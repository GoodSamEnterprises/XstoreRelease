/*    */ package dtv.data2.replication.dtximpl.config;
/*    */ 
/*    */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*    */ import dtv.data2.replication.ReplicationConfigException;
/*    */ import dtv.util.config.ConfigHelper;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import org.apache.commons.lang3.StringUtils;
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
/*    */ public class DtxReplicationConfigHelper
/*    */   extends ConfigHelper<DtxReplicationConfig>
/*    */ {
/*    */   private static DtxReplicationServiceConfig[] services_;
/*    */   private static DtxReplicationQueueConfig repQueueConfig_;
/*    */   
/*    */   static {
/* 27 */     (new DtxReplicationConfigHelper()).initialize();
/*    */   }
/*    */   
/*    */   public static DtxReplicationQueueConfig getReplicationQueueConfig() {
/* 31 */     return repQueueConfig_;
/*    */   }
/*    */   
/*    */   public static DtxReplicationServiceConfig[] getServiceConfigs() {
/* 35 */     return services_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isReplication(DataSourceDescriptor argDescriptor) {
/* 46 */     return StringUtils.defaultString(argDescriptor.getName()).equalsIgnoreCase(
/* 47 */         getReplicationQueueConfig().getDataSource());
/*    */   }
/*    */ 
/*    */   
/*    */   public void hashRootConfigs() {
/* 52 */     super.hashRootConfigs();
/*    */     
/* 54 */     if (services_ != null) {
/* 55 */       throw new ReplicationConfigException("Service map is non null - attempt made to load ReplicationConfig more than once.");
/*    */     }
/*    */ 
/*    */     
/* 59 */     repQueueConfig_ = ((DtxReplicationConfig)getRootConfig()).getReplicationQueueConfig();
/*    */     
/* 61 */     services_ = ((DtxReplicationConfig)getRootConfig()).getServices();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 70 */     return "DtxReplicationConfig";
/*    */   }
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String dtype, String argSourceDescription) {
/* 75 */     if ("DtxReplicationConfig".equalsIgnoreCase(argTagName)) {
/* 76 */       return (IConfigObject)new DtxReplicationConfig();
/*    */     }
/* 78 */     if ("service".equalsIgnoreCase(argTagName)) {
/* 79 */       return (IConfigObject)new DtxReplicationServiceConfig();
/*    */     }
/* 81 */     if ("destination".equalsIgnoreCase(argTagName)) {
/* 82 */       return (IConfigObject)new ServiceDestinationConfig();
/*    */     }
/* 84 */     if ("subscriber".equalsIgnoreCase(argTagName)) {
/* 85 */       return (IConfigObject)new ServiceSubscriberConfig();
/*    */     }
/* 87 */     if ("condition".equalsIgnoreCase(argTagName)) {
/* 88 */       return (IConfigObject)new ServiceConditionConfig();
/*    */     }
/* 90 */     if ("conditionParam".equalsIgnoreCase(argTagName)) {
/* 91 */       return (IConfigObject)new ServiceConditionParameterConfig();
/*    */     }
/* 93 */     if ("ReplicationQueue".equalsIgnoreCase(argTagName)) {
/* 94 */       return (IConfigObject)new DtxReplicationQueueConfig();
/*    */     }
/* 96 */     if ("relegationLevel".equalsIgnoreCase(argTagName)) {
/* 97 */       return (IConfigObject)new RelegationLevelConfig();
/*    */     }
/* 99 */     return super.getConfigObject(argTagName, dtype, argSourceDescription);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\config\DtxReplicationConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */