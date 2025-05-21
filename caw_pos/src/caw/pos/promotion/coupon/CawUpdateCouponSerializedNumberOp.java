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
 * BZ24323          141117    Serial_number should be captured info properly in datatabse when doing a transaction using Coupon.
 * BZ31793          250719    [INTERNAL] serializedCoupon field in OS log is returned same serial numbers for each Merchant Certificate coupon
 *===================================================================
 */

package caw.pos.promotion.coupon;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import caw.pos.common.CawValueKeys;
import caw.pos.pricing.discount.CawDiscountCouponHelper;
import twitter4j.JSONObject;
import dtv.data2.access.DataFactory;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trl.IRetailPriceModifier;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;

/**
 *
 */
public class CawUpdateCouponSerializedNumberOp extends Operation {

    private Map<String, List<JSONObject>> serialNumberActiveMaps  = null;

    private static final Logger           _logger                 = LogManager
            .getLogger(CawUpdateCouponSerializedNumberOp.class);
    
    @Inject
    private CawDiscountCouponHelper       _cawDiscountCouponHelper;          /* BZ31793 */

    /* (non-Javadoc)
     * @see dtv.pos.framework.op.Operation#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {

        Boolean isRun = Boolean.FALSE;
        serialNumberActiveMaps = _transactionScope
                .getValue(CawValueKeys.SERIAL_NUMBER_ACTIVE);
        if (serialNumberActiveMaps != null
                && serialNumberActiveMaps.size() > 0) {
            isRun = Boolean.TRUE;
        } else {
            serialNumberActiveMaps = null;
        }
        return isRun;
    }

    /* (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        IPosTransaction trans = _transactionScope.getTransaction();
        if (trans != null) {
            List<ISaleReturnLineItem> lineItems = trans
                    .getLineItems(ISaleReturnLineItem.class);
            if (lineItems != null) {
                String serialNumber = null;
                try {
                    for (ISaleReturnLineItem saleLineItem : lineItems) {
                        if (saleLineItem.getReturn()
                                || saleLineItem.getVoid()) {
                            continue;
                        }

                        if (saleLineItem.getRetailPriceModifiers().size() > 0) {
                            for (IRetailPriceModifier modifier : saleLineItem
                                    .getRetailPriceModifiers()) {
                                if (modifier.getVoid()) {
                                    continue;
                                }
                                /* BEGIN BZ31793 */
                                serialNumber = _cawDiscountCouponHelper
                                        .getSerialNumber(modifier.getDealId(), serialNumberActiveMaps);
                                /* END BZ31793 */
                                if (serialNumber != null) {
                                    modifier.setSerialNumber(serialNumber);
                                    DataFactory.makePersistent(modifier);
                                    serialNumber = null; // Clear data
                                }
                            }
                        }
                    }
                } catch (Exception ex) {
                    _logger.error("Can not update Serial Number."
                            + ex.getMessage());
                }
            }
        }

        return HELPER.completeResponse();
    }
    // BZ31793 move method getSerialNumber to CawDiscountCouponHelper
}
