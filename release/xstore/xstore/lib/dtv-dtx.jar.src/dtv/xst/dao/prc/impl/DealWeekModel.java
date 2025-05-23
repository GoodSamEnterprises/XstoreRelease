/*     */ package dtv.xst.dao.prc.impl;
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
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.prc.DealWeekPropertyId;
/*     */ import dtv.xst.dao.prc.IDealWeek;
/*     */ import dtv.xst.dao.prc.IDealWeekProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DealWeekModel extends AbstractDataModelWithPropertyImpl<IDealWeekProperty> implements IDealWeek {
/*     */   private static final long serialVersionUID = 575037088L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IDealWeekProperty> _properties; private transient HistoricalList<IDealWeekProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new DealWeekDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DealWeekDAO getDAO_() {
/*  46 */     return (DealWeekDAO)this._daoImpl;
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
/*  70 */       this._events.post(IDealWeek.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<DealWeekPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((DealWeekPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getDealId() {
/* 101 */     return getDAO_().getDealId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDealId(String argDealId) {
/* 109 */     if (setDealId_noev(argDealId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IDealWeek.SET_DEALID, argDealId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDealId_noev(String argDealId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getDealId() == null && argDealId != null) || (
/* 122 */       getDAO_().getDealId() != null && !getDAO_().getDealId().equals(argDealId))) {
/* 123 */       getDAO_().setDealId(argDealId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<DealWeekPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((DealWeekPropertyModel)it.next()).setDealId_noev(argDealId);
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
/*     */   public String getDayCode() {
/* 143 */     return getDAO_().getDayCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDayCode(String argDayCode) {
/* 151 */     if (setDayCode_noev(argDayCode) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IDealWeek.SET_DAYCODE, argDayCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDayCode_noev(String argDayCode) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getDayCode() == null && argDayCode != null) || (
/* 164 */       getDAO_().getDayCode() != null && !getDAO_().getDayCode().equals(argDayCode))) {
/* 165 */       getDAO_().setDayCode(argDayCode);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<DealWeekPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((DealWeekPropertyModel)it.next()).setDayCode_noev(argDayCode);
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
/*     */   public Date getStartTime() {
/* 185 */     return getDAO_().getStartTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/* 193 */     if (setStartTime_noev(argStartTime) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IDealWeek.SET_STARTTIME, argStartTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStartTime_noev(Date argStartTime) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getStartTime() == null && argStartTime != null) || (
/* 206 */       getDAO_().getStartTime() != null && !getDAO_().getStartTime().equals(argStartTime))) {
/* 207 */       getDAO_().setStartTime(argStartTime);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<DealWeekPropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((DealWeekPropertyModel)it.next()).setStartTime_noev(argStartTime);
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
/*     */   public String getOrgCode() {
/* 227 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 235 */     if (setOrgCode_noev(argOrgCode) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(IDealWeek.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 248 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 249 */       getDAO_().setOrgCode(argOrgCode);
/* 250 */       ev_postable = true;
/*     */     } 
/*     */     
/* 253 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 261 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 269 */     if (setOrgValue_noev(argOrgValue) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(IDealWeek.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 282 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 283 */       getDAO_().setOrgValue(argOrgValue);
/* 284 */       ev_postable = true;
/*     */     } 
/*     */     
/* 287 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 295 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 303 */     if (setCreateDate_noev(argCreateDate) && 
/* 304 */       this._events != null && 
/* 305 */       postEventsForChanges()) {
/* 306 */       this._events.post(IDealWeek.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 313 */     boolean ev_postable = false;
/*     */     
/* 315 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 316 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 317 */       getDAO_().setCreateDate(argCreateDate);
/* 318 */       ev_postable = true;
/*     */     } 
/*     */     
/* 321 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 329 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 337 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 338 */       this._events != null && 
/* 339 */       postEventsForChanges()) {
/* 340 */       this._events.post(IDealWeek.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 347 */     boolean ev_postable = false;
/*     */     
/* 349 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 350 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 351 */       getDAO_().setCreateUserId(argCreateUserId);
/* 352 */       ev_postable = true;
/*     */     } 
/*     */     
/* 355 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 363 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 371 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 372 */       this._events != null && 
/* 373 */       postEventsForChanges()) {
/* 374 */       this._events.post(IDealWeek.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 381 */     boolean ev_postable = false;
/*     */     
/* 383 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 384 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 385 */       getDAO_().setUpdateDate(argUpdateDate);
/* 386 */       ev_postable = true;
/*     */     } 
/*     */     
/* 389 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 397 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 405 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 406 */       this._events != null && 
/* 407 */       postEventsForChanges()) {
/* 408 */       this._events.post(IDealWeek.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 415 */     boolean ev_postable = false;
/*     */     
/* 417 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 418 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 419 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 420 */       ev_postable = true;
/*     */     } 
/*     */     
/* 423 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndTime() {
/* 431 */     return getDAO_().getEndTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndTime(Date argEndTime) {
/* 439 */     if (setEndTime_noev(argEndTime) && 
/* 440 */       this._events != null && 
/* 441 */       postEventsForChanges()) {
/* 442 */       this._events.post(IDealWeek.SET_ENDTIME, argEndTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEndTime_noev(Date argEndTime) {
/* 449 */     boolean ev_postable = false;
/*     */     
/* 451 */     if ((getDAO_().getEndTime() == null && argEndTime != null) || (
/* 452 */       getDAO_().getEndTime() != null && !getDAO_().getEndTime().equals(argEndTime))) {
/* 453 */       getDAO_().setEndTime(argEndTime);
/* 454 */       ev_postable = true;
/*     */     } 
/*     */     
/* 457 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDealWeekProperty newProperty(String argPropertyName) {
/* 461 */     DealWeekPropertyId id = new DealWeekPropertyId();
/*     */     
/* 463 */     id.setDealId(getDealId());
/* 464 */     id.setDayCode(getDayCode());
/* 465 */     id.setStartTime(getStartTime());
/* 466 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 468 */     IDealWeekProperty prop = (IDealWeekProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDealWeekProperty.class);
/* 469 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDealWeekProperty> getProperties() {
/* 478 */     if (this._properties == null) {
/* 479 */       this._properties = new HistoricalList(null);
/*     */     }
/* 481 */     return (List<IDealWeekProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDealWeekProperty> argProperties) {
/* 485 */     if (this._properties == null) {
/* 486 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 488 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 491 */     for (IDealWeekProperty child : this._properties) {
/* 492 */       DealWeekPropertyModel model = (DealWeekPropertyModel)child;
/* 493 */       model.setOrganizationId_noev(getOrganizationId());
/* 494 */       model.setDealId_noev(getDealId());
/* 495 */       model.setDayCode_noev(getDayCode());
/* 496 */       model.setStartTime_noev(getStartTime());
/* 497 */       if (child instanceof IDataModelImpl) {
/* 498 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 499 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 500 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 501 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 504 */       if (postEventsForChanges()) {
/* 505 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDealWeekProperty(IDealWeekProperty argDealWeekProperty) {
/* 511 */     if (this._properties == null) {
/* 512 */       this._properties = new HistoricalList(null);
/*     */     }
/* 514 */     argDealWeekProperty.setOrganizationId(getOrganizationId());
/* 515 */     argDealWeekProperty.setDealId(getDealId());
/* 516 */     argDealWeekProperty.setDayCode(getDayCode());
/* 517 */     argDealWeekProperty.setStartTime(getStartTime());
/* 518 */     if (argDealWeekProperty instanceof IDataModelImpl) {
/* 519 */       IDataAccessObject childDao = ((IDataModelImpl)argDealWeekProperty).getDAO();
/* 520 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 521 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 522 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 527 */     if (postEventsForChanges()) {
/* 528 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealWeekProperty));
/*     */     }
/*     */     
/* 531 */     this._properties.add(argDealWeekProperty);
/* 532 */     if (postEventsForChanges()) {
/* 533 */       this._events.post(IDealWeek.ADD_PROPERTIES, argDealWeekProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDealWeekProperty(IDealWeekProperty argDealWeekProperty) {
/* 538 */     if (this._properties != null) {
/*     */       
/* 540 */       if (postEventsForChanges()) {
/* 541 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealWeekProperty));
/*     */       }
/* 543 */       this._properties.remove(argDealWeekProperty);
/* 544 */       if (postEventsForChanges()) {
/* 545 */         this._events.post(IDealWeek.REMOVE_PROPERTIES, argDealWeekProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 552 */     if ("Properties".equals(argFieldId)) {
/* 553 */       return getProperties();
/*     */     }
/* 555 */     if ("DealWeekExtension".equals(argFieldId)) {
/* 556 */       return this._myExtension;
/*     */     }
/*     */     
/* 559 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 565 */     if ("Properties".equals(argFieldId)) {
/* 566 */       setProperties(changeToList(argValue, IDealWeekProperty.class));
/*     */     }
/* 568 */     else if ("DealWeekExtension".equals(argFieldId)) {
/* 569 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 572 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 578 */     this._persistenceDefaults = argPD;
/* 579 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 580 */     this._eventManager = argEM;
/* 581 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 582 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 583 */     if (this._properties != null) {
/* 584 */       for (IDealWeekProperty relationship : this._properties) {
/* 585 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDealWeekExt() {
/* 591 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDealWeekExt(IDataModel argExt) {
/* 595 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 600 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 604 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 607 */     super.startTransaction();
/*     */     
/* 609 */     this._propertiesSavepoint = this._properties;
/* 610 */     if (this._properties != null) {
/* 611 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 612 */       Iterator<IDataModel> it = this._properties.iterator();
/* 613 */       while (it.hasNext()) {
/* 614 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 619 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 624 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 627 */     super.rollbackChanges();
/*     */     
/* 629 */     this._properties = this._propertiesSavepoint;
/* 630 */     this._propertiesSavepoint = null;
/* 631 */     if (this._properties != null) {
/* 632 */       Iterator<IDataModel> it = this._properties.iterator();
/* 633 */       while (it.hasNext()) {
/* 634 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 642 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 645 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 648 */     super.commitTransaction();
/*     */     
/* 650 */     this._propertiesSavepoint = this._properties;
/* 651 */     if (this._properties != null) {
/* 652 */       Iterator<IDataModel> it = this._properties.iterator();
/* 653 */       while (it.hasNext()) {
/* 654 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 656 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 660 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 665 */     argStream.defaultReadObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 675 */   private static final String[] DAY_CODES = new String[] { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getDayOfWeek(Date argDate) {
/* 685 */     String dayCode = null;
/*     */     
/* 687 */     if (argDate != null) {
/* 688 */       int dayOfWeek = DateUtils.getDayOfWeek(argDate);
/* 689 */       dayCode = DAY_CODES[dayOfWeek - 1];
/*     */     } 
/* 691 */     return dayCode;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealWeekModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */