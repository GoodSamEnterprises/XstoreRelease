/*    */ package dtv.pos.framework.form.component;
/*    */ 
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
/*    */ public class FormYesNoLabel<T extends IFormModel>
/*    */   extends FormLabel<T>
/*    */ {
/*    */   protected void setText(Object argValue) {
/* 19 */     if (argValue != null)
/* 20 */       getLabel().setText((new YesNoValue((Boolean)argValue)).toString()); 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormYesNoLabel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */