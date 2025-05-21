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
 * BZ23506          021017    Xstore flashes 2 times in previous screen before going to Tender Options screen
 *===================================================================
 */

package caw.pos.register;

import dtv.pos.framework.op.PromptMenuOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * This is an extension of PromptMenuOp that prevents a request to show the transaction list along with the
 * requested menu prompt, with the intent being that this prompt will not display everything that is necessary for
 * tendering. Because in the customize code is using IBusyState that it will occur flash at Tender Options screen.
 *
 **/
public class CawPromptTenderMenuOp extends PromptMenuOp {

    /** {@inheritDoc} */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        IOpResponse response = super.handleOpExec(argEvent);
        /* Begin BZ23506 */
        /*IEditModel model = _modeProvider.get().getStationModel().getModel(ModelKeys.CURRENT_TRANSACTION);
        ShowFormRequest transListReq = new ShowFormRequest(FormKey.valueOf("TRANSACTION_LIST_PRIMARY"), model);
        response.insertOpRequest(transListReq);*/
        /* End BZ23506 */
        return response;
    }
}
