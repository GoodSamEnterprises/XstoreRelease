/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.CustomerConsentInfoPropertyId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomerConsentInfoPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 803966207L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerConsentInfoPropertyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private DtvDate _effectiveDate;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private DtvDate _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
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
/*     */   public Date getEffectiveDate() {
/*  48 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  52 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/*  53 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/*  59 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  63 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/*  64 */       this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/*  69 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/*  73 */     if (changed(argType, this._type, "type")) {
/*  74 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/*  79 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/*  83 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/*  84 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/*  89 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/*  93 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/*  94 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 100 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 104 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 105 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 110 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 114 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 115 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 121 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 125 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 126 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 131 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 135 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 136 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 142 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 146 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 147 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 154 */     StringBuilder buf = new StringBuilder(512);
/* 155 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 156 */     if (getOrganizationId() != null) {
/* 157 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 159 */     if (getEffectiveDate() != null) {
/* 160 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 162 */     if (getPropertyCode() != null) {
/* 163 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 165 */     if (getType() != null) {
/* 166 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 168 */     if (getStringValue() != null) {
/* 169 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 171 */     if (getDateValue() != null) {
/* 172 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 174 */     if (getDecimalValue() != null) {
/* 175 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 177 */     if (getCreateDate() != null) {
/* 178 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 180 */     if (getCreateUserId() != null) {
/* 181 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 183 */     if (getUpdateDate() != null) {
/* 184 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 186 */     if (getUpdateUserId() != null) {
/* 187 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 190 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 194 */     CustomerConsentInfoPropertyId id = new CustomerConsentInfoPropertyId();
/* 195 */     id.setOrganizationId(getOrganizationId());
/* 196 */     id.setEffectiveDate(getEffectiveDate());
/* 197 */     id.setPropertyCode(getPropertyCode());
/* 198 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 202 */     setOrganizationId(((CustomerConsentInfoPropertyId)argObjectId).getOrganizationId());
/* 203 */     setEffectiveDate(((CustomerConsentInfoPropertyId)argObjectId).getEffectiveDate());
/* 204 */     setPropertyCode(((CustomerConsentInfoPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 208 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 212 */     StringBuilder buf = new StringBuilder(550);
/* 213 */     buf.append("<").append("dao").append(" name=\"CustomerConsentInfoProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 214 */     getFieldsAsXml(buf);
/* 215 */     buf.append("</").append("dao").append(">");
/*     */     
/* 217 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 221 */     Map<String, String> values = super.getValues();
/* 222 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 223 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 224 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 225 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 226 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 227 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 228 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 229 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 230 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 231 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 232 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
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
/*     */         case "EffectiveDate":
/*     */           try {
/* 256 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 257 */             setEffectiveDate((Date)value);
/* 258 */           } catch (Exception ee) {
/* 259 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 265 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 266 */             setPropertyCode((String)value);
/* 267 */           } catch (Exception ee) {
/* 268 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 274 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 275 */             setType((String)value);
/* 276 */           } catch (Exception ee) {
/* 277 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 284 */             setStringValue((String)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 293 */             setDateValue((Date)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 302 */             setDecimalValue((BigDecimal)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 311 */             setCreateDate((Date)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 320 */             setCreateUserId((String)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 328 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 329 */             setUpdateDate((Date)value);
/* 330 */           } catch (Exception ee) {
/* 331 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 337 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 338 */             setUpdateUserId((String)value);
/* 339 */           } catch (Exception ee) {
/* 340 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\CustomerConsentInfoPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */