/*    */ package dtv.pos.framework.ui.view;
/*    */ 
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import dtv.pos.ui.component.PosComponentFactory;
/*    */ import dtv.pos.ui.component.PosFormView;
/*    */ import javax.swing.JComponent;
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
/*    */ public final class FormView
/*    */   extends AbstractUIView<IFormModel>
/*    */ {
/*    */   private final PosFormView formView_;
/*    */   
/*    */   public FormView() {
/* 24 */     this(null);
/*    */   }
/*    */   
/*    */   private FormView(IFormModel model) {
/* 28 */     setModel(model);
/* 29 */     this.formView_ = PosComponentFactory.getInstance().createFormView();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JComponent getDisplayComponent() {
/* 41 */     return (JComponent)getFormView();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JComponent getFocusComponent() {
/* 52 */     return (JComponent)getFormView();
/*    */   }
/*    */   
/*    */   private PosFormView getFormView() {
/* 56 */     return this.formView_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\FormView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */