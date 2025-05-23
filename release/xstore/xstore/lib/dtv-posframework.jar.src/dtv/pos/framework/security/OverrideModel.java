/*    */ package dtv.pos.framework.security;
/*    */ 
/*    */ import dtv.logbuilder.model.IOverrideModel;
/*    */ import dtv.pos.iframework.security.ISecurityConstants;
/*    */ import dtv.xst.daocommon.ISystemUser;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
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
/*    */ public class OverrideModel
/*    */   extends AbstractSecurityLogModel
/*    */   implements IOverrideModel
/*    */ {
/*    */   public ISystemUser getOverridingUser() {
/* 30 */     return getScopedValue(ISecurityConstants.CURRENT_ADDITIONAL_SECURITY_USER);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<String> getPrivileges() {
/* 36 */     return Arrays.asList(getScopedValue(ISecurityConstants.CURRENT_PRIVILEGES));
/*    */   }
/*    */   
/*    */   public ISystemUser getTempSystemUser() {
/* 40 */     return this._stationState.getSystemUser();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\OverrideModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */