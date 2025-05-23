/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.ChargeAccountHistoryId;
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
/*     */ public class ChargeAccountHistoryDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -284103269L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ChargeAccountHistoryDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Long _historySeq;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _activityDate;
/*     */   private String _activityEnum;
/*     */   private BigDecimal _amt;
/*     */   private Long _partyId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private BigDecimal _accountBalance;
/*     */   private String _accountUserName;
/*     */   private String _accountUserId;
/*  45 */   private Boolean _reversedFlag = Boolean.FALSE;
/*     */   
/*     */   public Long getOrganizationId() {
/*  48 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  52 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  53 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountId() {
/*  58 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  62 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/*  63 */       this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  68 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  72 */     if (changed(argCustAccountCode, this._custAccountCode, "custAccountCode")) {
/*  73 */       this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getHistorySeq() {
/*  78 */     return this._historySeq;
/*     */   }
/*     */   
/*     */   public void setHistorySeq(Long argHistorySeq) {
/*  82 */     if (changed(argHistorySeq, this._historySeq, "historySeq")) {
/*  83 */       this._historySeq = argHistorySeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  88 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  92 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  93 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  99 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 103 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 104 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 109 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 113 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 114 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 120 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 124 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 125 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getActivityDate() {
/* 130 */     return (Date)this._activityDate;
/*     */   }
/*     */   
/*     */   public void setActivityDate(Date argActivityDate) {
/* 134 */     if (changed(argActivityDate, this._activityDate, "activityDate")) {
/* 135 */       this._activityDate = (argActivityDate == null || argActivityDate instanceof DtvDate) ? (DtvDate)argActivityDate : new DtvDate(argActivityDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getActivityEnum() {
/* 141 */     return this._activityEnum;
/*     */   }
/*     */   
/*     */   public void setActivityEnum(String argActivityEnum) {
/* 145 */     if (changed(argActivityEnum, this._activityEnum, "activityEnum")) {
/* 146 */       this._activityEnum = argActivityEnum;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmt() {
/* 151 */     return this._amt;
/*     */   }
/*     */   
/*     */   public void setAmt(BigDecimal argAmt) {
/* 155 */     if (changed(argAmt, this._amt, "amt")) {
/* 156 */       this._amt = argAmt;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/* 161 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/* 165 */     if (changed(argPartyId, this._partyId, "partyId")) {
/* 166 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/* 171 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 175 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/* 176 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransactionSequence() {
/* 182 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/* 186 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/* 187 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 192 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 196 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 197 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/* 202 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 206 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/* 207 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/* 212 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/* 216 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/* 217 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAccountBalance() {
/* 222 */     return this._accountBalance;
/*     */   }
/*     */   
/*     */   public void setAccountBalance(BigDecimal argAccountBalance) {
/* 226 */     if (changed(argAccountBalance, this._accountBalance, "accountBalance")) {
/* 227 */       this._accountBalance = argAccountBalance;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountUserName() {
/* 232 */     return this._accountUserName;
/*     */   }
/*     */   
/*     */   public void setAccountUserName(String argAccountUserName) {
/* 236 */     if (changed(argAccountUserName, this._accountUserName, "accountUserName")) {
/* 237 */       this._accountUserName = argAccountUserName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountUserId() {
/* 242 */     return this._accountUserId;
/*     */   }
/*     */   
/*     */   public void setAccountUserId(String argAccountUserId) {
/* 246 */     if (changed(argAccountUserId, this._accountUserId, "accountUserId")) {
/* 247 */       this._accountUserId = argAccountUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getReversedFlag() {
/* 252 */     return this._reversedFlag;
/*     */   }
/*     */   
/*     */   public void setReversedFlag(Boolean argReversedFlag) {
/* 256 */     if (changed(argReversedFlag, this._reversedFlag, "reversedFlag")) {
/* 257 */       this._reversedFlag = argReversedFlag;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 264 */     StringBuilder buf = new StringBuilder(512);
/* 265 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 266 */     if (getOrganizationId() != null) {
/* 267 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 269 */     if (getCustAccountId() != null) {
/* 270 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/* 272 */     if (getCustAccountCode() != null) {
/* 273 */       buf.append("custAccountCode").append("=").append(getCustAccountCode()).append(" ");
/*     */     }
/* 275 */     if (getHistorySeq() != null) {
/* 276 */       buf.append("historySeq").append("=").append(getHistorySeq()).append(" ");
/*     */     }
/* 278 */     if (getCreateDate() != null) {
/* 279 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 281 */     if (getCreateUserId() != null) {
/* 282 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 284 */     if (getUpdateDate() != null) {
/* 285 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 287 */     if (getUpdateUserId() != null) {
/* 288 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 290 */     if (getActivityDate() != null) {
/* 291 */       buf.append("activityDate").append("=").append(getActivityDate()).append(" ");
/*     */     }
/* 293 */     if (getActivityEnum() != null) {
/* 294 */       buf.append("activityEnum").append("=").append(getActivityEnum()).append(" ");
/*     */     }
/* 296 */     if (getAmt() != null) {
/* 297 */       buf.append("amt").append("=").append(getAmt()).append(" ");
/*     */     }
/* 299 */     if (getPartyId() != null) {
/* 300 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 302 */     if (getBusinessDate() != null) {
/* 303 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 305 */     if (getTransactionSequence() != null) {
/* 306 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 308 */     if (getWorkstationId() != null) {
/* 309 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 311 */     if (getRetailLocationId() != null) {
/* 312 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 314 */     if (getRetailTransactionLineItemSequence() != null) {
/* 315 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 317 */     if (getAccountBalance() != null) {
/* 318 */       buf.append("accountBalance").append("=").append(getAccountBalance()).append(" ");
/*     */     }
/* 320 */     if (getAccountUserName() != null) {
/* 321 */       buf.append("accountUserName").append("=").append(getAccountUserName()).append(" ");
/*     */     }
/* 323 */     if (getAccountUserId() != null) {
/* 324 */       buf.append("accountUserId").append("=").append(getAccountUserId()).append(" ");
/*     */     }
/* 326 */     if (getReversedFlag() != null && getReversedFlag().booleanValue()) {
/* 327 */       buf.append("reversedFlag").append("=").append(getReversedFlag()).append(" ");
/*     */     }
/*     */     
/* 330 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 334 */     ChargeAccountHistoryId id = new ChargeAccountHistoryId();
/* 335 */     id.setOrganizationId(getOrganizationId());
/* 336 */     id.setCustAccountId(getCustAccountId());
/* 337 */     id.setCustAccountCode(getCustAccountCode());
/* 338 */     id.setHistorySeq(getHistorySeq());
/* 339 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 343 */     setOrganizationId(((ChargeAccountHistoryId)argObjectId).getOrganizationId());
/* 344 */     setCustAccountId(((ChargeAccountHistoryId)argObjectId).getCustAccountId());
/* 345 */     setCustAccountCode(((ChargeAccountHistoryId)argObjectId).getCustAccountCode());
/* 346 */     setHistorySeq(((ChargeAccountHistoryId)argObjectId).getHistorySeq());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 350 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 354 */     StringBuilder buf = new StringBuilder(1050);
/* 355 */     buf.append("<").append("dao").append(" name=\"ChargeAccountHistory\" cmd=\"" + getObjectStateString() + "\">");
/* 356 */     getFieldsAsXml(buf);
/* 357 */     buf.append("</").append("dao").append(">");
/*     */     
/* 359 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 363 */     Map<String, String> values = super.getValues();
/* 364 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 365 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 366 */     if (this._custAccountCode != null) values.put("CustAccountCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountCode)); 
/* 367 */     if (this._historySeq != null) values.put("HistorySeq", DaoUtils.getXmlSafeFieldValue(-5, this._historySeq)); 
/* 368 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 369 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 370 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 371 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 372 */     if (this._activityDate != null) values.put("ActivityDate", DaoUtils.getXmlSafeFieldValue(91, this._activityDate)); 
/* 373 */     if (this._activityEnum != null) values.put("ActivityEnum", DaoUtils.getXmlSafeFieldValue(12, this._activityEnum)); 
/* 374 */     if (this._amt != null) values.put("Amt", DaoUtils.getXmlSafeFieldValue(3, this._amt)); 
/* 375 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 376 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 377 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 378 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 379 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 380 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 381 */     if (this._accountBalance != null) values.put("AccountBalance", DaoUtils.getXmlSafeFieldValue(3, this._accountBalance)); 
/* 382 */     if (this._accountUserName != null) values.put("AccountUserName", DaoUtils.getXmlSafeFieldValue(12, this._accountUserName)); 
/* 383 */     if (this._accountUserId != null) values.put("AccountUserId", DaoUtils.getXmlSafeFieldValue(12, this._accountUserId)); 
/* 384 */     if (this._reversedFlag != null) values.put("ReversedFlag", DaoUtils.getXmlSafeFieldValue(-7, this._reversedFlag)); 
/* 385 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 390 */     super.setValues(argValues);
/* 391 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 393 */       String fieldName = field.getKey();
/* 394 */       String fieldValue = field.getValue();
/* 395 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 399 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 400 */             setOrganizationId((Long)value);
/* 401 */           } catch (Exception ee) {
/* 402 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountId":
/*     */           try {
/* 408 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 409 */             setCustAccountId((String)value);
/* 410 */           } catch (Exception ee) {
/* 411 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountCode":
/*     */           try {
/* 417 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 418 */             setCustAccountCode((String)value);
/* 419 */           } catch (Exception ee) {
/* 420 */             throw new DtxException("An exception occurred while calling setCustAccountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "HistorySeq":
/*     */           try {
/* 426 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 427 */             setHistorySeq((Long)value);
/* 428 */           } catch (Exception ee) {
/* 429 */             throw new DtxException("An exception occurred while calling setHistorySeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 435 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 436 */             setCreateDate((Date)value);
/* 437 */           } catch (Exception ee) {
/* 438 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 444 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 445 */             setCreateUserId((String)value);
/* 446 */           } catch (Exception ee) {
/* 447 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 453 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 454 */             setUpdateDate((Date)value);
/* 455 */           } catch (Exception ee) {
/* 456 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 462 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 463 */             setUpdateUserId((String)value);
/* 464 */           } catch (Exception ee) {
/* 465 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActivityDate":
/*     */           try {
/* 471 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 472 */             setActivityDate((Date)value);
/* 473 */           } catch (Exception ee) {
/* 474 */             throw new DtxException("An exception occurred while calling setActivityDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActivityEnum":
/*     */           try {
/* 480 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 481 */             setActivityEnum((String)value);
/* 482 */           } catch (Exception ee) {
/* 483 */             throw new DtxException("An exception occurred while calling setActivityEnum() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amt":
/*     */           try {
/* 489 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 490 */             setAmt((BigDecimal)value);
/* 491 */           } catch (Exception ee) {
/* 492 */             throw new DtxException("An exception occurred while calling setAmt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 498 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 499 */             setPartyId((Long)value);
/* 500 */           } catch (Exception ee) {
/* 501 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 507 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 508 */             setBusinessDate((Date)value);
/* 509 */           } catch (Exception ee) {
/* 510 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 516 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 517 */             setTransactionSequence((Long)value);
/* 518 */           } catch (Exception ee) {
/* 519 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 525 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 526 */             setWorkstationId((Long)value);
/* 527 */           } catch (Exception ee) {
/* 528 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 534 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 535 */             setRetailLocationId((Long)value);
/* 536 */           } catch (Exception ee) {
/* 537 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 543 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 544 */             setRetailTransactionLineItemSequence((Integer)value);
/* 545 */           } catch (Exception ee) {
/* 546 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountBalance":
/*     */           try {
/* 552 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 553 */             setAccountBalance((BigDecimal)value);
/* 554 */           } catch (Exception ee) {
/* 555 */             throw new DtxException("An exception occurred while calling setAccountBalance() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountUserName":
/*     */           try {
/* 561 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 562 */             setAccountUserName((String)value);
/* 563 */           } catch (Exception ee) {
/* 564 */             throw new DtxException("An exception occurred while calling setAccountUserName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountUserId":
/*     */           try {
/* 570 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 571 */             setAccountUserId((String)value);
/* 572 */           } catch (Exception ee) {
/* 573 */             throw new DtxException("An exception occurred while calling setAccountUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReversedFlag":
/*     */           try {
/* 579 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 580 */             setReversedFlag((Boolean)value);
/* 581 */           } catch (Exception ee) {
/* 582 */             throw new DtxException("An exception occurred while calling setReversedFlag() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\ChargeAccountHistoryDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */