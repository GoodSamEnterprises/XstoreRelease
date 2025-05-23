/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.iframework.form.IEnumValueWrapper;
/*     */ import dtv.util.ICodeInterface;
/*     */ import java.lang.reflect.Method;
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
/*     */ public class CodeEnumValueWrapper
/*     */   implements IEnumValueWrapper
/*     */ {
/*  22 */   private static final FormattableFactory FF = FormattableFactory.getInstance();
/*     */   
/*  24 */   private IFormattable toString_ = IFormattable.EMPTY;
/*  25 */   private Object value_ = null;
/*  26 */   private String code_ = null;
/*     */   
/*     */   private Method descriptionAccessor_;
/*     */   
/*     */   public boolean equals(Object argOther) {
/*  31 */     if (argOther == this) {
/*  32 */       return true;
/*     */     }
/*  34 */     if (argOther == null) {
/*  35 */       return (this.code_ == null);
/*     */     }
/*  37 */     if (!(argOther instanceof CodeEnumValueWrapper)) {
/*  38 */       return false;
/*     */     }
/*  40 */     CodeEnumValueWrapper other = (CodeEnumValueWrapper)argOther;
/*  41 */     if (other.getActualValue() == getActualValue()) {
/*  42 */       return true;
/*     */     }
/*  44 */     if (this.code_ == null) {
/*  45 */       return (other.code_ == null);
/*     */     }
/*  47 */     return this.code_.equals(other.code_);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getActualValue() {
/*  52 */     return this.value_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  57 */     if (this.code_ == null) {
/*  58 */       return 0;
/*     */     }
/*     */     
/*  61 */     return this.code_.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActualValue(Object newValue) {
/*  67 */     this.value_ = newValue;
/*  68 */     this.toString_ = getDescription(this.value_);
/*  69 */     this.code_ = getCode(this.value_);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  74 */     return this.toString_.toString(OutputContextType.VIEW);
/*     */   }
/*     */   
/*     */   private String getCode(Object argValue) {
/*  78 */     if (argValue == null) {
/*  79 */       return null;
/*     */     }
/*  81 */     if (argValue instanceof ICodeInterface) {
/*  82 */       return ((ICodeInterface)argValue).getCode();
/*     */     }
/*     */     
/*     */     try {
/*  86 */       if (this.descriptionAccessor_ == null) {
/*  87 */         this.descriptionAccessor_ = argValue.getClass().getMethod("getCode", new Class[0]);
/*     */       }
/*  89 */       return (String)this.descriptionAccessor_.invoke(argValue, new Object[0]);
/*     */     }
/*  91 */     catch (Exception ex) {
/*     */ 
/*     */       
/*  94 */       IllegalArgumentException newEx = new IllegalArgumentException(argValue.getClass().getName() + " does not implement " + ICodeInterface.class.getName());
/*  95 */       newEx.initCause(ex);
/*  96 */       throw newEx;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private IFormattable getDescription(Object argValue) {
/* 103 */     if (argValue == null) {
/* 104 */       return IFormattable.EMPTY;
/*     */     }
/* 106 */     if (argValue instanceof ICodeInterface) {
/* 107 */       return FF.getSimpleFormattable(((ICodeInterface)argValue).getDescription());
/*     */     }
/*     */     
/*     */     try {
/* 111 */       if (this.descriptionAccessor_ == null) {
/* 112 */         this.descriptionAccessor_ = argValue.getClass().getMethod("getDescription", new Class[0]);
/*     */       }
/* 114 */       return FF.getSimpleFormattable((String)this.descriptionAccessor_.invoke(argValue, new Object[0]));
/*     */     }
/* 116 */     catch (Exception ex) {
/*     */ 
/*     */       
/* 119 */       IllegalArgumentException newEx = new IllegalArgumentException(argValue.getClass().getName() + " does not implement " + ICodeInterface.class.getName());
/* 120 */       newEx.initCause(ex);
/* 121 */       throw newEx;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\CodeEnumValueWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */