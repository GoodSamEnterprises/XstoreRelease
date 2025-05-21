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
 * BZ23637          280917    [Prompting Engine] - Changes required to keep the customer from being prompted multiple times for GSC membership
 * BZ26629          300718    [New Requirement] Add a prompt to capture discount code when the Retail Coupon discount reason is selected
 * BZ27010          080818    [PROD][1.5.0]Returned Merchandise Receipt is printing incorrectly for all reason codes
 * BZ27028          021018    [New Requirement] Move the configuration for Return Merchandise Receipt into the table
 * BZ27535          090519    [New Requirement] Tax Exempt Wholesale Customer status not recognized at different stores
 * BZ33615          311019    [Prod] Issue with tax being charged on tax exempt wholesale customer
 * BZ33595          151119    Scanner/Warranty prompt screen - scanner provides 1 successful beep but desire is to have triple error beep
 * BZ44528          130821    Electric World & Mobile POS Implementation (Phase 1)
 * BZ48564          100222    [Loyalty] - Need to add new Rewards column on the existing Customer Maintenance Accounts Tab
 * BZ69515          120225    Display Good Sam Visa Cardholder indicator Icon
 *===================================================================
 */

package caw.pos.common;

/**
 * Define constants or utility methods
 * to read properties from system.properties
 */
public class CawPropertyUtils {

    // Begin BZ23637
    public static final String  GOOD_SAM_CLUB                     = System
            .getProperty("caw.good.sam.club");

    public static final String  CUSTOMER_GROUP_TYPE_RETL_OLD_NAME = System
            .getProperty("caw.customer.group.type.retl.old.name");

    public static final String  CUSTOMER_GROUP_TYPE_RETL_NEW_NAME = System
            .getProperty("caw.customer.group.type.retl.new.name");

    public static final String  CUSTOMER_GROUP_TYPE_CLUB_OLD_NAME = System
            .getProperty("caw.customer.group.type.club.old.name");

    public static final String  CUSTOMER_GROUP_TYPE_CLUB_NEW_NAME = System
            .getProperty("caw.customer.group.type.club.new.name");

    public static final String  CUSTOMER_GROUP_TYPE_CREW_OLD_NAME = System
            .getProperty("caw.customer.group.type.crew.old.name");

    public static final String  CUSTOMER_GROUP_TYPE_CREW_NEW_NAME = System
            .getProperty("caw.customer.group.type.crew.new.name");

    public static final String  CUSTOMER_GROUP_TYPE_WHSL_OLD_NAME = System
            .getProperty("caw.customer.group.type.whsl.old.name");

    public static final String  CUSTOMER_GROUP_TYPE_WHSL_NEW_NAME = System
            .getProperty("caw.customer.group.type.whsl.new.name");
    //BEGIN BZ69515
    public static final String  CUSTOMER_GROUP_TYPE_GSVISA_NAME = "GSVISA";
    // End BZ23637, BZ69515

    private static final String KEY_EBS_ENABLE                    = "EBS_ENABLE";

    public static final boolean EBS_ENABLE                        = allowEBSConnect();

    /* BEGIN BZ27535 */
    public static final String  STORE_NUMBER                      = String
            .format("%04d", Integer.parseInt(System
                    .getProperty("dtv.location.storeNumber")));/*BZ33615*/

    public static final String  COUNTRY_ID                        = System.getProperty("dtv.location.CountryId");
    /* END BZ27535 */
    

    public static final int     CAW_BEEP_VALUE                    = Integer
            .parseInt(System.getProperty("caw.beep.value"));                                                     //BZ33595
    
    /* BEGIN BZ44528: phase 1 */
    public static final int   WONDERSIGN_CART_SEARCH_PAGE_SIZE    = Integer.parseInt(
            System.getProperty("caw.pos.wondersign.cart.search.page.size"));
    
    public static final boolean CAW_WONDERSIGN_SKIP_PRODUCT_AVAILABILITY_API      =  getSystemProperty("caw.pos.wondersign.skip.product.availability.api", false);
    
    public static final boolean CAW_WONDERSIGN_SKIP_ORDER_SUBMIT_API              =  getSystemProperty("caw.pos.wondersign.skip.order.submit.api", false);
    /* END BZ44528: phase 1 */
    
    /*BEGIN BZ46381*/
    public static final String  RV_PAYMENT_CUST_PREFIX                       = getSystemProperty("caw.rv.payment.barcode.cust.prefix", "IDSCU");

    public static final String  RV_PAYMENT_WO_PREFIX                         = getSystemProperty("caw.rv.payment.barcode.wo.prefix", "IDSWO");
    /*END BZ46381*/
    /**
     * See value in system.properties
     * @param key
     * @param vDefault
     * @return
     */
    public static String getSystemProperty(String key, String vDefault) {

        try {
            String value = System.getProperty(key);
            if (value != null && value.length() > 0) {
                return value;
            } else {
                return vDefault;
            }
        } catch (RuntimeException ex) {
            return vDefault;
        } catch (Exception ex) {
            return vDefault;
        }
    }

    /**
     * Get boolean value
     * @return
     */
    public static boolean getSystemProperty(String key, boolean vDefault) {

        try {
            String propValue = System.getProperty(key);
            if (propValue != null && propValue.length() > 0) {
                if (Boolean.parseBoolean(propValue.trim())) {//BZ44528
                    return true;
                }
            }
        } catch (RuntimeException ex) {
            return vDefault;
        } catch (Exception ex) {
            return vDefault;
        }
        return vDefault;
    }

    /**
     * Get int value
     * @return
     */
    public static int getSystemProperty(String key, int vDefault) {

        try {
            String propValue = System.getProperty(key);
            if (propValue != null && propValue.length() > 0) {
                Integer val = Integer.valueOf(propValue);
                return val.intValue();
            }
        } catch (RuntimeException ex) {
            return vDefault;
        } catch (Exception ex) {
            return vDefault;
        }
        return vDefault;
    }

    /**
     * Allow EBS Connection
     * @return
     */
    public static boolean allowEBSConnect() {

        return getSystemProperty(KEY_EBS_ENABLE, false);
    }

    /**
     * Get system properties in array
     * @param key
     * @return
     */
    public static String[] getSystemArray(String key) {

        String val = getSystemProperty(key, "");
        val = val.replace(" ", "");
        String[] list = val.split(",");
        return list;
    }
}
