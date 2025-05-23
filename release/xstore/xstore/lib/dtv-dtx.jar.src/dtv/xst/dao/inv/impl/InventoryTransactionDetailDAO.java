/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryTransactionDetailId;
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
/*     */ public class InventoryTransactionDetailDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1690444045L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryTransactionDetailDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _inventoryDetailSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _oldStatusCode;
/*     */   private String _newStatusCode;
/*     */   private BigDecimal _previousUnitCount;
/*     */   private BigDecimal _newUnitCount;
/*     */   private String _actionCode;
/*     */   private BigDecimal _newPostedCount;
/*     */   private BigDecimal _previousPostedCount;
/*     */   private Long _inventoryDocumentRetailLocationId;
/*     */   private String _documentId;
/*     */   private String _documentTypeCode;
/*     */   private Integer _inventoryDocumentLineNumber;
/*     */   private String _inventoryItemId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  49 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  53 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  54 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  59 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  63 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  64 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  69 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  73 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  74 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/*  80 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  84 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  85 */       this._workstationId = argWorkstationId;
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
/*     */   public Integer getInventoryDetailSequence() {
/* 100 */     return this._inventoryDetailSequence;
/*     */   }
/*     */   
/*     */   public void setInventoryDetailSequence(Integer argInventoryDetailSequence) {
/* 104 */     if (changed(argInventoryDetailSequence, this._inventoryDetailSequence, "inventoryDetailSequence")) {
/* 105 */       this._inventoryDetailSequence = argInventoryDetailSequence;
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
/*     */   public String getOldStatusCode() {
/* 152 */     return this._oldStatusCode;
/*     */   }
/*     */   
/*     */   public void setOldStatusCode(String argOldStatusCode) {
/* 156 */     if (changed(argOldStatusCode, this._oldStatusCode, "oldStatusCode")) {
/* 157 */       this._oldStatusCode = argOldStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNewStatusCode() {
/* 162 */     return this._newStatusCode;
/*     */   }
/*     */   
/*     */   public void setNewStatusCode(String argNewStatusCode) {
/* 166 */     if (changed(argNewStatusCode, this._newStatusCode, "newStatusCode")) {
/* 167 */       this._newStatusCode = argNewStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPreviousUnitCount() {
/* 172 */     return this._previousUnitCount;
/*     */   }
/*     */   
/*     */   public void setPreviousUnitCount(BigDecimal argPreviousUnitCount) {
/* 176 */     if (changed(argPreviousUnitCount, this._previousUnitCount, "previousUnitCount")) {
/* 177 */       this._previousUnitCount = argPreviousUnitCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getNewUnitCount() {
/* 182 */     return this._newUnitCount;
/*     */   }
/*     */   
/*     */   public void setNewUnitCount(BigDecimal argNewUnitCount) {
/* 186 */     if (changed(argNewUnitCount, this._newUnitCount, "newUnitCount")) {
/* 187 */       this._newUnitCount = argNewUnitCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getActionCode() {
/* 192 */     return this._actionCode;
/*     */   }
/*     */   
/*     */   public void setActionCode(String argActionCode) {
/* 196 */     if (changed(argActionCode, this._actionCode, "actionCode")) {
/* 197 */       this._actionCode = argActionCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getNewPostedCount() {
/* 202 */     return this._newPostedCount;
/*     */   }
/*     */   
/*     */   public void setNewPostedCount(BigDecimal argNewPostedCount) {
/* 206 */     if (changed(argNewPostedCount, this._newPostedCount, "newPostedCount")) {
/* 207 */       this._newPostedCount = argNewPostedCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPreviousPostedCount() {
/* 212 */     return this._previousPostedCount;
/*     */   }
/*     */   
/*     */   public void setPreviousPostedCount(BigDecimal argPreviousPostedCount) {
/* 216 */     if (changed(argPreviousPostedCount, this._previousPostedCount, "previousPostedCount")) {
/* 217 */       this._previousPostedCount = argPreviousPostedCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getInventoryDocumentRetailLocationId() {
/* 222 */     return this._inventoryDocumentRetailLocationId;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentRetailLocationId(Long argInventoryDocumentRetailLocationId) {
/* 226 */     if (changed(argInventoryDocumentRetailLocationId, this._inventoryDocumentRetailLocationId, "inventoryDocumentRetailLocationId")) {
/* 227 */       this._inventoryDocumentRetailLocationId = argInventoryDocumentRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentId() {
/* 232 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/* 236 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/* 237 */       this._documentId = argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentTypeCode() {
/* 242 */     return this._documentTypeCode;
/*     */   }
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/* 246 */     if (changed(argDocumentTypeCode, this._documentTypeCode, "documentTypeCode")) {
/* 247 */       this._documentTypeCode = argDocumentTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getInventoryDocumentLineNumber() {
/* 252 */     return this._inventoryDocumentLineNumber;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentLineNumber(Integer argInventoryDocumentLineNumber) {
/* 256 */     if (changed(argInventoryDocumentLineNumber, this._inventoryDocumentLineNumber, "inventoryDocumentLineNumber")) {
/* 257 */       this._inventoryDocumentLineNumber = argInventoryDocumentLineNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryItemId() {
/* 262 */     return this._inventoryItemId;
/*     */   }
/*     */   
/*     */   public void setInventoryItemId(String argInventoryItemId) {
/* 266 */     if (changed(argInventoryItemId, this._inventoryItemId, "inventoryItemId")) {
/* 267 */       this._inventoryItemId = argInventoryItemId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 274 */     StringBuilder buf = new StringBuilder(512);
/* 275 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 276 */     if (getOrganizationId() != null) {
/* 277 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 279 */     if (getRetailLocationId() != null) {
/* 280 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 282 */     if (getBusinessDate() != null) {
/* 283 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 285 */     if (getWorkstationId() != null) {
/* 286 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 288 */     if (getTransactionSequence() != null) {
/* 289 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 291 */     if (getInventoryDetailSequence() != null) {
/* 292 */       buf.append("inventoryDetailSequence").append("=").append(getInventoryDetailSequence()).append(" ");
/*     */     }
/* 294 */     if (getCreateDate() != null) {
/* 295 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 297 */     if (getCreateUserId() != null) {
/* 298 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 300 */     if (getUpdateDate() != null) {
/* 301 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 303 */     if (getUpdateUserId() != null) {
/* 304 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 306 */     if (getOldStatusCode() != null) {
/* 307 */       buf.append("oldStatusCode").append("=").append(getOldStatusCode()).append(" ");
/*     */     }
/* 309 */     if (getNewStatusCode() != null) {
/* 310 */       buf.append("newStatusCode").append("=").append(getNewStatusCode()).append(" ");
/*     */     }
/* 312 */     if (getPreviousUnitCount() != null) {
/* 313 */       buf.append("previousUnitCount").append("=").append(getPreviousUnitCount()).append(" ");
/*     */     }
/* 315 */     if (getNewUnitCount() != null) {
/* 316 */       buf.append("newUnitCount").append("=").append(getNewUnitCount()).append(" ");
/*     */     }
/* 318 */     if (getActionCode() != null) {
/* 319 */       buf.append("actionCode").append("=").append(getActionCode()).append(" ");
/*     */     }
/* 321 */     if (getNewPostedCount() != null) {
/* 322 */       buf.append("newPostedCount").append("=").append(getNewPostedCount()).append(" ");
/*     */     }
/* 324 */     if (getPreviousPostedCount() != null) {
/* 325 */       buf.append("previousPostedCount").append("=").append(getPreviousPostedCount()).append(" ");
/*     */     }
/* 327 */     if (getInventoryDocumentRetailLocationId() != null) {
/* 328 */       buf.append("inventoryDocumentRetailLocationId").append("=").append(getInventoryDocumentRetailLocationId()).append(" ");
/*     */     }
/* 330 */     if (getDocumentId() != null) {
/* 331 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 333 */     if (getDocumentTypeCode() != null) {
/* 334 */       buf.append("documentTypeCode").append("=").append(getDocumentTypeCode()).append(" ");
/*     */     }
/* 336 */     if (getInventoryDocumentLineNumber() != null) {
/* 337 */       buf.append("inventoryDocumentLineNumber").append("=").append(getInventoryDocumentLineNumber()).append(" ");
/*     */     }
/* 339 */     if (getInventoryItemId() != null) {
/* 340 */       buf.append("inventoryItemId").append("=").append(getInventoryItemId()).append(" ");
/*     */     }
/*     */     
/* 343 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 347 */     InventoryTransactionDetailId id = new InventoryTransactionDetailId();
/* 348 */     id.setOrganizationId(getOrganizationId());
/* 349 */     id.setRetailLocationId(getRetailLocationId());
/* 350 */     id.setBusinessDate(getBusinessDate());
/* 351 */     id.setWorkstationId(getWorkstationId());
/* 352 */     id.setTransactionSequence(getTransactionSequence());
/* 353 */     id.setInventoryDetailSequence(getInventoryDetailSequence());
/* 354 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 358 */     setOrganizationId(((InventoryTransactionDetailId)argObjectId).getOrganizationId());
/* 359 */     setRetailLocationId(((InventoryTransactionDetailId)argObjectId).getRetailLocationId());
/* 360 */     setBusinessDate(((InventoryTransactionDetailId)argObjectId).getBusinessDate());
/* 361 */     setWorkstationId(((InventoryTransactionDetailId)argObjectId).getWorkstationId());
/* 362 */     setTransactionSequence(((InventoryTransactionDetailId)argObjectId).getTransactionSequence());
/* 363 */     setInventoryDetailSequence(((InventoryTransactionDetailId)argObjectId).getInventoryDetailSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 367 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 371 */     StringBuilder buf = new StringBuilder(1100);
/* 372 */     buf.append("<").append("dao").append(" name=\"InventoryTransactionDetail\" cmd=\"" + getObjectStateString() + "\">");
/* 373 */     getFieldsAsXml(buf);
/* 374 */     buf.append("</").append("dao").append(">");
/*     */     
/* 376 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 380 */     Map<String, String> values = super.getValues();
/* 381 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 382 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 383 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 384 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 385 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 386 */     if (this._inventoryDetailSequence != null) values.put("InventoryDetailSequence", DaoUtils.getXmlSafeFieldValue(4, this._inventoryDetailSequence)); 
/* 387 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 388 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 389 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 390 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 391 */     if (this._oldStatusCode != null) values.put("OldStatusCode", DaoUtils.getXmlSafeFieldValue(12, this._oldStatusCode)); 
/* 392 */     if (this._newStatusCode != null) values.put("NewStatusCode", DaoUtils.getXmlSafeFieldValue(12, this._newStatusCode)); 
/* 393 */     if (this._previousUnitCount != null) values.put("PreviousUnitCount", DaoUtils.getXmlSafeFieldValue(3, this._previousUnitCount)); 
/* 394 */     if (this._newUnitCount != null) values.put("NewUnitCount", DaoUtils.getXmlSafeFieldValue(3, this._newUnitCount)); 
/* 395 */     if (this._actionCode != null) values.put("ActionCode", DaoUtils.getXmlSafeFieldValue(12, this._actionCode)); 
/* 396 */     if (this._newPostedCount != null) values.put("NewPostedCount", DaoUtils.getXmlSafeFieldValue(3, this._newPostedCount)); 
/* 397 */     if (this._previousPostedCount != null) values.put("PreviousPostedCount", DaoUtils.getXmlSafeFieldValue(3, this._previousPostedCount)); 
/* 398 */     if (this._inventoryDocumentRetailLocationId != null) values.put("InventoryDocumentRetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._inventoryDocumentRetailLocationId)); 
/* 399 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 400 */     if (this._documentTypeCode != null) values.put("DocumentTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._documentTypeCode)); 
/* 401 */     if (this._inventoryDocumentLineNumber != null) values.put("InventoryDocumentLineNumber", DaoUtils.getXmlSafeFieldValue(4, this._inventoryDocumentLineNumber)); 
/* 402 */     if (this._inventoryItemId != null) values.put("InventoryItemId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryItemId)); 
/* 403 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 408 */     super.setValues(argValues);
/* 409 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 411 */       String fieldName = field.getKey();
/* 412 */       String fieldValue = field.getValue();
/* 413 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 417 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 418 */             setOrganizationId((Long)value);
/* 419 */           } catch (Exception ee) {
/* 420 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 426 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 427 */             setRetailLocationId((Long)value);
/* 428 */           } catch (Exception ee) {
/* 429 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 435 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 436 */             setBusinessDate((Date)value);
/* 437 */           } catch (Exception ee) {
/* 438 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 444 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 445 */             setWorkstationId((Long)value);
/* 446 */           } catch (Exception ee) {
/* 447 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 453 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 454 */             setTransactionSequence((Long)value);
/* 455 */           } catch (Exception ee) {
/* 456 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryDetailSequence":
/*     */           try {
/* 462 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 463 */             setInventoryDetailSequence((Integer)value);
/* 464 */           } catch (Exception ee) {
/* 465 */             throw new DtxException("An exception occurred while calling setInventoryDetailSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 471 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 472 */             setCreateDate((Date)value);
/* 473 */           } catch (Exception ee) {
/* 474 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 480 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 481 */             setCreateUserId((String)value);
/* 482 */           } catch (Exception ee) {
/* 483 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 489 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 490 */             setUpdateDate((Date)value);
/* 491 */           } catch (Exception ee) {
/* 492 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 498 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 499 */             setUpdateUserId((String)value);
/* 500 */           } catch (Exception ee) {
/* 501 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OldStatusCode":
/*     */           try {
/* 507 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 508 */             setOldStatusCode((String)value);
/* 509 */           } catch (Exception ee) {
/* 510 */             throw new DtxException("An exception occurred while calling setOldStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NewStatusCode":
/*     */           try {
/* 516 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 517 */             setNewStatusCode((String)value);
/* 518 */           } catch (Exception ee) {
/* 519 */             throw new DtxException("An exception occurred while calling setNewStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PreviousUnitCount":
/*     */           try {
/* 525 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 526 */             setPreviousUnitCount((BigDecimal)value);
/* 527 */           } catch (Exception ee) {
/* 528 */             throw new DtxException("An exception occurred while calling setPreviousUnitCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NewUnitCount":
/*     */           try {
/* 534 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 535 */             setNewUnitCount((BigDecimal)value);
/* 536 */           } catch (Exception ee) {
/* 537 */             throw new DtxException("An exception occurred while calling setNewUnitCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActionCode":
/*     */           try {
/* 543 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 544 */             setActionCode((String)value);
/* 545 */           } catch (Exception ee) {
/* 546 */             throw new DtxException("An exception occurred while calling setActionCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NewPostedCount":
/*     */           try {
/* 552 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 553 */             setNewPostedCount((BigDecimal)value);
/* 554 */           } catch (Exception ee) {
/* 555 */             throw new DtxException("An exception occurred while calling setNewPostedCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PreviousPostedCount":
/*     */           try {
/* 561 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 562 */             setPreviousPostedCount((BigDecimal)value);
/* 563 */           } catch (Exception ee) {
/* 564 */             throw new DtxException("An exception occurred while calling setPreviousPostedCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryDocumentRetailLocationId":
/*     */           try {
/* 570 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 571 */             setInventoryDocumentRetailLocationId((Long)value);
/* 572 */           } catch (Exception ee) {
/* 573 */             throw new DtxException("An exception occurred while calling setInventoryDocumentRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 579 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 580 */             setDocumentId((String)value);
/* 581 */           } catch (Exception ee) {
/* 582 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentTypeCode":
/*     */           try {
/* 588 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 589 */             setDocumentTypeCode((String)value);
/* 590 */           } catch (Exception ee) {
/* 591 */             throw new DtxException("An exception occurred while calling setDocumentTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryDocumentLineNumber":
/*     */           try {
/* 597 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 598 */             setInventoryDocumentLineNumber((Integer)value);
/* 599 */           } catch (Exception ee) {
/* 600 */             throw new DtxException("An exception occurred while calling setInventoryDocumentLineNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryItemId":
/*     */           try {
/* 606 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 607 */             setInventoryItemId((String)value);
/* 608 */           } catch (Exception ee) {
/* 609 */             throw new DtxException("An exception occurred while calling setInventoryItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryTransactionDetailDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */