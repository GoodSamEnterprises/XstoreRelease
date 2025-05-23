/*    */ package dtv.logbuilder.config;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ public class LogFilesConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String MAIN_TAG = "LogFiles";
/* 25 */   private List<LogFileConfig> logFileList_ = new ArrayList<>();
/*    */ 
/*    */ 
/*    */   
/*    */   private Map<String, LogFileConfig> logFileMap_;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LogFileConfig getLogFile(String argFileId) {
/* 35 */     return getLogFiles().get(argFileId);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 47 */     if (argValue instanceof LogFileConfig) {
/* 48 */       this.logFileList_.add((LogFileConfig)argValue);
/*    */     } else {
/*    */       
/* 51 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */   
/*    */   private Map<String, LogFileConfig> getLogFiles() {
/* 56 */     if (this.logFileMap_ == null) {
/*    */       
/* 58 */       Map<String, LogFileConfig> newLogFileMap = new HashMap<>();
/* 59 */       for (int i = 0; i < this.logFileList_.size(); i++) {
/* 60 */         LogFileConfig c = this.logFileList_.get(i);
/* 61 */         newLogFileMap.put(c.getFileId(), c);
/*    */       } 
/*    */       
/* 64 */       if (this.logFileMap_ == null) {
/* 65 */         this.logFileMap_ = newLogFileMap;
/*    */       }
/*    */     } 
/* 68 */     return this.logFileMap_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\config\LogFilesConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */