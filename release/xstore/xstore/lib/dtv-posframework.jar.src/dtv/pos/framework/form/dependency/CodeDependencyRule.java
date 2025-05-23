/*    */ package dtv.pos.framework.form.dependency;
/*    */ 
/*    */ import dtv.util.ICodeInterface;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CodeDependencyRule
/*    */   extends AbstractDependencyRule
/*    */ {
/* 23 */   private static final Logger logger_ = Logger.getLogger(CodeDependencyRule.class);
/*    */ 
/*    */ 
/*    */   
/*    */   protected void modelChange(Object argNewValue) {
/* 28 */     if (argNewValue == null) {
/* 29 */       handleNotSet();
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 34 */     String codeToTest = null;
/* 35 */     if (argNewValue instanceof ICodeInterface) {
/* 36 */       codeToTest = ((ICodeInterface)argNewValue).getCode();
/*    */     }
/* 38 */     else if (argNewValue instanceof String) {
/* 39 */       codeToTest = (String)argNewValue;
/*    */     } else {
/*    */       
/* 42 */       logger_
/* 43 */         .error(argNewValue.getClass() + "does not implement String OR " + ICodeInterface.class.getName());
/* 44 */       handleNotSet();
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 49 */     if (getCodeSet().contains(codeToTest)) {
/* 50 */       handleMatch();
/*    */     } else {
/*    */       
/* 53 */       handleNoMatch();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void validateParameters() {
/* 60 */     validateCardinalityParameters();
/*    */     
/* 62 */     if (getCodeSet() == null || getCodeSet().isEmpty())
/* 63 */       throw new IllegalArgumentException("codeSet must be specified"); 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\dependency\CodeDependencyRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */