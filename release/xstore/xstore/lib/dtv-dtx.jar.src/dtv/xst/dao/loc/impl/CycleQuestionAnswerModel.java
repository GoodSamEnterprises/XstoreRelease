/*     */ package dtv.xst.dao.loc.impl;
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
/*     */ import dtv.xst.dao.loc.CycleQuestionAnswerPropertyId;
/*     */ import dtv.xst.dao.loc.ICycleQuestionAnswer;
/*     */ import dtv.xst.dao.loc.ICycleQuestionAnswerProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CycleQuestionAnswerModel extends AbstractDataModelWithPropertyImpl<ICycleQuestionAnswerProperty> implements ICycleQuestionAnswer {
/*     */   private static final long serialVersionUID = -1404041814L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ICycleQuestionAnswerProperty> _properties; private transient HistoricalList<ICycleQuestionAnswerProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new CycleQuestionAnswerDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CycleQuestionAnswerDAO getDAO_() {
/*  46 */     return (CycleQuestionAnswerDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAnswerId() {
/*  54 */     return getDAO_().getAnswerId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnswerId(String argAnswerId) {
/*  62 */     if (setAnswerId_noev(argAnswerId) && 
/*  63 */       this._events != null && 
/*  64 */       postEventsForChanges()) {
/*  65 */       this._events.post(ICycleQuestionAnswer.SET_ANSWERID, argAnswerId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAnswerId_noev(String argAnswerId) {
/*  72 */     boolean ev_postable = false;
/*     */     
/*  74 */     if ((getDAO_().getAnswerId() == null && argAnswerId != null) || (
/*  75 */       getDAO_().getAnswerId() != null && !getDAO_().getAnswerId().equals(argAnswerId))) {
/*  76 */       getDAO_().setAnswerId(argAnswerId);
/*  77 */       ev_postable = true;
/*  78 */       if (this._properties != null) {
/*     */         
/*  80 */         Iterator<CycleQuestionAnswerPropertyModel> it = this._properties.iterator();
/*  81 */         while (it.hasNext())
/*     */         {
/*  83 */           ((CycleQuestionAnswerPropertyModel)it.next()).setAnswerId_noev(argAnswerId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  88 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getAnswerTimestamp() {
/*  96 */     return getDAO_().getAnswerTimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnswerTimestamp(Date argAnswerTimestamp) {
/* 104 */     if (setAnswerTimestamp_noev(argAnswerTimestamp) && 
/* 105 */       this._events != null && 
/* 106 */       postEventsForChanges()) {
/* 107 */       this._events.post(ICycleQuestionAnswer.SET_ANSWERTIMESTAMP, argAnswerTimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAnswerTimestamp_noev(Date argAnswerTimestamp) {
/* 114 */     boolean ev_postable = false;
/*     */     
/* 116 */     if ((getDAO_().getAnswerTimestamp() == null && argAnswerTimestamp != null) || (
/* 117 */       getDAO_().getAnswerTimestamp() != null && !getDAO_().getAnswerTimestamp().equals(argAnswerTimestamp))) {
/* 118 */       getDAO_().setAnswerTimestamp(argAnswerTimestamp);
/* 119 */       ev_postable = true;
/* 120 */       if (this._properties != null) {
/*     */         
/* 122 */         Iterator<CycleQuestionAnswerPropertyModel> it = this._properties.iterator();
/* 123 */         while (it.hasNext())
/*     */         {
/* 125 */           ((CycleQuestionAnswerPropertyModel)it.next()).setAnswerTimestamp_noev(argAnswerTimestamp);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 130 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 138 */     if (getDAO_().getOrganizationId() != null) {
/* 139 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 142 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 151 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(ICycleQuestionAnswer.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 164 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 165 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<CycleQuestionAnswerPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((CycleQuestionAnswerPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getQuestionId() {
/* 185 */     return getDAO_().getQuestionId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuestionId(String argQuestionId) {
/* 193 */     if (setQuestionId_noev(argQuestionId) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(ICycleQuestionAnswer.SET_QUESTIONID, argQuestionId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setQuestionId_noev(String argQuestionId) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getQuestionId() == null && argQuestionId != null) || (
/* 206 */       getDAO_().getQuestionId() != null && !getDAO_().getQuestionId().equals(argQuestionId))) {
/* 207 */       getDAO_().setQuestionId(argQuestionId);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<CycleQuestionAnswerPropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((CycleQuestionAnswerPropertyModel)it.next()).setQuestionId_noev(argQuestionId);
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
/* 238 */       this._events.post(ICycleQuestionAnswer.SET_CREATEDATE, argCreateDate);
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
/* 272 */       this._events.post(ICycleQuestionAnswer.SET_CREATEUSERID, argCreateUserId);
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
/* 306 */       this._events.post(ICycleQuestionAnswer.SET_UPDATEDATE, argUpdateDate);
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
/* 340 */       this._events.post(ICycleQuestionAnswer.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public long getRetailLocationId() {
/* 363 */     if (getDAO_().getRetailLocationId() != null) {
/* 364 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 367 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 376 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 377 */       this._events != null && 
/* 378 */       postEventsForChanges()) {
/* 379 */       this._events.post(ICycleQuestionAnswer.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 386 */     boolean ev_postable = false;
/*     */     
/* 388 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 389 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 390 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 391 */       ev_postable = true;
/*     */     } 
/*     */     
/* 394 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICycleQuestionAnswerProperty newProperty(String argPropertyName) {
/* 398 */     CycleQuestionAnswerPropertyId id = new CycleQuestionAnswerPropertyId();
/*     */     
/* 400 */     id.setAnswerId(getAnswerId());
/* 401 */     id.setAnswerTimestamp(getAnswerTimestamp());
/* 402 */     id.setQuestionId(getQuestionId());
/* 403 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 405 */     ICycleQuestionAnswerProperty prop = (ICycleQuestionAnswerProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICycleQuestionAnswerProperty.class);
/* 406 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICycleQuestionAnswerProperty> getProperties() {
/* 415 */     if (this._properties == null) {
/* 416 */       this._properties = new HistoricalList(null);
/*     */     }
/* 418 */     return (List<ICycleQuestionAnswerProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICycleQuestionAnswerProperty> argProperties) {
/* 422 */     if (this._properties == null) {
/* 423 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 425 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 428 */     for (ICycleQuestionAnswerProperty child : this._properties) {
/* 429 */       CycleQuestionAnswerPropertyModel model = (CycleQuestionAnswerPropertyModel)child;
/* 430 */       model.setAnswerId_noev(getAnswerId());
/* 431 */       model.setAnswerTimestamp_noev(getAnswerTimestamp());
/* 432 */       model.setOrganizationId_noev(getOrganizationId());
/* 433 */       model.setQuestionId_noev(getQuestionId());
/* 434 */       if (child instanceof IDataModelImpl) {
/* 435 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 436 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 437 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 438 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 441 */       if (postEventsForChanges()) {
/* 442 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCycleQuestionAnswerProperty(ICycleQuestionAnswerProperty argCycleQuestionAnswerProperty) {
/* 448 */     if (this._properties == null) {
/* 449 */       this._properties = new HistoricalList(null);
/*     */     }
/* 451 */     argCycleQuestionAnswerProperty.setAnswerId(getAnswerId());
/* 452 */     argCycleQuestionAnswerProperty.setAnswerTimestamp(getAnswerTimestamp());
/* 453 */     argCycleQuestionAnswerProperty.setOrganizationId(getOrganizationId());
/* 454 */     argCycleQuestionAnswerProperty.setQuestionId(getQuestionId());
/* 455 */     if (argCycleQuestionAnswerProperty instanceof IDataModelImpl) {
/* 456 */       IDataAccessObject childDao = ((IDataModelImpl)argCycleQuestionAnswerProperty).getDAO();
/* 457 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 458 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 459 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 464 */     if (postEventsForChanges()) {
/* 465 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCycleQuestionAnswerProperty));
/*     */     }
/*     */     
/* 468 */     this._properties.add(argCycleQuestionAnswerProperty);
/* 469 */     if (postEventsForChanges()) {
/* 470 */       this._events.post(ICycleQuestionAnswer.ADD_PROPERTIES, argCycleQuestionAnswerProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCycleQuestionAnswerProperty(ICycleQuestionAnswerProperty argCycleQuestionAnswerProperty) {
/* 475 */     if (this._properties != null) {
/*     */       
/* 477 */       if (postEventsForChanges()) {
/* 478 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCycleQuestionAnswerProperty));
/*     */       }
/* 480 */       this._properties.remove(argCycleQuestionAnswerProperty);
/* 481 */       if (postEventsForChanges()) {
/* 482 */         this._events.post(ICycleQuestionAnswer.REMOVE_PROPERTIES, argCycleQuestionAnswerProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 489 */     if ("Properties".equals(argFieldId)) {
/* 490 */       return getProperties();
/*     */     }
/* 492 */     if ("CycleQuestionAnswerExtension".equals(argFieldId)) {
/* 493 */       return this._myExtension;
/*     */     }
/*     */     
/* 496 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 502 */     if ("Properties".equals(argFieldId)) {
/* 503 */       setProperties(changeToList(argValue, ICycleQuestionAnswerProperty.class));
/*     */     }
/* 505 */     else if ("CycleQuestionAnswerExtension".equals(argFieldId)) {
/* 506 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 509 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 515 */     this._persistenceDefaults = argPD;
/* 516 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 517 */     this._eventManager = argEM;
/* 518 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 519 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 520 */     if (this._properties != null) {
/* 521 */       for (ICycleQuestionAnswerProperty relationship : this._properties) {
/* 522 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCycleQuestionAnswerExt() {
/* 528 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCycleQuestionAnswerExt(IDataModel argExt) {
/* 532 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 537 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 541 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 544 */     super.startTransaction();
/*     */     
/* 546 */     this._propertiesSavepoint = this._properties;
/* 547 */     if (this._properties != null) {
/* 548 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 549 */       Iterator<IDataModel> it = this._properties.iterator();
/* 550 */       while (it.hasNext()) {
/* 551 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 556 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 561 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 564 */     super.rollbackChanges();
/*     */     
/* 566 */     this._properties = this._propertiesSavepoint;
/* 567 */     this._propertiesSavepoint = null;
/* 568 */     if (this._properties != null) {
/* 569 */       Iterator<IDataModel> it = this._properties.iterator();
/* 570 */       while (it.hasNext()) {
/* 571 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 579 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 582 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 585 */     super.commitTransaction();
/*     */     
/* 587 */     this._propertiesSavepoint = this._properties;
/* 588 */     if (this._properties != null) {
/* 589 */       Iterator<IDataModel> it = this._properties.iterator();
/* 590 */       while (it.hasNext()) {
/* 591 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 593 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 597 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 602 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\CycleQuestionAnswerModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */