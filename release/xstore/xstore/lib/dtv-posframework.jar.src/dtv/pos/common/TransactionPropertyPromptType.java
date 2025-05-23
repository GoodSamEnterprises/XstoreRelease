/*    */ package dtv.pos.common;
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
/*    */ public enum TransactionPropertyPromptType
/*    */ {
/* 16 */   SIMPLE, LIST, DATE, NUMERIC, DECIMAL, MONEY, MASK, CHAIN, PROMPT_KEY, NO_PROMPT, PHONEENTRY;
/*    */   static {
/* 18 */     _logger = Logger.getLogger(TransactionPropertyPromptType.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static final Logger _logger;
/*    */ 
/*    */ 
/*    */   
/*    */   public static TransactionPropertyPromptType forName(String argName) {
/*    */     try {
/* 29 */       return valueOf(argName);
/*    */     }
/* 31 */     catch (Exception ex) {
/* 32 */       _logger.debug("No enumeration instance named [" + argName + "] exists", ex);
/* 33 */       return null;
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
/*    */   public boolean matches(String argName) {
/* 45 */     return name().equalsIgnoreCase(argName);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\TransactionPropertyPromptType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */