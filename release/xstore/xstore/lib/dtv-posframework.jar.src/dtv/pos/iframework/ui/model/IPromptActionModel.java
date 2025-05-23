/*    */ package dtv.pos.iframework.ui.model;
/*    */ 
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.pos.iframework.action.IXstAction;
/*    */ import dtv.pos.iframework.event.IXstEventListener;
/*    */ import dtv.pos.iframework.ui.ActionDisplayType;
/*    */ import java.awt.Component;
/*    */ import java.util.Collection;
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
/*    */ public interface IPromptActionModel
/*    */   extends IActionModel
/*    */ {
/* 26 */   public static final EventEnum ADD_ACTION = new EventEnum("add action");
/* 27 */   public static final EventEnum REMOVE_ACTION = new EventEnum("remove action");
/*    */   
/*    */   void addAction(IXstAction paramIXstAction);
/*    */   
/*    */   void evaluateVisibility();
/*    */   
/*    */   void removeAction(IXstAction paramIXstAction);
/*    */   
/*    */   void setValues(Collection<IXstAction> paramCollection, ActionDisplayType paramActionDisplayType, IUIInputModel paramIUIInputModel, Collection<Component> paramCollection1, IXstEventListener paramIXstEventListener);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\model\IPromptActionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */