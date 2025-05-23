/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.OrderId;
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
/*     */ public class OrderDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 76453678L;
/*  23 */   private static final Logger _logger = Logger.getLogger(OrderDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orderType;
/*     */   private String _statusCode;
/*     */   private DtvDate _orderDate;
/*     */   private String _orderLocationId;
/*     */   private BigDecimal _subtotal;
/*     */   private BigDecimal _taxAmount;
/*     */   private BigDecimal _total;
/*     */   private BigDecimal _balanceDue;
/*     */   private String _notes;
/*     */   private String _referenceNumber;
/*     */   private BigDecimal _additionalFreightCharges;
/*     */   private BigDecimal _additionalCharges;
/*  43 */   private Boolean _shipComplete = Boolean.FALSE;
/*     */   private BigDecimal _freightTax;
/*     */   private String _orderMessage;
/*     */   private String _giftMessage;
/*  47 */   private Boolean _underReview = Boolean.FALSE;
/*     */   private String _statusCodeReason;
/*     */   private String _statusCodeReasonNote;
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
/*     */   public String getOrderId() {
/*  62 */     return this._orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/*  66 */     if (changed(argOrderId, this._orderId, "orderId")) {
/*  67 */       this._orderId = (argOrderId != null && MANAGE_CASE) ? argOrderId.toUpperCase() : argOrderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  72 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  76 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  77 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  83 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  87 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  88 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  93 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  97 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  98 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 104 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 108 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 109 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrderType() {
/* 114 */     return this._orderType;
/*     */   }
/*     */   
/*     */   public void setOrderType(String argOrderType) {
/* 118 */     if (changed(argOrderType, this._orderType, "orderType")) {
/* 119 */       this._orderType = argOrderType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStatusCode() {
/* 124 */     return this._statusCode;
/*     */   }
/*     */   
/*     */   public void setStatusCode(String argStatusCode) {
/* 128 */     if (changed(argStatusCode, this._statusCode, "statusCode")) {
/* 129 */       this._statusCode = argStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getOrderDate() {
/* 134 */     return (Date)this._orderDate;
/*     */   }
/*     */   
/*     */   public void setOrderDate(Date argOrderDate) {
/* 138 */     if (changed(argOrderDate, this._orderDate, "orderDate")) {
/* 139 */       this._orderDate = (argOrderDate == null || argOrderDate instanceof DtvDate) ? (DtvDate)argOrderDate : new DtvDate(argOrderDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getOrderLocationId() {
/* 145 */     return this._orderLocationId;
/*     */   }
/*     */   
/*     */   public void setOrderLocationId(String argOrderLocationId) {
/* 149 */     if (changed(argOrderLocationId, this._orderLocationId, "orderLocationId")) {
/* 150 */       this._orderLocationId = argOrderLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getSubtotal() {
/* 155 */     return this._subtotal;
/*     */   }
/*     */   
/*     */   public void setSubtotal(BigDecimal argSubtotal) {
/* 159 */     if (changed(argSubtotal, this._subtotal, "subtotal")) {
/* 160 */       this._subtotal = argSubtotal;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxAmount() {
/* 165 */     return this._taxAmount;
/*     */   }
/*     */   
/*     */   public void setTaxAmount(BigDecimal argTaxAmount) {
/* 169 */     if (changed(argTaxAmount, this._taxAmount, "taxAmount")) {
/* 170 */       this._taxAmount = argTaxAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTotal() {
/* 175 */     return this._total;
/*     */   }
/*     */   
/*     */   public void setTotal(BigDecimal argTotal) {
/* 179 */     if (changed(argTotal, this._total, "total")) {
/* 180 */       this._total = argTotal;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getBalanceDue() {
/* 185 */     return this._balanceDue;
/*     */   }
/*     */   
/*     */   public void setBalanceDue(BigDecimal argBalanceDue) {
/* 189 */     if (changed(argBalanceDue, this._balanceDue, "balanceDue")) {
/* 190 */       this._balanceDue = argBalanceDue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNotes() {
/* 195 */     return this._notes;
/*     */   }
/*     */   
/*     */   public void setNotes(String argNotes) {
/* 199 */     if (changed(argNotes, this._notes, "notes")) {
/* 200 */       this._notes = argNotes;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReferenceNumber() {
/* 205 */     return this._referenceNumber;
/*     */   }
/*     */   
/*     */   public void setReferenceNumber(String argReferenceNumber) {
/* 209 */     if (changed(argReferenceNumber, this._referenceNumber, "referenceNumber")) {
/* 210 */       this._referenceNumber = argReferenceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAdditionalFreightCharges() {
/* 215 */     return this._additionalFreightCharges;
/*     */   }
/*     */   
/*     */   public void setAdditionalFreightCharges(BigDecimal argAdditionalFreightCharges) {
/* 219 */     if (changed(argAdditionalFreightCharges, this._additionalFreightCharges, "additionalFreightCharges")) {
/* 220 */       this._additionalFreightCharges = argAdditionalFreightCharges;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAdditionalCharges() {
/* 225 */     return this._additionalCharges;
/*     */   }
/*     */   
/*     */   public void setAdditionalCharges(BigDecimal argAdditionalCharges) {
/* 229 */     if (changed(argAdditionalCharges, this._additionalCharges, "additionalCharges")) {
/* 230 */       this._additionalCharges = argAdditionalCharges;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getShipComplete() {
/* 235 */     return this._shipComplete;
/*     */   }
/*     */   
/*     */   public void setShipComplete(Boolean argShipComplete) {
/* 239 */     if (changed(argShipComplete, this._shipComplete, "shipComplete")) {
/* 240 */       this._shipComplete = argShipComplete;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getFreightTax() {
/* 245 */     return this._freightTax;
/*     */   }
/*     */   
/*     */   public void setFreightTax(BigDecimal argFreightTax) {
/* 249 */     if (changed(argFreightTax, this._freightTax, "freightTax")) {
/* 250 */       this._freightTax = argFreightTax;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrderMessage() {
/* 255 */     return this._orderMessage;
/*     */   }
/*     */   
/*     */   public void setOrderMessage(String argOrderMessage) {
/* 259 */     if (changed(argOrderMessage, this._orderMessage, "orderMessage")) {
/* 260 */       this._orderMessage = argOrderMessage;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getGiftMessage() {
/* 265 */     return this._giftMessage;
/*     */   }
/*     */   
/*     */   public void setGiftMessage(String argGiftMessage) {
/* 269 */     if (changed(argGiftMessage, this._giftMessage, "giftMessage")) {
/* 270 */       this._giftMessage = argGiftMessage;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getUnderReview() {
/* 275 */     return this._underReview;
/*     */   }
/*     */   
/*     */   public void setUnderReview(Boolean argUnderReview) {
/* 279 */     if (changed(argUnderReview, this._underReview, "underReview")) {
/* 280 */       this._underReview = argUnderReview;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStatusCodeReason() {
/* 285 */     return this._statusCodeReason;
/*     */   }
/*     */   
/*     */   public void setStatusCodeReason(String argStatusCodeReason) {
/* 289 */     if (changed(argStatusCodeReason, this._statusCodeReason, "statusCodeReason")) {
/* 290 */       this._statusCodeReason = argStatusCodeReason;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStatusCodeReasonNote() {
/* 295 */     return this._statusCodeReasonNote;
/*     */   }
/*     */   
/*     */   public void setStatusCodeReasonNote(String argStatusCodeReasonNote) {
/* 299 */     if (changed(argStatusCodeReasonNote, this._statusCodeReasonNote, "statusCodeReasonNote")) {
/* 300 */       this._statusCodeReasonNote = argStatusCodeReasonNote;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 307 */     StringBuilder buf = new StringBuilder(512);
/* 308 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 309 */     if (getOrganizationId() != null) {
/* 310 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 312 */     if (getOrderId() != null) {
/* 313 */       buf.append("orderId").append("=").append(getOrderId()).append(" ");
/*     */     }
/* 315 */     if (getCreateDate() != null) {
/* 316 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 318 */     if (getCreateUserId() != null) {
/* 319 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 321 */     if (getUpdateDate() != null) {
/* 322 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 324 */     if (getUpdateUserId() != null) {
/* 325 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 327 */     if (getOrderType() != null) {
/* 328 */       buf.append("orderType").append("=").append(getOrderType()).append(" ");
/*     */     }
/* 330 */     if (getStatusCode() != null) {
/* 331 */       buf.append("statusCode").append("=").append(getStatusCode()).append(" ");
/*     */     }
/* 333 */     if (getOrderDate() != null) {
/* 334 */       buf.append("orderDate").append("=").append(getOrderDate()).append(" ");
/*     */     }
/* 336 */     if (getOrderLocationId() != null) {
/* 337 */       buf.append("orderLocationId").append("=").append(getOrderLocationId()).append(" ");
/*     */     }
/* 339 */     if (getSubtotal() != null) {
/* 340 */       buf.append("subtotal").append("=").append(getSubtotal()).append(" ");
/*     */     }
/* 342 */     if (getTaxAmount() != null) {
/* 343 */       buf.append("taxAmount").append("=").append(getTaxAmount()).append(" ");
/*     */     }
/* 345 */     if (getTotal() != null) {
/* 346 */       buf.append("total").append("=").append(getTotal()).append(" ");
/*     */     }
/* 348 */     if (getBalanceDue() != null) {
/* 349 */       buf.append("balanceDue").append("=").append(getBalanceDue()).append(" ");
/*     */     }
/* 351 */     if (getNotes() != null) {
/* 352 */       buf.append("notes").append("=").append(getNotes()).append(" ");
/*     */     }
/* 354 */     if (getReferenceNumber() != null) {
/* 355 */       buf.append("referenceNumber").append("=").append(getReferenceNumber()).append(" ");
/*     */     }
/* 357 */     if (getAdditionalFreightCharges() != null) {
/* 358 */       buf.append("additionalFreightCharges").append("=").append(getAdditionalFreightCharges()).append(" ");
/*     */     }
/* 360 */     if (getAdditionalCharges() != null) {
/* 361 */       buf.append("additionalCharges").append("=").append(getAdditionalCharges()).append(" ");
/*     */     }
/* 363 */     if (getShipComplete() != null && getShipComplete().booleanValue()) {
/* 364 */       buf.append("shipComplete").append("=").append(getShipComplete()).append(" ");
/*     */     }
/* 366 */     if (getFreightTax() != null) {
/* 367 */       buf.append("freightTax").append("=").append(getFreightTax()).append(" ");
/*     */     }
/* 369 */     if (getOrderMessage() != null) {
/* 370 */       buf.append("orderMessage").append("=").append(getOrderMessage()).append(" ");
/*     */     }
/* 372 */     if (getGiftMessage() != null) {
/* 373 */       buf.append("giftMessage").append("=").append(getGiftMessage()).append(" ");
/*     */     }
/* 375 */     if (getUnderReview() != null && getUnderReview().booleanValue()) {
/* 376 */       buf.append("underReview").append("=").append(getUnderReview()).append(" ");
/*     */     }
/* 378 */     if (getStatusCodeReason() != null) {
/* 379 */       buf.append("statusCodeReason").append("=").append(getStatusCodeReason()).append(" ");
/*     */     }
/* 381 */     if (getStatusCodeReasonNote() != null) {
/* 382 */       buf.append("statusCodeReasonNote").append("=").append(getStatusCodeReasonNote()).append(" ");
/*     */     }
/*     */     
/* 385 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 389 */     OrderId id = new OrderId();
/* 390 */     id.setOrganizationId(getOrganizationId());
/* 391 */     id.setOrderId(getOrderId());
/* 392 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 396 */     setOrganizationId(((OrderId)argObjectId).getOrganizationId());
/* 397 */     setOrderId(((OrderId)argObjectId).getOrderId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 401 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 405 */     StringBuilder buf = new StringBuilder(1250);
/* 406 */     buf.append("<").append("dao").append(" name=\"Order\" cmd=\"" + getObjectStateString() + "\">");
/* 407 */     getFieldsAsXml(buf);
/* 408 */     buf.append("</").append("dao").append(">");
/*     */     
/* 410 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 414 */     Map<String, String> values = super.getValues();
/* 415 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 416 */     if (this._orderId != null) values.put("OrderId", DaoUtils.getXmlSafeFieldValue(12, this._orderId)); 
/* 417 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 418 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 419 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 420 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 421 */     if (this._orderType != null) values.put("OrderType", DaoUtils.getXmlSafeFieldValue(12, this._orderType)); 
/* 422 */     if (this._statusCode != null) values.put("StatusCode", DaoUtils.getXmlSafeFieldValue(12, this._statusCode)); 
/* 423 */     if (this._orderDate != null) values.put("OrderDate", DaoUtils.getXmlSafeFieldValue(91, this._orderDate)); 
/* 424 */     if (this._orderLocationId != null) values.put("OrderLocationId", DaoUtils.getXmlSafeFieldValue(12, this._orderLocationId)); 
/* 425 */     if (this._subtotal != null) values.put("Subtotal", DaoUtils.getXmlSafeFieldValue(3, this._subtotal)); 
/* 426 */     if (this._taxAmount != null) values.put("TaxAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxAmount)); 
/* 427 */     if (this._total != null) values.put("Total", DaoUtils.getXmlSafeFieldValue(3, this._total)); 
/* 428 */     if (this._balanceDue != null) values.put("BalanceDue", DaoUtils.getXmlSafeFieldValue(3, this._balanceDue)); 
/* 429 */     if (this._notes != null) values.put("Notes", DaoUtils.getXmlSafeFieldValue(12, this._notes)); 
/* 430 */     if (this._referenceNumber != null) values.put("ReferenceNumber", DaoUtils.getXmlSafeFieldValue(12, this._referenceNumber)); 
/* 431 */     if (this._additionalFreightCharges != null) values.put("AdditionalFreightCharges", DaoUtils.getXmlSafeFieldValue(3, this._additionalFreightCharges)); 
/* 432 */     if (this._additionalCharges != null) values.put("AdditionalCharges", DaoUtils.getXmlSafeFieldValue(3, this._additionalCharges)); 
/* 433 */     if (this._shipComplete != null) values.put("ShipComplete", DaoUtils.getXmlSafeFieldValue(-7, this._shipComplete)); 
/* 434 */     if (this._freightTax != null) values.put("FreightTax", DaoUtils.getXmlSafeFieldValue(3, this._freightTax)); 
/* 435 */     if (this._orderMessage != null) values.put("OrderMessage", DaoUtils.getXmlSafeFieldValue(12, this._orderMessage)); 
/* 436 */     if (this._giftMessage != null) values.put("GiftMessage", DaoUtils.getXmlSafeFieldValue(12, this._giftMessage)); 
/* 437 */     if (this._underReview != null) values.put("UnderReview", DaoUtils.getXmlSafeFieldValue(-7, this._underReview)); 
/* 438 */     if (this._statusCodeReason != null) values.put("StatusCodeReason", DaoUtils.getXmlSafeFieldValue(12, this._statusCodeReason)); 
/* 439 */     if (this._statusCodeReasonNote != null) values.put("StatusCodeReasonNote", DaoUtils.getXmlSafeFieldValue(12, this._statusCodeReasonNote)); 
/* 440 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 445 */     super.setValues(argValues);
/* 446 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 448 */       String fieldName = field.getKey();
/* 449 */       String fieldValue = field.getValue();
/* 450 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 454 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 455 */             setOrganizationId((Long)value);
/* 456 */           } catch (Exception ee) {
/* 457 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrderId":
/*     */           try {
/* 463 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 464 */             setOrderId((String)value);
/* 465 */           } catch (Exception ee) {
/* 466 */             throw new DtxException("An exception occurred while calling setOrderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 472 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 473 */             setCreateDate((Date)value);
/* 474 */           } catch (Exception ee) {
/* 475 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 481 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 482 */             setCreateUserId((String)value);
/* 483 */           } catch (Exception ee) {
/* 484 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 490 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 491 */             setUpdateDate((Date)value);
/* 492 */           } catch (Exception ee) {
/* 493 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 499 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 500 */             setUpdateUserId((String)value);
/* 501 */           } catch (Exception ee) {
/* 502 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrderType":
/*     */           try {
/* 508 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 509 */             setOrderType((String)value);
/* 510 */           } catch (Exception ee) {
/* 511 */             throw new DtxException("An exception occurred while calling setOrderType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusCode":
/*     */           try {
/* 517 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 518 */             setStatusCode((String)value);
/* 519 */           } catch (Exception ee) {
/* 520 */             throw new DtxException("An exception occurred while calling setStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrderDate":
/*     */           try {
/* 526 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 527 */             setOrderDate((Date)value);
/* 528 */           } catch (Exception ee) {
/* 529 */             throw new DtxException("An exception occurred while calling setOrderDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrderLocationId":
/*     */           try {
/* 535 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 536 */             setOrderLocationId((String)value);
/* 537 */           } catch (Exception ee) {
/* 538 */             throw new DtxException("An exception occurred while calling setOrderLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Subtotal":
/*     */           try {
/* 544 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 545 */             setSubtotal((BigDecimal)value);
/* 546 */           } catch (Exception ee) {
/* 547 */             throw new DtxException("An exception occurred while calling setSubtotal() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxAmount":
/*     */           try {
/* 553 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 554 */             setTaxAmount((BigDecimal)value);
/* 555 */           } catch (Exception ee) {
/* 556 */             throw new DtxException("An exception occurred while calling setTaxAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Total":
/*     */           try {
/* 562 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 563 */             setTotal((BigDecimal)value);
/* 564 */           } catch (Exception ee) {
/* 565 */             throw new DtxException("An exception occurred while calling setTotal() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BalanceDue":
/*     */           try {
/* 571 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 572 */             setBalanceDue((BigDecimal)value);
/* 573 */           } catch (Exception ee) {
/* 574 */             throw new DtxException("An exception occurred while calling setBalanceDue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Notes":
/*     */           try {
/* 580 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 581 */             setNotes((String)value);
/* 582 */           } catch (Exception ee) {
/* 583 */             throw new DtxException("An exception occurred while calling setNotes() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReferenceNumber":
/*     */           try {
/* 589 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 590 */             setReferenceNumber((String)value);
/* 591 */           } catch (Exception ee) {
/* 592 */             throw new DtxException("An exception occurred while calling setReferenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AdditionalFreightCharges":
/*     */           try {
/* 598 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 599 */             setAdditionalFreightCharges((BigDecimal)value);
/* 600 */           } catch (Exception ee) {
/* 601 */             throw new DtxException("An exception occurred while calling setAdditionalFreightCharges() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AdditionalCharges":
/*     */           try {
/* 607 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 608 */             setAdditionalCharges((BigDecimal)value);
/* 609 */           } catch (Exception ee) {
/* 610 */             throw new DtxException("An exception occurred while calling setAdditionalCharges() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipComplete":
/*     */           try {
/* 616 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 617 */             setShipComplete((Boolean)value);
/* 618 */           } catch (Exception ee) {
/* 619 */             throw new DtxException("An exception occurred while calling setShipComplete() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FreightTax":
/*     */           try {
/* 625 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 626 */             setFreightTax((BigDecimal)value);
/* 627 */           } catch (Exception ee) {
/* 628 */             throw new DtxException("An exception occurred while calling setFreightTax() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrderMessage":
/*     */           try {
/* 634 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 635 */             setOrderMessage((String)value);
/* 636 */           } catch (Exception ee) {
/* 637 */             throw new DtxException("An exception occurred while calling setOrderMessage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "GiftMessage":
/*     */           try {
/* 643 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 644 */             setGiftMessage((String)value);
/* 645 */           } catch (Exception ee) {
/* 646 */             throw new DtxException("An exception occurred while calling setGiftMessage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UnderReview":
/*     */           try {
/* 652 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 653 */             setUnderReview((Boolean)value);
/* 654 */           } catch (Exception ee) {
/* 655 */             throw new DtxException("An exception occurred while calling setUnderReview() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusCodeReason":
/*     */           try {
/* 661 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 662 */             setStatusCodeReason((String)value);
/* 663 */           } catch (Exception ee) {
/* 664 */             throw new DtxException("An exception occurred while calling setStatusCodeReason() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusCodeReasonNote":
/*     */           try {
/* 670 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 671 */             setStatusCodeReasonNote((String)value);
/* 672 */           } catch (Exception ee) {
/* 673 */             throw new DtxException("An exception occurred while calling setStatusCodeReasonNote() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\OrderDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */