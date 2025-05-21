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
 * BZ26629          300718    [New Requirement] Add a prompt to capture discount code when the Retail Coupon discount reason is selected
 * BZ27028          021018    [New Requirement] Move the configuration for Return Merchandise Receipt into the table
 *===================================================================
 */

package caw.pos.pricing.discount;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;

import dtv.i18n.IFormattable;
import dtv.pos.common.PromptKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.pricing.discount.PromptDiscountReasonOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.com.IReasonCode;

/**
 * The CawPromptDiscountReasonOp is customize the current Discount Reason in Xstore as new requirement of Camping Word.
 * When the user select the discount reason on GUI, System will take the reason code then check the reason code have exist system.properties.
 * If the reason is exist in configuration, System going to display ENTER_COUPON_CODE screen. It is allow the User enter coupon code.
 * The coupon code will save to table TRL_RTL_PRICE_MOD.NOTES. 
 * 
 * Note: When the transaction completed, the system have execute CawSaveCouponCodeOp class to Persistent the coupon code to TRL_RTRAINS_LINEITM_P table.
 */
public class CawPromptDiscountReasonOp extends PromptDiscountReasonOp {

    private static final Logger     _logger = LogManager
            .getLogger(CawPromptDiscountReasonOp.class);

    @Inject
    private CawDiscountCouponHelper _cawDiscountCouponHelper;

    public CawPromptDiscountReasonOp() {

        super();
    }

    /**
     * The method is check the coupon exist in configuration, the CAW_ENTER_COUPON_CODE will display.
     */
    @Override
    protected PromptKey getCommentPromptKey() {

        IReasonCode iReasonCode = this
                .getScopedValue(ValueKeys.SELECTED_REASON_CODE);
        if (iReasonCode != null) {
            /* BZ27028 added, removed code of BZ26629 */
            // Check reason code have existed in configuration
            boolean isShowEnterCouponCode = _cawDiscountCouponHelper
                    .isEnableReasonCode(CawConstants.DISCOUNT_REASON_TYPE_CODE, iReasonCode
                            .getReasonCode());
            if (isShowEnterCouponCode) {
                return PromptKey.valueOf("CAW_ENTER_COUPON_CODE");
            }
        }
        // System will call base workflow if the reason code does not exist in configuration
        return super.getCommentPromptKey();
    }

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        try {
            IReasonCode iReasonCode = this
                    .getScopedValue(ValueKeys.SELECTED_REASON_CODE);
            if (iReasonCode != null) {
                /* BZ27028 added, removed code of BZ26629 */
                boolean isShowEnterCouponCode = _cawDiscountCouponHelper
                        .isEnableReasonCode(CawConstants.DISCOUNT_REASON_TYPE_CODE, iReasonCode
                                .getReasonCode());
                if (isShowEnterCouponCode) {
                    return processEnterCouponDiscount(argEvent);
                }
            }

        } catch (Exception ex) {
            _logger.debug("Can not process Enter Coupon Discount."
                    + ex.getMessage());
        }

        return super.handleOpExec(argEvent);
    }

    /**
     * @param argEvent
     * @param state
     * @return
     */
    private IOpResponse processEnterCouponDiscount(IXstEvent argEvent) {

        IOpState state = this.getOpState();
        if (state == this.COMMENT_PROMPT) {
            IReasonCode reason = this
                    .getScopedValue(ValueKeys.SELECTED_REASON_CODE);

            String comment = argEvent != null ? argEvent.getStringData() : null;
            if (StringUtils.isEmpty(comment)
                    && this.isCommentRequired(reason)) {
                this.setOpState(this.COMMENT_REQUIRED_PROMPT);
                return this.HELPER
                        .getPromptResponse(VALIDATION_ERROR_MESSAGE, new IFormattable[] { this._ff
                                .getLiteral("_entryIsRequired") });
            } else if (!validCommment(comment)) {// Display error info when the user enter the coupon code invalid
                this.setOpState(this.COMMENT_REQUIRED_PROMPT);
                return this.HELPER
                        .getPromptResponse(VALIDATION_ERROR_MESSAGE, new IFormattable[] { this._ff
                                .getLiteral("_validatemessage60") });
            } else {
                this.setComment(comment);

                if (reason.getCustomerMessage() != null) {
                    this.setOpState(this.NOTIFY_PROMPT);
                    return this.HELPER
                            .getPromptResponse(REASON_CUSTOMER_MESSAGE, new IFormattable[] { this._ff
                                    .getLiteral(reason.getCustomerMessage()) });
                } else {
                    return this.HELPER.completeResponse();
                }
            }
        } else if (state == this.COMMENT_REQUIRED_PROMPT) {
            this.setOpState(this.COMMENT_PROMPT);

            return this.getPromptResponse(argEvent, this
                    .getDefaultPromptKey(), this.getPromptArgs(argEvent));
        } else {
            return state == this.NOTIFY_PROMPT ? this.HELPER.completeResponse()
                    : super.handleOpExec(argEvent);
        }
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        return super.handlePromptResponse(argEvent);
    }

    /**
     * 
     */
    @Override
    protected boolean isCommentRequired(IReasonCode iReasonCode) {

        if (iReasonCode != null) {
            /* BZ27028 added, removed code of BZ26629 */
            boolean isShowEnterCouponCode = _cawDiscountCouponHelper
                    .isEnableReasonCode(CawConstants.DISCOUNT_REASON_TYPE_CODE, iReasonCode
                            .getReasonCode());
            if (isShowEnterCouponCode) {
                return isShowEnterCouponCode;
            }
        }

        return super.isCommentRequired(iReasonCode);
    }

    /**
     * The method validation the coupon code enter by user.
     * The coupon code need to length between 4 to 6 character  
     * @param comment
     * @return
     */
    private boolean validCommment(String comment) {

        boolean isValid = true;
        if (StringUtils.isNotEmpty(comment)) {
            if (comment.length() < 4) {
                isValid = false;
            } else if (comment.length() > 6) {
                isValid = false;
            }
        }

        return isValid;

    }

}
