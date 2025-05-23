/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ttr.IdentityVerificationId;
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
/*     */ public class IdentityVerificationDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1897243161L;
/*  23 */   private static final Logger _logger = Logger.getLogger(IdentityVerificationDAO.class);
/*     */   
/*     */   private DtvDate _businessDate;
/*     */   private Integer _identityVerificationSequence;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _idNumber;
/*     */   private String _idTypeCode;
/*     */   private String _issuingAuthority;
/*     */   
/*     */   public Date getBusinessDate() {
/*  41 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  45 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  46 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getIdentityVerificationSequence() {
/*  52 */     return this._identityVerificationSequence;
/*     */   }
/*     */   
/*     */   public void setIdentityVerificationSequence(Integer argIdentityVerificationSequence) {
/*  56 */     if (changed(argIdentityVerificationSequence, this._identityVerificationSequence, "identityVerificationSequence")) {
/*  57 */       this._identityVerificationSequence = argIdentityVerificationSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  62 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  66 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  67 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  72 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  76 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  77 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  82 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  86 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/*  87 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  92 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  96 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  97 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 102 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 106 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 107 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 112 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 116 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 117 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 123 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 127 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 128 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 133 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 137 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 138 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 144 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 148 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 149 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getIdNumber() {
/* 154 */     return this._idNumber;
/*     */   }
/*     */   
/*     */   public void setIdNumber(String argIdNumber) {
/* 158 */     if (changed(argIdNumber, this._idNumber, "idNumber")) {
/* 159 */       this._idNumber = argIdNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getIdTypeCode() {
/* 164 */     return this._idTypeCode;
/*     */   }
/*     */   
/*     */   public void setIdTypeCode(String argIdTypeCode) {
/* 168 */     if (changed(argIdTypeCode, this._idTypeCode, "idTypeCode")) {
/* 169 */       this._idTypeCode = argIdTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getIssuingAuthority() {
/* 174 */     return this._issuingAuthority;
/*     */   }
/*     */   
/*     */   public void setIssuingAuthority(String argIssuingAuthority) {
/* 178 */     if (changed(argIssuingAuthority, this._issuingAuthority, "issuingAuthority")) {
/* 179 */       this._issuingAuthority = argIssuingAuthority;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 186 */     StringBuilder buf = new StringBuilder(512);
/* 187 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 188 */     if (getBusinessDate() != null) {
/* 189 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 191 */     if (getIdentityVerificationSequence() != null) {
/* 192 */       buf.append("identityVerificationSequence").append("=").append(getIdentityVerificationSequence()).append(" ");
/*     */     }
/* 194 */     if (getOrganizationId() != null) {
/* 195 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 197 */     if (getRetailLocationId() != null) {
/* 198 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 200 */     if (getRetailTransactionLineItemSequence() != null) {
/* 201 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 203 */     if (getTransactionSequence() != null) {
/* 204 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 206 */     if (getWorkstationId() != null) {
/* 207 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 209 */     if (getCreateDate() != null) {
/* 210 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 212 */     if (getCreateUserId() != null) {
/* 213 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 215 */     if (getUpdateDate() != null) {
/* 216 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 218 */     if (getUpdateUserId() != null) {
/* 219 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 221 */     if (getIdNumber() != null) {
/* 222 */       buf.append("idNumber").append("=").append(getIdNumber()).append(" ");
/*     */     }
/* 224 */     if (getIdTypeCode() != null) {
/* 225 */       buf.append("idTypeCode").append("=").append(getIdTypeCode()).append(" ");
/*     */     }
/* 227 */     if (getIssuingAuthority() != null) {
/* 228 */       buf.append("issuingAuthority").append("=").append(getIssuingAuthority()).append(" ");
/*     */     }
/*     */     
/* 231 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 235 */     IdentityVerificationId id = new IdentityVerificationId();
/* 236 */     id.setBusinessDate(getBusinessDate());
/* 237 */     id.setIdentityVerificationSequence(getIdentityVerificationSequence());
/* 238 */     id.setOrganizationId(getOrganizationId());
/* 239 */     id.setRetailLocationId(getRetailLocationId());
/* 240 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 241 */     id.setTransactionSequence(getTransactionSequence());
/* 242 */     id.setWorkstationId(getWorkstationId());
/* 243 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 247 */     setBusinessDate(((IdentityVerificationId)argObjectId).getBusinessDate());
/* 248 */     setIdentityVerificationSequence(((IdentityVerificationId)argObjectId).getIdentityVerificationSequence());
/* 249 */     setOrganizationId(((IdentityVerificationId)argObjectId).getOrganizationId());
/* 250 */     setRetailLocationId(((IdentityVerificationId)argObjectId).getRetailLocationId());
/* 251 */     setRetailTransactionLineItemSequence(((IdentityVerificationId)argObjectId).getRetailTransactionLineItemSequence());
/* 252 */     setTransactionSequence(((IdentityVerificationId)argObjectId).getTransactionSequence());
/* 253 */     setWorkstationId(((IdentityVerificationId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 257 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 261 */     StringBuilder buf = new StringBuilder(700);
/* 262 */     buf.append("<").append("dao").append(" name=\"IdentityVerification\" cmd=\"" + getObjectStateString() + "\">");
/* 263 */     getFieldsAsXml(buf);
/* 264 */     buf.append("</").append("dao").append(">");
/*     */     
/* 266 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 270 */     Map<String, String> values = super.getValues();
/* 271 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 272 */     if (this._identityVerificationSequence != null) values.put("IdentityVerificationSequence", DaoUtils.getXmlSafeFieldValue(4, this._identityVerificationSequence)); 
/* 273 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 274 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 275 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 276 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 277 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 278 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 279 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 280 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 281 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 282 */     if (this._idNumber != null) values.put("IdNumber", DaoUtils.getXmlSafeFieldValue(12, this._idNumber)); 
/* 283 */     if (this._idTypeCode != null) values.put("IdTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._idTypeCode)); 
/* 284 */     if (this._issuingAuthority != null) values.put("IssuingAuthority", DaoUtils.getXmlSafeFieldValue(12, this._issuingAuthority)); 
/* 285 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 290 */     super.setValues(argValues);
/* 291 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 293 */       String fieldName = field.getKey();
/* 294 */       String fieldValue = field.getValue();
/* 295 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 299 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 300 */             setBusinessDate((Date)value);
/* 301 */           } catch (Exception ee) {
/* 302 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IdentityVerificationSequence":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 309 */             setIdentityVerificationSequence((Integer)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setIdentityVerificationSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 318 */             setOrganizationId((Long)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 327 */             setRetailLocationId((Long)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 336 */             setRetailTransactionLineItemSequence((Integer)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 344 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 345 */             setTransactionSequence((Long)value);
/* 346 */           } catch (Exception ee) {
/* 347 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 354 */             setWorkstationId((Long)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 363 */             setCreateDate((Date)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 372 */             setCreateUserId((String)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 381 */             setUpdateDate((Date)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 390 */             setUpdateUserId((String)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IdNumber":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 399 */             setIdNumber((String)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setIdNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IdTypeCode":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 408 */             setIdTypeCode((String)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setIdTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IssuingAuthority":
/*     */           try {
/* 416 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 417 */             setIssuingAuthority((String)value);
/* 418 */           } catch (Exception ee) {
/* 419 */             throw new DtxException("An exception occurred while calling setIssuingAuthority() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\IdentityVerificationDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */