/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.cwo.IWorkItem;
/*     */ import dtv.xst.dao.cwo.IWorkItemProperty;
/*     */ import dtv.xst.dao.cwo.IWorkOrderAccount;
/*     */ import dtv.xst.dao.cwo.WorkItemPropertyId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class WorkItemModel extends WorkItemBaseModel implements IWorkItem {
/*     */   private static final long serialVersionUID = 99166692L;
/*     */   private IWorkOrderAccount _workOrderAccount;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IWorkItemProperty> _properties; private transient HistoricalList<IWorkItemProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new WorkItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WorkItemDAO getDAO_() {
/*  49 */     return (WorkItemDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  57 */     if (getDAO_().getOrganizationId() != null) {
/*  58 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  61 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  70 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  71 */       this._events != null && 
/*  72 */       postEventsForChanges()) {
/*  73 */       this._events.post(IWorkItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  80 */     boolean ev_postable = false;
/*     */     
/*  82 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  83 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  84 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  85 */       ev_postable = true;
/*  86 */       if (this._properties != null) {
/*     */         
/*  88 */         Iterator<WorkItemPropertyModel> it = this._properties.iterator();
/*  89 */         while (it.hasNext())
/*     */         {
/*  91 */           ((WorkItemPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/* 104 */     return getDAO_().getCustAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 112 */     if (setCustAccountId_noev(argCustAccountId) && 
/* 113 */       this._events != null && 
/* 114 */       postEventsForChanges()) {
/* 115 */       this._events.post(IWorkItem.SET_CUSTACCOUNTID, argCustAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountId_noev(String argCustAccountId) {
/* 122 */     boolean ev_postable = false;
/*     */     
/* 124 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/* 125 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/* 126 */       getDAO_().setCustAccountId(argCustAccountId);
/* 127 */       ev_postable = true;
/* 128 */       if (this._properties != null) {
/*     */         
/* 130 */         Iterator<WorkItemPropertyModel> it = this._properties.iterator();
/* 131 */         while (it.hasNext())
/*     */         {
/* 133 */           ((WorkItemPropertyModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 138 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountCode() {
/* 146 */     return getDAO_().getCustAccountCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/* 154 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/* 155 */       this._events != null && 
/* 156 */       postEventsForChanges()) {
/* 157 */       this._events.post(IWorkItem.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/* 164 */     boolean ev_postable = false;
/*     */     
/* 166 */     if ((getDAO_().getCustAccountCode() == null && argCustAccountCode != null) || (
/* 167 */       getDAO_().getCustAccountCode() != null && !getDAO_().getCustAccountCode().equals(argCustAccountCode))) {
/* 168 */       getDAO_().setCustAccountCode(argCustAccountCode);
/* 169 */       ev_postable = true;
/* 170 */       if (this._properties != null) {
/*     */         
/* 172 */         Iterator<WorkItemPropertyModel> it = this._properties.iterator();
/* 173 */         while (it.hasNext())
/*     */         {
/* 175 */           ((WorkItemPropertyModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 180 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWorkItemSequence() {
/* 188 */     if (getDAO_().getWorkItemSequence() != null) {
/* 189 */       return getDAO_().getWorkItemSequence().intValue();
/*     */     }
/*     */     
/* 192 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkItemSequence(int argWorkItemSequence) {
/* 201 */     if (setWorkItemSequence_noev(argWorkItemSequence) && 
/* 202 */       this._events != null && 
/* 203 */       postEventsForChanges()) {
/* 204 */       this._events.post(IWorkItem.SET_WORKITEMSEQUENCE, Integer.valueOf(argWorkItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkItemSequence_noev(int argWorkItemSequence) {
/* 211 */     boolean ev_postable = false;
/*     */     
/* 213 */     if ((getDAO_().getWorkItemSequence() == null && Integer.valueOf(argWorkItemSequence) != null) || (
/* 214 */       getDAO_().getWorkItemSequence() != null && !getDAO_().getWorkItemSequence().equals(Integer.valueOf(argWorkItemSequence)))) {
/* 215 */       getDAO_().setWorkItemSequence(Integer.valueOf(argWorkItemSequence));
/* 216 */       ev_postable = true;
/* 217 */       if (this._properties != null) {
/*     */         
/* 219 */         Iterator<WorkItemPropertyModel> it = this._properties.iterator();
/* 220 */         while (it.hasNext())
/*     */         {
/* 222 */           ((WorkItemPropertyModel)it.next()).setWorkItemSequence_noev(argWorkItemSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 227 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 235 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 243 */     if (setCreateDate_noev(argCreateDate) && 
/* 244 */       this._events != null && 
/* 245 */       postEventsForChanges()) {
/* 246 */       this._events.post(IWorkItem.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 253 */     boolean ev_postable = false;
/*     */     
/* 255 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 256 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 257 */       getDAO_().setCreateDate(argCreateDate);
/* 258 */       ev_postable = true;
/*     */     } 
/*     */     
/* 261 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 269 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 277 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 278 */       this._events != null && 
/* 279 */       postEventsForChanges()) {
/* 280 */       this._events.post(IWorkItem.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 287 */     boolean ev_postable = false;
/*     */     
/* 289 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 290 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 291 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 303 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 311 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 312 */       this._events != null && 
/* 313 */       postEventsForChanges()) {
/* 314 */       this._events.post(IWorkItem.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 321 */     boolean ev_postable = false;
/*     */     
/* 323 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 324 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 325 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 337 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 345 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 346 */       this._events != null && 
/* 347 */       postEventsForChanges()) {
/* 348 */       this._events.post(IWorkItem.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 355 */     boolean ev_postable = false;
/*     */     
/* 357 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 358 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 359 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public String getItemId() {
/* 371 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 379 */     if (setItemId_noev(argItemId) && 
/* 380 */       this._events != null && 
/* 381 */       postEventsForChanges()) {
/* 382 */       this._events.post(IWorkItem.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 389 */     boolean ev_postable = false;
/*     */     
/* 391 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 392 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 393 */       getDAO_().setItemId(argItemId);
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
/*     */   public String getDescription() {
/* 405 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 413 */     if (setDescription_noev(argDescription) && 
/* 414 */       this._events != null && 
/* 415 */       postEventsForChanges()) {
/* 416 */       this._events.post(IWorkItem.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 423 */     boolean ev_postable = false;
/*     */     
/* 425 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 426 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 427 */       getDAO_().setDescription(argDescription);
/* 428 */       ev_postable = true;
/*     */     } 
/*     */     
/* 431 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getValueAmount() {
/* 439 */     return getDAO_().getValueAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueAmount(BigDecimal argValueAmount) {
/* 447 */     if (setValueAmount_noev(argValueAmount) && 
/* 448 */       this._events != null && 
/* 449 */       postEventsForChanges()) {
/* 450 */       this._events.post(IWorkItem.SET_VALUEAMOUNT, argValueAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setValueAmount_noev(BigDecimal argValueAmount) {
/* 457 */     boolean ev_postable = false;
/*     */     
/* 459 */     if ((getDAO_().getValueAmount() == null && argValueAmount != null) || (
/* 460 */       getDAO_().getValueAmount() != null && !getDAO_().getValueAmount().equals(argValueAmount))) {
/* 461 */       getDAO_().setValueAmount(argValueAmount);
/* 462 */       ev_postable = true;
/*     */     } 
/*     */     
/* 465 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWarrantyNumber() {
/* 473 */     return getDAO_().getWarrantyNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyNumber(String argWarrantyNumber) {
/* 481 */     if (setWarrantyNumber_noev(argWarrantyNumber) && 
/* 482 */       this._events != null && 
/* 483 */       postEventsForChanges()) {
/* 484 */       this._events.post(IWorkItem.SET_WARRANTYNUMBER, argWarrantyNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWarrantyNumber_noev(String argWarrantyNumber) {
/* 491 */     boolean ev_postable = false;
/*     */     
/* 493 */     if ((getDAO_().getWarrantyNumber() == null && argWarrantyNumber != null) || (
/* 494 */       getDAO_().getWarrantyNumber() != null && !getDAO_().getWarrantyNumber().equals(argWarrantyNumber))) {
/* 495 */       getDAO_().setWarrantyNumber(argWarrantyNumber);
/* 496 */       ev_postable = true;
/*     */     } 
/*     */     
/* 499 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWorkItemSerialNumber() {
/* 507 */     return getDAO_().getWorkItemSerialNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkItemSerialNumber(String argWorkItemSerialNumber) {
/* 515 */     if (setWorkItemSerialNumber_noev(argWorkItemSerialNumber) && 
/* 516 */       this._events != null && 
/* 517 */       postEventsForChanges()) {
/* 518 */       this._events.post(IWorkItem.SET_WORKITEMSERIALNUMBER, argWorkItemSerialNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkItemSerialNumber_noev(String argWorkItemSerialNumber) {
/* 525 */     boolean ev_postable = false;
/*     */     
/* 527 */     if ((getDAO_().getWorkItemSerialNumber() == null && argWorkItemSerialNumber != null) || (
/* 528 */       getDAO_().getWorkItemSerialNumber() != null && !getDAO_().getWorkItemSerialNumber().equals(argWorkItemSerialNumber))) {
/* 529 */       getDAO_().setWorkItemSerialNumber(argWorkItemSerialNumber);
/* 530 */       ev_postable = true;
/*     */     } 
/*     */     
/* 533 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getVoid() {
/* 541 */     if (getDAO_().getVoid() != null) {
/* 542 */       return getDAO_().getVoid().booleanValue();
/*     */     }
/*     */     
/* 545 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoid(boolean argVoid) {
/* 554 */     if (setVoid_noev(argVoid) && 
/* 555 */       this._events != null && 
/* 556 */       postEventsForChanges()) {
/* 557 */       this._events.post(IWorkItem.SET_VOID, Boolean.valueOf(argVoid));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoid_noev(boolean argVoid) {
/* 564 */     boolean ev_postable = false;
/*     */     
/* 566 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/* 567 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/* 568 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/* 569 */       ev_postable = true;
/*     */     } 
/*     */     
/* 572 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IWorkItemProperty newProperty(String argPropertyName) {
/* 576 */     WorkItemPropertyId id = new WorkItemPropertyId();
/*     */     
/* 578 */     id.setCustAccountId(getCustAccountId());
/* 579 */     id.setCustAccountCode(getCustAccountCode());
/* 580 */     id.setWorkItemSequence(Integer.valueOf(getWorkItemSequence()));
/* 581 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 583 */     IWorkItemProperty prop = (IWorkItemProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IWorkItemProperty.class);
/* 584 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IWorkItemProperty> getProperties() {
/* 593 */     if (this._properties == null) {
/* 594 */       this._properties = new HistoricalList(null);
/*     */     }
/* 596 */     return (List<IWorkItemProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IWorkItemProperty> argProperties) {
/* 600 */     if (this._properties == null) {
/* 601 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 603 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 606 */     for (IWorkItemProperty child : this._properties) {
/* 607 */       WorkItemPropertyModel model = (WorkItemPropertyModel)child;
/* 608 */       model.setOrganizationId_noev(getOrganizationId());
/* 609 */       model.setCustAccountId_noev(getCustAccountId());
/* 610 */       model.setCustAccountCode_noev(getCustAccountCode());
/* 611 */       model.setWorkItemSequence_noev(getWorkItemSequence());
/* 612 */       if (child instanceof IDataModelImpl) {
/* 613 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 614 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 615 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 616 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 619 */       if (postEventsForChanges()) {
/* 620 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addWorkItemProperty(IWorkItemProperty argWorkItemProperty) {
/* 626 */     if (this._properties == null) {
/* 627 */       this._properties = new HistoricalList(null);
/*     */     }
/* 629 */     argWorkItemProperty.setOrganizationId(getOrganizationId());
/* 630 */     argWorkItemProperty.setCustAccountId(getCustAccountId());
/* 631 */     argWorkItemProperty.setCustAccountCode(getCustAccountCode());
/* 632 */     argWorkItemProperty.setWorkItemSequence(getWorkItemSequence());
/* 633 */     if (argWorkItemProperty instanceof IDataModelImpl) {
/* 634 */       IDataAccessObject childDao = ((IDataModelImpl)argWorkItemProperty).getDAO();
/* 635 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 636 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 637 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 642 */     if (postEventsForChanges()) {
/* 643 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkItemProperty));
/*     */     }
/*     */     
/* 646 */     this._properties.add(argWorkItemProperty);
/* 647 */     if (postEventsForChanges()) {
/* 648 */       this._events.post(IWorkItem.ADD_PROPERTIES, argWorkItemProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeWorkItemProperty(IWorkItemProperty argWorkItemProperty) {
/* 653 */     if (this._properties != null) {
/*     */       
/* 655 */       if (postEventsForChanges()) {
/* 656 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkItemProperty));
/*     */       }
/* 658 */       this._properties.remove(argWorkItemProperty);
/* 659 */       if (postEventsForChanges()) {
/* 660 */         this._events.post(IWorkItem.REMOVE_PROPERTIES, argWorkItemProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setWorkOrderAccount(IWorkOrderAccount argWorkOrderAccount) {
/* 666 */     this._workOrderAccount = argWorkOrderAccount;
/*     */   }
/*     */   
/*     */   public IWorkOrderAccount getWorkOrderAccount() {
/* 670 */     return this._workOrderAccount;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 675 */     if ("Properties".equals(argFieldId)) {
/* 676 */       return getProperties();
/*     */     }
/* 678 */     if ("WorkItemExtension".equals(argFieldId)) {
/* 679 */       return this._myExtension;
/*     */     }
/*     */     
/* 682 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 688 */     if ("Properties".equals(argFieldId)) {
/* 689 */       setProperties(changeToList(argValue, IWorkItemProperty.class));
/*     */     }
/* 691 */     else if ("WorkItemExtension".equals(argFieldId)) {
/* 692 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 695 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 701 */     this._persistenceDefaults = argPD;
/* 702 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 703 */     this._eventManager = argEM;
/* 704 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 705 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 706 */     if (this._properties != null) {
/* 707 */       for (IWorkItemProperty relationship : this._properties) {
/* 708 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getWorkItemExt() {
/* 714 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setWorkItemExt(IDataModel argExt) {
/* 718 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 723 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 727 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 730 */     super.startTransaction();
/*     */     
/* 732 */     this._propertiesSavepoint = this._properties;
/* 733 */     if (this._properties != null) {
/* 734 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 735 */       Iterator<IDataModel> it = this._properties.iterator();
/* 736 */       while (it.hasNext()) {
/* 737 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 742 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 747 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 750 */     super.rollbackChanges();
/*     */     
/* 752 */     this._properties = this._propertiesSavepoint;
/* 753 */     this._propertiesSavepoint = null;
/* 754 */     if (this._properties != null) {
/* 755 */       Iterator<IDataModel> it = this._properties.iterator();
/* 756 */       while (it.hasNext()) {
/* 757 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 765 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 768 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 771 */     super.commitTransaction();
/*     */     
/* 773 */     this._propertiesSavepoint = this._properties;
/* 774 */     if (this._properties != null) {
/* 775 */       Iterator<IDataModel> it = this._properties.iterator();
/* 776 */       while (it.hasNext()) {
/* 777 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 779 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 783 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */