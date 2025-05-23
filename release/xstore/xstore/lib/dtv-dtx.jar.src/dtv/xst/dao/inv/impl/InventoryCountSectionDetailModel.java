/*     */ package dtv.xst.dao.inv.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
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
/*     */ import dtv.xst.dao.inv.IInventoryCountSection;
/*     */ import dtv.xst.dao.inv.IInventoryCountSectionDetail;
/*     */ import dtv.xst.dao.inv.IInventoryCountSectionDetailProperty;
/*     */ import dtv.xst.dao.inv.InventoryCountSectionDetailPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryCountSectionDetailModel extends AbstractDataModelWithPropertyImpl<IInventoryCountSectionDetailProperty> implements IInventoryCountSectionDetail {
/*     */   private static final long serialVersionUID = 1362489635L;
/*     */   private IInventoryCountSection _parentSection;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IInventoryCountSectionDetailProperty> _properties; private transient HistoricalList<IInventoryCountSectionDetailProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new InventoryCountSectionDetailDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryCountSectionDetailDAO getDAO_() {
/*  48 */     return (InventoryCountSectionDetailDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  56 */     if (getDAO_().getOrganizationId() != null) {
/*  57 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  60 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  69 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  70 */       this._events != null && 
/*  71 */       postEventsForChanges()) {
/*  72 */       this._events.post(IInventoryCountSectionDetail.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  79 */     boolean ev_postable = false;
/*     */     
/*  81 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  82 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  83 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  84 */       ev_postable = true;
/*  85 */       if (this._properties != null) {
/*     */         
/*  87 */         Iterator<InventoryCountSectionDetailPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((InventoryCountSectionDetailPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 103 */     if (getDAO_().getRetailLocationId() != null) {
/* 104 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 107 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 116 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 117 */       this._events != null && 
/* 118 */       postEventsForChanges()) {
/* 119 */       this._events.post(IInventoryCountSectionDetail.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 126 */     boolean ev_postable = false;
/*     */     
/* 128 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 129 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 130 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 131 */       ev_postable = true;
/* 132 */       if (this._properties != null) {
/*     */         
/* 134 */         Iterator<InventoryCountSectionDetailPropertyModel> it = this._properties.iterator();
/* 135 */         while (it.hasNext())
/*     */         {
/* 137 */           ((InventoryCountSectionDetailPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInventoryBucketId() {
/* 150 */     return getDAO_().getInventoryBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/* 158 */     if (setInventoryBucketId_noev(argInventoryBucketId) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(IInventoryCountSectionDetail.SET_INVENTORYBUCKETID, argInventoryBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryBucketId_noev(String argInventoryBucketId) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getInventoryBucketId() == null && argInventoryBucketId != null) || (
/* 171 */       getDAO_().getInventoryBucketId() != null && !getDAO_().getInventoryBucketId().equals(argInventoryBucketId))) {
/* 172 */       getDAO_().setInventoryBucketId(argInventoryBucketId);
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<InventoryCountSectionDetailPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((InventoryCountSectionDetailPropertyModel)it.next()).setInventoryBucketId_noev(argInventoryBucketId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 184 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSectionId() {
/* 192 */     return getDAO_().getSectionId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSectionId(String argSectionId) {
/* 200 */     if (setSectionId_noev(argSectionId) && 
/* 201 */       this._events != null && 
/* 202 */       postEventsForChanges()) {
/* 203 */       this._events.post(IInventoryCountSectionDetail.SET_SECTIONID, argSectionId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSectionId_noev(String argSectionId) {
/* 210 */     boolean ev_postable = false;
/*     */     
/* 212 */     if ((getDAO_().getSectionId() == null && argSectionId != null) || (
/* 213 */       getDAO_().getSectionId() != null && !getDAO_().getSectionId().equals(argSectionId))) {
/* 214 */       getDAO_().setSectionId(argSectionId);
/* 215 */       ev_postable = true;
/* 216 */       if (this._properties != null) {
/*     */         
/* 218 */         Iterator<InventoryCountSectionDetailPropertyModel> it = this._properties.iterator();
/* 219 */         while (it.hasNext())
/*     */         {
/* 221 */           ((InventoryCountSectionDetailPropertyModel)it.next()).setSectionId_noev(argSectionId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 226 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSectionDetailNumber() {
/* 234 */     if (getDAO_().getSectionDetailNumber() != null) {
/* 235 */       return getDAO_().getSectionDetailNumber().intValue();
/*     */     }
/*     */     
/* 238 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSectionDetailNumber(int argSectionDetailNumber) {
/* 247 */     if (setSectionDetailNumber_noev(argSectionDetailNumber) && 
/* 248 */       this._events != null && 
/* 249 */       postEventsForChanges()) {
/* 250 */       this._events.post(IInventoryCountSectionDetail.SET_SECTIONDETAILNUMBER, Integer.valueOf(argSectionDetailNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSectionDetailNumber_noev(int argSectionDetailNumber) {
/* 257 */     boolean ev_postable = false;
/*     */     
/* 259 */     if ((getDAO_().getSectionDetailNumber() == null && Integer.valueOf(argSectionDetailNumber) != null) || (
/* 260 */       getDAO_().getSectionDetailNumber() != null && !getDAO_().getSectionDetailNumber().equals(Integer.valueOf(argSectionDetailNumber)))) {
/* 261 */       getDAO_().setSectionDetailNumber(Integer.valueOf(argSectionDetailNumber));
/* 262 */       ev_postable = true;
/* 263 */       if (this._properties != null) {
/*     */         
/* 265 */         Iterator<InventoryCountSectionDetailPropertyModel> it = this._properties.iterator();
/* 266 */         while (it.hasNext())
/*     */         {
/* 268 */           ((InventoryCountSectionDetailPropertyModel)it.next()).setSectionDetailNumber_noev(argSectionDetailNumber);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 273 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 281 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 289 */     if (setCreateDate_noev(argCreateDate) && 
/* 290 */       this._events != null && 
/* 291 */       postEventsForChanges()) {
/* 292 */       this._events.post(IInventoryCountSectionDetail.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 299 */     boolean ev_postable = false;
/*     */     
/* 301 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 302 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 303 */       getDAO_().setCreateDate(argCreateDate);
/* 304 */       ev_postable = true;
/*     */     } 
/*     */     
/* 307 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 315 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 323 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 324 */       this._events != null && 
/* 325 */       postEventsForChanges()) {
/* 326 */       this._events.post(IInventoryCountSectionDetail.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 333 */     boolean ev_postable = false;
/*     */     
/* 335 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 336 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 337 */       getDAO_().setCreateUserId(argCreateUserId);
/* 338 */       ev_postable = true;
/*     */     } 
/*     */     
/* 341 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 349 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 357 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 358 */       this._events != null && 
/* 359 */       postEventsForChanges()) {
/* 360 */       this._events.post(IInventoryCountSectionDetail.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 367 */     boolean ev_postable = false;
/*     */     
/* 369 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 370 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 371 */       getDAO_().setUpdateDate(argUpdateDate);
/* 372 */       ev_postable = true;
/*     */     } 
/*     */     
/* 375 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 383 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 391 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 392 */       this._events != null && 
/* 393 */       postEventsForChanges()) {
/* 394 */       this._events.post(IInventoryCountSectionDetail.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 401 */     boolean ev_postable = false;
/*     */     
/* 403 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 404 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 405 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 406 */       ev_postable = true;
/*     */     } 
/*     */     
/* 409 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMerchandiseHierarchyLevel() {
/* 417 */     return getDAO_().getMerchandiseHierarchyLevel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMerchandiseHierarchyLevel(String argMerchandiseHierarchyLevel) {
/* 425 */     if (setMerchandiseHierarchyLevel_noev(argMerchandiseHierarchyLevel) && 
/* 426 */       this._events != null && 
/* 427 */       postEventsForChanges()) {
/* 428 */       this._events.post(IInventoryCountSectionDetail.SET_MERCHANDISEHIERARCHYLEVEL, argMerchandiseHierarchyLevel);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMerchandiseHierarchyLevel_noev(String argMerchandiseHierarchyLevel) {
/* 435 */     boolean ev_postable = false;
/*     */     
/* 437 */     if ((getDAO_().getMerchandiseHierarchyLevel() == null && argMerchandiseHierarchyLevel != null) || (
/* 438 */       getDAO_().getMerchandiseHierarchyLevel() != null && !getDAO_().getMerchandiseHierarchyLevel().equals(argMerchandiseHierarchyLevel))) {
/* 439 */       getDAO_().setMerchandiseHierarchyLevel(argMerchandiseHierarchyLevel);
/* 440 */       ev_postable = true;
/*     */     } 
/*     */     
/* 443 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMerchandiseHierarchyId() {
/* 451 */     return getDAO_().getMerchandiseHierarchyId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMerchandiseHierarchyId(String argMerchandiseHierarchyId) {
/* 459 */     if (setMerchandiseHierarchyId_noev(argMerchandiseHierarchyId) && 
/* 460 */       this._events != null && 
/* 461 */       postEventsForChanges()) {
/* 462 */       this._events.post(IInventoryCountSectionDetail.SET_MERCHANDISEHIERARCHYID, argMerchandiseHierarchyId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMerchandiseHierarchyId_noev(String argMerchandiseHierarchyId) {
/* 469 */     boolean ev_postable = false;
/*     */     
/* 471 */     if ((getDAO_().getMerchandiseHierarchyId() == null && argMerchandiseHierarchyId != null) || (
/* 472 */       getDAO_().getMerchandiseHierarchyId() != null && !getDAO_().getMerchandiseHierarchyId().equals(argMerchandiseHierarchyId))) {
/* 473 */       getDAO_().setMerchandiseHierarchyId(argMerchandiseHierarchyId);
/* 474 */       ev_postable = true;
/*     */     } 
/*     */     
/* 477 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 485 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 493 */     if (setDescription_noev(argDescription) && 
/* 494 */       this._events != null && 
/* 495 */       postEventsForChanges()) {
/* 496 */       this._events.post(IInventoryCountSectionDetail.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 503 */     boolean ev_postable = false;
/*     */     
/* 505 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 506 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 507 */       getDAO_().setDescription(argDescription);
/* 508 */       ev_postable = true;
/*     */     } 
/*     */     
/* 511 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryCountSectionDetailProperty newProperty(String argPropertyName) {
/* 515 */     InventoryCountSectionDetailPropertyId id = new InventoryCountSectionDetailPropertyId();
/*     */     
/* 517 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 518 */     id.setInventoryBucketId(getInventoryBucketId());
/* 519 */     id.setSectionId(getSectionId());
/* 520 */     id.setSectionDetailNumber(Integer.valueOf(getSectionDetailNumber()));
/* 521 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 523 */     IInventoryCountSectionDetailProperty prop = (IInventoryCountSectionDetailProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryCountSectionDetailProperty.class);
/* 524 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryCountSectionDetailProperty> getProperties() {
/* 533 */     if (this._properties == null) {
/* 534 */       this._properties = new HistoricalList(null);
/*     */     }
/* 536 */     return (List<IInventoryCountSectionDetailProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryCountSectionDetailProperty> argProperties) {
/* 540 */     if (this._properties == null) {
/* 541 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 543 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 546 */     for (IInventoryCountSectionDetailProperty child : this._properties) {
/* 547 */       InventoryCountSectionDetailPropertyModel model = (InventoryCountSectionDetailPropertyModel)child;
/* 548 */       model.setOrganizationId_noev(getOrganizationId());
/* 549 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 550 */       model.setInventoryBucketId_noev(getInventoryBucketId());
/* 551 */       model.setSectionId_noev(getSectionId());
/* 552 */       model.setSectionDetailNumber_noev(getSectionDetailNumber());
/* 553 */       if (child instanceof IDataModelImpl) {
/* 554 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 555 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 556 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 557 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 560 */       if (postEventsForChanges()) {
/* 561 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryCountSectionDetailProperty(IInventoryCountSectionDetailProperty argInventoryCountSectionDetailProperty) {
/* 567 */     if (this._properties == null) {
/* 568 */       this._properties = new HistoricalList(null);
/*     */     }
/* 570 */     argInventoryCountSectionDetailProperty.setOrganizationId(getOrganizationId());
/* 571 */     argInventoryCountSectionDetailProperty.setRetailLocationId(getRetailLocationId());
/* 572 */     argInventoryCountSectionDetailProperty.setInventoryBucketId(getInventoryBucketId());
/* 573 */     argInventoryCountSectionDetailProperty.setSectionId(getSectionId());
/* 574 */     argInventoryCountSectionDetailProperty.setSectionDetailNumber(getSectionDetailNumber());
/* 575 */     if (argInventoryCountSectionDetailProperty instanceof IDataModelImpl) {
/* 576 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryCountSectionDetailProperty).getDAO();
/* 577 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 578 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 579 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 584 */     if (postEventsForChanges()) {
/* 585 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountSectionDetailProperty));
/*     */     }
/*     */     
/* 588 */     this._properties.add(argInventoryCountSectionDetailProperty);
/* 589 */     if (postEventsForChanges()) {
/* 590 */       this._events.post(IInventoryCountSectionDetail.ADD_PROPERTIES, argInventoryCountSectionDetailProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryCountSectionDetailProperty(IInventoryCountSectionDetailProperty argInventoryCountSectionDetailProperty) {
/* 595 */     if (this._properties != null) {
/*     */       
/* 597 */       if (postEventsForChanges()) {
/* 598 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountSectionDetailProperty));
/*     */       }
/* 600 */       this._properties.remove(argInventoryCountSectionDetailProperty);
/* 601 */       if (postEventsForChanges()) {
/* 602 */         this._events.post(IInventoryCountSectionDetail.REMOVE_PROPERTIES, argInventoryCountSectionDetailProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentSection(IInventoryCountSection argParentSection) {
/* 608 */     this._parentSection = argParentSection;
/*     */   }
/*     */   
/*     */   public IInventoryCountSection getParentSection() {
/* 612 */     return this._parentSection;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 617 */     if ("Properties".equals(argFieldId)) {
/* 618 */       return getProperties();
/*     */     }
/* 620 */     if ("InventoryCountSectionDetailExtension".equals(argFieldId)) {
/* 621 */       return this._myExtension;
/*     */     }
/*     */     
/* 624 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 630 */     if ("Properties".equals(argFieldId)) {
/* 631 */       setProperties(changeToList(argValue, IInventoryCountSectionDetailProperty.class));
/*     */     }
/* 633 */     else if ("InventoryCountSectionDetailExtension".equals(argFieldId)) {
/* 634 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 637 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 643 */     this._persistenceDefaults = argPD;
/* 644 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 645 */     this._eventManager = argEM;
/* 646 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 647 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 648 */     if (this._properties != null) {
/* 649 */       for (IInventoryCountSectionDetailProperty relationship : this._properties) {
/* 650 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryCountSectionDetailExt() {
/* 656 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryCountSectionDetailExt(IDataModel argExt) {
/* 660 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 665 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 669 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 672 */     super.startTransaction();
/*     */     
/* 674 */     this._propertiesSavepoint = this._properties;
/* 675 */     if (this._properties != null) {
/* 676 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 677 */       Iterator<IDataModel> it = this._properties.iterator();
/* 678 */       while (it.hasNext()) {
/* 679 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 684 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 689 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 692 */     super.rollbackChanges();
/*     */     
/* 694 */     this._properties = this._propertiesSavepoint;
/* 695 */     this._propertiesSavepoint = null;
/* 696 */     if (this._properties != null) {
/* 697 */       Iterator<IDataModel> it = this._properties.iterator();
/* 698 */       while (it.hasNext()) {
/* 699 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 707 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 710 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 713 */     super.commitTransaction();
/*     */     
/* 715 */     this._propertiesSavepoint = this._properties;
/* 716 */     if (this._properties != null) {
/* 717 */       Iterator<IDataModel> it = this._properties.iterator();
/* 718 */       while (it.hasNext()) {
/* 719 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 721 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 725 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 730 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSectionDetailModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */