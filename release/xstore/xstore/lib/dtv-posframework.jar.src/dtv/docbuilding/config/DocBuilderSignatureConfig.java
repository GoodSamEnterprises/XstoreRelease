/*    */ package dtv.docbuilding.config;
/*    */ 
/*    */ import dtv.docbuilding.DocBuilderSignature;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public class DocBuilderSignatureConfig
/*    */   extends AbstractParentConfig
/*    */   implements ISectionMemberConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private DocBuilderFieldConfig field_;
/*    */   
/*    */   public DocBuilderSignature makeTransactionSignature(FormatterMapConfig argFormatterMap) {
/* 32 */     DocBuilderSignature signature = new DocBuilderSignature(getField().makeField(argFormatterMap));
/* 33 */     signature.setSourceDescription(getSourceDescription());
/* 34 */     return signature;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 40 */     if (argValue instanceof DocBuilderFieldConfig) {
/* 41 */       this.field_ = (DocBuilderFieldConfig)argValue;
/*    */     } else {
/*    */       
/* 44 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */   
/*    */   private DocBuilderFieldConfig getField() {
/* 49 */     return this.field_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderSignatureConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */