/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.OrderLineId;
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
/*     */ public class OrderLineDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1612149826L;
/*  23 */   private static final Logger _logger = Logger.getLogger(OrderLineDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _externalOrderId;
/*     */   private String _itemId;
/*     */   private BigDecimal _quantity;
/*     */   private String _fulfillmentType;
/*     */   private String _statusCode;
/*     */   private BigDecimal _unitPrice;
/*     */   private BigDecimal _extendedPrice;
/*     */   private BigDecimal _taxAmount;
/*     */   private String _notes;
/*     */   private String _selectedShipMethod;
/*     */   private String _actualShipMethod;
/*     */   private String _trackingNumber;
/*  44 */   private Boolean _dropShip = Boolean.FALSE;
/*  45 */   private Boolean _void = Boolean.FALSE;
/*     */   private String _statusCodeReason;
/*     */   private Integer _lineNumber;
/*     */   private String _statusCodeReasonNote;
/*     */   private String _itemUpcCode;
/*     */   private String _itemEanCode;
/*     */   private BigDecimal _extendedFreight;
/*     */   private BigDecimal _customizationCharge;
/*  53 */   private Boolean _giftWrap = Boolean.FALSE;
/*  54 */   private Boolean _shipAlone = Boolean.FALSE;
/*     */   private BigDecimal _shipWeight;
/*     */   private String _lineMessage;
/*     */   
/*     */   public Long getOrganizationId() {
/*  59 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  63 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  64 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrderId() {
/*  69 */     return this._orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/*  73 */     if (changed(argOrderId, this._orderId, "orderId")) {
/*  74 */       this._orderId = (argOrderId != null && MANAGE_CASE) ? argOrderId.toUpperCase() : argOrderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSequence() {
/*  79 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Integer argSequence) {
/*  83 */     if (changed(argSequence, this._sequence, "sequence")) {
/*  84 */       this._sequence = argSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  89 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  93 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  94 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 100 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 104 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 105 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 110 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 114 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 115 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 121 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 125 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 126 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getExternalOrderId() {
/* 131 */     return this._externalOrderId;
/*     */   }
/*     */   
/*     */   public void setExternalOrderId(String argExternalOrderId) {
/* 135 */     if (changed(argExternalOrderId, this._externalOrderId, "externalOrderId")) {
/* 136 */       this._externalOrderId = argExternalOrderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/* 141 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 145 */     if (changed(argItemId, this._itemId, "itemId")) {
/* 146 */       this._itemId = argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getQuantity() {
/* 151 */     return this._quantity;
/*     */   }
/*     */   
/*     */   public void setQuantity(BigDecimal argQuantity) {
/* 155 */     if (changed(argQuantity, this._quantity, "quantity")) {
/* 156 */       this._quantity = argQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFulfillmentType() {
/* 161 */     return this._fulfillmentType;
/*     */   }
/*     */   
/*     */   public void setFulfillmentType(String argFulfillmentType) {
/* 165 */     if (changed(argFulfillmentType, this._fulfillmentType, "fulfillmentType")) {
/* 166 */       this._fulfillmentType = argFulfillmentType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStatusCode() {
/* 171 */     return this._statusCode;
/*     */   }
/*     */   
/*     */   public void setStatusCode(String argStatusCode) {
/* 175 */     if (changed(argStatusCode, this._statusCode, "statusCode")) {
/* 176 */       this._statusCode = argStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getUnitPrice() {
/* 181 */     return this._unitPrice;
/*     */   }
/*     */   
/*     */   public void setUnitPrice(BigDecimal argUnitPrice) {
/* 185 */     if (changed(argUnitPrice, this._unitPrice, "unitPrice")) {
/* 186 */       this._unitPrice = argUnitPrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getExtendedPrice() {
/* 191 */     return this._extendedPrice;
/*     */   }
/*     */   
/*     */   public void setExtendedPrice(BigDecimal argExtendedPrice) {
/* 195 */     if (changed(argExtendedPrice, this._extendedPrice, "extendedPrice")) {
/* 196 */       this._extendedPrice = argExtendedPrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxAmount() {
/* 201 */     return this._taxAmount;
/*     */   }
/*     */   
/*     */   public void setTaxAmount(BigDecimal argTaxAmount) {
/* 205 */     if (changed(argTaxAmount, this._taxAmount, "taxAmount")) {
/* 206 */       this._taxAmount = argTaxAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNotes() {
/* 211 */     return this._notes;
/*     */   }
/*     */   
/*     */   public void setNotes(String argNotes) {
/* 215 */     if (changed(argNotes, this._notes, "notes")) {
/* 216 */       this._notes = argNotes;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSelectedShipMethod() {
/* 221 */     return this._selectedShipMethod;
/*     */   }
/*     */   
/*     */   public void setSelectedShipMethod(String argSelectedShipMethod) {
/* 225 */     if (changed(argSelectedShipMethod, this._selectedShipMethod, "selectedShipMethod")) {
/* 226 */       this._selectedShipMethod = argSelectedShipMethod;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getActualShipMethod() {
/* 231 */     return this._actualShipMethod;
/*     */   }
/*     */   
/*     */   public void setActualShipMethod(String argActualShipMethod) {
/* 235 */     if (changed(argActualShipMethod, this._actualShipMethod, "actualShipMethod")) {
/* 236 */       this._actualShipMethod = argActualShipMethod;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTrackingNumber() {
/* 241 */     return this._trackingNumber;
/*     */   }
/*     */   
/*     */   public void setTrackingNumber(String argTrackingNumber) {
/* 245 */     if (changed(argTrackingNumber, this._trackingNumber, "trackingNumber")) {
/* 246 */       this._trackingNumber = argTrackingNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getDropShip() {
/* 251 */     return this._dropShip;
/*     */   }
/*     */   
/*     */   public void setDropShip(Boolean argDropShip) {
/* 255 */     if (changed(argDropShip, this._dropShip, "dropShip")) {
/* 256 */       this._dropShip = argDropShip;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getVoid() {
/* 261 */     return this._void;
/*     */   }
/*     */   
/*     */   public void setVoid(Boolean argVoid) {
/* 265 */     if (changed(argVoid, this._void, "void")) {
/* 266 */       this._void = argVoid;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStatusCodeReason() {
/* 271 */     return this._statusCodeReason;
/*     */   }
/*     */   
/*     */   public void setStatusCodeReason(String argStatusCodeReason) {
/* 275 */     if (changed(argStatusCodeReason, this._statusCodeReason, "statusCodeReason")) {
/* 276 */       this._statusCodeReason = argStatusCodeReason;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getLineNumber() {
/* 281 */     return this._lineNumber;
/*     */   }
/*     */   
/*     */   public void setLineNumber(Integer argLineNumber) {
/* 285 */     if (changed(argLineNumber, this._lineNumber, "lineNumber")) {
/* 286 */       this._lineNumber = argLineNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStatusCodeReasonNote() {
/* 291 */     return this._statusCodeReasonNote;
/*     */   }
/*     */   
/*     */   public void setStatusCodeReasonNote(String argStatusCodeReasonNote) {
/* 295 */     if (changed(argStatusCodeReasonNote, this._statusCodeReasonNote, "statusCodeReasonNote")) {
/* 296 */       this._statusCodeReasonNote = argStatusCodeReasonNote;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemUpcCode() {
/* 301 */     return this._itemUpcCode;
/*     */   }
/*     */   
/*     */   public void setItemUpcCode(String argItemUpcCode) {
/* 305 */     if (changed(argItemUpcCode, this._itemUpcCode, "itemUpcCode")) {
/* 306 */       this._itemUpcCode = argItemUpcCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemEanCode() {
/* 311 */     return this._itemEanCode;
/*     */   }
/*     */   
/*     */   public void setItemEanCode(String argItemEanCode) {
/* 315 */     if (changed(argItemEanCode, this._itemEanCode, "itemEanCode")) {
/* 316 */       this._itemEanCode = argItemEanCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getExtendedFreight() {
/* 321 */     return this._extendedFreight;
/*     */   }
/*     */   
/*     */   public void setExtendedFreight(BigDecimal argExtendedFreight) {
/* 325 */     if (changed(argExtendedFreight, this._extendedFreight, "extendedFreight")) {
/* 326 */       this._extendedFreight = argExtendedFreight;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getCustomizationCharge() {
/* 331 */     return this._customizationCharge;
/*     */   }
/*     */   
/*     */   public void setCustomizationCharge(BigDecimal argCustomizationCharge) {
/* 335 */     if (changed(argCustomizationCharge, this._customizationCharge, "customizationCharge")) {
/* 336 */       this._customizationCharge = argCustomizationCharge;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getGiftWrap() {
/* 341 */     return this._giftWrap;
/*     */   }
/*     */   
/*     */   public void setGiftWrap(Boolean argGiftWrap) {
/* 345 */     if (changed(argGiftWrap, this._giftWrap, "giftWrap")) {
/* 346 */       this._giftWrap = argGiftWrap;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getShipAlone() {
/* 351 */     return this._shipAlone;
/*     */   }
/*     */   
/*     */   public void setShipAlone(Boolean argShipAlone) {
/* 355 */     if (changed(argShipAlone, this._shipAlone, "shipAlone")) {
/* 356 */       this._shipAlone = argShipAlone;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getShipWeight() {
/* 361 */     return this._shipWeight;
/*     */   }
/*     */   
/*     */   public void setShipWeight(BigDecimal argShipWeight) {
/* 365 */     if (changed(argShipWeight, this._shipWeight, "shipWeight")) {
/* 366 */       this._shipWeight = argShipWeight;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLineMessage() {
/* 371 */     return this._lineMessage;
/*     */   }
/*     */   
/*     */   public void setLineMessage(String argLineMessage) {
/* 375 */     if (changed(argLineMessage, this._lineMessage, "lineMessage")) {
/* 376 */       this._lineMessage = argLineMessage;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 383 */     StringBuilder buf = new StringBuilder(512);
/* 384 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 385 */     if (getOrganizationId() != null) {
/* 386 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 388 */     if (getOrderId() != null) {
/* 389 */       buf.append("orderId").append("=").append(getOrderId()).append(" ");
/*     */     }
/* 391 */     if (getSequence() != null) {
/* 392 */       buf.append("sequence").append("=").append(getSequence()).append(" ");
/*     */     }
/* 394 */     if (getCreateDate() != null) {
/* 395 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 397 */     if (getCreateUserId() != null) {
/* 398 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 400 */     if (getUpdateDate() != null) {
/* 401 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 403 */     if (getUpdateUserId() != null) {
/* 404 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 406 */     if (getExternalOrderId() != null) {
/* 407 */       buf.append("externalOrderId").append("=").append(getExternalOrderId()).append(" ");
/*     */     }
/* 409 */     if (getItemId() != null) {
/* 410 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 412 */     if (getQuantity() != null) {
/* 413 */       buf.append("quantity").append("=").append(getQuantity()).append(" ");
/*     */     }
/* 415 */     if (getFulfillmentType() != null) {
/* 416 */       buf.append("fulfillmentType").append("=").append(getFulfillmentType()).append(" ");
/*     */     }
/* 418 */     if (getStatusCode() != null) {
/* 419 */       buf.append("statusCode").append("=").append(getStatusCode()).append(" ");
/*     */     }
/* 421 */     if (getUnitPrice() != null) {
/* 422 */       buf.append("unitPrice").append("=").append(getUnitPrice()).append(" ");
/*     */     }
/* 424 */     if (getExtendedPrice() != null) {
/* 425 */       buf.append("extendedPrice").append("=").append(getExtendedPrice()).append(" ");
/*     */     }
/* 427 */     if (getTaxAmount() != null) {
/* 428 */       buf.append("taxAmount").append("=").append(getTaxAmount()).append(" ");
/*     */     }
/* 430 */     if (getNotes() != null) {
/* 431 */       buf.append("notes").append("=").append(getNotes()).append(" ");
/*     */     }
/* 433 */     if (getSelectedShipMethod() != null) {
/* 434 */       buf.append("selectedShipMethod").append("=").append(getSelectedShipMethod()).append(" ");
/*     */     }
/* 436 */     if (getActualShipMethod() != null) {
/* 437 */       buf.append("actualShipMethod").append("=").append(getActualShipMethod()).append(" ");
/*     */     }
/* 439 */     if (getTrackingNumber() != null) {
/* 440 */       buf.append("trackingNumber").append("=").append(getTrackingNumber()).append(" ");
/*     */     }
/* 442 */     if (getDropShip() != null && getDropShip().booleanValue()) {
/* 443 */       buf.append("dropShip").append("=").append(getDropShip()).append(" ");
/*     */     }
/* 445 */     if (getVoid() != null && getVoid().booleanValue()) {
/* 446 */       buf.append("void").append("=").append(getVoid()).append(" ");
/*     */     }
/* 448 */     if (getStatusCodeReason() != null) {
/* 449 */       buf.append("statusCodeReason").append("=").append(getStatusCodeReason()).append(" ");
/*     */     }
/* 451 */     if (getLineNumber() != null) {
/* 452 */       buf.append("lineNumber").append("=").append(getLineNumber()).append(" ");
/*     */     }
/* 454 */     if (getStatusCodeReasonNote() != null) {
/* 455 */       buf.append("statusCodeReasonNote").append("=").append(getStatusCodeReasonNote()).append(" ");
/*     */     }
/* 457 */     if (getItemUpcCode() != null) {
/* 458 */       buf.append("itemUpcCode").append("=").append(getItemUpcCode()).append(" ");
/*     */     }
/* 460 */     if (getItemEanCode() != null) {
/* 461 */       buf.append("itemEanCode").append("=").append(getItemEanCode()).append(" ");
/*     */     }
/* 463 */     if (getExtendedFreight() != null) {
/* 464 */       buf.append("extendedFreight").append("=").append(getExtendedFreight()).append(" ");
/*     */     }
/* 466 */     if (getCustomizationCharge() != null) {
/* 467 */       buf.append("customizationCharge").append("=").append(getCustomizationCharge()).append(" ");
/*     */     }
/* 469 */     if (getGiftWrap() != null && getGiftWrap().booleanValue()) {
/* 470 */       buf.append("giftWrap").append("=").append(getGiftWrap()).append(" ");
/*     */     }
/* 472 */     if (getShipAlone() != null && getShipAlone().booleanValue()) {
/* 473 */       buf.append("shipAlone").append("=").append(getShipAlone()).append(" ");
/*     */     }
/* 475 */     if (getShipWeight() != null) {
/* 476 */       buf.append("shipWeight").append("=").append(getShipWeight()).append(" ");
/*     */     }
/* 478 */     if (getLineMessage() != null) {
/* 479 */       buf.append("lineMessage").append("=").append(getLineMessage()).append(" ");
/*     */     }
/*     */     
/* 482 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 486 */     OrderLineId id = new OrderLineId();
/* 487 */     id.setOrganizationId(getOrganizationId());
/* 488 */     id.setOrderId(getOrderId());
/* 489 */     id.setSequence(getSequence());
/* 490 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 494 */     setOrganizationId(((OrderLineId)argObjectId).getOrganizationId());
/* 495 */     setOrderId(((OrderLineId)argObjectId).getOrderId());
/* 496 */     setSequence(((OrderLineId)argObjectId).getSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 500 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 504 */     StringBuilder buf = new StringBuilder(1600);
/* 505 */     buf.append("<").append("dao").append(" name=\"OrderLine\" cmd=\"" + getObjectStateString() + "\">");
/* 506 */     getFieldsAsXml(buf);
/* 507 */     buf.append("</").append("dao").append(">");
/*     */     
/* 509 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 513 */     Map<String, String> values = super.getValues();
/* 514 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 515 */     if (this._orderId != null) values.put("OrderId", DaoUtils.getXmlSafeFieldValue(12, this._orderId)); 
/* 516 */     if (this._sequence != null) values.put("Sequence", DaoUtils.getXmlSafeFieldValue(4, this._sequence)); 
/* 517 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 518 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 519 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 520 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 521 */     if (this._externalOrderId != null) values.put("ExternalOrderId", DaoUtils.getXmlSafeFieldValue(12, this._externalOrderId)); 
/* 522 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 523 */     if (this._quantity != null) values.put("Quantity", DaoUtils.getXmlSafeFieldValue(3, this._quantity)); 
/* 524 */     if (this._fulfillmentType != null) values.put("FulfillmentType", DaoUtils.getXmlSafeFieldValue(12, this._fulfillmentType)); 
/* 525 */     if (this._statusCode != null) values.put("StatusCode", DaoUtils.getXmlSafeFieldValue(12, this._statusCode)); 
/* 526 */     if (this._unitPrice != null) values.put("UnitPrice", DaoUtils.getXmlSafeFieldValue(3, this._unitPrice)); 
/* 527 */     if (this._extendedPrice != null) values.put("ExtendedPrice", DaoUtils.getXmlSafeFieldValue(3, this._extendedPrice)); 
/* 528 */     if (this._taxAmount != null) values.put("TaxAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxAmount)); 
/* 529 */     if (this._notes != null) values.put("Notes", DaoUtils.getXmlSafeFieldValue(12, this._notes)); 
/* 530 */     if (this._selectedShipMethod != null) values.put("SelectedShipMethod", DaoUtils.getXmlSafeFieldValue(12, this._selectedShipMethod)); 
/* 531 */     if (this._actualShipMethod != null) values.put("ActualShipMethod", DaoUtils.getXmlSafeFieldValue(12, this._actualShipMethod)); 
/* 532 */     if (this._trackingNumber != null) values.put("TrackingNumber", DaoUtils.getXmlSafeFieldValue(12, this._trackingNumber)); 
/* 533 */     if (this._dropShip != null) values.put("DropShip", DaoUtils.getXmlSafeFieldValue(-7, this._dropShip)); 
/* 534 */     if (this._void != null) values.put("Void", DaoUtils.getXmlSafeFieldValue(-7, this._void)); 
/* 535 */     if (this._statusCodeReason != null) values.put("StatusCodeReason", DaoUtils.getXmlSafeFieldValue(12, this._statusCodeReason)); 
/* 536 */     if (this._lineNumber != null) values.put("LineNumber", DaoUtils.getXmlSafeFieldValue(4, this._lineNumber)); 
/* 537 */     if (this._statusCodeReasonNote != null) values.put("StatusCodeReasonNote", DaoUtils.getXmlSafeFieldValue(12, this._statusCodeReasonNote)); 
/* 538 */     if (this._itemUpcCode != null) values.put("ItemUpcCode", DaoUtils.getXmlSafeFieldValue(12, this._itemUpcCode)); 
/* 539 */     if (this._itemEanCode != null) values.put("ItemEanCode", DaoUtils.getXmlSafeFieldValue(12, this._itemEanCode)); 
/* 540 */     if (this._extendedFreight != null) values.put("ExtendedFreight", DaoUtils.getXmlSafeFieldValue(3, this._extendedFreight)); 
/* 541 */     if (this._customizationCharge != null) values.put("CustomizationCharge", DaoUtils.getXmlSafeFieldValue(3, this._customizationCharge)); 
/* 542 */     if (this._giftWrap != null) values.put("GiftWrap", DaoUtils.getXmlSafeFieldValue(-7, this._giftWrap)); 
/* 543 */     if (this._shipAlone != null) values.put("ShipAlone", DaoUtils.getXmlSafeFieldValue(-7, this._shipAlone)); 
/* 544 */     if (this._shipWeight != null) values.put("ShipWeight", DaoUtils.getXmlSafeFieldValue(3, this._shipWeight)); 
/* 545 */     if (this._lineMessage != null) values.put("LineMessage", DaoUtils.getXmlSafeFieldValue(12, this._lineMessage)); 
/* 546 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 551 */     super.setValues(argValues);
/* 552 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 554 */       String fieldName = field.getKey();
/* 555 */       String fieldValue = field.getValue();
/* 556 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 560 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 561 */             setOrganizationId((Long)value);
/* 562 */           } catch (Exception ee) {
/* 563 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrderId":
/*     */           try {
/* 569 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 570 */             setOrderId((String)value);
/* 571 */           } catch (Exception ee) {
/* 572 */             throw new DtxException("An exception occurred while calling setOrderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Sequence":
/*     */           try {
/* 578 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 579 */             setSequence((Integer)value);
/* 580 */           } catch (Exception ee) {
/* 581 */             throw new DtxException("An exception occurred while calling setSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 587 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 588 */             setCreateDate((Date)value);
/* 589 */           } catch (Exception ee) {
/* 590 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 596 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 597 */             setCreateUserId((String)value);
/* 598 */           } catch (Exception ee) {
/* 599 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 605 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 606 */             setUpdateDate((Date)value);
/* 607 */           } catch (Exception ee) {
/* 608 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 614 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 615 */             setUpdateUserId((String)value);
/* 616 */           } catch (Exception ee) {
/* 617 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExternalOrderId":
/*     */           try {
/* 623 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 624 */             setExternalOrderId((String)value);
/* 625 */           } catch (Exception ee) {
/* 626 */             throw new DtxException("An exception occurred while calling setExternalOrderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 632 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 633 */             setItemId((String)value);
/* 634 */           } catch (Exception ee) {
/* 635 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Quantity":
/*     */           try {
/* 641 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 642 */             setQuantity((BigDecimal)value);
/* 643 */           } catch (Exception ee) {
/* 644 */             throw new DtxException("An exception occurred while calling setQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FulfillmentType":
/*     */           try {
/* 650 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 651 */             setFulfillmentType((String)value);
/* 652 */           } catch (Exception ee) {
/* 653 */             throw new DtxException("An exception occurred while calling setFulfillmentType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusCode":
/*     */           try {
/* 659 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 660 */             setStatusCode((String)value);
/* 661 */           } catch (Exception ee) {
/* 662 */             throw new DtxException("An exception occurred while calling setStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UnitPrice":
/*     */           try {
/* 668 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 669 */             setUnitPrice((BigDecimal)value);
/* 670 */           } catch (Exception ee) {
/* 671 */             throw new DtxException("An exception occurred while calling setUnitPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExtendedPrice":
/*     */           try {
/* 677 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 678 */             setExtendedPrice((BigDecimal)value);
/* 679 */           } catch (Exception ee) {
/* 680 */             throw new DtxException("An exception occurred while calling setExtendedPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxAmount":
/*     */           try {
/* 686 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 687 */             setTaxAmount((BigDecimal)value);
/* 688 */           } catch (Exception ee) {
/* 689 */             throw new DtxException("An exception occurred while calling setTaxAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Notes":
/*     */           try {
/* 695 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 696 */             setNotes((String)value);
/* 697 */           } catch (Exception ee) {
/* 698 */             throw new DtxException("An exception occurred while calling setNotes() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SelectedShipMethod":
/*     */           try {
/* 704 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 705 */             setSelectedShipMethod((String)value);
/* 706 */           } catch (Exception ee) {
/* 707 */             throw new DtxException("An exception occurred while calling setSelectedShipMethod() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActualShipMethod":
/*     */           try {
/* 713 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 714 */             setActualShipMethod((String)value);
/* 715 */           } catch (Exception ee) {
/* 716 */             throw new DtxException("An exception occurred while calling setActualShipMethod() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TrackingNumber":
/*     */           try {
/* 722 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 723 */             setTrackingNumber((String)value);
/* 724 */           } catch (Exception ee) {
/* 725 */             throw new DtxException("An exception occurred while calling setTrackingNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DropShip":
/*     */           try {
/* 731 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 732 */             setDropShip((Boolean)value);
/* 733 */           } catch (Exception ee) {
/* 734 */             throw new DtxException("An exception occurred while calling setDropShip() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Void":
/*     */           try {
/* 740 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 741 */             setVoid((Boolean)value);
/* 742 */           } catch (Exception ee) {
/* 743 */             throw new DtxException("An exception occurred while calling setVoid() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusCodeReason":
/*     */           try {
/* 749 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 750 */             setStatusCodeReason((String)value);
/* 751 */           } catch (Exception ee) {
/* 752 */             throw new DtxException("An exception occurred while calling setStatusCodeReason() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineNumber":
/*     */           try {
/* 758 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 759 */             setLineNumber((Integer)value);
/* 760 */           } catch (Exception ee) {
/* 761 */             throw new DtxException("An exception occurred while calling setLineNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusCodeReasonNote":
/*     */           try {
/* 767 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 768 */             setStatusCodeReasonNote((String)value);
/* 769 */           } catch (Exception ee) {
/* 770 */             throw new DtxException("An exception occurred while calling setStatusCodeReasonNote() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemUpcCode":
/*     */           try {
/* 776 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 777 */             setItemUpcCode((String)value);
/* 778 */           } catch (Exception ee) {
/* 779 */             throw new DtxException("An exception occurred while calling setItemUpcCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemEanCode":
/*     */           try {
/* 785 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 786 */             setItemEanCode((String)value);
/* 787 */           } catch (Exception ee) {
/* 788 */             throw new DtxException("An exception occurred while calling setItemEanCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExtendedFreight":
/*     */           try {
/* 794 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 795 */             setExtendedFreight((BigDecimal)value);
/* 796 */           } catch (Exception ee) {
/* 797 */             throw new DtxException("An exception occurred while calling setExtendedFreight() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomizationCharge":
/*     */           try {
/* 803 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 804 */             setCustomizationCharge((BigDecimal)value);
/* 805 */           } catch (Exception ee) {
/* 806 */             throw new DtxException("An exception occurred while calling setCustomizationCharge() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "GiftWrap":
/*     */           try {
/* 812 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 813 */             setGiftWrap((Boolean)value);
/* 814 */           } catch (Exception ee) {
/* 815 */             throw new DtxException("An exception occurred while calling setGiftWrap() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipAlone":
/*     */           try {
/* 821 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 822 */             setShipAlone((Boolean)value);
/* 823 */           } catch (Exception ee) {
/* 824 */             throw new DtxException("An exception occurred while calling setShipAlone() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipWeight":
/*     */           try {
/* 830 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 831 */             setShipWeight((BigDecimal)value);
/* 832 */           } catch (Exception ee) {
/* 833 */             throw new DtxException("An exception occurred while calling setShipWeight() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineMessage":
/*     */           try {
/* 839 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 840 */             setLineMessage((String)value);
/* 841 */           } catch (Exception ee) {
/* 842 */             throw new DtxException("An exception occurred while calling setLineMessage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\OrderLineDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */