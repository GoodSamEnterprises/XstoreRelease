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
 * BZ26289          110718    New Requirement - Enable A/R Payment Functionality in Xstore
 *===================================================================
 */

package caw.pos.register.ha.rcpt;

import caw.pos.araccount.CawCustomerUtil;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * The CawRcptHouseAccountPaymentCondition 
 */
public class CawRcptHouseAccountPaymentCondition
        extends AbstractInvertableCondition {

    @Override
    protected boolean conditionMetImpl(Object argSource) {

        if (argSource instanceof IPosTransaction) {
            IPosTransaction pos = (IPosTransaction) argSource;
            if (CawCustomerUtil.isHouseAccountPayment(pos)) {
                return true;
            }
        }
        return false;
    }

}
