/*     */ package dtv.xst.dao.cat.impl;
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
/*     */ import dtv.xst.dao.cat.AwardAccountPropertyId;
/*     */ import dtv.xst.dao.cat.IAwardAccount;
/*     */ import dtv.xst.dao.cat.IAwardAccountCoupon;
/*     */ import dtv.xst.dao.cat.IAwardAccountProperty;
/*     */ import dtv.xst.dao.cat.ICustomerLoyaltyCard;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class AwardAccountModel extends AwardAccountBaseModel implements IAwardAccount {
/*     */   private static final long serialVersionUID = 1907951920L;
/*     */   private ICustomerLoyaltyCard _parentCard;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IAwardAccountCoupon> _awardCoupons; private transient HistoricalList<IAwardAccountCoupon> _awardCouponsSavepoint; private HistoricalList<IAwardAccountProperty> _properties; private transient HistoricalList<IAwardAccountProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new AwardAccountDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private AwardAccountDAO getDAO_() {
/*  49 */     return (AwardAccountDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  57 */     if (getDAO_().getOrganizationId() != null) {
/*  58 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  61 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  70 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  71 */       this._events != null && 
/*  72 */       postEventsForChanges()) {
/*  73 */       this._events.post(IAwardAccount.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  80 */     boolean ev_postable = false;
/*     */     
/*  82 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  83 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  84 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  85 */       ev_postable = true;
/*  86 */       if (this._awardCoupons != null) {
/*     */         
/*  88 */         Iterator<AwardAccountCouponModel> it = this._awardCoupons.iterator();
/*  89 */         while (it.hasNext())
/*     */         {
/*  91 */           ((AwardAccountCouponModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  94 */       if (this._properties != null) {
/*     */         
/*  96 */         Iterator<AwardAccountPropertyModel> it = this._properties.iterator();
/*  97 */         while (it.hasNext())
/*     */         {
/*  99 */           ((AwardAccountPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 104 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCardNumber() {
/* 112 */     return getDAO_().getCardNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCardNumber(String argCardNumber) {
/* 120 */     if (setCardNumber_noev(argCardNumber) && 
/* 121 */       this._events != null && 
/* 122 */       postEventsForChanges()) {
/* 123 */       this._events.post(IAwardAccount.SET_CARDNUMBER, argCardNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCardNumber_noev(String argCardNumber) {
/* 130 */     boolean ev_postable = false;
/*     */     
/* 132 */     if ((getDAO_().getCardNumber() == null && argCardNumber != null) || (
/* 133 */       getDAO_().getCardNumber() != null && !getDAO_().getCardNumber().equals(argCardNumber))) {
/* 134 */       getDAO_().setCardNumber(argCardNumber);
/* 135 */       ev_postable = true;
/* 136 */       if (this._awardCoupons != null) {
/*     */         
/* 138 */         Iterator<AwardAccountCouponModel> it = this._awardCoupons.iterator();
/* 139 */         while (it.hasNext())
/*     */         {
/* 141 */           ((AwardAccountCouponModel)it.next()).setCardNumber_noev(argCardNumber);
/*     */         }
/*     */       } 
/* 144 */       if (this._properties != null) {
/*     */         
/* 146 */         Iterator<AwardAccountPropertyModel> it = this._properties.iterator();
/* 147 */         while (it.hasNext())
/*     */         {
/* 149 */           ((AwardAccountPropertyModel)it.next()).setCardNumber_noev(argCardNumber);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 154 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountId() {
/* 162 */     return getDAO_().getAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountId(String argAccountId) {
/* 170 */     if (setAccountId_noev(argAccountId) && 
/* 171 */       this._events != null && 
/* 172 */       postEventsForChanges()) {
/* 173 */       this._events.post(IAwardAccount.SET_ACCOUNTID, argAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountId_noev(String argAccountId) {
/* 180 */     boolean ev_postable = false;
/*     */     
/* 182 */     if ((getDAO_().getAccountId() == null && argAccountId != null) || (
/* 183 */       getDAO_().getAccountId() != null && !getDAO_().getAccountId().equals(argAccountId))) {
/* 184 */       getDAO_().setAccountId(argAccountId);
/* 185 */       ev_postable = true;
/* 186 */       if (this._awardCoupons != null) {
/*     */         
/* 188 */         Iterator<AwardAccountCouponModel> it = this._awardCoupons.iterator();
/* 189 */         while (it.hasNext())
/*     */         {
/* 191 */           ((AwardAccountCouponModel)it.next()).setAccountId_noev(argAccountId);
/*     */         }
/*     */       } 
/* 194 */       if (this._properties != null) {
/*     */         
/* 196 */         Iterator<AwardAccountPropertyModel> it = this._properties.iterator();
/* 197 */         while (it.hasNext())
/*     */         {
/* 199 */           ((AwardAccountPropertyModel)it.next()).setAccountId_noev(argAccountId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 204 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 212 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 220 */     if (setCreateDate_noev(argCreateDate) && 
/* 221 */       this._events != null && 
/* 222 */       postEventsForChanges()) {
/* 223 */       this._events.post(IAwardAccount.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 230 */     boolean ev_postable = false;
/*     */     
/* 232 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 233 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 234 */       getDAO_().setCreateDate(argCreateDate);
/* 235 */       ev_postable = true;
/*     */     } 
/*     */     
/* 238 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 246 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 254 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 255 */       this._events != null && 
/* 256 */       postEventsForChanges()) {
/* 257 */       this._events.post(IAwardAccount.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 264 */     boolean ev_postable = false;
/*     */     
/* 266 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 267 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 268 */       getDAO_().setCreateUserId(argCreateUserId);
/* 269 */       ev_postable = true;
/*     */     } 
/*     */     
/* 272 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 280 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 288 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 289 */       this._events != null && 
/* 290 */       postEventsForChanges()) {
/* 291 */       this._events.post(IAwardAccount.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 298 */     boolean ev_postable = false;
/*     */     
/* 300 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 301 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 302 */       getDAO_().setUpdateDate(argUpdateDate);
/* 303 */       ev_postable = true;
/*     */     } 
/*     */     
/* 306 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 314 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 322 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 323 */       this._events != null && 
/* 324 */       postEventsForChanges()) {
/* 325 */       this._events.post(IAwardAccount.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 332 */     boolean ev_postable = false;
/*     */     
/* 334 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 335 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 336 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 337 */       ev_postable = true;
/*     */     } 
/*     */     
/* 340 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IAwardAccountProperty newProperty(String argPropertyName) {
/* 344 */     AwardAccountPropertyId id = new AwardAccountPropertyId();
/*     */     
/* 346 */     id.setCardNumber(getCardNumber());
/* 347 */     id.setAccountId(getAccountId());
/* 348 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 350 */     IAwardAccountProperty prop = (IAwardAccountProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IAwardAccountProperty.class);
/* 351 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "AwardCoupons")
/*     */   public List<IAwardAccountCoupon> getAwardCoupons() {
/* 363 */     if (this._awardCoupons == null) {
/* 364 */       this._awardCoupons = new HistoricalList(null);
/*     */     }
/* 366 */     return (List<IAwardAccountCoupon>)this._awardCoupons;
/*     */   }
/*     */   
/*     */   public void setAwardCoupons(List<IAwardAccountCoupon> argAwardCoupons) {
/* 370 */     if (this._awardCoupons == null) {
/* 371 */       this._awardCoupons = new HistoricalList(argAwardCoupons);
/*     */     } else {
/* 373 */       this._awardCoupons.setCurrentList(argAwardCoupons);
/*     */     } 
/*     */     
/* 376 */     for (IAwardAccountCoupon child : this._awardCoupons) {
/* 377 */       child.setParentAccount(this);
/*     */     }
/*     */ 
/*     */     
/* 381 */     for (IAwardAccountCoupon child : this._awardCoupons) {
/* 382 */       AwardAccountCouponModel model = (AwardAccountCouponModel)child;
/* 383 */       model.setOrganizationId_noev(getOrganizationId());
/* 384 */       model.setCardNumber_noev(getCardNumber());
/* 385 */       model.setAccountId_noev(getAccountId());
/* 386 */       if (child instanceof IDataModelImpl) {
/* 387 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 388 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 389 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 390 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 393 */       if (postEventsForChanges()) {
/* 394 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addAwardAccountCoupon(IAwardAccountCoupon argAwardAccountCoupon) {
/* 401 */     argAwardAccountCoupon.setParentAccount(this);
/* 402 */     if (this._awardCoupons == null) {
/* 403 */       this._awardCoupons = new HistoricalList(null);
/*     */     }
/* 405 */     argAwardAccountCoupon.setOrganizationId(getOrganizationId());
/* 406 */     argAwardAccountCoupon.setCardNumber(getCardNumber());
/* 407 */     argAwardAccountCoupon.setAccountId(getAccountId());
/* 408 */     if (argAwardAccountCoupon instanceof IDataModelImpl) {
/* 409 */       IDataAccessObject childDao = ((IDataModelImpl)argAwardAccountCoupon).getDAO();
/* 410 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 411 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 412 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 417 */     if (postEventsForChanges()) {
/* 418 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAwardAccountCoupon));
/*     */     }
/*     */     
/* 421 */     this._awardCoupons.add(argAwardAccountCoupon);
/* 422 */     if (postEventsForChanges()) {
/* 423 */       this._events.post(IAwardAccount.ADD_AWARDCOUPONS, argAwardAccountCoupon);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeAwardAccountCoupon(IAwardAccountCoupon argAwardAccountCoupon) {
/* 428 */     if (this._awardCoupons != null) {
/*     */       
/* 430 */       if (postEventsForChanges()) {
/* 431 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAwardAccountCoupon));
/*     */       }
/* 433 */       this._awardCoupons.remove(argAwardAccountCoupon);
/*     */       
/* 435 */       argAwardAccountCoupon.setParentAccount(null);
/* 436 */       if (postEventsForChanges()) {
/* 437 */         this._events.post(IAwardAccount.REMOVE_AWARDCOUPONS, argAwardAccountCoupon);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IAwardAccountProperty> getProperties() {
/* 444 */     if (this._properties == null) {
/* 445 */       this._properties = new HistoricalList(null);
/*     */     }
/* 447 */     return (List<IAwardAccountProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IAwardAccountProperty> argProperties) {
/* 451 */     if (this._properties == null) {
/* 452 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 454 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 457 */     for (IAwardAccountProperty child : this._properties) {
/* 458 */       AwardAccountPropertyModel model = (AwardAccountPropertyModel)child;
/* 459 */       model.setOrganizationId_noev(getOrganizationId());
/* 460 */       model.setCardNumber_noev(getCardNumber());
/* 461 */       model.setAccountId_noev(getAccountId());
/* 462 */       if (child instanceof IDataModelImpl) {
/* 463 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 464 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 465 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 466 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 469 */       if (postEventsForChanges()) {
/* 470 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addAwardAccountProperty(IAwardAccountProperty argAwardAccountProperty) {
/* 476 */     if (this._properties == null) {
/* 477 */       this._properties = new HistoricalList(null);
/*     */     }
/* 479 */     argAwardAccountProperty.setOrganizationId(getOrganizationId());
/* 480 */     argAwardAccountProperty.setCardNumber(getCardNumber());
/* 481 */     argAwardAccountProperty.setAccountId(getAccountId());
/* 482 */     if (argAwardAccountProperty instanceof IDataModelImpl) {
/* 483 */       IDataAccessObject childDao = ((IDataModelImpl)argAwardAccountProperty).getDAO();
/* 484 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 485 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 486 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 491 */     if (postEventsForChanges()) {
/* 492 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAwardAccountProperty));
/*     */     }
/*     */     
/* 495 */     this._properties.add(argAwardAccountProperty);
/* 496 */     if (postEventsForChanges()) {
/* 497 */       this._events.post(IAwardAccount.ADD_PROPERTIES, argAwardAccountProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeAwardAccountProperty(IAwardAccountProperty argAwardAccountProperty) {
/* 502 */     if (this._properties != null) {
/*     */       
/* 504 */       if (postEventsForChanges()) {
/* 505 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAwardAccountProperty));
/*     */       }
/* 507 */       this._properties.remove(argAwardAccountProperty);
/* 508 */       if (postEventsForChanges()) {
/* 509 */         this._events.post(IAwardAccount.REMOVE_PROPERTIES, argAwardAccountProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentCard(ICustomerLoyaltyCard argParentCard) {
/* 515 */     this._parentCard = argParentCard;
/*     */   }
/*     */   
/*     */   public ICustomerLoyaltyCard getParentCard() {
/* 519 */     return this._parentCard;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 524 */     if ("AwardCoupons".equals(argFieldId)) {
/* 525 */       return getAwardCoupons();
/*     */     }
/* 527 */     if ("Properties".equals(argFieldId)) {
/* 528 */       return getProperties();
/*     */     }
/* 530 */     if ("AwardAccountExtension".equals(argFieldId)) {
/* 531 */       return this._myExtension;
/*     */     }
/*     */     
/* 534 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 540 */     if ("AwardCoupons".equals(argFieldId)) {
/* 541 */       setAwardCoupons(changeToList(argValue, IAwardAccountCoupon.class));
/*     */     }
/* 543 */     else if ("Properties".equals(argFieldId)) {
/* 544 */       setProperties(changeToList(argValue, IAwardAccountProperty.class));
/*     */     }
/* 546 */     else if ("AwardAccountExtension".equals(argFieldId)) {
/* 547 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 550 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 556 */     this._persistenceDefaults = argPD;
/* 557 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 558 */     this._eventManager = argEM;
/* 559 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 560 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 561 */     if (this._awardCoupons != null) {
/* 562 */       for (IAwardAccountCoupon relationship : this._awardCoupons) {
/* 563 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 566 */     if (this._properties != null) {
/* 567 */       for (IAwardAccountProperty relationship : this._properties) {
/* 568 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getAwardAccountExt() {
/* 574 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setAwardAccountExt(IDataModel argExt) {
/* 578 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 583 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 587 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 590 */     super.startTransaction();
/*     */     
/* 592 */     this._awardCouponsSavepoint = this._awardCoupons;
/* 593 */     if (this._awardCoupons != null) {
/* 594 */       this._awardCouponsSavepoint = new HistoricalList((List)this._awardCoupons);
/* 595 */       Iterator<IDataModel> it = this._awardCoupons.iterator();
/* 596 */       while (it.hasNext()) {
/* 597 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 601 */     this._propertiesSavepoint = this._properties;
/* 602 */     if (this._properties != null) {
/* 603 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 604 */       Iterator<IDataModel> it = this._properties.iterator();
/* 605 */       while (it.hasNext()) {
/* 606 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 611 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 616 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 619 */     super.rollbackChanges();
/*     */     
/* 621 */     this._awardCoupons = this._awardCouponsSavepoint;
/* 622 */     this._awardCouponsSavepoint = null;
/* 623 */     if (this._awardCoupons != null) {
/* 624 */       Iterator<IDataModel> it = this._awardCoupons.iterator();
/* 625 */       while (it.hasNext()) {
/* 626 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 630 */     this._properties = this._propertiesSavepoint;
/* 631 */     this._propertiesSavepoint = null;
/* 632 */     if (this._properties != null) {
/* 633 */       Iterator<IDataModel> it = this._properties.iterator();
/* 634 */       while (it.hasNext()) {
/* 635 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 643 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 646 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 649 */     super.commitTransaction();
/*     */     
/* 651 */     this._awardCouponsSavepoint = this._awardCoupons;
/* 652 */     if (this._awardCoupons != null) {
/* 653 */       Iterator<IDataModel> it = this._awardCoupons.iterator();
/* 654 */       while (it.hasNext()) {
/* 655 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 657 */       this._awardCoupons = new HistoricalList((List)this._awardCoupons);
/*     */     } 
/*     */     
/* 660 */     this._propertiesSavepoint = this._properties;
/* 661 */     if (this._properties != null) {
/* 662 */       Iterator<IDataModel> it = this._properties.iterator();
/* 663 */       while (it.hasNext()) {
/* 664 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 666 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 670 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\AwardAccountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */