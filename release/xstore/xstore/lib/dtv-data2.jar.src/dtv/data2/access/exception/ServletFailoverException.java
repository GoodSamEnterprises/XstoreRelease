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
/*    */ public class ServletFailoverException
/*    */   extends FailoverException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public static ServletFailoverException getNewException(String argMessage, String argDataSourceName) {
/* 23 */     return new ServletFailoverException(argMessage, argDataSourceName);
/*    */   }
/*    */   
/*    */   public static ServletFailoverException getNewException(Throwable argThrowable, String argDataSourceName) {
/* 27 */     return new ServletFailoverException(argThrowable, argDataSourceName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   ServletFailoverException(String argMessage, String argDataSourceName) {
/* 35 */     super(argMessage, argDataSourceName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   ServletFailoverException(Throwable argThrowable, String argDataSourceName) {
/* 43 */     super(argThrowable, argDataSourceName);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\exception\ServletFailoverException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */