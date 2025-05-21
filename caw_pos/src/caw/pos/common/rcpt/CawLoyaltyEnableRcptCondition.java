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
 * BZ54776          120123    Bug 54776 : [Patch 22.0] Extend ability to turn ON/OFF loyalty functionality into xstore to specific stores if needed.
 *===================================================================
 */

package caw.pos.common.rcpt;

import caw.pos.cheetah.util.CawCheetahHelper;

import dtv.docbuilding.conditions.AbstractInvertableCondition;

public class CawLoyaltyEnableRcptCondition extends AbstractInvertableCondition {

    @Override
    protected boolean conditionMetImpl(Object argArg) {

        if (CawCheetahHelper.isEnableLoyalty()) {
            return true;
        }
        
        return false;
    }

}
