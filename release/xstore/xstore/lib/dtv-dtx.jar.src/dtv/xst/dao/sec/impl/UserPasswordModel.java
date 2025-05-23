/*     */ package dtv.xst.dao.sec.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
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
/*     */ import dtv.xst.dao.sec.IUserPassword;
/*     */ import dtv.xst.dao.sec.IUserPasswordProperty;
/*     */ import dtv.xst.dao.sec.IUserRole;
/*     */ import dtv.xst.dao.sec.UserPasswordPropertyId;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class UserPasswordModel extends UserPasswordBaseModel implements IUserPassword {
/*     */   private static final long serialVersionUID = 613376934L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private HistoricalList<IUserRole> _roleObjects; private transient HistoricalList<IUserRole> _roleObjectsSavepoint; private HistoricalList<IUserPasswordProperty> _properties; private transient HistoricalList<IUserPasswordProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new UserPasswordDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private UserPasswordDAO getDAO_() {
/*  47 */     return (UserPasswordDAO)this._daoImpl;
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
/*  71 */       this._events.post(IUserPassword.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  84 */       if (this._roleObjects != null) {
/*     */         
/*  86 */         Iterator<UserRoleModel> it = this._roleObjects.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((UserRoleModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  92 */       if (this._properties != null) {
/*     */         
/*  94 */         Iterator<UserPasswordPropertyModel> it = this._properties.iterator();
/*  95 */         while (it.hasNext())
/*     */         {
/*  97 */           ((UserPasswordPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getUser() {
/* 110 */     return getDAO_().getUser();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUser(String argUser) {
/* 118 */     if (setUser_noev(argUser) && 
/* 119 */       this._events != null && 
/* 120 */       postEventsForChanges()) {
/* 121 */       this._events.post(IUserPassword.SET_USER, argUser);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUser_noev(String argUser) {
/* 128 */     boolean ev_postable = false;
/*     */     
/* 130 */     if ((getDAO_().getUser() == null && argUser != null) || (
/* 131 */       getDAO_().getUser() != null && !getDAO_().getUser().equals(argUser))) {
/* 132 */       getDAO_().setUser(argUser);
/* 133 */       ev_postable = true;
/* 134 */       if (this._roleObjects != null) {
/*     */         
/* 136 */         Iterator<UserRoleModel> it = this._roleObjects.iterator();
/* 137 */         while (it.hasNext())
/*     */         {
/* 139 */           ((UserRoleModel)it.next()).setUser_noev(argUser);
/*     */         }
/*     */       } 
/* 142 */       if (this._properties != null) {
/*     */         
/* 144 */         Iterator<UserPasswordPropertyModel> it = this._properties.iterator();
/* 145 */         while (it.hasNext())
/*     */         {
/* 147 */           ((UserPasswordPropertyModel)it.next()).setUser_noev(argUser);
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
/*     */   public long getSequence() {
/* 160 */     if (getDAO_().getSequence() != null) {
/* 161 */       return getDAO_().getSequence().longValue();
/*     */     }
/*     */     
/* 164 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequence(long argSequence) {
/* 173 */     if (setSequence_noev(argSequence) && 
/* 174 */       this._events != null && 
/* 175 */       postEventsForChanges()) {
/* 176 */       this._events.post(IUserPassword.SET_SEQUENCE, Long.valueOf(argSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequence_noev(long argSequence) {
/* 183 */     boolean ev_postable = false;
/*     */     
/* 185 */     if ((getDAO_().getSequence() == null && Long.valueOf(argSequence) != null) || (
/* 186 */       getDAO_().getSequence() != null && !getDAO_().getSequence().equals(Long.valueOf(argSequence)))) {
/* 187 */       getDAO_().setSequence(Long.valueOf(argSequence));
/* 188 */       ev_postable = true;
/* 189 */       if (this._properties != null) {
/*     */         
/* 191 */         Iterator<UserPasswordPropertyModel> it = this._properties.iterator();
/* 192 */         while (it.hasNext())
/*     */         {
/* 194 */           ((UserPasswordPropertyModel)it.next()).setSequence_noev(argSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 199 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 207 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 215 */     if (setCreateDate_noev(argCreateDate) && 
/* 216 */       this._events != null && 
/* 217 */       postEventsForChanges()) {
/* 218 */       this._events.post(IUserPassword.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 225 */     boolean ev_postable = false;
/*     */     
/* 227 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 228 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 229 */       getDAO_().setCreateDate(argCreateDate);
/* 230 */       ev_postable = true;
/*     */     } 
/*     */     
/* 233 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 241 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 249 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 250 */       this._events != null && 
/* 251 */       postEventsForChanges()) {
/* 252 */       this._events.post(IUserPassword.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 259 */     boolean ev_postable = false;
/*     */     
/* 261 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 262 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 263 */       getDAO_().setCreateUserId(argCreateUserId);
/* 264 */       ev_postable = true;
/*     */     } 
/*     */     
/* 267 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 275 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 283 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 284 */       this._events != null && 
/* 285 */       postEventsForChanges()) {
/* 286 */       this._events.post(IUserPassword.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 293 */     boolean ev_postable = false;
/*     */     
/* 295 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 296 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 297 */       getDAO_().setUpdateDate(argUpdateDate);
/* 298 */       ev_postable = true;
/*     */     } 
/*     */     
/* 301 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 309 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 317 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 318 */       this._events != null && 
/* 319 */       postEventsForChanges()) {
/* 320 */       this._events.post(IUserPassword.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 327 */     boolean ev_postable = false;
/*     */     
/* 329 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 330 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 331 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 332 */       ev_postable = true;
/*     */     } 
/*     */     
/* 335 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHash() {
/* 343 */     return getDAO_().getHash();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHash(String argHash) {
/* 351 */     if (setHash_noev(argHash) && 
/* 352 */       this._events != null && 
/* 353 */       postEventsForChanges()) {
/* 354 */       this._events.post(IUserPassword.SET_HASH, argHash);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setHash_noev(String argHash) {
/* 361 */     boolean ev_postable = false;
/*     */     
/* 363 */     if ((getDAO_().getHash() == null && argHash != null) || (
/* 364 */       getDAO_().getHash() != null && !getDAO_().getHash().equals(argHash))) {
/* 365 */       getDAO_().setHash(argHash);
/* 366 */       ev_postable = true;
/*     */     } 
/*     */     
/* 369 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 377 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 385 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 386 */       this._events != null && 
/* 387 */       postEventsForChanges()) {
/* 388 */       this._events.post(IUserPassword.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 395 */     boolean ev_postable = false;
/*     */     
/* 397 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 398 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 399 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 400 */       ev_postable = true;
/*     */     } 
/*     */     
/* 403 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFailedAttempts() {
/* 411 */     if (getDAO_().getFailedAttempts() != null) {
/* 412 */       return getDAO_().getFailedAttempts().intValue();
/*     */     }
/*     */     
/* 415 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFailedAttempts(int argFailedAttempts) {
/* 424 */     if (setFailedAttempts_noev(argFailedAttempts) && 
/* 425 */       this._events != null && 
/* 426 */       postEventsForChanges()) {
/* 427 */       this._events.post(IUserPassword.SET_FAILEDATTEMPTS, Integer.valueOf(argFailedAttempts));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFailedAttempts_noev(int argFailedAttempts) {
/* 434 */     boolean ev_postable = false;
/*     */     
/* 436 */     if ((getDAO_().getFailedAttempts() == null && Integer.valueOf(argFailedAttempts) != null) || (
/* 437 */       getDAO_().getFailedAttempts() != null && !getDAO_().getFailedAttempts().equals(Integer.valueOf(argFailedAttempts)))) {
/* 438 */       getDAO_().setFailedAttempts(Integer.valueOf(argFailedAttempts));
/* 439 */       ev_postable = true;
/*     */     } 
/*     */     
/* 442 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getLockedOutTimeStamp() {
/* 450 */     return getDAO_().getLockedOutTimeStamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLockedOutTimeStamp(Date argLockedOutTimeStamp) {
/* 458 */     if (setLockedOutTimeStamp_noev(argLockedOutTimeStamp) && 
/* 459 */       this._events != null && 
/* 460 */       postEventsForChanges()) {
/* 461 */       this._events.post(IUserPassword.SET_LOCKEDOUTTIMESTAMP, argLockedOutTimeStamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLockedOutTimeStamp_noev(Date argLockedOutTimeStamp) {
/* 468 */     boolean ev_postable = false;
/*     */     
/* 470 */     if ((getDAO_().getLockedOutTimeStamp() == null && argLockedOutTimeStamp != null) || (
/* 471 */       getDAO_().getLockedOutTimeStamp() != null && !getDAO_().getLockedOutTimeStamp().equals(argLockedOutTimeStamp))) {
/* 472 */       getDAO_().setLockedOutTimeStamp(argLockedOutTimeStamp);
/* 473 */       ev_postable = true;
/*     */     } 
/*     */     
/* 476 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IUserPasswordProperty newProperty(String argPropertyName) {
/* 480 */     UserPasswordPropertyId id = new UserPasswordPropertyId();
/*     */     
/* 482 */     id.setUser(getUser());
/* 483 */     id.setSequence(Long.valueOf(getSequence()));
/* 484 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 486 */     IUserPasswordProperty prop = (IUserPasswordProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IUserPasswordProperty.class);
/* 487 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "RoleObjects")
/*     */   public List<IUserRole> getRoleObjects() {
/* 499 */     if (this._roleObjects == null) {
/* 500 */       this._roleObjects = new HistoricalList(null);
/*     */     }
/* 502 */     return (List<IUserRole>)this._roleObjects;
/*     */   }
/*     */   
/*     */   public void setRoleObjects(List<IUserRole> argRoleObjects) {
/* 506 */     if (this._roleObjects == null) {
/* 507 */       this._roleObjects = new HistoricalList(argRoleObjects);
/*     */     } else {
/* 509 */       this._roleObjects.setCurrentList(argRoleObjects);
/*     */     } 
/*     */     
/* 512 */     for (IUserRole child : this._roleObjects) {
/* 513 */       UserRoleModel model = (UserRoleModel)child;
/* 514 */       model.setUser_noev(getUser());
/* 515 */       model.setOrganizationId_noev(getOrganizationId());
/* 516 */       if (child instanceof IDataModelImpl) {
/* 517 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 518 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 519 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 520 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 523 */       if (postEventsForChanges()) {
/* 524 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addUserRole(IUserRole argUserRole) {
/* 530 */     if (this._roleObjects == null) {
/* 531 */       this._roleObjects = new HistoricalList(null);
/*     */     }
/* 533 */     argUserRole.setUser(getUser());
/* 534 */     argUserRole.setOrganizationId(getOrganizationId());
/* 535 */     if (argUserRole instanceof IDataModelImpl) {
/* 536 */       IDataAccessObject childDao = ((IDataModelImpl)argUserRole).getDAO();
/* 537 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 538 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 539 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 544 */     if (postEventsForChanges()) {
/* 545 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argUserRole));
/*     */     }
/*     */     
/* 548 */     this._roleObjects.add(argUserRole);
/* 549 */     if (postEventsForChanges()) {
/* 550 */       this._events.post(IUserPassword.ADD_ROLEOBJECTS, argUserRole);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeUserRole(IUserRole argUserRole) {
/* 555 */     if (this._roleObjects != null) {
/*     */       
/* 557 */       if (postEventsForChanges()) {
/* 558 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argUserRole));
/*     */       }
/* 560 */       this._roleObjects.remove(argUserRole);
/* 561 */       if (postEventsForChanges()) {
/* 562 */         this._events.post(IUserPassword.REMOVE_ROLEOBJECTS, argUserRole);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IUserPasswordProperty> getProperties() {
/* 569 */     if (this._properties == null) {
/* 570 */       this._properties = new HistoricalList(null);
/*     */     }
/* 572 */     return (List<IUserPasswordProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IUserPasswordProperty> argProperties) {
/* 576 */     if (this._properties == null) {
/* 577 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 579 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 582 */     for (IUserPasswordProperty child : this._properties) {
/* 583 */       UserPasswordPropertyModel model = (UserPasswordPropertyModel)child;
/* 584 */       model.setOrganizationId_noev(getOrganizationId());
/* 585 */       model.setUser_noev(getUser());
/* 586 */       model.setSequence_noev(getSequence());
/* 587 */       if (child instanceof IDataModelImpl) {
/* 588 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 589 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 590 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 591 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 594 */       if (postEventsForChanges()) {
/* 595 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addUserPasswordProperty(IUserPasswordProperty argUserPasswordProperty) {
/* 601 */     if (this._properties == null) {
/* 602 */       this._properties = new HistoricalList(null);
/*     */     }
/* 604 */     argUserPasswordProperty.setOrganizationId(getOrganizationId());
/* 605 */     argUserPasswordProperty.setUser(getUser());
/* 606 */     argUserPasswordProperty.setSequence(getSequence());
/* 607 */     if (argUserPasswordProperty instanceof IDataModelImpl) {
/* 608 */       IDataAccessObject childDao = ((IDataModelImpl)argUserPasswordProperty).getDAO();
/* 609 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 610 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 611 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 616 */     if (postEventsForChanges()) {
/* 617 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argUserPasswordProperty));
/*     */     }
/*     */     
/* 620 */     this._properties.add(argUserPasswordProperty);
/* 621 */     if (postEventsForChanges()) {
/* 622 */       this._events.post(IUserPassword.ADD_PROPERTIES, argUserPasswordProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeUserPasswordProperty(IUserPasswordProperty argUserPasswordProperty) {
/* 627 */     if (this._properties != null) {
/*     */       
/* 629 */       if (postEventsForChanges()) {
/* 630 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argUserPasswordProperty));
/*     */       }
/* 632 */       this._properties.remove(argUserPasswordProperty);
/* 633 */       if (postEventsForChanges()) {
/* 634 */         this._events.post(IUserPassword.REMOVE_PROPERTIES, argUserPasswordProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 641 */     if ("RoleObjects".equals(argFieldId)) {
/* 642 */       return getRoleObjects();
/*     */     }
/* 644 */     if ("Properties".equals(argFieldId)) {
/* 645 */       return getProperties();
/*     */     }
/* 647 */     if ("UserPasswordExtension".equals(argFieldId)) {
/* 648 */       return this._myExtension;
/*     */     }
/*     */     
/* 651 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 657 */     if ("RoleObjects".equals(argFieldId)) {
/* 658 */       setRoleObjects(changeToList(argValue, IUserRole.class));
/*     */     }
/* 660 */     else if ("Properties".equals(argFieldId)) {
/* 661 */       setProperties(changeToList(argValue, IUserPasswordProperty.class));
/*     */     }
/* 663 */     else if ("UserPasswordExtension".equals(argFieldId)) {
/* 664 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 667 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 673 */     this._persistenceDefaults = argPD;
/* 674 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 675 */     this._eventManager = argEM;
/* 676 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 677 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 678 */     if (this._roleObjects != null) {
/* 679 */       for (IUserRole relationship : this._roleObjects) {
/* 680 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 683 */     if (this._properties != null) {
/* 684 */       for (IUserPasswordProperty relationship : this._properties) {
/* 685 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getUserPasswordExt() {
/* 691 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setUserPasswordExt(IDataModel argExt) {
/* 695 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 700 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 704 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 707 */     super.startTransaction();
/*     */     
/* 709 */     this._roleObjectsSavepoint = this._roleObjects;
/* 710 */     if (this._roleObjects != null) {
/* 711 */       this._roleObjectsSavepoint = new HistoricalList((List)this._roleObjects);
/* 712 */       Iterator<IDataModel> it = this._roleObjects.iterator();
/* 713 */       while (it.hasNext()) {
/* 714 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 718 */     this._propertiesSavepoint = this._properties;
/* 719 */     if (this._properties != null) {
/* 720 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 721 */       Iterator<IDataModel> it = this._properties.iterator();
/* 722 */       while (it.hasNext()) {
/* 723 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 728 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 733 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 736 */     super.rollbackChanges();
/*     */     
/* 738 */     this._roleObjects = this._roleObjectsSavepoint;
/* 739 */     this._roleObjectsSavepoint = null;
/* 740 */     if (this._roleObjects != null) {
/* 741 */       Iterator<IDataModel> it = this._roleObjects.iterator();
/* 742 */       while (it.hasNext()) {
/* 743 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 747 */     this._properties = this._propertiesSavepoint;
/* 748 */     this._propertiesSavepoint = null;
/* 749 */     if (this._properties != null) {
/* 750 */       Iterator<IDataModel> it = this._properties.iterator();
/* 751 */       while (it.hasNext()) {
/* 752 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 760 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 763 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 766 */     super.commitTransaction();
/*     */     
/* 768 */     this._roleObjectsSavepoint = this._roleObjects;
/* 769 */     if (this._roleObjects != null) {
/* 770 */       Iterator<IDataModel> it = this._roleObjects.iterator();
/* 771 */       while (it.hasNext()) {
/* 772 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 774 */       this._roleObjects = new HistoricalList((List)this._roleObjects);
/*     */     } 
/*     */     
/* 777 */     this._propertiesSavepoint = this._properties;
/* 778 */     if (this._properties != null) {
/* 779 */       Iterator<IDataModel> it = this._properties.iterator();
/* 780 */       while (it.hasNext()) {
/* 781 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 783 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 787 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\UserPasswordModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */