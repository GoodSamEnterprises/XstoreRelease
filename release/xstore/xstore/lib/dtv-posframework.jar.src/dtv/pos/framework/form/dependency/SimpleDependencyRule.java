/*    */ package dtv.pos.framework.form.dependency;
/*    */ 
/*    */ import dtv.pos.iframework.form.ICardinality;
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
/*    */ public class SimpleDependencyRule
/*    */   extends AbstractDependencyRule
/*    */ {
/*    */   protected void modelChange(Object argNewValue) {
/* 23 */     if (argNewValue == null || (argNewValue instanceof String && 
/* 24 */       StringUtils.isEmpty((String)argNewValue))) {
/* 25 */       this.parentField_.removeValue();
/* 26 */       this.parentField_.setCardinality(ICardinality.NOT_AVAILABLE);
/*    */     } else {
/*    */       
/* 29 */       this.parentField_.unremoveValue();
/* 30 */       this.parentField_.setCardinality(ICardinality.REQUIRED);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\dependency\SimpleDependencyRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */