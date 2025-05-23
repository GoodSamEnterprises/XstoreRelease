/*    */ package dtv.data2.replication.dtximpl.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.HashMap;
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
/*    */ public class DtxReplicationConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private DtxReplicationQueueConfig repQueueConfig_;
/* 23 */   private final Map<String, DtxReplicationServiceConfig> services_ = new HashMap<>(8);
/*    */   
/*    */   private static final String TAG_REPLICATION_QUEUE = "ReplicationQueue";
/*    */   
/*    */   private static final String TAG_SERVICE = "service";
/*    */   
/*    */   public DtxReplicationQueueConfig getReplicationQueueConfig() {
/* 30 */     return this.repQueueConfig_;
/*    */   }
/*    */   
/*    */   public DtxReplicationServiceConfig[] getServices() {
/* 34 */     return (DtxReplicationServiceConfig[])this.services_.values().toArray((Object[])new DtxReplicationServiceConfig[this.services_.size()]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 40 */     if ("service".equalsIgnoreCase(argKey)) {
/* 41 */       DtxReplicationServiceConfig val = (DtxReplicationServiceConfig)argValue;
/* 42 */       this.services_.put(val.getName(), val);
/*    */     }
/* 44 */     else if ("ReplicationQueue".equalsIgnoreCase(argKey)) {
/* 45 */       this.repQueueConfig_ = (DtxReplicationQueueConfig)argValue;
/*    */     } else {
/*    */       
/* 48 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\config\DtxReplicationConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */