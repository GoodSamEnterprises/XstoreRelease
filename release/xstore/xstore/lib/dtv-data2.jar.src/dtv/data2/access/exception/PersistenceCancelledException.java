/*    */ package dtv.data2.access.exception;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PersistenceCancelledException
/*    */   extends PersistenceException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public PersistenceCancelledException() {}
/*    */   
/*    */   public PersistenceCancelledException(String argMessage) {
/* 29 */     super(argMessage);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PersistenceCancelledException(String argMessage, Throwable argCause) {
/* 37 */     super(argMessage, argCause);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PersistenceCancelledException(Throwable argCause) {
/* 44 */     super(argCause);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\exception\PersistenceCancelledException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */