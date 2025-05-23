/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.itm.IWarrantyItem;
/*     */ import dtv.xst.dao.itm.IWarrantyItemPrice;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class WarrantyItemModel
/*     */   extends NonPhysicalItemModel
/*     */   implements IWarrantyItem
/*     */ {
/*     */   private static final long serialVersionUID = -1154324913L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public void initDAO() {
/*  32 */     setDAO((IDataAccessObject)new WarrantyItemDAO());
/*     */   }
/*     */   private IDataModel _myExtension;
/*     */   private HistoricalList<IWarrantyItemPrice> _warrantyItemPrices;
/*     */   private transient HistoricalList<IWarrantyItemPrice> _warrantyItemPricesSavepoint;
/*     */   transient BigDecimal _computedPrice;
/*     */   
/*     */   private WarrantyItemDAO getDAO_() {
/*  40 */     return (WarrantyItemDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  48 */     if (getDAO_().getOrganizationId() != null) {
/*  49 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  52 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  61 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  62 */       this._events != null && 
/*  63 */       postEventsForChanges()) {
/*  64 */       this._events.post(IWarrantyItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  71 */     boolean ev_postable = false;
/*     */ 
/*     */     
/*  74 */     if (super.setOrganizationId_noev(argOrganizationId) && 
/*  75 */       this._warrantyItemPrices != null) {
/*     */       
/*  77 */       Iterator<WarrantyItemPriceModel> it = this._warrantyItemPrices.iterator();
/*  78 */       while (it.hasNext())
/*     */       {
/*  80 */         ((WarrantyItemPriceModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  85 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/*  93 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 101 */     if (setItemId_noev(argItemId) && 
/* 102 */       this._events != null && 
/* 103 */       postEventsForChanges()) {
/* 104 */       this._events.post(IWarrantyItem.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 111 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 114 */     if (super.setItemId_noev(argItemId) && 
/* 115 */       this._warrantyItemPrices != null) {
/*     */       
/* 117 */       Iterator<WarrantyItemPriceModel> it = this._warrantyItemPrices.iterator();
/* 118 */       while (it.hasNext())
/*     */       {
/* 120 */         ((WarrantyItemPriceModel)it.next()).setItemId_noev(argItemId);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 125 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 133 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 141 */     if (setCreateDate_noev(argCreateDate) && 
/* 142 */       this._events != null && 
/* 143 */       postEventsForChanges()) {
/* 144 */       this._events.post(IWarrantyItem.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 151 */     boolean ev_postable = false;
/*     */     
/* 153 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 154 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 155 */       getDAO_().setCreateDate(argCreateDate);
/* 156 */       ev_postable = true;
/*     */     } 
/*     */     
/* 159 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 167 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 175 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 176 */       this._events != null && 
/* 177 */       postEventsForChanges()) {
/* 178 */       this._events.post(IWarrantyItem.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 185 */     boolean ev_postable = false;
/*     */     
/* 187 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 188 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 189 */       getDAO_().setCreateUserId(argCreateUserId);
/* 190 */       ev_postable = true;
/*     */     } 
/*     */     
/* 193 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 201 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 209 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 210 */       this._events != null && 
/* 211 */       postEventsForChanges()) {
/* 212 */       this._events.post(IWarrantyItem.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 219 */     boolean ev_postable = false;
/*     */     
/* 221 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 222 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 223 */       getDAO_().setUpdateDate(argUpdateDate);
/* 224 */       ev_postable = true;
/*     */     } 
/*     */     
/* 227 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 235 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 243 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 244 */       this._events != null && 
/* 245 */       postEventsForChanges()) {
/* 246 */       this._events.post(IWarrantyItem.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 253 */     boolean ev_postable = false;
/*     */     
/* 255 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 256 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 257 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 258 */       ev_postable = true;
/*     */     } 
/*     */     
/* 261 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPricingMethodCode() {
/* 269 */     return getDAO_().getPricingMethodCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPricingMethodCode(String argPricingMethodCode) {
/* 277 */     if (setPricingMethodCode_noev(argPricingMethodCode) && 
/* 278 */       this._events != null && 
/* 279 */       postEventsForChanges()) {
/* 280 */       this._events.post(IWarrantyItem.SET_PRICINGMETHODCODE, argPricingMethodCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPricingMethodCode_noev(String argPricingMethodCode) {
/* 287 */     boolean ev_postable = false;
/*     */     
/* 289 */     if ((getDAO_().getPricingMethodCode() == null && argPricingMethodCode != null) || (
/* 290 */       getDAO_().getPricingMethodCode() != null && !getDAO_().getPricingMethodCode().equals(argPricingMethodCode))) {
/* 291 */       getDAO_().setPricingMethodCode(argPricingMethodCode);
/* 292 */       ev_postable = true;
/*     */     } 
/*     */     
/* 295 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getWarrantyPriceAmt() {
/* 303 */     return getDAO_().getWarrantyPriceAmt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyPriceAmt(BigDecimal argWarrantyPriceAmt) {
/* 311 */     if (setWarrantyPriceAmt_noev(argWarrantyPriceAmt) && 
/* 312 */       this._events != null && 
/* 313 */       postEventsForChanges()) {
/* 314 */       this._events.post(IWarrantyItem.SET_WARRANTYPRICEAMT, argWarrantyPriceAmt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWarrantyPriceAmt_noev(BigDecimal argWarrantyPriceAmt) {
/* 321 */     boolean ev_postable = false;
/*     */     
/* 323 */     if ((getDAO_().getWarrantyPriceAmt() == null && argWarrantyPriceAmt != null) || (
/* 324 */       getDAO_().getWarrantyPriceAmt() != null && !getDAO_().getWarrantyPriceAmt().equals(argWarrantyPriceAmt))) {
/* 325 */       getDAO_().setWarrantyPriceAmt(argWarrantyPriceAmt);
/* 326 */       ev_postable = true;
/*     */     } 
/*     */     
/* 329 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getWarrantyPricePercentage() {
/* 337 */     return getDAO_().getWarrantyPricePercentage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyPricePercentage(BigDecimal argWarrantyPricePercentage) {
/* 345 */     if (setWarrantyPricePercentage_noev(argWarrantyPricePercentage) && 
/* 346 */       this._events != null && 
/* 347 */       postEventsForChanges()) {
/* 348 */       this._events.post(IWarrantyItem.SET_WARRANTYPRICEPERCENTAGE, argWarrantyPricePercentage);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWarrantyPricePercentage_noev(BigDecimal argWarrantyPricePercentage) {
/* 355 */     boolean ev_postable = false;
/*     */     
/* 357 */     if ((getDAO_().getWarrantyPricePercentage() == null && argWarrantyPricePercentage != null) || (
/* 358 */       getDAO_().getWarrantyPricePercentage() != null && !getDAO_().getWarrantyPricePercentage().equals(argWarrantyPricePercentage))) {
/* 359 */       getDAO_().setWarrantyPricePercentage(argWarrantyPricePercentage);
/* 360 */       ev_postable = true;
/*     */     } 
/*     */     
/* 363 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getWarrantyMinPriceAmt() {
/* 371 */     return getDAO_().getWarrantyMinPriceAmt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyMinPriceAmt(BigDecimal argWarrantyMinPriceAmt) {
/* 379 */     if (setWarrantyMinPriceAmt_noev(argWarrantyMinPriceAmt) && 
/* 380 */       this._events != null && 
/* 381 */       postEventsForChanges()) {
/* 382 */       this._events.post(IWarrantyItem.SET_WARRANTYMINPRICEAMT, argWarrantyMinPriceAmt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWarrantyMinPriceAmt_noev(BigDecimal argWarrantyMinPriceAmt) {
/* 389 */     boolean ev_postable = false;
/*     */     
/* 391 */     if ((getDAO_().getWarrantyMinPriceAmt() == null && argWarrantyMinPriceAmt != null) || (
/* 392 */       getDAO_().getWarrantyMinPriceAmt() != null && !getDAO_().getWarrantyMinPriceAmt().equals(argWarrantyMinPriceAmt))) {
/* 393 */       getDAO_().setWarrantyMinPriceAmt(argWarrantyMinPriceAmt);
/* 394 */       ev_postable = true;
/*     */     } 
/*     */     
/* 397 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getExpirationDays() {
/* 405 */     if (getDAO_().getExpirationDays() != null) {
/* 406 */       return getDAO_().getExpirationDays().longValue();
/*     */     }
/*     */     
/* 409 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDays(long argExpirationDays) {
/* 418 */     if (setExpirationDays_noev(argExpirationDays) && 
/* 419 */       this._events != null && 
/* 420 */       postEventsForChanges()) {
/* 421 */       this._events.post(IWarrantyItem.SET_EXPIRATIONDAYS, Long.valueOf(argExpirationDays));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDays_noev(long argExpirationDays) {
/* 428 */     boolean ev_postable = false;
/*     */     
/* 430 */     if ((getDAO_().getExpirationDays() == null && Long.valueOf(argExpirationDays) != null) || (
/* 431 */       getDAO_().getExpirationDays() != null && !getDAO_().getExpirationDays().equals(Long.valueOf(argExpirationDays)))) {
/* 432 */       getDAO_().setExpirationDays(Long.valueOf(argExpirationDays));
/* 433 */       ev_postable = true;
/*     */     } 
/*     */     
/* 436 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getServiceDays() {
/* 444 */     if (getDAO_().getServiceDays() != null) {
/* 445 */       return getDAO_().getServiceDays().longValue();
/*     */     }
/*     */     
/* 448 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setServiceDays(long argServiceDays) {
/* 457 */     if (setServiceDays_noev(argServiceDays) && 
/* 458 */       this._events != null && 
/* 459 */       postEventsForChanges()) {
/* 460 */       this._events.post(IWarrantyItem.SET_SERVICEDAYS, Long.valueOf(argServiceDays));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setServiceDays_noev(long argServiceDays) {
/* 467 */     boolean ev_postable = false;
/*     */     
/* 469 */     if ((getDAO_().getServiceDays() == null && Long.valueOf(argServiceDays) != null) || (
/* 470 */       getDAO_().getServiceDays() != null && !getDAO_().getServiceDays().equals(Long.valueOf(argServiceDays)))) {
/* 471 */       getDAO_().setServiceDays(Long.valueOf(argServiceDays));
/* 472 */       ev_postable = true;
/*     */     } 
/*     */     
/* 475 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getRenewable() {
/* 483 */     if (getDAO_().getRenewable() != null) {
/* 484 */       return getDAO_().getRenewable().booleanValue();
/*     */     }
/*     */     
/* 487 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRenewable(boolean argRenewable) {
/* 496 */     if (setRenewable_noev(argRenewable) && 
/* 497 */       this._events != null && 
/* 498 */       postEventsForChanges()) {
/* 499 */       this._events.post(IWarrantyItem.SET_RENEWABLE, Boolean.valueOf(argRenewable));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRenewable_noev(boolean argRenewable) {
/* 506 */     boolean ev_postable = false;
/*     */     
/* 508 */     if ((getDAO_().getRenewable() == null && Boolean.valueOf(argRenewable) != null) || (
/* 509 */       getDAO_().getRenewable() != null && !getDAO_().getRenewable().equals(Boolean.valueOf(argRenewable)))) {
/* 510 */       getDAO_().setRenewable(Boolean.valueOf(argRenewable));
/* 511 */       ev_postable = true;
/*     */     } 
/*     */     
/* 514 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "WarrantyItemPrices")
/*     */   public List<IWarrantyItemPrice> getWarrantyItemPrices() {
/* 523 */     if (this._warrantyItemPrices == null) {
/* 524 */       this._warrantyItemPrices = new HistoricalList(null);
/*     */     }
/* 526 */     return (List<IWarrantyItemPrice>)this._warrantyItemPrices;
/*     */   }
/*     */   
/*     */   public void setWarrantyItemPrices(List<IWarrantyItemPrice> argWarrantyItemPrices) {
/* 530 */     if (this._warrantyItemPrices == null) {
/* 531 */       this._warrantyItemPrices = new HistoricalList(argWarrantyItemPrices);
/*     */     } else {
/* 533 */       this._warrantyItemPrices.setCurrentList(argWarrantyItemPrices);
/*     */     } 
/*     */     
/* 536 */     for (IWarrantyItemPrice child : this._warrantyItemPrices) {
/* 537 */       WarrantyItemPriceModel model = (WarrantyItemPriceModel)child;
/* 538 */       model.setItemId_noev(getItemId());
/* 539 */       model.setOrganizationId_noev(getOrganizationId());
/* 540 */       if (child instanceof IDataModelImpl) {
/* 541 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 542 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 543 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 544 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 547 */       if (postEventsForChanges()) {
/* 548 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addWarrantyItemPrice(IWarrantyItemPrice argWarrantyItemPrice) {
/* 554 */     if (this._warrantyItemPrices == null) {
/* 555 */       this._warrantyItemPrices = new HistoricalList(null);
/*     */     }
/* 557 */     argWarrantyItemPrice.setItemId(getItemId());
/* 558 */     argWarrantyItemPrice.setOrganizationId(getOrganizationId());
/* 559 */     if (argWarrantyItemPrice instanceof IDataModelImpl) {
/* 560 */       IDataAccessObject childDao = ((IDataModelImpl)argWarrantyItemPrice).getDAO();
/* 561 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 562 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 563 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 568 */     if (postEventsForChanges()) {
/* 569 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWarrantyItemPrice));
/*     */     }
/*     */     
/* 572 */     this._warrantyItemPrices.add(argWarrantyItemPrice);
/* 573 */     if (postEventsForChanges()) {
/* 574 */       this._events.post(IWarrantyItem.ADD_WARRANTYITEMPRICES, argWarrantyItemPrice);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeWarrantyItemPrice(IWarrantyItemPrice argWarrantyItemPrice) {
/* 579 */     if (this._warrantyItemPrices != null) {
/*     */       
/* 581 */       if (postEventsForChanges()) {
/* 582 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWarrantyItemPrice));
/*     */       }
/* 584 */       this._warrantyItemPrices.remove(argWarrantyItemPrice);
/* 585 */       if (postEventsForChanges()) {
/* 586 */         this._events.post(IWarrantyItem.REMOVE_WARRANTYITEMPRICES, argWarrantyItemPrice);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 593 */     if ("WarrantyItemPrices".equals(argFieldId)) {
/* 594 */       return getWarrantyItemPrices();
/*     */     }
/* 596 */     if ("WarrantyItemExtension".equals(argFieldId)) {
/* 597 */       return this._myExtension;
/*     */     }
/*     */     
/* 600 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 606 */     if ("WarrantyItemPrices".equals(argFieldId)) {
/* 607 */       setWarrantyItemPrices(changeToList(argValue, IWarrantyItemPrice.class));
/*     */     }
/* 609 */     else if ("WarrantyItemExtension".equals(argFieldId)) {
/* 610 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 613 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 619 */     super.setDependencies(argPD, argEM);
/* 620 */     if (this._warrantyItemPrices != null) {
/* 621 */       for (IWarrantyItemPrice relationship : this._warrantyItemPrices) {
/* 622 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getWarrantyItemExt() {
/* 628 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setWarrantyItemExt(IDataModel argExt) {
/* 632 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 637 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 641 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 644 */     super.startTransaction();
/*     */     
/* 646 */     this._warrantyItemPricesSavepoint = this._warrantyItemPrices;
/* 647 */     if (this._warrantyItemPrices != null) {
/* 648 */       this._warrantyItemPricesSavepoint = new HistoricalList((List)this._warrantyItemPrices);
/* 649 */       Iterator<IDataModel> it = this._warrantyItemPrices.iterator();
/* 650 */       while (it.hasNext()) {
/* 651 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 656 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 661 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 664 */     super.rollbackChanges();
/*     */     
/* 666 */     this._warrantyItemPrices = this._warrantyItemPricesSavepoint;
/* 667 */     this._warrantyItemPricesSavepoint = null;
/* 668 */     if (this._warrantyItemPrices != null) {
/* 669 */       Iterator<IDataModel> it = this._warrantyItemPrices.iterator();
/* 670 */       while (it.hasNext()) {
/* 671 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 679 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 682 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 685 */     super.commitTransaction();
/*     */     
/* 687 */     this._warrantyItemPricesSavepoint = this._warrantyItemPrices;
/* 688 */     if (this._warrantyItemPrices != null) {
/* 689 */       Iterator<IDataModel> it = this._warrantyItemPrices.iterator();
/* 690 */       while (it.hasNext()) {
/* 691 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 693 */       this._warrantyItemPrices = new HistoricalList((List)this._warrantyItemPrices);
/*     */     } 
/*     */ 
/*     */     
/* 697 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 702 */     argStream.defaultReadObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getComputedPriceAmt() {
/* 717 */     return this._computedPrice;
/*     */   }
/*     */   
/*     */   public void setComputedPriceAmt(BigDecimal computedPrice) {
/* 721 */     this._computedPrice = computedPrice;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */