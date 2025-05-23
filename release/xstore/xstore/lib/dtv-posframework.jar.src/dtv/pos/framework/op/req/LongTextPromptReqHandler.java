/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.event.IXstEventListener;
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LongTextPromptReqHandler
/*    */   extends AbstractPromptReqHandler
/*    */ {
/*    */   private IModeController _modeController;
/*    */   
/*    */   public void handleRequest(IOpRequest argRequest, IXstEventListener argListener, IModeController argModeController) {
/* 34 */     UIServices.invoke(() -> { this._modeController = argModeController; super.handleRequest(argRequest, argListener, argModeController); this._modeController.getUiController().showPopupLongText(); }true, true);
/*    */   }
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
/*    */   protected Collection<Component> getKeyStrokeTargets() {
/* 49 */     String componentName = "POPUP_LONG_TEXT_VIEW";
/* 50 */     Component c = this._modeController.getUiController().getFocusableChildComponent(componentName);
/*    */     
/* 52 */     return Arrays.asList(new Component[] { c });
/*    */   }
/*    */ 
/*    */   
/*    */   protected IPromptModel getPromptModel() {
/* 57 */     return (IPromptModel)this._modeController.getStationModel().getLongTextPromptModel();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\LongTextPromptReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */