/*     */ package dtv.xst.dao.com.impl;
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
/*     */ import dtv.xst.dao.com.IReportData;
/*     */ import dtv.xst.dao.com.IReportDataProperty;
/*     */ import dtv.xst.dao.com.ReportDataPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ReportDataModel extends AbstractDataModelWithPropertyImpl<IReportDataProperty> implements IReportData {
/*     */   private static final long serialVersionUID = -370615522L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IReportDataProperty> _properties; private transient HistoricalList<IReportDataProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ReportDataDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ReportDataDAO getDAO_() {
/*  46 */     return (ReportDataDAO)this._daoImpl;
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
/*  70 */       this._events.post(IReportData.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ReportDataPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ReportDataPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getOwnerId() {
/* 101 */     return getDAO_().getOwnerId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOwnerId(String argOwnerId) {
/* 109 */     if (setOwnerId_noev(argOwnerId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IReportData.SET_OWNERID, argOwnerId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOwnerId_noev(String argOwnerId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getOwnerId() == null && argOwnerId != null) || (
/* 122 */       getDAO_().getOwnerId() != null && !getDAO_().getOwnerId().equals(argOwnerId))) {
/* 123 */       getDAO_().setOwnerId(argOwnerId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<ReportDataPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((ReportDataPropertyModel)it.next()).setOwnerId_noev(argOwnerId);
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
/*     */   public String getOwnerType() {
/* 143 */     return getDAO_().getOwnerType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOwnerType(String argOwnerType) {
/* 151 */     if (setOwnerType_noev(argOwnerType) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IReportData.SET_OWNERTYPE, argOwnerType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOwnerType_noev(String argOwnerType) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getOwnerType() == null && argOwnerType != null) || (
/* 164 */       getDAO_().getOwnerType() != null && !getDAO_().getOwnerType().equals(argOwnerType))) {
/* 165 */       getDAO_().setOwnerType(argOwnerType);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<ReportDataPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((ReportDataPropertyModel)it.next()).setOwnerType_noev(argOwnerType);
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
/*     */   public String getReportId() {
/* 185 */     return getDAO_().getReportId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReportId(String argReportId) {
/* 193 */     if (setReportId_noev(argReportId) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IReportData.SET_REPORTID, argReportId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReportId_noev(String argReportId) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getReportId() == null && argReportId != null) || (
/* 206 */       getDAO_().getReportId() != null && !getDAO_().getReportId().equals(argReportId))) {
/* 207 */       getDAO_().setReportId(argReportId);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<ReportDataPropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((ReportDataPropertyModel)it.next()).setReportId_noev(argReportId);
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
/*     */   public Date getCreateDate() {
/* 227 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 235 */     if (setCreateDate_noev(argCreateDate) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(IReportData.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 248 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 249 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 261 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 269 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(IReportData.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 282 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 283 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 295 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 303 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 304 */       this._events != null && 
/* 305 */       postEventsForChanges()) {
/* 306 */       this._events.post(IReportData.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 313 */     boolean ev_postable = false;
/*     */     
/* 315 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 316 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 317 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 329 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 337 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 338 */       this._events != null && 
/* 339 */       postEventsForChanges()) {
/* 340 */       this._events.post(IReportData.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 347 */     boolean ev_postable = false;
/*     */     
/* 349 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 350 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 351 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public String getOrgCode() {
/* 363 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 371 */     if (setOrgCode_noev(argOrgCode) && 
/* 372 */       this._events != null && 
/* 373 */       postEventsForChanges()) {
/* 374 */       this._events.post(IReportData.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 381 */     boolean ev_postable = false;
/*     */     
/* 383 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 384 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 385 */       getDAO_().setOrgCode(argOrgCode);
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
/*     */   public String getOrgValue() {
/* 397 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 405 */     if (setOrgValue_noev(argOrgValue) && 
/* 406 */       this._events != null && 
/* 407 */       postEventsForChanges()) {
/* 408 */       this._events.post(IReportData.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 415 */     boolean ev_postable = false;
/*     */     
/* 417 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 418 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 419 */       getDAO_().setOrgValue(argOrgValue);
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
/*     */   public Object getReportData() {
/* 431 */     return getDAO_().getReportData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReportData(Object argReportData) {
/* 439 */     if (setReportData_noev(argReportData) && 
/* 440 */       this._events != null && 
/* 441 */       postEventsForChanges()) {
/* 442 */       this._events.post(IReportData.SET_REPORTDATA, argReportData);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReportData_noev(Object argReportData) {
/* 449 */     boolean ev_postable = false;
/*     */     
/* 451 */     if ((getDAO_().getReportData() == null && argReportData != null) || (
/* 452 */       getDAO_().getReportData() != null && !getDAO_().getReportData().equals(argReportData))) {
/* 453 */       getDAO_().setReportData(argReportData);
/* 454 */       ev_postable = true;
/*     */     } 
/*     */     
/* 457 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDelete() {
/* 465 */     if (getDAO_().getDelete() != null) {
/* 466 */       return getDAO_().getDelete().booleanValue();
/*     */     }
/*     */     
/* 469 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDelete(boolean argDelete) {
/* 478 */     if (setDelete_noev(argDelete) && 
/* 479 */       this._events != null && 
/* 480 */       postEventsForChanges()) {
/* 481 */       this._events.post(IReportData.SET_DELETE, Boolean.valueOf(argDelete));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDelete_noev(boolean argDelete) {
/* 488 */     boolean ev_postable = false;
/*     */     
/* 490 */     if ((getDAO_().getDelete() == null && Boolean.valueOf(argDelete) != null) || (
/* 491 */       getDAO_().getDelete() != null && !getDAO_().getDelete().equals(Boolean.valueOf(argDelete)))) {
/* 492 */       getDAO_().setDelete(Boolean.valueOf(argDelete));
/* 493 */       ev_postable = true;
/*     */     } 
/*     */     
/* 496 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IReportDataProperty newProperty(String argPropertyName) {
/* 500 */     ReportDataPropertyId id = new ReportDataPropertyId();
/*     */     
/* 502 */     id.setOwnerId(getOwnerId());
/* 503 */     id.setOwnerType(getOwnerType());
/* 504 */     id.setReportId(getReportId());
/* 505 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 507 */     IReportDataProperty prop = (IReportDataProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IReportDataProperty.class);
/* 508 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IReportDataProperty> getProperties() {
/* 517 */     if (this._properties == null) {
/* 518 */       this._properties = new HistoricalList(null);
/*     */     }
/* 520 */     return (List<IReportDataProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IReportDataProperty> argProperties) {
/* 524 */     if (this._properties == null) {
/* 525 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 527 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 530 */     for (IReportDataProperty child : this._properties) {
/* 531 */       ReportDataPropertyModel model = (ReportDataPropertyModel)child;
/* 532 */       model.setOrganizationId_noev(getOrganizationId());
/* 533 */       model.setOwnerId_noev(getOwnerId());
/* 534 */       model.setOwnerType_noev(getOwnerType());
/* 535 */       model.setReportId_noev(getReportId());
/* 536 */       if (child instanceof IDataModelImpl) {
/* 537 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 538 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 539 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 540 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 543 */       if (postEventsForChanges()) {
/* 544 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addReportDataProperty(IReportDataProperty argReportDataProperty) {
/* 550 */     if (this._properties == null) {
/* 551 */       this._properties = new HistoricalList(null);
/*     */     }
/* 553 */     argReportDataProperty.setOrganizationId(getOrganizationId());
/* 554 */     argReportDataProperty.setOwnerId(getOwnerId());
/* 555 */     argReportDataProperty.setOwnerType(getOwnerType());
/* 556 */     argReportDataProperty.setReportId(getReportId());
/* 557 */     if (argReportDataProperty instanceof IDataModelImpl) {
/* 558 */       IDataAccessObject childDao = ((IDataModelImpl)argReportDataProperty).getDAO();
/* 559 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 560 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 561 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 566 */     if (postEventsForChanges()) {
/* 567 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReportDataProperty));
/*     */     }
/*     */     
/* 570 */     this._properties.add(argReportDataProperty);
/* 571 */     if (postEventsForChanges()) {
/* 572 */       this._events.post(IReportData.ADD_PROPERTIES, argReportDataProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeReportDataProperty(IReportDataProperty argReportDataProperty) {
/* 577 */     if (this._properties != null) {
/*     */       
/* 579 */       if (postEventsForChanges()) {
/* 580 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReportDataProperty));
/*     */       }
/* 582 */       this._properties.remove(argReportDataProperty);
/* 583 */       if (postEventsForChanges()) {
/* 584 */         this._events.post(IReportData.REMOVE_PROPERTIES, argReportDataProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 591 */     if ("Properties".equals(argFieldId)) {
/* 592 */       return getProperties();
/*     */     }
/* 594 */     if ("ReportDataExtension".equals(argFieldId)) {
/* 595 */       return this._myExtension;
/*     */     }
/*     */     
/* 598 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 604 */     if ("Properties".equals(argFieldId)) {
/* 605 */       setProperties(changeToList(argValue, IReportDataProperty.class));
/*     */     }
/* 607 */     else if ("ReportDataExtension".equals(argFieldId)) {
/* 608 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 611 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 617 */     this._persistenceDefaults = argPD;
/* 618 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 619 */     this._eventManager = argEM;
/* 620 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 621 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 622 */     if (this._properties != null) {
/* 623 */       for (IReportDataProperty relationship : this._properties) {
/* 624 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getReportDataExt() {
/* 630 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setReportDataExt(IDataModel argExt) {
/* 634 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 639 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 643 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 646 */     super.startTransaction();
/*     */     
/* 648 */     this._propertiesSavepoint = this._properties;
/* 649 */     if (this._properties != null) {
/* 650 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 651 */       Iterator<IDataModel> it = this._properties.iterator();
/* 652 */       while (it.hasNext()) {
/* 653 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 658 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 663 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 666 */     super.rollbackChanges();
/*     */     
/* 668 */     this._properties = this._propertiesSavepoint;
/* 669 */     this._propertiesSavepoint = null;
/* 670 */     if (this._properties != null) {
/* 671 */       Iterator<IDataModel> it = this._properties.iterator();
/* 672 */       while (it.hasNext()) {
/* 673 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 681 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 684 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 687 */     super.commitTransaction();
/*     */     
/* 689 */     this._propertiesSavepoint = this._properties;
/* 690 */     if (this._properties != null) {
/* 691 */       Iterator<IDataModel> it = this._properties.iterator();
/* 692 */       while (it.hasNext()) {
/* 693 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 695 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 699 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 704 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ReportDataModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */