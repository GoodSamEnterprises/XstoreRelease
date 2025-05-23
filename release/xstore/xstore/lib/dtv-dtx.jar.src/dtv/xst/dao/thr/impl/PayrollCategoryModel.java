/*     */ package dtv.xst.dao.thr.impl;
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
/*     */ import dtv.xst.dao.thr.IPayrollCategory;
/*     */ import dtv.xst.dao.thr.IPayrollCategoryProperty;
/*     */ import dtv.xst.dao.thr.PayrollCategoryPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class PayrollCategoryModel extends AbstractDataModelWithPropertyImpl<IPayrollCategoryProperty> implements IPayrollCategory {
/*     */   private static final long serialVersionUID = 75858211L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IPayrollCategoryProperty> _properties; private transient HistoricalList<IPayrollCategoryProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new PayrollCategoryDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PayrollCategoryDAO getDAO_() {
/*  46 */     return (PayrollCategoryDAO)this._daoImpl;
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
/*  70 */       this._events.post(IPayrollCategory.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<PayrollCategoryPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((PayrollCategoryPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getPayrollCategory() {
/* 101 */     return getDAO_().getPayrollCategory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPayrollCategory(String argPayrollCategory) {
/* 109 */     if (setPayrollCategory_noev(argPayrollCategory) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IPayrollCategory.SET_PAYROLLCATEGORY, argPayrollCategory);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPayrollCategory_noev(String argPayrollCategory) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getPayrollCategory() == null && argPayrollCategory != null) || (
/* 122 */       getDAO_().getPayrollCategory() != null && !getDAO_().getPayrollCategory().equals(argPayrollCategory))) {
/* 123 */       getDAO_().setPayrollCategory(argPayrollCategory);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<PayrollCategoryPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((PayrollCategoryPropertyModel)it.next()).setPayrollCategory_noev(argPayrollCategory);
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
/* 154 */       this._events.post(IPayrollCategory.SET_CREATEDATE, argCreateDate);
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
/* 188 */       this._events.post(IPayrollCategory.SET_CREATEUSERID, argCreateUserId);
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
/* 222 */       this._events.post(IPayrollCategory.SET_UPDATEDATE, argUpdateDate);
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
/* 256 */       this._events.post(IPayrollCategory.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getDescription() {
/* 279 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 287 */     if (setDescription_noev(argDescription) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(IPayrollCategory.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 300 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 301 */       getDAO_().setDescription(argDescription);
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
/*     */   public int getSortOrder() {
/* 313 */     if (getDAO_().getSortOrder() != null) {
/* 314 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 317 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 326 */     if (setSortOrder_noev(argSortOrder) && 
/* 327 */       this._events != null && 
/* 328 */       postEventsForChanges()) {
/* 329 */       this._events.post(IPayrollCategory.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 336 */     boolean ev_postable = false;
/*     */     
/* 338 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 339 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 340 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 341 */       ev_postable = true;
/*     */     } 
/*     */     
/* 344 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getIncludeInOverTime() {
/* 352 */     if (getDAO_().getIncludeInOverTime() != null) {
/* 353 */       return getDAO_().getIncludeInOverTime().booleanValue();
/*     */     }
/*     */     
/* 356 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeInOverTime(boolean argIncludeInOverTime) {
/* 365 */     if (setIncludeInOverTime_noev(argIncludeInOverTime) && 
/* 366 */       this._events != null && 
/* 367 */       postEventsForChanges()) {
/* 368 */       this._events.post(IPayrollCategory.SET_INCLUDEINOVERTIME, Boolean.valueOf(argIncludeInOverTime));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIncludeInOverTime_noev(boolean argIncludeInOverTime) {
/* 375 */     boolean ev_postable = false;
/*     */     
/* 377 */     if ((getDAO_().getIncludeInOverTime() == null && Boolean.valueOf(argIncludeInOverTime) != null) || (
/* 378 */       getDAO_().getIncludeInOverTime() != null && !getDAO_().getIncludeInOverTime().equals(Boolean.valueOf(argIncludeInOverTime)))) {
/* 379 */       getDAO_().setIncludeInOverTime(Boolean.valueOf(argIncludeInOverTime));
/* 380 */       ev_postable = true;
/*     */     } 
/*     */     
/* 383 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPayCode() {
/* 391 */     return getDAO_().getPayCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPayCode(String argPayCode) {
/* 399 */     if (setPayCode_noev(argPayCode) && 
/* 400 */       this._events != null && 
/* 401 */       postEventsForChanges()) {
/* 402 */       this._events.post(IPayrollCategory.SET_PAYCODE, argPayCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPayCode_noev(String argPayCode) {
/* 409 */     boolean ev_postable = false;
/*     */     
/* 411 */     if ((getDAO_().getPayCode() == null && argPayCode != null) || (
/* 412 */       getDAO_().getPayCode() != null && !getDAO_().getPayCode().equals(argPayCode))) {
/* 413 */       getDAO_().setPayCode(argPayCode);
/* 414 */       ev_postable = true;
/*     */     } 
/*     */     
/* 417 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getWorkingCategory() {
/* 425 */     if (getDAO_().getWorkingCategory() != null) {
/* 426 */       return getDAO_().getWorkingCategory().booleanValue();
/*     */     }
/*     */     
/* 429 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkingCategory(boolean argWorkingCategory) {
/* 438 */     if (setWorkingCategory_noev(argWorkingCategory) && 
/* 439 */       this._events != null && 
/* 440 */       postEventsForChanges()) {
/* 441 */       this._events.post(IPayrollCategory.SET_WORKINGCATEGORY, Boolean.valueOf(argWorkingCategory));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkingCategory_noev(boolean argWorkingCategory) {
/* 448 */     boolean ev_postable = false;
/*     */     
/* 450 */     if ((getDAO_().getWorkingCategory() == null && Boolean.valueOf(argWorkingCategory) != null) || (
/* 451 */       getDAO_().getWorkingCategory() != null && !getDAO_().getWorkingCategory().equals(Boolean.valueOf(argWorkingCategory)))) {
/* 452 */       getDAO_().setWorkingCategory(Boolean.valueOf(argWorkingCategory));
/* 453 */       ev_postable = true;
/*     */     } 
/*     */     
/* 456 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IPayrollCategoryProperty newProperty(String argPropertyName) {
/* 460 */     PayrollCategoryPropertyId id = new PayrollCategoryPropertyId();
/*     */     
/* 462 */     id.setPayrollCategory(getPayrollCategory());
/* 463 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 465 */     IPayrollCategoryProperty prop = (IPayrollCategoryProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPayrollCategoryProperty.class);
/* 466 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IPayrollCategoryProperty> getProperties() {
/* 475 */     if (this._properties == null) {
/* 476 */       this._properties = new HistoricalList(null);
/*     */     }
/* 478 */     return (List<IPayrollCategoryProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IPayrollCategoryProperty> argProperties) {
/* 482 */     if (this._properties == null) {
/* 483 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 485 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 488 */     for (IPayrollCategoryProperty child : this._properties) {
/* 489 */       PayrollCategoryPropertyModel model = (PayrollCategoryPropertyModel)child;
/* 490 */       model.setOrganizationId_noev(getOrganizationId());
/* 491 */       model.setPayrollCategory_noev(getPayrollCategory());
/* 492 */       if (child instanceof IDataModelImpl) {
/* 493 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 494 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 495 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 496 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 499 */       if (postEventsForChanges()) {
/* 500 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addPayrollCategoryProperty(IPayrollCategoryProperty argPayrollCategoryProperty) {
/* 506 */     if (this._properties == null) {
/* 507 */       this._properties = new HistoricalList(null);
/*     */     }
/* 509 */     argPayrollCategoryProperty.setOrganizationId(getOrganizationId());
/* 510 */     argPayrollCategoryProperty.setPayrollCategory(getPayrollCategory());
/* 511 */     if (argPayrollCategoryProperty instanceof IDataModelImpl) {
/* 512 */       IDataAccessObject childDao = ((IDataModelImpl)argPayrollCategoryProperty).getDAO();
/* 513 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 514 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 515 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 520 */     if (postEventsForChanges()) {
/* 521 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPayrollCategoryProperty));
/*     */     }
/*     */     
/* 524 */     this._properties.add(argPayrollCategoryProperty);
/* 525 */     if (postEventsForChanges()) {
/* 526 */       this._events.post(IPayrollCategory.ADD_PROPERTIES, argPayrollCategoryProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePayrollCategoryProperty(IPayrollCategoryProperty argPayrollCategoryProperty) {
/* 531 */     if (this._properties != null) {
/*     */       
/* 533 */       if (postEventsForChanges()) {
/* 534 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPayrollCategoryProperty));
/*     */       }
/* 536 */       this._properties.remove(argPayrollCategoryProperty);
/* 537 */       if (postEventsForChanges()) {
/* 538 */         this._events.post(IPayrollCategory.REMOVE_PROPERTIES, argPayrollCategoryProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 545 */     if ("Properties".equals(argFieldId)) {
/* 546 */       return getProperties();
/*     */     }
/* 548 */     if ("PayrollCategoryExtension".equals(argFieldId)) {
/* 549 */       return this._myExtension;
/*     */     }
/*     */     
/* 552 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 558 */     if ("Properties".equals(argFieldId)) {
/* 559 */       setProperties(changeToList(argValue, IPayrollCategoryProperty.class));
/*     */     }
/* 561 */     else if ("PayrollCategoryExtension".equals(argFieldId)) {
/* 562 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 565 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 571 */     this._persistenceDefaults = argPD;
/* 572 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 573 */     this._eventManager = argEM;
/* 574 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 575 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 576 */     if (this._properties != null) {
/* 577 */       for (IPayrollCategoryProperty relationship : this._properties) {
/* 578 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getPayrollCategoryExt() {
/* 584 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setPayrollCategoryExt(IDataModel argExt) {
/* 588 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 593 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 597 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 600 */     super.startTransaction();
/*     */     
/* 602 */     this._propertiesSavepoint = this._properties;
/* 603 */     if (this._properties != null) {
/* 604 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 605 */       Iterator<IDataModel> it = this._properties.iterator();
/* 606 */       while (it.hasNext()) {
/* 607 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 612 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 617 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 620 */     super.rollbackChanges();
/*     */     
/* 622 */     this._properties = this._propertiesSavepoint;
/* 623 */     this._propertiesSavepoint = null;
/* 624 */     if (this._properties != null) {
/* 625 */       Iterator<IDataModel> it = this._properties.iterator();
/* 626 */       while (it.hasNext()) {
/* 627 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 635 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 638 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 641 */     super.commitTransaction();
/*     */     
/* 643 */     this._propertiesSavepoint = this._properties;
/* 644 */     if (this._properties != null) {
/* 645 */       Iterator<IDataModel> it = this._properties.iterator();
/* 646 */       while (it.hasNext()) {
/* 647 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 649 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 653 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 658 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\PayrollCategoryModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */