/*     */ package dtv.xst.dao.com;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DatabaseTranslationPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 997716491L;
/*     */   private String _locale;
/*     */   private String _translationKey;
/*     */   private String _propertyCode;
/*     */   
/*     */   public DatabaseTranslationPropertyId() {}
/*     */   
/*     */   public DatabaseTranslationPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocale() {
/*  31 */     return this._locale;
/*     */   }
/*     */   
/*     */   public void setLocale(String argLocale) {
/*  35 */     this._locale = (argLocale != null && MANAGE_CASE) ? argLocale.toUpperCase() : argLocale;
/*     */   }
/*     */   
/*     */   public String getTranslationKey() {
/*  39 */     return this._translationKey;
/*     */   }
/*     */   
/*     */   public void setTranslationKey(String argTranslationKey) {
/*  43 */     this._translationKey = (argTranslationKey != null && MANAGE_CASE) ? argTranslationKey.toUpperCase() : argTranslationKey;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  47 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  51 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  55 */     String str = argObjectIdValue;
/*  56 */     if (StringUtils.isEmpty(str)) {
/*  57 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  60 */       String[] tokens = str.split("::");
/*  61 */       str = tokens[0];
/*     */       
/*  63 */       setOrganizationId(Long.valueOf(str));
/*  64 */       str = tokens[1];
/*     */       
/*  66 */       if ("null".equals(str)) {
/*  67 */         setLocale((String)null);
/*     */       } else {
/*     */         
/*  70 */         setLocale(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setTranslationKey((String)null);
/*     */       } else {
/*     */         
/*  78 */         setTranslationKey(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  86 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  89 */     } catch (Exception ee) {
/*  90 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  96 */     if (this == ob) {
/*  97 */       return true;
/*     */     }
/*  99 */     if (!(ob instanceof DatabaseTranslationPropertyId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     DatabaseTranslationPropertyId other = (DatabaseTranslationPropertyId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._locale == null && other._locale == null) || (this._locale != null && this._locale
/*     */ 
/*     */       
/* 109 */       .equals(other._locale))) && ((this._translationKey == null && other._translationKey == null) || (this._translationKey != null && this._translationKey
/*     */ 
/*     */       
/* 112 */       .equals(other._translationKey))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 115 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._locale == null) ? 0 : this._locale
/* 123 */       .hashCode()) + ((this._translationKey == null) ? 0 : this._translationKey
/* 124 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "DatabaseTranslationProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._locale)
/* 140 */       .append("::").append(this._translationKey)
/* 141 */       .append("::").append(this._propertyCode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._locale == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._translationKey == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._propertyCode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\DatabaseTranslationPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */