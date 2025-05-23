/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.PosTransactionLinkPropertyId;
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
/*     */ public class PosTransactionLinkPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1196197145L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PosTransactionLinkPropertyDAO.class);
/*     */   
/*     */   private DtvDate _businessDate;
/*     */   private DtvDate _linkBusinessDate;
/*     */   private Long _linkRetailLocationId;
/*     */   private Long _linkTransactionSequence;
/*     */   private Long _linkWorkstationId;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
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
/*     */   public Date getBusinessDate() {
/*  45 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  49 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  50 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getLinkBusinessDate() {
/*  56 */     return (Date)this._linkBusinessDate;
/*     */   }
/*     */   
/*     */   public void setLinkBusinessDate(Date argLinkBusinessDate) {
/*  60 */     if (changed(argLinkBusinessDate, this._linkBusinessDate, "linkBusinessDate")) {
/*  61 */       this._linkBusinessDate = (argLinkBusinessDate == null || argLinkBusinessDate instanceof DtvDate) ? (DtvDate)argLinkBusinessDate : new DtvDate(argLinkBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getLinkRetailLocationId() {
/*  67 */     return this._linkRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setLinkRetailLocationId(Long argLinkRetailLocationId) {
/*  71 */     if (changed(argLinkRetailLocationId, this._linkRetailLocationId, "linkRetailLocationId")) {
/*  72 */       this._linkRetailLocationId = argLinkRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getLinkTransactionSequence() {
/*  77 */     return this._linkTransactionSequence;
/*     */   }
/*     */   
/*     */   public void setLinkTransactionSequence(Long argLinkTransactionSequence) {
/*  81 */     if (changed(argLinkTransactionSequence, this._linkTransactionSequence, "linkTransactionSequence")) {
/*  82 */       this._linkTransactionSequence = argLinkTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getLinkWorkstationId() {
/*  87 */     return this._linkWorkstationId;
/*     */   }
/*     */   
/*     */   public void setLinkWorkstationId(Long argLinkWorkstationId) {
/*  91 */     if (changed(argLinkWorkstationId, this._linkWorkstationId, "linkWorkstationId")) {
/*  92 */       this._linkWorkstationId = argLinkWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  97 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/* 101 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/* 102 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/* 107 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 111 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/* 112 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/* 117 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/* 121 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/* 122 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 127 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 131 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 132 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/* 137 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 141 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/* 142 */       this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/* 147 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/* 151 */     if (changed(argType, this._type, "type")) {
/* 152 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/* 157 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 161 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/* 162 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/* 167 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 171 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 172 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 178 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 182 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 183 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 188 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 192 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 193 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 199 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 203 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 204 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 209 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 213 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 214 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 220 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 224 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 225 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 232 */     StringBuilder buf = new StringBuilder(512);
/* 233 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 234 */     if (getBusinessDate() != null) {
/* 235 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 237 */     if (getLinkBusinessDate() != null) {
/* 238 */       buf.append("linkBusinessDate").append("=").append(getLinkBusinessDate()).append(" ");
/*     */     }
/* 240 */     if (getLinkRetailLocationId() != null) {
/* 241 */       buf.append("linkRetailLocationId").append("=").append(getLinkRetailLocationId()).append(" ");
/*     */     }
/* 243 */     if (getLinkTransactionSequence() != null) {
/* 244 */       buf.append("linkTransactionSequence").append("=").append(getLinkTransactionSequence()).append(" ");
/*     */     }
/* 246 */     if (getLinkWorkstationId() != null) {
/* 247 */       buf.append("linkWorkstationId").append("=").append(getLinkWorkstationId()).append(" ");
/*     */     }
/* 249 */     if (getOrganizationId() != null) {
/* 250 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 252 */     if (getRetailLocationId() != null) {
/* 253 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 255 */     if (getTransactionSequence() != null) {
/* 256 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 258 */     if (getWorkstationId() != null) {
/* 259 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 261 */     if (getPropertyCode() != null) {
/* 262 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 264 */     if (getType() != null) {
/* 265 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 267 */     if (getStringValue() != null) {
/* 268 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 270 */     if (getDateValue() != null) {
/* 271 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 273 */     if (getDecimalValue() != null) {
/* 274 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 276 */     if (getCreateDate() != null) {
/* 277 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 279 */     if (getCreateUserId() != null) {
/* 280 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 282 */     if (getUpdateDate() != null) {
/* 283 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 285 */     if (getUpdateUserId() != null) {
/* 286 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 289 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 293 */     PosTransactionLinkPropertyId id = new PosTransactionLinkPropertyId();
/* 294 */     id.setBusinessDate(getBusinessDate());
/* 295 */     id.setLinkBusinessDate(getLinkBusinessDate());
/* 296 */     id.setLinkRetailLocationId(getLinkRetailLocationId());
/* 297 */     id.setLinkTransactionSequence(getLinkTransactionSequence());
/* 298 */     id.setLinkWorkstationId(getLinkWorkstationId());
/* 299 */     id.setOrganizationId(getOrganizationId());
/* 300 */     id.setRetailLocationId(getRetailLocationId());
/* 301 */     id.setTransactionSequence(getTransactionSequence());
/* 302 */     id.setWorkstationId(getWorkstationId());
/* 303 */     id.setPropertyCode(getPropertyCode());
/* 304 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 308 */     setBusinessDate(((PosTransactionLinkPropertyId)argObjectId).getBusinessDate());
/* 309 */     setLinkBusinessDate(((PosTransactionLinkPropertyId)argObjectId).getLinkBusinessDate());
/* 310 */     setLinkRetailLocationId(((PosTransactionLinkPropertyId)argObjectId).getLinkRetailLocationId());
/* 311 */     setLinkTransactionSequence(((PosTransactionLinkPropertyId)argObjectId).getLinkTransactionSequence());
/* 312 */     setLinkWorkstationId(((PosTransactionLinkPropertyId)argObjectId).getLinkWorkstationId());
/* 313 */     setOrganizationId(((PosTransactionLinkPropertyId)argObjectId).getOrganizationId());
/* 314 */     setRetailLocationId(((PosTransactionLinkPropertyId)argObjectId).getRetailLocationId());
/* 315 */     setTransactionSequence(((PosTransactionLinkPropertyId)argObjectId).getTransactionSequence());
/* 316 */     setWorkstationId(((PosTransactionLinkPropertyId)argObjectId).getWorkstationId());
/* 317 */     setPropertyCode(((PosTransactionLinkPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 321 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 325 */     StringBuilder buf = new StringBuilder(900);
/* 326 */     buf.append("<").append("dao").append(" name=\"PosTransactionLinkProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 327 */     getFieldsAsXml(buf);
/* 328 */     buf.append("</").append("dao").append(">");
/*     */     
/* 330 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 334 */     Map<String, String> values = super.getValues();
/* 335 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 336 */     if (this._linkBusinessDate != null) values.put("LinkBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._linkBusinessDate)); 
/* 337 */     if (this._linkRetailLocationId != null) values.put("LinkRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._linkRetailLocationId)); 
/* 338 */     if (this._linkTransactionSequence != null) values.put("LinkTransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._linkTransactionSequence)); 
/* 339 */     if (this._linkWorkstationId != null) values.put("LinkWorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._linkWorkstationId)); 
/* 340 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 341 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 342 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 343 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 344 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 345 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 346 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 347 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 348 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 349 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 350 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 351 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 352 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 353 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 358 */     super.setValues(argValues);
/* 359 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 361 */       String fieldName = field.getKey();
/* 362 */       String fieldValue = field.getValue();
/* 363 */       switch (fieldName) {
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
/*     */         case "LinkBusinessDate":
/*     */           try {
/* 376 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 377 */             setLinkBusinessDate((Date)value);
/* 378 */           } catch (Exception ee) {
/* 379 */             throw new DtxException("An exception occurred while calling setLinkBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LinkRetailLocationId":
/*     */           try {
/* 385 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 386 */             setLinkRetailLocationId((Long)value);
/* 387 */           } catch (Exception ee) {
/* 388 */             throw new DtxException("An exception occurred while calling setLinkRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LinkTransactionSequence":
/*     */           try {
/* 394 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 395 */             setLinkTransactionSequence((Long)value);
/* 396 */           } catch (Exception ee) {
/* 397 */             throw new DtxException("An exception occurred while calling setLinkTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LinkWorkstationId":
/*     */           try {
/* 403 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 404 */             setLinkWorkstationId((Long)value);
/* 405 */           } catch (Exception ee) {
/* 406 */             throw new DtxException("An exception occurred while calling setLinkWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 412 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 413 */             setOrganizationId((Long)value);
/* 414 */           } catch (Exception ee) {
/* 415 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 421 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 422 */             setRetailLocationId((Long)value);
/* 423 */           } catch (Exception ee) {
/* 424 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 430 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 431 */             setTransactionSequence((Long)value);
/* 432 */           } catch (Exception ee) {
/* 433 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 439 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 440 */             setWorkstationId((Long)value);
/* 441 */           } catch (Exception ee) {
/* 442 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 448 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 449 */             setPropertyCode((String)value);
/* 450 */           } catch (Exception ee) {
/* 451 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 457 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 458 */             setType((String)value);
/* 459 */           } catch (Exception ee) {
/* 460 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 466 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 467 */             setStringValue((String)value);
/* 468 */           } catch (Exception ee) {
/* 469 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 475 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 476 */             setDateValue((Date)value);
/* 477 */           } catch (Exception ee) {
/* 478 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 484 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 485 */             setDecimalValue((BigDecimal)value);
/* 486 */           } catch (Exception ee) {
/* 487 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 493 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 494 */             setCreateDate((Date)value);
/* 495 */           } catch (Exception ee) {
/* 496 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 502 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 503 */             setCreateUserId((String)value);
/* 504 */           } catch (Exception ee) {
/* 505 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 511 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 512 */             setUpdateDate((Date)value);
/* 513 */           } catch (Exception ee) {
/* 514 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 520 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 521 */             setUpdateUserId((String)value);
/* 522 */           } catch (Exception ee) {
/* 523 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PosTransactionLinkPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */