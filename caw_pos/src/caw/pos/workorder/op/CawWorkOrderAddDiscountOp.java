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
 * BZ27286          210818    Work Order Deposit - Discount for Elite Customer not coming from S&I
 * BZ31943          170719    [Port BZ31529 to 5.0]Xstore did not capture the coupon code for WO discount from S/I
 *===================================================================
 */

package caw.pos.workorder.op;

import java.math.BigDecimal;
import java.util.Map;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;
import caw.pos.workorder.common.CawWorkOrderConstants;

import dtv.pos.common.ConfigurationMgr;
import dtv.pos.common.OpChainKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.pricing.discount.DiscountHelper;
import dtv.pos.spring.ValueKeys;
import dtv.util.NumberUtils;
import dtv.xst.dao.com.IReasonCode;
import dtv.xst.dao.com.impl.ReasonCodeModel;
import dtv.xst.dao.dsc.IDiscount;

/**
 *
 */
public class CawWorkOrderAddDiscountOp extends Operation {

    @Inject
    private DiscountHelper _discountHelper;

    /* Add discount from S&I into item
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argVar1) {

        Map<String, BigDecimal> discountList = getScopedValue(CawValueKeys.WO_LIST_DISCOUNT); /*BZ31943*/
        if (discountList.size() > 0) {
            for (Map.Entry<String, BigDecimal> entry : discountList.entrySet()) { /*BZ31943*/
                clearScopedValue(ValueKeys.CURRENT_DISCOUNT);
                clearScopedValue(ValueKeys.ENTERED_DISCOUNT_AMOUNT);
                clearScopedValue(ValueKeys.SELECTED_REASON_CODE); /*BZ31943*/
                if (NumberUtils.isPositive(entry.getValue())) { /*BZ31943*/
                    IDiscount discount = _discountHelper
                            .getDiscount(CawWorkOrderConstants.CAW_ITEM_AMT_PROMPT);
                    /* Begin BZ31943 simulate a reason code */
                    IReasonCode reasonCode = new ReasonCodeModel();
                    reasonCode.setOrganizationId(ConfigurationMgr.getOrganizationId());
                    reasonCode.setReasonTypeCode("DISCOUNT");
                    reasonCode.setReasonCode(entry.getKey());
                    /* End BZ31943 simulate a reason code */
                    setScopedValue(ValueKeys.SELECTED_REASON_CODE, reasonCode); /*BZ31943*/
                    setScopedValue(ValueKeys.CURRENT_DISCOUNT, discount);
                    /* BEGIN BZ31943 */
                    setScopedValue(ValueKeys.ENTERED_DISCOUNT_AMOUNT, entry.getValue());
                    discountList.remove(entry.getKey());
                    /* END BZ31943 */
                    return HELPER.getWaitStackChainResponse(OpChainKey
                            .valueOf("CAW_LINE_ITEM_DISCOUNT"));
                }
            }
        }
        return HELPER.completeResponse();
    }
}
