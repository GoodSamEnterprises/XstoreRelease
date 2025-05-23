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
/*    */ 
/*    */ 
/*    */ public class TrueDependencyRule
/*    */   extends AbstractDependencyRule
/*    */ {
/*    */   protected void modelChange(Object argNewValue) {
/* 25 */     if (argNewValue == null || (argNewValue instanceof String && 
/* 26 */       StringUtils.isEmpty((String)argNewValue))) {
/* 27 */       this.parentField_.removeValue();
/* 28 */       this.parentField_.setCardinality(ICardinality.NOT_AVAILABLE);
/*    */     } else {
/*    */       
/* 31 */       this.parentField_.setValue(Boolean.TRUE);
/* 32 */       this.parentField_.setCardinality(ICardinality.REQUIRED);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\dependency\TrueDependencyRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */