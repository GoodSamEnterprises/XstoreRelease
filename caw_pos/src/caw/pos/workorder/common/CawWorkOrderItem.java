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
 * BZ27107          080818    [1.6.5][Internal] Item Quantity in S&I did not flow to Xstore for Work Order Transaction
 * BZ27192          150818    WO Obtain the item details (price, tax, description,...) and work order total from Neuron
 * BZ27286          210818    Work Order Deposit - Discount for Elite Customer not coming from S&I
 * BZ27712          121018    [New Requirement] Order Service is not sending item attributes for Work Orders
 * BZ29205          280119    [Port 29175 to release 3.0] Order Service is not sending properties for item 500 for WorkOrder which lookup from S&I when doing WO Deposit/Complete
 * BZ30154          190619    [New Requirement] Xstore capture the Work Order line items' sale associate from S&I and forward it to Order Service as part of item attribute
 * BZ31943          170719    [Port BZ31529 to 5.0]Xstore did not capture the coupon code for WO discount from S/I
 *===================================================================
 */

package caw.pos.workorder.common;

import java.math.BigDecimal;
import java.util.Map;

import twitter4j.JSONObject;

/**
 * Work Order Item.
 */
public class CawWorkOrderItem {

    private String                  itemId;

    private BigDecimal              quantity;

    private BigDecimal              unitSellingPrice;          //BZ27192

    private Map<String, BigDecimal> adjAmountList;             // BZ27286, BZ31943

    private boolean                 isNonPhysicalItemv = false;

    private String                  attributes;                //BZ27712

    private JSONObject              properties;                /*BZ29205*/

    private String                  salesPerson;               /*BZ30154*/
    
    /*BEGIN BZ30154*/
    /**
     * @return the salesPerson
     */
    public String getSalesPerson() {
    
        return salesPerson;
    }

    
    /**
     * @param argSalesPerson the salesPerson to set
     */
    public void setSalesPerson(String argSalesPerson) {
    
        salesPerson = argSalesPerson;
    }
    /*END BZ30154*/
    /**
     * 
     */
    public CawWorkOrderItem() {

        super();
    }

    /**
     * 
     */
    /* BEGIN BZ31943 */
    public CawWorkOrderItem(String argItemId, BigDecimal argQuantity,
            BigDecimal argUnitSellingPrice, Map<String, BigDecimal> argAdjAmount) {

        super();
        itemId = argItemId;
        quantity = argQuantity;
        unitSellingPrice = argUnitSellingPrice;
        adjAmountList = argAdjAmount;
    }
    /* END BZ31943 */
    /**
     * @return the itemId
     */
    public String getItemId() {

        return itemId;
    }

    /**
     * @param argItemId the itemId to set
     */
    public void setItemId(String argItemId) {

        itemId = argItemId;
    }

    /**
     * @return the quantity
     */
    public BigDecimal getQuantity() {

        return quantity;
    }

    /**
     * @param argQuantity the quantity to set
     */
    public void setQuantity(BigDecimal argQuantity) {

        quantity = argQuantity;
    }

    /**
     * @return the unitSellingPrice
     */
    public BigDecimal getUnitSellingPrice() {

        return unitSellingPrice;
    }

    /**
     * @param argUnitSellingPrice the unitSellingPrice to set
     */
    public void setUnitSellingPrice(BigDecimal argUnitSellingPrice) {

        unitSellingPrice = argUnitSellingPrice;
    }

    /* BEGIN BZ31943 */
    /**
     * @return the adjAmount
     */
    public Map<String, BigDecimal> getAdjAmount(){

        return adjAmountList;
    }

    /**
     * @param argAdjAmount the adjAmount to set
     */
    public void setAdjAmount(Map<String, BigDecimal> argAdjAmount) {

        adjAmountList = argAdjAmount;
    }
    /* END BZ31943 */
    
    /**
     * @return the isNonPhysicalItemv
     */
    public boolean isNonPhysicalItemv() {

        return isNonPhysicalItemv;
    }

    /**
     * @param argIsNonPhysicalItemv the isNonPhysicalItemv to set
     */
    public void setNonPhysicalItemv(boolean argIsNonPhysicalItemv) {

        isNonPhysicalItemv = argIsNonPhysicalItemv;
    }

    /**
     * @return the attribute
     */
    public String getAttributes() {

        return attributes;
    }

    /**
     * @param argAttribute the attribute to set
     */
    public void setAttributes(String argAttribute) {

        attributes = argAttribute;
    }

    /*BEGIN BZ29205*/
    /**
     * @return the property
     */
    public JSONObject getProperties() {

        return properties;
    }

    /**
     * @param argProperty the property to set
     */
    public void setProperties(JSONObject argProperty) {

        properties = argProperty;
    }
    /*END BZ29205*/
}
