/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderSerializedCountId;
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
/*     */ public class TenderSerializedCountDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -395161513L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderSerializedCountDAO.class);
/*     */   
/*     */   private DtvDate _businessDayDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _serializedCountSequence;
/*     */   private String _tenderTypeCode;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private String _serialNumber;
/*     */   private String _tenderId;
/*     */   
/*     */   public Date getBusinessDayDate() {
/*  41 */     return (Date)this._businessDayDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDayDate(Date argBusinessDayDate) {
/*  45 */     if (changed(argBusinessDayDate, this._businessDayDate, "businessDayDate")) {
/*  46 */       this._businessDayDate = (argBusinessDayDate == null || argBusinessDayDate instanceof DtvDate) ? (DtvDate)argBusinessDayDate : new DtvDate(argBusinessDayDate);
/*     */     }
/*     */   }
/*     */ 
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
/*     */   public Long getRetailLocationId() {
/*  62 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  66 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  67 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSerializedCountSequence() {
/*  72 */     return this._serializedCountSequence;
/*     */   }
/*     */   
/*     */   public void setSerializedCountSequence(Integer argSerializedCountSequence) {
/*  76 */     if (changed(argSerializedCountSequence, this._serializedCountSequence, "serializedCountSequence")) {
/*  77 */       this._serializedCountSequence = argSerializedCountSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderTypeCode() {
/*  82 */     return this._tenderTypeCode;
/*     */   }
/*     */   
/*     */   public void setTenderTypeCode(String argTenderTypeCode) {
/*  86 */     if (changed(argTenderTypeCode, this._tenderTypeCode, "tenderTypeCode")) {
/*  87 */       this._tenderTypeCode = (argTenderTypeCode != null && MANAGE_CASE) ? argTenderTypeCode.toUpperCase() : argTenderTypeCode;
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
/*     */   public BigDecimal getAmount() {
/* 154 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 158 */     if (changed(argAmount, this._amount, "amount")) {
/* 159 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/* 164 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 168 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/* 169 */       this._serialNumber = argSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderId() {
/* 174 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/* 178 */     if (changed(argTenderId, this._tenderId, "tenderId")) {
/* 179 */       this._tenderId = argTenderId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 186 */     StringBuilder buf = new StringBuilder(512);
/* 187 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 188 */     if (getBusinessDayDate() != null) {
/* 189 */       buf.append("businessDayDate").append("=").append(getBusinessDayDate()).append(" ");
/*     */     }
/* 191 */     if (getOrganizationId() != null) {
/* 192 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 194 */     if (getRetailLocationId() != null) {
/* 195 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 197 */     if (getSerializedCountSequence() != null) {
/* 198 */       buf.append("serializedCountSequence").append("=").append(getSerializedCountSequence()).append(" ");
/*     */     }
/* 200 */     if (getTenderTypeCode() != null) {
/* 201 */       buf.append("tenderTypeCode").append("=").append(getTenderTypeCode()).append(" ");
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
/* 221 */     if (getAmount() != null) {
/* 222 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 224 */     if (getSerialNumber() != null) {
/* 225 */       buf.append("serialNumber").append("=").append(getSerialNumber()).append(" ");
/*     */     }
/* 227 */     if (getTenderId() != null) {
/* 228 */       buf.append("tenderId").append("=").append(getTenderId()).append(" ");
/*     */     }
/*     */     
/* 231 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 235 */     TenderSerializedCountId id = new TenderSerializedCountId();
/* 236 */     id.setBusinessDayDate(getBusinessDayDate());
/* 237 */     id.setOrganizationId(getOrganizationId());
/* 238 */     id.setRetailLocationId(getRetailLocationId());
/* 239 */     id.setSerializedCountSequence(getSerializedCountSequence());
/* 240 */     id.setTenderTypeCode(getTenderTypeCode());
/* 241 */     id.setTransactionSequence(getTransactionSequence());
/* 242 */     id.setWorkstationId(getWorkstationId());
/* 243 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 247 */     setBusinessDayDate(((TenderSerializedCountId)argObjectId).getBusinessDayDate());
/* 248 */     setOrganizationId(((TenderSerializedCountId)argObjectId).getOrganizationId());
/* 249 */     setRetailLocationId(((TenderSerializedCountId)argObjectId).getRetailLocationId());
/* 250 */     setSerializedCountSequence(((TenderSerializedCountId)argObjectId).getSerializedCountSequence());
/* 251 */     setTenderTypeCode(((TenderSerializedCountId)argObjectId).getTenderTypeCode());
/* 252 */     setTransactionSequence(((TenderSerializedCountId)argObjectId).getTransactionSequence());
/* 253 */     setWorkstationId(((TenderSerializedCountId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 257 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 261 */     StringBuilder buf = new StringBuilder(700);
/* 262 */     buf.append("<").append("dao").append(" name=\"TenderSerializedCount\" cmd=\"" + getObjectStateString() + "\">");
/* 263 */     getFieldsAsXml(buf);
/* 264 */     buf.append("</").append("dao").append(">");
/*     */     
/* 266 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 270 */     Map<String, String> values = super.getValues();
/* 271 */     if (this._businessDayDate != null) values.put("BusinessDayDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDayDate)); 
/* 272 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 273 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 274 */     if (this._serializedCountSequence != null) values.put("SerializedCountSequence", DaoUtils.getXmlSafeFieldValue(4, this._serializedCountSequence)); 
/* 275 */     if (this._tenderTypeCode != null) values.put("TenderTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._tenderTypeCode)); 
/* 276 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 277 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 278 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 279 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 280 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 281 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 282 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 283 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/* 284 */     if (this._tenderId != null) values.put("TenderId", DaoUtils.getXmlSafeFieldValue(12, this._tenderId)); 
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
/*     */         case "BusinessDayDate":
/*     */           try {
/* 299 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 300 */             setBusinessDayDate((Date)value);
/* 301 */           } catch (Exception ee) {
/* 302 */             throw new DtxException("An exception occurred while calling setBusinessDayDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
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
/*     */         case "RetailLocationId":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 318 */             setRetailLocationId((Long)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerializedCountSequence":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 327 */             setSerializedCountSequence((Integer)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setSerializedCountSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderTypeCode":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 336 */             setTenderTypeCode((String)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setTenderTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "Amount":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 399 */             setAmount((BigDecimal)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerialNumber":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 408 */             setSerialNumber((String)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderId":
/*     */           try {
/* 416 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 417 */             setTenderId((String)value);
/* 418 */           } catch (Exception ee) {
/* 419 */             throw new DtxException("An exception occurred while calling setTenderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderSerializedCountDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */