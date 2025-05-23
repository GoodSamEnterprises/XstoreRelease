/*    */ package dtv.data2.access.exception;
/*    */ 
/*    */ import dtv.util.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ExceptionApplicableRule
/*    */ {
/*    */   private final String message_;
/*    */   private final Class<?> exceptionClass_;
/*    */   private final boolean matchFoundResult_;
/*    */   
/*    */   ExceptionApplicableRule(String argMessage) {
/* 20 */     this(argMessage, null, true);
/*    */   }
/*    */   
/*    */   ExceptionApplicableRule(String argMessage, Class<?> argExceptionClass, boolean argMatchFoundResult) {
/* 24 */     if (argExceptionClass == null && StringUtils.isEmpty(argMessage)) {
/* 25 */       throw new DtxException("ExceptionApplicableRule cannot be created with null or empty argMessage AND null argExceptionClass. At least one of these arguments needs to be supplied.");
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 30 */     if (argMessage != null) {
/* 31 */       this.message_ = argMessage.toLowerCase();
/*    */     } else {
/*    */       
/* 34 */       this.message_ = null;
/*    */     } 
/*    */     
/* 37 */     this.exceptionClass_ = argExceptionClass;
/* 38 */     this.matchFoundResult_ = argMatchFoundResult;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 48 */     return this.message_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   Class<?> getExceptionClass() {
/* 56 */     return this.exceptionClass_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   boolean getMatchFoundResult() {
/* 64 */     return this.matchFoundResult_;
/*    */   }
/*    */   
/*    */   boolean isExceptionClassPertinent() {
/* 68 */     return (this.exceptionClass_ != null);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\exception\ExceptionApplicableRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */