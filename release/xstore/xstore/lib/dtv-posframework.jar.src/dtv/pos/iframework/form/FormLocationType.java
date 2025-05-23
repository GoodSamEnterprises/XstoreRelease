/*    */ package dtv.pos.iframework.form;
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
/*    */ public enum FormLocationType
/*    */ {
/* 17 */   MULTI_PURPOSE_VIEW(true), POPUP_VIEW_PANEL(false), MESSAGE_AREA(false), TRANSACTION_LIST_AREA(true); private boolean _primaryLocation;
/*    */   
/*    */   static {
/* 20 */     logger_ = Logger.getLogger(FormLocationType.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static final Logger logger_;
/*    */ 
/*    */   
/*    */   public static FormLocationType forName(IConfigObject argName) {
/* 29 */     if (argName == null) {
/* 30 */       return null;
/*    */     }
/*    */     try {
/* 33 */       return valueOf(argName.toString().trim().toUpperCase());
/*    */     }
/* 35 */     catch (Exception ex) {
/* 36 */       logger_.error("CAUGHT EXCEPTION::" + argName.getSourceDescription(), ex);
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
/*    */   public static FormLocationType forName(String argName) {
/* 48 */     if (argName == null) {
/* 49 */       return null;
/*    */     }
/*    */     try {
/* 52 */       return valueOf(argName.trim().toUpperCase());
/*    */     }
/* 54 */     catch (Exception ex) {
/* 55 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 56 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static FormLocationType[] getInstances() {
/* 66 */     return values();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   FormLocationType(boolean argIsPrimaryLocation) {
/* 73 */     this._primaryLocation = argIsPrimaryLocation;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isPrimaryLocation() {
/* 82 */     return this._primaryLocation;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 92 */     return name();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\FormLocationType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */