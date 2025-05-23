/*    */ package dtv.pos.framework.validation;
/*    */ 
/*    */ import dtv.pos.framework.logging.ProcessLogger;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.validation.IValidationResult;
/*    */ import dtv.pos.iframework.validation.IValidationResultList;
/*    */ import dtv.pos.iframework.validation.IValidationRule;
/*    */ import dtv.util.config.IHasSourceDescription;
/*    */ import java.util.List;
/*    */ import javax.inject.Inject;
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
/*    */ public class ValidationHelper
/*    */ {
/*    */   @Inject
/*    */   private ProcessLogger _processLogger;
/*    */   
/*    */   public IValidationResultList applyValidationRules(IXstEvent argEvent, List<IValidationRule> argRules) {
/* 35 */     IValidationResultList results = new ValidationResultList();
/*    */     
/* 37 */     if (argRules != null && !argRules.isEmpty()) {
/* 38 */       for (IValidationRule rule : argRules) {
/* 39 */         IValidationResult result = rule.validate();
/* 40 */         logResult(rule, result);
/*    */         
/* 42 */         results.add(result);
/* 43 */         if (!results.isValid() && !results.isSecured()) {
/*    */ 
/*    */ 
/*    */           
/* 47 */           IValidationResultList unsecuredResults = new ValidationResultList();
/* 48 */           IValidationResult[] invalidResults = results.getInvalidResults();
/*    */           
/* 50 */           if (invalidResults != null) {
/* 51 */             for (IValidationResult invalid : invalidResults) {
/* 52 */               if (!invalid.isSecured()) {
/* 53 */                 unsecuredResults.add(invalid);
/*    */               }
/*    */             } 
/*    */           }
/*    */           
/* 58 */           return unsecuredResults;
/*    */         } 
/*    */       } 
/*    */     }
/*    */     
/* 63 */     return results;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void logResult(IValidationRule argRule, IValidationResult argResult) {
/* 73 */     boolean failure = (!argResult.isValid() && !argResult.isSecured());
/* 74 */     String prefix = failure ? "X" : (argResult.isSecured() ? "?" : "+");
/*    */     
/* 76 */     if (failure) {
/* 77 */       this._processLogger.warn("Rule", argRule.getClass(), (IHasSourceDescription)argRule, prefix, null);
/*    */     } else {
/*    */       
/* 80 */       this._processLogger.info("Rule", argRule.getClass(), (IHasSourceDescription)argRule, prefix, null);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\validation\ValidationHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */