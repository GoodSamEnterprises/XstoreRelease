/*     */ package dtv.xst.dao.itm.impl;
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
/*     */ import dtv.xst.dao.itm.IItem;
/*     */ import dtv.xst.dao.itm.IItemImage;
/*     */ import dtv.xst.dao.itm.IItemImageProperty;
/*     */ import dtv.xst.dao.itm.ItemImagePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemImageModel extends AbstractDataModelWithPropertyImpl<IItemImageProperty> implements IItemImage {
/*     */   private static final long serialVersionUID = -157724184L;
/*     */   private IItem _parentItem;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IItemImageProperty> _properties; private transient HistoricalList<IItemImageProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new ItemImageDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemImageDAO getDAO_() {
/*  48 */     return (ItemImageDAO)this._daoImpl;
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
/*  72 */       this._events.post(IItemImage.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<ItemImagePropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((ItemImagePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getItemId() {
/* 103 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 111 */     if (setItemId_noev(argItemId) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(IItemImage.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 124 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 125 */       getDAO_().setItemId(argItemId);
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<ItemImagePropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((ItemImagePropertyModel)it.next()).setItemId_noev(argItemId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 137 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFeatureId() {
/* 145 */     return getDAO_().getFeatureId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFeatureId(String argFeatureId) {
/* 153 */     if (setFeatureId_noev(argFeatureId) && 
/* 154 */       this._events != null && 
/* 155 */       postEventsForChanges()) {
/* 156 */       this._events.post(IItemImage.SET_FEATUREID, argFeatureId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFeatureId_noev(String argFeatureId) {
/* 163 */     boolean ev_postable = false;
/*     */     
/* 165 */     if ((getDAO_().getFeatureId() == null && argFeatureId != null) || (
/* 166 */       getDAO_().getFeatureId() != null && !getDAO_().getFeatureId().equals(argFeatureId))) {
/* 167 */       getDAO_().setFeatureId(argFeatureId);
/* 168 */       ev_postable = true;
/* 169 */       if (this._properties != null) {
/*     */         
/* 171 */         Iterator<ItemImagePropertyModel> it = this._properties.iterator();
/* 172 */         while (it.hasNext())
/*     */         {
/* 174 */           ((ItemImagePropertyModel)it.next()).setFeatureId_noev(argFeatureId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 179 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 187 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 195 */     if (setCreateDate_noev(argCreateDate) && 
/* 196 */       this._events != null && 
/* 197 */       postEventsForChanges()) {
/* 198 */       this._events.post(IItemImage.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 205 */     boolean ev_postable = false;
/*     */     
/* 207 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 208 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 209 */       getDAO_().setCreateDate(argCreateDate);
/* 210 */       ev_postable = true;
/*     */     } 
/*     */     
/* 213 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 221 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 229 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 230 */       this._events != null && 
/* 231 */       postEventsForChanges()) {
/* 232 */       this._events.post(IItemImage.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 239 */     boolean ev_postable = false;
/*     */     
/* 241 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 242 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 243 */       getDAO_().setCreateUserId(argCreateUserId);
/* 244 */       ev_postable = true;
/*     */     } 
/*     */     
/* 247 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 255 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 263 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 264 */       this._events != null && 
/* 265 */       postEventsForChanges()) {
/* 266 */       this._events.post(IItemImage.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 273 */     boolean ev_postable = false;
/*     */     
/* 275 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 276 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 277 */       getDAO_().setUpdateDate(argUpdateDate);
/* 278 */       ev_postable = true;
/*     */     } 
/*     */     
/* 281 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 289 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 297 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 298 */       this._events != null && 
/* 299 */       postEventsForChanges()) {
/* 300 */       this._events.post(IItemImage.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 307 */     boolean ev_postable = false;
/*     */     
/* 309 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 310 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 311 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 312 */       ev_postable = true;
/*     */     } 
/*     */     
/* 315 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getImageUrl() {
/* 323 */     return getDAO_().getImageUrl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setImageUrl(String argImageUrl) {
/* 331 */     if (setImageUrl_noev(argImageUrl) && 
/* 332 */       this._events != null && 
/* 333 */       postEventsForChanges()) {
/* 334 */       this._events.post(IItemImage.SET_IMAGEURL, argImageUrl);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setImageUrl_noev(String argImageUrl) {
/* 341 */     boolean ev_postable = false;
/*     */     
/* 343 */     if ((getDAO_().getImageUrl() == null && argImageUrl != null) || (
/* 344 */       getDAO_().getImageUrl() != null && !getDAO_().getImageUrl().equals(argImageUrl))) {
/* 345 */       getDAO_().setImageUrl(argImageUrl);
/* 346 */       ev_postable = true;
/*     */     } 
/*     */     
/* 349 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 357 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 365 */     if (setOrgCode_noev(argOrgCode) && 
/* 366 */       this._events != null && 
/* 367 */       postEventsForChanges()) {
/* 368 */       this._events.post(IItemImage.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 375 */     boolean ev_postable = false;
/*     */     
/* 377 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 378 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 379 */       getDAO_().setOrgCode(argOrgCode);
/* 380 */       ev_postable = true;
/*     */     } 
/*     */     
/* 383 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 391 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 399 */     if (setOrgValue_noev(argOrgValue) && 
/* 400 */       this._events != null && 
/* 401 */       postEventsForChanges()) {
/* 402 */       this._events.post(IItemImage.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 409 */     boolean ev_postable = false;
/*     */     
/* 411 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 412 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 413 */       getDAO_().setOrgValue(argOrgValue);
/* 414 */       ev_postable = true;
/*     */     } 
/*     */     
/* 417 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemImageProperty newProperty(String argPropertyName) {
/* 421 */     ItemImagePropertyId id = new ItemImagePropertyId();
/*     */     
/* 423 */     id.setItemId(getItemId());
/* 424 */     id.setFeatureId(getFeatureId());
/* 425 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 427 */     IItemImageProperty prop = (IItemImageProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemImageProperty.class);
/* 428 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemImageProperty> getProperties() {
/* 437 */     if (this._properties == null) {
/* 438 */       this._properties = new HistoricalList(null);
/*     */     }
/* 440 */     return (List<IItemImageProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemImageProperty> argProperties) {
/* 444 */     if (this._properties == null) {
/* 445 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 447 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 450 */     for (IItemImageProperty child : this._properties) {
/* 451 */       ItemImagePropertyModel model = (ItemImagePropertyModel)child;
/* 452 */       model.setOrganizationId_noev(getOrganizationId());
/* 453 */       model.setItemId_noev(getItemId());
/* 454 */       model.setFeatureId_noev(getFeatureId());
/* 455 */       if (child instanceof IDataModelImpl) {
/* 456 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 457 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 458 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 459 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 462 */       if (postEventsForChanges()) {
/* 463 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemImageProperty(IItemImageProperty argItemImageProperty) {
/* 469 */     if (this._properties == null) {
/* 470 */       this._properties = new HistoricalList(null);
/*     */     }
/* 472 */     argItemImageProperty.setOrganizationId(getOrganizationId());
/* 473 */     argItemImageProperty.setItemId(getItemId());
/* 474 */     argItemImageProperty.setFeatureId(getFeatureId());
/* 475 */     if (argItemImageProperty instanceof IDataModelImpl) {
/* 476 */       IDataAccessObject childDao = ((IDataModelImpl)argItemImageProperty).getDAO();
/* 477 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 478 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 479 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 484 */     if (postEventsForChanges()) {
/* 485 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemImageProperty));
/*     */     }
/*     */     
/* 488 */     this._properties.add(argItemImageProperty);
/* 489 */     if (postEventsForChanges()) {
/* 490 */       this._events.post(IItemImage.ADD_PROPERTIES, argItemImageProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemImageProperty(IItemImageProperty argItemImageProperty) {
/* 495 */     if (this._properties != null) {
/*     */       
/* 497 */       if (postEventsForChanges()) {
/* 498 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemImageProperty));
/*     */       }
/* 500 */       this._properties.remove(argItemImageProperty);
/* 501 */       if (postEventsForChanges()) {
/* 502 */         this._events.post(IItemImage.REMOVE_PROPERTIES, argItemImageProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentItem(IItem argParentItem) {
/* 508 */     this._parentItem = argParentItem;
/*     */   }
/*     */   
/*     */   public IItem getParentItem() {
/* 512 */     return this._parentItem;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 517 */     if ("Properties".equals(argFieldId)) {
/* 518 */       return getProperties();
/*     */     }
/* 520 */     if ("ItemImageExtension".equals(argFieldId)) {
/* 521 */       return this._myExtension;
/*     */     }
/*     */     
/* 524 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 530 */     if ("Properties".equals(argFieldId)) {
/* 531 */       setProperties(changeToList(argValue, IItemImageProperty.class));
/*     */     }
/* 533 */     else if ("ItemImageExtension".equals(argFieldId)) {
/* 534 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 537 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 543 */     this._persistenceDefaults = argPD;
/* 544 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 545 */     this._eventManager = argEM;
/* 546 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 547 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 548 */     if (this._properties != null) {
/* 549 */       for (IItemImageProperty relationship : this._properties) {
/* 550 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemImageExt() {
/* 556 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemImageExt(IDataModel argExt) {
/* 560 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 565 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 569 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 572 */     super.startTransaction();
/*     */     
/* 574 */     this._propertiesSavepoint = this._properties;
/* 575 */     if (this._properties != null) {
/* 576 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 577 */       Iterator<IDataModel> it = this._properties.iterator();
/* 578 */       while (it.hasNext()) {
/* 579 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 584 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 589 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 592 */     super.rollbackChanges();
/*     */     
/* 594 */     this._properties = this._propertiesSavepoint;
/* 595 */     this._propertiesSavepoint = null;
/* 596 */     if (this._properties != null) {
/* 597 */       Iterator<IDataModel> it = this._properties.iterator();
/* 598 */       while (it.hasNext()) {
/* 599 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 607 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 610 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 613 */     super.commitTransaction();
/*     */     
/* 615 */     this._propertiesSavepoint = this._properties;
/* 616 */     if (this._properties != null) {
/* 617 */       Iterator<IDataModel> it = this._properties.iterator();
/* 618 */       while (it.hasNext()) {
/* 619 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 621 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 625 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 630 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemImageModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */