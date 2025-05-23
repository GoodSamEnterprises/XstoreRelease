/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.pos.framework.ui.component.XstCenterLabelWrapping;
/*    */ import dtv.pos.framework.ui.component.XstLabel;
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
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
/*    */ public class FormLabelWrappingCenter<T extends IFormModel>
/*    */   extends FormLabel<T>
/*    */ {
/*    */   protected XstLabel createLabel() {
/* 22 */     return (XstLabel)new XstCenterLabelWrapping();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormLabelWrappingCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */