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
 *===================================================================
 */

package caw.pos.workorder.op;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.workorder.common.CawWorkOrderConstants;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.cwo.IWorkOrderAccount;
import dtv.xst.dao.cwo.IWorkOrderPriceCode;

/**
 *
 */
public class CawWorkOrderAddPriceCodeOp extends Operation {

    private static final Logger _logger = LogManager
            .getLogger(CawWorkOrderAddPriceCodeOp.class);

    @Inject
    private WorkOrderHelper     _workOrderHelper;

    /* Add price code to current work order account
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        try {
            IWorkOrderAccount account = _workOrderHelper
                    .getCurrentWorkOrderAccount();
            IWorkOrderPriceCode priceCode = _workOrderHelper
                    .getWorkOrderPriceCode(CawWorkOrderConstants.DEFAULT_PRICE_CODE);

            if (account != null && priceCode != null) {
                account.setWorkOrderAccountPriceCode(priceCode);
                _logger.debug("WO add price code to current work order.");
            } else {
                _logger.error("WO current work order or price code is null.");
            }
        } catch (RuntimeException ex) {
            _logger.error(ex);
        } catch (Exception ex) {
            _logger.error(ex);
        }
        return HELPER.completeResponse();
    }

}
