/*     */ package dtv.xst.dao.inv.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
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
/*     */ import dtv.xst.dao.inv.IInventoryCountSection;
/*     */ import dtv.xst.dao.inv.IInventoryCountSectionDetail;
/*     */ import dtv.xst.dao.inv.IInventoryCountSectionProperty;
/*     */ import dtv.xst.dao.inv.InventoryCountSectionPropertyId;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryCountSectionModel extends InventoryCountSectionBaseModel implements IInventoryCountSection {
/*     */   private static final long serialVersionUID = 2004539954L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private HistoricalList<IInventoryCountSectionDetail> _sectionDetails; private transient HistoricalList<IInventoryCountSectionDetail> _sectionDetailsSavepoint; private HistoricalList<IInventoryCountSectionProperty> _properties; private transient HistoricalList<IInventoryCountSectionProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new InventoryCountSectionDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryCountSectionDAO getDAO_() {
/*  47 */     return (InventoryCountSectionDAO)this._daoImpl;
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
/*  71 */       this._events.post(IInventoryCountSection.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  84 */       if (this._sectionDetails != null) {
/*     */         
/*  86 */         Iterator<InventoryCountSectionDetailModel> it = this._sectionDetails.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((InventoryCountSectionDetailModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  92 */       if (this._properties != null) {
/*     */         
/*  94 */         Iterator<InventoryCountSectionPropertyModel> it = this._properties.iterator();
/*  95 */         while (it.hasNext())
/*     */         {
/*  97 */           ((InventoryCountSectionPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 110 */     if (getDAO_().getRetailLocationId() != null) {
/* 111 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 114 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 123 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 124 */       this._events != null && 
/* 125 */       postEventsForChanges()) {
/* 126 */       this._events.post(IInventoryCountSection.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 133 */     boolean ev_postable = false;
/*     */     
/* 135 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 136 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 137 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 138 */       ev_postable = true;
/* 139 */       if (this._sectionDetails != null) {
/*     */         
/* 141 */         Iterator<InventoryCountSectionDetailModel> it = this._sectionDetails.iterator();
/* 142 */         while (it.hasNext())
/*     */         {
/* 144 */           ((InventoryCountSectionDetailModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/* 147 */       if (this._properties != null) {
/*     */         
/* 149 */         Iterator<InventoryCountSectionPropertyModel> it = this._properties.iterator();
/* 150 */         while (it.hasNext())
/*     */         {
/* 152 */           ((InventoryCountSectionPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 157 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInventoryBucketId() {
/* 165 */     return getDAO_().getInventoryBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/* 173 */     if (setInventoryBucketId_noev(argInventoryBucketId) && 
/* 174 */       this._events != null && 
/* 175 */       postEventsForChanges()) {
/* 176 */       this._events.post(IInventoryCountSection.SET_INVENTORYBUCKETID, argInventoryBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryBucketId_noev(String argInventoryBucketId) {
/* 183 */     boolean ev_postable = false;
/*     */     
/* 185 */     if ((getDAO_().getInventoryBucketId() == null && argInventoryBucketId != null) || (
/* 186 */       getDAO_().getInventoryBucketId() != null && !getDAO_().getInventoryBucketId().equals(argInventoryBucketId))) {
/* 187 */       getDAO_().setInventoryBucketId(argInventoryBucketId);
/* 188 */       ev_postable = true;
/* 189 */       if (this._sectionDetails != null) {
/*     */         
/* 191 */         Iterator<InventoryCountSectionDetailModel> it = this._sectionDetails.iterator();
/* 192 */         while (it.hasNext())
/*     */         {
/* 194 */           ((InventoryCountSectionDetailModel)it.next()).setInventoryBucketId_noev(argInventoryBucketId);
/*     */         }
/*     */       } 
/* 197 */       if (this._properties != null) {
/*     */         
/* 199 */         Iterator<InventoryCountSectionPropertyModel> it = this._properties.iterator();
/* 200 */         while (it.hasNext())
/*     */         {
/* 202 */           ((InventoryCountSectionPropertyModel)it.next()).setInventoryBucketId_noev(argInventoryBucketId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 207 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSectionId() {
/* 215 */     return getDAO_().getSectionId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSectionId(String argSectionId) {
/* 223 */     if (setSectionId_noev(argSectionId) && 
/* 224 */       this._events != null && 
/* 225 */       postEventsForChanges()) {
/* 226 */       this._events.post(IInventoryCountSection.SET_SECTIONID, argSectionId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSectionId_noev(String argSectionId) {
/* 233 */     boolean ev_postable = false;
/*     */     
/* 235 */     if ((getDAO_().getSectionId() == null && argSectionId != null) || (
/* 236 */       getDAO_().getSectionId() != null && !getDAO_().getSectionId().equals(argSectionId))) {
/* 237 */       getDAO_().setSectionId(argSectionId);
/* 238 */       ev_postable = true;
/* 239 */       if (this._sectionDetails != null) {
/*     */         
/* 241 */         Iterator<InventoryCountSectionDetailModel> it = this._sectionDetails.iterator();
/* 242 */         while (it.hasNext())
/*     */         {
/* 244 */           ((InventoryCountSectionDetailModel)it.next()).setSectionId_noev(argSectionId);
/*     */         }
/*     */       } 
/* 247 */       if (this._properties != null) {
/*     */         
/* 249 */         Iterator<InventoryCountSectionPropertyModel> it = this._properties.iterator();
/* 250 */         while (it.hasNext())
/*     */         {
/* 252 */           ((InventoryCountSectionPropertyModel)it.next()).setSectionId_noev(argSectionId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 257 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 265 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 273 */     if (setCreateDate_noev(argCreateDate) && 
/* 274 */       this._events != null && 
/* 275 */       postEventsForChanges()) {
/* 276 */       this._events.post(IInventoryCountSection.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 283 */     boolean ev_postable = false;
/*     */     
/* 285 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 286 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 287 */       getDAO_().setCreateDate(argCreateDate);
/* 288 */       ev_postable = true;
/*     */     } 
/*     */     
/* 291 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 299 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 307 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 308 */       this._events != null && 
/* 309 */       postEventsForChanges()) {
/* 310 */       this._events.post(IInventoryCountSection.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 317 */     boolean ev_postable = false;
/*     */     
/* 319 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 320 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 321 */       getDAO_().setCreateUserId(argCreateUserId);
/* 322 */       ev_postable = true;
/*     */     } 
/*     */     
/* 325 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 333 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 341 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 342 */       this._events != null && 
/* 343 */       postEventsForChanges()) {
/* 344 */       this._events.post(IInventoryCountSection.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 351 */     boolean ev_postable = false;
/*     */     
/* 353 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 354 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 355 */       getDAO_().setUpdateDate(argUpdateDate);
/* 356 */       ev_postable = true;
/*     */     } 
/*     */     
/* 359 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 367 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 375 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 376 */       this._events != null && 
/* 377 */       postEventsForChanges()) {
/* 378 */       this._events.post(IInventoryCountSection.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 385 */     boolean ev_postable = false;
/*     */     
/* 387 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 388 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 389 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 390 */       ev_postable = true;
/*     */     } 
/*     */     
/* 393 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 401 */     if (getDAO_().getSortOrder() != null) {
/* 402 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 405 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 414 */     if (setSortOrder_noev(argSortOrder) && 
/* 415 */       this._events != null && 
/* 416 */       postEventsForChanges()) {
/* 417 */       this._events.post(IInventoryCountSection.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 424 */     boolean ev_postable = false;
/*     */     
/* 426 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 427 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 428 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 429 */       ev_postable = true;
/*     */     } 
/*     */     
/* 432 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInventoryBucketName() {
/* 440 */     return getDAO_().getInventoryBucketName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryBucketName(String argInventoryBucketName) {
/* 448 */     if (setInventoryBucketName_noev(argInventoryBucketName) && 
/* 449 */       this._events != null && 
/* 450 */       postEventsForChanges()) {
/* 451 */       this._events.post(IInventoryCountSection.SET_INVENTORYBUCKETNAME, argInventoryBucketName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryBucketName_noev(String argInventoryBucketName) {
/* 458 */     boolean ev_postable = false;
/*     */     
/* 460 */     if ((getDAO_().getInventoryBucketName() == null && argInventoryBucketName != null) || (
/* 461 */       getDAO_().getInventoryBucketName() != null && !getDAO_().getInventoryBucketName().equals(argInventoryBucketName))) {
/* 462 */       getDAO_().setInventoryBucketName(argInventoryBucketName);
/* 463 */       ev_postable = true;
/*     */     } 
/*     */     
/* 466 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryCountSectionProperty newProperty(String argPropertyName) {
/* 470 */     InventoryCountSectionPropertyId id = new InventoryCountSectionPropertyId();
/*     */     
/* 472 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 473 */     id.setInventoryBucketId(getInventoryBucketId());
/* 474 */     id.setSectionId(getSectionId());
/* 475 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 477 */     IInventoryCountSectionProperty prop = (IInventoryCountSectionProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryCountSectionProperty.class);
/* 478 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "SectionDetails")
/*     */   public List<IInventoryCountSectionDetail> getSectionDetails() {
/* 490 */     if (this._sectionDetails == null) {
/* 491 */       this._sectionDetails = new HistoricalList(null);
/*     */     }
/* 493 */     return (List<IInventoryCountSectionDetail>)this._sectionDetails;
/*     */   }
/*     */   
/*     */   public void setSectionDetails(List<IInventoryCountSectionDetail> argSectionDetails) {
/* 497 */     if (this._sectionDetails == null) {
/* 498 */       this._sectionDetails = new HistoricalList(argSectionDetails);
/*     */     } else {
/* 500 */       this._sectionDetails.setCurrentList(argSectionDetails);
/*     */     } 
/*     */     
/* 503 */     for (IInventoryCountSectionDetail child : this._sectionDetails) {
/* 504 */       child.setParentSection(this);
/*     */     }
/*     */ 
/*     */     
/* 508 */     for (IInventoryCountSectionDetail child : this._sectionDetails) {
/* 509 */       InventoryCountSectionDetailModel model = (InventoryCountSectionDetailModel)child;
/* 510 */       model.setOrganizationId_noev(getOrganizationId());
/* 511 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 512 */       model.setInventoryBucketId_noev(getInventoryBucketId());
/* 513 */       model.setSectionId_noev(getSectionId());
/* 514 */       if (child instanceof IDataModelImpl) {
/* 515 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 516 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 517 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 518 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 521 */       if (postEventsForChanges()) {
/* 522 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryCountSectionDetail(IInventoryCountSectionDetail argInventoryCountSectionDetail) {
/* 528 */     super.addInventoryCountSectionDetail(argInventoryCountSectionDetail);
/*     */ 
/*     */     
/* 531 */     argInventoryCountSectionDetail.setParentSection(this);
/* 532 */     if (this._sectionDetails == null) {
/* 533 */       this._sectionDetails = new HistoricalList(null);
/*     */     }
/* 535 */     argInventoryCountSectionDetail.setOrganizationId(getOrganizationId());
/* 536 */     argInventoryCountSectionDetail.setRetailLocationId(getRetailLocationId());
/* 537 */     argInventoryCountSectionDetail.setInventoryBucketId(getInventoryBucketId());
/* 538 */     argInventoryCountSectionDetail.setSectionId(getSectionId());
/* 539 */     if (argInventoryCountSectionDetail instanceof IDataModelImpl) {
/* 540 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryCountSectionDetail).getDAO();
/* 541 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 542 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 543 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 548 */     if (postEventsForChanges()) {
/* 549 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountSectionDetail));
/*     */     }
/*     */     
/* 552 */     this._sectionDetails.add(argInventoryCountSectionDetail);
/* 553 */     if (postEventsForChanges()) {
/* 554 */       this._events.post(IInventoryCountSection.ADD_SECTIONDETAILS, argInventoryCountSectionDetail);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryCountSectionDetail(IInventoryCountSectionDetail argInventoryCountSectionDetail) {
/* 559 */     if (this._sectionDetails != null) {
/*     */       
/* 561 */       if (postEventsForChanges()) {
/* 562 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountSectionDetail));
/*     */       }
/* 564 */       this._sectionDetails.remove(argInventoryCountSectionDetail);
/*     */       
/* 566 */       argInventoryCountSectionDetail.setParentSection(null);
/* 567 */       if (postEventsForChanges()) {
/* 568 */         this._events.post(IInventoryCountSection.REMOVE_SECTIONDETAILS, argInventoryCountSectionDetail);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryCountSectionProperty> getProperties() {
/* 575 */     if (this._properties == null) {
/* 576 */       this._properties = new HistoricalList(null);
/*     */     }
/* 578 */     return (List<IInventoryCountSectionProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryCountSectionProperty> argProperties) {
/* 582 */     if (this._properties == null) {
/* 583 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 585 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 588 */     for (IInventoryCountSectionProperty child : this._properties) {
/* 589 */       InventoryCountSectionPropertyModel model = (InventoryCountSectionPropertyModel)child;
/* 590 */       model.setOrganizationId_noev(getOrganizationId());
/* 591 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 592 */       model.setInventoryBucketId_noev(getInventoryBucketId());
/* 593 */       model.setSectionId_noev(getSectionId());
/* 594 */       if (child instanceof IDataModelImpl) {
/* 595 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 596 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 597 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 598 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 601 */       if (postEventsForChanges()) {
/* 602 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryCountSectionProperty(IInventoryCountSectionProperty argInventoryCountSectionProperty) {
/* 608 */     if (this._properties == null) {
/* 609 */       this._properties = new HistoricalList(null);
/*     */     }
/* 611 */     argInventoryCountSectionProperty.setOrganizationId(getOrganizationId());
/* 612 */     argInventoryCountSectionProperty.setRetailLocationId(getRetailLocationId());
/* 613 */     argInventoryCountSectionProperty.setInventoryBucketId(getInventoryBucketId());
/* 614 */     argInventoryCountSectionProperty.setSectionId(getSectionId());
/* 615 */     if (argInventoryCountSectionProperty instanceof IDataModelImpl) {
/* 616 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryCountSectionProperty).getDAO();
/* 617 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 618 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 619 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 624 */     if (postEventsForChanges()) {
/* 625 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountSectionProperty));
/*     */     }
/*     */     
/* 628 */     this._properties.add(argInventoryCountSectionProperty);
/* 629 */     if (postEventsForChanges()) {
/* 630 */       this._events.post(IInventoryCountSection.ADD_PROPERTIES, argInventoryCountSectionProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryCountSectionProperty(IInventoryCountSectionProperty argInventoryCountSectionProperty) {
/* 635 */     if (this._properties != null) {
/*     */       
/* 637 */       if (postEventsForChanges()) {
/* 638 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryCountSectionProperty));
/*     */       }
/* 640 */       this._properties.remove(argInventoryCountSectionProperty);
/* 641 */       if (postEventsForChanges()) {
/* 642 */         this._events.post(IInventoryCountSection.REMOVE_PROPERTIES, argInventoryCountSectionProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 649 */     if ("SectionDetails".equals(argFieldId)) {
/* 650 */       return getSectionDetails();
/*     */     }
/* 652 */     if ("Properties".equals(argFieldId)) {
/* 653 */       return getProperties();
/*     */     }
/* 655 */     if ("InventoryCountSectionExtension".equals(argFieldId)) {
/* 656 */       return this._myExtension;
/*     */     }
/*     */     
/* 659 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 665 */     if ("SectionDetails".equals(argFieldId)) {
/* 666 */       setSectionDetails(changeToList(argValue, IInventoryCountSectionDetail.class));
/*     */     }
/* 668 */     else if ("Properties".equals(argFieldId)) {
/* 669 */       setProperties(changeToList(argValue, IInventoryCountSectionProperty.class));
/*     */     }
/* 671 */     else if ("InventoryCountSectionExtension".equals(argFieldId)) {
/* 672 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 675 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 681 */     this._persistenceDefaults = argPD;
/* 682 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 683 */     this._eventManager = argEM;
/* 684 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 685 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 686 */     if (this._sectionDetails != null) {
/* 687 */       for (IInventoryCountSectionDetail relationship : this._sectionDetails) {
/* 688 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 691 */     if (this._properties != null) {
/* 692 */       for (IInventoryCountSectionProperty relationship : this._properties) {
/* 693 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryCountSectionExt() {
/* 699 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryCountSectionExt(IDataModel argExt) {
/* 703 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 708 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 712 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 715 */     super.startTransaction();
/*     */     
/* 717 */     this._sectionDetailsSavepoint = this._sectionDetails;
/* 718 */     if (this._sectionDetails != null) {
/* 719 */       this._sectionDetailsSavepoint = new HistoricalList((List)this._sectionDetails);
/* 720 */       Iterator<IDataModel> it = this._sectionDetails.iterator();
/* 721 */       while (it.hasNext()) {
/* 722 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 726 */     this._propertiesSavepoint = this._properties;
/* 727 */     if (this._properties != null) {
/* 728 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 729 */       Iterator<IDataModel> it = this._properties.iterator();
/* 730 */       while (it.hasNext()) {
/* 731 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 736 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 741 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 744 */     super.rollbackChanges();
/*     */     
/* 746 */     this._sectionDetails = this._sectionDetailsSavepoint;
/* 747 */     this._sectionDetailsSavepoint = null;
/* 748 */     if (this._sectionDetails != null) {
/* 749 */       Iterator<IDataModel> it = this._sectionDetails.iterator();
/* 750 */       while (it.hasNext()) {
/* 751 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 755 */     this._properties = this._propertiesSavepoint;
/* 756 */     this._propertiesSavepoint = null;
/* 757 */     if (this._properties != null) {
/* 758 */       Iterator<IDataModel> it = this._properties.iterator();
/* 759 */       while (it.hasNext()) {
/* 760 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 768 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 771 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 774 */     super.commitTransaction();
/*     */     
/* 776 */     this._sectionDetailsSavepoint = this._sectionDetails;
/* 777 */     if (this._sectionDetails != null) {
/* 778 */       Iterator<IDataModel> it = this._sectionDetails.iterator();
/* 779 */       while (it.hasNext()) {
/* 780 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 782 */       this._sectionDetails = new HistoricalList((List)this._sectionDetails);
/*     */     } 
/*     */     
/* 785 */     this._propertiesSavepoint = this._properties;
/* 786 */     if (this._properties != null) {
/* 787 */       Iterator<IDataModel> it = this._properties.iterator();
/* 788 */       while (it.hasNext()) {
/* 789 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 791 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 795 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSectionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */