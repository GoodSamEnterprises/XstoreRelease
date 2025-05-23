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
/*     */ import dtv.xst.dao.ctl.DataLoaderFailurePropertyId;
/*     */ import dtv.xst.dao.ctl.IDataLoaderFailure;
/*     */ import dtv.xst.dao.ctl.IDataLoaderFailureProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DataLoaderFailureModel extends AbstractDataModelWithPropertyImpl<IDataLoaderFailureProperty> implements IDataLoaderFailure {
/*     */   private static final long serialVersionUID = 299414093L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IDataLoaderFailureProperty> _properties; private transient HistoricalList<IDataLoaderFailureProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new DataLoaderFailureDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DataLoaderFailureDAO getDAO_() {
/*  46 */     return (DataLoaderFailureDAO)this._daoImpl;
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
/*  70 */       this._events.post(IDataLoaderFailure.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<DataLoaderFailurePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((DataLoaderFailurePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 112 */       this._events.post(IDataLoaderFailure.SET_FILENAME, argFileName);
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
/* 127 */         Iterator<DataLoaderFailurePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((DataLoaderFailurePropertyModel)it.next()).setFileName_noev(argFileName);
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
/* 159 */       this._events.post(IDataLoaderFailure.SET_RUNTIME, Long.valueOf(argRunTime));
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
/* 174 */         Iterator<DataLoaderFailurePropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((DataLoaderFailurePropertyModel)it.next()).setRunTime_noev(argRunTime);
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
/*     */   public int getFailureSequence() {
/* 190 */     if (getDAO_().getFailureSequence() != null) {
/* 191 */       return getDAO_().getFailureSequence().intValue();
/*     */     }
/*     */     
/* 194 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFailureSequence(int argFailureSequence) {
/* 203 */     if (setFailureSequence_noev(argFailureSequence) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(IDataLoaderFailure.SET_FAILURESEQUENCE, Integer.valueOf(argFailureSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFailureSequence_noev(int argFailureSequence) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getFailureSequence() == null && Integer.valueOf(argFailureSequence) != null) || (
/* 216 */       getDAO_().getFailureSequence() != null && !getDAO_().getFailureSequence().equals(Integer.valueOf(argFailureSequence)))) {
/* 217 */       getDAO_().setFailureSequence(Integer.valueOf(argFailureSequence));
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<DataLoaderFailurePropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((DataLoaderFailurePropertyModel)it.next()).setFailureSequence_noev(argFailureSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 229 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 237 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 245 */     if (setCreateDate_noev(argCreateDate) && 
/* 246 */       this._events != null && 
/* 247 */       postEventsForChanges()) {
/* 248 */       this._events.post(IDataLoaderFailure.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 255 */     boolean ev_postable = false;
/*     */     
/* 257 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 258 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 259 */       getDAO_().setCreateDate(argCreateDate);
/* 260 */       ev_postable = true;
/*     */     } 
/*     */     
/* 263 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 271 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 279 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 280 */       this._events != null && 
/* 281 */       postEventsForChanges()) {
/* 282 */       this._events.post(IDataLoaderFailure.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 289 */     boolean ev_postable = false;
/*     */     
/* 291 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 292 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 293 */       getDAO_().setCreateUserId(argCreateUserId);
/* 294 */       ev_postable = true;
/*     */     } 
/*     */     
/* 297 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 305 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 313 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 314 */       this._events != null && 
/* 315 */       postEventsForChanges()) {
/* 316 */       this._events.post(IDataLoaderFailure.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 323 */     boolean ev_postable = false;
/*     */     
/* 325 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 326 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 327 */       getDAO_().setUpdateDate(argUpdateDate);
/* 328 */       ev_postable = true;
/*     */     } 
/*     */     
/* 331 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 339 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 347 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 348 */       this._events != null && 
/* 349 */       postEventsForChanges()) {
/* 350 */       this._events.post(IDataLoaderFailure.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 357 */     boolean ev_postable = false;
/*     */     
/* 359 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 360 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 361 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 362 */       ev_postable = true;
/*     */     } 
/*     */     
/* 365 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFailureMessage() {
/* 373 */     return getDAO_().getFailureMessage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFailureMessage(String argFailureMessage) {
/* 381 */     if (setFailureMessage_noev(argFailureMessage) && 
/* 382 */       this._events != null && 
/* 383 */       postEventsForChanges()) {
/* 384 */       this._events.post(IDataLoaderFailure.SET_FAILUREMESSAGE, argFailureMessage);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFailureMessage_noev(String argFailureMessage) {
/* 391 */     boolean ev_postable = false;
/*     */     
/* 393 */     if ((getDAO_().getFailureMessage() == null && argFailureMessage != null) || (
/* 394 */       getDAO_().getFailureMessage() != null && !getDAO_().getFailureMessage().equals(argFailureMessage))) {
/* 395 */       getDAO_().setFailureMessage(argFailureMessage);
/* 396 */       ev_postable = true;
/*     */     } 
/*     */     
/* 399 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFailedData() {
/* 407 */     return getDAO_().getFailedData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFailedData(String argFailedData) {
/* 415 */     if (setFailedData_noev(argFailedData) && 
/* 416 */       this._events != null && 
/* 417 */       postEventsForChanges()) {
/* 418 */       this._events.post(IDataLoaderFailure.SET_FAILEDDATA, argFailedData);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFailedData_noev(String argFailedData) {
/* 425 */     boolean ev_postable = false;
/*     */     
/* 427 */     if ((getDAO_().getFailedData() == null && argFailedData != null) || (
/* 428 */       getDAO_().getFailedData() != null && !getDAO_().getFailedData().equals(argFailedData))) {
/* 429 */       getDAO_().setFailedData(argFailedData);
/* 430 */       ev_postable = true;
/*     */     } 
/*     */     
/* 433 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDataLoaderFailureProperty newProperty(String argPropertyName) {
/* 437 */     DataLoaderFailurePropertyId id = new DataLoaderFailurePropertyId();
/*     */     
/* 439 */     id.setFileName(getFileName());
/* 440 */     id.setRunTime(Long.valueOf(getRunTime()));
/* 441 */     id.setFailureSequence(Integer.valueOf(getFailureSequence()));
/* 442 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 444 */     IDataLoaderFailureProperty prop = (IDataLoaderFailureProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDataLoaderFailureProperty.class);
/* 445 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDataLoaderFailureProperty> getProperties() {
/* 454 */     if (this._properties == null) {
/* 455 */       this._properties = new HistoricalList(null);
/*     */     }
/* 457 */     return (List<IDataLoaderFailureProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDataLoaderFailureProperty> argProperties) {
/* 461 */     if (this._properties == null) {
/* 462 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 464 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 467 */     for (IDataLoaderFailureProperty child : this._properties) {
/* 468 */       DataLoaderFailurePropertyModel model = (DataLoaderFailurePropertyModel)child;
/* 469 */       model.setOrganizationId_noev(getOrganizationId());
/* 470 */       model.setFileName_noev(getFileName());
/* 471 */       model.setRunTime_noev(getRunTime());
/* 472 */       model.setFailureSequence_noev(getFailureSequence());
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
/*     */   public void addDataLoaderFailureProperty(IDataLoaderFailureProperty argDataLoaderFailureProperty) {
/* 487 */     if (this._properties == null) {
/* 488 */       this._properties = new HistoricalList(null);
/*     */     }
/* 490 */     argDataLoaderFailureProperty.setOrganizationId(getOrganizationId());
/* 491 */     argDataLoaderFailureProperty.setFileName(getFileName());
/* 492 */     argDataLoaderFailureProperty.setRunTime(getRunTime());
/* 493 */     argDataLoaderFailureProperty.setFailureSequence(getFailureSequence());
/* 494 */     if (argDataLoaderFailureProperty instanceof IDataModelImpl) {
/* 495 */       IDataAccessObject childDao = ((IDataModelImpl)argDataLoaderFailureProperty).getDAO();
/* 496 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 497 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 498 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 503 */     if (postEventsForChanges()) {
/* 504 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDataLoaderFailureProperty));
/*     */     }
/*     */     
/* 507 */     this._properties.add(argDataLoaderFailureProperty);
/* 508 */     if (postEventsForChanges()) {
/* 509 */       this._events.post(IDataLoaderFailure.ADD_PROPERTIES, argDataLoaderFailureProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDataLoaderFailureProperty(IDataLoaderFailureProperty argDataLoaderFailureProperty) {
/* 514 */     if (this._properties != null) {
/*     */       
/* 516 */       if (postEventsForChanges()) {
/* 517 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDataLoaderFailureProperty));
/*     */       }
/* 519 */       this._properties.remove(argDataLoaderFailureProperty);
/* 520 */       if (postEventsForChanges()) {
/* 521 */         this._events.post(IDataLoaderFailure.REMOVE_PROPERTIES, argDataLoaderFailureProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 528 */     if ("Properties".equals(argFieldId)) {
/* 529 */       return getProperties();
/*     */     }
/* 531 */     if ("DataLoaderFailureExtension".equals(argFieldId)) {
/* 532 */       return this._myExtension;
/*     */     }
/*     */     
/* 535 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 541 */     if ("Properties".equals(argFieldId)) {
/* 542 */       setProperties(changeToList(argValue, IDataLoaderFailureProperty.class));
/*     */     }
/* 544 */     else if ("DataLoaderFailureExtension".equals(argFieldId)) {
/* 545 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 548 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 554 */     this._persistenceDefaults = argPD;
/* 555 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 556 */     this._eventManager = argEM;
/* 557 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 558 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 559 */     if (this._properties != null) {
/* 560 */       for (IDataLoaderFailureProperty relationship : this._properties) {
/* 561 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDataLoaderFailureExt() {
/* 567 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDataLoaderFailureExt(IDataModel argExt) {
/* 571 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 576 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 580 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 583 */     super.startTransaction();
/*     */     
/* 585 */     this._propertiesSavepoint = this._properties;
/* 586 */     if (this._properties != null) {
/* 587 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 588 */       Iterator<IDataModel> it = this._properties.iterator();
/* 589 */       while (it.hasNext()) {
/* 590 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 595 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 600 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 603 */     super.rollbackChanges();
/*     */     
/* 605 */     this._properties = this._propertiesSavepoint;
/* 606 */     this._propertiesSavepoint = null;
/* 607 */     if (this._properties != null) {
/* 608 */       Iterator<IDataModel> it = this._properties.iterator();
/* 609 */       while (it.hasNext()) {
/* 610 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 618 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 621 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 624 */     super.commitTransaction();
/*     */     
/* 626 */     this._propertiesSavepoint = this._properties;
/* 627 */     if (this._properties != null) {
/* 628 */       Iterator<IDataModel> it = this._properties.iterator();
/* 629 */       while (it.hasNext()) {
/* 630 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 632 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 636 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 641 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\DataLoaderFailureModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */