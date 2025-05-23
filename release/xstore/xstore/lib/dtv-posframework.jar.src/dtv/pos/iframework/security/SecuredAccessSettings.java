/*    */ package dtv.pos.iframework.security;
/*    */ 
/*    */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
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
/*    */ public class SecuredAccessSettings
/*    */ {
/*    */   private final IAccessLevel accessLevel;
/*    */   private final String privilegeType;
/*    */   
/*    */   public SecuredAccessSettings(IAccessLevel argLevel, String argType) {
/* 28 */     this.accessLevel = argLevel;
/* 29 */     this.privilegeType = argType;
/*    */   }
/*    */ 
/*    */   
/*    */   public IAccessLevel getAccessLevel() {
/* 34 */     return this.accessLevel;
/*    */   }
/*    */   
/*    */   public String getPrivilegeType() {
/* 38 */     return this.privilegeType;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\SecuredAccessSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */