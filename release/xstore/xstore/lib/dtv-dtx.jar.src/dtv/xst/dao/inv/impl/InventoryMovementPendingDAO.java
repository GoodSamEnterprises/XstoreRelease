/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryMovementPendingId;
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
/*     */ public class InventoryMovementPendingDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -313774836L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryMovementPendingDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _lineItemSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _itemId;
/*     */   private String _serialNumber;
/*     */   private String _actionCode;
/*     */   private BigDecimal _quantity;
/*  39 */   private Boolean _reconciled = Boolean.FALSE;
/*  40 */   private Boolean _void = Boolean.FALSE;
/*     */   
/*     */   public Long getOrganizationId() {
/*  43 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  47 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  48 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  53 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  57 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  58 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  63 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  67 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  68 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/*  74 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  78 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  79 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  84 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  88 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  89 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getLineItemSequence() {
/*  94 */     return this._lineItemSequence;
/*     */   }
/*     */   
/*     */   public void setLineItemSequence(Integer argLineItemSequence) {
/*  98 */     if (changed(argLineItemSequence, this._lineItemSequence, "lineItemSequence")) {
/*  99 */       this._lineItemSequence = argLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 104 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 108 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 109 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 115 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 119 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 120 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 125 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 129 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 130 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 136 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 140 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 141 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/* 146 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 150 */     if (changed(argItemId, this._itemId, "itemId")) {
/* 151 */       this._itemId = argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/* 156 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 160 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/* 161 */       this._serialNumber = argSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getActionCode() {
/* 166 */     return this._actionCode;
/*     */   }
/*     */   
/*     */   public void setActionCode(String argActionCode) {
/* 170 */     if (changed(argActionCode, this._actionCode, "actionCode")) {
/* 171 */       this._actionCode = argActionCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getQuantity() {
/* 176 */     return this._quantity;
/*     */   }
/*     */   
/*     */   public void setQuantity(BigDecimal argQuantity) {
/* 180 */     if (changed(argQuantity, this._quantity, "quantity")) {
/* 181 */       this._quantity = argQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getReconciled() {
/* 186 */     return this._reconciled;
/*     */   }
/*     */   
/*     */   public void setReconciled(Boolean argReconciled) {
/* 190 */     if (changed(argReconciled, this._reconciled, "reconciled")) {
/* 191 */       this._reconciled = argReconciled;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getVoid() {
/* 196 */     return this._void;
/*     */   }
/*     */   
/*     */   public void setVoid(Boolean argVoid) {
/* 200 */     if (changed(argVoid, this._void, "void")) {
/* 201 */       this._void = argVoid;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 208 */     StringBuilder buf = new StringBuilder(512);
/* 209 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 210 */     if (getOrganizationId() != null) {
/* 211 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 213 */     if (getRetailLocationId() != null) {
/* 214 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 216 */     if (getBusinessDate() != null) {
/* 217 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 219 */     if (getWorkstationId() != null) {
/* 220 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 222 */     if (getTransactionSequence() != null) {
/* 223 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 225 */     if (getLineItemSequence() != null) {
/* 226 */       buf.append("lineItemSequence").append("=").append(getLineItemSequence()).append(" ");
/*     */     }
/* 228 */     if (getCreateDate() != null) {
/* 229 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 231 */     if (getCreateUserId() != null) {
/* 232 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 234 */     if (getUpdateDate() != null) {
/* 235 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 237 */     if (getUpdateUserId() != null) {
/* 238 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 240 */     if (getItemId() != null) {
/* 241 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 243 */     if (getSerialNumber() != null) {
/* 244 */       buf.append("serialNumber").append("=").append(getSerialNumber()).append(" ");
/*     */     }
/* 246 */     if (getActionCode() != null) {
/* 247 */       buf.append("actionCode").append("=").append(getActionCode()).append(" ");
/*     */     }
/* 249 */     if (getQuantity() != null) {
/* 250 */       buf.append("quantity").append("=").append(getQuantity()).append(" ");
/*     */     }
/* 252 */     if (getReconciled() != null && getReconciled().booleanValue()) {
/* 253 */       buf.append("reconciled").append("=").append(getReconciled()).append(" ");
/*     */     }
/* 255 */     if (getVoid() != null && getVoid().booleanValue()) {
/* 256 */       buf.append("void").append("=").append(getVoid()).append(" ");
/*     */     }
/*     */     
/* 259 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 263 */     InventoryMovementPendingId id = new InventoryMovementPendingId();
/* 264 */     id.setOrganizationId(getOrganizationId());
/* 265 */     id.setRetailLocationId(getRetailLocationId());
/* 266 */     id.setBusinessDate(getBusinessDate());
/* 267 */     id.setWorkstationId(getWorkstationId());
/* 268 */     id.setTransactionSequence(getTransactionSequence());
/* 269 */     id.setLineItemSequence(getLineItemSequence());
/* 270 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 274 */     setOrganizationId(((InventoryMovementPendingId)argObjectId).getOrganizationId());
/* 275 */     setRetailLocationId(((InventoryMovementPendingId)argObjectId).getRetailLocationId());
/* 276 */     setBusinessDate(((InventoryMovementPendingId)argObjectId).getBusinessDate());
/* 277 */     setWorkstationId(((InventoryMovementPendingId)argObjectId).getWorkstationId());
/* 278 */     setTransactionSequence(((InventoryMovementPendingId)argObjectId).getTransactionSequence());
/* 279 */     setLineItemSequence(((InventoryMovementPendingId)argObjectId).getLineItemSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 283 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 287 */     StringBuilder buf = new StringBuilder(800);
/* 288 */     buf.append("<").append("dao").append(" name=\"InventoryMovementPending\" cmd=\"" + getObjectStateString() + "\">");
/* 289 */     getFieldsAsXml(buf);
/* 290 */     buf.append("</").append("dao").append(">");
/*     */     
/* 292 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 296 */     Map<String, String> values = super.getValues();
/* 297 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 298 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 299 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 300 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 301 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 302 */     if (this._lineItemSequence != null) values.put("LineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._lineItemSequence)); 
/* 303 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 304 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 305 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 306 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 307 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 308 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/* 309 */     if (this._actionCode != null) values.put("ActionCode", DaoUtils.getXmlSafeFieldValue(12, this._actionCode)); 
/* 310 */     if (this._quantity != null) values.put("Quantity", DaoUtils.getXmlSafeFieldValue(3, this._quantity)); 
/* 311 */     if (this._reconciled != null) values.put("Reconciled", DaoUtils.getXmlSafeFieldValue(-7, this._reconciled)); 
/* 312 */     if (this._void != null) values.put("Void", DaoUtils.getXmlSafeFieldValue(-7, this._void)); 
/* 313 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 318 */     super.setValues(argValues);
/* 319 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 321 */       String fieldName = field.getKey();
/* 322 */       String fieldValue = field.getValue();
/* 323 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 327 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 328 */             setOrganizationId((Long)value);
/* 329 */           } catch (Exception ee) {
/* 330 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 336 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 337 */             setRetailLocationId((Long)value);
/* 338 */           } catch (Exception ee) {
/* 339 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 345 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 346 */             setBusinessDate((Date)value);
/* 347 */           } catch (Exception ee) {
/* 348 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 354 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 355 */             setWorkstationId((Long)value);
/* 356 */           } catch (Exception ee) {
/* 357 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 363 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 364 */             setTransactionSequence((Long)value);
/* 365 */           } catch (Exception ee) {
/* 366 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemSequence":
/*     */           try {
/* 372 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 373 */             setLineItemSequence((Integer)value);
/* 374 */           } catch (Exception ee) {
/* 375 */             throw new DtxException("An exception occurred while calling setLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 381 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 382 */             setCreateDate((Date)value);
/* 383 */           } catch (Exception ee) {
/* 384 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 390 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 391 */             setCreateUserId((String)value);
/* 392 */           } catch (Exception ee) {
/* 393 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 399 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 400 */             setUpdateDate((Date)value);
/* 401 */           } catch (Exception ee) {
/* 402 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 408 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 409 */             setUpdateUserId((String)value);
/* 410 */           } catch (Exception ee) {
/* 411 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 417 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 418 */             setItemId((String)value);
/* 419 */           } catch (Exception ee) {
/* 420 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerialNumber":
/*     */           try {
/* 426 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 427 */             setSerialNumber((String)value);
/* 428 */           } catch (Exception ee) {
/* 429 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActionCode":
/*     */           try {
/* 435 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 436 */             setActionCode((String)value);
/* 437 */           } catch (Exception ee) {
/* 438 */             throw new DtxException("An exception occurred while calling setActionCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Quantity":
/*     */           try {
/* 444 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 445 */             setQuantity((BigDecimal)value);
/* 446 */           } catch (Exception ee) {
/* 447 */             throw new DtxException("An exception occurred while calling setQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Reconciled":
/*     */           try {
/* 453 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 454 */             setReconciled((Boolean)value);
/* 455 */           } catch (Exception ee) {
/* 456 */             throw new DtxException("An exception occurred while calling setReconciled() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Void":
/*     */           try {
/* 462 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 463 */             setVoid((Boolean)value);
/* 464 */           } catch (Exception ee) {
/* 465 */             throw new DtxException("An exception occurred while calling setVoid() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryMovementPendingDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */