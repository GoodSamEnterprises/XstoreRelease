/*    */ package dtv.pos.framework.ui.component;
/*    */ 
/*    */ import dtv.ui.ComponentID;
/*    */ import dtv.ui.model.ICombinedListModel;
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
/*    */ public class XstActionList
/*    */   extends XstList
/*    */ {
/*    */   public XstActionList() {
/* 20 */     this(DtvList.TOUCH_READY_LIST_ID);
/*    */   }
/*    */   
/*    */   public XstActionList(ComponentID argId) {
/* 24 */     super(argId);
/*    */   }
/*    */   
/*    */   public XstActionList(ICombinedListModel<Object> model) {
/* 28 */     this(model, DtvList.TOUCH_READY_LIST_ID);
/*    */   }
/*    */   
/*    */   public XstActionList(ICombinedListModel<Object> model, ComponentID argId) {
/* 32 */     super(argId, model);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstActionList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */