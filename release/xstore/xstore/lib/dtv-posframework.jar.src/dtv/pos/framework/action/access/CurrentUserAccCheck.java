/*    */ package dtv.pos.framework.action.access;
/*    */ 
/*    */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
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
/*    */ public class CurrentUserAccCheck
/*    */   extends AbstractPrivilegedVisibilityRule
/*    */ {
/* 19 */   private ISystemUser cachedUser = null;
/* 20 */   private IAccessLevel cachedAccessLevel = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected IAccessLevel checkVisibilityImpl() {
/* 30 */     ISystemUser user = getCurrentSystemUser();
/*    */     
/* 32 */     if (user == this.cachedUser) {
/* 33 */       return this.cachedAccessLevel;
/*    */     }
/*    */     
/* 36 */     IAccessLevel access = getCurrentAccessLevel();
/*    */     
/* 38 */     cache(user, access);
/*    */     
/* 40 */     return access;
/*    */   }
/*    */   
/*    */   protected void cache(ISystemUser argUser, IAccessLevel argAccessLevel) {
/* 44 */     this.cachedUser = argUser;
/* 45 */     this.cachedAccessLevel = argAccessLevel;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\access\CurrentUserAccCheck.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */