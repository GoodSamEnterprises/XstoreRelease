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
 * BZ37396          021020    Tax value calculation issue in Order transactions
 *===================================================================
 */

package caw.pos.order;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;
import twitter4j.JSONArray;
import twitter4j.JSONObject;

import dtv.pos.framework.op.Operation;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.order.OrderMgr;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.xom.IOrder;
/**
 *
 */
public class CawUpdateTaxViaTaxAPIOp extends Operation {

    @Inject
    private OrderMgr            _orderMgr;

    @Inject
    private TransactionScope    _transaction;

    private static final Logger _logger   = LogManager.getLogger(CawUpdateTaxViaTaxAPIOp.class);

    private static final String THE_ORDER = "theOrder";

    private static final String ITEMS     = "items";

    /** {@inheritDoc} */
    @Override
    public boolean isOperationApplicable() {
        return CawShippingRateHelper.getInstance().isNewDeliveryOrder(_orderMgr);
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        try {

            IPosTransaction iPosTransaction = _transaction.getTransaction();
            IOrder order = _orderMgr.getCurrentOrder();
            JSONObject jsonObjectResponse = getScopedValue(CawValueKeys.CAW_TAX_RESPONSE);

            if (iPosTransaction != null && jsonObjectResponse != null) {
                JSONObject theOrder = jsonObjectResponse.getJSONObject(THE_ORDER);
                JSONArray items = theOrder.getJSONArray(ITEMS);

                CawOrderHelper.getInstance().updateTaxModifier(items, order, iPosTransaction);
            }
        } catch (Exception ex) {
            _logger.info("[Exception happen when mapping Tax Response]: " + ex.getMessage());
        }

        return HELPER.completeResponse();
    }
}
