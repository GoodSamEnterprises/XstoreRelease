/*     */ package dtv.xst.dao.tsn.impl;
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
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.Money;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.tsn.ITenderRepository;
/*     */ import dtv.xst.dao.tsn.ITenderRepositoryFloat;
/*     */ import dtv.xst.dao.tsn.ITenderRepositoryFloatProperty;
/*     */ import dtv.xst.dao.tsn.TenderRepositoryFloatPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Currency;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TenderRepositoryFloatModel extends AbstractDataModelWithPropertyImpl<ITenderRepositoryFloatProperty> implements ITenderRepositoryFloat {
/*     */   private static final long serialVersionUID = 921069470L;
/*     */   private ITenderRepository _parentTenderRepository;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<ITenderRepositoryFloatProperty> _properties; private transient HistoricalList<ITenderRepositoryFloatProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new TenderRepositoryFloatDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TenderRepositoryFloatDAO getDAO_() {
/*  48 */     return (TenderRepositoryFloatDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  56 */     if (getDAO_().getOrganizationId() != null) {
/*  57 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  60 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  69 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  70 */       this._events != null && 
/*  71 */       postEventsForChanges()) {
/*  72 */       this._events.post(ITenderRepositoryFloat.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  79 */     boolean ev_postable = false;
/*     */     
/*  81 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  82 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  83 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  84 */       ev_postable = true;
/*  85 */       if (this._properties != null) {
/*     */         
/*  87 */         Iterator<TenderRepositoryFloatPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((TenderRepositoryFloatPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 103 */     if (getDAO_().getRetailLocationId() != null) {
/* 104 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 107 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 116 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 117 */       this._events != null && 
/* 118 */       postEventsForChanges()) {
/* 119 */       this._events.post(ITenderRepositoryFloat.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 126 */     boolean ev_postable = false;
/*     */     
/* 128 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 129 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 130 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 131 */       ev_postable = true;
/* 132 */       if (this._properties != null) {
/*     */         
/* 134 */         Iterator<TenderRepositoryFloatPropertyModel> it = this._properties.iterator();
/* 135 */         while (it.hasNext())
/*     */         {
/* 137 */           ((TenderRepositoryFloatPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTenderRepositoryId() {
/* 150 */     return getDAO_().getTenderRepositoryId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTenderRepositoryId(String argTenderRepositoryId) {
/* 158 */     if (setTenderRepositoryId_noev(argTenderRepositoryId) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(ITenderRepositoryFloat.SET_TENDERREPOSITORYID, argTenderRepositoryId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTenderRepositoryId_noev(String argTenderRepositoryId) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getTenderRepositoryId() == null && argTenderRepositoryId != null) || (
/* 171 */       getDAO_().getTenderRepositoryId() != null && !getDAO_().getTenderRepositoryId().equals(argTenderRepositoryId))) {
/* 172 */       getDAO_().setTenderRepositoryId(argTenderRepositoryId);
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<TenderRepositoryFloatPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((TenderRepositoryFloatPropertyModel)it.next()).setTenderRepositoryId_noev(argTenderRepositoryId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 184 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCurrencyId() {
/* 192 */     return getDAO_().getCurrencyId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrencyId(String argCurrencyId) {
/* 200 */     if (setCurrencyId_noev(argCurrencyId) && 
/* 201 */       this._events != null && 
/* 202 */       postEventsForChanges()) {
/* 203 */       this._events.post(ITenderRepositoryFloat.SET_CURRENCYID, argCurrencyId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCurrencyId_noev(String argCurrencyId) {
/* 210 */     boolean ev_postable = false;
/*     */     
/* 212 */     if ((getDAO_().getCurrencyId() == null && argCurrencyId != null) || (
/* 213 */       getDAO_().getCurrencyId() != null && !getDAO_().getCurrencyId().equals(argCurrencyId))) {
/* 214 */       getDAO_().setCurrencyId(argCurrencyId);
/* 215 */       ev_postable = true;
/* 216 */       if (this._properties != null) {
/*     */         
/* 218 */         Iterator<TenderRepositoryFloatPropertyModel> it = this._properties.iterator();
/* 219 */         while (it.hasNext())
/*     */         {
/* 221 */           ((TenderRepositoryFloatPropertyModel)it.next()).setCurrencyId_noev(argCurrencyId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 226 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 234 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 242 */     if (setCreateDate_noev(argCreateDate) && 
/* 243 */       this._events != null && 
/* 244 */       postEventsForChanges()) {
/* 245 */       this._events.post(ITenderRepositoryFloat.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 252 */     boolean ev_postable = false;
/*     */     
/* 254 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 255 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 256 */       getDAO_().setCreateDate(argCreateDate);
/* 257 */       ev_postable = true;
/*     */     } 
/*     */     
/* 260 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 268 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 276 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 277 */       this._events != null && 
/* 278 */       postEventsForChanges()) {
/* 279 */       this._events.post(ITenderRepositoryFloat.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 286 */     boolean ev_postable = false;
/*     */     
/* 288 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 289 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 290 */       getDAO_().setCreateUserId(argCreateUserId);
/* 291 */       ev_postable = true;
/*     */     } 
/*     */     
/* 294 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 302 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 310 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 311 */       this._events != null && 
/* 312 */       postEventsForChanges()) {
/* 313 */       this._events.post(ITenderRepositoryFloat.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 320 */     boolean ev_postable = false;
/*     */     
/* 322 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 323 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 324 */       getDAO_().setUpdateDate(argUpdateDate);
/* 325 */       ev_postable = true;
/*     */     } 
/*     */     
/* 328 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 336 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 344 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 345 */       this._events != null && 
/* 346 */       postEventsForChanges()) {
/* 347 */       this._events.post(ITenderRepositoryFloat.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 354 */     boolean ev_postable = false;
/*     */     
/* 356 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 357 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 358 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 359 */       ev_postable = true;
/*     */     } 
/*     */     
/* 362 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDefaultCashFloat() {
/* 370 */     return getDAO_().getDefaultCashFloat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultCashFloat(BigDecimal argDefaultCashFloat) {
/* 378 */     if (setDefaultCashFloat_noev(argDefaultCashFloat) && 
/* 379 */       this._events != null && 
/* 380 */       postEventsForChanges()) {
/* 381 */       this._events.post(ITenderRepositoryFloat.SET_DEFAULTCASHFLOAT, argDefaultCashFloat);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDefaultCashFloat_noev(BigDecimal argDefaultCashFloat) {
/* 388 */     boolean ev_postable = false;
/*     */     
/* 390 */     if ((getDAO_().getDefaultCashFloat() == null && argDefaultCashFloat != null) || (
/* 391 */       getDAO_().getDefaultCashFloat() != null && !getDAO_().getDefaultCashFloat().equals(argDefaultCashFloat))) {
/* 392 */       getDAO_().setDefaultCashFloat(argDefaultCashFloat);
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
/*     */   public BigDecimal getLastClosingCashAmt() {
/* 404 */     return getDAO_().getLastClosingCashAmt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastClosingCashAmt(BigDecimal argLastClosingCashAmt) {
/* 412 */     if (setLastClosingCashAmt_noev(argLastClosingCashAmt) && 
/* 413 */       this._events != null && 
/* 414 */       postEventsForChanges()) {
/* 415 */       this._events.post(ITenderRepositoryFloat.SET_LASTCLOSINGCASHAMT, argLastClosingCashAmt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLastClosingCashAmt_noev(BigDecimal argLastClosingCashAmt) {
/* 422 */     boolean ev_postable = false;
/*     */     
/* 424 */     if ((getDAO_().getLastClosingCashAmt() == null && argLastClosingCashAmt != null) || (
/* 425 */       getDAO_().getLastClosingCashAmt() != null && !getDAO_().getLastClosingCashAmt().equals(argLastClosingCashAmt))) {
/* 426 */       getDAO_().setLastClosingCashAmt(argLastClosingCashAmt);
/* 427 */       ev_postable = true;
/*     */     } 
/*     */     
/* 430 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITenderRepositoryFloatProperty newProperty(String argPropertyName) {
/* 434 */     TenderRepositoryFloatPropertyId id = new TenderRepositoryFloatPropertyId();
/*     */     
/* 436 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 437 */     id.setTenderRepositoryId(getTenderRepositoryId());
/* 438 */     id.setCurrencyId(getCurrencyId());
/* 439 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 441 */     ITenderRepositoryFloatProperty prop = (ITenderRepositoryFloatProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITenderRepositoryFloatProperty.class);
/* 442 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITenderRepositoryFloatProperty> getProperties() {
/* 451 */     if (this._properties == null) {
/* 452 */       this._properties = new HistoricalList(null);
/*     */     }
/* 454 */     return (List<ITenderRepositoryFloatProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITenderRepositoryFloatProperty> argProperties) {
/* 458 */     if (this._properties == null) {
/* 459 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 461 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 464 */     for (ITenderRepositoryFloatProperty child : this._properties) {
/* 465 */       TenderRepositoryFloatPropertyModel model = (TenderRepositoryFloatPropertyModel)child;
/* 466 */       model.setOrganizationId_noev(getOrganizationId());
/* 467 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 468 */       model.setTenderRepositoryId_noev(getTenderRepositoryId());
/* 469 */       model.setCurrencyId_noev(getCurrencyId());
/* 470 */       if (child instanceof IDataModelImpl) {
/* 471 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 472 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 473 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 474 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 477 */       if (postEventsForChanges()) {
/* 478 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTenderRepositoryFloatProperty(ITenderRepositoryFloatProperty argTenderRepositoryFloatProperty) {
/* 484 */     if (this._properties == null) {
/* 485 */       this._properties = new HistoricalList(null);
/*     */     }
/* 487 */     argTenderRepositoryFloatProperty.setOrganizationId(getOrganizationId());
/* 488 */     argTenderRepositoryFloatProperty.setRetailLocationId(getRetailLocationId());
/* 489 */     argTenderRepositoryFloatProperty.setTenderRepositoryId(getTenderRepositoryId());
/* 490 */     argTenderRepositoryFloatProperty.setCurrencyId(getCurrencyId());
/* 491 */     if (argTenderRepositoryFloatProperty instanceof IDataModelImpl) {
/* 492 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderRepositoryFloatProperty).getDAO();
/* 493 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 494 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 495 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 500 */     if (postEventsForChanges()) {
/* 501 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderRepositoryFloatProperty));
/*     */     }
/*     */     
/* 504 */     this._properties.add(argTenderRepositoryFloatProperty);
/* 505 */     if (postEventsForChanges()) {
/* 506 */       this._events.post(ITenderRepositoryFloat.ADD_PROPERTIES, argTenderRepositoryFloatProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTenderRepositoryFloatProperty(ITenderRepositoryFloatProperty argTenderRepositoryFloatProperty) {
/* 511 */     if (this._properties != null) {
/*     */       
/* 513 */       if (postEventsForChanges()) {
/* 514 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderRepositoryFloatProperty));
/*     */       }
/* 516 */       this._properties.remove(argTenderRepositoryFloatProperty);
/* 517 */       if (postEventsForChanges()) {
/* 518 */         this._events.post(ITenderRepositoryFloat.REMOVE_PROPERTIES, argTenderRepositoryFloatProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentTenderRepository(ITenderRepository argParentTenderRepository) {
/* 524 */     this._parentTenderRepository = argParentTenderRepository;
/*     */   }
/*     */   
/*     */   public ITenderRepository getParentTenderRepository() {
/* 528 */     return this._parentTenderRepository;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 533 */     if ("Properties".equals(argFieldId)) {
/* 534 */       return getProperties();
/*     */     }
/* 536 */     if ("TenderRepositoryFloatExtension".equals(argFieldId)) {
/* 537 */       return this._myExtension;
/*     */     }
/*     */     
/* 540 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 546 */     if ("Properties".equals(argFieldId)) {
/* 547 */       setProperties(changeToList(argValue, ITenderRepositoryFloatProperty.class));
/*     */     }
/* 549 */     else if ("TenderRepositoryFloatExtension".equals(argFieldId)) {
/* 550 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 553 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 559 */     this._persistenceDefaults = argPD;
/* 560 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 561 */     this._eventManager = argEM;
/* 562 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 563 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 564 */     if (this._properties != null) {
/* 565 */       for (ITenderRepositoryFloatProperty relationship : this._properties) {
/* 566 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTenderRepositoryFloatExt() {
/* 572 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTenderRepositoryFloatExt(IDataModel argExt) {
/* 576 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 581 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 585 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 588 */     super.startTransaction();
/*     */     
/* 590 */     this._propertiesSavepoint = this._properties;
/* 591 */     if (this._properties != null) {
/* 592 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 593 */       Iterator<IDataModel> it = this._properties.iterator();
/* 594 */       while (it.hasNext()) {
/* 595 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 600 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 605 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 608 */     super.rollbackChanges();
/*     */     
/* 610 */     this._properties = this._propertiesSavepoint;
/* 611 */     this._propertiesSavepoint = null;
/* 612 */     if (this._properties != null) {
/* 613 */       Iterator<IDataModel> it = this._properties.iterator();
/* 614 */       while (it.hasNext()) {
/* 615 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 623 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 626 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 629 */     super.commitTransaction();
/*     */     
/* 631 */     this._propertiesSavepoint = this._properties;
/* 632 */     if (this._properties != null) {
/* 633 */       Iterator<IDataModel> it = this._properties.iterator();
/* 634 */       while (it.hasNext()) {
/* 635 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 637 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 641 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 646 */     argStream.defaultReadObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Money getDefaultCashFloatAsMoney() {
/* 659 */     BigDecimal cashFloat = getDefaultCashFloat();
/* 660 */     Currency currency = Currency.getInstance(getCurrencyId());
/*     */     
/* 662 */     return new Money(cashFloat, currency);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderRepositoryFloatModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */