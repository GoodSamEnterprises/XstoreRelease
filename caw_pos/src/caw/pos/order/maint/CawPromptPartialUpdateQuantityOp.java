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
 * BZ42307          200921    [Requirement] Add ability to reject at the item level for BOPIS 
 * BZ46682          131021    [Internal] Partial Rejected items does not display on the Order Maintenance screen - BOPIS 
 *===================================================================
 */

package caw.pos.order.maint;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.FormKey;
import dtv.pos.framework.op.AbstractFormOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.validation.IValidationResultList;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.xst.dao.xom.IOrderLine;

/**
 *
 */
public class CawPromptPartialUpdateQuantityOp extends AbstractFormOp<CawOrderItemUpdateQtyModel> {
    private static final String ACTION_KEY = "ActionKey";
    private String _msgKey = "_quantityTo%sMessage";
    private String _errorExceedTotalKey = "_quantityTo%sGreaterThanTotalErrorMsg";
    private String _errorMustbePositiveKey = "_quantityTo%sMustbePositiveErrorMsg";

    @Override
    public void setParameter(String argName, String argValue) {
        if (ACTION_KEY.equalsIgnoreCase(argName)) {
            this._msgKey = String.format(this._msgKey, argValue);
            this._errorExceedTotalKey = String.format(this._errorExceedTotalKey, argValue);
            this._errorMustbePositiveKey = String.format(this._errorMustbePositiveKey, argValue);
        } else {
            super.setParameter(argName, argValue);
        }

    }

    @Override
    protected CawOrderItemUpdateQtyModel createModel() {
        IOrderLine orderLine = this.getScopedValue(CawValueKeys.CURRENT_ORDER_LINE_DETAIL);
        return new CawOrderItemUpdateQtyModel(this._msgKey, orderLine);
    }

    @Override
    protected FormKey getFormKey() {
        return FormKey.valueOf("ORDER_ITEM_UPDATE_QTY");
    }

    protected List<BigDecimal> getPartialUpdateQuantityList() {
        List<BigDecimal> partialUpdateQtys = this.getScopedValue(CawValueKeys.ORDER_LINE_DETAILS_PARTIAL_UPDATE_QTY);
        if (partialUpdateQtys == null) {
            partialUpdateQtys = new ArrayList<BigDecimal>();
            this.setScopedValue(CawValueKeys.ORDER_LINE_DETAILS_PARTIAL_UPDATE_QTY, partialUpdateQtys);
        }
        return partialUpdateQtys;
    }

    /*BEGIN BZ46682*/
    private void getOderLineQuantityList() {
        IOrderLine orderLine = this.getScopedValue(CawValueKeys.CURRENT_ORDER_LINE_DETAIL);
        List<BigDecimal> orderLineQtys = this.getScopedValue(CawValueKeys.CAW_ORDER_QUANTITIES);
        if (orderLineQtys == null) {
            orderLineQtys = new ArrayList<BigDecimal>();
            orderLineQtys.add(orderLine.getQuantity());
            this.setScopedValue(CawValueKeys.CAW_ORDER_QUANTITIES, orderLineQtys);
        }else {
            orderLineQtys.add(orderLine.getQuantity());
        }
    }
    /*END BZ46682*/
    @Override
    protected IOpResponse handleBeforeDataAction(IXstEvent argAction) {
        IOrderLine orderLine = this.getScopedValue(CawValueKeys.CURRENT_ORDER_LINE_DETAIL);
        if (orderLine.getQuantity().compareTo(BigDecimal.ONE) > 0) {
            return super.handleBeforeDataAction(argAction);
        } else {
            List<BigDecimal> partialUpdateQtys = this.getPartialUpdateQuantityList();
            partialUpdateQtys.add(BigDecimal.ONE);
            this.getOderLineQuantityList();/*BZ46682*/
            return this.HELPER.completeResponse();
        }
    }

    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {
        List<BigDecimal> partialUpdateQtys = this.getPartialUpdateQuantityList();
        CawOrderItemUpdateQtyModel model = this.getModel();
        partialUpdateQtys.add(model.getQuantity());
        this.getOderLineQuantityList();/*BZ46682*/
        return this.HELPER.completeResponse();
    }

    @Override
    protected IValidationResultList validateForm(CawOrderItemUpdateQtyModel argModel) {
        IValidationResultList results = super.validateForm(argModel);
        if (results.isValid()) {
            IOrderLine orderLine = this.getScopedValue(CawValueKeys.CURRENT_ORDER_LINE_DETAIL);
            if (argModel.getQuantity().signum() < 1) {
                results.add(SimpleValidationResult.getFailed(this._errorMustbePositiveKey));
            } else if (argModel.getQuantity().compareTo(orderLine.getQuantity()) > 0) {
                results.add(SimpleValidationResult.getFailed(this._errorExceedTotalKey, new Object[]{orderLine.getQuantity()}));
            }
        }
        return results;
    }
}
