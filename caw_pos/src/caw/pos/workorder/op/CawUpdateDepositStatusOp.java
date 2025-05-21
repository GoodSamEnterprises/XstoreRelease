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
 * BZ26207          190718    New Requirement - Enable Work Order Functionality
 * BZ27063          060818    [1.6.4] WO Xstore must NOT send the status call to reset the WO status
 *===================================================================
 */

package caw.pos.workorder.op;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawUpdateDepositStatusOp extends Operation {

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        /*String number = _transactionScope
                .getValue(CawValueKeys.CAW_WORK_ORDER_NUMBER);//wo448283-get
        
        if (number != null) {
            CawWorkOrderHelper.getInstance()
                    .sendUpdateStatusToEBS(_stationState, number, CawWorkOrderConstants.DEPOSIT);
        } else {
            _logger.error("WO work order number is null.");
        }*/ //BZ27063
        return HELPER.completeResponse();
    }

}
