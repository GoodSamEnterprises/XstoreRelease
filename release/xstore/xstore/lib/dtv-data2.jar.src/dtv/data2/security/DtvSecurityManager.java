/*     */ package dtv.data2.security;
/*     */ 
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import dtv.util.test.IIncidentReporter;
/*     */ import javax.inject.Inject;
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
/*     */ public class DtvSecurityManager
/*     */ {
/*  18 */   private static final Logger _logger = Logger.getLogger(DtvSecurityManager.class);
/*     */   
/*     */   private static final DtvSecurityManager _instance;
/*  21 */   private static final boolean _allowAllAccess = Boolean.getBoolean("dtv.util.security.AccessWarnings.disable");
/*     */ 
/*     */   
/*     */   static {
/*  25 */     String className = System.getProperty(DtvSecurityManager.class.getName());
/*     */     
/*     */     try {
/*  28 */       instance = (DtvSecurityManager)Class.forName(className).newInstance();
/*     */     }
/*  30 */     catch (Throwable ex) {
/*  31 */       instance = new DtvSecurityManager();
/*     */     } 
/*  33 */     _instance = instance;
/*     */   }
/*     */   @Inject
/*     */   private IIncidentReporter _testHarness;
/*     */   
/*     */   static {
/*     */     DtvSecurityManager instance;
/*     */   }
/*     */   
/*     */   public static DtvSecurityManager getInstance() {
/*  43 */     return _instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DtvSecurityManager() {
/*  50 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAllowed(String argContext) {
/*  58 */     return isAllowed(argContext, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAllowed(String argContext, boolean logException) {
/*  66 */     if (_allowAllAccess) {
/*  67 */       return true;
/*     */     }
/*     */     
/*  70 */     SecurityThreadContextConfig context = DtvSecurityConfigHelper.getInstance().getContext(argContext);
/*  71 */     if (context == null) {
/*  72 */       return true;
/*     */     }
/*     */     
/*  75 */     Throwable check = new Throwable("STACK TRACE");
/*  76 */     check.fillInStackTrace();
/*     */     
/*  78 */     boolean allowed = false;
/*  79 */     StackTraceElement ele = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     for (StackTraceElement elem : check.getStackTrace()) {
/*  88 */       if (context.allowed(elem)) {
/*  89 */         allowed = true;
/*     */         
/*     */         break;
/*     */       } 
/*  93 */       if (!context.ignored(elem) && ele == null) {
/*  94 */         ele = elem;
/*     */       }
/*     */     } 
/*     */     
/*  98 */     if (!allowed) {
/*  99 */       if (ele == null) {
/* 100 */         ele = check.getStackTrace()[0];
/*     */       }
/*     */       
/* 103 */       if (logException || this._testHarness.isRunning()) {
/* 104 */         _logger.warn("Illegal access [" + argContext + "] from " + ele
/* 105 */             .getClassName() + "#" + ele.getMethodName(), check);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 110 */       this._testHarness.reportIncident("Illegal access from UI Thread: " + argContext, this);
/*     */     } 
/* 112 */     return allowed;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\security\DtvSecurityManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */