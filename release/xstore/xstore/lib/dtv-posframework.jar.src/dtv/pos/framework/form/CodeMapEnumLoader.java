/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.config.IFormattableConfig;
/*    */ import dtv.pos.iframework.form.IEnumLoader;
/*    */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*    */ import dtv.pos.iframework.form.config.IFormValueEnumConfig;
/*    */ import dtv.util.ObjectUtils;
/*    */ import dtv.util.config.IReflectionParameterCapable;
/*    */ import dtv.util.config.ListConfig;
/*    */ import dtv.util.config.MapConfig;
/*    */ import dtv.util.config.ParameterConfig;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CodeMapEnumLoader
/*    */   implements IEnumLoader
/*    */ {
/* 27 */   private static final Logger logger_ = Logger.getLogger(CodeMapEnumLoader.class);
/*    */   
/*    */   private Map<String, Object> valueMap_;
/*    */   
/*    */   private List<CodeTranslationWrapper> values_;
/*    */   
/*    */   private CodeMapValueWrapperFactory wrapperFactory_;
/*    */   
/*    */   public List<? extends Object> getValues() {
/* 36 */     return (List)this.values_;
/*    */   }
/*    */ 
/*    */   
/*    */   public IValueWrapperFactory getWrapperFactory() {
/* 41 */     return this.wrapperFactory_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfig(IFormValueEnumConfig argConfig) {
/* 47 */     List<Object> valueOrder = null;
/* 48 */     ParameterConfig[] params = argConfig.getLoaderParams().getParameters();
/* 49 */     for (ParameterConfig p : params) {
/* 50 */       if ("map".equalsIgnoreCase(p.getName()) && p.getValue() instanceof MapConfig) {
/* 51 */         this.valueMap_ = ((MapConfig)p.getValue()).getMap();
/*    */       }
/* 53 */       else if ("order".equalsIgnoreCase(p.getName()) && p.getValue() instanceof ListConfig) {
/* 54 */         List configList = ((ListConfig)p.getValue()).getList();
/* 55 */         valueOrder = new ArrayList();
/* 56 */         for (int j = 0; j < configList.size(); j++) {
/* 57 */           Object o = configList.get(j);
/* 58 */           if (o instanceof IReflectionParameterCapable) {
/* 59 */             valueOrder.add(((IReflectionParameterCapable)o).getParamValue());
/*    */           } else {
/*    */             
/* 62 */             logger_.warn("unexpected list member " + ObjectUtils.getClassNameFromObject(o));
/*    */           } 
/*    */         } 
/*    */       } 
/* 66 */       if (valueOrder != null && this.valueMap_ != null) {
/*    */         break;
/*    */       }
/*    */     } 
/* 70 */     if (valueOrder == null) {
/* 71 */       valueOrder = new ArrayList(this.valueMap_.keySet());
/*    */     }
/* 73 */     makeList(argConfig, valueOrder);
/* 74 */     this.wrapperFactory_ = new CodeMapValueWrapperFactory(this.valueMap_);
/*    */   }
/*    */ 
/*    */   
/*    */   private void makeList(IFormValueEnumConfig argConfig, List argValueOrder) {
/* 79 */     this.values_ = new ArrayList<>();
/* 80 */     if (argConfig.isNullAllowed()) {
/* 81 */       this.values_.add(new CodeTranslationWrapper(null, IFormattable.EMPTY));
/*    */     }
/* 83 */     for (int i = 0; i < argValueOrder.size(); i++) {
/* 84 */       Object key = argValueOrder.get(i);
/* 85 */       if (key instanceof String) {
/* 86 */         Object fc = this.valueMap_.get(key);
/* 87 */         if (fc instanceof IFormattableConfig) {
/* 88 */           IFormattable f = ((IFormattableConfig)fc).getFormattable();
/* 89 */           this.values_.add(new CodeTranslationWrapper((String)key, f));
/*    */         } else {
/*    */           
/* 92 */           logger_.warn(fc + " is not a " + IFormattableConfig.class.getName());
/*    */         } 
/*    */       } else {
/*    */         
/* 96 */         logger_.warn("key " + key + " is not a String");
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\CodeMapEnumLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */