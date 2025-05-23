/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.event.IXstEventListener;
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
/*    */ import dtv.pos.iframework.ui.model.IPromptModel;
/*    */ import dtv.pos.iframework.ui.model.IStationModel;
/*    */ import dtv.ui.UIServices;
/*    */ import java.awt.Component;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collection;
/*    */ import org.apache.log4j.Logger;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NotifyPromptReqHandler
/*    */   extends AbstractPromptReqHandler
/*    */ {
/* 31 */   private static final Logger logger = Logger.getLogger(NotifyPromptReqHandler.class);
/*    */ 
/*    */   
/*    */   private IModeController _modeController;
/*    */ 
/*    */   
/*    */   public void handleRequest(IOpRequest argRequest, IXstEventListener argListener, IModeController argModeController) {
/* 38 */     UIServices.invoke(() -> { this._modeController = argModeController; super.handleRequest(argRequest, argListener, argModeController); this._modeController.getUiController().showPopupNotify(); }true, true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isPopupHandler() {
/* 48 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Collection<Component> getKeyStrokeTargets() {
/* 53 */     String componentName = "POPUP_NOTIFY_VIEW";
/* 54 */     Component c = this._modeController.getUiController().getFocusableChildComponent(componentName);
/*    */     
/* 56 */     return Arrays.asList(new Component[] { c });
/*    */   }
/*    */ 
/*    */   
/*    */   protected IPromptModel getPromptModel() {
/* 61 */     IStationModel sm = this._modeController.getStationModel();
/*    */     
/* 63 */     if (sm == null) {
/* 64 */       logger.warn("NULL STATION MODEL?!?!?!");
/* 65 */       return null;
/*    */     } 
/*    */     
/* 68 */     return (IPromptModel)sm.getNotifyPromptModel();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\NotifyPromptReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */