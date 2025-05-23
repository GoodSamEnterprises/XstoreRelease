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
/*     */ public class AddressPostalCodeId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1501423540L;
/*     */   private String _countryId;
/*     */   private String _postalCodeId;
/*     */   private String _addressMode;
/*     */   
/*     */   public AddressPostalCodeId() {}
/*     */   
/*     */   public AddressPostalCodeId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCountryId() {
/*  31 */     return this._countryId;
/*     */   }
/*     */   
/*     */   public void setCountryId(String argCountryId) {
/*  35 */     this._countryId = (argCountryId != null && MANAGE_CASE) ? argCountryId.toUpperCase() : argCountryId;
/*     */   }
/*     */   
/*     */   public String getPostalCodeId() {
/*  39 */     return this._postalCodeId;
/*     */   }
/*     */   
/*     */   public void setPostalCodeId(String argPostalCodeId) {
/*  43 */     this._postalCodeId = (argPostalCodeId != null && MANAGE_CASE) ? argPostalCodeId.toUpperCase() : argPostalCodeId;
/*     */   }
/*     */   
/*     */   public String getAddressMode() {
/*  47 */     return this._addressMode;
/*     */   }
/*     */   
/*     */   public void setAddressMode(String argAddressMode) {
/*  51 */     this._addressMode = (argAddressMode != null && MANAGE_CASE) ? argAddressMode.toUpperCase() : argAddressMode;
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
/*  67 */         setCountryId((String)null);
/*     */       } else {
/*     */         
/*  70 */         setCountryId(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setPostalCodeId((String)null);
/*     */       } else {
/*     */         
/*  78 */         setPostalCodeId(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setAddressMode((String)null);
/*     */       } else {
/*     */         
/*  86 */         setAddressMode(str);
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
/*  99 */     if (!(ob instanceof AddressPostalCodeId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     AddressPostalCodeId other = (AddressPostalCodeId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._countryId == null && other._countryId == null) || (this._countryId != null && this._countryId
/*     */ 
/*     */       
/* 109 */       .equals(other._countryId))) && ((this._postalCodeId == null && other._postalCodeId == null) || (this._postalCodeId != null && this._postalCodeId
/*     */ 
/*     */       
/* 112 */       .equals(other._postalCodeId))) && ((this._addressMode == null && other._addressMode == null) || (this._addressMode != null && this._addressMode
/*     */ 
/*     */       
/* 115 */       .equals(other._addressMode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._countryId == null) ? 0 : this._countryId
/* 123 */       .hashCode()) + ((this._postalCodeId == null) ? 0 : this._postalCodeId
/* 124 */       .hashCode()) + ((this._addressMode == null) ? 0 : this._addressMode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "AddressPostalCode";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._countryId)
/* 140 */       .append("::").append(this._postalCodeId)
/* 141 */       .append("::").append(this._addressMode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._countryId == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._postalCodeId == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._addressMode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\AddressPostalCodeId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */