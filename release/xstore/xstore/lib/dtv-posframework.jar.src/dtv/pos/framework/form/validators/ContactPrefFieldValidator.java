/*    */ package dtv.pos.framework.form.validators;
/*    */ 
/*    */ import dtv.pos.iframework.form.IEditModel;
/*    */ import dtv.pos.iframework.form.IEditModelField;
/*    */ import dtv.pos.iframework.validation.IValidationResult;
/*    */ import dtv.pos.iframework.validation.SimpleValidationResult;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContactPrefFieldValidator
/*    */   implements IEditModelFieldValidator<Object>
/*    */ {
/*    */   public IValidationResult validateField(IEditModel argEditModel, IEditModelField<Object> argField) {
/* 27 */     IValidationResult result = IValidationResult.SUCCESS;
/*    */     
/* 29 */     Object fieldValue = argEditModel.getValue(argField.getFieldKey());
/* 30 */     if (fieldValue != null && !StringUtils.isEmpty(fieldValue.toString())) {
/*    */       
/* 32 */       boolean valid = isContactPrefHasValue(argEditModel, fieldValue.toString());
/* 33 */       result = valid ? SimpleValidationResult.getPassed() : SimpleValidationResult.getFailed("_contactPrefValidationError");
/*    */     } 
/* 35 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean isContactPrefHasValue(IEditModel argEditModel, String argFieldValue) {
/* 42 */     if ((argFieldValue.equals("HOME") && argEditModel.getValue("telephone1") == null) || (argFieldValue
/* 43 */       .equals("BUSINESS") && argEditModel.getValue("telephone2") == null) || (argFieldValue
/* 44 */       .equals("MOBILE") && argEditModel.getValue("telephone3") == null) || (argFieldValue
/* 45 */       .equals("FAX") && argEditModel.getValue("telephone4") == null) || (argFieldValue
/* 46 */       .equals("EMAIL") && argEditModel.getValue("emailAddress") == null)) {
/* 47 */       return false;
/*    */     }
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\validators\ContactPrefFieldValidator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */