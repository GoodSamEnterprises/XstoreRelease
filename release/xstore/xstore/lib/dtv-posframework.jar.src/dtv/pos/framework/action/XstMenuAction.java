/*    */ package dtv.pos.framework.action;
/*    */ 
/*    */ import dtv.pos.framework.action.type.XstMenuActionType;
/*    */ import dtv.pos.framework.op.req.OpRequestType;
/*    */ import dtv.pos.iframework.action.IXstActionType;
/*    */ import dtv.pos.iframework.action.IXstMenuAction;
/*    */ import java.awt.event.ActionEvent;
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
/*    */ public class XstMenuAction
/*    */   extends XstDefaultAction
/*    */   implements IXstMenuAction
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 27 */   private ActionEvent _menuEvent = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public XstMenuAction(ActionEvent argMenuEvent) {
/* 34 */     super((IXstActionType)XstMenuActionType.MENU, null);
/* 35 */     this._menuEvent = argMenuEvent;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionEvent getMenuEvent() {
/* 41 */     return this._menuEvent;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getRequestType() {
/* 47 */     return OpRequestType.MENU.name();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getUiRequestKey() {
/* 53 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\XstMenuAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */