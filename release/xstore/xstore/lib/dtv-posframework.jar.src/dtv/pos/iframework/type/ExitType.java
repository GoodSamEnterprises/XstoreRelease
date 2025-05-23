/*    */ package dtv.pos.iframework.type;
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
/*    */ public enum ExitType
/*    */   implements IExitType
/*    */ {
/* 15 */   NO_DATABASE(-5),
/*    */ 
/*    */   
/* 18 */   FORCE(-6),
/*    */ 
/*    */   
/* 21 */   CONFIG(-1),
/*    */ 
/*    */   
/* 24 */   DISASTER(-4),
/*    */ 
/*    */   
/* 27 */   UNABLE_TO_START(-7),
/*    */ 
/*    */   
/* 30 */   NORMAL(0),
/*    */ 
/*    */   
/* 33 */   SYSTEM_CLOSED(0),
/*    */ 
/*    */   
/* 36 */   DUPLICATE_INSTANCE(-8),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 42 */   RESTART_REQUESTED(1),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 48 */   CONFIG_PATH_CHANGED_RESTART(7);
/*    */ 
/*    */ 
/*    */   
/*    */   private final int exitLevel_;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   ExitType(int argExitLevel) {
/* 58 */     this.exitLevel_ = argExitLevel;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getExitLevel() {
/* 68 */     return this.exitLevel_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 77 */     return name();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\type\ExitType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */