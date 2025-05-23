/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.KitComponentModifierPropertyId;
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
/*     */ public class KitComponentModifierPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1967630637L;
/*  23 */   private static final Logger _logger = Logger.getLogger(KitComponentModifierPropertyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private String _componentItemId;
/*     */   private Long _sequenceNumber;
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
/*     */   public Long getOrganizationId() {
/*  44 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  48 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  49 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  54 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  58 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  59 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  64 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  68 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  69 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/*  75 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  79 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  80 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  85 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  89 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  90 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  95 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  99 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/* 100 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getComponentItemId() {
/* 105 */     return this._componentItemId;
/*     */   }
/*     */   
/*     */   public void setComponentItemId(String argComponentItemId) {
/* 109 */     if (changed(argComponentItemId, this._componentItemId, "componentItemId")) {
/* 110 */       this._componentItemId = (argComponentItemId != null && MANAGE_CASE) ? argComponentItemId.toUpperCase() : argComponentItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getSequenceNumber() {
/* 115 */     return this._sequenceNumber;
/*     */   }
/*     */   
/*     */   public void setSequenceNumber(Long argSequenceNumber) {
/* 119 */     if (changed(argSequenceNumber, this._sequenceNumber, "sequenceNumber")) {
/* 120 */       this._sequenceNumber = argSequenceNumber;
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
/* 222 */     if (getOrganizationId() != null) {
/* 223 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 225 */     if (getRetailLocationId() != null) {
/* 226 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 228 */     if (getBusinessDate() != null) {
/* 229 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 231 */     if (getWorkstationId() != null) {
/* 232 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 234 */     if (getTransactionSequence() != null) {
/* 235 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 237 */     if (getRetailTransactionLineItemSequence() != null) {
/* 238 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 240 */     if (getComponentItemId() != null) {
/* 241 */       buf.append("componentItemId").append("=").append(getComponentItemId()).append(" ");
/*     */     }
/* 243 */     if (getSequenceNumber() != null) {
/* 244 */       buf.append("sequenceNumber").append("=").append(getSequenceNumber()).append(" ");
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
/* 278 */     KitComponentModifierPropertyId id = new KitComponentModifierPropertyId();
/* 279 */     id.setOrganizationId(getOrganizationId());
/* 280 */     id.setRetailLocationId(getRetailLocationId());
/* 281 */     id.setBusinessDate(getBusinessDate());
/* 282 */     id.setWorkstationId(getWorkstationId());
/* 283 */     id.setTransactionSequence(getTransactionSequence());
/* 284 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 285 */     id.setComponentItemId(getComponentItemId());
/* 286 */     id.setSequenceNumber(getSequenceNumber());
/* 287 */     id.setPropertyCode(getPropertyCode());
/* 288 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 292 */     setOrganizationId(((KitComponentModifierPropertyId)argObjectId).getOrganizationId());
/* 293 */     setRetailLocationId(((KitComponentModifierPropertyId)argObjectId).getRetailLocationId());
/* 294 */     setBusinessDate(((KitComponentModifierPropertyId)argObjectId).getBusinessDate());
/* 295 */     setWorkstationId(((KitComponentModifierPropertyId)argObjectId).getWorkstationId());
/* 296 */     setTransactionSequence(((KitComponentModifierPropertyId)argObjectId).getTransactionSequence());
/* 297 */     setRetailTransactionLineItemSequence(((KitComponentModifierPropertyId)argObjectId).getRetailTransactionLineItemSequence());
/* 298 */     setComponentItemId(((KitComponentModifierPropertyId)argObjectId).getComponentItemId());
/* 299 */     setSequenceNumber(((KitComponentModifierPropertyId)argObjectId).getSequenceNumber());
/* 300 */     setPropertyCode(((KitComponentModifierPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 304 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 308 */     StringBuilder buf = new StringBuilder(850);
/* 309 */     buf.append("<").append("dao").append(" name=\"KitComponentModifierProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 310 */     getFieldsAsXml(buf);
/* 311 */     buf.append("</").append("dao").append(">");
/*     */     
/* 313 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 317 */     Map<String, String> values = super.getValues();
/* 318 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 319 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 320 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 321 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 322 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 323 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 324 */     if (this._componentItemId != null) values.put("ComponentItemId", DaoUtils.getXmlSafeFieldValue(12, this._componentItemId)); 
/* 325 */     if (this._sequenceNumber != null) values.put("SequenceNumber", DaoUtils.getXmlSafeFieldValue(-5, this._sequenceNumber)); 
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
/*     */         case "OrganizationId":
/*     */           try {
/* 349 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 350 */             setOrganizationId((Long)value);
/* 351 */           } catch (Exception ee) {
/* 352 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 358 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 359 */             setRetailLocationId((Long)value);
/* 360 */           } catch (Exception ee) {
/* 361 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 367 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 368 */             setBusinessDate((Date)value);
/* 369 */           } catch (Exception ee) {
/* 370 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 376 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 377 */             setWorkstationId((Long)value);
/* 378 */           } catch (Exception ee) {
/* 379 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 385 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 386 */             setTransactionSequence((Long)value);
/* 387 */           } catch (Exception ee) {
/* 388 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 394 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 395 */             setRetailTransactionLineItemSequence((Integer)value);
/* 396 */           } catch (Exception ee) {
/* 397 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ComponentItemId":
/*     */           try {
/* 403 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 404 */             setComponentItemId((String)value);
/* 405 */           } catch (Exception ee) {
/* 406 */             throw new DtxException("An exception occurred while calling setComponentItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SequenceNumber":
/*     */           try {
/* 412 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 413 */             setSequenceNumber((Long)value);
/* 414 */           } catch (Exception ee) {
/* 415 */             throw new DtxException("An exception occurred while calling setSequenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\KitComponentModifierPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */