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
 * BZ44917          110921    [New Requirement] IDS Payment Integration with Xstore
 *===================================================================
 */

package caw.pos.tender.validation;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import caw.pos.register.rvpayment.CawRvPaymentHelper;

import dtv.i18n.IFormattable;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.iframework.validation.SimpleValidationResult;
import dtv.pos.register.type.LineItemType;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.validation.BeyondOverTenderLimitRule;
import dtv.pos.tender.validation.TenderAmountData;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 *
 */
public class CawBeyondOverTenderLimitRule extends BeyondOverTenderLimitRule {
    
    @Inject
    private TransactionScope _transactionScope;

    @Override
    protected IValidationResult validateNonChangeTender(
            TenderAmountData data) {
        
        IPosTransaction trans = _transactionScope.getTransaction();
        
        if (trans != null) {
            List<ISaleReturnLineItem> transLineItems = trans.getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
            
            if (CawRvPaymentHelper.isRvTransaction(transLineItems)) {
                ITenderLineItem tenderLine = getScopedValue(ValueKeys.CURRENT_TENDER_LINE);
                String usedTenderId = tenderLine.getTenderId();
                
                if (CawRvPaymentHelper.isCMATTenderOption(usedTenderId)) {
                    BigDecimal notRvAmoutRemain = CawRvPaymentHelper.getNotRvAmoutRemain(_transactionScope.getTransaction());
                    
                    if (notRvAmoutRemain.subtract(data.getEnteredAmount()).compareTo(BigDecimal.ZERO) < 0) {
                        
                        IFormattable[] format = new IFormattable[3];
                        
                        format[0] = this.FF.getLiteral(data.getEnteredAmount());
                        format[1] = this.FF.getLiteral(tenderLine.getTenderId());
                        format[2] = this.FF.getLiteral(notRvAmoutRemain);
                        
                        IFormattable errorMessage = this.FF.getTranslatable("_cawRvPaymentTenderOverAmountMsg", format);
                        
                        return SimpleValidationResult.getFailed(errorMessage);
                    }
                }
            }
        }
    
        
        
        return super.validateNonChangeTender(data);
    }
}
