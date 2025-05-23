/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractExtensibleDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerAccountJournalId;
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
/*     */ public class CustomerAccountJournalDAO
/*     */   extends AbstractExtensibleDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1713126376L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerAccountJournalDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Long _journalSequence;
/*     */   private String _className;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _retailLocationId;
/*     */   private BigDecimal _accountBalance;
/*     */   private String _custIdentityTypeCode;
/*     */   private Long _transRetailLocationId;
/*     */   private Long _transWorkstationId;
/*     */   private DtvDate _transBusinessDate;
/*     */   private Long _transSequence;
/*     */   private Long _partyId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  44 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  48 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  49 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountId() {
/*  54 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  58 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/*  59 */       this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  64 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  68 */     if (changed(argCustAccountCode, this._custAccountCode, "custAccountCode")) {
/*  69 */       this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getJournalSequence() {
/*  74 */     return this._journalSequence;
/*     */   }
/*     */   
/*     */   public void setJournalSequence(Long argJournalSequence) {
/*  78 */     if (changed(argJournalSequence, this._journalSequence, "journalSequence")) {
/*  79 */       this._journalSequence = argJournalSequence;
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
/*     */   public Long getRetailLocationId() {
/* 136 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 140 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/* 141 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAccountBalance() {
/* 146 */     return this._accountBalance;
/*     */   }
/*     */   
/*     */   public void setAccountBalance(BigDecimal argAccountBalance) {
/* 150 */     if (changed(argAccountBalance, this._accountBalance, "accountBalance")) {
/* 151 */       this._accountBalance = argAccountBalance;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustIdentityTypeCode() {
/* 156 */     return this._custIdentityTypeCode;
/*     */   }
/*     */   
/*     */   public void setCustIdentityTypeCode(String argCustIdentityTypeCode) {
/* 160 */     if (changed(argCustIdentityTypeCode, this._custIdentityTypeCode, "custIdentityTypeCode")) {
/* 161 */       this._custIdentityTypeCode = argCustIdentityTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransRetailLocationId() {
/* 166 */     return this._transRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setTransRetailLocationId(Long argTransRetailLocationId) {
/* 170 */     if (changed(argTransRetailLocationId, this._transRetailLocationId, "transRetailLocationId")) {
/* 171 */       this._transRetailLocationId = argTransRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransWorkstationId() {
/* 176 */     return this._transWorkstationId;
/*     */   }
/*     */   
/*     */   public void setTransWorkstationId(Long argTransWorkstationId) {
/* 180 */     if (changed(argTransWorkstationId, this._transWorkstationId, "transWorkstationId")) {
/* 181 */       this._transWorkstationId = argTransWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getTransBusinessDate() {
/* 186 */     return (Date)this._transBusinessDate;
/*     */   }
/*     */   
/*     */   public void setTransBusinessDate(Date argTransBusinessDate) {
/* 190 */     if (changed(argTransBusinessDate, this._transBusinessDate, "transBusinessDate")) {
/* 191 */       this._transBusinessDate = (argTransBusinessDate == null || argTransBusinessDate instanceof DtvDate) ? (DtvDate)argTransBusinessDate : new DtvDate(argTransBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransSequence() {
/* 197 */     return this._transSequence;
/*     */   }
/*     */   
/*     */   public void setTransSequence(Long argTransSequence) {
/* 201 */     if (changed(argTransSequence, this._transSequence, "transSequence")) {
/* 202 */       this._transSequence = argTransSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/* 207 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/* 211 */     if (changed(argPartyId, this._partyId, "partyId")) {
/* 212 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 219 */     StringBuilder buf = new StringBuilder(512);
/* 220 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 221 */     if (getOrganizationId() != null) {
/* 222 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 224 */     if (getCustAccountId() != null) {
/* 225 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/* 227 */     if (getCustAccountCode() != null) {
/* 228 */       buf.append("custAccountCode").append("=").append(getCustAccountCode()).append(" ");
/*     */     }
/* 230 */     if (getJournalSequence() != null) {
/* 231 */       buf.append("journalSequence").append("=").append(getJournalSequence()).append(" ");
/*     */     }
/* 233 */     if (getClassName() != null) {
/* 234 */       buf.append("className").append("=").append(getClassName()).append(" ");
/*     */     }
/* 236 */     if (getCreateDate() != null) {
/* 237 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 239 */     if (getCreateUserId() != null) {
/* 240 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 242 */     if (getUpdateDate() != null) {
/* 243 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 245 */     if (getUpdateUserId() != null) {
/* 246 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 248 */     if (getRetailLocationId() != null) {
/* 249 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 251 */     if (getAccountBalance() != null) {
/* 252 */       buf.append("accountBalance").append("=").append(getAccountBalance()).append(" ");
/*     */     }
/* 254 */     if (getCustIdentityTypeCode() != null) {
/* 255 */       buf.append("custIdentityTypeCode").append("=").append(getCustIdentityTypeCode()).append(" ");
/*     */     }
/* 257 */     if (getTransRetailLocationId() != null) {
/* 258 */       buf.append("transRetailLocationId").append("=").append(getTransRetailLocationId()).append(" ");
/*     */     }
/* 260 */     if (getTransWorkstationId() != null) {
/* 261 */       buf.append("transWorkstationId").append("=").append(getTransWorkstationId()).append(" ");
/*     */     }
/* 263 */     if (getTransBusinessDate() != null) {
/* 264 */       buf.append("transBusinessDate").append("=").append(getTransBusinessDate()).append(" ");
/*     */     }
/* 266 */     if (getTransSequence() != null) {
/* 267 */       buf.append("transSequence").append("=").append(getTransSequence()).append(" ");
/*     */     }
/* 269 */     if (getPartyId() != null) {
/* 270 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/*     */     
/* 273 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 277 */     CustomerAccountJournalId id = new CustomerAccountJournalId();
/* 278 */     id.setOrganizationId(getOrganizationId());
/* 279 */     id.setCustAccountId(getCustAccountId());
/* 280 */     id.setCustAccountCode(getCustAccountCode());
/* 281 */     id.setJournalSequence(getJournalSequence());
/* 282 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 286 */     setOrganizationId(((CustomerAccountJournalId)argObjectId).getOrganizationId());
/* 287 */     setCustAccountId(((CustomerAccountJournalId)argObjectId).getCustAccountId());
/* 288 */     setCustAccountCode(((CustomerAccountJournalId)argObjectId).getCustAccountCode());
/* 289 */     setJournalSequence(((CustomerAccountJournalId)argObjectId).getJournalSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 293 */     return this._className;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 297 */     StringBuilder buf = new StringBuilder(850);
/* 298 */     buf.append("<").append("dao").append(" name=\"CustomerAccountJournal\" cmd=\"" + getObjectStateString() + "\">");
/* 299 */     getFieldsAsXml(buf);
/* 300 */     buf.append("</").append("dao").append(">");
/*     */     
/* 302 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 306 */     Map<String, String> values = super.getValues();
/* 307 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 308 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 309 */     if (this._custAccountCode != null) values.put("CustAccountCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountCode)); 
/* 310 */     if (this._journalSequence != null) values.put("JournalSequence", DaoUtils.getXmlSafeFieldValue(-5, this._journalSequence)); 
/* 311 */     if (this._className != null) values.put("ClassName", DaoUtils.getXmlSafeFieldValue(12, this._className)); 
/* 312 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 313 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 314 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 315 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 316 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 317 */     if (this._accountBalance != null) values.put("AccountBalance", DaoUtils.getXmlSafeFieldValue(3, this._accountBalance)); 
/* 318 */     if (this._custIdentityTypeCode != null) values.put("CustIdentityTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._custIdentityTypeCode)); 
/* 319 */     if (this._transRetailLocationId != null) values.put("TransRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._transRetailLocationId)); 
/* 320 */     if (this._transWorkstationId != null) values.put("TransWorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._transWorkstationId)); 
/* 321 */     if (this._transBusinessDate != null) values.put("TransBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._transBusinessDate)); 
/* 322 */     if (this._transSequence != null) values.put("TransSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transSequence)); 
/* 323 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 324 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 329 */     super.setValues(argValues);
/* 330 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 332 */       String fieldName = field.getKey();
/* 333 */       String fieldValue = field.getValue();
/* 334 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 338 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 339 */             setOrganizationId((Long)value);
/* 340 */           } catch (Exception ee) {
/* 341 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountId":
/*     */           try {
/* 347 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 348 */             setCustAccountId((String)value);
/* 349 */           } catch (Exception ee) {
/* 350 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountCode":
/*     */           try {
/* 356 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 357 */             setCustAccountCode((String)value);
/* 358 */           } catch (Exception ee) {
/* 359 */             throw new DtxException("An exception occurred while calling setCustAccountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "JournalSequence":
/*     */           try {
/* 365 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 366 */             setJournalSequence((Long)value);
/* 367 */           } catch (Exception ee) {
/* 368 */             throw new DtxException("An exception occurred while calling setJournalSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ClassName":
/*     */           try {
/* 374 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 375 */             setClassName((String)value);
/* 376 */           } catch (Exception ee) {
/* 377 */             throw new DtxException("An exception occurred while calling setClassName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 383 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 384 */             setCreateDate((Date)value);
/* 385 */           } catch (Exception ee) {
/* 386 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 392 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 393 */             setCreateUserId((String)value);
/* 394 */           } catch (Exception ee) {
/* 395 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 401 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 402 */             setUpdateDate((Date)value);
/* 403 */           } catch (Exception ee) {
/* 404 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 410 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 411 */             setUpdateUserId((String)value);
/* 412 */           } catch (Exception ee) {
/* 413 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 419 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 420 */             setRetailLocationId((Long)value);
/* 421 */           } catch (Exception ee) {
/* 422 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountBalance":
/*     */           try {
/* 428 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 429 */             setAccountBalance((BigDecimal)value);
/* 430 */           } catch (Exception ee) {
/* 431 */             throw new DtxException("An exception occurred while calling setAccountBalance() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustIdentityTypeCode":
/*     */           try {
/* 437 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 438 */             setCustIdentityTypeCode((String)value);
/* 439 */           } catch (Exception ee) {
/* 440 */             throw new DtxException("An exception occurred while calling setCustIdentityTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransRetailLocationId":
/*     */           try {
/* 446 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 447 */             setTransRetailLocationId((Long)value);
/* 448 */           } catch (Exception ee) {
/* 449 */             throw new DtxException("An exception occurred while calling setTransRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransWorkstationId":
/*     */           try {
/* 455 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 456 */             setTransWorkstationId((Long)value);
/* 457 */           } catch (Exception ee) {
/* 458 */             throw new DtxException("An exception occurred while calling setTransWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransBusinessDate":
/*     */           try {
/* 464 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 465 */             setTransBusinessDate((Date)value);
/* 466 */           } catch (Exception ee) {
/* 467 */             throw new DtxException("An exception occurred while calling setTransBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransSequence":
/*     */           try {
/* 473 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 474 */             setTransSequence((Long)value);
/* 475 */           } catch (Exception ee) {
/* 476 */             throw new DtxException("An exception occurred while calling setTransSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 482 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 483 */             setPartyId((Long)value);
/* 484 */           } catch (Exception ee) {
/* 485 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountJournalDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */