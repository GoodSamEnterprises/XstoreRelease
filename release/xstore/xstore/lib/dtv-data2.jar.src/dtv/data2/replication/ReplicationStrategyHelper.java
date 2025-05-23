/*    */ package dtv.data2.replication;
/*    */ 
/*    */ import dtv.util.StringUtils;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class ReplicationStrategyHelper
/*    */ {
/* 17 */   private static final Logger logger_ = Logger.getLogger(ReplicationStrategyHelper.class);
/*    */   
/*    */   private static final String PROP_ENABLED = "dtv.data2.replication.enabled";
/*    */   
/*    */   private static final String PROP_STRATEGY = "dtv.data2.replication.strategy";
/*    */   private static final String DEFAULT_STRATEGY = "dtv.data2.replication.dtximpl.DtxReplicationStrategy";
/*    */   private static IReplicationStrategy currentStrategy_;
/*    */   
/*    */   public static void disableReplication() {
/* 26 */     initialize(false);
/*    */   }
/*    */   
/*    */   public static IReplicationStrategy getReplicationStategy() {
/* 30 */     return currentStrategy_;
/*    */   }
/*    */   
/*    */   public static void initialize() {
/*    */     try {
/* 35 */       String prop = System.getProperty("dtv.data2.replication.enabled", "OFF").trim();
/* 36 */       if (StringUtils.isEmpty(prop)) {
/* 37 */         prop = "OFF";
/*    */       }
/* 39 */       initialize(!"OFF".equalsIgnoreCase(prop));
/*    */     }
/* 41 */     catch (Exception ee) {
/* 42 */       String msg = "Static init error.";
/* 43 */       logger_.error(msg, ee);
/* 44 */       throw new ReplicationConfigException(msg, ee);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void initialize(boolean argReplicationEnabled) {
/* 49 */     String strategy = null;
/*    */     try {
/* 51 */       if (argReplicationEnabled) {
/* 52 */         strategy = System.getProperty("dtv.data2.replication.strategy", "dtv.data2.replication.dtximpl.DtxReplicationStrategy");
/* 53 */         currentStrategy_ = (IReplicationStrategy)Class.forName(strategy).newInstance();
/*    */       } else {
/*    */         
/* 56 */         currentStrategy_ = null;
/*    */       }
/*    */     
/* 59 */     } catch (Exception ex) {
/* 60 */       String msg = "An unexpected error occurred while instantiating replication strategy: " + strategy + ". Replication will not be available.";
/*    */ 
/*    */ 
/*    */       
/* 64 */       logger_.error(msg, ex);
/* 65 */       throw new ReplicationConfigException(msg, ex);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static boolean isReplicationEnabled() {
/* 70 */     return (currentStrategy_ != null);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\ReplicationStrategyHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */