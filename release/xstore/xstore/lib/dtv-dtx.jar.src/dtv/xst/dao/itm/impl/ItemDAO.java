/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractExtensibleDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemId;
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
/*     */ public class ItemDAO
/*     */   extends AbstractExtensibleDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 2289459L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _className;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _description;
/*     */   private String _itemLevelCode;
/*     */   private String _itemTypeCode;
/*     */   private String _merchLevel1Id;
/*     */   private String _merchLevel2Id;
/*     */   private String _merchLevel3Id;
/*     */   private String _merchLevel4Id;
/*  41 */   private Boolean _serializedItem = Boolean.FALSE;
/*     */   private String _parentItemId;
/*     */   private String _name;
/*  44 */   private Boolean _disallowItemMatrixDisplay = Boolean.FALSE;
/*     */   private String _itemMatrixColor;
/*     */   private String _dimensionSystem;
/*     */   private String _dimension1;
/*     */   private String _dimension2;
/*     */   private String _dimension3;
/*     */   private BigDecimal _listPrice;
/*  51 */   private Boolean _measurementRequired = Boolean.FALSE;
/*  52 */   private Boolean _notInventoried = Boolean.FALSE;
/*     */   private String _externalSystem;
/*     */   
/*     */   public Long getOrganizationId() {
/*  56 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  60 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  61 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  66 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  70 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  71 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getClassName() {
/*  76 */     return this._className;
/*     */   }
/*     */   
/*     */   public void setClassName(String argClassName) {
/*  80 */     if (changed(argClassName, this._className, "className")) {
/*  81 */       this._className = argClassName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  86 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  90 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  91 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  97 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 101 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 102 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 107 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 111 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 112 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 118 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 122 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 123 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 128 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 132 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 133 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 138 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 142 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 143 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 148 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 152 */     if (changed(argDescription, this._description, "description")) {
/* 153 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemLevelCode() {
/* 158 */     return this._itemLevelCode;
/*     */   }
/*     */   
/*     */   public void setItemLevelCode(String argItemLevelCode) {
/* 162 */     if (changed(argItemLevelCode, this._itemLevelCode, "itemLevelCode")) {
/* 163 */       this._itemLevelCode = argItemLevelCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemTypeCode() {
/* 168 */     return this._itemTypeCode;
/*     */   }
/*     */   
/*     */   public void setItemTypeCode(String argItemTypeCode) {
/* 172 */     if (changed(argItemTypeCode, this._itemTypeCode, "itemTypeCode")) {
/* 173 */       this._itemTypeCode = argItemTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMerchLevel1Id() {
/* 178 */     return this._merchLevel1Id;
/*     */   }
/*     */   
/*     */   public void setMerchLevel1Id(String argMerchLevel1Id) {
/* 182 */     if (changed(argMerchLevel1Id, this._merchLevel1Id, "merchLevel1Id")) {
/* 183 */       this._merchLevel1Id = argMerchLevel1Id;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMerchLevel2Id() {
/* 188 */     return this._merchLevel2Id;
/*     */   }
/*     */   
/*     */   public void setMerchLevel2Id(String argMerchLevel2Id) {
/* 192 */     if (changed(argMerchLevel2Id, this._merchLevel2Id, "merchLevel2Id")) {
/* 193 */       this._merchLevel2Id = argMerchLevel2Id;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMerchLevel3Id() {
/* 198 */     return this._merchLevel3Id;
/*     */   }
/*     */   
/*     */   public void setMerchLevel3Id(String argMerchLevel3Id) {
/* 202 */     if (changed(argMerchLevel3Id, this._merchLevel3Id, "merchLevel3Id")) {
/* 203 */       this._merchLevel3Id = argMerchLevel3Id;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMerchLevel4Id() {
/* 208 */     return this._merchLevel4Id;
/*     */   }
/*     */   
/*     */   public void setMerchLevel4Id(String argMerchLevel4Id) {
/* 212 */     if (changed(argMerchLevel4Id, this._merchLevel4Id, "merchLevel4Id")) {
/* 213 */       this._merchLevel4Id = argMerchLevel4Id;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getSerializedItem() {
/* 218 */     return this._serializedItem;
/*     */   }
/*     */   
/*     */   public void setSerializedItem(Boolean argSerializedItem) {
/* 222 */     if (changed(argSerializedItem, this._serializedItem, "serializedItem")) {
/* 223 */       this._serializedItem = argSerializedItem;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getParentItemId() {
/* 228 */     return this._parentItemId;
/*     */   }
/*     */   
/*     */   public void setParentItemId(String argParentItemId) {
/* 232 */     if (changed(argParentItemId, this._parentItemId, "parentItemId")) {
/* 233 */       this._parentItemId = argParentItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getName() {
/* 238 */     return this._name;
/*     */   }
/*     */   
/*     */   public void setName(String argName) {
/* 242 */     if (changed(argName, this._name, "name")) {
/* 243 */       this._name = argName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getDisallowItemMatrixDisplay() {
/* 248 */     return this._disallowItemMatrixDisplay;
/*     */   }
/*     */   
/*     */   public void setDisallowItemMatrixDisplay(Boolean argDisallowItemMatrixDisplay) {
/* 252 */     if (changed(argDisallowItemMatrixDisplay, this._disallowItemMatrixDisplay, "disallowItemMatrixDisplay")) {
/* 253 */       this._disallowItemMatrixDisplay = argDisallowItemMatrixDisplay;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemMatrixColor() {
/* 258 */     return this._itemMatrixColor;
/*     */   }
/*     */   
/*     */   public void setItemMatrixColor(String argItemMatrixColor) {
/* 262 */     if (changed(argItemMatrixColor, this._itemMatrixColor, "itemMatrixColor")) {
/* 263 */       this._itemMatrixColor = argItemMatrixColor;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDimensionSystem() {
/* 268 */     return this._dimensionSystem;
/*     */   }
/*     */   
/*     */   public void setDimensionSystem(String argDimensionSystem) {
/* 272 */     if (changed(argDimensionSystem, this._dimensionSystem, "dimensionSystem")) {
/* 273 */       this._dimensionSystem = argDimensionSystem;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDimension1() {
/* 278 */     return this._dimension1;
/*     */   }
/*     */   
/*     */   public void setDimension1(String argDimension1) {
/* 282 */     if (changed(argDimension1, this._dimension1, "dimension1")) {
/* 283 */       this._dimension1 = argDimension1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDimension2() {
/* 288 */     return this._dimension2;
/*     */   }
/*     */   
/*     */   public void setDimension2(String argDimension2) {
/* 292 */     if (changed(argDimension2, this._dimension2, "dimension2")) {
/* 293 */       this._dimension2 = argDimension2;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDimension3() {
/* 298 */     return this._dimension3;
/*     */   }
/*     */   
/*     */   public void setDimension3(String argDimension3) {
/* 302 */     if (changed(argDimension3, this._dimension3, "dimension3")) {
/* 303 */       this._dimension3 = argDimension3;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getListPrice() {
/* 308 */     return this._listPrice;
/*     */   }
/*     */   
/*     */   public void setListPrice(BigDecimal argListPrice) {
/* 312 */     if (changed(argListPrice, this._listPrice, "listPrice")) {
/* 313 */       this._listPrice = argListPrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getMeasurementRequired() {
/* 318 */     return this._measurementRequired;
/*     */   }
/*     */   
/*     */   public void setMeasurementRequired(Boolean argMeasurementRequired) {
/* 322 */     if (changed(argMeasurementRequired, this._measurementRequired, "measurementRequired")) {
/* 323 */       this._measurementRequired = argMeasurementRequired;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getNotInventoried() {
/* 328 */     return this._notInventoried;
/*     */   }
/*     */   
/*     */   public void setNotInventoried(Boolean argNotInventoried) {
/* 332 */     if (changed(argNotInventoried, this._notInventoried, "notInventoried")) {
/* 333 */       this._notInventoried = argNotInventoried;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getExternalSystem() {
/* 338 */     return this._externalSystem;
/*     */   }
/*     */   
/*     */   public void setExternalSystem(String argExternalSystem) {
/* 342 */     if (changed(argExternalSystem, this._externalSystem, "externalSystem")) {
/* 343 */       this._externalSystem = argExternalSystem;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 350 */     StringBuilder buf = new StringBuilder(512);
/* 351 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 352 */     if (getOrganizationId() != null) {
/* 353 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 355 */     if (getItemId() != null) {
/* 356 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 358 */     if (getClassName() != null) {
/* 359 */       buf.append("className").append("=").append(getClassName()).append(" ");
/*     */     }
/* 361 */     if (getCreateDate() != null) {
/* 362 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 364 */     if (getCreateUserId() != null) {
/* 365 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 367 */     if (getUpdateDate() != null) {
/* 368 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 370 */     if (getUpdateUserId() != null) {
/* 371 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 373 */     if (getOrgCode() != null) {
/* 374 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 376 */     if (getOrgValue() != null) {
/* 377 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 379 */     if (getDescription() != null) {
/* 380 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 382 */     if (getItemLevelCode() != null) {
/* 383 */       buf.append("itemLevelCode").append("=").append(getItemLevelCode()).append(" ");
/*     */     }
/* 385 */     if (getItemTypeCode() != null) {
/* 386 */       buf.append("itemTypeCode").append("=").append(getItemTypeCode()).append(" ");
/*     */     }
/* 388 */     if (getMerchLevel1Id() != null) {
/* 389 */       buf.append("merchLevel1Id").append("=").append(getMerchLevel1Id()).append(" ");
/*     */     }
/* 391 */     if (getMerchLevel2Id() != null) {
/* 392 */       buf.append("merchLevel2Id").append("=").append(getMerchLevel2Id()).append(" ");
/*     */     }
/* 394 */     if (getMerchLevel3Id() != null) {
/* 395 */       buf.append("merchLevel3Id").append("=").append(getMerchLevel3Id()).append(" ");
/*     */     }
/* 397 */     if (getMerchLevel4Id() != null) {
/* 398 */       buf.append("merchLevel4Id").append("=").append(getMerchLevel4Id()).append(" ");
/*     */     }
/* 400 */     if (getSerializedItem() != null && getSerializedItem().booleanValue()) {
/* 401 */       buf.append("serializedItem").append("=").append(getSerializedItem()).append(" ");
/*     */     }
/* 403 */     if (getParentItemId() != null) {
/* 404 */       buf.append("parentItemId").append("=").append(getParentItemId()).append(" ");
/*     */     }
/* 406 */     if (getName() != null) {
/* 407 */       buf.append("name").append("=").append(getName()).append(" ");
/*     */     }
/* 409 */     if (getDisallowItemMatrixDisplay() != null && getDisallowItemMatrixDisplay().booleanValue()) {
/* 410 */       buf.append("disallowItemMatrixDisplay").append("=").append(getDisallowItemMatrixDisplay()).append(" ");
/*     */     }
/* 412 */     if (getItemMatrixColor() != null) {
/* 413 */       buf.append("itemMatrixColor").append("=").append(getItemMatrixColor()).append(" ");
/*     */     }
/* 415 */     if (getDimensionSystem() != null) {
/* 416 */       buf.append("dimensionSystem").append("=").append(getDimensionSystem()).append(" ");
/*     */     }
/* 418 */     if (getDimension1() != null) {
/* 419 */       buf.append("dimension1").append("=").append(getDimension1()).append(" ");
/*     */     }
/* 421 */     if (getDimension2() != null) {
/* 422 */       buf.append("dimension2").append("=").append(getDimension2()).append(" ");
/*     */     }
/* 424 */     if (getDimension3() != null) {
/* 425 */       buf.append("dimension3").append("=").append(getDimension3()).append(" ");
/*     */     }
/* 427 */     if (getListPrice() != null) {
/* 428 */       buf.append("listPrice").append("=").append(getListPrice()).append(" ");
/*     */     }
/* 430 */     if (getMeasurementRequired() != null && getMeasurementRequired().booleanValue()) {
/* 431 */       buf.append("measurementRequired").append("=").append(getMeasurementRequired()).append(" ");
/*     */     }
/* 433 */     if (getNotInventoried() != null && getNotInventoried().booleanValue()) {
/* 434 */       buf.append("notInventoried").append("=").append(getNotInventoried()).append(" ");
/*     */     }
/* 436 */     if (getExternalSystem() != null) {
/* 437 */       buf.append("externalSystem").append("=").append(getExternalSystem()).append(" ");
/*     */     }
/*     */     
/* 440 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 444 */     ItemId id = new ItemId();
/* 445 */     id.setOrganizationId(getOrganizationId());
/* 446 */     id.setItemId(getItemId());
/* 447 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 451 */     setOrganizationId(((ItemId)argObjectId).getOrganizationId());
/* 452 */     setItemId(((ItemId)argObjectId).getItemId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 456 */     return this._className;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 460 */     StringBuilder buf = new StringBuilder(1450);
/* 461 */     buf.append("<").append("dao").append(" name=\"Item\" cmd=\"" + getObjectStateString() + "\">");
/* 462 */     getFieldsAsXml(buf);
/* 463 */     buf.append("</").append("dao").append(">");
/*     */     
/* 465 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 469 */     Map<String, String> values = super.getValues();
/* 470 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 471 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 472 */     if (this._className != null) values.put("ClassName", DaoUtils.getXmlSafeFieldValue(12, this._className)); 
/* 473 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 474 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 475 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 476 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 477 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 478 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 479 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 480 */     if (this._itemLevelCode != null) values.put("ItemLevelCode", DaoUtils.getXmlSafeFieldValue(12, this._itemLevelCode)); 
/* 481 */     if (this._itemTypeCode != null) values.put("ItemTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._itemTypeCode)); 
/* 482 */     if (this._merchLevel1Id != null) values.put("MerchLevel1Id", DaoUtils.getXmlSafeFieldValue(12, this._merchLevel1Id)); 
/* 483 */     if (this._merchLevel2Id != null) values.put("MerchLevel2Id", DaoUtils.getXmlSafeFieldValue(12, this._merchLevel2Id)); 
/* 484 */     if (this._merchLevel3Id != null) values.put("MerchLevel3Id", DaoUtils.getXmlSafeFieldValue(12, this._merchLevel3Id)); 
/* 485 */     if (this._merchLevel4Id != null) values.put("MerchLevel4Id", DaoUtils.getXmlSafeFieldValue(12, this._merchLevel4Id)); 
/* 486 */     if (this._serializedItem != null) values.put("SerializedItem", DaoUtils.getXmlSafeFieldValue(-7, this._serializedItem)); 
/* 487 */     if (this._parentItemId != null) values.put("ParentItemId", DaoUtils.getXmlSafeFieldValue(12, this._parentItemId)); 
/* 488 */     if (this._name != null) values.put("Name", DaoUtils.getXmlSafeFieldValue(12, this._name)); 
/* 489 */     if (this._disallowItemMatrixDisplay != null) values.put("DisallowItemMatrixDisplay", DaoUtils.getXmlSafeFieldValue(-7, this._disallowItemMatrixDisplay)); 
/* 490 */     if (this._itemMatrixColor != null) values.put("ItemMatrixColor", DaoUtils.getXmlSafeFieldValue(12, this._itemMatrixColor)); 
/* 491 */     if (this._dimensionSystem != null) values.put("DimensionSystem", DaoUtils.getXmlSafeFieldValue(12, this._dimensionSystem)); 
/* 492 */     if (this._dimension1 != null) values.put("Dimension1", DaoUtils.getXmlSafeFieldValue(12, this._dimension1)); 
/* 493 */     if (this._dimension2 != null) values.put("Dimension2", DaoUtils.getXmlSafeFieldValue(12, this._dimension2)); 
/* 494 */     if (this._dimension3 != null) values.put("Dimension3", DaoUtils.getXmlSafeFieldValue(12, this._dimension3)); 
/* 495 */     if (this._listPrice != null) values.put("ListPrice", DaoUtils.getXmlSafeFieldValue(3, this._listPrice)); 
/* 496 */     if (this._measurementRequired != null) values.put("MeasurementRequired", DaoUtils.getXmlSafeFieldValue(-7, this._measurementRequired)); 
/* 497 */     if (this._notInventoried != null) values.put("NotInventoried", DaoUtils.getXmlSafeFieldValue(-7, this._notInventoried)); 
/* 498 */     if (this._externalSystem != null) values.put("ExternalSystem", DaoUtils.getXmlSafeFieldValue(12, this._externalSystem)); 
/* 499 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 504 */     super.setValues(argValues);
/* 505 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 507 */       String fieldName = field.getKey();
/* 508 */       String fieldValue = field.getValue();
/* 509 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 513 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 514 */             setOrganizationId((Long)value);
/* 515 */           } catch (Exception ee) {
/* 516 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 522 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 523 */             setItemId((String)value);
/* 524 */           } catch (Exception ee) {
/* 525 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ClassName":
/*     */           try {
/* 531 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 532 */             setClassName((String)value);
/* 533 */           } catch (Exception ee) {
/* 534 */             throw new DtxException("An exception occurred while calling setClassName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 540 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 541 */             setCreateDate((Date)value);
/* 542 */           } catch (Exception ee) {
/* 543 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 549 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 550 */             setCreateUserId((String)value);
/* 551 */           } catch (Exception ee) {
/* 552 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 558 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 559 */             setUpdateDate((Date)value);
/* 560 */           } catch (Exception ee) {
/* 561 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 567 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 568 */             setUpdateUserId((String)value);
/* 569 */           } catch (Exception ee) {
/* 570 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 576 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 577 */             setOrgCode((String)value);
/* 578 */           } catch (Exception ee) {
/* 579 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 585 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 586 */             setOrgValue((String)value);
/* 587 */           } catch (Exception ee) {
/* 588 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 594 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 595 */             setDescription((String)value);
/* 596 */           } catch (Exception ee) {
/* 597 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemLevelCode":
/*     */           try {
/* 603 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 604 */             setItemLevelCode((String)value);
/* 605 */           } catch (Exception ee) {
/* 606 */             throw new DtxException("An exception occurred while calling setItemLevelCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemTypeCode":
/*     */           try {
/* 612 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 613 */             setItemTypeCode((String)value);
/* 614 */           } catch (Exception ee) {
/* 615 */             throw new DtxException("An exception occurred while calling setItemTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MerchLevel1Id":
/*     */           try {
/* 621 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 622 */             setMerchLevel1Id((String)value);
/* 623 */           } catch (Exception ee) {
/* 624 */             throw new DtxException("An exception occurred while calling setMerchLevel1Id() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MerchLevel2Id":
/*     */           try {
/* 630 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 631 */             setMerchLevel2Id((String)value);
/* 632 */           } catch (Exception ee) {
/* 633 */             throw new DtxException("An exception occurred while calling setMerchLevel2Id() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MerchLevel3Id":
/*     */           try {
/* 639 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 640 */             setMerchLevel3Id((String)value);
/* 641 */           } catch (Exception ee) {
/* 642 */             throw new DtxException("An exception occurred while calling setMerchLevel3Id() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MerchLevel4Id":
/*     */           try {
/* 648 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 649 */             setMerchLevel4Id((String)value);
/* 650 */           } catch (Exception ee) {
/* 651 */             throw new DtxException("An exception occurred while calling setMerchLevel4Id() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerializedItem":
/*     */           try {
/* 657 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 658 */             setSerializedItem((Boolean)value);
/* 659 */           } catch (Exception ee) {
/* 660 */             throw new DtxException("An exception occurred while calling setSerializedItem() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ParentItemId":
/*     */           try {
/* 666 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 667 */             setParentItemId((String)value);
/* 668 */           } catch (Exception ee) {
/* 669 */             throw new DtxException("An exception occurred while calling setParentItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Name":
/*     */           try {
/* 675 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 676 */             setName((String)value);
/* 677 */           } catch (Exception ee) {
/* 678 */             throw new DtxException("An exception occurred while calling setName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DisallowItemMatrixDisplay":
/*     */           try {
/* 684 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 685 */             setDisallowItemMatrixDisplay((Boolean)value);
/* 686 */           } catch (Exception ee) {
/* 687 */             throw new DtxException("An exception occurred while calling setDisallowItemMatrixDisplay() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemMatrixColor":
/*     */           try {
/* 693 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 694 */             setItemMatrixColor((String)value);
/* 695 */           } catch (Exception ee) {
/* 696 */             throw new DtxException("An exception occurred while calling setItemMatrixColor() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DimensionSystem":
/*     */           try {
/* 702 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 703 */             setDimensionSystem((String)value);
/* 704 */           } catch (Exception ee) {
/* 705 */             throw new DtxException("An exception occurred while calling setDimensionSystem() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Dimension1":
/*     */           try {
/* 711 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 712 */             setDimension1((String)value);
/* 713 */           } catch (Exception ee) {
/* 714 */             throw new DtxException("An exception occurred while calling setDimension1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Dimension2":
/*     */           try {
/* 720 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 721 */             setDimension2((String)value);
/* 722 */           } catch (Exception ee) {
/* 723 */             throw new DtxException("An exception occurred while calling setDimension2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Dimension3":
/*     */           try {
/* 729 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 730 */             setDimension3((String)value);
/* 731 */           } catch (Exception ee) {
/* 732 */             throw new DtxException("An exception occurred while calling setDimension3() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ListPrice":
/*     */           try {
/* 738 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 739 */             setListPrice((BigDecimal)value);
/* 740 */           } catch (Exception ee) {
/* 741 */             throw new DtxException("An exception occurred while calling setListPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MeasurementRequired":
/*     */           try {
/* 747 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 748 */             setMeasurementRequired((Boolean)value);
/* 749 */           } catch (Exception ee) {
/* 750 */             throw new DtxException("An exception occurred while calling setMeasurementRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "NotInventoried":
/*     */           try {
/* 756 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 757 */             setNotInventoried((Boolean)value);
/* 758 */           } catch (Exception ee) {
/* 759 */             throw new DtxException("An exception occurred while calling setNotInventoried() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExternalSystem":
/*     */           try {
/* 765 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 766 */             setExternalSystem((String)value);
/* 767 */           } catch (Exception ee) {
/* 768 */             throw new DtxException("An exception occurred while calling setExternalSystem() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */