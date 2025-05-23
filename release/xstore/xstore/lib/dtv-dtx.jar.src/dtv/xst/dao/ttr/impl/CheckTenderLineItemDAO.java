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
/*     */ public class CheckTenderLineItemDAO
/*     */   extends TenderLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = -1404906717L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CheckTenderLineItemDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _adjudicationCode;
/*     */   private String _authorizationCode;
/*     */   private String _authorizationMethodCode;
/*     */   private String _bankId;
/*     */   private String _checkAccountNumber;
/*     */   private String _checkSequenceNumber;
/*     */   private DtvDate _customerBirthDate;
/*     */   private String _entryMethodCode;
/*     */   private String _micrData;
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
/*     */   public String getAdjudicationCode() {
/*  82 */     return this._adjudicationCode;
/*     */   }
/*     */   
/*     */   public void setAdjudicationCode(String argAdjudicationCode) {
/*  86 */     if (changed(argAdjudicationCode, this._adjudicationCode, "adjudicationCode")) {
/*  87 */       this._adjudicationCode = argAdjudicationCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorizationCode() {
/*  92 */     return this._authorizationCode;
/*     */   }
/*     */   
/*     */   public void setAuthorizationCode(String argAuthorizationCode) {
/*  96 */     if (changed(argAuthorizationCode, this._authorizationCode, "authorizationCode")) {
/*  97 */       this._authorizationCode = argAuthorizationCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAuthorizationMethodCode() {
/* 102 */     return this._authorizationMethodCode;
/*     */   }
/*     */   
/*     */   public void setAuthorizationMethodCode(String argAuthorizationMethodCode) {
/* 106 */     if (changed(argAuthorizationMethodCode, this._authorizationMethodCode, "authorizationMethodCode")) {
/* 107 */       this._authorizationMethodCode = argAuthorizationMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBankId() {
/* 112 */     return this._bankId;
/*     */   }
/*     */   
/*     */   public void setBankId(String argBankId) {
/* 116 */     if (changed(argBankId, this._bankId, "bankId")) {
/* 117 */       this._bankId = argBankId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCheckAccountNumber() {
/* 122 */     return this._checkAccountNumber;
/*     */   }
/*     */   
/*     */   public void setCheckAccountNumber(String argCheckAccountNumber) {
/* 126 */     if (changed(argCheckAccountNumber, this._checkAccountNumber, "checkAccountNumber")) {
/* 127 */       this._checkAccountNumber = argCheckAccountNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCheckSequenceNumber() {
/* 132 */     return this._checkSequenceNumber;
/*     */   }
/*     */   
/*     */   public void setCheckSequenceNumber(String argCheckSequenceNumber) {
/* 136 */     if (changed(argCheckSequenceNumber, this._checkSequenceNumber, "checkSequenceNumber")) {
/* 137 */       this._checkSequenceNumber = argCheckSequenceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCustomerBirthDate() {
/* 142 */     return (Date)this._customerBirthDate;
/*     */   }
/*     */   
/*     */   public void setCustomerBirthDate(Date argCustomerBirthDate) {
/* 146 */     if (changed(argCustomerBirthDate, this._customerBirthDate, "customerBirthDate")) {
/* 147 */       this._customerBirthDate = (argCustomerBirthDate == null || argCustomerBirthDate instanceof DtvDate) ? (DtvDate)argCustomerBirthDate : new DtvDate(argCustomerBirthDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getEntryMethodCode() {
/* 153 */     return this._entryMethodCode;
/*     */   }
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/* 157 */     if (changed(argEntryMethodCode, this._entryMethodCode, "entryMethodCode")) {
/* 158 */       this._entryMethodCode = argEntryMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMicrData() {
/* 163 */     return this._micrData;
/*     */   }
/*     */   
/*     */   public void setMicrData(String argMicrData) {
/* 167 */     if (changed(argMicrData, this._micrData, "micrData")) {
/* 168 */       this._micrData = argMicrData;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 175 */     StringBuilder buf = new StringBuilder(512);
/* 176 */     buf.append(super.toString());
/* 177 */     if (getCreateDate() != null) {
/* 178 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 180 */     if (getCreateUserId() != null) {
/* 181 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 183 */     if (getUpdateDate() != null) {
/* 184 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 186 */     if (getUpdateUserId() != null) {
/* 187 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 189 */     if (getAdjudicationCode() != null) {
/* 190 */       buf.append("adjudicationCode").append("=").append(getAdjudicationCode()).append(" ");
/*     */     }
/* 192 */     if (getAuthorizationCode() != null) {
/* 193 */       buf.append("authorizationCode").append("=").append(getAuthorizationCode()).append(" ");
/*     */     }
/* 195 */     if (getAuthorizationMethodCode() != null) {
/* 196 */       buf.append("authorizationMethodCode").append("=").append(getAuthorizationMethodCode()).append(" ");
/*     */     }
/* 198 */     if (getBankId() != null) {
/* 199 */       buf.append("bankId").append("=").append(getBankId()).append(" ");
/*     */     }
/* 201 */     if (getCheckAccountNumber() != null) {
/* 202 */       buf.append("checkAccountNumber").append("=").append("[REDACTED]").append(" ");
/*     */     }
/* 204 */     if (getCheckSequenceNumber() != null) {
/* 205 */       buf.append("checkSequenceNumber").append("=").append(getCheckSequenceNumber()).append(" ");
/*     */     }
/* 207 */     if (getCustomerBirthDate() != null) {
/* 208 */       buf.append("customerBirthDate").append("=").append(getCustomerBirthDate()).append(" ");
/*     */     }
/* 210 */     if (getEntryMethodCode() != null) {
/* 211 */       buf.append("entryMethodCode").append("=").append(getEntryMethodCode()).append(" ");
/*     */     }
/* 213 */     if (getMicrData() != null) {
/* 214 */       buf.append("micrData").append("=").append(getMicrData()).append(" ");
/*     */     }
/*     */     
/* 217 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 222 */     StringBuilder buf = new StringBuilder(2300);
/* 223 */     buf.append("<").append("dao").append(" name=\"CheckTenderLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 224 */     getFieldsAsXml(buf);
/* 225 */     buf.append("</").append("dao").append(">");
/*     */     
/* 227 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 231 */     Map<String, String> values = super.getValues();
/* 232 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 233 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 234 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 235 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 236 */     if (this._adjudicationCode != null) values.put("AdjudicationCode", DaoUtils.getXmlSafeFieldValue(12, this._adjudicationCode)); 
/* 237 */     if (this._authorizationCode != null) values.put("AuthorizationCode", DaoUtils.getXmlSafeFieldValue(12, this._authorizationCode)); 
/* 238 */     if (this._authorizationMethodCode != null) values.put("AuthorizationMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._authorizationMethodCode)); 
/* 239 */     if (this._bankId != null) values.put("BankId", DaoUtils.getXmlSafeFieldValue(12, this._bankId)); 
/* 240 */     if (this._checkAccountNumber != null) values.put("CheckAccountNumber", DaoUtils.getXmlSafeFieldValue(12, this._checkAccountNumber)); 
/* 241 */     if (this._checkSequenceNumber != null) values.put("CheckSequenceNumber", DaoUtils.getXmlSafeFieldValue(12, this._checkSequenceNumber)); 
/* 242 */     if (this._customerBirthDate != null) values.put("CustomerBirthDate", DaoUtils.getXmlSafeFieldValue(91, this._customerBirthDate)); 
/* 243 */     if (this._entryMethodCode != null) values.put("EntryMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._entryMethodCode)); 
/* 244 */     if (this._micrData != null) values.put("MicrData", DaoUtils.getXmlSafeFieldValue(12, this._micrData)); 
/* 245 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 250 */     super.setValues(argValues);
/* 251 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 253 */       String fieldName = field.getKey();
/* 254 */       String fieldValue = field.getValue();
/* 255 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 259 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 260 */             setCreateDate((Date)value);
/* 261 */           } catch (Exception ee) {
/* 262 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 268 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 269 */             setCreateUserId((String)value);
/* 270 */           } catch (Exception ee) {
/* 271 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 277 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 278 */             setUpdateDate((Date)value);
/* 279 */           } catch (Exception ee) {
/* 280 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 286 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 287 */             setUpdateUserId((String)value);
/* 288 */           } catch (Exception ee) {
/* 289 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AdjudicationCode":
/*     */           try {
/* 295 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 296 */             setAdjudicationCode((String)value);
/* 297 */           } catch (Exception ee) {
/* 298 */             throw new DtxException("An exception occurred while calling setAdjudicationCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationCode":
/*     */           try {
/* 304 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 305 */             setAuthorizationCode((String)value);
/* 306 */           } catch (Exception ee) {
/* 307 */             throw new DtxException("An exception occurred while calling setAuthorizationCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AuthorizationMethodCode":
/*     */           try {
/* 313 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 314 */             setAuthorizationMethodCode((String)value);
/* 315 */           } catch (Exception ee) {
/* 316 */             throw new DtxException("An exception occurred while calling setAuthorizationMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BankId":
/*     */           try {
/* 322 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 323 */             setBankId((String)value);
/* 324 */           } catch (Exception ee) {
/* 325 */             throw new DtxException("An exception occurred while calling setBankId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CheckAccountNumber":
/*     */           try {
/* 331 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 332 */             setCheckAccountNumber((String)value);
/* 333 */           } catch (Exception ee) {
/* 334 */             throw new DtxException("An exception occurred while calling setCheckAccountNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CheckSequenceNumber":
/*     */           try {
/* 340 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 341 */             setCheckSequenceNumber((String)value);
/* 342 */           } catch (Exception ee) {
/* 343 */             throw new DtxException("An exception occurred while calling setCheckSequenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerBirthDate":
/*     */           try {
/* 349 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 350 */             setCustomerBirthDate((Date)value);
/* 351 */           } catch (Exception ee) {
/* 352 */             throw new DtxException("An exception occurred while calling setCustomerBirthDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EntryMethodCode":
/*     */           try {
/* 358 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 359 */             setEntryMethodCode((String)value);
/* 360 */           } catch (Exception ee) {
/* 361 */             throw new DtxException("An exception occurred while calling setEntryMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MicrData":
/*     */           try {
/* 367 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 368 */             setMicrData((String)value);
/* 369 */           } catch (Exception ee) {
/* 370 */             throw new DtxException("An exception occurred while calling setMicrData() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\CheckTenderLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */