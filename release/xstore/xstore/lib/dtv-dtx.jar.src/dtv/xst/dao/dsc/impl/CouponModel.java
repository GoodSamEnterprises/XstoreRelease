/*     */ package dtv.xst.dao.dsc.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.dsc.CouponPropertyId;
/*     */ import dtv.xst.dao.dsc.ICoupon;
/*     */ import dtv.xst.dao.dsc.ICouponProperty;
/*     */ import dtv.xst.dao.dsc.IDiscount;
/*     */ import dtv.xst.dao.tnd.ITender;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CouponModel extends AbstractDataModelWithPropertyImpl<ICouponProperty> implements ICoupon {
/*     */   private static final long serialVersionUID = 2024260678L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private IDiscount _couponDiscount;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient IDiscount _couponDiscountSavepoint; private ITender _tender; private transient ITender _tenderSavepoint; private HistoricalList<ICouponProperty> _properties; private transient HistoricalList<ICouponProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new CouponDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CouponDAO getDAO_() {
/*  48 */     return (CouponDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCouponSerialNumber() {
/*  56 */     return getDAO_().getCouponSerialNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCouponSerialNumber(String argCouponSerialNumber) {
/*  64 */     if (setCouponSerialNumber_noev(argCouponSerialNumber) && 
/*  65 */       this._events != null && 
/*  66 */       postEventsForChanges()) {
/*  67 */       this._events.post(ICoupon.SET_COUPONSERIALNUMBER, argCouponSerialNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCouponSerialNumber_noev(String argCouponSerialNumber) {
/*  74 */     boolean ev_postable = false;
/*     */     
/*  76 */     if ((getDAO_().getCouponSerialNumber() == null && argCouponSerialNumber != null) || (
/*  77 */       getDAO_().getCouponSerialNumber() != null && !getDAO_().getCouponSerialNumber().equals(argCouponSerialNumber))) {
/*  78 */       getDAO_().setCouponSerialNumber(argCouponSerialNumber);
/*  79 */       ev_postable = true;
/*  80 */       if (this._properties != null) {
/*     */         
/*  82 */         Iterator<CouponPropertyModel> it = this._properties.iterator();
/*  83 */         while (it.hasNext())
/*     */         {
/*  85 */           ((CouponPropertyModel)it.next()).setCouponSerialNumber_noev(argCouponSerialNumber);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  90 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  98 */     if (getDAO_().getOrganizationId() != null) {
/*  99 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 102 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 111 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(ICoupon.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 124 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 125 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<CouponPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((CouponPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 137 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 145 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 153 */     if (setOrgCode_noev(argOrgCode) && 
/* 154 */       this._events != null && 
/* 155 */       postEventsForChanges()) {
/* 156 */       this._events.post(ICoupon.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 163 */     boolean ev_postable = false;
/*     */     
/* 165 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 166 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 167 */       getDAO_().setOrgCode(argOrgCode);
/* 168 */       ev_postable = true;
/*     */     } 
/*     */     
/* 171 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 179 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 187 */     if (setOrgValue_noev(argOrgValue) && 
/* 188 */       this._events != null && 
/* 189 */       postEventsForChanges()) {
/* 190 */       this._events.post(ICoupon.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 197 */     boolean ev_postable = false;
/*     */     
/* 199 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 200 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 201 */       getDAO_().setOrgValue(argOrgValue);
/* 202 */       ev_postable = true;
/*     */     } 
/*     */     
/* 205 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 213 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 221 */     if (setCreateDate_noev(argCreateDate) && 
/* 222 */       this._events != null && 
/* 223 */       postEventsForChanges()) {
/* 224 */       this._events.post(ICoupon.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 231 */     boolean ev_postable = false;
/*     */     
/* 233 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 234 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 235 */       getDAO_().setCreateDate(argCreateDate);
/* 236 */       ev_postable = true;
/*     */     } 
/*     */     
/* 239 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 247 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 255 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 256 */       this._events != null && 
/* 257 */       postEventsForChanges()) {
/* 258 */       this._events.post(ICoupon.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 265 */     boolean ev_postable = false;
/*     */     
/* 267 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 268 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 269 */       getDAO_().setCreateUserId(argCreateUserId);
/* 270 */       ev_postable = true;
/*     */     } 
/*     */     
/* 273 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 281 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 289 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 290 */       this._events != null && 
/* 291 */       postEventsForChanges()) {
/* 292 */       this._events.post(ICoupon.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 299 */     boolean ev_postable = false;
/*     */     
/* 301 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 302 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 303 */       getDAO_().setUpdateDate(argUpdateDate);
/* 304 */       ev_postable = true;
/*     */     } 
/*     */     
/* 307 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 315 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 323 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 324 */       this._events != null && 
/* 325 */       postEventsForChanges()) {
/* 326 */       this._events.post(ICoupon.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 333 */     boolean ev_postable = false;
/*     */     
/* 335 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 336 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 337 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 338 */       ev_postable = true;
/*     */     } 
/*     */     
/* 341 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDiscountCode() {
/* 349 */     return getDAO_().getDiscountCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDiscountCode(String argDiscountCode) {
/* 357 */     if (setDiscountCode_noev(argDiscountCode) && 
/* 358 */       this._events != null && 
/* 359 */       postEventsForChanges()) {
/* 360 */       this._events.post(ICoupon.SET_DISCOUNTCODE, argDiscountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDiscountCode_noev(String argDiscountCode) {
/* 367 */     boolean ev_postable = false;
/*     */     
/* 369 */     if ((getDAO_().getDiscountCode() == null && argDiscountCode != null) || (
/* 370 */       getDAO_().getDiscountCode() != null && !getDAO_().getDiscountCode().equals(argDiscountCode))) {
/* 371 */       getDAO_().setDiscountCode(argDiscountCode);
/* 372 */       ev_postable = true;
/*     */     } 
/*     */     
/* 375 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCouponType() {
/* 383 */     return getDAO_().getCouponType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCouponType(String argCouponType) {
/* 391 */     if (setCouponType_noev(argCouponType) && 
/* 392 */       this._events != null && 
/* 393 */       postEventsForChanges()) {
/* 394 */       this._events.post(ICoupon.SET_COUPONTYPE, argCouponType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCouponType_noev(String argCouponType) {
/* 401 */     boolean ev_postable = false;
/*     */     
/* 403 */     if ((getDAO_().getCouponType() == null && argCouponType != null) || (
/* 404 */       getDAO_().getCouponType() != null && !getDAO_().getCouponType().equals(argCouponType))) {
/* 405 */       getDAO_().setCouponType(argCouponType);
/* 406 */       ev_postable = true;
/*     */     } 
/*     */     
/* 409 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTenderId() {
/* 417 */     return getDAO_().getTenderId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/* 425 */     if (setTenderId_noev(argTenderId) && 
/* 426 */       this._events != null && 
/* 427 */       postEventsForChanges()) {
/* 428 */       this._events.post(ICoupon.SET_TENDERID, argTenderId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTenderId_noev(String argTenderId) {
/* 435 */     boolean ev_postable = false;
/*     */     
/* 437 */     if ((getDAO_().getTenderId() == null && argTenderId != null) || (
/* 438 */       getDAO_().getTenderId() != null && !getDAO_().getTenderId().equals(argTenderId))) {
/* 439 */       getDAO_().setTenderId(argTenderId);
/* 440 */       ev_postable = true;
/*     */     } 
/*     */     
/* 443 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 451 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 459 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 460 */       this._events != null && 
/* 461 */       postEventsForChanges()) {
/* 462 */       this._events.post(ICoupon.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 469 */     boolean ev_postable = false;
/*     */     
/* 471 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 472 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 473 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 474 */       ev_postable = true;
/*     */     } 
/*     */     
/* 477 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 485 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 493 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 494 */       this._events != null && 
/* 495 */       postEventsForChanges()) {
/* 496 */       this._events.post(ICoupon.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 503 */     boolean ev_postable = false;
/*     */     
/* 505 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 506 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 507 */       getDAO_().setExpirationDate(argExpirationDate);
/* 508 */       ev_postable = true;
/*     */     } 
/*     */     
/* 511 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getSerialized() {
/* 519 */     if (getDAO_().getSerialized() != null) {
/* 520 */       return getDAO_().getSerialized().booleanValue();
/*     */     }
/*     */     
/* 523 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerialized(boolean argSerialized) {
/* 532 */     if (setSerialized_noev(argSerialized) && 
/* 533 */       this._events != null && 
/* 534 */       postEventsForChanges()) {
/* 535 */       this._events.post(ICoupon.SET_SERIALIZED, Boolean.valueOf(argSerialized));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSerialized_noev(boolean argSerialized) {
/* 542 */     boolean ev_postable = false;
/*     */     
/* 544 */     if ((getDAO_().getSerialized() == null && Boolean.valueOf(argSerialized) != null) || (
/* 545 */       getDAO_().getSerialized() != null && !getDAO_().getSerialized().equals(Boolean.valueOf(argSerialized)))) {
/* 546 */       getDAO_().setSerialized(Boolean.valueOf(argSerialized));
/* 547 */       ev_postable = true;
/*     */     } 
/*     */     
/* 550 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICouponProperty newProperty(String argPropertyName) {
/* 554 */     CouponPropertyId id = new CouponPropertyId();
/*     */     
/* 556 */     id.setCouponSerialNumber(getCouponSerialNumber());
/* 557 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 559 */     ICouponProperty prop = (ICouponProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICouponProperty.class);
/* 560 */     return prop;
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
/*     */   @Relationship(name = "CouponDiscount")
/*     */   public IDiscount getCouponDiscount() {
/* 575 */     return this._couponDiscount;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCouponDiscount(IDiscount argCouponDiscount) {
/* 580 */     if (argCouponDiscount == null) {
/*     */       
/* 582 */       getDAO_().setDiscountCode(null);
/* 583 */       if (this._couponDiscount != null)
/*     */       {
/* 585 */         if (postEventsForChanges()) {
/* 586 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._couponDiscount));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 591 */       getDAO_().setDiscountCode(argCouponDiscount.getDiscountCode());
/*     */       
/* 593 */       if (postEventsForChanges()) {
/* 594 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCouponDiscount));
/*     */       }
/*     */     } 
/*     */     
/* 598 */     this._couponDiscount = argCouponDiscount;
/* 599 */     if (postEventsForChanges()) {
/* 600 */       this._events.post(ICoupon.SET_COUPONDISCOUNT, argCouponDiscount);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Tender")
/*     */   public ITender getTender() {
/* 606 */     return this._tender;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTender(ITender argTender) {
/* 611 */     if (argTender == null) {
/*     */       
/* 613 */       getDAO_().setTenderId(null);
/* 614 */       if (this._tender != null)
/*     */       {
/* 616 */         if (postEventsForChanges()) {
/* 617 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._tender));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 622 */       getDAO_().setTenderId(argTender.getTenderId());
/*     */       
/* 624 */       if (postEventsForChanges()) {
/* 625 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTender));
/*     */       }
/*     */     } 
/*     */     
/* 629 */     this._tender = argTender;
/* 630 */     if (postEventsForChanges()) {
/* 631 */       this._events.post(ICoupon.SET_TENDER, argTender);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICouponProperty> getProperties() {
/* 637 */     if (this._properties == null) {
/* 638 */       this._properties = new HistoricalList(null);
/*     */     }
/* 640 */     return (List<ICouponProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICouponProperty> argProperties) {
/* 644 */     if (this._properties == null) {
/* 645 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 647 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 650 */     for (ICouponProperty child : this._properties) {
/* 651 */       CouponPropertyModel model = (CouponPropertyModel)child;
/* 652 */       model.setCouponSerialNumber_noev(getCouponSerialNumber());
/* 653 */       model.setOrganizationId_noev(getOrganizationId());
/* 654 */       if (child instanceof IDataModelImpl) {
/* 655 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 656 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 657 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 658 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 661 */       if (postEventsForChanges()) {
/* 662 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCouponProperty(ICouponProperty argCouponProperty) {
/* 668 */     if (this._properties == null) {
/* 669 */       this._properties = new HistoricalList(null);
/*     */     }
/* 671 */     argCouponProperty.setCouponSerialNumber(getCouponSerialNumber());
/* 672 */     argCouponProperty.setOrganizationId(getOrganizationId());
/* 673 */     if (argCouponProperty instanceof IDataModelImpl) {
/* 674 */       IDataAccessObject childDao = ((IDataModelImpl)argCouponProperty).getDAO();
/* 675 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 676 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 677 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 682 */     if (postEventsForChanges()) {
/* 683 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCouponProperty));
/*     */     }
/*     */     
/* 686 */     this._properties.add(argCouponProperty);
/* 687 */     if (postEventsForChanges()) {
/* 688 */       this._events.post(ICoupon.ADD_PROPERTIES, argCouponProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCouponProperty(ICouponProperty argCouponProperty) {
/* 693 */     if (this._properties != null) {
/*     */       
/* 695 */       if (postEventsForChanges()) {
/* 696 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCouponProperty));
/*     */       }
/* 698 */       this._properties.remove(argCouponProperty);
/* 699 */       if (postEventsForChanges()) {
/* 700 */         this._events.post(ICoupon.REMOVE_PROPERTIES, argCouponProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 707 */     if ("CouponDiscount".equals(argFieldId)) {
/* 708 */       return getCouponDiscount();
/*     */     }
/* 710 */     if ("Tender".equals(argFieldId)) {
/* 711 */       return getTender();
/*     */     }
/* 713 */     if ("Properties".equals(argFieldId)) {
/* 714 */       return getProperties();
/*     */     }
/* 716 */     if ("CouponExtension".equals(argFieldId)) {
/* 717 */       return this._myExtension;
/*     */     }
/*     */     
/* 720 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 726 */     if ("CouponDiscount".equals(argFieldId)) {
/* 727 */       setCouponDiscount((IDiscount)argValue);
/*     */     }
/* 729 */     else if ("Tender".equals(argFieldId)) {
/* 730 */       setTender((ITender)argValue);
/*     */     }
/* 732 */     else if ("Properties".equals(argFieldId)) {
/* 733 */       setProperties(changeToList(argValue, ICouponProperty.class));
/*     */     }
/* 735 */     else if ("CouponExtension".equals(argFieldId)) {
/* 736 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 739 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 745 */     this._persistenceDefaults = argPD;
/* 746 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 747 */     this._eventManager = argEM;
/* 748 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 749 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 750 */     if (this._couponDiscount != null) {
/* 751 */       ((IDataModelImpl)this._couponDiscount).setDependencies(argPD, argEM);
/*     */     }
/* 753 */     if (this._tender != null) {
/* 754 */       ((IDataModelImpl)this._tender).setDependencies(argPD, argEM);
/*     */     }
/* 756 */     if (this._properties != null) {
/* 757 */       for (ICouponProperty relationship : this._properties) {
/* 758 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCouponExt() {
/* 764 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCouponExt(IDataModel argExt) {
/* 768 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 773 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 777 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 780 */     super.startTransaction();
/*     */     
/* 782 */     this._couponDiscountSavepoint = this._couponDiscount;
/* 783 */     if (this._couponDiscount != null) {
/* 784 */       this._couponDiscount.startTransaction();
/*     */     }
/*     */     
/* 787 */     this._tenderSavepoint = this._tender;
/* 788 */     if (this._tender != null) {
/* 789 */       this._tender.startTransaction();
/*     */     }
/*     */     
/* 792 */     this._propertiesSavepoint = this._properties;
/* 793 */     if (this._properties != null) {
/* 794 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 795 */       Iterator<IDataModel> it = this._properties.iterator();
/* 796 */       while (it.hasNext()) {
/* 797 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 802 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 807 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 810 */     super.rollbackChanges();
/*     */     
/* 812 */     this._couponDiscount = this._couponDiscountSavepoint;
/* 813 */     this._couponDiscountSavepoint = null;
/* 814 */     if (this._couponDiscount != null) {
/* 815 */       this._couponDiscount.rollbackChanges();
/*     */     }
/*     */     
/* 818 */     this._tender = this._tenderSavepoint;
/* 819 */     this._tenderSavepoint = null;
/* 820 */     if (this._tender != null) {
/* 821 */       this._tender.rollbackChanges();
/*     */     }
/*     */     
/* 824 */     this._properties = this._propertiesSavepoint;
/* 825 */     this._propertiesSavepoint = null;
/* 826 */     if (this._properties != null) {
/* 827 */       Iterator<IDataModel> it = this._properties.iterator();
/* 828 */       while (it.hasNext()) {
/* 829 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 837 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 840 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 843 */     super.commitTransaction();
/*     */     
/* 845 */     this._couponDiscountSavepoint = this._couponDiscount;
/* 846 */     if (this._couponDiscount != null) {
/* 847 */       this._couponDiscount.commitTransaction();
/*     */     }
/*     */     
/* 850 */     this._tenderSavepoint = this._tender;
/* 851 */     if (this._tender != null) {
/* 852 */       this._tender.commitTransaction();
/*     */     }
/*     */     
/* 855 */     this._propertiesSavepoint = this._properties;
/* 856 */     if (this._properties != null) {
/* 857 */       Iterator<IDataModel> it = this._properties.iterator();
/* 858 */       while (it.hasNext()) {
/* 859 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 861 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 865 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 870 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\CouponModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */