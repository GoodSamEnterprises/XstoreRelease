/*    */ package dtv.pos.framework.form.dependency;
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
/*    */ public class ValueDependencyRule
/*    */   extends AbstractDependencyRule
/*    */ {
/*    */   protected void modelChange(Object argNewValue) {
/* 18 */     if (argNewValue == null) {
/* 19 */       handleNotSet();
/*    */     }
/* 21 */     else if (getCodeSet().contains(argNewValue.toString())) {
/* 22 */       handleMatch();
/*    */     } else {
/*    */       
/* 25 */       handleNoMatch();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void validateParameters() {
/* 32 */     validateCardinalityParameters();
/*    */     
/* 34 */     if (getCodeSet() == null || getCodeSet().isEmpty())
/* 35 */       throw new IllegalArgumentException("codeSet must be specified"); 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\dependency\ValueDependencyRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */