/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.CorrectionModifierId;
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
/*     */ public class CorrectionModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1247937653L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CorrectionModifierDAO.class);
/*     */   
/*     */   private DtvDate _businessDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _originalRetailLocationId;
/*     */   private Long _originalWorkstationId;
/*     */   private DtvDate _originalBusinessDate;
/*     */   private Long _originalTransactionSequence;
/*     */   private Integer _originalRetailTransactionLineItemSequence;
/*     */   private String _reasonCode;
/*     */   private String _notes;
/*     */   private BigDecimal _originalTaxAmt;
/*     */   private BigDecimal _originalExtendedPrice;
/*     */   private BigDecimal _originalUnitPrice;
/*     */   private BigDecimal _originalBaseExtendedPrice;
/*     */   private BigDecimal _originalBaseUnitPrice;
/*     */   
/*     */   public Date getBusinessDate() {
/*  49 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  53 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  54 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getOrganizationId() {
/*  60 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  64 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  65 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  70 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  74 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  75 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  80 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  84 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/*  85 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  90 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  94 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  95 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 100 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 104 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 105 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 110 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 114 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 115 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 121 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 125 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 126 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 131 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 135 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 136 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 142 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 146 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 147 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOriginalRetailLocationId() {
/* 152 */     return this._originalRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setOriginalRetailLocationId(Long argOriginalRetailLocationId) {
/* 156 */     if (changed(argOriginalRetailLocationId, this._originalRetailLocationId, "originalRetailLocationId")) {
/* 157 */       this._originalRetailLocationId = argOriginalRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOriginalWorkstationId() {
/* 162 */     return this._originalWorkstationId;
/*     */   }
/*     */   
/*     */   public void setOriginalWorkstationId(Long argOriginalWorkstationId) {
/* 166 */     if (changed(argOriginalWorkstationId, this._originalWorkstationId, "originalWorkstationId")) {
/* 167 */       this._originalWorkstationId = argOriginalWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getOriginalBusinessDate() {
/* 172 */     return (Date)this._originalBusinessDate;
/*     */   }
/*     */   
/*     */   public void setOriginalBusinessDate(Date argOriginalBusinessDate) {
/* 176 */     if (changed(argOriginalBusinessDate, this._originalBusinessDate, "originalBusinessDate")) {
/* 177 */       this._originalBusinessDate = (argOriginalBusinessDate == null || argOriginalBusinessDate instanceof DtvDate) ? (DtvDate)argOriginalBusinessDate : new DtvDate(argOriginalBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getOriginalTransactionSequence() {
/* 183 */     return this._originalTransactionSequence;
/*     */   }
/*     */   
/*     */   public void setOriginalTransactionSequence(Long argOriginalTransactionSequence) {
/* 187 */     if (changed(argOriginalTransactionSequence, this._originalTransactionSequence, "originalTransactionSequence")) {
/* 188 */       this._originalTransactionSequence = argOriginalTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getOriginalRetailTransactionLineItemSequence() {
/* 193 */     return this._originalRetailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setOriginalRetailTransactionLineItemSequence(Integer argOriginalRetailTransactionLineItemSequence) {
/* 197 */     if (changed(argOriginalRetailTransactionLineItemSequence, this._originalRetailTransactionLineItemSequence, "originalRetailTransactionLineItemSequence")) {
/* 198 */       this._originalRetailTransactionLineItemSequence = argOriginalRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReasonCode() {
/* 203 */     return this._reasonCode;
/*     */   }
/*     */   
/*     */   public void setReasonCode(String argReasonCode) {
/* 207 */     if (changed(argReasonCode, this._reasonCode, "reasonCode")) {
/* 208 */       this._reasonCode = argReasonCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNotes() {
/* 213 */     return this._notes;
/*     */   }
/*     */   
/*     */   public void setNotes(String argNotes) {
/* 217 */     if (changed(argNotes, this._notes, "notes")) {
/* 218 */       this._notes = argNotes;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getOriginalTaxAmt() {
/* 223 */     return this._originalTaxAmt;
/*     */   }
/*     */   
/*     */   public void setOriginalTaxAmt(BigDecimal argOriginalTaxAmt) {
/* 227 */     if (changed(argOriginalTaxAmt, this._originalTaxAmt, "originalTaxAmt")) {
/* 228 */       this._originalTaxAmt = argOriginalTaxAmt;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getOriginalExtendedPrice() {
/* 233 */     return this._originalExtendedPrice;
/*     */   }
/*     */   
/*     */   public void setOriginalExtendedPrice(BigDecimal argOriginalExtendedPrice) {
/* 237 */     if (changed(argOriginalExtendedPrice, this._originalExtendedPrice, "originalExtendedPrice")) {
/* 238 */       this._originalExtendedPrice = argOriginalExtendedPrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getOriginalUnitPrice() {
/* 243 */     return this._originalUnitPrice;
/*     */   }
/*     */   
/*     */   public void setOriginalUnitPrice(BigDecimal argOriginalUnitPrice) {
/* 247 */     if (changed(argOriginalUnitPrice, this._originalUnitPrice, "originalUnitPrice")) {
/* 248 */       this._originalUnitPrice = argOriginalUnitPrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getOriginalBaseExtendedPrice() {
/* 253 */     return this._originalBaseExtendedPrice;
/*     */   }
/*     */   
/*     */   public void setOriginalBaseExtendedPrice(BigDecimal argOriginalBaseExtendedPrice) {
/* 257 */     if (changed(argOriginalBaseExtendedPrice, this._originalBaseExtendedPrice, "originalBaseExtendedPrice")) {
/* 258 */       this._originalBaseExtendedPrice = argOriginalBaseExtendedPrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getOriginalBaseUnitPrice() {
/* 263 */     return this._originalBaseUnitPrice;
/*     */   }
/*     */   
/*     */   public void setOriginalBaseUnitPrice(BigDecimal argOriginalBaseUnitPrice) {
/* 267 */     if (changed(argOriginalBaseUnitPrice, this._originalBaseUnitPrice, "originalBaseUnitPrice")) {
/* 268 */       this._originalBaseUnitPrice = argOriginalBaseUnitPrice;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 275 */     StringBuilder buf = new StringBuilder(512);
/* 276 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 277 */     if (getBusinessDate() != null) {
/* 278 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 280 */     if (getOrganizationId() != null) {
/* 281 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 283 */     if (getRetailLocationId() != null) {
/* 284 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 286 */     if (getRetailTransactionLineItemSequence() != null) {
/* 287 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 289 */     if (getTransactionSequence() != null) {
/* 290 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 292 */     if (getWorkstationId() != null) {
/* 293 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 295 */     if (getCreateDate() != null) {
/* 296 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 298 */     if (getCreateUserId() != null) {
/* 299 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 301 */     if (getUpdateDate() != null) {
/* 302 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 304 */     if (getUpdateUserId() != null) {
/* 305 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 307 */     if (getOriginalRetailLocationId() != null) {
/* 308 */       buf.append("originalRetailLocationId").append("=").append(getOriginalRetailLocationId()).append(" ");
/*     */     }
/* 310 */     if (getOriginalWorkstationId() != null) {
/* 311 */       buf.append("originalWorkstationId").append("=").append(getOriginalWorkstationId()).append(" ");
/*     */     }
/* 313 */     if (getOriginalBusinessDate() != null) {
/* 314 */       buf.append("originalBusinessDate").append("=").append(getOriginalBusinessDate()).append(" ");
/*     */     }
/* 316 */     if (getOriginalTransactionSequence() != null) {
/* 317 */       buf.append("originalTransactionSequence").append("=").append(getOriginalTransactionSequence()).append(" ");
/*     */     }
/* 319 */     if (getOriginalRetailTransactionLineItemSequence() != null) {
/* 320 */       buf.append("originalRetailTransactionLineItemSequence").append("=").append(getOriginalRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 322 */     if (getReasonCode() != null) {
/* 323 */       buf.append("reasonCode").append("=").append(getReasonCode()).append(" ");
/*     */     }
/* 325 */     if (getNotes() != null) {
/* 326 */       buf.append("notes").append("=").append(getNotes()).append(" ");
/*     */     }
/* 328 */     if (getOriginalTaxAmt() != null) {
/* 329 */       buf.append("originalTaxAmt").append("=").append(getOriginalTaxAmt()).append(" ");
/*     */     }
/* 331 */     if (getOriginalExtendedPrice() != null) {
/* 332 */       buf.append("originalExtendedPrice").append("=").append(getOriginalExtendedPrice()).append(" ");
/*     */     }
/* 334 */     if (getOriginalUnitPrice() != null) {
/* 335 */       buf.append("originalUnitPrice").append("=").append(getOriginalUnitPrice()).append(" ");
/*     */     }
/* 337 */     if (getOriginalBaseExtendedPrice() != null) {
/* 338 */       buf.append("originalBaseExtendedPrice").append("=").append(getOriginalBaseExtendedPrice()).append(" ");
/*     */     }
/* 340 */     if (getOriginalBaseUnitPrice() != null) {
/* 341 */       buf.append("originalBaseUnitPrice").append("=").append(getOriginalBaseUnitPrice()).append(" ");
/*     */     }
/*     */     
/* 344 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 348 */     CorrectionModifierId id = new CorrectionModifierId();
/* 349 */     id.setBusinessDate(getBusinessDate());
/* 350 */     id.setOrganizationId(getOrganizationId());
/* 351 */     id.setRetailLocationId(getRetailLocationId());
/* 352 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 353 */     id.setTransactionSequence(getTransactionSequence());
/* 354 */     id.setWorkstationId(getWorkstationId());
/* 355 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 359 */     setBusinessDate(((CorrectionModifierId)argObjectId).getBusinessDate());
/* 360 */     setOrganizationId(((CorrectionModifierId)argObjectId).getOrganizationId());
/* 361 */     setRetailLocationId(((CorrectionModifierId)argObjectId).getRetailLocationId());
/* 362 */     setRetailTransactionLineItemSequence(((CorrectionModifierId)argObjectId).getRetailTransactionLineItemSequence());
/* 363 */     setTransactionSequence(((CorrectionModifierId)argObjectId).getTransactionSequence());
/* 364 */     setWorkstationId(((CorrectionModifierId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 368 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 372 */     StringBuilder buf = new StringBuilder(1100);
/* 373 */     buf.append("<").append("dao").append(" name=\"CorrectionModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 374 */     getFieldsAsXml(buf);
/* 375 */     buf.append("</").append("dao").append(">");
/*     */     
/* 377 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 381 */     Map<String, String> values = super.getValues();
/* 382 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 383 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 384 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 385 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 386 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 387 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 388 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 389 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 390 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 391 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 392 */     if (this._originalRetailLocationId != null) values.put("OriginalRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._originalRetailLocationId)); 
/* 393 */     if (this._originalWorkstationId != null) values.put("OriginalWorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._originalWorkstationId)); 
/* 394 */     if (this._originalBusinessDate != null) values.put("OriginalBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._originalBusinessDate)); 
/* 395 */     if (this._originalTransactionSequence != null) values.put("OriginalTransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._originalTransactionSequence)); 
/* 396 */     if (this._originalRetailTransactionLineItemSequence != null) values.put("OriginalRetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._originalRetailTransactionLineItemSequence)); 
/* 397 */     if (this._reasonCode != null) values.put("ReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._reasonCode)); 
/* 398 */     if (this._notes != null) values.put("Notes", DaoUtils.getXmlSafeFieldValue(12, this._notes)); 
/* 399 */     if (this._originalTaxAmt != null) values.put("OriginalTaxAmt", DaoUtils.getXmlSafeFieldValue(3, this._originalTaxAmt)); 
/* 400 */     if (this._originalExtendedPrice != null) values.put("OriginalExtendedPrice", DaoUtils.getXmlSafeFieldValue(3, this._originalExtendedPrice)); 
/* 401 */     if (this._originalUnitPrice != null) values.put("OriginalUnitPrice", DaoUtils.getXmlSafeFieldValue(3, this._originalUnitPrice)); 
/* 402 */     if (this._originalBaseExtendedPrice != null) values.put("OriginalBaseExtendedPrice", DaoUtils.getXmlSafeFieldValue(3, this._originalBaseExtendedPrice)); 
/* 403 */     if (this._originalBaseUnitPrice != null) values.put("OriginalBaseUnitPrice", DaoUtils.getXmlSafeFieldValue(3, this._originalBaseUnitPrice)); 
/* 404 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 409 */     super.setValues(argValues);
/* 410 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 412 */       String fieldName = field.getKey();
/* 413 */       String fieldValue = field.getValue();
/* 414 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 418 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 419 */             setBusinessDate((Date)value);
/* 420 */           } catch (Exception ee) {
/* 421 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 427 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 428 */             setOrganizationId((Long)value);
/* 429 */           } catch (Exception ee) {
/* 430 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 436 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 437 */             setRetailLocationId((Long)value);
/* 438 */           } catch (Exception ee) {
/* 439 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 445 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 446 */             setRetailTransactionLineItemSequence((Integer)value);
/* 447 */           } catch (Exception ee) {
/* 448 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 454 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 455 */             setTransactionSequence((Long)value);
/* 456 */           } catch (Exception ee) {
/* 457 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 463 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 464 */             setWorkstationId((Long)value);
/* 465 */           } catch (Exception ee) {
/* 466 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 472 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 473 */             setCreateDate((Date)value);
/* 474 */           } catch (Exception ee) {
/* 475 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 481 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 482 */             setCreateUserId((String)value);
/* 483 */           } catch (Exception ee) {
/* 484 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 490 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 491 */             setUpdateDate((Date)value);
/* 492 */           } catch (Exception ee) {
/* 493 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 499 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 500 */             setUpdateUserId((String)value);
/* 501 */           } catch (Exception ee) {
/* 502 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalRetailLocationId":
/*     */           try {
/* 508 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 509 */             setOriginalRetailLocationId((Long)value);
/* 510 */           } catch (Exception ee) {
/* 511 */             throw new DtxException("An exception occurred while calling setOriginalRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalWorkstationId":
/*     */           try {
/* 517 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 518 */             setOriginalWorkstationId((Long)value);
/* 519 */           } catch (Exception ee) {
/* 520 */             throw new DtxException("An exception occurred while calling setOriginalWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalBusinessDate":
/*     */           try {
/* 526 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 527 */             setOriginalBusinessDate((Date)value);
/* 528 */           } catch (Exception ee) {
/* 529 */             throw new DtxException("An exception occurred while calling setOriginalBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalTransactionSequence":
/*     */           try {
/* 535 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 536 */             setOriginalTransactionSequence((Long)value);
/* 537 */           } catch (Exception ee) {
/* 538 */             throw new DtxException("An exception occurred while calling setOriginalTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalRetailTransactionLineItemSequence":
/*     */           try {
/* 544 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 545 */             setOriginalRetailTransactionLineItemSequence((Integer)value);
/* 546 */           } catch (Exception ee) {
/* 547 */             throw new DtxException("An exception occurred while calling setOriginalRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReasonCode":
/*     */           try {
/* 553 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 554 */             setReasonCode((String)value);
/* 555 */           } catch (Exception ee) {
/* 556 */             throw new DtxException("An exception occurred while calling setReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Notes":
/*     */           try {
/* 562 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 563 */             setNotes((String)value);
/* 564 */           } catch (Exception ee) {
/* 565 */             throw new DtxException("An exception occurred while calling setNotes() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalTaxAmt":
/*     */           try {
/* 571 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 572 */             setOriginalTaxAmt((BigDecimal)value);
/* 573 */           } catch (Exception ee) {
/* 574 */             throw new DtxException("An exception occurred while calling setOriginalTaxAmt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalExtendedPrice":
/*     */           try {
/* 580 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 581 */             setOriginalExtendedPrice((BigDecimal)value);
/* 582 */           } catch (Exception ee) {
/* 583 */             throw new DtxException("An exception occurred while calling setOriginalExtendedPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalUnitPrice":
/*     */           try {
/* 589 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 590 */             setOriginalUnitPrice((BigDecimal)value);
/* 591 */           } catch (Exception ee) {
/* 592 */             throw new DtxException("An exception occurred while calling setOriginalUnitPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalBaseExtendedPrice":
/*     */           try {
/* 598 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 599 */             setOriginalBaseExtendedPrice((BigDecimal)value);
/* 600 */           } catch (Exception ee) {
/* 601 */             throw new DtxException("An exception occurred while calling setOriginalBaseExtendedPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalBaseUnitPrice":
/*     */           try {
/* 607 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 608 */             setOriginalBaseUnitPrice((BigDecimal)value);
/* 609 */           } catch (Exception ee) {
/* 610 */             throw new DtxException("An exception occurred while calling setOriginalBaseUnitPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\CorrectionModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */