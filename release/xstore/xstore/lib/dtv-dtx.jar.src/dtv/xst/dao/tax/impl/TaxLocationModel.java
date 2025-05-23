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
/*     */ import dtv.xst.dao.tax.ITaxLocation;
/*     */ import dtv.xst.dao.tax.ITaxLocationProperty;
/*     */ import dtv.xst.dao.tax.TaxLocationPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TaxLocationModel extends AbstractDataModelWithPropertyImpl<ITaxLocationProperty> implements ITaxLocation {
/*     */   private static final long serialVersionUID = 1612484704L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ITaxLocationProperty> _properties; private transient HistoricalList<ITaxLocationProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new TaxLocationDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TaxLocationDAO getDAO_() {
/*  46 */     return (TaxLocationDAO)this._daoImpl;
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
/*  70 */       this._events.post(ITaxLocation.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<TaxLocationPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((TaxLocationPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getTaxLocationId() {
/* 101 */     return getDAO_().getTaxLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/* 109 */     if (setTaxLocationId_noev(argTaxLocationId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(ITaxLocation.SET_TAXLOCATIONID, argTaxLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxLocationId_noev(String argTaxLocationId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getTaxLocationId() == null && argTaxLocationId != null) || (
/* 122 */       getDAO_().getTaxLocationId() != null && !getDAO_().getTaxLocationId().equals(argTaxLocationId))) {
/* 123 */       getDAO_().setTaxLocationId(argTaxLocationId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<TaxLocationPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((TaxLocationPropertyModel)it.next()).setTaxLocationId_noev(argTaxLocationId);
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
/* 154 */       this._events.post(ITaxLocation.SET_CREATEDATE, argCreateDate);
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
/* 188 */       this._events.post(ITaxLocation.SET_CREATEUSERID, argCreateUserId);
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
/* 222 */       this._events.post(ITaxLocation.SET_UPDATEDATE, argUpdateDate);
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
/* 256 */       this._events.post(ITaxLocation.SET_UPDATEUSERID, argUpdateUserId);
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
/* 290 */       this._events.post(ITaxLocation.SET_ORGCODE, argOrgCode);
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
/* 324 */       this._events.post(ITaxLocation.SET_ORGVALUE, argOrgValue);
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
/*     */   public String getDescription() {
/* 347 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 355 */     if (setDescription_noev(argDescription) && 
/* 356 */       this._events != null && 
/* 357 */       postEventsForChanges()) {
/* 358 */       this._events.post(ITaxLocation.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 365 */     boolean ev_postable = false;
/*     */     
/* 367 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 368 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 369 */       getDAO_().setDescription(argDescription);
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
/*     */   public String getName() {
/* 381 */     return getDAO_().getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String argName) {
/* 389 */     if (setName_noev(argName) && 
/* 390 */       this._events != null && 
/* 391 */       postEventsForChanges()) {
/* 392 */       this._events.post(ITaxLocation.SET_NAME, argName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setName_noev(String argName) {
/* 399 */     boolean ev_postable = false;
/*     */     
/* 401 */     if ((getDAO_().getName() == null && argName != null) || (
/* 402 */       getDAO_().getName() != null && !getDAO_().getName().equals(argName))) {
/* 403 */       getDAO_().setName(argName);
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
/*     */   public String getExternalSystem() {
/* 415 */     return getDAO_().getExternalSystem();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExternalSystem(String argExternalSystem) {
/* 423 */     if (setExternalSystem_noev(argExternalSystem) && 
/* 424 */       this._events != null && 
/* 425 */       postEventsForChanges()) {
/* 426 */       this._events.post(ITaxLocation.SET_EXTERNALSYSTEM, argExternalSystem);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExternalSystem_noev(String argExternalSystem) {
/* 433 */     boolean ev_postable = false;
/*     */     
/* 435 */     if ((getDAO_().getExternalSystem() == null && argExternalSystem != null) || (
/* 436 */       getDAO_().getExternalSystem() != null && !getDAO_().getExternalSystem().equals(argExternalSystem))) {
/* 437 */       getDAO_().setExternalSystem(argExternalSystem);
/* 438 */       ev_postable = true;
/*     */     } 
/*     */     
/* 441 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITaxLocationProperty newProperty(String argPropertyName) {
/* 445 */     TaxLocationPropertyId id = new TaxLocationPropertyId();
/*     */     
/* 447 */     id.setTaxLocationId(getTaxLocationId());
/* 448 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 450 */     ITaxLocationProperty prop = (ITaxLocationProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITaxLocationProperty.class);
/* 451 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITaxLocationProperty> getProperties() {
/* 460 */     if (this._properties == null) {
/* 461 */       this._properties = new HistoricalList(null);
/*     */     }
/* 463 */     return (List<ITaxLocationProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITaxLocationProperty> argProperties) {
/* 467 */     if (this._properties == null) {
/* 468 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 470 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 473 */     for (ITaxLocationProperty child : this._properties) {
/* 474 */       TaxLocationPropertyModel model = (TaxLocationPropertyModel)child;
/* 475 */       model.setOrganizationId_noev(getOrganizationId());
/* 476 */       model.setTaxLocationId_noev(getTaxLocationId());
/* 477 */       if (child instanceof IDataModelImpl) {
/* 478 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 479 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 480 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 481 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 484 */       if (postEventsForChanges()) {
/* 485 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTaxLocationProperty(ITaxLocationProperty argTaxLocationProperty) {
/* 491 */     if (this._properties == null) {
/* 492 */       this._properties = new HistoricalList(null);
/*     */     }
/* 494 */     argTaxLocationProperty.setOrganizationId(getOrganizationId());
/* 495 */     argTaxLocationProperty.setTaxLocationId(getTaxLocationId());
/* 496 */     if (argTaxLocationProperty instanceof IDataModelImpl) {
/* 497 */       IDataAccessObject childDao = ((IDataModelImpl)argTaxLocationProperty).getDAO();
/* 498 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 499 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 500 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 505 */     if (postEventsForChanges()) {
/* 506 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxLocationProperty));
/*     */     }
/*     */     
/* 509 */     this._properties.add(argTaxLocationProperty);
/* 510 */     if (postEventsForChanges()) {
/* 511 */       this._events.post(ITaxLocation.ADD_PROPERTIES, argTaxLocationProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTaxLocationProperty(ITaxLocationProperty argTaxLocationProperty) {
/* 516 */     if (this._properties != null) {
/*     */       
/* 518 */       if (postEventsForChanges()) {
/* 519 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxLocationProperty));
/*     */       }
/* 521 */       this._properties.remove(argTaxLocationProperty);
/* 522 */       if (postEventsForChanges()) {
/* 523 */         this._events.post(ITaxLocation.REMOVE_PROPERTIES, argTaxLocationProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 530 */     if ("Properties".equals(argFieldId)) {
/* 531 */       return getProperties();
/*     */     }
/* 533 */     if ("TaxLocationExtension".equals(argFieldId)) {
/* 534 */       return this._myExtension;
/*     */     }
/*     */     
/* 537 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 543 */     if ("Properties".equals(argFieldId)) {
/* 544 */       setProperties(changeToList(argValue, ITaxLocationProperty.class));
/*     */     }
/* 546 */     else if ("TaxLocationExtension".equals(argFieldId)) {
/* 547 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 550 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 556 */     this._persistenceDefaults = argPD;
/* 557 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 558 */     this._eventManager = argEM;
/* 559 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 560 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 561 */     if (this._properties != null) {
/* 562 */       for (ITaxLocationProperty relationship : this._properties) {
/* 563 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTaxLocationExt() {
/* 569 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTaxLocationExt(IDataModel argExt) {
/* 573 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 578 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 582 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 585 */     super.startTransaction();
/*     */     
/* 587 */     this._propertiesSavepoint = this._properties;
/* 588 */     if (this._properties != null) {
/* 589 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 590 */       Iterator<IDataModel> it = this._properties.iterator();
/* 591 */       while (it.hasNext()) {
/* 592 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 597 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 602 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 605 */     super.rollbackChanges();
/*     */     
/* 607 */     this._properties = this._propertiesSavepoint;
/* 608 */     this._propertiesSavepoint = null;
/* 609 */     if (this._properties != null) {
/* 610 */       Iterator<IDataModel> it = this._properties.iterator();
/* 611 */       while (it.hasNext()) {
/* 612 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 620 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 623 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 626 */     super.commitTransaction();
/*     */     
/* 628 */     this._propertiesSavepoint = this._properties;
/* 629 */     if (this._properties != null) {
/* 630 */       Iterator<IDataModel> it = this._properties.iterator();
/* 631 */       while (it.hasNext()) {
/* 632 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 634 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 638 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 643 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxLocationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */