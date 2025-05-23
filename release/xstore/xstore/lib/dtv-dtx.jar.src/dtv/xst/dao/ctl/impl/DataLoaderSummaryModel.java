/*     */ package dtv.xst.dao.ctl.impl;
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
/*     */ import dtv.xst.dao.ctl.DataLoaderSummaryPropertyId;
/*     */ import dtv.xst.dao.ctl.IDataLoaderSummary;
/*     */ import dtv.xst.dao.ctl.IDataLoaderSummaryProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DataLoaderSummaryModel extends AbstractDataModelWithPropertyImpl<IDataLoaderSummaryProperty> implements IDataLoaderSummary {
/*     */   private static final long serialVersionUID = -471652247L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IDataLoaderSummaryProperty> _properties; private transient HistoricalList<IDataLoaderSummaryProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new DataLoaderSummaryDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DataLoaderSummaryDAO getDAO_() {
/*  46 */     return (DataLoaderSummaryDAO)this._daoImpl;
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
/*  70 */       this._events.post(IDataLoaderSummary.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<DataLoaderSummaryPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((DataLoaderSummaryPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getFileName() {
/* 101 */     return getDAO_().getFileName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFileName(String argFileName) {
/* 109 */     if (setFileName_noev(argFileName) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IDataLoaderSummary.SET_FILENAME, argFileName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFileName_noev(String argFileName) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getFileName() == null && argFileName != null) || (
/* 122 */       getDAO_().getFileName() != null && !getDAO_().getFileName().equals(argFileName))) {
/* 123 */       getDAO_().setFileName(argFileName);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<DataLoaderSummaryPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((DataLoaderSummaryPropertyModel)it.next()).setFileName_noev(argFileName);
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
/*     */   public long getRunTime() {
/* 143 */     if (getDAO_().getRunTime() != null) {
/* 144 */       return getDAO_().getRunTime().longValue();
/*     */     }
/*     */     
/* 147 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRunTime(long argRunTime) {
/* 156 */     if (setRunTime_noev(argRunTime) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IDataLoaderSummary.SET_RUNTIME, Long.valueOf(argRunTime));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRunTime_noev(long argRunTime) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getRunTime() == null && Long.valueOf(argRunTime) != null) || (
/* 169 */       getDAO_().getRunTime() != null && !getDAO_().getRunTime().equals(Long.valueOf(argRunTime)))) {
/* 170 */       getDAO_().setRunTime(Long.valueOf(argRunTime));
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<DataLoaderSummaryPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((DataLoaderSummaryPropertyModel)it.next()).setRunTime_noev(argRunTime);
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
/* 201 */       this._events.post(IDataLoaderSummary.SET_CREATEDATE, argCreateDate);
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
/* 235 */       this._events.post(IDataLoaderSummary.SET_CREATEUSERID, argCreateUserId);
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
/* 269 */       this._events.post(IDataLoaderSummary.SET_UPDATEDATE, argUpdateDate);
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
/* 303 */       this._events.post(IDataLoaderSummary.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public boolean getSuccess() {
/* 326 */     if (getDAO_().getSuccess() != null) {
/* 327 */       return getDAO_().getSuccess().booleanValue();
/*     */     }
/*     */     
/* 330 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSuccess(boolean argSuccess) {
/* 339 */     if (setSuccess_noev(argSuccess) && 
/* 340 */       this._events != null && 
/* 341 */       postEventsForChanges()) {
/* 342 */       this._events.post(IDataLoaderSummary.SET_SUCCESS, Boolean.valueOf(argSuccess));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSuccess_noev(boolean argSuccess) {
/* 349 */     boolean ev_postable = false;
/*     */     
/* 351 */     if ((getDAO_().getSuccess() == null && Boolean.valueOf(argSuccess) != null) || (
/* 352 */       getDAO_().getSuccess() != null && !getDAO_().getSuccess().equals(Boolean.valueOf(argSuccess)))) {
/* 353 */       getDAO_().setSuccess(Boolean.valueOf(argSuccess));
/* 354 */       ev_postable = true;
/*     */     } 
/*     */     
/* 357 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSuccessfulRows() {
/* 365 */     if (getDAO_().getSuccessfulRows() != null) {
/* 366 */       return getDAO_().getSuccessfulRows().intValue();
/*     */     }
/*     */     
/* 369 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSuccessfulRows(int argSuccessfulRows) {
/* 378 */     if (setSuccessfulRows_noev(argSuccessfulRows) && 
/* 379 */       this._events != null && 
/* 380 */       postEventsForChanges()) {
/* 381 */       this._events.post(IDataLoaderSummary.SET_SUCCESSFULROWS, Integer.valueOf(argSuccessfulRows));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSuccessfulRows_noev(int argSuccessfulRows) {
/* 388 */     boolean ev_postable = false;
/*     */     
/* 390 */     if ((getDAO_().getSuccessfulRows() == null && Integer.valueOf(argSuccessfulRows) != null) || (
/* 391 */       getDAO_().getSuccessfulRows() != null && !getDAO_().getSuccessfulRows().equals(Integer.valueOf(argSuccessfulRows)))) {
/* 392 */       getDAO_().setSuccessfulRows(Integer.valueOf(argSuccessfulRows));
/* 393 */       ev_postable = true;
/*     */     } 
/*     */     
/* 396 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFailedRows() {
/* 404 */     if (getDAO_().getFailedRows() != null) {
/* 405 */       return getDAO_().getFailedRows().intValue();
/*     */     }
/*     */     
/* 408 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFailedRows(int argFailedRows) {
/* 417 */     if (setFailedRows_noev(argFailedRows) && 
/* 418 */       this._events != null && 
/* 419 */       postEventsForChanges()) {
/* 420 */       this._events.post(IDataLoaderSummary.SET_FAILEDROWS, Integer.valueOf(argFailedRows));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFailedRows_noev(int argFailedRows) {
/* 427 */     boolean ev_postable = false;
/*     */     
/* 429 */     if ((getDAO_().getFailedRows() == null && Integer.valueOf(argFailedRows) != null) || (
/* 430 */       getDAO_().getFailedRows() != null && !getDAO_().getFailedRows().equals(Integer.valueOf(argFailedRows)))) {
/* 431 */       getDAO_().setFailedRows(Integer.valueOf(argFailedRows));
/* 432 */       ev_postable = true;
/*     */     } 
/*     */     
/* 435 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDataLoaderSummaryProperty newProperty(String argPropertyName) {
/* 439 */     DataLoaderSummaryPropertyId id = new DataLoaderSummaryPropertyId();
/*     */     
/* 441 */     id.setFileName(getFileName());
/* 442 */     id.setRunTime(Long.valueOf(getRunTime()));
/* 443 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 445 */     IDataLoaderSummaryProperty prop = (IDataLoaderSummaryProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDataLoaderSummaryProperty.class);
/* 446 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDataLoaderSummaryProperty> getProperties() {
/* 455 */     if (this._properties == null) {
/* 456 */       this._properties = new HistoricalList(null);
/*     */     }
/* 458 */     return (List<IDataLoaderSummaryProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDataLoaderSummaryProperty> argProperties) {
/* 462 */     if (this._properties == null) {
/* 463 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 465 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 468 */     for (IDataLoaderSummaryProperty child : this._properties) {
/* 469 */       DataLoaderSummaryPropertyModel model = (DataLoaderSummaryPropertyModel)child;
/* 470 */       model.setOrganizationId_noev(getOrganizationId());
/* 471 */       model.setFileName_noev(getFileName());
/* 472 */       model.setRunTime_noev(getRunTime());
/* 473 */       if (child instanceof IDataModelImpl) {
/* 474 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 475 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 476 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 477 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 480 */       if (postEventsForChanges()) {
/* 481 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDataLoaderSummaryProperty(IDataLoaderSummaryProperty argDataLoaderSummaryProperty) {
/* 487 */     if (this._properties == null) {
/* 488 */       this._properties = new HistoricalList(null);
/*     */     }
/* 490 */     argDataLoaderSummaryProperty.setOrganizationId(getOrganizationId());
/* 491 */     argDataLoaderSummaryProperty.setFileName(getFileName());
/* 492 */     argDataLoaderSummaryProperty.setRunTime(getRunTime());
/* 493 */     if (argDataLoaderSummaryProperty instanceof IDataModelImpl) {
/* 494 */       IDataAccessObject childDao = ((IDataModelImpl)argDataLoaderSummaryProperty).getDAO();
/* 495 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 496 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 497 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 502 */     if (postEventsForChanges()) {
/* 503 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDataLoaderSummaryProperty));
/*     */     }
/*     */     
/* 506 */     this._properties.add(argDataLoaderSummaryProperty);
/* 507 */     if (postEventsForChanges()) {
/* 508 */       this._events.post(IDataLoaderSummary.ADD_PROPERTIES, argDataLoaderSummaryProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDataLoaderSummaryProperty(IDataLoaderSummaryProperty argDataLoaderSummaryProperty) {
/* 513 */     if (this._properties != null) {
/*     */       
/* 515 */       if (postEventsForChanges()) {
/* 516 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDataLoaderSummaryProperty));
/*     */       }
/* 518 */       this._properties.remove(argDataLoaderSummaryProperty);
/* 519 */       if (postEventsForChanges()) {
/* 520 */         this._events.post(IDataLoaderSummary.REMOVE_PROPERTIES, argDataLoaderSummaryProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 527 */     if ("Properties".equals(argFieldId)) {
/* 528 */       return getProperties();
/*     */     }
/* 530 */     if ("DataLoaderSummaryExtension".equals(argFieldId)) {
/* 531 */       return this._myExtension;
/*     */     }
/*     */     
/* 534 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 540 */     if ("Properties".equals(argFieldId)) {
/* 541 */       setProperties(changeToList(argValue, IDataLoaderSummaryProperty.class));
/*     */     }
/* 543 */     else if ("DataLoaderSummaryExtension".equals(argFieldId)) {
/* 544 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 547 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 553 */     this._persistenceDefaults = argPD;
/* 554 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 555 */     this._eventManager = argEM;
/* 556 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 557 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 558 */     if (this._properties != null) {
/* 559 */       for (IDataLoaderSummaryProperty relationship : this._properties) {
/* 560 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDataLoaderSummaryExt() {
/* 566 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDataLoaderSummaryExt(IDataModel argExt) {
/* 570 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 575 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 579 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 582 */     super.startTransaction();
/*     */     
/* 584 */     this._propertiesSavepoint = this._properties;
/* 585 */     if (this._properties != null) {
/* 586 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 587 */       Iterator<IDataModel> it = this._properties.iterator();
/* 588 */       while (it.hasNext()) {
/* 589 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 594 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 599 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 602 */     super.rollbackChanges();
/*     */     
/* 604 */     this._properties = this._propertiesSavepoint;
/* 605 */     this._propertiesSavepoint = null;
/* 606 */     if (this._properties != null) {
/* 607 */       Iterator<IDataModel> it = this._properties.iterator();
/* 608 */       while (it.hasNext()) {
/* 609 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 617 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 620 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 623 */     super.commitTransaction();
/*     */     
/* 625 */     this._propertiesSavepoint = this._properties;
/* 626 */     if (this._properties != null) {
/* 627 */       Iterator<IDataModel> it = this._properties.iterator();
/* 628 */       while (it.hasNext()) {
/* 629 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 631 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 635 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 640 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\DataLoaderSummaryModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */