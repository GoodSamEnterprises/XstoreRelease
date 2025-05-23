/*    */ package dtv.data2.dataserver;
/*    */ 
/*    */ import dtv.util.DtvThreadFactory;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.util.concurrent.Callable;
/*    */ import java.util.concurrent.ExecutorService;
/*    */ import java.util.concurrent.Executors;
/*    */ import java.util.concurrent.Future;
/*    */ import java.util.concurrent.ThreadFactory;
/*    */ import java.util.concurrent.TimeoutException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommandStreamReader
/*    */   implements Callable<String>
/*    */ {
/* 24 */   private final ExecutorService _executor = Executors.newSingleThreadExecutor((ThreadFactory)DtvThreadFactory.makeForDaemons("CommandStreamReader"));
/*    */ 
/*    */   
/*    */   private final InputStream stream_;
/*    */ 
/*    */   
/*    */   private boolean hasStarted_ = false;
/*    */ 
/*    */   
/*    */   public CommandStreamReader(InputStream argStream) {
/* 34 */     this.stream_ = argStream;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String call() throws Exception {
/* 42 */     this.hasStarted_ = true;
/* 43 */     BufferedReader r = new BufferedReader(new InputStreamReader(this.stream_));
/* 44 */     StringBuilder sb = new StringBuilder();
/*    */     String line;
/* 46 */     while ((line = r.readLine()) != null) {
/* 47 */       sb.append(line).append('\n');
/*    */     }
/* 49 */     return sb.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Future<String> start() {
/* 58 */     return this._executor.submit(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void stop() {
/* 66 */     this._executor.shutdown();
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
/*    */   public void waitForBegin(long argMillis) throws TimeoutException, InterruptedException {
/* 79 */     long timeoutTime = System.currentTimeMillis() + argMillis;
/* 80 */     while (System.currentTimeMillis() < timeoutTime && !this.hasStarted_) {
/* 81 */       Thread.sleep(100L);
/*    */     }
/* 83 */     if (!this.hasStarted_)
/* 84 */       throw new TimeoutException(); 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\CommandStreamReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */