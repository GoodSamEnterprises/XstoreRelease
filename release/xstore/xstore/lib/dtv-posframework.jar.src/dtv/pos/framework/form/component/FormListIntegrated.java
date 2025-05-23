/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.pos.framework.ui.component.XstList;
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import dtv.ui.swing.DtvList;
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
/*    */ public class FormListIntegrated<T extends IFormModel>
/*    */   extends FormList<T>
/*    */ {
/*    */   protected XstList createListComponent() {
/* 24 */     return new XstList(DtvList.INTEGRATED_ID);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormListIntegrated.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */