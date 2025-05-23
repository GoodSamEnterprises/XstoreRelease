/*    */ package dtv.xst.dao.cat.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.cat.ICustomerItemAccountActivity;
/*    */ import dtv.xst.dao.cat.ICustomerItemAccountActivityModel;
/*    */ import dtv.xst.dao.cat.ICustomerItemAccountActivityProperty;
/*    */ import dtv.xst.dao.trn.PosTransactionId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CustomerItemAccountActivityBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<ICustomerItemAccountActivityProperty>
/*    */   implements ICustomerItemAccountActivity, ICustomerItemAccountActivityModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void copyTo(ICustomerItemAccountActivity argActivity) {
/* 27 */     argActivity.setAccountLineItemStateCode(getAccountLineItemStateCode());
/* 28 */     argActivity.setActivityCode(getActivityCode());
/* 29 */     argActivity.setActivityDateTime(getActivityDateTime());
/* 30 */     argActivity.setBusinessDate(getBusinessDate());
/* 31 */     argActivity.setCustAccountCode(getCustAccountCode());
/* 32 */     argActivity.setCustAccountDetailNum(getCustAccountDetailNum());
/* 33 */     argActivity.setCustAccountId(getCustAccountId());
/* 34 */     argActivity.setExtendedAmount(getExtendedAmount());
/* 35 */     argActivity.setNetAmount(getNetAmount());
/* 36 */     argActivity.setOrganizationId(getOrganizationId());
/* 37 */     argActivity.setQuantity(getQuantity());
/* 38 */     argActivity.setRetailLocationId(getRetailLocationId());
/* 39 */     argActivity.setScheduledPickupDate(getScheduledPickupDate());
/* 40 */     argActivity.setTransLineItemSeq(getTransLineItemSeq());
/* 41 */     argActivity.setTransSequence(getTransSequence());
/* 42 */     argActivity.setTypeCode(getTypeCode());
/* 43 */     argActivity.setUnitPrice(getUnitPrice());
/* 44 */     argActivity.setWorkstationId(getWorkstationId());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PosTransactionId createTransactionId() {
/* 50 */     PosTransactionId transId = new PosTransactionId();
/*    */     
/* 52 */     transId.setOrganizationId(Long.valueOf(getOrganizationId()));
/* 53 */     transId.setBusinessDate(getBusinessDate());
/* 54 */     transId.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 55 */     transId.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 56 */     transId.setTransactionSequence(Long.valueOf(getTransSequence()));
/*    */     
/* 58 */     return transId;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerItemAccountActivityBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */