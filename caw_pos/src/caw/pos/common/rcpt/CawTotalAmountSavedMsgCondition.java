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
 * BZ23607          031017    CWS Receipts Requires Printing of Regular and Club Pricing for Items
 *===================================================================
 */

package caw.pos.common.rcpt;

import static dtv.pos.common.ConfigurationMgr.minYouSavedThresholdAmount;
import static dtv.pos.common.ConfigurationMgr.showYouSavedMessage;

import java.math.BigDecimal;

import dtv.pos.common.rcpt.TotalAmountSavedMsgCondition;
import dtv.util.NumberUtils;
import dtv.xst.dao.trl.IRetailTransaction;

/**
 * Checking the condition to show/hide the saved money message section
 */
public class CawTotalAmountSavedMsgCondition
        extends TotalAmountSavedMsgCondition {

    /** {@inheritDoc} */
    @Override
    public boolean conditionMetImpl(Object argSource) {

        if (!showYouSavedMessage()) {
            return false;
        }

        if (!(argSource instanceof IRetailTransaction)) {
            return false;
        }

        BigDecimal totalDiscount = new CawTotalAmountSavedWorker(
                (IRetailTransaction) argSource).call();
        BigDecimal minDiscountToDisplay = minYouSavedThresholdAmount();
        if (NumberUtils.isGreaterThan(minDiscountToDisplay, totalDiscount)
                || !NumberUtils.isPositive(totalDiscount)) {
            return false;
        }

        return true;
    }
}
