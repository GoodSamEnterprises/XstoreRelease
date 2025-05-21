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
 * BZ23676          101017    [Tender] The New Good Sam VISA tender option button should only be available on the transaction that the application was approved for.
 * BZ25761          121018    New Requirement - Acquisition of Private Label Credit Card integration in Xstore
 * BZ28741          211218    [PLCC] The selection of customer on Pin Pad Credit Approval Form doesn't persist in TRN_TRANS_P
 * BZ29137          240119    [Internal] 'Thank You' text is overlapped on PINPAD screen when doing Instant credit trans.
 * BZ29293          140219    [Internal] Missing Credit limit amount on the Xstore GOOD SAM CREDIT APPLICATION RESPONSE screen
 * BZ29371          150219    [Internal Remove the space after the APR and % on the GOOD SAM CREDIT APPLICATION RESPONSE on Pin Pad and Xstore
 * BZ29302          140219    [Internal] Auto apply discount when first time tender using the new Good Sam Visa
 * BZ29536          260219    Xstore not pass in the expiry date to sale request when tendering with PLCC short token
 * BZ57844          080823    Bug 57844 - [Task] Loyalty Phase 2.
 * BZ58780          110923    [Internal][Loyalty] Offer for new GSVS is still active even though Xstore set turn off to get a free GS Membership with approval and purchase.
 *===================================================================
 */

package caw.tenderauth.impl.eigen.goodsam.op;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.tenderauth.impl.eigen.CawEigenHelper;
import caw.tenderauth.impl.eigen.CawEigenMgr;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;

import dtv.data2.access.DataPropertyUtils;
import dtv.i18n.FormattableFactory;
import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.i18n.format.MoneyFormatter;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * Ask customer if they want to use new GS card for current transaction or not
 * and save customer's selection into TRN_TRANS_P
 */
public class CawGoodSamVisaResponseApprovedOp extends AbstractPromptOp {

    private static final Logger _logger         = LogManager.getLogger(CawGoodSamVisaResponseApprovedOp.class);

    private CawCustomerGSHelper _gsHelper       = CawCustomerGSHelper.getInstance();

    @Inject
    private IBusyState          _busyState;

    @Inject
    private CawEigenHelper      _cawEigenHelper;                                                               /*BZ29137*/

    @Inject
    private CawEigenMgr         _cawEigenMgr;

    private MoneyFormatter      _moneyFormatter = new MoneyFormatter();
    
    private final String          CAW_GOOD_SAM_VISA_RESPONSE_APPROVE_ENABLE_LOYALTY = "CAW.GOOD_SAM_VISA_RESPONSE_APPROVE_ENABLE_LOYALTY"; //BZ57844

    @Override
    public PromptKey getDefaultPromptKey() {    
        /* BEGIN BZ57844 */
        if (_gsHelper.isEnableLoyalty()) {
            return PromptKey
                    .valueOf(CAW_GOOD_SAM_VISA_RESPONSE_APPROVE_ENABLE_LOYALTY);
        }
        /* END BZ57844 */
        return PromptKey.valueOf("CAW.GOOD_SAM_VISA_RESPONSE_APPROVE");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {
        final IXstActionKey key = ((IXstAction) argEvent).getActionKey();

        if (key == XstDataActionKey.YES) {

            /*Begin BZ28741: Build transaction property value*/
            StringBuilder value = new StringBuilder();
            value.append(CawConstants.CARD_TYPE);
            if (_gsHelper.getCardType() == 1) {
                value.append(CawConstants.VISA_LONG);
            } else if (_gsHelper.getCardType() == 2) {
                value.append(CawConstants.PLCC_LONG);
            }
            value.append(CawConstants.UNDERSCORE_SIGN).append(CawConstants.SELECTED);
            /*End BZ28741*/

            _busyState.start(CawConstants.WAIT_FOR_SIGCAP);
            /*Customer select YES/NO on PINPAD*/
            if (_cawEigenMgr.applyGoodSamRewards(_gsHelper.getGSInfo())) {
                _gsHelper.isApplyGS(true);
                value.append(CawConstants.YES_CONSTANT); /*BZ28741*/
                /* BEGIN BZ29302: apply Deal in Credit Application flow*/
                
                /* BGIN BZ58780: not apply Deal in Instant Credit when enable GS Membership Offer */
                if (_gsHelper.isEnableLoyalty()) {
                    _transactionScope.setValue(CawValueKeys.SAY_YES_GSV_TENDER, Boolean.FALSE);
                } else {
                    _transactionScope.setValue(CawValueKeys.SAY_YES_GSV_TENDER, Boolean.TRUE);
                }
                /* END BZ29302, BZ58780*/
            } else {
                value.append(CawConstants.NO_CONSTANT); /*BZ28741*/
                _gsHelper.isApplyGS(false);
            }

            /*Begin BZ28741: Add property to transaction and persist to TRN_TRANS_P once transaction completed.*/
            IPosTransaction trans = _transactionScope.getTransaction();
            if (trans != null) {
                DataPropertyUtils.setPropertyValue(trans, CawConstants.GOODSAM_CARD_APPLY, value);
            } else {
                _logger.error("CawGoodSamVisaResponseApprovedOp-handlePromptResponse: transaction is null.");
            }
            /*End BZ28741*/

            _busyState.end();
            /*Begin BZ29137*/
            _cawEigenHelper.refreshPinpadScreen(_transactionScope);
            /*End BZ29137*/
            return HELPER.completeResponse();
        }

        return HELPER.completeResponse();
    }

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable cardType = null;

        if (_gsHelper.getCardType() == 1) {
            cardType = _ff.getTranslatable("_visaXst");
        } else if (_gsHelper.getCardType() == 2) {
            cardType = _ff.getTranslatable("_plcc");
        }

        IFormattable gsCreditLimit = FormattableFactory.getInstance()
                .getSimpleFormattable(_moneyFormatter.format(_gsHelper.getGSInfo().getCreditLimit(), null).trim());//BZ29293, BZ29371: remove space of CreditLimit using trim()
        IFormattable gsAPR = FormattableFactory.getInstance()
                .getSimpleFormattable(_moneyFormatter.format(_gsHelper.getGSInfo().getApr(), null).trim());//BZ29293, BZ29371: remove space of gsAPR using trim()

        IFormattable args[] = new IFormattable[3];
        args[0] = cardType;
        args[1] = gsCreditLimit;
        args[2] = gsAPR;

        return args;
    }
}
