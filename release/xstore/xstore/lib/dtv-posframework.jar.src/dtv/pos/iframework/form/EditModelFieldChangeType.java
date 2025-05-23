/*    */ package dtv.pos.iframework.form;
/*    */ 
/*    */ import dtv.event.IEventConstraint;
/*    */ import dtv.event.constraint.NameConstraint;
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
/*    */ public enum EditModelFieldChangeType
/*    */ {
/* 25 */   CARDINALITY_CHANGED,
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 32 */   ENUMERATION_CHANGED,
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 38 */   VALUE_CHANGED;
/*    */   EditModelFieldChangeType() {
/* 40 */     this.constraint_ = (IEventConstraint)new NameConstraint(this);
/*    */   }
/*    */ 
/*    */   
/*    */   private final IEventConstraint constraint_;
/*    */   
/*    */   public IEventConstraint toConstraint() {
/* 47 */     return this.constraint_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\EditModelFieldChangeType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */