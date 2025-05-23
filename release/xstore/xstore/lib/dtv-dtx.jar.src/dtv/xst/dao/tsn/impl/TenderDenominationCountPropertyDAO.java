/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderDenominationCountPropertyId;
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
/*     */ public class TenderDenominationCountPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 759654283L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderDenominationCountPropertyDAO.class);
/*     */   
/*     */   private DtvDate _businessDayDate;
/*     */   private String _denominationId;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _tenderId;
/*     */   private String _tenderTypeCode;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private DtvDate _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   
/*     */   public Date getBusinessDayDate() {
/*  44 */     return (Date)this._businessDayDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDayDate(Date argBusinessDayDate) {
/*  48 */     if (changed(argBusinessDayDate, this._businessDayDate, "businessDayDate")) {
/*  49 */       this._businessDayDate = (argBusinessDayDate == null || argBusinessDayDate instanceof DtvDate) ? (DtvDate)argBusinessDayDate : new DtvDate(argBusinessDayDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDenominationId() {
/*  55 */     return this._denominationId;
/*     */   }
/*     */   
/*     */   public void setDenominationId(String argDenominationId) {
/*  59 */     if (changed(argDenominationId, this._denominationId, "denominationId")) {
/*  60 */       this._denominationId = (argDenominationId != null && MANAGE_CASE) ? argDenominationId.toUpperCase() : argDenominationId;
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
/*     */   public String getTenderId() {
/*  85 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/*  89 */     if (changed(argTenderId, this._tenderId, "tenderId")) {
/*  90 */       this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderTypeCode() {
/*  95 */     return this._tenderTypeCode;
/*     */   }
/*     */   
/*     */   public void setTenderTypeCode(String argTenderTypeCode) {
/*  99 */     if (changed(argTenderTypeCode, this._tenderTypeCode, "tenderTypeCode")) {
/* 100 */       this._tenderTypeCode = (argTenderTypeCode != null && MANAGE_CASE) ? argTenderTypeCode.toUpperCase() : argTenderTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/* 105 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/* 109 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/* 110 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 115 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 119 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 120 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/* 125 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 129 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/* 130 */       this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/* 135 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/* 139 */     if (changed(argType, this._type, "type")) {
/* 140 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/* 145 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 149 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/* 150 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/* 155 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 159 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 160 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 166 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 170 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 171 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 176 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 180 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 181 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 187 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 191 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 192 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 197 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 201 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 202 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 208 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 212 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 213 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 220 */     StringBuilder buf = new StringBuilder(512);
/* 221 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 222 */     if (getBusinessDayDate() != null) {
/* 223 */       buf.append("businessDayDate").append("=").append(getBusinessDayDate()).append(" ");
/*     */     }
/* 225 */     if (getDenominationId() != null) {
/* 226 */       buf.append("denominationId").append("=").append(getDenominationId()).append(" ");
/*     */     }
/* 228 */     if (getOrganizationId() != null) {
/* 229 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 231 */     if (getRetailLocationId() != null) {
/* 232 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 234 */     if (getTenderId() != null) {
/* 235 */       buf.append("tenderId").append("=").append(getTenderId()).append(" ");
/*     */     }
/* 237 */     if (getTenderTypeCode() != null) {
/* 238 */       buf.append("tenderTypeCode").append("=").append(getTenderTypeCode()).append(" ");
/*     */     }
/* 240 */     if (getTransactionSequence() != null) {
/* 241 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 243 */     if (getWorkstationId() != null) {
/* 244 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 246 */     if (getPropertyCode() != null) {
/* 247 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 249 */     if (getType() != null) {
/* 250 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 252 */     if (getStringValue() != null) {
/* 253 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 255 */     if (getDateValue() != null) {
/* 256 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 258 */     if (getDecimalValue() != null) {
/* 259 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 261 */     if (getCreateDate() != null) {
/* 262 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 264 */     if (getCreateUserId() != null) {
/* 265 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 267 */     if (getUpdateDate() != null) {
/* 268 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 270 */     if (getUpdateUserId() != null) {
/* 271 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 274 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 278 */     TenderDenominationCountPropertyId id = new TenderDenominationCountPropertyId();
/* 279 */     id.setBusinessDayDate(getBusinessDayDate());
/* 280 */     id.setDenominationId(getDenominationId());
/* 281 */     id.setOrganizationId(getOrganizationId());
/* 282 */     id.setRetailLocationId(getRetailLocationId());
/* 283 */     id.setTenderId(getTenderId());
/* 284 */     id.setTenderTypeCode(getTenderTypeCode());
/* 285 */     id.setTransactionSequence(getTransactionSequence());
/* 286 */     id.setWorkstationId(getWorkstationId());
/* 287 */     id.setPropertyCode(getPropertyCode());
/* 288 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 292 */     setBusinessDayDate(((TenderDenominationCountPropertyId)argObjectId).getBusinessDayDate());
/* 293 */     setDenominationId(((TenderDenominationCountPropertyId)argObjectId).getDenominationId());
/* 294 */     setOrganizationId(((TenderDenominationCountPropertyId)argObjectId).getOrganizationId());
/* 295 */     setRetailLocationId(((TenderDenominationCountPropertyId)argObjectId).getRetailLocationId());
/* 296 */     setTenderId(((TenderDenominationCountPropertyId)argObjectId).getTenderId());
/* 297 */     setTenderTypeCode(((TenderDenominationCountPropertyId)argObjectId).getTenderTypeCode());
/* 298 */     setTransactionSequence(((TenderDenominationCountPropertyId)argObjectId).getTransactionSequence());
/* 299 */     setWorkstationId(((TenderDenominationCountPropertyId)argObjectId).getWorkstationId());
/* 300 */     setPropertyCode(((TenderDenominationCountPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 304 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 308 */     StringBuilder buf = new StringBuilder(850);
/* 309 */     buf.append("<").append("dao").append(" name=\"TenderDenominationCountProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 310 */     getFieldsAsXml(buf);
/* 311 */     buf.append("</").append("dao").append(">");
/*     */     
/* 313 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 317 */     Map<String, String> values = super.getValues();
/* 318 */     if (this._businessDayDate != null) values.put("BusinessDayDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDayDate)); 
/* 319 */     if (this._denominationId != null) values.put("DenominationId", DaoUtils.getXmlSafeFieldValue(12, this._denominationId)); 
/* 320 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 321 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 322 */     if (this._tenderId != null) values.put("TenderId", DaoUtils.getXmlSafeFieldValue(12, this._tenderId)); 
/* 323 */     if (this._tenderTypeCode != null) values.put("TenderTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._tenderTypeCode)); 
/* 324 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 325 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 326 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 327 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 328 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 329 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 330 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 331 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 332 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 333 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 334 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 335 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 340 */     super.setValues(argValues);
/* 341 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 343 */       String fieldName = field.getKey();
/* 344 */       String fieldValue = field.getValue();
/* 345 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDayDate":
/*     */           try {
/* 349 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 350 */             setBusinessDayDate((Date)value);
/* 351 */           } catch (Exception ee) {
/* 352 */             throw new DtxException("An exception occurred while calling setBusinessDayDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DenominationId":
/*     */           try {
/* 358 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 359 */             setDenominationId((String)value);
/* 360 */           } catch (Exception ee) {
/* 361 */             throw new DtxException("An exception occurred while calling setDenominationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 367 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 368 */             setOrganizationId((Long)value);
/* 369 */           } catch (Exception ee) {
/* 370 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 376 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 377 */             setRetailLocationId((Long)value);
/* 378 */           } catch (Exception ee) {
/* 379 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderId":
/*     */           try {
/* 385 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 386 */             setTenderId((String)value);
/* 387 */           } catch (Exception ee) {
/* 388 */             throw new DtxException("An exception occurred while calling setTenderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderTypeCode":
/*     */           try {
/* 394 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 395 */             setTenderTypeCode((String)value);
/* 396 */           } catch (Exception ee) {
/* 397 */             throw new DtxException("An exception occurred while calling setTenderTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 403 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 404 */             setTransactionSequence((Long)value);
/* 405 */           } catch (Exception ee) {
/* 406 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 412 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 413 */             setWorkstationId((Long)value);
/* 414 */           } catch (Exception ee) {
/* 415 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 421 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 422 */             setPropertyCode((String)value);
/* 423 */           } catch (Exception ee) {
/* 424 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 430 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 431 */             setType((String)value);
/* 432 */           } catch (Exception ee) {
/* 433 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 439 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 440 */             setStringValue((String)value);
/* 441 */           } catch (Exception ee) {
/* 442 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 448 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 449 */             setDateValue((Date)value);
/* 450 */           } catch (Exception ee) {
/* 451 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 457 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 458 */             setDecimalValue((BigDecimal)value);
/* 459 */           } catch (Exception ee) {
/* 460 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 466 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 467 */             setCreateDate((Date)value);
/* 468 */           } catch (Exception ee) {
/* 469 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 475 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 476 */             setCreateUserId((String)value);
/* 477 */           } catch (Exception ee) {
/* 478 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 484 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 485 */             setUpdateDate((Date)value);
/* 486 */           } catch (Exception ee) {
/* 487 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 493 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 494 */             setUpdateUserId((String)value);
/* 495 */           } catch (Exception ee) {
/* 496 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderDenominationCountPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */