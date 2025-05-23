/*     */ package dtv.data2.replication.dtximpl;
/*     */ 
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.status.IDataSourceStatusListener;
/*     */ import dtv.data2.access.status.StatusMgr;
/*     */ import dtv.data2.replication.ReplicationConfigException;
/*     */ import dtv.data2.replication.ReplicationException;
/*     */ import dtv.data2.replication.dtximpl.config.DtxReplicationConfigHelper;
/*     */ import dtv.data2.replication.dtximpl.config.DtxReplicationServiceConfig;
/*     */ import dtv.data2.replication.dtximpl.config.RelegationLevelConfig;
/*     */ import dtv.data2.replication.dtximpl.dispatcher.IDtxReplicationDispatcher;
/*     */ import dtv.data2.replication.dtximpl.event.ReplicationEvent;
/*     */ import dtv.data2.replication.dtximpl.event.ReplicationProcessQueueEvent;
/*     */ import dtv.data2.replication.dtximpl.event.ReplicationTransactionEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.log4j.Logger;
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
/*     */ 
/*     */ 
/*     */ public class ReplicationProcessor
/*     */   extends Thread
/*     */   implements IDataSourceStatusListener
/*     */ {
/*  42 */   private static final Logger logger_ = Logger.getLogger(ReplicationProcessor.class);
/*  43 */   private static final Logger auditLogger_ = Logger.getLogger("REPLICATION_AUDIT_LOG");
/*     */   
/*     */   @Inject
/*     */   private DtxReplicationServiceFactory _replicationServiceFactory;
/*     */   
/*     */   @Inject
/*     */   protected ReplicationEventLogWriter _eventLogWriter;
/*     */   
/*  51 */   private final List<String> offlineDatasources_ = new ArrayList<>(5);
/*  52 */   private final BlockingQueue<ReplicationEvent> replicationEventQueue_ = new LinkedBlockingQueue<>();
/*     */   
/*  54 */   private final long cycleInterval_ = DtxReplicationConfigHelper.getReplicationQueueConfig()
/*  55 */     .getCycleInterval();
/*     */   
/*  57 */   private final long offlineFailureCountResetInterval_ = DtxReplicationConfigHelper.getReplicationQueueConfig().getOfflineFailureCountResetInterval();
/*     */   
/*     */   private Timer processQueueTimer_;
/*  60 */   private long lastQueueProcessCompleted_ = System.currentTimeMillis();
/*  61 */   private long lastOnlineNotification_ = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean queueProcessActive_ = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean _processorStarted = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispatch(ReplicationTransaction argReplicationTrans) {
/*  78 */     if (auditLogger_.isDebugEnabled()) {
/*  79 */       auditLogger_.debug("dispatch() called with replication trans. Service: " + argReplicationTrans
/*  80 */           .getServiceName() + " Trans Id: " + argReplicationTrans.getTransactionId() + " New: " + argReplicationTrans
/*  81 */           .getNewTransaction());
/*     */     }
/*     */     
/*  84 */     if (argReplicationTrans.getNewTransaction()) {
/*  85 */       throw new ReplicationException("Invalid usage - NEW replication transactions should be adding by using enqueue. Service: " + argReplicationTrans
/*  86 */           .getServiceName() + " Trans Id: " + argReplicationTrans
/*  87 */           .getTransactionId());
/*     */     }
/*     */     
/*  90 */     this.replicationEventQueue_.add(new ReplicationTransactionEvent(argReplicationTrans));
/*     */     
/*  92 */     if (auditLogger_.isDebugEnabled()) {
/*  93 */       auditLogger_.debug("dispatch() finished adding trans to replicationEventQueue_. Service: " + argReplicationTrans
/*  94 */           .getServiceName() + " Trans Id: " + argReplicationTrans.getTransactionId());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void enqueue(ReplicationTransaction argReplicationTrans) {
/* 103 */     if (auditLogger_.isDebugEnabled()) {
/* 104 */       auditLogger_.debug("enqueue() called with replication trans. Service: " + argReplicationTrans
/* 105 */           .getServiceName() + " Trans Id: " + argReplicationTrans.getTransactionId() + " New: " + argReplicationTrans
/* 106 */           .getNewTransaction());
/*     */     }
/*     */     
/* 109 */     ReplicationQueueAccessor.getInstance().addObject(argReplicationTrans);
/*     */     
/* 111 */     if (auditLogger_.isDebugEnabled()) {
/* 112 */       auditLogger_.debug("enqueue() finished. Service: " + argReplicationTrans.getServiceName() + " Trans Id: " + argReplicationTrans
/* 113 */           .getTransactionId());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void notfiyOffline(String argDataSource) {
/* 119 */     if (!this.offlineDatasources_.contains(argDataSource)) {
/* 120 */       this.offlineDatasources_.add(argDataSource);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyOnline(String argDataSource) {
/* 129 */     if (!this.offlineDatasources_.contains(argDataSource)) {
/*     */       return;
/*     */     }
/*     */     
/* 133 */     this.offlineDatasources_.remove(argDataSource);
/*     */ 
/*     */     
/* 136 */     long NOW = System.currentTimeMillis();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     if (NOW - this.lastOnlineNotification_ < this.offlineFailureCountResetInterval_) {
/* 142 */       if (auditLogger_.isDebugEnabled()) {
/* 143 */         auditLogger_.debug("notifyOnline() returning because not enough time passed. Datasource online: " + argDataSource);
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 149 */     this.lastOnlineNotification_ = System.currentTimeMillis();
/*     */     
/* 151 */     if (auditLogger_.isDebugEnabled()) {
/* 152 */       auditLogger_
/* 153 */         .debug("BEGING notifyOnline() adding RESET_OFFLINE_FAILURE_COUNTS event to the queue. Datasource online: " + argDataSource);
/*     */     }
/*     */ 
/*     */     
/* 157 */     this.replicationEventQueue_.add(new ReplicationEvent(ReplicationEvent.ReplicationEventType.RESET_OFFLINE_FAILURE_COUNTS));
/*     */     
/* 159 */     if (auditLogger_.isDebugEnabled()) {
/* 160 */       auditLogger_
/* 161 */         .debug("FINISH notifyOnline() adding RESET_OFFLINE_FAILURE_COUNTS event to the queue. Datasource online: " + argDataSource);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 172 */     auditLogger_.debug(Thread.currentThread().getName() + " thread running.");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/*     */       try {
/* 180 */         auditLogger_.debug("----BEGIN MAIN LOOP Before replicationEventQueue_.take()----");
/*     */         
/* 182 */         ReplicationEvent event = this.replicationEventQueue_.take();
/*     */         
/* 184 */         auditLogger_.info("Event Queue Size: " + this.replicationEventQueue_.size());
/*     */         
/* 186 */         if (auditLogger_.isDebugEnabled()) {
/* 187 */           auditLogger_.debug("Taking ReplicationEvent from the queue. Event Type: " + event
/* 188 */               .getEventType().name() + " Record contained within the queue: " + this.replicationEventQueue_
/* 189 */               .contains(event));
/*     */         }
/*     */         
/* 192 */         if (ReplicationEvent.ReplicationEventType.PROCESS_TRANSACTION == event.getEventType()) {
/* 193 */           ReplicationTransaction trans = ((ReplicationTransactionEvent)event).getReplicationTransaction();
/*     */           
/* 195 */           if (auditLogger_.isDebugEnabled()) {
/* 196 */             auditLogger_.debug("BEGIN PROCESS_TRANSACTION service: " + trans.getServiceName() + " rep trans id: " + trans
/* 197 */                 .getTransactionId());
/*     */           }
/*     */           
/* 200 */           dispatchImpl(trans);
/*     */           
/* 202 */           if (auditLogger_.isDebugEnabled()) {
/* 203 */             auditLogger_.debug("FINISHED PROCESS_TRANSACTION for service: " + trans.getServiceName() + " rep trans id: " + trans
/* 204 */                 .getTransactionId());
/*     */           }
/*     */         }
/* 207 */         else if (ReplicationEvent.ReplicationEventType.PROCESS_QUEUE == event.getEventType()) {
/* 208 */           this.queueProcessActive_ = true;
/* 209 */           int min = ((ReplicationProcessQueueEvent)event).getMinFailures();
/* 210 */           int max = ((ReplicationProcessQueueEvent)event).getMaxFailures();
/*     */           
/* 212 */           for (DtxReplicationServiceConfig serviceConfig : DtxReplicationConfigHelper.getServiceConfigs()) {
/* 213 */             String serviceName = serviceConfig.getName();
/*     */             
/* 215 */             if (auditLogger_.isDebugEnabled()) {
/* 216 */               auditLogger_.debug("BEGIN PROCESS_QUEUE (" + serviceName + ") Min failures: " + min + ". Max failures: " + max + ".");
/*     */             }
/*     */ 
/*     */ 
/*     */             
/* 221 */             List<ReplicationTransaction> transactions = ReplicationQueueAccessor.getInstance().getReplicationTransactions(serviceName, min, max);
/*     */             
/* 223 */             if (auditLogger_.isDebugEnabled()) {
/* 224 */               auditLogger_.debug("FINISHED PROCESS_QUEUE (" + serviceName + ") Min failures: " + min + ". Max failures: " + max + ".");
/*     */             }
/*     */ 
/*     */             
/* 228 */             if (transactions != null && !transactions.isEmpty()) {
/* 229 */               this.queueProcessActive_ = true;
/*     */               
/* 231 */               auditLogger_.info("Publishing " + transactions
/* 232 */                   .size() + " records to the event queue (" + serviceName + ").");
/*     */               
/* 234 */               for (ReplicationTransaction trans : transactions) {
/* 235 */                 dispatch(trans);
/*     */               }
/*     */             } else {
/*     */               
/* 239 */               auditLogger_.debug("PROCESS_QUEUE (" + serviceName + ") *RETURNED NO QUEUE ENTRIES*");
/*     */             }
/*     */           
/*     */           } 
/* 243 */         } else if (ReplicationEvent.ReplicationEventType.RESET_OFFLINE_FAILURE_COUNTS == event.getEventType()) {
/* 244 */           auditLogger_.debug("BEGIN RESET_OFFLINE_FAILURE_COUNTS");
/* 245 */           ReplicationQueueAccessor.getInstance().resetOfflineFailureCounts();
/* 246 */           this.lastOnlineNotification_ = System.currentTimeMillis();
/* 247 */           auditLogger_.debug("FINISHED RESET_OFFLINE_FAILURE_COUNTS");
/*     */         } else {
/*     */           
/* 250 */           auditLogger_.warn("Unkown replication event type: " + event.getEventType());
/* 251 */           throw new DtxException("Unkown replication event type: " + event.getEventType());
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 257 */         if (this.queueProcessActive_ && this.replicationEventQueue_.isEmpty()) {
/* 258 */           this.lastQueueProcessCompleted_ = System.currentTimeMillis();
/* 259 */           if (auditLogger_.isDebugEnabled()) {
/* 260 */             auditLogger_.debug("Setting lastQueueProcessCompleted_ = " + this.lastQueueProcessCompleted_);
/*     */           }
/* 262 */           this.queueProcessActive_ = false;
/*     */         } 
/*     */         
/* 265 */         auditLogger_.debug("----END MAIN LOOP----");
/*     */       }
/* 267 */       catch (Exception ee) {
/* 268 */         logger_.error("Unpexpected exception caught in ReplicationProcessor main loop. We will attempt to continue.", ee);
/*     */         
/* 270 */         auditLogger_.error("Unpexpected exception caught in ReplicationProcessor main loop. We will attempt to continue.", ee);
/*     */       
/*     */       }
/* 273 */       catch (Error ee) {
/* 274 */         logger_.fatal("*** ERROR CAUGHT IN REPLICATION PROCESSOR THREAD. REPLICATION WILL NO LONGER FUNCTION.", ee);
/*     */         
/* 276 */         auditLogger_.fatal("*** ERROR CAUGHT IN REPLICATION PROCESSOR THREAD. REPLICATION WILL NO LONGER FUNCTION.", ee);
/*     */         
/* 278 */         throw ee;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startProcessor() {
/* 288 */     if (!this._processorStarted) {
/* 289 */       setName("Replication Processor");
/* 290 */       setPriority(4);
/*     */ 
/*     */       
/* 293 */       auditLogger_.debug("Starting Replication Processor thread.");
/*     */       
/* 295 */       start();
/*     */       
/* 297 */       auditLogger_.debug("Scheduling Replication Queue Process Timer to fire every " + this.cycleInterval_ + " ms.");
/*     */ 
/*     */       
/* 300 */       this.processQueueTimer_ = new Timer("Replication Queue Process Timer", true);
/* 301 */       this.processQueueTimer_.schedule(new ProcessReplicationQueueTask(), this.cycleInterval_, this.cycleInterval_);
/*     */ 
/*     */       
/* 304 */       StatusMgr.getInstance().registerStatusListener(this);
/* 305 */       this._processorStarted = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void dispatchImpl(ReplicationTransaction argTrans) {
/* 310 */     ReplicationTransaction trans = argTrans;
/* 311 */     IDtxReplicationDispatcher.DispatchResult result = IDtxReplicationDispatcher.DispatchResult.DISPATCH_ERROR_FAILURE;
/*     */     
/*     */     try {
/* 314 */       DtxReplicationService service = this._replicationServiceFactory.getService(trans.getServiceName());
/*     */ 
/*     */       
/* 317 */       result = service.dispatch(trans);
/*     */     }
/* 319 */     catch (RuntimeException|Error ex) {
/* 320 */       auditLogger_.fatal("REPLICATION PROCESSOR EXCEPTION", ex);
/* 321 */       this._eventLogWriter.writeRepQueueFailureEventLogEntry("FATAL", "REPLICATION PROCESSOR EXCEPTION", ex, argTrans
/* 322 */           .getWorkstationId());
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 329 */     if (IDtxReplicationDispatcher.DispatchResult.DISPATCH_SUCCESSFUL == result) {
/* 330 */       if (auditLogger_.isDebugEnabled()) {
/* 331 */         auditLogger_.debug("Dispatch successful - removing trans: " + trans.getTransactionId() + " from the queue.");
/*     */       }
/*     */ 
/*     */       
/* 335 */       ReplicationQueueAccessor.getInstance().removeObject(trans);
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 341 */       if (IDtxReplicationDispatcher.DispatchResult.DISPATCH_IMPOSSIBLE_TO_REPLICATE == result) {
/* 342 */         String persistableXml = trans.getPersistablesAsXml();
/* 343 */         if (StringUtils.countMatches(persistableXml, "<dao name=") == 1 && persistableXml
/* 344 */           .contains("name=\"EventLogEntry\"")) {
/* 345 */           logger_.warn("An event log entry is stuck in the replication queue. Can't take action.");
/* 346 */           result = IDtxReplicationDispatcher.DispatchResult.DISPATCH_ERROR_FAILURE;
/*     */         } else {
/*     */           
/* 349 */           logger_.warn("Impossible to replicate data. Service: [" + trans.getServiceName() + "]\n" + trans
/* 350 */               .getPersistablesAsXml());
/* 351 */           this._eventLogWriter.writeRepQueueNotPossibleEventLogEntry("WARN", "Impossible to replicate data. Service: " + trans
/*     */               
/* 353 */               .getServiceName() + "\n" + trans
/* 354 */               .getPersistablesAsXml(), argTrans.getWorkstationId());
/*     */           
/* 356 */           if (auditLogger_.isInfoEnabled()) {
/*     */ 
/*     */             
/* 359 */             String msg = "Dispatch failed - not possible to replicate this data; no further attempts will be made for trans " + trans.getTransactionId() + " This replication trans will be removed from the queue.";
/*     */             
/* 361 */             auditLogger_.info(msg);
/*     */           } 
/*     */           
/* 364 */           ReplicationQueueAccessor.getInstance().removeObject(trans);
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/* 369 */       if (trans.isExpired()) {
/* 370 */         if (auditLogger_.isInfoEnabled()) {
/* 371 */           auditLogger_.info("Dispatch failed - Removing transaction from the queue because it expired. " + trans
/* 372 */               .getTransactionId());
/*     */         }
/*     */         
/* 375 */         ReplicationQueueAccessor.getInstance().removeObject(trans);
/*     */       }
/*     */       else {
/*     */         
/* 379 */         if (IDtxReplicationDispatcher.DispatchResult.DISPATCH_OFFLINE_FAILURE == result) {
/* 380 */           trans.incrementOfflineFailures();
/*     */         }
/* 382 */         else if (IDtxReplicationDispatcher.DispatchResult.DISPATCH_ERROR_FAILURE == result) {
/* 383 */           trans.incrementErrorFailures();
/*     */         } else {
/*     */           
/* 386 */           throw new ReplicationException("Unkown DispatchResult: " + result);
/*     */         } 
/*     */         
/* 389 */         if (auditLogger_.isDebugEnabled()) {
/* 390 */           auditLogger_.debug("Dispatch failed - Setting ERROR failure count to " + trans
/* 391 */               .getFailedErrorAttempts() + " and OFFLINE failure count to " + trans
/* 392 */               .getFailedOfflineAttempts() + " for trans " + trans.getTransactionId() + " and service " + trans
/* 393 */               .getServiceName());
/*     */         }
/*     */         
/* 396 */         auditLogger_.debug("BEGIN existingTransactionFailed");
/* 397 */         ReplicationQueueAccessor.getInstance().existingTransactionFailed(result, trans);
/* 398 */         auditLogger_.debug("FNISHED existingTransactionFailed");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class ProcessReplicationQueueTask
/*     */     extends TimerTask
/*     */   {
/* 409 */     private ReplicationProcessor.RelegationLevel[] relegationLevels_ = null;
/* 410 */     private long cycleCount_ = 0L;
/*     */     
/*     */     ProcessReplicationQueueTask() {
/* 413 */       initRelegationLevels();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void run() {
/* 419 */       if (enoughTimePassed()) {
/* 420 */         int[] minMax = getMinMaxFailures(this.cycleCount_++);
/*     */         
/* 422 */         if (ReplicationProcessor.auditLogger_.isDebugEnabled()) {
/* 423 */           ReplicationProcessor.auditLogger_
/* 424 */             .debug("BEGIN ProcessReplicationQueueTask adding ReplicationProcessQueueEvent Min failures " + minMax[0] + " Max " + minMax[1] + " cycle count: " + this.cycleCount_);
/*     */         }
/*     */ 
/*     */         
/* 428 */         ReplicationProcessor.this.replicationEventQueue_.add(new ReplicationProcessQueueEvent(minMax[0], minMax[1]));
/*     */         
/* 430 */         if (ReplicationProcessor.auditLogger_.isDebugEnabled()) {
/* 431 */           ReplicationProcessor.auditLogger_
/* 432 */             .debug("END ProcessReplicationQueueTask adding ReplicationProcessQueueEvent Min failures " + minMax[0] + " Max " + minMax[1] + " cycle count: " + this.cycleCount_);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean enoughTimePassed() {
/* 439 */       long NOW = System.currentTimeMillis();
/* 440 */       if (ReplicationProcessor.this.queueProcessActive_ || NOW - ReplicationProcessor.this.lastQueueProcessCompleted_ < ReplicationProcessor.this.cycleInterval_) {
/* 441 */         return false;
/*     */       }
/*     */       
/* 444 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     private int[] getMinMaxFailures(long argCycleCount) {
/* 449 */       if (this.relegationLevels_.length == 0) {
/* 450 */         return new int[] { -1, -1 };
/*     */       }
/*     */       
/* 453 */       if (argCycleCount > 0L) {
/* 454 */         ReplicationProcessor.RelegationLevel previousLevel = null;
/*     */ 
/*     */         
/* 457 */         for (ReplicationProcessor.RelegationLevel element : this.relegationLevels_) {
/* 458 */           if (argCycleCount % element.getRetryAfterCycles() == 0L) {
/* 459 */             if (previousLevel != null) {
/* 460 */               return new int[] { element.getFailedAttempts(), previousLevel.getFailedAttempts() };
/*     */             }
/*     */             
/* 463 */             return new int[] { element.getFailedAttempts(), -1 };
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 471 */           previousLevel = element;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 476 */       return new int[] { -1, this.relegationLevels_[this.relegationLevels_.length - 1]
/* 477 */           .getFailedAttempts() };
/*     */     }
/*     */ 
/*     */     
/*     */     private void initRelegationLevels() {
/*     */       try {
/* 483 */         List<? extends RelegationLevelConfig> levelConfigs = DtxReplicationConfigHelper.getReplicationQueueConfig().getRelegationLevels();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 490 */         int lastFailedAttempts = -1;
/* 491 */         int lastRetryAfter = -1;
/*     */         
/* 493 */         for (RelegationLevelConfig current : levelConfigs) {
/* 494 */           if (current.getFailAttempts() <= lastFailedAttempts) {
/* 495 */             throw new ReplicationConfigException("RelegationLevel failed attempts attribute must ascend for every entry made.  No duplicates.  Invalid failed attempts: " + current
/*     */                 
/* 497 */                 .getFailAttempts());
/*     */           }
/*     */           
/* 500 */           if (current.getRetryAfterCycles() <= lastRetryAfter) {
/* 501 */             throw new ReplicationConfigException("RelegationLevel retry after attribute must ascend for every entry made.  No duplicates.  Invalid retry after: " + current
/*     */                 
/* 503 */                 .getFailAttempts());
/*     */           }
/*     */           
/* 506 */           lastFailedAttempts = current.getFailAttempts();
/* 507 */           lastRetryAfter = current.getRetryAfterCycles();
/*     */         } 
/*     */         
/* 510 */         if (!levelConfigs.isEmpty()) {
/* 511 */           this.relegationLevels_ = new ReplicationProcessor.RelegationLevel[levelConfigs.size()];
/* 512 */           int counter = this.relegationLevels_.length - 1;
/*     */           
/* 514 */           for (RelegationLevelConfig config : levelConfigs) {
/* 515 */             this.relegationLevels_[counter--] = new ReplicationProcessor.RelegationLevel(config
/* 516 */                 .getFailAttempts(), config.getRetryAfterCycles());
/*     */           }
/*     */         }
/*     */       
/*     */       }
/* 521 */       catch (Throwable ex) {
/* 522 */         this.relegationLevels_ = new ReplicationProcessor.RelegationLevel[0];
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class RelegationLevel
/*     */   {
/*     */     private final int failedAttempts_;
/*     */     
/*     */     private final int retryAfterCycles_;
/*     */     
/*     */     public RelegationLevel(int argFailedAttempts, int argRetryAfterCycles) {
/* 535 */       if (argFailedAttempts < 0) {
/* 536 */         throw new ReplicationConfigException("Invalid value: " + argFailedAttempts + " for failed attempts.  Check relegation levels in replication config.");
/*     */       }
/*     */ 
/*     */       
/* 540 */       if (argRetryAfterCycles < 0) {
/* 541 */         throw new ReplicationConfigException("Invalid value: " + argRetryAfterCycles + " for retry cycles.  Check relegation levels in replication config.");
/*     */       }
/*     */ 
/*     */       
/* 545 */       this.failedAttempts_ = argFailedAttempts;
/* 546 */       this.retryAfterCycles_ = argRetryAfterCycles;
/*     */     }
/*     */     
/*     */     public int getFailedAttempts() {
/* 550 */       return this.failedAttempts_;
/*     */     }
/*     */     
/*     */     public int getRetryAfterCycles() {
/* 554 */       return this.retryAfterCycles_;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\ReplicationProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */