/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderCountId;
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
/*     */ public class TenderCountDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 715373179L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderCountDAO.class);
/*     */   
/*     */   private DtvDate _businessDayDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _tenderId;
/*     */   private String _tenderTypeCode;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private BigDecimal _differenceAmount;
/*     */   private Integer _differenceMediaCount;
/*     */   private Integer _mediaCount;
/*     */   private BigDecimal _depositAmount;
/*     */   private BigDecimal _localCurrencyAmount;
/*     */   
/*     */   public Date getBusinessDayDate() {
/*  44 */     return (Date)this._businessDayDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDayDate(Date argBusinessDayDate) {
/*  48 */     if (changed(argBusinessDayDate, this._businessDayDate, "businessDayDate")) {
/*  49 */       this._businessDayDate = (argBusinessDayDate == null || argBusinessDayDate instanceof DtvDate) ? (DtvDate)argBusinessDayDate : new DtvDate(argBusinessDayDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getOrganizationId() {
/*  55 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  59 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  60 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  65 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  69 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  70 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderId() {
/*  75 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/*  79 */     if (changed(argTenderId, this._tenderId, "tenderId")) {
/*  80 */       this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderTypeCode() {
/*  85 */     return this._tenderTypeCode;
/*     */   }
/*     */   
/*     */   public void setTenderTypeCode(String argTenderTypeCode) {
/*  89 */     if (changed(argTenderTypeCode, this._tenderTypeCode, "tenderTypeCode")) {
/*  90 */       this._tenderTypeCode = (argTenderTypeCode != null && MANAGE_CASE) ? argTenderTypeCode.toUpperCase() : argTenderTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  95 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  99 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/* 100 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 105 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 109 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 110 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 115 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 119 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 120 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 126 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 130 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 131 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 136 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 140 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 141 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 147 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 151 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 152 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmount() {
/* 157 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 161 */     if (changed(argAmount, this._amount, "amount")) {
/* 162 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getDifferenceAmount() {
/* 167 */     return this._differenceAmount;
/*     */   }
/*     */   
/*     */   public void setDifferenceAmount(BigDecimal argDifferenceAmount) {
/* 171 */     if (changed(argDifferenceAmount, this._differenceAmount, "differenceAmount")) {
/* 172 */       this._differenceAmount = argDifferenceAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getDifferenceMediaCount() {
/* 177 */     return this._differenceMediaCount;
/*     */   }
/*     */   
/*     */   public void setDifferenceMediaCount(Integer argDifferenceMediaCount) {
/* 181 */     if (changed(argDifferenceMediaCount, this._differenceMediaCount, "differenceMediaCount")) {
/* 182 */       this._differenceMediaCount = argDifferenceMediaCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getMediaCount() {
/* 187 */     return this._mediaCount;
/*     */   }
/*     */   
/*     */   public void setMediaCount(Integer argMediaCount) {
/* 191 */     if (changed(argMediaCount, this._mediaCount, "mediaCount")) {
/* 192 */       this._mediaCount = argMediaCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getDepositAmount() {
/* 197 */     return this._depositAmount;
/*     */   }
/*     */   
/*     */   public void setDepositAmount(BigDecimal argDepositAmount) {
/* 201 */     if (changed(argDepositAmount, this._depositAmount, "depositAmount")) {
/* 202 */       this._depositAmount = argDepositAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getLocalCurrencyAmount() {
/* 207 */     return this._localCurrencyAmount;
/*     */   }
/*     */   
/*     */   public void setLocalCurrencyAmount(BigDecimal argLocalCurrencyAmount) {
/* 211 */     if (changed(argLocalCurrencyAmount, this._localCurrencyAmount, "localCurrencyAmount")) {
/* 212 */       this._localCurrencyAmount = argLocalCurrencyAmount;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 219 */     StringBuilder buf = new StringBuilder(512);
/* 220 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 221 */     if (getBusinessDayDate() != null) {
/* 222 */       buf.append("businessDayDate").append("=").append(getBusinessDayDate()).append(" ");
/*     */     }
/* 224 */     if (getOrganizationId() != null) {
/* 225 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 227 */     if (getRetailLocationId() != null) {
/* 228 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 230 */     if (getTenderId() != null) {
/* 231 */       buf.append("tenderId").append("=").append(getTenderId()).append(" ");
/*     */     }
/* 233 */     if (getTenderTypeCode() != null) {
/* 234 */       buf.append("tenderTypeCode").append("=").append(getTenderTypeCode()).append(" ");
/*     */     }
/* 236 */     if (getTransactionSequence() != null) {
/* 237 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 239 */     if (getWorkstationId() != null) {
/* 240 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 242 */     if (getCreateDate() != null) {
/* 243 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 245 */     if (getCreateUserId() != null) {
/* 246 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 248 */     if (getUpdateDate() != null) {
/* 249 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 251 */     if (getUpdateUserId() != null) {
/* 252 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 254 */     if (getAmount() != null) {
/* 255 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 257 */     if (getDifferenceAmount() != null) {
/* 258 */       buf.append("differenceAmount").append("=").append(getDifferenceAmount()).append(" ");
/*     */     }
/* 260 */     if (getDifferenceMediaCount() != null) {
/* 261 */       buf.append("differenceMediaCount").append("=").append(getDifferenceMediaCount()).append(" ");
/*     */     }
/* 263 */     if (getMediaCount() != null) {
/* 264 */       buf.append("mediaCount").append("=").append(getMediaCount()).append(" ");
/*     */     }
/* 266 */     if (getDepositAmount() != null) {
/* 267 */       buf.append("depositAmount").append("=").append(getDepositAmount()).append(" ");
/*     */     }
/* 269 */     if (getLocalCurrencyAmount() != null) {
/* 270 */       buf.append("localCurrencyAmount").append("=").append(getLocalCurrencyAmount()).append(" ");
/*     */     }
/*     */     
/* 273 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 277 */     TenderCountId id = new TenderCountId();
/* 278 */     id.setBusinessDayDate(getBusinessDayDate());
/* 279 */     id.setOrganizationId(getOrganizationId());
/* 280 */     id.setRetailLocationId(getRetailLocationId());
/* 281 */     id.setTenderId(getTenderId());
/* 282 */     id.setTenderTypeCode(getTenderTypeCode());
/* 283 */     id.setTransactionSequence(getTransactionSequence());
/* 284 */     id.setWorkstationId(getWorkstationId());
/* 285 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 289 */     setBusinessDayDate(((TenderCountId)argObjectId).getBusinessDayDate());
/* 290 */     setOrganizationId(((TenderCountId)argObjectId).getOrganizationId());
/* 291 */     setRetailLocationId(((TenderCountId)argObjectId).getRetailLocationId());
/* 292 */     setTenderId(((TenderCountId)argObjectId).getTenderId());
/* 293 */     setTenderTypeCode(((TenderCountId)argObjectId).getTenderTypeCode());
/* 294 */     setTransactionSequence(((TenderCountId)argObjectId).getTransactionSequence());
/* 295 */     setWorkstationId(((TenderCountId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 299 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 303 */     StringBuilder buf = new StringBuilder(850);
/* 304 */     buf.append("<").append("dao").append(" name=\"TenderCount\" cmd=\"" + getObjectStateString() + "\">");
/* 305 */     getFieldsAsXml(buf);
/* 306 */     buf.append("</").append("dao").append(">");
/*     */     
/* 308 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 312 */     Map<String, String> values = super.getValues();
/* 313 */     if (this._businessDayDate != null) values.put("BusinessDayDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDayDate)); 
/* 314 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 315 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 316 */     if (this._tenderId != null) values.put("TenderId", DaoUtils.getXmlSafeFieldValue(12, this._tenderId)); 
/* 317 */     if (this._tenderTypeCode != null) values.put("TenderTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._tenderTypeCode)); 
/* 318 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 319 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 320 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 321 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 322 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 323 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 324 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 325 */     if (this._differenceAmount != null) values.put("DifferenceAmount", DaoUtils.getXmlSafeFieldValue(3, this._differenceAmount)); 
/* 326 */     if (this._differenceMediaCount != null) values.put("DifferenceMediaCount", DaoUtils.getXmlSafeFieldValue(4, this._differenceMediaCount)); 
/* 327 */     if (this._mediaCount != null) values.put("MediaCount", DaoUtils.getXmlSafeFieldValue(4, this._mediaCount)); 
/* 328 */     if (this._depositAmount != null) values.put("DepositAmount", DaoUtils.getXmlSafeFieldValue(3, this._depositAmount)); 
/* 329 */     if (this._localCurrencyAmount != null) values.put("LocalCurrencyAmount", DaoUtils.getXmlSafeFieldValue(3, this._localCurrencyAmount)); 
/* 330 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 335 */     super.setValues(argValues);
/* 336 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 338 */       String fieldName = field.getKey();
/* 339 */       String fieldValue = field.getValue();
/* 340 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDayDate":
/*     */           try {
/* 344 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 345 */             setBusinessDayDate((Date)value);
/* 346 */           } catch (Exception ee) {
/* 347 */             throw new DtxException("An exception occurred while calling setBusinessDayDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 354 */             setOrganizationId((Long)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 363 */             setRetailLocationId((Long)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderId":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 372 */             setTenderId((String)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setTenderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderTypeCode":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 381 */             setTenderTypeCode((String)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setTenderTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 390 */             setTransactionSequence((Long)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 399 */             setWorkstationId((Long)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 408 */             setCreateDate((Date)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 416 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 417 */             setCreateUserId((String)value);
/* 418 */           } catch (Exception ee) {
/* 419 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 425 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 426 */             setUpdateDate((Date)value);
/* 427 */           } catch (Exception ee) {
/* 428 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 434 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 435 */             setUpdateUserId((String)value);
/* 436 */           } catch (Exception ee) {
/* 437 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 443 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 444 */             setAmount((BigDecimal)value);
/* 445 */           } catch (Exception ee) {
/* 446 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DifferenceAmount":
/*     */           try {
/* 452 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 453 */             setDifferenceAmount((BigDecimal)value);
/* 454 */           } catch (Exception ee) {
/* 455 */             throw new DtxException("An exception occurred while calling setDifferenceAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DifferenceMediaCount":
/*     */           try {
/* 461 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 462 */             setDifferenceMediaCount((Integer)value);
/* 463 */           } catch (Exception ee) {
/* 464 */             throw new DtxException("An exception occurred while calling setDifferenceMediaCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MediaCount":
/*     */           try {
/* 470 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 471 */             setMediaCount((Integer)value);
/* 472 */           } catch (Exception ee) {
/* 473 */             throw new DtxException("An exception occurred while calling setMediaCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DepositAmount":
/*     */           try {
/* 479 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 480 */             setDepositAmount((BigDecimal)value);
/* 481 */           } catch (Exception ee) {
/* 482 */             throw new DtxException("An exception occurred while calling setDepositAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LocalCurrencyAmount":
/*     */           try {
/* 488 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 489 */             setLocalCurrencyAmount((BigDecimal)value);
/* 490 */           } catch (Exception ee) {
/* 491 */             throw new DtxException("An exception occurred while calling setLocalCurrencyAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderCountDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */