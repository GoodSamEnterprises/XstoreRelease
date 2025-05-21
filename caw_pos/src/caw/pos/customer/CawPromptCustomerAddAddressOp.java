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
 * BZ37753          160920    [Internal] - HDE screen displays when adding 2nd address for customer 
 *===================================================================
 */
package caw.pos.customer;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.pos.framework.form.validators.CawPostalCodeFieldValidator;

import dtv.data2.access.DataFactory;
import dtv.event.Eventor;
import dtv.event.eventor.DefaultEventor;
import dtv.i18n.*;
import dtv.pos.address.search.AddressSearchResultStatus;
import dtv.pos.common.*;
import dtv.pos.customer.CustomerUtil;
import dtv.pos.customer.MultipleAddressFormModel;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractChangeCountryOp;
import dtv.pos.framework.ui.config.*;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.form.IEditModelField;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.IValidationResultList;
import dtv.pos.spring.ValueKeys;
import dtv.ui.swing.text.ValidationResultsStyler;
import dtv.xst.dao.crm.IPartyLocaleInformation;;

/**
 *
 */
public class CawPromptCustomerAddAddressOp extends AbstractChangeCountryOp<MultipleAddressFormModel> {
    
    private static final Logger        _logger               = LogManager.getLogger(CawPromptCustomerAddAddressOp.class);
    
    private static final IXstActionKey CHANGE_COUNTRY_ACTION = XstDataActionKey.valueOf("CHANGE_COUNTRY");
    private static final IXstActionKey CHANGE_COUNTRY_CANCEL = XstDataActionKey.valueOf("CHANGE_COUNTRY_CANCEL");
    private static final PromptKey CAW_QAS_NOT_FOUND         = PromptKey.valueOf("CAW_QAS_NOT_FOUND");
    private static final PromptKey CAW_QAS_CHECK_CONNECTION  = PromptKey.valueOf("CAW_QAS_CHECK_CONNECTION");
    private static final PromptKey CAW_QAS_VALIDATE_COUNTRY  = PromptKey.valueOf("CAW_QAS_VALIDATE_COUNTRY");
    private static final String    ADDRESS_LOOKUP            = "ADDRESS_LOOKUP";
    private CawCustomerHelper      _custHelper               = CawCustomerHelper.getInstance();
    
    @Inject
    private IBusyState             _busyState;
    @Inject
    private CawPostalCodeFieldValidator _postalCodeValidator;
    @Inject
    private PromptConfigHelper _promptConfigHelper;
    
    @Override
    public IOpResponse handleOpReverse(IXstEvent argEvent) {

        return super.handleOpReverse(argEvent);
    }

    @Override
    protected MultipleAddressFormModel createModel() {

        MultipleAddressFormModel model = new MultipleAddressFormModel();
        String country = model.getCountry();
        if (country != null) {
            setScopedValue(ValueKeys.ADDRESS_LOOKUP_COUNTRY, country);
        }
        return model;
    }

    @Override
    protected FormKey getBaseFormKey() {

        return FormKey.valueOf("CUST_ADD_EDIT_ADDRESS");
    }

    @Override
    protected void setSelectedCountry(String argCountry) {

        super.setSelectedCountry(argCountry);
        if (argCountry != null) {
            setScopedValue(ValueKeys.ADDRESS_LOOKUP_COUNTRY, argCountry);
        }
    }

    @Override
    protected IOpResponse handleInitialState() {

        MultipleAddressFormModel model = getModel();
        setSelectedCountry(model.getCountry());
        setOpState(AFTER_REQUEST);

        return HELPER
                .getShowFormResponse(getFormKey(), model, getActionGroupKey(), isEditable());
    }

    @Override
    protected IOpResponse handleFormResponse(IXstEvent argEvent) {

        MultipleAddressFormModel addressModel = getModel();
        addressModel.commitChanges();

        Eventor eventor = new DefaultEventor(
                CustomerUtil.ADDRESS_CHANGED_EVENT_DESCRIPTOR);
        eventor.post(CustomerUtil.CUSTOMER_ADDRESS_ADDED, addressModel
                .getAddress());

        return HELPER.completeResponse();
    }

    @Override
    protected IOpResponse handleDisplayAgain() {

        MultipleAddressFormModel cm = getModel();
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
            clearScopedValue(ValueKeys.ADDRESS_SEARCH_RESULT);
        }
        return super.handleDisplayAgain();
    }

    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        boolean saveChangePressed = false;
        boolean saveQASValidated = false;
        IXstActionKey actionKey = argAction.getActionKey();

        if (CHANGE_COUNTRY_ACTION.equals(argAction.getActionKey())) {
            return this.handleChangeCountry(argAction);
        } else if (this.getOpState() != null
                && "CHANGE_COUNTRY".equals(this.getOpState().toString())
                && CHANGE_COUNTRY_CANCEL.equals(argAction.getActionKey())) {
            this.setOpState(this.AFTER_REQUEST);
            return this.HELPER.getChangeFormResponse(this.getFormKey(), this
                    .getModel(), this.getActionGroupKey(), this.isEditable());
        }

        IOpResponse resonse = null;

        if (CawConstants.QAS_APPLIED.equalsIgnoreCase(actionKey.toString())) {
            refreshModel();
            /* Back to Multi address form after find address success.
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
                }
            }
        }

        resonse = handleQASAddressLookup(argAction, saveChangePressed, saveQASValidated);
        return resonse;

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

                    String addressLine = getMergedAddressOneLine(this
                            .getModel());
                    String country = this.getModel().getCountry();
                    int code = _custHelper
                            .checkQASMatchingLookupAddress(addressLine, country, _busyState, _transactionScope);
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

    public String getMergedAddressOneLine(MultipleAddressFormModel infoModel) {

        StringBuilder address = new StringBuilder();
        MultipleAddressFormModel _infoModel = infoModel;
        try {
            if (_infoModel != null) {
                if (_infoModel.getAddress1() != null) {
                    address.append(_infoModel.getAddress1());
                }
                if (_infoModel.getAddress2() != null) {
                    if (_infoModel.getAddress1() == null) {
                        address.append(_infoModel.getAddress2());
                    } else {
                        address.append(", ").append(_infoModel.getAddress2());
                    }
                }
                if (_infoModel.getAddress3() != null) {
                    if (_infoModel.getAddress1() == null
                            && _infoModel.getAddress2() == null) {
                        address.append(_infoModel.getAddress3());
                    } else {
                        address.append(", ").append(_infoModel.getAddress3());
                    }
                }
                if (_infoModel.getAddress4() != null) {
                    if (_infoModel.getAddress1() == null
                            && _infoModel.getAddress2() == null
                            && _infoModel.getAddress3() == null) {
                        address.append(_infoModel.getAddress4());
                    } else {
                        address.append(", ").append(_infoModel.getAddress4());
                    }
                }
                address.append(", ");
                if (_infoModel.getCity() != null) {
                    address.append(_infoModel.getCity());
                }
                address.append(", ");
                if (_infoModel.getState() != null) {
                    address.append(_infoModel.getState());
                }
                if (_infoModel.getPostalCode() != null) {
                    address.append(" ").append(_infoModel.getPostalCode());
                }
            }
        } catch (Exception ex) {
            _logger.error("getMergedAddressLine-1: " + ex.getMessage());
        }
        return address.toString();
    }

    private IOpResponse getPromptAddressLookup(IXstDataAction argAction) {

        setScopedModelOffline();
        _transactionScope
                .setValue(CawValueKeys.MULTI_ADDRESS_FORM_ADD_OR_EDIT, "ADD");
        argAction.setActionKey(XstDataActionKey.valueOf("ADDRESS_LOOKUP"));
        return HELPER.getCompleteStackChainResponse(OpChainKey
                .valueOf(ADDRESS_LOOKUP), argAction);
    }

    private IOpResponse getPromptNotFound() {

        setOpState(VALIDATION_ERROR);
        _transactionScope.setValue(CawValueKeys.IS_ADDRESS_FOUND, false);
        AddressSearchResultStatus status = AddressSearchResultStatus.ADDRESS_NOT_FOUND;
        IFormattable args[] = (new IFormattable[] { _formattables
                .getSimpleFormattable(status.getMessage()), _formattables
                        .getSimpleFormattable(status.getStatus()) });
        return HELPER.getPromptResponse(CAW_QAS_NOT_FOUND, args);
    }

    private void setScopedModelOffline() {

        Object model = getModel();
        IPartyLocaleInformation localeToUpdate = DataFactory
                .createObject(IPartyLocaleInformation.class);

        if (model != null && model instanceof MultipleAddressFormModel) {

            MultipleAddressFormModel infoModel = (MultipleAddressFormModel) model;

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
            localeToUpdate.setAddressType(infoModel.getAddressType());
            setScopedValue(CawValueKeys.CAW_MULTI_ADDRESS_FORM_OFF, localeToUpdate);
        }
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

    private IOpResponse getPromptCountryQAS() {

        IFormattable args[] = new IFormattable[1];
        args[0] = _formattables.getSimpleFormattable("", FormatterType.SIMPLE);
        return HELPER.getPromptResponse(CAW_QAS_VALIDATE_COUNTRY, args);
    }

    private void refreshModel() {

        Object model = this.getModel();
        this.getModel().getAddressType();
        if (model != null && model instanceof MultipleAddressFormModel) {
            MultipleAddressFormModel cm = (MultipleAddressFormModel) model;
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

                String addressType = null;
                Object cawParty = getScopedValue(CawValueKeys.CAW_MULTI_ADDRESS_FORM_OFF);
                if (cawParty != null
                        && cawParty instanceof IPartyLocaleInformation) {
                    IPartyLocaleInformation address = (IPartyLocaleInformation) cawParty;
                    addressType = address.getAddressType();
                }
                cm.setAddressType(addressType);
                this.clearScopedValue(ValueKeys.ADDRESS_SEARCH_RESULT);

            }
        }
    }

    private void refreshModelOffline() {

        Object model = getModel();
        if (model != null && model instanceof MultipleAddressFormModel) {
            MultipleAddressFormModel cm = (MultipleAddressFormModel) model;
            Object ob = getScopedValue(CawValueKeys.CAW_MULTI_ADDRESS_FORM_OFF);
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
                cm.setAddressType(addressInformation.getAddressType());
                clearScopedValue(CawValueKeys.CAW_MULTI_ADDRESS_FORM_OFF);
            }
        }
    }

    @Override
    protected IOpResponse getFormValidityResponse(
            MultipleAddressFormModel argModel) {

        IValidationResultList results = this.validateForm(argModel);

        IEditModelField<String> postalCode = argModel.getFieldDef("postalCode");
        IValidationResult validatePostalCode = _postalCodeValidator
                .validateField(argModel, postalCode);

        if (validatePostalCode.isValid()) {
            return super.getFormValidityResponse(argModel);

        } else {
            this.setOpState(this.VALIDATION_ERROR);
            results.add(validatePostalCode);

            PromptConfig promptConfig = new PromptConfig();
            PromptKey promptKey = this.getFormValidationFailedPromptKey();

            promptConfig.setDataFieldConfig(new DataFieldConfig());
            promptConfig = this._promptConfigHelper
                    .getPromptConfig(promptKey, promptConfig);
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
}
