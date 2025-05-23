/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.i18n.LocaleHelper;
/*    */ import dtv.pos.iframework.form.IEnumLoader;
/*    */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*    */ import dtv.pos.iframework.form.config.IFormValueEnumConfig;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Locale;
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
/*    */ public class LocaleEnumLoader
/*    */   implements IEnumLoader
/*    */ {
/* 24 */   private static final IValueWrapperFactory valueWrapperFactory_ = ValueWrapperFactory.makeWrapperFactory((Class)LocaleStringWrapper.class);
/*    */   
/*    */   private static List<Object> VALUES;
/*    */   
/*    */   private static List<Object> VALUES_PLUS_NULL;
/*    */   
/*    */   private List<Object> values_;
/*    */   private boolean isNullAllowed_;
/*    */   
/*    */   public List<? extends Object> getValues() {
/* 34 */     if (VALUES == null) {
/* 35 */       VALUES = new ArrayList();
/* 36 */       List<Locale> a = LocaleHelper.getInstance().getAvailableLocales();
/* 37 */       for (Locale element : a) {
/* 38 */         VALUES.add(valueWrapperFactory_.wrapValue(element));
/*    */       }
/* 40 */       VALUES_PLUS_NULL = new ArrayList();
/* 41 */       VALUES_PLUS_NULL.add(null);
/* 42 */       VALUES_PLUS_NULL.addAll(VALUES);
/*    */     } 
/* 44 */     if (this.values_ == null) {
/* 45 */       if (this.isNullAllowed_) {
/* 46 */         this.values_ = VALUES_PLUS_NULL;
/*    */       } else {
/*    */         
/* 49 */         this.values_ = VALUES;
/*    */       } 
/*    */     }
/* 52 */     return this.values_;
/*    */   }
/*    */ 
/*    */   
/*    */   public IValueWrapperFactory getWrapperFactory() {
/* 57 */     return valueWrapperFactory_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfig(IFormValueEnumConfig argConfig) {
/* 62 */     this.isNullAllowed_ = argConfig.isNullAllowed();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\LocaleEnumLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */