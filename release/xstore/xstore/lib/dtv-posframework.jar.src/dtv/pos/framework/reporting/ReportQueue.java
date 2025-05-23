/*     */ package dtv.pos.framework.reporting;
/*     */ 
/*     */ import dtv.pos.iframework.reporting.IReportFill;
/*     */ import dtv.util.DtvThreadFactory;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReportQueue
/*     */ {
/*  24 */   private static final Logger _logger = Logger.getLogger(ReportQueue.class);
/*  25 */   private static final AtomicBoolean _instantiated = new AtomicBoolean(false);
/*     */   private static final ReportQueue _instance;
/*     */   protected final Map<Integer, Future<Boolean>> tasks_;
/*     */   
/*     */   static {
/*  30 */     String implName = System.getProperty(ReportQueue.class.getName());
/*  31 */     if (StringUtils.isEmpty(implName)) {
/*  32 */       _instance = new ReportQueue();
/*     */     } else {
/*     */       
/*     */       try {
/*  36 */         Class<?> impl = Class.forName(implName);
/*  37 */         _instance = (ReportQueue)impl.newInstance();
/*     */       }
/*  39 */       catch (Exception ex) {
/*     */         
/*  41 */         throw new ExceptionInInitializerError(ex);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private final ThreadFactory threadFactory_; protected final ExecutorService exec_;
/*     */   
/*     */   public static ReportQueue getInstance() {
/*  48 */     return _instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReportQueue() {
/*  57 */     if (!_instantiated.compareAndSet(false, true)) {
/*  58 */       throw new IllegalStateException("Cannot instantiate multiple singletons");
/*     */     }
/*  60 */     this.tasks_ = new HashMap<>();
/*  61 */     this.threadFactory_ = (ThreadFactory)DtvThreadFactory.makeForDaemons("DtvReport");
/*  62 */     this.exec_ = createExecutor();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean cancelReport(IReportFill argFill) {
/*  67 */     boolean result = false;
/*  68 */     Future<?> task = this.tasks_.get(Integer.valueOf(argFill.getFillId()));
/*  69 */     if (task != null) {
/*  70 */       result = task.cancel(true);
/*     */     }
/*  72 */     cleanupTasks();
/*  73 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillReport(IReportFill argFill) {
/*  78 */     cleanupTasks();
/*  79 */     argFill.setStatus(ReportFillStatus.PENDING);
/*  80 */     _logger.info("Processing report [" + argFill.getDescription() + "]...");
/*  81 */     Future<Boolean> task = this.exec_.submit(createReportFillProcessor(argFill));
/*  82 */     this.tasks_.put(Integer.valueOf(argFill.getFillId()), task);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void cleanupTasks() {
/*  89 */     for (Integer key : new ArrayList(this.tasks_.keySet())) {
/*  90 */       Future<?> task = this.tasks_.get(key);
/*  91 */       if (task != null && task.isDone()) {
/*  92 */         this.tasks_.remove(key);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected ExecutorService createExecutor() {
/*  99 */     return Executors.newSingleThreadExecutor(getThreadFactory());
/*     */   }
/*     */ 
/*     */   
/*     */   protected Callable<Boolean> createReportFillProcessor(IReportFill argFill) {
/* 104 */     return new ReportFillProcessor(argFill);
/*     */   }
/*     */ 
/*     */   
/*     */   protected ThreadFactory getThreadFactory() {
/* 109 */     return this.threadFactory_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\ReportQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */