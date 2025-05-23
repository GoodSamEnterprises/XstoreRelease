/*    */ package dtv.pos.iframework.security;
/*    */ 
/*    */ import dtv.util.crypto.EncString;
/*    */ import dtv.xst.daocommon.ISystemUser;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IAuthenticationModule
/*    */ {
/*    */   ISystemUser authenticate();
/*    */   
/*    */   boolean authenticate(String paramString, EncString paramEncString);
/*    */   
/*    */   boolean isApplicable();
/*    */   
/*    */   void setSecurityCallback(ISecurityCallback paramISecurityCallback);
/*    */   
/*    */   public enum AuthenticationModuleType
/*    */   {
/* 63 */     STANDARD;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\IAuthenticationModule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */