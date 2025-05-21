/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions [of the software code and associated documentation] 
 * developed for Camping World are proprietary and confidential 
 * to BTM Global. BTM Global has granted Camping World a perpetual, 
 * non-exclusive, non-sublicensable license to use [the software 
 * code and associated documentation] for its internal business 
 * operations only.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#      ddMMyy    Description
 * BZ26207          250718    New Requirement - Enable Work Order Functionality
 * BZ27117          080818    [OS] Should be handled account credit tender like Item deposit for WO complete transaction.
 *===================================================================
 */

package caw.orderservice.model;

/**
 *
 */
public class CawWorkOrderDetail {

    private String id;

    private String posStatus;

    //Begin BZ27117
    private String taxGroupId;

    private String itmCode;

    /**
     * @return the taxGroupId
     */
    public String getTaxGroupId() {

        return taxGroupId;
    }

    /**
     * @param taxGroupId the taxGroupId to set
     */
    public void setTaxGroupId(String taxGroupId) {

        this.taxGroupId = taxGroupId;
    }

    /**
     * @return the itmCode
     */
    public String getItmCode() {

        return itmCode;
    }

    /**
     * @param itmCode the itmCode to set
     */
    public void setItmCode(String itmCode) {

        this.itmCode = itmCode;
    }
    //End BZ27117
    /**
     * @return the id
     */
    public String getId() {

        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {

        this.id = id;
    }

    /**
     * @return the posStatus
     */
    public String getPosStatus() {

        return posStatus;
    }

    /**
     * @param posStatus the posStatus to set
     */
    public void setPosStatus(String posStatus) {

        this.posStatus = posStatus;
    }

}
