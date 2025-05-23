/*    */ package dtv.pos.framework.security;
/*    */ 
/*    */ import dtv.pos.iframework.security.AccessType;
/*    */ import dtv.pos.iframework.security.IAcl;
/*    */ import dtv.pos.iframework.security.IAclEntry;
/*    */ import dtv.pos.iframework.security.ISecuredObjectID;
/*    */ import dtv.pos.iframework.visibilityrules.AccessLevel;
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
/*    */ class DefaultAcl
/*    */   implements IAcl
/*    */ {
/*    */   public void addAccessEntry(IAclEntry newAccessEntry) {
/* 25 */     throw new UnsupportedOperationException("Method addAccessEntry() not implemented.");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean authorize(ISystemUser argAuthTicket, AccessType argAccessType) {
/* 33 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IAccessLevel getAccessLevel(AccessType argAccessType, ISystemUser argUser) {
/* 44 */     return (IAccessLevel)AccessLevel.GRANTED_PRIVILEGED;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ISecuredObjectID getSecuredObjectID() {
/* 54 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isAuthenticationRequired() {
/* 64 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\DefaultAcl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */