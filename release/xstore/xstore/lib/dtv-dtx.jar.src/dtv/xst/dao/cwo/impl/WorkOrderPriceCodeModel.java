/*     */ package dtv.xst.dao.cwo.impl;
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
/*     */ import dtv.xst.dao.cwo.IWorkOrderPriceCode;
/*     */ import dtv.xst.dao.cwo.IWorkOrderPriceCodeProperty;
/*     */ import dtv.xst.dao.cwo.WorkOrderPriceCodePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class WorkOrderPriceCodeModel extends AbstractDataModelWithPropertyImpl<IWorkOrderPriceCodeProperty> implements IWorkOrderPriceCode {
/*     */   private static final long serialVersionUID = 867767481L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IWorkOrderPriceCodeProperty> _properties; private transient HistoricalList<IWorkOrderPriceCodeProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new WorkOrderPriceCodeDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WorkOrderPriceCodeDAO getDAO_() {
/*  46 */     return (WorkOrderPriceCodeDAO)this._daoImpl;
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
/*  70 */       this._events.post(IWorkOrderPriceCode.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<WorkOrderPriceCodePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((WorkOrderPriceCodePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getPriceCode() {
/* 101 */     return getDAO_().getPriceCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPriceCode(String argPriceCode) {
/* 109 */     if (setPriceCode_noev(argPriceCode) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IWorkOrderPriceCode.SET_PRICECODE, argPriceCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPriceCode_noev(String argPriceCode) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getPriceCode() == null && argPriceCode != null) || (
/* 122 */       getDAO_().getPriceCode() != null && !getDAO_().getPriceCode().equals(argPriceCode))) {
/* 123 */       getDAO_().setPriceCode(argPriceCode);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<WorkOrderPriceCodePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((WorkOrderPriceCodePropertyModel)it.next()).setPriceCode_noev(argPriceCode);
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
/* 154 */       this._events.post(IWorkOrderPriceCode.SET_CREATEDATE, argCreateDate);
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
/* 188 */       this._events.post(IWorkOrderPriceCode.SET_CREATEUSERID, argCreateUserId);
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
/* 222 */       this._events.post(IWorkOrderPriceCode.SET_UPDATEDATE, argUpdateDate);
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
/* 256 */       this._events.post(IWorkOrderPriceCode.SET_UPDATEUSERID, argUpdateUserId);
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
/* 290 */       this._events.post(IWorkOrderPriceCode.SET_ORGCODE, argOrgCode);
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
/* 324 */       this._events.post(IWorkOrderPriceCode.SET_ORGVALUE, argOrgValue);
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
/* 363 */       this._events.post(IWorkOrderPriceCode.SET_SORTORDER, Integer.valueOf(argSortOrder));
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
/* 397 */       this._events.post(IWorkOrderPriceCode.SET_DESCRIPTION, argDescription);
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
/*     */   public boolean getPromptForWarrantyNumber() {
/* 420 */     if (getDAO_().getPromptForWarrantyNumber() != null) {
/* 421 */       return getDAO_().getPromptForWarrantyNumber().booleanValue();
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
/*     */   public void setPromptForWarrantyNumber(boolean argPromptForWarrantyNumber) {
/* 433 */     if (setPromptForWarrantyNumber_noev(argPromptForWarrantyNumber) && 
/* 434 */       this._events != null && 
/* 435 */       postEventsForChanges()) {
/* 436 */       this._events.post(IWorkOrderPriceCode.SET_PROMPTFORWARRANTYNUMBER, Boolean.valueOf(argPromptForWarrantyNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPromptForWarrantyNumber_noev(boolean argPromptForWarrantyNumber) {
/* 443 */     boolean ev_postable = false;
/*     */     
/* 445 */     if ((getDAO_().getPromptForWarrantyNumber() == null && Boolean.valueOf(argPromptForWarrantyNumber) != null) || (
/* 446 */       getDAO_().getPromptForWarrantyNumber() != null && !getDAO_().getPromptForWarrantyNumber().equals(Boolean.valueOf(argPromptForWarrantyNumber)))) {
/* 447 */       getDAO_().setPromptForWarrantyNumber(Boolean.valueOf(argPromptForWarrantyNumber));
/* 448 */       ev_postable = true;
/*     */     } 
/*     */     
/* 451 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IWorkOrderPriceCodeProperty newProperty(String argPropertyName) {
/* 455 */     WorkOrderPriceCodePropertyId id = new WorkOrderPriceCodePropertyId();
/*     */     
/* 457 */     id.setPriceCode(getPriceCode());
/* 458 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 460 */     IWorkOrderPriceCodeProperty prop = (IWorkOrderPriceCodeProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IWorkOrderPriceCodeProperty.class);
/* 461 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IWorkOrderPriceCodeProperty> getProperties() {
/* 470 */     if (this._properties == null) {
/* 471 */       this._properties = new HistoricalList(null);
/*     */     }
/* 473 */     return (List<IWorkOrderPriceCodeProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IWorkOrderPriceCodeProperty> argProperties) {
/* 477 */     if (this._properties == null) {
/* 478 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 480 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 483 */     for (IWorkOrderPriceCodeProperty child : this._properties) {
/* 484 */       WorkOrderPriceCodePropertyModel model = (WorkOrderPriceCodePropertyModel)child;
/* 485 */       model.setOrganizationId_noev(getOrganizationId());
/* 486 */       model.setPriceCode_noev(getPriceCode());
/* 487 */       if (child instanceof IDataModelImpl) {
/* 488 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 489 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 490 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 491 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 494 */       if (postEventsForChanges()) {
/* 495 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addWorkOrderPriceCodeProperty(IWorkOrderPriceCodeProperty argWorkOrderPriceCodeProperty) {
/* 501 */     if (this._properties == null) {
/* 502 */       this._properties = new HistoricalList(null);
/*     */     }
/* 504 */     argWorkOrderPriceCodeProperty.setOrganizationId(getOrganizationId());
/* 505 */     argWorkOrderPriceCodeProperty.setPriceCode(getPriceCode());
/* 506 */     if (argWorkOrderPriceCodeProperty instanceof IDataModelImpl) {
/* 507 */       IDataAccessObject childDao = ((IDataModelImpl)argWorkOrderPriceCodeProperty).getDAO();
/* 508 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 509 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 510 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 515 */     if (postEventsForChanges()) {
/* 516 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkOrderPriceCodeProperty));
/*     */     }
/*     */     
/* 519 */     this._properties.add(argWorkOrderPriceCodeProperty);
/* 520 */     if (postEventsForChanges()) {
/* 521 */       this._events.post(IWorkOrderPriceCode.ADD_PROPERTIES, argWorkOrderPriceCodeProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeWorkOrderPriceCodeProperty(IWorkOrderPriceCodeProperty argWorkOrderPriceCodeProperty) {
/* 526 */     if (this._properties != null) {
/*     */       
/* 528 */       if (postEventsForChanges()) {
/* 529 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkOrderPriceCodeProperty));
/*     */       }
/* 531 */       this._properties.remove(argWorkOrderPriceCodeProperty);
/* 532 */       if (postEventsForChanges()) {
/* 533 */         this._events.post(IWorkOrderPriceCode.REMOVE_PROPERTIES, argWorkOrderPriceCodeProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 540 */     if ("Properties".equals(argFieldId)) {
/* 541 */       return getProperties();
/*     */     }
/* 543 */     if ("WorkOrderPriceCodeExtension".equals(argFieldId)) {
/* 544 */       return this._myExtension;
/*     */     }
/*     */     
/* 547 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 553 */     if ("Properties".equals(argFieldId)) {
/* 554 */       setProperties(changeToList(argValue, IWorkOrderPriceCodeProperty.class));
/*     */     }
/* 556 */     else if ("WorkOrderPriceCodeExtension".equals(argFieldId)) {
/* 557 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 560 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 566 */     this._persistenceDefaults = argPD;
/* 567 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 568 */     this._eventManager = argEM;
/* 569 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 570 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 571 */     if (this._properties != null) {
/* 572 */       for (IWorkOrderPriceCodeProperty relationship : this._properties) {
/* 573 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getWorkOrderPriceCodeExt() {
/* 579 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setWorkOrderPriceCodeExt(IDataModel argExt) {
/* 583 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 588 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 592 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 595 */     super.startTransaction();
/*     */     
/* 597 */     this._propertiesSavepoint = this._properties;
/* 598 */     if (this._properties != null) {
/* 599 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 600 */       Iterator<IDataModel> it = this._properties.iterator();
/* 601 */       while (it.hasNext()) {
/* 602 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 607 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 612 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 615 */     super.rollbackChanges();
/*     */     
/* 617 */     this._properties = this._propertiesSavepoint;
/* 618 */     this._propertiesSavepoint = null;
/* 619 */     if (this._properties != null) {
/* 620 */       Iterator<IDataModel> it = this._properties.iterator();
/* 621 */       while (it.hasNext()) {
/* 622 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 630 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 633 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 636 */     super.commitTransaction();
/*     */     
/* 638 */     this._propertiesSavepoint = this._properties;
/* 639 */     if (this._properties != null) {
/* 640 */       Iterator<IDataModel> it = this._properties.iterator();
/* 641 */       while (it.hasNext()) {
/* 642 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 644 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 648 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 653 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkOrderPriceCodeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */