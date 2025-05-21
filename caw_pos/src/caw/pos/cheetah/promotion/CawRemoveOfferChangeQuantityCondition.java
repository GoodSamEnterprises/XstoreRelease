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
 * BZ53977          021222    [UAT] Xstore is discounting Loyalty offer more than maximum offer amount
 *===================================================================
 */

package caw.pos.cheetah.promotion;

import java.util.List;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.AbstractRunCondition;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.trl.IRetailPriceModifier;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawRemoveOfferChangeQuantityCondition extends AbstractRunCondition{

	//BEGIN BZ53977
    @Inject
    protected TransactionScope _transactionScope;
    
    @Override
    protected boolean shouldRunImpl() {
        boolean isPriceMod = false;
        ISaleReturnLineItem lineItem = null;
        if(this.getScopedValue(ValueKeys.CURRENT_SALE_LINE) != null) {
            lineItem = this.getScopedValue(ValueKeys.CURRENT_SALE_LINE);
            List<IRetailPriceModifier> retailPriceModifiers = lineItem.getRetailPriceModifiers();
            if(retailPriceModifiers != null && retailPriceModifiers.size() > 0) {
                for (IRetailPriceModifier priceModifier : retailPriceModifiers) {
                    if(priceModifier.getStringProperty("IS_PROMO") != null) {
                        isPriceMod = true;
                        break;
                    }
                }
            }
        }
        
        if(isPriceMod) {
            if(_transactionScope.getValue(CawValueKeys.CAW_PROMOTIONS_SELECTED) != null 
                    && _transactionScope.getValue(CawValueKeys.CAW_PROMOTIONS_SELECTED).size() > 0) {
                return true;
            }  
        }
        
        return false;
    }
    //END BZ53977
}
