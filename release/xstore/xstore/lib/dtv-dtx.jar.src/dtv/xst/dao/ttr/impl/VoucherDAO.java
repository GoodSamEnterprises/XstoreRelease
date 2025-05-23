/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.data2.access.impl.IHasIncrementalValues;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ttr.VoucherId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VoucherDAO
/*     */   extends AbstractDAOImpl
/*     */   implements IHasIncrementalValues
/*     */ {
/*     */   private static final long serialVersionUID = -1990121842L;
/*  23 */   private static final Logger _logger = Logger.getLogger(VoucherDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _serialNumber;
/*     */   private String _voucherTypeCode;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _expirationDate;
/*     */   private BigDecimal _faceValueAmount;
/*     */   private DtvDate _issueDatetimestamp;
/*     */   private String _issueTypeCode;
/*     */   private BigDecimal _unspentBalanceAmount;
/*     */   private BigDecimal _initUnspentBalanceAmount;
/*     */   private String _voucherStatusCode;
/*     */   private String _currencyId;
/*     */   protected boolean _incrementalActive = true;
/*     */   
/*     */   public void setIncrementalActive(boolean argActive) {
/*  44 */     this._incrementalActive = argActive;
/*     */   }
/*     */   
/*     */   public boolean getIncrementalActive() {
/*  48 */     return this._incrementalActive;
/*     */   }
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
/*     */   public String getSerialNumber() {
/*  62 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/*  66 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/*  67 */       this._serialNumber = (argSerialNumber != null && MANAGE_CASE) ? argSerialNumber.toUpperCase() : argSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getVoucherTypeCode() {
/*  72 */     return this._voucherTypeCode;
/*     */   }
/*     */   
/*     */   public void setVoucherTypeCode(String argVoucherTypeCode) {
/*  76 */     if (changed(argVoucherTypeCode, this._voucherTypeCode, "voucherTypeCode")) {
/*  77 */       this._voucherTypeCode = (argVoucherTypeCode != null && MANAGE_CASE) ? argVoucherTypeCode.toUpperCase() : argVoucherTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  82 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  86 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  87 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  93 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  97 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  98 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 103 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 107 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 108 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 114 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 118 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 119 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/* 124 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 128 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/* 129 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 135 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 139 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 140 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getFaceValueAmount() {
/* 146 */     return this._faceValueAmount;
/*     */   }
/*     */   
/*     */   public void setFaceValueAmount(BigDecimal argFaceValueAmount) {
/* 150 */     if (changed(argFaceValueAmount, this._faceValueAmount, "faceValueAmount")) {
/* 151 */       this._faceValueAmount = argFaceValueAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getIssueDatetimestamp() {
/* 156 */     return (Date)this._issueDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setIssueDatetimestamp(Date argIssueDatetimestamp) {
/* 160 */     if (changed(argIssueDatetimestamp, this._issueDatetimestamp, "issueDatetimestamp")) {
/* 161 */       this._issueDatetimestamp = (argIssueDatetimestamp == null || argIssueDatetimestamp instanceof DtvDate) ? (DtvDate)argIssueDatetimestamp : new DtvDate(argIssueDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIssueTypeCode() {
/* 167 */     return this._issueTypeCode;
/*     */   }
/*     */   
/*     */   public void setIssueTypeCode(String argIssueTypeCode) {
/* 171 */     if (changed(argIssueTypeCode, this._issueTypeCode, "issueTypeCode")) {
/* 172 */       this._issueTypeCode = argIssueTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getUnspentBalanceAmount() {
/* 177 */     return this._unspentBalanceAmount;
/*     */   }
/*     */   
/*     */   public BigDecimal getInitUnspentBalanceAmount() {
/* 181 */     return this._initUnspentBalanceAmount;
/*     */   }
/*     */   
/*     */   public void setUnspentBalanceAmount(BigDecimal argUnspentBalanceAmount) {
/* 185 */     if (changed(argUnspentBalanceAmount, this._unspentBalanceAmount, "unspentBalanceAmount")) {
/* 186 */       this._unspentBalanceAmount = argUnspentBalanceAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setInitUnspentBalanceAmount(BigDecimal argUnspentBalanceAmount) {
/* 191 */     this._initUnspentBalanceAmount = argUnspentBalanceAmount;
/*     */   }
/*     */   
/*     */   public String getVoucherStatusCode() {
/* 195 */     return this._voucherStatusCode;
/*     */   }
/*     */   
/*     */   public void setVoucherStatusCode(String argVoucherStatusCode) {
/* 199 */     if (changed(argVoucherStatusCode, this._voucherStatusCode, "voucherStatusCode")) {
/* 200 */       this._voucherStatusCode = argVoucherStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCurrencyId() {
/* 205 */     return this._currencyId;
/*     */   }
/*     */   
/*     */   public void setCurrencyId(String argCurrencyId) {
/* 209 */     if (changed(argCurrencyId, this._currencyId, "currencyId")) {
/* 210 */       this._currencyId = argCurrencyId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private BigDecimal getUnspentBalanceAmountDiff() {
/*     */     BigDecimal val1, val2;
/* 219 */     if (this._unspentBalanceAmount == null) {
/* 220 */       val1 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 223 */       val1 = this._unspentBalanceAmount;
/*     */     } 
/*     */     
/* 226 */     if (this._initUnspentBalanceAmount == null) {
/* 227 */       val2 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 230 */       val2 = this._initUnspentBalanceAmount;
/*     */     } 
/*     */     
/* 233 */     BigDecimal res = val1.subtract(val2);
/*     */     
/* 235 */     if (res.scale() < 8) {
/* 236 */       res = res.setScale(8);
/*     */     }
/*     */     
/* 239 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 244 */     StringBuilder buf = new StringBuilder(512);
/* 245 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 246 */     if (getOrganizationId() != null) {
/* 247 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 249 */     if (getSerialNumber() != null) {
/* 250 */       buf.append("serialNumber").append("=").append(getSerialNumber()).append(" ");
/*     */     }
/* 252 */     if (getVoucherTypeCode() != null) {
/* 253 */       buf.append("voucherTypeCode").append("=").append(getVoucherTypeCode()).append(" ");
/*     */     }
/* 255 */     if (getCreateDate() != null) {
/* 256 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 258 */     if (getCreateUserId() != null) {
/* 259 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 261 */     if (getUpdateDate() != null) {
/* 262 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 264 */     if (getUpdateUserId() != null) {
/* 265 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 267 */     if (getEffectiveDate() != null) {
/* 268 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 270 */     if (getExpirationDate() != null) {
/* 271 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 273 */     if (getFaceValueAmount() != null) {
/* 274 */       buf.append("faceValueAmount").append("=").append(getFaceValueAmount()).append(" ");
/*     */     }
/* 276 */     if (getIssueDatetimestamp() != null) {
/* 277 */       buf.append("issueDatetimestamp").append("=").append(getIssueDatetimestamp()).append(" ");
/*     */     }
/* 279 */     if (getIssueTypeCode() != null) {
/* 280 */       buf.append("issueTypeCode").append("=").append(getIssueTypeCode()).append(" ");
/*     */     }
/* 282 */     if (getUnspentBalanceAmount() != null) {
/* 283 */       buf.append("unspentBalanceAmount").append("=").append(getUnspentBalanceAmount()).append(" ");
/*     */     }
/* 285 */     if (getVoucherStatusCode() != null) {
/* 286 */       buf.append("voucherStatusCode").append("=").append(getVoucherStatusCode()).append(" ");
/*     */     }
/* 288 */     if (getCurrencyId() != null) {
/* 289 */       buf.append("currencyId").append("=").append(getCurrencyId()).append(" ");
/*     */     }
/*     */     
/* 292 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 296 */     VoucherId id = new VoucherId();
/* 297 */     id.setOrganizationId(getOrganizationId());
/* 298 */     id.setSerialNumber(getSerialNumber());
/* 299 */     id.setVoucherTypeCode(getVoucherTypeCode());
/* 300 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 304 */     setOrganizationId(((VoucherId)argObjectId).getOrganizationId());
/* 305 */     setSerialNumber(((VoucherId)argObjectId).getSerialNumber());
/* 306 */     setVoucherTypeCode(((VoucherId)argObjectId).getVoucherTypeCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 310 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 314 */     StringBuilder buf = new StringBuilder(750);
/* 315 */     buf.append("<").append("dao").append(" name=\"Voucher\" cmd=\"" + getObjectStateString() + "\">");
/* 316 */     getFieldsAsXml(buf);
/* 317 */     buf.append("</").append("dao").append(">");
/*     */     
/* 319 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 323 */     Map<String, String> values = super.getValues();
/* 324 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 325 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/* 326 */     if (this._voucherTypeCode != null) values.put("VoucherTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._voucherTypeCode)); 
/* 327 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 328 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 329 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 330 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 331 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 332 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 333 */     if (this._faceValueAmount != null) values.put("FaceValueAmount", DaoUtils.getXmlSafeFieldValue(3, this._faceValueAmount)); 
/* 334 */     if (this._issueDatetimestamp != null) values.put("IssueDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._issueDatetimestamp)); 
/* 335 */     if (this._issueTypeCode != null) values.put("IssueTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._issueTypeCode)); 
/* 336 */     if (this._unspentBalanceAmount != null) values.put("UnspentBalanceAmount", DaoUtils.getXmlSafeFieldValue(3, getUnspentBalanceAmountDiff())); 
/* 337 */     if (this._voucherStatusCode != null) values.put("VoucherStatusCode", DaoUtils.getXmlSafeFieldValue(12, this._voucherStatusCode)); 
/* 338 */     if (this._currencyId != null) values.put("CurrencyId", DaoUtils.getXmlSafeFieldValue(12, this._currencyId)); 
/* 339 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 344 */     super.setValues(argValues);
/* 345 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 347 */       String fieldName = field.getKey();
/* 348 */       String fieldValue = field.getValue();
/* 349 */       switch (fieldName) {
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
/*     */         case "SerialNumber":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 363 */             setSerialNumber((String)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VoucherTypeCode":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 372 */             setVoucherTypeCode((String)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setVoucherTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 381 */             setCreateDate((Date)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 390 */             setCreateUserId((String)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 399 */             setUpdateDate((Date)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 408 */             setUpdateUserId((String)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 416 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 417 */             setEffectiveDate((Date)value);
/* 418 */           } catch (Exception ee) {
/* 419 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 425 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 426 */             setExpirationDate((Date)value);
/* 427 */           } catch (Exception ee) {
/* 428 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FaceValueAmount":
/*     */           try {
/* 434 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 435 */             setFaceValueAmount((BigDecimal)value);
/* 436 */           } catch (Exception ee) {
/* 437 */             throw new DtxException("An exception occurred while calling setFaceValueAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IssueDatetimestamp":
/*     */           try {
/* 443 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 444 */             setIssueDatetimestamp((Date)value);
/* 445 */           } catch (Exception ee) {
/* 446 */             throw new DtxException("An exception occurred while calling setIssueDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IssueTypeCode":
/*     */           try {
/* 452 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 453 */             setIssueTypeCode((String)value);
/* 454 */           } catch (Exception ee) {
/* 455 */             throw new DtxException("An exception occurred while calling setIssueTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UnspentBalanceAmount":
/*     */           try {
/* 461 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 462 */             setUnspentBalanceAmount((BigDecimal)value);
/* 463 */           } catch (Exception ee) {
/* 464 */             throw new DtxException("An exception occurred while calling setUnspentBalanceAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VoucherStatusCode":
/*     */           try {
/* 470 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 471 */             setVoucherStatusCode((String)value);
/* 472 */           } catch (Exception ee) {
/* 473 */             throw new DtxException("An exception occurred while calling setVoucherStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CurrencyId":
/*     */           try {
/* 479 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 480 */             setCurrencyId((String)value);
/* 481 */           } catch (Exception ee) {
/* 482 */             throw new DtxException("An exception occurred while calling setCurrencyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\VoucherDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */