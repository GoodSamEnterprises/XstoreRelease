/*     */ package dtv.xst.dao.itm.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.itm.IItemPrices;
/*     */ import dtv.xst.dao.itm.IItemPricesProperty;
/*     */ import dtv.xst.dao.itm.ItemPricesPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemPricesModel extends AbstractDataModelWithPropertyImpl<IItemPricesProperty> implements IItemPrices {
/*     */   private static final long serialVersionUID = -389226147L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IItemPricesProperty> _properties; private transient HistoricalList<IItemPricesProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ItemPricesDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemPricesDAO getDAO_() {
/*  46 */     return (ItemPricesDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  54 */     if (getDAO_().getOrganizationId() != null) {
/*  55 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  58 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  67 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  68 */       this._events != null && 
/*  69 */       postEventsForChanges()) {
/*  70 */       this._events.post(IItemPrices.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  77 */     boolean ev_postable = false;
/*     */     
/*  79 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  80 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  81 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  82 */       ev_postable = true;
/*  83 */       if (this._properties != null) {
/*     */         
/*  85 */         Iterator<ItemPricesPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ItemPricesPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/* 101 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 109 */     if (setItemId_noev(argItemId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IItemPrices.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 122 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 123 */       getDAO_().setItemId(argItemId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<ItemPricesPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((ItemPricesPropertyModel)it.next()).setItemId_noev(argItemId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 135 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLevelCode() {
/* 143 */     return getDAO_().getLevelCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/* 151 */     if (setLevelCode_noev(argLevelCode) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IItemPrices.SET_LEVELCODE, argLevelCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLevelCode_noev(String argLevelCode) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getLevelCode() == null && argLevelCode != null) || (
/* 164 */       getDAO_().getLevelCode() != null && !getDAO_().getLevelCode().equals(argLevelCode))) {
/* 165 */       getDAO_().setLevelCode(argLevelCode);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<ItemPricesPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((ItemPricesPropertyModel)it.next()).setLevelCode_noev(argLevelCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLevelValue() {
/* 185 */     return getDAO_().getLevelValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/* 193 */     if (setLevelValue_noev(argLevelValue) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IItemPrices.SET_LEVELVALUE, argLevelValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLevelValue_noev(String argLevelValue) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getLevelValue() == null && argLevelValue != null) || (
/* 206 */       getDAO_().getLevelValue() != null && !getDAO_().getLevelValue().equals(argLevelValue))) {
/* 207 */       getDAO_().setLevelValue(argLevelValue);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<ItemPricesPropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((ItemPricesPropertyModel)it.next()).setLevelValue_noev(argLevelValue);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 219 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemPricePropertyCode() {
/* 227 */     return getDAO_().getItemPricePropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemPricePropertyCode(String argItemPricePropertyCode) {
/* 235 */     if (setItemPricePropertyCode_noev(argItemPricePropertyCode) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(IItemPrices.SET_ITEMPRICEPROPERTYCODE, argItemPricePropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemPricePropertyCode_noev(String argItemPricePropertyCode) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getItemPricePropertyCode() == null && argItemPricePropertyCode != null) || (
/* 248 */       getDAO_().getItemPricePropertyCode() != null && !getDAO_().getItemPricePropertyCode().equals(argItemPricePropertyCode))) {
/* 249 */       getDAO_().setItemPricePropertyCode(argItemPricePropertyCode);
/* 250 */       ev_postable = true;
/* 251 */       if (this._properties != null) {
/*     */         
/* 253 */         Iterator<ItemPricesPropertyModel> it = this._properties.iterator();
/* 254 */         while (it.hasNext())
/*     */         {
/* 256 */           ((ItemPricesPropertyModel)it.next()).setItemPricePropertyCode_noev(argItemPricePropertyCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 261 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 269 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 277 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 278 */       this._events != null && 
/* 279 */       postEventsForChanges()) {
/* 280 */       this._events.post(IItemPrices.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 287 */     boolean ev_postable = false;
/*     */     
/* 289 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 290 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 291 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 292 */       ev_postable = true;
/* 293 */       if (this._properties != null) {
/*     */         
/* 295 */         Iterator<ItemPricesPropertyModel> it = this._properties.iterator();
/* 296 */         while (it.hasNext())
/*     */         {
/* 298 */           ((ItemPricesPropertyModel)it.next()).setEffectiveDate_noev(argEffectiveDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 303 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getPricingQuantity() {
/* 311 */     return getDAO_().getPricingQuantity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPricingQuantity(BigDecimal argPricingQuantity) {
/* 319 */     if (setPricingQuantity_noev(argPricingQuantity) && 
/* 320 */       this._events != null && 
/* 321 */       postEventsForChanges()) {
/* 322 */       this._events.post(IItemPrices.SET_PRICINGQUANTITY, argPricingQuantity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPricingQuantity_noev(BigDecimal argPricingQuantity) {
/* 329 */     boolean ev_postable = false;
/*     */     
/* 331 */     if ((getDAO_().getPricingQuantity() == null && argPricingQuantity != null) || (
/* 332 */       getDAO_().getPricingQuantity() != null && !getDAO_().getPricingQuantity().equals(argPricingQuantity))) {
/* 333 */       getDAO_().setPricingQuantity(argPricingQuantity);
/* 334 */       ev_postable = true;
/* 335 */       if (this._properties != null) {
/*     */         
/* 337 */         Iterator<ItemPricesPropertyModel> it = this._properties.iterator();
/* 338 */         while (it.hasNext())
/*     */         {
/* 340 */           ((ItemPricesPropertyModel)it.next()).setPricingQuantity_noev(argPricingQuantity);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 345 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 353 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 361 */     if (setCreateDate_noev(argCreateDate) && 
/* 362 */       this._events != null && 
/* 363 */       postEventsForChanges()) {
/* 364 */       this._events.post(IItemPrices.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 371 */     boolean ev_postable = false;
/*     */     
/* 373 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 374 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 375 */       getDAO_().setCreateDate(argCreateDate);
/* 376 */       ev_postable = true;
/*     */     } 
/*     */     
/* 379 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 387 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 395 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 396 */       this._events != null && 
/* 397 */       postEventsForChanges()) {
/* 398 */       this._events.post(IItemPrices.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 405 */     boolean ev_postable = false;
/*     */     
/* 407 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 408 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 409 */       getDAO_().setCreateUserId(argCreateUserId);
/* 410 */       ev_postable = true;
/*     */     } 
/*     */     
/* 413 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 421 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 429 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 430 */       this._events != null && 
/* 431 */       postEventsForChanges()) {
/* 432 */       this._events.post(IItemPrices.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 439 */     boolean ev_postable = false;
/*     */     
/* 441 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 442 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 443 */       getDAO_().setUpdateDate(argUpdateDate);
/* 444 */       ev_postable = true;
/*     */     } 
/*     */     
/* 447 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 455 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 463 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 464 */       this._events != null && 
/* 465 */       postEventsForChanges()) {
/* 466 */       this._events.post(IItemPrices.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 473 */     boolean ev_postable = false;
/*     */     
/* 475 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 476 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 477 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 478 */       ev_postable = true;
/*     */     } 
/*     */     
/* 481 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 489 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 497 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 498 */       this._events != null && 
/* 499 */       postEventsForChanges()) {
/* 500 */       this._events.post(IItemPrices.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 507 */     boolean ev_postable = false;
/*     */     
/* 509 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 510 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 511 */       getDAO_().setExpirationDate(argExpirationDate);
/* 512 */       ev_postable = true;
/*     */     } 
/*     */     
/* 515 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getPrice() {
/* 523 */     return getDAO_().getPrice();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrice(BigDecimal argPrice) {
/* 531 */     if (setPrice_noev(argPrice) && 
/* 532 */       this._events != null && 
/* 533 */       postEventsForChanges()) {
/* 534 */       this._events.post(IItemPrices.SET_PRICE, argPrice);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPrice_noev(BigDecimal argPrice) {
/* 541 */     boolean ev_postable = false;
/*     */     
/* 543 */     if ((getDAO_().getPrice() == null && argPrice != null) || (
/* 544 */       getDAO_().getPrice() != null && !getDAO_().getPrice().equals(argPrice))) {
/* 545 */       getDAO_().setPrice(argPrice);
/* 546 */       ev_postable = true;
/*     */     } 
/*     */     
/* 549 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExternalId() {
/* 557 */     return getDAO_().getExternalId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExternalId(String argExternalId) {
/* 565 */     if (setExternalId_noev(argExternalId) && 
/* 566 */       this._events != null && 
/* 567 */       postEventsForChanges()) {
/* 568 */       this._events.post(IItemPrices.SET_EXTERNALID, argExternalId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExternalId_noev(String argExternalId) {
/* 575 */     boolean ev_postable = false;
/*     */     
/* 577 */     if ((getDAO_().getExternalId() == null && argExternalId != null) || (
/* 578 */       getDAO_().getExternalId() != null && !getDAO_().getExternalId().equals(argExternalId))) {
/* 579 */       getDAO_().setExternalId(argExternalId);
/* 580 */       ev_postable = true;
/*     */     } 
/*     */     
/* 583 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExternalSystem() {
/* 591 */     return getDAO_().getExternalSystem();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExternalSystem(String argExternalSystem) {
/* 599 */     if (setExternalSystem_noev(argExternalSystem) && 
/* 600 */       this._events != null && 
/* 601 */       postEventsForChanges()) {
/* 602 */       this._events.post(IItemPrices.SET_EXTERNALSYSTEM, argExternalSystem);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExternalSystem_noev(String argExternalSystem) {
/* 609 */     boolean ev_postable = false;
/*     */     
/* 611 */     if ((getDAO_().getExternalSystem() == null && argExternalSystem != null) || (
/* 612 */       getDAO_().getExternalSystem() != null && !getDAO_().getExternalSystem().equals(argExternalSystem))) {
/* 613 */       getDAO_().setExternalSystem(argExternalSystem);
/* 614 */       ev_postable = true;
/*     */     } 
/*     */     
/* 617 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemPricesProperty newProperty(String argPropertyName) {
/* 621 */     ItemPricesPropertyId id = new ItemPricesPropertyId();
/*     */     
/* 623 */     id.setItemId(getItemId());
/* 624 */     id.setLevelCode(getLevelCode());
/* 625 */     id.setLevelValue(getLevelValue());
/* 626 */     id.setItemPricePropertyCode(getItemPricePropertyCode());
/* 627 */     id.setEffectiveDate(getEffectiveDate());
/* 628 */     id.setPricingQuantity(getPricingQuantity());
/* 629 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 631 */     IItemPricesProperty prop = (IItemPricesProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemPricesProperty.class);
/* 632 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemPricesProperty> getProperties() {
/* 641 */     if (this._properties == null) {
/* 642 */       this._properties = new HistoricalList(null);
/*     */     }
/* 644 */     return (List<IItemPricesProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemPricesProperty> argProperties) {
/* 648 */     if (this._properties == null) {
/* 649 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 651 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 654 */     for (IItemPricesProperty child : this._properties) {
/* 655 */       ItemPricesPropertyModel model = (ItemPricesPropertyModel)child;
/* 656 */       model.setOrganizationId_noev(getOrganizationId());
/* 657 */       model.setItemId_noev(getItemId());
/* 658 */       model.setLevelCode_noev(getLevelCode());
/* 659 */       model.setLevelValue_noev(getLevelValue());
/* 660 */       model.setItemPricePropertyCode_noev(getItemPricePropertyCode());
/* 661 */       model.setEffectiveDate_noev(getEffectiveDate());
/* 662 */       model.setPricingQuantity_noev(getPricingQuantity());
/* 663 */       if (child instanceof IDataModelImpl) {
/* 664 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 665 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 666 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 667 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 670 */       if (postEventsForChanges()) {
/* 671 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemPricesProperty(IItemPricesProperty argItemPricesProperty) {
/* 677 */     if (this._properties == null) {
/* 678 */       this._properties = new HistoricalList(null);
/*     */     }
/* 680 */     argItemPricesProperty.setOrganizationId(getOrganizationId());
/* 681 */     argItemPricesProperty.setItemId(getItemId());
/* 682 */     argItemPricesProperty.setLevelCode(getLevelCode());
/* 683 */     argItemPricesProperty.setLevelValue(getLevelValue());
/* 684 */     argItemPricesProperty.setItemPricePropertyCode(getItemPricePropertyCode());
/* 685 */     argItemPricesProperty.setEffectiveDate(getEffectiveDate());
/* 686 */     argItemPricesProperty.setPricingQuantity(getPricingQuantity());
/* 687 */     if (argItemPricesProperty instanceof IDataModelImpl) {
/* 688 */       IDataAccessObject childDao = ((IDataModelImpl)argItemPricesProperty).getDAO();
/* 689 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 690 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 691 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 696 */     if (postEventsForChanges()) {
/* 697 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemPricesProperty));
/*     */     }
/*     */     
/* 700 */     this._properties.add(argItemPricesProperty);
/* 701 */     if (postEventsForChanges()) {
/* 702 */       this._events.post(IItemPrices.ADD_PROPERTIES, argItemPricesProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemPricesProperty(IItemPricesProperty argItemPricesProperty) {
/* 707 */     if (this._properties != null) {
/*     */       
/* 709 */       if (postEventsForChanges()) {
/* 710 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemPricesProperty));
/*     */       }
/* 712 */       this._properties.remove(argItemPricesProperty);
/* 713 */       if (postEventsForChanges()) {
/* 714 */         this._events.post(IItemPrices.REMOVE_PROPERTIES, argItemPricesProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 721 */     if ("Properties".equals(argFieldId)) {
/* 722 */       return getProperties();
/*     */     }
/* 724 */     if ("ItemPricesExtension".equals(argFieldId)) {
/* 725 */       return this._myExtension;
/*     */     }
/*     */     
/* 728 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 734 */     if ("Properties".equals(argFieldId)) {
/* 735 */       setProperties(changeToList(argValue, IItemPricesProperty.class));
/*     */     }
/* 737 */     else if ("ItemPricesExtension".equals(argFieldId)) {
/* 738 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 741 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 747 */     this._persistenceDefaults = argPD;
/* 748 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 749 */     this._eventManager = argEM;
/* 750 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 751 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 752 */     if (this._properties != null) {
/* 753 */       for (IItemPricesProperty relationship : this._properties) {
/* 754 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemPricesExt() {
/* 760 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemPricesExt(IDataModel argExt) {
/* 764 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 769 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 773 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 776 */     super.startTransaction();
/*     */     
/* 778 */     this._propertiesSavepoint = this._properties;
/* 779 */     if (this._properties != null) {
/* 780 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 781 */       Iterator<IDataModel> it = this._properties.iterator();
/* 782 */       while (it.hasNext()) {
/* 783 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 788 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 793 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 796 */     super.rollbackChanges();
/*     */     
/* 798 */     this._properties = this._propertiesSavepoint;
/* 799 */     this._propertiesSavepoint = null;
/* 800 */     if (this._properties != null) {
/* 801 */       Iterator<IDataModel> it = this._properties.iterator();
/* 802 */       while (it.hasNext()) {
/* 803 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 811 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 814 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 817 */     super.commitTransaction();
/*     */     
/* 819 */     this._propertiesSavepoint = this._properties;
/* 820 */     if (this._properties != null) {
/* 821 */       Iterator<IDataModel> it = this._properties.iterator();
/* 822 */       while (it.hasNext()) {
/* 823 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 825 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 829 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 834 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemPricesModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */