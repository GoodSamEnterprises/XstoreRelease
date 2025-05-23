/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.iframework.form.IEnumValueWrapper;
/*     */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.com.CodeLocator;
/*     */ import dtv.xst.dao.com.IReasonCode;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReasonCodeValueWrapperFactory
/*     */   implements IValueWrapperFactory
/*     */ {
/*     */   final String codeGroup_;
/*     */   
/*     */   public static ReasonCodeValueWrapperFactory makeForCodeGroup(String argCodeGroup) {
/*  27 */     return new ReasonCodeValueWrapperFactory(argCodeGroup);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ReasonCodeValueWrapperFactory(String argCodeGroup) {
/*  33 */     this.codeGroup_ = argCodeGroup;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object wrapValue(Object argObject) {
/*  38 */     ValueWrapper wrapped = new ValueWrapper();
/*  39 */     wrapped.setActualValue(argObject);
/*  40 */     return wrapped;
/*     */   }
/*     */   
/*     */   class ValueWrapper
/*     */     implements IEnumValueWrapper, IFormattable
/*     */   {
/*  46 */     private IFormattable _description = null;
/*  47 */     private IReasonCode _value = null;
/*  48 */     private String _code = null;
/*     */ 
/*     */     
/*     */     public boolean equals(Object argOther) {
/*  52 */       if (argOther == this) {
/*  53 */         return true;
/*     */       }
/*  55 */       if (argOther == null) {
/*  56 */         return (this._code == null);
/*     */       }
/*  58 */       if (!(argOther instanceof ValueWrapper)) {
/*  59 */         return false;
/*     */       }
/*  61 */       ValueWrapper other = (ValueWrapper)argOther;
/*     */       
/*  63 */       if (ObjectUtils.equivalent(other.getActualValue(), getActualValue())) {
/*  64 */         return true;
/*     */       }
/*  66 */       if (this._code == null) {
/*  67 */         return (other._code == null);
/*     */       }
/*  69 */       return this._code.equals(other._code);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Object getActualValue() {
/*  75 */       return this._code;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Locale getLocale() {
/*  81 */       return this._description.getLocale();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getSourceDescription() {
/*  87 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Object getUnformattedData() {
/*  93 */       return this._description.getUnformattedData();
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*  98 */       return (this._code == null) ? 0 : this._code.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isFormattingOptimizable() {
/* 104 */       return this._description.isFormattingOptimizable();
/*     */     }
/*     */ 
/*     */     
/*     */     public void setActualValue(Object argValue) {
/* 109 */       if (argValue instanceof IReasonCode) {
/* 110 */         this._value = (IReasonCode)argValue;
/*     */       }
/* 112 */       else if (argValue instanceof String) {
/* 113 */         this
/* 114 */           ._value = CodeLocator.getReasonCode(ConfigurationMgr.getOrganizationId(), ReasonCodeValueWrapperFactory.this.codeGroup_, (String)argValue);
/*     */       } 
/* 116 */       if (this._value == null) {
/* 117 */         this._description = IFormattable.EMPTY;
/* 118 */         this._code = null;
/*     */       } else {
/*     */         
/* 121 */         this._description = FormattableFactory.getInstance().getSimpleFormattable(this._value.getDescription());
/* 122 */         this._code = this._value.getReasonCode();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setLocale(Locale argLocale) {
/* 129 */       this._description.setLocale(argLocale);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setSourceDescription(String argSourceDescription) {}
/*     */ 
/*     */     
/*     */     public String toString() {
/* 138 */       return this._description.toString(OutputContextType.DEFAULT);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString(OutputContextType argContext) {
/* 144 */       return this._description.toString(argContext);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString(OutputContextType argContext, Locale argLocale) {
/* 150 */       return this._description.toString(argContext, argLocale);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString(OutputContextType argContext, Locale argLocale, Object argTarget) {
/* 156 */       return this._description.toString(argContext, argLocale, argTarget);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString(OutputContextType argContext, Object argTarget) {
/* 162 */       return this._description.toString(argContext, argTarget);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\ReasonCodeValueWrapperFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */