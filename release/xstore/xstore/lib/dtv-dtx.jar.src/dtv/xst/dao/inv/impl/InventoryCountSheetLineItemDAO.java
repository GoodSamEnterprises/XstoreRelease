/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCountSheetLineItemId;
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
/*     */ public class InventoryCountSheetLineItemDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1408801485L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryCountSheetLineItemDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private Integer _countSheetNumber;
/*     */   private Integer _lineItemNumber;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _inventoryBucketId;
/*     */   private Integer _countCycle;
/*     */   private Integer _pageNumber;
/*     */   private String _itemId;
/*     */   private String _alternateId;
/*     */   private String _description;
/*     */   private BigDecimal _quantity;
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
/*     */   public String getInventoryCountId() {
/*  63 */     return this._inventoryCountId;
/*     */   }
/*     */   
/*     */   public void setInventoryCountId(String argInventoryCountId) {
/*  67 */     if (changed(argInventoryCountId, this._inventoryCountId, "inventoryCountId")) {
/*  68 */       this._inventoryCountId = (argInventoryCountId != null && MANAGE_CASE) ? argInventoryCountId.toUpperCase() : argInventoryCountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getCountSheetNumber() {
/*  73 */     return this._countSheetNumber;
/*     */   }
/*     */   
/*     */   public void setCountSheetNumber(Integer argCountSheetNumber) {
/*  77 */     if (changed(argCountSheetNumber, this._countSheetNumber, "countSheetNumber")) {
/*  78 */       this._countSheetNumber = argCountSheetNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getLineItemNumber() {
/*  83 */     return this._lineItemNumber;
/*     */   }
/*     */   
/*     */   public void setLineItemNumber(Integer argLineItemNumber) {
/*  87 */     if (changed(argLineItemNumber, this._lineItemNumber, "lineItemNumber")) {
/*  88 */       this._lineItemNumber = argLineItemNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  93 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  97 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  98 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 104 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 108 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 109 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 114 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 118 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 119 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 125 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 129 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 130 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryBucketId() {
/* 135 */     return this._inventoryBucketId;
/*     */   }
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/* 139 */     if (changed(argInventoryBucketId, this._inventoryBucketId, "inventoryBucketId")) {
/* 140 */       this._inventoryBucketId = argInventoryBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getCountCycle() {
/* 145 */     return this._countCycle;
/*     */   }
/*     */   
/*     */   public void setCountCycle(Integer argCountCycle) {
/* 149 */     if (changed(argCountCycle, this._countCycle, "countCycle")) {
/* 150 */       this._countCycle = argCountCycle;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getPageNumber() {
/* 155 */     return this._pageNumber;
/*     */   }
/*     */   
/*     */   public void setPageNumber(Integer argPageNumber) {
/* 159 */     if (changed(argPageNumber, this._pageNumber, "pageNumber")) {
/* 160 */       this._pageNumber = argPageNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/* 165 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 169 */     if (changed(argItemId, this._itemId, "itemId")) {
/* 170 */       this._itemId = argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAlternateId() {
/* 175 */     return this._alternateId;
/*     */   }
/*     */   
/*     */   public void setAlternateId(String argAlternateId) {
/* 179 */     if (changed(argAlternateId, this._alternateId, "alternateId")) {
/* 180 */       this._alternateId = argAlternateId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 185 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 189 */     if (changed(argDescription, this._description, "description")) {
/* 190 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getQuantity() {
/* 195 */     return this._quantity;
/*     */   }
/*     */   
/*     */   public void setQuantity(BigDecimal argQuantity) {
/* 199 */     if (changed(argQuantity, this._quantity, "quantity")) {
/* 200 */       this._quantity = argQuantity;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 207 */     StringBuilder buf = new StringBuilder(512);
/* 208 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 209 */     if (getOrganizationId() != null) {
/* 210 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 212 */     if (getRetailLocationId() != null) {
/* 213 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 215 */     if (getInventoryCountId() != null) {
/* 216 */       buf.append("inventoryCountId").append("=").append(getInventoryCountId()).append(" ");
/*     */     }
/* 218 */     if (getCountSheetNumber() != null) {
/* 219 */       buf.append("countSheetNumber").append("=").append(getCountSheetNumber()).append(" ");
/*     */     }
/* 221 */     if (getLineItemNumber() != null) {
/* 222 */       buf.append("lineItemNumber").append("=").append(getLineItemNumber()).append(" ");
/*     */     }
/* 224 */     if (getCreateDate() != null) {
/* 225 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 227 */     if (getCreateUserId() != null) {
/* 228 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 230 */     if (getUpdateDate() != null) {
/* 231 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 233 */     if (getUpdateUserId() != null) {
/* 234 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 236 */     if (getInventoryBucketId() != null) {
/* 237 */       buf.append("inventoryBucketId").append("=").append(getInventoryBucketId()).append(" ");
/*     */     }
/* 239 */     if (getCountCycle() != null) {
/* 240 */       buf.append("countCycle").append("=").append(getCountCycle()).append(" ");
/*     */     }
/* 242 */     if (getPageNumber() != null) {
/* 243 */       buf.append("pageNumber").append("=").append(getPageNumber()).append(" ");
/*     */     }
/* 245 */     if (getItemId() != null) {
/* 246 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 248 */     if (getAlternateId() != null) {
/* 249 */       buf.append("alternateId").append("=").append(getAlternateId()).append(" ");
/*     */     }
/* 251 */     if (getDescription() != null) {
/* 252 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 254 */     if (getQuantity() != null) {
/* 255 */       buf.append("quantity").append("=").append(getQuantity()).append(" ");
/*     */     }
/*     */     
/* 258 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 262 */     InventoryCountSheetLineItemId id = new InventoryCountSheetLineItemId();
/* 263 */     id.setOrganizationId(getOrganizationId());
/* 264 */     id.setRetailLocationId(getRetailLocationId());
/* 265 */     id.setInventoryCountId(getInventoryCountId());
/* 266 */     id.setCountSheetNumber(getCountSheetNumber());
/* 267 */     id.setLineItemNumber(getLineItemNumber());
/* 268 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 272 */     setOrganizationId(((InventoryCountSheetLineItemId)argObjectId).getOrganizationId());
/* 273 */     setRetailLocationId(((InventoryCountSheetLineItemId)argObjectId).getRetailLocationId());
/* 274 */     setInventoryCountId(((InventoryCountSheetLineItemId)argObjectId).getInventoryCountId());
/* 275 */     setCountSheetNumber(((InventoryCountSheetLineItemId)argObjectId).getCountSheetNumber());
/* 276 */     setLineItemNumber(((InventoryCountSheetLineItemId)argObjectId).getLineItemNumber());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 280 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 284 */     StringBuilder buf = new StringBuilder(800);
/* 285 */     buf.append("<").append("dao").append(" name=\"InventoryCountSheetLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 286 */     getFieldsAsXml(buf);
/* 287 */     buf.append("</").append("dao").append(">");
/*     */     
/* 289 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 293 */     Map<String, String> values = super.getValues();
/* 294 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 295 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 296 */     if (this._inventoryCountId != null) values.put("InventoryCountId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryCountId)); 
/* 297 */     if (this._countSheetNumber != null) values.put("CountSheetNumber", DaoUtils.getXmlSafeFieldValue(4, this._countSheetNumber)); 
/* 298 */     if (this._lineItemNumber != null) values.put("LineItemNumber", DaoUtils.getXmlSafeFieldValue(4, this._lineItemNumber)); 
/* 299 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 300 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 301 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 302 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 303 */     if (this._inventoryBucketId != null) values.put("InventoryBucketId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryBucketId)); 
/* 304 */     if (this._countCycle != null) values.put("CountCycle", DaoUtils.getXmlSafeFieldValue(4, this._countCycle)); 
/* 305 */     if (this._pageNumber != null) values.put("PageNumber", DaoUtils.getXmlSafeFieldValue(4, this._pageNumber)); 
/* 306 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 307 */     if (this._alternateId != null) values.put("AlternateId", DaoUtils.getXmlSafeFieldValue(12, this._alternateId)); 
/* 308 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 309 */     if (this._quantity != null) values.put("Quantity", DaoUtils.getXmlSafeFieldValue(3, this._quantity)); 
/* 310 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 315 */     super.setValues(argValues);
/* 316 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 318 */       String fieldName = field.getKey();
/* 319 */       String fieldValue = field.getValue();
/* 320 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 325 */             setOrganizationId((Long)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 334 */             setRetailLocationId((Long)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryCountId":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 343 */             setInventoryCountId((String)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setInventoryCountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CountSheetNumber":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 352 */             setCountSheetNumber((Integer)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setCountSheetNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LineItemNumber":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 361 */             setLineItemNumber((Integer)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setLineItemNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 370 */             setCreateDate((Date)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 379 */             setCreateUserId((String)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 388 */             setUpdateDate((Date)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 397 */             setUpdateUserId((String)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryBucketId":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 406 */             setInventoryBucketId((String)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setInventoryBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CountCycle":
/*     */           try {
/* 414 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 415 */             setCountCycle((Integer)value);
/* 416 */           } catch (Exception ee) {
/* 417 */             throw new DtxException("An exception occurred while calling setCountCycle() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PageNumber":
/*     */           try {
/* 423 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 424 */             setPageNumber((Integer)value);
/* 425 */           } catch (Exception ee) {
/* 426 */             throw new DtxException("An exception occurred while calling setPageNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 432 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 433 */             setItemId((String)value);
/* 434 */           } catch (Exception ee) {
/* 435 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AlternateId":
/*     */           try {
/* 441 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 442 */             setAlternateId((String)value);
/* 443 */           } catch (Exception ee) {
/* 444 */             throw new DtxException("An exception occurred while calling setAlternateId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 450 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 451 */             setDescription((String)value);
/* 452 */           } catch (Exception ee) {
/* 453 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Quantity":
/*     */           try {
/* 459 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 460 */             setQuantity((BigDecimal)value);
/* 461 */           } catch (Exception ee) {
/* 462 */             throw new DtxException("An exception occurred while calling setQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSheetLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */