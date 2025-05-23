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
/*    */ public class TaskActionConstraint
/*    */   extends DetailMessageConstraint
/*    */ {
/*    */   public TaskActionConstraint(String action) {
/* 19 */     this(action, true);
/*    */   }
/*    */   
/*    */   public TaskActionConstraint(String action, boolean equals) {
/* 23 */     super("action", action, equals);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\comm\constraint\TaskActionConstraint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */