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
 * BZ63225          230424    Issue with refunds from Work Order Completes
 *===================================================================
 */

package caw.pos.register.returns;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import caw.pos.common.CawValueKeys;
import caw.pos.ejournal.CawTransactionSearchHelper;

import dtv.data2.access.pm.PersistenceManagerType;
import dtv.pos.common.TransactionHelper;
import dtv.pos.register.returns.*;
import dtv.pos.register.type.LineItemType;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.dao.trn.PosTransactionId;

/**
 *
 */
public class CawUpdateVoidVerifiedReturnItemOp extends UpdateVoidVerifiedReturnItemOp {
    
    @Inject
    private ReturnManager _returnMgr;
    @Inject
    private CawTransactionSearchHelper transHelper;
    @Override
    protected void updateOrigTransList(IPosTransaction argOrigTrans, IPosTransaction argCurTrans) {
        List<IRetailTransaction> origTrans = this._returnMgr.getAllOrigTransaction();
    
        List<ISaleReturnLineItem> curSaleItems = argCurTrans.getLineItemsByTypeCode(LineItemType.ITEM.getName(), ISaleReturnLineItem.class);
    
        int foundCount = 0;
        for (ISaleReturnLineItem saleItem : curSaleItems) {
          if (!saleItem.getVoid() && saleItem.getReturn() && ReturnType.VERIFIED.matches(saleItem.getReturnTypeCode())) {
            IRetailTransaction iRetailTransaction = TransactionHelper.searchExistingOriginalReturnTransaction(saleItem.getOriginalBusinessDate(), saleItem
                .getOriginalTransactionSequence(), saleItem.getOriginalRetailLocationId(), saleItem
                .getOriginalWorkstationId(), origTrans);
    
            if (iRetailTransaction.getObjectId().equals(argOrigTrans.getObjectId()))
              foundCount++; 
          } 
        } 
        if (foundCount == 0) {
            Map<PosTransactionId, PosTransactionId> woDepositTransMaping = _transactionScope.getValue(CawValueKeys.CAW_WO_DEPOSIT_TRANSACTION_MAPPING);
            for(int i = 0; i < this._returnMgr.getAllOrigTransaction().size(); i++) {
                IPosTransaction woCompleteTrans = this._returnMgr.getAllOrigTransaction().get(i);
                if(argOrigTrans.getRetailLocationId() == woCompleteTrans.getRetailLocationId()
                        && argOrigTrans.getWorkstationId() == woCompleteTrans.getWorkstationId()
                        && argOrigTrans.getTransactionSequence() == woCompleteTrans.getTransactionSequence()
                        && argOrigTrans.getBusinessDate().equals(woCompleteTrans.getBusinessDate())) {
                    
                    PosTransactionId woCompleteTransId = new PosTransactionId();
                    woCompleteTransId.setOrganizationId(woCompleteTrans.getOrganizationId());
                    woCompleteTransId.setRetailLocationId(Long.valueOf(woCompleteTrans.getRetailLocationId()));
                    woCompleteTransId.setWorkstationId(Long.valueOf(woCompleteTrans.getWorkstationId()));
                    woCompleteTransId.setTransactionSequence(woCompleteTrans.getTransactionSequence());
                    woCompleteTransId.setBusinessDate(woCompleteTrans.getBusinessDate());
                    
                    if(woDepositTransMaping != null && woDepositTransMaping.containsKey(woCompleteTransId) ) {
                        IPosTransaction woDepositTrans = transHelper.getTransaction(woDepositTransMaping.get(woCompleteTransId), PersistenceManagerType
                                .forName("XCENTER_STANDARD"));
                        for(int j = 0; j < this._returnMgr.getAllOrigTransaction().size(); j++) {
                            IPosTransaction tmpTrans = this._returnMgr.getAllOrigTransaction().get(j);
                            if(tmpTrans.getRetailLocationId() == woDepositTrans.getRetailLocationId()
                                    && tmpTrans.getWorkstationId() == woDepositTrans.getWorkstationId()
                                    && tmpTrans.getTransactionSequence() == woDepositTrans.getTransactionSequence()
                                    && tmpTrans.getBusinessDate().equals(woDepositTrans.getBusinessDate())) {
                                this._returnMgr.getAllOrigTransaction().remove(j);
                                woDepositTransMaping.remove(woCompleteTransId);
                                break;
                            }
                        }
                    }
                }
            }
            _transactionScope.getValue(CawValueKeys.CAW_WO_DEPOSIT_TRANSACTION_MAPPING);
            this._returnMgr.getAllOrigTransaction().remove(argOrigTrans); 
        }
      }
}
