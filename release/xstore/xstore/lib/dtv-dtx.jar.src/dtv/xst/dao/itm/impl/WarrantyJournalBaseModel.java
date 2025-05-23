/*    */ package dtv.xst.dao.itm.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.itm.IWarrantyJournal;
/*    */ import dtv.xst.dao.itm.IWarrantyJournalModel;
/*    */ import dtv.xst.dao.itm.IWarrantyJournalProperty;
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
/*    */ public abstract class WarrantyJournalBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IWarrantyJournalProperty>
/*    */   implements IWarrantyJournal, IWarrantyJournalModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public PosTransactionId getWarrantyIssueTransactionId() {
/* 27 */     PosTransactionId id = null;
/*    */     
/* 29 */     if (getWarrantyIssueDate() != null) {
/* 30 */       id = new PosTransactionId();
/* 31 */       id.setBusinessDate(getWarrantyIssueDate());
/* 32 */       id.setRetailLocationId(Long.valueOf(getWarrantyLineRtlLocId()));
/* 33 */       id.setWorkstationId(Long.valueOf(getWarrantyLineWkstnId()));
/* 34 */       id.setTransactionSequence(Long.valueOf(getWarrantyLineTransSeq()));
/*    */     } 
/*    */     
/* 37 */     return id;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyJournalBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */