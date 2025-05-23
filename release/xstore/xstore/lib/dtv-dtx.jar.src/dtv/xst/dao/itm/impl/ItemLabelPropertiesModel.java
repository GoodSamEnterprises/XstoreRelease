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
/*     */ import dtv.xst.dao.itm.IItemLabelProperties;
/*     */ import dtv.xst.dao.itm.IItemLabelPropertiesProperty;
/*     */ import dtv.xst.dao.itm.ItemLabelPropertiesPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemLabelPropertiesModel extends AbstractDataModelWithPropertyImpl<IItemLabelPropertiesProperty> implements IItemLabelProperties {
/*     */   private static final long serialVersionUID = 1062658964L;
/*     */   private IItem _parentItem;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IItemLabelPropertiesProperty> _properties; private transient HistoricalList<IItemLabelPropertiesProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new ItemLabelPropertiesDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemLabelPropertiesDAO getDAO_() {
/*  48 */     return (ItemLabelPropertiesDAO)this._daoImpl;
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
/*  72 */       this._events.post(IItemLabelProperties.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<ItemLabelPropertiesPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((ItemLabelPropertiesPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 114 */       this._events.post(IItemLabelProperties.SET_ITEMID, argItemId);
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
/* 129 */         Iterator<ItemLabelPropertiesPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((ItemLabelPropertiesPropertyModel)it.next()).setItemId_noev(argItemId);
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
/*     */   public String getOrgCode() {
/* 145 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 153 */     if (setOrgCode_noev(argOrgCode) && 
/* 154 */       this._events != null && 
/* 155 */       postEventsForChanges()) {
/* 156 */       this._events.post(IItemLabelProperties.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 163 */     boolean ev_postable = false;
/*     */     
/* 165 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 166 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 167 */       getDAO_().setOrgCode(argOrgCode);
/* 168 */       ev_postable = true;
/*     */     } 
/*     */     
/* 171 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 179 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 187 */     if (setOrgValue_noev(argOrgValue) && 
/* 188 */       this._events != null && 
/* 189 */       postEventsForChanges()) {
/* 190 */       this._events.post(IItemLabelProperties.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 197 */     boolean ev_postable = false;
/*     */     
/* 199 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 200 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 201 */       getDAO_().setOrgValue(argOrgValue);
/* 202 */       ev_postable = true;
/*     */     } 
/*     */     
/* 205 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 213 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 221 */     if (setCreateDate_noev(argCreateDate) && 
/* 222 */       this._events != null && 
/* 223 */       postEventsForChanges()) {
/* 224 */       this._events.post(IItemLabelProperties.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 231 */     boolean ev_postable = false;
/*     */     
/* 233 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 234 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 235 */       getDAO_().setCreateDate(argCreateDate);
/* 236 */       ev_postable = true;
/*     */     } 
/*     */     
/* 239 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 247 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 255 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 256 */       this._events != null && 
/* 257 */       postEventsForChanges()) {
/* 258 */       this._events.post(IItemLabelProperties.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 265 */     boolean ev_postable = false;
/*     */     
/* 267 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 268 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 269 */       getDAO_().setCreateUserId(argCreateUserId);
/* 270 */       ev_postable = true;
/*     */     } 
/*     */     
/* 273 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 281 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 289 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 290 */       this._events != null && 
/* 291 */       postEventsForChanges()) {
/* 292 */       this._events.post(IItemLabelProperties.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 299 */     boolean ev_postable = false;
/*     */     
/* 301 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 302 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 303 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 315 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 323 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 324 */       this._events != null && 
/* 325 */       postEventsForChanges()) {
/* 326 */       this._events.post(IItemLabelProperties.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 333 */     boolean ev_postable = false;
/*     */     
/* 335 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 336 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 337 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public String getStockLabel() {
/* 349 */     return getDAO_().getStockLabel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStockLabel(String argStockLabel) {
/* 357 */     if (setStockLabel_noev(argStockLabel) && 
/* 358 */       this._events != null && 
/* 359 */       postEventsForChanges()) {
/* 360 */       this._events.post(IItemLabelProperties.SET_STOCKLABEL, argStockLabel);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStockLabel_noev(String argStockLabel) {
/* 367 */     boolean ev_postable = false;
/*     */     
/* 369 */     if ((getDAO_().getStockLabel() == null && argStockLabel != null) || (
/* 370 */       getDAO_().getStockLabel() != null && !getDAO_().getStockLabel().equals(argStockLabel))) {
/* 371 */       getDAO_().setStockLabel(argStockLabel);
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
/*     */   public String getLogoUrl() {
/* 383 */     return getDAO_().getLogoUrl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLogoUrl(String argLogoUrl) {
/* 391 */     if (setLogoUrl_noev(argLogoUrl) && 
/* 392 */       this._events != null && 
/* 393 */       postEventsForChanges()) {
/* 394 */       this._events.post(IItemLabelProperties.SET_LOGOURL, argLogoUrl);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLogoUrl_noev(String argLogoUrl) {
/* 401 */     boolean ev_postable = false;
/*     */     
/* 403 */     if ((getDAO_().getLogoUrl() == null && argLogoUrl != null) || (
/* 404 */       getDAO_().getLogoUrl() != null && !getDAO_().getLogoUrl().equals(argLogoUrl))) {
/* 405 */       getDAO_().setLogoUrl(argLogoUrl);
/* 406 */       ev_postable = true;
/*     */     } 
/*     */     
/* 409 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemLabelPropertiesProperty newProperty(String argPropertyName) {
/* 413 */     ItemLabelPropertiesPropertyId id = new ItemLabelPropertiesPropertyId();
/*     */     
/* 415 */     id.setItemId(getItemId());
/* 416 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 418 */     IItemLabelPropertiesProperty prop = (IItemLabelPropertiesProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemLabelPropertiesProperty.class);
/* 419 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemLabelPropertiesProperty> getProperties() {
/* 428 */     if (this._properties == null) {
/* 429 */       this._properties = new HistoricalList(null);
/*     */     }
/* 431 */     return (List<IItemLabelPropertiesProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemLabelPropertiesProperty> argProperties) {
/* 435 */     if (this._properties == null) {
/* 436 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 438 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 441 */     for (IItemLabelPropertiesProperty child : this._properties) {
/* 442 */       ItemLabelPropertiesPropertyModel model = (ItemLabelPropertiesPropertyModel)child;
/* 443 */       model.setOrganizationId_noev(getOrganizationId());
/* 444 */       model.setItemId_noev(getItemId());
/* 445 */       if (child instanceof IDataModelImpl) {
/* 446 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 447 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 448 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 449 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 452 */       if (postEventsForChanges()) {
/* 453 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemLabelPropertiesProperty(IItemLabelPropertiesProperty argItemLabelPropertiesProperty) {
/* 459 */     if (this._properties == null) {
/* 460 */       this._properties = new HistoricalList(null);
/*     */     }
/* 462 */     argItemLabelPropertiesProperty.setOrganizationId(getOrganizationId());
/* 463 */     argItemLabelPropertiesProperty.setItemId(getItemId());
/* 464 */     if (argItemLabelPropertiesProperty instanceof IDataModelImpl) {
/* 465 */       IDataAccessObject childDao = ((IDataModelImpl)argItemLabelPropertiesProperty).getDAO();
/* 466 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 467 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 468 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 473 */     if (postEventsForChanges()) {
/* 474 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemLabelPropertiesProperty));
/*     */     }
/*     */     
/* 477 */     this._properties.add(argItemLabelPropertiesProperty);
/* 478 */     if (postEventsForChanges()) {
/* 479 */       this._events.post(IItemLabelProperties.ADD_PROPERTIES, argItemLabelPropertiesProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemLabelPropertiesProperty(IItemLabelPropertiesProperty argItemLabelPropertiesProperty) {
/* 484 */     if (this._properties != null) {
/*     */       
/* 486 */       if (postEventsForChanges()) {
/* 487 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemLabelPropertiesProperty));
/*     */       }
/* 489 */       this._properties.remove(argItemLabelPropertiesProperty);
/* 490 */       if (postEventsForChanges()) {
/* 491 */         this._events.post(IItemLabelProperties.REMOVE_PROPERTIES, argItemLabelPropertiesProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentItem(IItem argParentItem) {
/* 497 */     this._parentItem = argParentItem;
/*     */   }
/*     */   
/*     */   public IItem getParentItem() {
/* 501 */     return this._parentItem;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 506 */     if ("Properties".equals(argFieldId)) {
/* 507 */       return getProperties();
/*     */     }
/* 509 */     if ("ItemLabelPropertiesExtension".equals(argFieldId)) {
/* 510 */       return this._myExtension;
/*     */     }
/*     */     
/* 513 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 519 */     if ("Properties".equals(argFieldId)) {
/* 520 */       setProperties(changeToList(argValue, IItemLabelPropertiesProperty.class));
/*     */     }
/* 522 */     else if ("ItemLabelPropertiesExtension".equals(argFieldId)) {
/* 523 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 526 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 532 */     this._persistenceDefaults = argPD;
/* 533 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 534 */     this._eventManager = argEM;
/* 535 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 536 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 537 */     if (this._properties != null) {
/* 538 */       for (IItemLabelPropertiesProperty relationship : this._properties) {
/* 539 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemLabelPropertiesExt() {
/* 545 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemLabelPropertiesExt(IDataModel argExt) {
/* 549 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 554 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 558 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 561 */     super.startTransaction();
/*     */     
/* 563 */     this._propertiesSavepoint = this._properties;
/* 564 */     if (this._properties != null) {
/* 565 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 566 */       Iterator<IDataModel> it = this._properties.iterator();
/* 567 */       while (it.hasNext()) {
/* 568 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 573 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 578 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 581 */     super.rollbackChanges();
/*     */     
/* 583 */     this._properties = this._propertiesSavepoint;
/* 584 */     this._propertiesSavepoint = null;
/* 585 */     if (this._properties != null) {
/* 586 */       Iterator<IDataModel> it = this._properties.iterator();
/* 587 */       while (it.hasNext()) {
/* 588 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 596 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 599 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 602 */     super.commitTransaction();
/*     */     
/* 604 */     this._propertiesSavepoint = this._properties;
/* 605 */     if (this._properties != null) {
/* 606 */       Iterator<IDataModel> it = this._properties.iterator();
/* 607 */       while (it.hasNext()) {
/* 608 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 610 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 614 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 619 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemLabelPropertiesModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */