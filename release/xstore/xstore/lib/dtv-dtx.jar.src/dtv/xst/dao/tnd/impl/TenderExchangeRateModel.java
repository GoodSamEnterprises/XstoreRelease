/*     */ package dtv.xst.dao.tnd.impl;
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
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.tnd.ITenderExchangeRate;
/*     */ import dtv.xst.dao.tnd.ITenderExchangeRateProperty;
/*     */ import dtv.xst.dao.tnd.TenderExchangeRatePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TenderExchangeRateModel extends AbstractDataModelWithPropertyImpl<ITenderExchangeRateProperty> implements ITenderExchangeRate {
/*     */   private static final long serialVersionUID = 186706615L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ITenderExchangeRateProperty> _properties; private transient HistoricalList<ITenderExchangeRateProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new TenderExchangeRateDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TenderExchangeRateDAO getDAO_() {
/*  46 */     return (TenderExchangeRateDAO)this._daoImpl;
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
/*  70 */       this._events.post(ITenderExchangeRate.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<TenderExchangeRatePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((TenderExchangeRatePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getBaseCurrency() {
/* 101 */     return getDAO_().getBaseCurrency();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBaseCurrency(String argBaseCurrency) {
/* 109 */     if (setBaseCurrency_noev(argBaseCurrency) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(ITenderExchangeRate.SET_BASECURRENCY, argBaseCurrency);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBaseCurrency_noev(String argBaseCurrency) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getBaseCurrency() == null && argBaseCurrency != null) || (
/* 122 */       getDAO_().getBaseCurrency() != null && !getDAO_().getBaseCurrency().equals(argBaseCurrency))) {
/* 123 */       getDAO_().setBaseCurrency(argBaseCurrency);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<TenderExchangeRatePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((TenderExchangeRatePropertyModel)it.next()).setBaseCurrency_noev(argBaseCurrency);
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
/*     */   public String getTargetCurrency() {
/* 143 */     return getDAO_().getTargetCurrency();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTargetCurrency(String argTargetCurrency) {
/* 151 */     if (setTargetCurrency_noev(argTargetCurrency) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(ITenderExchangeRate.SET_TARGETCURRENCY, argTargetCurrency);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTargetCurrency_noev(String argTargetCurrency) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getTargetCurrency() == null && argTargetCurrency != null) || (
/* 164 */       getDAO_().getTargetCurrency() != null && !getDAO_().getTargetCurrency().equals(argTargetCurrency))) {
/* 165 */       getDAO_().setTargetCurrency(argTargetCurrency);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<TenderExchangeRatePropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((TenderExchangeRatePropertyModel)it.next()).setTargetCurrency_noev(argTargetCurrency);
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
/*     */   public String getLevelCode() {
/* 185 */     return getDAO_().getLevelCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/* 193 */     if (setLevelCode_noev(argLevelCode) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(ITenderExchangeRate.SET_LEVELCODE, argLevelCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLevelCode_noev(String argLevelCode) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getLevelCode() == null && argLevelCode != null) || (
/* 206 */       getDAO_().getLevelCode() != null && !getDAO_().getLevelCode().equals(argLevelCode))) {
/* 207 */       getDAO_().setLevelCode(argLevelCode);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<TenderExchangeRatePropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((TenderExchangeRatePropertyModel)it.next()).setLevelCode_noev(argLevelCode);
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
/*     */   public String getLevelValue() {
/* 227 */     return getDAO_().getLevelValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/* 235 */     if (setLevelValue_noev(argLevelValue) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(ITenderExchangeRate.SET_LEVELVALUE, argLevelValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLevelValue_noev(String argLevelValue) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getLevelValue() == null && argLevelValue != null) || (
/* 248 */       getDAO_().getLevelValue() != null && !getDAO_().getLevelValue().equals(argLevelValue))) {
/* 249 */       getDAO_().setLevelValue(argLevelValue);
/* 250 */       ev_postable = true;
/* 251 */       if (this._properties != null) {
/*     */         
/* 253 */         Iterator<TenderExchangeRatePropertyModel> it = this._properties.iterator();
/* 254 */         while (it.hasNext())
/*     */         {
/* 256 */           ((TenderExchangeRatePropertyModel)it.next()).setLevelValue_noev(argLevelValue);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 261 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 269 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 277 */     if (setCreateDate_noev(argCreateDate) && 
/* 278 */       this._events != null && 
/* 279 */       postEventsForChanges()) {
/* 280 */       this._events.post(ITenderExchangeRate.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 287 */     boolean ev_postable = false;
/*     */     
/* 289 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 290 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 291 */       getDAO_().setCreateDate(argCreateDate);
/* 292 */       ev_postable = true;
/*     */     } 
/*     */     
/* 295 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 303 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 311 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 312 */       this._events != null && 
/* 313 */       postEventsForChanges()) {
/* 314 */       this._events.post(ITenderExchangeRate.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 321 */     boolean ev_postable = false;
/*     */     
/* 323 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 324 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 325 */       getDAO_().setCreateUserId(argCreateUserId);
/* 326 */       ev_postable = true;
/*     */     } 
/*     */     
/* 329 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 337 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 345 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 346 */       this._events != null && 
/* 347 */       postEventsForChanges()) {
/* 348 */       this._events.post(ITenderExchangeRate.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 355 */     boolean ev_postable = false;
/*     */     
/* 357 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 358 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 359 */       getDAO_().setUpdateDate(argUpdateDate);
/* 360 */       ev_postable = true;
/*     */     } 
/*     */     
/* 363 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 371 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 379 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 380 */       this._events != null && 
/* 381 */       postEventsForChanges()) {
/* 382 */       this._events.post(ITenderExchangeRate.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 389 */     boolean ev_postable = false;
/*     */     
/* 391 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 392 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 393 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 394 */       ev_postable = true;
/*     */     } 
/*     */     
/* 397 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getExchangeRate() {
/* 405 */     return getDAO_().getExchangeRate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExchangeRate(BigDecimal argExchangeRate) {
/* 413 */     if (setExchangeRate_noev(argExchangeRate) && 
/* 414 */       this._events != null && 
/* 415 */       postEventsForChanges()) {
/* 416 */       this._events.post(ITenderExchangeRate.SET_EXCHANGERATE, argExchangeRate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExchangeRate_noev(BigDecimal argExchangeRate) {
/* 423 */     boolean ev_postable = false;
/*     */     
/* 425 */     if ((getDAO_().getExchangeRate() == null && argExchangeRate != null) || (
/* 426 */       getDAO_().getExchangeRate() != null && !getDAO_().getExchangeRate().equals(argExchangeRate))) {
/* 427 */       getDAO_().setExchangeRate(argExchangeRate);
/* 428 */       ev_postable = true;
/*     */     } 
/*     */     
/* 431 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITenderExchangeRateProperty newProperty(String argPropertyName) {
/* 435 */     TenderExchangeRatePropertyId id = new TenderExchangeRatePropertyId();
/*     */     
/* 437 */     id.setBaseCurrency(getBaseCurrency());
/* 438 */     id.setTargetCurrency(getTargetCurrency());
/* 439 */     id.setLevelCode(getLevelCode());
/* 440 */     id.setLevelValue(getLevelValue());
/* 441 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 443 */     ITenderExchangeRateProperty prop = (ITenderExchangeRateProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITenderExchangeRateProperty.class);
/* 444 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITenderExchangeRateProperty> getProperties() {
/* 453 */     if (this._properties == null) {
/* 454 */       this._properties = new HistoricalList(null);
/*     */     }
/* 456 */     return (List<ITenderExchangeRateProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITenderExchangeRateProperty> argProperties) {
/* 460 */     if (this._properties == null) {
/* 461 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 463 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 466 */     for (ITenderExchangeRateProperty child : this._properties) {
/* 467 */       TenderExchangeRatePropertyModel model = (TenderExchangeRatePropertyModel)child;
/* 468 */       model.setOrganizationId_noev(getOrganizationId());
/* 469 */       model.setBaseCurrency_noev(getBaseCurrency());
/* 470 */       model.setTargetCurrency_noev(getTargetCurrency());
/* 471 */       model.setLevelCode_noev(getLevelCode());
/* 472 */       model.setLevelValue_noev(getLevelValue());
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
/*     */   public void addTenderExchangeRateProperty(ITenderExchangeRateProperty argTenderExchangeRateProperty) {
/* 487 */     if (this._properties == null) {
/* 488 */       this._properties = new HistoricalList(null);
/*     */     }
/* 490 */     argTenderExchangeRateProperty.setOrganizationId(getOrganizationId());
/* 491 */     argTenderExchangeRateProperty.setBaseCurrency(getBaseCurrency());
/* 492 */     argTenderExchangeRateProperty.setTargetCurrency(getTargetCurrency());
/* 493 */     argTenderExchangeRateProperty.setLevelCode(getLevelCode());
/* 494 */     argTenderExchangeRateProperty.setLevelValue(getLevelValue());
/* 495 */     if (argTenderExchangeRateProperty instanceof IDataModelImpl) {
/* 496 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderExchangeRateProperty).getDAO();
/* 497 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 498 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 499 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 504 */     if (postEventsForChanges()) {
/* 505 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderExchangeRateProperty));
/*     */     }
/*     */     
/* 508 */     this._properties.add(argTenderExchangeRateProperty);
/* 509 */     if (postEventsForChanges()) {
/* 510 */       this._events.post(ITenderExchangeRate.ADD_PROPERTIES, argTenderExchangeRateProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTenderExchangeRateProperty(ITenderExchangeRateProperty argTenderExchangeRateProperty) {
/* 515 */     if (this._properties != null) {
/*     */       
/* 517 */       if (postEventsForChanges()) {
/* 518 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderExchangeRateProperty));
/*     */       }
/* 520 */       this._properties.remove(argTenderExchangeRateProperty);
/* 521 */       if (postEventsForChanges()) {
/* 522 */         this._events.post(ITenderExchangeRate.REMOVE_PROPERTIES, argTenderExchangeRateProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 529 */     if ("Properties".equals(argFieldId)) {
/* 530 */       return getProperties();
/*     */     }
/* 532 */     if ("TenderExchangeRateExtension".equals(argFieldId)) {
/* 533 */       return this._myExtension;
/*     */     }
/*     */     
/* 536 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 542 */     if ("Properties".equals(argFieldId)) {
/* 543 */       setProperties(changeToList(argValue, ITenderExchangeRateProperty.class));
/*     */     }
/* 545 */     else if ("TenderExchangeRateExtension".equals(argFieldId)) {
/* 546 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 549 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 555 */     this._persistenceDefaults = argPD;
/* 556 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 557 */     this._eventManager = argEM;
/* 558 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 559 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 560 */     if (this._properties != null) {
/* 561 */       for (ITenderExchangeRateProperty relationship : this._properties) {
/* 562 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTenderExchangeRateExt() {
/* 568 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTenderExchangeRateExt(IDataModel argExt) {
/* 572 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 577 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 581 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 584 */     super.startTransaction();
/*     */     
/* 586 */     this._propertiesSavepoint = this._properties;
/* 587 */     if (this._properties != null) {
/* 588 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 589 */       Iterator<IDataModel> it = this._properties.iterator();
/* 590 */       while (it.hasNext()) {
/* 591 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 596 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 601 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 604 */     super.rollbackChanges();
/*     */     
/* 606 */     this._properties = this._propertiesSavepoint;
/* 607 */     this._propertiesSavepoint = null;
/* 608 */     if (this._properties != null) {
/* 609 */       Iterator<IDataModel> it = this._properties.iterator();
/* 610 */       while (it.hasNext()) {
/* 611 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 619 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 622 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 625 */     super.commitTransaction();
/*     */     
/* 627 */     this._propertiesSavepoint = this._properties;
/* 628 */     if (this._properties != null) {
/* 629 */       Iterator<IDataModel> it = this._properties.iterator();
/* 630 */       while (it.hasNext()) {
/* 631 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 633 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 637 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 642 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderExchangeRateModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */