/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemRestrictionCalendarPropertyId;
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
/*     */ public class ItemRestrictionCalendarPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1560309740L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemRestrictionCalendarPropertyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _restrictionCategory;
/*     */   private String _restrictionCode;
/*     */   private String _dayCode;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _startTime;
/*     */   private String _saleLineItemTypeCode;
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
/*  43 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  47 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  48 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRestrictionCategory() {
/*  53 */     return this._restrictionCategory;
/*     */   }
/*     */   
/*     */   public void setRestrictionCategory(String argRestrictionCategory) {
/*  57 */     if (changed(argRestrictionCategory, this._restrictionCategory, "restrictionCategory")) {
/*  58 */       this._restrictionCategory = (argRestrictionCategory != null && MANAGE_CASE) ? argRestrictionCategory.toUpperCase() : argRestrictionCategory;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRestrictionCode() {
/*  63 */     return this._restrictionCode;
/*     */   }
/*     */   
/*     */   public void setRestrictionCode(String argRestrictionCode) {
/*  67 */     if (changed(argRestrictionCode, this._restrictionCode, "restrictionCode")) {
/*  68 */       this._restrictionCode = (argRestrictionCode != null && MANAGE_CASE) ? argRestrictionCode.toUpperCase() : argRestrictionCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDayCode() {
/*  73 */     return this._dayCode;
/*     */   }
/*     */   
/*     */   public void setDayCode(String argDayCode) {
/*  77 */     if (changed(argDayCode, this._dayCode, "dayCode")) {
/*  78 */       this._dayCode = (argDayCode != null && MANAGE_CASE) ? argDayCode.toUpperCase() : argDayCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  83 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  87 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/*  88 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getStartTime() {
/*  94 */     return (Date)this._startTime;
/*     */   }
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/*  98 */     if (changed(argStartTime, this._startTime, "startTime")) {
/*  99 */       this._startTime = (argStartTime == null || argStartTime instanceof DtvDate) ? (DtvDate)argStartTime : new DtvDate(argStartTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSaleLineItemTypeCode() {
/* 105 */     return this._saleLineItemTypeCode;
/*     */   }
/*     */   
/*     */   public void setSaleLineItemTypeCode(String argSaleLineItemTypeCode) {
/* 109 */     if (changed(argSaleLineItemTypeCode, this._saleLineItemTypeCode, "saleLineItemTypeCode")) {
/* 110 */       this._saleLineItemTypeCode = (argSaleLineItemTypeCode != null && MANAGE_CASE) ? argSaleLineItemTypeCode.toUpperCase() : argSaleLineItemTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/* 115 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 119 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/* 120 */       this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/* 125 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/* 129 */     if (changed(argType, this._type, "type")) {
/* 130 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/* 135 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 139 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/* 140 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/* 145 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 149 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 150 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 156 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 160 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 161 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 166 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 170 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 171 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 177 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 181 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 182 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 187 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 191 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 192 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 198 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 202 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 203 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 210 */     StringBuilder buf = new StringBuilder(512);
/* 211 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 212 */     if (getOrganizationId() != null) {
/* 213 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 215 */     if (getRestrictionCategory() != null) {
/* 216 */       buf.append("restrictionCategory").append("=").append(getRestrictionCategory()).append(" ");
/*     */     }
/* 218 */     if (getRestrictionCode() != null) {
/* 219 */       buf.append("restrictionCode").append("=").append(getRestrictionCode()).append(" ");
/*     */     }
/* 221 */     if (getDayCode() != null) {
/* 222 */       buf.append("dayCode").append("=").append(getDayCode()).append(" ");
/*     */     }
/* 224 */     if (getEffectiveDate() != null) {
/* 225 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 227 */     if (getStartTime() != null) {
/* 228 */       buf.append("startTime").append("=").append(getStartTime()).append(" ");
/*     */     }
/* 230 */     if (getSaleLineItemTypeCode() != null) {
/* 231 */       buf.append("saleLineItemTypeCode").append("=").append(getSaleLineItemTypeCode()).append(" ");
/*     */     }
/* 233 */     if (getPropertyCode() != null) {
/* 234 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 236 */     if (getType() != null) {
/* 237 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 239 */     if (getStringValue() != null) {
/* 240 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 242 */     if (getDateValue() != null) {
/* 243 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 245 */     if (getDecimalValue() != null) {
/* 246 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 248 */     if (getCreateDate() != null) {
/* 249 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 251 */     if (getCreateUserId() != null) {
/* 252 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 254 */     if (getUpdateDate() != null) {
/* 255 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 257 */     if (getUpdateUserId() != null) {
/* 258 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 261 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 265 */     ItemRestrictionCalendarPropertyId id = new ItemRestrictionCalendarPropertyId();
/* 266 */     id.setOrganizationId(getOrganizationId());
/* 267 */     id.setRestrictionCategory(getRestrictionCategory());
/* 268 */     id.setRestrictionCode(getRestrictionCode());
/* 269 */     id.setDayCode(getDayCode());
/* 270 */     id.setEffectiveDate(getEffectiveDate());
/* 271 */     id.setStartTime(getStartTime());
/* 272 */     id.setSaleLineItemTypeCode(getSaleLineItemTypeCode());
/* 273 */     id.setPropertyCode(getPropertyCode());
/* 274 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 278 */     setOrganizationId(((ItemRestrictionCalendarPropertyId)argObjectId).getOrganizationId());
/* 279 */     setRestrictionCategory(((ItemRestrictionCalendarPropertyId)argObjectId).getRestrictionCategory());
/* 280 */     setRestrictionCode(((ItemRestrictionCalendarPropertyId)argObjectId).getRestrictionCode());
/* 281 */     setDayCode(((ItemRestrictionCalendarPropertyId)argObjectId).getDayCode());
/* 282 */     setEffectiveDate(((ItemRestrictionCalendarPropertyId)argObjectId).getEffectiveDate());
/* 283 */     setStartTime(((ItemRestrictionCalendarPropertyId)argObjectId).getStartTime());
/* 284 */     setSaleLineItemTypeCode(((ItemRestrictionCalendarPropertyId)argObjectId).getSaleLineItemTypeCode());
/* 285 */     setPropertyCode(((ItemRestrictionCalendarPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 289 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 293 */     StringBuilder buf = new StringBuilder(800);
/* 294 */     buf.append("<").append("dao").append(" name=\"ItemRestrictionCalendarProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 295 */     getFieldsAsXml(buf);
/* 296 */     buf.append("</").append("dao").append(">");
/*     */     
/* 298 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 302 */     Map<String, String> values = super.getValues();
/* 303 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 304 */     if (this._restrictionCategory != null) values.put("RestrictionCategory", DaoUtils.getXmlSafeFieldValue(12, this._restrictionCategory)); 
/* 305 */     if (this._restrictionCode != null) values.put("RestrictionCode", DaoUtils.getXmlSafeFieldValue(12, this._restrictionCode)); 
/* 306 */     if (this._dayCode != null) values.put("DayCode", DaoUtils.getXmlSafeFieldValue(12, this._dayCode)); 
/* 307 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 308 */     if (this._startTime != null) values.put("StartTime", DaoUtils.getXmlSafeFieldValue(91, this._startTime)); 
/* 309 */     if (this._saleLineItemTypeCode != null) values.put("SaleLineItemTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._saleLineItemTypeCode)); 
/* 310 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 311 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 312 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 313 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 314 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 315 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 316 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 317 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 318 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 319 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 324 */     super.setValues(argValues);
/* 325 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 327 */       String fieldName = field.getKey();
/* 328 */       String fieldValue = field.getValue();
/* 329 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 334 */             setOrganizationId((Long)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RestrictionCategory":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 343 */             setRestrictionCategory((String)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setRestrictionCategory() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RestrictionCode":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 352 */             setRestrictionCode((String)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setRestrictionCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DayCode":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 361 */             setDayCode((String)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setDayCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 370 */             setEffectiveDate((Date)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StartTime":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 379 */             setStartTime((Date)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setStartTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SaleLineItemTypeCode":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 388 */             setSaleLineItemTypeCode((String)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setSaleLineItemTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 397 */             setPropertyCode((String)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 406 */             setType((String)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 414 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 415 */             setStringValue((String)value);
/* 416 */           } catch (Exception ee) {
/* 417 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 423 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 424 */             setDateValue((Date)value);
/* 425 */           } catch (Exception ee) {
/* 426 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 432 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 433 */             setDecimalValue((BigDecimal)value);
/* 434 */           } catch (Exception ee) {
/* 435 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 441 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 442 */             setCreateDate((Date)value);
/* 443 */           } catch (Exception ee) {
/* 444 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 450 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 451 */             setCreateUserId((String)value);
/* 452 */           } catch (Exception ee) {
/* 453 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 459 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 460 */             setUpdateDate((Date)value);
/* 461 */           } catch (Exception ee) {
/* 462 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 468 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 469 */             setUpdateUserId((String)value);
/* 470 */           } catch (Exception ee) {
/* 471 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictionCalendarPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */