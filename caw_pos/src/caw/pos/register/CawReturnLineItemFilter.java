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
 * BZ46111          111021    [UAT] Electric World Phase 1 Mixed Transaction Return Error
 *===================================================================
 */

package caw.pos.register;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.data2.access.IDataModel;
import dtv.data2x.impl.req.NoRecordsFoundException;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.framework.scope.ValueKey;
import dtv.pos.register.*;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.SaleItemType;
import dtv.xst.daocommon.ILineItemFilter;

/**
 *
 */
public class CawReturnLineItemFilter extends ReturnLineItemFilter {
    private static final Logger logger_ = LogManager.getLogger(CawReturnLineItemFilter.class);
    
    public static final ValueKey<Boolean> IS_NO_ORDER_IN_OB = new ValueKey<Boolean>(Boolean.class, "IS_NO_ORDER_IN_OB");
    
    private final ILineItemFilter _parentFilter;

    public CawReturnLineItemFilter(ILineItemFilter argParent) {
        super(argParent);
        
        if (argParent == null) {
           throw new NullPointerException();
          }
         _parentFilter = argParent;
    }

    public List<? extends IDataModel> filter(List<? extends IDataModel> argLines
            , TransactionScope transactionScope) {
        List<IDataModel> result = new ArrayList<>();
        
        List<? extends IDataModel> lines = _parentFilter.filter(argLines);
        
        for (IDataModel model : lines) {
            if (model instanceof ISaleReturnLineItem) {
                ISaleReturnLineItem saleLineItem = (ISaleReturnLineItem)model;
                
                if (!saleLineItem.getReturn() && !saleLineItem.getVoid()) {
                    String itemType = saleLineItem.getSaleReturnLineItemTypeCode();
                    IItemLocator itemLocator = ItemLocator.getLocator();
                    
                    if (SaleItemType.ORDER.matches(itemType)) {
                        List<IDataModel> singleOrderItemList = new ArrayList<>();
                        
                        singleOrderItemList.add(model);
                        
                        try {
                            List<? extends IDataModel> returnableOrder = itemLocator.getAvailableForReturnList(singleOrderItemList);
                            result.addAll(returnableOrder);
                        } catch (NoRecordsFoundException ex) {
                            transactionScope.setValue(CawReturnLineItemFilter.IS_NO_ORDER_IN_OB, true);
                            logger_.debug(ex.getMessage());
                        }
                    } else {
                        List<IDataModel> singleItemList = new ArrayList<>();
                        
                        singleItemList.add(model);
                        result.addAll(itemLocator.getAvailableForReturnList(singleItemList));
                    }
                }
            }
        }
        
         return result;
    }

}
