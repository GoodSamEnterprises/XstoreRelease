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
 * BZ23585              270917    Xstore stuck in a loop when authorization service is offline
 * BZ23917              111017    [Payments] Xstore is stuck "Waiting for sigcap input" 
 *                                even after customer cancels credit application on pin pad
 * BZ37305              260820    [New Requirement] Prompting Engine call before customer information gets displayed on the PinPad.      
 *===================================================================
 */

package caw.tenderauth.impl.mira.constants;

/**
 *
 */
public class CawMiraCommand {

    public static final String CAPTURE                = "01";

    public static final String VOID_CAPTURE           = "03";

    public static final String REFUND                 = "04";

    public static final String VOID_REFUND            = "06";

    public static final String AUTHORIZATION_BY_PHONE = "16";      //BZ23585

    public static final String ACTIVATE               = "21";

    public static final String DEACTIVATE             = "22";

    public static final String RELOAD                 = "24";

    public static final String RELOAD_VOID            = "35";

    public static final String REDEEM                 = "25";

    public static final String REDEEM_VOID            = "26";

    public static final String BALANCE_INQUIRY        = "28";

    public static final String DISPLAY_CUSTOMER_INFORMATION = "93";      /*BZ37305*/

    public static final String CASH_OUT               = "CASH_OUT";

}
