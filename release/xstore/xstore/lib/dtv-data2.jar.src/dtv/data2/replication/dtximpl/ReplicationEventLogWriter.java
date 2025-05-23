/*    */ package dtv.data2.replication.dtximpl;
/*    */ 
/*    */ import dtv.data2.IPersistenceDefaults;
/*    */ import dtv.data2.access.IEventLogWriter;
/*    */ import dtv.util.DtvDate;
/*    */ import java.util.Date;
/*    */ import javax.inject.Inject;
/*    */ import org.apache.commons.lang3.exception.ExceptionUtils;
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
/*    */ 
/*    */ public class ReplicationEventLogWriter
/*    */ {
/* 23 */   private static final Logger logger_ = Logger.getLogger(ReplicationEventLogWriter.class);
/*    */   
/*    */   @Inject
/*    */   private IEventLogWriter eventLogWriter_;
/*    */   
/*    */   @Inject
/*    */   private IPersistenceDefaults _persistenceDefaults;
/*    */ 
/*    */   
/*    */   protected String getStackFrameForCaller() {
/* 33 */     for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
/* 34 */       if (!element.getClassName().equals(Thread.class.getName()) && 
/* 35 */         !element.getClassName().equals(getClass().getName())) {
/* 36 */         return element.toString();
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 41 */     return "";
/*    */   }
/*    */ 
/*    */   
/*    */   protected void writeEventLogEntry(String argCategory, String argLevel, String argEntryMessage, String argSource, long argWkstnId) {
/*    */     try {
/* 47 */       Long organizationId = this._persistenceDefaults.getOrganizationId();
/* 48 */       Integer rtlLocId = this._persistenceDefaults.getRetailLocationId();
/* 49 */       String threadName = Thread.currentThread().getName();
/* 50 */       DtvDate eventDate = new DtvDate();
/* 51 */       this.eventLogWriter_.writeEventLog(organizationId.longValue(), rtlLocId.intValue(), argWkstnId, argCategory, argLevel, argEntryMessage, (Date)eventDate, threadName, argSource, true);
/*    */     
/*    */     }
/* 54 */     catch (Throwable t) {
/* 55 */       logger_.error("An error occurred while writing a replication event log entry.", t);
/*    */     } 
/*    */   }
/*    */   
/*    */   protected void writeRepQueueFailureEventLogEntry(String argLevel, String argEntryMessage, long argWkstnId) {
/* 60 */     writeRepQueueFailureEventLogEntry(argLevel, argEntryMessage, getStackFrameForCaller(), argWkstnId);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void writeRepQueueFailureEventLogEntry(String argLevel, String argEntryMessage, String argSource, long argWkstnId) {
/* 65 */     writeEventLogEntry("dtv.sysadmin.data.repqueue.errors", argLevel, argEntryMessage, argSource, argWkstnId);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void writeRepQueueFailureEventLogEntry(String argLevel, String argEntryMessage, Throwable argThrowable, long argWkstnId) {
/* 70 */     writeRepQueueFailureEventLogEntry(argLevel, argEntryMessage, ExceptionUtils.getStackTrace(argThrowable), argWkstnId);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void writeRepQueueNoFailureEventLogEntry(String argLevel, String argEntryMessage, long argWkstnId) {
/* 76 */     writeEventLogEntry("dtv.sysadmin.data.repqueue.nofails", argLevel, argEntryMessage, 
/* 77 */         getStackFrameForCaller(), argWkstnId);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void writeRepQueueNotPossibleEventLogEntry(String argLevel, String argEntryMessage, long argWkstnId) {
/* 82 */     writeEventLogEntry("dtv.sysadmin.data.repqueue.notpossible", argLevel, argEntryMessage, 
/* 83 */         getStackFrameForCaller(), argWkstnId);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void writeRepQueueReadErrorEventLogEntry(String argLevel, String argEntryMessage, Throwable argThrowable, long argWkstnId) {
/* 88 */     writeEventLogEntry("dtv.sysadmin.data.repqueue.readerror", argLevel, argEntryMessage, 
/* 89 */         ExceptionUtils.getStackTrace(argThrowable), argWkstnId);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\ReplicationEventLogWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */