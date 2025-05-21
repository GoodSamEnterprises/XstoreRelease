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
 *===================================================================
 */

package caw.pos.register.rvpayment;

import java.math.BigDecimal;

import dtv.pos.framework.form.BasicEditModel;

/**
 *
 */
public class CawRvPaymentModel extends BasicEditModel {

    private String     rvServiceCustomer;

    private String     rvServiceWo;

    private String     rvFistName;

    private String     rvLastName;

    private String     rvPostalCode;

    private String     locationCode;

    private String     salesChannelId;

    private BigDecimal rvAmount;

    private String     itemCode;
    
    private String     rvDescription;

    private String     properties;

    private BigDecimal rvQty;

    CawRvPaymentModel(String title, String message) {
        super(FF.getTranslatable(title), FF.getTranslatable(message));
        setFields();

    }

    CawRvPaymentModel() {
        setFields();
    }

    private void setFields() {

        addField("rvServiceCustomer", String.class);
        addField("rvServiceWo", String.class);
        addField("rvFistName", String.class);
        addField("rvLastName", String.class);
        addField("rvPostalCode", String.class);
        addField("locationCode", String.class);
        addField("salesChannelId", String.class);
        addField("rvAmount", BigDecimal.class);
    }

    /**
     * @return the rvServiceCustomer
     */
    public String getRvServiceCustomer() {

        return rvServiceCustomer;
    }

    /**
     * @param argRvServiceCustomer the rvServiceCustomer to set
     */
    public void setRvServiceCustomer(String argRvServiceCustomer) {

        rvServiceCustomer = argRvServiceCustomer;
    }

    /**
     * @return the rvServiceWo
     */
    public String getRvServiceWo() {

        return rvServiceWo;
    }

    /**
     * @param argRvServiceWo the rvServiceWo to set
     */
    public void setRvServiceWo(String argRvServiceWo) {

        rvServiceWo = argRvServiceWo;
    }

    /**
     * @return the rvFistName
     */
    public String getRvFistName() {

        return rvFistName;
    }

    /**
     * @param argRvFistName the rvFistName to set
     */
    public void setRvFistName(String argRvFistName) {

        rvFistName = argRvFistName;
    }

    /**
     * @return the rvLastName
     */
    public String getRvLastName() {

        return rvLastName;
    }

    /**
     * @param argRvLastName the rvLastName to set
     */
    public void setRvLastName(String argRvLastName) {

        rvLastName = argRvLastName;
    }

    /**
     * @return the rvPostalCode
     */
    public String getRvPostalCode() {

        return rvPostalCode;
    }

    /**
     * @param argRvPostalCode the rvPostalCode to set
     */
    public void setRvPostalCode(String argRvPostalCode) {

        rvPostalCode = argRvPostalCode;
    }

    /**
     * @return the locationCode
     */
    public String getLocationCode() {

        return locationCode;
    }

    /**
     * @param argLocationCode the locationCode to set
     */
    public void setLocationCode(String argLocationCode) {

        locationCode = argLocationCode;
    }

    /**
     * @return the salesChannelId
     */
    public String getSalesChannelId() {

        return salesChannelId;
    }

    /**
     * @param argSalesChannelId the salesChannelId to set
     */
    public void setSalesChannelId(String argSalesChannelId) {

        salesChannelId = argSalesChannelId;
    }

    /**
     * @return the rvAmount
     */
    public BigDecimal getRvAmount() {

        return rvAmount;
    }

    /**
     * @param argRvAmount the rvAmount to set
     */
    public void setRvAmount(BigDecimal argRvAmount) {

        rvAmount = argRvAmount;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {

        return itemCode;
    }

    /**
     * @param argItemCode the itemCode to set
     */
    public void setItemCode(String argItemCode) {

        itemCode = argItemCode;
    }

    /**
     * @return the properties
     */
    public String getProperties() {

        return properties;
    }

    /**
     * @param argProperties the properties to set
     */
    public void setProperties(String argProperties) {

        properties = argProperties;
    }

    /**
     * @return the rvQty
     */
    public BigDecimal getRvQty() {

        return rvQty;
    }

    /**
     * @param argRvQty the rvQty to set
     */
    public void setRvQty(BigDecimal argRvQty) {

        rvQty = argRvQty;
    }

    
    /**
     * @return the rvDescription
     */
    public String getRvDescription() {
    
        return rvDescription;
    }

    
    /**
     * @param argRvDescription the rvDescription to set
     */
    public void setRvDescription(String argRvDescription) {
    
        rvDescription = argRvDescription;
    }
    
}
