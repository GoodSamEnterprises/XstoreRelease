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

/**
 *
 */
public class CawCustomerPrice {

    private Integer identifier         = CawEBSConstant.CUSTOMER_TEMPLATE_PRICE_IDENTIFIER;

    private String  band               = CawEBSConstant.CUSTOMER_TEMPLATE_PRICE_BAND;

    private String  description        = CawEBSConstant.CUSTOMER_TEMPLATE_PRICE_DESCRIPTION;

    private String  priceCompareBand   = CawEBSConstant.CUSTOMER_TEMPLATE_PRICE_COMPARE_BAND;

    private Integer priceCompareBandId = CawEBSConstant.CUSTOMER_TEMPLATE_PRICE_COMPARE_BAND_ID;

    private String  membership         = CawEBSConstant.CUSTOMER_TEMPLATE_PRICE_MEMBERSHIP;

    public Integer getIdentifier() {

        return identifier;
    }

    /**
     * @param argIdentifier
     */
    public void setIdentifier(Integer argIdentifier) {

        identifier = argIdentifier;
    }

    /**
     * @return
     */
    public String getBand() {

        return band;
    }

    /**
     * @param argBand
     */
    public void setBand(String argBand) {

        band = argBand;
    }

    /**
     * @return
     */
    public String getDescription() {

        return description;
    }

    /**
     * @param argDescription
     */
    public void setDescription(String argDescription) {

        description = argDescription;
    }

    /**
     * @return
     */
    public String getPriceCompareBand() {

        return priceCompareBand;
    }

    /**
     * @param argPriceCompareBand
     */
    public void setPriceCompareBand(String argPriceCompareBand) {

        priceCompareBand = argPriceCompareBand;
    }

    /**
     * @return
     */
    public Integer getPriceCompareBandId() {

        return priceCompareBandId;
    }

    /**
     * @param argPriceCompareBandId
     */
    public void setPriceCompareBandId(Integer argPriceCompareBandId) {

        priceCompareBandId = argPriceCompareBandId;
    }

    /**
     * @return the membership
     */
    public String getMembership() {

        return membership;
    }

    /**
     * @param argMembership the membership to set
     */
    public void setMembership(String argMembership) {

        membership = argMembership;
    }

}
