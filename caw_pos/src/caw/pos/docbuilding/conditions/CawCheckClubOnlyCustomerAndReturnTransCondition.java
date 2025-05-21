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
 * BZ48629          250222    [Task] Print Points Balances - Sale transaction
 *===================================================================
 */

package caw.pos.docbuilding.conditions;

import java.util.List;

import caw.pos.common.CawConstants;

import dtv.docbuilding.conditions.AbstractInvertableCondition;
import dtv.util.StringUtils;
import dtv.xst.dao.trl.*;

/**
 *
 */
public class CawCheckClubOnlyCustomerAndReturnTransCondition extends AbstractInvertableCondition {
    
    //BEGIN BZ48629
    @Override
    protected boolean conditionMetImpl(Object argSoure) {
        if (argSoure instanceof IRetailTransaction) {
            IRetailTransaction trans = (IRetailTransaction) argSoure;
            List<IRetailTransactionLineItem> transLine = trans.getSaleLineItems();
            for(IRetailTransactionLineItem retailLineItem : transLine) {
                if(retailLineItem instanceof ISaleReturnLineItem) {
                    ISaleReturnLineItem saleReturnLineItem = (ISaleReturnLineItem)retailLineItem;
                    if(!saleReturnLineItem.getReturn()) {
                       return false;
                    }
                }
            }

   
    }
        return true;
    //END BZ48629
    }
}

