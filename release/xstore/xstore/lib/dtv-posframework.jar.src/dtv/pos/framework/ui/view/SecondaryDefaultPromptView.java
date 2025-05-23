/*    */ package dtv.pos.framework.ui.view;
/*    */ 
/*    */ import dtv.pos.framework.ui.component.XstReadOnlyTextArea;
/*    */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*    */ import dtv.pos.iframework.ui.model.IPromptModel;
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
/*    */ public class SecondaryDefaultPromptView
/*    */   extends AbstractSecondaryPromptView<IPromptModel>
/*    */ {
/*    */   private final XstReadOnlyTextArea messageArea_;
/*    */   
/*    */   public SecondaryDefaultPromptView() {
/* 29 */     this((IPromptModel)null);
/*    */   }
/*    */ 
/*    */   
/*    */   public SecondaryDefaultPromptView(IPromptModel argModel) {
/* 34 */     this.messageArea_ = XstViewComponentFactory.getInstance().createReadOnlyTextArea();
/* 35 */     getPromptPanel().setContent(this.messageArea_.getDisplayComponent());
/* 36 */     setModel(argModel);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected Class<IPromptModel> getModelClass() {
/* 42 */     return IPromptModel.class;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\SecondaryDefaultPromptView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */