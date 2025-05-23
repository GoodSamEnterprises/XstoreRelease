/*    */ package dtv.docbuilding.conditions;
/*    */ 
/*    */ import dtv.docbuilding.DocBuilderHelper;
/*    */ import dtv.docbuilding.conditions.compare.IComparison;
/*    */ import dtv.util.ObjectUtils;
/*    */ import dtv.util.config.IReflectionParameterCapable;
/*    */ import java.util.List;
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
/*    */ public class SimpleComparisonCondition
/*    */   extends AbstractInvertableCondition
/*    */ {
/* 24 */   private static final Logger logger_ = Logger.getLogger(SimpleComparisonCondition.class);
/*    */   
/*    */   private final String[] methods_;
/*    */   
/*    */   private final IComparison comparison_;
/*    */   
/*    */   private final Class<?>[] paramClasses_;
/*    */   private final Object[] params_;
/*    */   
/*    */   public SimpleComparisonCondition(String[] argMethods, List<IReflectionParameterCapable<?>> argMethodParamList, IComparison argComparison) {
/* 34 */     this.methods_ = argMethods;
/* 35 */     this.comparison_ = argComparison;
/*    */     
/* 37 */     if (argMethodParamList != null && argMethodParamList.size() > 0) {
/* 38 */       this.paramClasses_ = new Class[argMethodParamList.size()];
/* 39 */       this.params_ = new Object[argMethodParamList.size()];
/*    */       
/* 41 */       for (int i = 0; i < this.paramClasses_.length; i++) {
/* 42 */         IReflectionParameterCapable<?> config = argMethodParamList.get(i);
/* 43 */         this.paramClasses_[i] = config.getParamDataType();
/* 44 */         this.params_[i] = config.getParamValue();
/*    */       } 
/*    */     } else {
/*    */       
/* 48 */       this.paramClasses_ = new Class[0];
/* 49 */       this.params_ = new Object[0];
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean conditionMetImpl(Object argSource) {
/* 56 */     String currentMethod = null;
/*    */     
/*    */     try {
/* 59 */       Object[] oa = new Object[this.methods_.length];
/* 60 */       for (int i = 0; i < oa.length; i++) {
/*    */         
/* 62 */         currentMethod = this.methods_[i];
/* 63 */         oa[i] = 
/* 64 */           DocBuilderHelper.invokeMethodChain(currentMethod, argSource, this.paramClasses_, this.params_, 
/* 65 */             getSourceDescription());
/*    */       } 
/*    */       
/* 68 */       return this.comparison_.compare(oa);
/*    */     }
/* 70 */     catch (Exception ex) {
/* 71 */       logger_.debug("CAUGHT EXCEPTION with config @@ [" + getSourceDescription() + "], source='" + 
/* 72 */           ObjectUtils.getClassNameFromObject(argSource) + "':'" + argSource + "' method_='" + currentMethod + "', comparison='" + this.comparison_ + "'... returning false", ex);
/*    */       
/* 74 */       return false;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, Object argValue) {
/* 81 */     this.comparison_.setParameter(argName, argValue);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\SimpleComparisonCondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */