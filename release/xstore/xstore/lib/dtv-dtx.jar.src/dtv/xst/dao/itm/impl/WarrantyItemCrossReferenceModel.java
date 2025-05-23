/*     */ package dtv.xst.dao.itm.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.itm.IWarrantyItem;
/*     */ import dtv.xst.dao.itm.IWarrantyItemCrossReference;
/*     */ import dtv.xst.dao.itm.IWarrantyItemCrossReferenceProperty;
/*     */ import dtv.xst.dao.itm.WarrantyItemCrossReferencePropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class WarrantyItemCrossReferenceModel extends AbstractDataModelWithPropertyImpl<IWarrantyItemCrossReferenceProperty> implements IWarrantyItemCrossReference {
/*     */   private static final long serialVersionUID = -332362982L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IWarrantyItem _warrantyItem; private transient IWarrantyItem _warrantyItemSavepoint; private HistoricalList<IWarrantyItemCrossReferenceProperty> _properties; private transient HistoricalList<IWarrantyItemCrossReferenceProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new WarrantyItemCrossReferenceDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WarrantyItemCrossReferenceDAO getDAO_() {
/*  47 */     return (WarrantyItemCrossReferenceDAO)this._daoImpl;
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
/*  71 */       this._events.post(IWarrantyItemCrossReference.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  86 */         Iterator<WarrantyItemCrossReferencePropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((WarrantyItemCrossReferencePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getItemId() {
/* 102 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 110 */     if (setItemId_noev(argItemId) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(IWarrantyItemCrossReference.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 123 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 124 */       getDAO_().setItemId(argItemId);
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<WarrantyItemCrossReferencePropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((WarrantyItemCrossReferencePropertyModel)it.next()).setItemId_noev(argItemId);
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
/*     */   public String getWarrantyItemId() {
/* 144 */     return getDAO_().getWarrantyItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyItemId(String argWarrantyItemId) {
/* 152 */     if (setWarrantyItemId_noev(argWarrantyItemId) && 
/* 153 */       this._events != null && 
/* 154 */       postEventsForChanges()) {
/* 155 */       this._events.post(IWarrantyItemCrossReference.SET_WARRANTYITEMID, argWarrantyItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWarrantyItemId_noev(String argWarrantyItemId) {
/* 162 */     boolean ev_postable = false;
/*     */     
/* 164 */     if ((getDAO_().getWarrantyItemId() == null && argWarrantyItemId != null) || (
/* 165 */       getDAO_().getWarrantyItemId() != null && !getDAO_().getWarrantyItemId().equals(argWarrantyItemId))) {
/* 166 */       getDAO_().setWarrantyItemId(argWarrantyItemId);
/* 167 */       ev_postable = true;
/* 168 */       if (this._properties != null) {
/*     */         
/* 170 */         Iterator<WarrantyItemCrossReferencePropertyModel> it = this._properties.iterator();
/* 171 */         while (it.hasNext())
/*     */         {
/* 173 */           ((WarrantyItemCrossReferencePropertyModel)it.next()).setWarrantyItemId_noev(argWarrantyItemId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 178 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 186 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 194 */     if (setOrgCode_noev(argOrgCode) && 
/* 195 */       this._events != null && 
/* 196 */       postEventsForChanges()) {
/* 197 */       this._events.post(IWarrantyItemCrossReference.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 204 */     boolean ev_postable = false;
/*     */     
/* 206 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 207 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 208 */       getDAO_().setOrgCode(argOrgCode);
/* 209 */       ev_postable = true;
/*     */     } 
/*     */     
/* 212 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 220 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 228 */     if (setOrgValue_noev(argOrgValue) && 
/* 229 */       this._events != null && 
/* 230 */       postEventsForChanges()) {
/* 231 */       this._events.post(IWarrantyItemCrossReference.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 238 */     boolean ev_postable = false;
/*     */     
/* 240 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 241 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 242 */       getDAO_().setOrgValue(argOrgValue);
/* 243 */       ev_postable = true;
/*     */     } 
/*     */     
/* 246 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 254 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 262 */     if (setCreateDate_noev(argCreateDate) && 
/* 263 */       this._events != null && 
/* 264 */       postEventsForChanges()) {
/* 265 */       this._events.post(IWarrantyItemCrossReference.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 272 */     boolean ev_postable = false;
/*     */     
/* 274 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 275 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 276 */       getDAO_().setCreateDate(argCreateDate);
/* 277 */       ev_postable = true;
/*     */     } 
/*     */     
/* 280 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 288 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 296 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 297 */       this._events != null && 
/* 298 */       postEventsForChanges()) {
/* 299 */       this._events.post(IWarrantyItemCrossReference.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 306 */     boolean ev_postable = false;
/*     */     
/* 308 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 309 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 310 */       getDAO_().setCreateUserId(argCreateUserId);
/* 311 */       ev_postable = true;
/*     */     } 
/*     */     
/* 314 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 322 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 330 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 331 */       this._events != null && 
/* 332 */       postEventsForChanges()) {
/* 333 */       this._events.post(IWarrantyItemCrossReference.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 340 */     boolean ev_postable = false;
/*     */     
/* 342 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 343 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 344 */       getDAO_().setUpdateDate(argUpdateDate);
/* 345 */       ev_postable = true;
/*     */     } 
/*     */     
/* 348 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 356 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 364 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 365 */       this._events != null && 
/* 366 */       postEventsForChanges()) {
/* 367 */       this._events.post(IWarrantyItemCrossReference.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 374 */     boolean ev_postable = false;
/*     */     
/* 376 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 377 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 378 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 379 */       ev_postable = true;
/*     */     } 
/*     */     
/* 382 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWarrantyTypeCode() {
/* 390 */     return getDAO_().getWarrantyTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyTypeCode(String argWarrantyTypeCode) {
/* 398 */     if (setWarrantyTypeCode_noev(argWarrantyTypeCode) && 
/* 399 */       this._events != null && 
/* 400 */       postEventsForChanges()) {
/* 401 */       this._events.post(IWarrantyItemCrossReference.SET_WARRANTYTYPECODE, argWarrantyTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWarrantyTypeCode_noev(String argWarrantyTypeCode) {
/* 408 */     boolean ev_postable = false;
/*     */     
/* 410 */     if ((getDAO_().getWarrantyTypeCode() == null && argWarrantyTypeCode != null) || (
/* 411 */       getDAO_().getWarrantyTypeCode() != null && !getDAO_().getWarrantyTypeCode().equals(argWarrantyTypeCode))) {
/* 412 */       getDAO_().setWarrantyTypeCode(argWarrantyTypeCode);
/* 413 */       ev_postable = true;
/*     */     } 
/*     */     
/* 416 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSortOrder() {
/* 424 */     if (getDAO_().getSortOrder() != null) {
/* 425 */       return getDAO_().getSortOrder().longValue();
/*     */     }
/*     */     
/* 428 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(long argSortOrder) {
/* 437 */     if (setSortOrder_noev(argSortOrder) && 
/* 438 */       this._events != null && 
/* 439 */       postEventsForChanges()) {
/* 440 */       this._events.post(IWarrantyItemCrossReference.SET_SORTORDER, Long.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(long argSortOrder) {
/* 447 */     boolean ev_postable = false;
/*     */     
/* 449 */     if ((getDAO_().getSortOrder() == null && Long.valueOf(argSortOrder) != null) || (
/* 450 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Long.valueOf(argSortOrder)))) {
/* 451 */       getDAO_().setSortOrder(Long.valueOf(argSortOrder));
/* 452 */       ev_postable = true;
/*     */     } 
/*     */     
/* 455 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IWarrantyItemCrossReferenceProperty newProperty(String argPropertyName) {
/* 459 */     WarrantyItemCrossReferencePropertyId id = new WarrantyItemCrossReferencePropertyId();
/*     */     
/* 461 */     id.setItemId(getItemId());
/* 462 */     id.setWarrantyItemId(getWarrantyItemId());
/* 463 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 465 */     IWarrantyItemCrossReferenceProperty prop = (IWarrantyItemCrossReferenceProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IWarrantyItemCrossReferenceProperty.class);
/* 466 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "WarrantyItem")
/*     */   public IWarrantyItem getWarrantyItem() {
/* 478 */     return this._warrantyItem;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWarrantyItem(IWarrantyItem argWarrantyItem) {
/* 483 */     if (argWarrantyItem == null) {
/*     */       
/* 485 */       if (this._warrantyItem != null) {
/* 486 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*     */       }
/*     */       
/* 489 */       if (this._warrantyItem != null)
/*     */       {
/* 491 */         if (postEventsForChanges()) {
/* 492 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._warrantyItem));
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     }
/* 498 */     else if (postEventsForChanges()) {
/* 499 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWarrantyItem));
/*     */     } 
/*     */ 
/*     */     
/* 503 */     this._warrantyItem = argWarrantyItem;
/* 504 */     if (postEventsForChanges()) {
/* 505 */       this._events.post(IWarrantyItemCrossReference.SET_WARRANTYITEM, argWarrantyItem);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IWarrantyItemCrossReferenceProperty> getProperties() {
/* 511 */     if (this._properties == null) {
/* 512 */       this._properties = new HistoricalList(null);
/*     */     }
/* 514 */     return (List<IWarrantyItemCrossReferenceProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IWarrantyItemCrossReferenceProperty> argProperties) {
/* 518 */     if (this._properties == null) {
/* 519 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 521 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 524 */     for (IWarrantyItemCrossReferenceProperty child : this._properties) {
/* 525 */       WarrantyItemCrossReferencePropertyModel model = (WarrantyItemCrossReferencePropertyModel)child;
/* 526 */       model.setOrganizationId_noev(getOrganizationId());
/* 527 */       model.setItemId_noev(getItemId());
/* 528 */       model.setWarrantyItemId_noev(getWarrantyItemId());
/* 529 */       if (child instanceof IDataModelImpl) {
/* 530 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 531 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 532 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 533 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 536 */       if (postEventsForChanges()) {
/* 537 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addWarrantyItemCrossReferenceProperty(IWarrantyItemCrossReferenceProperty argWarrantyItemCrossReferenceProperty) {
/* 543 */     if (this._properties == null) {
/* 544 */       this._properties = new HistoricalList(null);
/*     */     }
/* 546 */     argWarrantyItemCrossReferenceProperty.setOrganizationId(getOrganizationId());
/* 547 */     argWarrantyItemCrossReferenceProperty.setItemId(getItemId());
/* 548 */     argWarrantyItemCrossReferenceProperty.setWarrantyItemId(getWarrantyItemId());
/* 549 */     if (argWarrantyItemCrossReferenceProperty instanceof IDataModelImpl) {
/* 550 */       IDataAccessObject childDao = ((IDataModelImpl)argWarrantyItemCrossReferenceProperty).getDAO();
/* 551 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 552 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 553 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 558 */     if (postEventsForChanges()) {
/* 559 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWarrantyItemCrossReferenceProperty));
/*     */     }
/*     */     
/* 562 */     this._properties.add(argWarrantyItemCrossReferenceProperty);
/* 563 */     if (postEventsForChanges()) {
/* 564 */       this._events.post(IWarrantyItemCrossReference.ADD_PROPERTIES, argWarrantyItemCrossReferenceProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeWarrantyItemCrossReferenceProperty(IWarrantyItemCrossReferenceProperty argWarrantyItemCrossReferenceProperty) {
/* 569 */     if (this._properties != null) {
/*     */       
/* 571 */       if (postEventsForChanges()) {
/* 572 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWarrantyItemCrossReferenceProperty));
/*     */       }
/* 574 */       this._properties.remove(argWarrantyItemCrossReferenceProperty);
/* 575 */       if (postEventsForChanges()) {
/* 576 */         this._events.post(IWarrantyItemCrossReference.REMOVE_PROPERTIES, argWarrantyItemCrossReferenceProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 583 */     if ("WarrantyItem".equals(argFieldId)) {
/* 584 */       return getWarrantyItem();
/*     */     }
/* 586 */     if ("Properties".equals(argFieldId)) {
/* 587 */       return getProperties();
/*     */     }
/* 589 */     if ("WarrantyItemCrossReferenceExtension".equals(argFieldId)) {
/* 590 */       return this._myExtension;
/*     */     }
/*     */     
/* 593 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 599 */     if ("WarrantyItem".equals(argFieldId)) {
/* 600 */       setWarrantyItem((IWarrantyItem)argValue);
/*     */     }
/* 602 */     else if ("Properties".equals(argFieldId)) {
/* 603 */       setProperties(changeToList(argValue, IWarrantyItemCrossReferenceProperty.class));
/*     */     }
/* 605 */     else if ("WarrantyItemCrossReferenceExtension".equals(argFieldId)) {
/* 606 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 609 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 615 */     this._persistenceDefaults = argPD;
/* 616 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 617 */     this._eventManager = argEM;
/* 618 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 619 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 620 */     if (this._warrantyItem != null) {
/* 621 */       ((IDataModelImpl)this._warrantyItem).setDependencies(argPD, argEM);
/*     */     }
/* 623 */     if (this._properties != null) {
/* 624 */       for (IWarrantyItemCrossReferenceProperty relationship : this._properties) {
/* 625 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getWarrantyItemCrossReferenceExt() {
/* 631 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setWarrantyItemCrossReferenceExt(IDataModel argExt) {
/* 635 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 640 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 644 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 647 */     super.startTransaction();
/*     */     
/* 649 */     this._warrantyItemSavepoint = this._warrantyItem;
/* 650 */     if (this._warrantyItem != null) {
/* 651 */       this._warrantyItem.startTransaction();
/*     */     }
/*     */     
/* 654 */     this._propertiesSavepoint = this._properties;
/* 655 */     if (this._properties != null) {
/* 656 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 657 */       Iterator<IDataModel> it = this._properties.iterator();
/* 658 */       while (it.hasNext()) {
/* 659 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 664 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 669 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 672 */     super.rollbackChanges();
/*     */     
/* 674 */     this._warrantyItem = this._warrantyItemSavepoint;
/* 675 */     this._warrantyItemSavepoint = null;
/* 676 */     if (this._warrantyItem != null) {
/* 677 */       this._warrantyItem.rollbackChanges();
/*     */     }
/*     */     
/* 680 */     this._properties = this._propertiesSavepoint;
/* 681 */     this._propertiesSavepoint = null;
/* 682 */     if (this._properties != null) {
/* 683 */       Iterator<IDataModel> it = this._properties.iterator();
/* 684 */       while (it.hasNext()) {
/* 685 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 693 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 696 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 699 */     super.commitTransaction();
/*     */     
/* 701 */     this._warrantyItemSavepoint = this._warrantyItem;
/* 702 */     if (this._warrantyItem != null) {
/* 703 */       this._warrantyItem.commitTransaction();
/*     */     }
/*     */     
/* 706 */     this._propertiesSavepoint = this._properties;
/* 707 */     if (this._properties != null) {
/* 708 */       Iterator<IDataModel> it = this._properties.iterator();
/* 709 */       while (it.hasNext()) {
/* 710 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 712 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 716 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 721 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyItemCrossReferenceModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */