/*     */ package dtv.xst.dao.itm.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
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
/*     */ import dtv.xst.dao.itm.IItem;
/*     */ import dtv.xst.dao.itm.IItemLabelBatch;
/*     */ import dtv.xst.dao.itm.IItemLabelBatchProperty;
/*     */ import dtv.xst.dao.itm.ItemLabelBatchPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemLabelBatchModel extends AbstractDataModelWithPropertyImpl<IItemLabelBatchProperty> implements IItemLabelBatch {
/*     */   private static final long serialVersionUID = -51165127L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IItem _item; private transient IItem _itemSavepoint; private HistoricalList<IItemLabelBatchProperty> _properties; private transient HistoricalList<IItemLabelBatchProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new ItemLabelBatchDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemLabelBatchDAO getDAO_() {
/*  47 */     return (ItemLabelBatchDAO)this._daoImpl;
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
/*  71 */       this._events.post(IItemLabelBatch.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  86 */         Iterator<ItemLabelBatchPropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((ItemLabelBatchPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 102 */     if (getDAO_().getRetailLocationId() != null) {
/* 103 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 106 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 115 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 116 */       this._events != null && 
/* 117 */       postEventsForChanges()) {
/* 118 */       this._events.post(IItemLabelBatch.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 125 */     boolean ev_postable = false;
/*     */     
/* 127 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 128 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 129 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 130 */       ev_postable = true;
/* 131 */       if (this._properties != null) {
/*     */         
/* 133 */         Iterator<ItemLabelBatchPropertyModel> it = this._properties.iterator();
/* 134 */         while (it.hasNext())
/*     */         {
/* 136 */           ((ItemLabelBatchPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 141 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBatchName() {
/* 149 */     return getDAO_().getBatchName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBatchName(String argBatchName) {
/* 157 */     if (setBatchName_noev(argBatchName) && 
/* 158 */       this._events != null && 
/* 159 */       postEventsForChanges()) {
/* 160 */       this._events.post(IItemLabelBatch.SET_BATCHNAME, argBatchName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBatchName_noev(String argBatchName) {
/* 167 */     boolean ev_postable = false;
/*     */     
/* 169 */     if ((getDAO_().getBatchName() == null && argBatchName != null) || (
/* 170 */       getDAO_().getBatchName() != null && !getDAO_().getBatchName().equals(argBatchName))) {
/* 171 */       getDAO_().setBatchName(argBatchName);
/* 172 */       ev_postable = true;
/* 173 */       if (this._properties != null) {
/*     */         
/* 175 */         Iterator<ItemLabelBatchPropertyModel> it = this._properties.iterator();
/* 176 */         while (it.hasNext())
/*     */         {
/* 178 */           ((ItemLabelBatchPropertyModel)it.next()).setBatchName_noev(argBatchName);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 183 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/* 191 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 199 */     if (setItemId_noev(argItemId) && 
/* 200 */       this._events != null && 
/* 201 */       postEventsForChanges()) {
/* 202 */       this._events.post(IItemLabelBatch.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 209 */     boolean ev_postable = false;
/*     */     
/* 211 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 212 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 213 */       getDAO_().setItemId(argItemId);
/* 214 */       ev_postable = true;
/* 215 */       if (this._properties != null) {
/*     */         
/* 217 */         Iterator<ItemLabelBatchPropertyModel> it = this._properties.iterator();
/* 218 */         while (it.hasNext())
/*     */         {
/* 220 */           ((ItemLabelBatchPropertyModel)it.next()).setItemId_noev(argItemId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 225 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStockLabel() {
/* 233 */     return getDAO_().getStockLabel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStockLabel(String argStockLabel) {
/* 241 */     if (setStockLabel_noev(argStockLabel) && 
/* 242 */       this._events != null && 
/* 243 */       postEventsForChanges()) {
/* 244 */       this._events.post(IItemLabelBatch.SET_STOCKLABEL, argStockLabel);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStockLabel_noev(String argStockLabel) {
/* 251 */     boolean ev_postable = false;
/*     */     
/* 253 */     if ((getDAO_().getStockLabel() == null && argStockLabel != null) || (
/* 254 */       getDAO_().getStockLabel() != null && !getDAO_().getStockLabel().equals(argStockLabel))) {
/* 255 */       getDAO_().setStockLabel(argStockLabel);
/* 256 */       ev_postable = true;
/* 257 */       if (this._properties != null) {
/*     */         
/* 259 */         Iterator<ItemLabelBatchPropertyModel> it = this._properties.iterator();
/* 260 */         while (it.hasNext())
/*     */         {
/* 262 */           ((ItemLabelBatchPropertyModel)it.next()).setStockLabel_noev(argStockLabel);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 267 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 275 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 283 */     if (setCreateDate_noev(argCreateDate) && 
/* 284 */       this._events != null && 
/* 285 */       postEventsForChanges()) {
/* 286 */       this._events.post(IItemLabelBatch.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 293 */     boolean ev_postable = false;
/*     */     
/* 295 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 296 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 297 */       getDAO_().setCreateDate(argCreateDate);
/* 298 */       ev_postable = true;
/*     */     } 
/*     */     
/* 301 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 309 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 317 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 318 */       this._events != null && 
/* 319 */       postEventsForChanges()) {
/* 320 */       this._events.post(IItemLabelBatch.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 327 */     boolean ev_postable = false;
/*     */     
/* 329 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 330 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 331 */       getDAO_().setCreateUserId(argCreateUserId);
/* 332 */       ev_postable = true;
/*     */     } 
/*     */     
/* 335 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 343 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 351 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 352 */       this._events != null && 
/* 353 */       postEventsForChanges()) {
/* 354 */       this._events.post(IItemLabelBatch.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 361 */     boolean ev_postable = false;
/*     */     
/* 363 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 364 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 365 */       getDAO_().setUpdateDate(argUpdateDate);
/* 366 */       ev_postable = true;
/*     */     } 
/*     */     
/* 369 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 377 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 385 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 386 */       this._events != null && 
/* 387 */       postEventsForChanges()) {
/* 388 */       this._events.post(IItemLabelBatch.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 395 */     boolean ev_postable = false;
/*     */     
/* 397 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 398 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 399 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 400 */       ev_postable = true;
/*     */     } 
/*     */     
/* 403 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCount() {
/* 411 */     if (getDAO_().getCount() != null) {
/* 412 */       return getDAO_().getCount().longValue();
/*     */     }
/*     */     
/* 415 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCount(long argCount) {
/* 424 */     if (setCount_noev(argCount) && 
/* 425 */       this._events != null && 
/* 426 */       postEventsForChanges()) {
/* 427 */       this._events.post(IItemLabelBatch.SET_COUNT, Long.valueOf(argCount));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCount_noev(long argCount) {
/* 434 */     boolean ev_postable = false;
/*     */     
/* 436 */     if ((getDAO_().getCount() == null && Long.valueOf(argCount) != null) || (
/* 437 */       getDAO_().getCount() != null && !getDAO_().getCount().equals(Long.valueOf(argCount)))) {
/* 438 */       getDAO_().setCount(Long.valueOf(argCount));
/* 439 */       ev_postable = true;
/*     */     } 
/*     */     
/* 442 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getOverridenPrice() {
/* 450 */     return getDAO_().getOverridenPrice();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOverridenPrice(BigDecimal argOverridenPrice) {
/* 458 */     if (setOverridenPrice_noev(argOverridenPrice) && 
/* 459 */       this._events != null && 
/* 460 */       postEventsForChanges()) {
/* 461 */       this._events.post(IItemLabelBatch.SET_OVERRIDENPRICE, argOverridenPrice);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOverridenPrice_noev(BigDecimal argOverridenPrice) {
/* 468 */     boolean ev_postable = false;
/*     */     
/* 470 */     if ((getDAO_().getOverridenPrice() == null && argOverridenPrice != null) || (
/* 471 */       getDAO_().getOverridenPrice() != null && !getDAO_().getOverridenPrice().equals(argOverridenPrice))) {
/* 472 */       getDAO_().setOverridenPrice(argOverridenPrice);
/* 473 */       ev_postable = true;
/*     */     } 
/*     */     
/* 476 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemLabelBatchProperty newProperty(String argPropertyName) {
/* 480 */     ItemLabelBatchPropertyId id = new ItemLabelBatchPropertyId();
/*     */     
/* 482 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 483 */     id.setBatchName(getBatchName());
/* 484 */     id.setItemId(getItemId());
/* 485 */     id.setStockLabel(getStockLabel());
/* 486 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 488 */     IItemLabelBatchProperty prop = (IItemLabelBatchProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemLabelBatchProperty.class);
/* 489 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Item")
/*     */   public IItem getItem() {
/* 501 */     return this._item;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setItem(IItem argItem) {
/* 506 */     if (argItem == null) {
/*     */       
/* 508 */       if (this._item != null) {
/* 509 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*     */       }
/*     */       
/* 512 */       if (this._item != null)
/*     */       {
/* 514 */         if (postEventsForChanges()) {
/* 515 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._item));
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     }
/* 521 */     else if (postEventsForChanges()) {
/* 522 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItem));
/*     */     } 
/*     */ 
/*     */     
/* 526 */     this._item = argItem;
/* 527 */     if (postEventsForChanges()) {
/* 528 */       this._events.post(IItemLabelBatch.SET_ITEM, argItem);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemLabelBatchProperty> getProperties() {
/* 534 */     if (this._properties == null) {
/* 535 */       this._properties = new HistoricalList(null);
/*     */     }
/* 537 */     return (List<IItemLabelBatchProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemLabelBatchProperty> argProperties) {
/* 541 */     if (this._properties == null) {
/* 542 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 544 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 547 */     for (IItemLabelBatchProperty child : this._properties) {
/* 548 */       ItemLabelBatchPropertyModel model = (ItemLabelBatchPropertyModel)child;
/* 549 */       model.setOrganizationId_noev(getOrganizationId());
/* 550 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 551 */       model.setBatchName_noev(getBatchName());
/* 552 */       model.setItemId_noev(getItemId());
/* 553 */       model.setStockLabel_noev(getStockLabel());
/* 554 */       if (child instanceof IDataModelImpl) {
/* 555 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 556 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 557 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 558 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 561 */       if (postEventsForChanges()) {
/* 562 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemLabelBatchProperty(IItemLabelBatchProperty argItemLabelBatchProperty) {
/* 568 */     if (this._properties == null) {
/* 569 */       this._properties = new HistoricalList(null);
/*     */     }
/* 571 */     argItemLabelBatchProperty.setOrganizationId(getOrganizationId());
/* 572 */     argItemLabelBatchProperty.setRetailLocationId(getRetailLocationId());
/* 573 */     argItemLabelBatchProperty.setBatchName(getBatchName());
/* 574 */     argItemLabelBatchProperty.setItemId(getItemId());
/* 575 */     argItemLabelBatchProperty.setStockLabel(getStockLabel());
/* 576 */     if (argItemLabelBatchProperty instanceof IDataModelImpl) {
/* 577 */       IDataAccessObject childDao = ((IDataModelImpl)argItemLabelBatchProperty).getDAO();
/* 578 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 579 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 580 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 585 */     if (postEventsForChanges()) {
/* 586 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemLabelBatchProperty));
/*     */     }
/*     */     
/* 589 */     this._properties.add(argItemLabelBatchProperty);
/* 590 */     if (postEventsForChanges()) {
/* 591 */       this._events.post(IItemLabelBatch.ADD_PROPERTIES, argItemLabelBatchProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemLabelBatchProperty(IItemLabelBatchProperty argItemLabelBatchProperty) {
/* 596 */     if (this._properties != null) {
/*     */       
/* 598 */       if (postEventsForChanges()) {
/* 599 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemLabelBatchProperty));
/*     */       }
/* 601 */       this._properties.remove(argItemLabelBatchProperty);
/* 602 */       if (postEventsForChanges()) {
/* 603 */         this._events.post(IItemLabelBatch.REMOVE_PROPERTIES, argItemLabelBatchProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 610 */     if ("Item".equals(argFieldId)) {
/* 611 */       return getItem();
/*     */     }
/* 613 */     if ("Properties".equals(argFieldId)) {
/* 614 */       return getProperties();
/*     */     }
/* 616 */     if ("ItemLabelBatchExtension".equals(argFieldId)) {
/* 617 */       return this._myExtension;
/*     */     }
/*     */     
/* 620 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 626 */     if ("Item".equals(argFieldId)) {
/* 627 */       setItem((IItem)argValue);
/*     */     }
/* 629 */     else if ("Properties".equals(argFieldId)) {
/* 630 */       setProperties(changeToList(argValue, IItemLabelBatchProperty.class));
/*     */     }
/* 632 */     else if ("ItemLabelBatchExtension".equals(argFieldId)) {
/* 633 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 636 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 642 */     this._persistenceDefaults = argPD;
/* 643 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 644 */     this._eventManager = argEM;
/* 645 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 646 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 647 */     if (this._item != null) {
/* 648 */       ((IDataModelImpl)this._item).setDependencies(argPD, argEM);
/*     */     }
/* 650 */     if (this._properties != null) {
/* 651 */       for (IItemLabelBatchProperty relationship : this._properties) {
/* 652 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemLabelBatchExt() {
/* 658 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemLabelBatchExt(IDataModel argExt) {
/* 662 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 667 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 671 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 674 */     super.startTransaction();
/*     */     
/* 676 */     this._itemSavepoint = this._item;
/* 677 */     if (this._item != null) {
/* 678 */       this._item.startTransaction();
/*     */     }
/*     */     
/* 681 */     this._propertiesSavepoint = this._properties;
/* 682 */     if (this._properties != null) {
/* 683 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 684 */       Iterator<IDataModel> it = this._properties.iterator();
/* 685 */       while (it.hasNext()) {
/* 686 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 691 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 696 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 699 */     super.rollbackChanges();
/*     */     
/* 701 */     this._item = this._itemSavepoint;
/* 702 */     this._itemSavepoint = null;
/* 703 */     if (this._item != null) {
/* 704 */       this._item.rollbackChanges();
/*     */     }
/*     */     
/* 707 */     this._properties = this._propertiesSavepoint;
/* 708 */     this._propertiesSavepoint = null;
/* 709 */     if (this._properties != null) {
/* 710 */       Iterator<IDataModel> it = this._properties.iterator();
/* 711 */       while (it.hasNext()) {
/* 712 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 720 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 723 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 726 */     super.commitTransaction();
/*     */     
/* 728 */     this._itemSavepoint = this._item;
/* 729 */     if (this._item != null) {
/* 730 */       this._item.commitTransaction();
/*     */     }
/*     */     
/* 733 */     this._propertiesSavepoint = this._properties;
/* 734 */     if (this._properties != null) {
/* 735 */       Iterator<IDataModel> it = this._properties.iterator();
/* 736 */       while (it.hasNext()) {
/* 737 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 739 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 743 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 748 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemLabelBatchModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */