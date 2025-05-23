/*    */ package dtv.pos.framework.ui;
/*    */ 
/*    */ import dtv.event.IEventConstraint;
/*    */ import dtv.event.constraint.NameConstraint;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public enum UIModelChangeType
/*    */ {
/* 25 */   UPDATED,
/*    */ 
/*    */ 
/*    */   
/* 29 */   CLEARED,
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   HIDE;
/*    */   static {
/* 36 */     constraints_ = new HashMap<>();
/*    */   }
/*    */ 
/*    */   
/*    */   private static final Map<UIModelChangeType, IEventConstraint> constraints_;
/*    */   
/*    */   public IEventConstraint toConstraint() {
/*    */     NameConstraint nameConstraint;
/* 44 */     IEventConstraint constraint = constraints_.get(this);
/* 45 */     if (constraint == null) {
/* 46 */       nameConstraint = new NameConstraint(this);
/* 47 */       constraints_.put(this, nameConstraint);
/*    */     } 
/* 49 */     return (IEventConstraint)nameConstraint;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\UIModelChangeType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */