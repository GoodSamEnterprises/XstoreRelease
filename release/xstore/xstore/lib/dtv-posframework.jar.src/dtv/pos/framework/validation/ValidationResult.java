/*    */ package dtv.pos.framework.validation;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.pos.iframework.validation.SimpleValidationResult;
/*    */ import dtv.xst.dao.sec.IPrivilege;
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
/*    */ 
/*    */ public class ValidationResult
/*    */   extends SimpleValidationResult
/*    */ {
/*    */   private final IPrivilege privilege_;
/*    */   private final boolean isSecuredAndPassable_;
/*    */   
/*    */   public static ValidationResult getOverridable(IFormattable argMessage, IPrivilege argPrivilege) {
/* 27 */     return new ValidationResult(argMessage, argPrivilege);
/*    */   }
/*    */   
/*    */   private static boolean isSecuredAndPassable(IPrivilege argPrivilege) {
/* 31 */     if (argPrivilege == null) {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if (argPrivilege != null) {
/* 36 */       for (byte b : argPrivilege.getGroupMembership()) {
/* 37 */         if (b != 0) {
/* 38 */           return true;
/*    */         }
/*    */       } 
/*    */     }
/* 42 */     return false;
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
/*    */   
/*    */   private ValidationResult(IFormattable argMessage, IPrivilege argPrivilege) {
/* 55 */     super(argMessage);
/* 56 */     this.privilege_ = argPrivilege;
/* 57 */     this.isSecuredAndPassable_ = isSecuredAndPassable(argPrivilege);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getPrivilege() {
/* 63 */     return (this.privilege_ == null) ? null : this.privilege_.getPrivilegeType();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isSecured() {
/* 69 */     return this.isSecuredAndPassable_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 75 */     return "ValidationResult[valid=" + isValid() + ", privilege=" + this.privilege_ + ", securedAndPassable=" + this.isSecuredAndPassable_ + ", message=" + 
/* 76 */       getMessageDescription() + "]";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\validation\ValidationResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */