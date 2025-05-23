/*    */ package dtv.pos.framework.comm;
/*    */ 
/*    */ import dtv.event.EventDescriptor;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class TaskConstants
/*    */ {
/*    */   public static final String KEY_TASK = "task";
/*    */   public static final String KEY_STATUS = "status";
/*    */   public static final String KEY_ID = "id";
/*    */   public static final String KEY_ACTION = "action";
/*    */   public static final String KEY_DESCRIPTION = "description";
/*    */   public static final String KEY_FORMATTABLES = "IFormattable Array";
/*    */   public static final String SOURCE_XSTORE = "XSTORE";
/*    */   public static final String SOURCE_ENVIRONMENT = "ENVIRONMENT";
/*    */   public static final String TASK_NONE = "NONE";
/*    */   public static final String STATUS_RUNNING = "RUN";
/*    */   public static final String STATUS_SUCCESS = "SUCCESS";
/*    */   public static final String STATUS_WARNING = "WARNING";
/*    */   public static final String STATUS_ERROR = "ERROR";
/*    */   public static final String STATUS_REFRESH = "REFRESH";
/*    */   public static final String TASK_OPEN = "OPEN";
/*    */   public static final String TASK_CLOSE = "CLOSING";
/*    */   public static final String TASK_NOTIFY_MASTER_BACKUP_READY = "NOTIFY_MASTER_BACKUP_READY";
/*    */   public static final String TASK_UPDATE_SOFTWARE = "UPDATE_SOFTWARE";
/*    */   public static final String TASK_PREPARE_POLLING_FILE = "PREPARE_POLLING_FILE";
/*    */   public static final String TASK_CONSOLIDATE_LOGS = "CONSOLIDATE_LOGS";
/*    */   public static final String TASK_UNZIP_DOWNLOAD_FILES = "UNZIP_DOWNLOAD_FILES";
/*    */   public static final String TASK_DATALOADER = "DATALOADER";
/*    */   public static final String TASK_REPORTS = "REPORTS";
/*    */   public static final String TASK_NOTIFY_MASTER_DB_BACKUP_READY = "NOTIFY_MASTER_DB_BACKUP_READY";
/*    */   public static final String TASK_CLEAR_UPDATE_FILES = "CLEAR_UPDATE_FILES";
/*    */   public static final String TASK_POLL = "POLL";
/*    */   public static final String TASK_PROCESS_DOWNLOADS = "PROCESS_DOWNLOADS";
/*    */   public static final String TASK_BACKUP_DATABASE = "BACKUP_DATABASE";
/*    */   public static final String TASK_SERVER_BACKUP = "SERVER_BACKUP";
/*    */   public static final String TASK_ARCHIVE_DATABASE = "ARCHIVE_DATABASE";
/*    */   public static final String TASK_INIT_STORE_CLOSE = "INIT_STORE_CLOSE";
/*    */   public static final String TASK_FINALIZE_STORE_CLOSE = "FINALIZE_STORE_CLOSE";
/*    */   public static final String CLEAR_AFTER_TIME = "CLEAR_AFTER_TIME";
/* 69 */   public static final EventDescriptor MESSAGE_STATUS_UPDATE = new EventDescriptor("MessagesStatusCellUpdate");
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\comm\TaskConstants.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */