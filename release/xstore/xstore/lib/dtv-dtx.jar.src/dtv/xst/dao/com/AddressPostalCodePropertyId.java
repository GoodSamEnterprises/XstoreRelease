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
/*     */ public class AddressPostalCodePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1004752449L;
/*     */   private String _countryId;
/*     */   private String _postalCodeId;
/*     */   private String _addressMode;
/*     */   private String _propertyCode;
/*     */   
/*     */   public AddressPostalCodePropertyId() {}
/*     */   
/*     */   public AddressPostalCodePropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCountryId() {
/*  32 */     return this._countryId;
/*     */   }
/*     */   
/*     */   public void setCountryId(String argCountryId) {
/*  36 */     this._countryId = (argCountryId != null && MANAGE_CASE) ? argCountryId.toUpperCase() : argCountryId;
/*     */   }
/*     */   
/*     */   public String getPostalCodeId() {
/*  40 */     return this._postalCodeId;
/*     */   }
/*     */   
/*     */   public void setPostalCodeId(String argPostalCodeId) {
/*  44 */     this._postalCodeId = (argPostalCodeId != null && MANAGE_CASE) ? argPostalCodeId.toUpperCase() : argPostalCodeId;
/*     */   }
/*     */   
/*     */   public String getAddressMode() {
/*  48 */     return this._addressMode;
/*     */   }
/*     */   
/*     */   public void setAddressMode(String argAddressMode) {
/*  52 */     this._addressMode = (argAddressMode != null && MANAGE_CASE) ? argAddressMode.toUpperCase() : argAddressMode;
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
/*  72 */       setOrganizationId(Long.valueOf(str));
/*  73 */       str = tokens[1];
/*     */       
/*  75 */       if ("null".equals(str)) {
/*  76 */         setCountryId((String)null);
/*     */       } else {
/*     */         
/*  79 */         setCountryId(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setPostalCodeId((String)null);
/*     */       } else {
/*     */         
/*  87 */         setPostalCodeId(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       if ("null".equals(str)) {
/*  92 */         setAddressMode((String)null);
/*     */       } else {
/*     */         
/*  95 */         setAddressMode(str);
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
/* 116 */     if (!(ob instanceof AddressPostalCodePropertyId)) {
/* 117 */       return false;
/*     */     }
/* 119 */     AddressPostalCodePropertyId other = (AddressPostalCodePropertyId)ob;
/* 120 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 123 */       .equals(other._organizationId))) && ((this._countryId == null && other._countryId == null) || (this._countryId != null && this._countryId
/*     */ 
/*     */       
/* 126 */       .equals(other._countryId))) && ((this._postalCodeId == null && other._postalCodeId == null) || (this._postalCodeId != null && this._postalCodeId
/*     */ 
/*     */       
/* 129 */       .equals(other._postalCodeId))) && ((this._addressMode == null && other._addressMode == null) || (this._addressMode != null && this._addressMode
/*     */ 
/*     */       
/* 132 */       .equals(other._addressMode))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 135 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 141 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 142 */       .hashCode()) + ((this._countryId == null) ? 0 : this._countryId
/* 143 */       .hashCode()) + ((this._postalCodeId == null) ? 0 : this._postalCodeId
/* 144 */       .hashCode()) + ((this._addressMode == null) ? 0 : this._addressMode
/* 145 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 146 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 151 */     return "AddressPostalCodeProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 156 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 158 */     return buff.append(
/* 159 */         String.valueOf(this._organizationId))
/* 160 */       .append("::").append(this._countryId)
/* 161 */       .append("::").append(this._postalCodeId)
/* 162 */       .append("::").append(this._addressMode)
/* 163 */       .append("::").append(this._propertyCode)
/* 164 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 168 */     if (this._countryId == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (this._postalCodeId == null) {
/* 172 */       return false;
/*     */     }
/* 174 */     if (this._addressMode == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     if (this._propertyCode == null) {
/* 178 */       return false;
/*     */     }
/* 180 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\AddressPostalCodePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */