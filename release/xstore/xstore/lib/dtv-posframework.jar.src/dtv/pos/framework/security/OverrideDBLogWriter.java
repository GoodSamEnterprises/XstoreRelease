/*    */ package dtv.pos.framework.security;
/*    */ 
/*    */ import dtv.pos.iframework.security.ISecurityLogModel;
/*    */ import dtv.xst.dao.hrs.IEmployee;
/*    */ import dtv.xst.dao.sec.ISecurityLog;
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
/*    */ public class OverrideDBLogWriter
/*    */   extends BasicDBLogWriter
/*    */ {
/*    */   protected ISecurityLog setCustomValues(ISecurityLogModel argLogModel, ISecurityLog argSecurityLog) {
/* 25 */     ISystemUser tempUser = argLogModel.getTempSystemUser();
/*    */     
/* 27 */     if (tempUser instanceof IEmployee) {
/* 28 */       IEmployee tempEmployee = (IEmployee)tempUser;
/* 29 */       argSecurityLog.setEmployeeId(tempEmployee.getEmployeeId());
/*    */     } 
/*    */     
/* 32 */     ISystemUser overrideUser = argLogModel.getOverridingUser();
/*    */     
/* 34 */     if (overrideUser instanceof IEmployee) {
/* 35 */       IEmployee overrideEmployee = (IEmployee)overrideUser;
/* 36 */       argSecurityLog.setOverridingEmployeeId(overrideEmployee.getEmployeeId());
/*    */     } 
/*    */     
/* 39 */     return super.setCustomValues(argLogModel, argSecurityLog);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\OverrideDBLogWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */