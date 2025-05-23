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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IMessage
/*    */   extends Comparable
/*    */ {
/* 20 */   public static final EventEnum MESSAGE_ADDED_HINT = new EventEnum("MessageAdded");
/*    */   
/*    */   int getPriority();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\model\IMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */