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
 * BZ61159          160124    [New Requirement] - Xstore AGIS Replacement 
 *===================================================================
 */

package caw.pos.agis.op;

import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawAGISPitchesCashAndCarryPromptOp extends AbstractPromptOp{
    private final String CAW_AGIS_PITCHES_CASH_AND_CARRY = "CAW_AGIS_PITCHES_CASH_AND_CARRY";
    
    @Override
    public PromptKey getDefaultPromptKey() {
        return  PromptKey.valueOf(CAW_AGIS_PITCHES_CASH_AND_CARRY);                
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argVar1) {
        return HELPER.completeResponse();
    }

}
