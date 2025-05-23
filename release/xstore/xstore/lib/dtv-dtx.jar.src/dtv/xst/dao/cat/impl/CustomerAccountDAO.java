/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractExtensibleDAOImpl;
/*     */ import dtv.data2.access.impl.IHasIncrementalValues;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerAccountId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomerAccountDAO
/*     */   extends AbstractExtensibleDAOImpl
/*     */   implements IHasIncrementalValues
/*     */ {
/*     */   private static final long serialVersionUID = -790272945L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerAccountDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private String _className;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _accountBalance;
/*     */   private BigDecimal _initAccountBalance;
/*     */   private Long _retailLocationId;
/*  36 */   private Boolean _custIdentityReq = Boolean.FALSE;
/*     */   private String _custIdentityTypeCode;
/*     */   private String _custAccountStateCode;
/*     */   private DtvDate _accountSetupDate;
/*     */   private DtvDate _lastActivityDate;
/*     */   private Long _partyId;
/*     */   private String _accountPurchaseOrderNumber;
/*     */   protected boolean _incrementalActive = true;
/*     */   
/*     */   public void setIncrementalActive(boolean argActive) {
/*  46 */     this._incrementalActive = argActive;
/*     */   }
/*     */   
/*     */   public boolean getIncrementalActive() {
/*  50 */     return this._incrementalActive;
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  54 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  58 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  59 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountId() {
/*  64 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  68 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/*  69 */       this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  74 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  78 */     if (changed(argCustAccountCode, this._custAccountCode, "custAccountCode")) {
/*  79 */       this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getClassName() {
/*  84 */     return this._className;
/*     */   }
/*     */   
/*     */   public void setClassName(String argClassName) {
/*  88 */     if (changed(argClassName, this._className, "className")) {
/*  89 */       this._className = argClassName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  94 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  98 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  99 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 105 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 109 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 110 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 115 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 119 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 120 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 126 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 130 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 131 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAccountBalance() {
/* 136 */     return this._accountBalance;
/*     */   }
/*     */   
/*     */   public BigDecimal getInitAccountBalance() {
/* 140 */     return this._initAccountBalance;
/*     */   }
/*     */   
/*     */   public void setAccountBalance(BigDecimal argAccountBalance) {
/* 144 */     if (changed(argAccountBalance, this._accountBalance, "accountBalance")) {
/* 145 */       this._accountBalance = argAccountBalance;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setInitAccountBalance(BigDecimal argAccountBalance) {
/* 150 */     this._initAccountBalance = argAccountBalance;
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/* 154 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 158 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/* 159 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getCustIdentityReq() {
/* 164 */     return this._custIdentityReq;
/*     */   }
/*     */   
/*     */   public void setCustIdentityReq(Boolean argCustIdentityReq) {
/* 168 */     if (changed(argCustIdentityReq, this._custIdentityReq, "custIdentityReq")) {
/* 169 */       this._custIdentityReq = argCustIdentityReq;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustIdentityTypeCode() {
/* 174 */     return this._custIdentityTypeCode;
/*     */   }
/*     */   
/*     */   public void setCustIdentityTypeCode(String argCustIdentityTypeCode) {
/* 178 */     if (changed(argCustIdentityTypeCode, this._custIdentityTypeCode, "custIdentityTypeCode")) {
/* 179 */       this._custIdentityTypeCode = argCustIdentityTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountStateCode() {
/* 184 */     return this._custAccountStateCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountStateCode(String argCustAccountStateCode) {
/* 188 */     if (changed(argCustAccountStateCode, this._custAccountStateCode, "custAccountStateCode")) {
/* 189 */       this._custAccountStateCode = argCustAccountStateCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getAccountSetupDate() {
/* 194 */     return (Date)this._accountSetupDate;
/*     */   }
/*     */   
/*     */   public void setAccountSetupDate(Date argAccountSetupDate) {
/* 198 */     if (changed(argAccountSetupDate, this._accountSetupDate, "accountSetupDate")) {
/* 199 */       this._accountSetupDate = (argAccountSetupDate == null || argAccountSetupDate instanceof DtvDate) ? (DtvDate)argAccountSetupDate : new DtvDate(argAccountSetupDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getLastActivityDate() {
/* 205 */     return (Date)this._lastActivityDate;
/*     */   }
/*     */   
/*     */   public void setLastActivityDate(Date argLastActivityDate) {
/* 209 */     if (changed(argLastActivityDate, this._lastActivityDate, "lastActivityDate")) {
/* 210 */       this._lastActivityDate = (argLastActivityDate == null || argLastActivityDate instanceof DtvDate) ? (DtvDate)argLastActivityDate : new DtvDate(argLastActivityDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getPartyId() {
/* 216 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/* 220 */     if (changed(argPartyId, this._partyId, "partyId")) {
/* 221 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountPurchaseOrderNumber() {
/* 226 */     return this._accountPurchaseOrderNumber;
/*     */   }
/*     */   
/*     */   public void setAccountPurchaseOrderNumber(String argAccountPurchaseOrderNumber) {
/* 230 */     if (changed(argAccountPurchaseOrderNumber, this._accountPurchaseOrderNumber, "accountPurchaseOrderNumber")) {
/* 231 */       this._accountPurchaseOrderNumber = argAccountPurchaseOrderNumber;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private BigDecimal getAccountBalanceDiff() {
/*     */     BigDecimal val1, val2;
/* 240 */     if (this._accountBalance == null) {
/* 241 */       val1 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 244 */       val1 = this._accountBalance;
/*     */     } 
/*     */     
/* 247 */     if (this._initAccountBalance == null) {
/* 248 */       val2 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 251 */       val2 = this._initAccountBalance;
/*     */     } 
/*     */     
/* 254 */     BigDecimal res = val1.subtract(val2);
/*     */     
/* 256 */     if (res.scale() < 8) {
/* 257 */       res = res.setScale(8);
/*     */     }
/*     */     
/* 260 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 265 */     StringBuilder buf = new StringBuilder(512);
/* 266 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 267 */     if (getOrganizationId() != null) {
/* 268 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 270 */     if (getCustAccountId() != null) {
/* 271 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/* 273 */     if (getCustAccountCode() != null) {
/* 274 */       buf.append("custAccountCode").append("=").append(getCustAccountCode()).append(" ");
/*     */     }
/* 276 */     if (getClassName() != null) {
/* 277 */       buf.append("className").append("=").append(getClassName()).append(" ");
/*     */     }
/* 279 */     if (getCreateDate() != null) {
/* 280 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 282 */     if (getCreateUserId() != null) {
/* 283 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 285 */     if (getUpdateDate() != null) {
/* 286 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 288 */     if (getUpdateUserId() != null) {
/* 289 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 291 */     if (getAccountBalance() != null) {
/* 292 */       buf.append("accountBalance").append("=").append(getAccountBalance()).append(" ");
/*     */     }
/* 294 */     if (getRetailLocationId() != null) {
/* 295 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 297 */     if (getCustIdentityReq() != null && getCustIdentityReq().booleanValue()) {
/* 298 */       buf.append("custIdentityReq").append("=").append(getCustIdentityReq()).append(" ");
/*     */     }
/* 300 */     if (getCustIdentityTypeCode() != null) {
/* 301 */       buf.append("custIdentityTypeCode").append("=").append(getCustIdentityTypeCode()).append(" ");
/*     */     }
/* 303 */     if (getCustAccountStateCode() != null) {
/* 304 */       buf.append("custAccountStateCode").append("=").append(getCustAccountStateCode()).append(" ");
/*     */     }
/* 306 */     if (getAccountSetupDate() != null) {
/* 307 */       buf.append("accountSetupDate").append("=").append(getAccountSetupDate()).append(" ");
/*     */     }
/* 309 */     if (getLastActivityDate() != null) {
/* 310 */       buf.append("lastActivityDate").append("=").append(getLastActivityDate()).append(" ");
/*     */     }
/* 312 */     if (getPartyId() != null) {
/* 313 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 315 */     if (getAccountPurchaseOrderNumber() != null) {
/* 316 */       buf.append("accountPurchaseOrderNumber").append("=").append(getAccountPurchaseOrderNumber()).append(" ");
/*     */     }
/*     */     
/* 319 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 323 */     CustomerAccountId id = new CustomerAccountId();
/* 324 */     id.setOrganizationId(getOrganizationId());
/* 325 */     id.setCustAccountId(getCustAccountId());
/* 326 */     id.setCustAccountCode(getCustAccountCode());
/* 327 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 331 */     setOrganizationId(((CustomerAccountId)argObjectId).getOrganizationId());
/* 332 */     setCustAccountId(((CustomerAccountId)argObjectId).getCustAccountId());
/* 333 */     setCustAccountCode(((CustomerAccountId)argObjectId).getCustAccountCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 337 */     return this._className;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 341 */     StringBuilder buf = new StringBuilder(850);
/* 342 */     buf.append("<").append("dao").append(" name=\"CustomerAccount\" cmd=\"" + getObjectStateString() + "\">");
/* 343 */     getFieldsAsXml(buf);
/* 344 */     buf.append("</").append("dao").append(">");
/*     */     
/* 346 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 350 */     Map<String, String> values = super.getValues();
/* 351 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 352 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 353 */     if (this._custAccountCode != null) values.put("CustAccountCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountCode)); 
/* 354 */     if (this._className != null) values.put("ClassName", DaoUtils.getXmlSafeFieldValue(12, this._className)); 
/* 355 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 356 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 357 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 358 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 359 */     if (this._accountBalance != null) values.put("AccountBalance", DaoUtils.getXmlSafeFieldValue(3, getAccountBalanceDiff())); 
/* 360 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 361 */     if (this._custIdentityReq != null) values.put("CustIdentityReq", DaoUtils.getXmlSafeFieldValue(-7, this._custIdentityReq)); 
/* 362 */     if (this._custIdentityTypeCode != null) values.put("CustIdentityTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._custIdentityTypeCode)); 
/* 363 */     if (this._custAccountStateCode != null) values.put("CustAccountStateCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountStateCode)); 
/* 364 */     if (this._accountSetupDate != null) values.put("AccountSetupDate", DaoUtils.getXmlSafeFieldValue(91, this._accountSetupDate)); 
/* 365 */     if (this._lastActivityDate != null) values.put("LastActivityDate", DaoUtils.getXmlSafeFieldValue(91, this._lastActivityDate)); 
/* 366 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 367 */     if (this._accountPurchaseOrderNumber != null) values.put("AccountPurchaseOrderNumber", DaoUtils.getXmlSafeFieldValue(12, this._accountPurchaseOrderNumber)); 
/* 368 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 373 */     super.setValues(argValues);
/* 374 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 376 */       String fieldName = field.getKey();
/* 377 */       String fieldValue = field.getValue();
/* 378 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 382 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 383 */             setOrganizationId((Long)value);
/* 384 */           } catch (Exception ee) {
/* 385 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountId":
/*     */           try {
/* 391 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 392 */             setCustAccountId((String)value);
/* 393 */           } catch (Exception ee) {
/* 394 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountCode":
/*     */           try {
/* 400 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 401 */             setCustAccountCode((String)value);
/* 402 */           } catch (Exception ee) {
/* 403 */             throw new DtxException("An exception occurred while calling setCustAccountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ClassName":
/*     */           try {
/* 409 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 410 */             setClassName((String)value);
/* 411 */           } catch (Exception ee) {
/* 412 */             throw new DtxException("An exception occurred while calling setClassName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 418 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 419 */             setCreateDate((Date)value);
/* 420 */           } catch (Exception ee) {
/* 421 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 427 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 428 */             setCreateUserId((String)value);
/* 429 */           } catch (Exception ee) {
/* 430 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 436 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 437 */             setUpdateDate((Date)value);
/* 438 */           } catch (Exception ee) {
/* 439 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 445 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 446 */             setUpdateUserId((String)value);
/* 447 */           } catch (Exception ee) {
/* 448 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountBalance":
/*     */           try {
/* 454 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 455 */             setAccountBalance((BigDecimal)value);
/* 456 */           } catch (Exception ee) {
/* 457 */             throw new DtxException("An exception occurred while calling setAccountBalance() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 463 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 464 */             setRetailLocationId((Long)value);
/* 465 */           } catch (Exception ee) {
/* 466 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustIdentityReq":
/*     */           try {
/* 472 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 473 */             setCustIdentityReq((Boolean)value);
/* 474 */           } catch (Exception ee) {
/* 475 */             throw new DtxException("An exception occurred while calling setCustIdentityReq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustIdentityTypeCode":
/*     */           try {
/* 481 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 482 */             setCustIdentityTypeCode((String)value);
/* 483 */           } catch (Exception ee) {
/* 484 */             throw new DtxException("An exception occurred while calling setCustIdentityTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountStateCode":
/*     */           try {
/* 490 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 491 */             setCustAccountStateCode((String)value);
/* 492 */           } catch (Exception ee) {
/* 493 */             throw new DtxException("An exception occurred while calling setCustAccountStateCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountSetupDate":
/*     */           try {
/* 499 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 500 */             setAccountSetupDate((Date)value);
/* 501 */           } catch (Exception ee) {
/* 502 */             throw new DtxException("An exception occurred while calling setAccountSetupDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LastActivityDate":
/*     */           try {
/* 508 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 509 */             setLastActivityDate((Date)value);
/* 510 */           } catch (Exception ee) {
/* 511 */             throw new DtxException("An exception occurred while calling setLastActivityDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 517 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 518 */             setPartyId((Long)value);
/* 519 */           } catch (Exception ee) {
/* 520 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountPurchaseOrderNumber":
/*     */           try {
/* 526 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 527 */             setAccountPurchaseOrderNumber((String)value);
/* 528 */           } catch (Exception ee) {
/* 529 */             throw new DtxException("An exception occurred while calling setAccountPurchaseOrderNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */