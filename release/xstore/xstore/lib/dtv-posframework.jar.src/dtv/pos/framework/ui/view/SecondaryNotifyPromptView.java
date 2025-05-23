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
/*    */ public class SecondaryNotifyPromptView
/*    */   extends AbstractSecondaryPromptView<INotifyPromptModel>
/*    */ {
/*    */   private final XstReadOnlyTextArea messageArea_;
/*    */   
/*    */   public SecondaryNotifyPromptView() {
/* 34 */     INotifyPromptModel model = ((IModeController)this._modeProvider.get()).getStationModel().getNotifyPromptModel();
/* 35 */     this.messageArea_ = XstViewComponentFactory.getInstance().createReadOnlyTextArea();
/* 36 */     getPromptPanel().setContent(this.messageArea_.getDisplayComponent());
/*    */     
/* 38 */     setModel(model);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected Class<INotifyPromptModel> getModelClass() {
/* 44 */     return INotifyPromptModel.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void setInstruction(IPromptModel argModel) {
/* 50 */     IPromptConfig config = argModel.getPromptConfig();
/*    */     
/* 52 */     if (config.isDataFieldConfigSet()) {
/* 53 */       IStyler styler = config.getDataFieldConfig().getStyler();
/* 54 */       if (styler != null) {
/* 55 */         this.messageArea_.setContentType("text/rtf");
/* 56 */         styler.apply((JTextPane)this.messageArea_.getTextPane());
/*    */       }
/*    */     
/* 59 */     } else if (config instanceof dtv.pos.framework.op.xflow.StubOpPromptConfig) {
/* 60 */       this.messageArea_.setContentType("text/html");
/* 61 */       this.messageArea_.setText(config.getMsgSectionConfig().getText(argModel.getPromptArgs()));
/*    */     } else {
/*    */       
/* 64 */       this.messageArea_.setContentType("text/plain");
/* 65 */       this.messageArea_.setText(config.getMsgSectionConfig().getText(argModel.getPromptArgs()));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\SecondaryNotifyPromptView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */