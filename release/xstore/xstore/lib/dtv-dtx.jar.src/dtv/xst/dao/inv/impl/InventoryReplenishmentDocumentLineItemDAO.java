/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryReplenishmentDocumentLineItemId;
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
/*     */ public class InventoryReplenishmentDocumentLineItemDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1339662122L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryReplenishmentDocumentLineItemDAO.class);
/*     */   
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private BigDecimal _suggestedOrderQuantity;
/*     */   private BigDecimal _orderQuantity;
/*     */   private BigDecimal _confirmedQuantity;
/*     */   private DtvDate _confirmationDate;
/*     */   private String _confirmationNumber;
/*     */   private String _shipVia;
/*     */   private BigDecimal _shippedQuantity;
/*     */   private DtvDate _shippedDate;
/*     */   private BigDecimal _receivedQuantity;
/*     */   private DtvDate _receivedDate;
/*     */   private String _sourceType;
/*     */   private String _sourceId;
/*     */   private String _sourceName;
/*     */   private String _parentDocumentId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   
/*     */   public String getDocumentId() {
/*  50 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  54 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/*  55 */       this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  60 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  64 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/*  65 */       this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getInventoryDocumentLineNumber() {
/*  70 */     return this._inventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentLineNumber(Integer argInventoryDocumentLineNumber) {
/*  74 */     if (changed(argInventoryDocumentLineNumber, this._inventoryDocumentLineNumber, "inventoryDocumentLineNumber")) {
/*  75 */       this._inventoryDocumentLineNumber = argInventoryDocumentLineNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  80 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  84 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  85 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  90 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  94 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  95 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getSuggestedOrderQuantity() {
/* 100 */     return this._suggestedOrderQuantity;
/*     */   }
/*     */   
/*     */   public void setSuggestedOrderQuantity(BigDecimal argSuggestedOrderQuantity) {
/* 104 */     if (changed(argSuggestedOrderQuantity, this._suggestedOrderQuantity, "suggestedOrderQuantity")) {
/* 105 */       this._suggestedOrderQuantity = argSuggestedOrderQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getOrderQuantity() {
/* 110 */     return this._orderQuantity;
/*     */   }
/*     */   
/*     */   public void setOrderQuantity(BigDecimal argOrderQuantity) {
/* 114 */     if (changed(argOrderQuantity, this._orderQuantity, "orderQuantity")) {
/* 115 */       this._orderQuantity = argOrderQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getConfirmedQuantity() {
/* 120 */     return this._confirmedQuantity;
/*     */   }
/*     */   
/*     */   public void setConfirmedQuantity(BigDecimal argConfirmedQuantity) {
/* 124 */     if (changed(argConfirmedQuantity, this._confirmedQuantity, "confirmedQuantity")) {
/* 125 */       this._confirmedQuantity = argConfirmedQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getConfirmationDate() {
/* 130 */     return (Date)this._confirmationDate;
/*     */   }
/*     */   
/*     */   public void setConfirmationDate(Date argConfirmationDate) {
/* 134 */     if (changed(argConfirmationDate, this._confirmationDate, "confirmationDate")) {
/* 135 */       this._confirmationDate = (argConfirmationDate == null || argConfirmationDate instanceof DtvDate) ? (DtvDate)argConfirmationDate : new DtvDate(argConfirmationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getConfirmationNumber() {
/* 141 */     return this._confirmationNumber;
/*     */   }
/*     */   
/*     */   public void setConfirmationNumber(String argConfirmationNumber) {
/* 145 */     if (changed(argConfirmationNumber, this._confirmationNumber, "confirmationNumber")) {
/* 146 */       this._confirmationNumber = argConfirmationNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getShipVia() {
/* 151 */     return this._shipVia;
/*     */   }
/*     */   
/*     */   public void setShipVia(String argShipVia) {
/* 155 */     if (changed(argShipVia, this._shipVia, "shipVia")) {
/* 156 */       this._shipVia = argShipVia;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getShippedQuantity() {
/* 161 */     return this._shippedQuantity;
/*     */   }
/*     */   
/*     */   public void setShippedQuantity(BigDecimal argShippedQuantity) {
/* 165 */     if (changed(argShippedQuantity, this._shippedQuantity, "shippedQuantity")) {
/* 166 */       this._shippedQuantity = argShippedQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getShippedDate() {
/* 171 */     return (Date)this._shippedDate;
/*     */   }
/*     */   
/*     */   public void setShippedDate(Date argShippedDate) {
/* 175 */     if (changed(argShippedDate, this._shippedDate, "shippedDate")) {
/* 176 */       this._shippedDate = (argShippedDate == null || argShippedDate instanceof DtvDate) ? (DtvDate)argShippedDate : new DtvDate(argShippedDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getReceivedQuantity() {
/* 182 */     return this._receivedQuantity;
/*     */   }
/*     */   
/*     */   public void setReceivedQuantity(BigDecimal argReceivedQuantity) {
/* 186 */     if (changed(argReceivedQuantity, this._receivedQuantity, "receivedQuantity")) {
/* 187 */       this._receivedQuantity = argReceivedQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getReceivedDate() {
/* 192 */     return (Date)this._receivedDate;
/*     */   }
/*     */   
/*     */   public void setReceivedDate(Date argReceivedDate) {
/* 196 */     if (changed(argReceivedDate, this._receivedDate, "receivedDate")) {
/* 197 */       this._receivedDate = (argReceivedDate == null || argReceivedDate instanceof DtvDate) ? (DtvDate)argReceivedDate : new DtvDate(argReceivedDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSourceType() {
/* 203 */     return this._sourceType;
/*     */   }
/*     */   
/*     */   public void setSourceType(String argSourceType) {
/* 207 */     if (changed(argSourceType, this._sourceType, "sourceType")) {
/* 208 */       this._sourceType = argSourceType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSourceId() {
/* 213 */     return this._sourceId;
/*     */   }
/*     */   
/*     */   public void setSourceId(String argSourceId) {
/* 217 */     if (changed(argSourceId, this._sourceId, "sourceId")) {
/* 218 */       this._sourceId = argSourceId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSourceName() {
/* 223 */     return this._sourceName;
/*     */   }
/*     */   
/*     */   public void setSourceName(String argSourceName) {
/* 227 */     if (changed(argSourceName, this._sourceName, "sourceName")) {
/* 228 */       this._sourceName = argSourceName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getParentDocumentId() {
/* 233 */     return this._parentDocumentId;
/*     */   }
/*     */   
/*     */   public void setParentDocumentId(String argParentDocumentId) {
/* 237 */     if (changed(argParentDocumentId, this._parentDocumentId, "parentDocumentId")) {
/* 238 */       this._parentDocumentId = argParentDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 243 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 247 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 248 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 254 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 258 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 259 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 264 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 268 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 269 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 275 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 279 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 280 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 287 */     StringBuilder buf = new StringBuilder(512);
/* 288 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 289 */     if (getDocumentId() != null) {
/* 290 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 292 */     if (getDocumentTypeCode() != null) {
/* 293 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/* 295 */     if (getInventoryDocumentLineNumber() != null) {
/* 296 */       buf.append("inventoryDocumentLineNumber").append("=").append(getInventoryDocumentLineNumber()).append(" ");
/*     */     }
/* 298 */     if (getOrganizationId() != null) {
/* 299 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 301 */     if (getRetailLocationId() != null) {
/* 302 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 304 */     if (getSuggestedOrderQuantity() != null) {
/* 305 */       buf.append("suggestedOrderQuantity").append("=").append(getSuggestedOrderQuantity()).append(" ");
/*     */     }
/* 307 */     if (getOrderQuantity() != null) {
/* 308 */       buf.append("orderQuantity").append("=").append(getOrderQuantity()).append(" ");
/*     */     }
/* 310 */     if (getConfirmedQuantity() != null) {
/* 311 */       buf.append("confirmedQuantity").append("=").append(getConfirmedQuantity()).append(" ");
/*     */     }
/* 313 */     if (getConfirmationDate() != null) {
/* 314 */       buf.append("confirmationDate").append("=").append(getConfirmationDate()).append(" ");
/*     */     }
/* 316 */     if (getConfirmationNumber() != null) {
/* 317 */       buf.append("confirmationNumber").append("=").append(getConfirmationNumber()).append(" ");
/*     */     }
/* 319 */     if (getShipVia() != null) {
/* 320 */       buf.append("shipVia").append("=").append(getShipVia()).append(" ");
/*     */     }
/* 322 */     if (getShippedQuantity() != null) {
/* 323 */       buf.append("shippedQuantity").append("=").append(getShippedQuantity()).append(" ");
/*     */     }
/* 325 */     if (getShippedDate() != null) {
/* 326 */       buf.append("shippedDate").append("=").append(getShippedDate()).append(" ");
/*     */     }
/* 328 */     if (getReceivedQuantity() != null) {
/* 329 */       buf.append("receivedQuantity").append("=").append(getReceivedQuantity()).append(" ");
/*     */     }
/* 331 */     if (getReceivedDate() != null) {
/* 332 */       buf.append("receivedDate").append("=").append(getReceivedDate()).append(" ");
/*     */     }
/* 334 */     if (getSourceType() != null) {
/* 335 */       buf.append("sourceType").append("=").append(getSourceType()).append(" ");
/*     */     }
/* 337 */     if (getSourceId() != null) {
/* 338 */       buf.append("sourceId").append("=").append(getSourceId()).append(" ");
/*     */     }
/* 340 */     if (getSourceName() != null) {
/* 341 */       buf.append("sourceName").append("=").append(getSourceName()).append(" ");
/*     */     }
/* 343 */     if (getParentDocumentId() != null) {
/* 344 */       buf.append("parentDocumentId").append("=").append(getParentDocumentId()).append(" ");
/*     */     }
/* 346 */     if (getCreateDate() != null) {
/* 347 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 349 */     if (getCreateUserId() != null) {
/* 350 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 352 */     if (getUpdateDate() != null) {
/* 353 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 355 */     if (getUpdateUserId() != null) {
/* 356 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 359 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 363 */     InventoryReplenishmentDocumentLineItemId id = new InventoryReplenishmentDocumentLineItemId();
/* 364 */     id.setDocumentId(getDocumentId());
/* 365 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 366 */     id.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/* 367 */     id.setOrganizationId(getOrganizationId());
/* 368 */     id.setRetailLocationId(getRetailLocationId());
/* 369 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 373 */     setDocumentId(((InventoryReplenishmentDocumentLineItemId)argObjectId).getDocumentId());
/* 374 */     setDocumentTypeCode(((InventoryReplenishmentDocumentLineItemId)argObjectId).getDocumentTypeCode());
/* 375 */     setInventoryDocumentLineNumber(((InventoryReplenishmentDocumentLineItemId)argObjectId).getInventoryDocumentLineNumber());
/* 376 */     setOrganizationId(((InventoryReplenishmentDocumentLineItemId)argObjectId).getOrganizationId());
/* 377 */     setRetailLocationId(((InventoryReplenishmentDocumentLineItemId)argObjectId).getRetailLocationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 381 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 385 */     StringBuilder buf = new StringBuilder(1150);
/* 386 */     buf.append("<").append("dao").append(" name=\"InventoryReplenishmentDocumentLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 387 */     getFieldsAsXml(buf);
/* 388 */     buf.append("</").append("dao").append(">");
/*     */     
/* 390 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 394 */     Map<String, String> values = super.getValues();
/* 395 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 396 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 397 */     if (this._inventoryDocumentLineNumber != null) values.put("InventoryDocumentLineNumber", DaoUtils.getXmlSafeFieldValue(4, this._inventoryDocumentLineNumber)); 
/* 398 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 399 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 400 */     if (this._suggestedOrderQuantity != null) values.put("SuggestedOrderQuantity", DaoUtils.getXmlSafeFieldValue(3, this._suggestedOrderQuantity)); 
/* 401 */     if (this._orderQuantity != null) values.put("OrderQuantity", DaoUtils.getXmlSafeFieldValue(3, this._orderQuantity)); 
/* 402 */     if (this._confirmedQuantity != null) values.put("ConfirmedQuantity", DaoUtils.getXmlSafeFieldValue(3, this._confirmedQuantity)); 
/* 403 */     if (this._confirmationDate != null) values.put("ConfirmationDate", DaoUtils.getXmlSafeFieldValue(91, this._confirmationDate)); 
/* 404 */     if (this._confirmationNumber != null) values.put("ConfirmationNumber", DaoUtils.getXmlSafeFieldValue(12, this._confirmationNumber)); 
/* 405 */     if (this._shipVia != null) values.put("ShipVia", DaoUtils.getXmlSafeFieldValue(12, this._shipVia)); 
/* 406 */     if (this._shippedQuantity != null) values.put("ShippedQuantity", DaoUtils.getXmlSafeFieldValue(3, this._shippedQuantity)); 
/* 407 */     if (this._shippedDate != null) values.put("ShippedDate", DaoUtils.getXmlSafeFieldValue(91, this._shippedDate)); 
/* 408 */     if (this._receivedQuantity != null) values.put("ReceivedQuantity", DaoUtils.getXmlSafeFieldValue(3, this._receivedQuantity)); 
/* 409 */     if (this._receivedDate != null) values.put("ReceivedDate", DaoUtils.getXmlSafeFieldValue(91, this._receivedDate)); 
/* 410 */     if (this._sourceType != null) values.put("SourceType", DaoUtils.getXmlSafeFieldValue(12, this._sourceType)); 
/* 411 */     if (this._sourceId != null) values.put("SourceId", DaoUtils.getXmlSafeFieldValue(12, this._sourceId)); 
/* 412 */     if (this._sourceName != null) values.put("SourceName", DaoUtils.getXmlSafeFieldValue(12, this._sourceName)); 
/* 413 */     if (this._parentDocumentId != null) values.put("ParentDocumentId", DaoUtils.getXmlSafeFieldValue(12, this._parentDocumentId)); 
/* 414 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 415 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 416 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 417 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 418 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 423 */     super.setValues(argValues);
/* 424 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 426 */       String fieldName = field.getKey();
/* 427 */       String fieldValue = field.getValue();
/* 428 */       switch (fieldName) {
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 432 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 433 */             setDocumentId((String)value);
/* 434 */           } catch (Exception ee) {
/* 435 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 441 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 442 */             setDocumentTypeCode((String)value);
/* 443 */           } catch (Exception ee) {
/* 444 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryDocumentLineNumber":
/*     */           try {
/* 450 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 451 */             setInventoryDocumentLineNumber((Integer)value);
/* 452 */           } catch (Exception ee) {
/* 453 */             throw new DtxException("An exception occurred while calling setInventoryDocumentLineNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 459 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 460 */             setOrganizationId((Long)value);
/* 461 */           } catch (Exception ee) {
/* 462 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 468 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 469 */             setRetailLocationId((Long)value);
/* 470 */           } catch (Exception ee) {
/* 471 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SuggestedOrderQuantity":
/*     */           try {
/* 477 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 478 */             setSuggestedOrderQuantity((BigDecimal)value);
/* 479 */           } catch (Exception ee) {
/* 480 */             throw new DtxException("An exception occurred while calling setSuggestedOrderQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrderQuantity":
/*     */           try {
/* 486 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 487 */             setOrderQuantity((BigDecimal)value);
/* 488 */           } catch (Exception ee) {
/* 489 */             throw new DtxException("An exception occurred while calling setOrderQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ConfirmedQuantity":
/*     */           try {
/* 495 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 496 */             setConfirmedQuantity((BigDecimal)value);
/* 497 */           } catch (Exception ee) {
/* 498 */             throw new DtxException("An exception occurred while calling setConfirmedQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ConfirmationDate":
/*     */           try {
/* 504 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 505 */             setConfirmationDate((Date)value);
/* 506 */           } catch (Exception ee) {
/* 507 */             throw new DtxException("An exception occurred while calling setConfirmationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ConfirmationNumber":
/*     */           try {
/* 513 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 514 */             setConfirmationNumber((String)value);
/* 515 */           } catch (Exception ee) {
/* 516 */             throw new DtxException("An exception occurred while calling setConfirmationNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipVia":
/*     */           try {
/* 522 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 523 */             setShipVia((String)value);
/* 524 */           } catch (Exception ee) {
/* 525 */             throw new DtxException("An exception occurred while calling setShipVia() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShippedQuantity":
/*     */           try {
/* 531 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 532 */             setShippedQuantity((BigDecimal)value);
/* 533 */           } catch (Exception ee) {
/* 534 */             throw new DtxException("An exception occurred while calling setShippedQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShippedDate":
/*     */           try {
/* 540 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 541 */             setShippedDate((Date)value);
/* 542 */           } catch (Exception ee) {
/* 543 */             throw new DtxException("An exception occurred while calling setShippedDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReceivedQuantity":
/*     */           try {
/* 549 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 550 */             setReceivedQuantity((BigDecimal)value);
/* 551 */           } catch (Exception ee) {
/* 552 */             throw new DtxException("An exception occurred while calling setReceivedQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReceivedDate":
/*     */           try {
/* 558 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 559 */             setReceivedDate((Date)value);
/* 560 */           } catch (Exception ee) {
/* 561 */             throw new DtxException("An exception occurred while calling setReceivedDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SourceType":
/*     */           try {
/* 567 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 568 */             setSourceType((String)value);
/* 569 */           } catch (Exception ee) {
/* 570 */             throw new DtxException("An exception occurred while calling setSourceType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SourceId":
/*     */           try {
/* 576 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 577 */             setSourceId((String)value);
/* 578 */           } catch (Exception ee) {
/* 579 */             throw new DtxException("An exception occurred while calling setSourceId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SourceName":
/*     */           try {
/* 585 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 586 */             setSourceName((String)value);
/* 587 */           } catch (Exception ee) {
/* 588 */             throw new DtxException("An exception occurred while calling setSourceName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ParentDocumentId":
/*     */           try {
/* 594 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 595 */             setParentDocumentId((String)value);
/* 596 */           } catch (Exception ee) {
/* 597 */             throw new DtxException("An exception occurred while calling setParentDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 603 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 604 */             setCreateDate((Date)value);
/* 605 */           } catch (Exception ee) {
/* 606 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 612 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 613 */             setCreateUserId((String)value);
/* 614 */           } catch (Exception ee) {
/* 615 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 621 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 622 */             setUpdateDate((Date)value);
/* 623 */           } catch (Exception ee) {
/* 624 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 630 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 631 */             setUpdateUserId((String)value);
/* 632 */           } catch (Exception ee) {
/* 633 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryReplenishmentDocumentLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */