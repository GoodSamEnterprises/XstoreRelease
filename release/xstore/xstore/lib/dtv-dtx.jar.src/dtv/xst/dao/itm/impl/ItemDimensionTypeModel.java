/*     */ package dtv.xst.dao.itm.impl;
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
/*     */ import dtv.xst.dao.itm.IItemDimensionType;
/*     */ import dtv.xst.dao.itm.IItemDimensionTypeProperty;
/*     */ import dtv.xst.dao.itm.IItemDimensionValue;
/*     */ import dtv.xst.dao.itm.ItemDimensionTypePropertyId;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemDimensionTypeModel extends ItemDimensionTypeBaseModel implements IItemDimensionType {
/*     */   private static final long serialVersionUID = -198567603L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private HistoricalList<IItemDimensionValue> _dimensionValues; private transient HistoricalList<IItemDimensionValue> _dimensionValuesSavepoint; private HistoricalList<IItemDimensionTypeProperty> _properties; private transient HistoricalList<IItemDimensionTypeProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new ItemDimensionTypeDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemDimensionTypeDAO getDAO_() {
/*  47 */     return (ItemDimensionTypeDAO)this._daoImpl;
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
/*  71 */       this._events.post(IItemDimensionType.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  84 */       if (this._dimensionValues != null) {
/*     */         
/*  86 */         Iterator<ItemDimensionValueModel> it = this._dimensionValues.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((ItemDimensionValueModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  92 */       if (this._properties != null) {
/*     */         
/*  94 */         Iterator<ItemDimensionTypePropertyModel> it = this._properties.iterator();
/*  95 */         while (it.hasNext())
/*     */         {
/*  97 */           ((ItemDimensionTypePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getDimensionSystem() {
/* 110 */     return getDAO_().getDimensionSystem();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimensionSystem(String argDimensionSystem) {
/* 118 */     if (setDimensionSystem_noev(argDimensionSystem) && 
/* 119 */       this._events != null && 
/* 120 */       postEventsForChanges()) {
/* 121 */       this._events.post(IItemDimensionType.SET_DIMENSIONSYSTEM, argDimensionSystem);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDimensionSystem_noev(String argDimensionSystem) {
/* 128 */     boolean ev_postable = false;
/*     */     
/* 130 */     if ((getDAO_().getDimensionSystem() == null && argDimensionSystem != null) || (
/* 131 */       getDAO_().getDimensionSystem() != null && !getDAO_().getDimensionSystem().equals(argDimensionSystem))) {
/* 132 */       getDAO_().setDimensionSystem(argDimensionSystem);
/* 133 */       ev_postable = true;
/* 134 */       if (this._dimensionValues != null) {
/*     */         
/* 136 */         Iterator<ItemDimensionValueModel> it = this._dimensionValues.iterator();
/* 137 */         while (it.hasNext())
/*     */         {
/* 139 */           ((ItemDimensionValueModel)it.next()).setDimensionSystem_noev(argDimensionSystem);
/*     */         }
/*     */       } 
/* 142 */       if (this._properties != null) {
/*     */         
/* 144 */         Iterator<ItemDimensionTypePropertyModel> it = this._properties.iterator();
/* 145 */         while (it.hasNext())
/*     */         {
/* 147 */           ((ItemDimensionTypePropertyModel)it.next()).setDimensionSystem_noev(argDimensionSystem);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 152 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimension() {
/* 160 */     return getDAO_().getDimension();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimension(String argDimension) {
/* 168 */     if (setDimension_noev(argDimension) && 
/* 169 */       this._events != null && 
/* 170 */       postEventsForChanges()) {
/* 171 */       this._events.post(IItemDimensionType.SET_DIMENSION, argDimension);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDimension_noev(String argDimension) {
/* 178 */     boolean ev_postable = false;
/*     */     
/* 180 */     if ((getDAO_().getDimension() == null && argDimension != null) || (
/* 181 */       getDAO_().getDimension() != null && !getDAO_().getDimension().equals(argDimension))) {
/* 182 */       getDAO_().setDimension(argDimension);
/* 183 */       ev_postable = true;
/* 184 */       if (this._dimensionValues != null) {
/*     */         
/* 186 */         Iterator<ItemDimensionValueModel> it = this._dimensionValues.iterator();
/* 187 */         while (it.hasNext())
/*     */         {
/* 189 */           ((ItemDimensionValueModel)it.next()).setDimension_noev(argDimension);
/*     */         }
/*     */       } 
/* 192 */       if (this._properties != null) {
/*     */         
/* 194 */         Iterator<ItemDimensionTypePropertyModel> it = this._properties.iterator();
/* 195 */         while (it.hasNext())
/*     */         {
/* 197 */           ((ItemDimensionTypePropertyModel)it.next()).setDimension_noev(argDimension);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 202 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 210 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 218 */     if (setOrgCode_noev(argOrgCode) && 
/* 219 */       this._events != null && 
/* 220 */       postEventsForChanges()) {
/* 221 */       this._events.post(IItemDimensionType.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 228 */     boolean ev_postable = false;
/*     */     
/* 230 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 231 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 232 */       getDAO_().setOrgCode(argOrgCode);
/* 233 */       ev_postable = true;
/*     */     } 
/*     */     
/* 236 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 244 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 252 */     if (setOrgValue_noev(argOrgValue) && 
/* 253 */       this._events != null && 
/* 254 */       postEventsForChanges()) {
/* 255 */       this._events.post(IItemDimensionType.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 262 */     boolean ev_postable = false;
/*     */     
/* 264 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 265 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 266 */       getDAO_().setOrgValue(argOrgValue);
/* 267 */       ev_postable = true;
/*     */     } 
/*     */     
/* 270 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 278 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 286 */     if (setCreateDate_noev(argCreateDate) && 
/* 287 */       this._events != null && 
/* 288 */       postEventsForChanges()) {
/* 289 */       this._events.post(IItemDimensionType.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 296 */     boolean ev_postable = false;
/*     */     
/* 298 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 299 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 300 */       getDAO_().setCreateDate(argCreateDate);
/* 301 */       ev_postable = true;
/*     */     } 
/*     */     
/* 304 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 312 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 320 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 321 */       this._events != null && 
/* 322 */       postEventsForChanges()) {
/* 323 */       this._events.post(IItemDimensionType.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 330 */     boolean ev_postable = false;
/*     */     
/* 332 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 333 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 334 */       getDAO_().setCreateUserId(argCreateUserId);
/* 335 */       ev_postable = true;
/*     */     } 
/*     */     
/* 338 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 346 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 354 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 355 */       this._events != null && 
/* 356 */       postEventsForChanges()) {
/* 357 */       this._events.post(IItemDimensionType.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 364 */     boolean ev_postable = false;
/*     */     
/* 366 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 367 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 368 */       getDAO_().setUpdateDate(argUpdateDate);
/* 369 */       ev_postable = true;
/*     */     } 
/*     */     
/* 372 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 380 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 388 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 389 */       this._events != null && 
/* 390 */       postEventsForChanges()) {
/* 391 */       this._events.post(IItemDimensionType.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 398 */     boolean ev_postable = false;
/*     */     
/* 400 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 401 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 402 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 403 */       ev_postable = true;
/*     */     } 
/*     */     
/* 406 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSequence() {
/* 414 */     if (getDAO_().getSequence() != null) {
/* 415 */       return getDAO_().getSequence().intValue();
/*     */     }
/*     */     
/* 418 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequence(int argSequence) {
/* 427 */     if (setSequence_noev(argSequence) && 
/* 428 */       this._events != null && 
/* 429 */       postEventsForChanges()) {
/* 430 */       this._events.post(IItemDimensionType.SET_SEQUENCE, Integer.valueOf(argSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequence_noev(int argSequence) {
/* 437 */     boolean ev_postable = false;
/*     */     
/* 439 */     if ((getDAO_().getSequence() == null && Integer.valueOf(argSequence) != null) || (
/* 440 */       getDAO_().getSequence() != null && !getDAO_().getSequence().equals(Integer.valueOf(argSequence)))) {
/* 441 */       getDAO_().setSequence(Integer.valueOf(argSequence));
/* 442 */       ev_postable = true;
/*     */     } 
/*     */     
/* 445 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 453 */     if (getDAO_().getSortOrder() != null) {
/* 454 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 457 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 466 */     if (setSortOrder_noev(argSortOrder) && 
/* 467 */       this._events != null && 
/* 468 */       postEventsForChanges()) {
/* 469 */       this._events.post(IItemDimensionType.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 476 */     boolean ev_postable = false;
/*     */     
/* 478 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 479 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 480 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 481 */       ev_postable = true;
/*     */     } 
/*     */     
/* 484 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 492 */     if (setDescription_noev(argDescription) && 
/* 493 */       this._events != null && 
/* 494 */       postEventsForChanges()) {
/* 495 */       this._events.post(IItemDimensionType.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 502 */     boolean ev_postable = false;
/*     */     
/* 504 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 505 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 506 */       getDAO_().setDescription(argDescription);
/* 507 */       ev_postable = true;
/*     */     } 
/*     */     
/* 510 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPromptMessage() {
/* 518 */     return getDAO_().getPromptMessage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPromptMessage(String argPromptMessage) {
/* 526 */     if (setPromptMessage_noev(argPromptMessage) && 
/* 527 */       this._events != null && 
/* 528 */       postEventsForChanges()) {
/* 529 */       this._events.post(IItemDimensionType.SET_PROMPTMESSAGE, argPromptMessage);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPromptMessage_noev(String argPromptMessage) {
/* 536 */     boolean ev_postable = false;
/*     */     
/* 538 */     if ((getDAO_().getPromptMessage() == null && argPromptMessage != null) || (
/* 539 */       getDAO_().getPromptMessage() != null && !getDAO_().getPromptMessage().equals(argPromptMessage))) {
/* 540 */       getDAO_().setPromptMessage(argPromptMessage);
/* 541 */       ev_postable = true;
/*     */     } 
/*     */     
/* 544 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemDimensionTypeProperty newProperty(String argPropertyName) {
/* 548 */     ItemDimensionTypePropertyId id = new ItemDimensionTypePropertyId();
/*     */     
/* 550 */     id.setDimensionSystem(getDimensionSystem());
/* 551 */     id.setDimension(getDimension());
/* 552 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 554 */     IItemDimensionTypeProperty prop = (IItemDimensionTypeProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemDimensionTypeProperty.class);
/* 555 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "DimensionValues")
/*     */   public List<IItemDimensionValue> getDimensionValues() {
/* 567 */     if (this._dimensionValues == null) {
/* 568 */       this._dimensionValues = new HistoricalList(null);
/*     */     }
/* 570 */     return (List<IItemDimensionValue>)this._dimensionValues;
/*     */   }
/*     */   
/*     */   public void setDimensionValues(List<IItemDimensionValue> argDimensionValues) {
/* 574 */     if (this._dimensionValues == null) {
/* 575 */       this._dimensionValues = new HistoricalList(argDimensionValues);
/*     */     } else {
/* 577 */       this._dimensionValues.setCurrentList(argDimensionValues);
/*     */     } 
/*     */     
/* 580 */     for (IItemDimensionValue child : this._dimensionValues) {
/* 581 */       child.setParentDimensionType(this);
/*     */     }
/*     */ 
/*     */     
/* 585 */     for (IItemDimensionValue child : this._dimensionValues) {
/* 586 */       ItemDimensionValueModel model = (ItemDimensionValueModel)child;
/* 587 */       model.setOrganizationId_noev(getOrganizationId());
/* 588 */       model.setDimensionSystem_noev(getDimensionSystem());
/* 589 */       model.setDimension_noev(getDimension());
/* 590 */       if (child instanceof IDataModelImpl) {
/* 591 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 592 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 593 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 594 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 597 */       if (postEventsForChanges()) {
/* 598 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addDimensionValue(IItemDimensionValue argDimensionValue) {
/* 605 */     argDimensionValue.setParentDimensionType(this);
/* 606 */     if (this._dimensionValues == null) {
/* 607 */       this._dimensionValues = new HistoricalList(null);
/*     */     }
/* 609 */     argDimensionValue.setOrganizationId(getOrganizationId());
/* 610 */     argDimensionValue.setDimensionSystem(getDimensionSystem());
/* 611 */     argDimensionValue.setDimension(getDimension());
/* 612 */     if (argDimensionValue instanceof IDataModelImpl) {
/* 613 */       IDataAccessObject childDao = ((IDataModelImpl)argDimensionValue).getDAO();
/* 614 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 615 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 616 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 621 */     if (postEventsForChanges()) {
/* 622 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDimensionValue));
/*     */     }
/*     */     
/* 625 */     this._dimensionValues.add(argDimensionValue);
/* 626 */     if (postEventsForChanges()) {
/* 627 */       this._events.post(IItemDimensionType.ADD_DIMENSIONVALUES, argDimensionValue);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDimensionValue(IItemDimensionValue argDimensionValue) {
/* 632 */     if (this._dimensionValues != null) {
/*     */       
/* 634 */       if (postEventsForChanges()) {
/* 635 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDimensionValue));
/*     */       }
/* 637 */       this._dimensionValues.remove(argDimensionValue);
/*     */       
/* 639 */       argDimensionValue.setParentDimensionType(null);
/* 640 */       if (postEventsForChanges()) {
/* 641 */         this._events.post(IItemDimensionType.REMOVE_DIMENSIONVALUES, argDimensionValue);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemDimensionTypeProperty> getProperties() {
/* 648 */     if (this._properties == null) {
/* 649 */       this._properties = new HistoricalList(null);
/*     */     }
/* 651 */     return (List<IItemDimensionTypeProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemDimensionTypeProperty> argProperties) {
/* 655 */     if (this._properties == null) {
/* 656 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 658 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 661 */     for (IItemDimensionTypeProperty child : this._properties) {
/* 662 */       ItemDimensionTypePropertyModel model = (ItemDimensionTypePropertyModel)child;
/* 663 */       model.setOrganizationId_noev(getOrganizationId());
/* 664 */       model.setDimensionSystem_noev(getDimensionSystem());
/* 665 */       model.setDimension_noev(getDimension());
/* 666 */       if (child instanceof IDataModelImpl) {
/* 667 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 668 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 669 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 670 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 673 */       if (postEventsForChanges()) {
/* 674 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemDimensionTypeProperty(IItemDimensionTypeProperty argItemDimensionTypeProperty) {
/* 680 */     if (this._properties == null) {
/* 681 */       this._properties = new HistoricalList(null);
/*     */     }
/* 683 */     argItemDimensionTypeProperty.setOrganizationId(getOrganizationId());
/* 684 */     argItemDimensionTypeProperty.setDimensionSystem(getDimensionSystem());
/* 685 */     argItemDimensionTypeProperty.setDimension(getDimension());
/* 686 */     if (argItemDimensionTypeProperty instanceof IDataModelImpl) {
/* 687 */       IDataAccessObject childDao = ((IDataModelImpl)argItemDimensionTypeProperty).getDAO();
/* 688 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 689 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 690 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 695 */     if (postEventsForChanges()) {
/* 696 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemDimensionTypeProperty));
/*     */     }
/*     */     
/* 699 */     this._properties.add(argItemDimensionTypeProperty);
/* 700 */     if (postEventsForChanges()) {
/* 701 */       this._events.post(IItemDimensionType.ADD_PROPERTIES, argItemDimensionTypeProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemDimensionTypeProperty(IItemDimensionTypeProperty argItemDimensionTypeProperty) {
/* 706 */     if (this._properties != null) {
/*     */       
/* 708 */       if (postEventsForChanges()) {
/* 709 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemDimensionTypeProperty));
/*     */       }
/* 711 */       this._properties.remove(argItemDimensionTypeProperty);
/* 712 */       if (postEventsForChanges()) {
/* 713 */         this._events.post(IItemDimensionType.REMOVE_PROPERTIES, argItemDimensionTypeProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 720 */     if ("DimensionValues".equals(argFieldId)) {
/* 721 */       return getDimensionValues();
/*     */     }
/* 723 */     if ("Properties".equals(argFieldId)) {
/* 724 */       return getProperties();
/*     */     }
/* 726 */     if ("ItemDimensionTypeExtension".equals(argFieldId)) {
/* 727 */       return this._myExtension;
/*     */     }
/*     */     
/* 730 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 736 */     if ("DimensionValues".equals(argFieldId)) {
/* 737 */       setDimensionValues(changeToList(argValue, IItemDimensionValue.class));
/*     */     }
/* 739 */     else if ("Properties".equals(argFieldId)) {
/* 740 */       setProperties(changeToList(argValue, IItemDimensionTypeProperty.class));
/*     */     }
/* 742 */     else if ("ItemDimensionTypeExtension".equals(argFieldId)) {
/* 743 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 746 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 752 */     this._persistenceDefaults = argPD;
/* 753 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 754 */     this._eventManager = argEM;
/* 755 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 756 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 757 */     if (this._dimensionValues != null) {
/* 758 */       for (IItemDimensionValue relationship : this._dimensionValues) {
/* 759 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 762 */     if (this._properties != null) {
/* 763 */       for (IItemDimensionTypeProperty relationship : this._properties) {
/* 764 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemDimensionTypeExt() {
/* 770 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemDimensionTypeExt(IDataModel argExt) {
/* 774 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 779 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 783 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 786 */     super.startTransaction();
/*     */     
/* 788 */     this._dimensionValuesSavepoint = this._dimensionValues;
/* 789 */     if (this._dimensionValues != null) {
/* 790 */       this._dimensionValuesSavepoint = new HistoricalList((List)this._dimensionValues);
/* 791 */       Iterator<IDataModel> it = this._dimensionValues.iterator();
/* 792 */       while (it.hasNext()) {
/* 793 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 797 */     this._propertiesSavepoint = this._properties;
/* 798 */     if (this._properties != null) {
/* 799 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 800 */       Iterator<IDataModel> it = this._properties.iterator();
/* 801 */       while (it.hasNext()) {
/* 802 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 807 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 812 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 815 */     super.rollbackChanges();
/*     */     
/* 817 */     this._dimensionValues = this._dimensionValuesSavepoint;
/* 818 */     this._dimensionValuesSavepoint = null;
/* 819 */     if (this._dimensionValues != null) {
/* 820 */       Iterator<IDataModel> it = this._dimensionValues.iterator();
/* 821 */       while (it.hasNext()) {
/* 822 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 826 */     this._properties = this._propertiesSavepoint;
/* 827 */     this._propertiesSavepoint = null;
/* 828 */     if (this._properties != null) {
/* 829 */       Iterator<IDataModel> it = this._properties.iterator();
/* 830 */       while (it.hasNext()) {
/* 831 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 839 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 842 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 845 */     super.commitTransaction();
/*     */     
/* 847 */     this._dimensionValuesSavepoint = this._dimensionValues;
/* 848 */     if (this._dimensionValues != null) {
/* 849 */       Iterator<IDataModel> it = this._dimensionValues.iterator();
/* 850 */       while (it.hasNext()) {
/* 851 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 853 */       this._dimensionValues = new HistoricalList((List)this._dimensionValues);
/*     */     } 
/*     */     
/* 856 */     this._propertiesSavepoint = this._properties;
/* 857 */     if (this._properties != null) {
/* 858 */       Iterator<IDataModel> it = this._properties.iterator();
/* 859 */       while (it.hasNext()) {
/* 860 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 862 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 866 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemDimensionTypeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */