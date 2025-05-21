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
 * BZ27973          140119    New Requirement - PLCC Account Payment
 * BZ29387          140219    [Internal] Xstore Sale screen with Good Sam Payment Item does not match requirements.
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountpayment.op;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSHelper;
import caw.tenderauth.impl.eigen.goodsam.common.CawCustomerGSInfo;

import dtv.data2.access.DataPropertyUtils;
import dtv.data2.access.impl.DaoState;
import dtv.data2.access.impl.IDataModelImpl;
import dtv.hardware.types.HardwareType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.ItemLocator;
import dtv.pos.register.type.NonPhysicalItemType;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.itm.INonPhysicalItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.SaleItemType;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * Ready payment sale line item.
 */
public class CawAddAccountPaymentItemOp extends Operation {
    /* BEGIN BZ29248 */
    private final static NonPhysicalItemType ACCOUNT_PAYMENT = NonPhysicalItemType.forName(CawConstants.ITEM_AR_PAYMENT, true);

    private static final Logger              logger          = Logger.getLogger(CawAddAccountPaymentItemOp.class);
    
    private CawCustomerGSHelper              _gsHelper       = CawCustomerGSHelper.getInstance();
    /* END BZ29248 */
    /* Create Payment sale line item.
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        INonPhysicalItem[] items = ItemLocator.getLocator().getNonPhysicalItemsForType(ACCOUNT_PAYMENT);
        ISaleReturnLineItem lineItem = ItemLocator.getLocator()
                .getSaleLineItem(items[0], SaleItemType.SALE, false, false, HardwareType.KEYBOARD);
        /* BEGIN BZ29387 */
        _transactionScope.setValue(CawValueKeys.IS_ACCOUNT_PAYMENT, Boolean.valueOf(true));

        lineItem.setScannedItemId(CawConstants.ACCOUNT_ID_LABEL + _gsHelper.getMarkedPAN());

        lineItem.getItem().setDescription(CawConstants.GS_ACCOUNT_PAYMENT);

        ((IDataModelImpl) lineItem.getItem()).getDAO().setObjectState(DaoState.CLEAN.intVal());
        setScopedValue(ValueKeys.CURRENT_SALE_LINE, lineItem);

        IPosTransaction trans = _transactionScope.getTransaction();

        if (trans != null) {
            DataPropertyUtils.setPropertyValue(trans, CawConstants.CAW_TRANSACTION_TYPE, CawConstants.ACCOUNT_PAYMENT);
        } else {
            logger.error("Could not save account payment to TRN_TRANS_P");
        }
        /* BEGIN BZ27973 */
        DataPropertyUtils.setPropertyValue(lineItem, CawConstants.CAW_ACCOUNTID, _gsHelper.getAccountCode());
        if (_gsHelper.getBalance() != null) {
            DataPropertyUtils
                    .setPropertyValue(lineItem, CawConstants.CAW_BALANCEAMOUNT, _gsHelper.getBalance().toString());
        }
        if (_gsHelper.getCardType() == 1) {
            DataPropertyUtils.setPropertyValue(lineItem, CawConstants.CAW_CARDTYPE, CawConstants.VISA_LONG);
        } else if (_gsHelper.getCardType() == 2) {
            DataPropertyUtils.setPropertyValue(lineItem, CawConstants.CAW_CARDTYPE, CawConstants.PLCC_LONG);
        } else {
            DataPropertyUtils.setPropertyValue(lineItem, CawConstants.CAW_CARDTYPE, "");
        }

        DataPropertyUtils.setPropertyValue(lineItem, CawConstants.CAW_CARDMASK, _gsHelper.getMarkedPAN());

        if (_gsHelper != null && _gsHelper.getResMgs() != null && StringUtils.isNotEmpty(_gsHelper.getResMgs())) {
            CawCustomerGSInfo cusInfo = _gsHelper.parseCustomerInfo(_gsHelper.getResMgs());
            if (cusInfo != null) {
                DataPropertyUtils.setPropertyValue(lineItem, CawConstants.CAW_ADDRESS1_UPCASE, cusInfo.getAddress1());

                DataPropertyUtils.setPropertyValue(lineItem, CawConstants.CAW_CITY_UPCASE, cusInfo.getCity());

                DataPropertyUtils.setPropertyValue(lineItem, CawConstants.CAW_STATE_UPCASE, cusInfo.getState());

                DataPropertyUtils.setPropertyValue(lineItem, CawConstants.CAW_ZIPCODE_UPCASE, cusInfo.getZipCode());
            }

        }
        /* END BZ27973 */
        /* END BZ29387 */
        return HELPER.completeResponse();
    }
}
