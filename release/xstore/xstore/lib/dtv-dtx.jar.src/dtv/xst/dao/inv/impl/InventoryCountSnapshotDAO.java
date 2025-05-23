/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.data2.access.impl.IHasIncrementalValues;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCountSnapshotId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryCountSnapshotDAO
/*     */   extends AbstractDAOImpl
/*     */   implements IHasIncrementalValues
/*     */ {
/*     */   private static final long serialVersionUID = 1348133911L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryCountSnapshotDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private String _inventoryLocationId;
/*     */   private String _inventoryBucketId;
/*     */   private String _itemId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _snapshotDate;
/*     */   private BigDecimal _quantity;
/*     */   private BigDecimal _initQuantity;
/*     */   protected boolean _incrementalActive = true;
/*     */   
/*     */   public void setIncrementalActive(boolean argActive) {
/*  41 */     this._incrementalActive = argActive;
/*     */   }
/*     */   
/*     */   public boolean getIncrementalActive() {
/*  45 */     return this._incrementalActive;
/*     */   }
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
/*     */   public String getInventoryCountId() {
/*  69 */     return this._inventoryCountId;
/*     */   }
/*     */   
/*     */   public void setInventoryCountId(String argInventoryCountId) {
/*  73 */     if (changed(argInventoryCountId, this._inventoryCountId, "inventoryCountId")) {
/*  74 */       this._inventoryCountId = (argInventoryCountId != null && MANAGE_CASE) ? argInventoryCountId.toUpperCase() : argInventoryCountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryLocationId() {
/*  79 */     return this._inventoryLocationId;
/*     */   }
/*     */   
/*     */   public void setInventoryLocationId(String argInventoryLocationId) {
/*  83 */     if (changed(argInventoryLocationId, this._inventoryLocationId, "inventoryLocationId")) {
/*  84 */       this._inventoryLocationId = (argInventoryLocationId != null && MANAGE_CASE) ? argInventoryLocationId.toUpperCase() : argInventoryLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryBucketId() {
/*  89 */     return this._inventoryBucketId;
/*     */   }
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/*  93 */     if (changed(argInventoryBucketId, this._inventoryBucketId, "inventoryBucketId")) {
/*  94 */       this._inventoryBucketId = (argInventoryBucketId != null && MANAGE_CASE) ? argInventoryBucketId.toUpperCase() : argInventoryBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  99 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 103 */     if (changed(argItemId, this._itemId, "itemId")) {
/* 104 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 109 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 113 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 114 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 120 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 124 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 125 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 130 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 134 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 135 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 141 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 145 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 146 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getSnapshotDate() {
/* 151 */     return (Date)this._snapshotDate;
/*     */   }
/*     */   
/*     */   public void setSnapshotDate(Date argSnapshotDate) {
/* 155 */     if (changed(argSnapshotDate, this._snapshotDate, "snapshotDate")) {
/* 156 */       this._snapshotDate = (argSnapshotDate == null || argSnapshotDate instanceof DtvDate) ? (DtvDate)argSnapshotDate : new DtvDate(argSnapshotDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getQuantity() {
/* 162 */     return this._quantity;
/*     */   }
/*     */   
/*     */   public BigDecimal getInitQuantity() {
/* 166 */     return this._initQuantity;
/*     */   }
/*     */   
/*     */   public void setQuantity(BigDecimal argQuantity) {
/* 170 */     if (changed(argQuantity, this._quantity, "quantity")) {
/* 171 */       this._quantity = argQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setInitQuantity(BigDecimal argQuantity) {
/* 176 */     this._initQuantity = argQuantity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private BigDecimal getQuantityDiff() {
/*     */     BigDecimal val1, val2;
/* 184 */     if (this._quantity == null) {
/* 185 */       val1 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 188 */       val1 = this._quantity;
/*     */     } 
/*     */     
/* 191 */     if (this._initQuantity == null) {
/* 192 */       val2 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 195 */       val2 = this._initQuantity;
/*     */     } 
/*     */     
/* 198 */     BigDecimal res = val1.subtract(val2);
/*     */     
/* 200 */     if (res.scale() < 8) {
/* 201 */       res = res.setScale(8);
/*     */     }
/*     */     
/* 204 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 209 */     StringBuilder buf = new StringBuilder(512);
/* 210 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 211 */     if (getOrganizationId() != null) {
/* 212 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 214 */     if (getRetailLocationId() != null) {
/* 215 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 217 */     if (getInventoryCountId() != null) {
/* 218 */       buf.append("inventoryCountId").append("=").append(getInventoryCountId()).append(" ");
/*     */     }
/* 220 */     if (getInventoryLocationId() != null) {
/* 221 */       buf.append("inventoryLocationId").append("=").append(getInventoryLocationId()).append(" ");
/*     */     }
/* 223 */     if (getInventoryBucketId() != null) {
/* 224 */       buf.append("inventoryBucketId").append("=").append(getInventoryBucketId()).append(" ");
/*     */     }
/* 226 */     if (getItemId() != null) {
/* 227 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 229 */     if (getCreateDate() != null) {
/* 230 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 232 */     if (getCreateUserId() != null) {
/* 233 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 235 */     if (getUpdateDate() != null) {
/* 236 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 238 */     if (getUpdateUserId() != null) {
/* 239 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 241 */     if (getSnapshotDate() != null) {
/* 242 */       buf.append("snapshotDate").append("=").append(getSnapshotDate()).append(" ");
/*     */     }
/* 244 */     if (getQuantity() != null) {
/* 245 */       buf.append("quantity").append("=").append(getQuantity()).append(" ");
/*     */     }
/*     */     
/* 248 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 252 */     InventoryCountSnapshotId id = new InventoryCountSnapshotId();
/* 253 */     id.setOrganizationId(getOrganizationId());
/* 254 */     id.setRetailLocationId(getRetailLocationId());
/* 255 */     id.setInventoryCountId(getInventoryCountId());
/* 256 */     id.setInventoryLocationId(getInventoryLocationId());
/* 257 */     id.setInventoryBucketId(getInventoryBucketId());
/* 258 */     id.setItemId(getItemId());
/* 259 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 263 */     setOrganizationId(((InventoryCountSnapshotId)argObjectId).getOrganizationId());
/* 264 */     setRetailLocationId(((InventoryCountSnapshotId)argObjectId).getRetailLocationId());
/* 265 */     setInventoryCountId(((InventoryCountSnapshotId)argObjectId).getInventoryCountId());
/* 266 */     setInventoryLocationId(((InventoryCountSnapshotId)argObjectId).getInventoryLocationId());
/* 267 */     setInventoryBucketId(((InventoryCountSnapshotId)argObjectId).getInventoryBucketId());
/* 268 */     setItemId(((InventoryCountSnapshotId)argObjectId).getItemId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 272 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 276 */     StringBuilder buf = new StringBuilder(600);
/* 277 */     buf.append("<").append("dao").append(" name=\"InventoryCountSnapshot\" cmd=\"" + getObjectStateString() + "\">");
/* 278 */     getFieldsAsXml(buf);
/* 279 */     buf.append("</").append("dao").append(">");
/*     */     
/* 281 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 285 */     Map<String, String> values = super.getValues();
/* 286 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 287 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 288 */     if (this._inventoryCountId != null) values.put("InventoryCountId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryCountId)); 
/* 289 */     if (this._inventoryLocationId != null) values.put("InventoryLocationId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryLocationId)); 
/* 290 */     if (this._inventoryBucketId != null) values.put("InventoryBucketId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryBucketId)); 
/* 291 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 292 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 293 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 294 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 295 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 296 */     if (this._snapshotDate != null) values.put("SnapshotDate", DaoUtils.getXmlSafeFieldValue(91, this._snapshotDate)); 
/* 297 */     if (this._quantity != null) values.put("Quantity", DaoUtils.getXmlSafeFieldValue(3, getQuantityDiff())); 
/* 298 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 303 */     super.setValues(argValues);
/* 304 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 306 */       String fieldName = field.getKey();
/* 307 */       String fieldValue = field.getValue();
/* 308 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 313 */             setOrganizationId((Long)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 322 */             setRetailLocationId((Long)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryCountId":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 331 */             setInventoryCountId((String)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setInventoryCountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryLocationId":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 340 */             setInventoryLocationId((String)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setInventoryLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryBucketId":
/*     */           try {
/* 348 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 349 */             setInventoryBucketId((String)value);
/* 350 */           } catch (Exception ee) {
/* 351 */             throw new DtxException("An exception occurred while calling setInventoryBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 358 */             setItemId((String)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 366 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 367 */             setCreateDate((Date)value);
/* 368 */           } catch (Exception ee) {
/* 369 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 375 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 376 */             setCreateUserId((String)value);
/* 377 */           } catch (Exception ee) {
/* 378 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 384 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 385 */             setUpdateDate((Date)value);
/* 386 */           } catch (Exception ee) {
/* 387 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 393 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 394 */             setUpdateUserId((String)value);
/* 395 */           } catch (Exception ee) {
/* 396 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SnapshotDate":
/*     */           try {
/* 402 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 403 */             setSnapshotDate((Date)value);
/* 404 */           } catch (Exception ee) {
/* 405 */             throw new DtxException("An exception occurred while calling setSnapshotDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Quantity":
/*     */           try {
/* 411 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 412 */             setQuantity((BigDecimal)value);
/* 413 */           } catch (Exception ee) {
/* 414 */             throw new DtxException("An exception occurred while calling setQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSnapshotDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */