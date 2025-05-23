/*     */ package dtv.pos.framework.process;
/*     */ 
/*     */ import dtv.pos.iframework.XstApplication;
/*     */ import dtv.pos.iframework.event.IExitEvent;
/*     */ import dtv.pos.iframework.event.IExitListener;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
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
/*     */ public class LaunchedProcessManager
/*     */   implements ILaunchedProcessManager
/*     */ {
/*  25 */   private static final Logger logger_ = Logger.getLogger(LaunchedProcessManager.class);
/*     */   private static final int SLEEP_TIME = 1000;
/*     */   private static final ILaunchedProcessManager INSTANCE;
/*     */   
/*     */   static {
/*  30 */     ILaunchedProcessManager temp = null;
/*  31 */     String className = System.getProperty(ILaunchedProcessManager.class.getName());
/*     */     try {
/*  33 */       temp = (ILaunchedProcessManager)Class.forName(className).newInstance();
/*     */     }
/*  35 */     catch (Exception ex) {
/*  36 */       temp = new LaunchedProcessManager();
/*     */     } 
/*  38 */     INSTANCE = temp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ILaunchedProcessManager getInstance() {
/*  46 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isProcessRunning(Process p) {
/*  56 */     if (p == null) {
/*  57 */       return false;
/*     */     }
/*     */     try {
/*  60 */       p.exitValue();
/*     */     
/*     */     }
/*  63 */     catch (IllegalThreadStateException ex) {
/*     */       
/*  65 */       return true;
/*     */     } 
/*  67 */     return false;
/*     */   }
/*     */   
/*  70 */   Map<String, Process> processMap_ = new HashMap<>();
/*     */   private final MonitorThread thread_;
/*     */   
/*  73 */   private final IExitListener exitListener_ = new IExitListener()
/*     */     {
/*     */       public void exiting(IExitEvent argEvent) {
/*  76 */         for (Map.Entry<String, Process> entry : LaunchedProcessManager.this.processMap_.entrySet()) {
/*     */           try {
/*  78 */             ((Process)entry.getValue()).destroy();
/*     */           }
/*  80 */           catch (Throwable throwable) {}
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected LaunchedProcessManager() {
/*  89 */     XstApplication.addExitListener(this.exitListener_);
/*  90 */     this.thread_ = new MonitorThread();
/*  91 */     this.thread_.start();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isProcessRunning(String argProcessKey) {
/*  97 */     Process p = this.processMap_.get(argProcessKey);
/*  98 */     return isProcessRunning(p);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void monitor(IProcMonitorConfig argConfig, Process argProcess) {
/* 105 */     if (logger_.isInfoEnabled()) {
/* 106 */       logger_.info("monitoring " + argConfig.getKey());
/*     */     }
/*     */     
/* 109 */     File outputFile = argConfig.getOutputFile();
/* 110 */     if (outputFile != null) {
/*     */       
/*     */       try {
/* 113 */         StreamToFilePumper inputPumper = new StreamToFilePumper(argProcess.getInputStream(), outputFile, argConfig.appendOutputfile());
/*     */ 
/*     */ 
/*     */         
/* 117 */         StreamToFilePumper errorPumper = new StreamToFilePumper(argProcess.getErrorStream(), argConfig.getOutputFile(), argConfig.appendOutputfile());
/*     */         
/* 119 */         inputPumper.start();
/* 120 */         errorPumper.start();
/*     */       }
/* 122 */       catch (IOException ex) {
/* 123 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     }
/* 126 */     this.processMap_.put(argConfig.getKey(), argProcess);
/*     */   }
/*     */   
/*     */   protected class MonitorThread
/*     */     extends Thread
/*     */   {
/*     */     MonitorThread() {
/* 133 */       setName("LaunchedProcessMonitorThread");
/* 134 */       setDaemon(true);
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/*     */       while (true) {
/*     */         try {
/* 141 */           for (Iterator<Map.Entry<String, Process>> iter = LaunchedProcessManager.this.processMap_.entrySet().iterator(); iter.hasNext(); ) {
/* 142 */             Map.Entry<String, Process> entry = iter.next();
/* 143 */             Process p = entry.getValue();
/*     */             
/* 145 */             if (!LaunchedProcessManager.isProcessRunning(p)) {
/* 146 */               if (LaunchedProcessManager.logger_.isInfoEnabled()) {
/* 147 */                 LaunchedProcessManager.logger_.info("process [" + (String)entry.getKey() + "] ended with exit code " + p.exitValue());
/*     */               }
/* 149 */               iter.remove();
/*     */             } 
/*     */           } 
/* 152 */           sleep(1000L);
/*     */         }
/* 154 */         catch (Throwable t) {
/* 155 */           LaunchedProcessManager.logger_.error("CAUGHT EXCEPTION", t);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\process\LaunchedProcessManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */