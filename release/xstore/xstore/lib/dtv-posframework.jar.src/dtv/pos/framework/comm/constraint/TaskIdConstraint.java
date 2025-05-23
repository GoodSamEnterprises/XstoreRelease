/*    */ package dtv.pos.framework.comm.constraint;
/*    */ 
/*    */ import dtv.util.message.constraint.DetailMessageConstraint;
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
/*    */ public class TaskIdConstraint
/*    */   extends DetailMessageConstraint
/*    */ {
/*    */   public TaskIdConstraint(String id) {
/* 19 */     this(id, true);
/*    */   }
/*    */   
/*    */   public TaskIdConstraint(String id, boolean equals) {
/* 23 */     super("id", id, equals);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\comm\constraint\TaskIdConstraint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */