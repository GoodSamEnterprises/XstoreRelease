/*    */ package dtv.pos.framework.reporting.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
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
/*    */ public class ReportGroupConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private boolean enabled_ = true;
/*    */   private String name_;
/* 24 */   private List<String> reportList_ = new ArrayList<>();
/*    */   private String[] reports_;
/*    */   
/*    */   public String getName() {
/* 28 */     return this.name_;
/*    */   }
/*    */   
/*    */   public String[] getReports() {
/* 32 */     if (this.reports_ == null) {
/* 33 */       this.reports_ = this.reportList_.<String>toArray(new String[0]);
/* 34 */       this.reportList_ = null;
/*    */     } 
/* 36 */     return this.reports_;
/*    */   }
/*    */   
/*    */   public boolean isEnabled() {
/* 40 */     return this.enabled_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 45 */     if ("ReportRun".equalsIgnoreCase(argKey)) {
/* 46 */       this.reportList_.add(argValue.toString());
/*    */     }
/* 48 */     else if ("name".equalsIgnoreCase(argKey)) {
/* 49 */       this.name_ = argValue.toString();
/*    */     }
/* 51 */     else if ("enabled".equalsIgnoreCase(argKey)) {
/* 52 */       this.enabled_ = ConfigUtils.toBoolean(argValue);
/*    */     } else {
/*    */       
/* 55 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\config\ReportGroupConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */