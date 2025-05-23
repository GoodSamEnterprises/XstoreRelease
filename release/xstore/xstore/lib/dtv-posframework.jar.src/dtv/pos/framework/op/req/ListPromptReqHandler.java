/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.event.IXstEventListener;
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
/*    */ import dtv.pos.iframework.ui.config.IPromptConfig;
/*    */ import dtv.pos.iframework.ui.model.IListPromptModel;
/*    */ import dtv.pos.iframework.ui.model.IPromptModel;
/*    */ import dtv.ui.UIServices;
/*    */ import java.awt.Component;
/*    */ import java.util.Arrays;
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
/*    */ public class ListPromptReqHandler
/*    */   extends AbstractPromptReqHandler
/*    */ {
/*    */   private IModeController _modeController;
/*    */   
/*    */   public void handleRequest(IOpRequest argRequest, IXstEventListener argListener, IModeController argModeController) {
/* 33 */     UIServices.invoke(() -> { this._modeController = argModeController; super.handleRequest(argRequest, argListener, argModeController); ListPromptRequest request = (ListPromptRequest)argRequest; this._modeController.getUiController().showPopupList(request.isDisplayFullScreen()); }true, true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isPopupHandler() {
/* 44 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Collection<Component> getKeyStrokeTargets() {
/* 51 */     Component c = this._modeController.getUiController().getFocusableChildComponent("POPUP_LIST_VIEW");
/*    */     
/* 53 */     return Arrays.asList(new Component[] { c });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected IPromptModel getPromptModel() {
/* 62 */     return (IPromptModel)this._modeController.getStationModel().getListPromptModel();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void setModelValues(IPromptModel model, PromptRequest request) {
/* 73 */     IListPromptModel<?> listPromptModel = (IListPromptModel)model;
/* 74 */     ListPromptRequest listPromptRequest = (ListPromptRequest)request;
/*    */     
/* 76 */     listPromptModel.setPromptArgs(request.getPromptArgs());
/* 77 */     listPromptModel.setValues((IPromptConfig)request.getPromptConfig(), listPromptRequest.getListItems(), listPromptRequest
/* 78 */         .getSelectedIndices());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\ListPromptReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */