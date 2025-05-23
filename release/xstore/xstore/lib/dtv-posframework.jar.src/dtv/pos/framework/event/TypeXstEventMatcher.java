/*    */ package dtv.pos.framework.event;
/*    */ 
/*    */ import dtv.pos.iframework.action.IXstAction;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.event.IXstEventType;
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
/*    */ public class TypeXstEventMatcher
/*    */   implements IXstEventMatcher
/*    */ {
/*    */   private final int priority_;
/*    */   private final IXstEventType type_;
/*    */   private final IActionConfig action_;
/*    */   
/*    */   public TypeXstEventMatcher(int argPriority, IXstEventType argType, IActionConfig argActionConfig) {
/* 25 */     this.priority_ = argPriority;
/* 26 */     this.type_ = argType;
/* 27 */     this.action_ = argActionConfig;
/*    */   }
/*    */ 
/*    */   
/*    */   public IXstAction getAction() {
/* 32 */     return this.action_.getAction(null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean matches(IXstEvent argEvent) {
/* 37 */     return this.type_.equals(argEvent.getType());
/*    */   }
/*    */ 
/*    */   
/*    */   public int priority() {
/* 42 */     return this.priority_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\TypeXstEventMatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */