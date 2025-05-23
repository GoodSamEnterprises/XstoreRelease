/*     */ package dtv.xst.dao.trn.impl;
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
/*     */ import dtv.xst.dao.trn.ILineItemGenericStorage;
/*     */ import dtv.xst.dao.trn.ILineItemGenericStorageProperty;
/*     */ import dtv.xst.dao.trn.LineItemGenericStoragePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class LineItemGenericStorageModel extends AbstractDataModelWithPropertyImpl<ILineItemGenericStorageProperty> implements ILineItemGenericStorage {
/*     */   private static final long serialVersionUID = 608488907L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ILineItemGenericStorageProperty> _properties; private transient HistoricalList<ILineItemGenericStorageProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new LineItemGenericStorageDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private LineItemGenericStorageDAO getDAO_() {
/*  46 */     return (LineItemGenericStorageDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/*  54 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  62 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  63 */       this._events != null && 
/*  64 */       postEventsForChanges()) {
/*  65 */       this._events.post(ILineItemGenericStorage.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  72 */     boolean ev_postable = false;
/*     */     
/*  74 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  75 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  76 */       getDAO_().setBusinessDate(argBusinessDate);
/*  77 */       ev_postable = true;
/*  78 */       if (this._properties != null) {
/*     */         
/*  80 */         Iterator<LineItemGenericStoragePropertyModel> it = this._properties.iterator();
/*  81 */         while (it.hasNext())
/*     */         {
/*  83 */           ((LineItemGenericStoragePropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*     */   public long getOrganizationId() {
/*  96 */     if (getDAO_().getOrganizationId() != null) {
/*  97 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 100 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 109 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(ILineItemGenericStorage.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 122 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 123 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<LineItemGenericStoragePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((LineItemGenericStoragePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 143 */     if (getDAO_().getRetailLocationId() != null) {
/* 144 */       return getDAO_().getRetailLocationId().longValue();
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
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 156 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(ILineItemGenericStorage.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 169 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 170 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<LineItemGenericStoragePropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((LineItemGenericStoragePropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public int getLineItemSequence() {
/* 190 */     if (getDAO_().getLineItemSequence() != null) {
/* 191 */       return getDAO_().getLineItemSequence().intValue();
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
/*     */   public void setLineItemSequence(int argLineItemSequence) {
/* 203 */     if (setLineItemSequence_noev(argLineItemSequence) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(ILineItemGenericStorage.SET_LINEITEMSEQUENCE, Integer.valueOf(argLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLineItemSequence_noev(int argLineItemSequence) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getLineItemSequence() == null && Integer.valueOf(argLineItemSequence) != null) || (
/* 216 */       getDAO_().getLineItemSequence() != null && !getDAO_().getLineItemSequence().equals(Integer.valueOf(argLineItemSequence)))) {
/* 217 */       getDAO_().setLineItemSequence(Integer.valueOf(argLineItemSequence));
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<LineItemGenericStoragePropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((LineItemGenericStoragePropertyModel)it.next()).setLineItemSequence_noev(argLineItemSequence);
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
/*     */   public long getTransactionSequence() {
/* 237 */     if (getDAO_().getTransactionSequence() != null) {
/* 238 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 241 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 250 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 251 */       this._events != null && 
/* 252 */       postEventsForChanges()) {
/* 253 */       this._events.post(ILineItemGenericStorage.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 260 */     boolean ev_postable = false;
/*     */     
/* 262 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 263 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 264 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 265 */       ev_postable = true;
/* 266 */       if (this._properties != null) {
/*     */         
/* 268 */         Iterator<LineItemGenericStoragePropertyModel> it = this._properties.iterator();
/* 269 */         while (it.hasNext())
/*     */         {
/* 271 */           ((LineItemGenericStoragePropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 276 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 284 */     if (getDAO_().getWorkstationId() != null) {
/* 285 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 288 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 297 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 298 */       this._events != null && 
/* 299 */       postEventsForChanges()) {
/* 300 */       this._events.post(ILineItemGenericStorage.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 307 */     boolean ev_postable = false;
/*     */     
/* 309 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 310 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 311 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 312 */       ev_postable = true;
/* 313 */       if (this._properties != null) {
/*     */         
/* 315 */         Iterator<LineItemGenericStoragePropertyModel> it = this._properties.iterator();
/* 316 */         while (it.hasNext())
/*     */         {
/* 318 */           ((LineItemGenericStoragePropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 323 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 331 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 339 */     if (setCreateDate_noev(argCreateDate) && 
/* 340 */       this._events != null && 
/* 341 */       postEventsForChanges()) {
/* 342 */       this._events.post(ILineItemGenericStorage.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 349 */     boolean ev_postable = false;
/*     */     
/* 351 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 352 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 353 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 365 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 373 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 374 */       this._events != null && 
/* 375 */       postEventsForChanges()) {
/* 376 */       this._events.post(ILineItemGenericStorage.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 383 */     boolean ev_postable = false;
/*     */     
/* 385 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 386 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 387 */       getDAO_().setCreateUserId(argCreateUserId);
/* 388 */       ev_postable = true;
/*     */     } 
/*     */     
/* 391 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 399 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 407 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 408 */       this._events != null && 
/* 409 */       postEventsForChanges()) {
/* 410 */       this._events.post(ILineItemGenericStorage.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 417 */     boolean ev_postable = false;
/*     */     
/* 419 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 420 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 421 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 433 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 441 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 442 */       this._events != null && 
/* 443 */       postEventsForChanges()) {
/* 444 */       this._events.post(ILineItemGenericStorage.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 451 */     boolean ev_postable = false;
/*     */     
/* 453 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 454 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 455 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 456 */       ev_postable = true;
/*     */     } 
/*     */     
/* 459 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDataStorage() {
/* 467 */     return getDAO_().getDataStorage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataStorage(String argDataStorage) {
/* 475 */     if (setDataStorage_noev(argDataStorage) && 
/* 476 */       this._events != null && 
/* 477 */       postEventsForChanges()) {
/* 478 */       this._events.post(ILineItemGenericStorage.SET_DATASTORAGE, argDataStorage);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDataStorage_noev(String argDataStorage) {
/* 485 */     boolean ev_postable = false;
/*     */     
/* 487 */     if ((getDAO_().getDataStorage() == null && argDataStorage != null) || (
/* 488 */       getDAO_().getDataStorage() != null && !getDAO_().getDataStorage().equals(argDataStorage))) {
/* 489 */       getDAO_().setDataStorage(argDataStorage);
/* 490 */       ev_postable = true;
/*     */     } 
/*     */     
/* 493 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ILineItemGenericStorageProperty newProperty(String argPropertyName) {
/* 497 */     LineItemGenericStoragePropertyId id = new LineItemGenericStoragePropertyId();
/*     */     
/* 499 */     id.setBusinessDate(getBusinessDate());
/* 500 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 501 */     id.setLineItemSequence(Integer.valueOf(getLineItemSequence()));
/* 502 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 503 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 504 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 506 */     ILineItemGenericStorageProperty prop = (ILineItemGenericStorageProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ILineItemGenericStorageProperty.class);
/* 507 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ILineItemGenericStorageProperty> getProperties() {
/* 516 */     if (this._properties == null) {
/* 517 */       this._properties = new HistoricalList(null);
/*     */     }
/* 519 */     return (List<ILineItemGenericStorageProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ILineItemGenericStorageProperty> argProperties) {
/* 523 */     if (this._properties == null) {
/* 524 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 526 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 529 */     for (ILineItemGenericStorageProperty child : this._properties) {
/* 530 */       LineItemGenericStoragePropertyModel model = (LineItemGenericStoragePropertyModel)child;
/* 531 */       model.setBusinessDate_noev(getBusinessDate());
/* 532 */       model.setOrganizationId_noev(getOrganizationId());
/* 533 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 534 */       model.setLineItemSequence_noev(getLineItemSequence());
/* 535 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 536 */       model.setWorkstationId_noev(getWorkstationId());
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
/*     */   public void addLineItemGenericStorageProperty(ILineItemGenericStorageProperty argLineItemGenericStorageProperty) {
/* 551 */     if (this._properties == null) {
/* 552 */       this._properties = new HistoricalList(null);
/*     */     }
/* 554 */     argLineItemGenericStorageProperty.setBusinessDate(getBusinessDate());
/* 555 */     argLineItemGenericStorageProperty.setOrganizationId(getOrganizationId());
/* 556 */     argLineItemGenericStorageProperty.setRetailLocationId(getRetailLocationId());
/* 557 */     argLineItemGenericStorageProperty.setLineItemSequence(getLineItemSequence());
/* 558 */     argLineItemGenericStorageProperty.setTransactionSequence(getTransactionSequence());
/* 559 */     argLineItemGenericStorageProperty.setWorkstationId(getWorkstationId());
/* 560 */     if (argLineItemGenericStorageProperty instanceof IDataModelImpl) {
/* 561 */       IDataAccessObject childDao = ((IDataModelImpl)argLineItemGenericStorageProperty).getDAO();
/* 562 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 563 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 564 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 569 */     if (postEventsForChanges()) {
/* 570 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argLineItemGenericStorageProperty));
/*     */     }
/*     */     
/* 573 */     this._properties.add(argLineItemGenericStorageProperty);
/* 574 */     if (postEventsForChanges()) {
/* 575 */       this._events.post(ILineItemGenericStorage.ADD_PROPERTIES, argLineItemGenericStorageProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeLineItemGenericStorageProperty(ILineItemGenericStorageProperty argLineItemGenericStorageProperty) {
/* 580 */     if (this._properties != null) {
/*     */       
/* 582 */       if (postEventsForChanges()) {
/* 583 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argLineItemGenericStorageProperty));
/*     */       }
/* 585 */       this._properties.remove(argLineItemGenericStorageProperty);
/* 586 */       if (postEventsForChanges()) {
/* 587 */         this._events.post(ILineItemGenericStorage.REMOVE_PROPERTIES, argLineItemGenericStorageProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 594 */     if ("Properties".equals(argFieldId)) {
/* 595 */       return getProperties();
/*     */     }
/* 597 */     if ("LineItemGenericStorageExtension".equals(argFieldId)) {
/* 598 */       return this._myExtension;
/*     */     }
/*     */     
/* 601 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 607 */     if ("Properties".equals(argFieldId)) {
/* 608 */       setProperties(changeToList(argValue, ILineItemGenericStorageProperty.class));
/*     */     }
/* 610 */     else if ("LineItemGenericStorageExtension".equals(argFieldId)) {
/* 611 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 614 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 620 */     this._persistenceDefaults = argPD;
/* 621 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 622 */     this._eventManager = argEM;
/* 623 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 624 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 625 */     if (this._properties != null) {
/* 626 */       for (ILineItemGenericStorageProperty relationship : this._properties) {
/* 627 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getLineItemGenericStorageExt() {
/* 633 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setLineItemGenericStorageExt(IDataModel argExt) {
/* 637 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 642 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 646 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 649 */     super.startTransaction();
/*     */     
/* 651 */     this._propertiesSavepoint = this._properties;
/* 652 */     if (this._properties != null) {
/* 653 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 654 */       Iterator<IDataModel> it = this._properties.iterator();
/* 655 */       while (it.hasNext()) {
/* 656 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 661 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 666 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 669 */     super.rollbackChanges();
/*     */     
/* 671 */     this._properties = this._propertiesSavepoint;
/* 672 */     this._propertiesSavepoint = null;
/* 673 */     if (this._properties != null) {
/* 674 */       Iterator<IDataModel> it = this._properties.iterator();
/* 675 */       while (it.hasNext()) {
/* 676 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 684 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 687 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 690 */     super.commitTransaction();
/*     */     
/* 692 */     this._propertiesSavepoint = this._properties;
/* 693 */     if (this._properties != null) {
/* 694 */       Iterator<IDataModel> it = this._properties.iterator();
/* 695 */       while (it.hasNext()) {
/* 696 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 698 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 702 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 707 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\LineItemGenericStorageModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */