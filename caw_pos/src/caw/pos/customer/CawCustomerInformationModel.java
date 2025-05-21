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
 * BZ37305          260820    [New Requirement] Prompting Engine call before customer information gets displayed on the PinPad 
 *===================================================================
 */

package caw.pos.customer;

import java.util.Map;

import javax.inject.Inject;

import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.CawConstants;

import dtv.pos.customer.CustomerHelper;
import dtv.pos.framework.form.BasicEditModel;
import dtv.pos.framework.form.EditModelField;
import dtv.pos.iframework.form.IEditModelField;
import dtv.xst.dao.crm.IParty;

/**
 *
 */
public class CawCustomerInformationModel extends BasicEditModel {

    @Inject
    private CustomerHelper           _customerHelper;

    public static final String       CUST_NAME_FIELD             = "custName";

    public static final String       CUST_ADDRESS_FIELD          = "custAddress";

    public static final String       CUST_CITY_FIELD             = "custCity";

    public static final String       CUST_STATE_FIELD            = "custState";

    public static final String       CUST_POSTAL_CODE_FIELD      = "custPostalCode";

    public static final String       CUST_TELEPHONE_HOME_FIELD   = "custTelephoneHome";

    public static final String       CUST_TELEPHONE_MOBILE_FIELD = "custTelephoneMobile";

    public static final String       CUST_EMAIL_FIELD            = "custEmail";

    private String                   custName_;

    private String                   custAddress_;

    private String                   custState_;

    private String                   custCity_;

    private String                   custCountry_;

    private String                   custPostalCode_;

    private String                   custTelephoneHome_;

    private String                   custTelephoneMobile_;

    private String                   custEmail_;

    private IEditModelField<Integer> percentField_;

    private Integer                  percentComplete_;

    private IParty                   party                       = null;

    public CawCustomerInformationModel(IParty cust) {

        super(FF.getTranslatable("_cawCustomerInformationTitle"), null);
        this.addField("custName", String.class);
        this.addField("custAddress", String.class);
        this.addField("custCity", String.class);
        this.addField("custState", String.class);
        this.addField("custPostalCode", String.class);
        this.addField("custTelephoneMobile", String.class);
        this.addField("custTelephoneHome", String.class);
        this.addField("custEmail", String.class);
        this.percentField_ = EditModelField
                .makeFieldDef(this, "percentComplete", Integer.class, 10);
        this.addField(this.percentField_);
        this.party = cust;
        this.initializeFieldState();
    }

    @Override
    protected void initializeFieldValues() {

        super.initializeFieldValues();
        //Phone numbers
        Map<String, String> phoneNumbers = CawCustomerUtil
                .getPhoneNumberIParty(this.party);
        String home = "";
        String mobile = "";
        if (phoneNumbers != null && phoneNumbers.size() > 0) {
            home = phoneNumbers.get(CawConstants.HOME);
            home = (home == null) ? "" : home;
            mobile = phoneNumbers.get(CawConstants.MOBILE);
            mobile = (mobile == null) ? "" : mobile;
        }
        setValue(CUST_ADDRESS_FIELD, CawCustomerUtil
                .getAddressInfoIParty(this.party, 1));
        setValue(CUST_NAME_FIELD, _customerHelper
                .getCustomerDisplayName(this.party));
        setValue(CUST_CITY_FIELD, CawCustomerUtil
                .getAddressInfoIParty(this.party, 2));
        setValue(CUST_STATE_FIELD, CawCustomerUtil
                .getAddressInfoIParty(this.party, 3));

        setValue(CUST_POSTAL_CODE_FIELD, CawCustomerUtil
                .getAddressInfoIParty(this.party, 4));
        setValue(CUST_TELEPHONE_HOME_FIELD, home);
        setValue(CUST_TELEPHONE_MOBILE_FIELD, mobile);
        setValue(CUST_EMAIL_FIELD, this.party.getEmailAddress());
    }

    /**
     * @return the custName
     */
    public String getCustName() {

        return custName_;
    }

    /**
     * @param argCustName the custName to set
     */
    public void setCustName(String argCustName) {

        custName_ = argCustName;
    }

    /**
     * @return the custAddress
     */
    public String getCustAddress() {

        return custAddress_;
    }

    /**
     * @param argCustAddress the custAddress to set
     */
    public void setCustAddress(String argCustAddress) {

        custAddress_ = argCustAddress;
    }

    /**
     * @return the custState
     */
    public String getCustState() {

        return custState_;
    }

    /**
     * @param argCustState the custState to set
     */
    public void setCustState(String argCustState) {

        custState_ = argCustState;
    }

    /**
     * @return the custCountry
     */
    public String getCustCountry() {

        return custCountry_;
    }

    /**
     * @param argCustCountry the custCountry to set
     */
    public void setCustCountry(String argCustCountry) {

        custCountry_ = argCustCountry;
    }

    /**
     * @return the custPostalCode
     */
    public String getCustPostalCode() {

        return custPostalCode_;
    }

    /**
     * @param argCustPostalCode the custPostalCode to set
     */
    public void setCustPostalCode(String argCustPostalCode) {

        custPostalCode_ = argCustPostalCode;
    }

    /**
     * @return the custTelephoneHome
     */
    public String getCustTelephoneHome() {

        return custTelephoneHome_;
    }

    /**
     * @param argCustTelephoneHome the custTelephoneHome to set
     */
    public void setCustTelephoneHome(String argCustTelephoneHome) {

        custTelephoneHome_ = argCustTelephoneHome;
    }

    /**
     * @return the custTelephoneMobile
     */
    public String getCustTelephoneMobile() {

        return custTelephoneMobile_;
    }

    /**
     * @param argCustTelephoneMobile the custTelephoneMobile to set
     */
    public void setCustTelephoneMobile(String argCustTelephoneMobile) {

        custTelephoneMobile_ = argCustTelephoneMobile;
    }

    /**
     * @return the custEmail
     */
    public String getCustEmail() {

        return custEmail_;
    }

    public void setCustEmail(String argCustEmail) {

        custEmail_ = argCustEmail;
    }

    public IEditModelField<Integer> getPercentField() {

        return percentField_;
    }

    public void setPercentField(IEditModelField<Integer> argPercentField) {

        percentField_ = argPercentField;
    }

    public Integer getPercentComplete() {

        return percentComplete_;
    }

    public void setPercentComplete(Integer argPercentComplete) {

        percentComplete_ = argPercentComplete;
    }

    public String getCustCity() {

        return custCity_;
    }

    public void setCustCity(String argCustCity) {

        custCity_ = argCustCity;
    }

}
