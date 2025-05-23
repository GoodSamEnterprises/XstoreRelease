/*    */ package dtv.pos.iframework.type;
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
/*    */ public enum ValidationPromptTypes
/*    */ {
/* 16 */   REPROMPT, NOTIFY;
/*    */   
/*    */   static {
/* 19 */     logger_ = Logger.getLogger(ValidationPromptTypes.class);
/*    */   }
/*    */ 
/*    */   
/*    */   private static final Logger logger_;
/*    */ 
/*    */   
/*    */   public static ValidationPromptTypes forName(String argName) {
/* 27 */     if (argName == null) {
/* 28 */       return null;
/*    */     }
/*    */     try {
/* 31 */       return valueOf(argName.trim().toUpperCase());
/*    */     }
/* 33 */     catch (Exception ex) {
/* 34 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 35 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 44 */     return name();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\type\ValidationPromptTypes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */