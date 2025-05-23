/*     */ package dtv.xst.dao.trl.impl;
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
/*     */ public class AccountReceivableSaleLineItemDAO
/*     */   extends SaleReturnLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = 2138815799L;
/*  23 */   private static final Logger _logger = Logger.getLogger(AccountReceivableSaleLineItemDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _activityCode;
/*     */   private String _adjudicationCode;
/*     */   private String _authorizationCode;
/*     */   private String _authorizationMethodCode;
/*     */   private String _entryMethodCode;
/*     */   private String _accountNumber;
/*     */   private String _bankReferenceNumber;
/*     */   private String _accountUserId;
/*     */   private String _accountUserName;
/*     */   
/*     */   public Date getCreateDate() {
/*  40 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  44 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  45 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  51 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  55 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  56 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  61 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  65 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  66 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  72 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  76 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  77 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getActivityCode() {
/*  82 */     return this._activityCode;
/*     */   }
/*     */   
/*     */   public void setActivityCode(String argActivityCode) {
/*  86 */     if (changed(argActivityCode, this._activityCode, "activityCode")) {
/*  87 */       this._activityCode = argActivityCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAdjudicationCode() {
/*  92 */     return this._adjudicationCode;
/*     */   }
/*     */   
/*     */   public void setAdjudicationCode(String argAdjudicationCode) {
/*  96 */     if (changed(argAdjudicationCode, this._adjudicationCode, "adjudicationCode")) {
/*  97 */       this._adjudicationCode = argAdjudicationCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorizationCode() {
/* 102 */     return this._authorizationCode;
/*     */   }
/*     */   
/*     */   public void setAuthorizationCode(String argAuthorizationCode) {
/* 106 */     if (changed(argAuthorizationCode, this._authorizationCode, "authorizationCode")) {
/* 107 */       this._authorizationCode = argAuthorizationCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorizationMethodCode() {
/* 112 */     return this._authorizationMethodCode;
/*     */   }
/*     */   
/*     */   public void setAuthorizationMethodCode(String argAuthorizationMethodCode) {
/* 116 */     if (changed(argAuthorizationMethodCode, this._authorizationMethodCode, "authorizationMethodCode")) {
/* 117 */       this._authorizationMethodCode = argAuthorizationMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEntryMethodCode() {
/* 122 */     return this._entryMethodCode;
/*     */   }
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/* 126 */     if (changed(argEntryMethodCode, this._entryMethodCode, "entryMethodCode")) {
/* 127 */       this._entryMethodCode = argEntryMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountNumber() {
/* 132 */     return this._accountNumber;
/*     */   }
/*     */   
/*     */   public void setAccountNumber(String argAccountNumber) {
/* 136 */     if (changed(argAccountNumber, this._accountNumber, "accountNumber")) {
/* 137 */       this._accountNumber = argAccountNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBankReferenceNumber() {
/* 142 */     return this._bankReferenceNumber;
/*     */   }
/*     */   
/*     */   public void setBankReferenceNumber(String argBankReferenceNumber) {
/* 146 */     if (changed(argBankReferenceNumber, this._bankReferenceNumber, "bankReferenceNumber")) {
/* 147 */       this._bankReferenceNumber = argBankReferenceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountUserId() {
/* 152 */     return this._accountUserId;
/*     */   }
/*     */   
/*     */   public void setAccountUserId(String argAccountUserId) {
/* 156 */     if (changed(argAccountUserId, this._accountUserId, "accountUserId")) {
/* 157 */       this._accountUserId = argAccountUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountUserName() {
/* 162 */     return this._accountUserName;
/*     */   }
/*     */   
/*     */   public void setAccountUserName(String argAccountUserName) {
/* 166 */     if (changed(argAccountUserName, this._accountUserName, "accountUserName")) {
/* 167 */       this._accountUserName = argAccountUserName;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 174 */     StringBuilder buf = new StringBuilder(512);
/* 175 */     buf.append(super.toString());
/* 176 */     if (getCreateDate() != null) {
/* 177 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 179 */     if (getCreateUserId() != null) {
/* 180 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 182 */     if (getUpdateDate() != null) {
/* 183 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 185 */     if (getUpdateUserId() != null) {
/* 186 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 188 */     if (getActivityCode() != null) {
/* 189 */       buf.append("activityCode").append("=").append(getActivityCode()).append(" ");
/*     */     }
/* 191 */     if (getAdjudicationCode() != null) {
/* 192 */       buf.append("adjudicationCode").append("=").append(getAdjudicationCode()).append(" ");
/*     */     }
/* 194 */     if (getAuthorizationCode() != null) {
/* 195 */       buf.append("authorizationCode").append("=").append(getAuthorizationCode()).append(" ");
/*     */     }
/* 197 */     if (getAuthorizationMethodCode() != null) {
/* 198 */       buf.append("authorizationMethodCode").append("=").append(getAuthorizationMethodCode()).append(" ");
/*     */     }
/* 200 */     if (getEntryMethodCode() != null) {
/* 201 */       buf.append("entryMethodCode").append("=").append(getEntryMethodCode()).append(" ");
/*     */     }
/* 203 */     if (getAccountNumber() != null) {
/* 204 */       buf.append("accountNumber").append("=").append(getAccountNumber()).append(" ");
/*     */     }
/* 206 */     if (getBankReferenceNumber() != null) {
/* 207 */       buf.append("bankReferenceNumber").append("=").append(getBankReferenceNumber()).append(" ");
/*     */     }
/* 209 */     if (getAccountUserId() != null) {
/* 210 */       buf.append("accountUserId").append("=").append(getAccountUserId()).append(" ");
/*     */     }
/* 212 */     if (getAccountUserName() != null) {
/* 213 */       buf.append("accountUserName").append("=").append(getAccountUserName()).append(" ");
/*     */     }
/*     */     
/* 216 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 221 */     StringBuilder buf = new StringBuilder(4300);
/* 222 */     buf.append("<").append("dao").append(" name=\"AccountReceivableSaleLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 223 */     getFieldsAsXml(buf);
/* 224 */     buf.append("</").append("dao").append(">");
/*     */     
/* 226 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 230 */     Map<String, String> values = super.getValues();
/* 231 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 232 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 233 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 234 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 235 */     if (this._activityCode != null) values.put("ActivityCode", DaoUtils.getXmlSafeFieldValue(12, this._activityCode)); 
/* 236 */     if (this._adjudicationCode != null) values.put("AdjudicationCode", DaoUtils.getXmlSafeFieldValue(12, this._adjudicationCode)); 
/* 237 */     if (this._authorizationCode != null) values.put("AuthorizationCode", DaoUtils.getXmlSafeFieldValue(12, this._authorizationCode)); 
/* 238 */     if (this._authorizationMethodCode != null) values.put("AuthorizationMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._authorizationMethodCode)); 
/* 239 */     if (this._entryMethodCode != null) values.put("EntryMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._entryMethodCode)); 
/* 240 */     if (this._accountNumber != null) values.put("AccountNumber", DaoUtils.getXmlSafeFieldValue(12, this._accountNumber)); 
/* 241 */     if (this._bankReferenceNumber != null) values.put("BankReferenceNumber", DaoUtils.getXmlSafeFieldValue(12, this._bankReferenceNumber)); 
/* 242 */     if (this._accountUserId != null) values.put("AccountUserId", DaoUtils.getXmlSafeFieldValue(12, this._accountUserId)); 
/* 243 */     if (this._accountUserName != null) values.put("AccountUserName", DaoUtils.getXmlSafeFieldValue(12, this._accountUserName)); 
/* 244 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 249 */     super.setValues(argValues);
/* 250 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 252 */       String fieldName = field.getKey();
/* 253 */       String fieldValue = field.getValue();
/* 254 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 258 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 259 */             setCreateDate((Date)value);
/* 260 */           } catch (Exception ee) {
/* 261 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 267 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 268 */             setCreateUserId((String)value);
/* 269 */           } catch (Exception ee) {
/* 270 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 276 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 277 */             setUpdateDate((Date)value);
/* 278 */           } catch (Exception ee) {
/* 279 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 285 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 286 */             setUpdateUserId((String)value);
/* 287 */           } catch (Exception ee) {
/* 288 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActivityCode":
/*     */           try {
/* 294 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 295 */             setActivityCode((String)value);
/* 296 */           } catch (Exception ee) {
/* 297 */             throw new DtxException("An exception occurred while calling setActivityCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AdjudicationCode":
/*     */           try {
/* 303 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 304 */             setAdjudicationCode((String)value);
/* 305 */           } catch (Exception ee) {
/* 306 */             throw new DtxException("An exception occurred while calling setAdjudicationCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationCode":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 313 */             setAuthorizationCode((String)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setAuthorizationCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationMethodCode":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 322 */             setAuthorizationMethodCode((String)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setAuthorizationMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EntryMethodCode":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 331 */             setEntryMethodCode((String)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setEntryMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountNumber":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 340 */             setAccountNumber((String)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setAccountNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BankReferenceNumber":
/*     */           try {
/* 348 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 349 */             setBankReferenceNumber((String)value);
/* 350 */           } catch (Exception ee) {
/* 351 */             throw new DtxException("An exception occurred while calling setBankReferenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountUserId":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 358 */             setAccountUserId((String)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setAccountUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountUserName":
/*     */           try {
/* 366 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 367 */             setAccountUserName((String)value);
/* 368 */           } catch (Exception ee) {
/* 369 */             throw new DtxException("An exception occurred while calling setAccountUserName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\AccountReceivableSaleLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */