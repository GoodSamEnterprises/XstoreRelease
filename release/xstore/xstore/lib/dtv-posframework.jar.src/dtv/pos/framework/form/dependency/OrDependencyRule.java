/*    */ package dtv.pos.framework.form.dependency;
/*    */ 
/*    */ import dtv.util.ObjectUtils;
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
/*    */ public class OrDependencyRule
/*    */   extends AbstractDependencyRule
/*    */ {
/* 20 */   private static final Logger logger_ = Logger.getLogger(OrDependencyRule.class);
/*    */ 
/*    */ 
/*    */   
/*    */   protected void modelChange(Object argNewValue) {
/* 25 */     if (asBool(argNewValue)) {
/* 26 */       this.parentField_.unremoveValue();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean asBool(Object argData) {
/* 33 */     if (argData == null) {
/* 34 */       return false;
/*    */     }
/* 36 */     if (argData instanceof Boolean) {
/* 37 */       return ((Boolean)argData).booleanValue();
/*    */     }
/*    */     
/* 40 */     logger_.warn("unexpected value type " + ObjectUtils.getClassNameFromObject(argData));
/* 41 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\dependency\OrDependencyRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */