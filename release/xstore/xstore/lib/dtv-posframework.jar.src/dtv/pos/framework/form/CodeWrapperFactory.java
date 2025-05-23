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
/*     */ import dtv.xst.dao.com.ICodeValue;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CodeWrapperFactory
/*     */   implements IValueWrapperFactory
/*     */ {
/*  27 */   private static final Map<String, CodeWrapperFactory> CACHE = new HashMap<>();
/*     */ 
/*     */   
/*     */   final String codeGroup_;
/*     */ 
/*     */ 
/*     */   
/*     */   public static CodeWrapperFactory makeForCodeGroup(String argCodeGroup) {
/*  35 */     CodeWrapperFactory factory = CACHE.get(argCodeGroup);
/*  36 */     if (factory == null) {
/*  37 */       factory = new CodeWrapperFactory(argCodeGroup);
/*  38 */       CACHE.put(argCodeGroup, factory);
/*     */     } 
/*  40 */     return factory;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private CodeWrapperFactory(String argCodeGroup) {
/*  46 */     this.codeGroup_ = argCodeGroup;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object wrapValue(Object argObject) {
/*  52 */     ValueWrapper wrapped = new ValueWrapper();
/*  53 */     wrapped.setActualValue(argObject);
/*  54 */     return wrapped;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class ValueWrapper
/*     */     implements IEnumValueWrapper
/*     */   {
/*  63 */     private ICodeValue _value = null;
/*  64 */     private String _code = null;
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object argOther) {
/*  69 */       if (argOther == this) {
/*  70 */         return true;
/*     */       }
/*  72 */       if (argOther == null) {
/*  73 */         return (this._code == null);
/*     */       }
/*  75 */       if (!(argOther instanceof ValueWrapper)) {
/*  76 */         return false;
/*     */       }
/*  78 */       ValueWrapper other = (ValueWrapper)argOther;
/*  79 */       if (ObjectUtils.equivalent(other.getActualValue(), getActualValue())) {
/*  80 */         return true;
/*     */       }
/*  82 */       return ObjectUtils.equivalent(this._code, other._code);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Object getActualValue() {
/*  89 */       return this._code;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*  95 */       if (this._code == null) {
/*  96 */         return 0;
/*     */       }
/*     */       
/*  99 */       return this._code.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setActualValue(Object argValue) {
/* 106 */       if (argValue instanceof ICodeValue) {
/* 107 */         this._value = (ICodeValue)argValue;
/*     */       }
/* 109 */       else if (argValue instanceof String) {
/* 110 */         this
/* 111 */           ._value = CodeLocator.getCodeValue(ConfigurationMgr.getOrganizationId(), CodeWrapperFactory.this.codeGroup_, (String)argValue);
/*     */       }
/* 113 */       else if (argValue instanceof IFormattable) {
/* 114 */         Object data = ((IFormattable)argValue).getUnformattedData();
/*     */         
/* 116 */         if (data instanceof String) {
/* 117 */           this._value = CodeLocator.getCodeValue(ConfigurationMgr.getOrganizationId(), CodeWrapperFactory.this.codeGroup_, (String)data);
/*     */         }
/*     */       } 
/*     */       
/* 121 */       if (this._value == null) {
/* 122 */         this._code = null;
/*     */       } else {
/*     */         
/* 125 */         this._code = this._value.getCode();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 132 */       String description = null;
/* 133 */       if (this._value == null) {
/* 134 */         description = "";
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 140 */         IFormattable formattable = FormattableFactory.getInstance().getSimpleFormattable(this._value.getDescription());
/* 141 */         description = formattable.toString(OutputContextType.VIEW);
/*     */       } 
/*     */       
/* 144 */       return description;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\CodeWrapperFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */