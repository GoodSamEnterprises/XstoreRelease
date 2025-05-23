/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.pos.iframework.form.IEnumLoader;
/*    */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*    */ import dtv.pos.iframework.form.config.IFormValueEnumConfig;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class SimpleEnumLoader
/*    */   implements IEnumLoader
/*    */ {
/* 23 */   private static final IValueWrapperFactory WRAPPER_FACTORY = ValueWrapperFactory.makeWrapperFactory((Class)SimpleValueWrapper.class);
/*    */   
/*    */   private List<Object> values_;
/*    */   
/*    */   public List<? extends Object> getValues() {
/* 28 */     return this.values_;
/*    */   }
/*    */ 
/*    */   
/*    */   public IValueWrapperFactory getWrapperFactory() {
/* 33 */     return WRAPPER_FACTORY;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfig(IFormValueEnumConfig argConfig) {
/* 38 */     this.values_ = new ArrayList(argConfig.getConfiguredValues().getValues());
/* 39 */     if (argConfig.isNullAllowed())
/* 40 */       this.values_.add(0, null); 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\SimpleEnumLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */