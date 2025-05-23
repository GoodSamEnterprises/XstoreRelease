/*     */ package dtv.xst.dao.doc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.doc.DocumentDefinitionPropertiesId;
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
/*     */ public class DocumentDefinitionPropertiesDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1633627967L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DocumentDefinitionPropertiesDAO.class);
/*     */   
/*     */   private String _seriesId;
/*     */   private Long _organizationId;
/*     */   private String _documentType;
/*     */   private Long _sequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private DtvDate _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   
/*     */   public String getSeriesId() {
/*  42 */     return this._seriesId;
/*     */   }
/*     */   
/*     */   public void setSeriesId(String argSeriesId) {
/*  46 */     if (changed(argSeriesId, this._seriesId, "seriesId")) {
/*  47 */       this._seriesId = (argSeriesId != null && MANAGE_CASE) ? argSeriesId.toUpperCase() : argSeriesId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  52 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  56 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  57 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentType() {
/*  62 */     return this._documentType;
/*     */   }
/*     */   
/*     */   public void setDocumentType(String argDocumentType) {
/*  66 */     if (changed(argDocumentType, this._documentType, "documentType")) {
/*  67 */       this._documentType = (argDocumentType != null && MANAGE_CASE) ? argDocumentType.toUpperCase() : argDocumentType;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getSequence() {
/*  72 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Long argSequence) {
/*  76 */     if (changed(argSequence, this._sequence, "sequence")) {
/*  77 */       this._sequence = argSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  82 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  86 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  87 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  93 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  97 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  98 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 103 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 107 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 108 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 114 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 118 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 119 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 124 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 128 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 129 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 134 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 138 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 139 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/* 144 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 148 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/* 149 */       this._propertyCode = argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/* 154 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/* 158 */     if (changed(argType, this._type, "type")) {
/* 159 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/* 164 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 168 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/* 169 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/* 174 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 178 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 179 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 185 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 189 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 190 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 197 */     StringBuilder buf = new StringBuilder(512);
/* 198 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 199 */     if (getSeriesId() != null) {
/* 200 */       buf.append("seriesId").append("=").append(getSeriesId()).append(" ");
/*     */     }
/* 202 */     if (getOrganizationId() != null) {
/* 203 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 205 */     if (getDocumentType() != null) {
/* 206 */       buf.append("documentType").append("=").append(getDocumentType()).append(" ");
/*     */     }
/* 208 */     if (getSequence() != null) {
/* 209 */       buf.append("sequence").append("=").append(getSequence()).append(" ");
/*     */     }
/* 211 */     if (getCreateDate() != null) {
/* 212 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 214 */     if (getCreateUserId() != null) {
/* 215 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 217 */     if (getUpdateDate() != null) {
/* 218 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 220 */     if (getUpdateUserId() != null) {
/* 221 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 223 */     if (getOrgCode() != null) {
/* 224 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 226 */     if (getOrgValue() != null) {
/* 227 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 229 */     if (getPropertyCode() != null) {
/* 230 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 232 */     if (getType() != null) {
/* 233 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 235 */     if (getStringValue() != null) {
/* 236 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 238 */     if (getDateValue() != null) {
/* 239 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 241 */     if (getDecimalValue() != null) {
/* 242 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/*     */     
/* 245 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 249 */     DocumentDefinitionPropertiesId id = new DocumentDefinitionPropertiesId();
/* 250 */     id.setSeriesId(getSeriesId());
/* 251 */     id.setOrganizationId(getOrganizationId());
/* 252 */     id.setDocumentType(getDocumentType());
/* 253 */     id.setSequence(getSequence());
/* 254 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 258 */     setSeriesId(((DocumentDefinitionPropertiesId)argObjectId).getSeriesId());
/* 259 */     setOrganizationId(((DocumentDefinitionPropertiesId)argObjectId).getOrganizationId());
/* 260 */     setDocumentType(((DocumentDefinitionPropertiesId)argObjectId).getDocumentType());
/* 261 */     setSequence(((DocumentDefinitionPropertiesId)argObjectId).getSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 265 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 269 */     StringBuilder buf = new StringBuilder(750);
/* 270 */     buf.append("<").append("dao").append(" name=\"DocumentDefinitionProperties\" cmd=\"" + getObjectStateString() + "\">");
/* 271 */     getFieldsAsXml(buf);
/* 272 */     buf.append("</").append("dao").append(">");
/*     */     
/* 274 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 278 */     Map<String, String> values = super.getValues();
/* 279 */     if (this._seriesId != null) values.put("SeriesId", DaoUtils.getXmlSafeFieldValue(12, this._seriesId)); 
/* 280 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 281 */     if (this._documentType != null) values.put("DocumentType", DaoUtils.getXmlSafeFieldValue(12, this._documentType)); 
/* 282 */     if (this._sequence != null) values.put("Sequence", DaoUtils.getXmlSafeFieldValue(-5, this._sequence)); 
/* 283 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 284 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 285 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 286 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 287 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 288 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 289 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 290 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 291 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 292 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 293 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 294 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 299 */     super.setValues(argValues);
/* 300 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 302 */       String fieldName = field.getKey();
/* 303 */       String fieldValue = field.getValue();
/* 304 */       switch (fieldName) {
/*     */         
/*     */         case "SeriesId":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 309 */             setSeriesId((String)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setSeriesId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 318 */             setOrganizationId((Long)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentType":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 327 */             setDocumentType((String)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setDocumentType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Sequence":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 336 */             setSequence((Long)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 344 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 345 */             setCreateDate((Date)value);
/* 346 */           } catch (Exception ee) {
/* 347 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 354 */             setCreateUserId((String)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 363 */             setUpdateDate((Date)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 372 */             setUpdateUserId((String)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 381 */             setOrgCode((String)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 390 */             setOrgValue((String)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 399 */             setPropertyCode((String)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 408 */             setType((String)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 416 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 417 */             setStringValue((String)value);
/* 418 */           } catch (Exception ee) {
/* 419 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 425 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 426 */             setDateValue((Date)value);
/* 427 */           } catch (Exception ee) {
/* 428 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 434 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 435 */             setDecimalValue((BigDecimal)value);
/* 436 */           } catch (Exception ee) {
/* 437 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentDefinitionPropertiesDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */