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
 * BZ44917          110921    [New Requirement] IDS Payment Integration with Xstore
 * BZ46257          150921    [Internal] IDS Payment - Xstore displays 'RV service payment not found' instead of 'RV service payment search screen' when hit Add another payment after selected all payment result into transaction.
 *===================================================================
 */

package caw.pos.register.rvpayment;

import java.util.ArrayList;
import java.util.List;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.FormKey;
import dtv.pos.framework.op.AbstractFormOp;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawRvPaymentViewDetail extends AbstractFormOp<CawRvPaymentModel> {

    private final FormKey       CAW_RV_PAYMENT_VIEW_DETAIL  = FormKey.valueOf("CAW_RV_PAYMENT_VIEW_DETAIL");

    private static final String BUTTON_ADD_ANOTHER_PAYMENT  = "ADD_ANOTHER_PAYMENT";

    private static final String BUTTON_EXIT_WITHOUT_PAYMENT = "EXIT_WITHOUT_PAYMENT";

    @Override
    protected CawRvPaymentModel createModel() {

        CawRvPaymentModel model = new CawRvPaymentModel("_cawRvPaymentDetailTitle", "_cawRvPaymentDetailMessage");
        CawRvPaymentModel rvPaymentSelected = this.getScopedValue(CawValueKeys.CAW_RV_PAYMENT_ITEM_SELECTED);
        if (rvPaymentSelected != null) {
            model.setRvFistName(rvPaymentSelected.getRvFistName());
            model.setRvLastName(rvPaymentSelected.getRvLastName());
            model.setRvPostalCode(rvPaymentSelected.getRvPostalCode());
            model.setSalesChannelId(rvPaymentSelected.getSalesChannelId());
            model.setRvServiceCustomer(rvPaymentSelected.getRvServiceCustomer());
            model.setRvServiceWo(rvPaymentSelected.getRvServiceWo());
            model.setRvAmount(rvPaymentSelected.getRvAmount());
            model.setLocationCode(rvPaymentSelected.getLocationCode());
            model.setItemCode(rvPaymentSelected.getItemCode());
            model.setRvQty(rvPaymentSelected.getRvQty());
            model.setProperties(rvPaymentSelected.getProperties());
        }
        this.clearScopedValue(CawValueKeys.CAW_RV_PAYMENT_ITEM_SELECTED);
        return model;
    }

    @Override
    protected FormKey getFormKey() {

        return CAW_RV_PAYMENT_VIEW_DETAIL;
    }

    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {

        if (argEvent != null && argEvent instanceof IXstAction) {
            IXstActionKey key = ((IXstAction) argEvent).getActionKey();
            List<CawRvPaymentModel> rvSelectedItems = _transactionScope.getValue(CawValueKeys.CAW_RV_PAYMENT_ITEM_LIST);
            rvSelectedItems = rvSelectedItems == null ? new ArrayList<CawRvPaymentModel>() : rvSelectedItems;
            if (BUTTON_ADD_ANOTHER_PAYMENT.equals(key.toString())) {
                rvSelectedItems.add(getModel());
                _transactionScope.setValue(CawValueKeys.CAW_RV_PAYMENT_ITEM_LIST, rvSelectedItems);
                this.setScopedValue(CawValueKeys.IS_ADD_ANOTHER_RV_PAYMENT, Boolean.TRUE);/*BZ46257*/
                return HELPER.getBackupResponse();
            } else if (BUTTON_EXIT_WITHOUT_PAYMENT.equals(key.toString())) {
                return super.handleFormResponse(argEvent);
            }
            rvSelectedItems.add(getModel());
            _transactionScope.setValue(CawValueKeys.CAW_RV_PAYMENT_ITEM_LIST, rvSelectedItems);
        }
        return super.handleFormResponse(argEvent);
    }
}
