/*    */ package dtv.pos.framework.process;
/*    */ 
/*    */ import java.io.File;
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
/*    */ public class ProcMonitorConfig
/*    */   implements IProcMonitorConfig
/*    */ {
/*    */   private String key_;
/*    */   private File outputFile_;
/*    */   private boolean appendOutputfile_;
/*    */   private boolean allowMultiple_;
/*    */   private boolean continueOnError_;
/*    */   private boolean waitForExit_;
/*    */   
/*    */   public boolean allowMultiple() {
/* 25 */     return this.allowMultiple_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean appendOutputfile() {
/* 30 */     return this.appendOutputfile_;
/*    */   }
/*    */   
/*    */   public boolean continueOnError() {
/* 34 */     return this.continueOnError_;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getKey() {
/* 39 */     return this.key_;
/*    */   }
/*    */ 
/*    */   
/*    */   public File getOutputFile() {
/* 44 */     return this.outputFile_;
/*    */   }
/*    */   
/*    */   public void setAllowMultiple(boolean newValue) {
/* 48 */     this.allowMultiple_ = newValue;
/*    */   }
/*    */   
/*    */   public void setAppendOutputfile(boolean newValue) {
/* 52 */     this.appendOutputfile_ = newValue;
/*    */   }
/*    */   
/*    */   public void setContinueOnError(boolean argContinueOnError) {
/* 56 */     this.continueOnError_ = argContinueOnError;
/*    */   }
/*    */   
/*    */   public void setKey(String newValue) {
/* 60 */     this.key_ = newValue;
/*    */   }
/*    */   
/*    */   public void setOutputFile(File newValue) {
/* 64 */     this.outputFile_ = newValue;
/*    */   }
/*    */   
/*    */   public void setWaitForExit(boolean newValue) {
/* 68 */     this.waitForExit_ = newValue;
/*    */   }
/*    */   
/*    */   public boolean waitForExit() {
/* 72 */     return this.waitForExit_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\process\ProcMonitorConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */