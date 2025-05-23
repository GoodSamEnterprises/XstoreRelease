/*    */ package dtv.pos.framework.form.validators;
/*    */ 
/*    */ import dtv.pos.iframework.form.IEditModel;
/*    */ import dtv.pos.iframework.form.IEditModelField;
/*    */ import dtv.pos.iframework.validation.IValidationResult;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IEditModelFieldValidator<T>
/*    */ {
/*    */   default boolean runModelValidation() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   IValidationResult validateField(IEditModel paramIEditModel, IEditModelField<T> paramIEditModelField);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\validators\IEditModelFieldValidator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */