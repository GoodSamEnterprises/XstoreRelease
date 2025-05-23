/*    */ package dtv.pos.framework.event;
/*    */ 
/*    */ import dtv.pos.iframework.action.IXstAction;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.ui.config.IActionConfig;
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
/*    */ public class InterfaceXstEventMatcher
/*    */   implements IXstEventMatcher
/*    */ {
/*    */   private final int priority_;
/*    */   private final Class<? extends IXstEvent> matchingClass_;
/*    */   private final IActionConfig action_;
/*    */   
/*    */   public InterfaceXstEventMatcher(int argPriority, Class<? extends IXstEvent> argClass, IActionConfig argActionConfig) {
/* 27 */     this.priority_ = argPriority;
/* 28 */     this.matchingClass_ = argClass;
/* 29 */     this.action_ = argActionConfig;
/*    */   }
/*    */ 
/*    */   
/*    */   public IXstAction getAction() {
/* 34 */     return this.action_.getAction(null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean matches(IXstEvent argEvent) {
/* 39 */     return this.matchingClass_.isAssignableFrom(argEvent.getClass());
/*    */   }
/*    */ 
/*    */   
/*    */   public int priority() {
/* 44 */     return this.priority_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\InterfaceXstEventMatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */