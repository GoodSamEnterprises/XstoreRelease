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
/*    */ public class TaskNameConstraint
/*    */   extends DetailMessageConstraint
/*    */ {
/*    */   public TaskNameConstraint(String name) {
/* 19 */     this(name, true);
/*    */   }
/*    */   
/*    */   public TaskNameConstraint(String name, boolean equals) {
/* 23 */     super("task", name, equals);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\comm\constraint\TaskNameConstraint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */