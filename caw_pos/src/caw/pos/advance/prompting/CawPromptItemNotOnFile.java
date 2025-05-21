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
 * BZ23646          021017    [prompting advance]The message 'you cannot sell item' should be displayed after pressing 'Y' on Item not on file screen
 *===================================================================
 */

package caw.pos.advance.prompting;

import dtv.pos.common.PromptKey;
import dtv.pos.framework.action.type.XstDataActionKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * Prompt message item not on file.
 */
public class CawPromptItemNotOnFile extends AbstractPromptOp {

    private static final PromptKey ITEM_NOT_ON_FILE_NOTIFY = PromptKey
            .valueOf("ITEM_NOT_ON_FILE_NOTIFY");

    @Override
    public PromptKey getDefaultPromptKey() {

        return ITEM_NOT_ON_FILE_NOTIFY;
    }

    @Override
    protected IOpResponse handleDataAction(IXstDataAction argEvent) {

        if (XstDataActionKey.YES.equals(argEvent.getActionKey())) {
            return HELPER.getErrorResponse(_formattables
                    .getSimpleFormattable("_promptmsg145"));
        } else {
            return super.handleDataAction(argEvent);
        }
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argParamIXstEvent) {

        return HELPER.completeResponse();
    }

}
