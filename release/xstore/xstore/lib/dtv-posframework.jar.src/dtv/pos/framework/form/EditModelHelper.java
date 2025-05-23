/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.i18n.FormattableFactory;
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.pos.iframework.form.IEditModel;
/*    */ import dtv.pos.iframework.form.IEditModelField;
/*    */ import dtv.pos.iframework.validation.IValidationResult;
/*    */ import dtv.pos.iframework.validation.SimpleValidationResult;
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
/*    */ 
/*    */ 
/*    */ public class EditModelHelper
/*    */ {
/*    */   private static final String FIELD_REQUIRED_KEY = "_fieldRequired";
/*    */   private static final String FIELD_ACCESS_EXCEPTION_KEY = "_fieldAccessException";
/* 26 */   private static final FormattableFactory FF = FormattableFactory.getInstance();
/* 27 */   private static final Logger logger_ = Logger.getLogger(EditModelHelper.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IValidationResult getFieldError(String argFieldName, String argErrorKey) {
/* 37 */     IFormattable fieldNameArg = getLocalizedFieldName(argFieldName);
/* 38 */     IFormattable msg = FF.getTranslatable(argErrorKey, new IFormattable[] { fieldNameArg });
/*    */     
/* 40 */     return SimpleValidationResult.getFailed(msg);
/*    */   }
/*    */ 
/*    */   
/*    */   public IValidationResult getRequiredFieldMissing(IEditModelField argFieldDef) {
/* 45 */     return getFieldError(argFieldDef.getFieldKey(), "_fieldRequired");
/*    */   }
/*    */   
/*    */   public IValidationResult getRequiredFieldMissing(String argFieldName) {
/* 49 */     return getFieldError(argFieldName, "_fieldRequired");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IValidationResult getValueAccessException(IEditModel argSource, String argFieldName, Throwable argThowable) {
/* 55 */     logger_.error("CAUGHT EXCEPTION", argThowable);
/*    */ 
/*    */     
/* 58 */     IFormattable msg = FF.getTranslatable("_fieldAccessException", new IFormattable[] { FF.getLiteral(argThowable.getClass().getName()), FF
/* 59 */           .getLiteral(argFieldName) });
/*    */     
/* 61 */     return SimpleValidationResult.getFailed(msg);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected IFormattable getLocalizedFieldName(String argFieldKey) {
/* 72 */     return FF.getTranslatable("_editField_" + argFieldKey);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\EditModelHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */