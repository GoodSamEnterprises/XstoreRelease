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
/*    */ 
/*    */ public class YesNoInvertedValue
/*    */ {
/*    */   private final IFormattable _text;
/*    */   private final Boolean _value;
/*    */   
/*    */   public YesNoInvertedValue(Boolean argValue) {
/* 20 */     this._text = FormattableFactory.getInstance().getTranslatable(argValue.booleanValue() ? "_no" : "_yes");
/* 21 */     this._value = argValue;
/*    */   }
/*    */   
/*    */   public Boolean getValue() {
/* 25 */     return this._value;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 30 */     return this._text.toString(OutputContextType.VIEW);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\YesNoInvertedValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */