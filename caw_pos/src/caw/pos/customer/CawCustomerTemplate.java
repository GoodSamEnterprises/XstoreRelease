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
 * Req/Bug ID#          ddMMyy    Description
 * INT-92               260817    Customer Integration
 *== ================================================================
 */

package caw.pos.customer;

import caw.pos.common.CawEBSConstant;

public class CawCustomerTemplate {

    private CawCustomerInfo    name;

    private CawCustomerAddress address;

    private String             memberships              = CawEBSConstant.CUSTOMER_TEMPLATE_MEMBERSHIPS;

    private String             phones                   = CawEBSConstant.CUSTOMER_TEMPLATE_PHONES;

    private String             partners                 = CawEBSConstant.CUSTOMER_TEMPLATE_PARTNERS;

    private CawCustomerPrice   pricing;

    private Long               accountNumber            = CawEBSConstant.CUSTOMER_TEMPLATE_ACCOUNT_NUMBER;

    private Integer            accountStatus            = CawEBSConstant.CUSTOMER_TEMPLATE_ACCOUNT_STATUS;

    private String             accountStatusDescription = CawEBSConstant.CUSTOMER_TEMPLATE_ACCOUNT_STATUS_DESCRIPTION;

    private Integer            customerType             = CawEBSConstant.CUSTOMER_TEMPLATE_CUSTOMER_TYPE;

    private String             acxiomIdentifiers        = CawEBSConstant.CUSTOMER_TEMPLATE_ACXIOMIDENTIFIERS;

    private boolean            allowEdit                = CawEBSConstant.CUSTOMER_TEMPLATE_ALLOW_EDIT;

    private String             emailAddress             = CawEBSConstant.CUSTOMER_TEMPLATE_EMAIL_ADDRESS;

    private Integer            rvType                   = CawEBSConstant.CUSTOMER_TEMPLATE_RVTYPE;

    private String             rvTypeDescription        = CawEBSConstant.CUSTOMER_TEMPLATE_RVTYPE_DESCRIPTION;

    private Boolean            isTaxExempt              = CawEBSConstant.CUSTOMER_TEMPLATE_IS_TAXEXEMPT;

    private String             taxCertificate           = CawEBSConstant.CUSTOMER_TEMPLATE_TAX_CERTIFICATE;

    private CawCustomerArInfo  arInfo;

    private String             lastUpdateUser           = CawEBSConstant.CUSTOMER_TEMPLATE_LAST_UPDATE_USER;

    private String             lastUpdateSystem         = CawEBSConstant.CUSTOMER_TEMPLATE_LAST_UPDATE_SYSTEM;

    private String             lastUpdateDate           = CawEBSConstant.CUSTOMER_TEMPLATE_LAST_UPDATE_DATE;

    private String             feed                     = CawEBSConstant.CUSTOMER_TEMPLATE_FEED;

    private Integer            crud                     = CawEBSConstant.CUSTOMER_TEMPLATE_CRUD;

    private String             crudDescription          = CawEBSConstant.CUSTOMER_TEMPLATE_CRUD_DESCRIPTION;

    private String             attributes               = CawEBSConstant.CUSTOMER_TEMPLATE_ATTRIBUTES;

    /**
     * @return
     */
    public CawCustomerInfo getName() {

        return name;
    }

    /**
     * @param argName
     */
    public void setName(CawCustomerInfo argName) {

        name = argName;
    }

    /**
     * @return
     */
    public CawCustomerAddress getAddress() {

        return address;
    }

    /**
     * @param argAddress
     */
    public void setAddress(CawCustomerAddress argAddress) {

        address = argAddress;
    }

    /**
     * @return
     */
    public CawCustomerPrice getPricing() {

        return pricing;
    }

    /**
     * @param argPricing
     */
    public void setPricing(CawCustomerPrice argPricing) {

        pricing = argPricing;
    }

    /**
     * @return
     */
    public Long getAccountNumber() {

        return accountNumber;
    }

    /**
     * @param argAccountNumber
     */
    public void setAccountNumber(Long argAccountNumber) {

        accountNumber = argAccountNumber;
    }

    /**
     * @return
     */
    public Integer getAccountStatus() {

        return accountStatus;
    }

    /**
     * @param argAccountStatus
     */
    public void setAccountStatus(Integer argAccountStatus) {

        accountStatus = argAccountStatus;
    }

    /**
     * @return
     */
    public Integer getCustomerType() {

        return customerType;
    }

    /**
     * @param argCustomerType
     */
    public void setCustomerType(Integer argCustomerType) {

        customerType = argCustomerType;
    }

    /**
     * @return
     */
    public boolean isAllowEdit() {

        return allowEdit;
    }

    /**
     * @param argAllowEdit
     */
    public void setAllowEdit(boolean argAllowEdit) {

        allowEdit = argAllowEdit;
    }

    /**
     * @return
     */
    public String getEmailAddress() {

        return emailAddress;
    }

    /**
     * @param argEmailAddress
     */
    public void setEmailAddress(String argEmailAddress) {

        emailAddress = argEmailAddress;
    }

    /**
     * @return
     */
    public Integer getRvType() {

        return rvType;
    }

    /**
     * @param argRvType
     */
    public void setRvType(Integer argRvType) {

        rvType = argRvType;
    }

    /**
     * @return
     */
    public String getRvTypeDescription() {

        return rvTypeDescription;
    }

    /**
     * @param argRvTypeDescription
     */
    public void setRvTypeDescription(String argRvTypeDescription) {

        rvTypeDescription = argRvTypeDescription;
    }

    /**
     * @return
     */
    public Boolean getIsTaxExempt() {

        return isTaxExempt;
    }

    /**
     * @param argIsTaxExempt
     */
    public void setIsTaxExempt(Boolean argIsTaxExempt) {

        isTaxExempt = argIsTaxExempt;
    }

    /**
     * @return
     */
    public String getTaxCertificate() {

        return taxCertificate;
    }

    /**
     * @param argTaxCertificate
     */
    public void setTaxCertificate(String argTaxCertificate) {

        taxCertificate = argTaxCertificate;
    }

    /**
     * @return
     */
    public CawCustomerArInfo getArInfo() {

        return arInfo;
    }

    public void setArInfo(CawCustomerArInfo argArInfo) {

        arInfo = argArInfo;
    }

    public String getLastUpdateUser() {

        return lastUpdateUser;
    }

    public void setLastUpdateUser(String argLastUpdateUser) {

        lastUpdateUser = argLastUpdateUser;
    }

    public String getLastUpdateSystem() {

        return lastUpdateSystem;
    }

    public void setLastUpdateSystem(String argLastUpdateSystem) {

        lastUpdateSystem = argLastUpdateSystem;
    }

    public String getLastUpdateDate() {

        return lastUpdateDate;
    }

    public void setLastUpdateDate(String argLastUpdateDate) {

        lastUpdateDate = argLastUpdateDate;
    }

    public String getFeed() {

        return feed;
    }

    public void setFeed(String argFeed) {

        feed = argFeed;
    }

    public String getAttributes() {

        return attributes;
    }

    public void setAttributes(String argAttributes) {

        attributes = argAttributes;
    }

    /**
     * Returns
     * 
     * @return
     */
    public String getAccountStatusDescription() {

        return accountStatusDescription;
    }

    /**
     * Specifies
     * 
     * @param argAccountStatusDescription
     */
    public void setAccountStatusDescription(
            String argAccountStatusDescription) {

        accountStatusDescription = argAccountStatusDescription;
    }

    /**
     * Specifies
     * 
     * @param argCrud
     */
    public Integer getCrud() {

        return crud;
    }

    /**
     * Returns
     * 
     * @return
     */
    public void setCrud(Integer argCrud) {

        crud = argCrud;
    }

    /**
     * Specifies
     * 
     * @param argCrudDescription
     */
    public String getCrudDescription() {

        return crudDescription;
    }

    /**
     * Returns
     * 
     * @return
     */
    public void setCrudDescription(String argCrudDescription) {

        crudDescription = argCrudDescription;
    }

    /**
     * @return the memberships
     */
    public String getMemberships() {

        return memberships;
    }

    /**
     * @param argMemberships the memberships to set
     */
    public void setMemberships(String argMemberships) {

        memberships = argMemberships;
    }

    /**
     * @return the partners
     */
    public String getPartners() {

        return partners;
    }

    /**
     * @param argPartners the partners to set
     */
    public void setPartners(String argPartners) {

        partners = argPartners;
    }

    /**
     * @return the phones
     */
    public String getPhones() {

        return phones;
    }

    /**
     * @param argPhones the phones to set
     */
    public void setPhones(String argPhones) {

        phones = argPhones;
    }

    /**
     * @return the acxiomIdentifiers
     */
    public String getAcxiomIdentifiers() {

        return acxiomIdentifiers;
    }

    /**
     * @param argAcxiomIdentifiers the acxiomIdentifiers to set
     */
    public void setAcxiomIdentifiers(String argAcxiomIdentifiers) {

        acxiomIdentifiers = argAcxiomIdentifiers;
    }

}
