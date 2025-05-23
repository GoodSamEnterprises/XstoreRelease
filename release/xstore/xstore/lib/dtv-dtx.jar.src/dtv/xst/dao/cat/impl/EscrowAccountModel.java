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
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.cat.EscrowAccountPropertyId;
/*     */ import dtv.xst.dao.cat.IEscrowAccount;
/*     */ import dtv.xst.dao.cat.IEscrowAccountActivity;
/*     */ import dtv.xst.dao.cat.IEscrowAccountProperty;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class EscrowAccountModel extends EscrowAccountBaseModel implements IEscrowAccount {
/*     */   private static final long serialVersionUID = -878204408L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private HistoricalList<IEscrowAccountActivity> _escrowAccountActivities; private transient HistoricalList<IEscrowAccountActivity> _escrowAccountActivitiesSavepoint; private HistoricalList<IEscrowAccountProperty> _properties; private transient HistoricalList<IEscrowAccountProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new EscrowAccountDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EscrowAccountDAO getDAO_() {
/*  47 */     return (EscrowAccountDAO)this._daoImpl;
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
/*  71 */       this._events.post(IEscrowAccount.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  84 */       if (this._escrowAccountActivities != null) {
/*     */         
/*  86 */         Iterator<EscrowAccountActivityModel> it = this._escrowAccountActivities.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((EscrowAccountActivityModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  92 */       if (this._properties != null) {
/*     */         
/*  94 */         Iterator<EscrowAccountPropertyModel> it = this._properties.iterator();
/*  95 */         while (it.hasNext())
/*     */         {
/*  97 */           ((EscrowAccountPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/* 110 */     return getDAO_().getCustAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 118 */     if (setCustAccountId_noev(argCustAccountId) && 
/* 119 */       this._events != null && 
/* 120 */       postEventsForChanges()) {
/* 121 */       this._events.post(IEscrowAccount.SET_CUSTACCOUNTID, argCustAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountId_noev(String argCustAccountId) {
/* 128 */     boolean ev_postable = false;
/*     */     
/* 130 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/* 131 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/* 132 */       getDAO_().setCustAccountId(argCustAccountId);
/* 133 */       ev_postable = true;
/* 134 */       if (this._escrowAccountActivities != null) {
/*     */         
/* 136 */         Iterator<EscrowAccountActivityModel> it = this._escrowAccountActivities.iterator();
/* 137 */         while (it.hasNext())
/*     */         {
/* 139 */           ((EscrowAccountActivityModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*     */         }
/*     */       } 
/* 142 */       if (this._properties != null) {
/*     */         
/* 144 */         Iterator<EscrowAccountPropertyModel> it = this._properties.iterator();
/* 145 */         while (it.hasNext())
/*     */         {
/* 147 */           ((EscrowAccountPropertyModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 152 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 160 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 168 */     if (setCreateDate_noev(argCreateDate) && 
/* 169 */       this._events != null && 
/* 170 */       postEventsForChanges()) {
/* 171 */       this._events.post(IEscrowAccount.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 178 */     boolean ev_postable = false;
/*     */     
/* 180 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 181 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 182 */       getDAO_().setCreateDate(argCreateDate);
/* 183 */       ev_postable = true;
/*     */     } 
/*     */     
/* 186 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 194 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 202 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 203 */       this._events != null && 
/* 204 */       postEventsForChanges()) {
/* 205 */       this._events.post(IEscrowAccount.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 212 */     boolean ev_postable = false;
/*     */     
/* 214 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 215 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 216 */       getDAO_().setCreateUserId(argCreateUserId);
/* 217 */       ev_postable = true;
/*     */     } 
/*     */     
/* 220 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 228 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 236 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 237 */       this._events != null && 
/* 238 */       postEventsForChanges()) {
/* 239 */       this._events.post(IEscrowAccount.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 246 */     boolean ev_postable = false;
/*     */     
/* 248 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 249 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 250 */       getDAO_().setUpdateDate(argUpdateDate);
/* 251 */       ev_postable = true;
/*     */     } 
/*     */     
/* 254 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 262 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 270 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 271 */       this._events != null && 
/* 272 */       postEventsForChanges()) {
/* 273 */       this._events.post(IEscrowAccount.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 280 */     boolean ev_postable = false;
/*     */     
/* 282 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 283 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 284 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 285 */       ev_postable = true;
/*     */     } 
/*     */     
/* 288 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAccountBalance() {
/* 296 */     return getDAO_().getAccountBalance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountBalance(BigDecimal argAccountBalance) {
/* 304 */     if (setAccountBalance_noev(argAccountBalance) && 
/* 305 */       this._events != null && 
/* 306 */       postEventsForChanges()) {
/* 307 */       this._events.post(IEscrowAccount.SET_ACCOUNTBALANCE, argAccountBalance);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountBalance_noev(BigDecimal argAccountBalance) {
/* 314 */     boolean ev_postable = false;
/*     */     
/* 316 */     if ((getDAO_().getAccountBalance() == null && argAccountBalance != null) || (
/* 317 */       getDAO_().getAccountBalance() != null && !getDAO_().getAccountBalance().equals(argAccountBalance))) {
/* 318 */       getDAO_().setAccountBalance(argAccountBalance);
/* 319 */       ev_postable = true;
/*     */     } 
/*     */     
/* 322 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountStateCode() {
/* 330 */     return getDAO_().getCustAccountStateCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountStateCode(String argCustAccountStateCode) {
/* 338 */     if (setCustAccountStateCode_noev(argCustAccountStateCode) && 
/* 339 */       this._events != null && 
/* 340 */       postEventsForChanges()) {
/* 341 */       this._events.post(IEscrowAccount.SET_CUSTACCOUNTSTATECODE, argCustAccountStateCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountStateCode_noev(String argCustAccountStateCode) {
/* 348 */     boolean ev_postable = false;
/*     */     
/* 350 */     if ((getDAO_().getCustAccountStateCode() == null && argCustAccountStateCode != null) || (
/* 351 */       getDAO_().getCustAccountStateCode() != null && !getDAO_().getCustAccountStateCode().equals(argCustAccountStateCode))) {
/* 352 */       getDAO_().setCustAccountStateCode(argCustAccountStateCode);
/* 353 */       ev_postable = true;
/*     */     } 
/*     */     
/* 356 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getAccountSetupDate() {
/* 364 */     return getDAO_().getAccountSetupDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountSetupDate(Date argAccountSetupDate) {
/* 372 */     if (setAccountSetupDate_noev(argAccountSetupDate) && 
/* 373 */       this._events != null && 
/* 374 */       postEventsForChanges()) {
/* 375 */       this._events.post(IEscrowAccount.SET_ACCOUNTSETUPDATE, argAccountSetupDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountSetupDate_noev(Date argAccountSetupDate) {
/* 382 */     boolean ev_postable = false;
/*     */     
/* 384 */     if ((getDAO_().getAccountSetupDate() == null && argAccountSetupDate != null) || (
/* 385 */       getDAO_().getAccountSetupDate() != null && !getDAO_().getAccountSetupDate().equals(argAccountSetupDate))) {
/* 386 */       getDAO_().setAccountSetupDate(argAccountSetupDate);
/* 387 */       ev_postable = true;
/*     */     } 
/*     */     
/* 390 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getLastActivityDate() {
/* 398 */     return getDAO_().getLastActivityDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastActivityDate(Date argLastActivityDate) {
/* 406 */     if (setLastActivityDate_noev(argLastActivityDate) && 
/* 407 */       this._events != null && 
/* 408 */       postEventsForChanges()) {
/* 409 */       this._events.post(IEscrowAccount.SET_LASTACTIVITYDATE, argLastActivityDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLastActivityDate_noev(Date argLastActivityDate) {
/* 416 */     boolean ev_postable = false;
/*     */     
/* 418 */     if ((getDAO_().getLastActivityDate() == null && argLastActivityDate != null) || (
/* 419 */       getDAO_().getLastActivityDate() != null && !getDAO_().getLastActivityDate().equals(argLastActivityDate))) {
/* 420 */       getDAO_().setLastActivityDate(argLastActivityDate);
/* 421 */       ev_postable = true;
/*     */     } 
/*     */     
/* 424 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPartyId() {
/* 432 */     if (getDAO_().getPartyId() != null) {
/* 433 */       return getDAO_().getPartyId().longValue();
/*     */     }
/*     */     
/* 436 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPartyId(long argPartyId) {
/* 445 */     if (setPartyId_noev(argPartyId) && 
/* 446 */       this._events != null && 
/* 447 */       postEventsForChanges()) {
/* 448 */       this._events.post(IEscrowAccount.SET_PARTYID, Long.valueOf(argPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPartyId_noev(long argPartyId) {
/* 455 */     boolean ev_postable = false;
/*     */     
/* 457 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/* 458 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/* 459 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/* 460 */       ev_postable = true;
/*     */     } 
/*     */     
/* 463 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IEscrowAccountProperty newProperty(String argPropertyName) {
/* 467 */     EscrowAccountPropertyId id = new EscrowAccountPropertyId();
/*     */     
/* 469 */     id.setCustAccountId(getCustAccountId());
/* 470 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 472 */     IEscrowAccountProperty prop = (IEscrowAccountProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IEscrowAccountProperty.class);
/* 473 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "EscrowAccountActivities")
/*     */   public List<IEscrowAccountActivity> getEscrowAccountActivities() {
/* 485 */     if (this._escrowAccountActivities == null) {
/* 486 */       this._escrowAccountActivities = new HistoricalList(null);
/*     */     }
/* 488 */     return (List<IEscrowAccountActivity>)this._escrowAccountActivities;
/*     */   }
/*     */   
/*     */   public void setEscrowAccountActivities(List<IEscrowAccountActivity> argEscrowAccountActivities) {
/* 492 */     if (this._escrowAccountActivities == null) {
/* 493 */       this._escrowAccountActivities = new HistoricalList(argEscrowAccountActivities);
/*     */     } else {
/* 495 */       this._escrowAccountActivities.setCurrentList(argEscrowAccountActivities);
/*     */     } 
/*     */     
/* 498 */     for (IEscrowAccountActivity child : this._escrowAccountActivities) {
/* 499 */       EscrowAccountActivityModel model = (EscrowAccountActivityModel)child;
/* 500 */       model.setOrganizationId_noev(getOrganizationId());
/* 501 */       model.setCustAccountId_noev(getCustAccountId());
/* 502 */       if (child instanceof IDataModelImpl) {
/* 503 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 504 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 505 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 506 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 509 */       if (postEventsForChanges()) {
/* 510 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addEscrowAccountActivity(IEscrowAccountActivity argEscrowAccountActivity) {
/* 516 */     super.addEscrowAccountActivity(argEscrowAccountActivity);
/*     */     
/* 518 */     if (this._escrowAccountActivities == null) {
/* 519 */       this._escrowAccountActivities = new HistoricalList(null);
/*     */     }
/* 521 */     argEscrowAccountActivity.setOrganizationId(getOrganizationId());
/* 522 */     argEscrowAccountActivity.setCustAccountId(getCustAccountId());
/* 523 */     if (argEscrowAccountActivity instanceof IDataModelImpl) {
/* 524 */       IDataAccessObject childDao = ((IDataModelImpl)argEscrowAccountActivity).getDAO();
/* 525 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 526 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 527 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 532 */     if (postEventsForChanges()) {
/* 533 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEscrowAccountActivity));
/*     */     }
/*     */     
/* 536 */     this._escrowAccountActivities.add(argEscrowAccountActivity);
/* 537 */     if (postEventsForChanges()) {
/* 538 */       this._events.post(IEscrowAccount.ADD_ESCROWACCOUNTACTIVITIES, argEscrowAccountActivity);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeEscrowAccountActivity(IEscrowAccountActivity argEscrowAccountActivity) {
/* 543 */     if (this._escrowAccountActivities != null) {
/*     */       
/* 545 */       if (postEventsForChanges()) {
/* 546 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEscrowAccountActivity));
/*     */       }
/* 548 */       this._escrowAccountActivities.remove(argEscrowAccountActivity);
/* 549 */       if (postEventsForChanges()) {
/* 550 */         this._events.post(IEscrowAccount.REMOVE_ESCROWACCOUNTACTIVITIES, argEscrowAccountActivity);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IEscrowAccountProperty> getProperties() {
/* 557 */     if (this._properties == null) {
/* 558 */       this._properties = new HistoricalList(null);
/*     */     }
/* 560 */     return (List<IEscrowAccountProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IEscrowAccountProperty> argProperties) {
/* 564 */     if (this._properties == null) {
/* 565 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 567 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 570 */     for (IEscrowAccountProperty child : this._properties) {
/* 571 */       EscrowAccountPropertyModel model = (EscrowAccountPropertyModel)child;
/* 572 */       model.setOrganizationId_noev(getOrganizationId());
/* 573 */       model.setCustAccountId_noev(getCustAccountId());
/* 574 */       if (child instanceof IDataModelImpl) {
/* 575 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 576 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 577 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 578 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 581 */       if (postEventsForChanges()) {
/* 582 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addEscrowAccountProperty(IEscrowAccountProperty argEscrowAccountProperty) {
/* 588 */     if (this._properties == null) {
/* 589 */       this._properties = new HistoricalList(null);
/*     */     }
/* 591 */     argEscrowAccountProperty.setOrganizationId(getOrganizationId());
/* 592 */     argEscrowAccountProperty.setCustAccountId(getCustAccountId());
/* 593 */     if (argEscrowAccountProperty instanceof IDataModelImpl) {
/* 594 */       IDataAccessObject childDao = ((IDataModelImpl)argEscrowAccountProperty).getDAO();
/* 595 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 596 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 597 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 602 */     if (postEventsForChanges()) {
/* 603 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEscrowAccountProperty));
/*     */     }
/*     */     
/* 606 */     this._properties.add(argEscrowAccountProperty);
/* 607 */     if (postEventsForChanges()) {
/* 608 */       this._events.post(IEscrowAccount.ADD_PROPERTIES, argEscrowAccountProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeEscrowAccountProperty(IEscrowAccountProperty argEscrowAccountProperty) {
/* 613 */     if (this._properties != null) {
/*     */       
/* 615 */       if (postEventsForChanges()) {
/* 616 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEscrowAccountProperty));
/*     */       }
/* 618 */       this._properties.remove(argEscrowAccountProperty);
/* 619 */       if (postEventsForChanges()) {
/* 620 */         this._events.post(IEscrowAccount.REMOVE_PROPERTIES, argEscrowAccountProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 627 */     if ("EscrowAccountActivities".equals(argFieldId)) {
/* 628 */       return getEscrowAccountActivities();
/*     */     }
/* 630 */     if ("Properties".equals(argFieldId)) {
/* 631 */       return getProperties();
/*     */     }
/* 633 */     if ("EscrowAccountExtension".equals(argFieldId)) {
/* 634 */       return this._myExtension;
/*     */     }
/*     */     
/* 637 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 643 */     if ("EscrowAccountActivities".equals(argFieldId)) {
/* 644 */       setEscrowAccountActivities(changeToList(argValue, IEscrowAccountActivity.class));
/*     */     }
/* 646 */     else if ("Properties".equals(argFieldId)) {
/* 647 */       setProperties(changeToList(argValue, IEscrowAccountProperty.class));
/*     */     }
/* 649 */     else if ("EscrowAccountExtension".equals(argFieldId)) {
/* 650 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 653 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 659 */     this._persistenceDefaults = argPD;
/* 660 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 661 */     this._eventManager = argEM;
/* 662 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 663 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 664 */     if (this._escrowAccountActivities != null) {
/* 665 */       for (IEscrowAccountActivity relationship : this._escrowAccountActivities) {
/* 666 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 669 */     if (this._properties != null) {
/* 670 */       for (IEscrowAccountProperty relationship : this._properties) {
/* 671 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getEscrowAccountExt() {
/* 677 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setEscrowAccountExt(IDataModel argExt) {
/* 681 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 686 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 690 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 693 */     super.startTransaction();
/*     */     
/* 695 */     this._escrowAccountActivitiesSavepoint = this._escrowAccountActivities;
/* 696 */     if (this._escrowAccountActivities != null) {
/* 697 */       this._escrowAccountActivitiesSavepoint = new HistoricalList((List)this._escrowAccountActivities);
/* 698 */       Iterator<IDataModel> it = this._escrowAccountActivities.iterator();
/* 699 */       while (it.hasNext()) {
/* 700 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 704 */     this._propertiesSavepoint = this._properties;
/* 705 */     if (this._properties != null) {
/* 706 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 707 */       Iterator<IDataModel> it = this._properties.iterator();
/* 708 */       while (it.hasNext()) {
/* 709 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 714 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 719 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 722 */     super.rollbackChanges();
/*     */     
/* 724 */     this._escrowAccountActivities = this._escrowAccountActivitiesSavepoint;
/* 725 */     this._escrowAccountActivitiesSavepoint = null;
/* 726 */     if (this._escrowAccountActivities != null) {
/* 727 */       Iterator<IDataModel> it = this._escrowAccountActivities.iterator();
/* 728 */       while (it.hasNext()) {
/* 729 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 733 */     this._properties = this._propertiesSavepoint;
/* 734 */     this._propertiesSavepoint = null;
/* 735 */     if (this._properties != null) {
/* 736 */       Iterator<IDataModel> it = this._properties.iterator();
/* 737 */       while (it.hasNext()) {
/* 738 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 746 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 749 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 752 */     super.commitTransaction();
/*     */     
/* 754 */     this._escrowAccountActivitiesSavepoint = this._escrowAccountActivities;
/* 755 */     if (this._escrowAccountActivities != null) {
/* 756 */       Iterator<IDataModel> it = this._escrowAccountActivities.iterator();
/* 757 */       while (it.hasNext()) {
/* 758 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 760 */       this._escrowAccountActivities = new HistoricalList((List)this._escrowAccountActivities);
/*     */     } 
/*     */     
/* 763 */     this._propertiesSavepoint = this._properties;
/* 764 */     if (this._properties != null) {
/* 765 */       Iterator<IDataModel> it = this._properties.iterator();
/* 766 */       while (it.hasNext()) {
/* 767 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 769 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 773 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\EscrowAccountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */