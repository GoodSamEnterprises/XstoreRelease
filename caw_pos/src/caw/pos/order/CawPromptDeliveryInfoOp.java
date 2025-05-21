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
 * BZ37109          240820    [Task] Call QAS integration in Delivery Order to verify customer shipping address
 * BZ37611          310820    [Internal] A few delivery information on the order screen is clear unexpectedly after back from Chang Country screen without actions.
 * BZ37749          080920    [Internal] Validation zip code format is not brought into as a part integration QAS triggered at Process button on Delivery Information Order
 * BZ38349          071020    [Internal] Updated value for other fields (emails, phone,..) into Delivery Information are reverted to old value after applied correct address from QAS address verification.
 *===================================================================
 */

package caw.pos.order;

import java.util.*;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.framework.form.validators.CawPostalCodeFieldValidator;

import dtv.data2.access.DataFactory;
import dtv.i18n.*;
import dtv.pos.address.search.AddressSearchResultStatus;
import dtv.pos.common.*;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.location.IRegion;
import dtv.pos.framework.location.StoreLocationHelper;
import dtv.pos.framework.op.AbstractChangeCountryOp;
import dtv.pos.framework.op.OpState;
import dtv.pos.framework.ui.config.*;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.form.*;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.iframework.validation.*;
import dtv.pos.order.*;
import dtv.pos.spring.ValueKeys;
import dtv.ui.swing.text.ValidationResultsStyler;
import dtv.util.address.CountryCache;
import dtv.util.address.ICountry;
import dtv.xst.dao.crm.IPartyLocaleInformation;
import dtv.xst.dao.xom.*;
import dtv.xst.xom.impl.order.FulfillmentMethod;
import dtv.xst.xom.impl.order.OrderType;


/**
 *
 */
public class CawPromptDeliveryInfoOp extends AbstractChangeCountryOp<DeliveryInfoModel>{
    
    // Start BZ-37611
    private static final PromptKey COUNTRY_PROMPT = PromptKey.valueOf("PROMPT_COUNTRY_LIST");
    private static final PromptKey NO_COUNTRIES_PROMPT = PromptKey.valueOf("COUNTRY_LIST_NO_RESULTS");
    // End BZ-37611
    
    /*BEGIN BZ37749 */
    @Inject
    private PromptConfigHelper _promptConfigHelper;
    
    @Inject
    private CawPostalCodeFieldValidator _postalCodeValidator;
    /* END BZ37749 */

    @Inject
    private OrderMgr                   _orderMgr;

    private static final Logger        _logger                  = LogManager
            .getLogger(CawPromptDeliveryInfoOp.class);

    private final IOpState             CHANGE_COUNTRY           = new OpState(
            "CHANGE_COUNTRY");

    private static final IXstActionKey CHANGE_COUNTRY_ACTION    = XstDataActionKey
            .valueOf("CHANGE_COUNTRY");

    private static final IXstActionKey CHANGE_COUNTRY_CANCEL    = XstDataActionKey
            .valueOf("CHANGE_COUNTRY_CANCEL");

    private CawOrderHelper             _orderHelper             = CawOrderHelper
            .getInstance();

    @Inject
    private IBusyState                 _busyState;

    private static final String        ADDRESS_LOOKUP           = "ADDRESS_LOOKUP";

    private static final PromptKey     CAW_QAS_CHECK_CONNECTION = PromptKey
            .valueOf("CAW_QAS_CHECK_CONNECTION");

    private static final PromptKey     CAW_QAS_NOT_FOUND        = PromptKey
            .valueOf("CAW_QAS_NOT_FOUND");

    private static final PromptKey     CAW_QAS_VALIDATE_COUNTRY = PromptKey
            .valueOf("CAW_QAS_VALIDATE_COUNTRY");
    
    
    @Override
    public boolean isOperationApplicable() {
        boolean applicable = false;
        IOrder currentOrder = _orderMgr.getCurrentOrder();

        if ((currentOrder != null) && OrderType.forName(currentOrder.getOrderType()).isForDelivery()) {
          applicable = true;
        }

        return applicable;
      }
   
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        boolean saveChangePressed = false;
        boolean saveQASValidated = false;
        IXstActionKey actionKey = argAction.getActionKey();
        if (CHANGE_COUNTRY_ACTION.equals(argAction.getActionKey())) {
            return this.handleChangeCountry(argAction);

        } else if (this.CHANGE_COUNTRY.equals(this.getOpState())
                && CHANGE_COUNTRY_CANCEL.equals(argAction.getActionKey())) {

            this.setOpState(this.AFTER_REQUEST);
            return this.HELPER.getChangeFormResponse(this.getFormKey(), this
                    .getModel(), this.getActionGroupKey(), this.isEditable());
        }

        IOpResponse resonse = null;
        if (CawConstants.QAS_APPLIED.equalsIgnoreCase(actionKey.toString())) {
            refreshModel();
            /* Back to Delivery form after find address success.
             * setOpState(AFTER_REQUEST);
            saveChangePressed = true;
            saveQASValidated = true;
            actionKey = XstDataActionKey.ACCEPT;
            argAction.setActionKey(actionKey);*/
        }
        if (CawConstants.QAS_OFFLINE.equalsIgnoreCase(actionKey.toString())) {
            refreshModelOffline();
            setOpState(AFTER_REQUEST);
            saveChangePressed = true;
            saveQASValidated = true;
            actionKey = XstDataActionKey.ACCEPT;
            argAction.setActionKey(actionKey);
        }
        
        if (CawConstants.QAS_NOTFOUND.equalsIgnoreCase(actionKey.toString())) {
            refreshModelOffline();
            setOpState(VALIDATION_ERROR);
        }
        
        if ("ACCEPT".equalsIgnoreCase(actionKey.toString())) {
            if (getOpState() != null) {
                if (!getOpState().getName().equalsIgnoreCase("VALIDATION_ERROR")
                        && !getOpState().getName()
                                .equalsIgnoreCase("CHANGE_COUNTRY")) {
                    setOpState(AFTER_REQUEST);
                    saveChangePressed = true;   
                    setScopedValue(CawValueKeys.CAW_DELIVERY_INFO_MODEL_BEFORE, this.getModel()); //BZ38349
                }
            }
        }

        resonse = handleQASAddressLookup(argAction, saveChangePressed, saveQASValidated);
        return resonse;
    }
    
    private void refreshModel() {

        Object model = this.getModel();
        if (model != null && model instanceof DeliveryInfoModel) {
            DeliveryInfoModel cm = (DeliveryInfoModel) model;
            Object ob = getScopedValue(ValueKeys.ADDRESS_SEARCH_RESULT);
            if (ob != null && ob instanceof IPartyLocaleInformation) {
                IPartyLocaleInformation addressInformation = (IPartyLocaleInformation) ob;

                cm.setAddress1(addressInformation.getAddress1());
                cm.setAddress2(addressInformation.getAddress2());
                cm.setAddress3(addressInformation.getAddress3());
                cm.setAddress4(addressInformation.getAddress4());
                cm.setApartment("");
                cm.setCity(addressInformation.getCity());
                cm.setPostalCode(addressInformation.getPostalCode());
                cm.setState(addressInformation.getState());
                cm.setCountry(addressInformation.getCountry());
                this.clearScopedValue(ValueKeys.ADDRESS_SEARCH_RESULT);
                
            }
        }
    }
    
    
    private void setScopedModelOffline() {
      
        Object model = getModel();  
        IPartyLocaleInformation localeToUpdate = DataFactory.createObject(IPartyLocaleInformation.class) ;
        
        if (model != null && model instanceof DeliveryInfoModel) {

            DeliveryInfoModel infoModel = (DeliveryInfoModel) model;
            
            localeToUpdate.setAddress1(infoModel.getAddress1());
            localeToUpdate.setAddress2(infoModel.getAddress2());
            localeToUpdate.setAddress3(infoModel.getAddress3());
            localeToUpdate.setAddress4(infoModel.getAddress4());
            localeToUpdate.setApartment("");
            localeToUpdate.setCity(infoModel.getCity());
            localeToUpdate.setState(infoModel.getState());
            localeToUpdate.setPostalCode(infoModel.getPostalCode());
            localeToUpdate.setCountry(infoModel.getCountry());
            localeToUpdate.setCounty(infoModel.getCounty());
            localeToUpdate.setNeighborhood(infoModel.getNeighborhood());
            setScopedValue(CawValueKeys.CAW_DELIVERY_ADDRESS_INFO_OFF, localeToUpdate);
        }
    }
    
    private void refreshModelOffline() {

        Object model = getModel();
        if (model != null && model instanceof DeliveryInfoModel) {
            DeliveryInfoModel cm = (DeliveryInfoModel) model;
            Object ob = getScopedValue(CawValueKeys.CAW_DELIVERY_ADDRESS_INFO_OFF);
            if (ob != null && ob instanceof IPartyLocaleInformation) {
                IPartyLocaleInformation addressInformation = (IPartyLocaleInformation) ob;
                cm.setAddress1(addressInformation.getAddress1());
                cm.setAddress2(addressInformation.getAddress2());
                cm.setAddress3(addressInformation.getAddress3());
                cm.setAddress4(addressInformation.getAddress4());
                cm.setApartment("");
                cm.setCity(addressInformation.getCity());
                cm.setPostalCode(addressInformation.getPostalCode());
                cm.setState(addressInformation.getState());
                cm.setCounty(addressInformation.getCounty());
                cm.setNeighborhood(addressInformation.getNeighborhood());
                cm.setCountry(addressInformation.getCountry());
                clearScopedValue(CawValueKeys.CAW_DELIVERY_ADDRESS_INFO_OFF);
            }
        }
    }

  
    @Override
    protected IOpResponse handleDisplayAgain() {

        DeliveryInfoModel cm = this.getModel();
        IPartyLocaleInformation addressInformation = getScopedValue(ValueKeys.ADDRESS_SEARCH_RESULT);
        if (addressInformation != null) {
            cm.setAddress1(addressInformation.getAddress1());
            cm.setAddress2(addressInformation.getAddress2());
            cm.setAddress3(addressInformation.getAddress3());
            cm.setAddress4(addressInformation.getAddress4());
            cm.setApartment("");
            cm.setCity(addressInformation.getCity());
            cm.setPostalCode(addressInformation.getPostalCode());
            cm.setState(addressInformation.getState());
            cm.setCountry(addressInformation.getCountry());
        }
        clearScopedValue(ValueKeys.ADDRESS_SEARCH_RESULT);
        return super.handleDisplayAgain();
    }
    
    
    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {

        IOpResponse response = super.handleFormResponse(argEvent);

        DeliveryInfoModel infoModel = this.getModel();
        _orderMgr.setDeliveryInfo(infoModel.getDeliveryInfo());
        IOrder currentOrder = _orderMgr.getCurrentOrder();
        ICustomerModifier customer = currentOrder.getCustomer();
        customer.setTelephone1(infoModel.getTelephone());
        customer.setEmailAddress(infoModel.getEmailAddress());

        // Update all of the delivery lines on the current order to match the new delivery address.
        for (IOrderLine orderLine : currentOrder.getOrderLines()) {
            if (FulfillmentMethod.DELIVERY
                    .matches(orderLine.getFulfillmentType())
                    && (orderLine.getFulfillmentModifier() != null)) {
                IFulfillmentModifier fulfillment = orderLine
                        .getFulfillmentModifier();
                fulfillment.setLocationName1(infoModel.getFirstName());
                fulfillment.setLocationName2(infoModel.getLastName());
                fulfillment.getAddress().setAddress1(infoModel.getAddress1());
                fulfillment.getAddress().setAddress2(infoModel.getAddress2());
                fulfillment.getAddress().setCity(infoModel.getCity());
                fulfillment.getAddress().setState(infoModel.getState());
                fulfillment.getAddress()
                        .setPostalCode(infoModel.getPostalCode());
                fulfillment.getAddress().setCountry(infoModel.getCountry());
            }
        }

        return response;

    }

    private IOpResponse handleQASAddressLookup(IXstDataAction argAction,
            boolean saveChangePressed, boolean saveQASValidated) {

        IOpResponse resonse = null;
        if (saveChangePressed) {
            if (saveQASValidated) {
                //Continue to save change by calling base
                setOpState(AFTER_REQUEST);
                resonse = super.handleDataAction(argAction);
            } else {
                //Validate form and look up address
                resonse = getFormValidityResponse(getModel());
                if (resonse == null) {
                    int code = _orderHelper.checkQASMatchingLookupAddress(getModel(), _busyState, _transactionScope);
                    
                    if (code == 0) {
                        //Continue to save change by calling base super.handleDataAction(argAction);
                        resonse = super.handleDataAction(argAction);
                    } else if (code == -1) {
                        resonse = getPromptNotFound();
                    } else if (code == -2) {
                        resonse = getPromptOffline();
                    } else if (code == -3) {
                        resonse = getPromptCountryQAS();
                    } else {
                        resonse = getPromptAddressLookup(argAction);
                    }
                }
            }
        }
        return resonse;
    }
    
    /**
     * Address not found
     * @return
     */
    private IOpResponse getPromptNotFound() {

        setOpState(VALIDATION_ERROR);
        _transactionScope.setValue(CawValueKeys.IS_ADDRESS_FOUND, false);
        AddressSearchResultStatus status = AddressSearchResultStatus.ADDRESS_NOT_FOUND;
        IFormattable args[] = (new IFormattable[] { _formattables
                .getSimpleFormattable(status.getMessage()), _formattables
                        .getSimpleFormattable(status.getStatus()) });
        return HELPER.getPromptResponse(CAW_QAS_NOT_FOUND, args);
    }

    /**
     * Used when QAS Offline
     * @return
     */
    private IOpResponse getPromptOffline() {

        setOpState(VALIDATION_ERROR);
        _transactionScope.setValue(CawValueKeys.IS_ADDRESS_FOUND, false);
        IFormattable args[] = new IFormattable[1];
        args[0] = _formattables.getSimpleFormattable("", FormatterType.SIMPLE);
        return HELPER.getPromptResponse(CAW_QAS_CHECK_CONNECTION, args);
    }

    /**
     * Prompt Lookup Address with QAS
     * @param argAction
     * @return
     */
    private IOpResponse getPromptAddressLookup(IXstDataAction argAction) {

        setScopedModelOffline();
        _transactionScope.setValue(CawValueKeys.IS_DELIVERY_INFO, true);
        argAction.setActionKey(XstDataActionKey.valueOf("ADDRESS_LOOKUP"));
        return HELPER.getCompleteStackChainResponse(OpChainKey
                .valueOf(ADDRESS_LOOKUP), argAction);
    }

    private IOpResponse getPromptCountryQAS() {

        IFormattable args[] = new IFormattable[1];
        args[0] = _formattables.getSimpleFormattable("", FormatterType.SIMPLE);
        return HELPER.getPromptResponse(CAW_QAS_VALIDATE_COUNTRY, args);
    }

    @Override
    protected FormKey getBaseFormKey() {
        /* BEGIN BZ38349 */
        DeliveryInfoModel cm = this.getModel();
        DeliveryInfoModel beforeModel = getScopedValue(CawValueKeys.CAW_DELIVERY_INFO_MODEL_BEFORE);
        if (beforeModel != null) {
            cm.setFirstName(beforeModel.getFirstName());
            cm.setLastName(beforeModel.getLastName());
            cm.setOrganizationName(beforeModel.getOrganizationName());
            cm.setTelephone(beforeModel.getTelephone());
            cm.setSuffix(beforeModel.getSuffix());
            cm.setSalutation(beforeModel.getSalutation());
            cm.setEmailAddress(beforeModel.getEmailAddress());
            clearScopedValue(CawValueKeys.CAW_DELIVERY_INFO_MODEL_BEFORE);
            
        }
        /* END BZ38349 */

        return FormKey.valueOf("ORDER_DELIVERY_INFO");
    }

    @Override
    protected DeliveryInfoModel createModel() {

        IExtendedLocationModifier deliveryInfo = (_orderMgr
                .getDeliveryInfo() != null) //
                        ? _orderMgr.getDeliveryInfo()
                        : _orderMgr.getCurrentOrder().getCustomer();
        setSelectedCountry(deliveryInfo.getLocationAddress().getCountry());
        return new DeliveryInfoModel(deliveryInfo);
    }
    
    /* BEGIN BZ37611 */
    @Override
    protected void setSelectedCountry(String argCountry) {
      super.setSelectedCountry(argCountry);
      if (argCountry != null) {
        setScopedValue(ValueKeys.ADDRESS_LOOKUP_COUNTRY, argCountry);
      }
    }
    
    @Override
    public IOpResponse handleChangeCountry(IXstEvent argEvent) {
        ICountryEditModel model = (ICountryEditModel)this.getModel();
        Collection<IRegion> regions = StoreLocationHelper.getInstance().getRegions();
        List<ICountry> countries = new ArrayList();
        Iterator var5 = regions.iterator();

        while(var5.hasNext()) {
           IRegion region = (IRegion)var5.next();
           countries.addAll(Arrays.asList(region.getCountries()));
        }

        ICountry current = CountryCache.makeCountry(model.getCountry(), (String)null, 0);
        countries.remove(current);
       // Collections.sort(countries, new 1(this));
        this.setOpState(this.CHANGE_COUNTRY);
        IOpResponse response = countries.isEmpty() ? this.HELPER.getPromptResponse(NO_COUNTRIES_PROMPT, new IFormattable[0]) : this.HELPER.getListPromptResponse(COUNTRY_PROMPT, countries.toArray(), new IFormattable[0]);
        return response;
     }
    
    @Override
    protected IOpResponse handleAfterDataAction(IXstEvent argEvent) {
        return !this.CHANGE_COUNTRY.equals(this.getOpState()) && !this.isCountryChangedExternally()
                ? super.handleAfterDataAction(argEvent)
                : this.handleAfterChangeCountry(argEvent);
    }
    
    private final boolean isCountryChangedExternally() {
        if (this.getModel() instanceof ICountryEditModel) {
            ICountryEditModel cModel = (ICountryEditModel) this.getModel();
            return cModel.getCountryChangedExternally();
        } else {
            return false;
        }
    }
    /* END BZ37611 */
    
    /*BEGIN BZ37749 */
    @Override
    protected IOpResponse getFormValidityResponse(DeliveryInfoModel argModel) {

        IValidationResultList results = this.validateForm(argModel);

        IEditModelField<String> postalCode = argModel.getFieldDef("postalCode");
        IValidationResult validatePostalCode = _postalCodeValidator.validateField(argModel, postalCode);
        
        if (validatePostalCode.isValid()) {
            return super.getFormValidityResponse(argModel);
            
        } else {
            this.setOpState(this.VALIDATION_ERROR);
            results.add(validatePostalCode);

            PromptConfig promptConfig = new PromptConfig();
            PromptKey promptKey = this.getFormValidationFailedPromptKey();
            
            promptConfig.setDataFieldConfig(new DataFieldConfig());
            promptConfig = this._promptConfigHelper.getPromptConfig(promptKey, promptConfig);
            String problemHeader = promptConfig.getMsgSectionConfig()
                    .getText((IFormattable[]) null)
                    .toString(OutputContextType.VIEW);

            ValidationResultsStyler styler = new ValidationResultsStyler(
                    problemHeader, results.getInvalidResults());

            promptConfig.getDataFieldConfig().setStyler(styler);

            return this.HELPER.getPromptResponse(promptKey, promptConfig, this
                    .getFormKey(), new IFormattable[0]);
        }
    }
    /*END BZ37749 */
}
