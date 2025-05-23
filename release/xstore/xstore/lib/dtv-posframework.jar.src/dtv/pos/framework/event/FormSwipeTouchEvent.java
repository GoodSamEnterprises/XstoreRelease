/*    */ package dtv.pos.framework.event;
/*    */ 
/*    */ import dtv.pos.iframework.event.IXstEventType;
/*    */ import dtv.ui.touch.SwipeEvent;
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
/*    */ public class FormSwipeTouchEvent
/*    */   extends XstEvent
/*    */ {
/*    */   public FormSwipeTouchEvent(IXstEventType argEventType, Object argEventData, String argEventName, Object argSource) {
/* 27 */     super(argEventType, argEventData, argEventName, argSource);
/*    */   }
/*    */   
/*    */   public int getSwipedDirection() {
/* 31 */     SwipeEvent event = (SwipeEvent)getData();
/* 32 */     return event.getSwipeEventType();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\FormSwipeTouchEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */