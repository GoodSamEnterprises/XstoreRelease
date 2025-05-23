/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.event.IXstEventListener;
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
/*    */ import dtv.pos.iframework.ui.model.IPromptModel;
/*    */ import dtv.pos.iframework.ui.model.IUIInputModel;
/*    */ import dtv.ui.UIServices;
/*    */ import java.awt.Component;
/*    */ import java.util.Collection;
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
/*    */ public class ViewportPromptReqHandler
/*    */   extends AbstractPromptReqHandler
/*    */ {
/*    */   private IModeController _modeController;
/*    */   
/*    */   public void handleRequest(IOpRequest argRequest, IXstEventListener argListener, IModeController argModeController) {
/* 32 */     UIServices.invoke(() -> { this._modeController = argModeController; super.handleRequest(argRequest, argListener, argModeController); this._modeController.getUiController().showFocusBar(); }true, true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isPopupHandler() {
/* 42 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected IUIInputModel getDataModel() {
/* 47 */     return (IUIInputModel)this._modeController.getStationModel().getCurrentListModel();
/*    */   }
/*    */ 
/*    */   
/*    */   protected Collection<Component> getKeyStrokeTargets() {
/* 52 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected IPromptModel getPromptModel() {
/* 57 */     return (IPromptModel)this._modeController.getStationModel().getTextPromptModel();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\ViewportPromptReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */