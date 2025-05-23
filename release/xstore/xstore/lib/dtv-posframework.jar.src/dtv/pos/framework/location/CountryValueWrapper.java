/*     */ package dtv.pos.framework.location;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.iframework.form.IEnumValueWrapper;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.address.AddressService;
/*     */ import dtv.util.address.CountryCache;
/*     */ import dtv.util.address.ICountry;
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
/*     */ public class CountryValueWrapper
/*     */   implements IEnumValueWrapper
/*     */ {
/*     */   private ICountry _value;
/*  26 */   private String _code = null;
/*  27 */   private String _stringed = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/*  32 */     if (argOther == this) {
/*  33 */       return true;
/*     */     }
/*     */     
/*  36 */     if (argOther == null) {
/*  37 */       return (this._code == null);
/*     */     }
/*     */     
/*  40 */     if (!(argOther instanceof CountryValueWrapper)) {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     CountryValueWrapper other = (CountryValueWrapper)argOther;
/*     */     
/*  46 */     if (ObjectUtils.equivalent(other.getActualValue(), getActualValue())) {
/*  47 */       return true;
/*     */     }
/*     */     
/*  50 */     return ObjectUtils.equivalent(this._code, other._code);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getActualValue() {
/*  57 */     return this._code;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  63 */     if (this._code == null) {
/*  64 */       return 0;
/*     */     }
/*     */     
/*  67 */     return this._code.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActualValue(Object argValue) {
/*  74 */     if (argValue instanceof ICountry) {
/*  75 */       this._value = (ICountry)argValue;
/*     */     }
/*  77 */     else if (argValue instanceof String) {
/*     */       
/*  79 */       CountryCache cache = (CountryCache)AddressService.getInternalInstance().getFieldCache("DEFAULT", "country");
/*  80 */       this._value = cache.getCountry((String)argValue);
/*     */     }
/*  82 */     else if (argValue instanceof IFormattable) {
/*  83 */       Object data = ((IFormattable)argValue).getUnformattedData();
/*     */       
/*  85 */       if (data instanceof String) {
/*     */         
/*  87 */         CountryCache cache = (CountryCache)AddressService.getInternalInstance().getFieldCache("DEFAULT", "country");
/*  88 */         this._value = cache.getCountry((String)data);
/*     */       } 
/*     */     } 
/*     */     
/*  92 */     if (this._value == null) {
/*  93 */       this._code = null;
/*     */     } else {
/*     */       
/*  96 */       this._code = this._value.getCode();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 103 */     if (this._stringed == null)
/*     */     {
/* 105 */       if (this._value == null) {
/* 106 */         this._stringed = "";
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 112 */         IFormattable formattable = FormattableFactory.getInstance().getSimpleFormattable(this._value.getLongName());
/* 113 */         this._stringed = this._value.getCode() + " - " + formattable.toString(OutputContextType.VIEW);
/*     */       } 
/*     */     }
/*     */     
/* 117 */     return this._stringed;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\location\CountryValueWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */