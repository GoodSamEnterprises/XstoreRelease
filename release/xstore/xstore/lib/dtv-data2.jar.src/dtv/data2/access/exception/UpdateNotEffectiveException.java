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
/*    */ public class UpdateNotEffectiveException
/*    */   extends SpecialActionException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public UpdateNotEffectiveException(String argMessage, String argDataSource) {
/* 24 */     super(argMessage, argDataSource);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   ExceptionApplicableRule[] getApplicableRules() {
/* 32 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\exception\UpdateNotEffectiveException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */