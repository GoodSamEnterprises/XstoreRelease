/*    */ package dtv.xst.dao.hrs.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.util.ICodeInterface;
/*    */ import dtv.xst.dao.hrs.IWorkCodes;
/*    */ import dtv.xst.dao.hrs.IWorkCodesModel;
/*    */ import dtv.xst.dao.hrs.IWorkCodesProperty;
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
/*    */ public abstract class WorkCodesBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IWorkCodesProperty>
/*    */   implements IWorkCodes, IWorkCodesModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public int compareTo(ICodeInterface argOther) {
/* 26 */     return getSortOrder() - argOther.getSortOrder();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getCode() {
/* 32 */     return getWorkCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 38 */     return getDescription();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\WorkCodesBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */