/*     */ package dtv.xst.dao.tax.impl;
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
/*     */ import dtv.xst.dao.tax.ITaxAuthority;
/*     */ import dtv.xst.dao.tax.ITaxAuthorityProperty;
/*     */ import dtv.xst.dao.tax.TaxAuthorityPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TaxAuthorityModel extends AbstractDataModelWithPropertyImpl<ITaxAuthorityProperty> implements ITaxAuthority {
/*     */   private static final long serialVersionUID = 1120218104L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ITaxAuthorityProperty> _properties; private transient HistoricalList<ITaxAuthorityProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new TaxAuthorityDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TaxAuthorityDAO getDAO_() {
/*  46 */     return (TaxAuthorityDAO)this._daoImpl;
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
/*  70 */       this._events.post(ITaxAuthority.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<TaxAuthorityPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((TaxAuthorityPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getTaxAuthorityId() {
/* 101 */     return getDAO_().getTaxAuthorityId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxAuthorityId(String argTaxAuthorityId) {
/* 109 */     if (setTaxAuthorityId_noev(argTaxAuthorityId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(ITaxAuthority.SET_TAXAUTHORITYID, argTaxAuthorityId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxAuthorityId_noev(String argTaxAuthorityId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getTaxAuthorityId() == null && argTaxAuthorityId != null) || (
/* 122 */       getDAO_().getTaxAuthorityId() != null && !getDAO_().getTaxAuthorityId().equals(argTaxAuthorityId))) {
/* 123 */       getDAO_().setTaxAuthorityId(argTaxAuthorityId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<TaxAuthorityPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((TaxAuthorityPropertyModel)it.next()).setTaxAuthorityId_noev(argTaxAuthorityId);
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
/*     */   public Date getCreateDate() {
/* 143 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 151 */     if (setCreateDate_noev(argCreateDate) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(ITaxAuthority.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 164 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 165 */       getDAO_().setCreateDate(argCreateDate);
/* 166 */       ev_postable = true;
/*     */     } 
/*     */     
/* 169 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 177 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 185 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 186 */       this._events != null && 
/* 187 */       postEventsForChanges()) {
/* 188 */       this._events.post(ITaxAuthority.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 195 */     boolean ev_postable = false;
/*     */     
/* 197 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 198 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 199 */       getDAO_().setCreateUserId(argCreateUserId);
/* 200 */       ev_postable = true;
/*     */     } 
/*     */     
/* 203 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 211 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 219 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 220 */       this._events != null && 
/* 221 */       postEventsForChanges()) {
/* 222 */       this._events.post(ITaxAuthority.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 229 */     boolean ev_postable = false;
/*     */     
/* 231 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 232 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 233 */       getDAO_().setUpdateDate(argUpdateDate);
/* 234 */       ev_postable = true;
/*     */     } 
/*     */     
/* 237 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 245 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 253 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 254 */       this._events != null && 
/* 255 */       postEventsForChanges()) {
/* 256 */       this._events.post(ITaxAuthority.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 263 */     boolean ev_postable = false;
/*     */     
/* 265 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 266 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 267 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 268 */       ev_postable = true;
/*     */     } 
/*     */     
/* 271 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 279 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 287 */     if (setOrgCode_noev(argOrgCode) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(ITaxAuthority.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 300 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 301 */       getDAO_().setOrgCode(argOrgCode);
/* 302 */       ev_postable = true;
/*     */     } 
/*     */     
/* 305 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 313 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 321 */     if (setOrgValue_noev(argOrgValue) && 
/* 322 */       this._events != null && 
/* 323 */       postEventsForChanges()) {
/* 324 */       this._events.post(ITaxAuthority.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 331 */     boolean ev_postable = false;
/*     */     
/* 333 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 334 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 335 */       getDAO_().setOrgValue(argOrgValue);
/* 336 */       ev_postable = true;
/*     */     } 
/*     */     
/* 339 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 347 */     return getDAO_().getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String argName) {
/* 355 */     if (setName_noev(argName) && 
/* 356 */       this._events != null && 
/* 357 */       postEventsForChanges()) {
/* 358 */       this._events.post(ITaxAuthority.SET_NAME, argName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setName_noev(String argName) {
/* 365 */     boolean ev_postable = false;
/*     */     
/* 367 */     if ((getDAO_().getName() == null && argName != null) || (
/* 368 */       getDAO_().getName() != null && !getDAO_().getName().equals(argName))) {
/* 369 */       getDAO_().setName(argName);
/* 370 */       ev_postable = true;
/*     */     } 
/*     */     
/* 373 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRoundingCode() {
/* 381 */     return getDAO_().getRoundingCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRoundingCode(String argRoundingCode) {
/* 389 */     if (setRoundingCode_noev(argRoundingCode) && 
/* 390 */       this._events != null && 
/* 391 */       postEventsForChanges()) {
/* 392 */       this._events.post(ITaxAuthority.SET_ROUNDINGCODE, argRoundingCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRoundingCode_noev(String argRoundingCode) {
/* 399 */     boolean ev_postable = false;
/*     */     
/* 401 */     if ((getDAO_().getRoundingCode() == null && argRoundingCode != null) || (
/* 402 */       getDAO_().getRoundingCode() != null && !getDAO_().getRoundingCode().equals(argRoundingCode))) {
/* 403 */       getDAO_().setRoundingCode(argRoundingCode);
/* 404 */       ev_postable = true;
/*     */     } 
/*     */     
/* 407 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRoundingDigitsQuantity() {
/* 415 */     if (getDAO_().getRoundingDigitsQuantity() != null) {
/* 416 */       return getDAO_().getRoundingDigitsQuantity().intValue();
/*     */     }
/*     */     
/* 419 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRoundingDigitsQuantity(int argRoundingDigitsQuantity) {
/* 428 */     if (setRoundingDigitsQuantity_noev(argRoundingDigitsQuantity) && 
/* 429 */       this._events != null && 
/* 430 */       postEventsForChanges()) {
/* 431 */       this._events.post(ITaxAuthority.SET_ROUNDINGDIGITSQUANTITY, Integer.valueOf(argRoundingDigitsQuantity));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRoundingDigitsQuantity_noev(int argRoundingDigitsQuantity) {
/* 438 */     boolean ev_postable = false;
/*     */     
/* 440 */     if ((getDAO_().getRoundingDigitsQuantity() == null && Integer.valueOf(argRoundingDigitsQuantity) != null) || (
/* 441 */       getDAO_().getRoundingDigitsQuantity() != null && !getDAO_().getRoundingDigitsQuantity().equals(Integer.valueOf(argRoundingDigitsQuantity)))) {
/* 442 */       getDAO_().setRoundingDigitsQuantity(Integer.valueOf(argRoundingDigitsQuantity));
/* 443 */       ev_postable = true;
/*     */     } 
/*     */     
/* 446 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExternalSystem() {
/* 454 */     return getDAO_().getExternalSystem();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExternalSystem(String argExternalSystem) {
/* 462 */     if (setExternalSystem_noev(argExternalSystem) && 
/* 463 */       this._events != null && 
/* 464 */       postEventsForChanges()) {
/* 465 */       this._events.post(ITaxAuthority.SET_EXTERNALSYSTEM, argExternalSystem);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExternalSystem_noev(String argExternalSystem) {
/* 472 */     boolean ev_postable = false;
/*     */     
/* 474 */     if ((getDAO_().getExternalSystem() == null && argExternalSystem != null) || (
/* 475 */       getDAO_().getExternalSystem() != null && !getDAO_().getExternalSystem().equals(argExternalSystem))) {
/* 476 */       getDAO_().setExternalSystem(argExternalSystem);
/* 477 */       ev_postable = true;
/*     */     } 
/*     */     
/* 480 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITaxAuthorityProperty newProperty(String argPropertyName) {
/* 484 */     TaxAuthorityPropertyId id = new TaxAuthorityPropertyId();
/*     */     
/* 486 */     id.setTaxAuthorityId(getTaxAuthorityId());
/* 487 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 489 */     ITaxAuthorityProperty prop = (ITaxAuthorityProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITaxAuthorityProperty.class);
/* 490 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITaxAuthorityProperty> getProperties() {
/* 499 */     if (this._properties == null) {
/* 500 */       this._properties = new HistoricalList(null);
/*     */     }
/* 502 */     return (List<ITaxAuthorityProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITaxAuthorityProperty> argProperties) {
/* 506 */     if (this._properties == null) {
/* 507 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 509 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 512 */     for (ITaxAuthorityProperty child : this._properties) {
/* 513 */       TaxAuthorityPropertyModel model = (TaxAuthorityPropertyModel)child;
/* 514 */       model.setOrganizationId_noev(getOrganizationId());
/* 515 */       model.setTaxAuthorityId_noev(getTaxAuthorityId());
/* 516 */       if (child instanceof IDataModelImpl) {
/* 517 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 518 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 519 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 520 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 523 */       if (postEventsForChanges()) {
/* 524 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTaxAuthorityProperty(ITaxAuthorityProperty argTaxAuthorityProperty) {
/* 530 */     if (this._properties == null) {
/* 531 */       this._properties = new HistoricalList(null);
/*     */     }
/* 533 */     argTaxAuthorityProperty.setOrganizationId(getOrganizationId());
/* 534 */     argTaxAuthorityProperty.setTaxAuthorityId(getTaxAuthorityId());
/* 535 */     if (argTaxAuthorityProperty instanceof IDataModelImpl) {
/* 536 */       IDataAccessObject childDao = ((IDataModelImpl)argTaxAuthorityProperty).getDAO();
/* 537 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 538 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 539 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 544 */     if (postEventsForChanges()) {
/* 545 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxAuthorityProperty));
/*     */     }
/*     */     
/* 548 */     this._properties.add(argTaxAuthorityProperty);
/* 549 */     if (postEventsForChanges()) {
/* 550 */       this._events.post(ITaxAuthority.ADD_PROPERTIES, argTaxAuthorityProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTaxAuthorityProperty(ITaxAuthorityProperty argTaxAuthorityProperty) {
/* 555 */     if (this._properties != null) {
/*     */       
/* 557 */       if (postEventsForChanges()) {
/* 558 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxAuthorityProperty));
/*     */       }
/* 560 */       this._properties.remove(argTaxAuthorityProperty);
/* 561 */       if (postEventsForChanges()) {
/* 562 */         this._events.post(ITaxAuthority.REMOVE_PROPERTIES, argTaxAuthorityProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 569 */     if ("Properties".equals(argFieldId)) {
/* 570 */       return getProperties();
/*     */     }
/* 572 */     if ("TaxAuthorityExtension".equals(argFieldId)) {
/* 573 */       return this._myExtension;
/*     */     }
/*     */     
/* 576 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 582 */     if ("Properties".equals(argFieldId)) {
/* 583 */       setProperties(changeToList(argValue, ITaxAuthorityProperty.class));
/*     */     }
/* 585 */     else if ("TaxAuthorityExtension".equals(argFieldId)) {
/* 586 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 589 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 595 */     this._persistenceDefaults = argPD;
/* 596 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 597 */     this._eventManager = argEM;
/* 598 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 599 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 600 */     if (this._properties != null) {
/* 601 */       for (ITaxAuthorityProperty relationship : this._properties) {
/* 602 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTaxAuthorityExt() {
/* 608 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTaxAuthorityExt(IDataModel argExt) {
/* 612 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 617 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 621 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 624 */     super.startTransaction();
/*     */     
/* 626 */     this._propertiesSavepoint = this._properties;
/* 627 */     if (this._properties != null) {
/* 628 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 629 */       Iterator<IDataModel> it = this._properties.iterator();
/* 630 */       while (it.hasNext()) {
/* 631 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 636 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 641 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 644 */     super.rollbackChanges();
/*     */     
/* 646 */     this._properties = this._propertiesSavepoint;
/* 647 */     this._propertiesSavepoint = null;
/* 648 */     if (this._properties != null) {
/* 649 */       Iterator<IDataModel> it = this._properties.iterator();
/* 650 */       while (it.hasNext()) {
/* 651 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 659 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 662 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 665 */     super.commitTransaction();
/*     */     
/* 667 */     this._propertiesSavepoint = this._properties;
/* 668 */     if (this._properties != null) {
/* 669 */       Iterator<IDataModel> it = this._properties.iterator();
/* 670 */       while (it.hasNext()) {
/* 671 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 673 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 677 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 682 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxAuthorityModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */