/*    */ package dtv.pos.framework.ui.view;
/*    */ 
/*    */ import dtv.pos.framework.ui.component.XstReadOnlyTextArea;
/*    */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.ui.config.IPromptConfig;
/*    */ import dtv.pos.iframework.ui.model.INotifyPromptModel;
/*    */ import dtv.pos.iframework.ui.model.IPromptModel;
/*    */ import dtv.ui.swing.text.IStyler;
/*    */ import javax.swing.JTextPane;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class NotifyPromptView
/*    */   extends AbstractPromptView<INotifyPromptModel>
/*    */ {
/*    */   private final XstReadOnlyTextArea messageArea_;
/*    */   
/*    */   public NotifyPromptView() {
/* 39 */     INotifyPromptModel model = ((IModeController)this._modeProvider.get()).getStationModel().getNotifyPromptModel();
/* 40 */     this.messageArea_ = XstViewComponentFactory.getInstance().createReadOnlyTextArea();
/* 41 */     getPromptPanel().setContent(this.messageArea_.getDisplayComponent());
/*    */     
/* 43 */     setModel(model);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void setInstruction(IPromptModel argModel) {
/* 49 */     IPromptConfig config = argModel.getPromptConfig();
/*    */     
/* 51 */     if (config.isDataFieldConfigSet()) {
/* 52 */       IStyler styler = config.getDataFieldConfig().getStyler();
/* 53 */       if (styler != null) {
/* 54 */         this.messageArea_.setContentType("text/rtf");
/* 55 */         styler.apply((JTextPane)this.messageArea_.getTextPane());
/*    */       }
/*    */     
/*    */     }
/* 59 */     else if (config instanceof dtv.pos.framework.op.xflow.StubOpPromptConfig) {
/* 60 */       this.messageArea_.setContentType("text/html");
/* 61 */       this.messageArea_.setText(config.getMsgSectionConfig().getText(argModel.getPromptArgs()));
/*    */     }
/*    */     else {
/*    */       
/* 65 */       this.messageArea_.setContentType("text/plain");
/* 66 */       this.messageArea_.setText(config.getMsgSectionConfig().getText(argModel.getPromptArgs()));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\NotifyPromptView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */