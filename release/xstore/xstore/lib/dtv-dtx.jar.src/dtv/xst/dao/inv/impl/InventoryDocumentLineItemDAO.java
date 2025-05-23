/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryDocumentLineItemId;
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
/*     */ public class InventoryDocumentLineItemDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 652670142L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryDocumentLineItemDAO.class);
/*     */   
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _inventoryItemId;
/*     */   private DtvDate _lineItemBusinessDate;
/*     */   private Long _lineItemRetailLocationId;
/*     */   private Integer _lineItemRetailTransactionLineItemSequence;
/*     */   private Long _lineItemTransactionSequence;
/*     */   private String _lineItemTypeCode;
/*     */   private Long _lineItemWorkstationId;
/*     */   private String _statusCode;
/*     */   private String _serialNumber;
/*     */   private BigDecimal _unitCount;
/*     */   private BigDecimal _unitCost;
/*     */   private BigDecimal _expectedCount;
/*     */   private BigDecimal _postedCount;
/*     */   private BigDecimal _postedCost;
/*     */   private String _recordCreationType;
/*     */   private String _enteredItemDescription;
/*     */   private String _enteredItemId;
/*     */   private String _cartonId;
/*     */   private BigDecimal _retail;
/*     */   private String _modelNumber;
/*     */   private String _originalBucketId;
/*     */   private String _originalLocationId;
/*     */   private String _controlNumber;
/*     */   private BigDecimal _shippingWeight;
/*     */   
/*     */   public String getDocumentId() {
/*  60 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  64 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/*  65 */       this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  70 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/*  74 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/*  75 */       this._documentTypeCode = (argDocumentTypeCode != null && MANAGE_CASE) ? argDocumentTypeCode.toUpperCase() : argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getInventoryDocumentLineNumber() {
/*  80 */     return this._inventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentLineNumber(Integer argInventoryDocumentLineNumber) {
/*  84 */     if (changed(argInventoryDocumentLineNumber, this._inventoryDocumentLineNumber, "inventoryDocumentLineNumber")) {
/*  85 */       this._inventoryDocumentLineNumber = argInventoryDocumentLineNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  90 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  94 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  95 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/* 100 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 104 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/* 105 */       this._retailLocationId = argRetailLocationId;
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
/*     */   public String getInventoryItemId() {
/* 152 */     return this._inventoryItemId;
/*     */   }
/*     */   
/*     */   public void setInventoryItemId(String argInventoryItemId) {
/* 156 */     if (changed(argInventoryItemId, this._inventoryItemId, "inventoryItemId")) {
/* 157 */       this._inventoryItemId = argInventoryItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getLineItemBusinessDate() {
/* 162 */     return (Date)this._lineItemBusinessDate;
/*     */   }
/*     */   
/*     */   public void setLineItemBusinessDate(Date argLineItemBusinessDate) {
/* 166 */     if (changed(argLineItemBusinessDate, this._lineItemBusinessDate, "lineItemBusinessDate")) {
/* 167 */       this._lineItemBusinessDate = (argLineItemBusinessDate == null || argLineItemBusinessDate instanceof DtvDate) ? (DtvDate)argLineItemBusinessDate : new DtvDate(argLineItemBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getLineItemRetailLocationId() {
/* 173 */     return this._lineItemRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setLineItemRetailLocationId(Long argLineItemRetailLocationId) {
/* 177 */     if (changed(argLineItemRetailLocationId, this._lineItemRetailLocationId, "lineItemRetailLocationId")) {
/* 178 */       this._lineItemRetailLocationId = argLineItemRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getLineItemRetailTransactionLineItemSequence() {
/* 183 */     return this._lineItemRetailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setLineItemRetailTransactionLineItemSequence(Integer argLineItemRetailTransactionLineItemSequence) {
/* 187 */     if (changed(argLineItemRetailTransactionLineItemSequence, this._lineItemRetailTransactionLineItemSequence, "lineItemRetailTransactionLineItemSequence")) {
/* 188 */       this._lineItemRetailTransactionLineItemSequence = argLineItemRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getLineItemTransactionSequence() {
/* 193 */     return this._lineItemTransactionSequence;
/*     */   }
/*     */   
/*     */   public void setLineItemTransactionSequence(Long argLineItemTransactionSequence) {
/* 197 */     if (changed(argLineItemTransactionSequence, this._lineItemTransactionSequence, "lineItemTransactionSequence")) {
/* 198 */       this._lineItemTransactionSequence = argLineItemTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLineItemTypeCode() {
/* 203 */     return this._lineItemTypeCode;
/*     */   }
/*     */   
/*     */   public void setLineItemTypeCode(String argLineItemTypeCode) {
/* 207 */     if (changed(argLineItemTypeCode, this._lineItemTypeCode, "lineItemTypeCode")) {
/* 208 */       this._lineItemTypeCode = argLineItemTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getLineItemWorkstationId() {
/* 213 */     return this._lineItemWorkstationId;
/*     */   }
/*     */   
/*     */   public void setLineItemWorkstationId(Long argLineItemWorkstationId) {
/* 217 */     if (changed(argLineItemWorkstationId, this._lineItemWorkstationId, "lineItemWorkstationId")) {
/* 218 */       this._lineItemWorkstationId = argLineItemWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStatusCode() {
/* 223 */     return this._statusCode;
/*     */   }
/*     */   
/*     */   public void setStatusCode(String argStatusCode) {
/* 227 */     if (changed(argStatusCode, this._statusCode, "statusCode")) {
/* 228 */       this._statusCode = argStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/* 233 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 237 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/* 238 */       this._serialNumber = argSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getUnitCount() {
/* 243 */     return this._unitCount;
/*     */   }
/*     */   
/*     */   public void setUnitCount(BigDecimal argUnitCount) {
/* 247 */     if (changed(argUnitCount, this._unitCount, "unitCount")) {
/* 248 */       this._unitCount = argUnitCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getUnitCost() {
/* 253 */     return this._unitCost;
/*     */   }
/*     */   
/*     */   public void setUnitCost(BigDecimal argUnitCost) {
/* 257 */     if (changed(argUnitCost, this._unitCost, "unitCost")) {
/* 258 */       this._unitCost = argUnitCost;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getExpectedCount() {
/* 263 */     return this._expectedCount;
/*     */   }
/*     */   
/*     */   public void setExpectedCount(BigDecimal argExpectedCount) {
/* 267 */     if (changed(argExpectedCount, this._expectedCount, "expectedCount")) {
/* 268 */       this._expectedCount = argExpectedCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPostedCount() {
/* 273 */     return this._postedCount;
/*     */   }
/*     */   
/*     */   public void setPostedCount(BigDecimal argPostedCount) {
/* 277 */     if (changed(argPostedCount, this._postedCount, "postedCount")) {
/* 278 */       this._postedCount = argPostedCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPostedCost() {
/* 283 */     return this._postedCost;
/*     */   }
/*     */   
/*     */   public void setPostedCost(BigDecimal argPostedCost) {
/* 287 */     if (changed(argPostedCost, this._postedCost, "postedCost")) {
/* 288 */       this._postedCost = argPostedCost;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRecordCreationType() {
/* 293 */     return this._recordCreationType;
/*     */   }
/*     */   
/*     */   public void setRecordCreationType(String argRecordCreationType) {
/* 297 */     if (changed(argRecordCreationType, this._recordCreationType, "recordCreationType")) {
/* 298 */       this._recordCreationType = argRecordCreationType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEnteredItemDescription() {
/* 303 */     return this._enteredItemDescription;
/*     */   }
/*     */   
/*     */   public void setEnteredItemDescription(String argEnteredItemDescription) {
/* 307 */     if (changed(argEnteredItemDescription, this._enteredItemDescription, "enteredItemDescription")) {
/* 308 */       this._enteredItemDescription = argEnteredItemDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEnteredItemId() {
/* 313 */     return this._enteredItemId;
/*     */   }
/*     */   
/*     */   public void setEnteredItemId(String argEnteredItemId) {
/* 317 */     if (changed(argEnteredItemId, this._enteredItemId, "enteredItemId")) {
/* 318 */       this._enteredItemId = argEnteredItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCartonId() {
/* 323 */     return this._cartonId;
/*     */   }
/*     */   
/*     */   public void setCartonId(String argCartonId) {
/* 327 */     if (changed(argCartonId, this._cartonId, "cartonId")) {
/* 328 */       this._cartonId = argCartonId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getRetail() {
/* 333 */     return this._retail;
/*     */   }
/*     */   
/*     */   public void setRetail(BigDecimal argRetail) {
/* 337 */     if (changed(argRetail, this._retail, "retail")) {
/* 338 */       this._retail = argRetail;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getModelNumber() {
/* 343 */     return this._modelNumber;
/*     */   }
/*     */   
/*     */   public void setModelNumber(String argModelNumber) {
/* 347 */     if (changed(argModelNumber, this._modelNumber, "modelNumber")) {
/* 348 */       this._modelNumber = argModelNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOriginalBucketId() {
/* 353 */     return this._originalBucketId;
/*     */   }
/*     */   
/*     */   public void setOriginalBucketId(String argOriginalBucketId) {
/* 357 */     if (changed(argOriginalBucketId, this._originalBucketId, "originalBucketId")) {
/* 358 */       this._originalBucketId = argOriginalBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOriginalLocationId() {
/* 363 */     return this._originalLocationId;
/*     */   }
/*     */   
/*     */   public void setOriginalLocationId(String argOriginalLocationId) {
/* 367 */     if (changed(argOriginalLocationId, this._originalLocationId, "originalLocationId")) {
/* 368 */       this._originalLocationId = argOriginalLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getControlNumber() {
/* 373 */     return this._controlNumber;
/*     */   }
/*     */   
/*     */   public void setControlNumber(String argControlNumber) {
/* 377 */     if (changed(argControlNumber, this._controlNumber, "controlNumber")) {
/* 378 */       this._controlNumber = argControlNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getShippingWeight() {
/* 383 */     return this._shippingWeight;
/*     */   }
/*     */   
/*     */   public void setShippingWeight(BigDecimal argShippingWeight) {
/* 387 */     if (changed(argShippingWeight, this._shippingWeight, "shippingWeight")) {
/* 388 */       this._shippingWeight = argShippingWeight;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 395 */     StringBuilder buf = new StringBuilder(512);
/* 396 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 397 */     if (getDocumentId() != null) {
/* 398 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 400 */     if (getDocumentTypeCode() != null) {
/* 401 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/* 403 */     if (getInventoryDocumentLineNumber() != null) {
/* 404 */       buf.append("inventoryDocumentLineNumber").append("=").append(getInventoryDocumentLineNumber()).append(" ");
/*     */     }
/* 406 */     if (getOrganizationId() != null) {
/* 407 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 409 */     if (getRetailLocationId() != null) {
/* 410 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 412 */     if (getCreateDate() != null) {
/* 413 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 415 */     if (getCreateUserId() != null) {
/* 416 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 418 */     if (getUpdateDate() != null) {
/* 419 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 421 */     if (getUpdateUserId() != null) {
/* 422 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 424 */     if (getInventoryItemId() != null) {
/* 425 */       buf.append("inventoryItemId").append("=").append(getInventoryItemId()).append(" ");
/*     */     }
/* 427 */     if (getLineItemBusinessDate() != null) {
/* 428 */       buf.append("lineItemBusinessDate").append("=").append(getLineItemBusinessDate()).append(" ");
/*     */     }
/* 430 */     if (getLineItemRetailLocationId() != null) {
/* 431 */       buf.append("lineItemRetailLocationId").append("=").append(getLineItemRetailLocationId()).append(" ");
/*     */     }
/* 433 */     if (getLineItemRetailTransactionLineItemSequence() != null) {
/* 434 */       buf.append("lineItemRetailTransactionLineItemSequence").append("=").append(getLineItemRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 436 */     if (getLineItemTransactionSequence() != null) {
/* 437 */       buf.append("lineItemTransactionSequence").append("=").append(getLineItemTransactionSequence()).append(" ");
/*     */     }
/* 439 */     if (getLineItemTypeCode() != null) {
/* 440 */       buf.append("lineItemTypeCode").append("=").append(getLineItemTypeCode()).append(" ");
/*     */     }
/* 442 */     if (getLineItemWorkstationId() != null) {
/* 443 */       buf.append("lineItemWorkstationId").append("=").append(getLineItemWorkstationId()).append(" ");
/*     */     }
/* 445 */     if (getStatusCode() != null) {
/* 446 */       buf.append("statusCode").append("=").append(getStatusCode()).append(" ");
/*     */     }
/* 448 */     if (getSerialNumber() != null) {
/* 449 */       buf.append("serialNumber").append("=").append(getSerialNumber()).append(" ");
/*     */     }
/* 451 */     if (getUnitCount() != null) {
/* 452 */       buf.append("unitCount").append("=").append(getUnitCount()).append(" ");
/*     */     }
/* 454 */     if (getUnitCost() != null) {
/* 455 */       buf.append("unitCost").append("=").append(getUnitCost()).append(" ");
/*     */     }
/* 457 */     if (getExpectedCount() != null) {
/* 458 */       buf.append("expectedCount").append("=").append(getExpectedCount()).append(" ");
/*     */     }
/* 460 */     if (getPostedCount() != null) {
/* 461 */       buf.append("postedCount").append("=").append(getPostedCount()).append(" ");
/*     */     }
/* 463 */     if (getPostedCost() != null) {
/* 464 */       buf.append("postedCost").append("=").append(getPostedCost()).append(" ");
/*     */     }
/* 466 */     if (getRecordCreationType() != null) {
/* 467 */       buf.append("recordCreationType").append("=").append(getRecordCreationType()).append(" ");
/*     */     }
/* 469 */     if (getEnteredItemDescription() != null) {
/* 470 */       buf.append("enteredItemDescription").append("=").append(getEnteredItemDescription()).append(" ");
/*     */     }
/* 472 */     if (getEnteredItemId() != null) {
/* 473 */       buf.append("enteredItemId").append("=").append(getEnteredItemId()).append(" ");
/*     */     }
/* 475 */     if (getCartonId() != null) {
/* 476 */       buf.append("cartonId").append("=").append(getCartonId()).append(" ");
/*     */     }
/* 478 */     if (getRetail() != null) {
/* 479 */       buf.append("retail").append("=").append(getRetail()).append(" ");
/*     */     }
/* 481 */     if (getModelNumber() != null) {
/* 482 */       buf.append("modelNumber").append("=").append(getModelNumber()).append(" ");
/*     */     }
/* 484 */     if (getOriginalBucketId() != null) {
/* 485 */       buf.append("originalBucketId").append("=").append(getOriginalBucketId()).append(" ");
/*     */     }
/* 487 */     if (getOriginalLocationId() != null) {
/* 488 */       buf.append("originalLocationId").append("=").append(getOriginalLocationId()).append(" ");
/*     */     }
/* 490 */     if (getControlNumber() != null) {
/* 491 */       buf.append("controlNumber").append("=").append(getControlNumber()).append(" ");
/*     */     }
/* 493 */     if (getShippingWeight() != null) {
/* 494 */       buf.append("shippingWeight").append("=").append(getShippingWeight()).append(" ");
/*     */     }
/*     */     
/* 497 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 501 */     InventoryDocumentLineItemId id = new InventoryDocumentLineItemId();
/* 502 */     id.setDocumentId(getDocumentId());
/* 503 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 504 */     id.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/* 505 */     id.setOrganizationId(getOrganizationId());
/* 506 */     id.setRetailLocationId(getRetailLocationId());
/* 507 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 511 */     setDocumentId(((InventoryDocumentLineItemId)argObjectId).getDocumentId());
/* 512 */     setDocumentTypeCode(((InventoryDocumentLineItemId)argObjectId).getDocumentTypeCode());
/* 513 */     setInventoryDocumentLineNumber(((InventoryDocumentLineItemId)argObjectId).getInventoryDocumentLineNumber());
/* 514 */     setOrganizationId(((InventoryDocumentLineItemId)argObjectId).getOrganizationId());
/* 515 */     setRetailLocationId(((InventoryDocumentLineItemId)argObjectId).getRetailLocationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 519 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 523 */     StringBuilder buf = new StringBuilder(1650);
/* 524 */     buf.append("<").append("dao").append(" name=\"InventoryDocumentLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 525 */     getFieldsAsXml(buf);
/* 526 */     buf.append("</").append("dao").append(">");
/*     */     
/* 528 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 532 */     Map<String, String> values = super.getValues();
/* 533 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 534 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 535 */     if (this._inventoryDocumentLineNumber != null) values.put("InventoryDocumentLineNumber", DaoUtils.getXmlSafeFieldValue(4, this._inventoryDocumentLineNumber)); 
/* 536 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 537 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 538 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 539 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 540 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 541 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 542 */     if (this._inventoryItemId != null) values.put("InventoryItemId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryItemId)); 
/* 543 */     if (this._lineItemBusinessDate != null) values.put("LineItemBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._lineItemBusinessDate)); 
/* 544 */     if (this._lineItemRetailLocationId != null) values.put("LineItemRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._lineItemRetailLocationId)); 
/* 545 */     if (this._lineItemRetailTransactionLineItemSequence != null) values.put("LineItemRetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._lineItemRetailTransactionLineItemSequence)); 
/* 546 */     if (this._lineItemTransactionSequence != null) values.put("LineItemTransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._lineItemTransactionSequence)); 
/* 547 */     if (this._lineItemTypeCode != null) values.put("LineItemTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._lineItemTypeCode)); 
/* 548 */     if (this._lineItemWorkstationId != null) values.put("LineItemWorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._lineItemWorkstationId)); 
/* 549 */     if (this._statusCode != null) values.put("StatusCode", DaoUtils.getXmlSafeFieldValue(12, this._statusCode)); 
/* 550 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/* 551 */     if (this._unitCount != null) values.put("UnitCount", DaoUtils.getXmlSafeFieldValue(3, this._unitCount)); 
/* 552 */     if (this._unitCost != null) values.put("UnitCost", DaoUtils.getXmlSafeFieldValue(3, this._unitCost)); 
/* 553 */     if (this._expectedCount != null) values.put("ExpectedCount", DaoUtils.getXmlSafeFieldValue(3, this._expectedCount)); 
/* 554 */     if (this._postedCount != null) values.put("PostedCount", DaoUtils.getXmlSafeFieldValue(3, this._postedCount)); 
/* 555 */     if (this._postedCost != null) values.put("PostedCost", DaoUtils.getXmlSafeFieldValue(3, this._postedCost)); 
/* 556 */     if (this._recordCreationType != null) values.put("RecordCreationType", DaoUtils.getXmlSafeFieldValue(12, this._recordCreationType)); 
/* 557 */     if (this._enteredItemDescription != null) values.put("EnteredItemDescription", DaoUtils.getXmlSafeFieldValue(12, this._enteredItemDescription)); 
/* 558 */     if (this._enteredItemId != null) values.put("EnteredItemId", DaoUtils.getXmlSafeFieldValue(12, this._enteredItemId)); 
/* 559 */     if (this._cartonId != null) values.put("CartonId", DaoUtils.getXmlSafeFieldValue(12, this._cartonId)); 
/* 560 */     if (this._retail != null) values.put("Retail", DaoUtils.getXmlSafeFieldValue(3, this._retail)); 
/* 561 */     if (this._modelNumber != null) values.put("ModelNumber", DaoUtils.getXmlSafeFieldValue(12, this._modelNumber)); 
/* 562 */     if (this._originalBucketId != null) values.put("OriginalBucketId", DaoUtils.getXmlSafeFieldValue(12, this._originalBucketId)); 
/* 563 */     if (this._originalLocationId != null) values.put("OriginalLocationId", DaoUtils.getXmlSafeFieldValue(12, this._originalLocationId)); 
/* 564 */     if (this._controlNumber != null) values.put("ControlNumber", DaoUtils.getXmlSafeFieldValue(12, this._controlNumber)); 
/* 565 */     if (this._shippingWeight != null) values.put("ShippingWeight", DaoUtils.getXmlSafeFieldValue(3, this._shippingWeight)); 
/* 566 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 571 */     super.setValues(argValues);
/* 572 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 574 */       String fieldName = field.getKey();
/* 575 */       String fieldValue = field.getValue();
/* 576 */       switch (fieldName) {
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 580 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 581 */             setDocumentId((String)value);
/* 582 */           } catch (Exception ee) {
/* 583 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 589 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 590 */             setDocumentTypeCode((String)value);
/* 591 */           } catch (Exception ee) {
/* 592 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryDocumentLineNumber":
/*     */           try {
/* 598 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 599 */             setInventoryDocumentLineNumber((Integer)value);
/* 600 */           } catch (Exception ee) {
/* 601 */             throw new DtxException("An exception occurred while calling setInventoryDocumentLineNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 607 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 608 */             setOrganizationId((Long)value);
/* 609 */           } catch (Exception ee) {
/* 610 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 616 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 617 */             setRetailLocationId((Long)value);
/* 618 */           } catch (Exception ee) {
/* 619 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 625 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 626 */             setCreateDate((Date)value);
/* 627 */           } catch (Exception ee) {
/* 628 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 634 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 635 */             setCreateUserId((String)value);
/* 636 */           } catch (Exception ee) {
/* 637 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 643 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 644 */             setUpdateDate((Date)value);
/* 645 */           } catch (Exception ee) {
/* 646 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 652 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 653 */             setUpdateUserId((String)value);
/* 654 */           } catch (Exception ee) {
/* 655 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryItemId":
/*     */           try {
/* 661 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 662 */             setInventoryItemId((String)value);
/* 663 */           } catch (Exception ee) {
/* 664 */             throw new DtxException("An exception occurred while calling setInventoryItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemBusinessDate":
/*     */           try {
/* 670 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 671 */             setLineItemBusinessDate((Date)value);
/* 672 */           } catch (Exception ee) {
/* 673 */             throw new DtxException("An exception occurred while calling setLineItemBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemRetailLocationId":
/*     */           try {
/* 679 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 680 */             setLineItemRetailLocationId((Long)value);
/* 681 */           } catch (Exception ee) {
/* 682 */             throw new DtxException("An exception occurred while calling setLineItemRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemRetailTransactionLineItemSequence":
/*     */           try {
/* 688 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 689 */             setLineItemRetailTransactionLineItemSequence((Integer)value);
/* 690 */           } catch (Exception ee) {
/* 691 */             throw new DtxException("An exception occurred while calling setLineItemRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemTransactionSequence":
/*     */           try {
/* 697 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 698 */             setLineItemTransactionSequence((Long)value);
/* 699 */           } catch (Exception ee) {
/* 700 */             throw new DtxException("An exception occurred while calling setLineItemTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemTypeCode":
/*     */           try {
/* 706 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 707 */             setLineItemTypeCode((String)value);
/* 708 */           } catch (Exception ee) {
/* 709 */             throw new DtxException("An exception occurred while calling setLineItemTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemWorkstationId":
/*     */           try {
/* 715 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 716 */             setLineItemWorkstationId((Long)value);
/* 717 */           } catch (Exception ee) {
/* 718 */             throw new DtxException("An exception occurred while calling setLineItemWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusCode":
/*     */           try {
/* 724 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 725 */             setStatusCode((String)value);
/* 726 */           } catch (Exception ee) {
/* 727 */             throw new DtxException("An exception occurred while calling setStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerialNumber":
/*     */           try {
/* 733 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 734 */             setSerialNumber((String)value);
/* 735 */           } catch (Exception ee) {
/* 736 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UnitCount":
/*     */           try {
/* 742 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 743 */             setUnitCount((BigDecimal)value);
/* 744 */           } catch (Exception ee) {
/* 745 */             throw new DtxException("An exception occurred while calling setUnitCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UnitCost":
/*     */           try {
/* 751 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 752 */             setUnitCost((BigDecimal)value);
/* 753 */           } catch (Exception ee) {
/* 754 */             throw new DtxException("An exception occurred while calling setUnitCost() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpectedCount":
/*     */           try {
/* 760 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 761 */             setExpectedCount((BigDecimal)value);
/* 762 */           } catch (Exception ee) {
/* 763 */             throw new DtxException("An exception occurred while calling setExpectedCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PostedCount":
/*     */           try {
/* 769 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 770 */             setPostedCount((BigDecimal)value);
/* 771 */           } catch (Exception ee) {
/* 772 */             throw new DtxException("An exception occurred while calling setPostedCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PostedCost":
/*     */           try {
/* 778 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 779 */             setPostedCost((BigDecimal)value);
/* 780 */           } catch (Exception ee) {
/* 781 */             throw new DtxException("An exception occurred while calling setPostedCost() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RecordCreationType":
/*     */           try {
/* 787 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 788 */             setRecordCreationType((String)value);
/* 789 */           } catch (Exception ee) {
/* 790 */             throw new DtxException("An exception occurred while calling setRecordCreationType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EnteredItemDescription":
/*     */           try {
/* 796 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 797 */             setEnteredItemDescription((String)value);
/* 798 */           } catch (Exception ee) {
/* 799 */             throw new DtxException("An exception occurred while calling setEnteredItemDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EnteredItemId":
/*     */           try {
/* 805 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 806 */             setEnteredItemId((String)value);
/* 807 */           } catch (Exception ee) {
/* 808 */             throw new DtxException("An exception occurred while calling setEnteredItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CartonId":
/*     */           try {
/* 814 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 815 */             setCartonId((String)value);
/* 816 */           } catch (Exception ee) {
/* 817 */             throw new DtxException("An exception occurred while calling setCartonId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Retail":
/*     */           try {
/* 823 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 824 */             setRetail((BigDecimal)value);
/* 825 */           } catch (Exception ee) {
/* 826 */             throw new DtxException("An exception occurred while calling setRetail() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ModelNumber":
/*     */           try {
/* 832 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 833 */             setModelNumber((String)value);
/* 834 */           } catch (Exception ee) {
/* 835 */             throw new DtxException("An exception occurred while calling setModelNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalBucketId":
/*     */           try {
/* 841 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 842 */             setOriginalBucketId((String)value);
/* 843 */           } catch (Exception ee) {
/* 844 */             throw new DtxException("An exception occurred while calling setOriginalBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginalLocationId":
/*     */           try {
/* 850 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 851 */             setOriginalLocationId((String)value);
/* 852 */           } catch (Exception ee) {
/* 853 */             throw new DtxException("An exception occurred while calling setOriginalLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ControlNumber":
/*     */           try {
/* 859 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 860 */             setControlNumber((String)value);
/* 861 */           } catch (Exception ee) {
/* 862 */             throw new DtxException("An exception occurred while calling setControlNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShippingWeight":
/*     */           try {
/* 868 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 869 */             setShippingWeight((BigDecimal)value);
/* 870 */           } catch (Exception ee) {
/* 871 */             throw new DtxException("An exception occurred while calling setShippingWeight() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */