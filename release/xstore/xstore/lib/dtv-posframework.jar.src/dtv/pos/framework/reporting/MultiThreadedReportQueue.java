/*    */ package dtv.pos.framework.reporting;
/*    */ 
/*    */ import dtv.util.NumberUtils;
/*    */ import java.util.concurrent.ArrayBlockingQueue;
/*    */ import java.util.concurrent.ExecutorService;
/*    */ import java.util.concurrent.ThreadPoolExecutor;
/*    */ import java.util.concurrent.TimeUnit;
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
/*    */ public class MultiThreadedReportQueue
/*    */   extends ReportQueue
/*    */ {
/*    */   private static final int DEFAULT_CORE_THREAD_POOL_COUNT = 5;
/*    */   private static final int DEFAULT_MAX_THREAD_POOL_COUNT = 10;
/*    */   private static final int DEFAULT_MAX_REQUEST_COUNT = 100;
/*    */   
/*    */   protected ExecutorService createExecutor() {
/* 28 */     Integer cps = NumberUtils.getInteger(MultiThreadedReportQueue.class.getName() + ".CoreThreadPoolSize");
/* 29 */     Integer mps = NumberUtils.getInteger(MultiThreadedReportQueue.class.getName() + ".MaxThreadPoolSize");
/* 30 */     Integer mReq = NumberUtils.getInteger(MultiThreadedReportQueue.class.getName() + ".MaxRequestCount");
/*    */     
/* 32 */     int coreThreadPoolSize = (cps == null) ? 5 : cps.intValue();
/* 33 */     int maxThreadPoolSize = (mps == null) ? 10 : mps.intValue();
/* 34 */     int maxReqCount = (mReq == null) ? 100 : mReq.intValue();
/*    */ 
/*    */ 
/*    */     
/* 38 */     ThreadPoolExecutor tpe = new ThreadPoolExecutor(coreThreadPoolSize, maxThreadPoolSize, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(maxReqCount), getThreadFactory());
/* 39 */     tpe.allowCoreThreadTimeOut(true);
/* 40 */     return tpe;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\MultiThreadedReportQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */