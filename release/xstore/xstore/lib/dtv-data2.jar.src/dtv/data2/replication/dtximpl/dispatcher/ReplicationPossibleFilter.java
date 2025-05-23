/*    */ package dtv.data2.replication.dtximpl.dispatcher;
/*    */ 
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
/*    */ public class ReplicationPossibleFilter
/*    */ {
/* 15 */   private static final Logger logger_ = Logger.getLogger(ReplicationPossibleFilter.class);
/*    */ 
/*    */ 
/*    */   
/*    */   private static ReplicationPossibleFilter instance_;
/*    */ 
/*    */ 
/*    */   
/*    */   static {
/* 24 */     String PROPERTY = "dtv.data2.replication.dtximpl.dispatcher.ReplicationPossibleFilter";
/* 25 */     String implName = System.getProperty("dtv.data2.replication.dtximpl.dispatcher.ReplicationPossibleFilter", "dtv.data2.replication.dtximpl.dispatcher.ReplicationPossibleFilter");
/*    */     try {
/* 27 */       Class<?> implClass = Class.forName(implName);
/* 28 */       instance_ = (ReplicationPossibleFilter)implClass.newInstance();
/*    */     }
/* 30 */     catch (Throwable e) {
/* 31 */       logger_.error("Cannot find or instantiate class '" + implName + "' defined for '" + "dtv.data2.replication.dtximpl.dispatcher.ReplicationPossibleFilter" + "'.", e);
/* 32 */       instance_ = new ReplicationPossibleFilter();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static ReplicationPossibleFilter getInstance() {
/* 37 */     return instance_;
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
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isReplicationPossible(Exception ee) {
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\dispatcher\ReplicationPossibleFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */