/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions developed for Camping World by BTM Global Consulting
 * LLC and are the property of Camping World.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#      ddMMyy    Description
 * BZ23265          200917    Implement issue "Create Good Sam Visa" card function
 * BZ23586          200917    [Pre-screen Credit] - Need POS to prompt the customer if they want 
 *                            to apply for credit when a pre-screen ID has been passed from the prompting engine
 * BZ23596          270917    'Make offer' request doesn't send to EBS when selecting 'NO' on Pre-screen
 * BZ23265          290917    Implement issue "Create Good Sam Visa" card function
 * BZ23943          111017    [Certification] Made Offer should take precedence over all other prompts
 * BZ23982          131017    Registers are constantly frozen and required rebooting
 * BZ24017          151017    [Technical issue] - Avoid calling printStackTrace() in production code
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ25435          160718    New Requirement - Xstore changes to call the CardServices API instead of the Prompting Engine
 * BZ28265          261118    New Requirement - Migrate Prompting Engine Catalyst calls to the new PE Services for Xstore 2.1
 * BZ25761          121018    New Requirement - Acquisition of Private Label Credit Card integration in Xstore
 * BZ28247          181218    [New Requirement] Move Xstore integration to Card Service version 2
 * BZ29240          290119    [Internal][PLCC] The Pre-Approved Credit Offer screen always display thought the EBS response pre-screenID =0
 * BZ29326          130219    Card Service 2 - Read the makeCreditOffer atrribute from OLPS status call and make the credit offer if the flag is true
 * BZ29402          150219    [Internal] Items overwrites on PINPAD when letting Pin Pad Pre-Approved Form for PLCC timed out.
 * BZ29407          260219    [Internal] Xstore continues to prompt prescreen after application has been successfully completed.
 * BZ29983          060519    [Prod] Register freezing at prescreen
 * BZ29840          210318    [Internal][ESB log] There are a lot of redundant statements written into ESB log during having interaction between Xstore and Neuron API.
 *===================================================================
 */

package caw.tenderauth.impl.eigen.goodsam.op;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.util.CawEBSHelper;
import caw.tenderauth.impl.eigen.CawEigenHelper;
import caw.tenderauth.impl.eigen.CawEigenMgr;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;
import caw.tenderauth.impl.eigen.op.CawGoodSamVisaHelper;
import twitter4j.JSONObject;

import dtv.i18n.FormattableFactory;
import dtv.i18n.IFormattable;
import dtv.pos.common.*;
import dtv.pos.customer.CustomerHelper;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.returns.ReturnManager;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 * The CawGoodSamVisaPreScreenOp class
 */
public class CawGoodSamVisaPreScreenOp extends AbstractPromptOp {

    // Begin BZ23596
    private CawGoodSamVisaHelper           _cawGoodSamVisaHelper = CawGoodSamVisaHelper.getInstance();

    /*Begin BZ-23265*/
    @Inject
    private ReturnManager                  _returnManager;

    @Inject
    private IBusyState                     _busyState;                                                /*BZ29983*/

    // Begin BZ23596
    protected JSONObject                   directivesNews        = null;

    @Inject
    private TransactionScope               _transaction;

    @Inject
    private CustomerHelper                 _customerHelper;

    private CawCustomerGSHelper            _gsHelper             = CawCustomerGSHelper.getInstance();

    @Inject
    private CawEigenMgr                    _cawEigenMgr;

    private static final IXstDataActionKey NEXT                  = XstDataActionKey.valueOf("NEXT");

    // End BZ23596

    /* BEGIN BZ29402 */
    @Inject
    private CawEigenHelper                 _cawEigenHelper;
    /* END BZ29402 */

    @Override
    public boolean isOperationApplicable() {

        IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
        /*Begin BZ23915*/
        if (!StringUtils.isEmpty(_transactionScope.getValue(CawValueKeys.ACCOUNT_NUMBER))
                && !StringUtils.isEmpty(_transactionScope.getValue(CawValueKeys.EXP_DATE))) {
            return false;
        }
        /*End BZ23915*/

        /* Begin BZ25761 --Remove BZ-28265 */
        /* BEGIN BZ29326 */
        /* BEGIN BZ29407 */
        Boolean isCompletedMadeOffer = _transactionScope.getValue(CawValueKeys.IS_COMPLETED_MADE_OFFER);
        if (trans != null && trans.getCustomerParty() != null && _returnManager.getCurrentOrigTransactionId() == null) {
            if (!_gsHelper.getPreScreenId().isEmpty() && !CawConstants.VALUE_0.equals(_gsHelper.getPreScreenId())
                    && isCompletedMadeOffer == null) {
                return true;
            }
        }
        /* END BZ29407 */
        /* END BZ29326 */
        /* End BZ25761 */
        return false;
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW.GOOD_SAM_VISA_PRE_SCREEN");
    }

