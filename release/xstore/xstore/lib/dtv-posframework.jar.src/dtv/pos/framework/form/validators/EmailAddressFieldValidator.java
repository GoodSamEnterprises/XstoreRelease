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
/*    */ public class EmailAddressFieldValidator
/*    */   implements IEditModelFieldValidator<String>
/*    */ {
/*    */   public static final String EMAIL_ADDRESS_FIELD = "emailAddress";
/*    */   
/*    */   public IValidationResult validateField(IEditModel argEditModel, IEditModelField<String> argField) {
/* 29 */     IValidationResult result = IValidationResult.SUCCESS;
/*    */     
/* 31 */     if (!argField.isReadOnly() && argField.isAvailable()) {
/* 32 */       Object fieldValue = argEditModel.getValue(argField.getFieldKey());
/* 33 */       boolean valid = (fieldValue == null) ? true : StringUtils.isValidEmailAddress(fieldValue.toString());
/* 34 */       result = valid ? SimpleValidationResult.getPassed() : SimpleValidationResult.getFailed("_emailAddressValidationError");
/*    */     } else {
/*    */       
/* 37 */       result = SimpleValidationResult.getPassed();
/*    */     } 
/* 39 */     return result;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\validators\EmailAddressFieldValidator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */