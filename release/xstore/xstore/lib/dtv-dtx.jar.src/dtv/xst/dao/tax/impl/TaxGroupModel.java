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
/*     */ import dtv.xst.dao.tax.ITaxCode;
/*     */ import dtv.xst.dao.tax.ITaxGroup;
/*     */ import dtv.xst.dao.tax.ITaxGroupProperty;
/*     */ import dtv.xst.dao.tax.TaxGroupPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TaxGroupModel extends AbstractDataModelWithPropertyImpl<ITaxGroupProperty> implements ITaxGroup {
/*     */   private static final long serialVersionUID = -234701388L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private ITaxCode _taxCode; private transient ITaxCode _taxCodeSavepoint; private HistoricalList<ITaxGroupProperty> _properties; private transient HistoricalList<ITaxGroupProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new TaxGroupDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TaxGroupDAO getDAO_() {
/*  47 */     return (TaxGroupDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  55 */     if (getDAO_().getOrganizationId() != null) {
/*  56 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  59 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  68 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  69 */       this._events != null && 
/*  70 */       postEventsForChanges()) {
/*  71 */       this._events.post(ITaxGroup.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  78 */     boolean ev_postable = false;
/*     */     
/*  80 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  81 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  82 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  83 */       ev_postable = true;
/*  84 */       if (this._properties != null) {
/*     */         
/*  86 */         Iterator<TaxGroupPropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((TaxGroupPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  94 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxGroupId() {
/* 102 */     return getDAO_().getTaxGroupId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/* 110 */     if (setTaxGroupId_noev(argTaxGroupId) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(ITaxGroup.SET_TAXGROUPID, argTaxGroupId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxGroupId_noev(String argTaxGroupId) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getTaxGroupId() == null && argTaxGroupId != null) || (
/* 123 */       getDAO_().getTaxGroupId() != null && !getDAO_().getTaxGroupId().equals(argTaxGroupId))) {
/* 124 */       getDAO_().setTaxGroupId(argTaxGroupId);
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<TaxGroupPropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((TaxGroupPropertyModel)it.next()).setTaxGroupId_noev(argTaxGroupId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 136 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 144 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 152 */     if (setCreateDate_noev(argCreateDate) && 
/* 153 */       this._events != null && 
/* 154 */       postEventsForChanges()) {
/* 155 */       this._events.post(ITaxGroup.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 162 */     boolean ev_postable = false;
/*     */     
/* 164 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 165 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 166 */       getDAO_().setCreateDate(argCreateDate);
/* 167 */       ev_postable = true;
/*     */     } 
/*     */     
/* 170 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 178 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 186 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 187 */       this._events != null && 
/* 188 */       postEventsForChanges()) {
/* 189 */       this._events.post(ITaxGroup.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 196 */     boolean ev_postable = false;
/*     */     
/* 198 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 199 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 200 */       getDAO_().setCreateUserId(argCreateUserId);
/* 201 */       ev_postable = true;
/*     */     } 
/*     */     
/* 204 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 212 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 220 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 221 */       this._events != null && 
/* 222 */       postEventsForChanges()) {
/* 223 */       this._events.post(ITaxGroup.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 230 */     boolean ev_postable = false;
/*     */     
/* 232 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 233 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 234 */       getDAO_().setUpdateDate(argUpdateDate);
/* 235 */       ev_postable = true;
/*     */     } 
/*     */     
/* 238 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 246 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 254 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 255 */       this._events != null && 
/* 256 */       postEventsForChanges()) {
/* 257 */       this._events.post(ITaxGroup.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 264 */     boolean ev_postable = false;
/*     */     
/* 266 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 267 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 268 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 269 */       ev_postable = true;
/*     */     } 
/*     */     
/* 272 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 280 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 288 */     if (setOrgCode_noev(argOrgCode) && 
/* 289 */       this._events != null && 
/* 290 */       postEventsForChanges()) {
/* 291 */       this._events.post(ITaxGroup.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 298 */     boolean ev_postable = false;
/*     */     
/* 300 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 301 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 302 */       getDAO_().setOrgCode(argOrgCode);
/* 303 */       ev_postable = true;
/*     */     } 
/*     */     
/* 306 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 314 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 322 */     if (setOrgValue_noev(argOrgValue) && 
/* 323 */       this._events != null && 
/* 324 */       postEventsForChanges()) {
/* 325 */       this._events.post(ITaxGroup.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 332 */     boolean ev_postable = false;
/*     */     
/* 334 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 335 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 336 */       getDAO_().setOrgValue(argOrgValue);
/* 337 */       ev_postable = true;
/*     */     } 
/*     */     
/* 340 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDescriptionImpl() {
/* 348 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 356 */     if (setDescription_noev(argDescription) && 
/* 357 */       this._events != null && 
/* 358 */       postEventsForChanges()) {
/* 359 */       this._events.post(ITaxGroup.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 366 */     boolean ev_postable = false;
/*     */     
/* 368 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 369 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 370 */       getDAO_().setDescription(argDescription);
/* 371 */       ev_postable = true;
/*     */     } 
/*     */     
/* 374 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 382 */     return getDAO_().getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String argName) {
/* 390 */     if (setName_noev(argName) && 
/* 391 */       this._events != null && 
/* 392 */       postEventsForChanges()) {
/* 393 */       this._events.post(ITaxGroup.SET_NAME, argName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setName_noev(String argName) {
/* 400 */     boolean ev_postable = false;
/*     */     
/* 402 */     if ((getDAO_().getName() == null && argName != null) || (
/* 403 */       getDAO_().getName() != null && !getDAO_().getName().equals(argName))) {
/* 404 */       getDAO_().setName(argName);
/* 405 */       ev_postable = true;
/*     */     } 
/*     */     
/* 408 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxCodeId() {
/* 416 */     return getDAO_().getTaxCodeId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxCodeId(String argTaxCodeId) {
/* 424 */     if (setTaxCodeId_noev(argTaxCodeId) && 
/* 425 */       this._events != null && 
/* 426 */       postEventsForChanges()) {
/* 427 */       this._events.post(ITaxGroup.SET_TAXCODEID, argTaxCodeId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxCodeId_noev(String argTaxCodeId) {
/* 434 */     boolean ev_postable = false;
/*     */     
/* 436 */     if ((getDAO_().getTaxCodeId() == null && argTaxCodeId != null) || (
/* 437 */       getDAO_().getTaxCodeId() != null && !getDAO_().getTaxCodeId().equals(argTaxCodeId))) {
/* 438 */       getDAO_().setTaxCodeId(argTaxCodeId);
/* 439 */       ev_postable = true;
/*     */     } 
/*     */     
/* 442 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExternalSystem() {
/* 450 */     return getDAO_().getExternalSystem();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExternalSystem(String argExternalSystem) {
/* 458 */     if (setExternalSystem_noev(argExternalSystem) && 
/* 459 */       this._events != null && 
/* 460 */       postEventsForChanges()) {
/* 461 */       this._events.post(ITaxGroup.SET_EXTERNALSYSTEM, argExternalSystem);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExternalSystem_noev(String argExternalSystem) {
/* 468 */     boolean ev_postable = false;
/*     */     
/* 470 */     if ((getDAO_().getExternalSystem() == null && argExternalSystem != null) || (
/* 471 */       getDAO_().getExternalSystem() != null && !getDAO_().getExternalSystem().equals(argExternalSystem))) {
/* 472 */       getDAO_().setExternalSystem(argExternalSystem);
/* 473 */       ev_postable = true;
/*     */     } 
/*     */     
/* 476 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITaxGroupProperty newProperty(String argPropertyName) {
/* 480 */     TaxGroupPropertyId id = new TaxGroupPropertyId();
/*     */     
/* 482 */     id.setTaxGroupId(getTaxGroupId());
/* 483 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 485 */     ITaxGroupProperty prop = (ITaxGroupProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITaxGroupProperty.class);
/* 486 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "TaxCode")
/*     */   public ITaxCode getTaxCode() {
/* 498 */     return this._taxCode;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTaxCode(ITaxCode argTaxCode) {
/* 503 */     if (argTaxCode == null) {
/*     */       
/* 505 */       getDAO_().setTaxCodeId(null);
/* 506 */       if (this._taxCode != null)
/*     */       {
/* 508 */         if (postEventsForChanges()) {
/* 509 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._taxCode));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 514 */       getDAO_().setTaxCodeId(argTaxCode.getTaxCodeId());
/*     */       
/* 516 */       if (postEventsForChanges()) {
/* 517 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxCode));
/*     */       }
/*     */     } 
/*     */     
/* 521 */     this._taxCode = argTaxCode;
/* 522 */     if (postEventsForChanges()) {
/* 523 */       this._events.post(ITaxGroup.SET_TAXCODE, argTaxCode);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITaxGroupProperty> getProperties() {
/* 529 */     if (this._properties == null) {
/* 530 */       this._properties = new HistoricalList(null);
/*     */     }
/* 532 */     return (List<ITaxGroupProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITaxGroupProperty> argProperties) {
/* 536 */     if (this._properties == null) {
/* 537 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 539 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 542 */     for (ITaxGroupProperty child : this._properties) {
/* 543 */       TaxGroupPropertyModel model = (TaxGroupPropertyModel)child;
/* 544 */       model.setOrganizationId_noev(getOrganizationId());
/* 545 */       model.setTaxGroupId_noev(getTaxGroupId());
/* 546 */       if (child instanceof IDataModelImpl) {
/* 547 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 548 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 549 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 550 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 553 */       if (postEventsForChanges()) {
/* 554 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTaxGroupProperty(ITaxGroupProperty argTaxGroupProperty) {
/* 560 */     if (this._properties == null) {
/* 561 */       this._properties = new HistoricalList(null);
/*     */     }
/* 563 */     argTaxGroupProperty.setOrganizationId(getOrganizationId());
/* 564 */     argTaxGroupProperty.setTaxGroupId(getTaxGroupId());
/* 565 */     if (argTaxGroupProperty instanceof IDataModelImpl) {
/* 566 */       IDataAccessObject childDao = ((IDataModelImpl)argTaxGroupProperty).getDAO();
/* 567 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 568 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 569 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 574 */     if (postEventsForChanges()) {
/* 575 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxGroupProperty));
/*     */     }
/*     */     
/* 578 */     this._properties.add(argTaxGroupProperty);
/* 579 */     if (postEventsForChanges()) {
/* 580 */       this._events.post(ITaxGroup.ADD_PROPERTIES, argTaxGroupProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTaxGroupProperty(ITaxGroupProperty argTaxGroupProperty) {
/* 585 */     if (this._properties != null) {
/*     */       
/* 587 */       if (postEventsForChanges()) {
/* 588 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxGroupProperty));
/*     */       }
/* 590 */       this._properties.remove(argTaxGroupProperty);
/* 591 */       if (postEventsForChanges()) {
/* 592 */         this._events.post(ITaxGroup.REMOVE_PROPERTIES, argTaxGroupProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 599 */     if ("TaxCode".equals(argFieldId)) {
/* 600 */       return getTaxCode();
/*     */     }
/* 602 */     if ("Properties".equals(argFieldId)) {
/* 603 */       return getProperties();
/*     */     }
/* 605 */     if ("TaxGroupExtension".equals(argFieldId)) {
/* 606 */       return this._myExtension;
/*     */     }
/*     */     
/* 609 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 615 */     if ("TaxCode".equals(argFieldId)) {
/* 616 */       setTaxCode((ITaxCode)argValue);
/*     */     }
/* 618 */     else if ("Properties".equals(argFieldId)) {
/* 619 */       setProperties(changeToList(argValue, ITaxGroupProperty.class));
/*     */     }
/* 621 */     else if ("TaxGroupExtension".equals(argFieldId)) {
/* 622 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 625 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 631 */     this._persistenceDefaults = argPD;
/* 632 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 633 */     this._eventManager = argEM;
/* 634 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 635 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 636 */     if (this._taxCode != null) {
/* 637 */       ((IDataModelImpl)this._taxCode).setDependencies(argPD, argEM);
/*     */     }
/* 639 */     if (this._properties != null) {
/* 640 */       for (ITaxGroupProperty relationship : this._properties) {
/* 641 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTaxGroupExt() {
/* 647 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTaxGroupExt(IDataModel argExt) {
/* 651 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 656 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 660 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 663 */     super.startTransaction();
/*     */     
/* 665 */     this._taxCodeSavepoint = this._taxCode;
/* 666 */     if (this._taxCode != null) {
/* 667 */       this._taxCode.startTransaction();
/*     */     }
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
/* 690 */     this._taxCode = this._taxCodeSavepoint;
/* 691 */     this._taxCodeSavepoint = null;
/* 692 */     if (this._taxCode != null) {
/* 693 */       this._taxCode.rollbackChanges();
/*     */     }
/*     */     
/* 696 */     this._properties = this._propertiesSavepoint;
/* 697 */     this._propertiesSavepoint = null;
/* 698 */     if (this._properties != null) {
/* 699 */       Iterator<IDataModel> it = this._properties.iterator();
/* 700 */       while (it.hasNext()) {
/* 701 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 709 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 712 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 715 */     super.commitTransaction();
/*     */     
/* 717 */     this._taxCodeSavepoint = this._taxCode;
/* 718 */     if (this._taxCode != null) {
/* 719 */       this._taxCode.commitTransaction();
/*     */     }
/*     */     
/* 722 */     this._propertiesSavepoint = this._properties;
/* 723 */     if (this._properties != null) {
/* 724 */       Iterator<IDataModel> it = this._properties.iterator();
/* 725 */       while (it.hasNext()) {
/* 726 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 728 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 732 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 737 */     argStream.defaultReadObject();
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
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 752 */     String description = getDescriptionImpl();
/* 753 */     return (description == null) ? getName() : description;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxGroupModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */