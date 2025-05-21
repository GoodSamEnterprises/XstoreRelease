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
 * BZ23164              100917    [DEV] Implement EMV Payment Integration
 * BZ29590              070319    [Internal] PLCC/CO-BRAND-Good Sam Visa should be displayed on receipt instead of Credit/Card when using authorized token tender of Credit application to tender.
 *== ================================================================
 */

package caw.tenderauth.impl.mira.constants;

/**
 *
 */
public class CawCardTypeCode {

    public static final String DEBIT      = "I";

    public static final String VISA       = "V";

    public static final String MASTERCARD = "M";

    public static final String MAESTRO    = "MS";

    public static final String AMEX1      = "AX";

    public static final String AMEX2      = "A";

    public static final String DISCOVER   = "D";

    public static final String DINNER     = "E";

    public static final String JCB        = "JB"; //BZ23438

    public static final String SEARS      = "SE";

    public static final String GIFT_CARD  = "G";

    public static final String LOYALTY    = "L";

    public static final String FAST_PAY   = "LP";

    public static final String INCOMM     = "IN";

    public static final String TCRS       = "F";

    public static final String EBT        = "B";

    public static final String CASH_LINK  = "K";

    public static final String CHEQUE     = "Q";

    public static final String CMS        = "S";

    public static final String OTHER      = "O";

    public static final String GSPLCC     = "PL"; /*BZ29590*/
}
