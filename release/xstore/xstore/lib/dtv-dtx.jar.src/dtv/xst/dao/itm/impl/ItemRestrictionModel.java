/*     */ package dtv.xst.dao.itm.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.itm.IItemRestriction;
/*     */ import dtv.xst.dao.itm.IItemRestrictionProperty;
/*     */ import dtv.xst.dao.itm.ItemRestrictionPropertyId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemRestrictionModel extends ItemRestrictionBaseModel implements IItemRestriction {
/*     */   private static final long serialVersionUID = 1589862041L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IItemRestrictionProperty> _properties; private transient HistoricalList<IItemRestrictionProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new ItemRestrictionDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemRestrictionDAO getDAO_() {
/*  47 */     return (ItemRestrictionDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  55 */     if (getDAO_().getOrganizationId() != null) {
/*  56 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  59 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  68 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  69 */       this._events != null && 
/*  70 */       postEventsForChanges()) {
/*  71 */       this._events.post(IItemRestriction.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  78 */     boolean ev_postable = false;
/*     */     
/*  80 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  81 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  82 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  83 */       ev_postable = true;
/*  84 */       if (this._properties != null) {
/*     */         
/*  86 */         Iterator<ItemRestrictionPropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((ItemRestrictionPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  94 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRestrictionCategory() {
/* 102 */     return getDAO_().getRestrictionCategory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRestrictionCategory(String argRestrictionCategory) {
/* 110 */     if (setRestrictionCategory_noev(argRestrictionCategory) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(IItemRestriction.SET_RESTRICTIONCATEGORY, argRestrictionCategory);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRestrictionCategory_noev(String argRestrictionCategory) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getRestrictionCategory() == null && argRestrictionCategory != null) || (
/* 123 */       getDAO_().getRestrictionCategory() != null && !getDAO_().getRestrictionCategory().equals(argRestrictionCategory))) {
/* 124 */       getDAO_().setRestrictionCategory(argRestrictionCategory);
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<ItemRestrictionPropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((ItemRestrictionPropertyModel)it.next()).setRestrictionCategory_noev(argRestrictionCategory);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 136 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRestrictionCode() {
/* 144 */     return getDAO_().getRestrictionCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRestrictionCode(String argRestrictionCode) {
/* 152 */     if (setRestrictionCode_noev(argRestrictionCode) && 
/* 153 */       this._events != null && 
/* 154 */       postEventsForChanges()) {
/* 155 */       this._events.post(IItemRestriction.SET_RESTRICTIONCODE, argRestrictionCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRestrictionCode_noev(String argRestrictionCode) {
/* 162 */     boolean ev_postable = false;
/*     */     
/* 164 */     if ((getDAO_().getRestrictionCode() == null && argRestrictionCode != null) || (
/* 165 */       getDAO_().getRestrictionCode() != null && !getDAO_().getRestrictionCode().equals(argRestrictionCode))) {
/* 166 */       getDAO_().setRestrictionCode(argRestrictionCode);
/* 167 */       ev_postable = true;
/* 168 */       if (this._properties != null) {
/*     */         
/* 170 */         Iterator<ItemRestrictionPropertyModel> it = this._properties.iterator();
/* 171 */         while (it.hasNext())
/*     */         {
/* 173 */           ((ItemRestrictionPropertyModel)it.next()).setRestrictionCode_noev(argRestrictionCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 178 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 186 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 194 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 195 */       this._events != null && 
/* 196 */       postEventsForChanges()) {
/* 197 */       this._events.post(IItemRestriction.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 204 */     boolean ev_postable = false;
/*     */     
/* 206 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 207 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 208 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 209 */       ev_postable = true;
/* 210 */       if (this._properties != null) {
/*     */         
/* 212 */         Iterator<ItemRestrictionPropertyModel> it = this._properties.iterator();
/* 213 */         while (it.hasNext())
/*     */         {
/* 215 */           ((ItemRestrictionPropertyModel)it.next()).setEffectiveDate_noev(argEffectiveDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 220 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSaleLineItemTypeCode() {
/* 228 */     return getDAO_().getSaleLineItemTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSaleLineItemTypeCode(String argSaleLineItemTypeCode) {
/* 236 */     if (setSaleLineItemTypeCode_noev(argSaleLineItemTypeCode) && 
/* 237 */       this._events != null && 
/* 238 */       postEventsForChanges()) {
/* 239 */       this._events.post(IItemRestriction.SET_SALELINEITEMTYPECODE, argSaleLineItemTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSaleLineItemTypeCode_noev(String argSaleLineItemTypeCode) {
/* 246 */     boolean ev_postable = false;
/*     */     
/* 248 */     if ((getDAO_().getSaleLineItemTypeCode() == null && argSaleLineItemTypeCode != null) || (
/* 249 */       getDAO_().getSaleLineItemTypeCode() != null && !getDAO_().getSaleLineItemTypeCode().equals(argSaleLineItemTypeCode))) {
/* 250 */       getDAO_().setSaleLineItemTypeCode(argSaleLineItemTypeCode);
/* 251 */       ev_postable = true;
/* 252 */       if (this._properties != null) {
/*     */         
/* 254 */         Iterator<ItemRestrictionPropertyModel> it = this._properties.iterator();
/* 255 */         while (it.hasNext())
/*     */         {
/* 257 */           ((ItemRestrictionPropertyModel)it.next()).setSaleLineItemTypeCode_noev(argSaleLineItemTypeCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 262 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyName() {
/* 270 */     return getDAO_().getPropertyName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyName(String argPropertyName) {
/* 278 */     if (setPropertyName_noev(argPropertyName) && 
/* 279 */       this._events != null && 
/* 280 */       postEventsForChanges()) {
/* 281 */       this._events.post(IItemRestriction.SET_PROPERTYNAME, argPropertyName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyName_noev(String argPropertyName) {
/* 288 */     boolean ev_postable = false;
/*     */     
/* 290 */     if ((getDAO_().getPropertyName() == null && argPropertyName != null) || (
/* 291 */       getDAO_().getPropertyName() != null && !getDAO_().getPropertyName().equals(argPropertyName))) {
/* 292 */       getDAO_().setPropertyName(argPropertyName);
/* 293 */       ev_postable = true;
/* 294 */       if (this._properties != null) {
/*     */         
/* 296 */         Iterator<ItemRestrictionPropertyModel> it = this._properties.iterator();
/* 297 */         while (it.hasNext())
/*     */         {
/* 299 */           ((ItemRestrictionPropertyModel)it.next()).setPropertyName_noev(argPropertyName);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 304 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 312 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 320 */     if (setOrgCode_noev(argOrgCode) && 
/* 321 */       this._events != null && 
/* 322 */       postEventsForChanges()) {
/* 323 */       this._events.post(IItemRestriction.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 330 */     boolean ev_postable = false;
/*     */     
/* 332 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 333 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 334 */       getDAO_().setOrgCode(argOrgCode);
/* 335 */       ev_postable = true;
/*     */     } 
/*     */     
/* 338 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 346 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 354 */     if (setOrgValue_noev(argOrgValue) && 
/* 355 */       this._events != null && 
/* 356 */       postEventsForChanges()) {
/* 357 */       this._events.post(IItemRestriction.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 364 */     boolean ev_postable = false;
/*     */     
/* 366 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 367 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 368 */       getDAO_().setOrgValue(argOrgValue);
/* 369 */       ev_postable = true;
/*     */     } 
/*     */     
/* 372 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 380 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 388 */     if (setCreateDate_noev(argCreateDate) && 
/* 389 */       this._events != null && 
/* 390 */       postEventsForChanges()) {
/* 391 */       this._events.post(IItemRestriction.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 398 */     boolean ev_postable = false;
/*     */     
/* 400 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 401 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 402 */       getDAO_().setCreateDate(argCreateDate);
/* 403 */       ev_postable = true;
/*     */     } 
/*     */     
/* 406 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 414 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 422 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 423 */       this._events != null && 
/* 424 */       postEventsForChanges()) {
/* 425 */       this._events.post(IItemRestriction.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 432 */     boolean ev_postable = false;
/*     */     
/* 434 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 435 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 436 */       getDAO_().setCreateUserId(argCreateUserId);
/* 437 */       ev_postable = true;
/*     */     } 
/*     */     
/* 440 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 448 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 456 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 457 */       this._events != null && 
/* 458 */       postEventsForChanges()) {
/* 459 */       this._events.post(IItemRestriction.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 466 */     boolean ev_postable = false;
/*     */     
/* 468 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 469 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 470 */       getDAO_().setUpdateDate(argUpdateDate);
/* 471 */       ev_postable = true;
/*     */     } 
/*     */     
/* 474 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 482 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 490 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 491 */       this._events != null && 
/* 492 */       postEventsForChanges()) {
/* 493 */       this._events.post(IItemRestriction.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 500 */     boolean ev_postable = false;
/*     */     
/* 502 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 503 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 504 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 505 */       ev_postable = true;
/*     */     } 
/*     */     
/* 508 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 516 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 524 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 525 */       this._events != null && 
/* 526 */       postEventsForChanges()) {
/* 527 */       this._events.post(IItemRestriction.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 534 */     boolean ev_postable = false;
/*     */     
/* 536 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 537 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 538 */       getDAO_().setExpirationDate(argExpirationDate);
/* 539 */       ev_postable = true;
/*     */     } 
/*     */     
/* 542 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBooleanValue() {
/* 550 */     if (getDAO_().getBooleanValue() != null) {
/* 551 */       return getDAO_().getBooleanValue().booleanValue();
/*     */     }
/*     */     
/* 554 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBooleanValue(boolean argBooleanValue) {
/* 563 */     if (setBooleanValue_noev(argBooleanValue) && 
/* 564 */       this._events != null && 
/* 565 */       postEventsForChanges()) {
/* 566 */       this._events.post(IItemRestriction.SET_BOOLEANVALUE, Boolean.valueOf(argBooleanValue));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBooleanValue_noev(boolean argBooleanValue) {
/* 573 */     boolean ev_postable = false;
/*     */     
/* 575 */     if ((getDAO_().getBooleanValue() == null && Boolean.valueOf(argBooleanValue) != null) || (
/* 576 */       getDAO_().getBooleanValue() != null && !getDAO_().getBooleanValue().equals(Boolean.valueOf(argBooleanValue)))) {
/* 577 */       getDAO_().setBooleanValue(Boolean.valueOf(argBooleanValue));
/* 578 */       ev_postable = true;
/*     */     } 
/*     */     
/* 581 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 589 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 597 */     if (setStringValue_noev(argStringValue) && 
/* 598 */       this._events != null && 
/* 599 */       postEventsForChanges()) {
/* 600 */       this._events.post(IItemRestriction.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 607 */     boolean ev_postable = false;
/*     */     
/* 609 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 610 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 611 */       getDAO_().setStringValue(argStringValue);
/* 612 */       ev_postable = true;
/*     */     } 
/*     */     
/* 615 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDateValue() {
/* 623 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 631 */     if (setDateValue_noev(argDateValue) && 
/* 632 */       this._events != null && 
/* 633 */       postEventsForChanges()) {
/* 634 */       this._events.post(IItemRestriction.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 641 */     boolean ev_postable = false;
/*     */     
/* 643 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 644 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 645 */       getDAO_().setDateValue(argDateValue);
/* 646 */       ev_postable = true;
/*     */     } 
/*     */     
/* 649 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 657 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 665 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 666 */       this._events != null && 
/* 667 */       postEventsForChanges()) {
/* 668 */       this._events.post(IItemRestriction.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 675 */     boolean ev_postable = false;
/*     */     
/* 677 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 678 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 679 */       getDAO_().setDecimalValue(argDecimalValue);
/* 680 */       ev_postable = true;
/*     */     } 
/*     */     
/* 683 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getOnCalendar() {
/* 691 */     if (getDAO_().getOnCalendar() != null) {
/* 692 */       return getDAO_().getOnCalendar().booleanValue();
/*     */     }
/*     */     
/* 695 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOnCalendar(boolean argOnCalendar) {
/* 704 */     if (setOnCalendar_noev(argOnCalendar) && 
/* 705 */       this._events != null && 
/* 706 */       postEventsForChanges()) {
/* 707 */       this._events.post(IItemRestriction.SET_ONCALENDAR, Boolean.valueOf(argOnCalendar));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOnCalendar_noev(boolean argOnCalendar) {
/* 714 */     boolean ev_postable = false;
/*     */     
/* 716 */     if ((getDAO_().getOnCalendar() == null && Boolean.valueOf(argOnCalendar) != null) || (
/* 717 */       getDAO_().getOnCalendar() != null && !getDAO_().getOnCalendar().equals(Boolean.valueOf(argOnCalendar)))) {
/* 718 */       getDAO_().setOnCalendar(Boolean.valueOf(argOnCalendar));
/* 719 */       ev_postable = true;
/*     */     } 
/*     */     
/* 722 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemRestrictionProperty newProperty(String argPropertyName) {
/* 726 */     ItemRestrictionPropertyId id = new ItemRestrictionPropertyId();
/*     */     
/* 728 */     id.setRestrictionCategory(getRestrictionCategory());
/* 729 */     id.setRestrictionCode(getRestrictionCode());
/* 730 */     id.setEffectiveDate(getEffectiveDate());
/* 731 */     id.setSaleLineItemTypeCode(getSaleLineItemTypeCode());
/* 732 */     id.setPropertyName(getPropertyName());
/* 733 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 735 */     IItemRestrictionProperty prop = (IItemRestrictionProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemRestrictionProperty.class);
/* 736 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemRestrictionProperty> getProperties() {
/* 745 */     if (this._properties == null) {
/* 746 */       this._properties = new HistoricalList(null);
/*     */     }
/* 748 */     return (List<IItemRestrictionProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemRestrictionProperty> argProperties) {
/* 752 */     if (this._properties == null) {
/* 753 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 755 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 758 */     for (IItemRestrictionProperty child : this._properties) {
/* 759 */       ItemRestrictionPropertyModel model = (ItemRestrictionPropertyModel)child;
/* 760 */       model.setOrganizationId_noev(getOrganizationId());
/* 761 */       model.setRestrictionCategory_noev(getRestrictionCategory());
/* 762 */       model.setRestrictionCode_noev(getRestrictionCode());
/* 763 */       model.setEffectiveDate_noev(getEffectiveDate());
/* 764 */       model.setSaleLineItemTypeCode_noev(getSaleLineItemTypeCode());
/* 765 */       model.setPropertyName_noev(getPropertyName());
/* 766 */       if (child instanceof IDataModelImpl) {
/* 767 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 768 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 769 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 770 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 773 */       if (postEventsForChanges()) {
/* 774 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemRestrictionProperty(IItemRestrictionProperty argItemRestrictionProperty) {
/* 780 */     if (this._properties == null) {
/* 781 */       this._properties = new HistoricalList(null);
/*     */     }
/* 783 */     argItemRestrictionProperty.setOrganizationId(getOrganizationId());
/* 784 */     argItemRestrictionProperty.setRestrictionCategory(getRestrictionCategory());
/* 785 */     argItemRestrictionProperty.setRestrictionCode(getRestrictionCode());
/* 786 */     argItemRestrictionProperty.setEffectiveDate(getEffectiveDate());
/* 787 */     argItemRestrictionProperty.setSaleLineItemTypeCode(getSaleLineItemTypeCode());
/* 788 */     argItemRestrictionProperty.setPropertyName(getPropertyName());
/* 789 */     if (argItemRestrictionProperty instanceof IDataModelImpl) {
/* 790 */       IDataAccessObject childDao = ((IDataModelImpl)argItemRestrictionProperty).getDAO();
/* 791 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 792 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 793 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 798 */     if (postEventsForChanges()) {
/* 799 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemRestrictionProperty));
/*     */     }
/*     */     
/* 802 */     this._properties.add(argItemRestrictionProperty);
/* 803 */     if (postEventsForChanges()) {
/* 804 */       this._events.post(IItemRestriction.ADD_PROPERTIES, argItemRestrictionProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemRestrictionProperty(IItemRestrictionProperty argItemRestrictionProperty) {
/* 809 */     if (this._properties != null) {
/*     */       
/* 811 */       if (postEventsForChanges()) {
/* 812 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemRestrictionProperty));
/*     */       }
/* 814 */       this._properties.remove(argItemRestrictionProperty);
/* 815 */       if (postEventsForChanges()) {
/* 816 */         this._events.post(IItemRestriction.REMOVE_PROPERTIES, argItemRestrictionProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 823 */     if ("Properties".equals(argFieldId)) {
/* 824 */       return getProperties();
/*     */     }
/* 826 */     if ("ItemRestrictionExtension".equals(argFieldId)) {
/* 827 */       return this._myExtension;
/*     */     }
/*     */     
/* 830 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 836 */     if ("Properties".equals(argFieldId)) {
/* 837 */       setProperties(changeToList(argValue, IItemRestrictionProperty.class));
/*     */     }
/* 839 */     else if ("ItemRestrictionExtension".equals(argFieldId)) {
/* 840 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 843 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 849 */     this._persistenceDefaults = argPD;
/* 850 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 851 */     this._eventManager = argEM;
/* 852 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 853 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 854 */     if (this._properties != null) {
/* 855 */       for (IItemRestrictionProperty relationship : this._properties) {
/* 856 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemRestrictionExt() {
/* 862 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemRestrictionExt(IDataModel argExt) {
/* 866 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 871 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 875 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 878 */     super.startTransaction();
/*     */     
/* 880 */     this._propertiesSavepoint = this._properties;
/* 881 */     if (this._properties != null) {
/* 882 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 883 */       Iterator<IDataModel> it = this._properties.iterator();
/* 884 */       while (it.hasNext()) {
/* 885 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 890 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 895 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 898 */     super.rollbackChanges();
/*     */     
/* 900 */     this._properties = this._propertiesSavepoint;
/* 901 */     this._propertiesSavepoint = null;
/* 902 */     if (this._properties != null) {
/* 903 */       Iterator<IDataModel> it = this._properties.iterator();
/* 904 */       while (it.hasNext()) {
/* 905 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 913 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 916 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 919 */     super.commitTransaction();
/*     */     
/* 921 */     this._propertiesSavepoint = this._properties;
/* 922 */     if (this._properties != null) {
/* 923 */       Iterator<IDataModel> it = this._properties.iterator();
/* 924 */       while (it.hasNext()) {
/* 925 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 927 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 931 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */