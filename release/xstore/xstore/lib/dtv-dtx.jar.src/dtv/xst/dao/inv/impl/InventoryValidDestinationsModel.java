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
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.inv.IInventoryValidDestinations;
/*     */ import dtv.xst.dao.inv.IInventoryValidDestinationsProperty;
/*     */ import dtv.xst.dao.inv.InventoryValidDestinationsPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryValidDestinationsModel extends AbstractDataModelWithPropertyImpl<IInventoryValidDestinationsProperty> implements IInventoryValidDestinations {
/*     */   private static final long serialVersionUID = 866266725L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IInventoryValidDestinationsProperty> _properties; private transient HistoricalList<IInventoryValidDestinationsProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new InventoryValidDestinationsDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryValidDestinationsDAO getDAO_() {
/*  46 */     return (InventoryValidDestinationsDAO)this._daoImpl;
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
/*  70 */       this._events.post(IInventoryValidDestinations.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<InventoryValidDestinationsPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((InventoryValidDestinationsPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 101 */     if (getDAO_().getRetailLocationId() != null) {
/* 102 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 105 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 114 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 115 */       this._events != null && 
/* 116 */       postEventsForChanges()) {
/* 117 */       this._events.post(IInventoryValidDestinations.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 124 */     boolean ev_postable = false;
/*     */     
/* 126 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 127 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 128 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 129 */       ev_postable = true;
/* 130 */       if (this._properties != null) {
/*     */         
/* 132 */         Iterator<InventoryValidDestinationsPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((InventoryValidDestinationsPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 140 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentTypeCode() {
/* 148 */     return getDAO_().getDocumentTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/* 156 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IInventoryValidDestinations.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/* 169 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/* 170 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<InventoryValidDestinationsPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((InventoryValidDestinationsPropertyModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentSubtypeCode() {
/* 190 */     return getDAO_().getDocumentSubtypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentSubtypeCode(String argDocumentSubtypeCode) {
/* 198 */     if (setDocumentSubtypeCode_noev(argDocumentSubtypeCode) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(IInventoryValidDestinations.SET_DOCUMENTSUBTYPECODE, argDocumentSubtypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentSubtypeCode_noev(String argDocumentSubtypeCode) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getDocumentSubtypeCode() == null && argDocumentSubtypeCode != null) || (
/* 211 */       getDAO_().getDocumentSubtypeCode() != null && !getDAO_().getDocumentSubtypeCode().equals(argDocumentSubtypeCode))) {
/* 212 */       getDAO_().setDocumentSubtypeCode(argDocumentSubtypeCode);
/* 213 */       ev_postable = true;
/* 214 */       if (this._properties != null) {
/*     */         
/* 216 */         Iterator<InventoryValidDestinationsPropertyModel> it = this._properties.iterator();
/* 217 */         while (it.hasNext())
/*     */         {
/* 219 */           ((InventoryValidDestinationsPropertyModel)it.next()).setDocumentSubtypeCode_noev(argDocumentSubtypeCode);
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
/*     */   public String getDestinationTypeEnum() {
/* 232 */     return getDAO_().getDestinationTypeEnum();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDestinationTypeEnum(String argDestinationTypeEnum) {
/* 240 */     if (setDestinationTypeEnum_noev(argDestinationTypeEnum) && 
/* 241 */       this._events != null && 
/* 242 */       postEventsForChanges()) {
/* 243 */       this._events.post(IInventoryValidDestinations.SET_DESTINATIONTYPEENUM, argDestinationTypeEnum);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDestinationTypeEnum_noev(String argDestinationTypeEnum) {
/* 250 */     boolean ev_postable = false;
/*     */     
/* 252 */     if ((getDAO_().getDestinationTypeEnum() == null && argDestinationTypeEnum != null) || (
/* 253 */       getDAO_().getDestinationTypeEnum() != null && !getDAO_().getDestinationTypeEnum().equals(argDestinationTypeEnum))) {
/* 254 */       getDAO_().setDestinationTypeEnum(argDestinationTypeEnum);
/* 255 */       ev_postable = true;
/* 256 */       if (this._properties != null) {
/*     */         
/* 258 */         Iterator<InventoryValidDestinationsPropertyModel> it = this._properties.iterator();
/* 259 */         while (it.hasNext())
/*     */         {
/* 261 */           ((InventoryValidDestinationsPropertyModel)it.next()).setDestinationTypeEnum_noev(argDestinationTypeEnum);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 266 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDestinationId() {
/* 274 */     return getDAO_().getDestinationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDestinationId(String argDestinationId) {
/* 282 */     if (setDestinationId_noev(argDestinationId) && 
/* 283 */       this._events != null && 
/* 284 */       postEventsForChanges()) {
/* 285 */       this._events.post(IInventoryValidDestinations.SET_DESTINATIONID, argDestinationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDestinationId_noev(String argDestinationId) {
/* 292 */     boolean ev_postable = false;
/*     */     
/* 294 */     if ((getDAO_().getDestinationId() == null && argDestinationId != null) || (
/* 295 */       getDAO_().getDestinationId() != null && !getDAO_().getDestinationId().equals(argDestinationId))) {
/* 296 */       getDAO_().setDestinationId(argDestinationId);
/* 297 */       ev_postable = true;
/* 298 */       if (this._properties != null) {
/*     */         
/* 300 */         Iterator<InventoryValidDestinationsPropertyModel> it = this._properties.iterator();
/* 301 */         while (it.hasNext())
/*     */         {
/* 303 */           ((InventoryValidDestinationsPropertyModel)it.next()).setDestinationId_noev(argDestinationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 308 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 316 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 324 */     if (setCreateDate_noev(argCreateDate) && 
/* 325 */       this._events != null && 
/* 326 */       postEventsForChanges()) {
/* 327 */       this._events.post(IInventoryValidDestinations.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 334 */     boolean ev_postable = false;
/*     */     
/* 336 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 337 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 338 */       getDAO_().setCreateDate(argCreateDate);
/* 339 */       ev_postable = true;
/*     */     } 
/*     */     
/* 342 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 350 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 358 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 359 */       this._events != null && 
/* 360 */       postEventsForChanges()) {
/* 361 */       this._events.post(IInventoryValidDestinations.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 368 */     boolean ev_postable = false;
/*     */     
/* 370 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 371 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 372 */       getDAO_().setCreateUserId(argCreateUserId);
/* 373 */       ev_postable = true;
/*     */     } 
/*     */     
/* 376 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 384 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 392 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 393 */       this._events != null && 
/* 394 */       postEventsForChanges()) {
/* 395 */       this._events.post(IInventoryValidDestinations.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 402 */     boolean ev_postable = false;
/*     */     
/* 404 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 405 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 406 */       getDAO_().setUpdateDate(argUpdateDate);
/* 407 */       ev_postable = true;
/*     */     } 
/*     */     
/* 410 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 418 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 426 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 427 */       this._events != null && 
/* 428 */       postEventsForChanges()) {
/* 429 */       this._events.post(IInventoryValidDestinations.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 436 */     boolean ev_postable = false;
/*     */     
/* 438 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 439 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 440 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 441 */       ev_postable = true;
/*     */     } 
/*     */     
/* 444 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 452 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 460 */     if (setDescription_noev(argDescription) && 
/* 461 */       this._events != null && 
/* 462 */       postEventsForChanges()) {
/* 463 */       this._events.post(IInventoryValidDestinations.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 470 */     boolean ev_postable = false;
/*     */     
/* 472 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 473 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 474 */       getDAO_().setDescription(argDescription);
/* 475 */       ev_postable = true;
/*     */     } 
/*     */     
/* 478 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 486 */     if (getDAO_().getSortOrder() != null) {
/* 487 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 490 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 499 */     if (setSortOrder_noev(argSortOrder) && 
/* 500 */       this._events != null && 
/* 501 */       postEventsForChanges()) {
/* 502 */       this._events.post(IInventoryValidDestinations.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 509 */     boolean ev_postable = false;
/*     */     
/* 511 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 512 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 513 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 514 */       ev_postable = true;
/*     */     } 
/*     */     
/* 517 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryValidDestinationsProperty newProperty(String argPropertyName) {
/* 521 */     InventoryValidDestinationsPropertyId id = new InventoryValidDestinationsPropertyId();
/*     */     
/* 523 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 524 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 525 */     id.setDocumentSubtypeCode(getDocumentSubtypeCode());
/* 526 */     id.setDestinationTypeEnum(getDestinationTypeEnum());
/* 527 */     id.setDestinationId(getDestinationId());
/* 528 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 530 */     IInventoryValidDestinationsProperty prop = (IInventoryValidDestinationsProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryValidDestinationsProperty.class);
/* 531 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryValidDestinationsProperty> getProperties() {
/* 540 */     if (this._properties == null) {
/* 541 */       this._properties = new HistoricalList(null);
/*     */     }
/* 543 */     return (List<IInventoryValidDestinationsProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryValidDestinationsProperty> argProperties) {
/* 547 */     if (this._properties == null) {
/* 548 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 550 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 553 */     for (IInventoryValidDestinationsProperty child : this._properties) {
/* 554 */       InventoryValidDestinationsPropertyModel model = (InventoryValidDestinationsPropertyModel)child;
/* 555 */       model.setOrganizationId_noev(getOrganizationId());
/* 556 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 557 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 558 */       model.setDocumentSubtypeCode_noev(getDocumentSubtypeCode());
/* 559 */       model.setDestinationTypeEnum_noev(getDestinationTypeEnum());
/* 560 */       model.setDestinationId_noev(getDestinationId());
/* 561 */       if (child instanceof IDataModelImpl) {
/* 562 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 563 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 564 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 565 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 568 */       if (postEventsForChanges()) {
/* 569 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryValidDestinationsProperty(IInventoryValidDestinationsProperty argInventoryValidDestinationsProperty) {
/* 575 */     if (this._properties == null) {
/* 576 */       this._properties = new HistoricalList(null);
/*     */     }
/* 578 */     argInventoryValidDestinationsProperty.setOrganizationId(getOrganizationId());
/* 579 */     argInventoryValidDestinationsProperty.setRetailLocationId(getRetailLocationId());
/* 580 */     argInventoryValidDestinationsProperty.setDocumentTypeCode(getDocumentTypeCode());
/* 581 */     argInventoryValidDestinationsProperty.setDocumentSubtypeCode(getDocumentSubtypeCode());
/* 582 */     argInventoryValidDestinationsProperty.setDestinationTypeEnum(getDestinationTypeEnum());
/* 583 */     argInventoryValidDestinationsProperty.setDestinationId(getDestinationId());
/* 584 */     if (argInventoryValidDestinationsProperty instanceof IDataModelImpl) {
/* 585 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryValidDestinationsProperty).getDAO();
/* 586 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 587 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 588 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 593 */     if (postEventsForChanges()) {
/* 594 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryValidDestinationsProperty));
/*     */     }
/*     */     
/* 597 */     this._properties.add(argInventoryValidDestinationsProperty);
/* 598 */     if (postEventsForChanges()) {
/* 599 */       this._events.post(IInventoryValidDestinations.ADD_PROPERTIES, argInventoryValidDestinationsProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryValidDestinationsProperty(IInventoryValidDestinationsProperty argInventoryValidDestinationsProperty) {
/* 604 */     if (this._properties != null) {
/*     */       
/* 606 */       if (postEventsForChanges()) {
/* 607 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryValidDestinationsProperty));
/*     */       }
/* 609 */       this._properties.remove(argInventoryValidDestinationsProperty);
/* 610 */       if (postEventsForChanges()) {
/* 611 */         this._events.post(IInventoryValidDestinations.REMOVE_PROPERTIES, argInventoryValidDestinationsProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 618 */     if ("Properties".equals(argFieldId)) {
/* 619 */       return getProperties();
/*     */     }
/* 621 */     if ("InventoryValidDestinationsExtension".equals(argFieldId)) {
/* 622 */       return this._myExtension;
/*     */     }
/*     */     
/* 625 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 631 */     if ("Properties".equals(argFieldId)) {
/* 632 */       setProperties(changeToList(argValue, IInventoryValidDestinationsProperty.class));
/*     */     }
/* 634 */     else if ("InventoryValidDestinationsExtension".equals(argFieldId)) {
/* 635 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 638 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 644 */     this._persistenceDefaults = argPD;
/* 645 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 646 */     this._eventManager = argEM;
/* 647 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 648 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 649 */     if (this._properties != null) {
/* 650 */       for (IInventoryValidDestinationsProperty relationship : this._properties) {
/* 651 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryValidDestinationsExt() {
/* 657 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryValidDestinationsExt(IDataModel argExt) {
/* 661 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 666 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 670 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 673 */     super.startTransaction();
/*     */     
/* 675 */     this._propertiesSavepoint = this._properties;
/* 676 */     if (this._properties != null) {
/* 677 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 678 */       Iterator<IDataModel> it = this._properties.iterator();
/* 679 */       while (it.hasNext()) {
/* 680 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 685 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 690 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 693 */     super.rollbackChanges();
/*     */     
/* 695 */     this._properties = this._propertiesSavepoint;
/* 696 */     this._propertiesSavepoint = null;
/* 697 */     if (this._properties != null) {
/* 698 */       Iterator<IDataModel> it = this._properties.iterator();
/* 699 */       while (it.hasNext()) {
/* 700 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 708 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 711 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 714 */     super.commitTransaction();
/*     */     
/* 716 */     this._propertiesSavepoint = this._properties;
/* 717 */     if (this._properties != null) {
/* 718 */       Iterator<IDataModel> it = this._properties.iterator();
/* 719 */       while (it.hasNext()) {
/* 720 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 722 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 726 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 731 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryValidDestinationsModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */