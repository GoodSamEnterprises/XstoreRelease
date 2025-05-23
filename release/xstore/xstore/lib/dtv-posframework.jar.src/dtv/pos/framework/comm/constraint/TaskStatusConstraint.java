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
/*    */ public class TaskStatusConstraint
/*    */   extends DetailMessageConstraint
/*    */ {
/*    */   public TaskStatusConstraint(String status) {
/* 19 */     this(status, true);
/*    */   }
/*    */   
/*    */   public TaskStatusConstraint(String status, boolean equals) {
/* 23 */     super("status", status, equals);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\comm\constraint\TaskStatusConstraint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */