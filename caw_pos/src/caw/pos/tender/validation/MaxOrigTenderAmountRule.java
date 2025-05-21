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
 * BZ61330          290124    Update tender options for Verified return, Unverified return, web orders and Tender Exchange
 * BZ63225          230424    Issue with refunds from Work Order Completes
 *===================================================================
 */

package caw.pos.tender.validation;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.araccount.CawPromptTenderAmtOp;
import caw.pos.common.CawConstants;
import caw.pos.tender.CawTenderConstants;
import caw.pos.workorder.op.CawWorkOrderOptionsOp;

import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.common.CommonHelper;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.register.returns.ReturnManager;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.validation.AbstractSecuredTenderRule;
import dtv.pos.tender.validation.TenderAmountData;
import dtv.util.Money;
import dtv.util.NumberUtils;
import dtv.util.config.IConfigObject;
import dtv.xst.dao.tnd.ITender;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.ttr.ITenderLineItem;
import dtv.xst.dao.ttr.impl.TenderLineItemModel;

/**
 *
 */
public class MaxOrigTenderAmountRule extends AbstractSecuredTenderRule {
    private static final Logger _logger = LogManager.getLogger(MaxOrigTenderAmountRule.class);
    @Inject
    protected TransactionScope _transactionScope;
    
    @Inject
    private CommonHelper _commonHelper;
    
    @Inject
    private ReturnManager       _returnMgr;
    
    String tenderType_;
    
    private boolean isModifyAmountPrompt = false;
    
    private static final String TENDER_AMOUNT_MODIFY = "TENDER_AMOUNT_MODIFY";
    
    @Override
    public void setParameter(String argName, IConfigObject argValue) {
        if ("tenderType".equalsIgnoreCase(argName)) {
            this.tenderType_ = argValue.toString();
        } else {
            super.setParameter(argName, argValue);
        }
    }
    
    public void setTenderType(String argTenderType) {
        if(TENDER_AMOUNT_MODIFY.equalsIgnoreCase(argTenderType)) {
            this.isModifyAmountPrompt = true;
        } else {
            this.tenderType_ = argTenderType;
        }
    }
    
    @Override
    protected IValidationResult validateNonChangeTender(TenderAmountData data) {
        try {
            IValidationResult result = IValidationResult.SUCCESS;
            ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
            if(CawWorkOrderOptionsOp.isDepositAction() || CawWorkOrderOptionsOp.isRefundAction()
                    || CawWorkOrderOptionsOp.isCompleteAction() || !tenderLine.getTenderStatusCode().equalsIgnoreCase(CawConstants.CAW_REFUND_CONSTANT)) {  //BZ63225
                return result;
            }
            BigDecimal enteredAmount = this._commonHelper.roundCurrency(data.getEnteredAmount());
            BigDecimal enteredAmountTotal = BigDecimal.ZERO;
            if(this.isModifyAmountPrompt) { //in case select modify tender amount in tender option
                switch(tenderLine.getTenderId()) {
                case CawTenderConstants.USD_CURRENCY:
                    this.tenderType_ = CawTenderConstants.USD_CURRENCY;
                    break;
                case CawTenderConstants.THIRD_PARTY_TENDER_ID:
                    this.tenderType_ = CawTenderConstants.THIRD_PARTY_TENDER_ID;
                    break;
                case CawTenderConstants.AR_ACCOUNT_TENDER_ID:
                    this.tenderType_ = CawTenderConstants.AR_ACCOUNT_TENDER_ID;
                    break;
                default:
                    return result;
                }
                enteredAmountTotal = enteredAmount.add(enteredAmountTotal(tenderType_).multiply(BigDecimal.valueOf(-1))).add(tenderLine.getAmount());
            } else {
                enteredAmountTotal = enteredAmount.add(enteredAmountTotal(tenderType_).multiply(BigDecimal.valueOf(-1)));
            }
            BigDecimal origTendered = new CawPromptTenderAmtOp().getMaxAmountForDefaultValue(tenderType_);
            if (NumberUtils.isGreaterThan(enteredAmountTotal, origTendered)) {
                ITender tender = tenderLine.getTender();
                Currency currency = Currency.getInstance(tender.getCurrencyId());
                Money moneyAmount = new Money(enteredAmountTotal, currency);
                Money moneyMax = new Money(origTendered, currency);
                IFormattable amount = this.FF.getSimpleFormattable(moneyAmount, FormatterType.MONEY);
                IFormattable max = this.FF.getSimpleFormattable(moneyMax, FormatterType.MONEY);
                IFormattable tenderName = this.FF.getLiteral(tender.getDescription());
                IFormattable errorMessage = this.FF.getTranslatable("_tenderAmountHigherThanAllowed",
                        new IFormattable[]{amount, max, tenderName});
                return SimpleValidationResult.getFailed(errorMessage);
            }
            return result;
            
        } catch(Exception ex) {
            _logger.error("Error occur at MaxOrigTenderAmountRule class: " + ex.getMessage());
        }
        return super.validateNonChangeTender(data);
    }

    /**
     * @return
     */
    private BigDecimal enteredAmountTotal(String tenderType) {
        BigDecimal result = BigDecimal.ZERO;
        List<IRetailTransactionLineItem> retailTransactionLineItems = _transactionScope.getTransaction().getTenderLineItems();
        for (IRetailTransactionLineItem transLineItem : retailTransactionLineItems) {
            if (transLineItem instanceof TenderLineItemModel && !transLineItem.getVoid()) {
                TenderLineItemModel origTenderLine = (TenderLineItemModel) transLineItem;
                if(origTenderLine.getTenderId().equalsIgnoreCase(tenderType)) {
                    result = result.add(origTenderLine.getAmount());
                }
            }
        }
        return result;
    }
}
