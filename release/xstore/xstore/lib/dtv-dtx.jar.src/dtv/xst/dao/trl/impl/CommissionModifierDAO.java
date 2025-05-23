/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.CommissionModifierId;
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
/*     */ public class CommissionModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1992981246L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CommissionModifierDAO.class);
/*     */   
/*     */   private DtvDate _businessDate;
/*     */   private Integer _commissionModifierSequenceNbr;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private BigDecimal _percentage;
/*     */   private BigDecimal _percentageOfItem;
/*     */   private String _typeCode;
/*     */   private String _unverifiableEmployeeId;
/*     */   private Long _employeePartyId;
/*     */   
/*     */   public Date getBusinessDate() {
/*  44 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  48 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  49 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getCommissionModifierSequenceNbr() {
/*  55 */     return this._commissionModifierSequenceNbr;
/*     */   }
/*     */   
/*     */   public void setCommissionModifierSequenceNbr(Integer argCommissionModifierSequenceNbr) {
/*  59 */     if (changed(argCommissionModifierSequenceNbr, this._commissionModifierSequenceNbr, "commissionModifierSequenceNbr")) {
/*  60 */       this._commissionModifierSequenceNbr = argCommissionModifierSequenceNbr;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  65 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  69 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  70 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  75 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  79 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  80 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  85 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  89 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/*  90 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  95 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  99 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/* 100 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 105 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 109 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 110 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 115 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 119 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 120 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 126 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 130 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 131 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 136 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 140 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 141 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 147 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 151 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 152 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmount() {
/* 157 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 161 */     if (changed(argAmount, this._amount, "amount")) {
/* 162 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPercentage() {
/* 167 */     return this._percentage;
/*     */   }
/*     */   
/*     */   public void setPercentage(BigDecimal argPercentage) {
/* 171 */     if (changed(argPercentage, this._percentage, "percentage")) {
/* 172 */       this._percentage = argPercentage;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPercentageOfItem() {
/* 177 */     return this._percentageOfItem;
/*     */   }
/*     */   
/*     */   public void setPercentageOfItem(BigDecimal argPercentageOfItem) {
/* 181 */     if (changed(argPercentageOfItem, this._percentageOfItem, "percentageOfItem")) {
/* 182 */       this._percentageOfItem = argPercentageOfItem;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTypeCode() {
/* 187 */     return this._typeCode;
/*     */   }
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 191 */     if (changed(argTypeCode, this._typeCode, "typeCode")) {
/* 192 */       this._typeCode = argTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getUnverifiableEmployeeId() {
/* 197 */     return this._unverifiableEmployeeId;
/*     */   }
/*     */   
/*     */   public void setUnverifiableEmployeeId(String argUnverifiableEmployeeId) {
/* 201 */     if (changed(argUnverifiableEmployeeId, this._unverifiableEmployeeId, "unverifiableEmployeeId")) {
/* 202 */       this._unverifiableEmployeeId = argUnverifiableEmployeeId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getEmployeePartyId() {
/* 207 */     return this._employeePartyId;
/*     */   }
/*     */   
/*     */   public void setEmployeePartyId(Long argEmployeePartyId) {
/* 211 */     if (changed(argEmployeePartyId, this._employeePartyId, "employeePartyId")) {
/* 212 */       this._employeePartyId = argEmployeePartyId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 219 */     StringBuilder buf = new StringBuilder(512);
/* 220 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 221 */     if (getBusinessDate() != null) {
/* 222 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 224 */     if (getCommissionModifierSequenceNbr() != null) {
/* 225 */       buf.append("commissionModifierSequenceNbr").append("=").append(getCommissionModifierSequenceNbr()).append(" ");
/*     */     }
/* 227 */     if (getOrganizationId() != null) {
/* 228 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 230 */     if (getRetailLocationId() != null) {
/* 231 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 233 */     if (getRetailTransactionLineItemSequence() != null) {
/* 234 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 236 */     if (getTransactionSequence() != null) {
/* 237 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 239 */     if (getWorkstationId() != null) {
/* 240 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 242 */     if (getCreateDate() != null) {
/* 243 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 245 */     if (getCreateUserId() != null) {
/* 246 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 248 */     if (getUpdateDate() != null) {
/* 249 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 251 */     if (getUpdateUserId() != null) {
/* 252 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 254 */     if (getAmount() != null) {
/* 255 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 257 */     if (getPercentage() != null) {
/* 258 */       buf.append("percentage").append("=").append(getPercentage()).append(" ");
/*     */     }
/* 260 */     if (getPercentageOfItem() != null) {
/* 261 */       buf.append("percentageOfItem").append("=").append(getPercentageOfItem()).append(" ");
/*     */     }
/* 263 */     if (getTypeCode() != null) {
/* 264 */       buf.append("typeCode").append("=").append(getTypeCode()).append(" ");
/*     */     }
/* 266 */     if (getUnverifiableEmployeeId() != null) {
/* 267 */       buf.append("unverifiableEmployeeId").append("=").append(getUnverifiableEmployeeId()).append(" ");
/*     */     }
/* 269 */     if (getEmployeePartyId() != null) {
/* 270 */       buf.append("employeePartyId").append("=").append(getEmployeePartyId()).append(" ");
/*     */     }
/*     */     
/* 273 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 277 */     CommissionModifierId id = new CommissionModifierId();
/* 278 */     id.setBusinessDate(getBusinessDate());
/* 279 */     id.setCommissionModifierSequenceNbr(getCommissionModifierSequenceNbr());
/* 280 */     id.setOrganizationId(getOrganizationId());
/* 281 */     id.setRetailLocationId(getRetailLocationId());
/* 282 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 283 */     id.setTransactionSequence(getTransactionSequence());
/* 284 */     id.setWorkstationId(getWorkstationId());
/* 285 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 289 */     setBusinessDate(((CommissionModifierId)argObjectId).getBusinessDate());
/* 290 */     setCommissionModifierSequenceNbr(((CommissionModifierId)argObjectId).getCommissionModifierSequenceNbr());
/* 291 */     setOrganizationId(((CommissionModifierId)argObjectId).getOrganizationId());
/* 292 */     setRetailLocationId(((CommissionModifierId)argObjectId).getRetailLocationId());
/* 293 */     setRetailTransactionLineItemSequence(((CommissionModifierId)argObjectId).getRetailTransactionLineItemSequence());
/* 294 */     setTransactionSequence(((CommissionModifierId)argObjectId).getTransactionSequence());
/* 295 */     setWorkstationId(((CommissionModifierId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 299 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 303 */     StringBuilder buf = new StringBuilder(850);
/* 304 */     buf.append("<").append("dao").append(" name=\"CommissionModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 305 */     getFieldsAsXml(buf);
/* 306 */     buf.append("</").append("dao").append(">");
/*     */     
/* 308 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 312 */     Map<String, String> values = super.getValues();
/* 313 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 314 */     if (this._commissionModifierSequenceNbr != null) values.put("CommissionModifierSequenceNbr", DaoUtils.getXmlSafeFieldValue(4, this._commissionModifierSequenceNbr)); 
/* 315 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 316 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 317 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 318 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 319 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 320 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 321 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 322 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 323 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 324 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 325 */     if (this._percentage != null) values.put("Percentage", DaoUtils.getXmlSafeFieldValue(3, this._percentage)); 
/* 326 */     if (this._percentageOfItem != null) values.put("PercentageOfItem", DaoUtils.getXmlSafeFieldValue(3, this._percentageOfItem)); 
/* 327 */     if (this._typeCode != null) values.put("TypeCode", DaoUtils.getXmlSafeFieldValue(12, this._typeCode)); 
/* 328 */     if (this._unverifiableEmployeeId != null) values.put("UnverifiableEmployeeId", DaoUtils.getXmlSafeFieldValue(12, this._unverifiableEmployeeId)); 
/* 329 */     if (this._employeePartyId != null) values.put("EmployeePartyId", DaoUtils.getXmlSafeFieldValue(-5, this._employeePartyId)); 
/* 330 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 335 */     super.setValues(argValues);
/* 336 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 338 */       String fieldName = field.getKey();
/* 339 */       String fieldValue = field.getValue();
/* 340 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 344 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 345 */             setBusinessDate((Date)value);
/* 346 */           } catch (Exception ee) {
/* 347 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CommissionModifierSequenceNbr":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 354 */             setCommissionModifierSequenceNbr((Integer)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setCommissionModifierSequenceNbr() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 363 */             setOrganizationId((Long)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 372 */             setRetailLocationId((Long)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 381 */             setRetailTransactionLineItemSequence((Integer)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 390 */             setTransactionSequence((Long)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 399 */             setWorkstationId((Long)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 408 */             setCreateDate((Date)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 416 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 417 */             setCreateUserId((String)value);
/* 418 */           } catch (Exception ee) {
/* 419 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 425 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 426 */             setUpdateDate((Date)value);
/* 427 */           } catch (Exception ee) {
/* 428 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 434 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 435 */             setUpdateUserId((String)value);
/* 436 */           } catch (Exception ee) {
/* 437 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 443 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 444 */             setAmount((BigDecimal)value);
/* 445 */           } catch (Exception ee) {
/* 446 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Percentage":
/*     */           try {
/* 452 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 453 */             setPercentage((BigDecimal)value);
/* 454 */           } catch (Exception ee) {
/* 455 */             throw new DtxException("An exception occurred while calling setPercentage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PercentageOfItem":
/*     */           try {
/* 461 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 462 */             setPercentageOfItem((BigDecimal)value);
/* 463 */           } catch (Exception ee) {
/* 464 */             throw new DtxException("An exception occurred while calling setPercentageOfItem() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TypeCode":
/*     */           try {
/* 470 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 471 */             setTypeCode((String)value);
/* 472 */           } catch (Exception ee) {
/* 473 */             throw new DtxException("An exception occurred while calling setTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UnverifiableEmployeeId":
/*     */           try {
/* 479 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 480 */             setUnverifiableEmployeeId((String)value);
/* 481 */           } catch (Exception ee) {
/* 482 */             throw new DtxException("An exception occurred while calling setUnverifiableEmployeeId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmployeePartyId":
/*     */           try {
/* 488 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 489 */             setEmployeePartyId((Long)value);
/* 490 */           } catch (Exception ee) {
/* 491 */             throw new DtxException("An exception occurred while calling setEmployeePartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\CommissionModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */