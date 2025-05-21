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
 * BZ23381              190917    Can't print receipt when performing sale transaction with Credit Card tender
 * BZ29505              010319    [Internal] When tendering with a new GSV, card was declined with reason: INVALID EXP DATE301.
 * BZ29590              070319    [Internal] PLCC/CO-BRAND-Good Sam Visa should be displayed on receipt instead of Credit/Card when using authorized token tender of Credit application to tender.
 *== ================================================================
 */

package caw.tenderauth.impl.mira.constants;

/**
 *
 */
public class CawCardType {

    public static final String DEBIT      = "DEBIT_CARD";

    public static final String VISA       = "VISA";

    public static final String MASTERCARD = "MASTERCARD";

    public static final String MAESTRO    = "MAESTRO";

    public static final String AMEX       = "AMERICAN_EXPRESS";//BZ23381

    public static final String DISCOVER   = "DISCOVER";

    public static final String DINNER     = "DINERS_CLUB";     //BZ23438

    public static final String JCB        = "JCB";             //BZ23438

    public static final String SEARS      = "SEARS";

    public static final String GIFT_CARD  = "XPAY_GIFT_CARD";

    public static final String LOYALTY    = "LOYALTY";

    public static final String FAST_PAY   = "FAST_PAY";

    public static final String INCOMM     = "INCOMM";

    public static final String TCRS       = "TCRS";

    public static final String EBT        = "EBT";

    public static final String CASH_LINK  = "CASH_LINK";

    public static final String CHEQUE     = "CHEQUE";

    public static final String CMS        = "CMS";

    public static final String OTHER      = "OTHER";

    public static final String GSVISA     = "GSVISA";          /*BZ29505*/

    public static final String GSPLCC     = "GSPLCC";          /*BZ29590*/
}
