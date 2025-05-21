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
 * BZ23147          070917    Implement Serialized coupon
 *===================================================================
 */

package caw.pos.promotion.reserve.request;

/**
 * Reserve Request template
 */
public class CawSerialReserveRequest {

    private String serialNumber;

    private String businessDate;

    private String register;

    private String store;

    private String transaction;

    /**
     * @return the serialNumber
     */
    public String getSerialNumber() {

        return serialNumber;
    }

    /**
     * @param argSerialNumber the serialNumber to set
     */
    public void setSerialNumber(String argSerialNumber) {

        serialNumber = argSerialNumber;
    }

    /**
     * @return the businessDate
     */
    public String getBusinessDate() {

        return businessDate;
    }

    /**
     * @param argBusinessDate the businessDate to set
     */
    public void setBusinessDate(String argBusinessDate) {

        businessDate = argBusinessDate;
    }

    /**
     * @return the register
     */
    public String getRegister() {

        return register;
    }

    /**
     * @param argRegister the register to set
     */
    public void setRegister(String argRegister) {

        register = argRegister;
    }

    /**
     * @return the store
     */
    public String getStore() {

        return store;
    }

    /**
     * @param argStore the store to set
     */
    public void setStore(String argStore) {

        store = argStore;
    }

    /**
     * @return the transaction
     */
    public String getTransaction() {

        return transaction;
    }

    /**
     * @param argTransaction the transaction to set
     */
    public void setTransaction(String argTransaction) {

        transaction = argTransaction;
    }
}
