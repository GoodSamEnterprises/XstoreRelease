/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.KitComponentModifierId;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KitComponentModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -995503394L;
/*  23 */   private static final Logger _logger = Logger.getLogger(KitComponentModifierDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private String _componentItemId;
/*     */   private Long _sequenceNumber;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _componentItemDesc;
/*     */   private String _kitItemId;
/*     */   private Integer _displayOrder;
/*     */   private Integer _quantity;
/*     */   private String _serialNumber;
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
/*     */   public Date getCreateDate() {
/* 125 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 129 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 130 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 136 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 140 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 141 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 146 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 150 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 151 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 157 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 161 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 162 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getComponentItemDesc() {
/* 167 */     return this._componentItemDesc;
/*     */   }
/*     */   
/*     */   public void setComponentItemDesc(String argComponentItemDesc) {
/* 171 */     if (changed(argComponentItemDesc, this._componentItemDesc, "componentItemDesc")) {
/* 172 */       this._componentItemDesc = argComponentItemDesc;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getKitItemId() {
/* 177 */     return this._kitItemId;
/*     */   }
/*     */   
/*     */   public void setKitItemId(String argKitItemId) {
/* 181 */     if (changed(argKitItemId, this._kitItemId, "kitItemId")) {
/* 182 */       this._kitItemId = argKitItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getDisplayOrder() {
/* 187 */     return this._displayOrder;
/*     */   }
/*     */   
/*     */   public void setDisplayOrder(Integer argDisplayOrder) {
/* 191 */     if (changed(argDisplayOrder, this._displayOrder, "displayOrder")) {
/* 192 */       this._displayOrder = argDisplayOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getQuantity() {
/* 197 */     return this._quantity;
/*     */   }
/*     */   
/*     */   public void setQuantity(Integer argQuantity) {
/* 201 */     if (changed(argQuantity, this._quantity, "quantity")) {
/* 202 */       this._quantity = argQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/* 207 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 211 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/* 212 */       this._serialNumber = argSerialNumber;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 219 */     StringBuilder buf = new StringBuilder(512);
/* 220 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 221 */     if (getOrganizationId() != null) {
/* 222 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 224 */     if (getRetailLocationId() != null) {
/* 225 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 227 */     if (getBusinessDate() != null) {
/* 228 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 230 */     if (getWorkstationId() != null) {
/* 231 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 233 */     if (getTransactionSequence() != null) {
/* 234 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 236 */     if (getRetailTransactionLineItemSequence() != null) {
/* 237 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 239 */     if (getComponentItemId() != null) {
/* 240 */       buf.append("componentItemId").append("=").append(getComponentItemId()).append(" ");
/*     */     }
/* 242 */     if (getSequenceNumber() != null) {
/* 243 */       buf.append("sequenceNumber").append("=").append(getSequenceNumber()).append(" ");
/*     */     }
/* 245 */     if (getCreateDate() != null) {
/* 246 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 248 */     if (getCreateUserId() != null) {
/* 249 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 251 */     if (getUpdateDate() != null) {
/* 252 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 254 */     if (getUpdateUserId() != null) {
/* 255 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 257 */     if (getComponentItemDesc() != null) {
/* 258 */       buf.append("componentItemDesc").append("=").append(getComponentItemDesc()).append(" ");
/*     */     }
/* 260 */     if (getKitItemId() != null) {
/* 261 */       buf.append("kitItemId").append("=").append(getKitItemId()).append(" ");
/*     */     }
/* 263 */     if (getDisplayOrder() != null) {
/* 264 */       buf.append("displayOrder").append("=").append(getDisplayOrder()).append(" ");
/*     */     }
/* 266 */     if (getQuantity() != null) {
/* 267 */       buf.append("quantity").append("=").append(getQuantity()).append(" ");
/*     */     }
/* 269 */     if (getSerialNumber() != null) {
/* 270 */       buf.append("serialNumber").append("=").append(getSerialNumber()).append(" ");
/*     */     }
/*     */     
/* 273 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 277 */     KitComponentModifierId id = new KitComponentModifierId();
/* 278 */     id.setOrganizationId(getOrganizationId());
/* 279 */     id.setRetailLocationId(getRetailLocationId());
/* 280 */     id.setBusinessDate(getBusinessDate());
/* 281 */     id.setWorkstationId(getWorkstationId());
/* 282 */     id.setTransactionSequence(getTransactionSequence());
/* 283 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 284 */     id.setComponentItemId(getComponentItemId());
/* 285 */     id.setSequenceNumber(getSequenceNumber());
/* 286 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 290 */     setOrganizationId(((KitComponentModifierId)argObjectId).getOrganizationId());
/* 291 */     setRetailLocationId(((KitComponentModifierId)argObjectId).getRetailLocationId());
/* 292 */     setBusinessDate(((KitComponentModifierId)argObjectId).getBusinessDate());
/* 293 */     setWorkstationId(((KitComponentModifierId)argObjectId).getWorkstationId());
/* 294 */     setTransactionSequence(((KitComponentModifierId)argObjectId).getTransactionSequence());
/* 295 */     setRetailTransactionLineItemSequence(((KitComponentModifierId)argObjectId).getRetailTransactionLineItemSequence());
/* 296 */     setComponentItemId(((KitComponentModifierId)argObjectId).getComponentItemId());
/* 297 */     setSequenceNumber(((KitComponentModifierId)argObjectId).getSequenceNumber());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 301 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 305 */     StringBuilder buf = new StringBuilder(850);
/* 306 */     buf.append("<").append("dao").append(" name=\"KitComponentModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 307 */     getFieldsAsXml(buf);
/* 308 */     buf.append("</").append("dao").append(">");
/*     */     
/* 310 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 314 */     Map<String, String> values = super.getValues();
/* 315 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 316 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 317 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 318 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 319 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 320 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 321 */     if (this._componentItemId != null) values.put("ComponentItemId", DaoUtils.getXmlSafeFieldValue(12, this._componentItemId)); 
/* 322 */     if (this._sequenceNumber != null) values.put("SequenceNumber", DaoUtils.getXmlSafeFieldValue(-5, this._sequenceNumber)); 
/* 323 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 324 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 325 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 326 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 327 */     if (this._componentItemDesc != null) values.put("ComponentItemDesc", DaoUtils.getXmlSafeFieldValue(12, this._componentItemDesc)); 
/* 328 */     if (this._kitItemId != null) values.put("KitItemId", DaoUtils.getXmlSafeFieldValue(12, this._kitItemId)); 
/* 329 */     if (this._displayOrder != null) values.put("DisplayOrder", DaoUtils.getXmlSafeFieldValue(4, this._displayOrder)); 
/* 330 */     if (this._quantity != null) values.put("Quantity", DaoUtils.getXmlSafeFieldValue(4, this._quantity)); 
/* 331 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/* 332 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 337 */     super.setValues(argValues);
/* 338 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 340 */       String fieldName = field.getKey();
/* 341 */       String fieldValue = field.getValue();
/* 342 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 346 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 347 */             setOrganizationId((Long)value);
/* 348 */           } catch (Exception ee) {
/* 349 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 355 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 356 */             setRetailLocationId((Long)value);
/* 357 */           } catch (Exception ee) {
/* 358 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 364 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 365 */             setBusinessDate((Date)value);
/* 366 */           } catch (Exception ee) {
/* 367 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 373 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 374 */             setWorkstationId((Long)value);
/* 375 */           } catch (Exception ee) {
/* 376 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 382 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 383 */             setTransactionSequence((Long)value);
/* 384 */           } catch (Exception ee) {
/* 385 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 391 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 392 */             setRetailTransactionLineItemSequence((Integer)value);
/* 393 */           } catch (Exception ee) {
/* 394 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ComponentItemId":
/*     */           try {
/* 400 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 401 */             setComponentItemId((String)value);
/* 402 */           } catch (Exception ee) {
/* 403 */             throw new DtxException("An exception occurred while calling setComponentItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SequenceNumber":
/*     */           try {
/* 409 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 410 */             setSequenceNumber((Long)value);
/* 411 */           } catch (Exception ee) {
/* 412 */             throw new DtxException("An exception occurred while calling setSequenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 418 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 419 */             setCreateDate((Date)value);
/* 420 */           } catch (Exception ee) {
/* 421 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 427 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 428 */             setCreateUserId((String)value);
/* 429 */           } catch (Exception ee) {
/* 430 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 436 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 437 */             setUpdateDate((Date)value);
/* 438 */           } catch (Exception ee) {
/* 439 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 445 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 446 */             setUpdateUserId((String)value);
/* 447 */           } catch (Exception ee) {
/* 448 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ComponentItemDesc":
/*     */           try {
/* 454 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 455 */             setComponentItemDesc((String)value);
/* 456 */           } catch (Exception ee) {
/* 457 */             throw new DtxException("An exception occurred while calling setComponentItemDesc() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "KitItemId":
/*     */           try {
/* 463 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 464 */             setKitItemId((String)value);
/* 465 */           } catch (Exception ee) {
/* 466 */             throw new DtxException("An exception occurred while calling setKitItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DisplayOrder":
/*     */           try {
/* 472 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 473 */             setDisplayOrder((Integer)value);
/* 474 */           } catch (Exception ee) {
/* 475 */             throw new DtxException("An exception occurred while calling setDisplayOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Quantity":
/*     */           try {
/* 481 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 482 */             setQuantity((Integer)value);
/* 483 */           } catch (Exception ee) {
/* 484 */             throw new DtxException("An exception occurred while calling setQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerialNumber":
/*     */           try {
/* 490 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 491 */             setSerialNumber((String)value);
/* 492 */           } catch (Exception ee) {
/* 493 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\KitComponentModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */