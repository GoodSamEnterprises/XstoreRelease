/*     */ package dtv.pos.framework.comm;
/*     */ 
/*     */ import dtv.i18n.TranslationHelper;
/*     */ import dtv.ipc.server.IIpcService;
/*     */ import dtv.ipc.server.IpcRequest;
/*     */ import dtv.pos.framework.worker.IWorker;
/*     */ import dtv.pos.framework.worker.WorkerLocator;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.message.Message;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.beans.factory.NoSuchBeanDefinitionException;
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
/*     */ public class TaskService
/*     */   implements IIpcService
/*     */ {
/*  33 */   private static final Logger logger_ = Logger.getLogger(TaskService.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String ENV_MSG_PREFIX = "envMsg";
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private WorkerLocator _workerBeanLocator;
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> invoke(IpcRequest argRequest) {
/*  46 */     Map<String, String> params = argRequest.getParams();
/*  47 */     String description = params.get("id");
/*     */     
/*  49 */     if (!StringUtils.isEmpty(description) && !TranslationHelper.getInstance().isTranslationKey(description)) {
/*  50 */       description = TranslationHelper.getInstance().toTranslationKey("envMsg" + description);
/*     */       
/*  52 */       params = new LinkedHashMap<>(params);
/*  53 */       params.put("description", description);
/*  54 */       params.put("CLEAR_AFTER_TIME", "true");
/*     */     } 
/*     */     
/*  57 */     Message msg = new Message("ENVIRONMENT", params);
/*     */     
/*  59 */     logger_.info("Task message received: " + msg);
/*     */     
/*  61 */     MessageRouter.getInstance().routeMessage(msg);
/*  62 */     invokeWorkers(msg);
/*  63 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Map<String, String> processMessage(IpcRequest argRequest) {
/*  74 */     return invoke(argRequest);
/*     */   }
/*     */ 
/*     */   
/*     */   private void invokeWorkers(Message argMsg) {
/*  79 */     IWorker workers = lookupWorkers(argMsg);
/*     */     
/*  81 */     if (workers != null) {
/*     */       try {
/*  83 */         workers.performWork();
/*     */       }
/*  85 */       catch (Throwable ex) {
/*  86 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private IWorker lookupWorkers(Message argMsg) {
/*     */     try {
/*  93 */       StringBuilder name = new StringBuilder();
/*  94 */       name.append("appstatus-");
/*  95 */       name.append(argMsg.getDetail("task"));
/*  96 */       name.append("-");
/*  97 */       name.append(argMsg.getDetail("status"));
/*  98 */       return this._workerBeanLocator.getWorker(name.toString());
/*     */     }
/* 100 */     catch (NoSuchBeanDefinitionException ex) {
/* 101 */       logger_.trace("CAUGHT EXCEPTION", (Throwable)ex);
/*     */ 
/*     */       
/* 104 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\comm\TaskService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */