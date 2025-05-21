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
 * BZ46743          050122    Vehicle Identification Number (VIN) Capture for Xstore
 *===================================================================
 */

package caw.pos.register.returns;

import org.apache.commons.lang3.BooleanUtils;

import caw.pos.common.CawValueKeys;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.ItemPropertyPromptOp;

/**
 *
 */
public class CawReturnItemPropertyPromptOp extends ItemPropertyPromptOp {

    /* BEGIN BZ46743 */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {
        
        if (BooleanUtils.isTrue(_transactionScope.getValue(CawValueKeys.IS_GO_THROUGH_ITEM_PROPERTY_PROMPT_CHAIN))) {
            _transactionScope.clearValue(CawValueKeys.IS_GO_THROUGH_ITEM_PROPERTY_PROMPT_CHAIN);
            return handleNextProperty(argEvent);
        }
        
        return super.handleOpExec(argEvent);
    }
    
    @Override
    protected IOpResponse handleNextProperty(IXstEvent argEvent) {
    
        _transactionScope.clearValue(CawValueKeys.IS_GO_THROUGH_ITEM_PROPERTY_PROMPT_CHAIN);
        
        return super.handleNextProperty(argEvent);
    }
    /* END BZ46743 */
    
}