    @Override
    public IOpResponse getPromptResponse(IXstEvent argArgEvent, PromptKey argArgPromptKey,
            IFormattable[] argArgPromptArgs) {

        IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
        IParty party = trans.getCustomerParty();
        IFormattable[] args = new IFormattable[2];
        //Name
        args[0] = FormattableFactory.getInstance().getSimpleFormattable(_customerHelper.getCustomerDisplayName(party));
        //Card type
        if (_gsHelper.getCardType() == 1) {
            args[1] = _ff.getTranslatable("_visaXst");
        } else if (_gsHelper.getCardType() == 2) {
            args[1] = _ff.getTranslatable("_plcc");
        }
        return HELPER.getPromptResponse(getDefaultPromptKey(), args);
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        final IXstActionKey key = ((IXstAction) argEvent).getActionKey();
        // Begin BZ23596
        IRetailTransaction trans = _transaction.getTransaction(TransactionType.RETAIL_SALE);
        IParty custParty = trans.getCustomerParty();
        String keyPressed = "";
        String preScreenID = _gsHelper.getPreScreenId(); // BZ25435, BZ25761

        String customerJson = CawCatalystHelper.getLookupResponseData();// BZ28247

        if (!StringUtils.isEmpty(preScreenID) && !CawConstants.VALUE_0.equals(preScreenID)) { //BZ29240
            //Wait for pinpad response
            if (key.equals(NEXT)) {
                _busyState.start(CawConstants.WAIT_FOR_SIGCAP); /*BZ29983*/
                int keyResponse = _cawEigenMgr.offerGoodSamReward(custParty, _gsHelper.getCardType());

                if (keyResponse == 1) {
                    _gsHelper.setApplicationType(1);
                    keyPressed = XstDataActionKey.YES.toString();

                    /* BEGIN BZ28247 */

                    String requestJson = _cawGoodSamVisaHelper
                            .getMadeOfferTemplate(trans, keyPressed, preScreenID, customerJson);

                    /* END BZ28247 */

                    if (requestJson != null) {
                        //BZ26575 changed by using CawEBSHelper
                        /* Begin BZ23943 */
                        CawCatalystHelper.setCatalystDirectiveResponse(null);
                        CawCatalystHelper.setCatalystInputsResponse(null);
                        CawCatalystHelper.setCatalystMessageResponse(null);
                        /* End BZ23943 */

                        return HELPER.getCompleteStackChainResponse(OpChainKey
                                .valueOf("CAW_GOOD_SAM_CREDIT_MADE_OFFER")); /*BZ-23265*/
                    }
                } else if (keyResponse == 2) {
                    keyPressed = XstDataActionKey.NO.toString();
                    String requestJson = _cawGoodSamVisaHelper
                            .getMadeOfferTemplate(trans, keyPressed, preScreenID, customerJson);// BZ28247
                    if (requestJson != null) {
                        //BZ26575 changed by using CawEBSHelper
                        CawEBSHelper.getInstance().sendMadeOfferToEBS(requestJson);//BZ29840
                    }
                } else if (keyResponse == 3) {
                    keyPressed = key.toString();
                    String requestJson = _cawGoodSamVisaHelper
                            .getMadeOfferTemplate(trans, keyPressed, preScreenID, customerJson);// BZ28247
                    if (requestJson != null) {
                        //BZ26575 changed by using CawEBSHelper
                        CawEBSHelper.getInstance().sendMadeOfferToEBS(requestJson);//BZ29840
                    }
                } else {
                    /* BEGIN BZ29402: clear screen PINPAD when for PLCC timed out. */
                    _cawEigenHelper.refreshPinpadScreen(_transaction);
                    /* END BZ29402 */
                }
                _busyState.end(); /*BZ29983*/
            }
        }
        // End BZ23596

        return HELPER.completeResponse();
    }
    /*End BZ-232365*/

    @Override
    public String getLongRunningMessage() {

        return CawConstants.BUSY_STATE_MSG;
    }
}
