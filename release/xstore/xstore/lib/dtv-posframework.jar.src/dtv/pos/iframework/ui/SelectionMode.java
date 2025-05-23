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
/*    */ 
/*    */ 
/*    */ public enum SelectionMode
/*    */ {
/* 20 */   SINGLE_SELECTION(0),
/* 21 */   SINGLE_INTERVAL_SELECTION(1),
/* 22 */   MULTIPLE_SELECTION(2), NO_SELECTION(-1); private static final Logger logger_;
/*    */   
/*    */   static {
/* 25 */     logger_ = Logger.getLogger(SelectionMode.class);
/*    */   }
/*    */ 
/*    */   
/*    */   private final int value_;
/*    */ 
/*    */   
/*    */   public static SelectionMode forName(IConfigObject argName) {
/* 33 */     if (argName == null) {
/* 34 */       return null;
/*    */     }
/*    */     try {
/* 37 */       return valueOf(argName.toString().trim().toUpperCase());
/*    */     }
/* 39 */     catch (IllegalArgumentException ex) {
/* 40 */       logger_.error("CAUGHT EXCEPTION::" + argName.getSourceDescription(), ex);
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
/*    */   public static SelectionMode forName(String argName) {
/* 52 */     if (argName == null) {
/* 53 */       return null;
/*    */     }
/*    */     try {
/* 56 */       return valueOf(argName.trim().toUpperCase());
/*    */     }
/* 58 */     catch (IllegalArgumentException ex) {
/* 59 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 60 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SelectionMode[] getInstances() {
/* 70 */     return values();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   SelectionMode(int argValue) {
/* 81 */     this.value_ = argValue;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 89 */     return toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getValue() {
/* 97 */     return this.value_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\SelectionMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */