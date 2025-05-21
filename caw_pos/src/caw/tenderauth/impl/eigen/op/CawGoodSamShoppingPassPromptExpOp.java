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
 * BZ23406          290917    Implement tender by "Create Good Sam Visa" card function
 * BZ23725          051017    [Payment] Missing shopping pass authorization information on the sale receipt
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawGoodSamShoppingPassPromptExpOp extends AbstractPromptOp {

    /*Begin BZ-23406*/
    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_SHOPPING_PASS_EXP");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        return HELPER.completeResponse();
    }

    @Override
    protected IOpResponse handlePromptEvent(IXstEvent argEvent) {

        String shoppingPassExp = (String) argEvent.getData();
        setScopedValue(CawValueKeys.SHOPPING_PASS_EXP, shoppingPassExp);
        setScopedValue(CawValueKeys.IS_SHOPPING_PASS_CREDIT, Boolean.TRUE); //BZ23725
        return super.handlePromptEvent(argEvent);
    }
    /*End BZ-23406*/

}
