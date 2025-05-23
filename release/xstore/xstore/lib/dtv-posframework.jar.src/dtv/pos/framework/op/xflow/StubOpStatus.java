/*    */ package dtv.pos.framework.op.xflow;
/*    */ 
/*    */ import dtv.pos.iframework.op.OpStatus;
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
/*    */ public enum StubOpStatus
/*    */ {
/* 21 */   ERROR,
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 27 */   ERROR_HALT,
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   COMPLETE,
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 41 */   COMPLETE_HALT,
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 50 */   INCOMPLETE,
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 60 */   INCOMPLETE_HALT,
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 65 */   BREAKPOINT_FOUND;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public OpStatus getOpStatus() {
/* 73 */     switch (this) {
/*    */       case ERROR:
/* 75 */         return OpStatus.ERROR;
/*    */       case ERROR_HALT:
/* 77 */         return OpStatus.ERROR_HALT;
/*    */       case COMPLETE:
/* 79 */         return OpStatus.COMPLETE;
/*    */       case COMPLETE_HALT:
/* 81 */         return OpStatus.COMPLETE_HALT;
/*    */       case INCOMPLETE:
/* 83 */         return OpStatus.INCOMPLETE;
/*    */       case INCOMPLETE_HALT:
/* 85 */         return OpStatus.INCOMPLETE_HALT;
/*    */       case BREAKPOINT_FOUND:
/* 87 */         return OpStatus.BREAKPOINT_FOUND;
/*    */     } 
/* 89 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\xflow\StubOpStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */