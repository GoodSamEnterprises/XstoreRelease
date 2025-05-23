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
/*    */ 
/*    */ public class PersistenceException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 742070005867398656L;
/*    */   
/*    */   public PersistenceException() {}
/*    */   
/*    */   public PersistenceException(String argMessage) {
/* 30 */     super(argMessage);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PersistenceException(String argMessage, Throwable argCause) {
/* 39 */     super(argMessage, argCause);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PersistenceException(Throwable argCause) {
/* 48 */     super(argCause.getMessage(), argCause);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\exception\PersistenceException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */