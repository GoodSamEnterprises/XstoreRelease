/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.pos.framework.ui.component.XstList;
/*    */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import dtv.ui.swing.DtvList;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FormBasicList<T extends IFormModel>
/*    */   extends FormList<T>
/*    */ {
/*    */   protected XstList createListComponent() {
/* 14 */     return XstViewComponentFactory.getInstance().createList(DtvList.BASIC_LIST_ID);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormBasicList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */