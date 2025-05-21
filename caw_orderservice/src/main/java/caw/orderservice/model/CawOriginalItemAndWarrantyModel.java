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
 *===================================================================
 */

package caw.orderservice.model;

import java.sql.Timestamp;

/**
 *
 */
public class CawOriginalItemAndWarrantyModel {

    private Timestamp bsnDate;

    private String    transLienItmSeq;

    private String    storeId;

    private String    regId;

    private String    tranNbr;

    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }
        return false;
    }

    /**
     * @return the transLienItmSeq
     */
    public String getTransLienItmSeq() {

        return transLienItmSeq;
    }

    /**
     * @param transLienItmSeq the transLienItmSeq to set
     */
    public void setTransLienItmSeq(String transLienItmSeq) {

        this.transLienItmSeq = transLienItmSeq;
    }

    /**
     * @return the bsnDate
     */
    public Timestamp getBsnDate() {

        return bsnDate;
    }

    /**
     * @param bsnDate the bsnDate to set
     */
    public void setBsnDate(Timestamp bsnDate) {

        this.bsnDate = bsnDate;
    }

    /**
     * @return the storeId
     */
    public String getStoreId() {

        return storeId;
    }

    /**
     * @param storeId the storeId to set
     */
    public void setStoreId(String storeId) {

        this.storeId = storeId;
    }

    /**
     * @return the regId
     */
    public String getRegId() {

        return regId;
    }

    /**
     * @param regId the regId to set
     */
    public void setRegId(String regId) {

        this.regId = regId;
    }

    /**
     * @return the tranNbr
     */
    public String getTranNbr() {

        return tranNbr;
    }

    /**
     * @param tranNbr the tranNbr to set
     */
    public void setTranNbr(String tranNbr) {

        this.tranNbr = tranNbr;
    }

}
