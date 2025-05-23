/*     */ package dtv.xst.dao.crm.impl;
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
/*     */ import dtv.xst.dao.crm.CustomerConsentInfoPropertyId;
/*     */ import dtv.xst.dao.crm.ICustomerConsentInfo;
/*     */ import dtv.xst.dao.crm.ICustomerConsentInfoProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CustomerConsentInfoModel extends AbstractDataModelWithPropertyImpl<ICustomerConsentInfoProperty> implements ICustomerConsentInfo {
/*     */   private static final long serialVersionUID = -1453591286L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ICustomerConsentInfoProperty> _properties; private transient HistoricalList<ICustomerConsentInfoProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new CustomerConsentInfoDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CustomerConsentInfoDAO getDAO_() {
/*  46 */     return (CustomerConsentInfoDAO)this._daoImpl;
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
/*  70 */       this._events.post(ICustomerConsentInfo.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<CustomerConsentInfoPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((CustomerConsentInfoPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public Date getEffectiveDate() {
/* 101 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 109 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(ICustomerConsentInfo.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 122 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 123 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<CustomerConsentInfoPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((CustomerConsentInfoPropertyModel)it.next()).setEffectiveDate_noev(argEffectiveDate);
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
/* 154 */       this._events.post(ICustomerConsentInfo.SET_CREATEDATE, argCreateDate);
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
/* 188 */       this._events.post(ICustomerConsentInfo.SET_CREATEUSERID, argCreateUserId);
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
/* 222 */       this._events.post(ICustomerConsentInfo.SET_UPDATEDATE, argUpdateDate);
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
/* 256 */       this._events.post(ICustomerConsentInfo.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getTermsAndConditions() {
/* 279 */     return getDAO_().getTermsAndConditions();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTermsAndConditions(String argTermsAndConditions) {
/* 287 */     if (setTermsAndConditions_noev(argTermsAndConditions) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(ICustomerConsentInfo.SET_TERMSANDCONDITIONS, argTermsAndConditions);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTermsAndConditions_noev(String argTermsAndConditions) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getTermsAndConditions() == null && argTermsAndConditions != null) || (
/* 300 */       getDAO_().getTermsAndConditions() != null && !getDAO_().getTermsAndConditions().equals(argTermsAndConditions))) {
/* 301 */       getDAO_().setTermsAndConditions(argTermsAndConditions);
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
/*     */   public String getConsent1Text() {
/* 313 */     return getDAO_().getConsent1Text();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConsent1Text(String argConsent1Text) {
/* 321 */     if (setConsent1Text_noev(argConsent1Text) && 
/* 322 */       this._events != null && 
/* 323 */       postEventsForChanges()) {
/* 324 */       this._events.post(ICustomerConsentInfo.SET_CONSENT1TEXT, argConsent1Text);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConsent1Text_noev(String argConsent1Text) {
/* 331 */     boolean ev_postable = false;
/*     */     
/* 333 */     if ((getDAO_().getConsent1Text() == null && argConsent1Text != null) || (
/* 334 */       getDAO_().getConsent1Text() != null && !getDAO_().getConsent1Text().equals(argConsent1Text))) {
/* 335 */       getDAO_().setConsent1Text(argConsent1Text);
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
/*     */   public String getConsent2Text() {
/* 347 */     return getDAO_().getConsent2Text();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConsent2Text(String argConsent2Text) {
/* 355 */     if (setConsent2Text_noev(argConsent2Text) && 
/* 356 */       this._events != null && 
/* 357 */       postEventsForChanges()) {
/* 358 */       this._events.post(ICustomerConsentInfo.SET_CONSENT2TEXT, argConsent2Text);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConsent2Text_noev(String argConsent2Text) {
/* 365 */     boolean ev_postable = false;
/*     */     
/* 367 */     if ((getDAO_().getConsent2Text() == null && argConsent2Text != null) || (
/* 368 */       getDAO_().getConsent2Text() != null && !getDAO_().getConsent2Text().equals(argConsent2Text))) {
/* 369 */       getDAO_().setConsent2Text(argConsent2Text);
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
/*     */   public String getConsent3Text() {
/* 381 */     return getDAO_().getConsent3Text();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConsent3Text(String argConsent3Text) {
/* 389 */     if (setConsent3Text_noev(argConsent3Text) && 
/* 390 */       this._events != null && 
/* 391 */       postEventsForChanges()) {
/* 392 */       this._events.post(ICustomerConsentInfo.SET_CONSENT3TEXT, argConsent3Text);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConsent3Text_noev(String argConsent3Text) {
/* 399 */     boolean ev_postable = false;
/*     */     
/* 401 */     if ((getDAO_().getConsent3Text() == null && argConsent3Text != null) || (
/* 402 */       getDAO_().getConsent3Text() != null && !getDAO_().getConsent3Text().equals(argConsent3Text))) {
/* 403 */       getDAO_().setConsent3Text(argConsent3Text);
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
/*     */   public String getConsent4Text() {
/* 415 */     return getDAO_().getConsent4Text();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConsent4Text(String argConsent4Text) {
/* 423 */     if (setConsent4Text_noev(argConsent4Text) && 
/* 424 */       this._events != null && 
/* 425 */       postEventsForChanges()) {
/* 426 */       this._events.post(ICustomerConsentInfo.SET_CONSENT4TEXT, argConsent4Text);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConsent4Text_noev(String argConsent4Text) {
/* 433 */     boolean ev_postable = false;
/*     */     
/* 435 */     if ((getDAO_().getConsent4Text() == null && argConsent4Text != null) || (
/* 436 */       getDAO_().getConsent4Text() != null && !getDAO_().getConsent4Text().equals(argConsent4Text))) {
/* 437 */       getDAO_().setConsent4Text(argConsent4Text);
/* 438 */       ev_postable = true;
/*     */     } 
/*     */     
/* 441 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConsent5Text() {
/* 449 */     return getDAO_().getConsent5Text();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConsent5Text(String argConsent5Text) {
/* 457 */     if (setConsent5Text_noev(argConsent5Text) && 
/* 458 */       this._events != null && 
/* 459 */       postEventsForChanges()) {
/* 460 */       this._events.post(ICustomerConsentInfo.SET_CONSENT5TEXT, argConsent5Text);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConsent5Text_noev(String argConsent5Text) {
/* 467 */     boolean ev_postable = false;
/*     */     
/* 469 */     if ((getDAO_().getConsent5Text() == null && argConsent5Text != null) || (
/* 470 */       getDAO_().getConsent5Text() != null && !getDAO_().getConsent5Text().equals(argConsent5Text))) {
/* 471 */       getDAO_().setConsent5Text(argConsent5Text);
/* 472 */       ev_postable = true;
/*     */     } 
/*     */     
/* 475 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICustomerConsentInfoProperty newProperty(String argPropertyName) {
/* 479 */     CustomerConsentInfoPropertyId id = new CustomerConsentInfoPropertyId();
/*     */     
/* 481 */     id.setEffectiveDate(getEffectiveDate());
/* 482 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 484 */     ICustomerConsentInfoProperty prop = (ICustomerConsentInfoProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICustomerConsentInfoProperty.class);
/* 485 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICustomerConsentInfoProperty> getProperties() {
/* 494 */     if (this._properties == null) {
/* 495 */       this._properties = new HistoricalList(null);
/*     */     }
/* 497 */     return (List<ICustomerConsentInfoProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICustomerConsentInfoProperty> argProperties) {
/* 501 */     if (this._properties == null) {
/* 502 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 504 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 507 */     for (ICustomerConsentInfoProperty child : this._properties) {
/* 508 */       CustomerConsentInfoPropertyModel model = (CustomerConsentInfoPropertyModel)child;
/* 509 */       model.setOrganizationId_noev(getOrganizationId());
/* 510 */       model.setEffectiveDate_noev(getEffectiveDate());
/* 511 */       if (child instanceof IDataModelImpl) {
/* 512 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 513 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 514 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 515 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 518 */       if (postEventsForChanges()) {
/* 519 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCustomerConsentInfoProperty(ICustomerConsentInfoProperty argCustomerConsentInfoProperty) {
/* 525 */     if (this._properties == null) {
/* 526 */       this._properties = new HistoricalList(null);
/*     */     }
/* 528 */     argCustomerConsentInfoProperty.setOrganizationId(getOrganizationId());
/* 529 */     argCustomerConsentInfoProperty.setEffectiveDate(getEffectiveDate());
/* 530 */     if (argCustomerConsentInfoProperty instanceof IDataModelImpl) {
/* 531 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerConsentInfoProperty).getDAO();
/* 532 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 533 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 534 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 539 */     if (postEventsForChanges()) {
/* 540 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerConsentInfoProperty));
/*     */     }
/*     */     
/* 543 */     this._properties.add(argCustomerConsentInfoProperty);
/* 544 */     if (postEventsForChanges()) {
/* 545 */       this._events.post(ICustomerConsentInfo.ADD_PROPERTIES, argCustomerConsentInfoProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCustomerConsentInfoProperty(ICustomerConsentInfoProperty argCustomerConsentInfoProperty) {
/* 550 */     if (this._properties != null) {
/*     */       
/* 552 */       if (postEventsForChanges()) {
/* 553 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerConsentInfoProperty));
/*     */       }
/* 555 */       this._properties.remove(argCustomerConsentInfoProperty);
/* 556 */       if (postEventsForChanges()) {
/* 557 */         this._events.post(ICustomerConsentInfo.REMOVE_PROPERTIES, argCustomerConsentInfoProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 564 */     if ("Properties".equals(argFieldId)) {
/* 565 */       return getProperties();
/*     */     }
/* 567 */     if ("CustomerConsentInfoExtension".equals(argFieldId)) {
/* 568 */       return this._myExtension;
/*     */     }
/*     */     
/* 571 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 577 */     if ("Properties".equals(argFieldId)) {
/* 578 */       setProperties(changeToList(argValue, ICustomerConsentInfoProperty.class));
/*     */     }
/* 580 */     else if ("CustomerConsentInfoExtension".equals(argFieldId)) {
/* 581 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 584 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 590 */     this._persistenceDefaults = argPD;
/* 591 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 592 */     this._eventManager = argEM;
/* 593 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 594 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 595 */     if (this._properties != null) {
/* 596 */       for (ICustomerConsentInfoProperty relationship : this._properties) {
/* 597 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCustomerConsentInfoExt() {
/* 603 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCustomerConsentInfoExt(IDataModel argExt) {
/* 607 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 612 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 616 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 619 */     super.startTransaction();
/*     */     
/* 621 */     this._propertiesSavepoint = this._properties;
/* 622 */     if (this._properties != null) {
/* 623 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 624 */       Iterator<IDataModel> it = this._properties.iterator();
/* 625 */       while (it.hasNext()) {
/* 626 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 631 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 636 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 639 */     super.rollbackChanges();
/*     */     
/* 641 */     this._properties = this._propertiesSavepoint;
/* 642 */     this._propertiesSavepoint = null;
/* 643 */     if (this._properties != null) {
/* 644 */       Iterator<IDataModel> it = this._properties.iterator();
/* 645 */       while (it.hasNext()) {
/* 646 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 654 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 657 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 660 */     super.commitTransaction();
/*     */     
/* 662 */     this._propertiesSavepoint = this._properties;
/* 663 */     if (this._properties != null) {
/* 664 */       Iterator<IDataModel> it = this._properties.iterator();
/* 665 */       while (it.hasNext()) {
/* 666 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 668 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 672 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 677 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\CustomerConsentInfoModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */