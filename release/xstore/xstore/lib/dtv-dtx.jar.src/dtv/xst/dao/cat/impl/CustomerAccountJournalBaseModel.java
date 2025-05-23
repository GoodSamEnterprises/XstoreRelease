/*    */ package dtv.xst.dao.cat.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.cat.ICustomerAccountJournal;
/*    */ import dtv.xst.dao.cat.ICustomerAccountJournalModel;
/*    */ import dtv.xst.dao.cat.ICustomerAccountJournalProperty;
/*    */ import dtv.xst.dao.crm.IParty;
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
/*    */ public abstract class CustomerAccountJournalBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<ICustomerAccountJournalProperty>
/*    */   implements ICustomerAccountJournal, ICustomerAccountJournalModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void copyTo(ICustomerAccountJournal argJournal) {
/* 26 */     argJournal.setAccountBalance(getAccountBalance());
/* 27 */     argJournal.setCustAccountCode(getCustAccountCode());
/* 28 */     argJournal.setCustAccountId(getCustAccountId());
/* 29 */     argJournal.setCustIdentityTypeCode(getCustIdentityTypeCode());
/* 30 */     argJournal.setOrganizationId(getOrganizationId());
/* 31 */     argJournal.setPartyId(getPartyId());
/* 32 */     argJournal.setRetailLocationId(getRetailLocationId());
/* 33 */     argJournal.setTransBusinessDate(getTransBusinessDate());
/* 34 */     argJournal.setTransRetailLocationId(getTransRetailLocationId());
/* 35 */     argJournal.setTransSequence(getTransSequence());
/* 36 */     argJournal.setTransWorkstationId(getTransWorkstationId());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PosTransactionId createTransactionId() {
/* 42 */     PosTransactionId transId = new PosTransactionId();
/*    */     
/* 44 */     transId.setOrganizationId(Long.valueOf(getOrganizationId()));
/* 45 */     transId.setBusinessDate(getTransBusinessDate());
/* 46 */     transId.setRetailLocationId(Long.valueOf(getTransRetailLocationId()));
/* 47 */     transId.setWorkstationId(Long.valueOf(getTransWorkstationId()));
/* 48 */     transId.setTransactionSequence(Long.valueOf(getTransSequence()));
/*    */     
/* 50 */     return transId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IParty getParty() {
/* 56 */     return (getParentCustomerAccount() != null) ? getParentCustomerAccount().getParty() : null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountJournalBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */