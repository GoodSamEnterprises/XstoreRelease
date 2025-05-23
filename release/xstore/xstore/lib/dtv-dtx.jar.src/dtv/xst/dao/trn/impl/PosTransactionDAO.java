/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractExtensibleDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.PosTransactionId;
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
/*     */ public class PosTransactionDAO
/*     */   extends AbstractExtensibleDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1475778570L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PosTransactionDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private String _className;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _beginDateTimestamp;
/*     */   private DtvDate _transactionDate;
/*     */   private Integer _beginTimeInt;
/*     */   private DtvDate _endDateTimestamp;
/*  39 */   private Boolean _keyedOffline = Boolean.FALSE;
/*  40 */   private Boolean _posted = Boolean.FALSE;
/*     */   private Long _sessionId;
/*     */   private BigDecimal _subtotal;
/*     */   private BigDecimal _taxAmount;
/*     */   private BigDecimal _roundedAmount;
/*     */   private BigDecimal _total;
/*     */   private String _transactionStatusCode;
/*     */   private String _transactionTypeCode;
/*     */   private String _transactionCancelledReasonCode;
/*  49 */   private Boolean _genericStorage = Boolean.FALSE;
/*     */   private Long _operatorPartyId;
/*  51 */   private Boolean _postVoid = Boolean.FALSE;
/*     */   private String _cashDrawerId;
/*     */   private String _fiscalNumber;
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
/*     */   public Long getRetailLocationId() {
/*  66 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  70 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  71 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  76 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  80 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  81 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/*  87 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  91 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  92 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  97 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/* 101 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/* 102 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getClassName() {
/* 107 */     return this._className;
/*     */   }
/*     */   
/*     */   public void setClassName(String argClassName) {
/* 111 */     if (changed(argClassName, this._className, "className")) {
/* 112 */       this._className = argClassName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 117 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 121 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 122 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 128 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 132 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 133 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 138 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 142 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 143 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 149 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 153 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 154 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBeginDateTimestamp() {
/* 159 */     return (Date)this._beginDateTimestamp;
/*     */   }
/*     */   
/*     */   public void setBeginDateTimestamp(Date argBeginDateTimestamp) {
/* 163 */     if (changed(argBeginDateTimestamp, this._beginDateTimestamp, "beginDateTimestamp")) {
/* 164 */       this._beginDateTimestamp = (argBeginDateTimestamp == null || argBeginDateTimestamp instanceof DtvDate) ? (DtvDate)argBeginDateTimestamp : new DtvDate(argBeginDateTimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getTransactionDate() {
/* 170 */     return (Date)this._transactionDate;
/*     */   }
/*     */   
/*     */   public void setTransactionDate(Date argTransactionDate) {
/* 174 */     if (changed(argTransactionDate, this._transactionDate, "transactionDate")) {
/* 175 */       this._transactionDate = (argTransactionDate == null || argTransactionDate instanceof DtvDate) ? (DtvDate)argTransactionDate : new DtvDate(argTransactionDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getBeginTimeInt() {
/* 181 */     return this._beginTimeInt;
/*     */   }
/*     */   
/*     */   public void setBeginTimeInt(Integer argBeginTimeInt) {
/* 185 */     if (changed(argBeginTimeInt, this._beginTimeInt, "beginTimeInt")) {
/* 186 */       this._beginTimeInt = argBeginTimeInt;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEndDateTimestamp() {
/* 191 */     return (Date)this._endDateTimestamp;
/*     */   }
/*     */   
/*     */   public void setEndDateTimestamp(Date argEndDateTimestamp) {
/* 195 */     if (changed(argEndDateTimestamp, this._endDateTimestamp, "endDateTimestamp")) {
/* 196 */       this._endDateTimestamp = (argEndDateTimestamp == null || argEndDateTimestamp instanceof DtvDate) ? (DtvDate)argEndDateTimestamp : new DtvDate(argEndDateTimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getKeyedOffline() {
/* 202 */     return this._keyedOffline;
/*     */   }
/*     */   
/*     */   public void setKeyedOffline(Boolean argKeyedOffline) {
/* 206 */     if (changed(argKeyedOffline, this._keyedOffline, "keyedOffline")) {
/* 207 */       this._keyedOffline = argKeyedOffline;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getPosted() {
/* 212 */     return this._posted;
/*     */   }
/*     */   
/*     */   public void setPosted(Boolean argPosted) {
/* 216 */     if (changed(argPosted, this._posted, "posted")) {
/* 217 */       this._posted = argPosted;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getSessionId() {
/* 222 */     return this._sessionId;
/*     */   }
/*     */   
/*     */   public void setSessionId(Long argSessionId) {
/* 226 */     if (changed(argSessionId, this._sessionId, "sessionId")) {
/* 227 */       this._sessionId = argSessionId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getSubtotal() {
/* 232 */     return this._subtotal;
/*     */   }
/*     */   
/*     */   public void setSubtotal(BigDecimal argSubtotal) {
/* 236 */     if (changed(argSubtotal, this._subtotal, "subtotal")) {
/* 237 */       this._subtotal = argSubtotal;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxAmount() {
/* 242 */     return this._taxAmount;
/*     */   }
/*     */   
/*     */   public void setTaxAmount(BigDecimal argTaxAmount) {
/* 246 */     if (changed(argTaxAmount, this._taxAmount, "taxAmount")) {
/* 247 */       this._taxAmount = argTaxAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getRoundedAmount() {
/* 252 */     return this._roundedAmount;
/*     */   }
/*     */   
/*     */   public void setRoundedAmount(BigDecimal argRoundedAmount) {
/* 256 */     if (changed(argRoundedAmount, this._roundedAmount, "roundedAmount")) {
/* 257 */       this._roundedAmount = argRoundedAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTotal() {
/* 262 */     return this._total;
/*     */   }
/*     */   
/*     */   public void setTotal(BigDecimal argTotal) {
/* 266 */     if (changed(argTotal, this._total, "total")) {
/* 267 */       this._total = argTotal;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTransactionStatusCode() {
/* 272 */     return this._transactionStatusCode;
/*     */   }
/*     */   
/*     */   public void setTransactionStatusCode(String argTransactionStatusCode) {
/* 276 */     if (changed(argTransactionStatusCode, this._transactionStatusCode, "transactionStatusCode")) {
/* 277 */       this._transactionStatusCode = argTransactionStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTransactionTypeCode() {
/* 282 */     return this._transactionTypeCode;
/*     */   }
/*     */   
/*     */   public void setTransactionTypeCode(String argTransactionTypeCode) {
/* 286 */     if (changed(argTransactionTypeCode, this._transactionTypeCode, "transactionTypeCode")) {
/* 287 */       this._transactionTypeCode = argTransactionTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTransactionCancelledReasonCode() {
/* 292 */     return this._transactionCancelledReasonCode;
/*     */   }
/*     */   
/*     */   public void setTransactionCancelledReasonCode(String argTransactionCancelledReasonCode) {
/* 296 */     if (changed(argTransactionCancelledReasonCode, this._transactionCancelledReasonCode, "transactionCancelledReasonCode")) {
/* 297 */       this._transactionCancelledReasonCode = argTransactionCancelledReasonCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getGenericStorage() {
/* 302 */     return this._genericStorage;
/*     */   }
/*     */   
/*     */   public void setGenericStorage(Boolean argGenericStorage) {
/* 306 */     if (changed(argGenericStorage, this._genericStorage, "genericStorage")) {
/* 307 */       this._genericStorage = argGenericStorage;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOperatorPartyId() {
/* 312 */     return this._operatorPartyId;
/*     */   }
/*     */   
/*     */   public void setOperatorPartyId(Long argOperatorPartyId) {
/* 316 */     if (changed(argOperatorPartyId, this._operatorPartyId, "operatorPartyId")) {
/* 317 */       this._operatorPartyId = argOperatorPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getPostVoid() {
/* 322 */     return this._postVoid;
/*     */   }
/*     */   
/*     */   public void setPostVoid(Boolean argPostVoid) {
/* 326 */     if (changed(argPostVoid, this._postVoid, "postVoid")) {
/* 327 */       this._postVoid = argPostVoid;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCashDrawerId() {
/* 332 */     return this._cashDrawerId;
/*     */   }
/*     */   
/*     */   public void setCashDrawerId(String argCashDrawerId) {
/* 336 */     if (changed(argCashDrawerId, this._cashDrawerId, "cashDrawerId")) {
/* 337 */       this._cashDrawerId = argCashDrawerId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFiscalNumber() {
/* 342 */     return this._fiscalNumber;
/*     */   }
/*     */   
/*     */   public void setFiscalNumber(String argFiscalNumber) {
/* 346 */     if (changed(argFiscalNumber, this._fiscalNumber, "fiscalNumber")) {
/* 347 */       this._fiscalNumber = argFiscalNumber;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 354 */     StringBuilder buf = new StringBuilder(512);
/* 355 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 356 */     if (getOrganizationId() != null) {
/* 357 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 359 */     if (getRetailLocationId() != null) {
/* 360 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 362 */     if (getBusinessDate() != null) {
/* 363 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 365 */     if (getWorkstationId() != null) {
/* 366 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 368 */     if (getTransactionSequence() != null) {
/* 369 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 371 */     if (getClassName() != null) {
/* 372 */       buf.append("className").append("=").append(getClassName()).append(" ");
/*     */     }
/* 374 */     if (getCreateDate() != null) {
/* 375 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 377 */     if (getCreateUserId() != null) {
/* 378 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 380 */     if (getUpdateDate() != null) {
/* 381 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 383 */     if (getUpdateUserId() != null) {
/* 384 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 386 */     if (getBeginDateTimestamp() != null) {
/* 387 */       buf.append("beginDateTimestamp").append("=").append(getBeginDateTimestamp()).append(" ");
/*     */     }
/* 389 */     if (getTransactionDate() != null) {
/* 390 */       buf.append("transactionDate").append("=").append(getTransactionDate()).append(" ");
/*     */     }
/* 392 */     if (getBeginTimeInt() != null) {
/* 393 */       buf.append("beginTimeInt").append("=").append(getBeginTimeInt()).append(" ");
/*     */     }
/* 395 */     if (getEndDateTimestamp() != null) {
/* 396 */       buf.append("endDateTimestamp").append("=").append(getEndDateTimestamp()).append(" ");
/*     */     }
/* 398 */     if (getKeyedOffline() != null && getKeyedOffline().booleanValue()) {
/* 399 */       buf.append("keyedOffline").append("=").append(getKeyedOffline()).append(" ");
/*     */     }
/* 401 */     if (getPosted() != null && getPosted().booleanValue()) {
/* 402 */       buf.append("posted").append("=").append(getPosted()).append(" ");
/*     */     }
/* 404 */     if (getSessionId() != null) {
/* 405 */       buf.append("sessionId").append("=").append(getSessionId()).append(" ");
/*     */     }
/* 407 */     if (getSubtotal() != null) {
/* 408 */       buf.append("subtotal").append("=").append(getSubtotal()).append(" ");
/*     */     }
/* 410 */     if (getTaxAmount() != null) {
/* 411 */       buf.append("taxAmount").append("=").append(getTaxAmount()).append(" ");
/*     */     }
/* 413 */     if (getRoundedAmount() != null) {
/* 414 */       buf.append("roundedAmount").append("=").append(getRoundedAmount()).append(" ");
/*     */     }
/* 416 */     if (getTotal() != null) {
/* 417 */       buf.append("total").append("=").append(getTotal()).append(" ");
/*     */     }
/* 419 */     if (getTransactionStatusCode() != null) {
/* 420 */       buf.append("transactionStatusCode").append("=").append(getTransactionStatusCode()).append(" ");
/*     */     }
/* 422 */     if (getTransactionTypeCode() != null) {
/* 423 */       buf.append("transactionTypeCode").append("=").append(getTransactionTypeCode()).append(" ");
/*     */     }
/* 425 */     if (getTransactionCancelledReasonCode() != null) {
/* 426 */       buf.append("transactionCancelledReasonCode").append("=").append(getTransactionCancelledReasonCode()).append(" ");
/*     */     }
/* 428 */     if (getGenericStorage() != null && getGenericStorage().booleanValue()) {
/* 429 */       buf.append("genericStorage").append("=").append(getGenericStorage()).append(" ");
/*     */     }
/* 431 */     if (getOperatorPartyId() != null) {
/* 432 */       buf.append("operatorPartyId").append("=").append(getOperatorPartyId()).append(" ");
/*     */     }
/* 434 */     if (getPostVoid() != null && getPostVoid().booleanValue()) {
/* 435 */       buf.append("postVoid").append("=").append(getPostVoid()).append(" ");
/*     */     }
/* 437 */     if (getCashDrawerId() != null) {
/* 438 */       buf.append("cashDrawerId").append("=").append(getCashDrawerId()).append(" ");
/*     */     }
/* 440 */     if (getFiscalNumber() != null) {
/* 441 */       buf.append("fiscalNumber").append("=").append(getFiscalNumber()).append(" ");
/*     */     }
/*     */     
/* 444 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 448 */     PosTransactionId id = new PosTransactionId();
/* 449 */     id.setOrganizationId(getOrganizationId());
/* 450 */     id.setRetailLocationId(getRetailLocationId());
/* 451 */     id.setBusinessDate(getBusinessDate());
/* 452 */     id.setWorkstationId(getWorkstationId());
/* 453 */     id.setTransactionSequence(getTransactionSequence());
/* 454 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 458 */     setOrganizationId(((PosTransactionId)argObjectId).getOrganizationId());
/* 459 */     setRetailLocationId(((PosTransactionId)argObjectId).getRetailLocationId());
/* 460 */     setBusinessDate(((PosTransactionId)argObjectId).getBusinessDate());
/* 461 */     setWorkstationId(((PosTransactionId)argObjectId).getWorkstationId());
/* 462 */     setTransactionSequence(((PosTransactionId)argObjectId).getTransactionSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 466 */     return this._className;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 470 */     StringBuilder buf = new StringBuilder(1450);
/* 471 */     buf.append("<").append("dao").append(" name=\"PosTransaction\" cmd=\"" + getObjectStateString() + "\">");
/* 472 */     getFieldsAsXml(buf);
/* 473 */     buf.append("</").append("dao").append(">");
/*     */     
/* 475 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 479 */     Map<String, String> values = super.getValues();
/* 480 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 481 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 482 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 483 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 484 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 485 */     if (this._className != null) values.put("ClassName", DaoUtils.getXmlSafeFieldValue(12, this._className)); 
/* 486 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 487 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 488 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 489 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 490 */     if (this._beginDateTimestamp != null) values.put("BeginDateTimestamp", DaoUtils.getXmlSafeFieldValue(91, this._beginDateTimestamp)); 
/* 491 */     if (this._transactionDate != null) values.put("TransactionDate", DaoUtils.getXmlSafeFieldValue(91, this._transactionDate)); 
/* 492 */     if (this._beginTimeInt != null) values.put("BeginTimeInt", DaoUtils.getXmlSafeFieldValue(4, this._beginTimeInt)); 
/* 493 */     if (this._endDateTimestamp != null) values.put("EndDateTimestamp", DaoUtils.getXmlSafeFieldValue(91, this._endDateTimestamp)); 
/* 494 */     if (this._keyedOffline != null) values.put("KeyedOffline", DaoUtils.getXmlSafeFieldValue(-7, this._keyedOffline)); 
/* 495 */     if (this._posted != null) values.put("Posted", DaoUtils.getXmlSafeFieldValue(-7, this._posted)); 
/* 496 */     if (this._sessionId != null) values.put("SessionId", DaoUtils.getXmlSafeFieldValue(-5, this._sessionId)); 
/* 497 */     if (this._subtotal != null) values.put("Subtotal", DaoUtils.getXmlSafeFieldValue(3, this._subtotal)); 
/* 498 */     if (this._taxAmount != null) values.put("TaxAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxAmount)); 
/* 499 */     if (this._roundedAmount != null) values.put("RoundedAmount", DaoUtils.getXmlSafeFieldValue(3, this._roundedAmount)); 
/* 500 */     if (this._total != null) values.put("Total", DaoUtils.getXmlSafeFieldValue(3, this._total)); 
/* 501 */     if (this._transactionStatusCode != null) values.put("TransactionStatusCode", DaoUtils.getXmlSafeFieldValue(12, this._transactionStatusCode)); 
/* 502 */     if (this._transactionTypeCode != null) values.put("TransactionTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._transactionTypeCode)); 
/* 503 */     if (this._transactionCancelledReasonCode != null) values.put("TransactionCancelledReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._transactionCancelledReasonCode)); 
/* 504 */     if (this._genericStorage != null) values.put("GenericStorage", DaoUtils.getXmlSafeFieldValue(-7, this._genericStorage)); 
/* 505 */     if (this._operatorPartyId != null) values.put("OperatorPartyId", DaoUtils.getXmlSafeFieldValue(-5, this._operatorPartyId)); 
/* 506 */     if (this._postVoid != null) values.put("PostVoid", DaoUtils.getXmlSafeFieldValue(-7, this._postVoid)); 
/* 507 */     if (this._cashDrawerId != null) values.put("CashDrawerId", DaoUtils.getXmlSafeFieldValue(12, this._cashDrawerId)); 
/* 508 */     if (this._fiscalNumber != null) values.put("FiscalNumber", DaoUtils.getXmlSafeFieldValue(12, this._fiscalNumber)); 
/* 509 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 514 */     super.setValues(argValues);
/* 515 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 517 */       String fieldName = field.getKey();
/* 518 */       String fieldValue = field.getValue();
/* 519 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 523 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 524 */             setOrganizationId((Long)value);
/* 525 */           } catch (Exception ee) {
/* 526 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 532 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 533 */             setRetailLocationId((Long)value);
/* 534 */           } catch (Exception ee) {
/* 535 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 541 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 542 */             setBusinessDate((Date)value);
/* 543 */           } catch (Exception ee) {
/* 544 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 550 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 551 */             setWorkstationId((Long)value);
/* 552 */           } catch (Exception ee) {
/* 553 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 559 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 560 */             setTransactionSequence((Long)value);
/* 561 */           } catch (Exception ee) {
/* 562 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ClassName":
/*     */           try {
/* 568 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 569 */             setClassName((String)value);
/* 570 */           } catch (Exception ee) {
/* 571 */             throw new DtxException("An exception occurred while calling setClassName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 577 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 578 */             setCreateDate((Date)value);
/* 579 */           } catch (Exception ee) {
/* 580 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 586 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 587 */             setCreateUserId((String)value);
/* 588 */           } catch (Exception ee) {
/* 589 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 595 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 596 */             setUpdateDate((Date)value);
/* 597 */           } catch (Exception ee) {
/* 598 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 604 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 605 */             setUpdateUserId((String)value);
/* 606 */           } catch (Exception ee) {
/* 607 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BeginDateTimestamp":
/*     */           try {
/* 613 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 614 */             setBeginDateTimestamp((Date)value);
/* 615 */           } catch (Exception ee) {
/* 616 */             throw new DtxException("An exception occurred while calling setBeginDateTimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionDate":
/*     */           try {
/* 622 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 623 */             setTransactionDate((Date)value);
/* 624 */           } catch (Exception ee) {
/* 625 */             throw new DtxException("An exception occurred while calling setTransactionDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BeginTimeInt":
/*     */           try {
/* 631 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 632 */             setBeginTimeInt((Integer)value);
/* 633 */           } catch (Exception ee) {
/* 634 */             throw new DtxException("An exception occurred while calling setBeginTimeInt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndDateTimestamp":
/*     */           try {
/* 640 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 641 */             setEndDateTimestamp((Date)value);
/* 642 */           } catch (Exception ee) {
/* 643 */             throw new DtxException("An exception occurred while calling setEndDateTimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "KeyedOffline":
/*     */           try {
/* 649 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 650 */             setKeyedOffline((Boolean)value);
/* 651 */           } catch (Exception ee) {
/* 652 */             throw new DtxException("An exception occurred while calling setKeyedOffline() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Posted":
/*     */           try {
/* 658 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 659 */             setPosted((Boolean)value);
/* 660 */           } catch (Exception ee) {
/* 661 */             throw new DtxException("An exception occurred while calling setPosted() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SessionId":
/*     */           try {
/* 667 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 668 */             setSessionId((Long)value);
/* 669 */           } catch (Exception ee) {
/* 670 */             throw new DtxException("An exception occurred while calling setSessionId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Subtotal":
/*     */           try {
/* 676 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 677 */             setSubtotal((BigDecimal)value);
/* 678 */           } catch (Exception ee) {
/* 679 */             throw new DtxException("An exception occurred while calling setSubtotal() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxAmount":
/*     */           try {
/* 685 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 686 */             setTaxAmount((BigDecimal)value);
/* 687 */           } catch (Exception ee) {
/* 688 */             throw new DtxException("An exception occurred while calling setTaxAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RoundedAmount":
/*     */           try {
/* 694 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 695 */             setRoundedAmount((BigDecimal)value);
/* 696 */           } catch (Exception ee) {
/* 697 */             throw new DtxException("An exception occurred while calling setRoundedAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Total":
/*     */           try {
/* 703 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 704 */             setTotal((BigDecimal)value);
/* 705 */           } catch (Exception ee) {
/* 706 */             throw new DtxException("An exception occurred while calling setTotal() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionStatusCode":
/*     */           try {
/* 712 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 713 */             setTransactionStatusCode((String)value);
/* 714 */           } catch (Exception ee) {
/* 715 */             throw new DtxException("An exception occurred while calling setTransactionStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionTypeCode":
/*     */           try {
/* 721 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 722 */             setTransactionTypeCode((String)value);
/* 723 */           } catch (Exception ee) {
/* 724 */             throw new DtxException("An exception occurred while calling setTransactionTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionCancelledReasonCode":
/*     */           try {
/* 730 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 731 */             setTransactionCancelledReasonCode((String)value);
/* 732 */           } catch (Exception ee) {
/* 733 */             throw new DtxException("An exception occurred while calling setTransactionCancelledReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "GenericStorage":
/*     */           try {
/* 739 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 740 */             setGenericStorage((Boolean)value);
/* 741 */           } catch (Exception ee) {
/* 742 */             throw new DtxException("An exception occurred while calling setGenericStorage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OperatorPartyId":
/*     */           try {
/* 748 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 749 */             setOperatorPartyId((Long)value);
/* 750 */           } catch (Exception ee) {
/* 751 */             throw new DtxException("An exception occurred while calling setOperatorPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PostVoid":
/*     */           try {
/* 757 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 758 */             setPostVoid((Boolean)value);
/* 759 */           } catch (Exception ee) {
/* 760 */             throw new DtxException("An exception occurred while calling setPostVoid() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CashDrawerId":
/*     */           try {
/* 766 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 767 */             setCashDrawerId((String)value);
/* 768 */           } catch (Exception ee) {
/* 769 */             throw new DtxException("An exception occurred while calling setCashDrawerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FiscalNumber":
/*     */           try {
/* 775 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 776 */             setFiscalNumber((String)value);
/* 777 */           } catch (Exception ee) {
/* 778 */             throw new DtxException("An exception occurred while calling setFiscalNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PosTransactionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */