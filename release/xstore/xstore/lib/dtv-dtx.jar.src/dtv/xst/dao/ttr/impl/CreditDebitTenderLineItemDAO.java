/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CreditDebitTenderLineItemDAO
/*     */   extends TenderLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = 1871830094L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CreditDebitTenderLineItemDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _accountNumber;
/*     */   private String _adjudicationCode;
/*     */   private String _authorizationMethodCode;
/*     */   private String _authorizationCode;
/*     */   private String _bankReferenceNumber;
/*     */   private String _customerName;
/*     */   private String _entryMethodCode;
/*     */   private String _ps2000;
/*     */   private String _mediaIssuerId;
/*     */   private String _personalIdReferenceNumber;
/*     */   private String _personalIdRequiredTypeCode;
/*     */   private String _expirationDateString;
/*     */   private BigDecimal _cashbackAmount;
/*     */   private String _cardLevelIndicator;
/*     */   private String _accountNumberHash;
/*     */   private String _authorizationToken;
/*     */   private String _transactionReferenceData;
/*     */   private String _traceNumber;
/*     */   private BigDecimal _taxAmount;
/*     */   private BigDecimal _discountAmount;
/*     */   private BigDecimal _freightAmount;
/*     */   private BigDecimal _dutyAmount;
/*     */   private String _origLocalDateTime;
/*     */   private String _origTransmissionDateTime;
/*     */   private String _origSTAN;
/*     */   private String _transactionIdentifier;
/*     */   private String _ccvErrorCode;
/*     */   private String _posEntryModeChange;
/*     */   private String _processingCode;
/*     */   private String _posEntryMode;
/*     */   private String _posAdditionalData;
/*     */   private String _networkResultIndicator;
/*     */   private String _merchantCategoryCode;
/*     */   
/*     */   public Date getCreateDate() {
/*  64 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  68 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  69 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  75 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  79 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  80 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  85 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  89 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  90 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  96 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 100 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 101 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountNumber() {
/* 106 */     return this._accountNumber;
/*     */   }
/*     */   
/*     */   public void setAccountNumber(String argAccountNumber) {
/* 110 */     if (changed(argAccountNumber, this._accountNumber, "accountNumber")) {
/* 111 */       this._accountNumber = argAccountNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAdjudicationCode() {
/* 116 */     return this._adjudicationCode;
/*     */   }
/*     */   
/*     */   public void setAdjudicationCode(String argAdjudicationCode) {
/* 120 */     if (changed(argAdjudicationCode, this._adjudicationCode, "adjudicationCode")) {
/* 121 */       this._adjudicationCode = argAdjudicationCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorizationMethodCode() {
/* 126 */     return this._authorizationMethodCode;
/*     */   }
/*     */   
/*     */   public void setAuthorizationMethodCode(String argAuthorizationMethodCode) {
/* 130 */     if (changed(argAuthorizationMethodCode, this._authorizationMethodCode, "authorizationMethodCode")) {
/* 131 */       this._authorizationMethodCode = argAuthorizationMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorizationCode() {
/* 136 */     return this._authorizationCode;
/*     */   }
/*     */   
/*     */   public void setAuthorizationCode(String argAuthorizationCode) {
/* 140 */     if (changed(argAuthorizationCode, this._authorizationCode, "authorizationCode")) {
/* 141 */       this._authorizationCode = argAuthorizationCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBankReferenceNumber() {
/* 146 */     return this._bankReferenceNumber;
/*     */   }
/*     */   
/*     */   public void setBankReferenceNumber(String argBankReferenceNumber) {
/* 150 */     if (changed(argBankReferenceNumber, this._bankReferenceNumber, "bankReferenceNumber")) {
/* 151 */       this._bankReferenceNumber = argBankReferenceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustomerName() {
/* 156 */     return this._customerName;
/*     */   }
/*     */   
/*     */   public void setCustomerName(String argCustomerName) {
/* 160 */     if (changed(argCustomerName, this._customerName, "customerName")) {
/* 161 */       this._customerName = argCustomerName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEntryMethodCode() {
/* 166 */     return this._entryMethodCode;
/*     */   }
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/* 170 */     if (changed(argEntryMethodCode, this._entryMethodCode, "entryMethodCode")) {
/* 171 */       this._entryMethodCode = argEntryMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPs2000() {
/* 176 */     return this._ps2000;
/*     */   }
/*     */   
/*     */   public void setPs2000(String argPs2000) {
/* 180 */     if (changed(argPs2000, this._ps2000, "ps2000")) {
/* 181 */       this._ps2000 = argPs2000;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMediaIssuerId() {
/* 186 */     return this._mediaIssuerId;
/*     */   }
/*     */   
/*     */   public void setMediaIssuerId(String argMediaIssuerId) {
/* 190 */     if (changed(argMediaIssuerId, this._mediaIssuerId, "mediaIssuerId")) {
/* 191 */       this._mediaIssuerId = argMediaIssuerId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPersonalIdReferenceNumber() {
/* 196 */     return this._personalIdReferenceNumber;
/*     */   }
/*     */   
/*     */   public void setPersonalIdReferenceNumber(String argPersonalIdReferenceNumber) {
/* 200 */     if (changed(argPersonalIdReferenceNumber, this._personalIdReferenceNumber, "personalIdReferenceNumber")) {
/* 201 */       this._personalIdReferenceNumber = argPersonalIdReferenceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPersonalIdRequiredTypeCode() {
/* 206 */     return this._personalIdRequiredTypeCode;
/*     */   }
/*     */   
/*     */   public void setPersonalIdRequiredTypeCode(String argPersonalIdRequiredTypeCode) {
/* 210 */     if (changed(argPersonalIdRequiredTypeCode, this._personalIdRequiredTypeCode, "personalIdRequiredTypeCode")) {
/* 211 */       this._personalIdRequiredTypeCode = argPersonalIdRequiredTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getExpirationDateString() {
/* 216 */     return this._expirationDateString;
/*     */   }
/*     */   
/*     */   public void setExpirationDateString(String argExpirationDateString) {
/* 220 */     if (changed(argExpirationDateString, this._expirationDateString, "expirationDateString")) {
/* 221 */       this._expirationDateString = argExpirationDateString;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getCashbackAmount() {
/* 226 */     return this._cashbackAmount;
/*     */   }
/*     */   
/*     */   public void setCashbackAmount(BigDecimal argCashbackAmount) {
/* 230 */     if (changed(argCashbackAmount, this._cashbackAmount, "cashbackAmount")) {
/* 231 */       this._cashbackAmount = argCashbackAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCardLevelIndicator() {
/* 236 */     return this._cardLevelIndicator;
/*     */   }
/*     */   
/*     */   public void setCardLevelIndicator(String argCardLevelIndicator) {
/* 240 */     if (changed(argCardLevelIndicator, this._cardLevelIndicator, "cardLevelIndicator")) {
/* 241 */       this._cardLevelIndicator = argCardLevelIndicator;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountNumberHash() {
/* 246 */     return this._accountNumberHash;
/*     */   }
/*     */   
/*     */   public void setAccountNumberHash(String argAccountNumberHash) {
/* 250 */     if (changed(argAccountNumberHash, this._accountNumberHash, "accountNumberHash")) {
/* 251 */       this._accountNumberHash = argAccountNumberHash;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorizationToken() {
/* 256 */     return this._authorizationToken;
/*     */   }
/*     */   
/*     */   public void setAuthorizationToken(String argAuthorizationToken) {
/* 260 */     if (changed(argAuthorizationToken, this._authorizationToken, "authorizationToken")) {
/* 261 */       this._authorizationToken = argAuthorizationToken;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTransactionReferenceData() {
/* 266 */     return this._transactionReferenceData;
/*     */   }
/*     */   
/*     */   public void setTransactionReferenceData(String argTransactionReferenceData) {
/* 270 */     if (changed(argTransactionReferenceData, this._transactionReferenceData, "transactionReferenceData")) {
/* 271 */       this._transactionReferenceData = argTransactionReferenceData;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTraceNumber() {
/* 276 */     return this._traceNumber;
/*     */   }
/*     */   
/*     */   public void setTraceNumber(String argTraceNumber) {
/* 280 */     if (changed(argTraceNumber, this._traceNumber, "traceNumber")) {
/* 281 */       this._traceNumber = argTraceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTaxAmount() {
/* 286 */     return this._taxAmount;
/*     */   }
/*     */   
/*     */   public void setTaxAmount(BigDecimal argTaxAmount) {
/* 290 */     if (changed(argTaxAmount, this._taxAmount, "taxAmount")) {
/* 291 */       this._taxAmount = argTaxAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getDiscountAmount() {
/* 296 */     return this._discountAmount;
/*     */   }
/*     */   
/*     */   public void setDiscountAmount(BigDecimal argDiscountAmount) {
/* 300 */     if (changed(argDiscountAmount, this._discountAmount, "discountAmount")) {
/* 301 */       this._discountAmount = argDiscountAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getFreightAmount() {
/* 306 */     return this._freightAmount;
/*     */   }
/*     */   
/*     */   public void setFreightAmount(BigDecimal argFreightAmount) {
/* 310 */     if (changed(argFreightAmount, this._freightAmount, "freightAmount")) {
/* 311 */       this._freightAmount = argFreightAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getDutyAmount() {
/* 316 */     return this._dutyAmount;
/*     */   }
/*     */   
/*     */   public void setDutyAmount(BigDecimal argDutyAmount) {
/* 320 */     if (changed(argDutyAmount, this._dutyAmount, "dutyAmount")) {
/* 321 */       this._dutyAmount = argDutyAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrigLocalDateTime() {
/* 326 */     return this._origLocalDateTime;
/*     */   }
/*     */   
/*     */   public void setOrigLocalDateTime(String argOrigLocalDateTime) {
/* 330 */     if (changed(argOrigLocalDateTime, this._origLocalDateTime, "origLocalDateTime")) {
/* 331 */       this._origLocalDateTime = argOrigLocalDateTime;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrigTransmissionDateTime() {
/* 336 */     return this._origTransmissionDateTime;
/*     */   }
/*     */   
/*     */   public void setOrigTransmissionDateTime(String argOrigTransmissionDateTime) {
/* 340 */     if (changed(argOrigTransmissionDateTime, this._origTransmissionDateTime, "origTransmissionDateTime")) {
/* 341 */       this._origTransmissionDateTime = argOrigTransmissionDateTime;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrigSTAN() {
/* 346 */     return this._origSTAN;
/*     */   }
/*     */   
/*     */   public void setOrigSTAN(String argOrigSTAN) {
/* 350 */     if (changed(argOrigSTAN, this._origSTAN, "origSTAN")) {
/* 351 */       this._origSTAN = argOrigSTAN;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTransactionIdentifier() {
/* 356 */     return this._transactionIdentifier;
/*     */   }
/*     */   
/*     */   public void setTransactionIdentifier(String argTransactionIdentifier) {
/* 360 */     if (changed(argTransactionIdentifier, this._transactionIdentifier, "transactionIdentifier")) {
/* 361 */       this._transactionIdentifier = argTransactionIdentifier;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCcvErrorCode() {
/* 366 */     return this._ccvErrorCode;
/*     */   }
/*     */   
/*     */   public void setCcvErrorCode(String argCcvErrorCode) {
/* 370 */     if (changed(argCcvErrorCode, this._ccvErrorCode, "ccvErrorCode")) {
/* 371 */       this._ccvErrorCode = argCcvErrorCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPosEntryModeChange() {
/* 376 */     return this._posEntryModeChange;
/*     */   }
/*     */   
/*     */   public void setPosEntryModeChange(String argPosEntryModeChange) {
/* 380 */     if (changed(argPosEntryModeChange, this._posEntryModeChange, "posEntryModeChange")) {
/* 381 */       this._posEntryModeChange = argPosEntryModeChange;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getProcessingCode() {
/* 386 */     return this._processingCode;
/*     */   }
/*     */   
/*     */   public void setProcessingCode(String argProcessingCode) {
/* 390 */     if (changed(argProcessingCode, this._processingCode, "processingCode")) {
/* 391 */       this._processingCode = argProcessingCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPosEntryMode() {
/* 396 */     return this._posEntryMode;
/*     */   }
/*     */   
/*     */   public void setPosEntryMode(String argPosEntryMode) {
/* 400 */     if (changed(argPosEntryMode, this._posEntryMode, "posEntryMode")) {
/* 401 */       this._posEntryMode = argPosEntryMode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPosAdditionalData() {
/* 406 */     return this._posAdditionalData;
/*     */   }
/*     */   
/*     */   public void setPosAdditionalData(String argPosAdditionalData) {
/* 410 */     if (changed(argPosAdditionalData, this._posAdditionalData, "posAdditionalData")) {
/* 411 */       this._posAdditionalData = argPosAdditionalData;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNetworkResultIndicator() {
/* 416 */     return this._networkResultIndicator;
/*     */   }
/*     */   
/*     */   public void setNetworkResultIndicator(String argNetworkResultIndicator) {
/* 420 */     if (changed(argNetworkResultIndicator, this._networkResultIndicator, "networkResultIndicator")) {
/* 421 */       this._networkResultIndicator = argNetworkResultIndicator;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMerchantCategoryCode() {
/* 426 */     return this._merchantCategoryCode;
/*     */   }
/*     */   
/*     */   public void setMerchantCategoryCode(String argMerchantCategoryCode) {
/* 430 */     if (changed(argMerchantCategoryCode, this._merchantCategoryCode, "merchantCategoryCode")) {
/* 431 */       this._merchantCategoryCode = argMerchantCategoryCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 438 */     StringBuilder buf = new StringBuilder(512);
/* 439 */     buf.append(super.toString());
/* 440 */     if (getCreateDate() != null) {
/* 441 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 443 */     if (getCreateUserId() != null) {
/* 444 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 446 */     if (getUpdateDate() != null) {
/* 447 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 449 */     if (getUpdateUserId() != null) {
/* 450 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 452 */     if (getAccountNumber() != null) {
/* 453 */       buf.append("accountNumber").append("=").append("[REDACTED]").append(" ");
/*     */     }
/* 455 */     if (getAdjudicationCode() != null) {
/* 456 */       buf.append("adjudicationCode").append("=").append(getAdjudicationCode()).append(" ");
/*     */     }
/* 458 */     if (getAuthorizationMethodCode() != null) {
/* 459 */       buf.append("authorizationMethodCode").append("=").append(getAuthorizationMethodCode()).append(" ");
/*     */     }
/* 461 */     if (getAuthorizationCode() != null) {
/* 462 */       buf.append("authorizationCode").append("=").append(getAuthorizationCode()).append(" ");
/*     */     }
/* 464 */     if (getBankReferenceNumber() != null) {
/* 465 */       buf.append("bankReferenceNumber").append("=").append(getBankReferenceNumber()).append(" ");
/*     */     }
/* 467 */     if (getCustomerName() != null) {
/* 468 */       buf.append("customerName").append("=").append(getCustomerName()).append(" ");
/*     */     }
/* 470 */     if (getEntryMethodCode() != null) {
/* 471 */       buf.append("entryMethodCode").append("=").append(getEntryMethodCode()).append(" ");
/*     */     }
/* 473 */     if (getPs2000() != null) {
/* 474 */       buf.append("ps2000").append("=").append(getPs2000()).append(" ");
/*     */     }
/* 476 */     if (getMediaIssuerId() != null) {
/* 477 */       buf.append("mediaIssuerId").append("=").append(getMediaIssuerId()).append(" ");
/*     */     }
/* 479 */     if (getPersonalIdReferenceNumber() != null) {
/* 480 */       buf.append("personalIdReferenceNumber").append("=").append(getPersonalIdReferenceNumber()).append(" ");
/*     */     }
/* 482 */     if (getPersonalIdRequiredTypeCode() != null) {
/* 483 */       buf.append("personalIdRequiredTypeCode").append("=").append(getPersonalIdRequiredTypeCode()).append(" ");
/*     */     }
/* 485 */     if (getExpirationDateString() != null) {
/* 486 */       buf.append("expirationDateString").append("=").append("[REDACTED]").append(" ");
/*     */     }
/* 488 */     if (getCashbackAmount() != null) {
/* 489 */       buf.append("cashbackAmount").append("=").append(getCashbackAmount()).append(" ");
/*     */     }
/* 491 */     if (getCardLevelIndicator() != null) {
/* 492 */       buf.append("cardLevelIndicator").append("=").append(getCardLevelIndicator()).append(" ");
/*     */     }
/* 494 */     if (getAccountNumberHash() != null) {
/* 495 */       buf.append("accountNumberHash").append("=").append("[REDACTED]").append(" ");
/*     */     }
/* 497 */     if (getAuthorizationToken() != null) {
/* 498 */       buf.append("authorizationToken").append("=").append(getAuthorizationToken()).append(" ");
/*     */     }
/* 500 */     if (getTransactionReferenceData() != null) {
/* 501 */       buf.append("transactionReferenceData").append("=").append(getTransactionReferenceData()).append(" ");
/*     */     }
/* 503 */     if (getTraceNumber() != null) {
/* 504 */       buf.append("traceNumber").append("=").append(getTraceNumber()).append(" ");
/*     */     }
/* 506 */     if (getTaxAmount() != null) {
/* 507 */       buf.append("taxAmount").append("=").append(getTaxAmount()).append(" ");
/*     */     }
/* 509 */     if (getDiscountAmount() != null) {
/* 510 */       buf.append("discountAmount").append("=").append(getDiscountAmount()).append(" ");
/*     */     }
/* 512 */     if (getFreightAmount() != null) {
/* 513 */       buf.append("freightAmount").append("=").append(getFreightAmount()).append(" ");
/*     */     }
/* 515 */     if (getDutyAmount() != null) {
/* 516 */       buf.append("dutyAmount").append("=").append(getDutyAmount()).append(" ");
/*     */     }
/* 518 */     if (getOrigLocalDateTime() != null) {
/* 519 */       buf.append("origLocalDateTime").append("=").append(getOrigLocalDateTime()).append(" ");
/*     */     }
/* 521 */     if (getOrigTransmissionDateTime() != null) {
/* 522 */       buf.append("origTransmissionDateTime").append("=").append(getOrigTransmissionDateTime()).append(" ");
/*     */     }
/* 524 */     if (getOrigSTAN() != null) {
/* 525 */       buf.append("origSTAN").append("=").append(getOrigSTAN()).append(" ");
/*     */     }
/* 527 */     if (getTransactionIdentifier() != null) {
/* 528 */       buf.append("transactionIdentifier").append("=").append(getTransactionIdentifier()).append(" ");
/*     */     }
/* 530 */     if (getCcvErrorCode() != null) {
/* 531 */       buf.append("ccvErrorCode").append("=").append(getCcvErrorCode()).append(" ");
/*     */     }
/* 533 */     if (getPosEntryModeChange() != null) {
/* 534 */       buf.append("posEntryModeChange").append("=").append(getPosEntryModeChange()).append(" ");
/*     */     }
/* 536 */     if (getProcessingCode() != null) {
/* 537 */       buf.append("processingCode").append("=").append(getProcessingCode()).append(" ");
/*     */     }
/* 539 */     if (getPosEntryMode() != null) {
/* 540 */       buf.append("posEntryMode").append("=").append(getPosEntryMode()).append(" ");
/*     */     }
/* 542 */     if (getPosAdditionalData() != null) {
/* 543 */       buf.append("posAdditionalData").append("=").append(getPosAdditionalData()).append(" ");
/*     */     }
/* 545 */     if (getNetworkResultIndicator() != null) {
/* 546 */       buf.append("networkResultIndicator").append("=").append(getNetworkResultIndicator()).append(" ");
/*     */     }
/* 548 */     if (getMerchantCategoryCode() != null) {
/* 549 */       buf.append("merchantCategoryCode").append("=").append(getMerchantCategoryCode()).append(" ");
/*     */     }
/*     */     
/* 552 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 557 */     StringBuilder buf = new StringBuilder(3500);
/* 558 */     buf.append("<").append("dao").append(" name=\"CreditDebitTenderLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 559 */     getFieldsAsXml(buf);
/* 560 */     buf.append("</").append("dao").append(">");
/*     */     
/* 562 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 566 */     Map<String, String> values = super.getValues();
/* 567 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 568 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 569 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 570 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 571 */     if (this._accountNumber != null) values.put("AccountNumber", DaoUtils.getXmlSafeFieldValue(12, this._accountNumber)); 
/* 572 */     if (this._adjudicationCode != null) values.put("AdjudicationCode", DaoUtils.getXmlSafeFieldValue(12, this._adjudicationCode)); 
/* 573 */     if (this._authorizationMethodCode != null) values.put("AuthorizationMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._authorizationMethodCode)); 
/* 574 */     if (this._authorizationCode != null) values.put("AuthorizationCode", DaoUtils.getXmlSafeFieldValue(12, this._authorizationCode)); 
/* 575 */     if (this._bankReferenceNumber != null) values.put("BankReferenceNumber", DaoUtils.getXmlSafeFieldValue(12, this._bankReferenceNumber)); 
/* 576 */     if (this._customerName != null) values.put("CustomerName", DaoUtils.getXmlSafeFieldValue(12, this._customerName)); 
/* 577 */     if (this._entryMethodCode != null) values.put("EntryMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._entryMethodCode)); 
/* 578 */     if (this._ps2000 != null) values.put("Ps2000", DaoUtils.getXmlSafeFieldValue(12, this._ps2000)); 
/* 579 */     if (this._mediaIssuerId != null) values.put("MediaIssuerId", DaoUtils.getXmlSafeFieldValue(12, this._mediaIssuerId)); 
/* 580 */     if (this._personalIdReferenceNumber != null) values.put("PersonalIdReferenceNumber", DaoUtils.getXmlSafeFieldValue(12, this._personalIdReferenceNumber)); 
/* 581 */     if (this._personalIdRequiredTypeCode != null) values.put("PersonalIdRequiredTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._personalIdRequiredTypeCode)); 
/* 582 */     if (this._expirationDateString != null) values.put("ExpirationDateString", DaoUtils.getXmlSafeFieldValue(12, this._expirationDateString)); 
/* 583 */     if (this._cashbackAmount != null) values.put("CashbackAmount", DaoUtils.getXmlSafeFieldValue(3, this._cashbackAmount)); 
/* 584 */     if (this._cardLevelIndicator != null) values.put("CardLevelIndicator", DaoUtils.getXmlSafeFieldValue(12, this._cardLevelIndicator)); 
/* 585 */     if (this._accountNumberHash != null) values.put("AccountNumberHash", DaoUtils.getXmlSafeFieldValue(12, this._accountNumberHash)); 
/* 586 */     if (this._authorizationToken != null) values.put("AuthorizationToken", DaoUtils.getXmlSafeFieldValue(12, this._authorizationToken)); 
/* 587 */     if (this._transactionReferenceData != null) values.put("TransactionReferenceData", DaoUtils.getXmlSafeFieldValue(12, this._transactionReferenceData)); 
/* 588 */     if (this._traceNumber != null) values.put("TraceNumber", DaoUtils.getXmlSafeFieldValue(12, this._traceNumber)); 
/* 589 */     if (this._taxAmount != null) values.put("TaxAmount", DaoUtils.getXmlSafeFieldValue(3, this._taxAmount)); 
/* 590 */     if (this._discountAmount != null) values.put("DiscountAmount", DaoUtils.getXmlSafeFieldValue(3, this._discountAmount)); 
/* 591 */     if (this._freightAmount != null) values.put("FreightAmount", DaoUtils.getXmlSafeFieldValue(3, this._freightAmount)); 
/* 592 */     if (this._dutyAmount != null) values.put("DutyAmount", DaoUtils.getXmlSafeFieldValue(3, this._dutyAmount)); 
/* 593 */     if (this._origLocalDateTime != null) values.put("OrigLocalDateTime", DaoUtils.getXmlSafeFieldValue(12, this._origLocalDateTime)); 
/* 594 */     if (this._origTransmissionDateTime != null) values.put("OrigTransmissionDateTime", DaoUtils.getXmlSafeFieldValue(12, this._origTransmissionDateTime)); 
/* 595 */     if (this._origSTAN != null) values.put("OrigSTAN", DaoUtils.getXmlSafeFieldValue(12, this._origSTAN)); 
/* 596 */     if (this._transactionIdentifier != null) values.put("TransactionIdentifier", DaoUtils.getXmlSafeFieldValue(12, this._transactionIdentifier)); 
/* 597 */     if (this._ccvErrorCode != null) values.put("CcvErrorCode", DaoUtils.getXmlSafeFieldValue(12, this._ccvErrorCode)); 
/* 598 */     if (this._posEntryModeChange != null) values.put("PosEntryModeChange", DaoUtils.getXmlSafeFieldValue(12, this._posEntryModeChange)); 
/* 599 */     if (this._processingCode != null) values.put("ProcessingCode", DaoUtils.getXmlSafeFieldValue(12, this._processingCode)); 
/* 600 */     if (this._posEntryMode != null) values.put("PosEntryMode", DaoUtils.getXmlSafeFieldValue(12, this._posEntryMode)); 
/* 601 */     if (this._posAdditionalData != null) values.put("PosAdditionalData", DaoUtils.getXmlSafeFieldValue(12, this._posAdditionalData)); 
/* 602 */     if (this._networkResultIndicator != null) values.put("NetworkResultIndicator", DaoUtils.getXmlSafeFieldValue(12, this._networkResultIndicator)); 
/* 603 */     if (this._merchantCategoryCode != null) values.put("MerchantCategoryCode", DaoUtils.getXmlSafeFieldValue(12, this._merchantCategoryCode)); 
/* 604 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 609 */     super.setValues(argValues);
/* 610 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 612 */       String fieldName = field.getKey();
/* 613 */       String fieldValue = field.getValue();
/* 614 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 618 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 619 */             setCreateDate((Date)value);
/* 620 */           } catch (Exception ee) {
/* 621 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 627 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 628 */             setCreateUserId((String)value);
/* 629 */           } catch (Exception ee) {
/* 630 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 636 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 637 */             setUpdateDate((Date)value);
/* 638 */           } catch (Exception ee) {
/* 639 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 645 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 646 */             setUpdateUserId((String)value);
/* 647 */           } catch (Exception ee) {
/* 648 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountNumber":
/*     */           try {
/* 654 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 655 */             setAccountNumber((String)value);
/* 656 */           } catch (Exception ee) {
/* 657 */             throw new DtxException("An exception occurred while calling setAccountNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AdjudicationCode":
/*     */           try {
/* 663 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 664 */             setAdjudicationCode((String)value);
/* 665 */           } catch (Exception ee) {
/* 666 */             throw new DtxException("An exception occurred while calling setAdjudicationCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationMethodCode":
/*     */           try {
/* 672 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 673 */             setAuthorizationMethodCode((String)value);
/* 674 */           } catch (Exception ee) {
/* 675 */             throw new DtxException("An exception occurred while calling setAuthorizationMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationCode":
/*     */           try {
/* 681 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 682 */             setAuthorizationCode((String)value);
/* 683 */           } catch (Exception ee) {
/* 684 */             throw new DtxException("An exception occurred while calling setAuthorizationCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BankReferenceNumber":
/*     */           try {
/* 690 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 691 */             setBankReferenceNumber((String)value);
/* 692 */           } catch (Exception ee) {
/* 693 */             throw new DtxException("An exception occurred while calling setBankReferenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerName":
/*     */           try {
/* 699 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 700 */             setCustomerName((String)value);
/* 701 */           } catch (Exception ee) {
/* 702 */             throw new DtxException("An exception occurred while calling setCustomerName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EntryMethodCode":
/*     */           try {
/* 708 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 709 */             setEntryMethodCode((String)value);
/* 710 */           } catch (Exception ee) {
/* 711 */             throw new DtxException("An exception occurred while calling setEntryMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Ps2000":
/*     */           try {
/* 717 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 718 */             setPs2000((String)value);
/* 719 */           } catch (Exception ee) {
/* 720 */             throw new DtxException("An exception occurred while calling setPs2000() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MediaIssuerId":
/*     */           try {
/* 726 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 727 */             setMediaIssuerId((String)value);
/* 728 */           } catch (Exception ee) {
/* 729 */             throw new DtxException("An exception occurred while calling setMediaIssuerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PersonalIdReferenceNumber":
/*     */           try {
/* 735 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 736 */             setPersonalIdReferenceNumber((String)value);
/* 737 */           } catch (Exception ee) {
/* 738 */             throw new DtxException("An exception occurred while calling setPersonalIdReferenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PersonalIdRequiredTypeCode":
/*     */           try {
/* 744 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 745 */             setPersonalIdRequiredTypeCode((String)value);
/* 746 */           } catch (Exception ee) {
/* 747 */             throw new DtxException("An exception occurred while calling setPersonalIdRequiredTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDateString":
/*     */           try {
/* 753 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 754 */             setExpirationDateString((String)value);
/* 755 */           } catch (Exception ee) {
/* 756 */             throw new DtxException("An exception occurred while calling setExpirationDateString() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CashbackAmount":
/*     */           try {
/* 762 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 763 */             setCashbackAmount((BigDecimal)value);
/* 764 */           } catch (Exception ee) {
/* 765 */             throw new DtxException("An exception occurred while calling setCashbackAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CardLevelIndicator":
/*     */           try {
/* 771 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 772 */             setCardLevelIndicator((String)value);
/* 773 */           } catch (Exception ee) {
/* 774 */             throw new DtxException("An exception occurred while calling setCardLevelIndicator() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountNumberHash":
/*     */           try {
/* 780 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 781 */             setAccountNumberHash((String)value);
/* 782 */           } catch (Exception ee) {
/* 783 */             throw new DtxException("An exception occurred while calling setAccountNumberHash() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationToken":
/*     */           try {
/* 789 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 790 */             setAuthorizationToken((String)value);
/* 791 */           } catch (Exception ee) {
/* 792 */             throw new DtxException("An exception occurred while calling setAuthorizationToken() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionReferenceData":
/*     */           try {
/* 798 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 799 */             setTransactionReferenceData((String)value);
/* 800 */           } catch (Exception ee) {
/* 801 */             throw new DtxException("An exception occurred while calling setTransactionReferenceData() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TraceNumber":
/*     */           try {
/* 807 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 808 */             setTraceNumber((String)value);
/* 809 */           } catch (Exception ee) {
/* 810 */             throw new DtxException("An exception occurred while calling setTraceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxAmount":
/*     */           try {
/* 816 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 817 */             setTaxAmount((BigDecimal)value);
/* 818 */           } catch (Exception ee) {
/* 819 */             throw new DtxException("An exception occurred while calling setTaxAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DiscountAmount":
/*     */           try {
/* 825 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 826 */             setDiscountAmount((BigDecimal)value);
/* 827 */           } catch (Exception ee) {
/* 828 */             throw new DtxException("An exception occurred while calling setDiscountAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FreightAmount":
/*     */           try {
/* 834 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 835 */             setFreightAmount((BigDecimal)value);
/* 836 */           } catch (Exception ee) {
/* 837 */             throw new DtxException("An exception occurred while calling setFreightAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DutyAmount":
/*     */           try {
/* 843 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 844 */             setDutyAmount((BigDecimal)value);
/* 845 */           } catch (Exception ee) {
/* 846 */             throw new DtxException("An exception occurred while calling setDutyAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrigLocalDateTime":
/*     */           try {
/* 852 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 853 */             setOrigLocalDateTime((String)value);
/* 854 */           } catch (Exception ee) {
/* 855 */             throw new DtxException("An exception occurred while calling setOrigLocalDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrigTransmissionDateTime":
/*     */           try {
/* 861 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 862 */             setOrigTransmissionDateTime((String)value);
/* 863 */           } catch (Exception ee) {
/* 864 */             throw new DtxException("An exception occurred while calling setOrigTransmissionDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrigSTAN":
/*     */           try {
/* 870 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 871 */             setOrigSTAN((String)value);
/* 872 */           } catch (Exception ee) {
/* 873 */             throw new DtxException("An exception occurred while calling setOrigSTAN() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionIdentifier":
/*     */           try {
/* 879 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 880 */             setTransactionIdentifier((String)value);
/* 881 */           } catch (Exception ee) {
/* 882 */             throw new DtxException("An exception occurred while calling setTransactionIdentifier() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CcvErrorCode":
/*     */           try {
/* 888 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 889 */             setCcvErrorCode((String)value);
/* 890 */           } catch (Exception ee) {
/* 891 */             throw new DtxException("An exception occurred while calling setCcvErrorCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PosEntryModeChange":
/*     */           try {
/* 897 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 898 */             setPosEntryModeChange((String)value);
/* 899 */           } catch (Exception ee) {
/* 900 */             throw new DtxException("An exception occurred while calling setPosEntryModeChange() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ProcessingCode":
/*     */           try {
/* 906 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 907 */             setProcessingCode((String)value);
/* 908 */           } catch (Exception ee) {
/* 909 */             throw new DtxException("An exception occurred while calling setProcessingCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PosEntryMode":
/*     */           try {
/* 915 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 916 */             setPosEntryMode((String)value);
/* 917 */           } catch (Exception ee) {
/* 918 */             throw new DtxException("An exception occurred while calling setPosEntryMode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PosAdditionalData":
/*     */           try {
/* 924 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 925 */             setPosAdditionalData((String)value);
/* 926 */           } catch (Exception ee) {
/* 927 */             throw new DtxException("An exception occurred while calling setPosAdditionalData() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NetworkResultIndicator":
/*     */           try {
/* 933 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 934 */             setNetworkResultIndicator((String)value);
/* 935 */           } catch (Exception ee) {
/* 936 */             throw new DtxException("An exception occurred while calling setNetworkResultIndicator() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MerchantCategoryCode":
/*     */           try {
/* 942 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 943 */             setMerchantCategoryCode((String)value);
/* 944 */           } catch (Exception ee) {
/* 945 */             throw new DtxException("An exception occurred while calling setMerchantCategoryCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\CreditDebitTenderLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */