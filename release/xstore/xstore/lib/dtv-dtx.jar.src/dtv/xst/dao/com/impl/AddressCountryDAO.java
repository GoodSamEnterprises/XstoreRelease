/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.AddressCountryId;
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
/*     */ public class AddressCountryDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 367625506L;
/*  23 */   private static final Logger _logger = Logger.getLogger(AddressCountryDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _countryId;
/*     */   private String _addressMode;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _countryName;
/*     */   private Integer _postalCodeMaxLength;
/*     */   
/*     */   public Long getOrganizationId() {
/*  36 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  40 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  41 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCountryId() {
/*  46 */     return this._countryId;
/*     */   }
/*     */   
/*     */   public void setCountryId(String argCountryId) {
/*  50 */     if (changed(argCountryId, this._countryId, "countryId")) {
/*  51 */       this._countryId = (argCountryId != null && MANAGE_CASE) ? argCountryId.toUpperCase() : argCountryId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddressMode() {
/*  56 */     return this._addressMode;
/*     */   }
/*     */   
/*     */   public void setAddressMode(String argAddressMode) {
/*  60 */     if (changed(argAddressMode, this._addressMode, "addressMode")) {
/*  61 */       this._addressMode = (argAddressMode != null && MANAGE_CASE) ? argAddressMode.toUpperCase() : argAddressMode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  66 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  70 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  71 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  77 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  81 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  82 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  87 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  91 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  92 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  98 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 102 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 103 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCountryName() {
/* 108 */     return this._countryName;
/*     */   }
/*     */   
/*     */   public void setCountryName(String argCountryName) {
/* 112 */     if (changed(argCountryName, this._countryName, "countryName")) {
/* 113 */       this._countryName = argCountryName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getPostalCodeMaxLength() {
/* 118 */     return this._postalCodeMaxLength;
/*     */   }
/*     */   
/*     */   public void setPostalCodeMaxLength(Integer argPostalCodeMaxLength) {
/* 122 */     if (changed(argPostalCodeMaxLength, this._postalCodeMaxLength, "postalCodeMaxLength")) {
/* 123 */       this._postalCodeMaxLength = argPostalCodeMaxLength;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buf = new StringBuilder(512);
/* 131 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 132 */     if (getOrganizationId() != null) {
/* 133 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 135 */     if (getCountryId() != null) {
/* 136 */       buf.append("countryId").append("=").append(getCountryId()).append(" ");
/*     */     }
/* 138 */     if (getAddressMode() != null) {
/* 139 */       buf.append("addressMode").append("=").append(getAddressMode()).append(" ");
/*     */     }
/* 141 */     if (getCreateDate() != null) {
/* 142 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 144 */     if (getCreateUserId() != null) {
/* 145 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 147 */     if (getUpdateDate() != null) {
/* 148 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 150 */     if (getUpdateUserId() != null) {
/* 151 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 153 */     if (getCountryName() != null) {
/* 154 */       buf.append("countryName").append("=").append(getCountryName()).append(" ");
/*     */     }
/* 156 */     if (getPostalCodeMaxLength() != null) {
/* 157 */       buf.append("postalCodeMaxLength").append("=").append(getPostalCodeMaxLength()).append(" ");
/*     */     }
/*     */     
/* 160 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 164 */     AddressCountryId id = new AddressCountryId();
/* 165 */     id.setOrganizationId(getOrganizationId());
/* 166 */     id.setCountryId(getCountryId());
/* 167 */     id.setAddressMode(getAddressMode());
/* 168 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 172 */     setOrganizationId(((AddressCountryId)argObjectId).getOrganizationId());
/* 173 */     setCountryId(((AddressCountryId)argObjectId).getCountryId());
/* 174 */     setAddressMode(((AddressCountryId)argObjectId).getAddressMode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 178 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 182 */     StringBuilder buf = new StringBuilder(450);
/* 183 */     buf.append("<").append("dao").append(" name=\"AddressCountry\" cmd=\"" + getObjectStateString() + "\">");
/* 184 */     getFieldsAsXml(buf);
/* 185 */     buf.append("</").append("dao").append(">");
/*     */     
/* 187 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 191 */     Map<String, String> values = super.getValues();
/* 192 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 193 */     if (this._countryId != null) values.put("CountryId", DaoUtils.getXmlSafeFieldValue(12, this._countryId)); 
/* 194 */     if (this._addressMode != null) values.put("AddressMode", DaoUtils.getXmlSafeFieldValue(12, this._addressMode)); 
/* 195 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 196 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 197 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 198 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 199 */     if (this._countryName != null) values.put("CountryName", DaoUtils.getXmlSafeFieldValue(12, this._countryName)); 
/* 200 */     if (this._postalCodeMaxLength != null) values.put("PostalCodeMaxLength", DaoUtils.getXmlSafeFieldValue(4, this._postalCodeMaxLength)); 
/* 201 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 206 */     super.setValues(argValues);
/* 207 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 209 */       String fieldName = field.getKey();
/* 210 */       String fieldValue = field.getValue();
/* 211 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 215 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 216 */             setOrganizationId((Long)value);
/* 217 */           } catch (Exception ee) {
/* 218 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CountryId":
/*     */           try {
/* 224 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 225 */             setCountryId((String)value);
/* 226 */           } catch (Exception ee) {
/* 227 */             throw new DtxException("An exception occurred while calling setCountryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AddressMode":
/*     */           try {
/* 233 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 234 */             setAddressMode((String)value);
/* 235 */           } catch (Exception ee) {
/* 236 */             throw new DtxException("An exception occurred while calling setAddressMode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 242 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 243 */             setCreateDate((Date)value);
/* 244 */           } catch (Exception ee) {
/* 245 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 251 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 252 */             setCreateUserId((String)value);
/* 253 */           } catch (Exception ee) {
/* 254 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 260 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 261 */             setUpdateDate((Date)value);
/* 262 */           } catch (Exception ee) {
/* 263 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 269 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 270 */             setUpdateUserId((String)value);
/* 271 */           } catch (Exception ee) {
/* 272 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CountryName":
/*     */           try {
/* 278 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 279 */             setCountryName((String)value);
/* 280 */           } catch (Exception ee) {
/* 281 */             throw new DtxException("An exception occurred while calling setCountryName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PostalCodeMaxLength":
/*     */           try {
/* 287 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 288 */             setPostalCodeMaxLength((Integer)value);
/* 289 */           } catch (Exception ee) {
/* 290 */             throw new DtxException("An exception occurred while calling setPostalCodeMaxLength() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AddressCountryDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */