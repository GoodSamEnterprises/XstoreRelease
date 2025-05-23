/*    */ package dtv.data2.access.status;
/*    */ 
/*    */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*    */ import dtv.data2.access.datasource.DataSourceFactory;
/*    */ import dtv.data2.access.exception.FailoverException;
/*    */ import dtv.data2.access.exception.ForcedOfflineException;
/*    */ import dtv.ipc.server.IIpcService;
/*    */ import dtv.ipc.server.IpcRequest;
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
/*    */ public class SetDBStatusService
/*    */   implements IIpcService
/*    */ {
/*    */   public Map<String, String> invoke(IpcRequest argRequest) {
/* 26 */     StatusMgr statusMgr = StatusMgr.getInstance();
/* 27 */     String dataSourceName = (String)argRequest.getParams().get("dataSourceName");
/*    */ 
/*    */     
/* 30 */     DataSourceDescriptor dataSourceDescriptor = DataSourceFactory.getInstance().getDataSourceDescriptor(dataSourceName);
/*    */     
/* 32 */     if (argRequest.getMethod().equals("forceDataSourceOffline")) {
/* 33 */       dataSourceDescriptor.setForcedOffline(true);
/* 34 */       statusMgr.notifyOffline(dataSourceName, 
/* 35 */           (FailoverException)ForcedOfflineException.getNewException("Forced offline by Xenvironment", dataSourceName));
/*    */     }
/* 37 */     else if (argRequest.getMethod().equals("forceDataSourceOnline")) {
/* 38 */       dataSourceDescriptor.setForcedOffline(false);
/* 39 */       statusMgr.notifyOnline(dataSourceName);
/*    */     } 
/*    */     
/* 42 */     return new HashMap<>();
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\status\SetDBStatusService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */