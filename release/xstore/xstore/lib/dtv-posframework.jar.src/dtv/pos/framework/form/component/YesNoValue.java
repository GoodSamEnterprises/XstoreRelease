/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.i18n.FormattableFactory;
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.OutputContextType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class YesNoValue
/*    */ {
/*    */   private final IFormattable _text;
/*    */   private final Boolean _value;
/*    */   
/*    */   public YesNoValue(Boolean argValue) {
/* 19 */     this._text = FormattableFactory.getInstance().getTranslatable(argValue.booleanValue() ? "_yes" : "_no");
/* 20 */     this._value = argValue;
/*    */   }
/*    */   
/*    */   public Boolean getValue() {
/* 24 */     return this._value;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 29 */     return this._text.toString(OutputContextType.VIEW);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\YesNoValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */