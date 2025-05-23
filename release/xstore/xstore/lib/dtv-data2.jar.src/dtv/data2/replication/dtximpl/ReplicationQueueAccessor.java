/*      */ package dtv.data2.replication.dtximpl;
/*      */ 
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.exception.FailoverException;
/*      */ import dtv.data2.access.impl.jdbc.DBConnection;
/*      */ import dtv.data2.access.impl.jdbc.JDBCDataSourceMgr;
/*      */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*      */ import dtv.data2.replication.ReplicationException;
/*      */ import dtv.data2.replication.dtximpl.config.DtxReplicationConfigHelper;
/*      */ import dtv.data2.replication.dtximpl.config.DtxReplicationQueueConfig;
/*      */ import dtv.data2.replication.dtximpl.dispatcher.IDtxReplicationDispatcher;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.util.temp.InjectionHammer;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import javax.inject.Inject;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ReplicationQueueAccessor
/*      */ {
/*      */   public static final int UNSPECIFIED = -1;
/*      */   protected static final int MAX_RETRIES;
/*      */   protected static final int RETRY_WAIT;
/*      */   protected static final int NO_FAILS_LIMIT;
/*      */   protected static final int ERROR_NOTIFICATION_CYCLES;
/*      */   protected static final ReplicationQueueAccessor INSTANCE;
/*   45 */   private static final Logger logger_ = Logger.getLogger(ReplicationQueueAccessor.class);
/*   46 */   private static final Logger auditLogger_ = Logger.getLogger("REPLICATION_AUDIT_LOG");
/*      */   
/*      */   private static final String SQL_INSERT = "insert into ctl_replication_queue (organization_id, rtl_loc_id, wkstn_id, db_trans_id, service_name, date_time, expires_after, expires_immediately_flag, never_expires_flag, offline_failures, error_failures, replication_data) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
/*      */   
/*      */   private static final String SQL_DELETE = "delete from ctl_replication_queue where organization_id = ? and rtl_loc_id = ? and wkstn_id = ? and db_trans_id = ? and service_name = ?";
/*      */   
/*      */   private static final String SQL_SELECT = "select organization_id, rtl_loc_id, wkstn_id, db_trans_id, service_name, date_time, expires_after, expires_immediately_flag, never_expires_flag, offline_failures, error_failures, replication_data from ctl_replication_queue where organization_id = ? and rtl_loc_id = ? and wkstn_id = ?";
/*      */   
/*      */   private static final String SQL_FAILURE_MIN = "(offline_failures + error_failures) >=";
/*      */   
/*      */   private static final String SQL_FAILURE_MAX = "(offline_failures + error_failures) <";
/*      */   
/*      */   private static final String SQL_FAILURE_EQ = "(offline_failures + error_failures) =";
/*      */   
/*      */   private static final String SQL_WHERE_SERVICENAME = " and service_name = ? ";
/*      */   
/*      */   private static final String SQL_ORDER_BY = "order by date_time asc";
/*      */   
/*      */   private static final String SQL_UPDATE_OFFLINE_FAILURES = "update ctl_replication_queue set offline_failures = ? where organization_id = ? and rtl_loc_id = ? and wkstn_id = ? and db_trans_id = ? and service_name = ?";
/*      */   
/*      */   private static final String SQL_UPDATE_ERROR_FAILURES = "update ctl_replication_queue set error_failures = ? where organization_id = ? and rtl_loc_id = ? and wkstn_id = ? and db_trans_id = ? and service_name = ?";
/*      */   
/*      */   private static final String SQL_RESET_OFFLINE_FAILURES = "update ctl_replication_queue set offline_failures = 0 where organization_id = ? and rtl_loc_id = ? and wkstn_id = ? and offline_failures > 0";
/*      */   
/*      */   private static final String SQL_ERROR_FAILURE_COUNT = "select count(*) from ctl_replication_queue where organization_id = ? and rtl_loc_id = ? and wkstn_id = ? and error_failures > 0";
/*      */   private static final String SQL_NO_FAILURE_COUNT = "select count(*) from ctl_replication_queue where organization_id = ? and rtl_loc_id = ? and wkstn_id = ? and offline_failures = 0 and error_failures = 0";
/*   72 */   private static int currentErrorCycle_ = 0;
/*      */ 
/*      */   
/*   75 */   protected static final DtxReplicationQueueConfig _replicationQueueConfig = DtxReplicationConfigHelper.getReplicationQueueConfig();
/*      */   
/*      */   @Inject
/*      */   private IPersistenceDefaults _persistenceDefaults;
/*      */   @Inject
/*      */   protected ReplicationEventLogWriter _eventLogWriter;
/*      */   private final String myDataSource_;
/*      */   private final int maxRecordsPerCycle_;
/*      */   
/*      */   static {
/*   85 */     MAX_RETRIES = Integer.getInteger("dtv.data2.replication.queue.maxretries", 4).intValue();
/*   86 */     RETRY_WAIT = Integer.getInteger("dtv.data2.replication.queue.retrywait", 3000).intValue();
/*   87 */     NO_FAILS_LIMIT = Integer.getInteger("dtv.data2.replication.queue.nofailslimit", 100).intValue();
/*   88 */     ERROR_NOTIFICATION_CYCLES = _replicationQueueConfig.getErrorNotificationCycles();
/*      */     
/*   90 */     String sysProp = System.getProperty("dtv.data2.replication.dtximpl.ReplicationQueueAccessor");
/*      */     
/*   92 */     ReplicationQueueAccessor instance = null;
/*   93 */     if (!StringUtils.isEmpty(sysProp)) {
/*      */       try {
/*   95 */         instance = (ReplicationQueueAccessor)Class.forName(sysProp).newInstance();
/*      */       }
/*   97 */       catch (Exception ee) {
/*   98 */         logger_.error("exception while loading customer implementation of ReplicationQueueAccessor", ee);
/*      */       } 
/*      */     }
/*      */     
/*  102 */     if (instance == null) {
/*  103 */       instance = new ReplicationQueueAccessor();
/*      */     }
/*  105 */     INSTANCE = instance;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ReplicationQueueAccessor getInstance() {
/*  113 */     return INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ReplicationQueueAccessor() {
/*  124 */     InjectionHammer.forceAtInjectProcessing(this);
/*      */     
/*  126 */     String myDataSource = "Local";
/*      */     try {
/*  128 */       myDataSource = DtxReplicationConfigHelper.getReplicationQueueConfig().getDataSource();
/*      */     } finally {
/*      */       
/*  131 */       this.myDataSource_ = myDataSource;
/*      */     } 
/*  133 */     auditLogger_.info("Replication datasource is: " + this.myDataSource_);
/*      */     
/*  135 */     int maxRecordsPerCycle = 50;
/*      */     try {
/*  137 */       maxRecordsPerCycle = DtxReplicationConfigHelper.getReplicationQueueConfig().getMaxRecsPerCycle();
/*      */     } finally {
/*      */       
/*  140 */       this.maxRecordsPerCycle_ = maxRecordsPerCycle;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addObject(ReplicationTransaction argTransaction) {
/*  151 */     boolean SAVE_REQUIRED = true;
/*      */     
/*      */     try {
/*  154 */       boolean success = addObjectImpl(argTransaction, this.myDataSource_, null, true);
/*  155 */       if (!success)
/*      */       {
/*      */         
/*  158 */         String msg = "An unexpected error occurred while adding a transaction to the replication queue. No exception thrown, just failure reported. XML SQL data:\n" + argTransaction.getPersistablesAsXml();
/*  159 */         logger_.error(msg, new Throwable("STACK TRACE"));
/*  160 */         throw new ReplicationException(msg);
/*      */       }
/*      */     
/*  163 */     } catch (Exception ee) {
/*  164 */       logger_.error("Serious replication queue error - could not save save entry to replication queue. " + argTransaction
/*  165 */           .getPersistablesAsXml(), ee);
/*  166 */       if (ee instanceof RuntimeException) {
/*  167 */         throw (RuntimeException)ee;
/*      */       }
/*      */       
/*  170 */       throw new ReplicationException("An error occurred while saving to the replication queue.", ee);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addObjectRemote(ReplicationTransaction argTransaction, String argDataSource, String argDestinationService) {
/*  188 */     boolean SAVE_NOT_REQUIRED = false;
/*      */     
/*  190 */     return addObjectImpl(argTransaction, argDataSource, argDestinationService, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void existingTransactionFailed(IDtxReplicationDispatcher.DispatchResult argResult, ReplicationTransaction argTransaction) {
/*  199 */     auditLogger_.debug("BEGIN existingTransactionFailed");
/*      */     
/*  201 */     Connection dbConnection = null;
/*  202 */     PreparedStatement ps = null; try {
/*      */       String SQL;
/*      */       int failureCount;
/*  205 */       dbConnection = getConnection();
/*  206 */       int index = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  211 */       if (IDtxReplicationDispatcher.DispatchResult.DISPATCH_OFFLINE_FAILURE == argResult) {
/*  212 */         SQL = "update ctl_replication_queue set offline_failures = ? where organization_id = ? and rtl_loc_id = ? and wkstn_id = ? and db_trans_id = ? and service_name = ?";
/*  213 */         failureCount = argTransaction.getFailedOfflineAttempts();
/*      */       }
/*  215 */       else if (IDtxReplicationDispatcher.DispatchResult.DISPATCH_ERROR_FAILURE == argResult) {
/*  216 */         SQL = "update ctl_replication_queue set error_failures = ? where organization_id = ? and rtl_loc_id = ? and wkstn_id = ? and db_trans_id = ? and service_name = ?";
/*  217 */         failureCount = argTransaction.getFailedErrorAttempts();
/*      */       } else {
/*      */         
/*  220 */         throw new ReplicationException("Unkown DispatchResult: " + argResult);
/*      */       } 
/*      */       
/*  223 */       ps = dbConnection.prepareStatement(SQL);
/*      */       
/*  225 */       ps.setLong(index++, failureCount);
/*  226 */       ps.setLong(index++, argTransaction.getOrganizationId());
/*  227 */       ps.setLong(index++, argTransaction.getRetailLocationId());
/*  228 */       ps.setLong(index++, argTransaction.getWorkstationId());
/*  229 */       ps.setString(index++, argTransaction.getTransactionId());
/*  230 */       ps.setString(index++, argTransaction.getServiceName());
/*  231 */       auditLogger_.debug("BEGIN ps.execute() existingTransactionFailed");
/*  232 */       ps.execute();
/*  233 */       auditLogger_.debug("END ps.execute() existingTransactionFailed");
/*      */     }
/*  235 */     catch (Exception ee) {
/*  236 */       if (FailoverException.isFailover(ee)) {
/*  237 */         logger_.warn("Failed to update a failure count in replication queue for db trans id: " + argTransaction
/*  238 */             .getTransactionId() + " because of failover: " + ee);
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */         
/*  244 */         String msg = "An unexpected error occured while updating an entry from the replication log. db_trans_id = " + argTransaction.getTransactionId() + " service_name = " + argTransaction.getServiceName();
/*  245 */         logger_.warn(msg, ee);
/*      */       } 
/*      */     } finally {
/*      */       
/*  249 */       if (ps != null) {
/*      */         try {
/*  251 */           ps.close();
/*      */         }
/*  253 */         catch (Exception ee) {
/*  254 */           logger_.warn("An exception occurred while closing a prepared statement.", ee);
/*      */         } 
/*      */       }
/*  257 */       if (dbConnection != null) {
/*      */         try {
/*  259 */           dbConnection.close();
/*      */         }
/*  261 */         catch (Exception ee) {
/*  262 */           logger_.warn("An exception occurred while closing a connection.", ee);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  267 */     auditLogger_.debug("END existingTransactionFailed");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<ReplicationTransaction> getReplicationTransactions(int argMinFailureLevel, int argMaxFailureLevel) {
/*  287 */     return getReplicationTransactions(null, argMinFailureLevel, argMaxFailureLevel);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<ReplicationTransaction> getReplicationTransactions(String argServiceName, int argMinFailureLevel, int argMaxFailureLevel) {
/*  302 */     long workstationStart = _replicationQueueConfig.getWorkstationStart();
/*  303 */     long workstationEnd = _replicationQueueConfig.getWorkstationEnd();
/*      */     
/*  305 */     if (workstationStart > 0L && workstationEnd > 0L && workstationEnd > workstationStart) {
/*  306 */       List<ReplicationTransaction> list = new ArrayList<>();
/*      */       long workstationId;
/*  308 */       for (workstationId = workstationStart; workstationId <= workstationEnd; workstationId++) {
/*      */         
/*  310 */         List<ReplicationTransaction> transactions = getReplicationTransactions(argServiceName, argMinFailureLevel, argMaxFailureLevel, workstationId);
/*  311 */         if (transactions != null) {
/*  312 */           list.addAll(transactions);
/*      */         }
/*      */       } 
/*      */       
/*  316 */       return list;
/*      */     } 
/*      */     
/*  319 */     return getReplicationTransactions(argServiceName, argMinFailureLevel, argMaxFailureLevel, 
/*  320 */         getWorkstationId());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<ReplicationTransaction> getReplicationTransactions(String argServiceName, int argMinFailureLevel, int argMaxFailureLevel, long argWorkstationId) {
/*  339 */     if (auditLogger_.isDebugEnabled()) {
/*  340 */       auditLogger_.debug("BEGIN getReplicationTransactions min: " + argMinFailureLevel + "max: " + argMaxFailureLevel);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  348 */     if (argMaxFailureLevel != -1 && argMinFailureLevel != -1 && argMaxFailureLevel < argMinFailureLevel)
/*      */     {
/*  350 */       throw new ReplicationException("Invalid min & max provided to getReplicationTransactions.  max < min. Min = " + argMinFailureLevel + " Max = " + argMaxFailureLevel);
/*      */     }
/*      */ 
/*      */     
/*  354 */     if (argMinFailureLevel < -1 || argMaxFailureLevel < -1) {
/*  355 */       throw new ReplicationException("Invalid min & max provided to getReplicationTransactions.  min or max is < -1. Min = " + argMinFailureLevel + " Max = " + argMaxFailureLevel);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  360 */     List<ReplicationTransaction> resultObjects = null;
/*      */     
/*      */     try {
/*  363 */       resultObjects = queryReplicationTransactions(argServiceName, argMinFailureLevel, argMaxFailureLevel, argWorkstationId);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  368 */       if (++currentErrorCycle_ % ERROR_NOTIFICATION_CYCLES == 0) {
/*  369 */         int errorFails_ = queryErrorFailureCount(argWorkstationId);
/*  370 */         if (errorFails_ > 0) {
/*  371 */           auditLogger_.error("REPLICATION ENTRIES WITH ERROR FAILURES: " + errorFails_);
/*  372 */           this._eventLogWriter.writeRepQueueFailureEventLogEntry("ERROR", "REPLICATION ENTRIES WITH ERROR FAILURES: " + errorFails_, argWorkstationId);
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  380 */       int noFails_ = queryNonFailedRecCount(argWorkstationId);
/*  381 */       if (noFails_ > NO_FAILS_LIMIT) {
/*  382 */         auditLogger_.warn("PENDING REPLICATION RECORDS: " + noFails_);
/*  383 */         this._eventLogWriter.writeRepQueueNoFailureEventLogEntry("WARN", "PENDING REPLICATION RECORDS: " + noFails_, argWorkstationId);
/*      */       }
/*      */     
/*      */     }
/*  387 */     catch (Exception ee) {
/*  388 */       if (FailoverException.isFailover(ee)) {
/*  389 */         logger_.warn("A failover exception occured while querying the replication queue: " + ee.toString());
/*      */       } else {
/*      */         
/*  392 */         logger_.error("An unexpected error occured while querying the replication queue.", ee);
/*  393 */         this._eventLogWriter.writeRepQueueReadErrorEventLogEntry("ERROR", "ERROR OCCURRED WHILE QUERYING REP QUEUE", ee, argWorkstationId);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  398 */     String resultObjectCount = (resultObjects == null) ? "null" : String.valueOf(resultObjects.size());
/*      */     
/*  400 */     if (auditLogger_.isDebugEnabled()) {
/*  401 */       auditLogger_.debug("END getReplicationTransactions min: " + argMinFailureLevel + "max: " + argMaxFailureLevel + " Returning " + resultObjectCount + " replication entries");
/*      */     }
/*      */ 
/*      */     
/*  405 */     return resultObjects;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int queryNonFailedRecCount(long argWorkstationId) throws SQLException {
/*  416 */     Connection dbConnection = null;
/*  417 */     PreparedStatement ps3 = null;
/*  418 */     ResultSet results3 = null;
/*  419 */     int noFails_ = 0;
/*      */     try {
/*  421 */       dbConnection = getConnection();
/*  422 */       ps3 = dbConnection.prepareStatement("select count(*) from ctl_replication_queue where organization_id = ? and rtl_loc_id = ? and wkstn_id = ? and offline_failures = 0 and error_failures = 0");
/*  423 */       int index = 1;
/*  424 */       ps3.setLong(index++, getOrganizationId());
/*  425 */       ps3.setInt(index++, getRetailLocationId());
/*  426 */       ps3.setLong(index++, argWorkstationId);
/*  427 */       results3 = ps3.executeQuery();
/*      */       
/*  429 */       if (results3 != null) {
/*  430 */         while (results3.next()) {
/*  431 */           noFails_ = results3.getInt(1);
/*      */         }
/*      */       }
/*      */     } finally {
/*      */       
/*  436 */       if (results3 != null) {
/*      */         try {
/*  438 */           results3.close();
/*      */         }
/*  440 */         catch (Exception ee) {
/*  441 */           logger_.warn("An exception occurred while closing a result set.", ee);
/*      */         } 
/*      */       }
/*  444 */       if (ps3 != null) {
/*      */         try {
/*  446 */           ps3.close();
/*      */         }
/*  448 */         catch (Exception ee) {
/*  449 */           logger_.warn("An exception occurred while closing a prepared statement.", ee);
/*      */         } 
/*      */       }
/*  452 */       if (dbConnection != null) {
/*      */         try {
/*  454 */           dbConnection.close();
/*      */         }
/*  456 */         catch (Exception ee) {
/*  457 */           logger_.warn("An exception occurred while closing a connection.", ee);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  462 */     return noFails_;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<ReplicationTransaction> queryReplicationTransactions(String argServiceName, int argMinFailureLevel, int argMaxFailureLevel, long argWorkstationId) throws SQLException {
/*  478 */     Connection dbConnection = null;
/*  479 */     PreparedStatement ps = null;
/*  480 */     ResultSet results = null;
/*      */     
/*  482 */     List<ReplicationTransaction> resultObjects = null;
/*      */     
/*      */     try {
/*  485 */       dbConnection = getConnection();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  491 */       StringBuilder sql = new StringBuilder(192);
/*  492 */       sql.append("select organization_id, rtl_loc_id, wkstn_id, db_trans_id, service_name, date_time, expires_after, expires_immediately_flag, never_expires_flag, offline_failures, error_failures, replication_data from ctl_replication_queue where organization_id = ? and rtl_loc_id = ? and wkstn_id = ?");
/*      */       
/*  494 */       if (argMinFailureLevel == argMaxFailureLevel) {
/*  495 */         if (argMaxFailureLevel != -1) {
/*  496 */           sql.append(" and ");
/*  497 */           sql.append("(offline_failures + error_failures) =");
/*  498 */           sql.append(" ");
/*  499 */           sql.append(argMinFailureLevel);
/*      */         } 
/*      */       } else {
/*      */         
/*  503 */         if (argMinFailureLevel > -1) {
/*  504 */           sql.append(" and ");
/*  505 */           sql.append("(offline_failures + error_failures) >=");
/*  506 */           sql.append(" ");
/*  507 */           sql.append(argMinFailureLevel);
/*      */         } 
/*  509 */         if (argMaxFailureLevel > -1) {
/*  510 */           sql.append(" and ");
/*  511 */           sql.append("(offline_failures + error_failures) <");
/*  512 */           sql.append(" ");
/*  513 */           sql.append(argMaxFailureLevel);
/*      */         } 
/*      */       } 
/*      */       
/*  517 */       if (argServiceName != null) {
/*  518 */         sql.append(" and service_name = ? ");
/*      */       }
/*      */       
/*  521 */       sql.append(" ");
/*  522 */       sql.append("order by date_time asc");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  534 */       ps = dbConnection.prepareStatement(sql.toString());
/*      */       
/*  536 */       ps.setMaxRows(this.maxRecordsPerCycle_);
/*  537 */       ps.setFetchSize(this.maxRecordsPerCycle_);
/*      */       
/*  539 */       int index = 1;
/*      */       
/*  541 */       ps.setLong(index++, getOrganizationId());
/*  542 */       ps.setInt(index++, getRetailLocationId());
/*  543 */       ps.setLong(index++, argWorkstationId);
/*  544 */       if (argServiceName != null) {
/*  545 */         ps.setString(index++, argServiceName);
/*      */       }
/*  547 */       auditLogger_.debug("BEGIN ps.executeQuery() getReplicationTransactions");
/*  548 */       results = ps.executeQuery();
/*  549 */       auditLogger_.debug("END ps.executeQuery() getReplicationTransactions");
/*      */       
/*  551 */       if (results != null) {
/*  552 */         while (results.next()) {
/*      */           
/*  554 */           if (resultObjects == null) {
/*  555 */             resultObjects = new ArrayList<>(this.maxRecordsPerCycle_);
/*      */           }
/*      */           
/*  558 */           if (auditLogger_.isDebugEnabled()) {
/*  559 */             auditLogger_.debug("BEGIN Process result " + (resultObjects.size() + 1));
/*      */           }
/*      */           
/*  562 */           index = 1;
/*      */           
/*  564 */           ReplicationTransaction trans = new ReplicationTransaction();
/*      */           
/*  566 */           trans.setOrganizationId(results.getLong(index++));
/*  567 */           trans.setRetailLocationId(results.getInt(index++));
/*  568 */           trans.setWorkstationId(results.getLong(index++));
/*  569 */           trans.setTransactionId(results.getString(index++));
/*  570 */           trans.setServiceName(results.getString(index++));
/*  571 */           trans.setCreatedTime(results.getLong(index++));
/*      */           
/*  573 */           long expAfters = results.getLong(index++);
/*  574 */           if (expAfters != 0L) {
/*  575 */             trans.setExpiresAfter(expAfters);
/*      */           }
/*      */           
/*  578 */           int expiresImmediately = results.getInt(index++);
/*  579 */           if (expiresImmediately != 0) {
/*  580 */             trans.setExpiresImmediately(true);
/*      */           }
/*      */           
/*  583 */           int neverExpires = results.getInt(index++);
/*  584 */           if (neverExpires != 0) {
/*  585 */             trans.setNeverExpires(true);
/*      */           }
/*      */           
/*  588 */           trans.setFailedOfflineAttempts(results.getInt(index++));
/*  589 */           trans.setFailedErrorAttempts(results.getInt(index++));
/*  590 */           trans.addDataAsXmlString(JDBCHelper.clobToString(results, index++));
/*      */           
/*  592 */           trans.setNewTransaction(false);
/*      */           
/*  594 */           if (auditLogger_.isDebugEnabled()) {
/*  595 */             auditLogger_.debug("END Process result " + (resultObjects.size() + 1));
/*      */           }
/*      */           
/*  598 */           resultObjects.add(trans);
/*      */         } 
/*      */       }
/*      */     } finally {
/*      */       
/*  603 */       if (results != null) {
/*      */         try {
/*  605 */           results.close();
/*      */         }
/*  607 */         catch (Exception ee) {
/*  608 */           logger_.warn("An exception occurred while closing a result set.", ee);
/*      */         } 
/*      */       }
/*  611 */       if (ps != null) {
/*      */         try {
/*  613 */           ps.close();
/*      */         }
/*  615 */         catch (Exception ee) {
/*  616 */           logger_.warn("An exception while closing a prepared statement.", ee);
/*      */         } 
/*      */       }
/*  619 */       if (dbConnection != null) {
/*      */         try {
/*  621 */           dbConnection.close();
/*      */         }
/*  623 */         catch (Exception ee) {
/*  624 */           logger_.warn("An exception occurred while closing a connection.", ee);
/*      */         } 
/*      */       }
/*      */     } 
/*  628 */     return resultObjects;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeObject(ReplicationTransaction argTransaction) {
/*  637 */     if (auditLogger_.isDebugEnabled()) {
/*  638 */       auditLogger_.debug("BEGIN removeObject trans: " + argTransaction.getTransactionId());
/*      */     }
/*      */     
/*  641 */     Connection dbConnection = null;
/*  642 */     PreparedStatement ps = null;
/*  643 */     int retries = 0;
/*      */     
/*  645 */     while (retries++ < MAX_RETRIES) {
/*      */       
/*  647 */       try { int index = 1;
/*  648 */         dbConnection = getConnection();
/*  649 */         ps = dbConnection.prepareStatement("delete from ctl_replication_queue where organization_id = ? and rtl_loc_id = ? and wkstn_id = ? and db_trans_id = ? and service_name = ?");
/*      */         
/*  651 */         ps.setLong(index++, argTransaction.getOrganizationId());
/*  652 */         ps.setLong(index++, argTransaction.getRetailLocationId());
/*  653 */         ps.setLong(index++, argTransaction.getWorkstationId());
/*  654 */         ps.setString(index++, argTransaction.getTransactionId());
/*  655 */         ps.setString(index++, argTransaction.getServiceName());
/*      */         
/*  657 */         if (auditLogger_.isDebugEnabled()) {
/*  658 */           auditLogger_.debug("BEGIN ps.execute() removeObject trans: " + argTransaction.getTransactionId());
/*      */         }
/*      */         
/*  661 */         ps.execute();
/*      */         
/*  663 */         if (auditLogger_.isDebugEnabled()) {
/*  664 */           auditLogger_.debug("END ps.execute() removeObject trans: " + argTransaction.getTransactionId());
/*      */         }
/*      */ 
/*      */         
/*      */         break; }
/*  669 */       catch (Exception ee)
/*      */       
/*  671 */       { auditLogger_.debug("removeObject exception caught " + ee + " retries: " + retries);
/*      */         
/*  673 */         if (FailoverException.isFailover(ee))
/*      */         { try {
/*  675 */             Thread.sleep(RETRY_WAIT);
/*      */           }
/*  677 */           catch (Exception exception) {}
/*      */ 
/*      */           
/*  680 */           if (retries == MAX_RETRIES) {
/*  681 */             logger_.warn("Failed to delete replication from queue because queue datasource is offline. Transation id: " + argTransaction
/*  682 */                 .getTransactionId() + " Exception: " + ee);
/*      */           
/*      */           }
/*      */            }
/*      */         
/*      */         else
/*      */         
/*      */         { 
/*  690 */           String msg = "An unexpected error occured while removing an entry from the replication queue. db_trans_id = " + argTransaction.getTransactionId() + " service_name = " + argTransaction.getServiceName();
/*  691 */           logger_.warn(msg, ee);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  696 */           if (ps != null) {
/*      */             try {
/*  698 */               ps.close();
/*      */             }
/*  700 */             catch (Exception exception) {
/*  701 */               logger_.warn("An exception occurred while closing a statement.", exception);
/*      */             } 
/*      */           }
/*  704 */           if (dbConnection != null)
/*      */             
/*  706 */             try { dbConnection.close(); }
/*      */             
/*  708 */             catch (Exception exception)
/*  709 */             { logger_.warn("An exception occurred while closing a connection.", exception); }   break; }  } finally { if (ps != null) try { ps.close(); } catch (Exception ee) { logger_.warn("An exception occurred while closing a statement.", ee); }   if (dbConnection != null) try { dbConnection.close(); } catch (Exception ee) { logger_.warn("An exception occurred while closing a connection.", ee); }
/*      */         
/*      */          }
/*      */     
/*      */     } 
/*      */ 
/*      */     
/*  716 */     if (auditLogger_.isDebugEnabled()) {
/*  717 */       auditLogger_.debug("END removeObject trans: " + argTransaction.getTransactionId());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void resetOfflineFailureCounts() {
/*  726 */     long workstationStart = _replicationQueueConfig.getWorkstationStart();
/*  727 */     long workstationEnd = _replicationQueueConfig.getWorkstationEnd();
/*      */     
/*  729 */     if (0L <= workstationStart && workstationStart <= workstationEnd) {
/*  730 */       long workstationId; for (workstationId = workstationStart; workstationId <= workstationEnd; workstationId++) {
/*  731 */         resetOfflineFailureCounts(workstationId);
/*      */       }
/*      */     } else {
/*      */       
/*  735 */       resetOfflineFailureCounts(getWorkstationId());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void resetOfflineFailureCounts(long argWorkstationId) {
/*  746 */     auditLogger_.debug("BEGIN resetOfflineFailureCounts");
/*  747 */     Connection dbConnection = null;
/*  748 */     PreparedStatement ps = null;
/*      */     try {
/*  750 */       dbConnection = getConnection();
/*  751 */       int index = 1;
/*  752 */       ps = dbConnection.prepareStatement("update ctl_replication_queue set offline_failures = 0 where organization_id = ? and rtl_loc_id = ? and wkstn_id = ? and offline_failures > 0");
/*  753 */       ps.setLong(index++, getOrganizationId());
/*  754 */       ps.setLong(index++, getRetailLocationId());
/*  755 */       ps.setLong(index++, argWorkstationId);
/*  756 */       auditLogger_.debug("BEGIN ps.execute() resetOfflineFailureCounts");
/*  757 */       ps.execute();
/*  758 */       auditLogger_.debug("END ps.execute() resetOfflineFailureCounts");
/*      */     }
/*  760 */     catch (Exception ee) {
/*  761 */       if (FailoverException.isFailover(ee)) {
/*  762 */         logger_.warn("Failed to reset failures counts in replication queue  because of failover: " + ee);
/*      */       } else {
/*      */         
/*  765 */         String msg = "An unexpected error occurred while reseting failure counts.";
/*  766 */         logger_.warn(msg, ee);
/*      */       } 
/*      */     } finally {
/*      */       
/*  770 */       if (ps != null) {
/*      */         try {
/*  772 */           ps.close();
/*      */         }
/*  774 */         catch (SQLException e) {
/*  775 */           logger_.warn("An exception occurred while closing a statement.", e);
/*      */         } 
/*      */       }
/*  778 */       if (dbConnection != null) {
/*      */         try {
/*  780 */           dbConnection.close();
/*      */         }
/*  782 */         catch (SQLException e) {
/*  783 */           logger_.warn("An exception occurred while closing a connection.", e);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  788 */     auditLogger_.debug("END resetOfflineFailureCounts");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean addObjectImpl(ReplicationTransaction argTransaction, String argDataSource, String destinationService, boolean argRequiredSave) {
/*  794 */     if (auditLogger_.isDebugEnabled()) {
/*  795 */       auditLogger_.debug("BEGIN addObjectImpl for trans: " + argTransaction.getTransactionId());
/*      */     }
/*      */     
/*  798 */     boolean done = false;
/*  799 */     int retries = 0;
/*      */     
/*  801 */     while (!done) {
/*      */       
/*  803 */       Connection dbConnection = null;
/*  804 */       PreparedStatement ps = null;
/*      */       try {
/*  806 */         int index = 1;
/*  807 */         dbConnection = getConnection();
/*  808 */         ps = dbConnection.prepareStatement("insert into ctl_replication_queue (organization_id, rtl_loc_id, wkstn_id, db_trans_id, service_name, date_time, expires_after, expires_immediately_flag, never_expires_flag, offline_failures, error_failures, replication_data) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
/*      */         
/*  810 */         ps.setLong(index++, argTransaction.getOrganizationId());
/*  811 */         ps.setLong(index++, argTransaction.getRetailLocationId());
/*  812 */         ps.setLong(index++, argTransaction.getWorkstationId());
/*  813 */         ps.setString(index++, argTransaction.getTransactionId());
/*      */         
/*  815 */         if (destinationService != null) {
/*  816 */           ps.setString(index++, destinationService);
/*      */         } else {
/*      */           
/*  819 */           ps.setString(index++, argTransaction.getServiceName());
/*      */         } 
/*      */         
/*  822 */         ps.setLong(index++, argTransaction.getCreatedTime());
/*      */         
/*  824 */         if (!argTransaction.getExpiresImmediately() && !argTransaction.getNeverExpires() && argTransaction
/*  825 */           .getExpiresAfter() > 0L) {
/*  826 */           ps.setString(index++, String.valueOf(argTransaction.getExpiresAfter()));
/*      */         } else {
/*      */           
/*  829 */           ps.setNull(index++, 4);
/*      */         } 
/*      */         
/*  832 */         if (argTransaction.getExpiresImmediately()) {
/*  833 */           ps.setInt(index++, 1);
/*      */         } else {
/*      */           
/*  836 */           ps.setInt(index++, 0);
/*      */         } 
/*      */         
/*  839 */         if (argTransaction.getNeverExpires()) {
/*  840 */           ps.setInt(index++, 1);
/*      */         } else {
/*      */           
/*  843 */           ps.setInt(index++, 0);
/*      */         } 
/*      */         
/*  846 */         ps.setInt(index++, argTransaction.getFailedOfflineAttempts());
/*  847 */         ps.setInt(index++, argTransaction.getFailedErrorAttempts());
/*  848 */         ps.setString(index++, argTransaction.getPersistablesAsXml());
/*      */         
/*  850 */         auditLogger_.debug("BEGIN addObjectImpl ps.execute() for INSERT");
/*  851 */         ps.execute();
/*  852 */         auditLogger_.debug("END addObjectImpl ps.execute() for INSERT - returning true");
/*      */         
/*  854 */         return true;
/*      */       }
/*  856 */       catch (Exception ee) {
/*  857 */         done = false;
/*      */         
/*  859 */         auditLogger_.debug("Exception caught during addObjectImpl " + ee);
/*      */         
/*  861 */         if (!FailoverException.isFailover(ee) || retries >= MAX_RETRIES) {
/*  862 */           if (argRequiredSave) {
/*  863 */             String str = "An unexpected error occured while saving to the replication queue. Replication data may have been lost.";
/*      */ 
/*      */             
/*  866 */             logger_.fatal(str, ee);
/*  867 */             throw new ReplicationException(str, ee);
/*      */           } 
/*      */           
/*  870 */           String msg = "Failed to save data to replication queue.";
/*  871 */           throw new ReplicationException(msg, ee);
/*      */         } 
/*      */ 
/*      */         
/*  875 */         retries++;
/*  876 */         if (logger_.isDebugEnabled()) {
/*  877 */           logger_.debug("Failover detected on replication queue datasource: [" + argDataSource + "], will retry (retry count: + " + retries + " MAX_RETRIES: " + MAX_RETRIES, ee);
/*      */         }
/*      */ 
/*      */         
/*  881 */         auditLogger_.debug("addObjectImpl will retry.  going to sleep " + RETRY_WAIT + " retries: " + retries);
/*      */ 
/*      */         
/*      */         try {
/*  885 */           Thread.sleep(RETRY_WAIT);
/*      */         }
/*  887 */         catch (Exception exception) {}
/*      */       
/*      */       }
/*      */       finally {
/*      */ 
/*      */         
/*  893 */         if (ps != null) {
/*      */           try {
/*  895 */             ps.close();
/*      */           }
/*  897 */           catch (Exception ex) {
/*  898 */             logger_.warn("An exception occurred while closing a statement.", ex);
/*      */           } 
/*      */         }
/*  901 */         if (dbConnection != null) {
/*      */           try {
/*  903 */             dbConnection.close();
/*      */           }
/*  905 */           catch (Exception ex) {
/*  906 */             logger_.warn("An exception occurred while closing a connection.", ex);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  912 */     auditLogger_.warn("addObjectImpl could not save, preparing to throw.");
/*  913 */     throw new ReplicationException("Invalid state in ReplicationQueueAccessor - this code should NOT be hit - Replication queue entry NOT saved. Service:  " + argTransaction
/*      */         
/*  915 */         .getServiceName() + " Data: " + argTransaction
/*  916 */         .getPersistablesAsXml());
/*      */   }
/*      */   protected Connection getConnection() {
/*      */     DBConnection dBConnection;
/*  920 */     Connection dbConnection = null;
/*      */     
/*  922 */     int retries = 0;
/*      */     
/*  924 */     while (dbConnection == null && retries++ < MAX_RETRIES) {
/*      */       try {
/*  926 */         dBConnection = JDBCDataSourceMgr.getInstance().getConnection(this.myDataSource_);
/*      */       }
/*  928 */       catch (Exception ee) {
/*  929 */         if (FailoverException.isFailover(ee)) {
/*  930 */           logger_.warn("A failover occurred while obtaining replication queue datasource. [" + this.myDataSource_ + "] " + ee);
/*      */           
/*      */           try {
/*  933 */             Thread.sleep(RETRY_WAIT);
/*      */           }
/*  935 */           catch (InterruptedException interruptedException) {}
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/*  940 */         String msg = "An exception occurred while obtaining the datasource used for the replication queue: [" + this.myDataSource_ + "].  This datasource MUST be enabled, available, and use JDBCPersistenceStrategy for replication to function.";
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  945 */         logger_.error(msg, ee);
/*      */         
/*  947 */         throw new ReplicationException(msg, ee);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  952 */     if (dBConnection == null) {
/*  953 */       throw new ReplicationException("Unable to obtain datasource for replication queue [" + this.myDataSource_ + "]");
/*      */     }
/*      */ 
/*      */     
/*  957 */     return (Connection)dBConnection;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected long getOrganizationId() {
/*  967 */     return this._persistenceDefaults.getOrganizationId().longValue();
/*      */   }
/*      */   
/*      */   protected int getRetailLocationId() {
/*  971 */     return this._persistenceDefaults.getRetailLocationId().intValue();
/*      */   }
/*      */   
/*      */   protected long getWorkstationId() {
/*  975 */     return this._persistenceDefaults.getWorkstationId().longValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int queryErrorFailureCount(long argWorkstationId) throws SQLException {
/*  987 */     Connection dbConnection = null;
/*  988 */     PreparedStatement ps2 = null;
/*  989 */     ResultSet results2 = null;
/*  990 */     int errorFails_ = 0;
/*      */     try {
/*  992 */       dbConnection = getConnection();
/*  993 */       ps2 = dbConnection.prepareStatement("select count(*) from ctl_replication_queue where organization_id = ? and rtl_loc_id = ? and wkstn_id = ? and error_failures > 0");
/*  994 */       int index = 1;
/*  995 */       ps2.setLong(index++, getOrganizationId());
/*  996 */       ps2.setInt(index++, getRetailLocationId());
/*  997 */       ps2.setLong(index++, argWorkstationId);
/*  998 */       results2 = ps2.executeQuery();
/*      */       
/* 1000 */       if (results2 != null) {
/* 1001 */         while (results2.next()) {
/* 1002 */           errorFails_ = results2.getInt(1);
/*      */         }
/*      */       }
/*      */     } finally {
/*      */       
/* 1007 */       if (results2 != null) {
/*      */         try {
/* 1009 */           results2.close();
/*      */         }
/* 1011 */         catch (Exception ee) {
/* 1012 */           logger_.warn("An exception occurred while closing a result set.", ee);
/*      */         } 
/*      */       }
/* 1015 */       if (ps2 != null) {
/*      */         try {
/* 1017 */           ps2.close();
/*      */         }
/* 1019 */         catch (Exception ee) {
/* 1020 */           logger_.warn("An exception occurred while closing a prepared statement.", ee);
/*      */         } 
/*      */       }
/* 1023 */       if (dbConnection != null) {
/*      */         try {
/* 1025 */           dbConnection.close();
/*      */         }
/* 1027 */         catch (Exception ee) {
/* 1028 */           logger_.warn("An exception occurred while closing a connection.", ee);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/* 1033 */     return errorFails_;
/*      */   }
/*      */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\ReplicationQueueAccessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */