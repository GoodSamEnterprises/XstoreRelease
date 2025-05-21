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
 * BZ38378          121020    [Internal] Create Order - The customer's information did NOT update when executing change it in progress create Order transaction
 * BZ44528          130821    Electric World & Mobile POS Implementation (Phase 1)
 * BZ46743          240122    Vehicle Identification Number (VIN) Capture for Xstore
 * BZ53752          221122    [BTM-255] - Wrong ItemCorrelationKey is being set in OrginalCorrelationKey attribute on returned items in SubmitOrder Request
 *===================================================================
 */

package caw.pos.order;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.common.*;
import caw.pos.register.vin.CawVinHelper;
import caw.pos.wondersign.model.CawWonderSignCartItem;
import twitter4j.JSONArray;
import twitter4j.JSONObject;

import dtv.i18n.IFormattable;
import dtv.pos.common.*;
import dtv.pos.framework.op.req.ShowFormRequest;
import dtv.pos.iframework.action.DataActionGroupKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.form.*;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.req.IOpRequest;
import dtv.pos.iframework.type.ModelKey;
import dtv.pos.order.OrderMgr;
import dtv.pos.register.sale.PromptItemScanOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.xom.*;
import dtv.xst.xom.impl.order.OrderLineStatus;

public class CawPromptOrderItemScanOp extends PromptItemScanOp {

    private static final FormKey ORDER_SUMMARY_REGISTER_FORM = FormKey.valueOf("ORDER_SUMMARY_REGISTER");

    private static final Logger  _logger                     = LogManager.getLogger(CawPromptOrderItemScanOp.class);

    @Inject
    private OrderMgr             _orderMgr;

    private final String         PHONE_TYPE_DESCRIPTION      = "typeDescription";

    private final String         PHONE_NUMBER                = "number";

    @Override
    public PromptKey getDefaultPromptKey() {

        String promptKey = (disableInput(null)) ? "ORDER_SELECT_OPTION" : "ORDER_ENTER_SCAN_ITEM";
        return PromptKey.valueOf(promptKey);
    }

    @Override
    public IOpResponse getPromptResponse(IXstEvent argEvent,
            PromptKey argPromptKey, IFormattable[] argPromptArgs) {

        IOpResponse response = super.getPromptResponse(argEvent, argPromptKey, argPromptArgs);
        IEditModel listModel = this._modeProvider.get().getStationModel()
                .getModel(this.getModelKey());
        IOpRequest formReq = new ShowFormRequest(ORDER_SUMMARY_REGISTER_FORM,
                listModel, (DataActionGroupKey) null, true,
                FormLocationType.MESSAGE_AREA);

        String lookupResponse = CawCatalystHelper.getLookupResponseData();
        if (StringUtils.isNotEmpty(lookupResponse)) {
            try {
                CawOrderListEditModel cawListModel = (CawOrderListEditModel) listModel;
                ICustomerModifier customer = cawListModel.getModeledOrder()
                        .getCustomer();
                JSONObject responseJSONData = new JSONObject(lookupResponse);
                setCustomerModifier(customer, responseJSONData);
                formReq = new ShowFormRequest(ORDER_SUMMARY_REGISTER_FORM,
                        cawListModel, (DataActionGroupKey) null, true,
                        FormLocationType.MESSAGE_AREA);
            } catch (Exception ex) {
                _logger.info("Exception happen when update form ORDER_SUMMARY_REGISTER :" + ex.getMessage());
            }
        }
        
        response.insertOpRequest(formReq);
        /*BEGIN BZ44528*/
        if(this._transactionScope
                .getValue(CawValueKeys.WS_SELECTED_ITEM_LIST) != null && this._transactionScope
                        .getValue(CawValueKeys.WS_SELECTED_ITEM_LIST) .size() > 0) {
            return this.handlePromptResponse(argEvent);
        }
        /*END BZ44528*/
        return response;
    }
    /*BEGIN BZ44528*/
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {
        List<CawWonderSignCartItem> WSItems = this._transactionScope.getValue(CawValueKeys.WS_SELECTED_ITEM_LIST);
        if(WSItems != null && WSItems.size() > 0) {
            for (CawWonderSignCartItem item : WSItems) {
                BigDecimal quantity = new BigDecimal(item.getQuantity());
                this.setScopedValue(ValueKeys.ENTERED_ITEM_ID, item.getCode());
                this.setScopedValue(ValueKeys.ENTERED_ITEM_QUANTITY, quantity);
                this.setScopedValue(CawValueKeys.WONDERSIGN_CART_ID, item.getCorrelationKey());
                this.setScopedValue(CawValueKeys.WONDERSIGN_CART_ID_SUBMIT_ORDER, item.getCorrelationKey());//BZ53752
                WSItems.remove(item);
                IOpResponse opResponse = super.handlePromptResponse(argEvent);
                if(WSItems.size() > 0) {
                    return super.handleOpExec(argEvent);
                }
                return opResponse;
            }
        }
        return super.handlePromptResponse(argEvent);
    }
    /*END BZ44528*/
    @Override
    public boolean isOperationApplicable() {
        /*BEGIN BZ46743*/
        IItem currentItem = getScopedValue(ValueKeys.CURRENT_ITEM);
        if(currentItem != null && CawVinHelper.isVinItem(currentItem)) {
            clearScopedValue(ValueKeys.CURRENT_ITEM);
        }
        /*END BZ46743*/
        return getScopedValue(ValueKeys.CURRENT_ITEM) == null;
    }

    @Override
    protected boolean disableInput(IXstEvent argEvent) {

        IOrder currentOrder = _orderMgr.getCurrentOrder();
        boolean disable = false;
        if (!OrderLineStatus.NEW.matches(currentOrder.getStatusCode())
                || this._transactionScope.getValue(CawValueKeys.WS_SELECTED_ITEM_LIST) != null) {/*BZ44528*/
            disable = true;
        }
        return disable;
    }

    @Override
    protected FormKey getListFormKey() {

        return FormKey.valueOf("ORDER_TRANSACTION_LIST");
    }

    @Override
    protected ModelKey<? extends IListEditModel<Object>> getModelKey() {

        return ModelKeys.ORDER_LIST_MODEL;
    }

    @Override
    protected IOpResponse getTenderingResponse(IXstEvent argEvent) {

        return HELPER.getStartChainResponse(OpChainKey
                .valueOf("ORDER_PRE_TENDERING"));
    }

    private void setCustomerModifier(ICustomerModifier customer, JSONObject responseData) {

        JSONObject objIndex = null;
        try {
            //Handle name
            objIndex = CawJSONUtils.getJSONObject(responseData, CawJSONConstant.JSON_NAME);
            if (objIndex != null) {
                if (objIndex.get(CawJSONConstant.JSON_LAST_NAME) != null) {
                    customer.setFirstName(objIndex
                            .get(CawJSONConstant.JSON_FIRST_NAME).toString());
                }
                if (objIndex.get(CawJSONConstant.JSON_LAST_NAME) != null) {
                    customer.setLastName(objIndex
                            .get(CawJSONConstant.JSON_LAST_NAME).toString());
                }
                String companyName = objIndex
                        .getString(CawJSONConstant.JSON_COMPANY);
                if (companyName != null) {
                    customer.setOrganizationName(companyName);
                    if (companyName.split(" ").length > 1) {
                        String first = companyName
                                .substring(0, companyName.lastIndexOf(" "));
                        String last = companyName
                                .substring(companyName.lastIndexOf(" ") + 1);
                        customer.setFirstName(first);
                        customer.setLastName(last);
                    } else {
                        customer.setFirstName("");
                        customer.setLastName(companyName);
                    }
                }
            }

            // Handle address
            objIndex = CawJSONUtils
                    .getJSONObject(responseData, CawJSONConstant.JSON_ADDRESS);
            if (objIndex != null) {
                IAddressModifier addressInfo = customer.getAddress();

                if (objIndex.getString(CawJSONConstant.JSON_LINE1) != null) {
                    addressInfo.setAddress1(objIndex
                            .getString(CawJSONConstant.JSON_LINE1));
                }

                if (objIndex.getString(CawJSONConstant.JSON_LINE2) != null) {
                    addressInfo.setAddress2(objIndex
                            .getString(CawJSONConstant.JSON_LINE2));
                }

                if (objIndex.getString(CawJSONConstant.JSON_LINE3) != null) {
                    addressInfo.setAddress3(objIndex
                            .getString(CawJSONConstant.JSON_LINE3));
                }

                if (objIndex.getString(CawJSONConstant.JSON_LINE4) != null) {
                    addressInfo.setAddress4(objIndex
                            .getString(CawJSONConstant.JSON_LINE4));
                }

                if (objIndex.getString(CawJSONConstant.JSON_CITY) != null) {
                    addressInfo.setCity(objIndex
                            .getString(CawJSONConstant.JSON_CITY));
                }

                if (objIndex.getString(CawJSONConstant.JSON_STATE) != null) {
                    addressInfo.setState(objIndex
                            .getString(CawJSONConstant.JSON_STATE));
                }

                if (objIndex
                        .getString(CawJSONConstant.JSON_POSTAL_CODE) != null) {
                    addressInfo.setPostalCode(objIndex
                            .getString(CawJSONConstant.JSON_POSTAL_CODE));
                }

                if (objIndex.getString(CawJSONConstant.JSON_COUNTY) != null) {
                    addressInfo.setCounty(objIndex
                            .getString(CawJSONConstant.JSON_COUNTY));
                }
                String country = objIndex
                        .getString(CawJSONConstant.JSON_COUNTRY);
                if (country != null && country.length() > 2) {
                    country = country.substring(0, 2);
                }
                addressInfo.setCountry(country);
            }

            //Handle Email
            String emailaddress = CawJSONUtils
                    .getString(responseData, CawJSONConstant.JSON_EMAIL_ADDRESS);
            if (StringUtils.isNotEmpty(emailaddress)) {
                customer.setEmailAddress(emailaddress);
            }

            //Handle Phone
            JSONArray phones = CawJSONUtils
                    .getJSONArray(responseData, CawJSONConstant.JSON_PHONES);
            String typeDescription = null;
            String number = null;
            JSONObject phone = null;
            if (phones != null) {
                for (int i = 0; i < phones.length(); i++) {
                    phone = phones.getJSONObject(i);
                    typeDescription = phone.getString(PHONE_TYPE_DESCRIPTION);
                    number = phone.getString(PHONE_NUMBER);
                    if (StringUtils.isNotEmpty(typeDescription)) {
                        if (typeDescription.equals("Home")) {
                            customer.setTelephone1(number);
                        } else if (typeDescription.equals("Cell")) {
                            customer.setTelephone2(number);
                        }
                    }
                }
            }

        } catch (Exception ex) {
            _logger.info("Exception happen when convert data from Upsert response: " + ex.getMessage());
        }
    }
}
