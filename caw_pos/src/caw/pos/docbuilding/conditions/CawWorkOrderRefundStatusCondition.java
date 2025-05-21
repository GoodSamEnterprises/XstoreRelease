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
 * BZ27163          140818    WO Email receipt shows the incorrect header for Work Order Deposit or Refund
 *===================================================================
 */

package caw.pos.docbuilding.conditions;

import caw.pos.workorder.op.CawWorkOrderOptionsOp;

import dtv.docbuilding.conditions.AbstractInvertableCondition;

/**
 *
 */
public class CawWorkOrderRefundStatusCondition
        extends AbstractInvertableCondition {

    /* (non-Javadoc)
     * @see dtv.docbuilding.conditions.AbstractInvertableCondition#conditionMetImpl(java.lang.Object)
     */
    @Override
    protected boolean conditionMetImpl(Object argVar1) {

        return CawWorkOrderOptionsOp.isRefundAction();
    }

}
