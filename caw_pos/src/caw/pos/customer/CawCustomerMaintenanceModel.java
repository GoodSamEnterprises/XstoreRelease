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
 * BZ23745              061017    Club info is not displayed on Account tab when viewing a customer as activate GSAM
 * BZ26564              140618    [Internal] QAS search sent tag country incorrectly the address of customer which country is CAN
 * BZ26289              180718    New Requirement - Enable A/R Payment Functionality in Xstore
 * BZ27000              030818    [26289] House Account tab info displays incorrectly the A/R data retrieved from EBS Neuron or localDB.
 * BZ27339              031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ33598              231219    [Prod] QAS address match issues
 * BZ28036              100220    [New Requirement] Enable the base Functionality available for Customer Purchase History
 * BZ35198              240220    [Defect 33598 ] New Customer Maintenance screen for WHSL/CRW customer is not correct
 * BZ36405              030620    Issue with Credit Customer placed on credit hold
 * BZ48564              100222    [Loyalty] - Need to add new Rewards column on the existing Customer Maintenance Accounts Tab
 *===================================================================
 */

package caw.pos.customer;

import static dtv.pos.iframework.form.IEditModelFieldMetadata.ATTR_NEW;
import static dtv.pos.iframework.form.IEditModelFieldMetadata.ATTR_NO_SETTER;

import java.math.BigDecimal;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.araccount.CawCustomerUtil;
import caw.pos.customer.membership.CawCustomerMembershipView;
import caw.pos.customer.membership.CawMembershipHelper;

import dtv.data2.access.IDataModel;
import dtv.pos.customer.CustomerMaintenanceModel;
import dtv.pos.customer.IQualifiedAddress;
import dtv.pos.customer.account.HouseAccountHistoryListModel;
import dtv.pos.customer.model.AddressListModel;
import dtv.pos.customer.model.CustLoyaltyAwardListModel;
import dtv.pos.iframework.form.config.IDaoEditMappingConfig;
import dtv.xst.dao.cat.IAwardAccountCoupon;

public class CawCustomerMaintenanceModel extends CustomerMaintenanceModel {

    public static final String  CUST_ACCOUNT_LABEL                     = "custAccountLabel";

    private static final Logger _logger                                = LogManager
            .getLogger(CawCustomerMaintenanceModel.class);

    private String              custAccountLabel_                      = "_customerNumberLabel";

    public static final String  CUST_HC_TAX_EXEMPT_STATUS_FIELD        = "custTaxExemptStatus";

    private String              custTaxExemptStatus                    = "";

    public static final String  CUST_HC_AVAILABLE_CREDIT               = "customerHouseAccountAvailableCredit";

    private BigDecimal          customerHouseAccountAvailableCredit    = null;

    public static final String  CUST_HC_SETUP_DATE_FIELD               = "cawCustomerHouseAccountSetupDate";

    private Date                cawCustomerHouseAccountSetupDate       = null;

    private Date                cawCustomerHouseAccountLastPaymentDate = null;
    
    //BEGIN BZ48564
    private CustLoyaltyAwardListModel _loyaltyCouponsModel;
    private List<Object>         listItems_                            = new ArrayList<>();
    private int                  selectedCardIndex                     = 0;
    private List<CawCustomerMembershipView> custMemViews;
    //END BZ48564
    
    // BZ27000 end
    /* Begin BZ27339 */
    /**
     * Gets the loyalty badge icon.
     *
     * @return the loyalty badge icon
     */
    @Override
    public String getLoyaltyBadgeIcon() {

        return CawMembershipHelper.getInstance().getMembershipImage();
    }
    /* End BZ27339 */

    public CawCustomerMaintenanceModel(IDataModel[] argDaos,
            IDaoEditMappingConfig argConfig, Boolean argIsNew) {

        super(argDaos, argConfig, argIsNew);
        addField(CUST_ACCOUNT_LABEL, String.class);
        addField(CUST_HC_TAX_EXEMPT_STATUS_FIELD, String.class);// BZ26289
        // BZ27000 start
        addField(CUST_HC_AVAILABLE_CREDIT, BigDecimal.class, ATTR_NEW
                + ATTR_NO_SETTER);
        addField(CUST_HC_SETUP_DATE_FIELD, Date.class);
        // BZ27000 end
        /*BEGIN BZ33598: in case Crew/Whsl customer -> make below fields read only*/
        if (CawCustomerUtil.isLoadingCrewWhslModel()) {
            disableField("firstName");
            disableField("middleName");
            disableField("lastName");
            disableField("organizationName");
            disableField("organizationTypeCode"); /* BZ35198: Changed apartment to organizationTypeCode */
            disableField("telephone1");
            disableField("anniversaryDate");
            disableField("telephone2");
            disableField("birthDate");
            disableField("telephone3");
            disableField("gender");
            disableField("telephone1");
            disableField("telephone1");
            disableField("emailAddress");
            disableField("preferredLocale");
        }
        /*END BZ33598*/
    }

