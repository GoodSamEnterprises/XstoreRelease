/*    */ package dtv.pos.iframework.ui;
/*    */ 
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public enum ScrollingPolicy
/*    */ {
/*    */   private static final Logger logger_;
/*    */   private final int horizontal_;
/*    */   private final int vertical_;
/* 21 */   AS_NEEDED(30, 20),
/* 22 */   NEVER(31, 21),
/* 23 */   ALWAYS(32, 22);
/*    */   
/*    */   static {
/* 26 */     logger_ = Logger.getLogger(ScrollingPolicy.class);
/*    */   }
/*    */   public static ScrollingPolicy forName(IConfigObject argName) {
/* 29 */     if (argName == null) {
/* 30 */       return null;
/*    */     }
/*    */     try {
/* 33 */       return valueOf(argName.toString().trim().toUpperCase());
/*    */     }
/* 35 */     catch (IllegalArgumentException ex) {
/* 36 */       logger_.warn("CAUGHT EXCEPTION::" + argName.getSourceDescription(), ex);
/* 37 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ScrollingPolicy forName(String argName) {
/* 48 */     if (argName == null) {
/* 49 */       return null;
/*    */     }
/*    */     try {
/* 52 */       return valueOf(argName.trim().toUpperCase());
/*    */     }
/* 54 */     catch (IllegalArgumentException ex) {
/* 55 */       logger_.warn("CAUGHT EXCEPTION", ex);
/* 56 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ScrollingPolicy[] getInstances() {
/* 66 */     return values();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   ScrollingPolicy(int argHorizValue, int argVertValue) {
/* 73 */     this.horizontal_ = argHorizValue;
/* 74 */     this.vertical_ = argVertValue;
/*    */   }
/*    */   
/*    */   public int getHorizontalValue() {
/* 78 */     return this.horizontal_;
/*    */   }
/*    */   
/*    */   public int getVerticalValue() {
/* 82 */     return this.vertical_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\ScrollingPolicy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */