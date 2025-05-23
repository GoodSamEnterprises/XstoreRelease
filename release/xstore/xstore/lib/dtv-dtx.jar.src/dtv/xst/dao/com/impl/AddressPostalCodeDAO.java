/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.AddressPostalCodeId;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AddressPostalCodeDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1501423540L;
/*  23 */   private static final Logger _logger = Logger.getLogger(AddressPostalCodeDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _countryId;
/*     */   private String _postalCodeId;
/*     */   private String _addressMode;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _postalCode;
/*     */   private String _stateId;
/*     */   private String _cityName;
/*     */   
/*     */   public Long getOrganizationId() {
/*  38 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  42 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  43 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCountryId() {
/*  48 */     return this._countryId;
/*     */   }
/*     */   
/*     */   public void setCountryId(String argCountryId) {
/*  52 */     if (changed(argCountryId, this._countryId, "countryId")) {
/*  53 */       this._countryId = (argCountryId != null && MANAGE_CASE) ? argCountryId.toUpperCase() : argCountryId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPostalCodeId() {
/*  58 */     return this._postalCodeId;
/*     */   }
/*     */   
/*     */   public void setPostalCodeId(String argPostalCodeId) {
/*  62 */     if (changed(argPostalCodeId, this._postalCodeId, "postalCodeId")) {
/*  63 */       this._postalCodeId = (argPostalCodeId != null && MANAGE_CASE) ? argPostalCodeId.toUpperCase() : argPostalCodeId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddressMode() {
/*  68 */     return this._addressMode;
/*     */   }
/*     */   
/*     */   public void setAddressMode(String argAddressMode) {
/*  72 */     if (changed(argAddressMode, this._addressMode, "addressMode")) {
/*  73 */       this._addressMode = (argAddressMode != null && MANAGE_CASE) ? argAddressMode.toUpperCase() : argAddressMode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  78 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  82 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  83 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  89 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  93 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  94 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  99 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 103 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 104 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 110 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 114 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 115 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPostalCode() {
/* 120 */     return this._postalCode;
/*     */   }
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/* 124 */     if (changed(argPostalCode, this._postalCode, "postalCode")) {
/* 125 */       this._postalCode = argPostalCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStateId() {
/* 130 */     return this._stateId;
/*     */   }
/*     */   
/*     */   public void setStateId(String argStateId) {
/* 134 */     if (changed(argStateId, this._stateId, "stateId")) {
/* 135 */       this._stateId = argStateId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCityName() {
/* 140 */     return this._cityName;
/*     */   }
/*     */   
/*     */   public void setCityName(String argCityName) {
/* 144 */     if (changed(argCityName, this._cityName, "cityName")) {
/* 145 */       this._cityName = argCityName;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 152 */     StringBuilder buf = new StringBuilder(512);
/* 153 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 154 */     if (getOrganizationId() != null) {
/* 155 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 157 */     if (getCountryId() != null) {
/* 158 */       buf.append("countryId").append("=").append(getCountryId()).append(" ");
/*     */     }
/* 160 */     if (getPostalCodeId() != null) {
/* 161 */       buf.append("postalCodeId").append("=").append(getPostalCodeId()).append(" ");
/*     */     }
/* 163 */     if (getAddressMode() != null) {
/* 164 */       buf.append("addressMode").append("=").append(getAddressMode()).append(" ");
/*     */     }
/* 166 */     if (getCreateDate() != null) {
/* 167 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 169 */     if (getCreateUserId() != null) {
/* 170 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 172 */     if (getUpdateDate() != null) {
/* 173 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 175 */     if (getUpdateUserId() != null) {
/* 176 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 178 */     if (getPostalCode() != null) {
/* 179 */       buf.append("postalCode").append("=").append(getPostalCode()).append(" ");
/*     */     }
/* 181 */     if (getStateId() != null) {
/* 182 */       buf.append("stateId").append("=").append(getStateId()).append(" ");
/*     */     }
/* 184 */     if (getCityName() != null) {
/* 185 */       buf.append("cityName").append("=").append(getCityName()).append(" ");
/*     */     }
/*     */     
/* 188 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     AddressPostalCodeId id = new AddressPostalCodeId();
/* 193 */     id.setOrganizationId(getOrganizationId());
/* 194 */     id.setCountryId(getCountryId());
/* 195 */     id.setPostalCodeId(getPostalCodeId());
/* 196 */     id.setAddressMode(getAddressMode());
/* 197 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 201 */     setOrganizationId(((AddressPostalCodeId)argObjectId).getOrganizationId());
/* 202 */     setCountryId(((AddressPostalCodeId)argObjectId).getCountryId());
/* 203 */     setPostalCodeId(((AddressPostalCodeId)argObjectId).getPostalCodeId());
/* 204 */     setAddressMode(((AddressPostalCodeId)argObjectId).getAddressMode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 208 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 212 */     StringBuilder buf = new StringBuilder(550);
/* 213 */     buf.append("<").append("dao").append(" name=\"AddressPostalCode\" cmd=\"" + getObjectStateString() + "\">");
/* 214 */     getFieldsAsXml(buf);
/* 215 */     buf.append("</").append("dao").append(">");
/*     */     
/* 217 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 221 */     Map<String, String> values = super.getValues();
/* 222 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 223 */     if (this._countryId != null) values.put("CountryId", DaoUtils.getXmlSafeFieldValue(12, this._countryId)); 
/* 224 */     if (this._postalCodeId != null) values.put("PostalCodeId", DaoUtils.getXmlSafeFieldValue(12, this._postalCodeId)); 
/* 225 */     if (this._addressMode != null) values.put("AddressMode", DaoUtils.getXmlSafeFieldValue(12, this._addressMode)); 
/* 226 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 227 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 228 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 229 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 230 */     if (this._postalCode != null) values.put("PostalCode", DaoUtils.getXmlSafeFieldValue(12, this._postalCode)); 
/* 231 */     if (this._stateId != null) values.put("StateId", DaoUtils.getXmlSafeFieldValue(12, this._stateId)); 
/* 232 */     if (this._cityName != null) values.put("CityName", DaoUtils.getXmlSafeFieldValue(12, this._cityName)); 
/* 233 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 238 */     super.setValues(argValues);
/* 239 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 241 */       String fieldName = field.getKey();
/* 242 */       String fieldValue = field.getValue();
/* 243 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 247 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 248 */             setOrganizationId((Long)value);
/* 249 */           } catch (Exception ee) {
/* 250 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CountryId":
/*     */           try {
/* 256 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 257 */             setCountryId((String)value);
/* 258 */           } catch (Exception ee) {
/* 259 */             throw new DtxException("An exception occurred while calling setCountryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PostalCodeId":
/*     */           try {
/* 265 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 266 */             setPostalCodeId((String)value);
/* 267 */           } catch (Exception ee) {
/* 268 */             throw new DtxException("An exception occurred while calling setPostalCodeId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AddressMode":
/*     */           try {
/* 274 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 275 */             setAddressMode((String)value);
/* 276 */           } catch (Exception ee) {
/* 277 */             throw new DtxException("An exception occurred while calling setAddressMode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 284 */             setCreateDate((Date)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 293 */             setCreateUserId((String)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 302 */             setUpdateDate((Date)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 311 */             setUpdateUserId((String)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PostalCode":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 320 */             setPostalCode((String)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setPostalCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StateId":
/*     */           try {
/* 328 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 329 */             setStateId((String)value);
/* 330 */           } catch (Exception ee) {
/* 331 */             throw new DtxException("An exception occurred while calling setStateId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CityName":
/*     */           try {
/* 337 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 338 */             setCityName((String)value);
/* 339 */           } catch (Exception ee) {
/* 340 */             throw new DtxException("An exception occurred while calling setCityName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AddressPostalCodeDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */