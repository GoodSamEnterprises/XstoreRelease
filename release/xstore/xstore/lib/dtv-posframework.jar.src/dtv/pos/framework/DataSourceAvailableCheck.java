/*     */ package dtv.pos.framework;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.HashMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class DataSourceAvailableCheck
/*     */ {
/*     */   static final String PROP_PREFIX = "dtv.pos.startup.dbcheck.";
/*     */   static final String PROP_IMPL = "dtv.pos.startup.dbcheck.impl";
/*     */   static final String PROP_ATTEMPTS = "dtv.pos.startup.dbcheck.attempts";
/*     */   static final String PROP_DELAY = "dtv.pos.startup.dbcheck.delay";
/*  36 */   private static final Logger _logger = Logger.getLogger(DataSourceAvailableCheck.class);
/*     */   private static final DataSourceAvailableCheck _impl;
/*  38 */   private static final IQueryKey<?> _healthQuery = (IQueryKey<?>)new QueryKey("CHECK_HEALTH", Object.class);
/*     */   
/*  40 */   private static final IFailureHandler _defaultHandler = new IFailureHandler()
/*     */     {
/*     */       public void handleFailure(DataSourceAvailableCheck.Statistics argStats)
/*     */       {
/*  44 */         DataSourceAvailableCheck._logger.fatal(StringUtils.fill("*", 60));
/*  45 */         DataSourceAvailableCheck._logger.fatal("Local data source unavailable!");
/*  46 */         DataSourceAvailableCheck._logger.fatal(StringUtils.fill("-", 4) + " Total Attempts = " + argStats._totalAttempts);
/*  47 */         DataSourceAvailableCheck._logger.fatal(StringUtils.fill("-", 4) + " Total Seconds Elapsed = " + (argStats._elapsedMillis / 1000L));
/*  48 */         DataSourceAvailableCheck._logger.fatal(StringUtils.fill("*", 60));
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  55 */     DataSourceAvailableCheck temp = null;
/*  56 */     String className = System.getProperty("dtv.pos.startup.dbcheck.impl");
/*     */     try {
/*  58 */       temp = (DataSourceAvailableCheck)Class.forName(className).newInstance();
/*     */     }
/*  60 */     catch (Exception ex) {
/*  61 */       _logger.debug("No instance of " + DataSourceAvailableCheck.class.getName() + " mapped to VM property [" + "dtv.pos.startup.dbcheck.impl" + "].  Using default implementation.");
/*     */       
/*  63 */       temp = new DataSourceAvailableCheck();
/*     */     } 
/*  65 */     _impl = temp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IFailureHandler defaultHandler() {
/*  73 */     return _defaultHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate() {
/*  80 */     validate(new IFailureHandler[] { _defaultHandler });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(IFailureHandler... argHandlers) {
/*  91 */     (new IFailureHandler[1])[0] = _defaultHandler; IFailureHandler[] handlers = (argHandlers == null) ? new IFailureHandler[1] : argHandlers;
/*     */ 
/*     */ 
/*     */     
/*  95 */     Statistics stats = new Statistics();
/*     */ 
/*     */     
/*  98 */     _logger.info("Data source availability check : ?");
/*  99 */     long startTime = System.currentTimeMillis();
/*     */     
/* 101 */     boolean passedCheck = _impl.validateImpl(stats);
/*     */     
/* 103 */     stats._elapsedMillis = System.currentTimeMillis() - startTime;
/* 104 */     _logger.info("Data source availability check : " + (passedCheck ? "PASSED" : "FAILED"));
/*     */     
/* 106 */     if (!passedCheck)
/*     */     {
/* 108 */       for (IFailureHandler handler : handlers) {
/* 109 */         handler.handleFailure(stats);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/* 114 */   private Integer _attempts = null;
/* 115 */   private Integer _delay = null;
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
/*     */ 
/*     */   
/*     */   public DataSourceAvailableCheck(int argAttempts, int argDelay) {
/* 133 */     this._attempts = Integer.valueOf(argAttempts);
/* 134 */     this._delay = Integer.valueOf(argDelay);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getAttempts() {
/* 142 */     if (this._attempts == null) {
/* 143 */       int attempts = Integer.parseInt(System.getProperty("dtv.pos.startup.dbcheck.attempts", "3"));
/* 144 */       this._attempts = Integer.valueOf((attempts < 0) ? 0 : attempts);
/*     */     } 
/* 146 */     return this._attempts.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getDelay() {
/* 155 */     if (this._delay == null) {
/* 156 */       int delay = Integer.parseInt(System.getProperty("dtv.pos.startup.dbcheck.delay", "10"));
/* 157 */       this._delay = Integer.valueOf((delay <= 0) ? 1 : delay);
/*     */     } 
/* 159 */     return this._delay.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAvailable() {
/*     */     try {
/* 168 */       DataFactory.getObjectByQuery(_healthQuery, new HashMap<>());
/*     */     }
/* 170 */     catch (Exception ex) {
/* 171 */       _logger.warn("Error interrogating online status of local DB: " + ex);
/* 172 */       return false;
/*     */     } 
/* 174 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean validateImpl(Statistics argStats) {
/* 185 */     int attempts = getAttempts();
/*     */ 
/*     */     
/* 188 */     if (attempts <= 0)
/*     */     {
/*     */       
/* 191 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 196 */       long delayMillis = (getDelay() * 1000);
/*     */ 
/*     */       
/* 199 */       for (int i = 0; i < attempts; i++) {
/* 200 */         argStats._totalAttempts++;
/* 201 */         long startTime = System.currentTimeMillis();
/*     */ 
/*     */         
/* 204 */         boolean available = isAvailable();
/* 205 */         if (_logger.isDebugEnabled()) {
/* 206 */           _logger.debug("Local data source is " + (available ? "online" : "OFFLINE"));
/*     */         }
/*     */         
/* 209 */         if (available)
/*     */         {
/*     */           
/* 212 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 217 */         boolean needToWait = (i + 1 < attempts);
/* 218 */         long waitMillis = Math.max(0L, delayMillis - System.currentTimeMillis() - startTime);
/*     */         
/* 220 */         if (_logger.isDebugEnabled()) {
/*     */           
/* 222 */           StringBuilder logMsg = new StringBuilder();
/* 223 */           logMsg.append("Local DB offline on attempt ").append(i + 1);
/*     */           
/* 225 */           if (needToWait) {
/* 226 */             logMsg.append(" -- Waiting ").append(waitMillis).append("ms before trying again.");
/*     */           }
/* 228 */           _logger.debug(logMsg);
/*     */         } 
/*     */ 
/*     */         
/* 232 */         if (needToWait) {
/* 233 */           Thread.sleep(waitMillis);
/*     */         }
/*     */       }
/*     */     
/* 237 */     } catch (Exception ex) {
/* 238 */       _logger.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */ 
/*     */     
/* 242 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataSourceAvailableCheck() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface IFailureHandler
/*     */   {
/*     */     void handleFailure(DataSourceAvailableCheck.Statistics param1Statistics);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Statistics
/*     */   {
/*     */     int _totalAttempts;
/*     */ 
/*     */     
/*     */     long _elapsedMillis;
/*     */ 
/*     */ 
/*     */     
/*     */     public long getElapsedMillis() {
/* 271 */       return this._elapsedMillis;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getTotalAttempts() {
/* 279 */       return this._totalAttempts;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\DataSourceAvailableCheck.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */