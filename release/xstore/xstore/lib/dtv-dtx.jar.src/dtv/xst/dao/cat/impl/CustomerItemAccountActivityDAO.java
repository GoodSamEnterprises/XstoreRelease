/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerItemAccountActivityId;
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
/*     */ public class CustomerItemAccountActivityDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 570978283L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerItemAccountActivityDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Long _custAccountDetailNum;
/*     */   private Long _sequenceNumber;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _extendedAmount;
/*     */   private DtvDate _activityDateTime;
/*     */   private String _activityCode;
/*     */   private String _accountLineItemStateCode;
/*     */   private String _typeCode;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _transSequence;
/*     */   private Long _transLineItemSeq;
/*     */   private BigDecimal _netAmount;
/*     */   private BigDecimal _unitPrice;
/*     */   private BigDecimal _quantity;
/*     */   private DtvDate _scheduledPickupDate;
/*     */   
/*     */   public Long getOrganizationId() {
/*  50 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  54 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  55 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountId() {
/*  60 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  64 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/*  65 */       this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  70 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  74 */     if (changed(argCustAccountCode, this._custAccountCode, "custAccountCode")) {
/*  75 */       this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCustAccountDetailNum() {
/*  80 */     return this._custAccountDetailNum;
/*     */   }
/*     */   
/*     */   public void setCustAccountDetailNum(Long argCustAccountDetailNum) {
/*  84 */     if (changed(argCustAccountDetailNum, this._custAccountDetailNum, "custAccountDetailNum")) {
/*  85 */       this._custAccountDetailNum = argCustAccountDetailNum;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getSequenceNumber() {
/*  90 */     return this._sequenceNumber;
/*     */   }
/*     */   
/*     */   public void setSequenceNumber(Long argSequenceNumber) {
/*  94 */     if (changed(argSequenceNumber, this._sequenceNumber, "sequenceNumber")) {
/*  95 */       this._sequenceNumber = argSequenceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 100 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 104 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 105 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 111 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 115 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 116 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 121 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 125 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 126 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 132 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 136 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 137 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getExtendedAmount() {
/* 142 */     return this._extendedAmount;
/*     */   }
/*     */   
/*     */   public void setExtendedAmount(BigDecimal argExtendedAmount) {
/* 146 */     if (changed(argExtendedAmount, this._extendedAmount, "extendedAmount")) {
/* 147 */       this._extendedAmount = argExtendedAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getActivityDateTime() {
/* 152 */     return (Date)this._activityDateTime;
/*     */   }
/*     */   
/*     */   public void setActivityDateTime(Date argActivityDateTime) {
/* 156 */     if (changed(argActivityDateTime, this._activityDateTime, "activityDateTime")) {
/* 157 */       this._activityDateTime = (argActivityDateTime == null || argActivityDateTime instanceof DtvDate) ? (DtvDate)argActivityDateTime : new DtvDate(argActivityDateTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getActivityCode() {
/* 163 */     return this._activityCode;
/*     */   }
/*     */   
/*     */   public void setActivityCode(String argActivityCode) {
/* 167 */     if (changed(argActivityCode, this._activityCode, "activityCode")) {
/* 168 */       this._activityCode = argActivityCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountLineItemStateCode() {
/* 173 */     return this._accountLineItemStateCode;
/*     */   }
/*     */   
/*     */   public void setAccountLineItemStateCode(String argAccountLineItemStateCode) {
/* 177 */     if (changed(argAccountLineItemStateCode, this._accountLineItemStateCode, "accountLineItemStateCode")) {
/* 178 */       this._accountLineItemStateCode = argAccountLineItemStateCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTypeCode() {
/* 183 */     return this._typeCode;
/*     */   }
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 187 */     if (changed(argTypeCode, this._typeCode, "typeCode")) {
/* 188 */       this._typeCode = argTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/* 193 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 197 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/* 198 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 203 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 207 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 208 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/* 213 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 217 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/* 218 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransSequence() {
/* 224 */     return this._transSequence;
/*     */   }
/*     */   
/*     */   public void setTransSequence(Long argTransSequence) {
/* 228 */     if (changed(argTransSequence, this._transSequence, "transSequence")) {
/* 229 */       this._transSequence = argTransSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransLineItemSeq() {
/* 234 */     return this._transLineItemSeq;
/*     */   }
/*     */   
/*     */   public void setTransLineItemSeq(Long argTransLineItemSeq) {
/* 238 */     if (changed(argTransLineItemSeq, this._transLineItemSeq, "transLineItemSeq")) {
/* 239 */       this._transLineItemSeq = argTransLineItemSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getNetAmount() {
/* 244 */     return this._netAmount;
/*     */   }
/*     */   
/*     */   public void setNetAmount(BigDecimal argNetAmount) {
/* 248 */     if (changed(argNetAmount, this._netAmount, "netAmount")) {
/* 249 */       this._netAmount = argNetAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getUnitPrice() {
/* 254 */     return this._unitPrice;
/*     */   }
/*     */   
/*     */   public void setUnitPrice(BigDecimal argUnitPrice) {
/* 258 */     if (changed(argUnitPrice, this._unitPrice, "unitPrice")) {
/* 259 */       this._unitPrice = argUnitPrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getQuantity() {
/* 264 */     return this._quantity;
/*     */   }
/*     */   
/*     */   public void setQuantity(BigDecimal argQuantity) {
/* 268 */     if (changed(argQuantity, this._quantity, "quantity")) {
/* 269 */       this._quantity = argQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getScheduledPickupDate() {
/* 274 */     return (Date)this._scheduledPickupDate;
/*     */   }
/*     */   
/*     */   public void setScheduledPickupDate(Date argScheduledPickupDate) {
/* 278 */     if (changed(argScheduledPickupDate, this._scheduledPickupDate, "scheduledPickupDate")) {
/* 279 */       this._scheduledPickupDate = (argScheduledPickupDate == null || argScheduledPickupDate instanceof DtvDate) ? (DtvDate)argScheduledPickupDate : new DtvDate(argScheduledPickupDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 287 */     StringBuilder buf = new StringBuilder(512);
/* 288 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 289 */     if (getOrganizationId() != null) {
/* 290 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 292 */     if (getCustAccountId() != null) {
/* 293 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/* 295 */     if (getCustAccountCode() != null) {
/* 296 */       buf.append("custAccountCode").append("=").append(getCustAccountCode()).append(" ");
/*     */     }
/* 298 */     if (getCustAccountDetailNum() != null) {
/* 299 */       buf.append("custAccountDetailNum").append("=").append(getCustAccountDetailNum()).append(" ");
/*     */     }
/* 301 */     if (getSequenceNumber() != null) {
/* 302 */       buf.append("sequenceNumber").append("=").append(getSequenceNumber()).append(" ");
/*     */     }
/* 304 */     if (getCreateDate() != null) {
/* 305 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 307 */     if (getCreateUserId() != null) {
/* 308 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 310 */     if (getUpdateDate() != null) {
/* 311 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 313 */     if (getUpdateUserId() != null) {
/* 314 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 316 */     if (getExtendedAmount() != null) {
/* 317 */       buf.append("extendedAmount").append("=").append(getExtendedAmount()).append(" ");
/*     */     }
/* 319 */     if (getActivityDateTime() != null) {
/* 320 */       buf.append("activityDateTime").append("=").append(getActivityDateTime()).append(" ");
/*     */     }
/* 322 */     if (getActivityCode() != null) {
/* 323 */       buf.append("activityCode").append("=").append(getActivityCode()).append(" ");
/*     */     }
/* 325 */     if (getAccountLineItemStateCode() != null) {
/* 326 */       buf.append("accountLineItemStateCode").append("=").append(getAccountLineItemStateCode()).append(" ");
/*     */     }
/* 328 */     if (getTypeCode() != null) {
/* 329 */       buf.append("typeCode").append("=").append(getTypeCode()).append(" ");
/*     */     }
/* 331 */     if (getRetailLocationId() != null) {
/* 332 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 334 */     if (getWorkstationId() != null) {
/* 335 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 337 */     if (getBusinessDate() != null) {
/* 338 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 340 */     if (getTransSequence() != null) {
/* 341 */       buf.append("transSequence").append("=").append(getTransSequence()).append(" ");
/*     */     }
/* 343 */     if (getTransLineItemSeq() != null) {
/* 344 */       buf.append("transLineItemSeq").append("=").append(getTransLineItemSeq()).append(" ");
/*     */     }
/* 346 */     if (getNetAmount() != null) {
/* 347 */       buf.append("netAmount").append("=").append(getNetAmount()).append(" ");
/*     */     }
/* 349 */     if (getUnitPrice() != null) {
/* 350 */       buf.append("unitPrice").append("=").append(getUnitPrice()).append(" ");
/*     */     }
/* 352 */     if (getQuantity() != null) {
/* 353 */       buf.append("quantity").append("=").append(getQuantity()).append(" ");
/*     */     }
/* 355 */     if (getScheduledPickupDate() != null) {
/* 356 */       buf.append("scheduledPickupDate").append("=").append(getScheduledPickupDate()).append(" ");
/*     */     }
/*     */     
/* 359 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 363 */     CustomerItemAccountActivityId id = new CustomerItemAccountActivityId();
/* 364 */     id.setOrganizationId(getOrganizationId());
/* 365 */     id.setCustAccountId(getCustAccountId());
/* 366 */     id.setCustAccountCode(getCustAccountCode());
/* 367 */     id.setCustAccountDetailNum(getCustAccountDetailNum());
/* 368 */     id.setSequenceNumber(getSequenceNumber());
/* 369 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 373 */     setOrganizationId(((CustomerItemAccountActivityId)argObjectId).getOrganizationId());
/* 374 */     setCustAccountId(((CustomerItemAccountActivityId)argObjectId).getCustAccountId());
/* 375 */     setCustAccountCode(((CustomerItemAccountActivityId)argObjectId).getCustAccountCode());
/* 376 */     setCustAccountDetailNum(((CustomerItemAccountActivityId)argObjectId).getCustAccountDetailNum());
/* 377 */     setSequenceNumber(((CustomerItemAccountActivityId)argObjectId).getSequenceNumber());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 381 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 385 */     StringBuilder buf = new StringBuilder(1150);
/* 386 */     buf.append("<").append("dao").append(" name=\"CustomerItemAccountActivity\" cmd=\"" + getObjectStateString() + "\">");
/* 387 */     getFieldsAsXml(buf);
/* 388 */     buf.append("</").append("dao").append(">");
/*     */     
/* 390 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 394 */     Map<String, String> values = super.getValues();
/* 395 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 396 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 397 */     if (this._custAccountCode != null) values.put("CustAccountCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountCode)); 
/* 398 */     if (this._custAccountDetailNum != null) values.put("CustAccountDetailNum", DaoUtils.getXmlSafeFieldValue(-5, this._custAccountDetailNum)); 
/* 399 */     if (this._sequenceNumber != null) values.put("SequenceNumber", DaoUtils.getXmlSafeFieldValue(-5, this._sequenceNumber)); 
/* 400 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 401 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 402 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 403 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 404 */     if (this._extendedAmount != null) values.put("ExtendedAmount", DaoUtils.getXmlSafeFieldValue(3, this._extendedAmount)); 
/* 405 */     if (this._activityDateTime != null) values.put("ActivityDateTime", DaoUtils.getXmlSafeFieldValue(91, this._activityDateTime)); 
/* 406 */     if (this._activityCode != null) values.put("ActivityCode", DaoUtils.getXmlSafeFieldValue(12, this._activityCode)); 
/* 407 */     if (this._accountLineItemStateCode != null) values.put("AccountLineItemStateCode", DaoUtils.getXmlSafeFieldValue(12, this._accountLineItemStateCode)); 
/* 408 */     if (this._typeCode != null) values.put("TypeCode", DaoUtils.getXmlSafeFieldValue(12, this._typeCode)); 
/* 409 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 410 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 411 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 412 */     if (this._transSequence != null) values.put("TransSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transSequence)); 
/* 413 */     if (this._transLineItemSeq != null) values.put("TransLineItemSeq", DaoUtils.getXmlSafeFieldValue(-5, this._transLineItemSeq)); 
/* 414 */     if (this._netAmount != null) values.put("NetAmount", DaoUtils.getXmlSafeFieldValue(3, this._netAmount)); 
/* 415 */     if (this._unitPrice != null) values.put("UnitPrice", DaoUtils.getXmlSafeFieldValue(3, this._unitPrice)); 
/* 416 */     if (this._quantity != null) values.put("Quantity", DaoUtils.getXmlSafeFieldValue(3, this._quantity)); 
/* 417 */     if (this._scheduledPickupDate != null) values.put("ScheduledPickupDate", DaoUtils.getXmlSafeFieldValue(91, this._scheduledPickupDate)); 
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
/*     */         case "OrganizationId":
/*     */           try {
/* 432 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 433 */             setOrganizationId((Long)value);
/* 434 */           } catch (Exception ee) {
/* 435 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountId":
/*     */           try {
/* 441 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 442 */             setCustAccountId((String)value);
/* 443 */           } catch (Exception ee) {
/* 444 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountCode":
/*     */           try {
/* 450 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 451 */             setCustAccountCode((String)value);
/* 452 */           } catch (Exception ee) {
/* 453 */             throw new DtxException("An exception occurred while calling setCustAccountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountDetailNum":
/*     */           try {
/* 459 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 460 */             setCustAccountDetailNum((Long)value);
/* 461 */           } catch (Exception ee) {
/* 462 */             throw new DtxException("An exception occurred while calling setCustAccountDetailNum() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SequenceNumber":
/*     */           try {
/* 468 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 469 */             setSequenceNumber((Long)value);
/* 470 */           } catch (Exception ee) {
/* 471 */             throw new DtxException("An exception occurred while calling setSequenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 477 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 478 */             setCreateDate((Date)value);
/* 479 */           } catch (Exception ee) {
/* 480 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 486 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 487 */             setCreateUserId((String)value);
/* 488 */           } catch (Exception ee) {
/* 489 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 495 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 496 */             setUpdateDate((Date)value);
/* 497 */           } catch (Exception ee) {
/* 498 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 504 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 505 */             setUpdateUserId((String)value);
/* 506 */           } catch (Exception ee) {
/* 507 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExtendedAmount":
/*     */           try {
/* 513 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 514 */             setExtendedAmount((BigDecimal)value);
/* 515 */           } catch (Exception ee) {
/* 516 */             throw new DtxException("An exception occurred while calling setExtendedAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActivityDateTime":
/*     */           try {
/* 522 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 523 */             setActivityDateTime((Date)value);
/* 524 */           } catch (Exception ee) {
/* 525 */             throw new DtxException("An exception occurred while calling setActivityDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActivityCode":
/*     */           try {
/* 531 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 532 */             setActivityCode((String)value);
/* 533 */           } catch (Exception ee) {
/* 534 */             throw new DtxException("An exception occurred while calling setActivityCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountLineItemStateCode":
/*     */           try {
/* 540 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 541 */             setAccountLineItemStateCode((String)value);
/* 542 */           } catch (Exception ee) {
/* 543 */             throw new DtxException("An exception occurred while calling setAccountLineItemStateCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TypeCode":
/*     */           try {
/* 549 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 550 */             setTypeCode((String)value);
/* 551 */           } catch (Exception ee) {
/* 552 */             throw new DtxException("An exception occurred while calling setTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 558 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 559 */             setRetailLocationId((Long)value);
/* 560 */           } catch (Exception ee) {
/* 561 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 567 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 568 */             setWorkstationId((Long)value);
/* 569 */           } catch (Exception ee) {
/* 570 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 576 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 577 */             setBusinessDate((Date)value);
/* 578 */           } catch (Exception ee) {
/* 579 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransSequence":
/*     */           try {
/* 585 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 586 */             setTransSequence((Long)value);
/* 587 */           } catch (Exception ee) {
/* 588 */             throw new DtxException("An exception occurred while calling setTransSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransLineItemSeq":
/*     */           try {
/* 594 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 595 */             setTransLineItemSeq((Long)value);
/* 596 */           } catch (Exception ee) {
/* 597 */             throw new DtxException("An exception occurred while calling setTransLineItemSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NetAmount":
/*     */           try {
/* 603 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 604 */             setNetAmount((BigDecimal)value);
/* 605 */           } catch (Exception ee) {
/* 606 */             throw new DtxException("An exception occurred while calling setNetAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UnitPrice":
/*     */           try {
/* 612 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 613 */             setUnitPrice((BigDecimal)value);
/* 614 */           } catch (Exception ee) {
/* 615 */             throw new DtxException("An exception occurred while calling setUnitPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Quantity":
/*     */           try {
/* 621 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 622 */             setQuantity((BigDecimal)value);
/* 623 */           } catch (Exception ee) {
/* 624 */             throw new DtxException("An exception occurred while calling setQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ScheduledPickupDate":
/*     */           try {
/* 630 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 631 */             setScheduledPickupDate((Date)value);
/* 632 */           } catch (Exception ee) {
/* 633 */             throw new DtxException("An exception occurred while calling setScheduledPickupDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerItemAccountActivityDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */