/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.AbstractDataModelPropertiesImpl;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.xst.dao.itm.IItemRestrictionProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemRestrictionPropertyModel
/*     */   extends AbstractDataModelPropertiesImpl
/*     */   implements IItemRestrictionProperty
/*     */ {
/*     */   private static final long serialVersionUID = 1913911182L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  31 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */ 
/*     */   
/*     */   public void initDAO() {
/*  36 */     setDAO((IDataAccessObject)new ItemRestrictionPropertyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemRestrictionPropertyDAO getDAO_() {
/*  44 */     return (ItemRestrictionPropertyDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  52 */     if (getDAO_().getOrganizationId() != null) {
/*  53 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  56 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  65 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  66 */       this._events != null && 
/*  67 */       postEventsForChanges()) {
/*  68 */       this._events.post(IItemRestrictionProperty.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  75 */     boolean ev_postable = false;
/*     */     
/*  77 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  78 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  79 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  80 */       ev_postable = true;
/*     */     } 
/*     */     
/*  83 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRestrictionCategory() {
/*  91 */     return getDAO_().getRestrictionCategory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRestrictionCategory(String argRestrictionCategory) {
/*  99 */     if (setRestrictionCategory_noev(argRestrictionCategory) && 
/* 100 */       this._events != null && 
/* 101 */       postEventsForChanges()) {
/* 102 */       this._events.post(IItemRestrictionProperty.SET_RESTRICTIONCATEGORY, argRestrictionCategory);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRestrictionCategory_noev(String argRestrictionCategory) {
/* 109 */     boolean ev_postable = false;
/*     */     
/* 111 */     if ((getDAO_().getRestrictionCategory() == null && argRestrictionCategory != null) || (
/* 112 */       getDAO_().getRestrictionCategory() != null && !getDAO_().getRestrictionCategory().equals(argRestrictionCategory))) {
/* 113 */       getDAO_().setRestrictionCategory(argRestrictionCategory);
/* 114 */       ev_postable = true;
/*     */     } 
/*     */     
/* 117 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRestrictionCode() {
/* 125 */     return getDAO_().getRestrictionCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRestrictionCode(String argRestrictionCode) {
/* 133 */     if (setRestrictionCode_noev(argRestrictionCode) && 
/* 134 */       this._events != null && 
/* 135 */       postEventsForChanges()) {
/* 136 */       this._events.post(IItemRestrictionProperty.SET_RESTRICTIONCODE, argRestrictionCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRestrictionCode_noev(String argRestrictionCode) {
/* 143 */     boolean ev_postable = false;
/*     */     
/* 145 */     if ((getDAO_().getRestrictionCode() == null && argRestrictionCode != null) || (
/* 146 */       getDAO_().getRestrictionCode() != null && !getDAO_().getRestrictionCode().equals(argRestrictionCode))) {
/* 147 */       getDAO_().setRestrictionCode(argRestrictionCode);
/* 148 */       ev_postable = true;
/*     */     } 
/*     */     
/* 151 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 159 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 167 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 168 */       this._events != null && 
/* 169 */       postEventsForChanges()) {
/* 170 */       this._events.post(IItemRestrictionProperty.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 177 */     boolean ev_postable = false;
/*     */     
/* 179 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 180 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 181 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 182 */       ev_postable = true;
/*     */     } 
/*     */     
/* 185 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSaleLineItemTypeCode() {
/* 193 */     return getDAO_().getSaleLineItemTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSaleLineItemTypeCode(String argSaleLineItemTypeCode) {
/* 201 */     if (setSaleLineItemTypeCode_noev(argSaleLineItemTypeCode) && 
/* 202 */       this._events != null && 
/* 203 */       postEventsForChanges()) {
/* 204 */       this._events.post(IItemRestrictionProperty.SET_SALELINEITEMTYPECODE, argSaleLineItemTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSaleLineItemTypeCode_noev(String argSaleLineItemTypeCode) {
/* 211 */     boolean ev_postable = false;
/*     */     
/* 213 */     if ((getDAO_().getSaleLineItemTypeCode() == null && argSaleLineItemTypeCode != null) || (
/* 214 */       getDAO_().getSaleLineItemTypeCode() != null && !getDAO_().getSaleLineItemTypeCode().equals(argSaleLineItemTypeCode))) {
/* 215 */       getDAO_().setSaleLineItemTypeCode(argSaleLineItemTypeCode);
/* 216 */       ev_postable = true;
/*     */     } 
/*     */     
/* 219 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyName() {
/* 227 */     return getDAO_().getPropertyName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyName(String argPropertyName) {
/* 235 */     if (setPropertyName_noev(argPropertyName) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(IItemRestrictionProperty.SET_PROPERTYNAME, argPropertyName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyName_noev(String argPropertyName) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getPropertyName() == null && argPropertyName != null) || (
/* 248 */       getDAO_().getPropertyName() != null && !getDAO_().getPropertyName().equals(argPropertyName))) {
/* 249 */       getDAO_().setPropertyName(argPropertyName);
/* 250 */       ev_postable = true;
/*     */     } 
/*     */     
/* 253 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/* 261 */     return getDAO_().getPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 269 */     if (setPropertyCode_noev(argPropertyCode) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(IItemRestrictionProperty.SET_PROPERTYCODE, argPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyCode_noev(String argPropertyCode) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getPropertyCode() == null && argPropertyCode != null) || (
/* 282 */       getDAO_().getPropertyCode() != null && !getDAO_().getPropertyCode().equals(argPropertyCode))) {
/* 283 */       getDAO_().setPropertyCode(argPropertyCode);
/* 284 */       ev_postable = true;
/*     */     } 
/*     */     
/* 287 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 295 */     return getDAO_().getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 303 */     if (setType_noev(argType) && 
/* 304 */       this._events != null && 
/* 305 */       postEventsForChanges()) {
/* 306 */       this._events.post(IItemRestrictionProperty.SET_TYPE, argType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setType_noev(String argType) {
/* 313 */     boolean ev_postable = false;
/*     */     
/* 315 */     if ((getDAO_().getType() == null && argType != null) || (
/* 316 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 317 */       getDAO_().setType(argType);
/* 318 */       ev_postable = true;
/*     */     } 
/*     */     
/* 321 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 329 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 337 */     if (setStringValue_noev(argStringValue) && 
/* 338 */       this._events != null && 
/* 339 */       postEventsForChanges()) {
/* 340 */       this._events.post(IItemRestrictionProperty.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 347 */     boolean ev_postable = false;
/*     */     
/* 349 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 350 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 351 */       getDAO_().setStringValue(argStringValue);
/* 352 */       ev_postable = true;
/*     */     } 
/*     */     
/* 355 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDateValue() {
/* 363 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 371 */     if (setDateValue_noev(argDateValue) && 
/* 372 */       this._events != null && 
/* 373 */       postEventsForChanges()) {
/* 374 */       this._events.post(IItemRestrictionProperty.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 381 */     boolean ev_postable = false;
/*     */     
/* 383 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 384 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 385 */       getDAO_().setDateValue(argDateValue);
/* 386 */       ev_postable = true;
/*     */     } 
/*     */     
/* 389 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 397 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 405 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 406 */       this._events != null && 
/* 407 */       postEventsForChanges()) {
/* 408 */       this._events.post(IItemRestrictionProperty.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 415 */     boolean ev_postable = false;
/*     */     
/* 417 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 418 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 419 */       getDAO_().setDecimalValue(argDecimalValue);
/* 420 */       ev_postable = true;
/*     */     } 
/*     */     
/* 423 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 431 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 439 */     if (setCreateDate_noev(argCreateDate) && 
/* 440 */       this._events != null && 
/* 441 */       postEventsForChanges()) {
/* 442 */       this._events.post(IItemRestrictionProperty.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 449 */     boolean ev_postable = false;
/*     */     
/* 451 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 452 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 453 */       getDAO_().setCreateDate(argCreateDate);
/* 454 */       ev_postable = true;
/*     */     } 
/*     */     
/* 457 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 465 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 473 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 474 */       this._events != null && 
/* 475 */       postEventsForChanges()) {
/* 476 */       this._events.post(IItemRestrictionProperty.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 483 */     boolean ev_postable = false;
/*     */     
/* 485 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 486 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 487 */       getDAO_().setCreateUserId(argCreateUserId);
/* 488 */       ev_postable = true;
/*     */     } 
/*     */     
/* 491 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 499 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 507 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 508 */       this._events != null && 
/* 509 */       postEventsForChanges()) {
/* 510 */       this._events.post(IItemRestrictionProperty.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 517 */     boolean ev_postable = false;
/*     */     
/* 519 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 520 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 521 */       getDAO_().setUpdateDate(argUpdateDate);
/* 522 */       ev_postable = true;
/*     */     } 
/*     */     
/* 525 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 533 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 541 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 542 */       this._events != null && 
/* 543 */       postEventsForChanges()) {
/* 544 */       this._events.post(IItemRestrictionProperty.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 551 */     boolean ev_postable = false;
/*     */     
/* 553 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 554 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 555 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 556 */       ev_postable = true;
/*     */     } 
/*     */     
/* 559 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 565 */     if ("ItemRestrictionPropertyExtension".equals(argFieldId)) {
/* 566 */       return this._myExtension;
/*     */     }
/*     */     
/* 569 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 575 */     if ("ItemRestrictionPropertyExtension".equals(argFieldId)) {
/* 576 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 579 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 585 */     this._persistenceDefaults = argPD;
/* 586 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 587 */     this._eventManager = argEM;
/* 588 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 589 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 594 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 598 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 601 */     super.startTransaction();
/*     */ 
/*     */     
/* 604 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 609 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 612 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 618 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 621 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 624 */     super.commitTransaction();
/*     */ 
/*     */     
/* 627 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 632 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictionPropertyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */