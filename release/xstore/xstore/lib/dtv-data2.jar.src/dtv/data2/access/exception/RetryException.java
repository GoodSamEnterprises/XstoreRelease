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
/*    */ public class RetryException
/*    */   extends SpecialActionException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 20 */   private static final ExceptionApplicableRule[] rules = new ExceptionApplicableRule[] { new ExceptionApplicableRule("rerun the transaction"), new ExceptionApplicableRule("all threads are blocked"), new ExceptionApplicableRule("ORA-00060") };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static RetryException getNewException(String argMessage, Throwable argCause, String argDataSourceName) {
/* 29 */     if (argCause instanceof RetryException) {
/* 30 */       return (RetryException)argCause;
/*    */     }
/*    */     
/* 33 */     return new RetryException(argMessage, argCause, argDataSourceName);
/*    */   }
/*    */   
/*    */   public static RetryException getNewException(Throwable argCause, String argDataSourceName) {
/* 37 */     if (argCause instanceof RetryException) {
/* 38 */       return (RetryException)argCause;
/*    */     }
/*    */     
/* 41 */     return new RetryException(argCause, argDataSourceName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isRetryException(Throwable ex) {
/* 51 */     return (new RetryException()).isApplicable(ex);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private RetryException() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private RetryException(String argMessage, Throwable argCause, String argDataSourceName) {
/* 63 */     super(argMessage, argCause, argDataSourceName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private RetryException(Throwable argCause, String argDataSourceName) {
/* 70 */     super(argCause, argDataSourceName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   ExceptionApplicableRule[] getApplicableRules() {
/* 77 */     return rules;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\exception\RetryException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */