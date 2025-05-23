/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryJournalId;
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
/*     */ public class InventoryJournalDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 85946971L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryJournalDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private Long _transactionLineItemSequence;
/*     */   private Long _journalSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _inventoryItemId;
/*     */   private String _itemSerialNumber;
/*     */   private String _actionCode;
/*     */   private BigDecimal _quantity;
/*     */   private String _sourceLocationId;
/*     */   private String _sourceBucketId;
/*     */   private String _destinationLocationId;
/*     */   private String _destinationBucketId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  46 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  50 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  51 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  56 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  60 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  61 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  66 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  70 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  71 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  76 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  80 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  81 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransactionSequence() {
/*  87 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  91 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  92 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionLineItemSequence() {
/*  97 */     return this._transactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionLineItemSequence(Long argTransactionLineItemSequence) {
/* 101 */     if (changed(argTransactionLineItemSequence, this._transactionLineItemSequence, "transactionLineItemSequence")) {
/* 102 */       this._transactionLineItemSequence = argTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getJournalSequence() {
/* 107 */     return this._journalSequence;
/*     */   }
/*     */   
/*     */   public void setJournalSequence(Long argJournalSequence) {
/* 111 */     if (changed(argJournalSequence, this._journalSequence, "journalSequence")) {
/* 112 */       this._journalSequence = argJournalSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 117 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 121 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 122 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 128 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 132 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 133 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 138 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 142 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 143 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 149 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 153 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 154 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryItemId() {
/* 159 */     return this._inventoryItemId;
/*     */   }
/*     */   
/*     */   public void setInventoryItemId(String argInventoryItemId) {
/* 163 */     if (changed(argInventoryItemId, this._inventoryItemId, "inventoryItemId")) {
/* 164 */       this._inventoryItemId = argInventoryItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemSerialNumber() {
/* 169 */     return this._itemSerialNumber;
/*     */   }
/*     */   
/*     */   public void setItemSerialNumber(String argItemSerialNumber) {
/* 173 */     if (changed(argItemSerialNumber, this._itemSerialNumber, "itemSerialNumber")) {
/* 174 */       this._itemSerialNumber = argItemSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getActionCode() {
/* 179 */     return this._actionCode;
/*     */   }
/*     */   
/*     */   public void setActionCode(String argActionCode) {
/* 183 */     if (changed(argActionCode, this._actionCode, "actionCode")) {
/* 184 */       this._actionCode = argActionCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getQuantity() {
/* 189 */     return this._quantity;
/*     */   }
/*     */   
/*     */   public void setQuantity(BigDecimal argQuantity) {
/* 193 */     if (changed(argQuantity, this._quantity, "quantity")) {
/* 194 */       this._quantity = argQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSourceLocationId() {
/* 199 */     return this._sourceLocationId;
/*     */   }
/*     */   
/*     */   public void setSourceLocationId(String argSourceLocationId) {
/* 203 */     if (changed(argSourceLocationId, this._sourceLocationId, "sourceLocationId")) {
/* 204 */       this._sourceLocationId = argSourceLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSourceBucketId() {
/* 209 */     return this._sourceBucketId;
/*     */   }
/*     */   
/*     */   public void setSourceBucketId(String argSourceBucketId) {
/* 213 */     if (changed(argSourceBucketId, this._sourceBucketId, "sourceBucketId")) {
/* 214 */       this._sourceBucketId = argSourceBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDestinationLocationId() {
/* 219 */     return this._destinationLocationId;
/*     */   }
/*     */   
/*     */   public void setDestinationLocationId(String argDestinationLocationId) {
/* 223 */     if (changed(argDestinationLocationId, this._destinationLocationId, "destinationLocationId")) {
/* 224 */       this._destinationLocationId = argDestinationLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDestinationBucketId() {
/* 229 */     return this._destinationBucketId;
/*     */   }
/*     */   
/*     */   public void setDestinationBucketId(String argDestinationBucketId) {
/* 233 */     if (changed(argDestinationBucketId, this._destinationBucketId, "destinationBucketId")) {
/* 234 */       this._destinationBucketId = argDestinationBucketId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 241 */     StringBuilder buf = new StringBuilder(512);
/* 242 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 243 */     if (getOrganizationId() != null) {
/* 244 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 246 */     if (getRetailLocationId() != null) {
/* 247 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 249 */     if (getWorkstationId() != null) {
/* 250 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 252 */     if (getBusinessDate() != null) {
/* 253 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 255 */     if (getTransactionSequence() != null) {
/* 256 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 258 */     if (getTransactionLineItemSequence() != null) {
/* 259 */       buf.append("transactionLineItemSequence").append("=").append(getTransactionLineItemSequence()).append(" ");
/*     */     }
/* 261 */     if (getJournalSequence() != null) {
/* 262 */       buf.append("journalSequence").append("=").append(getJournalSequence()).append(" ");
/*     */     }
/* 264 */     if (getCreateDate() != null) {
/* 265 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 267 */     if (getCreateUserId() != null) {
/* 268 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 270 */     if (getUpdateDate() != null) {
/* 271 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 273 */     if (getUpdateUserId() != null) {
/* 274 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 276 */     if (getInventoryItemId() != null) {
/* 277 */       buf.append("inventoryItemId").append("=").append(getInventoryItemId()).append(" ");
/*     */     }
/* 279 */     if (getItemSerialNumber() != null) {
/* 280 */       buf.append("itemSerialNumber").append("=").append(getItemSerialNumber()).append(" ");
/*     */     }
/* 282 */     if (getActionCode() != null) {
/* 283 */       buf.append("actionCode").append("=").append(getActionCode()).append(" ");
/*     */     }
/* 285 */     if (getQuantity() != null) {
/* 286 */       buf.append("quantity").append("=").append(getQuantity()).append(" ");
/*     */     }
/* 288 */     if (getSourceLocationId() != null) {
/* 289 */       buf.append("sourceLocationId").append("=").append(getSourceLocationId()).append(" ");
/*     */     }
/* 291 */     if (getSourceBucketId() != null) {
/* 292 */       buf.append("sourceBucketId").append("=").append(getSourceBucketId()).append(" ");
/*     */     }
/* 294 */     if (getDestinationLocationId() != null) {
/* 295 */       buf.append("destinationLocationId").append("=").append(getDestinationLocationId()).append(" ");
/*     */     }
/* 297 */     if (getDestinationBucketId() != null) {
/* 298 */       buf.append("destinationBucketId").append("=").append(getDestinationBucketId()).append(" ");
/*     */     }
/*     */     
/* 301 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 305 */     InventoryJournalId id = new InventoryJournalId();
/* 306 */     id.setOrganizationId(getOrganizationId());
/* 307 */     id.setRetailLocationId(getRetailLocationId());
/* 308 */     id.setWorkstationId(getWorkstationId());
/* 309 */     id.setBusinessDate(getBusinessDate());
/* 310 */     id.setTransactionSequence(getTransactionSequence());
/* 311 */     id.setTransactionLineItemSequence(getTransactionLineItemSequence());
/* 312 */     id.setJournalSequence(getJournalSequence());
/* 313 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 317 */     setOrganizationId(((InventoryJournalId)argObjectId).getOrganizationId());
/* 318 */     setRetailLocationId(((InventoryJournalId)argObjectId).getRetailLocationId());
/* 319 */     setWorkstationId(((InventoryJournalId)argObjectId).getWorkstationId());
/* 320 */     setBusinessDate(((InventoryJournalId)argObjectId).getBusinessDate());
/* 321 */     setTransactionSequence(((InventoryJournalId)argObjectId).getTransactionSequence());
/* 322 */     setTransactionLineItemSequence(((InventoryJournalId)argObjectId).getTransactionLineItemSequence());
/* 323 */     setJournalSequence(((InventoryJournalId)argObjectId).getJournalSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 327 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 331 */     StringBuilder buf = new StringBuilder(950);
/* 332 */     buf.append("<").append("dao").append(" name=\"InventoryJournal\" cmd=\"" + getObjectStateString() + "\">");
/* 333 */     getFieldsAsXml(buf);
/* 334 */     buf.append("</").append("dao").append(">");
/*     */     
/* 336 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 340 */     Map<String, String> values = super.getValues();
/* 341 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 342 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 343 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 344 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 345 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 346 */     if (this._transactionLineItemSequence != null) values.put("TransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionLineItemSequence)); 
/* 347 */     if (this._journalSequence != null) values.put("JournalSequence", DaoUtils.getXmlSafeFieldValue(-5, this._journalSequence)); 
/* 348 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 349 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 350 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 351 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 352 */     if (this._inventoryItemId != null) values.put("InventoryItemId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryItemId)); 
/* 353 */     if (this._itemSerialNumber != null) values.put("ItemSerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._itemSerialNumber)); 
/* 354 */     if (this._actionCode != null) values.put("ActionCode", DaoUtils.getXmlSafeFieldValue(12, this._actionCode)); 
/* 355 */     if (this._quantity != null) values.put("Quantity", DaoUtils.getXmlSafeFieldValue(3, this._quantity)); 
/* 356 */     if (this._sourceLocationId != null) values.put("SourceLocationId", DaoUtils.getXmlSafeFieldValue(12, this._sourceLocationId)); 
/* 357 */     if (this._sourceBucketId != null) values.put("SourceBucketId", DaoUtils.getXmlSafeFieldValue(12, this._sourceBucketId)); 
/* 358 */     if (this._destinationLocationId != null) values.put("DestinationLocationId", DaoUtils.getXmlSafeFieldValue(12, this._destinationLocationId)); 
/* 359 */     if (this._destinationBucketId != null) values.put("DestinationBucketId", DaoUtils.getXmlSafeFieldValue(12, this._destinationBucketId)); 
/* 360 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 365 */     super.setValues(argValues);
/* 366 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 368 */       String fieldName = field.getKey();
/* 369 */       String fieldValue = field.getValue();
/* 370 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 374 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 375 */             setOrganizationId((Long)value);
/* 376 */           } catch (Exception ee) {
/* 377 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 383 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 384 */             setRetailLocationId((Long)value);
/* 385 */           } catch (Exception ee) {
/* 386 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 392 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 393 */             setWorkstationId((Long)value);
/* 394 */           } catch (Exception ee) {
/* 395 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 401 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 402 */             setBusinessDate((Date)value);
/* 403 */           } catch (Exception ee) {
/* 404 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 410 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 411 */             setTransactionSequence((Long)value);
/* 412 */           } catch (Exception ee) {
/* 413 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionLineItemSequence":
/*     */           try {
/* 419 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 420 */             setTransactionLineItemSequence((Long)value);
/* 421 */           } catch (Exception ee) {
/* 422 */             throw new DtxException("An exception occurred while calling setTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "JournalSequence":
/*     */           try {
/* 428 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 429 */             setJournalSequence((Long)value);
/* 430 */           } catch (Exception ee) {
/* 431 */             throw new DtxException("An exception occurred while calling setJournalSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 437 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 438 */             setCreateDate((Date)value);
/* 439 */           } catch (Exception ee) {
/* 440 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 446 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 447 */             setCreateUserId((String)value);
/* 448 */           } catch (Exception ee) {
/* 449 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 455 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 456 */             setUpdateDate((Date)value);
/* 457 */           } catch (Exception ee) {
/* 458 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 464 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 465 */             setUpdateUserId((String)value);
/* 466 */           } catch (Exception ee) {
/* 467 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryItemId":
/*     */           try {
/* 473 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 474 */             setInventoryItemId((String)value);
/* 475 */           } catch (Exception ee) {
/* 476 */             throw new DtxException("An exception occurred while calling setInventoryItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemSerialNumber":
/*     */           try {
/* 482 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 483 */             setItemSerialNumber((String)value);
/* 484 */           } catch (Exception ee) {
/* 485 */             throw new DtxException("An exception occurred while calling setItemSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActionCode":
/*     */           try {
/* 491 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 492 */             setActionCode((String)value);
/* 493 */           } catch (Exception ee) {
/* 494 */             throw new DtxException("An exception occurred while calling setActionCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Quantity":
/*     */           try {
/* 500 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 501 */             setQuantity((BigDecimal)value);
/* 502 */           } catch (Exception ee) {
/* 503 */             throw new DtxException("An exception occurred while calling setQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SourceLocationId":
/*     */           try {
/* 509 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 510 */             setSourceLocationId((String)value);
/* 511 */           } catch (Exception ee) {
/* 512 */             throw new DtxException("An exception occurred while calling setSourceLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SourceBucketId":
/*     */           try {
/* 518 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 519 */             setSourceBucketId((String)value);
/* 520 */           } catch (Exception ee) {
/* 521 */             throw new DtxException("An exception occurred while calling setSourceBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationLocationId":
/*     */           try {
/* 527 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 528 */             setDestinationLocationId((String)value);
/* 529 */           } catch (Exception ee) {
/* 530 */             throw new DtxException("An exception occurred while calling setDestinationLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationBucketId":
/*     */           try {
/* 536 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 537 */             setDestinationBucketId((String)value);
/* 538 */           } catch (Exception ee) {
/* 539 */             throw new DtxException("An exception occurred while calling setDestinationBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryJournalDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */