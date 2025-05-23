/*    */ package dtv.pos.framework.form.validators;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class DefaultEditModelFieldValidatorFactory
/*    */   implements IEditModelFieldValidatorFactory
/*    */ {
/* 19 */   private Map<String, IEditModelFieldValidator<?>> fieldValidators = new HashMap<>();
/*    */ 
/*    */ 
/*    */   
/*    */   public IEditModelFieldValidator<?> getValidator(String argFieldName) {
/* 24 */     IEditModelFieldValidator<?> result = this.fieldValidators.get(argFieldName);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 30 */     return result;
/*    */   }
/*    */   
/*    */   public void setParameters(Map<String, IEditModelFieldValidator<?>> argParameters) {
/* 34 */     this.fieldValidators = argParameters;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\validators\DefaultEditModelFieldValidatorFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */