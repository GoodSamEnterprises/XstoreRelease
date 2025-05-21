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
 * BZ69391          020625    [AGIS Modification] - Update Pitches form to be able to add non-membership items (Section 2.1.4)
 * BZ69389          020625    [AGIS Modification] - Update UI to display membership item by group (Section 2.1.2)
 * BZ69390          020625    [AGIS Modification] - Update Last Chance Prompt to handle grouping (Section 2.1.3)
 *===================================================================
 */

package caw.pos.agis.model;

import caw.pos.common.CawConstants;

import dtv.util.ICodeInterface;

/**
 *
 */
public class CawAGISPitchesItemModel implements ICodeInterface{
    private String descriptions;
    private String itemCode;
    private int maxQuantity;
    private boolean isAutoRenew;
    private double planPrice;
    private String productReference;
    private String offerReference;
    private String planReference;
    private String distributionChannel;
    private String responseMethod;
    
    /**
     * @return the description
     */
    @Override
    public String getDescription() {
        if(itemCode.equals(CawConstants.CAW_MEMBERSHIP_OPTION_CODE)||
                itemCode.equals(CawConstants.CAW_NOTHANKS_OPTION_CODE) ) {
            return descriptions;
        }
        return descriptions + " - $" + String.valueOf(planPrice) ;
    }
    
    public String getDescriptions() {
        
        return descriptions;
    }
    
    /**
     * @param argDescription the description to set
     */
    public void setDescriptions(String argDescription) {
    
        descriptions = argDescription;
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
     * @return the maxQuantity
     */
    public int getMaxQuantity() {
    
        return maxQuantity;
    }
    
    /**
     * @param argMaxQuantity the maxQuantity to set
     */
    public void setMaxQuantity(int argMaxQuantity) {
    
        maxQuantity = argMaxQuantity;
    }
    
    /**
     * @return the isAutoRenew
     */
    public boolean isAutoRenew() {
    
        return isAutoRenew;
    }
    
    /**
     * @param argIsAutoRenew the isAutoRenew to set
     */
    public void setAutoRenew(boolean argIsAutoRenew) {
    
        isAutoRenew = argIsAutoRenew;
    }
    
    /**
     * @return the planPrice
     */
    public double getPlanPrice() {
    
        return planPrice;
    }
    
    /**
     * @param argPlanPrice the planPrice to set
     */
    public void setPlanPrice(double argPlanPrice) {
    
        planPrice = argPlanPrice;
    }
    
    /**
     * @return the productReference
     */
    public String getProductReference() {
    
        return productReference;
    }
    
    /**
     * @param argProductReference the productReference to set
     */
    public void setProductReference(String argProductReference) {
    
        productReference = argProductReference;
    }
    
    /**
     * @return the offerReference
     */
    public String getOfferReference() {
    
        return offerReference;
    }
    
    /**
     * @param argOfferReference the offerReference to set
     */
    public void setOfferReference(String argOfferReference) {
    
        offerReference = argOfferReference;
    }
    
    /**
     * @return the planReference
     */
    public String getPlanReference() {
    
        return planReference;
    }
    
    /**
     * @param argPlanReference the planReference to set
     */
    public void setPlanReference(String argPlanReference) {
    
        planReference = argPlanReference;
    }
    
    /**
     * @return the distributionChannel
     */
    public String getDistributionChannel() {
    
        return distributionChannel;
    }
    
    /**
     * @param argDistributionChannel the distributionChannel to set
     */
    public void setDistributionChannel(String argDistributionChannel) {
    
        distributionChannel = argDistributionChannel;
    }
    
    /**
     * @return the responseMethod
     */
    public String getResponseMethod() {
    
        return responseMethod;
    }
    
    /**
     * @param argResponseMethod the responseMethod to set
     */
    public void setResponseMethod(String argResponseMethod) {
    
        responseMethod = argResponseMethod;
    }

    /**
     * 
     */
    public CawAGISPitchesItemModel(String argDescription, String argItemCode,
            int argMaxQuantity, boolean argIsAutoRenew, double argPlanPrice,
            String argProductReference, String argOfferReference,
            String argPlanReference, String argDistributionChannel,
            String argResponseMethod) {
        super();
        descriptions = argDescription;
        itemCode = argItemCode;
        maxQuantity = argMaxQuantity;
        isAutoRenew = argIsAutoRenew;
        planPrice = argPlanPrice;
        productReference = argProductReference;
        offerReference = argOfferReference;
        planReference = argPlanReference;
        distributionChannel = argDistributionChannel;
        responseMethod = argResponseMethod;
    }

    /**
     * 
     */
    public CawAGISPitchesItemModel() {
        super();
    }

    /* (non-Javadoc)
     * @see dtv.util.ICode#getCode()
     */
    @Override
    public String getCode() {

        // @todo Auto-generated method stub
        return getItemCode();
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(ICodeInterface argO) {

        // @todo Auto-generated method stub
        return this.getSortOrder() - argO.getSortOrder();
    }

    /* (non-Javadoc)
     * @see dtv.util.ICodeInterface#getSortOrder()
     */
    @Override
    public int getSortOrder() {

        // @todo Auto-generated method stub
        return 0;
    }
    
    
}