    /*BEGIN BZ33598 */
    /**
     * Disable field by name
     * @param fieldName
     */
    private void disableField(String fieldName) {
        getFieldDef(fieldName).setReadOnly(true);
    }
    /*END BZ33598*/

    @Override
    protected void initializeFieldValues() {

        super.initializeFieldValues();
        this.updateModelExtend();
    }

    /**
     * Update the model with fields/labels extended
     *
     *
     */
    public void updateModelExtend() {

        setValue(CUST_ACCOUNT_LABEL, custAccountLabel_);
        setValue(CUST_HC_TAX_EXEMPT_STATUS_FIELD, custTaxExemptStatus);
        setValue(CUST_HC_AVAILABLE_CREDIT, customerHouseAccountAvailableCredit);
        setValue(CUST_HC_SETUP_DATE_FIELD, cawCustomerHouseAccountSetupDate);
    }

    /**
     * Gets the Account's label 
     *
     * @return the name of Account's label
     */
    public String getCustAccountLabel() {

        return custAccountLabel_;
    }

    /**
     * Sets the the Account's Label
     *
     * @param argCustAccountLabel : the new label for Account
     */
    public void setCustAccountLabel(String argCustAccountLabel) {

        custAccountLabel_ = argCustAccountLabel;

    }

    /**
     * Update the value for Account's label
     *
     *
     */
    public void updateCustAccountLabel() {

        setValue(CUST_ACCOUNT_LABEL, custAccountLabel_);
    }

    /**
     * BZ26564 moved to
     * @return
     */
    public IQualifiedAddress getMainAddress() {
        IQualifiedAddress _mainAddress = null;//new TemporaryAddress();
        try {
            AddressListModel addressListModel = getCustomerAddressModel();
            if (addressListModel != null) {
                @SuppressWarnings("rawtypes")
                List addressList = addressListModel.getAddresses();
                if (addressList.size() > 0) {
                    Object ob = addressList.get(0);
                    if (ob instanceof IQualifiedAddress) {
                        _mainAddress = (IQualifiedAddress) ob;
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("getMainAddress-1: " + ex.getMessage());
        }
        return _mainAddress;
    }

    // BZ26289 start
    /**
     * @return the custTaxExemptStatus
     */
    public String getCustTaxExemptStatus() {
        return custTaxExemptStatus;
    }

    /**
     * @param taxExemptStatus the taxExemptStatus to set
     */
    public void setCustTaxExemptStatus(String taxExemptStatus) {
        custTaxExemptStatus = taxExemptStatus;
    }

    /*Begin BZ36405*/
    /* (non-Javadoc)
     * @see dtv.pos.customer.CustomerMaintenanceModel#setCustomerHouseAccountOnHoldFlag(java.lang.Boolean)
     */
    @Override
    public void setCustomerHouseAccountOnHoldFlag(Boolean argValue) {
        super.setCustomerHouseAccountOnHoldFlag(argValue);
    }

    /*End BZ36405*/
    // BZ26289 end
    // BZ27000 start
    /**
     * @return the customerHouseAccountAvailableCredit
     */
    public BigDecimal getCustomerHouseAccountAvailableCredit() {
        return customerHouseAccountAvailableCredit;
    }

    /**
     * @param argCustomerHouseAccountAvailableCredit the customerHouseAccountAvailableCredit to set
     */
    public void setCustomerHouseAccountAvailableCredit(
            BigDecimal argCustomerHouseAccountAvailableCredit) {
        customerHouseAccountAvailableCredit = argCustomerHouseAccountAvailableCredit;
    }

    /**
     * @return the cawCustomerHouseAccountSetupDate
     */
    public Date getCawCustomerHouseAccountSetupDate() {
        return cawCustomerHouseAccountSetupDate;
    }

    /**
     * @param argCawCustomerHouseAccountSetupDate the cawCustomerHouseAccountSetupDate to set
     */
    public void setCawCustomerHouseAccountSetupDate(
            Date argCawCustomerHouseAccountSetupDate) {
        cawCustomerHouseAccountSetupDate = argCawCustomerHouseAccountSetupDate;
    }

    /**
     * Gets the customer house account history list.
     *
     * @return the customer house account history list
     */
    @Override
    public HouseAccountHistoryListModel getCustomerHouseAccountHistoryList() {

        //Don't display all lines on HC grid
        return new HouseAccountHistoryListModel();
    }

    /**
     * BZ27000 required 
     * Gets the customer house account last payment date.
     *
     * @return the customer house account last payment date
     */
    @Override
    public Date getCustomerHouseAccountLastPaymentDate() {

        //BZ27000 required to override
        return getCawCustomerHouseAccountLastPaymentDate();
    }

    /**
     * @return the cawCustomerHouseAccountLastPaymentDate
     */
    public Date getCawCustomerHouseAccountLastPaymentDate() {

        return cawCustomerHouseAccountLastPaymentDate;
    }

    /**
     * @param argCawCustomerHouseAccountLastPaymentDate the cawCustomerHouseAccountLastPaymentDate to set
     */
    public void setCawCustomerHouseAccountLastPaymentDate(
            Date argCawCustomerHouseAccountLastPaymentDate) {

        cawCustomerHouseAccountLastPaymentDate = argCawCustomerHouseAccountLastPaymentDate;
        super.setCustomerHouseAccountLastPaymentDate(argCawCustomerHouseAccountLastPaymentDate);
    }
    // BZ27000 end
    
    //BEGIN BZ48564
    /**
     * @return the loyaltyCouponsModel
     */
    public CustLoyaltyAwardListModel getLoyaltyCouponsModel() {
    
        return _loyaltyCouponsModel;
    }

    
    /**
     * @param argLoyaltyCouponsModel the loyaltyCouponsModel to set
     */
    public void setLoyaltyCouponsModel(
            CustLoyaltyAwardListModel argLoyaltyCouponsModel) {
    
        _loyaltyCouponsModel = argLoyaltyCouponsModel;
    }

    @Override
    protected void init(boolean argArg0) {
        super.init(argArg0);

        this._loyaltyCouponsModel = new CustLoyaltyAwardListModel(this.getCustomer().getLoyaltyCards(), argArg0);
        this.custMemViews = CawMembershipHelper.getInstance().getMemberships();
        if (custMemViews != null) {
            CawCustomerMembershipView custSelect = custMemViews.get(0);
            List<IAwardAccountCoupon> listAward = custSelect.getCoupon(); 
            this.listItems_ = new ArrayList<>();
            
            if (listAward != null) {
                for(IAwardAccountCoupon coupon : listAward) {
                    this.listItems_.add(coupon);
                }
                this.getCustLoyaltyAwardListModel().getModel().setElements(listItems_);
            }
        }       
        
        
        this.getLoyaltyCardsModel().getSelectionModel().addListSelectionListener(argE -> {
            this.custMemViews = CawMembershipHelper.getInstance().getMemberships();
            if (custMemViews != null) {
                int sizeCust = custMemViews.size();
                this.listItems_ = new ArrayList<>();
                this.getCustLoyaltyAwardListModel().clearModel();  
                
                for (int selectedIndex = 0; selectedIndex < sizeCust; selectedIndex++) {
                    if (super.getLoyaltyCardsModel().getSelectionModel().isSelectedIndex(selectedIndex)) {
                        this.selectedCardIndex = selectedIndex;
                        break;
                    }
                }
                
                CawCustomerMembershipView custSelect = custMemViews.get(selectedCardIndex);
                List<IAwardAccountCoupon> listAward = custSelect.getCoupon();                
                if (listAward != null) {
                    for(IAwardAccountCoupon coupon : listAward) {
                        this.listItems_.add(coupon);
                    }
                    this.getCustLoyaltyAwardListModel().getModel().setElements(listItems_);
                }
                                       
                this.getCustLoyaltyAwardListModel().getModel().setElements(listItems_);
            }

         });
    }
    
    //END BZ48564
}
