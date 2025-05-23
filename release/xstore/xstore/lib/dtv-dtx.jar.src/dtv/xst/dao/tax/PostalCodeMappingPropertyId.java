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
/*     */ public class PostalCodeMappingPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1220466645L;
/*     */   private String _city;
/*     */   private String _postalCode;
/*     */   private String _taxLocationId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public PostalCodeMappingPropertyId() {}
/*     */   
/*     */   public PostalCodeMappingPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCity() {
/*  32 */     return this._city;
/*     */   }
/*     */   
/*     */   public void setCity(String argCity) {
/*  36 */     this._city = (argCity != null && MANAGE_CASE) ? argCity.toUpperCase() : argCity;
/*     */   }
/*     */   
/*     */   public String getPostalCode() {
/*  40 */     return this._postalCode;
/*     */   }
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/*  44 */     this._postalCode = (argPostalCode != null && MANAGE_CASE) ? argPostalCode.toUpperCase() : argPostalCode;
/*     */   }
/*     */   
/*     */   public String getTaxLocationId() {
/*  48 */     return this._taxLocationId;
/*     */   }
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/*  52 */     this._taxLocationId = (argTaxLocationId != null && MANAGE_CASE) ? argTaxLocationId.toUpperCase() : argTaxLocationId;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  56 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  60 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  64 */     String str = argObjectIdValue;
/*  65 */     if (StringUtils.isEmpty(str)) {
/*  66 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  69 */       String[] tokens = str.split("::");
/*  70 */       str = tokens[0];
/*     */       
/*  72 */       if ("null".equals(str)) {
/*  73 */         setCity((String)null);
/*     */       } else {
/*     */         
/*  76 */         setCity(str);
/*     */       } 
/*  78 */       str = tokens[1];
/*     */       
/*  80 */       setOrganizationId(Long.valueOf(str));
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setPostalCode((String)null);
/*     */       } else {
/*     */         
/*  87 */         setPostalCode(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       if ("null".equals(str)) {
/*  92 */         setTaxLocationId((String)null);
/*     */       } else {
/*     */         
/*  95 */         setTaxLocationId(str);
/*     */       } 
/*  97 */       str = tokens[4];
/*     */       
/*  99 */       if ("null".equals(str)) {
/* 100 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 103 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 106 */     } catch (Exception ee) {
/* 107 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 113 */     if (this == ob) {
/* 114 */       return true;
/*     */     }
/* 116 */     if (!(ob instanceof PostalCodeMappingPropertyId)) {
/* 117 */       return false;
/*     */     }
/* 119 */     PostalCodeMappingPropertyId other = (PostalCodeMappingPropertyId)ob;
/* 120 */     return (((this._city == null && other._city == null) || (this._city != null && this._city
/*     */ 
/*     */       
/* 123 */       .equals(other._city))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 126 */       .equals(other._organizationId))) && ((this._postalCode == null && other._postalCode == null) || (this._postalCode != null && this._postalCode
/*     */ 
/*     */       
/* 129 */       .equals(other._postalCode))) && ((this._taxLocationId == null && other._taxLocationId == null) || (this._taxLocationId != null && this._taxLocationId
/*     */ 
/*     */       
/* 132 */       .equals(other._taxLocationId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 135 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 141 */     return ((this._city == null) ? 0 : this._city
/* 142 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 143 */       .hashCode()) + ((this._postalCode == null) ? 0 : this._postalCode
/* 144 */       .hashCode()) + ((this._taxLocationId == null) ? 0 : this._taxLocationId
/* 145 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 146 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 151 */     return "PostalCodeMappingProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 156 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 158 */     return buff.append(this._city)
/*     */       
/* 160 */       .append("::").append(String.valueOf(this._organizationId))
/* 161 */       .append("::").append(this._postalCode)
/* 162 */       .append("::").append(this._taxLocationId)
/* 163 */       .append("::").append(this._propertyCode)
/* 164 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 168 */     if (this._city == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (this._postalCode == null) {
/* 172 */       return false;
/*     */     }
/* 174 */     if (this._taxLocationId == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     if (this._propertyCode == null) {
/* 178 */       return false;
/*     */     }
/* 180 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\PostalCodeMappingPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */