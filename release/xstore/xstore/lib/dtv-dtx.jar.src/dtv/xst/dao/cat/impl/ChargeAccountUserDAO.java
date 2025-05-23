/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.ChargeAccountUserId;
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
/*     */ public class ChargeAccountUserDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -143206364L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ChargeAccountUserDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private String _accountUserId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _accountUserName;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _expirationDate;
/*  36 */   private Boolean _primaryContact = Boolean.FALSE;
/*     */   private Long _partyId;
/*     */   private String _accountUserFirstName;
/*     */   private String _accountUserLastName;
/*     */   
/*     */   public Long getOrganizationId() {
/*  42 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  46 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  47 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountId() {
/*  52 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  56 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/*  57 */       this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  62 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  66 */     if (changed(argCustAccountCode, this._custAccountCode, "custAccountCode")) {
/*  67 */       this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountUserId() {
/*  72 */     return this._accountUserId;
/*     */   }
/*     */   
/*     */   public void setAccountUserId(String argAccountUserId) {
/*  76 */     if (changed(argAccountUserId, this._accountUserId, "accountUserId")) {
/*  77 */       this._accountUserId = (argAccountUserId != null && MANAGE_CASE) ? argAccountUserId.toUpperCase() : argAccountUserId;
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
/*     */   public String getAccountUserName() {
/* 124 */     return this._accountUserName;
/*     */   }
/*     */   
/*     */   public void setAccountUserName(String argAccountUserName) {
/* 128 */     if (changed(argAccountUserName, this._accountUserName, "accountUserName")) {
/* 129 */       this._accountUserName = argAccountUserName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/* 134 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 138 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/* 139 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 145 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 149 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 150 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getPrimaryContact() {
/* 156 */     return this._primaryContact;
/*     */   }
/*     */   
/*     */   public void setPrimaryContact(Boolean argPrimaryContact) {
/* 160 */     if (changed(argPrimaryContact, this._primaryContact, "primaryContact")) {
/* 161 */       this._primaryContact = argPrimaryContact;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/* 166 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/* 170 */     if (changed(argPartyId, this._partyId, "partyId")) {
/* 171 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountUserFirstName() {
/* 176 */     return this._accountUserFirstName;
/*     */   }
/*     */   
/*     */   public void setAccountUserFirstName(String argAccountUserFirstName) {
/* 180 */     if (changed(argAccountUserFirstName, this._accountUserFirstName, "accountUserFirstName")) {
/* 181 */       this._accountUserFirstName = argAccountUserFirstName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountUserLastName() {
/* 186 */     return this._accountUserLastName;
/*     */   }
/*     */   
/*     */   public void setAccountUserLastName(String argAccountUserLastName) {
/* 190 */     if (changed(argAccountUserLastName, this._accountUserLastName, "accountUserLastName")) {
/* 191 */       this._accountUserLastName = argAccountUserLastName;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 198 */     StringBuilder buf = new StringBuilder(512);
/* 199 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 200 */     if (getOrganizationId() != null) {
/* 201 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 203 */     if (getCustAccountId() != null) {
/* 204 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/* 206 */     if (getCustAccountCode() != null) {
/* 207 */       buf.append("custAccountCode").append("=").append(getCustAccountCode()).append(" ");
/*     */     }
/* 209 */     if (getAccountUserId() != null) {
/* 210 */       buf.append("accountUserId").append("=").append(getAccountUserId()).append(" ");
/*     */     }
/* 212 */     if (getCreateDate() != null) {
/* 213 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 215 */     if (getCreateUserId() != null) {
/* 216 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 218 */     if (getUpdateDate() != null) {
/* 219 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 221 */     if (getUpdateUserId() != null) {
/* 222 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 224 */     if (getAccountUserName() != null) {
/* 225 */       buf.append("accountUserName").append("=").append(getAccountUserName()).append(" ");
/*     */     }
/* 227 */     if (getEffectiveDate() != null) {
/* 228 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 230 */     if (getExpirationDate() != null) {
/* 231 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 233 */     if (getPrimaryContact() != null && getPrimaryContact().booleanValue()) {
/* 234 */       buf.append("primaryContact").append("=").append(getPrimaryContact()).append(" ");
/*     */     }
/* 236 */     if (getPartyId() != null) {
/* 237 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 239 */     if (getAccountUserFirstName() != null) {
/* 240 */       buf.append("accountUserFirstName").append("=").append(getAccountUserFirstName()).append(" ");
/*     */     }
/* 242 */     if (getAccountUserLastName() != null) {
/* 243 */       buf.append("accountUserLastName").append("=").append(getAccountUserLastName()).append(" ");
/*     */     }
/*     */     
/* 246 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 250 */     ChargeAccountUserId id = new ChargeAccountUserId();
/* 251 */     id.setOrganizationId(getOrganizationId());
/* 252 */     id.setCustAccountId(getCustAccountId());
/* 253 */     id.setCustAccountCode(getCustAccountCode());
/* 254 */     id.setAccountUserId(getAccountUserId());
/* 255 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 259 */     setOrganizationId(((ChargeAccountUserId)argObjectId).getOrganizationId());
/* 260 */     setCustAccountId(((ChargeAccountUserId)argObjectId).getCustAccountId());
/* 261 */     setCustAccountCode(((ChargeAccountUserId)argObjectId).getCustAccountCode());
/* 262 */     setAccountUserId(((ChargeAccountUserId)argObjectId).getAccountUserId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 266 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 270 */     StringBuilder buf = new StringBuilder(750);
/* 271 */     buf.append("<").append("dao").append(" name=\"ChargeAccountUser\" cmd=\"" + getObjectStateString() + "\">");
/* 272 */     getFieldsAsXml(buf);
/* 273 */     buf.append("</").append("dao").append(">");
/*     */     
/* 275 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 279 */     Map<String, String> values = super.getValues();
/* 280 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 281 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 282 */     if (this._custAccountCode != null) values.put("CustAccountCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountCode)); 
/* 283 */     if (this._accountUserId != null) values.put("AccountUserId", DaoUtils.getXmlSafeFieldValue(12, this._accountUserId)); 
/* 284 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 285 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 286 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 287 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 288 */     if (this._accountUserName != null) values.put("AccountUserName", DaoUtils.getXmlSafeFieldValue(12, this._accountUserName)); 
/* 289 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 290 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 291 */     if (this._primaryContact != null) values.put("PrimaryContact", DaoUtils.getXmlSafeFieldValue(-7, this._primaryContact)); 
/* 292 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 293 */     if (this._accountUserFirstName != null) values.put("AccountUserFirstName", DaoUtils.getXmlSafeFieldValue(12, this._accountUserFirstName)); 
/* 294 */     if (this._accountUserLastName != null) values.put("AccountUserLastName", DaoUtils.getXmlSafeFieldValue(12, this._accountUserLastName)); 
/* 295 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 300 */     super.setValues(argValues);
/* 301 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 303 */       String fieldName = field.getKey();
/* 304 */       String fieldValue = field.getValue();
/* 305 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 309 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 310 */             setOrganizationId((Long)value);
/* 311 */           } catch (Exception ee) {
/* 312 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountId":
/*     */           try {
/* 318 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 319 */             setCustAccountId((String)value);
/* 320 */           } catch (Exception ee) {
/* 321 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountCode":
/*     */           try {
/* 327 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 328 */             setCustAccountCode((String)value);
/* 329 */           } catch (Exception ee) {
/* 330 */             throw new DtxException("An exception occurred while calling setCustAccountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountUserId":
/*     */           try {
/* 336 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 337 */             setAccountUserId((String)value);
/* 338 */           } catch (Exception ee) {
/* 339 */             throw new DtxException("An exception occurred while calling setAccountUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 345 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 346 */             setCreateDate((Date)value);
/* 347 */           } catch (Exception ee) {
/* 348 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 354 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 355 */             setCreateUserId((String)value);
/* 356 */           } catch (Exception ee) {
/* 357 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 363 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 364 */             setUpdateDate((Date)value);
/* 365 */           } catch (Exception ee) {
/* 366 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 372 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 373 */             setUpdateUserId((String)value);
/* 374 */           } catch (Exception ee) {
/* 375 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountUserName":
/*     */           try {
/* 381 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 382 */             setAccountUserName((String)value);
/* 383 */           } catch (Exception ee) {
/* 384 */             throw new DtxException("An exception occurred while calling setAccountUserName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 390 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 391 */             setEffectiveDate((Date)value);
/* 392 */           } catch (Exception ee) {
/* 393 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 399 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 400 */             setExpirationDate((Date)value);
/* 401 */           } catch (Exception ee) {
/* 402 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PrimaryContact":
/*     */           try {
/* 408 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 409 */             setPrimaryContact((Boolean)value);
/* 410 */           } catch (Exception ee) {
/* 411 */             throw new DtxException("An exception occurred while calling setPrimaryContact() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 417 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 418 */             setPartyId((Long)value);
/* 419 */           } catch (Exception ee) {
/* 420 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountUserFirstName":
/*     */           try {
/* 426 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 427 */             setAccountUserFirstName((String)value);
/* 428 */           } catch (Exception ee) {
/* 429 */             throw new DtxException("An exception occurred while calling setAccountUserFirstName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountUserLastName":
/*     */           try {
/* 435 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 436 */             setAccountUserLastName((String)value);
/* 437 */           } catch (Exception ee) {
/* 438 */             throw new DtxException("An exception occurred while calling setAccountUserLastName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\ChargeAccountUserDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */