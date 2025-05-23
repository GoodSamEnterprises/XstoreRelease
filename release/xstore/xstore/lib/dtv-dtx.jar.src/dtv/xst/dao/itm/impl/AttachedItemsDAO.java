/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.AttachedItemsId;
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
/*     */ public class AttachedItemsDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 719229020L;
/*  23 */   private static final Logger _logger = Logger.getLogger(AttachedItemsDAO.class);
/*     */   
/*     */   private String _attachedItemId;
/*     */   private Long _organizationId;
/*     */   private String _soldItemId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _beginDatetime;
/*     */   private DtvDate _endDatetime;
/*  36 */   private Boolean _promptToAdd = Boolean.FALSE;
/*     */   private String _promptToAddMsgKey;
/*     */   private BigDecimal _quantityToAdd;
/*     */   private String _lineItemAssociationTypeCode;
/*  40 */   private Boolean _promptForReturn = Boolean.FALSE;
/*     */   private String _promptForReturnMsgKey;
/*     */   private String _externalId;
/*     */   private String _externalSystem;
/*     */   
/*     */   public String getAttachedItemId() {
/*  46 */     return this._attachedItemId;
/*     */   }
/*     */   
/*     */   public void setAttachedItemId(String argAttachedItemId) {
/*  50 */     if (changed(argAttachedItemId, this._attachedItemId, "attachedItemId")) {
/*  51 */       this._attachedItemId = (argAttachedItemId != null && MANAGE_CASE) ? argAttachedItemId.toUpperCase() : argAttachedItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  56 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  60 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  61 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSoldItemId() {
/*  66 */     return this._soldItemId;
/*     */   }
/*     */   
/*     */   public void setSoldItemId(String argSoldItemId) {
/*  70 */     if (changed(argSoldItemId, this._soldItemId, "soldItemId")) {
/*  71 */       this._soldItemId = (argSoldItemId != null && MANAGE_CASE) ? argSoldItemId.toUpperCase() : argSoldItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelCode() {
/*  76 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/*  80 */     if (changed(argLevelCode, this._levelCode, "levelCode")) {
/*  81 */       this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelValue() {
/*  86 */     return this._levelValue;
/*     */   }
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/*  90 */     if (changed(argLevelValue, this._levelValue, "levelValue")) {
/*  91 */       this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  96 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 100 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 101 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 107 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 111 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 112 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 117 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 121 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 122 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 128 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 132 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 133 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBeginDatetime() {
/* 138 */     return (Date)this._beginDatetime;
/*     */   }
/*     */   
/*     */   public void setBeginDatetime(Date argBeginDatetime) {
/* 142 */     if (changed(argBeginDatetime, this._beginDatetime, "beginDatetime")) {
/* 143 */       this._beginDatetime = (argBeginDatetime == null || argBeginDatetime instanceof DtvDate) ? (DtvDate)argBeginDatetime : new DtvDate(argBeginDatetime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndDatetime() {
/* 149 */     return (Date)this._endDatetime;
/*     */   }
/*     */   
/*     */   public void setEndDatetime(Date argEndDatetime) {
/* 153 */     if (changed(argEndDatetime, this._endDatetime, "endDatetime")) {
/* 154 */       this._endDatetime = (argEndDatetime == null || argEndDatetime instanceof DtvDate) ? (DtvDate)argEndDatetime : new DtvDate(argEndDatetime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getPromptToAdd() {
/* 160 */     return this._promptToAdd;
/*     */   }
/*     */   
/*     */   public void setPromptToAdd(Boolean argPromptToAdd) {
/* 164 */     if (changed(argPromptToAdd, this._promptToAdd, "promptToAdd")) {
/* 165 */       this._promptToAdd = argPromptToAdd;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPromptToAddMsgKey() {
/* 170 */     return this._promptToAddMsgKey;
/*     */   }
/*     */   
/*     */   public void setPromptToAddMsgKey(String argPromptToAddMsgKey) {
/* 174 */     if (changed(argPromptToAddMsgKey, this._promptToAddMsgKey, "promptToAddMsgKey")) {
/* 175 */       this._promptToAddMsgKey = argPromptToAddMsgKey;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getQuantityToAdd() {
/* 180 */     return this._quantityToAdd;
/*     */   }
/*     */   
/*     */   public void setQuantityToAdd(BigDecimal argQuantityToAdd) {
/* 184 */     if (changed(argQuantityToAdd, this._quantityToAdd, "quantityToAdd")) {
/* 185 */       this._quantityToAdd = argQuantityToAdd;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLineItemAssociationTypeCode() {
/* 190 */     return this._lineItemAssociationTypeCode;
/*     */   }
/*     */   
/*     */   public void setLineItemAssociationTypeCode(String argLineItemAssociationTypeCode) {
/* 194 */     if (changed(argLineItemAssociationTypeCode, this._lineItemAssociationTypeCode, "lineItemAssociationTypeCode")) {
/* 195 */       this._lineItemAssociationTypeCode = argLineItemAssociationTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getPromptForReturn() {
/* 200 */     return this._promptForReturn;
/*     */   }
/*     */   
/*     */   public void setPromptForReturn(Boolean argPromptForReturn) {
/* 204 */     if (changed(argPromptForReturn, this._promptForReturn, "promptForReturn")) {
/* 205 */       this._promptForReturn = argPromptForReturn;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPromptForReturnMsgKey() {
/* 210 */     return this._promptForReturnMsgKey;
/*     */   }
/*     */   
/*     */   public void setPromptForReturnMsgKey(String argPromptForReturnMsgKey) {
/* 214 */     if (changed(argPromptForReturnMsgKey, this._promptForReturnMsgKey, "promptForReturnMsgKey")) {
/* 215 */       this._promptForReturnMsgKey = argPromptForReturnMsgKey;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getExternalId() {
/* 220 */     return this._externalId;
/*     */   }
/*     */   
/*     */   public void setExternalId(String argExternalId) {
/* 224 */     if (changed(argExternalId, this._externalId, "externalId")) {
/* 225 */       this._externalId = argExternalId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getExternalSystem() {
/* 230 */     return this._externalSystem;
/*     */   }
/*     */   
/*     */   public void setExternalSystem(String argExternalSystem) {
/* 234 */     if (changed(argExternalSystem, this._externalSystem, "externalSystem")) {
/* 235 */       this._externalSystem = argExternalSystem;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 242 */     StringBuilder buf = new StringBuilder(512);
/* 243 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 244 */     if (getAttachedItemId() != null) {
/* 245 */       buf.append("attachedItemId").append("=").append(getAttachedItemId()).append(" ");
/*     */     }
/* 247 */     if (getOrganizationId() != null) {
/* 248 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 250 */     if (getSoldItemId() != null) {
/* 251 */       buf.append("soldItemId").append("=").append(getSoldItemId()).append(" ");
/*     */     }
/* 253 */     if (getLevelCode() != null) {
/* 254 */       buf.append("levelCode").append("=").append(getLevelCode()).append(" ");
/*     */     }
/* 256 */     if (getLevelValue() != null) {
/* 257 */       buf.append("levelValue").append("=").append(getLevelValue()).append(" ");
/*     */     }
/* 259 */     if (getCreateDate() != null) {
/* 260 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 262 */     if (getCreateUserId() != null) {
/* 263 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 265 */     if (getUpdateDate() != null) {
/* 266 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 268 */     if (getUpdateUserId() != null) {
/* 269 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 271 */     if (getBeginDatetime() != null) {
/* 272 */       buf.append("beginDatetime").append("=").append(getBeginDatetime()).append(" ");
/*     */     }
/* 274 */     if (getEndDatetime() != null) {
/* 275 */       buf.append("endDatetime").append("=").append(getEndDatetime()).append(" ");
/*     */     }
/* 277 */     if (getPromptToAdd() != null && getPromptToAdd().booleanValue()) {
/* 278 */       buf.append("promptToAdd").append("=").append(getPromptToAdd()).append(" ");
/*     */     }
/* 280 */     if (getPromptToAddMsgKey() != null) {
/* 281 */       buf.append("promptToAddMsgKey").append("=").append(getPromptToAddMsgKey()).append(" ");
/*     */     }
/* 283 */     if (getQuantityToAdd() != null) {
/* 284 */       buf.append("quantityToAdd").append("=").append(getQuantityToAdd()).append(" ");
/*     */     }
/* 286 */     if (getLineItemAssociationTypeCode() != null) {
/* 287 */       buf.append("lineItemAssociationTypeCode").append("=").append(getLineItemAssociationTypeCode()).append(" ");
/*     */     }
/* 289 */     if (getPromptForReturn() != null && getPromptForReturn().booleanValue()) {
/* 290 */       buf.append("promptForReturn").append("=").append(getPromptForReturn()).append(" ");
/*     */     }
/* 292 */     if (getPromptForReturnMsgKey() != null) {
/* 293 */       buf.append("promptForReturnMsgKey").append("=").append(getPromptForReturnMsgKey()).append(" ");
/*     */     }
/* 295 */     if (getExternalId() != null) {
/* 296 */       buf.append("externalId").append("=").append(getExternalId()).append(" ");
/*     */     }
/* 298 */     if (getExternalSystem() != null) {
/* 299 */       buf.append("externalSystem").append("=").append(getExternalSystem()).append(" ");
/*     */     }
/*     */     
/* 302 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 306 */     AttachedItemsId id = new AttachedItemsId();
/* 307 */     id.setAttachedItemId(getAttachedItemId());
/* 308 */     id.setOrganizationId(getOrganizationId());
/* 309 */     id.setSoldItemId(getSoldItemId());
/* 310 */     id.setLevelCode(getLevelCode());
/* 311 */     id.setLevelValue(getLevelValue());
/* 312 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 316 */     setAttachedItemId(((AttachedItemsId)argObjectId).getAttachedItemId());
/* 317 */     setOrganizationId(((AttachedItemsId)argObjectId).getOrganizationId());
/* 318 */     setSoldItemId(((AttachedItemsId)argObjectId).getSoldItemId());
/* 319 */     setLevelCode(((AttachedItemsId)argObjectId).getLevelCode());
/* 320 */     setLevelValue(((AttachedItemsId)argObjectId).getLevelValue());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 324 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 328 */     StringBuilder buf = new StringBuilder(950);
/* 329 */     buf.append("<").append("dao").append(" name=\"AttachedItems\" cmd=\"" + getObjectStateString() + "\">");
/* 330 */     getFieldsAsXml(buf);
/* 331 */     buf.append("</").append("dao").append(">");
/*     */     
/* 333 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 337 */     Map<String, String> values = super.getValues();
/* 338 */     if (this._attachedItemId != null) values.put("AttachedItemId", DaoUtils.getXmlSafeFieldValue(12, this._attachedItemId)); 
/* 339 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 340 */     if (this._soldItemId != null) values.put("SoldItemId", DaoUtils.getXmlSafeFieldValue(12, this._soldItemId)); 
/* 341 */     if (this._levelCode != null) values.put("LevelCode", DaoUtils.getXmlSafeFieldValue(12, this._levelCode)); 
/* 342 */     if (this._levelValue != null) values.put("LevelValue", DaoUtils.getXmlSafeFieldValue(12, this._levelValue)); 
/* 343 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 344 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 345 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 346 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 347 */     if (this._beginDatetime != null) values.put("BeginDatetime", DaoUtils.getXmlSafeFieldValue(91, this._beginDatetime)); 
/* 348 */     if (this._endDatetime != null) values.put("EndDatetime", DaoUtils.getXmlSafeFieldValue(91, this._endDatetime)); 
/* 349 */     if (this._promptToAdd != null) values.put("PromptToAdd", DaoUtils.getXmlSafeFieldValue(-7, this._promptToAdd)); 
/* 350 */     if (this._promptToAddMsgKey != null) values.put("PromptToAddMsgKey", DaoUtils.getXmlSafeFieldValue(12, this._promptToAddMsgKey)); 
/* 351 */     if (this._quantityToAdd != null) values.put("QuantityToAdd", DaoUtils.getXmlSafeFieldValue(3, this._quantityToAdd)); 
/* 352 */     if (this._lineItemAssociationTypeCode != null) values.put("LineItemAssociationTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._lineItemAssociationTypeCode)); 
/* 353 */     if (this._promptForReturn != null) values.put("PromptForReturn", DaoUtils.getXmlSafeFieldValue(-7, this._promptForReturn)); 
/* 354 */     if (this._promptForReturnMsgKey != null) values.put("PromptForReturnMsgKey", DaoUtils.getXmlSafeFieldValue(12, this._promptForReturnMsgKey)); 
/* 355 */     if (this._externalId != null) values.put("ExternalId", DaoUtils.getXmlSafeFieldValue(12, this._externalId)); 
/* 356 */     if (this._externalSystem != null) values.put("ExternalSystem", DaoUtils.getXmlSafeFieldValue(12, this._externalSystem)); 
/* 357 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 362 */     super.setValues(argValues);
/* 363 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 365 */       String fieldName = field.getKey();
/* 366 */       String fieldValue = field.getValue();
/* 367 */       switch (fieldName) {
/*     */         
/*     */         case "AttachedItemId":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 372 */             setAttachedItemId((String)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setAttachedItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 381 */             setOrganizationId((Long)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SoldItemId":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 390 */             setSoldItemId((String)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setSoldItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelCode":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 399 */             setLevelCode((String)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setLevelCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelValue":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 408 */             setLevelValue((String)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setLevelValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 416 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 417 */             setCreateDate((Date)value);
/* 418 */           } catch (Exception ee) {
/* 419 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 425 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 426 */             setCreateUserId((String)value);
/* 427 */           } catch (Exception ee) {
/* 428 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 434 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 435 */             setUpdateDate((Date)value);
/* 436 */           } catch (Exception ee) {
/* 437 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 443 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 444 */             setUpdateUserId((String)value);
/* 445 */           } catch (Exception ee) {
/* 446 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BeginDatetime":
/*     */           try {
/* 452 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 453 */             setBeginDatetime((Date)value);
/* 454 */           } catch (Exception ee) {
/* 455 */             throw new DtxException("An exception occurred while calling setBeginDatetime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndDatetime":
/*     */           try {
/* 461 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 462 */             setEndDatetime((Date)value);
/* 463 */           } catch (Exception ee) {
/* 464 */             throw new DtxException("An exception occurred while calling setEndDatetime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptToAdd":
/*     */           try {
/* 470 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 471 */             setPromptToAdd((Boolean)value);
/* 472 */           } catch (Exception ee) {
/* 473 */             throw new DtxException("An exception occurred while calling setPromptToAdd() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptToAddMsgKey":
/*     */           try {
/* 479 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 480 */             setPromptToAddMsgKey((String)value);
/* 481 */           } catch (Exception ee) {
/* 482 */             throw new DtxException("An exception occurred while calling setPromptToAddMsgKey() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "QuantityToAdd":
/*     */           try {
/* 488 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 489 */             setQuantityToAdd((BigDecimal)value);
/* 490 */           } catch (Exception ee) {
/* 491 */             throw new DtxException("An exception occurred while calling setQuantityToAdd() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemAssociationTypeCode":
/*     */           try {
/* 497 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 498 */             setLineItemAssociationTypeCode((String)value);
/* 499 */           } catch (Exception ee) {
/* 500 */             throw new DtxException("An exception occurred while calling setLineItemAssociationTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptForReturn":
/*     */           try {
/* 506 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 507 */             setPromptForReturn((Boolean)value);
/* 508 */           } catch (Exception ee) {
/* 509 */             throw new DtxException("An exception occurred while calling setPromptForReturn() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptForReturnMsgKey":
/*     */           try {
/* 515 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 516 */             setPromptForReturnMsgKey((String)value);
/* 517 */           } catch (Exception ee) {
/* 518 */             throw new DtxException("An exception occurred while calling setPromptForReturnMsgKey() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExternalId":
/*     */           try {
/* 524 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 525 */             setExternalId((String)value);
/* 526 */           } catch (Exception ee) {
/* 527 */             throw new DtxException("An exception occurred while calling setExternalId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExternalSystem":
/*     */           try {
/* 533 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 534 */             setExternalSystem((String)value);
/* 535 */           } catch (Exception ee) {
/* 536 */             throw new DtxException("An exception occurred while calling setExternalSystem() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\AttachedItemsDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */