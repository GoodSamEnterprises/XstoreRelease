/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCountSnapshotPropertyId;
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
/*     */ public class InventoryCountSnapshotPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1678057228L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryCountSnapshotPropertyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private String _inventoryLocationId;
/*     */   private String _inventoryBucketId;
/*     */   private String _itemId;
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
/*  42 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  46 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  47 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  52 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  56 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  57 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryCountId() {
/*  62 */     return this._inventoryCountId;
/*     */   }
/*     */   
/*     */   public void setInventoryCountId(String argInventoryCountId) {
/*  66 */     if (changed(argInventoryCountId, this._inventoryCountId, "inventoryCountId")) {
/*  67 */       this._inventoryCountId = (argInventoryCountId != null && MANAGE_CASE) ? argInventoryCountId.toUpperCase() : argInventoryCountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryLocationId() {
/*  72 */     return this._inventoryLocationId;
/*     */   }
/*     */   
/*     */   public void setInventoryLocationId(String argInventoryLocationId) {
/*  76 */     if (changed(argInventoryLocationId, this._inventoryLocationId, "inventoryLocationId")) {
/*  77 */       this._inventoryLocationId = (argInventoryLocationId != null && MANAGE_CASE) ? argInventoryLocationId.toUpperCase() : argInventoryLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryBucketId() {
/*  82 */     return this._inventoryBucketId;
/*     */   }
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/*  86 */     if (changed(argInventoryBucketId, this._inventoryBucketId, "inventoryBucketId")) {
/*  87 */       this._inventoryBucketId = (argInventoryBucketId != null && MANAGE_CASE) ? argInventoryBucketId.toUpperCase() : argInventoryBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  92 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  96 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  97 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/* 102 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 106 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/* 107 */       this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/* 112 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/* 116 */     if (changed(argType, this._type, "type")) {
/* 117 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/* 122 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 126 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/* 127 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/* 132 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 136 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 137 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 143 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 147 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 148 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 153 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 157 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 158 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 164 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 168 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 169 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 174 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 178 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 179 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 185 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 189 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 190 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 197 */     StringBuilder buf = new StringBuilder(512);
/* 198 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 199 */     if (getOrganizationId() != null) {
/* 200 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 202 */     if (getRetailLocationId() != null) {
/* 203 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 205 */     if (getInventoryCountId() != null) {
/* 206 */       buf.append("inventoryCountId").append("=").append(getInventoryCountId()).append(" ");
/*     */     }
/* 208 */     if (getInventoryLocationId() != null) {
/* 209 */       buf.append("inventoryLocationId").append("=").append(getInventoryLocationId()).append(" ");
/*     */     }
/* 211 */     if (getInventoryBucketId() != null) {
/* 212 */       buf.append("inventoryBucketId").append("=").append(getInventoryBucketId()).append(" ");
/*     */     }
/* 214 */     if (getItemId() != null) {
/* 215 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 217 */     if (getPropertyCode() != null) {
/* 218 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 220 */     if (getType() != null) {
/* 221 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 223 */     if (getStringValue() != null) {
/* 224 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 226 */     if (getDateValue() != null) {
/* 227 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 229 */     if (getDecimalValue() != null) {
/* 230 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 232 */     if (getCreateDate() != null) {
/* 233 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 235 */     if (getCreateUserId() != null) {
/* 236 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 238 */     if (getUpdateDate() != null) {
/* 239 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 241 */     if (getUpdateUserId() != null) {
/* 242 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 245 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 249 */     InventoryCountSnapshotPropertyId id = new InventoryCountSnapshotPropertyId();
/* 250 */     id.setOrganizationId(getOrganizationId());
/* 251 */     id.setRetailLocationId(getRetailLocationId());
/* 252 */     id.setInventoryCountId(getInventoryCountId());
/* 253 */     id.setInventoryLocationId(getInventoryLocationId());
/* 254 */     id.setInventoryBucketId(getInventoryBucketId());
/* 255 */     id.setItemId(getItemId());
/* 256 */     id.setPropertyCode(getPropertyCode());
/* 257 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 261 */     setOrganizationId(((InventoryCountSnapshotPropertyId)argObjectId).getOrganizationId());
/* 262 */     setRetailLocationId(((InventoryCountSnapshotPropertyId)argObjectId).getRetailLocationId());
/* 263 */     setInventoryCountId(((InventoryCountSnapshotPropertyId)argObjectId).getInventoryCountId());
/* 264 */     setInventoryLocationId(((InventoryCountSnapshotPropertyId)argObjectId).getInventoryLocationId());
/* 265 */     setInventoryBucketId(((InventoryCountSnapshotPropertyId)argObjectId).getInventoryBucketId());
/* 266 */     setItemId(((InventoryCountSnapshotPropertyId)argObjectId).getItemId());
/* 267 */     setPropertyCode(((InventoryCountSnapshotPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 271 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 275 */     StringBuilder buf = new StringBuilder(750);
/* 276 */     buf.append("<").append("dao").append(" name=\"InventoryCountSnapshotProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 277 */     getFieldsAsXml(buf);
/* 278 */     buf.append("</").append("dao").append(">");
/*     */     
/* 280 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 284 */     Map<String, String> values = super.getValues();
/* 285 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 286 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 287 */     if (this._inventoryCountId != null) values.put("InventoryCountId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryCountId)); 
/* 288 */     if (this._inventoryLocationId != null) values.put("InventoryLocationId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryLocationId)); 
/* 289 */     if (this._inventoryBucketId != null) values.put("InventoryBucketId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryBucketId)); 
/* 290 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 291 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 292 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 293 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 294 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 295 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 296 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 297 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 298 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 299 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 300 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 305 */     super.setValues(argValues);
/* 306 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 308 */       String fieldName = field.getKey();
/* 309 */       String fieldValue = field.getValue();
/* 310 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 314 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 315 */             setOrganizationId((Long)value);
/* 316 */           } catch (Exception ee) {
/* 317 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 323 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 324 */             setRetailLocationId((Long)value);
/* 325 */           } catch (Exception ee) {
/* 326 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryCountId":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 333 */             setInventoryCountId((String)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setInventoryCountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryLocationId":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 342 */             setInventoryLocationId((String)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setInventoryLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryBucketId":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 351 */             setInventoryBucketId((String)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setInventoryBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 360 */             setItemId((String)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 368 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 369 */             setPropertyCode((String)value);
/* 370 */           } catch (Exception ee) {
/* 371 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 377 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 378 */             setType((String)value);
/* 379 */           } catch (Exception ee) {
/* 380 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 386 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 387 */             setStringValue((String)value);
/* 388 */           } catch (Exception ee) {
/* 389 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 395 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 396 */             setDateValue((Date)value);
/* 397 */           } catch (Exception ee) {
/* 398 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 404 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 405 */             setDecimalValue((BigDecimal)value);
/* 406 */           } catch (Exception ee) {
/* 407 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 413 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 414 */             setCreateDate((Date)value);
/* 415 */           } catch (Exception ee) {
/* 416 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 422 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 423 */             setCreateUserId((String)value);
/* 424 */           } catch (Exception ee) {
/* 425 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 431 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 432 */             setUpdateDate((Date)value);
/* 433 */           } catch (Exception ee) {
/* 434 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 440 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 441 */             setUpdateUserId((String)value);
/* 442 */           } catch (Exception ee) {
/* 443 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSnapshotPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */