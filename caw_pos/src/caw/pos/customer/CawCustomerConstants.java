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
 * BZ27339              031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ26893              291018    [New Requirement] - Xstore Transaction Receipt Changes
 * BZ28201              141118    [New Requirement] Additional Item Prompts and attributes for 500 item needs to print on transaction receipts.
 * BZ29409              220219    [Prod] CW is reporting that a Wholesale customer couldn't be found when attempting a third party tender
 * BZ30318              250619    [New Requirement] Drop leading characters from GS member card barcode scans
 * BZ31523              250619    [Port BZ30263 to 5.0]Display GSC member savings in transaction
 * BZ30259              120220    [New Requirement] Customer Specific Messages on Receipts
 * BZ44053              150621    [PROD] Membership Validation Issue - Cannot sell RENEW on active membership accounts
 * BZ45486              060821    [Prod] Issue With House and 3rd Party Payment 
 * BZ48567              100222    [Task] - Display Loyalty Information on the Membership Info tab
 *===================================================================
 */

package caw.pos.customer;

import java.util.regex.Pattern;

import dtv.pos.common.FormKey;
import dtv.pos.customer.account.type.CustomerAccountType;
import dtv.pos.framework.scope.ValueKey;

/**
 * Define all constants used for Customer package
 */
public class CawCustomerConstants {

    public static final String           CUSTOMER_SEARCH_V2          = "CUSTOMER_SEARCH_V2";

    public static final String           ADD_CUSTOMER_CHAIN          = "AddCustomerChain";

    public static final String           ORGANIZATION_NAME_FIELD     = "organizationName";

    public static final ValueKey<String> ACCOUNT_NUMBER              = new ValueKey<String>(String.class,
            "ACCOUNT_NUMBER");

    public static final ValueKey<String> LOCATION_CODE               = new ValueKey<String>(String.class,
            "LOCATION_CODE");

    public static final String           COUNTRY_FIELD               = "country";

    public static final String           BUTTON_CANCEL_QAS           = "CANCEL_QAS";

    public static final String           BUTTON_CHANGE_COUNTRY       = "CHANGE_COUNTRY";

    public static final String           BUTTON_ACCEPT               = "ACCEPT";

    public static final String           PRIMARY_ADDRESS             = "primaryAddress";

    public static final String           PRIMARY_ONLY                = "PrimaryOnly";

    // BZ23301
    public static final Pattern          VALID_EMAIL_ADDRESS_REGEX   = Pattern
            .compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    // BZ26289
    public static final String           CUST_ACCT_CODE              = CustomerAccountType.HOUSE_ACCOUNT.getCode();

    // BZ27339 Start
    public static final String           BUTTON_CLEAR                = "CLEAR";

    public static final String           BACK_OFFICE                 = "BACK_OFFICE";

    public static final FormKey          FORM_CUSTOMER_MEMBERSHIP    = FormKey.valueOf("CUSTOMER_MEMBERSHIP");

    public static final FormKey          FORM_CUSTOMER_HA_MEMBERSHIP = FormKey.valueOf("CUSTOMER_HA_MEMBERSHIP");

    /**
     * The CAW_CUSTOMER_GROUPS_LEVEL
     */
    public static final String           CAW_CUSTOMER_GROUPS_LEVEL   = "CAW_CUSTOMER_GROUPS_LEVEL";

    /**
     * The CAW_CUSTOMER_ELITE_LEVEL
     */
    public static final String           CAW_CUSTOMER_ELITE_LEVEL    = "Elite";

    /**
     *  CUSTOMER_GROUPS
     */
    public static final String           CUSTOMER_GROUPS             = "CUSTOMER_GROUPS";
    // BZ27339 end

    // BZ26893
    /**
     * The CAW_MEMBERSHIP_NAME
     */
    public static final String           CAW_MEMBERSHIP_NAME         = "CAW_MEMBERSHIP_NAME";

    /**
     * The CAW_MEMBERSHIP_STATUS
     */
    public static final String           CAW_MEMBERSHIP_STATUS       = "CAW_MEMBERSHIP_STATUS";
    //End BZ26893

    /**
     * The CAW_RECEIPT_ITEM_PROPERTIES
     */
    public static final String           CAW_RECEIPT_ITEM_PROPERTIES = "CAW_RECEIPT_ITEM_PROPERTIES";              // BZ28201

    public static final String           CAW_WHOLESALE_IDENTIFY      = "8192, 16384, 32768, 65536, 131072";        /*BZ44053, BZ45486*/                      //BZ29409, BZ-44053
    
    public static final String           LOYALTY_NUMBER_TRIM         = "73";                                       /*BZ30318*/

    public static final String           CAW_CREW_IDENTIFY           = "256, 512"; /*BZ31523, BZ44053, BZ45486*/

    /* BEGIN BZ30259 */
    public static final String           CAW_MEMBERSHIP_MESS         = "CAW_MEMBERSHIP_MESS";

    public static final String           MEMBERSHIPS_STATUS_EXPIRED  = "2";
    /* END BZ30259 */
    
    public static final String           CAW_SPLIT_STRING_COMMA      = "\\s*,\\s*";/*BZ45486*/
    
    public static final FormKey          FORM_CUSTOMER_MEMBERSHIP_CLUB = FormKey.valueOf("CUSTOMER_MEMBERSHIP_CLUB");/*BZ48567*/
}