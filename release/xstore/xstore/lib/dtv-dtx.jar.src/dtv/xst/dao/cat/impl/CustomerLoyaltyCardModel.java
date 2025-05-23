/*     */ package dtv.xst.dao.cat.impl;
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
/*     */ import dtv.xst.dao.cat.CustomerLoyaltyCardPropertyId;
/*     */ import dtv.xst.dao.cat.IAwardAccount;
/*     */ import dtv.xst.dao.cat.ICustomerLoyaltyAccount;
/*     */ import dtv.xst.dao.cat.ICustomerLoyaltyCard;
/*     */ import dtv.xst.dao.cat.ICustomerLoyaltyCardProperty;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CustomerLoyaltyCardModel extends CustomerLoyaltyCardBaseModel implements ICustomerLoyaltyCard {
/*     */   private static final long serialVersionUID = 1934498200L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private HistoricalList<ICustomerLoyaltyAccount> _loyaltyAccounts;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient HistoricalList<ICustomerLoyaltyAccount> _loyaltyAccountsSavepoint; private HistoricalList<IAwardAccount> _awardAccounts; private transient HistoricalList<IAwardAccount> _awardAccountsSavepoint; private HistoricalList<ICustomerLoyaltyCardProperty> _properties; private transient HistoricalList<ICustomerLoyaltyCardProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new CustomerLoyaltyCardDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CustomerLoyaltyCardDAO getDAO_() {
/*  47 */     return (CustomerLoyaltyCardDAO)this._daoImpl;
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
/*  71 */       this._events.post(ICustomerLoyaltyCard.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  84 */       if (this._loyaltyAccounts != null) {
/*     */         
/*  86 */         Iterator<CustomerLoyaltyAccountModel> it = this._loyaltyAccounts.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((CustomerLoyaltyAccountModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  92 */       if (this._awardAccounts != null) {
/*     */         
/*  94 */         Iterator<AwardAccountModel> it = this._awardAccounts.iterator();
/*  95 */         while (it.hasNext())
/*     */         {
/*  97 */           ((AwardAccountModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/* 100 */       if (this._properties != null) {
/*     */         
/* 102 */         Iterator<CustomerLoyaltyCardPropertyModel> it = this._properties.iterator();
/* 103 */         while (it.hasNext())
/*     */         {
/* 105 */           ((CustomerLoyaltyCardPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 110 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCardNumber() {
/* 118 */     return getDAO_().getCardNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCardNumber(String argCardNumber) {
/* 126 */     if (setCardNumber_noev(argCardNumber) && 
/* 127 */       this._events != null && 
/* 128 */       postEventsForChanges()) {
/* 129 */       this._events.post(ICustomerLoyaltyCard.SET_CARDNUMBER, argCardNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCardNumber_noev(String argCardNumber) {
/* 136 */     boolean ev_postable = false;
/*     */     
/* 138 */     if ((getDAO_().getCardNumber() == null && argCardNumber != null) || (
/* 139 */       getDAO_().getCardNumber() != null && !getDAO_().getCardNumber().equals(argCardNumber))) {
/* 140 */       getDAO_().setCardNumber(argCardNumber);
/* 141 */       ev_postable = true;
/* 142 */       if (this._loyaltyAccounts != null) {
/*     */         
/* 144 */         Iterator<CustomerLoyaltyAccountModel> it = this._loyaltyAccounts.iterator();
/* 145 */         while (it.hasNext())
/*     */         {
/* 147 */           ((CustomerLoyaltyAccountModel)it.next()).setCardNumber_noev(argCardNumber);
/*     */         }
/*     */       } 
/* 150 */       if (this._awardAccounts != null) {
/*     */         
/* 152 */         Iterator<AwardAccountModel> it = this._awardAccounts.iterator();
/* 153 */         while (it.hasNext())
/*     */         {
/* 155 */           ((AwardAccountModel)it.next()).setCardNumber_noev(argCardNumber);
/*     */         }
/*     */       } 
/* 158 */       if (this._properties != null) {
/*     */         
/* 160 */         Iterator<CustomerLoyaltyCardPropertyModel> it = this._properties.iterator();
/* 161 */         while (it.hasNext())
/*     */         {
/* 163 */           ((CustomerLoyaltyCardPropertyModel)it.next()).setCardNumber_noev(argCardNumber);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 168 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 176 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 184 */     if (setCreateDate_noev(argCreateDate) && 
/* 185 */       this._events != null && 
/* 186 */       postEventsForChanges()) {
/* 187 */       this._events.post(ICustomerLoyaltyCard.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 194 */     boolean ev_postable = false;
/*     */     
/* 196 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 197 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 198 */       getDAO_().setCreateDate(argCreateDate);
/* 199 */       ev_postable = true;
/*     */     } 
/*     */     
/* 202 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 210 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 218 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 219 */       this._events != null && 
/* 220 */       postEventsForChanges()) {
/* 221 */       this._events.post(ICustomerLoyaltyCard.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 228 */     boolean ev_postable = false;
/*     */     
/* 230 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 231 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 232 */       getDAO_().setCreateUserId(argCreateUserId);
/* 233 */       ev_postable = true;
/*     */     } 
/*     */     
/* 236 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 244 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 252 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 253 */       this._events != null && 
/* 254 */       postEventsForChanges()) {
/* 255 */       this._events.post(ICustomerLoyaltyCard.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 262 */     boolean ev_postable = false;
/*     */     
/* 264 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 265 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 266 */       getDAO_().setUpdateDate(argUpdateDate);
/* 267 */       ev_postable = true;
/*     */     } 
/*     */     
/* 270 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 278 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 286 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 287 */       this._events != null && 
/* 288 */       postEventsForChanges()) {
/* 289 */       this._events.post(ICustomerLoyaltyCard.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 296 */     boolean ev_postable = false;
/*     */     
/* 298 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 299 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 300 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 301 */       ev_postable = true;
/*     */     } 
/*     */     
/* 304 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPartyId() {
/* 312 */     if (getDAO_().getPartyId() != null) {
/* 313 */       return getDAO_().getPartyId().longValue();
/*     */     }
/*     */     
/* 316 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPartyId(long argPartyId) {
/* 325 */     if (setPartyId_noev(argPartyId) && 
/* 326 */       this._events != null && 
/* 327 */       postEventsForChanges()) {
/* 328 */       this._events.post(ICustomerLoyaltyCard.SET_PARTYID, Long.valueOf(argPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPartyId_noev(long argPartyId) {
/* 335 */     boolean ev_postable = false;
/*     */     
/* 337 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/* 338 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/* 339 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/* 340 */       ev_postable = true;
/*     */     } 
/*     */     
/* 343 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 351 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 359 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 360 */       this._events != null && 
/* 361 */       postEventsForChanges()) {
/* 362 */       this._events.post(ICustomerLoyaltyCard.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 369 */     boolean ev_postable = false;
/*     */     
/* 371 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 372 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 373 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 374 */       ev_postable = true;
/*     */     } 
/*     */     
/* 377 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 385 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 393 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 394 */       this._events != null && 
/* 395 */       postEventsForChanges()) {
/* 396 */       this._events.post(ICustomerLoyaltyCard.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 403 */     boolean ev_postable = false;
/*     */     
/* 405 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 406 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 407 */       getDAO_().setExpirationDate(argExpirationDate);
/* 408 */       ev_postable = true;
/*     */     } 
/*     */     
/* 411 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICustomerLoyaltyCardProperty newProperty(String argPropertyName) {
/* 415 */     CustomerLoyaltyCardPropertyId id = new CustomerLoyaltyCardPropertyId();
/*     */     
/* 417 */     id.setCardNumber(getCardNumber());
/* 418 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 420 */     ICustomerLoyaltyCardProperty prop = (ICustomerLoyaltyCardProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICustomerLoyaltyCardProperty.class);
/* 421 */     return prop;
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
/*     */   @Relationship(name = "LoyaltyAccounts")
/*     */   public List<ICustomerLoyaltyAccount> getLoyaltyAccounts() {
/* 436 */     if (this._loyaltyAccounts == null) {
/* 437 */       this._loyaltyAccounts = new HistoricalList(null);
/*     */     }
/* 439 */     return (List<ICustomerLoyaltyAccount>)this._loyaltyAccounts;
/*     */   }
/*     */   
/*     */   public void setLoyaltyAccounts(List<ICustomerLoyaltyAccount> argLoyaltyAccounts) {
/* 443 */     if (this._loyaltyAccounts == null) {
/* 444 */       this._loyaltyAccounts = new HistoricalList(argLoyaltyAccounts);
/*     */     } else {
/* 446 */       this._loyaltyAccounts.setCurrentList(argLoyaltyAccounts);
/*     */     } 
/*     */     
/* 449 */     for (ICustomerLoyaltyAccount child : this._loyaltyAccounts) {
/* 450 */       child.setParentCard(this);
/*     */     }
/*     */ 
/*     */     
/* 454 */     for (ICustomerLoyaltyAccount child : this._loyaltyAccounts) {
/* 455 */       CustomerLoyaltyAccountModel model = (CustomerLoyaltyAccountModel)child;
/* 456 */       model.setOrganizationId_noev(getOrganizationId());
/* 457 */       model.setCardNumber_noev(getCardNumber());
/* 458 */       if (child instanceof IDataModelImpl) {
/* 459 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 460 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 461 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 462 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 465 */       if (postEventsForChanges()) {
/* 466 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addCustomerLoyaltyAccount(ICustomerLoyaltyAccount argCustomerLoyaltyAccount) {
/* 473 */     argCustomerLoyaltyAccount.setParentCard(this);
/* 474 */     if (this._loyaltyAccounts == null) {
/* 475 */       this._loyaltyAccounts = new HistoricalList(null);
/*     */     }
/* 477 */     argCustomerLoyaltyAccount.setOrganizationId(getOrganizationId());
/* 478 */     argCustomerLoyaltyAccount.setCardNumber(getCardNumber());
/* 479 */     if (argCustomerLoyaltyAccount instanceof IDataModelImpl) {
/* 480 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerLoyaltyAccount).getDAO();
/* 481 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 482 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 483 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 488 */     if (postEventsForChanges()) {
/* 489 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerLoyaltyAccount));
/*     */     }
/*     */     
/* 492 */     this._loyaltyAccounts.add(argCustomerLoyaltyAccount);
/* 493 */     if (postEventsForChanges()) {
/* 494 */       this._events.post(ICustomerLoyaltyCard.ADD_LOYALTYACCOUNTS, argCustomerLoyaltyAccount);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCustomerLoyaltyAccount(ICustomerLoyaltyAccount argCustomerLoyaltyAccount) {
/* 499 */     if (this._loyaltyAccounts != null) {
/*     */       
/* 501 */       if (postEventsForChanges()) {
/* 502 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerLoyaltyAccount));
/*     */       }
/* 504 */       this._loyaltyAccounts.remove(argCustomerLoyaltyAccount);
/*     */       
/* 506 */       argCustomerLoyaltyAccount.setParentCard(null);
/* 507 */       if (postEventsForChanges()) {
/* 508 */         this._events.post(ICustomerLoyaltyCard.REMOVE_LOYALTYACCOUNTS, argCustomerLoyaltyAccount);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "AwardAccounts")
/*     */   public List<IAwardAccount> getAwardAccounts() {
/* 515 */     if (this._awardAccounts == null) {
/* 516 */       this._awardAccounts = new HistoricalList(null);
/*     */     }
/* 518 */     return (List<IAwardAccount>)this._awardAccounts;
/*     */   }
/*     */   
/*     */   public void setAwardAccounts(List<IAwardAccount> argAwardAccounts) {
/* 522 */     if (this._awardAccounts == null) {
/* 523 */       this._awardAccounts = new HistoricalList(argAwardAccounts);
/*     */     } else {
/* 525 */       this._awardAccounts.setCurrentList(argAwardAccounts);
/*     */     } 
/*     */     
/* 528 */     for (IAwardAccount child : this._awardAccounts) {
/* 529 */       child.setParentCard(this);
/*     */     }
/*     */ 
/*     */     
/* 533 */     for (IAwardAccount child : this._awardAccounts) {
/* 534 */       AwardAccountModel model = (AwardAccountModel)child;
/* 535 */       model.setOrganizationId_noev(getOrganizationId());
/* 536 */       model.setCardNumber_noev(getCardNumber());
/* 537 */       if (child instanceof IDataModelImpl) {
/* 538 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 539 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 540 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 541 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 544 */       if (postEventsForChanges()) {
/* 545 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addAwardAccount(IAwardAccount argAwardAccount) {
/* 552 */     argAwardAccount.setParentCard(this);
/* 553 */     if (this._awardAccounts == null) {
/* 554 */       this._awardAccounts = new HistoricalList(null);
/*     */     }
/* 556 */     argAwardAccount.setOrganizationId(getOrganizationId());
/* 557 */     argAwardAccount.setCardNumber(getCardNumber());
/* 558 */     if (argAwardAccount instanceof IDataModelImpl) {
/* 559 */       IDataAccessObject childDao = ((IDataModelImpl)argAwardAccount).getDAO();
/* 560 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 561 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 562 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 567 */     if (postEventsForChanges()) {
/* 568 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAwardAccount));
/*     */     }
/*     */     
/* 571 */     this._awardAccounts.add(argAwardAccount);
/* 572 */     if (postEventsForChanges()) {
/* 573 */       this._events.post(ICustomerLoyaltyCard.ADD_AWARDACCOUNTS, argAwardAccount);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeAwardAccount(IAwardAccount argAwardAccount) {
/* 578 */     if (this._awardAccounts != null) {
/*     */       
/* 580 */       if (postEventsForChanges()) {
/* 581 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAwardAccount));
/*     */       }
/* 583 */       this._awardAccounts.remove(argAwardAccount);
/*     */       
/* 585 */       argAwardAccount.setParentCard(null);
/* 586 */       if (postEventsForChanges()) {
/* 587 */         this._events.post(ICustomerLoyaltyCard.REMOVE_AWARDACCOUNTS, argAwardAccount);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICustomerLoyaltyCardProperty> getProperties() {
/* 594 */     if (this._properties == null) {
/* 595 */       this._properties = new HistoricalList(null);
/*     */     }
/* 597 */     return (List<ICustomerLoyaltyCardProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICustomerLoyaltyCardProperty> argProperties) {
/* 601 */     if (this._properties == null) {
/* 602 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 604 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 607 */     for (ICustomerLoyaltyCardProperty child : this._properties) {
/* 608 */       CustomerLoyaltyCardPropertyModel model = (CustomerLoyaltyCardPropertyModel)child;
/* 609 */       model.setOrganizationId_noev(getOrganizationId());
/* 610 */       model.setCardNumber_noev(getCardNumber());
/* 611 */       if (child instanceof IDataModelImpl) {
/* 612 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 613 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 614 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 615 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 618 */       if (postEventsForChanges()) {
/* 619 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCustomerLoyaltyCardProperty(ICustomerLoyaltyCardProperty argCustomerLoyaltyCardProperty) {
/* 625 */     if (this._properties == null) {
/* 626 */       this._properties = new HistoricalList(null);
/*     */     }
/* 628 */     argCustomerLoyaltyCardProperty.setOrganizationId(getOrganizationId());
/* 629 */     argCustomerLoyaltyCardProperty.setCardNumber(getCardNumber());
/* 630 */     if (argCustomerLoyaltyCardProperty instanceof IDataModelImpl) {
/* 631 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerLoyaltyCardProperty).getDAO();
/* 632 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 633 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 634 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 639 */     if (postEventsForChanges()) {
/* 640 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerLoyaltyCardProperty));
/*     */     }
/*     */     
/* 643 */     this._properties.add(argCustomerLoyaltyCardProperty);
/* 644 */     if (postEventsForChanges()) {
/* 645 */       this._events.post(ICustomerLoyaltyCard.ADD_PROPERTIES, argCustomerLoyaltyCardProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCustomerLoyaltyCardProperty(ICustomerLoyaltyCardProperty argCustomerLoyaltyCardProperty) {
/* 650 */     if (this._properties != null) {
/*     */       
/* 652 */       if (postEventsForChanges()) {
/* 653 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerLoyaltyCardProperty));
/*     */       }
/* 655 */       this._properties.remove(argCustomerLoyaltyCardProperty);
/* 656 */       if (postEventsForChanges()) {
/* 657 */         this._events.post(ICustomerLoyaltyCard.REMOVE_PROPERTIES, argCustomerLoyaltyCardProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 664 */     if ("LoyaltyAccounts".equals(argFieldId)) {
/* 665 */       return getLoyaltyAccounts();
/*     */     }
/* 667 */     if ("AwardAccounts".equals(argFieldId)) {
/* 668 */       return getAwardAccounts();
/*     */     }
/* 670 */     if ("Properties".equals(argFieldId)) {
/* 671 */       return getProperties();
/*     */     }
/* 673 */     if ("CustomerLoyaltyCardExtension".equals(argFieldId)) {
/* 674 */       return this._myExtension;
/*     */     }
/*     */     
/* 677 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 683 */     if ("LoyaltyAccounts".equals(argFieldId)) {
/* 684 */       setLoyaltyAccounts(changeToList(argValue, ICustomerLoyaltyAccount.class));
/*     */     }
/* 686 */     else if ("AwardAccounts".equals(argFieldId)) {
/* 687 */       setAwardAccounts(changeToList(argValue, IAwardAccount.class));
/*     */     }
/* 689 */     else if ("Properties".equals(argFieldId)) {
/* 690 */       setProperties(changeToList(argValue, ICustomerLoyaltyCardProperty.class));
/*     */     }
/* 692 */     else if ("CustomerLoyaltyCardExtension".equals(argFieldId)) {
/* 693 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 696 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 702 */     this._persistenceDefaults = argPD;
/* 703 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 704 */     this._eventManager = argEM;
/* 705 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 706 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 707 */     if (this._loyaltyAccounts != null) {
/* 708 */       for (ICustomerLoyaltyAccount relationship : this._loyaltyAccounts) {
/* 709 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 712 */     if (this._awardAccounts != null) {
/* 713 */       for (IAwardAccount relationship : this._awardAccounts) {
/* 714 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 717 */     if (this._properties != null) {
/* 718 */       for (ICustomerLoyaltyCardProperty relationship : this._properties) {
/* 719 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCustomerLoyaltyCardExt() {
/* 725 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCustomerLoyaltyCardExt(IDataModel argExt) {
/* 729 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 734 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 738 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 741 */     super.startTransaction();
/*     */     
/* 743 */     this._loyaltyAccountsSavepoint = this._loyaltyAccounts;
/* 744 */     if (this._loyaltyAccounts != null) {
/* 745 */       this._loyaltyAccountsSavepoint = new HistoricalList((List)this._loyaltyAccounts);
/* 746 */       Iterator<IDataModel> it = this._loyaltyAccounts.iterator();
/* 747 */       while (it.hasNext()) {
/* 748 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 752 */     this._awardAccountsSavepoint = this._awardAccounts;
/* 753 */     if (this._awardAccounts != null) {
/* 754 */       this._awardAccountsSavepoint = new HistoricalList((List)this._awardAccounts);
/* 755 */       Iterator<IDataModel> it = this._awardAccounts.iterator();
/* 756 */       while (it.hasNext()) {
/* 757 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 761 */     this._propertiesSavepoint = this._properties;
/* 762 */     if (this._properties != null) {
/* 763 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 764 */       Iterator<IDataModel> it = this._properties.iterator();
/* 765 */       while (it.hasNext()) {
/* 766 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 771 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 776 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 779 */     super.rollbackChanges();
/*     */     
/* 781 */     this._loyaltyAccounts = this._loyaltyAccountsSavepoint;
/* 782 */     this._loyaltyAccountsSavepoint = null;
/* 783 */     if (this._loyaltyAccounts != null) {
/* 784 */       Iterator<IDataModel> it = this._loyaltyAccounts.iterator();
/* 785 */       while (it.hasNext()) {
/* 786 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 790 */     this._awardAccounts = this._awardAccountsSavepoint;
/* 791 */     this._awardAccountsSavepoint = null;
/* 792 */     if (this._awardAccounts != null) {
/* 793 */       Iterator<IDataModel> it = this._awardAccounts.iterator();
/* 794 */       while (it.hasNext()) {
/* 795 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 799 */     this._properties = this._propertiesSavepoint;
/* 800 */     this._propertiesSavepoint = null;
/* 801 */     if (this._properties != null) {
/* 802 */       Iterator<IDataModel> it = this._properties.iterator();
/* 803 */       while (it.hasNext()) {
/* 804 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 812 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 815 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 818 */     super.commitTransaction();
/*     */     
/* 820 */     this._loyaltyAccountsSavepoint = this._loyaltyAccounts;
/* 821 */     if (this._loyaltyAccounts != null) {
/* 822 */       Iterator<IDataModel> it = this._loyaltyAccounts.iterator();
/* 823 */       while (it.hasNext()) {
/* 824 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 826 */       this._loyaltyAccounts = new HistoricalList((List)this._loyaltyAccounts);
/*     */     } 
/*     */     
/* 829 */     this._awardAccountsSavepoint = this._awardAccounts;
/* 830 */     if (this._awardAccounts != null) {
/* 831 */       Iterator<IDataModel> it = this._awardAccounts.iterator();
/* 832 */       while (it.hasNext()) {
/* 833 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 835 */       this._awardAccounts = new HistoricalList((List)this._awardAccounts);
/*     */     } 
/*     */     
/* 838 */     this._propertiesSavepoint = this._properties;
/* 839 */     if (this._properties != null) {
/* 840 */       Iterator<IDataModel> it = this._properties.iterator();
/* 841 */       while (it.hasNext()) {
/* 842 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 844 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 848 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerLoyaltyCardModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */