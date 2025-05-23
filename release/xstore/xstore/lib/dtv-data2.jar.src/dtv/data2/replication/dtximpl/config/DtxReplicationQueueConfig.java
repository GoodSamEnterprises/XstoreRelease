/*     */ package dtv.data2.replication.dtximpl.config;
/*     */ 
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DtxReplicationQueueConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final int DEFAULT_CYCLE_INTERVAL = 10000;
/*     */   private static final int DEFAULT_MAX_RECRORDS = 50;
/*     */   private static final int DEFAULT_FAILURE_COUNT_RESET_INTERVAL = 600000;
/*     */   private static final int DEFAULT_ERROR_NOTIFICATION_CYCLES = 180;
/*     */   private String dataSource_;
/*     */   private int cycleInterval_;
/*     */   private int maxRecsPerCycle_;
/*  30 */   private int offlineFailureCountResetInterval_ = 600000;
/*  31 */   private int errorNotificationCycles_ = 180;
/*     */   
/*  33 */   private long workstationStart_ = -1L;
/*  34 */   private long workstationEnd_ = -1L;
/*     */   
/*  36 */   private final List<RelegationLevelConfig> relegationLevels_ = new ArrayList<>(4);
/*     */   
/*     */   public int getCycleInterval() {
/*  39 */     return this.cycleInterval_;
/*     */   }
/*     */   
/*     */   public String getDataSource() {
/*  43 */     return this.dataSource_;
/*     */   }
/*     */   
/*     */   public int getErrorNotificationCycles() {
/*  47 */     return this.errorNotificationCycles_;
/*     */   }
/*     */   
/*     */   public int getMaxRecsPerCycle() {
/*  51 */     return this.maxRecsPerCycle_;
/*     */   }
/*     */   
/*     */   public int getOfflineFailureCountResetInterval() {
/*  55 */     return this.offlineFailureCountResetInterval_;
/*     */   }
/*     */   
/*     */   public List<RelegationLevelConfig> getRelegationLevels() {
/*  59 */     return this.relegationLevels_;
/*     */   }
/*     */   
/*     */   public long getWorkstationEnd() {
/*  63 */     return this.workstationEnd_;
/*     */   }
/*     */   
/*     */   public long getWorkstationStart() {
/*  67 */     return this.workstationStart_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  75 */     if ("dataSource".equalsIgnoreCase(argKey)) {
/*  76 */       this.dataSource_ = argValue.toString();
/*     */     }
/*  78 */     else if ("cycleInterval".equalsIgnoreCase(argKey)) {
/*  79 */       this.cycleInterval_ = ConfigUtils.toInt(argValue, 10000);
/*     */     }
/*  81 */     else if ("errorNotificationCycles".equalsIgnoreCase(argKey)) {
/*  82 */       this.errorNotificationCycles_ = ConfigUtils.toInt(argValue, 180);
/*     */     }
/*  84 */     else if ("maxRecsPerCycle".equalsIgnoreCase(argKey)) {
/*  85 */       this.maxRecsPerCycle_ = ConfigUtils.toInt(argValue, 50);
/*     */     }
/*  87 */     else if ("offlineFailureCountResetInterval".equalsIgnoreCase(argKey)) {
/*  88 */       this.offlineFailureCountResetInterval_ = ConfigUtils.toInt(argValue, 600000);
/*     */     }
/*  90 */     else if ("workstationStart".equalsIgnoreCase(argKey)) {
/*  91 */       this.workstationStart_ = ConfigUtils.toLong(argValue);
/*     */     }
/*  93 */     else if ("workstationEnd".equalsIgnoreCase(argKey)) {
/*  94 */       this.workstationEnd_ = ConfigUtils.toLong(argValue);
/*     */     }
/*  96 */     else if (argValue instanceof RelegationLevelConfig) {
/*  97 */       this.relegationLevels_.add((RelegationLevelConfig)argValue);
/*     */     } else {
/*     */       
/* 100 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\config\DtxReplicationQueueConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */