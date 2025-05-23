/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.config.IFormattableConfig;
/*    */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*    */ import java.util.Map;
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
/*    */ public class CodeMapValueWrapperFactory
/*    */   implements IValueWrapperFactory
/*    */ {
/*    */   private final Map formattableMap;
/*    */   
/*    */   public CodeMapValueWrapperFactory(Map argFormattableMap) {
/* 25 */     this.formattableMap = argFormattableMap;
/*    */   }
/*    */   
/*    */   public Object wrapValue(Object actualValue) {
/*    */     IFormattable f;
/* 30 */     if (actualValue == null) {
/* 31 */       return null;
/*    */     }
/*    */     
/* 34 */     IFormattableConfig fc = (IFormattableConfig)this.formattableMap.get(actualValue);
/*    */     
/* 36 */     if (fc == null) {
/* 37 */       f = IFormattable.EMPTY;
/*    */     } else {
/*    */       
/* 40 */       f = fc.getFormattable();
/*    */     } 
/* 42 */     return new CodeTranslationWrapper("" + actualValue, f);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\CodeMapValueWrapperFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */