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

/**
 *
 */
public class CawCustomerArInfo {

    private Boolean isArCreditHold;

    private String  availableBalance;

    private String  lastPayment;

    /**
     * @return
     */
    public Boolean getIsArCreditHold() {

        return isArCreditHold;
    }

    /**
     * @param argIsArCreditHold
     */
    public void setIsArCreditHold(Boolean argIsArCreditHold) {

        isArCreditHold = argIsArCreditHold;
    }

    /**
     * @return
     */
    public String getAvailableBalance() {

        return availableBalance;
    }

    /**
     * @param argAvailableBalance
     */
    public void setAvailableBalance(String argAvailableBalance) {

        availableBalance = argAvailableBalance;
    }

    /**
     * @return
     */
    public String getLastPayment() {

        return lastPayment;
    }

    /**
     * @param argLastPayment
     */
    public void setLastPayment(String argLastPayment) {

        lastPayment = argLastPayment;
    }

}
