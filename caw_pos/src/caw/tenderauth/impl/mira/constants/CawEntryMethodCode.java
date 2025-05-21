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
 *== ================================================================
 */

package caw.tenderauth.impl.mira.constants;

/**
 *
 */
public class CawEntryMethodCode {

    public static final String SWIPE                = "S";

    public static final String MANUAL               = "M";

    public static final String CHIP                 = "C";

    public static final String FALLBACK             = "T";

    public static final String CONTACTLESS          = "O";

    public static final String MAGSTRIP_CONTACTLESS = "P";

    public static final String KEYED                = "K";
}
