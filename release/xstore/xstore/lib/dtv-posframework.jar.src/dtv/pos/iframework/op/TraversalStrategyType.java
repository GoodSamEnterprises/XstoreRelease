/*    */ package dtv.pos.iframework.op;
/*    */ 
/*    */ import org.apache.log4j.Logger;
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
/*    */ public enum TraversalStrategyType
/*    */ {
/* 17 */   FORWARD(">>", "forward"),
/*    */   
/* 19 */   REVERSE("<<", "reverse"),
/*    */   
/* 21 */   FIND_BREAKPOINT("<*", "findBreakpoint");
/*    */   
/*    */   static {
/* 24 */     logger_ = Logger.getLogger(TraversalStrategyType.class);
/*    */   }
/*    */ 
/*    */   
/*    */   private static final Logger logger_;
/*    */   private String _logPrefix;
/*    */   private String _longName;
/*    */   
/*    */   public static TraversalStrategyType forName(String argName) {
/* 33 */     if (argName == null) {
/* 34 */       return null;
/*    */     }
/*    */     try {
/* 37 */       return valueOf(argName.trim().toUpperCase());
/*    */     }
/* 39 */     catch (Exception ex) {
/* 40 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 41 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   TraversalStrategyType(String argLogPrefix, String argName) {
/* 54 */     this._logPrefix = argLogPrefix;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getLogPrefix() {
/* 61 */     return this._logPrefix;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getLongName() {
/* 66 */     return this._longName + "TraversalStrategy";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\TraversalStrategyType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */