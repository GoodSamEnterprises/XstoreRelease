/*    */ package dtv.pos.framework.comm;
/*    */ 
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.event.Eventor;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.event.eventor.DefaultEventor;
/*    */ import dtv.ipc.server.IIpcService;
/*    */ import dtv.ipc.server.IpcRequest;
/*    */ import dtv.pos.environment.EnvironmentSystemErrorStatus;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class EnvironmentErrorStatusService
/*    */   implements IIpcService, IEventSource
/*    */ {
/* 26 */   public static final EventEnum ENVIRONMENT_ERROR_STATUS_CHANGED = new EventEnum("EnvironmentErrorStatusChanged");
/*    */ 
/*    */   
/* 29 */   private final Eventor _eventor = (Eventor)new DefaultEventor(this);
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, String> invoke(IpcRequest argRequest) {
/* 34 */     EnvironmentSystemErrorStatus errorStatus = new EnvironmentSystemErrorStatus();
/*    */     
/* 36 */     if (argRequest != null && 
/* 37 */       Boolean.valueOf((String)argRequest.getParams().get("error")).booleanValue()) {
/* 38 */       errorStatus.setError(true);
/*    */     }
/*    */ 
/*    */     
/* 42 */     this._eventor.post(ENVIRONMENT_ERROR_STATUS_CHANGED, errorStatus);
/*    */     
/* 44 */     return new HashMap<>();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\comm\EnvironmentErrorStatusService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */