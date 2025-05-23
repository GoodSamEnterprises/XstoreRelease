/*    */ package dtv.pos.framework.location;
/*    */ 
/*    */ import dtv.pos.framework.form.ValueWrapperFactory;
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
/*    */ 
/*    */ public class CountryEnumLoader
/*    */   implements IEnumLoader
/*    */ {
/* 25 */   private static final IValueWrapperFactory COUNTRY_WRAPPER = ValueWrapperFactory.makeWrapperFactory(CountryValueWrapper.class);
/*    */   
/* 27 */   private static final List<? extends Object> DEFAULT_VALUES = new ArrayList();
/*    */ 
/*    */ 
/*    */   
/*    */   public List<? extends Object> getValues() {
/* 32 */     return DEFAULT_VALUES;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IValueWrapperFactory getWrapperFactory() {
/* 38 */     return COUNTRY_WRAPPER;
/*    */   }
/*    */   
/*    */   public void setConfig(IFormValueEnumConfig argConfig) {}
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\location\CountryEnumLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */