/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
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
/*     */ import dtv.xst.dao.cat.AwardAccountCouponPropertyId;
/*     */ import dtv.xst.dao.cat.IAwardAccount;
/*     */ import dtv.xst.dao.cat.IAwardAccountCoupon;
/*     */ import dtv.xst.dao.cat.IAwardAccountCouponProperty;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class AwardAccountCouponModel extends AwardAccountCouponBaseModel implements IAwardAccountCoupon {
/*     */   private static final long serialVersionUID = -18798218L;
/*     */   private IAwardAccount _parentAccount;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IAwardAccountCouponProperty> _properties; private transient HistoricalList<IAwardAccountCouponProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new AwardAccountCouponDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private AwardAccountCouponDAO getDAO_() {
/*  49 */     return (AwardAccountCouponDAO)this._daoImpl;
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
/*  73 */       this._events.post(IAwardAccountCoupon.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  86 */       if (this._properties != null) {
/*     */         
/*  88 */         Iterator<AwardAccountCouponPropertyModel> it = this._properties.iterator();
/*  89 */         while (it.hasNext())
/*     */         {
/*  91 */           ((AwardAccountCouponPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCardNumber() {
/* 104 */     return getDAO_().getCardNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCardNumber(String argCardNumber) {
/* 112 */     if (setCardNumber_noev(argCardNumber) && 
/* 113 */       this._events != null && 
/* 114 */       postEventsForChanges()) {
/* 115 */       this._events.post(IAwardAccountCoupon.SET_CARDNUMBER, argCardNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCardNumber_noev(String argCardNumber) {
/* 122 */     boolean ev_postable = false;
/*     */     
/* 124 */     if ((getDAO_().getCardNumber() == null && argCardNumber != null) || (
/* 125 */       getDAO_().getCardNumber() != null && !getDAO_().getCardNumber().equals(argCardNumber))) {
/* 126 */       getDAO_().setCardNumber(argCardNumber);
/* 127 */       ev_postable = true;
/* 128 */       if (this._properties != null) {
/*     */         
/* 130 */         Iterator<AwardAccountCouponPropertyModel> it = this._properties.iterator();
/* 131 */         while (it.hasNext())
/*     */         {
/* 133 */           ((AwardAccountCouponPropertyModel)it.next()).setCardNumber_noev(argCardNumber);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 138 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountId() {
/* 146 */     return getDAO_().getAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountId(String argAccountId) {
/* 154 */     if (setAccountId_noev(argAccountId) && 
/* 155 */       this._events != null && 
/* 156 */       postEventsForChanges()) {
/* 157 */       this._events.post(IAwardAccountCoupon.SET_ACCOUNTID, argAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountId_noev(String argAccountId) {
/* 164 */     boolean ev_postable = false;
/*     */     
/* 166 */     if ((getDAO_().getAccountId() == null && argAccountId != null) || (
/* 167 */       getDAO_().getAccountId() != null && !getDAO_().getAccountId().equals(argAccountId))) {
/* 168 */       getDAO_().setAccountId(argAccountId);
/* 169 */       ev_postable = true;
/* 170 */       if (this._properties != null) {
/*     */         
/* 172 */         Iterator<AwardAccountCouponPropertyModel> it = this._properties.iterator();
/* 173 */         while (it.hasNext())
/*     */         {
/* 175 */           ((AwardAccountCouponPropertyModel)it.next()).setAccountId_noev(argAccountId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 180 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCouponId() {
/* 188 */     return getDAO_().getCouponId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCouponId(String argCouponId) {
/* 196 */     if (setCouponId_noev(argCouponId) && 
/* 197 */       this._events != null && 
/* 198 */       postEventsForChanges()) {
/* 199 */       this._events.post(IAwardAccountCoupon.SET_COUPONID, argCouponId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCouponId_noev(String argCouponId) {
/* 206 */     boolean ev_postable = false;
/*     */     
/* 208 */     if ((getDAO_().getCouponId() == null && argCouponId != null) || (
/* 209 */       getDAO_().getCouponId() != null && !getDAO_().getCouponId().equals(argCouponId))) {
/* 210 */       getDAO_().setCouponId(argCouponId);
/* 211 */       ev_postable = true;
/* 212 */       if (this._properties != null) {
/*     */         
/* 214 */         Iterator<AwardAccountCouponPropertyModel> it = this._properties.iterator();
/* 215 */         while (it.hasNext())
/*     */         {
/* 217 */           ((AwardAccountCouponPropertyModel)it.next()).setCouponId_noev(argCouponId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 222 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 230 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 238 */     if (setCreateDate_noev(argCreateDate) && 
/* 239 */       this._events != null && 
/* 240 */       postEventsForChanges()) {
/* 241 */       this._events.post(IAwardAccountCoupon.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 248 */     boolean ev_postable = false;
/*     */     
/* 250 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 251 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 252 */       getDAO_().setCreateDate(argCreateDate);
/* 253 */       ev_postable = true;
/*     */     } 
/*     */     
/* 256 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 264 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 272 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 273 */       this._events != null && 
/* 274 */       postEventsForChanges()) {
/* 275 */       this._events.post(IAwardAccountCoupon.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 282 */     boolean ev_postable = false;
/*     */     
/* 284 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 285 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 286 */       getDAO_().setCreateUserId(argCreateUserId);
/* 287 */       ev_postable = true;
/*     */     } 
/*     */     
/* 290 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 298 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 306 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 307 */       this._events != null && 
/* 308 */       postEventsForChanges()) {
/* 309 */       this._events.post(IAwardAccountCoupon.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 316 */     boolean ev_postable = false;
/*     */     
/* 318 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 319 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 320 */       getDAO_().setUpdateDate(argUpdateDate);
/* 321 */       ev_postable = true;
/*     */     } 
/*     */     
/* 324 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 332 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 340 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 341 */       this._events != null && 
/* 342 */       postEventsForChanges()) {
/* 343 */       this._events.post(IAwardAccountCoupon.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 350 */     boolean ev_postable = false;
/*     */     
/* 352 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 353 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 354 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 355 */       ev_postable = true;
/*     */     } 
/*     */     
/* 358 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAmount() {
/* 366 */     return getDAO_().getAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 374 */     if (setAmount_noev(argAmount) && 
/* 375 */       this._events != null && 
/* 376 */       postEventsForChanges()) {
/* 377 */       this._events.post(IAwardAccountCoupon.SET_AMOUNT, argAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAmount_noev(BigDecimal argAmount) {
/* 384 */     boolean ev_postable = false;
/*     */     
/* 386 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/* 387 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/* 388 */       getDAO_().setAmount(argAmount);
/* 389 */       ev_postable = true;
/*     */     } 
/*     */     
/* 392 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 400 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 408 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 409 */       this._events != null && 
/* 410 */       postEventsForChanges()) {
/* 411 */       this._events.post(IAwardAccountCoupon.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 418 */     boolean ev_postable = false;
/*     */     
/* 420 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 421 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 422 */       getDAO_().setExpirationDate(argExpirationDate);
/* 423 */       ev_postable = true;
/*     */     } 
/*     */     
/* 426 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IAwardAccountCouponProperty newProperty(String argPropertyName) {
/* 430 */     AwardAccountCouponPropertyId id = new AwardAccountCouponPropertyId();
/*     */     
/* 432 */     id.setCardNumber(getCardNumber());
/* 433 */     id.setAccountId(getAccountId());
/* 434 */     id.setCouponId(getCouponId());
/* 435 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 437 */     IAwardAccountCouponProperty prop = (IAwardAccountCouponProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IAwardAccountCouponProperty.class);
/* 438 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IAwardAccountCouponProperty> getProperties() {
/* 447 */     if (this._properties == null) {
/* 448 */       this._properties = new HistoricalList(null);
/*     */     }
/* 450 */     return (List<IAwardAccountCouponProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IAwardAccountCouponProperty> argProperties) {
/* 454 */     if (this._properties == null) {
/* 455 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 457 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 460 */     for (IAwardAccountCouponProperty child : this._properties) {
/* 461 */       AwardAccountCouponPropertyModel model = (AwardAccountCouponPropertyModel)child;
/* 462 */       model.setOrganizationId_noev(getOrganizationId());
/* 463 */       model.setCardNumber_noev(getCardNumber());
/* 464 */       model.setAccountId_noev(getAccountId());
/* 465 */       model.setCouponId_noev(getCouponId());
/* 466 */       if (child instanceof IDataModelImpl) {
/* 467 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 468 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 469 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 470 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 473 */       if (postEventsForChanges()) {
/* 474 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addAwardAccountCouponProperty(IAwardAccountCouponProperty argAwardAccountCouponProperty) {
/* 480 */     if (this._properties == null) {
/* 481 */       this._properties = new HistoricalList(null);
/*     */     }
/* 483 */     argAwardAccountCouponProperty.setOrganizationId(getOrganizationId());
/* 484 */     argAwardAccountCouponProperty.setCardNumber(getCardNumber());
/* 485 */     argAwardAccountCouponProperty.setAccountId(getAccountId());
/* 486 */     argAwardAccountCouponProperty.setCouponId(getCouponId());
/* 487 */     if (argAwardAccountCouponProperty instanceof IDataModelImpl) {
/* 488 */       IDataAccessObject childDao = ((IDataModelImpl)argAwardAccountCouponProperty).getDAO();
/* 489 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 490 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 491 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 496 */     if (postEventsForChanges()) {
/* 497 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAwardAccountCouponProperty));
/*     */     }
/*     */     
/* 500 */     this._properties.add(argAwardAccountCouponProperty);
/* 501 */     if (postEventsForChanges()) {
/* 502 */       this._events.post(IAwardAccountCoupon.ADD_PROPERTIES, argAwardAccountCouponProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeAwardAccountCouponProperty(IAwardAccountCouponProperty argAwardAccountCouponProperty) {
/* 507 */     if (this._properties != null) {
/*     */       
/* 509 */       if (postEventsForChanges()) {
/* 510 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAwardAccountCouponProperty));
/*     */       }
/* 512 */       this._properties.remove(argAwardAccountCouponProperty);
/* 513 */       if (postEventsForChanges()) {
/* 514 */         this._events.post(IAwardAccountCoupon.REMOVE_PROPERTIES, argAwardAccountCouponProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentAccount(IAwardAccount argParentAccount) {
/* 520 */     this._parentAccount = argParentAccount;
/*     */   }
/*     */   
/*     */   public IAwardAccount getParentAccount() {
/* 524 */     return this._parentAccount;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 529 */     if ("Properties".equals(argFieldId)) {
/* 530 */       return getProperties();
/*     */     }
/* 532 */     if ("AwardAccountCouponExtension".equals(argFieldId)) {
/* 533 */       return this._myExtension;
/*     */     }
/*     */     
/* 536 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 542 */     if ("Properties".equals(argFieldId)) {
/* 543 */       setProperties(changeToList(argValue, IAwardAccountCouponProperty.class));
/*     */     }
/* 545 */     else if ("AwardAccountCouponExtension".equals(argFieldId)) {
/* 546 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 549 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 555 */     this._persistenceDefaults = argPD;
/* 556 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 557 */     this._eventManager = argEM;
/* 558 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 559 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 560 */     if (this._properties != null) {
/* 561 */       for (IAwardAccountCouponProperty relationship : this._properties) {
/* 562 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getAwardAccountCouponExt() {
/* 568 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setAwardAccountCouponExt(IDataModel argExt) {
/* 572 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 577 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 581 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 584 */     super.startTransaction();
/*     */     
/* 586 */     this._propertiesSavepoint = this._properties;
/* 587 */     if (this._properties != null) {
/* 588 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 589 */       Iterator<IDataModel> it = this._properties.iterator();
/* 590 */       while (it.hasNext()) {
/* 591 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 596 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 601 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 604 */     super.rollbackChanges();
/*     */     
/* 606 */     this._properties = this._propertiesSavepoint;
/* 607 */     this._propertiesSavepoint = null;
/* 608 */     if (this._properties != null) {
/* 609 */       Iterator<IDataModel> it = this._properties.iterator();
/* 610 */       while (it.hasNext()) {
/* 611 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 619 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 622 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 625 */     super.commitTransaction();
/*     */     
/* 627 */     this._propertiesSavepoint = this._properties;
/* 628 */     if (this._properties != null) {
/* 629 */       Iterator<IDataModel> it = this._properties.iterator();
/* 630 */       while (it.hasNext()) {
/* 631 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 633 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 637 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\AwardAccountCouponModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */