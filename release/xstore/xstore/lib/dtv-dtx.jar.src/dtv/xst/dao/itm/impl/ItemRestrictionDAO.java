/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemRestrictionId;
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
/*     */ public class ItemRestrictionDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1589862041L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemRestrictionDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _restrictionCategory;
/*     */   private String _restrictionCode;
/*     */   private DtvDate _effectiveDate;
/*     */   private String _saleLineItemTypeCode;
/*     */   private String _propertyName;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _expirationDate;
/*  38 */   private Boolean _booleanValue = Boolean.FALSE;
/*     */   private String _stringValue;
/*     */   private DtvDate _dateValue;
/*     */   private BigDecimal _decimalValue;
/*  42 */   private Boolean _onCalendar = Boolean.FALSE;
/*     */   
/*     */   public Long getOrganizationId() {
/*  45 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  49 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  50 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRestrictionCategory() {
/*  55 */     return this._restrictionCategory;
/*     */   }
/*     */   
/*     */   public void setRestrictionCategory(String argRestrictionCategory) {
/*  59 */     if (changed(argRestrictionCategory, this._restrictionCategory, "restrictionCategory")) {
/*  60 */       this._restrictionCategory = (argRestrictionCategory != null && MANAGE_CASE) ? argRestrictionCategory.toUpperCase() : argRestrictionCategory;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRestrictionCode() {
/*  65 */     return this._restrictionCode;
/*     */   }
/*     */   
/*     */   public void setRestrictionCode(String argRestrictionCode) {
/*  69 */     if (changed(argRestrictionCode, this._restrictionCode, "restrictionCode")) {
/*  70 */       this._restrictionCode = (argRestrictionCode != null && MANAGE_CASE) ? argRestrictionCode.toUpperCase() : argRestrictionCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  75 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  79 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/*  80 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSaleLineItemTypeCode() {
/*  86 */     return this._saleLineItemTypeCode;
/*     */   }
/*     */   
/*     */   public void setSaleLineItemTypeCode(String argSaleLineItemTypeCode) {
/*  90 */     if (changed(argSaleLineItemTypeCode, this._saleLineItemTypeCode, "saleLineItemTypeCode")) {
/*  91 */       this._saleLineItemTypeCode = (argSaleLineItemTypeCode != null && MANAGE_CASE) ? argSaleLineItemTypeCode.toUpperCase() : argSaleLineItemTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPropertyName() {
/*  96 */     return this._propertyName;
/*     */   }
/*     */   
/*     */   public void setPropertyName(String argPropertyName) {
/* 100 */     if (changed(argPropertyName, this._propertyName, "propertyName")) {
/* 101 */       this._propertyName = (argPropertyName != null && MANAGE_CASE) ? argPropertyName.toUpperCase() : argPropertyName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 106 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 110 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 111 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 116 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 120 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 121 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 126 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 130 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 131 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 137 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 141 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 142 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 147 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 151 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 152 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 158 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 162 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 163 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getExpirationDate() {
/* 168 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 172 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 173 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getBooleanValue() {
/* 179 */     return this._booleanValue;
/*     */   }
/*     */   
/*     */   public void setBooleanValue(Boolean argBooleanValue) {
/* 183 */     if (changed(argBooleanValue, this._booleanValue, "booleanValue")) {
/* 184 */       this._booleanValue = argBooleanValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/* 189 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 193 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/* 194 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/* 199 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 203 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 204 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 210 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 214 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 215 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getOnCalendar() {
/* 220 */     return this._onCalendar;
/*     */   }
/*     */   
/*     */   public void setOnCalendar(Boolean argOnCalendar) {
/* 224 */     if (changed(argOnCalendar, this._onCalendar, "onCalendar")) {
/* 225 */       this._onCalendar = argOnCalendar;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 232 */     StringBuilder buf = new StringBuilder(512);
/* 233 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 234 */     if (getOrganizationId() != null) {
/* 235 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 237 */     if (getRestrictionCategory() != null) {
/* 238 */       buf.append("restrictionCategory").append("=").append(getRestrictionCategory()).append(" ");
/*     */     }
/* 240 */     if (getRestrictionCode() != null) {
/* 241 */       buf.append("restrictionCode").append("=").append(getRestrictionCode()).append(" ");
/*     */     }
/* 243 */     if (getEffectiveDate() != null) {
/* 244 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 246 */     if (getSaleLineItemTypeCode() != null) {
/* 247 */       buf.append("saleLineItemTypeCode").append("=").append(getSaleLineItemTypeCode()).append(" ");
/*     */     }
/* 249 */     if (getPropertyName() != null) {
/* 250 */       buf.append("propertyName").append("=").append(getPropertyName()).append(" ");
/*     */     }
/* 252 */     if (getOrgCode() != null) {
/* 253 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 255 */     if (getOrgValue() != null) {
/* 256 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 258 */     if (getCreateDate() != null) {
/* 259 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 261 */     if (getCreateUserId() != null) {
/* 262 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 264 */     if (getUpdateDate() != null) {
/* 265 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 267 */     if (getUpdateUserId() != null) {
/* 268 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 270 */     if (getExpirationDate() != null) {
/* 271 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 273 */     if (getBooleanValue() != null && getBooleanValue().booleanValue()) {
/* 274 */       buf.append("booleanValue").append("=").append(getBooleanValue()).append(" ");
/*     */     }
/* 276 */     if (getStringValue() != null) {
/* 277 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 279 */     if (getDateValue() != null) {
/* 280 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 282 */     if (getDecimalValue() != null) {
/* 283 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 285 */     if (getOnCalendar() != null && getOnCalendar().booleanValue()) {
/* 286 */       buf.append("onCalendar").append("=").append(getOnCalendar()).append(" ");
/*     */     }
/*     */     
/* 289 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 293 */     ItemRestrictionId id = new ItemRestrictionId();
/* 294 */     id.setOrganizationId(getOrganizationId());
/* 295 */     id.setRestrictionCategory(getRestrictionCategory());
/* 296 */     id.setRestrictionCode(getRestrictionCode());
/* 297 */     id.setEffectiveDate(getEffectiveDate());
/* 298 */     id.setSaleLineItemTypeCode(getSaleLineItemTypeCode());
/* 299 */     id.setPropertyName(getPropertyName());
/* 300 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 304 */     setOrganizationId(((ItemRestrictionId)argObjectId).getOrganizationId());
/* 305 */     setRestrictionCategory(((ItemRestrictionId)argObjectId).getRestrictionCategory());
/* 306 */     setRestrictionCode(((ItemRestrictionId)argObjectId).getRestrictionCode());
/* 307 */     setEffectiveDate(((ItemRestrictionId)argObjectId).getEffectiveDate());
/* 308 */     setSaleLineItemTypeCode(((ItemRestrictionId)argObjectId).getSaleLineItemTypeCode());
/* 309 */     setPropertyName(((ItemRestrictionId)argObjectId).getPropertyName());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 313 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 317 */     StringBuilder buf = new StringBuilder(900);
/* 318 */     buf.append("<").append("dao").append(" name=\"ItemRestriction\" cmd=\"" + getObjectStateString() + "\">");
/* 319 */     getFieldsAsXml(buf);
/* 320 */     buf.append("</").append("dao").append(">");
/*     */     
/* 322 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 326 */     Map<String, String> values = super.getValues();
/* 327 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 328 */     if (this._restrictionCategory != null) values.put("RestrictionCategory", DaoUtils.getXmlSafeFieldValue(12, this._restrictionCategory)); 
/* 329 */     if (this._restrictionCode != null) values.put("RestrictionCode", DaoUtils.getXmlSafeFieldValue(12, this._restrictionCode)); 
/* 330 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 331 */     if (this._saleLineItemTypeCode != null) values.put("SaleLineItemTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._saleLineItemTypeCode)); 
/* 332 */     if (this._propertyName != null) values.put("PropertyName", DaoUtils.getXmlSafeFieldValue(12, this._propertyName)); 
/* 333 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 334 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 335 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 336 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 337 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 338 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 339 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 340 */     if (this._booleanValue != null) values.put("BooleanValue", DaoUtils.getXmlSafeFieldValue(-7, this._booleanValue)); 
/* 341 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 342 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 343 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 344 */     if (this._onCalendar != null) values.put("OnCalendar", DaoUtils.getXmlSafeFieldValue(-7, this._onCalendar)); 
/* 345 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 350 */     super.setValues(argValues);
/* 351 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 353 */       String fieldName = field.getKey();
/* 354 */       String fieldValue = field.getValue();
/* 355 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 360 */             setOrganizationId((Long)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RestrictionCategory":
/*     */           try {
/* 368 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 369 */             setRestrictionCategory((String)value);
/* 370 */           } catch (Exception ee) {
/* 371 */             throw new DtxException("An exception occurred while calling setRestrictionCategory() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RestrictionCode":
/*     */           try {
/* 377 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 378 */             setRestrictionCode((String)value);
/* 379 */           } catch (Exception ee) {
/* 380 */             throw new DtxException("An exception occurred while calling setRestrictionCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 386 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 387 */             setEffectiveDate((Date)value);
/* 388 */           } catch (Exception ee) {
/* 389 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SaleLineItemTypeCode":
/*     */           try {
/* 395 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 396 */             setSaleLineItemTypeCode((String)value);
/* 397 */           } catch (Exception ee) {
/* 398 */             throw new DtxException("An exception occurred while calling setSaleLineItemTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyName":
/*     */           try {
/* 404 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 405 */             setPropertyName((String)value);
/* 406 */           } catch (Exception ee) {
/* 407 */             throw new DtxException("An exception occurred while calling setPropertyName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 413 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 414 */             setOrgCode((String)value);
/* 415 */           } catch (Exception ee) {
/* 416 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 422 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 423 */             setOrgValue((String)value);
/* 424 */           } catch (Exception ee) {
/* 425 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 431 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 432 */             setCreateDate((Date)value);
/* 433 */           } catch (Exception ee) {
/* 434 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 440 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 441 */             setCreateUserId((String)value);
/* 442 */           } catch (Exception ee) {
/* 443 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 449 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 450 */             setUpdateDate((Date)value);
/* 451 */           } catch (Exception ee) {
/* 452 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 458 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 459 */             setUpdateUserId((String)value);
/* 460 */           } catch (Exception ee) {
/* 461 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 467 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 468 */             setExpirationDate((Date)value);
/* 469 */           } catch (Exception ee) {
/* 470 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BooleanValue":
/*     */           try {
/* 476 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 477 */             setBooleanValue((Boolean)value);
/* 478 */           } catch (Exception ee) {
/* 479 */             throw new DtxException("An exception occurred while calling setBooleanValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 485 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 486 */             setStringValue((String)value);
/* 487 */           } catch (Exception ee) {
/* 488 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 494 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 495 */             setDateValue((Date)value);
/* 496 */           } catch (Exception ee) {
/* 497 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 503 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 504 */             setDecimalValue((BigDecimal)value);
/* 505 */           } catch (Exception ee) {
/* 506 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OnCalendar":
/*     */           try {
/* 512 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 513 */             setOnCalendar((Boolean)value);
/* 514 */           } catch (Exception ee) {
/* 515 */             throw new DtxException("An exception occurred while calling setOnCalendar() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */