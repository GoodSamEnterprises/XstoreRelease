/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ttr.VoucherHistoryId;
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
/*     */ public class VoucherHistoryDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -41453018L;
/*  23 */   private static final Logger _logger = Logger.getLogger(VoucherHistoryDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _serialNumber;
/*     */   private String _voucherTypeCode;
/*     */   private Long _historySequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _activityCode;
/*     */   private BigDecimal _amount;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _transactionSequence;
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
/*     */   public String getSerialNumber() {
/*  52 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/*  56 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/*  57 */       this._serialNumber = (argSerialNumber != null && MANAGE_CASE) ? argSerialNumber.toUpperCase() : argSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getVoucherTypeCode() {
/*  62 */     return this._voucherTypeCode;
/*     */   }
/*     */   
/*     */   public void setVoucherTypeCode(String argVoucherTypeCode) {
/*  66 */     if (changed(argVoucherTypeCode, this._voucherTypeCode, "voucherTypeCode")) {
/*  67 */       this._voucherTypeCode = (argVoucherTypeCode != null && MANAGE_CASE) ? argVoucherTypeCode.toUpperCase() : argVoucherTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getHistorySequence() {
/*  72 */     return this._historySequence;
/*     */   }
/*     */   
/*     */   public void setHistorySequence(Long argHistorySequence) {
/*  76 */     if (changed(argHistorySequence, this._historySequence, "historySequence")) {
/*  77 */       this._historySequence = argHistorySequence;
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
/*     */   public String getActivityCode() {
/* 124 */     return this._activityCode;
/*     */   }
/*     */   
/*     */   public void setActivityCode(String argActivityCode) {
/* 128 */     if (changed(argActivityCode, this._activityCode, "activityCode")) {
/* 129 */       this._activityCode = argActivityCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmount() {
/* 134 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 138 */     if (changed(argAmount, this._amount, "amount")) {
/* 139 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/* 144 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/* 148 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/* 149 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
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
/*     */   public Long getWorkstationId() {
/* 164 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 168 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 169 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/* 174 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 178 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/* 179 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransactionSequence() {
/* 185 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/* 189 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/* 190 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 197 */     StringBuilder buf = new StringBuilder(512);
/* 198 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 199 */     if (getOrganizationId() != null) {
/* 200 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 202 */     if (getSerialNumber() != null) {
/* 203 */       buf.append("serialNumber").append("=").append(getSerialNumber()).append(" ");
/*     */     }
/* 205 */     if (getVoucherTypeCode() != null) {
/* 206 */       buf.append("voucherTypeCode").append("=").append(getVoucherTypeCode()).append(" ");
/*     */     }
/* 208 */     if (getHistorySequence() != null) {
/* 209 */       buf.append("historySequence").append("=").append(getHistorySequence()).append(" ");
/*     */     }
/* 211 */     if (getCreateDate() != null) {
/* 212 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 214 */     if (getCreateUserId() != null) {
/* 215 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 217 */     if (getUpdateDate() != null) {
/* 218 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 220 */     if (getUpdateUserId() != null) {
/* 221 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 223 */     if (getActivityCode() != null) {
/* 224 */       buf.append("activityCode").append("=").append(getActivityCode()).append(" ");
/*     */     }
/* 226 */     if (getAmount() != null) {
/* 227 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 229 */     if (getRetailTransactionLineItemSequence() != null) {
/* 230 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 232 */     if (getRetailLocationId() != null) {
/* 233 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 235 */     if (getWorkstationId() != null) {
/* 236 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 238 */     if (getBusinessDate() != null) {
/* 239 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 241 */     if (getTransactionSequence() != null) {
/* 242 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/*     */     
/* 245 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 249 */     VoucherHistoryId id = new VoucherHistoryId();
/* 250 */     id.setOrganizationId(getOrganizationId());
/* 251 */     id.setSerialNumber(getSerialNumber());
/* 252 */     id.setVoucherTypeCode(getVoucherTypeCode());
/* 253 */     id.setHistorySequence(getHistorySequence());
/* 254 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 258 */     setOrganizationId(((VoucherHistoryId)argObjectId).getOrganizationId());
/* 259 */     setSerialNumber(((VoucherHistoryId)argObjectId).getSerialNumber());
/* 260 */     setVoucherTypeCode(((VoucherHistoryId)argObjectId).getVoucherTypeCode());
/* 261 */     setHistorySequence(((VoucherHistoryId)argObjectId).getHistorySequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 265 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 269 */     StringBuilder buf = new StringBuilder(750);
/* 270 */     buf.append("<").append("dao").append(" name=\"VoucherHistory\" cmd=\"" + getObjectStateString() + "\">");
/* 271 */     getFieldsAsXml(buf);
/* 272 */     buf.append("</").append("dao").append(">");
/*     */     
/* 274 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 278 */     Map<String, String> values = super.getValues();
/* 279 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 280 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/* 281 */     if (this._voucherTypeCode != null) values.put("VoucherTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._voucherTypeCode)); 
/* 282 */     if (this._historySequence != null) values.put("HistorySequence", DaoUtils.getXmlSafeFieldValue(-5, this._historySequence)); 
/* 283 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 284 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 285 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 286 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 287 */     if (this._activityCode != null) values.put("ActivityCode", DaoUtils.getXmlSafeFieldValue(12, this._activityCode)); 
/* 288 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 289 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 290 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 291 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 292 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 293 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 294 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 299 */     super.setValues(argValues);
/* 300 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 302 */       String fieldName = field.getKey();
/* 303 */       String fieldValue = field.getValue();
/* 304 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 309 */             setOrganizationId((Long)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerialNumber":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 318 */             setSerialNumber((String)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VoucherTypeCode":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 327 */             setVoucherTypeCode((String)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setVoucherTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "HistorySequence":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 336 */             setHistorySequence((Long)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setHistorySequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 344 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 345 */             setCreateDate((Date)value);
/* 346 */           } catch (Exception ee) {
/* 347 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 354 */             setCreateUserId((String)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 363 */             setUpdateDate((Date)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 372 */             setUpdateUserId((String)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActivityCode":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 381 */             setActivityCode((String)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setActivityCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 390 */             setAmount((BigDecimal)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 399 */             setRetailTransactionLineItemSequence((Integer)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 408 */             setRetailLocationId((Long)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 416 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 417 */             setWorkstationId((Long)value);
/* 418 */           } catch (Exception ee) {
/* 419 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 425 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 426 */             setBusinessDate((Date)value);
/* 427 */           } catch (Exception ee) {
/* 428 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 434 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 435 */             setTransactionSequence((Long)value);
/* 436 */           } catch (Exception ee) {
/* 437 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\VoucherHistoryDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */