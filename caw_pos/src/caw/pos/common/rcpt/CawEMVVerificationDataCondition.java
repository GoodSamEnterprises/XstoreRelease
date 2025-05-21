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
 * BZ23558              270917    Receipts are missing EMV data
 *===================================================================
 */

package caw.pos.common.rcpt;

import caw.tenderauth.impl.eigen.constants.CawEigenConstants;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;

public class CawEMVVerificationDataCondition
        extends AbstractInvertableCondition {

    /** {@inheritDoc} */
    @Override
    protected boolean conditionMetImpl(Object argValue) {

        if (argValue instanceof ICreditDebitTenderLineItem) {
            ICreditDebitTenderLineItem lineItem = (ICreditDebitTenderLineItem) argValue;
            if (CawEigenConstants.MIRA_ENTRY_METHOD_CHIP
                    .equals(lineItem.getEntryMethodCode())) {
                return true;
            }
        }
        return false;
    }
}
