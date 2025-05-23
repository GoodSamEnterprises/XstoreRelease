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
/*     */ import dtv.xst.dao.inv.IShipper;
/*     */ import dtv.xst.dao.inv.IShipperProperty;
/*     */ import dtv.xst.dao.inv.ShipperPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ShipperModel extends AbstractDataModelWithPropertyImpl<IShipperProperty> implements IShipper {
/*     */   private static final long serialVersionUID = -568756927L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IShipperProperty> _properties; private transient HistoricalList<IShipperProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ShipperDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ShipperDAO getDAO_() {
/*  46 */     return (ShipperDAO)this._daoImpl;
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
/*  70 */       this._events.post(IShipper.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ShipperPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ShipperPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getShipperId() {
/* 101 */     return getDAO_().getShipperId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShipperId(String argShipperId) {
/* 109 */     if (setShipperId_noev(argShipperId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IShipper.SET_SHIPPERID, argShipperId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setShipperId_noev(String argShipperId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getShipperId() == null && argShipperId != null) || (
/* 122 */       getDAO_().getShipperId() != null && !getDAO_().getShipperId().equals(argShipperId))) {
/* 123 */       getDAO_().setShipperId(argShipperId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<ShipperPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((ShipperPropertyModel)it.next()).setShipperId_noev(argShipperId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 135 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 143 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 151 */     if (setOrgCode_noev(argOrgCode) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IShipper.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 164 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 165 */       getDAO_().setOrgCode(argOrgCode);
/* 166 */       ev_postable = true;
/*     */     } 
/*     */     
/* 169 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 177 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 185 */     if (setOrgValue_noev(argOrgValue) && 
/* 186 */       this._events != null && 
/* 187 */       postEventsForChanges()) {
/* 188 */       this._events.post(IShipper.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 195 */     boolean ev_postable = false;
/*     */     
/* 197 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 198 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 199 */       getDAO_().setOrgValue(argOrgValue);
/* 200 */       ev_postable = true;
/*     */     } 
/*     */     
/* 203 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 211 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 219 */     if (setCreateDate_noev(argCreateDate) && 
/* 220 */       this._events != null && 
/* 221 */       postEventsForChanges()) {
/* 222 */       this._events.post(IShipper.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 229 */     boolean ev_postable = false;
/*     */     
/* 231 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 232 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 233 */       getDAO_().setCreateDate(argCreateDate);
/* 234 */       ev_postable = true;
/*     */     } 
/*     */     
/* 237 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 245 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 253 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 254 */       this._events != null && 
/* 255 */       postEventsForChanges()) {
/* 256 */       this._events.post(IShipper.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 263 */     boolean ev_postable = false;
/*     */     
/* 265 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 266 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 267 */       getDAO_().setCreateUserId(argCreateUserId);
/* 268 */       ev_postable = true;
/*     */     } 
/*     */     
/* 271 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 279 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 287 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(IShipper.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 300 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 301 */       getDAO_().setUpdateDate(argUpdateDate);
/* 302 */       ev_postable = true;
/*     */     } 
/*     */     
/* 305 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 313 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 321 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 322 */       this._events != null && 
/* 323 */       postEventsForChanges()) {
/* 324 */       this._events.post(IShipper.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 331 */     boolean ev_postable = false;
/*     */     
/* 333 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 334 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 335 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 336 */       ev_postable = true;
/*     */     } 
/*     */     
/* 339 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getShipperDesc() {
/* 347 */     return getDAO_().getShipperDesc();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShipperDesc(String argShipperDesc) {
/* 355 */     if (setShipperDesc_noev(argShipperDesc) && 
/* 356 */       this._events != null && 
/* 357 */       postEventsForChanges()) {
/* 358 */       this._events.post(IShipper.SET_SHIPPERDESC, argShipperDesc);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setShipperDesc_noev(String argShipperDesc) {
/* 365 */     boolean ev_postable = false;
/*     */     
/* 367 */     if ((getDAO_().getShipperDesc() == null && argShipperDesc != null) || (
/* 368 */       getDAO_().getShipperDesc() != null && !getDAO_().getShipperDesc().equals(argShipperDesc))) {
/* 369 */       getDAO_().setShipperDesc(argShipperDesc);
/* 370 */       ev_postable = true;
/*     */     } 
/*     */     
/* 373 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDisplayOrder() {
/* 381 */     if (getDAO_().getDisplayOrder() != null) {
/* 382 */       return getDAO_().getDisplayOrder().intValue();
/*     */     }
/*     */     
/* 385 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayOrder(int argDisplayOrder) {
/* 394 */     if (setDisplayOrder_noev(argDisplayOrder) && 
/* 395 */       this._events != null && 
/* 396 */       postEventsForChanges()) {
/* 397 */       this._events.post(IShipper.SET_DISPLAYORDER, Integer.valueOf(argDisplayOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDisplayOrder_noev(int argDisplayOrder) {
/* 404 */     boolean ev_postable = false;
/*     */     
/* 406 */     if ((getDAO_().getDisplayOrder() == null && Integer.valueOf(argDisplayOrder) != null) || (
/* 407 */       getDAO_().getDisplayOrder() != null && !getDAO_().getDisplayOrder().equals(Integer.valueOf(argDisplayOrder)))) {
/* 408 */       getDAO_().setDisplayOrder(Integer.valueOf(argDisplayOrder));
/* 409 */       ev_postable = true;
/*     */     } 
/*     */     
/* 412 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getTrackingNumberEnabled() {
/* 420 */     if (getDAO_().getTrackingNumberEnabled() != null) {
/* 421 */       return getDAO_().getTrackingNumberEnabled().booleanValue();
/*     */     }
/*     */     
/* 424 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTrackingNumberEnabled(boolean argTrackingNumberEnabled) {
/* 433 */     if (setTrackingNumberEnabled_noev(argTrackingNumberEnabled) && 
/* 434 */       this._events != null && 
/* 435 */       postEventsForChanges()) {
/* 436 */       this._events.post(IShipper.SET_TRACKINGNUMBERENABLED, Boolean.valueOf(argTrackingNumberEnabled));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTrackingNumberEnabled_noev(boolean argTrackingNumberEnabled) {
/* 443 */     boolean ev_postable = false;
/*     */     
/* 445 */     if ((getDAO_().getTrackingNumberEnabled() == null && Boolean.valueOf(argTrackingNumberEnabled) != null) || (
/* 446 */       getDAO_().getTrackingNumberEnabled() != null && !getDAO_().getTrackingNumberEnabled().equals(Boolean.valueOf(argTrackingNumberEnabled)))) {
/* 447 */       getDAO_().setTrackingNumberEnabled(Boolean.valueOf(argTrackingNumberEnabled));
/* 448 */       ev_postable = true;
/*     */     } 
/*     */     
/* 451 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IShipperProperty newProperty(String argPropertyName) {
/* 455 */     ShipperPropertyId id = new ShipperPropertyId();
/*     */     
/* 457 */     id.setShipperId(getShipperId());
/* 458 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 460 */     IShipperProperty prop = (IShipperProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IShipperProperty.class);
/* 461 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IShipperProperty> getProperties() {
/* 470 */     if (this._properties == null) {
/* 471 */       this._properties = new HistoricalList(null);
/*     */     }
/* 473 */     return (List<IShipperProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IShipperProperty> argProperties) {
/* 477 */     if (this._properties == null) {
/* 478 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 480 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 483 */     for (IShipperProperty child : this._properties) {
/* 484 */       ShipperPropertyModel model = (ShipperPropertyModel)child;
/* 485 */       model.setOrganizationId_noev(getOrganizationId());
/* 486 */       model.setShipperId_noev(getShipperId());
/* 487 */       if (child instanceof IDataModelImpl) {
/* 488 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 489 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 490 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 491 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 494 */       if (postEventsForChanges()) {
/* 495 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addShipperProperty(IShipperProperty argShipperProperty) {
/* 501 */     if (this._properties == null) {
/* 502 */       this._properties = new HistoricalList(null);
/*     */     }
/* 504 */     argShipperProperty.setOrganizationId(getOrganizationId());
/* 505 */     argShipperProperty.setShipperId(getShipperId());
/* 506 */     if (argShipperProperty instanceof IDataModelImpl) {
/* 507 */       IDataAccessObject childDao = ((IDataModelImpl)argShipperProperty).getDAO();
/* 508 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 509 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 510 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 515 */     if (postEventsForChanges()) {
/* 516 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShipperProperty));
/*     */     }
/*     */     
/* 519 */     this._properties.add(argShipperProperty);
/* 520 */     if (postEventsForChanges()) {
/* 521 */       this._events.post(IShipper.ADD_PROPERTIES, argShipperProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeShipperProperty(IShipperProperty argShipperProperty) {
/* 526 */     if (this._properties != null) {
/*     */       
/* 528 */       if (postEventsForChanges()) {
/* 529 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShipperProperty));
/*     */       }
/* 531 */       this._properties.remove(argShipperProperty);
/* 532 */       if (postEventsForChanges()) {
/* 533 */         this._events.post(IShipper.REMOVE_PROPERTIES, argShipperProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 540 */     if ("Properties".equals(argFieldId)) {
/* 541 */       return getProperties();
/*     */     }
/* 543 */     if ("ShipperExtension".equals(argFieldId)) {
/* 544 */       return this._myExtension;
/*     */     }
/*     */     
/* 547 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 553 */     if ("Properties".equals(argFieldId)) {
/* 554 */       setProperties(changeToList(argValue, IShipperProperty.class));
/*     */     }
/* 556 */     else if ("ShipperExtension".equals(argFieldId)) {
/* 557 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 560 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 566 */     this._persistenceDefaults = argPD;
/* 567 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 568 */     this._eventManager = argEM;
/* 569 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 570 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 571 */     if (this._properties != null) {
/* 572 */       for (IShipperProperty relationship : this._properties) {
/* 573 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getShipperExt() {
/* 579 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setShipperExt(IDataModel argExt) {
/* 583 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 588 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 592 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 595 */     super.startTransaction();
/*     */     
/* 597 */     this._propertiesSavepoint = this._properties;
/* 598 */     if (this._properties != null) {
/* 599 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 600 */       Iterator<IDataModel> it = this._properties.iterator();
/* 601 */       while (it.hasNext()) {
/* 602 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 607 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 612 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 615 */     super.rollbackChanges();
/*     */     
/* 617 */     this._properties = this._propertiesSavepoint;
/* 618 */     this._propertiesSavepoint = null;
/* 619 */     if (this._properties != null) {
/* 620 */       Iterator<IDataModel> it = this._properties.iterator();
/* 621 */       while (it.hasNext()) {
/* 622 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 630 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 633 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 636 */     super.commitTransaction();
/*     */     
/* 638 */     this._propertiesSavepoint = this._properties;
/* 639 */     if (this._properties != null) {
/* 640 */       Iterator<IDataModel> it = this._properties.iterator();
/* 641 */       while (it.hasNext()) {
/* 642 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 644 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 648 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 653 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipperModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */