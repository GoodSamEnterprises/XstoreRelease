/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerItemAccountDetailId;
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
/*     */ public class CustomerItemAccountDetailDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -2003297235L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerItemAccountDetailDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Long _custAccountDetailNum;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _extendedAmount;
/*     */   private String _stateCode;
/*     */   private String _typeCode;
/*     */   private DtvDate _origItemAddDate;
/*     */   private DtvDate _scheduledPickupDate;
/*     */   private DtvDate _businessDate;
/*     */   private Long _retailLocationId;
/*     */   private Long _sourceLocationId;
/*     */   private String _deliveryType;
/*     */   private Long _fullfillmentLocationId;
/*     */   private DtvDate _receivedByCustDate;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private BigDecimal _netAmount;
/*     */   private BigDecimal _unitPrice;
/*     */   private BigDecimal _quantity;
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
/*     */   public String getCustAccountId() {
/*  62 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  66 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/*  67 */       this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  72 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  76 */     if (changed(argCustAccountCode, this._custAccountCode, "custAccountCode")) {
/*  77 */       this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCustAccountDetailNum() {
/*  82 */     return this._custAccountDetailNum;
/*     */   }
/*     */   
/*     */   public void setCustAccountDetailNum(Long argCustAccountDetailNum) {
/*  86 */     if (changed(argCustAccountDetailNum, this._custAccountDetailNum, "custAccountDetailNum")) {
/*  87 */       this._custAccountDetailNum = argCustAccountDetailNum;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  92 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  96 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  97 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 103 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 107 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 108 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 113 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 117 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 118 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 124 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 128 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 129 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getExtendedAmount() {
/* 134 */     return this._extendedAmount;
/*     */   }
/*     */   
/*     */   public void setExtendedAmount(BigDecimal argExtendedAmount) {
/* 138 */     if (changed(argExtendedAmount, this._extendedAmount, "extendedAmount")) {
/* 139 */       this._extendedAmount = argExtendedAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStateCode() {
/* 144 */     return this._stateCode;
/*     */   }
/*     */   
/*     */   public void setStateCode(String argStateCode) {
/* 148 */     if (changed(argStateCode, this._stateCode, "stateCode")) {
/* 149 */       this._stateCode = argStateCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTypeCode() {
/* 154 */     return this._typeCode;
/*     */   }
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 158 */     if (changed(argTypeCode, this._typeCode, "typeCode")) {
/* 159 */       this._typeCode = argTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getOrigItemAddDate() {
/* 164 */     return (Date)this._origItemAddDate;
/*     */   }
/*     */   
/*     */   public void setOrigItemAddDate(Date argOrigItemAddDate) {
/* 168 */     if (changed(argOrigItemAddDate, this._origItemAddDate, "origItemAddDate")) {
/* 169 */       this._origItemAddDate = (argOrigItemAddDate == null || argOrigItemAddDate instanceof DtvDate) ? (DtvDate)argOrigItemAddDate : new DtvDate(argOrigItemAddDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getScheduledPickupDate() {
/* 175 */     return (Date)this._scheduledPickupDate;
/*     */   }
/*     */   
/*     */   public void setScheduledPickupDate(Date argScheduledPickupDate) {
/* 179 */     if (changed(argScheduledPickupDate, this._scheduledPickupDate, "scheduledPickupDate")) {
/* 180 */       this._scheduledPickupDate = (argScheduledPickupDate == null || argScheduledPickupDate instanceof DtvDate) ? (DtvDate)argScheduledPickupDate : new DtvDate(argScheduledPickupDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 186 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 190 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/* 191 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/* 197 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 201 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/* 202 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getSourceLocationId() {
/* 207 */     return this._sourceLocationId;
/*     */   }
/*     */   
/*     */   public void setSourceLocationId(Long argSourceLocationId) {
/* 211 */     if (changed(argSourceLocationId, this._sourceLocationId, "sourceLocationId")) {
/* 212 */       this._sourceLocationId = argSourceLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDeliveryType() {
/* 217 */     return this._deliveryType;
/*     */   }
/*     */   
/*     */   public void setDeliveryType(String argDeliveryType) {
/* 221 */     if (changed(argDeliveryType, this._deliveryType, "deliveryType")) {
/* 222 */       this._deliveryType = argDeliveryType;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getFullfillmentLocationId() {
/* 227 */     return this._fullfillmentLocationId;
/*     */   }
/*     */   
/*     */   public void setFullfillmentLocationId(Long argFullfillmentLocationId) {
/* 231 */     if (changed(argFullfillmentLocationId, this._fullfillmentLocationId, "fullfillmentLocationId")) {
/* 232 */       this._fullfillmentLocationId = argFullfillmentLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getReceivedByCustDate() {
/* 237 */     return (Date)this._receivedByCustDate;
/*     */   }
/*     */   
/*     */   public void setReceivedByCustDate(Date argReceivedByCustDate) {
/* 241 */     if (changed(argReceivedByCustDate, this._receivedByCustDate, "receivedByCustDate")) {
/* 242 */       this._receivedByCustDate = (argReceivedByCustDate == null || argReceivedByCustDate instanceof DtvDate) ? (DtvDate)argReceivedByCustDate : new DtvDate(argReceivedByCustDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/* 248 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/* 252 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/* 253 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/* 258 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/* 262 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/* 263 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 268 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 272 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 273 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getNetAmount() {
/* 278 */     return this._netAmount;
/*     */   }
/*     */   
/*     */   public void setNetAmount(BigDecimal argNetAmount) {
/* 282 */     if (changed(argNetAmount, this._netAmount, "netAmount")) {
/* 283 */       this._netAmount = argNetAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getUnitPrice() {
/* 288 */     return this._unitPrice;
/*     */   }
/*     */   
/*     */   public void setUnitPrice(BigDecimal argUnitPrice) {
/* 292 */     if (changed(argUnitPrice, this._unitPrice, "unitPrice")) {
/* 293 */       this._unitPrice = argUnitPrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getQuantity() {
/* 298 */     return this._quantity;
/*     */   }
/*     */   
/*     */   public void setQuantity(BigDecimal argQuantity) {
/* 302 */     if (changed(argQuantity, this._quantity, "quantity")) {
/* 303 */       this._quantity = argQuantity;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 310 */     StringBuilder buf = new StringBuilder(512);
/* 311 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 312 */     if (getOrganizationId() != null) {
/* 313 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 315 */     if (getCustAccountId() != null) {
/* 316 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/* 318 */     if (getCustAccountCode() != null) {
/* 319 */       buf.append("custAccountCode").append("=").append(getCustAccountCode()).append(" ");
/*     */     }
/* 321 */     if (getCustAccountDetailNum() != null) {
/* 322 */       buf.append("custAccountDetailNum").append("=").append(getCustAccountDetailNum()).append(" ");
/*     */     }
/* 324 */     if (getCreateDate() != null) {
/* 325 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 327 */     if (getCreateUserId() != null) {
/* 328 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 330 */     if (getUpdateDate() != null) {
/* 331 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 333 */     if (getUpdateUserId() != null) {
/* 334 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 336 */     if (getExtendedAmount() != null) {
/* 337 */       buf.append("extendedAmount").append("=").append(getExtendedAmount()).append(" ");
/*     */     }
/* 339 */     if (getStateCode() != null) {
/* 340 */       buf.append("stateCode").append("=").append(getStateCode()).append(" ");
/*     */     }
/* 342 */     if (getTypeCode() != null) {
/* 343 */       buf.append("typeCode").append("=").append(getTypeCode()).append(" ");
/*     */     }
/* 345 */     if (getOrigItemAddDate() != null) {
/* 346 */       buf.append("origItemAddDate").append("=").append(getOrigItemAddDate()).append(" ");
/*     */     }
/* 348 */     if (getScheduledPickupDate() != null) {
/* 349 */       buf.append("scheduledPickupDate").append("=").append(getScheduledPickupDate()).append(" ");
/*     */     }
/* 351 */     if (getBusinessDate() != null) {
/* 352 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 354 */     if (getRetailLocationId() != null) {
/* 355 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 357 */     if (getSourceLocationId() != null) {
/* 358 */       buf.append("sourceLocationId").append("=").append(getSourceLocationId()).append(" ");
/*     */     }
/* 360 */     if (getDeliveryType() != null) {
/* 361 */       buf.append("deliveryType").append("=").append(getDeliveryType()).append(" ");
/*     */     }
/* 363 */     if (getFullfillmentLocationId() != null) {
/* 364 */       buf.append("fullfillmentLocationId").append("=").append(getFullfillmentLocationId()).append(" ");
/*     */     }
/* 366 */     if (getReceivedByCustDate() != null) {
/* 367 */       buf.append("receivedByCustDate").append("=").append(getReceivedByCustDate()).append(" ");
/*     */     }
/* 369 */     if (getRetailTransactionLineItemSequence() != null) {
/* 370 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 372 */     if (getTransactionSequence() != null) {
/* 373 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 375 */     if (getWorkstationId() != null) {
/* 376 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 378 */     if (getNetAmount() != null) {
/* 379 */       buf.append("netAmount").append("=").append(getNetAmount()).append(" ");
/*     */     }
/* 381 */     if (getUnitPrice() != null) {
/* 382 */       buf.append("unitPrice").append("=").append(getUnitPrice()).append(" ");
/*     */     }
/* 384 */     if (getQuantity() != null) {
/* 385 */       buf.append("quantity").append("=").append(getQuantity()).append(" ");
/*     */     }
/*     */     
/* 388 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 392 */     CustomerItemAccountDetailId id = new CustomerItemAccountDetailId();
/* 393 */     id.setOrganizationId(getOrganizationId());
/* 394 */     id.setCustAccountId(getCustAccountId());
/* 395 */     id.setCustAccountCode(getCustAccountCode());
/* 396 */     id.setCustAccountDetailNum(getCustAccountDetailNum());
/* 397 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 401 */     setOrganizationId(((CustomerItemAccountDetailId)argObjectId).getOrganizationId());
/* 402 */     setCustAccountId(((CustomerItemAccountDetailId)argObjectId).getCustAccountId());
/* 403 */     setCustAccountCode(((CustomerItemAccountDetailId)argObjectId).getCustAccountCode());
/* 404 */     setCustAccountDetailNum(((CustomerItemAccountDetailId)argObjectId).getCustAccountDetailNum());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 408 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 412 */     StringBuilder buf = new StringBuilder(1250);
/* 413 */     buf.append("<").append("dao").append(" name=\"CustomerItemAccountDetail\" cmd=\"" + getObjectStateString() + "\">");
/* 414 */     getFieldsAsXml(buf);
/* 415 */     buf.append("</").append("dao").append(">");
/*     */     
/* 417 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 421 */     Map<String, String> values = super.getValues();
/* 422 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 423 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 424 */     if (this._custAccountCode != null) values.put("CustAccountCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountCode)); 
/* 425 */     if (this._custAccountDetailNum != null) values.put("CustAccountDetailNum", DaoUtils.getXmlSafeFieldValue(-5, this._custAccountDetailNum)); 
/* 426 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 427 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 428 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 429 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 430 */     if (this._extendedAmount != null) values.put("ExtendedAmount", DaoUtils.getXmlSafeFieldValue(3, this._extendedAmount)); 
/* 431 */     if (this._stateCode != null) values.put("StateCode", DaoUtils.getXmlSafeFieldValue(12, this._stateCode)); 
/* 432 */     if (this._typeCode != null) values.put("TypeCode", DaoUtils.getXmlSafeFieldValue(12, this._typeCode)); 
/* 433 */     if (this._origItemAddDate != null) values.put("OrigItemAddDate", DaoUtils.getXmlSafeFieldValue(91, this._origItemAddDate)); 
/* 434 */     if (this._scheduledPickupDate != null) values.put("ScheduledPickupDate", DaoUtils.getXmlSafeFieldValue(91, this._scheduledPickupDate)); 
/* 435 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 436 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 437 */     if (this._sourceLocationId != null) values.put("SourceLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._sourceLocationId)); 
/* 438 */     if (this._deliveryType != null) values.put("DeliveryType", DaoUtils.getXmlSafeFieldValue(12, this._deliveryType)); 
/* 439 */     if (this._fullfillmentLocationId != null) values.put("FullfillmentLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._fullfillmentLocationId)); 
/* 440 */     if (this._receivedByCustDate != null) values.put("ReceivedByCustDate", DaoUtils.getXmlSafeFieldValue(91, this._receivedByCustDate)); 
/* 441 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 442 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 443 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 444 */     if (this._netAmount != null) values.put("NetAmount", DaoUtils.getXmlSafeFieldValue(3, this._netAmount)); 
/* 445 */     if (this._unitPrice != null) values.put("UnitPrice", DaoUtils.getXmlSafeFieldValue(3, this._unitPrice)); 
/* 446 */     if (this._quantity != null) values.put("Quantity", DaoUtils.getXmlSafeFieldValue(3, this._quantity)); 
/* 447 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 452 */     super.setValues(argValues);
/* 453 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 455 */       String fieldName = field.getKey();
/* 456 */       String fieldValue = field.getValue();
/* 457 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 461 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 462 */             setOrganizationId((Long)value);
/* 463 */           } catch (Exception ee) {
/* 464 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountId":
/*     */           try {
/* 470 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 471 */             setCustAccountId((String)value);
/* 472 */           } catch (Exception ee) {
/* 473 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountCode":
/*     */           try {
/* 479 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 480 */             setCustAccountCode((String)value);
/* 481 */           } catch (Exception ee) {
/* 482 */             throw new DtxException("An exception occurred while calling setCustAccountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountDetailNum":
/*     */           try {
/* 488 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 489 */             setCustAccountDetailNum((Long)value);
/* 490 */           } catch (Exception ee) {
/* 491 */             throw new DtxException("An exception occurred while calling setCustAccountDetailNum() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 497 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 498 */             setCreateDate((Date)value);
/* 499 */           } catch (Exception ee) {
/* 500 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 506 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 507 */             setCreateUserId((String)value);
/* 508 */           } catch (Exception ee) {
/* 509 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 515 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 516 */             setUpdateDate((Date)value);
/* 517 */           } catch (Exception ee) {
/* 518 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 524 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 525 */             setUpdateUserId((String)value);
/* 526 */           } catch (Exception ee) {
/* 527 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExtendedAmount":
/*     */           try {
/* 533 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 534 */             setExtendedAmount((BigDecimal)value);
/* 535 */           } catch (Exception ee) {
/* 536 */             throw new DtxException("An exception occurred while calling setExtendedAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StateCode":
/*     */           try {
/* 542 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 543 */             setStateCode((String)value);
/* 544 */           } catch (Exception ee) {
/* 545 */             throw new DtxException("An exception occurred while calling setStateCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TypeCode":
/*     */           try {
/* 551 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 552 */             setTypeCode((String)value);
/* 553 */           } catch (Exception ee) {
/* 554 */             throw new DtxException("An exception occurred while calling setTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrigItemAddDate":
/*     */           try {
/* 560 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 561 */             setOrigItemAddDate((Date)value);
/* 562 */           } catch (Exception ee) {
/* 563 */             throw new DtxException("An exception occurred while calling setOrigItemAddDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ScheduledPickupDate":
/*     */           try {
/* 569 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 570 */             setScheduledPickupDate((Date)value);
/* 571 */           } catch (Exception ee) {
/* 572 */             throw new DtxException("An exception occurred while calling setScheduledPickupDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 578 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 579 */             setBusinessDate((Date)value);
/* 580 */           } catch (Exception ee) {
/* 581 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 587 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 588 */             setRetailLocationId((Long)value);
/* 589 */           } catch (Exception ee) {
/* 590 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SourceLocationId":
/*     */           try {
/* 596 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 597 */             setSourceLocationId((Long)value);
/* 598 */           } catch (Exception ee) {
/* 599 */             throw new DtxException("An exception occurred while calling setSourceLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DeliveryType":
/*     */           try {
/* 605 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 606 */             setDeliveryType((String)value);
/* 607 */           } catch (Exception ee) {
/* 608 */             throw new DtxException("An exception occurred while calling setDeliveryType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FullfillmentLocationId":
/*     */           try {
/* 614 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 615 */             setFullfillmentLocationId((Long)value);
/* 616 */           } catch (Exception ee) {
/* 617 */             throw new DtxException("An exception occurred while calling setFullfillmentLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReceivedByCustDate":
/*     */           try {
/* 623 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 624 */             setReceivedByCustDate((Date)value);
/* 625 */           } catch (Exception ee) {
/* 626 */             throw new DtxException("An exception occurred while calling setReceivedByCustDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 632 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 633 */             setRetailTransactionLineItemSequence((Integer)value);
/* 634 */           } catch (Exception ee) {
/* 635 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 641 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 642 */             setTransactionSequence((Long)value);
/* 643 */           } catch (Exception ee) {
/* 644 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 650 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 651 */             setWorkstationId((Long)value);
/* 652 */           } catch (Exception ee) {
/* 653 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NetAmount":
/*     */           try {
/* 659 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 660 */             setNetAmount((BigDecimal)value);
/* 661 */           } catch (Exception ee) {
/* 662 */             throw new DtxException("An exception occurred while calling setNetAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "Quantity":
/*     */           try {
/* 677 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 678 */             setQuantity((BigDecimal)value);
/* 679 */           } catch (Exception ee) {
/* 680 */             throw new DtxException("An exception occurred while calling setQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerItemAccountDetailDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */