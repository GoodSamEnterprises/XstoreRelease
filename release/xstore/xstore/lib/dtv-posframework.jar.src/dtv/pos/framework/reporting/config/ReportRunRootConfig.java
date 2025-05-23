/*    */ package dtv.pos.framework.reporting.config;
/*    */ 
/*    */ import dtv.pos.iframework.reporting.IReportRunRule;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReportRunRootConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 23 */   private List<ReportRunConfig> reportRunList_ = new ArrayList<>();
/* 24 */   private List<ReportGroupConfig> reportGroupList_ = new ArrayList<>();
/*    */   
/*    */   private Map<String, ReportRunConfig> reportRunMap_;
/*    */   private Map<String, ReportGroupConfig> reportGroupMap_;
/*    */   
/*    */   public ReportGroupConfig getReportGroup(String argName) throws ReportGroupNotFoundException {
/* 30 */     if (this.reportGroupMap_ == null) {
/* 31 */       this.reportGroupMap_ = new HashMap<>();
/* 32 */       for (int i = 0; i < this.reportGroupList_.size(); i++) {
/* 33 */         ReportGroupConfig c = this.reportGroupList_.get(i);
/* 34 */         this.reportGroupMap_.put(c.getName().toUpperCase(), c);
/*    */       } 
/* 36 */       this.reportGroupList_ = null;
/*    */     } 
/* 38 */     ReportGroupConfig found = this.reportGroupMap_.get(argName.toUpperCase());
/* 39 */     if (found == null) {
/* 40 */       throw new ReportGroupNotFoundException("no report group named " + argName);
/*    */     }
/* 42 */     return found;
/*    */   }
/*    */ 
/*    */   
/*    */   public ReportRunConfig getReportRun(String argName, List<IReportRunRule> argRunRules) throws ReportRunNotFoundException {
/* 47 */     if (this.reportRunMap_ == null) {
/* 48 */       this.reportRunMap_ = new HashMap<>();
/* 49 */       for (int i = 0; i < this.reportRunList_.size(); i++) {
/* 50 */         ReportRunConfig c = this.reportRunList_.get(i);
/* 51 */         this.reportRunMap_.put(c.getName().toUpperCase(), c);
/*    */       } 
/* 53 */       this.reportRunList_ = null;
/*    */     } 
/* 55 */     ReportRunConfig found = this.reportRunMap_.get(argName.toUpperCase());
/* 56 */     if (found == null) {
/* 57 */       throw new ReportRunNotFoundException("no report run named " + argName);
/*    */     }
/* 59 */     found.setAvailableRunRules(argRunRules);
/* 60 */     return found;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 65 */     if (argValue instanceof ReportRunConfig) {
/* 66 */       this.reportRunList_.add((ReportRunConfig)argValue);
/*    */     }
/* 68 */     else if (argValue instanceof ReportGroupConfig) {
/* 69 */       this.reportGroupList_.add((ReportGroupConfig)argValue);
/*    */     } else {
/*    */       
/* 72 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\config\ReportRunRootConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */