/*    */ package dtv.pos.framework.ui.view;
/*    */ 
/*    */ import dtv.event.IEventConstraint;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.event.constraint.NameConstraint;
/*    */ import dtv.pos.iframework.IModel;
/*    */ import dtv.pos.iframework.ui.ActionDisplayType;
/*    */ import dtv.pos.iframework.ui.IUIController;
/*    */ import dtv.pos.iframework.ui.model.IMenuModel;
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
/*    */ public class ActionIconListView
/*    */   extends ActionListView
/*    */ {
/* 23 */   private static final IEventConstraint iconListConstraint_ = (IEventConstraint)new NameConstraint(ActionDisplayType.ICON_LIST);
/*    */   
/*    */   public ActionIconListView() {
/* 26 */     super(DtvList.TOUCH_READY_ICON_MENU_LIST_ID);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void deregisterEventHandlers(IMenuModel argModel) {
/* 32 */     this._eventManager.deregisterEventHandler(this.modelChangeHandler_, (IEventSource)argModel);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void registerEventHandlers(IMenuModel argModel) {
/* 38 */     this._eventManager.registerEventHandler(this.modelChangeHandler_, (IEventSource)argModel, iconListConstraint_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void showView(IUIController argController) {
/* 44 */     argController.showPopupIconMenu();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\ActionIconListView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */