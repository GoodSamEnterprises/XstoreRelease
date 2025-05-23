/*    */ package dtv.data2.dataloader;
/*    */ 
/*    */ import dtv.data2.IPersistenceDefaults;
/*    */ import dtv.data2.dataloader.pluggable.DeploymentInfo;
/*    */ import dtv.util.StringUtils;
/*    */ import org.apache.logging.log4j.Level;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ import org.apache.logging.log4j.ThreadContext;
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
/*    */ public class DataLoaderEventLogger
/*    */ {
/*    */   private static final String BASE_CATEGORY = "dtv.xstore.dataloader";
/* 24 */   private static final Logger LOG = LogManager.getLogger("dtv.xstore.dataloader");
/* 25 */   private static ThreadLocal<Logger> currentEventLogger_ = new ThreadLocal<Logger>()
/*    */     {
/*    */       protected Logger initialValue() {
/* 28 */         return DataLoaderEventLogger.LOG;
/*    */       }
/*    */     };
/* 31 */   private static ThreadLocal<IPersistenceDefaults> _persistenceDefaults = new ThreadLocal<>();
/*    */ 
/*    */   
/*    */   public static void error(CharSequence o) {
/* 35 */     log(Level.ERROR, o);
/*    */   }
/*    */   
/*    */   public static void error(CharSequence o, Throwable t) {
/* 39 */     log(Level.ERROR, o, t);
/*    */   }
/*    */   
/*    */   public static void fatal(CharSequence o) {
/* 43 */     log(Level.FATAL, o);
/*    */   }
/*    */   
/*    */   public static void fatal(CharSequence o, Throwable t) {
/* 47 */     log(Level.FATAL, o, t);
/*    */   }
/*    */   
/*    */   public static void info(CharSequence msg) {
/* 51 */     log(Level.INFO, msg);
/*    */   }
/*    */   
/*    */   public static void log(Level argLevel, CharSequence argMsg) {
/* 55 */     log(argLevel, argMsg, null);
/*    */   }
/*    */   
/*    */   public static void log(Level argLevel, CharSequence argMsg, Throwable t) {
/* 59 */     Logger logger = getLogger();
/* 60 */     if (logger.isEnabled(argLevel)) {
/* 61 */       IPersistenceDefaults pd = _persistenceDefaults.get();
/* 62 */       if (pd != null) {
/* 63 */         ThreadContext.put("OrganizationId", String.valueOf(pd.getOrganizationId()));
/* 64 */         ThreadContext.put("RetailLocationId", String.valueOf(pd.getRetailLocationId()));
/* 65 */         ThreadContext.put("WorkstationId", String.valueOf(pd.getWorkstationId()));
/*    */       } 
/* 67 */       logger.log(argLevel, argMsg, t);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void setCurrentHeader(IPersistenceDefaults argPersistenceDefaults, DeploymentInfo argHeader) {
/* 72 */     _persistenceDefaults.set(argPersistenceDefaults);
/* 73 */     if (argHeader == null || StringUtils.isEmpty(argHeader.getDownloadId())) {
/* 74 */       currentEventLogger_.set(LOG);
/*    */     } else {
/*    */       
/* 77 */       currentEventLogger_
/* 78 */         .set(LogManager.getLogger("dtv.xstore.dataloader.download_id=" + argHeader.getDownloadId()));
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void warn(String msg) {
/* 83 */     log(Level.WARN, msg);
/*    */   }
/*    */   
/*    */   public static void warn(String msg, Throwable t) {
/* 87 */     log(Level.WARN, msg, t);
/*    */   }
/*    */   
/*    */   private static Logger getLogger() {
/* 91 */     return currentEventLogger_.get();
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\DataLoaderEventLogger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */