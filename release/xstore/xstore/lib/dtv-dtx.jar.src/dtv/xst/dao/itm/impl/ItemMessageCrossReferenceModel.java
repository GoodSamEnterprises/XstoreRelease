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
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.itm.IItemMessageCrossReference;
/*     */ import dtv.xst.dao.itm.IItemMessageCrossReferenceProperty;
/*     */ import dtv.xst.dao.itm.ItemMessageCrossReferencePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemMessageCrossReferenceModel extends AbstractDataModelWithPropertyImpl<IItemMessageCrossReferenceProperty> implements IItemMessageCrossReference {
/*     */   private static final long serialVersionUID = -1678003873L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IItemMessageCrossReferenceProperty> _properties; private transient HistoricalList<IItemMessageCrossReferenceProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ItemMessageCrossReferenceDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemMessageCrossReferenceDAO getDAO_() {
/*  46 */     return (ItemMessageCrossReferenceDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessageId() {
/*  54 */     return getDAO_().getMessageId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMessageId(String argMessageId) {
/*  62 */     if (setMessageId_noev(argMessageId) && 
/*  63 */       this._events != null && 
/*  64 */       postEventsForChanges()) {
/*  65 */       this._events.post(IItemMessageCrossReference.SET_MESSAGEID, argMessageId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMessageId_noev(String argMessageId) {
/*  72 */     boolean ev_postable = false;
/*     */     
/*  74 */     if ((getDAO_().getMessageId() == null && argMessageId != null) || (
/*  75 */       getDAO_().getMessageId() != null && !getDAO_().getMessageId().equals(argMessageId))) {
/*  76 */       getDAO_().setMessageId(argMessageId);
/*  77 */       ev_postable = true;
/*  78 */       if (this._properties != null) {
/*     */         
/*  80 */         Iterator<ItemMessageCrossReferencePropertyModel> it = this._properties.iterator();
/*  81 */         while (it.hasNext())
/*     */         {
/*  83 */           ((ItemMessageCrossReferencePropertyModel)it.next()).setMessageId_noev(argMessageId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  88 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  96 */     if (getDAO_().getOrganizationId() != null) {
/*  97 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 100 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 109 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IItemMessageCrossReference.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 122 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 123 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<ItemMessageCrossReferencePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((ItemMessageCrossReferencePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getItemId() {
/* 143 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 151 */     if (setItemId_noev(argItemId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IItemMessageCrossReference.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 164 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 165 */       getDAO_().setItemId(argItemId);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<ItemMessageCrossReferencePropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((ItemMessageCrossReferencePropertyModel)it.next()).setItemId_noev(argItemId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 185 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 193 */     if (setOrgCode_noev(argOrgCode) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IItemMessageCrossReference.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 206 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 207 */       getDAO_().setOrgCode(argOrgCode);
/* 208 */       ev_postable = true;
/*     */     } 
/*     */     
/* 211 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 219 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 227 */     if (setOrgValue_noev(argOrgValue) && 
/* 228 */       this._events != null && 
/* 229 */       postEventsForChanges()) {
/* 230 */       this._events.post(IItemMessageCrossReference.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 237 */     boolean ev_postable = false;
/*     */     
/* 239 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 240 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 241 */       getDAO_().setOrgValue(argOrgValue);
/* 242 */       ev_postable = true;
/*     */     } 
/*     */     
/* 245 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 253 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 261 */     if (setCreateDate_noev(argCreateDate) && 
/* 262 */       this._events != null && 
/* 263 */       postEventsForChanges()) {
/* 264 */       this._events.post(IItemMessageCrossReference.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 271 */     boolean ev_postable = false;
/*     */     
/* 273 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 274 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 275 */       getDAO_().setCreateDate(argCreateDate);
/* 276 */       ev_postable = true;
/*     */     } 
/*     */     
/* 279 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 287 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 295 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(IItemMessageCrossReference.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 308 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 309 */       getDAO_().setCreateUserId(argCreateUserId);
/* 310 */       ev_postable = true;
/*     */     } 
/*     */     
/* 313 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 321 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 329 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(IItemMessageCrossReference.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 342 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 343 */       getDAO_().setUpdateDate(argUpdateDate);
/* 344 */       ev_postable = true;
/*     */     } 
/*     */     
/* 347 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 355 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 363 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 364 */       this._events != null && 
/* 365 */       postEventsForChanges()) {
/* 366 */       this._events.post(IItemMessageCrossReference.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 373 */     boolean ev_postable = false;
/*     */     
/* 375 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 376 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 377 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 378 */       ev_postable = true;
/*     */     } 
/*     */     
/* 381 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemMessageCrossReferenceProperty newProperty(String argPropertyName) {
/* 385 */     ItemMessageCrossReferencePropertyId id = new ItemMessageCrossReferencePropertyId();
/*     */     
/* 387 */     id.setMessageId(getMessageId());
/* 388 */     id.setItemId(getItemId());
/* 389 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 391 */     IItemMessageCrossReferenceProperty prop = (IItemMessageCrossReferenceProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemMessageCrossReferenceProperty.class);
/* 392 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemMessageCrossReferenceProperty> getProperties() {
/* 401 */     if (this._properties == null) {
/* 402 */       this._properties = new HistoricalList(null);
/*     */     }
/* 404 */     return (List<IItemMessageCrossReferenceProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemMessageCrossReferenceProperty> argProperties) {
/* 408 */     if (this._properties == null) {
/* 409 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 411 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 414 */     for (IItemMessageCrossReferenceProperty child : this._properties) {
/* 415 */       ItemMessageCrossReferencePropertyModel model = (ItemMessageCrossReferencePropertyModel)child;
/* 416 */       model.setMessageId_noev(getMessageId());
/* 417 */       model.setOrganizationId_noev(getOrganizationId());
/* 418 */       model.setItemId_noev(getItemId());
/* 419 */       if (child instanceof IDataModelImpl) {
/* 420 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 421 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 422 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 423 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 426 */       if (postEventsForChanges()) {
/* 427 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemMessageCrossReferenceProperty(IItemMessageCrossReferenceProperty argItemMessageCrossReferenceProperty) {
/* 433 */     if (this._properties == null) {
/* 434 */       this._properties = new HistoricalList(null);
/*     */     }
/* 436 */     argItemMessageCrossReferenceProperty.setMessageId(getMessageId());
/* 437 */     argItemMessageCrossReferenceProperty.setOrganizationId(getOrganizationId());
/* 438 */     argItemMessageCrossReferenceProperty.setItemId(getItemId());
/* 439 */     if (argItemMessageCrossReferenceProperty instanceof IDataModelImpl) {
/* 440 */       IDataAccessObject childDao = ((IDataModelImpl)argItemMessageCrossReferenceProperty).getDAO();
/* 441 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 442 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 443 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 448 */     if (postEventsForChanges()) {
/* 449 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemMessageCrossReferenceProperty));
/*     */     }
/*     */     
/* 452 */     this._properties.add(argItemMessageCrossReferenceProperty);
/* 453 */     if (postEventsForChanges()) {
/* 454 */       this._events.post(IItemMessageCrossReference.ADD_PROPERTIES, argItemMessageCrossReferenceProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemMessageCrossReferenceProperty(IItemMessageCrossReferenceProperty argItemMessageCrossReferenceProperty) {
/* 459 */     if (this._properties != null) {
/*     */       
/* 461 */       if (postEventsForChanges()) {
/* 462 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemMessageCrossReferenceProperty));
/*     */       }
/* 464 */       this._properties.remove(argItemMessageCrossReferenceProperty);
/* 465 */       if (postEventsForChanges()) {
/* 466 */         this._events.post(IItemMessageCrossReference.REMOVE_PROPERTIES, argItemMessageCrossReferenceProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 473 */     if ("Properties".equals(argFieldId)) {
/* 474 */       return getProperties();
/*     */     }
/* 476 */     if ("ItemMessageCrossReferenceExtension".equals(argFieldId)) {
/* 477 */       return this._myExtension;
/*     */     }
/*     */     
/* 480 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 486 */     if ("Properties".equals(argFieldId)) {
/* 487 */       setProperties(changeToList(argValue, IItemMessageCrossReferenceProperty.class));
/*     */     }
/* 489 */     else if ("ItemMessageCrossReferenceExtension".equals(argFieldId)) {
/* 490 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 493 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 499 */     this._persistenceDefaults = argPD;
/* 500 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 501 */     this._eventManager = argEM;
/* 502 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 503 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 504 */     if (this._properties != null) {
/* 505 */       for (IItemMessageCrossReferenceProperty relationship : this._properties) {
/* 506 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemMessageCrossReferenceExt() {
/* 512 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemMessageCrossReferenceExt(IDataModel argExt) {
/* 516 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 521 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 525 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 528 */     super.startTransaction();
/*     */     
/* 530 */     this._propertiesSavepoint = this._properties;
/* 531 */     if (this._properties != null) {
/* 532 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 533 */       Iterator<IDataModel> it = this._properties.iterator();
/* 534 */       while (it.hasNext()) {
/* 535 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 540 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 545 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 548 */     super.rollbackChanges();
/*     */     
/* 550 */     this._properties = this._propertiesSavepoint;
/* 551 */     this._propertiesSavepoint = null;
/* 552 */     if (this._properties != null) {
/* 553 */       Iterator<IDataModel> it = this._properties.iterator();
/* 554 */       while (it.hasNext()) {
/* 555 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 563 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 566 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 569 */     super.commitTransaction();
/*     */     
/* 571 */     this._propertiesSavepoint = this._properties;
/* 572 */     if (this._properties != null) {
/* 573 */       Iterator<IDataModel> it = this._properties.iterator();
/* 574 */       while (it.hasNext()) {
/* 575 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 577 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 581 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 586 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemMessageCrossReferenceModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */