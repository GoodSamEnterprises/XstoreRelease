/*     */ package dtv.xst.dao.sls.impl;
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
/*     */ import dtv.xst.dao.sls.ISalesGoal;
/*     */ import dtv.xst.dao.sls.ISalesGoalProperty;
/*     */ import dtv.xst.dao.sls.SalesGoalPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SalesGoalModel extends AbstractDataModelWithPropertyImpl<ISalesGoalProperty> implements ISalesGoal {
/*     */   private static final long serialVersionUID = 1920136735L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ISalesGoalProperty> _properties; private transient HistoricalList<ISalesGoalProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new SalesGoalDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SalesGoalDAO getDAO_() {
/*  46 */     return (SalesGoalDAO)this._daoImpl;
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
/*  70 */       this._events.post(ISalesGoal.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<SalesGoalPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((SalesGoalPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getSalesGoalId() {
/* 101 */     return getDAO_().getSalesGoalId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSalesGoalId(String argSalesGoalId) {
/* 109 */     if (setSalesGoalId_noev(argSalesGoalId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(ISalesGoal.SET_SALESGOALID, argSalesGoalId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSalesGoalId_noev(String argSalesGoalId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getSalesGoalId() == null && argSalesGoalId != null) || (
/* 122 */       getDAO_().getSalesGoalId() != null && !getDAO_().getSalesGoalId().equals(argSalesGoalId))) {
/* 123 */       getDAO_().setSalesGoalId(argSalesGoalId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<SalesGoalPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((SalesGoalPropertyModel)it.next()).setSalesGoalId_noev(argSalesGoalId);
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
/*     */   public String getOrgCode() {
/* 143 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 151 */     if (setOrgCode_noev(argOrgCode) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(ISalesGoal.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 164 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 165 */       getDAO_().setOrgCode(argOrgCode);
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
/*     */   public String getOrgValue() {
/* 177 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 185 */     if (setOrgValue_noev(argOrgValue) && 
/* 186 */       this._events != null && 
/* 187 */       postEventsForChanges()) {
/* 188 */       this._events.post(ISalesGoal.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 195 */     boolean ev_postable = false;
/*     */     
/* 197 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 198 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 199 */       getDAO_().setOrgValue(argOrgValue);
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
/*     */   public BigDecimal getSalesGoalValue() {
/* 211 */     return getDAO_().getSalesGoalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSalesGoalValue(BigDecimal argSalesGoalValue) {
/* 219 */     if (setSalesGoalValue_noev(argSalesGoalValue) && 
/* 220 */       this._events != null && 
/* 221 */       postEventsForChanges()) {
/* 222 */       this._events.post(ISalesGoal.SET_SALESGOALVALUE, argSalesGoalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSalesGoalValue_noev(BigDecimal argSalesGoalValue) {
/* 229 */     boolean ev_postable = false;
/*     */     
/* 231 */     if ((getDAO_().getSalesGoalValue() == null && argSalesGoalValue != null) || (
/* 232 */       getDAO_().getSalesGoalValue() != null && !getDAO_().getSalesGoalValue().equals(argSalesGoalValue))) {
/* 233 */       getDAO_().setSalesGoalValue(argSalesGoalValue);
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
/*     */   public Date getEffectiveDate() {
/* 245 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 253 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 254 */       this._events != null && 
/* 255 */       postEventsForChanges()) {
/* 256 */       this._events.post(ISalesGoal.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 263 */     boolean ev_postable = false;
/*     */     
/* 265 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 266 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 267 */       getDAO_().setEffectiveDate(argEffectiveDate);
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
/*     */   public Date getEndDate() {
/* 279 */     return getDAO_().getEndDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndDate(Date argEndDate) {
/* 287 */     if (setEndDate_noev(argEndDate) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(ISalesGoal.SET_ENDDATE, argEndDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEndDate_noev(Date argEndDate) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getEndDate() == null && argEndDate != null) || (
/* 300 */       getDAO_().getEndDate() != null && !getDAO_().getEndDate().equals(argEndDate))) {
/* 301 */       getDAO_().setEndDate(argEndDate);
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
/*     */   public String getDescription() {
/* 313 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 321 */     if (setDescription_noev(argDescription) && 
/* 322 */       this._events != null && 
/* 323 */       postEventsForChanges()) {
/* 324 */       this._events.post(ISalesGoal.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 331 */     boolean ev_postable = false;
/*     */     
/* 333 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 334 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 335 */       getDAO_().setDescription(argDescription);
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
/*     */   public Date getCreateDate() {
/* 347 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 355 */     if (setCreateDate_noev(argCreateDate) && 
/* 356 */       this._events != null && 
/* 357 */       postEventsForChanges()) {
/* 358 */       this._events.post(ISalesGoal.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 365 */     boolean ev_postable = false;
/*     */     
/* 367 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 368 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 369 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 381 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 389 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 390 */       this._events != null && 
/* 391 */       postEventsForChanges()) {
/* 392 */       this._events.post(ISalesGoal.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 399 */     boolean ev_postable = false;
/*     */     
/* 401 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 402 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 403 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 415 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 423 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 424 */       this._events != null && 
/* 425 */       postEventsForChanges()) {
/* 426 */       this._events.post(ISalesGoal.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 433 */     boolean ev_postable = false;
/*     */     
/* 435 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 436 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 437 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 449 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 457 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 458 */       this._events != null && 
/* 459 */       postEventsForChanges()) {
/* 460 */       this._events.post(ISalesGoal.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 467 */     boolean ev_postable = false;
/*     */     
/* 469 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 470 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 471 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 472 */       ev_postable = true;
/*     */     } 
/*     */     
/* 475 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ISalesGoalProperty newProperty(String argPropertyName) {
/* 479 */     SalesGoalPropertyId id = new SalesGoalPropertyId();
/*     */     
/* 481 */     id.setSalesGoalId(getSalesGoalId());
/* 482 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 484 */     ISalesGoalProperty prop = (ISalesGoalProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ISalesGoalProperty.class);
/* 485 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ISalesGoalProperty> getProperties() {
/* 494 */     if (this._properties == null) {
/* 495 */       this._properties = new HistoricalList(null);
/*     */     }
/* 497 */     return (List<ISalesGoalProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ISalesGoalProperty> argProperties) {
/* 501 */     if (this._properties == null) {
/* 502 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 504 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 507 */     for (ISalesGoalProperty child : this._properties) {
/* 508 */       SalesGoalPropertyModel model = (SalesGoalPropertyModel)child;
/* 509 */       model.setOrganizationId_noev(getOrganizationId());
/* 510 */       model.setSalesGoalId_noev(getSalesGoalId());
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
/*     */   public void addSalesGoalProperty(ISalesGoalProperty argSalesGoalProperty) {
/* 525 */     if (this._properties == null) {
/* 526 */       this._properties = new HistoricalList(null);
/*     */     }
/* 528 */     argSalesGoalProperty.setOrganizationId(getOrganizationId());
/* 529 */     argSalesGoalProperty.setSalesGoalId(getSalesGoalId());
/* 530 */     if (argSalesGoalProperty instanceof IDataModelImpl) {
/* 531 */       IDataAccessObject childDao = ((IDataModelImpl)argSalesGoalProperty).getDAO();
/* 532 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 533 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 534 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 539 */     if (postEventsForChanges()) {
/* 540 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSalesGoalProperty));
/*     */     }
/*     */     
/* 543 */     this._properties.add(argSalesGoalProperty);
/* 544 */     if (postEventsForChanges()) {
/* 545 */       this._events.post(ISalesGoal.ADD_PROPERTIES, argSalesGoalProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeSalesGoalProperty(ISalesGoalProperty argSalesGoalProperty) {
/* 550 */     if (this._properties != null) {
/*     */       
/* 552 */       if (postEventsForChanges()) {
/* 553 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSalesGoalProperty));
/*     */       }
/* 555 */       this._properties.remove(argSalesGoalProperty);
/* 556 */       if (postEventsForChanges()) {
/* 557 */         this._events.post(ISalesGoal.REMOVE_PROPERTIES, argSalesGoalProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 564 */     if ("Properties".equals(argFieldId)) {
/* 565 */       return getProperties();
/*     */     }
/* 567 */     if ("SalesGoalExtension".equals(argFieldId)) {
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
/* 578 */       setProperties(changeToList(argValue, ISalesGoalProperty.class));
/*     */     }
/* 580 */     else if ("SalesGoalExtension".equals(argFieldId)) {
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
/* 596 */       for (ISalesGoalProperty relationship : this._properties) {
/* 597 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getSalesGoalExt() {
/* 603 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setSalesGoalExt(IDataModel argExt) {
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sls\impl\SalesGoalModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */