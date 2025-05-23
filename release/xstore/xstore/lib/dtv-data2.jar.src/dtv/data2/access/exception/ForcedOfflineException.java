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
/*    */ public final class ForcedOfflineException
/*    */   extends FailoverException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public static ForcedOfflineException getNewException(String argMessage, String argDataSourceName) {
/* 20 */     return new ForcedOfflineException(argMessage, argDataSourceName);
/*    */   }
/*    */   
/*    */   private ForcedOfflineException(String argMessage, String argDataSourceName) {
/* 24 */     super(argMessage, argDataSourceName);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\exception\ForcedOfflineException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */