/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemRestrictionCalendarId;
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
/*     */ public class ItemRestrictionCalendarDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1566239497L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemRestrictionCalendarDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _restrictionCategory;
/*     */   private String _restrictionCode;
/*     */   private String _dayCode;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _startTime;
/*     */   private String _saleLineItemTypeCode;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _expirationDate;
/*     */   private DtvDate _endTime;
/*  40 */   private Boolean _exemption = Boolean.FALSE;
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
/*     */   public String getOrgCode() {
/* 115 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 119 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 120 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 125 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 129 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 130 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 135 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 139 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 140 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 146 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 150 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 151 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 156 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 160 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 161 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 167 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 171 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 172 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getExpirationDate() {
/* 177 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 181 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 182 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndTime() {
/* 188 */     return (Date)this._endTime;
/*     */   }
/*     */   
/*     */   public void setEndTime(Date argEndTime) {
/* 192 */     if (changed(argEndTime, this._endTime, "endTime")) {
/* 193 */       this._endTime = (argEndTime == null || argEndTime instanceof DtvDate) ? (DtvDate)argEndTime : new DtvDate(argEndTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getExemption() {
/* 199 */     return this._exemption;
/*     */   }
/*     */   
/*     */   public void setExemption(Boolean argExemption) {
/* 203 */     if (changed(argExemption, this._exemption, "exemption")) {
/* 204 */       this._exemption = argExemption;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 211 */     StringBuilder buf = new StringBuilder(512);
/* 212 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 213 */     if (getOrganizationId() != null) {
/* 214 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 216 */     if (getRestrictionCategory() != null) {
/* 217 */       buf.append("restrictionCategory").append("=").append(getRestrictionCategory()).append(" ");
/*     */     }
/* 219 */     if (getRestrictionCode() != null) {
/* 220 */       buf.append("restrictionCode").append("=").append(getRestrictionCode()).append(" ");
/*     */     }
/* 222 */     if (getDayCode() != null) {
/* 223 */       buf.append("dayCode").append("=").append(getDayCode()).append(" ");
/*     */     }
/* 225 */     if (getEffectiveDate() != null) {
/* 226 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 228 */     if (getStartTime() != null) {
/* 229 */       buf.append("startTime").append("=").append(getStartTime()).append(" ");
/*     */     }
/* 231 */     if (getSaleLineItemTypeCode() != null) {
/* 232 */       buf.append("saleLineItemTypeCode").append("=").append(getSaleLineItemTypeCode()).append(" ");
/*     */     }
/* 234 */     if (getOrgCode() != null) {
/* 235 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 237 */     if (getOrgValue() != null) {
/* 238 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 240 */     if (getCreateDate() != null) {
/* 241 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 243 */     if (getCreateUserId() != null) {
/* 244 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 246 */     if (getUpdateDate() != null) {
/* 247 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 249 */     if (getUpdateUserId() != null) {
/* 250 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 252 */     if (getExpirationDate() != null) {
/* 253 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 255 */     if (getEndTime() != null) {
/* 256 */       buf.append("endTime").append("=").append(getEndTime()).append(" ");
/*     */     }
/* 258 */     if (getExemption() != null && getExemption().booleanValue()) {
/* 259 */       buf.append("exemption").append("=").append(getExemption()).append(" ");
/*     */     }
/*     */     
/* 262 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 266 */     ItemRestrictionCalendarId id = new ItemRestrictionCalendarId();
/* 267 */     id.setOrganizationId(getOrganizationId());
/* 268 */     id.setRestrictionCategory(getRestrictionCategory());
/* 269 */     id.setRestrictionCode(getRestrictionCode());
/* 270 */     id.setDayCode(getDayCode());
/* 271 */     id.setEffectiveDate(getEffectiveDate());
/* 272 */     id.setStartTime(getStartTime());
/* 273 */     id.setSaleLineItemTypeCode(getSaleLineItemTypeCode());
/* 274 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 278 */     setOrganizationId(((ItemRestrictionCalendarId)argObjectId).getOrganizationId());
/* 279 */     setRestrictionCategory(((ItemRestrictionCalendarId)argObjectId).getRestrictionCategory());
/* 280 */     setRestrictionCode(((ItemRestrictionCalendarId)argObjectId).getRestrictionCode());
/* 281 */     setDayCode(((ItemRestrictionCalendarId)argObjectId).getDayCode());
/* 282 */     setEffectiveDate(((ItemRestrictionCalendarId)argObjectId).getEffectiveDate());
/* 283 */     setStartTime(((ItemRestrictionCalendarId)argObjectId).getStartTime());
/* 284 */     setSaleLineItemTypeCode(((ItemRestrictionCalendarId)argObjectId).getSaleLineItemTypeCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 288 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 292 */     StringBuilder buf = new StringBuilder(800);
/* 293 */     buf.append("<").append("dao").append(" name=\"ItemRestrictionCalendar\" cmd=\"" + getObjectStateString() + "\">");
/* 294 */     getFieldsAsXml(buf);
/* 295 */     buf.append("</").append("dao").append(">");
/*     */     
/* 297 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 301 */     Map<String, String> values = super.getValues();
/* 302 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 303 */     if (this._restrictionCategory != null) values.put("RestrictionCategory", DaoUtils.getXmlSafeFieldValue(12, this._restrictionCategory)); 
/* 304 */     if (this._restrictionCode != null) values.put("RestrictionCode", DaoUtils.getXmlSafeFieldValue(12, this._restrictionCode)); 
/* 305 */     if (this._dayCode != null) values.put("DayCode", DaoUtils.getXmlSafeFieldValue(12, this._dayCode)); 
/* 306 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 307 */     if (this._startTime != null) values.put("StartTime", DaoUtils.getXmlSafeFieldValue(91, this._startTime)); 
/* 308 */     if (this._saleLineItemTypeCode != null) values.put("SaleLineItemTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._saleLineItemTypeCode)); 
/* 309 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 310 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 311 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 312 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 313 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 314 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 315 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 316 */     if (this._endTime != null) values.put("EndTime", DaoUtils.getXmlSafeFieldValue(91, this._endTime)); 
/* 317 */     if (this._exemption != null) values.put("Exemption", DaoUtils.getXmlSafeFieldValue(-7, this._exemption)); 
/* 318 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 323 */     super.setValues(argValues);
/* 324 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 326 */       String fieldName = field.getKey();
/* 327 */       String fieldValue = field.getValue();
/* 328 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 333 */             setOrganizationId((Long)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RestrictionCategory":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 342 */             setRestrictionCategory((String)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setRestrictionCategory() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RestrictionCode":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 351 */             setRestrictionCode((String)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setRestrictionCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DayCode":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 360 */             setDayCode((String)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setDayCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 368 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 369 */             setEffectiveDate((Date)value);
/* 370 */           } catch (Exception ee) {
/* 371 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StartTime":
/*     */           try {
/* 377 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 378 */             setStartTime((Date)value);
/* 379 */           } catch (Exception ee) {
/* 380 */             throw new DtxException("An exception occurred while calling setStartTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SaleLineItemTypeCode":
/*     */           try {
/* 386 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 387 */             setSaleLineItemTypeCode((String)value);
/* 388 */           } catch (Exception ee) {
/* 389 */             throw new DtxException("An exception occurred while calling setSaleLineItemTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 395 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 396 */             setOrgCode((String)value);
/* 397 */           } catch (Exception ee) {
/* 398 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 404 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 405 */             setOrgValue((String)value);
/* 406 */           } catch (Exception ee) {
/* 407 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 413 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 414 */             setCreateDate((Date)value);
/* 415 */           } catch (Exception ee) {
/* 416 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 422 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 423 */             setCreateUserId((String)value);
/* 424 */           } catch (Exception ee) {
/* 425 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 431 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 432 */             setUpdateDate((Date)value);
/* 433 */           } catch (Exception ee) {
/* 434 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 440 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 441 */             setUpdateUserId((String)value);
/* 442 */           } catch (Exception ee) {
/* 443 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 449 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 450 */             setExpirationDate((Date)value);
/* 451 */           } catch (Exception ee) {
/* 452 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndTime":
/*     */           try {
/* 458 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 459 */             setEndTime((Date)value);
/* 460 */           } catch (Exception ee) {
/* 461 */             throw new DtxException("An exception occurred while calling setEndTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Exemption":
/*     */           try {
/* 467 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 468 */             setExemption((Boolean)value);
/* 469 */           } catch (Exception ee) {
/* 470 */             throw new DtxException("An exception occurred while calling setExemption() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictionCalendarDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */