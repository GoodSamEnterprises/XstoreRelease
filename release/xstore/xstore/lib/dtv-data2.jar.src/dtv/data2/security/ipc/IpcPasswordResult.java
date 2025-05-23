/*    */ package dtv.data2.security.ipc;
/*    */ 
/*    */ import dtv.data2.access.AbstractQueryResult;
/*    */ import dtv.data2.access.IObjectId;
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
/*    */ public class IpcPasswordResult
/*    */   extends AbstractQueryResult
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String _password;
/*    */   
/*    */   public String getPassword() {
/* 23 */     return this._password;
/*    */   }
/*    */   
/*    */   public void setPassword(String argPassword) {
/* 27 */     this._password = argPassword;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IObjectId getObjectIdImpl() {
/* 33 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\security\ipc\IpcPasswordResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */