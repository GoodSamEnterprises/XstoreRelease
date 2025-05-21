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
 * BZ29372          150219    [Requirement] PLCC Account Lookup - ID Verification Screen new request
 *===================================================================
 */

package caw.tenderauth.impl.eigen.accountlookup.op;

import static dtv.pos.iframework.form.IEditModelFieldMetadata.ATTR_NEW;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import caw.pos.advance.prompting.CawInputSingleChoice;

import dtv.event.EventEnum;
import dtv.pos.framework.form.*;
import dtv.pos.framework.location.StateWrapperFactory;
import dtv.pos.iframework.ILocationFactory;
import dtv.pos.iframework.form.ICardinality;
import dtv.pos.iframework.form.IValueWrapperFactory;
import dtv.pos.iframework.form.dependency.IMutableFieldDefinition;
import dtv.util.ICodeInterface;
import dtv.util.address.*;

/**
 * The model contain the data for Identification Validation form.
 */
public class CawAccountLookupValidationModel extends BasicEditModel {

    public static final String                    EMPTY_STRING                 = "";

    public static final String                    SELECT_STATE                 = "Select State";

    private String                                accountFirstName;

    private String                                accountLastName;

    private ICodeInterface                        _acountCardType;

    private ICodeInterface                        _acountState;

    public static final String                    ACOUNT_CARD_TYPE             = "acountCardType";

    public static final String                    ACOUNT_STATE                 = "acountState";

    public static final EventEnum                 CUSTOMER_CARD_CHANGED        = new EventEnum("CUSTOMER_CARD_CHANGED");

    public static final EventEnum                 CUSTOMER_STATE_CHANGED       = new EventEnum(
            "CUSTOMER_STATE_CHANGED");

    private final IValueWrapperFactory            _codeInterfaceWrapperFactory = ValueWrapperFactory
            .makeWrapperFactory(CodeEnumValueWrapper.class);

    @Inject
    private ILocationFactory                      _locationFactory;

    @Inject
    @Named("cawAccountCardTypeSetFieldFactory")
    private DefaultEditModelSetFieldFilterFactory _cawAccountCardTypeSetFieldFactory;

    CawAccountLookupValidationModel() {

        // Add title for form Identification Validation
        super(FF.getTranslatable("_cawAccountValidationTitle"), null);
        // Add fields contain values: first name, last name
        addField("accountFirstName", String.class);
        addField("accountLastName", String.class);
        // Make the 'Select ID Type' ComboBox.
        addField(EditModelField
                .makeFieldDef(this, ACOUNT_CARD_TYPE, ICodeInterface.class, ATTR_NEW, null, ICardinality.OPTIONAL_UNBOUNDED, getCardTypes(), null, _codeInterfaceWrapperFactory, null));
        // Set field 'Select ID Type' is require.
        ((IMutableFieldDefinition<?>) getFieldDef(ACOUNT_CARD_TYPE)).setCardinality(ICardinality.REQUIRED);

        // Make the 'Select State' ComboBox.
        addField(EditModelField
                .makeFieldDef(this, ACOUNT_STATE, ICodeInterface.class, ATTR_NEW, null, ICardinality.NOT_AVAILABLE, getStates(), null, _codeInterfaceWrapperFactory, null));

        initializeFieldState();
    }

    @Override
    protected IEditModelSetFieldFilterFactory getSetFieldFilterFactory() {

        return _cawAccountCardTypeSetFieldFactory;
    }

    /**
     * @return the accountFirstName
     */
    public String getAccountFirstName() {

        return accountFirstName;
    }

    /**
     * @param argAccountFirstName the accountFirstName to set
     */
    public void setAccountFirstName(String argAccountFirstName) {

        accountFirstName = argAccountFirstName;
    }

    /**
     * @return the accountLastName
     */
    public String getAccountLastName() {

        return accountLastName;
    }

    /**
     * @param argAccountLastName the accountLastName to set
     */
    public void setAccountLastName(String argAccountLastName) {

        accountLastName = argAccountLastName;
    }

    /**
     * The function get list card type.
     * @return the lsInputSingleSelect
     */
    public List<CawInputSingleChoice> getCardTypes() {

        List<CawInputSingleChoice> argLsInputSingleSelect = new ArrayList<CawInputSingleChoice>();
        CawInputSingleChoice element = null;
        for (CawAccountCardType status : CawAccountCardType.values()) {
            element = new CawInputSingleChoice();
            element.setInputId(status.getType());
            element.setInputLable(status.getName());
            argLsInputSingleSelect.add(element);
        }

        return argLsInputSingleSelect;
    }

    /**
     * @return the acountCardType
     */
    public ICodeInterface getAcountCardType() {

        return _acountCardType;
    }

    /**
     * @param argAcountCardType the acountCardType to set
     */
    public void setAcountCardType(ICodeInterface argAcountCardType) {

        _acountCardType = argAcountCardType;
    }

    public List<CawInputSingleChoice> getStates() {

        List<CawInputSingleChoice> states = new ArrayList<CawInputSingleChoice>();
        CawInputSingleChoice element = new CawInputSingleChoice();
        element.setInputId(EMPTY_STRING);
        element.setInputLable(SELECT_STATE);
        states.add(element);

        String country = _locationFactory.getStoreById(_stationState.getRetailLocationId()).getCountry();

        StateWrapperFactory stateFactory = new StateWrapperFactory(country);
        StateCache stateCache_ = (StateCache) AddressService.getInternalInstance()
                .getFieldCache(IAddressServiceConstants.DEFAULT_MODE, IAddressServiceConstants.STATE);
        IState[] stateArr = stateCache_.getStateArrayForCountry(stateFactory.getCountryCode());
        if (stateArr != null && stateArr.length > 0) {
            for (int i = 0; i < stateArr.length; i++) {
                element = new CawInputSingleChoice();
                element.setInputId(stateArr[i].getCode());
                element.setInputLable(stateArr[i].getCode() + " - " + stateArr[i].getLongName());
                states.add(element);
            }
        }

        return states;
    }

    /**
     * @return the acountState
     */
    public ICodeInterface getAcountState() {

        return _acountState;
    }

    /**
     * @param argAcountState the acountState to set
     */
    public void setAcountState(ICodeInterface argAcountState) {

        _acountState = argAcountState;
    }

}
