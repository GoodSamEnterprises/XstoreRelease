/*    */ package dtv.docbuilding.config;
/*    */ 
/*    */ import dtv.docbuilding.IDocBuilderField;
/*    */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*    */ import dtv.i18n.formatter.output.IOutputFormatter;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ClassConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.lang.reflect.InvocationTargetException;
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
/*    */ public class DocBuilderAggregateConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 26 */   private static final Class<?>[] ctorParams_ = new Class[] { String.class, String.class, Integer.class, DocBuilderAlignmentType.class, int.class, IOutputFormatter.class };
/*    */ 
/*    */   
/* 29 */   private ClassConfig<?> aggregateClass_ = null;
/* 30 */   private String contents_ = "";
/*    */   
/*    */   public ClassConfig<?> getAggregateClass() {
/* 33 */     return this.aggregateClass_;
/*    */   }
/*    */   
/*    */   public String getContents() {
/* 37 */     return this.contents_;
/*    */   }
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
/*    */ 
/*    */ 
/*    */   
/*    */   public IDocBuilderField makeField(String argStyle, Integer argLocation, DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
/* 61 */     Constructor<?> ctor = this.aggregateClass_.getValue().getConstructor(ctorParams_);
/*    */     
/* 63 */     Object[] params = { this.contents_, argStyle, argLocation, argAlignment, Integer.valueOf(argPriority), argFormatter };
/*    */     
/* 65 */     return (IDocBuilderField)ctor.newInstance(params);
/*    */   }
/*    */   
/*    */   public void setAggregateClass(ClassConfig<?> argClass) {
/* 69 */     this.aggregateClass_ = argClass;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 76 */     if ("class".equalsIgnoreCase(argKey) || argValue instanceof ClassConfig) {
/* 77 */       this.aggregateClass_ = ConfigUtils.toClassConfig(argValue);
/*    */     }
/* 79 */     else if ("contents".equalsIgnoreCase(argKey)) {
/* 80 */       this.contents_ = argValue.toString();
/*    */     } else {
/*    */       
/* 83 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setContents(String argContent) {
/* 88 */     this.contents_ = argContent;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderAggregateConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */