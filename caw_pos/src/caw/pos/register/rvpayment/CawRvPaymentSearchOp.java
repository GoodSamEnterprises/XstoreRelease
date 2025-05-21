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
 * BZ46381          110821    IDS Payment - Should be able to scan a barcode of IDS Customer Number and IDS WO Number when doing a RV Service Payment Search in Xstore
 * BZ47618          131221    RV Service Payment requires Customer# in order to search with RV WO#
 * BZ47775          171221    Patch 15 Do not run automatic search for customer after clicking on RV Service Payment button
 *===================================================================
 */

package caw.pos.register.rvpayment;

import static dtv.pos.common.TransactionType.RETAIL_SALE;

import caw.hardware.types.CawInputType;
import caw.pos.common.CawPropertyUtils;
import caw.pos.common.CawValueKeys;

import dtv.hardware.events.ItemScanEvent;
import dtv.hardware.types.InputType;
import dtv.i18n.IFormattable;
import dtv.pos.common.FormKey;
import dtv.pos.framework.op.AbstractFormOp;
import dtv.pos.framework.validation.ValidationResultList;
import dtv.pos.iframework.event.*;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.validation.IValidationResultList;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 *
 */
public class CawRvPaymentSearchOp extends AbstractFormOp<CawRvPaymentModel> implements IXstEventObserver{
    private static final IXstEventType[] EVENTS;/*BZ46381*/
    
    private final FormKey                CAW_RV_PAYMENT_LOOKUP = FormKey.valueOf("CAW_RV_PAYMENT_LOOKUP");

    private boolean                      isInValidBarcode;/*BZ46381*/
    
    /*BEGIN BZ46381*/
    @Override
    public IXstEventType[] getObservedEvents() {
        return EVENTS;
    }

    static {
        EVENTS = new IXstEventType[] { CawInputType.INPUT_RV_PAYMENT, InputType.INPUT_ITEM};
    }
    /*END BZ46381*/
    
    @Override
    protected CawRvPaymentModel createModel() {

        CawRvPaymentModel model = new CawRvPaymentModel("_cawRvPaymentSearchTitle", "_enterSearchCriteria");
        IRetailTransaction trans = _transactionScope.getTransaction(RETAIL_SALE);
        if (trans != null && trans.getCustomerParty() != null) {
                IParty cust = trans.getCustomerParty();
                model.setRvFistName(cust.getFirstName());
                model.setRvLastName(cust.getLastName());
                model.setRvPostalCode(cust.getLocaleInformation().get(0).getPostalCode());
            }
        return model;
    }

    @Override
    protected IOpResponse handleInitialState() {

        /* BEGIN BZ47775 */
        /*IValidationResultList list = this.validateForm(this.getModel());
        if (list.isValid() && this.getScopedValue(CawValueKeys.CAW_RV_PAYMENT_SEARCH_MODEL) == null) {
            return handleFormResponse(null);
        }*/
        /* END BZ47775 */
        
        clearScopedValue(CawValueKeys.CAW_RV_PAYMENT_SEARCH_MODEL);
        isInValidBarcode = false;/*BZ46381*/
        return super.handleInitialState();
    }

    @Override
    protected FormKey getFormKey() {

        return CAW_RV_PAYMENT_LOOKUP;
    }

    /*BEGIN BZ46381*/
    @Override
    protected IOpResponse handleAfterDataAction(IXstEvent argEvent) {
        String idsBarcode = _transactionScope.getValue(CawValueKeys.CAW_RV_PAYMENT_BARCODE);
        if (idsBarcode != null) {
            String custPrefix = CawPropertyUtils.RV_PAYMENT_CUST_PREFIX;
            String woPrefix = CawPropertyUtils.RV_PAYMENT_WO_PREFIX;
            if(idsBarcode.startsWith(custPrefix)) {
                String idsCust = idsBarcode.substring(custPrefix.length());
                this.getModel().setRvServiceCustomer(idsCust);
            }else if(idsBarcode.startsWith(woPrefix)) {
                String idsWo = idsBarcode.substring(woPrefix.length());
                this.getModel().setRvServiceWo(idsWo);
            }
        }else if(argEvent instanceof ItemScanEvent) {
            isInValidBarcode = true;
        }
        _transactionScope.clearValue(CawValueKeys.CAW_RV_PAYMENT_BARCODE);
        return super.handleAfterDataAction(argEvent);
    }
    /*END BZ46381*/
    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {

        this.setScopedValue(CawValueKeys.CAW_RV_PAYMENT_SEARCH_MODEL, this.getModel());
        return super.handleFormResponse(argEvent);
    }

    @Override
    protected IValidationResultList validateForm(CawRvPaymentModel argModel) {

        IValidationResultList list = new ValidationResultList();
        /*BEGIN BZ46381*/
        if(isInValidBarcode) {
            IFormattable msg = _formattables.getTranslatable("_rvPaymentInvalidBarcode");
            list.add(SimpleValidationResult.getFailed(msg));
        }
        /*END BZ46381*/
        /*BEGIN BZ47618*/
        else if(argModel.getRvServiceWo() != null
                && argModel.getRvServiceCustomer() == null
                && argModel.getRvFistName() == null
                && argModel.getRvLastName() == null
                && argModel.getRvPostalCode() == null
                || (argModel.getRvServiceCustomer() == null
                        && argModel.getRvServiceWo() != null
                        && (argModel.getRvFistName() == null
                        || argModel.getRvLastName() == null
                        || argModel.getRvPostalCode() == null))) {
            IFormattable msg = _formattables.getTranslatable("_rvPaymentSearchWoErrorMsg");
            list.add(SimpleValidationResult.getFailed(msg));
        }
        /*END BZ47618*/
        else if (argModel.getRvServiceCustomer() == null
                && argModel.getRvServiceWo() == null
                && argModel.getRvFistName() == null
                && argModel.getRvLastName() == null
                && argModel.getRvPostalCode() == null
                || (argModel.getRvServiceCustomer() == null
                        && argModel.getRvServiceWo() == null
                        && (argModel.getRvFistName() == null
                                || argModel.getRvLastName() == null
                                || argModel.getRvPostalCode() == null))) {
            IFormattable msg = _formattables.getTranslatable("_rvPaymentSearchValidationError");
            list.add(SimpleValidationResult.getFailed(msg));
        }
        return argModel.validate(list);
    }
    
}
