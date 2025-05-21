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
 * BZ23701              021017    Void Receipt is required for Credit, Debit Tender line Void.
 *===================================================================
 */

package caw.pos.common.rcpt;

import dtv.pos.docbuilding.conditions.VoidedLineCondition;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

public class CawVoidTenderLineCondition extends VoidedLineCondition {

    /**
     * 
     */
    private static final String VOIDING = "VOIDING";

    /** {@inheritDoc} */
    @Override
    protected boolean conditionMetImpl(Object argValue) {

        if (argValue instanceof ICreditDebitTenderLineItem) {
            ICreditDebitTenderLineItem lineItem = (ICreditDebitTenderLineItem) argValue;
            if (lineItem.getProperty(VOIDING) != null) {
                return true;
            }
        }
        return super.conditionMetImpl(argValue);
    }
}
