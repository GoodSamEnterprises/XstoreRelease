/*     */ package dtv.xst.dao.xom.impl;
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
/*     */ import dtv.xst.dao.xom.IItemModifier;
/*     */ import dtv.xst.dao.xom.IItemModifierProperty;
/*     */ import dtv.xst.dao.xom.ItemModifierPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemModifierModel extends AbstractDataModelWithPropertyImpl<IItemModifierProperty> implements IItemModifier {
/*     */   private static final long serialVersionUID = 177238826L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IItemModifierProperty> _properties; private transient HistoricalList<IItemModifierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ItemModifierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemModifierDAO getDAO_() {
/*  46 */     return (ItemModifierDAO)this._daoImpl;
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
/*  70 */       this._events.post(IItemModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ItemModifierPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ItemModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getOrderId() {
/* 101 */     return getDAO_().getOrderId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/* 109 */     if (setOrderId_noev(argOrderId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IItemModifier.SET_ORDERID, argOrderId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrderId_noev(String argOrderId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getOrderId() == null && argOrderId != null) || (
/* 122 */       getDAO_().getOrderId() != null && !getDAO_().getOrderId().equals(argOrderId))) {
/* 123 */       getDAO_().setOrderId(argOrderId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<ItemModifierPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((ItemModifierPropertyModel)it.next()).setOrderId_noev(argOrderId);
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
/*     */   public int getSequence() {
/* 143 */     if (getDAO_().getSequence() != null) {
/* 144 */       return getDAO_().getSequence().intValue();
/*     */     }
/*     */     
/* 147 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequence(int argSequence) {
/* 156 */     if (setSequence_noev(argSequence) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IItemModifier.SET_SEQUENCE, Integer.valueOf(argSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequence_noev(int argSequence) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getSequence() == null && Integer.valueOf(argSequence) != null) || (
/* 169 */       getDAO_().getSequence() != null && !getDAO_().getSequence().equals(Integer.valueOf(argSequence)))) {
/* 170 */       getDAO_().setSequence(Integer.valueOf(argSequence));
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<ItemModifierPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((ItemModifierPropertyModel)it.next()).setSequence_noev(argSequence);
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
/*     */   public Date getCreateDate() {
/* 190 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 198 */     if (setCreateDate_noev(argCreateDate) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(IItemModifier.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 211 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 212 */       getDAO_().setCreateDate(argCreateDate);
/* 213 */       ev_postable = true;
/*     */     } 
/*     */     
/* 216 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 224 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 232 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 233 */       this._events != null && 
/* 234 */       postEventsForChanges()) {
/* 235 */       this._events.post(IItemModifier.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 242 */     boolean ev_postable = false;
/*     */     
/* 244 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 245 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 246 */       getDAO_().setCreateUserId(argCreateUserId);
/* 247 */       ev_postable = true;
/*     */     } 
/*     */     
/* 250 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 258 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 266 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 267 */       this._events != null && 
/* 268 */       postEventsForChanges()) {
/* 269 */       this._events.post(IItemModifier.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 276 */     boolean ev_postable = false;
/*     */     
/* 278 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 279 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 280 */       getDAO_().setUpdateDate(argUpdateDate);
/* 281 */       ev_postable = true;
/*     */     } 
/*     */     
/* 284 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 292 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 300 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 301 */       this._events != null && 
/* 302 */       postEventsForChanges()) {
/* 303 */       this._events.post(IItemModifier.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 310 */     boolean ev_postable = false;
/*     */     
/* 312 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 313 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 314 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 315 */       ev_postable = true;
/*     */     } 
/*     */     
/* 318 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/* 326 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 334 */     if (setItemId_noev(argItemId) && 
/* 335 */       this._events != null && 
/* 336 */       postEventsForChanges()) {
/* 337 */       this._events.post(IItemModifier.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 344 */     boolean ev_postable = false;
/*     */     
/* 346 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 347 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 348 */       getDAO_().setItemId(argItemId);
/* 349 */       ev_postable = true;
/*     */     } 
/*     */     
/* 352 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 360 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 368 */     if (setDescription_noev(argDescription) && 
/* 369 */       this._events != null && 
/* 370 */       postEventsForChanges()) {
/* 371 */       this._events.post(IItemModifier.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 378 */     boolean ev_postable = false;
/*     */     
/* 380 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 381 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 382 */       getDAO_().setDescription(argDescription);
/* 383 */       ev_postable = true;
/*     */     } 
/*     */     
/* 386 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getImageUrl() {
/* 394 */     return getDAO_().getImageUrl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setImageUrl(String argImageUrl) {
/* 402 */     if (setImageUrl_noev(argImageUrl) && 
/* 403 */       this._events != null && 
/* 404 */       postEventsForChanges()) {
/* 405 */       this._events.post(IItemModifier.SET_IMAGEURL, argImageUrl);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setImageUrl_noev(String argImageUrl) {
/* 412 */     boolean ev_postable = false;
/*     */     
/* 414 */     if ((getDAO_().getImageUrl() == null && argImageUrl != null) || (
/* 415 */       getDAO_().getImageUrl() != null && !getDAO_().getImageUrl().equals(argImageUrl))) {
/* 416 */       getDAO_().setImageUrl(argImageUrl);
/* 417 */       ev_postable = true;
/*     */     } 
/*     */     
/* 420 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemModifierProperty newProperty(String argPropertyName) {
/* 424 */     ItemModifierPropertyId id = new ItemModifierPropertyId();
/*     */     
/* 426 */     id.setOrderId(getOrderId());
/* 427 */     id.setSequence(Integer.valueOf(getSequence()));
/* 428 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 430 */     IItemModifierProperty prop = (IItemModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemModifierProperty.class);
/* 431 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemModifierProperty> getProperties() {
/* 440 */     if (this._properties == null) {
/* 441 */       this._properties = new HistoricalList(null);
/*     */     }
/* 443 */     return (List<IItemModifierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemModifierProperty> argProperties) {
/* 447 */     if (this._properties == null) {
/* 448 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 450 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 453 */     for (IItemModifierProperty child : this._properties) {
/* 454 */       ItemModifierPropertyModel model = (ItemModifierPropertyModel)child;
/* 455 */       model.setOrganizationId_noev(getOrganizationId());
/* 456 */       model.setOrderId_noev(getOrderId());
/* 457 */       model.setSequence_noev(getSequence());
/* 458 */       if (child instanceof IDataModelImpl) {
/* 459 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 460 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 461 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 462 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 465 */       if (postEventsForChanges()) {
/* 466 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemModifierProperty(IItemModifierProperty argItemModifierProperty) {
/* 472 */     if (this._properties == null) {
/* 473 */       this._properties = new HistoricalList(null);
/*     */     }
/* 475 */     argItemModifierProperty.setOrganizationId(getOrganizationId());
/* 476 */     argItemModifierProperty.setOrderId(getOrderId());
/* 477 */     argItemModifierProperty.setSequence(getSequence());
/* 478 */     if (argItemModifierProperty instanceof IDataModelImpl) {
/* 479 */       IDataAccessObject childDao = ((IDataModelImpl)argItemModifierProperty).getDAO();
/* 480 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 481 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 482 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 487 */     if (postEventsForChanges()) {
/* 488 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemModifierProperty));
/*     */     }
/*     */     
/* 491 */     this._properties.add(argItemModifierProperty);
/* 492 */     if (postEventsForChanges()) {
/* 493 */       this._events.post(IItemModifier.ADD_PROPERTIES, argItemModifierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemModifierProperty(IItemModifierProperty argItemModifierProperty) {
/* 498 */     if (this._properties != null) {
/*     */       
/* 500 */       if (postEventsForChanges()) {
/* 501 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemModifierProperty));
/*     */       }
/* 503 */       this._properties.remove(argItemModifierProperty);
/* 504 */       if (postEventsForChanges()) {
/* 505 */         this._events.post(IItemModifier.REMOVE_PROPERTIES, argItemModifierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 512 */     if ("Properties".equals(argFieldId)) {
/* 513 */       return getProperties();
/*     */     }
/* 515 */     if ("ItemModifierExtension".equals(argFieldId)) {
/* 516 */       return this._myExtension;
/*     */     }
/*     */     
/* 519 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 525 */     if ("Properties".equals(argFieldId)) {
/* 526 */       setProperties(changeToList(argValue, IItemModifierProperty.class));
/*     */     }
/* 528 */     else if ("ItemModifierExtension".equals(argFieldId)) {
/* 529 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 532 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 538 */     this._persistenceDefaults = argPD;
/* 539 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 540 */     this._eventManager = argEM;
/* 541 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 542 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 543 */     if (this._properties != null) {
/* 544 */       for (IItemModifierProperty relationship : this._properties) {
/* 545 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemModifierExt() {
/* 551 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemModifierExt(IDataModel argExt) {
/* 555 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 560 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 564 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 567 */     super.startTransaction();
/*     */     
/* 569 */     this._propertiesSavepoint = this._properties;
/* 570 */     if (this._properties != null) {
/* 571 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 572 */       Iterator<IDataModel> it = this._properties.iterator();
/* 573 */       while (it.hasNext()) {
/* 574 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 579 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 584 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 587 */     super.rollbackChanges();
/*     */     
/* 589 */     this._properties = this._propertiesSavepoint;
/* 590 */     this._propertiesSavepoint = null;
/* 591 */     if (this._properties != null) {
/* 592 */       Iterator<IDataModel> it = this._properties.iterator();
/* 593 */       while (it.hasNext()) {
/* 594 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 602 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 605 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 608 */     super.commitTransaction();
/*     */     
/* 610 */     this._propertiesSavepoint = this._properties;
/* 611 */     if (this._properties != null) {
/* 612 */       Iterator<IDataModel> it = this._properties.iterator();
/* 613 */       while (it.hasNext()) {
/* 614 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 616 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 620 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 625 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\ItemModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */