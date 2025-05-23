/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.DataFactory;
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
/*     */ import dtv.xst.dao.inv.CartonPropertyId;
/*     */ import dtv.xst.dao.inv.ICarton;
/*     */ import dtv.xst.dao.inv.ICartonProperty;
/*     */ import dtv.xst.dao.inv.IInventoryDocument;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CartonModel
/*     */   extends CartonBaseModel implements ICarton {
/*     */   private static final long serialVersionUID = 2011245855L;
/*     */   private IInventoryDocument _parentDocument;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<ICartonProperty> _properties; private transient HistoricalList<ICartonProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new CartonDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CartonDAO getDAO_() {
/*  49 */     return (CartonDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/*  57 */     return getDAO_().getDocumentId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  65 */     if (setDocumentId_noev(argDocumentId) && 
/*  66 */       this._events != null && 
/*  67 */       postEventsForChanges()) {
/*  68 */       this._events.post(ICarton.SET_DOCUMENTID, argDocumentId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentId_noev(String argDocumentId) {
/*  75 */     boolean ev_postable = false;
/*     */     
/*  77 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/*  78 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/*  79 */       getDAO_().setDocumentId(argDocumentId);
/*  80 */       ev_postable = true;
/*  81 */       if (this._properties != null) {
/*     */         
/*  83 */         Iterator<CartonPropertyModel> it = this._properties.iterator();
/*  84 */         while (it.hasNext())
/*     */         {
/*  86 */           ((CartonPropertyModel)it.next()).setDocumentId_noev(argDocumentId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  91 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentTypeCode() {
/*  99 */     return getDAO_().getDocumentTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/* 107 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/* 108 */       this._events != null && 
/* 109 */       postEventsForChanges()) {
/* 110 */       this._events.post(ICarton.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/* 117 */     boolean ev_postable = false;
/*     */     
/* 119 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/* 120 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/* 121 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/* 122 */       ev_postable = true;
/* 123 */       if (this._properties != null) {
/*     */         
/* 125 */         Iterator<CartonPropertyModel> it = this._properties.iterator();
/* 126 */         while (it.hasNext())
/*     */         {
/* 128 */           ((CartonPropertyModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 133 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCartonId() {
/* 141 */     return getDAO_().getCartonId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCartonId(String argCartonId) {
/* 149 */     if (setCartonId_noev(argCartonId) && 
/* 150 */       this._events != null && 
/* 151 */       postEventsForChanges()) {
/* 152 */       this._events.post(ICarton.SET_CARTONID, argCartonId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCartonId_noev(String argCartonId) {
/* 159 */     boolean ev_postable = false;
/*     */     
/* 161 */     if ((getDAO_().getCartonId() == null && argCartonId != null) || (
/* 162 */       getDAO_().getCartonId() != null && !getDAO_().getCartonId().equals(argCartonId))) {
/* 163 */       getDAO_().setCartonId(argCartonId);
/* 164 */       ev_postable = true;
/* 165 */       if (this._properties != null) {
/*     */         
/* 167 */         Iterator<CartonPropertyModel> it = this._properties.iterator();
/* 168 */         while (it.hasNext())
/*     */         {
/* 170 */           ((CartonPropertyModel)it.next()).setCartonId_noev(argCartonId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 175 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 183 */     if (getDAO_().getOrganizationId() != null) {
/* 184 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 187 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 196 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 197 */       this._events != null && 
/* 198 */       postEventsForChanges()) {
/* 199 */       this._events.post(ICarton.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 206 */     boolean ev_postable = false;
/*     */     
/* 208 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 209 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 210 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 211 */       ev_postable = true;
/* 212 */       if (this._properties != null) {
/*     */         
/* 214 */         Iterator<CartonPropertyModel> it = this._properties.iterator();
/* 215 */         while (it.hasNext())
/*     */         {
/* 217 */           ((CartonPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 222 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 230 */     if (getDAO_().getRetailLocationId() != null) {
/* 231 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 234 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 243 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 244 */       this._events != null && 
/* 245 */       postEventsForChanges()) {
/* 246 */       this._events.post(ICarton.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 253 */     boolean ev_postable = false;
/*     */     
/* 255 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 256 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 257 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 258 */       ev_postable = true;
/* 259 */       if (this._properties != null) {
/*     */         
/* 261 */         Iterator<CartonPropertyModel> it = this._properties.iterator();
/* 262 */         while (it.hasNext())
/*     */         {
/* 264 */           ((CartonPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 269 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 277 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 285 */     if (setCreateDate_noev(argCreateDate) && 
/* 286 */       this._events != null && 
/* 287 */       postEventsForChanges()) {
/* 288 */       this._events.post(ICarton.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 295 */     boolean ev_postable = false;
/*     */     
/* 297 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 298 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 299 */       getDAO_().setCreateDate(argCreateDate);
/* 300 */       ev_postable = true;
/*     */     } 
/*     */     
/* 303 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 311 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 319 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 320 */       this._events != null && 
/* 321 */       postEventsForChanges()) {
/* 322 */       this._events.post(ICarton.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 329 */     boolean ev_postable = false;
/*     */     
/* 331 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 332 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 333 */       getDAO_().setCreateUserId(argCreateUserId);
/* 334 */       ev_postable = true;
/*     */     } 
/*     */     
/* 337 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 345 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 353 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 354 */       this._events != null && 
/* 355 */       postEventsForChanges()) {
/* 356 */       this._events.post(ICarton.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 363 */     boolean ev_postable = false;
/*     */     
/* 365 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 366 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 367 */       getDAO_().setUpdateDate(argUpdateDate);
/* 368 */       ev_postable = true;
/*     */     } 
/*     */     
/* 371 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 379 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 387 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 388 */       this._events != null && 
/* 389 */       postEventsForChanges()) {
/* 390 */       this._events.post(ICarton.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 397 */     boolean ev_postable = false;
/*     */     
/* 399 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 400 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 401 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 402 */       ev_postable = true;
/*     */     } 
/*     */     
/* 405 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCartonStatusCode() {
/* 413 */     return getDAO_().getCartonStatusCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCartonStatusCode(String argCartonStatusCode) {
/* 421 */     if (setCartonStatusCode_noev(argCartonStatusCode) && 
/* 422 */       this._events != null && 
/* 423 */       postEventsForChanges()) {
/* 424 */       this._events.post(ICarton.SET_CARTONSTATUSCODE, argCartonStatusCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCartonStatusCode_noev(String argCartonStatusCode) {
/* 431 */     boolean ev_postable = false;
/*     */     
/* 433 */     if ((getDAO_().getCartonStatusCode() == null && argCartonStatusCode != null) || (
/* 434 */       getDAO_().getCartonStatusCode() != null && !getDAO_().getCartonStatusCode().equals(argCartonStatusCode))) {
/* 435 */       getDAO_().setCartonStatusCode(argCartonStatusCode);
/* 436 */       ev_postable = true;
/*     */     } 
/*     */     
/* 439 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getControlNumber() {
/* 447 */     return getDAO_().getControlNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setControlNumber(String argControlNumber) {
/* 455 */     if (setControlNumber_noev(argControlNumber) && 
/* 456 */       this._events != null && 
/* 457 */       postEventsForChanges()) {
/* 458 */       this._events.post(ICarton.SET_CONTROLNUMBER, argControlNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setControlNumber_noev(String argControlNumber) {
/* 465 */     boolean ev_postable = false;
/*     */     
/* 467 */     if ((getDAO_().getControlNumber() == null && argControlNumber != null) || (
/* 468 */       getDAO_().getControlNumber() != null && !getDAO_().getControlNumber().equals(argControlNumber))) {
/* 469 */       getDAO_().setControlNumber(argControlNumber);
/* 470 */       ev_postable = true;
/*     */     } 
/*     */     
/* 473 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRecordCreationType() {
/* 481 */     return getDAO_().getRecordCreationType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRecordCreationType(String argRecordCreationType) {
/* 489 */     if (setRecordCreationType_noev(argRecordCreationType) && 
/* 490 */       this._events != null && 
/* 491 */       postEventsForChanges()) {
/* 492 */       this._events.post(ICarton.SET_RECORDCREATIONTYPE, argRecordCreationType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRecordCreationType_noev(String argRecordCreationType) {
/* 499 */     boolean ev_postable = false;
/*     */     
/* 501 */     if ((getDAO_().getRecordCreationType() == null && argRecordCreationType != null) || (
/* 502 */       getDAO_().getRecordCreationType() != null && !getDAO_().getRecordCreationType().equals(argRecordCreationType))) {
/* 503 */       getDAO_().setRecordCreationType(argRecordCreationType);
/* 504 */       ev_postable = true;
/*     */     } 
/*     */     
/* 507 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICartonProperty newProperty(String argPropertyName) {
/* 511 */     CartonPropertyId id = new CartonPropertyId();
/*     */     
/* 513 */     id.setDocumentId(getDocumentId());
/* 514 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 515 */     id.setCartonId(getCartonId());
/* 516 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 517 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 519 */     ICartonProperty prop = (ICartonProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICartonProperty.class);
/* 520 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICartonProperty> getProperties() {
/* 529 */     if (this._properties == null) {
/* 530 */       this._properties = new HistoricalList(null);
/*     */     }
/* 532 */     return (List<ICartonProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICartonProperty> argProperties) {
/* 536 */     if (this._properties == null) {
/* 537 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 539 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 542 */     for (ICartonProperty child : this._properties) {
/* 543 */       CartonPropertyModel model = (CartonPropertyModel)child;
/* 544 */       model.setDocumentId_noev(getDocumentId());
/* 545 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 546 */       model.setCartonId_noev(getCartonId());
/* 547 */       model.setOrganizationId_noev(getOrganizationId());
/* 548 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 549 */       if (child instanceof IDataModelImpl) {
/* 550 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 551 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 552 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 553 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 556 */       if (postEventsForChanges()) {
/* 557 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCartonProperty(ICartonProperty argCartonProperty) {
/* 563 */     if (this._properties == null) {
/* 564 */       this._properties = new HistoricalList(null);
/*     */     }
/* 566 */     argCartonProperty.setDocumentId(getDocumentId());
/* 567 */     argCartonProperty.setDocumentTypeCode(getDocumentTypeCode());
/* 568 */     argCartonProperty.setCartonId(getCartonId());
/* 569 */     argCartonProperty.setOrganizationId(getOrganizationId());
/* 570 */     argCartonProperty.setRetailLocationId(getRetailLocationId());
/* 571 */     if (argCartonProperty instanceof IDataModelImpl) {
/* 572 */       IDataAccessObject childDao = ((IDataModelImpl)argCartonProperty).getDAO();
/* 573 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 574 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 575 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 580 */     if (postEventsForChanges()) {
/* 581 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCartonProperty));
/*     */     }
/*     */     
/* 584 */     this._properties.add(argCartonProperty);
/* 585 */     if (postEventsForChanges()) {
/* 586 */       this._events.post(ICarton.ADD_PROPERTIES, argCartonProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCartonProperty(ICartonProperty argCartonProperty) {
/* 591 */     if (this._properties != null) {
/*     */       
/* 593 */       if (postEventsForChanges()) {
/* 594 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCartonProperty));
/*     */       }
/* 596 */       this._properties.remove(argCartonProperty);
/* 597 */       if (postEventsForChanges()) {
/* 598 */         this._events.post(ICarton.REMOVE_PROPERTIES, argCartonProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentDocument(IInventoryDocument argParentDocument) {
/* 604 */     this._parentDocument = argParentDocument;
/*     */   }
/*     */   
/*     */   public IInventoryDocument getParentDocument() {
/* 608 */     return this._parentDocument;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 613 */     if ("Properties".equals(argFieldId)) {
/* 614 */       return getProperties();
/*     */     }
/* 616 */     if ("CartonExtension".equals(argFieldId)) {
/* 617 */       return this._myExtension;
/*     */     }
/*     */     
/* 620 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 626 */     if ("Properties".equals(argFieldId)) {
/* 627 */       setProperties(changeToList(argValue, ICartonProperty.class));
/*     */     }
/* 629 */     else if ("CartonExtension".equals(argFieldId)) {
/* 630 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 633 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 639 */     this._persistenceDefaults = argPD;
/* 640 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 641 */     this._eventManager = argEM;
/* 642 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 643 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 644 */     if (this._properties != null) {
/* 645 */       for (ICartonProperty relationship : this._properties) {
/* 646 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCartonExt() {
/* 652 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCartonExt(IDataModel argExt) {
/* 656 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 661 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 665 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 668 */     super.startTransaction();
/*     */     
/* 670 */     this._propertiesSavepoint = this._properties;
/* 671 */     if (this._properties != null) {
/* 672 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 673 */       Iterator<IDataModel> it = this._properties.iterator();
/* 674 */       while (it.hasNext()) {
/* 675 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 680 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 685 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 688 */     super.rollbackChanges();
/*     */     
/* 690 */     this._properties = this._propertiesSavepoint;
/* 691 */     this._propertiesSavepoint = null;
/* 692 */     if (this._properties != null) {
/* 693 */       Iterator<IDataModel> it = this._properties.iterator();
/* 694 */       while (it.hasNext()) {
/* 695 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 703 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 706 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 709 */     super.commitTransaction();
/*     */     
/* 711 */     this._propertiesSavepoint = this._properties;
/* 712 */     if (this._properties != null) {
/* 713 */       Iterator<IDataModel> it = this._properties.iterator();
/* 714 */       while (it.hasNext()) {
/* 715 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 717 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 721 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\CartonModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */