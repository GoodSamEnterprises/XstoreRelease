/*    */ package dtv.pos.framework.action.access;
/*    */ 
/*    */ import dtv.pos.common.PrivilegeType;
/*    */ import dtv.pos.framework.security.SecurityUtil;
/*    */ import dtv.pos.iframework.security.SecuredAccessSettings;
/*    */ import dtv.pos.iframework.security.StationState;
/*    */ import dtv.pos.iframework.visibilityrules.AccessLevel;
/*    */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*    */ import dtv.util.security.ISecured;
/*    */ import dtv.xst.daocommon.ISystemUser;
/*    */ import javax.inject.Inject;
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
/*    */ public abstract class AbstractPrivilegedVisibilityRule
/*    */   extends AbstractVisibilityRule
/*    */   implements ISecured
/*    */ {
/*    */   public static final String PARAM_PRIVILEGE = "privilege";
/*    */   @Inject
/*    */   protected SecurityUtil _securityUtil;
/*    */   @Inject
/*    */   private StationState _stationState;
/* 35 */   private PrivilegeType privilegeType_ = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public String getPrivilege() {
/* 40 */     return (this.privilegeType_ == null) ? null : this.privilegeType_.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, String argValue) {
/* 46 */     if ("privilege".equalsIgnoreCase(argName)) {
/* 47 */       this.privilegeType_ = PrivilegeType.valueOf(argValue.toString());
/*    */     } else {
/*    */       
/* 50 */       super.setParameter(argName, argValue);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setPrivilege(String argPrivilege) {
/* 55 */     this.privilegeType_ = PrivilegeType.valueOf(argPrivilege);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 61 */     return getClass().getName() + "[privilege=" + getPrivilege() + "]";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final IAccessLevel getCurrentAccessLevel() {
/* 69 */     if (getPrivilege() == null) {
/* 70 */       return (IAccessLevel)AccessLevel.DENIED;
/*    */     }
/*    */     
/* 73 */     SecuredAccessSettings settings = this._securityUtil.getSecuredAccessSettings(this._stationState.getSystemUser(), this);
/*    */ 
/*    */     
/* 76 */     if (settings == null) {
/* 77 */       return (IAccessLevel)AccessLevel.DENIED;
/*    */     }
/* 79 */     return settings.getAccessLevel();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final ISystemUser getCurrentSystemUser() {
/* 87 */     return this._stationState.getSystemUser();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final boolean isInvertable() {
/* 96 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\access\AbstractPrivilegedVisibilityRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */