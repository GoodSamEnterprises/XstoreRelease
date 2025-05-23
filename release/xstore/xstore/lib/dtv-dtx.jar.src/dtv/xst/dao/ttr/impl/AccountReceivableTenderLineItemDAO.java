/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
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
/*     */ 
/*     */ public class AccountReceivableTenderLineItemDAO
/*     */   extends TenderLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = -42857340L;
/*  23 */   private static final Logger _logger = Logger.getLogger(AccountReceivableTenderLineItemDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _accountNumber;
/*     */   private String _approvalCode;
/*     */   private Long _partyId;
/*     */   private String _accountUserName;
/*     */   private String _poNumber;
/*     */   private String _adjudicationCode;
/*     */   private String _authorizationMethodCode;
/*     */   private String _activityCode;
/*     */   private String _entryMethodCode;
/*     */   private String _authorizationCode;
/*     */   private String _accountUserId;
/*     */   
/*     */   public Date getCreateDate() {
/*  42 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  46 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  47 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  53 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  57 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  58 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  63 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  67 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  68 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  74 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  78 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  79 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountNumber() {
/*  84 */     return this._accountNumber;
/*     */   }
/*     */   
/*     */   public void setAccountNumber(String argAccountNumber) {
/*  88 */     if (changed(argAccountNumber, this._accountNumber, "accountNumber")) {
/*  89 */       this._accountNumber = argAccountNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getApprovalCode() {
/*  94 */     return this._approvalCode;
/*     */   }
/*     */   
/*     */   public void setApprovalCode(String argApprovalCode) {
/*  98 */     if (changed(argApprovalCode, this._approvalCode, "approvalCode")) {
/*  99 */       this._approvalCode = argApprovalCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/* 104 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/* 108 */     if (changed(argPartyId, this._partyId, "partyId")) {
/* 109 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountUserName() {
/* 114 */     return this._accountUserName;
/*     */   }
/*     */   
/*     */   public void setAccountUserName(String argAccountUserName) {
/* 118 */     if (changed(argAccountUserName, this._accountUserName, "accountUserName")) {
/* 119 */       this._accountUserName = argAccountUserName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPoNumber() {
/* 124 */     return this._poNumber;
/*     */   }
/*     */   
/*     */   public void setPoNumber(String argPoNumber) {
/* 128 */     if (changed(argPoNumber, this._poNumber, "poNumber")) {
/* 129 */       this._poNumber = argPoNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAdjudicationCode() {
/* 134 */     return this._adjudicationCode;
/*     */   }
/*     */   
/*     */   public void setAdjudicationCode(String argAdjudicationCode) {
/* 138 */     if (changed(argAdjudicationCode, this._adjudicationCode, "adjudicationCode")) {
/* 139 */       this._adjudicationCode = argAdjudicationCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorizationMethodCode() {
/* 144 */     return this._authorizationMethodCode;
/*     */   }
/*     */   
/*     */   public void setAuthorizationMethodCode(String argAuthorizationMethodCode) {
/* 148 */     if (changed(argAuthorizationMethodCode, this._authorizationMethodCode, "authorizationMethodCode")) {
/* 149 */       this._authorizationMethodCode = argAuthorizationMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getActivityCode() {
/* 154 */     return this._activityCode;
/*     */   }
/*     */   
/*     */   public void setActivityCode(String argActivityCode) {
/* 158 */     if (changed(argActivityCode, this._activityCode, "activityCode")) {
/* 159 */       this._activityCode = argActivityCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEntryMethodCode() {
/* 164 */     return this._entryMethodCode;
/*     */   }
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/* 168 */     if (changed(argEntryMethodCode, this._entryMethodCode, "entryMethodCode")) {
/* 169 */       this._entryMethodCode = argEntryMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorizationCode() {
/* 174 */     return this._authorizationCode;
/*     */   }
/*     */   
/*     */   public void setAuthorizationCode(String argAuthorizationCode) {
/* 178 */     if (changed(argAuthorizationCode, this._authorizationCode, "authorizationCode")) {
/* 179 */       this._authorizationCode = argAuthorizationCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountUserId() {
/* 184 */     return this._accountUserId;
/*     */   }
/*     */   
/*     */   public void setAccountUserId(String argAccountUserId) {
/* 188 */     if (changed(argAccountUserId, this._accountUserId, "accountUserId")) {
/* 189 */       this._accountUserId = argAccountUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 196 */     StringBuilder buf = new StringBuilder(512);
/* 197 */     buf.append(super.toString());
/* 198 */     if (getCreateDate() != null) {
/* 199 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 201 */     if (getCreateUserId() != null) {
/* 202 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 204 */     if (getUpdateDate() != null) {
/* 205 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 207 */     if (getUpdateUserId() != null) {
/* 208 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 210 */     if (getAccountNumber() != null) {
/* 211 */       buf.append("accountNumber").append("=").append(getAccountNumber()).append(" ");
/*     */     }
/* 213 */     if (getApprovalCode() != null) {
/* 214 */       buf.append("approvalCode").append("=").append(getApprovalCode()).append(" ");
/*     */     }
/* 216 */     if (getPartyId() != null) {
/* 217 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 219 */     if (getAccountUserName() != null) {
/* 220 */       buf.append("accountUserName").append("=").append(getAccountUserName()).append(" ");
/*     */     }
/* 222 */     if (getPoNumber() != null) {
/* 223 */       buf.append("poNumber").append("=").append(getPoNumber()).append(" ");
/*     */     }
/* 225 */     if (getAdjudicationCode() != null) {
/* 226 */       buf.append("adjudicationCode").append("=").append(getAdjudicationCode()).append(" ");
/*     */     }
/* 228 */     if (getAuthorizationMethodCode() != null) {
/* 229 */       buf.append("authorizationMethodCode").append("=").append(getAuthorizationMethodCode()).append(" ");
/*     */     }
/* 231 */     if (getActivityCode() != null) {
/* 232 */       buf.append("activityCode").append("=").append(getActivityCode()).append(" ");
/*     */     }
/* 234 */     if (getEntryMethodCode() != null) {
/* 235 */       buf.append("entryMethodCode").append("=").append(getEntryMethodCode()).append(" ");
/*     */     }
/* 237 */     if (getAuthorizationCode() != null) {
/* 238 */       buf.append("authorizationCode").append("=").append(getAuthorizationCode()).append(" ");
/*     */     }
/* 240 */     if (getAccountUserId() != null) {
/* 241 */       buf.append("accountUserId").append("=").append(getAccountUserId()).append(" ");
/*     */     }
/*     */     
/* 244 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 249 */     StringBuilder buf = new StringBuilder(2400);
/* 250 */     buf.append("<").append("dao").append(" name=\"AccountReceivableTenderLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 251 */     getFieldsAsXml(buf);
/* 252 */     buf.append("</").append("dao").append(">");
/*     */     
/* 254 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 258 */     Map<String, String> values = super.getValues();
/* 259 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 260 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 261 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 262 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 263 */     if (this._accountNumber != null) values.put("AccountNumber", DaoUtils.getXmlSafeFieldValue(12, this._accountNumber)); 
/* 264 */     if (this._approvalCode != null) values.put("ApprovalCode", DaoUtils.getXmlSafeFieldValue(12, this._approvalCode)); 
/* 265 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 266 */     if (this._accountUserName != null) values.put("AccountUserName", DaoUtils.getXmlSafeFieldValue(12, this._accountUserName)); 
/* 267 */     if (this._poNumber != null) values.put("PoNumber", DaoUtils.getXmlSafeFieldValue(12, this._poNumber)); 
/* 268 */     if (this._adjudicationCode != null) values.put("AdjudicationCode", DaoUtils.getXmlSafeFieldValue(12, this._adjudicationCode)); 
/* 269 */     if (this._authorizationMethodCode != null) values.put("AuthorizationMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._authorizationMethodCode)); 
/* 270 */     if (this._activityCode != null) values.put("ActivityCode", DaoUtils.getXmlSafeFieldValue(12, this._activityCode)); 
/* 271 */     if (this._entryMethodCode != null) values.put("EntryMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._entryMethodCode)); 
/* 272 */     if (this._authorizationCode != null) values.put("AuthorizationCode", DaoUtils.getXmlSafeFieldValue(12, this._authorizationCode)); 
/* 273 */     if (this._accountUserId != null) values.put("AccountUserId", DaoUtils.getXmlSafeFieldValue(12, this._accountUserId)); 
/* 274 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 279 */     super.setValues(argValues);
/* 280 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 282 */       String fieldName = field.getKey();
/* 283 */       String fieldValue = field.getValue();
/* 284 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 288 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 289 */             setCreateDate((Date)value);
/* 290 */           } catch (Exception ee) {
/* 291 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 298 */             setCreateUserId((String)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 307 */             setUpdateDate((Date)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 316 */             setUpdateUserId((String)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountNumber":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 325 */             setAccountNumber((String)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setAccountNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ApprovalCode":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 334 */             setApprovalCode((String)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setApprovalCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 343 */             setPartyId((Long)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountUserName":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 352 */             setAccountUserName((String)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setAccountUserName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PoNumber":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 361 */             setPoNumber((String)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setPoNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AdjudicationCode":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 370 */             setAdjudicationCode((String)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setAdjudicationCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationMethodCode":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 379 */             setAuthorizationMethodCode((String)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setAuthorizationMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActivityCode":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 388 */             setActivityCode((String)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setActivityCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EntryMethodCode":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 397 */             setEntryMethodCode((String)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setEntryMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationCode":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 406 */             setAuthorizationCode((String)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setAuthorizationCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountUserId":
/*     */           try {
/* 414 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 415 */             setAccountUserId((String)value);
/* 416 */           } catch (Exception ee) {
/* 417 */             throw new DtxException("An exception occurred while calling setAccountUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\AccountReceivableTenderLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */