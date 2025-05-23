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
/*     */ 
/*     */ public class DatabaseTranslationId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1081353750L;
/*     */   private String _locale;
/*     */   private String _translationKey;
/*     */   
/*     */   public DatabaseTranslationId() {}
/*     */   
/*     */   public DatabaseTranslationId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocale() {
/*  30 */     return this._locale;
/*     */   }
/*     */   
/*     */   public void setLocale(String argLocale) {
/*  34 */     this._locale = (argLocale != null && MANAGE_CASE) ? argLocale.toUpperCase() : argLocale;
/*     */   }
/*     */   
/*     */   public String getTranslationKey() {
/*  38 */     return this._translationKey;
/*     */   }
/*     */   
/*     */   public void setTranslationKey(String argTranslationKey) {
/*  42 */     this._translationKey = (argTranslationKey != null && MANAGE_CASE) ? argTranslationKey.toUpperCase() : argTranslationKey;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  46 */     String str = argObjectIdValue;
/*  47 */     if (StringUtils.isEmpty(str)) {
/*  48 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  51 */       String[] tokens = str.split("::");
/*  52 */       str = tokens[0];
/*     */       
/*  54 */       setOrganizationId(Long.valueOf(str));
/*  55 */       str = tokens[1];
/*     */       
/*  57 */       if ("null".equals(str)) {
/*  58 */         setLocale((String)null);
/*     */       } else {
/*     */         
/*  61 */         setLocale(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setTranslationKey((String)null);
/*     */       } else {
/*     */         
/*  69 */         setTranslationKey(str);
/*     */       }
/*     */     
/*  72 */     } catch (Exception ee) {
/*  73 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  79 */     if (this == ob) {
/*  80 */       return true;
/*     */     }
/*  82 */     if (!(ob instanceof DatabaseTranslationId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     DatabaseTranslationId other = (DatabaseTranslationId)ob;
/*  86 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  89 */       .equals(other._organizationId))) && ((this._locale == null && other._locale == null) || (this._locale != null && this._locale
/*     */ 
/*     */       
/*  92 */       .equals(other._locale))) && ((this._translationKey == null && other._translationKey == null) || (this._translationKey != null && this._translationKey
/*     */ 
/*     */       
/*  95 */       .equals(other._translationKey))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 102 */       .hashCode()) + ((this._locale == null) ? 0 : this._locale
/* 103 */       .hashCode()) + ((this._translationKey == null) ? 0 : this._translationKey
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "DatabaseTranslation";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(
/* 117 */         String.valueOf(this._organizationId))
/* 118 */       .append("::").append(this._locale)
/* 119 */       .append("::").append(this._translationKey)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._locale == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._translationKey == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\DatabaseTranslationId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */