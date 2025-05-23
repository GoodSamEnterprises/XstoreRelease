/*     */ package dtv.xst.dao.hrs.impl;
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
/*     */ import dtv.xst.dao.hrs.EmployeePasswordPropertyId;
/*     */ import dtv.xst.dao.hrs.IEmployeePassword;
/*     */ import dtv.xst.dao.hrs.IEmployeePasswordProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class EmployeePasswordModel extends AbstractDataModelWithPropertyImpl<IEmployeePasswordProperty> implements IEmployeePassword {
/*     */   private static final long serialVersionUID = 1636350857L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IEmployeePasswordProperty> _properties; private transient HistoricalList<IEmployeePasswordProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new EmployeePasswordDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EmployeePasswordDAO getDAO_() {
/*  46 */     return (EmployeePasswordDAO)this._daoImpl;
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
/*  70 */       this._events.post(IEmployeePassword.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<EmployeePasswordPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((EmployeePasswordPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getEmployeeId() {
/* 101 */     return getDAO_().getEmployeeId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/* 109 */     if (setEmployeeId_noev(argEmployeeId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IEmployeePassword.SET_EMPLOYEEID, argEmployeeId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEmployeeId_noev(String argEmployeeId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getEmployeeId() == null && argEmployeeId != null) || (
/* 122 */       getDAO_().getEmployeeId() != null && !getDAO_().getEmployeeId().equals(argEmployeeId))) {
/* 123 */       getDAO_().setEmployeeId(argEmployeeId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<EmployeePasswordPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((EmployeePasswordPropertyModel)it.next()).setEmployeeId_noev(argEmployeeId);
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
/*     */   public int getSequence() {
/* 143 */     if (getDAO_().getSequence() != null) {
/* 144 */       return getDAO_().getSequence().intValue();
/*     */     }
/*     */     
/* 147 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequence(int argSequence) {
/* 156 */     if (setSequence_noev(argSequence) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IEmployeePassword.SET_SEQUENCE, Integer.valueOf(argSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequence_noev(int argSequence) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getSequence() == null && Integer.valueOf(argSequence) != null) || (
/* 169 */       getDAO_().getSequence() != null && !getDAO_().getSequence().equals(Integer.valueOf(argSequence)))) {
/* 170 */       getDAO_().setSequence(Integer.valueOf(argSequence));
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<EmployeePasswordPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((EmployeePasswordPropertyModel)it.next()).setSequence_noev(argSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 190 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 198 */     if (setCreateDate_noev(argCreateDate) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(IEmployeePassword.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 211 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 212 */       getDAO_().setCreateDate(argCreateDate);
/* 213 */       ev_postable = true;
/*     */     } 
/*     */     
/* 216 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 224 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 232 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 233 */       this._events != null && 
/* 234 */       postEventsForChanges()) {
/* 235 */       this._events.post(IEmployeePassword.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 242 */     boolean ev_postable = false;
/*     */     
/* 244 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 245 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 246 */       getDAO_().setCreateUserId(argCreateUserId);
/* 247 */       ev_postable = true;
/*     */     } 
/*     */     
/* 250 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 258 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 266 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 267 */       this._events != null && 
/* 268 */       postEventsForChanges()) {
/* 269 */       this._events.post(IEmployeePassword.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 276 */     boolean ev_postable = false;
/*     */     
/* 278 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 279 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 280 */       getDAO_().setUpdateDate(argUpdateDate);
/* 281 */       ev_postable = true;
/*     */     } 
/*     */     
/* 284 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 292 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 300 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 301 */       this._events != null && 
/* 302 */       postEventsForChanges()) {
/* 303 */       this._events.post(IEmployeePassword.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 310 */     boolean ev_postable = false;
/*     */     
/* 312 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 313 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 314 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 315 */       ev_postable = true;
/*     */     } 
/*     */     
/* 318 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPassword() {
/* 326 */     return getDAO_().getPassword();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPassword(String argPassword) {
/* 334 */     if (setPassword_noev(argPassword) && 
/* 335 */       this._events != null && 
/* 336 */       postEventsForChanges()) {
/* 337 */       this._events.post(IEmployeePassword.SET_PASSWORD, argPassword);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPassword_noev(String argPassword) {
/* 344 */     boolean ev_postable = false;
/*     */     
/* 346 */     if ((getDAO_().getPassword() == null && argPassword != null) || (
/* 347 */       getDAO_().getPassword() != null && !getDAO_().getPassword().equals(argPassword))) {
/* 348 */       getDAO_().setPassword(argPassword);
/* 349 */       ev_postable = true;
/*     */     } 
/*     */     
/* 352 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 360 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 368 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 369 */       this._events != null && 
/* 370 */       postEventsForChanges()) {
/* 371 */       this._events.post(IEmployeePassword.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 378 */     boolean ev_postable = false;
/*     */     
/* 380 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 381 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 382 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 383 */       ev_postable = true;
/*     */     } 
/*     */     
/* 386 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getTemporary() {
/* 394 */     if (getDAO_().getTemporary() != null) {
/* 395 */       return getDAO_().getTemporary().booleanValue();
/*     */     }
/*     */     
/* 398 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTemporary(boolean argTemporary) {
/* 407 */     if (setTemporary_noev(argTemporary) && 
/* 408 */       this._events != null && 
/* 409 */       postEventsForChanges()) {
/* 410 */       this._events.post(IEmployeePassword.SET_TEMPORARY, Boolean.valueOf(argTemporary));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTemporary_noev(boolean argTemporary) {
/* 417 */     boolean ev_postable = false;
/*     */     
/* 419 */     if ((getDAO_().getTemporary() == null && Boolean.valueOf(argTemporary) != null) || (
/* 420 */       getDAO_().getTemporary() != null && !getDAO_().getTemporary().equals(Boolean.valueOf(argTemporary)))) {
/* 421 */       getDAO_().setTemporary(Boolean.valueOf(argTemporary));
/* 422 */       ev_postable = true;
/*     */     } 
/*     */     
/* 425 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCurrent() {
/* 433 */     if (getDAO_().getCurrent() != null) {
/* 434 */       return getDAO_().getCurrent().booleanValue();
/*     */     }
/*     */     
/* 437 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrent(boolean argCurrent) {
/* 446 */     if (setCurrent_noev(argCurrent) && 
/* 447 */       this._events != null && 
/* 448 */       postEventsForChanges()) {
/* 449 */       this._events.post(IEmployeePassword.SET_CURRENT, Boolean.valueOf(argCurrent));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCurrent_noev(boolean argCurrent) {
/* 456 */     boolean ev_postable = false;
/*     */     
/* 458 */     if ((getDAO_().getCurrent() == null && Boolean.valueOf(argCurrent) != null) || (
/* 459 */       getDAO_().getCurrent() != null && !getDAO_().getCurrent().equals(Boolean.valueOf(argCurrent)))) {
/* 460 */       getDAO_().setCurrent(Boolean.valueOf(argCurrent));
/* 461 */       ev_postable = true;
/*     */     } 
/*     */     
/* 464 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IEmployeePasswordProperty newProperty(String argPropertyName) {
/* 468 */     EmployeePasswordPropertyId id = new EmployeePasswordPropertyId();
/*     */     
/* 470 */     id.setEmployeeId(getEmployeeId());
/* 471 */     id.setSequence(Integer.valueOf(getSequence()));
/* 472 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 474 */     IEmployeePasswordProperty prop = (IEmployeePasswordProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IEmployeePasswordProperty.class);
/* 475 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IEmployeePasswordProperty> getProperties() {
/* 484 */     if (this._properties == null) {
/* 485 */       this._properties = new HistoricalList(null);
/*     */     }
/* 487 */     return (List<IEmployeePasswordProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IEmployeePasswordProperty> argProperties) {
/* 491 */     if (this._properties == null) {
/* 492 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 494 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 497 */     for (IEmployeePasswordProperty child : this._properties) {
/* 498 */       EmployeePasswordPropertyModel model = (EmployeePasswordPropertyModel)child;
/* 499 */       model.setOrganizationId_noev(getOrganizationId());
/* 500 */       model.setEmployeeId_noev(getEmployeeId());
/* 501 */       model.setSequence_noev(getSequence());
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
/*     */   public void addEmployeePasswordProperty(IEmployeePasswordProperty argEmployeePasswordProperty) {
/* 516 */     if (this._properties == null) {
/* 517 */       this._properties = new HistoricalList(null);
/*     */     }
/* 519 */     argEmployeePasswordProperty.setOrganizationId(getOrganizationId());
/* 520 */     argEmployeePasswordProperty.setEmployeeId(getEmployeeId());
/* 521 */     argEmployeePasswordProperty.setSequence(getSequence());
/* 522 */     if (argEmployeePasswordProperty instanceof IDataModelImpl) {
/* 523 */       IDataAccessObject childDao = ((IDataModelImpl)argEmployeePasswordProperty).getDAO();
/* 524 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 525 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 526 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 531 */     if (postEventsForChanges()) {
/* 532 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeePasswordProperty));
/*     */     }
/*     */     
/* 535 */     this._properties.add(argEmployeePasswordProperty);
/* 536 */     if (postEventsForChanges()) {
/* 537 */       this._events.post(IEmployeePassword.ADD_PROPERTIES, argEmployeePasswordProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeEmployeePasswordProperty(IEmployeePasswordProperty argEmployeePasswordProperty) {
/* 542 */     if (this._properties != null) {
/*     */       
/* 544 */       if (postEventsForChanges()) {
/* 545 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeePasswordProperty));
/*     */       }
/* 547 */       this._properties.remove(argEmployeePasswordProperty);
/* 548 */       if (postEventsForChanges()) {
/* 549 */         this._events.post(IEmployeePassword.REMOVE_PROPERTIES, argEmployeePasswordProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 556 */     if ("Properties".equals(argFieldId)) {
/* 557 */       return getProperties();
/*     */     }
/* 559 */     if ("EmployeePasswordExtension".equals(argFieldId)) {
/* 560 */       return this._myExtension;
/*     */     }
/*     */     
/* 563 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 569 */     if ("Properties".equals(argFieldId)) {
/* 570 */       setProperties(changeToList(argValue, IEmployeePasswordProperty.class));
/*     */     }
/* 572 */     else if ("EmployeePasswordExtension".equals(argFieldId)) {
/* 573 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 576 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 582 */     this._persistenceDefaults = argPD;
/* 583 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 584 */     this._eventManager = argEM;
/* 585 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 586 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 587 */     if (this._properties != null) {
/* 588 */       for (IEmployeePasswordProperty relationship : this._properties) {
/* 589 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getEmployeePasswordExt() {
/* 595 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setEmployeePasswordExt(IDataModel argExt) {
/* 599 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 604 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 608 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 611 */     super.startTransaction();
/*     */     
/* 613 */     this._propertiesSavepoint = this._properties;
/* 614 */     if (this._properties != null) {
/* 615 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 616 */       Iterator<IDataModel> it = this._properties.iterator();
/* 617 */       while (it.hasNext()) {
/* 618 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 623 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 628 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 631 */     super.rollbackChanges();
/*     */     
/* 633 */     this._properties = this._propertiesSavepoint;
/* 634 */     this._propertiesSavepoint = null;
/* 635 */     if (this._properties != null) {
/* 636 */       Iterator<IDataModel> it = this._properties.iterator();
/* 637 */       while (it.hasNext()) {
/* 638 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 646 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 649 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 652 */     super.commitTransaction();
/*     */     
/* 654 */     this._propertiesSavepoint = this._properties;
/* 655 */     if (this._properties != null) {
/* 656 */       Iterator<IDataModel> it = this._properties.iterator();
/* 657 */       while (it.hasNext()) {
/* 658 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 660 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 664 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 669 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeePasswordModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */