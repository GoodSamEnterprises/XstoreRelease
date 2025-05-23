/*    */ package dtv.pos.iframework.form.config;
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
/*    */ public enum FormPanelType
/*    */ {
/* 17 */   HEADER, MASTER, DETAIL, FOOTER,
/*    */   
/* 19 */   TOP_INFO, BOTTOM_INFO, LIST_FOOTER, TRANSACTION_SUMMARY, LIST, TOP_INFO_FOOTER;
/*    */   static {
/* 21 */     logger_ = Logger.getLogger(FormPanelType.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static final Logger logger_;
/*    */ 
/*    */   
/*    */   public static FormPanelType forName(IConfigObject argName) {
/* 30 */     if (argName == null) {
/* 31 */       return null;
/*    */     }
/*    */     try {
/* 34 */       return valueOf(argName.toString().trim().toUpperCase());
/*    */     }
/* 36 */     catch (Exception ex) {
/* 37 */       logger_.error("CAUGHT EXCEPTION::" + argName.getSourceDescription(), ex);
/* 38 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static FormPanelType forName(String argName) {
/* 49 */     if (argName == null) {
/* 50 */       return null;
/*    */     }
/*    */     try {
/* 53 */       return valueOf(argName.trim().toUpperCase());
/*    */     }
/* 55 */     catch (Exception ex) {
/* 56 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 57 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static FormPanelType[] getInstances() {
/* 67 */     return values();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 77 */     return name();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\FormPanelType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */