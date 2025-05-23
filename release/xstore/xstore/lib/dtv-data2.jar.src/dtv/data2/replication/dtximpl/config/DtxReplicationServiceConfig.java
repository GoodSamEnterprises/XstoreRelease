/*     */ package dtv.data2.replication.dtximpl.config;
/*     */ 
/*     */ import dtv.data2.replication.ReplicationConfigException;
/*     */ import dtv.util.StringUtils;
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
/*     */ 
/*     */ public class DtxReplicationServiceConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  26 */   private final List<ServiceConditionConfig> conditions_ = new ArrayList<>(5);
/*  27 */   private final List<ServiceSubscriberConfig> subscribers_ = new ArrayList<>();
/*     */   
/*  29 */   private String name_ = null;
/*  30 */   private String expireAfter_ = null;
/*  31 */   private ServiceDestinationConfig destination_ = null;
/*     */ 
/*     */   
/*     */   private boolean enabled_ = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ServiceConditionConfig> getConditions() {
/*  39 */     return this.conditions_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ServiceDestinationConfig getDestination() {
/*  47 */     return this.destination_;
/*     */   }
/*     */   
/*     */   public long getExpireAfter() {
/*  51 */     if (StringUtils.isEmpty(this.expireAfter_)) {
/*  52 */       return 0L;
/*     */     }
/*     */     
/*     */     try {
/*  56 */       return Long.parseLong(this.expireAfter_);
/*     */     }
/*  58 */     catch (Exception ee) {
/*  59 */       throw new ReplicationConfigException("Unknown value specified for expireAfter tag: " + this.expireAfter_, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  70 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ServiceSubscriberConfig> getSubscribers() {
/*  78 */     return this.subscribers_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/*  86 */     return this.enabled_;
/*     */   }
/*     */   
/*     */   public boolean isExpireImediately() {
/*  90 */     return (!StringUtils.isEmpty(this.expireAfter_) && "immediately".equalsIgnoreCase(this.expireAfter_.trim()));
/*     */   }
/*     */   
/*     */   public boolean isNeverExpires() {
/*  94 */     if (StringUtils.isEmpty(this.expireAfter_) || "never".equalsIgnoreCase(this.expireAfter_.trim())) {
/*  95 */       return true;
/*     */     }
/*  97 */     if (isExpireImediately()) {
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     return (getExpireAfter() == 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 109 */     if ("name".equalsIgnoreCase(argKey)) {
/* 110 */       this.name_ = argValue.toString();
/*     */     }
/* 112 */     else if ("enabled".equalsIgnoreCase(argKey)) {
/* 113 */       this.enabled_ = ConfigUtils.toBoolean(argValue);
/*     */     }
/* 115 */     else if (argValue instanceof ServiceConditionConfig) {
/* 116 */       this.conditions_.add((ServiceConditionConfig)argValue);
/*     */     }
/* 118 */     else if (argValue instanceof ServiceDestinationConfig) {
/* 119 */       this.destination_ = (ServiceDestinationConfig)argValue;
/*     */     }
/* 121 */     else if ("subscriber".equalsIgnoreCase(argKey)) {
/* 122 */       this.subscribers_.add((ServiceSubscriberConfig)argValue);
/*     */     }
/* 124 */     else if ("expireAfter".equalsIgnoreCase(argKey)) {
/* 125 */       this.expireAfter_ = argValue.toString();
/*     */     } else {
/*     */       
/* 128 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setExpireAfter(String argExpireAfter) {
/* 133 */     this.expireAfter_ = argExpireAfter;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\config\DtxReplicationServiceConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */