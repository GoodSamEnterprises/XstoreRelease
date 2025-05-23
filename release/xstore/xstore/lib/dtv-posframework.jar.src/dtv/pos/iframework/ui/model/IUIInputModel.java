/*    */ package dtv.pos.iframework.ui.model;
/*    */ 
/*    */ import dtv.event.EventEnum;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IUIInputModel
/*    */   extends IUIModel
/*    */ {
/* 15 */   public static final EventEnum SET_USER_INPUT = new EventEnum("setUserInput");
/*    */   
/*    */   Object getUserInput();
/*    */   
/*    */   void setUserInput(Object paramObject);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\model\IUIInputModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */