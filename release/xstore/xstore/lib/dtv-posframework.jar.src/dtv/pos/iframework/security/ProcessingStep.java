/*    */ package dtv.pos.iframework.security;
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
/*    */ public enum ProcessingStep
/*    */ {
/* 14 */   INITIAL_STEP((byte)0),
/* 15 */   LOGOUT((byte)8),
/* 16 */   AUTHENTICATE((byte)2),
/* 17 */   AUTHORIZE((byte)4),
/* 18 */   REAUTHENTICATE((byte)2),
/* 19 */   OVERRIDE_AUTHENTICATE((byte)2),
/* 20 */   OVERRIDE_AUTHORIZE((byte)4),
/* 21 */   SECOND_PROMPT((byte)2),
/* 22 */   LOGIN((byte)1),
/* 23 */   AUTOLOGOUT((byte)16),
/* 24 */   EXIT_STEP((byte)0);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private byte _requestType;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   ProcessingStep(byte argRequestType) {
/* 35 */     this._requestType = argRequestType;
/*    */   }
/*    */   
/*    */   public boolean isAuthentication() {
/* 39 */     return ((0x2 & this._requestType) > 0);
/*    */   }
/*    */   
/*    */   public boolean isAuthorization() {
/* 43 */     return ((0x4 & this._requestType) > 0);
/*    */   }
/*    */   
/*    */   public boolean isAutoLogout() {
/* 47 */     return ((0x10 & this._requestType) > 0);
/*    */   }
/*    */   
/*    */   public boolean isLogin() {
/* 51 */     return ((0x1 & this._requestType) > 0);
/*    */   }
/*    */   
/*    */   public boolean isLogout() {
/* 55 */     return ((0x8 & this._requestType) > 0);
/*    */   }
/*    */   
/*    */   public ProcessingStep next() {
/* 59 */     ProcessingStep nextStep = this;
/*    */     
/* 61 */     for (ProcessingStep value : values()) {
/* 62 */       int next = ordinal() + 1;
/*    */       
/* 64 */       if (value.ordinal() == next) {
/* 65 */         nextStep = value;
/*    */       }
/*    */     } 
/*    */     
/* 69 */     return nextStep;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\ProcessingStep.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */