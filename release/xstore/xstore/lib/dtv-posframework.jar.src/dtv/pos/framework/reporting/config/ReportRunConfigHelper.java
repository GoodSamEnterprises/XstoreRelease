/*    */ package dtv.pos.framework.reporting.config;
/*    */ 
/*    */ import dtv.pos.iframework.reporting.IReportRunRule;
/*    */ import dtv.util.config.ConfigHelper;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.List;
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
/*    */ public class ReportRunConfigHelper
/*    */   extends ConfigHelper<ReportRunRootConfig>
/*    */ {
/*    */   @Inject
/*    */   private List<IReportRunRule> _runRules;
/*    */   
/*    */   public ReportGroupConfig getReportGroup(String argName) throws ReportGroupNotFoundException {
/* 29 */     return ((ReportRunRootConfig)getRootConfig()).getReportGroup(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReportRunConfig getReportRun(String argReportName) throws ReportRunNotFoundException {
/* 35 */     return ((ReportRunRootConfig)getRootConfig()).getReportRun(argReportName, this._runRules);
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 40 */     return "ReportRunConfig";
/*    */   }
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String dtype, String argSourceDescription) {
/* 45 */     if ("Root".equalsIgnoreCase(dtype)) {
/* 46 */       return (IConfigObject)new ReportRunRootConfig();
/*    */     }
/* 48 */     if ("ReportGroup".equalsIgnoreCase(dtype)) {
/* 49 */       return (IConfigObject)new ReportGroupConfig();
/*    */     }
/* 51 */     if ("ReportRun".equalsIgnoreCase(dtype)) {
/* 52 */       return (IConfigObject)new ReportRunConfig();
/*    */     }
/* 54 */     if ("Action".equalsIgnoreCase(dtype)) {
/* 55 */       return (IConfigObject)new ReportActionConfig();
/*    */     }
/* 57 */     return super.getConfigObject(argTagName, dtype, argSourceDescription);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\config\ReportRunConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */