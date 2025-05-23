/*     */ package dtv.xst.dao.cwo.impl;
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
/*     */ import dtv.xst.dao.cwo.IWorkOrderCategory;
/*     */ import dtv.xst.dao.cwo.IWorkOrderCategoryProperty;
/*     */ import dtv.xst.dao.cwo.WorkOrderCategoryPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class WorkOrderCategoryModel extends AbstractDataModelWithPropertyImpl<IWorkOrderCategoryProperty> implements IWorkOrderCategory {
/*     */   private static final long serialVersionUID = 1116923579L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IWorkOrderCategoryProperty> _properties; private transient HistoricalList<IWorkOrderCategoryProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new WorkOrderCategoryDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WorkOrderCategoryDAO getDAO_() {
/*  46 */     return (WorkOrderCategoryDAO)this._daoImpl;
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
/*  70 */       this._events.post(IWorkOrderCategory.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<WorkOrderCategoryPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((WorkOrderCategoryPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getCategoryId() {
/* 101 */     return getDAO_().getCategoryId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCategoryId(String argCategoryId) {
/* 109 */     if (setCategoryId_noev(argCategoryId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IWorkOrderCategory.SET_CATEGORYID, argCategoryId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCategoryId_noev(String argCategoryId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getCategoryId() == null && argCategoryId != null) || (
/* 122 */       getDAO_().getCategoryId() != null && !getDAO_().getCategoryId().equals(argCategoryId))) {
/* 123 */       getDAO_().setCategoryId(argCategoryId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<WorkOrderCategoryPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((WorkOrderCategoryPropertyModel)it.next()).setCategoryId_noev(argCategoryId);
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
/* 154 */       this._events.post(IWorkOrderCategory.SET_CREATEDATE, argCreateDate);
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
/* 188 */       this._events.post(IWorkOrderCategory.SET_CREATEUSERID, argCreateUserId);
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
/* 222 */       this._events.post(IWorkOrderCategory.SET_UPDATEDATE, argUpdateDate);
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
/* 256 */       this._events.post(IWorkOrderCategory.SET_UPDATEUSERID, argUpdateUserId);
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
/* 290 */       this._events.post(IWorkOrderCategory.SET_ORGCODE, argOrgCode);
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
/* 324 */       this._events.post(IWorkOrderCategory.SET_ORGVALUE, argOrgValue);
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
/*     */   public int getSortOrder() {
/* 347 */     if (getDAO_().getSortOrder() != null) {
/* 348 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 351 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 360 */     if (setSortOrder_noev(argSortOrder) && 
/* 361 */       this._events != null && 
/* 362 */       postEventsForChanges()) {
/* 363 */       this._events.post(IWorkOrderCategory.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 370 */     boolean ev_postable = false;
/*     */     
/* 372 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 373 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 374 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 375 */       ev_postable = true;
/*     */     } 
/*     */     
/* 378 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 386 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 394 */     if (setDescription_noev(argDescription) && 
/* 395 */       this._events != null && 
/* 396 */       postEventsForChanges()) {
/* 397 */       this._events.post(IWorkOrderCategory.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 404 */     boolean ev_postable = false;
/*     */     
/* 406 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 407 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 408 */       getDAO_().setDescription(argDescription);
/* 409 */       ev_postable = true;
/*     */     } 
/*     */     
/* 412 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPromptForPriceCode() {
/* 420 */     if (getDAO_().getPromptForPriceCode() != null) {
/* 421 */       return getDAO_().getPromptForPriceCode().booleanValue();
/*     */     }
/*     */     
/* 424 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPromptForPriceCode(boolean argPromptForPriceCode) {
/* 433 */     if (setPromptForPriceCode_noev(argPromptForPriceCode) && 
/* 434 */       this._events != null && 
/* 435 */       postEventsForChanges()) {
/* 436 */       this._events.post(IWorkOrderCategory.SET_PROMPTFORPRICECODE, Boolean.valueOf(argPromptForPriceCode));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPromptForPriceCode_noev(boolean argPromptForPriceCode) {
/* 443 */     boolean ev_postable = false;
/*     */     
/* 445 */     if ((getDAO_().getPromptForPriceCode() == null && Boolean.valueOf(argPromptForPriceCode) != null) || (
/* 446 */       getDAO_().getPromptForPriceCode() != null && !getDAO_().getPromptForPriceCode().equals(Boolean.valueOf(argPromptForPriceCode)))) {
/* 447 */       getDAO_().setPromptForPriceCode(Boolean.valueOf(argPromptForPriceCode));
/* 448 */       ev_postable = true;
/*     */     } 
/*     */     
/* 451 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getMaxItemCount() {
/* 459 */     return getDAO_().getMaxItemCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxItemCount(BigDecimal argMaxItemCount) {
/* 467 */     if (setMaxItemCount_noev(argMaxItemCount) && 
/* 468 */       this._events != null && 
/* 469 */       postEventsForChanges()) {
/* 470 */       this._events.post(IWorkOrderCategory.SET_MAXITEMCOUNT, argMaxItemCount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMaxItemCount_noev(BigDecimal argMaxItemCount) {
/* 477 */     boolean ev_postable = false;
/*     */     
/* 479 */     if ((getDAO_().getMaxItemCount() == null && argMaxItemCount != null) || (
/* 480 */       getDAO_().getMaxItemCount() != null && !getDAO_().getMaxItemCount().equals(argMaxItemCount))) {
/* 481 */       getDAO_().setMaxItemCount(argMaxItemCount);
/* 482 */       ev_postable = true;
/*     */     } 
/*     */     
/* 485 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IWorkOrderCategoryProperty newProperty(String argPropertyName) {
/* 489 */     WorkOrderCategoryPropertyId id = new WorkOrderCategoryPropertyId();
/*     */     
/* 491 */     id.setCategoryId(getCategoryId());
/* 492 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 494 */     IWorkOrderCategoryProperty prop = (IWorkOrderCategoryProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IWorkOrderCategoryProperty.class);
/* 495 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IWorkOrderCategoryProperty> getProperties() {
/* 504 */     if (this._properties == null) {
/* 505 */       this._properties = new HistoricalList(null);
/*     */     }
/* 507 */     return (List<IWorkOrderCategoryProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IWorkOrderCategoryProperty> argProperties) {
/* 511 */     if (this._properties == null) {
/* 512 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 514 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 517 */     for (IWorkOrderCategoryProperty child : this._properties) {
/* 518 */       WorkOrderCategoryPropertyModel model = (WorkOrderCategoryPropertyModel)child;
/* 519 */       model.setOrganizationId_noev(getOrganizationId());
/* 520 */       model.setCategoryId_noev(getCategoryId());
/* 521 */       if (child instanceof IDataModelImpl) {
/* 522 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 523 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 524 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 525 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 528 */       if (postEventsForChanges()) {
/* 529 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addWorkOrderCategoryProperty(IWorkOrderCategoryProperty argWorkOrderCategoryProperty) {
/* 535 */     if (this._properties == null) {
/* 536 */       this._properties = new HistoricalList(null);
/*     */     }
/* 538 */     argWorkOrderCategoryProperty.setOrganizationId(getOrganizationId());
/* 539 */     argWorkOrderCategoryProperty.setCategoryId(getCategoryId());
/* 540 */     if (argWorkOrderCategoryProperty instanceof IDataModelImpl) {
/* 541 */       IDataAccessObject childDao = ((IDataModelImpl)argWorkOrderCategoryProperty).getDAO();
/* 542 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 543 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 544 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 549 */     if (postEventsForChanges()) {
/* 550 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkOrderCategoryProperty));
/*     */     }
/*     */     
/* 553 */     this._properties.add(argWorkOrderCategoryProperty);
/* 554 */     if (postEventsForChanges()) {
/* 555 */       this._events.post(IWorkOrderCategory.ADD_PROPERTIES, argWorkOrderCategoryProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeWorkOrderCategoryProperty(IWorkOrderCategoryProperty argWorkOrderCategoryProperty) {
/* 560 */     if (this._properties != null) {
/*     */       
/* 562 */       if (postEventsForChanges()) {
/* 563 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkOrderCategoryProperty));
/*     */       }
/* 565 */       this._properties.remove(argWorkOrderCategoryProperty);
/* 566 */       if (postEventsForChanges()) {
/* 567 */         this._events.post(IWorkOrderCategory.REMOVE_PROPERTIES, argWorkOrderCategoryProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 574 */     if ("Properties".equals(argFieldId)) {
/* 575 */       return getProperties();
/*     */     }
/* 577 */     if ("WorkOrderCategoryExtension".equals(argFieldId)) {
/* 578 */       return this._myExtension;
/*     */     }
/*     */     
/* 581 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 587 */     if ("Properties".equals(argFieldId)) {
/* 588 */       setProperties(changeToList(argValue, IWorkOrderCategoryProperty.class));
/*     */     }
/* 590 */     else if ("WorkOrderCategoryExtension".equals(argFieldId)) {
/* 591 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 594 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 600 */     this._persistenceDefaults = argPD;
/* 601 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 602 */     this._eventManager = argEM;
/* 603 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 604 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 605 */     if (this._properties != null) {
/* 606 */       for (IWorkOrderCategoryProperty relationship : this._properties) {
/* 607 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getWorkOrderCategoryExt() {
/* 613 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setWorkOrderCategoryExt(IDataModel argExt) {
/* 617 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 622 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 626 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 629 */     super.startTransaction();
/*     */     
/* 631 */     this._propertiesSavepoint = this._properties;
/* 632 */     if (this._properties != null) {
/* 633 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 634 */       Iterator<IDataModel> it = this._properties.iterator();
/* 635 */       while (it.hasNext()) {
/* 636 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 641 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 646 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 649 */     super.rollbackChanges();
/*     */     
/* 651 */     this._properties = this._propertiesSavepoint;
/* 652 */     this._propertiesSavepoint = null;
/* 653 */     if (this._properties != null) {
/* 654 */       Iterator<IDataModel> it = this._properties.iterator();
/* 655 */       while (it.hasNext()) {
/* 656 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 664 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 667 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 670 */     super.commitTransaction();
/*     */     
/* 672 */     this._propertiesSavepoint = this._properties;
/* 673 */     if (this._properties != null) {
/* 674 */       Iterator<IDataModel> it = this._properties.iterator();
/* 675 */       while (it.hasNext()) {
/* 676 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 678 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 682 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 687 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkOrderCategoryModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */