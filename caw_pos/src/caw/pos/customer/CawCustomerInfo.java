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
public class CawCustomerInfo {

    private String audit;

    private String prefix;

    private String first;

    private String middle;

    private String last;

    private String suffix;

    private String company;

    public String getAudit() {

        return audit;
    }

    /**
     * @param argAudit
     */
    public void setAudit(String argAudit) {

        audit = argAudit;
    }

    /**
     * @return
     */
    public String getPrefix() {

        return prefix;
    }

    /**
     * @param argPrefix
     */
    public void setPrefix(String argPrefix) {

        prefix = argPrefix;
    }

    /**
     * @return
     */
    public String getFirst() {

        return first;
    }

    /**
     * @param argFirst
     */
    public void setFirst(String argFirst) {

        first = argFirst;
    }

    /**
     * @return
     */
    public String getMiddle() {

        return middle;
    }

    /**
     * @param argMiddle
     */
    public void setMiddle(String argMiddle) {

        middle = argMiddle;
    }

    /**
     * @return
     */
    public String getLast() {

        return last;
    }

    /**
     * @param argLast
     */
    public void setLast(String argLast) {

        last = argLast;
    }

    /**
     * @return
     */
    public String getSuffix() {

        return suffix;
    }

    /**
     * @param argSuffix
     */
    public void setSuffix(String argSuffix) {

        suffix = argSuffix;
    }

    /**
     * @return
     */
    public String getCompany() {

        return company;
    }

    /**
     * @param argCompany
     */
    public void setCompany(String argCompany) {

        company = argCompany;
    }

}
