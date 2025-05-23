/*    */ package dtv.pos.iframework.ui.model;
/*    */ 
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.action.IXstAction;
/*    */ import dtv.pos.iframework.ui.ActionDisplayType;
/*    */ import dtv.pos.iframework.ui.IMenuItem;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IMenuModel
/*    */   extends IActionModel
/*    */ {
/* 37 */   public static final EventEnum FORWARD_TRAVERSAL_CONSTRAINT = new EventEnum("FORWARD_TRAVERSAL_CONSTRAINT");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 43 */   public static final EventEnum BACKWARD_TRAVERSAL_CONSTRAINT = new EventEnum("BACKWARD_TRAVERSAL_CONSTRAINT");
/*    */   
/*    */   IXstAction getBackAction();
/*    */   
/*    */   IMenuItem getCurrentMenu();
/*    */   
/*    */   ActionDisplayType getCurrentMenuDisplayType();
/*    */   
/*    */   IMenuItem getMenu(String paramString);
/*    */   
/*    */   boolean isSubMenuCurrent();
/*    */   
/*    */   void previousMenu();
/*    */   
/*    */   void refreshMenu();
/*    */   
/*    */   void setCurrentMenu(IMenuItem paramIMenuItem);
/*    */   
/*    */   void setCurrentMenu(String paramString);
/*    */   
/*    */   void setModeController(IModeController paramIModeController);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\model\IMenuModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */