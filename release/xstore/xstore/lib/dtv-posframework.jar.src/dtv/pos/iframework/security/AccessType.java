/*    */ package dtv.pos.iframework.security;
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
/*    */ public enum AccessType
/*    */ {
/* 15 */   CREATE, DELETE, READ, UPDATE;
/*    */   static {
/* 17 */     logger_ = Logger.getLogger(AccessType.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static final Logger logger_;
/*    */ 
/*    */   
/*    */   public static AccessType forName(String argName) {
/* 26 */     if (argName == null) {
/* 27 */       return null;
/*    */     }
/*    */     try {
/* 30 */       return valueOf(argName.trim().toUpperCase());
/*    */     }
/* 32 */     catch (Exception ex) {
/* 33 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 34 */       return null;
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
/*    */   public String toString() {
/* 46 */     return name();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\AccessType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */