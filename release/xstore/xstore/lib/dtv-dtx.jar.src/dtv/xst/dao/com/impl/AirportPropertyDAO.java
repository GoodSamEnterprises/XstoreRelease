/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.AirportPropertyId;
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
/*     */ public class AirportPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1481071520L;
/*  23 */   private static final Logger _logger = Logger.getLogger(AirportPropertyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _airportCode;
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
/*     */   public String getAirportCode() {
/*  48 */     return this._airportCode;
/*     */   }
/*     */   
/*     */   public void setAirportCode(String argAirportCode) {
/*  52 */     if (changed(argAirportCode, this._airportCode, "airportCode")) {
/*  53 */       this._airportCode = (argAirportCode != null && MANAGE_CASE) ? argAirportCode.toUpperCase() : argAirportCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  58 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  62 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/*  63 */       this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/*  68 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/*  72 */     if (changed(argType, this._type, "type")) {
/*  73 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/*  78 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/*  82 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/*  83 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/*  88 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/*  92 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/*  93 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/*  99 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 103 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 104 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 109 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 113 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 114 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 120 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 124 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 125 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 130 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 134 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 135 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 141 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 145 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 146 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     StringBuilder buf = new StringBuilder(512);
/* 154 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 155 */     if (getOrganizationId() != null) {
/* 156 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 158 */     if (getAirportCode() != null) {
/* 159 */       buf.append("airportCode").append("=").append(getAirportCode()).append(" ");
/*     */     }
/* 161 */     if (getPropertyCode() != null) {
/* 162 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 164 */     if (getType() != null) {
/* 165 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 167 */     if (getStringValue() != null) {
/* 168 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 170 */     if (getDateValue() != null) {
/* 171 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 173 */     if (getDecimalValue() != null) {
/* 174 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 176 */     if (getCreateDate() != null) {
/* 177 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 179 */     if (getCreateUserId() != null) {
/* 180 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 182 */     if (getUpdateDate() != null) {
/* 183 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 185 */     if (getUpdateUserId() != null) {
/* 186 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 189 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 193 */     AirportPropertyId id = new AirportPropertyId();
/* 194 */     id.setOrganizationId(getOrganizationId());
/* 195 */     id.setAirportCode(getAirportCode());
/* 196 */     id.setPropertyCode(getPropertyCode());
/* 197 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 201 */     setOrganizationId(((AirportPropertyId)argObjectId).getOrganizationId());
/* 202 */     setAirportCode(((AirportPropertyId)argObjectId).getAirportCode());
/* 203 */     setPropertyCode(((AirportPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 207 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 211 */     StringBuilder buf = new StringBuilder(550);
/* 212 */     buf.append("<").append("dao").append(" name=\"AirportProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 213 */     getFieldsAsXml(buf);
/* 214 */     buf.append("</").append("dao").append(">");
/*     */     
/* 216 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 220 */     Map<String, String> values = super.getValues();
/* 221 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 222 */     if (this._airportCode != null) values.put("AirportCode", DaoUtils.getXmlSafeFieldValue(12, this._airportCode)); 
/* 223 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 224 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 225 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 226 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 227 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 228 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 229 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 230 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 231 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 232 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 237 */     super.setValues(argValues);
/* 238 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 240 */       String fieldName = field.getKey();
/* 241 */       String fieldValue = field.getValue();
/* 242 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 246 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 247 */             setOrganizationId((Long)value);
/* 248 */           } catch (Exception ee) {
/* 249 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AirportCode":
/*     */           try {
/* 255 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 256 */             setAirportCode((String)value);
/* 257 */           } catch (Exception ee) {
/* 258 */             throw new DtxException("An exception occurred while calling setAirportCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 264 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 265 */             setPropertyCode((String)value);
/* 266 */           } catch (Exception ee) {
/* 267 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 273 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 274 */             setType((String)value);
/* 275 */           } catch (Exception ee) {
/* 276 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 282 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 283 */             setStringValue((String)value);
/* 284 */           } catch (Exception ee) {
/* 285 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 291 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 292 */             setDateValue((Date)value);
/* 293 */           } catch (Exception ee) {
/* 294 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 300 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 301 */             setDecimalValue((BigDecimal)value);
/* 302 */           } catch (Exception ee) {
/* 303 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 309 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 310 */             setCreateDate((Date)value);
/* 311 */           } catch (Exception ee) {
/* 312 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 318 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 319 */             setCreateUserId((String)value);
/* 320 */           } catch (Exception ee) {
/* 321 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 327 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 328 */             setUpdateDate((Date)value);
/* 329 */           } catch (Exception ee) {
/* 330 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 336 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 337 */             setUpdateUserId((String)value);
/* 338 */           } catch (Exception ee) {
/* 339 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AirportPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */