/*    */ package dtv.data2.access.transaction;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DataSourceTransactionException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public DataSourceTransactionException(String argDescription) {
/* 17 */     super(argDescription);
/*    */   }
/*    */   
/*    */   public DataSourceTransactionException(String argDescription, Throwable argCause) {
/* 21 */     super(argDescription, argCause);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\transaction\DataSourceTransactionException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */