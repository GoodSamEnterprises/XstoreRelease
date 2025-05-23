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
/*     */ import dtv.xst.dao.tax.ITaxTaxGroupMapping;
/*     */ import dtv.xst.dao.tax.ITaxTaxGroupMappingProperty;
/*     */ import dtv.xst.dao.tax.TaxTaxGroupMappingPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TaxTaxGroupMappingModel extends AbstractDataModelWithPropertyImpl<ITaxTaxGroupMappingProperty> implements ITaxTaxGroupMapping {
/*     */   private static final long serialVersionUID = -772656753L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ITaxTaxGroupMappingProperty> _properties; private transient HistoricalList<ITaxTaxGroupMappingProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new TaxTaxGroupMappingDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TaxTaxGroupMappingDAO getDAO_() {
/*  46 */     return (TaxTaxGroupMappingDAO)this._daoImpl;
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
/*  70 */       this._events.post(ITaxTaxGroupMapping.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<TaxTaxGroupMappingPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((TaxTaxGroupMappingPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getCustomerGroup() {
/* 101 */     return getDAO_().getCustomerGroup();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerGroup(String argCustomerGroup) {
/* 109 */     if (setCustomerGroup_noev(argCustomerGroup) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(ITaxTaxGroupMapping.SET_CUSTOMERGROUP, argCustomerGroup);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomerGroup_noev(String argCustomerGroup) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getCustomerGroup() == null && argCustomerGroup != null) || (
/* 122 */       getDAO_().getCustomerGroup() != null && !getDAO_().getCustomerGroup().equals(argCustomerGroup))) {
/* 123 */       getDAO_().setCustomerGroup(argCustomerGroup);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<TaxTaxGroupMappingPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((TaxTaxGroupMappingPropertyModel)it.next()).setCustomerGroup_noev(argCustomerGroup);
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
/*     */   public String getTaxGroupId() {
/* 143 */     return getDAO_().getTaxGroupId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxGroupId(String argTaxGroupId) {
/* 151 */     if (setTaxGroupId_noev(argTaxGroupId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(ITaxTaxGroupMapping.SET_TAXGROUPID, argTaxGroupId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxGroupId_noev(String argTaxGroupId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getTaxGroupId() == null && argTaxGroupId != null) || (
/* 164 */       getDAO_().getTaxGroupId() != null && !getDAO_().getTaxGroupId().equals(argTaxGroupId))) {
/* 165 */       getDAO_().setTaxGroupId(argTaxGroupId);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<TaxTaxGroupMappingPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((TaxTaxGroupMappingPropertyModel)it.next()).setTaxGroupId_noev(argTaxGroupId);
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
/*     */   public int getRtlLocId() {
/* 185 */     if (getDAO_().getRtlLocId() != null) {
/* 186 */       return getDAO_().getRtlLocId().intValue();
/*     */     }
/*     */     
/* 189 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRtlLocId(int argRtlLocId) {
/* 198 */     if (setRtlLocId_noev(argRtlLocId) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(ITaxTaxGroupMapping.SET_RTLLOCID, Integer.valueOf(argRtlLocId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRtlLocId_noev(int argRtlLocId) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getRtlLocId() == null && Integer.valueOf(argRtlLocId) != null) || (
/* 211 */       getDAO_().getRtlLocId() != null && !getDAO_().getRtlLocId().equals(Integer.valueOf(argRtlLocId)))) {
/* 212 */       getDAO_().setRtlLocId(Integer.valueOf(argRtlLocId));
/* 213 */       ev_postable = true;
/* 214 */       if (this._properties != null) {
/*     */         
/* 216 */         Iterator<TaxTaxGroupMappingPropertyModel> it = this._properties.iterator();
/* 217 */         while (it.hasNext())
/*     */         {
/* 219 */           ((TaxTaxGroupMappingPropertyModel)it.next()).setRtlLocId_noev(argRtlLocId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 224 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 232 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 240 */     if (setCreateDate_noev(argCreateDate) && 
/* 241 */       this._events != null && 
/* 242 */       postEventsForChanges()) {
/* 243 */       this._events.post(ITaxTaxGroupMapping.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 250 */     boolean ev_postable = false;
/*     */     
/* 252 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 253 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 254 */       getDAO_().setCreateDate(argCreateDate);
/* 255 */       ev_postable = true;
/*     */     } 
/*     */     
/* 258 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 266 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 274 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 275 */       this._events != null && 
/* 276 */       postEventsForChanges()) {
/* 277 */       this._events.post(ITaxTaxGroupMapping.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 284 */     boolean ev_postable = false;
/*     */     
/* 286 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 287 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 288 */       getDAO_().setCreateUserId(argCreateUserId);
/* 289 */       ev_postable = true;
/*     */     } 
/*     */     
/* 292 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 300 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 308 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 309 */       this._events != null && 
/* 310 */       postEventsForChanges()) {
/* 311 */       this._events.post(ITaxTaxGroupMapping.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 318 */     boolean ev_postable = false;
/*     */     
/* 320 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 321 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 322 */       getDAO_().setUpdateDate(argUpdateDate);
/* 323 */       ev_postable = true;
/*     */     } 
/*     */     
/* 326 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 334 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 342 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 343 */       this._events != null && 
/* 344 */       postEventsForChanges()) {
/* 345 */       this._events.post(ITaxTaxGroupMapping.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 352 */     boolean ev_postable = false;
/*     */     
/* 354 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 355 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 356 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 357 */       ev_postable = true;
/*     */     } 
/*     */     
/* 360 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPriority() {
/* 368 */     if (getDAO_().getPriority() != null) {
/* 369 */       return getDAO_().getPriority().intValue();
/*     */     }
/*     */     
/* 372 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPriority(int argPriority) {
/* 381 */     if (setPriority_noev(argPriority) && 
/* 382 */       this._events != null && 
/* 383 */       postEventsForChanges()) {
/* 384 */       this._events.post(ITaxTaxGroupMapping.SET_PRIORITY, Integer.valueOf(argPriority));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPriority_noev(int argPriority) {
/* 391 */     boolean ev_postable = false;
/*     */     
/* 393 */     if ((getDAO_().getPriority() == null && Integer.valueOf(argPriority) != null) || (
/* 394 */       getDAO_().getPriority() != null && !getDAO_().getPriority().equals(Integer.valueOf(argPriority)))) {
/* 395 */       getDAO_().setPriority(Integer.valueOf(argPriority));
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
/*     */   public String getNewTaxGroupId() {
/* 407 */     return getDAO_().getNewTaxGroupId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNewTaxGroupId(String argNewTaxGroupId) {
/* 415 */     if (setNewTaxGroupId_noev(argNewTaxGroupId) && 
/* 416 */       this._events != null && 
/* 417 */       postEventsForChanges()) {
/* 418 */       this._events.post(ITaxTaxGroupMapping.SET_NEWTAXGROUPID, argNewTaxGroupId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNewTaxGroupId_noev(String argNewTaxGroupId) {
/* 425 */     boolean ev_postable = false;
/*     */     
/* 427 */     if ((getDAO_().getNewTaxGroupId() == null && argNewTaxGroupId != null) || (
/* 428 */       getDAO_().getNewTaxGroupId() != null && !getDAO_().getNewTaxGroupId().equals(argNewTaxGroupId))) {
/* 429 */       getDAO_().setNewTaxGroupId(argNewTaxGroupId);
/* 430 */       ev_postable = true;
/*     */     } 
/*     */     
/* 433 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITaxTaxGroupMappingProperty newProperty(String argPropertyName) {
/* 437 */     TaxTaxGroupMappingPropertyId id = new TaxTaxGroupMappingPropertyId();
/*     */     
/* 439 */     id.setCustomerGroup(getCustomerGroup());
/* 440 */     id.setTaxGroupId(getTaxGroupId());
/* 441 */     id.setRtlLocId(Integer.valueOf(getRtlLocId()));
/* 442 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 444 */     ITaxTaxGroupMappingProperty prop = (ITaxTaxGroupMappingProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITaxTaxGroupMappingProperty.class);
/* 445 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITaxTaxGroupMappingProperty> getProperties() {
/* 454 */     if (this._properties == null) {
/* 455 */       this._properties = new HistoricalList(null);
/*     */     }
/* 457 */     return (List<ITaxTaxGroupMappingProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITaxTaxGroupMappingProperty> argProperties) {
/* 461 */     if (this._properties == null) {
/* 462 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 464 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 467 */     for (ITaxTaxGroupMappingProperty child : this._properties) {
/* 468 */       TaxTaxGroupMappingPropertyModel model = (TaxTaxGroupMappingPropertyModel)child;
/* 469 */       model.setOrganizationId_noev(getOrganizationId());
/* 470 */       model.setCustomerGroup_noev(getCustomerGroup());
/* 471 */       model.setTaxGroupId_noev(getTaxGroupId());
/* 472 */       model.setRtlLocId_noev(getRtlLocId());
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
/*     */   public void addTaxTaxGroupMappingProperty(ITaxTaxGroupMappingProperty argTaxTaxGroupMappingProperty) {
/* 487 */     if (this._properties == null) {
/* 488 */       this._properties = new HistoricalList(null);
/*     */     }
/* 490 */     argTaxTaxGroupMappingProperty.setOrganizationId(getOrganizationId());
/* 491 */     argTaxTaxGroupMappingProperty.setCustomerGroup(getCustomerGroup());
/* 492 */     argTaxTaxGroupMappingProperty.setTaxGroupId(getTaxGroupId());
/* 493 */     argTaxTaxGroupMappingProperty.setRtlLocId(getRtlLocId());
/* 494 */     if (argTaxTaxGroupMappingProperty instanceof IDataModelImpl) {
/* 495 */       IDataAccessObject childDao = ((IDataModelImpl)argTaxTaxGroupMappingProperty).getDAO();
/* 496 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 497 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 498 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 503 */     if (postEventsForChanges()) {
/* 504 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxTaxGroupMappingProperty));
/*     */     }
/*     */     
/* 507 */     this._properties.add(argTaxTaxGroupMappingProperty);
/* 508 */     if (postEventsForChanges()) {
/* 509 */       this._events.post(ITaxTaxGroupMapping.ADD_PROPERTIES, argTaxTaxGroupMappingProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTaxTaxGroupMappingProperty(ITaxTaxGroupMappingProperty argTaxTaxGroupMappingProperty) {
/* 514 */     if (this._properties != null) {
/*     */       
/* 516 */       if (postEventsForChanges()) {
/* 517 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxTaxGroupMappingProperty));
/*     */       }
/* 519 */       this._properties.remove(argTaxTaxGroupMappingProperty);
/* 520 */       if (postEventsForChanges()) {
/* 521 */         this._events.post(ITaxTaxGroupMapping.REMOVE_PROPERTIES, argTaxTaxGroupMappingProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 528 */     if ("Properties".equals(argFieldId)) {
/* 529 */       return getProperties();
/*     */     }
/* 531 */     if ("TaxTaxGroupMappingExtension".equals(argFieldId)) {
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
/* 542 */       setProperties(changeToList(argValue, ITaxTaxGroupMappingProperty.class));
/*     */     }
/* 544 */     else if ("TaxTaxGroupMappingExtension".equals(argFieldId)) {
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
/* 560 */       for (ITaxTaxGroupMappingProperty relationship : this._properties) {
/* 561 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTaxTaxGroupMappingExt() {
/* 567 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTaxTaxGroupMappingExt(IDataModel argExt) {
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxTaxGroupMappingModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */