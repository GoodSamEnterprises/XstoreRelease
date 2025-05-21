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
 * BZ59418          181023    Free Tier Opt In Loyalty SKU customization
 *===================================================================
 */

package caw.pos.cheetah;

import java.util.List;

import caw.pos.common.CawValueKeys;

import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.type.LineItemType;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.ICodeValue;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawUpdateLoyaltyFlagForFreeGS extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argVar1) {
        List<ICodeValue> iSKUCodes = null;
        List<ISaleReturnLineItem> transLineItems = null;
        
        if (_transactionScope.getValue(CawValueKeys.CAW_GS_LOYALTY_ITEM_FREE_CODE_VALUE) != null 
                && _transactionScope.getValue(CawValueKeys.CAW_GS_LOYALTY_ITEM_FREE_CODE_VALUE).size() > 0) {
            iSKUCodes = _transactionScope.getValue(CawValueKeys.CAW_GS_LOYALTY_ITEM_FREE_CODE_VALUE);
        }
        transLineItems = _transactionScope.getTransaction().getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
        
        if (iSKUCodes == null || iSKUCodes.size() <= 0) {
            iSKUCodes = (List<ICodeValue>) CodeLocator.getCodeValues(ConfigurationMgr.getOrganizationId(), "CAW_GSL_FREE_SIGN_UP");
            _transactionScope.setValue(CawValueKeys.CAW_GS_LOYALTY_ITEM_FREE_CODE_VALUE, iSKUCodes);
        }
        
         if(transLineItems != null && transLineItems.size() > 0) {
            for (ISaleReturnLineItem transLineItem : transLineItems) {
                for (ICodeValue iSKUCode : iSKUCodes) {
                    if(iSKUCode.getCode() != null && !iSKUCode.getCode().isEmpty()
                            && !transLineItem.getVoid() && transLineItem.getItemId().equalsIgnoreCase(iSKUCode.getCode())) {
                        if (_transactionScope.getValue(CawValueKeys.IS_LOYALTY_CUSTOMER) != null) {
                            _transactionScope.setValue(CawValueKeys.CAW_IS_ORIGINAL_LOYALTY_CUSTOMER, _transactionScope.getValue(CawValueKeys.IS_LOYALTY_CUSTOMER));
                        }
                        
                        _transactionScope.setValue(CawValueKeys.IS_LOYALTY_CUSTOMER, true);
                        
                        _transactionScope.setValue(CawValueKeys.CAW_LOYALTY_FREE_TIER_SKU, transLineItem.getItemId());
                    } 
                }
            }
        }

        return HELPER.completeResponse();
    }
}
