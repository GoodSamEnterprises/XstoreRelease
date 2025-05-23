/*    */ package dtv.pos.framework.ui.view;
/*    */ 
/*    */ import dtv.event.Event;
/*    */ import dtv.event.IEventAware;
/*    */ import dtv.pos.framework.ui.component.XstLongTextField;
/*    */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*    */ import dtv.pos.iframework.ui.config.IPromptConfig;
/*    */ import dtv.pos.iframework.ui.model.ITextPromptModel;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.event.DocumentListener;
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
/*    */ public final class LongTextPromptView
/*    */   extends AbstractPromptView<ITextPromptModel>
/*    */ {
/*    */   final XstLongTextField longTextField_;
/*    */   
/*    */   public LongTextPromptView() {
/* 39 */     ITextPromptModel model = ((IModeController)this._modeProvider.get()).getStationModel().getLongTextPromptModel();
/* 40 */     setModel(model);
/*    */     
/* 42 */     this.longTextField_ = XstViewComponentFactory.getInstance().createLongTextField();
/* 43 */     this.longTextField_.addDocumentListener((DocumentListener)getModel());
/* 44 */     getPromptPanel().setContent(this.longTextField_.getDisplayComponent());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JComponent getFocusComponent() {
/* 50 */     return this.longTextField_.getFocusComponent();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IEventAware createPrimaryHandler() {
/* 56 */     return (IEventAware)new TextModelChangeHandler();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected class TextModelChangeHandler
/*    */     extends AbstractPromptView<ITextPromptModel>.BasicModelChangeHandler
/*    */   {
/*    */     protected void doMoreGUIWork(Event argEvent) {
/* 65 */       super.doMoreGUIWork(argEvent);
/*    */       
/* 67 */       IPromptConfig promptConfig = LongTextPromptView.this.getModel().getPromptConfig();
/*    */ 
/*    */       
/* 70 */       IDataFieldConfig config = null;
/* 71 */       if (promptConfig.isDataFieldConfigSet()) {
/* 72 */         config = promptConfig.getDataFieldConfig();
/*    */       }
/* 74 */       LongTextPromptView.this.longTextField_.setDataFieldParameters(config);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\LongTextPromptView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */