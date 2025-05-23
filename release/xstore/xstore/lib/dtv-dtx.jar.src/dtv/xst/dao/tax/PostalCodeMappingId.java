/*     */ package dtv.xst.dao.tax;
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
/*     */ public class PostalCodeMappingId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1218085834L;
/*     */   private String _city;
/*     */   private String _postalCode;
/*     */   private String _taxLocationId;
/*     */   
/*     */   public PostalCodeMappingId() {}
/*     */   
/*     */   public PostalCodeMappingId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCity() {
/*  31 */     return this._city;
/*     */   }
/*     */   
/*     */   public void setCity(String argCity) {
/*  35 */     this._city = (argCity != null && MANAGE_CASE) ? argCity.toUpperCase() : argCity;
/*     */   }
/*     */   
/*     */   public String getPostalCode() {
/*  39 */     return this._postalCode;
/*     */   }
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/*  43 */     this._postalCode = (argPostalCode != null && MANAGE_CASE) ? argPostalCode.toUpperCase() : argPostalCode;
/*     */   }
/*     */   
/*     */   public String getTaxLocationId() {
/*  47 */     return this._taxLocationId;
/*     */   }
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/*  51 */     this._taxLocationId = (argTaxLocationId != null && MANAGE_CASE) ? argTaxLocationId.toUpperCase() : argTaxLocationId;
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
/*  63 */       if ("null".equals(str)) {
/*  64 */         setCity((String)null);
/*     */       } else {
/*     */         
/*  67 */         setCity(str);
/*     */       } 
/*  69 */       str = tokens[1];
/*     */       
/*  71 */       setOrganizationId(Long.valueOf(str));
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setPostalCode((String)null);
/*     */       } else {
/*     */         
/*  78 */         setPostalCode(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setTaxLocationId((String)null);
/*     */       } else {
/*     */         
/*  86 */         setTaxLocationId(str);
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
/*  99 */     if (!(ob instanceof PostalCodeMappingId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     PostalCodeMappingId other = (PostalCodeMappingId)ob;
/* 103 */     return (((this._city == null && other._city == null) || (this._city != null && this._city
/*     */ 
/*     */       
/* 106 */       .equals(other._city))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 109 */       .equals(other._organizationId))) && ((this._postalCode == null && other._postalCode == null) || (this._postalCode != null && this._postalCode
/*     */ 
/*     */       
/* 112 */       .equals(other._postalCode))) && ((this._taxLocationId == null && other._taxLocationId == null) || (this._taxLocationId != null && this._taxLocationId
/*     */ 
/*     */       
/* 115 */       .equals(other._taxLocationId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._city == null) ? 0 : this._city
/* 122 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 123 */       .hashCode()) + ((this._postalCode == null) ? 0 : this._postalCode
/* 124 */       .hashCode()) + ((this._taxLocationId == null) ? 0 : this._taxLocationId
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "PostalCodeMapping";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(this._city)
/*     */       
/* 139 */       .append("::").append(String.valueOf(this._organizationId))
/* 140 */       .append("::").append(this._postalCode)
/* 141 */       .append("::").append(this._taxLocationId)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._city == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._postalCode == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._taxLocationId == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\PostalCodeMappingId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */