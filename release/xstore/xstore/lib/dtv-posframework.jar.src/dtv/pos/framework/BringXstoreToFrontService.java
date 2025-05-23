/*    */ package dtv.pos.framework;
/*    */ 
/*    */ import dtv.ipc.server.IIpcService;
/*    */ import dtv.ipc.server.IpcRequest;
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
/*    */ public class BringXstoreToFrontService
/*    */   implements IIpcService
/*    */ {
/*    */   public Map<String, String> invoke(IpcRequest argRequest) {
/* 20 */     boolean wasAlwaysOnTop = StationController.getAppFrame().getFrameComponent().isAlwaysOnTop();
/* 21 */     StationController.getAppFrame().getFrameComponent().setAlwaysOnTop(true);
/* 22 */     StationController.getAppFrame().getFrameComponent().setAlwaysOnTop(wasAlwaysOnTop);
/* 23 */     StationController.getAppFrame().getFrameComponent().toFront();
/* 24 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\BringXstoreToFrontService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */