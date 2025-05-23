/*    */ package dtv.xst.daocommon;
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
/*    */ public enum EmployeeStatus
/*    */ {
/* 15 */   ACTIVE("A"), TERMINATED("T"), INACTIVE("I");
/*    */   
/*    */   private String _statusCode;
/*    */ 
/*    */   
/*    */   EmployeeStatus(String argCode) {
/* 21 */     this._statusCode = argCode;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getShortCode() {
/* 30 */     return this._statusCode;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\daocommon\EmployeeStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */