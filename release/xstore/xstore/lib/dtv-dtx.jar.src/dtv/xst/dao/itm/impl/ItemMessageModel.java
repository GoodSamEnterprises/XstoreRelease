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
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.itm.IItemMessage;
/*     */ import dtv.xst.dao.itm.IItemMessageCrossReference;
/*     */ import dtv.xst.dao.itm.IItemMessageProperty;
/*     */ import dtv.xst.dao.itm.IItemMessageTypes;
/*     */ import dtv.xst.dao.itm.ItemMessagePropertyId;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemMessageModel extends ItemMessageBaseModel implements IItemMessage {
/*     */   private static final long serialVersionUID = 2088876372L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private HistoricalList<IItemMessageTypes> _lineItemTypes;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient HistoricalList<IItemMessageTypes> _lineItemTypesSavepoint; private HistoricalList<IItemMessageCrossReference> _itemIds; private transient HistoricalList<IItemMessageCrossReference> _itemIdsSavepoint; private HistoricalList<IItemMessageProperty> _properties; private transient HistoricalList<IItemMessageProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new ItemMessageDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemMessageDAO getDAO_() {
/*  47 */     return (ItemMessageDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessageId() {
/*  55 */     return getDAO_().getMessageId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMessageId(String argMessageId) {
/*  63 */     if (setMessageId_noev(argMessageId) && 
/*  64 */       this._events != null && 
/*  65 */       postEventsForChanges()) {
/*  66 */       this._events.post(IItemMessage.SET_MESSAGEID, argMessageId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMessageId_noev(String argMessageId) {
/*  73 */     boolean ev_postable = false;
/*     */     
/*  75 */     if ((getDAO_().getMessageId() == null && argMessageId != null) || (
/*  76 */       getDAO_().getMessageId() != null && !getDAO_().getMessageId().equals(argMessageId))) {
/*  77 */       getDAO_().setMessageId(argMessageId);
/*  78 */       ev_postable = true;
/*  79 */       if (this._lineItemTypes != null) {
/*     */         
/*  81 */         Iterator<ItemMessageTypesModel> it = this._lineItemTypes.iterator();
/*  82 */         while (it.hasNext())
/*     */         {
/*  84 */           ((ItemMessageTypesModel)it.next()).setMessageId_noev(argMessageId);
/*     */         }
/*     */       } 
/*  87 */       if (this._itemIds != null) {
/*     */         
/*  89 */         Iterator<ItemMessageCrossReferenceModel> it = this._itemIds.iterator();
/*  90 */         while (it.hasNext())
/*     */         {
/*  92 */           ((ItemMessageCrossReferenceModel)it.next()).setMessageId_noev(argMessageId);
/*     */         }
/*     */       } 
/*  95 */       if (this._properties != null) {
/*     */         
/*  97 */         Iterator<ItemMessagePropertyModel> it = this._properties.iterator();
/*  98 */         while (it.hasNext())
/*     */         {
/* 100 */           ((ItemMessagePropertyModel)it.next()).setMessageId_noev(argMessageId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 105 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 113 */     if (getDAO_().getOrganizationId() != null) {
/* 114 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 117 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 126 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 127 */       this._events != null && 
/* 128 */       postEventsForChanges()) {
/* 129 */       this._events.post(IItemMessage.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 136 */     boolean ev_postable = false;
/*     */     
/* 138 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 139 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 140 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 141 */       ev_postable = true;
/* 142 */       if (this._lineItemTypes != null) {
/*     */         
/* 144 */         Iterator<ItemMessageTypesModel> it = this._lineItemTypes.iterator();
/* 145 */         while (it.hasNext())
/*     */         {
/* 147 */           ((ItemMessageTypesModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/* 150 */       if (this._itemIds != null) {
/*     */         
/* 152 */         Iterator<ItemMessageCrossReferenceModel> it = this._itemIds.iterator();
/* 153 */         while (it.hasNext())
/*     */         {
/* 155 */           ((ItemMessageCrossReferenceModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/* 158 */       if (this._properties != null) {
/*     */         
/* 160 */         Iterator<ItemMessagePropertyModel> it = this._properties.iterator();
/* 161 */         while (it.hasNext())
/*     */         {
/* 163 */           ((ItemMessagePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 168 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 176 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 184 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 185 */       this._events != null && 
/* 186 */       postEventsForChanges()) {
/* 187 */       this._events.post(IItemMessage.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 194 */     boolean ev_postable = false;
/*     */     
/* 196 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 197 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 198 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 199 */       ev_postable = true;
/* 200 */       if (this._properties != null) {
/*     */         
/* 202 */         Iterator<ItemMessagePropertyModel> it = this._properties.iterator();
/* 203 */         while (it.hasNext())
/*     */         {
/* 205 */           ((ItemMessagePropertyModel)it.next()).setEffectiveDate_noev(argEffectiveDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 210 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 218 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 226 */     if (setOrgCode_noev(argOrgCode) && 
/* 227 */       this._events != null && 
/* 228 */       postEventsForChanges()) {
/* 229 */       this._events.post(IItemMessage.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 236 */     boolean ev_postable = false;
/*     */     
/* 238 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 239 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 240 */       getDAO_().setOrgCode(argOrgCode);
/* 241 */       ev_postable = true;
/*     */     } 
/*     */     
/* 244 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 252 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 260 */     if (setOrgValue_noev(argOrgValue) && 
/* 261 */       this._events != null && 
/* 262 */       postEventsForChanges()) {
/* 263 */       this._events.post(IItemMessage.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 270 */     boolean ev_postable = false;
/*     */     
/* 272 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 273 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 274 */       getDAO_().setOrgValue(argOrgValue);
/* 275 */       ev_postable = true;
/*     */     } 
/*     */     
/* 278 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 286 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 294 */     if (setCreateDate_noev(argCreateDate) && 
/* 295 */       this._events != null && 
/* 296 */       postEventsForChanges()) {
/* 297 */       this._events.post(IItemMessage.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 304 */     boolean ev_postable = false;
/*     */     
/* 306 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 307 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 308 */       getDAO_().setCreateDate(argCreateDate);
/* 309 */       ev_postable = true;
/*     */     } 
/*     */     
/* 312 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 320 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 328 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 329 */       this._events != null && 
/* 330 */       postEventsForChanges()) {
/* 331 */       this._events.post(IItemMessage.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 338 */     boolean ev_postable = false;
/*     */     
/* 340 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 341 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 342 */       getDAO_().setCreateUserId(argCreateUserId);
/* 343 */       ev_postable = true;
/*     */     } 
/*     */     
/* 346 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 354 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 362 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 363 */       this._events != null && 
/* 364 */       postEventsForChanges()) {
/* 365 */       this._events.post(IItemMessage.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 372 */     boolean ev_postable = false;
/*     */     
/* 374 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 375 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 376 */       getDAO_().setUpdateDate(argUpdateDate);
/* 377 */       ev_postable = true;
/*     */     } 
/*     */     
/* 380 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 388 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 396 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 397 */       this._events != null && 
/* 398 */       postEventsForChanges()) {
/* 399 */       this._events.post(IItemMessage.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 406 */     boolean ev_postable = false;
/*     */     
/* 408 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 409 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 410 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 411 */       ev_postable = true;
/*     */     } 
/*     */     
/* 414 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContentType() {
/* 422 */     return getDAO_().getContentType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContentType(String argContentType) {
/* 430 */     if (setContentType_noev(argContentType) && 
/* 431 */       this._events != null && 
/* 432 */       postEventsForChanges()) {
/* 433 */       this._events.post(IItemMessage.SET_CONTENTTYPE, argContentType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setContentType_noev(String argContentType) {
/* 440 */     boolean ev_postable = false;
/*     */     
/* 442 */     if ((getDAO_().getContentType() == null && argContentType != null) || (
/* 443 */       getDAO_().getContentType() != null && !getDAO_().getContentType().equals(argContentType))) {
/* 444 */       getDAO_().setContentType(argContentType);
/* 445 */       ev_postable = true;
/*     */     } 
/*     */     
/* 448 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 456 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 464 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 465 */       this._events != null && 
/* 466 */       postEventsForChanges()) {
/* 467 */       this._events.post(IItemMessage.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 474 */     boolean ev_postable = false;
/*     */     
/* 476 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 477 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 478 */       getDAO_().setExpirationDate(argExpirationDate);
/* 479 */       ev_postable = true;
/*     */     } 
/*     */     
/* 482 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessageKey() {
/* 490 */     return getDAO_().getMessageKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMessageKey(String argMessageKey) {
/* 498 */     if (setMessageKey_noev(argMessageKey) && 
/* 499 */       this._events != null && 
/* 500 */       postEventsForChanges()) {
/* 501 */       this._events.post(IItemMessage.SET_MESSAGEKEY, argMessageKey);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMessageKey_noev(String argMessageKey) {
/* 508 */     boolean ev_postable = false;
/*     */     
/* 510 */     if ((getDAO_().getMessageKey() == null && argMessageKey != null) || (
/* 511 */       getDAO_().getMessageKey() != null && !getDAO_().getMessageKey().equals(argMessageKey))) {
/* 512 */       getDAO_().setMessageKey(argMessageKey);
/* 513 */       ev_postable = true;
/*     */     } 
/*     */     
/* 516 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTitleKey() {
/* 524 */     return getDAO_().getTitleKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTitleKey(String argTitleKey) {
/* 532 */     if (setTitleKey_noev(argTitleKey) && 
/* 533 */       this._events != null && 
/* 534 */       postEventsForChanges()) {
/* 535 */       this._events.post(IItemMessage.SET_TITLEKEY, argTitleKey);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTitleKey_noev(String argTitleKey) {
/* 542 */     boolean ev_postable = false;
/*     */     
/* 544 */     if ((getDAO_().getTitleKey() == null && argTitleKey != null) || (
/* 545 */       getDAO_().getTitleKey() != null && !getDAO_().getTitleKey().equals(argTitleKey))) {
/* 546 */       getDAO_().setTitleKey(argTitleKey);
/* 547 */       ev_postable = true;
/*     */     } 
/*     */     
/* 550 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemMessageProperty newProperty(String argPropertyName) {
/* 554 */     ItemMessagePropertyId id = new ItemMessagePropertyId();
/*     */     
/* 556 */     id.setMessageId(getMessageId());
/* 557 */     id.setEffectiveDate(getEffectiveDate());
/* 558 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 560 */     IItemMessageProperty prop = (IItemMessageProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemMessageProperty.class);
/* 561 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "LineItemTypes")
/*     */   public List<IItemMessageTypes> getLineItemTypes() {
/* 576 */     if (this._lineItemTypes == null) {
/* 577 */       this._lineItemTypes = new HistoricalList(null);
/*     */     }
/* 579 */     return (List<IItemMessageTypes>)this._lineItemTypes;
/*     */   }
/*     */   
/*     */   public void setLineItemTypes(List<IItemMessageTypes> argLineItemTypes) {
/* 583 */     if (this._lineItemTypes == null) {
/* 584 */       this._lineItemTypes = new HistoricalList(argLineItemTypes);
/*     */     } else {
/* 586 */       this._lineItemTypes.setCurrentList(argLineItemTypes);
/*     */     } 
/*     */     
/* 589 */     for (IItemMessageTypes child : this._lineItemTypes) {
/* 590 */       ItemMessageTypesModel model = (ItemMessageTypesModel)child;
/* 591 */       model.setMessageId_noev(getMessageId());
/* 592 */       model.setOrganizationId_noev(getOrganizationId());
/* 593 */       if (child instanceof IDataModelImpl) {
/* 594 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 595 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 596 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 597 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 600 */       if (postEventsForChanges()) {
/* 601 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemMessageTypes(IItemMessageTypes argItemMessageTypes) {
/* 607 */     if (this._lineItemTypes == null) {
/* 608 */       this._lineItemTypes = new HistoricalList(null);
/*     */     }
/* 610 */     argItemMessageTypes.setMessageId(getMessageId());
/* 611 */     argItemMessageTypes.setOrganizationId(getOrganizationId());
/* 612 */     if (argItemMessageTypes instanceof IDataModelImpl) {
/* 613 */       IDataAccessObject childDao = ((IDataModelImpl)argItemMessageTypes).getDAO();
/* 614 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 615 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 616 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 621 */     if (postEventsForChanges()) {
/* 622 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemMessageTypes));
/*     */     }
/*     */     
/* 625 */     this._lineItemTypes.add(argItemMessageTypes);
/* 626 */     if (postEventsForChanges()) {
/* 627 */       this._events.post(IItemMessage.ADD_LINEITEMTYPES, argItemMessageTypes);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemMessageTypes(IItemMessageTypes argItemMessageTypes) {
/* 632 */     if (this._lineItemTypes != null) {
/*     */       
/* 634 */       if (postEventsForChanges()) {
/* 635 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemMessageTypes));
/*     */       }
/* 637 */       this._lineItemTypes.remove(argItemMessageTypes);
/* 638 */       if (postEventsForChanges()) {
/* 639 */         this._events.post(IItemMessage.REMOVE_LINEITEMTYPES, argItemMessageTypes);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "ItemIds")
/*     */   public List<IItemMessageCrossReference> getItemIds() {
/* 646 */     if (this._itemIds == null) {
/* 647 */       this._itemIds = new HistoricalList(null);
/*     */     }
/* 649 */     return (List<IItemMessageCrossReference>)this._itemIds;
/*     */   }
/*     */   
/*     */   public void setItemIds(List<IItemMessageCrossReference> argItemIds) {
/* 653 */     if (this._itemIds == null) {
/* 654 */       this._itemIds = new HistoricalList(argItemIds);
/*     */     } else {
/* 656 */       this._itemIds.setCurrentList(argItemIds);
/*     */     } 
/*     */     
/* 659 */     for (IItemMessageCrossReference child : this._itemIds) {
/* 660 */       ItemMessageCrossReferenceModel model = (ItemMessageCrossReferenceModel)child;
/* 661 */       model.setMessageId_noev(getMessageId());
/* 662 */       model.setOrganizationId_noev(getOrganizationId());
/* 663 */       if (child instanceof IDataModelImpl) {
/* 664 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 665 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 666 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 667 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 670 */       if (postEventsForChanges()) {
/* 671 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemMessageCrossReference(IItemMessageCrossReference argItemMessageCrossReference) {
/* 677 */     if (this._itemIds == null) {
/* 678 */       this._itemIds = new HistoricalList(null);
/*     */     }
/* 680 */     argItemMessageCrossReference.setMessageId(getMessageId());
/* 681 */     argItemMessageCrossReference.setOrganizationId(getOrganizationId());
/* 682 */     if (argItemMessageCrossReference instanceof IDataModelImpl) {
/* 683 */       IDataAccessObject childDao = ((IDataModelImpl)argItemMessageCrossReference).getDAO();
/* 684 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 685 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 686 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 691 */     if (postEventsForChanges()) {
/* 692 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemMessageCrossReference));
/*     */     }
/*     */     
/* 695 */     this._itemIds.add(argItemMessageCrossReference);
/* 696 */     if (postEventsForChanges()) {
/* 697 */       this._events.post(IItemMessage.ADD_ITEMIDS, argItemMessageCrossReference);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemMessageCrossReference(IItemMessageCrossReference argItemMessageCrossReference) {
/* 702 */     if (this._itemIds != null) {
/*     */       
/* 704 */       if (postEventsForChanges()) {
/* 705 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemMessageCrossReference));
/*     */       }
/* 707 */       this._itemIds.remove(argItemMessageCrossReference);
/* 708 */       if (postEventsForChanges()) {
/* 709 */         this._events.post(IItemMessage.REMOVE_ITEMIDS, argItemMessageCrossReference);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemMessageProperty> getProperties() {
/* 716 */     if (this._properties == null) {
/* 717 */       this._properties = new HistoricalList(null);
/*     */     }
/* 719 */     return (List<IItemMessageProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemMessageProperty> argProperties) {
/* 723 */     if (this._properties == null) {
/* 724 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 726 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 729 */     for (IItemMessageProperty child : this._properties) {
/* 730 */       ItemMessagePropertyModel model = (ItemMessagePropertyModel)child;
/* 731 */       model.setMessageId_noev(getMessageId());
/* 732 */       model.setOrganizationId_noev(getOrganizationId());
/* 733 */       model.setEffectiveDate_noev(getEffectiveDate());
/* 734 */       if (child instanceof IDataModelImpl) {
/* 735 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 736 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 737 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 738 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 741 */       if (postEventsForChanges()) {
/* 742 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemMessageProperty(IItemMessageProperty argItemMessageProperty) {
/* 748 */     if (this._properties == null) {
/* 749 */       this._properties = new HistoricalList(null);
/*     */     }
/* 751 */     argItemMessageProperty.setMessageId(getMessageId());
/* 752 */     argItemMessageProperty.setOrganizationId(getOrganizationId());
/* 753 */     argItemMessageProperty.setEffectiveDate(getEffectiveDate());
/* 754 */     if (argItemMessageProperty instanceof IDataModelImpl) {
/* 755 */       IDataAccessObject childDao = ((IDataModelImpl)argItemMessageProperty).getDAO();
/* 756 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 757 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 758 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 763 */     if (postEventsForChanges()) {
/* 764 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemMessageProperty));
/*     */     }
/*     */     
/* 767 */     this._properties.add(argItemMessageProperty);
/* 768 */     if (postEventsForChanges()) {
/* 769 */       this._events.post(IItemMessage.ADD_PROPERTIES, argItemMessageProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemMessageProperty(IItemMessageProperty argItemMessageProperty) {
/* 774 */     if (this._properties != null) {
/*     */       
/* 776 */       if (postEventsForChanges()) {
/* 777 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemMessageProperty));
/*     */       }
/* 779 */       this._properties.remove(argItemMessageProperty);
/* 780 */       if (postEventsForChanges()) {
/* 781 */         this._events.post(IItemMessage.REMOVE_PROPERTIES, argItemMessageProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 788 */     if ("LineItemTypes".equals(argFieldId)) {
/* 789 */       return getLineItemTypes();
/*     */     }
/* 791 */     if ("ItemIds".equals(argFieldId)) {
/* 792 */       return getItemIds();
/*     */     }
/* 794 */     if ("Properties".equals(argFieldId)) {
/* 795 */       return getProperties();
/*     */     }
/* 797 */     if ("ItemMessageExtension".equals(argFieldId)) {
/* 798 */       return this._myExtension;
/*     */     }
/*     */     
/* 801 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 807 */     if ("LineItemTypes".equals(argFieldId)) {
/* 808 */       setLineItemTypes(changeToList(argValue, IItemMessageTypes.class));
/*     */     }
/* 810 */     else if ("ItemIds".equals(argFieldId)) {
/* 811 */       setItemIds(changeToList(argValue, IItemMessageCrossReference.class));
/*     */     }
/* 813 */     else if ("Properties".equals(argFieldId)) {
/* 814 */       setProperties(changeToList(argValue, IItemMessageProperty.class));
/*     */     }
/* 816 */     else if ("ItemMessageExtension".equals(argFieldId)) {
/* 817 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 820 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 826 */     this._persistenceDefaults = argPD;
/* 827 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 828 */     this._eventManager = argEM;
/* 829 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 830 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 831 */     if (this._lineItemTypes != null) {
/* 832 */       for (IItemMessageTypes relationship : this._lineItemTypes) {
/* 833 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 836 */     if (this._itemIds != null) {
/* 837 */       for (IItemMessageCrossReference relationship : this._itemIds) {
/* 838 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 841 */     if (this._properties != null) {
/* 842 */       for (IItemMessageProperty relationship : this._properties) {
/* 843 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemMessageExt() {
/* 849 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemMessageExt(IDataModel argExt) {
/* 853 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 858 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 862 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 865 */     super.startTransaction();
/*     */     
/* 867 */     this._lineItemTypesSavepoint = this._lineItemTypes;
/* 868 */     if (this._lineItemTypes != null) {
/* 869 */       this._lineItemTypesSavepoint = new HistoricalList((List)this._lineItemTypes);
/* 870 */       Iterator<IDataModel> it = this._lineItemTypes.iterator();
/* 871 */       while (it.hasNext()) {
/* 872 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 876 */     this._itemIdsSavepoint = this._itemIds;
/* 877 */     if (this._itemIds != null) {
/* 878 */       this._itemIdsSavepoint = new HistoricalList((List)this._itemIds);
/* 879 */       Iterator<IDataModel> it = this._itemIds.iterator();
/* 880 */       while (it.hasNext()) {
/* 881 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 885 */     this._propertiesSavepoint = this._properties;
/* 886 */     if (this._properties != null) {
/* 887 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 888 */       Iterator<IDataModel> it = this._properties.iterator();
/* 889 */       while (it.hasNext()) {
/* 890 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 895 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 900 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 903 */     super.rollbackChanges();
/*     */     
/* 905 */     this._lineItemTypes = this._lineItemTypesSavepoint;
/* 906 */     this._lineItemTypesSavepoint = null;
/* 907 */     if (this._lineItemTypes != null) {
/* 908 */       Iterator<IDataModel> it = this._lineItemTypes.iterator();
/* 909 */       while (it.hasNext()) {
/* 910 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 914 */     this._itemIds = this._itemIdsSavepoint;
/* 915 */     this._itemIdsSavepoint = null;
/* 916 */     if (this._itemIds != null) {
/* 917 */       Iterator<IDataModel> it = this._itemIds.iterator();
/* 918 */       while (it.hasNext()) {
/* 919 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 923 */     this._properties = this._propertiesSavepoint;
/* 924 */     this._propertiesSavepoint = null;
/* 925 */     if (this._properties != null) {
/* 926 */       Iterator<IDataModel> it = this._properties.iterator();
/* 927 */       while (it.hasNext()) {
/* 928 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 936 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 939 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 942 */     super.commitTransaction();
/*     */     
/* 944 */     this._lineItemTypesSavepoint = this._lineItemTypes;
/* 945 */     if (this._lineItemTypes != null) {
/* 946 */       Iterator<IDataModel> it = this._lineItemTypes.iterator();
/* 947 */       while (it.hasNext()) {
/* 948 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 950 */       this._lineItemTypes = new HistoricalList((List)this._lineItemTypes);
/*     */     } 
/*     */     
/* 953 */     this._itemIdsSavepoint = this._itemIds;
/* 954 */     if (this._itemIds != null) {
/* 955 */       Iterator<IDataModel> it = this._itemIds.iterator();
/* 956 */       while (it.hasNext()) {
/* 957 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 959 */       this._itemIds = new HistoricalList((List)this._itemIds);
/*     */     } 
/*     */     
/* 962 */     this._propertiesSavepoint = this._properties;
/* 963 */     if (this._properties != null) {
/* 964 */       Iterator<IDataModel> it = this._properties.iterator();
/* 965 */       while (it.hasNext()) {
/* 966 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 968 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 972 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemMessageModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */