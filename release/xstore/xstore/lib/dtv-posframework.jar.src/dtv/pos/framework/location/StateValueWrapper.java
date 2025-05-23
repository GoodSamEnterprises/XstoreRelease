/*     */ package dtv.pos.framework.location;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.iframework.form.IEnumValueWrapper;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.address.AddressService;
/*     */ import dtv.util.address.IState;
/*     */ import dtv.util.address.StateCache;
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
/*     */ 
/*     */ public class StateValueWrapper
/*     */   implements IEnumValueWrapper
/*     */ {
/*     */   private IState _value;
/*  26 */   private String _code = null;
/*     */   private final String _countryCode;
/*  28 */   private String _stringed = null;
/*     */   
/*     */   public StateValueWrapper(String argCountryCode) {
/*  31 */     this._countryCode = argCountryCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/*  37 */     if (argOther == this) {
/*  38 */       return true;
/*     */     }
/*     */     
/*  41 */     if (argOther == null) {
/*  42 */       return (this._code == null);
/*     */     }
/*     */     
/*  45 */     if (!(argOther instanceof StateValueWrapper)) {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     StateValueWrapper other = (StateValueWrapper)argOther;
/*     */     
/*  51 */     if (ObjectUtils.equivalent(other.getActualValue(), getActualValue())) {
/*  52 */       return true;
/*     */     }
/*     */     
/*  55 */     return ObjectUtils.equivalent(this._code, other._code);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getActualValue() {
/*  62 */     return this._code;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  68 */     if (this._code == null) {
/*  69 */       return 0;
/*     */     }
/*     */     
/*  72 */     return this._code.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActualValue(Object argValue) {
/*  79 */     if (argValue instanceof IState) {
/*  80 */       this._value = (IState)argValue;
/*     */     }
/*  82 */     else if (argValue instanceof String) {
/*  83 */       StateCache cache = (StateCache)AddressService.getInternalInstance().getFieldCache("DEFAULT", "state");
/*  84 */       this._value = cache.getState(this._countryCode, (String)argValue);
/*     */     } 
/*     */     
/*  87 */     if (this._value == null) {
/*  88 */       this._code = null;
/*     */     } else {
/*     */       
/*  91 */       this._code = this._value.getCode();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  98 */     if (this._stringed == null) {
/*  99 */       if (this._value == null) {
/* 100 */         this._stringed = "";
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 106 */         IFormattable formattable = FormattableFactory.getInstance().getSimpleFormattable(this._value.getLongName());
/* 107 */         this._stringed = this._value.getCode() + " - " + formattable.toString(OutputContextType.VIEW);
/*     */       } 
/*     */     }
/*     */     
/* 111 */     return this._stringed;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\location\StateValueWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */