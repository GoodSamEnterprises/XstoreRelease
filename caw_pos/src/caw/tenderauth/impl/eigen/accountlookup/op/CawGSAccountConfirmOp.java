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
 * BZ25762          121418    New Requirement - Credit Account Look up integration in Xstore
 * BZ29400          140118    [Internal[Account Lookup] First&Last name displaying on Account Found prompt does not match exactly First&name retrieved from ADS.
 * BZ29360          150219    [Internal][Account Lookup] Cannot retrieve account token to tender after Account Lookup found successfully
 * BZ29302          210219    [Internal] Auto apply discount when first time tender using the new Good Sam Visa.
 * BZ29340          220219    [Internal][Account Lookup]Pin Pad does not display Government-Issued Photo ID form simultaneously with Xstore Account Found screen which retrieved successfully from ADS
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountlookup.op;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import javax.inject.Inject;

import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.tenderauth.impl.eigen.CawEigenMgr;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;

import dtv.i18n.IFormattable;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.PromptOp;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;

public class CawGSAccountConfirmOp extends PromptOp {

    private CawCustomerGSHelper _gsHelper = CawCustomerGSHelper.getInstance();

    @Inject
    private CawEigenMgr         _cawEigenMgr;                                 // BZ29340
    /* Prompt Key
     * @see dtv.pos.framework.op.PromptOp#getDefaultPromptKey()
     */

    @Override
    public PromptKey getDefaultPromptKey() {
        _cawEigenMgr.verifyGovIssuedId(); // BZ29340
        return PromptKey.valueOf("CAW_GS_ACCOUNT_CONFIRM");
    }

    /* Process YES/NO selection. Customer ID match or not.
     * @see dtv.pos.framework.op.AbstractPromptOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        if (argEvent != null) {
            IXstActionKey key = ((IXstAction) argEvent).getActionKey();
            //YES: go to input info form
            if (key.equals(XstDataActionKey.YES)) {
                _gsHelper.isApplyGS(true); /*BZ29360*/
                /* BEGIN BZ29302: no apply deal in Account Lookup flow*/
                _transactionScope.setValue(CawValueKeys.SAY_YES_GSV_TENDER, Boolean.FALSE);
                /* END BZ29302*/
                return HELPER.completeResponse();
            }
            //NO: go to not found chain
            else if (key.equals(XstDataActionKey.NO)) {
                //Must be clear tokenized.
                _gsHelper.clearGSInfo();
                return HELPER.getStartChainResponse(OpChainKey.valueOf("CAW_GOOD_SAM_ACCOUNT_NOT_FOUND"));
            }
        }
        return super.handleOpExec(argEvent);
    }

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argArgEvent) {

        IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
        IParty custParty = trans.getCustomerParty();
        IFormattable args[] = new IFormattable[4];

        /* BEGIN BZ29400 */
        StringBuilder nameADS = new StringBuilder();
        nameADS.append(_gsHelper.getFirstNameADS()).append(CawConstants.SPACE_SIGN).append(_gsHelper.getLastNameADS())
                .toString();
        args[0] = _ff.getSimpleFormattable(nameADS.toString());
        /* END BZ29400 */

        args[1] = _ff.getSimpleFormattable(CawCustomerUtil.getAddressInfoIParty(custParty, 1));

        StringBuilder value = new StringBuilder();
        value.append(CawCustomerUtil.getAddressInfoIParty(custParty, 2)).append(CawConstants.COMMA_SIGN)
                .append(CawCustomerUtil.getAddressInfoIParty(custParty, 3)).append(CawConstants.SPACE_SIGN)
                .append(CawCustomerUtil.getAddressInfoIParty(custParty, 4));
        args[2] = _ff.getSimpleFormattable(value.toString());

        return args;
    }
}
