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
 * BZ26847          170718    [1.6.0][25958] Reload/Issue Gift card info prints on receipt incorrectly
 *===================================================================
 */

package caw.pos.register.nonphysical;

import java.util.Locale;

import caw.pos.common.CawConstants;
import caw.pos.common.CawUtilFunction;

import dtv.pos.i18n.format.VoucherSerialNumberFormatter;

/**
 *
 */
public class CawVoucherSerialNumberFormatter
        extends VoucherSerialNumberFormatter {

    /* 
     * This Class is used to format card number based on First six and last four digits Gift card
     */
    @Override
    public String format(Object o, Locale argLocale) {

        return CawUtilFunction.formatSerialGCWithMask(o, CawConstants.STAR_SIGN);
    }

}
