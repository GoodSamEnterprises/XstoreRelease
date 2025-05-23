/*    */ package dtv.data2.replication.dtximpl.config;
/*    */ 
/*    */ import dtv.util.config.AbstractConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public class RelegationLevelConfig
/*    */   extends AbstractConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String TAG_FAILED_ATTEMPTS = "failedAttempts";
/*    */   private static final String TAG_RETRY_AFTER_CYCLES = "retryAfterCycles";
/*    */   private int failAttempts_;
/*    */   private int retryAfterCycles_;
/*    */   
/*    */   public int getFailAttempts() {
/* 27 */     return this.failAttempts_;
/*    */   }
/*    */   
/*    */   public int getRetryAfterCycles() {
/* 31 */     return this.retryAfterCycles_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 39 */     if ("failedAttempts".equalsIgnoreCase(argKey)) {
/* 40 */       this.failAttempts_ = ConfigUtils.toInt(argValue);
/*    */     }
/* 42 */     else if ("retryAfterCycles".equalsIgnoreCase(argKey)) {
/* 43 */       this.retryAfterCycles_ = ConfigUtils.toInt(argValue);
/*    */     } else {
/*    */       
/* 46 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setValue(String argValue) {}
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\config\RelegationLevelConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */