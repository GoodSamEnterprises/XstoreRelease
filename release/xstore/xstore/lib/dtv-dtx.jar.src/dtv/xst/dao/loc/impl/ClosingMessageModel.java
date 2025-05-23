/*     */ package dtv.xst.dao.loc.impl;
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
/*     */ import dtv.xst.dao.loc.ClosingMessagePropertyId;
/*     */ import dtv.xst.dao.loc.IClosingMessage;
/*     */ import dtv.xst.dao.loc.IClosingMessageProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ClosingMessageModel extends AbstractDataModelWithPropertyImpl<IClosingMessageProperty> implements IClosingMessage {
/*     */   private static final long serialVersionUID = 1146700210L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IClosingMessageProperty> _properties; private transient HistoricalList<IClosingMessageProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ClosingMessageDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ClosingMessageDAO getDAO_() {
/*  46 */     return (ClosingMessageDAO)this._daoImpl;
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
/*  70 */       this._events.post(IClosingMessage.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ClosingMessagePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ClosingMessagePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(IClosingMessage.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 132 */         Iterator<ClosingMessagePropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((ClosingMessagePropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public Date getCreateDate() {
/* 148 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 156 */     if (setCreateDate_noev(argCreateDate) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IClosingMessage.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 169 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 170 */       getDAO_().setCreateDate(argCreateDate);
/* 171 */       ev_postable = true;
/*     */     } 
/*     */     
/* 174 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 182 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 190 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 191 */       this._events != null && 
/* 192 */       postEventsForChanges()) {
/* 193 */       this._events.post(IClosingMessage.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 200 */     boolean ev_postable = false;
/*     */     
/* 202 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 203 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 204 */       getDAO_().setCreateUserId(argCreateUserId);
/* 205 */       ev_postable = true;
/*     */     } 
/*     */     
/* 208 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 216 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 224 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 225 */       this._events != null && 
/* 226 */       postEventsForChanges()) {
/* 227 */       this._events.post(IClosingMessage.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 234 */     boolean ev_postable = false;
/*     */     
/* 236 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 237 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 238 */       getDAO_().setUpdateDate(argUpdateDate);
/* 239 */       ev_postable = true;
/*     */     } 
/*     */     
/* 242 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 250 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 258 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 259 */       this._events != null && 
/* 260 */       postEventsForChanges()) {
/* 261 */       this._events.post(IClosingMessage.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 268 */     boolean ev_postable = false;
/*     */     
/* 270 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 271 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 272 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 273 */       ev_postable = true;
/*     */     } 
/*     */     
/* 276 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getClosingMessage() {
/* 284 */     return getDAO_().getClosingMessage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClosingMessage(String argClosingMessage) {
/* 292 */     if (setClosingMessage_noev(argClosingMessage) && 
/* 293 */       this._events != null && 
/* 294 */       postEventsForChanges()) {
/* 295 */       this._events.post(IClosingMessage.SET_CLOSINGMESSAGE, argClosingMessage);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setClosingMessage_noev(String argClosingMessage) {
/* 302 */     boolean ev_postable = false;
/*     */     
/* 304 */     if ((getDAO_().getClosingMessage() == null && argClosingMessage != null) || (
/* 305 */       getDAO_().getClosingMessage() != null && !getDAO_().getClosingMessage().equals(argClosingMessage))) {
/* 306 */       getDAO_().setClosingMessage(argClosingMessage);
/* 307 */       ev_postable = true;
/*     */     } 
/*     */     
/* 310 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IClosingMessageProperty newProperty(String argPropertyName) {
/* 314 */     ClosingMessagePropertyId id = new ClosingMessagePropertyId();
/*     */     
/* 316 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 317 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 319 */     IClosingMessageProperty prop = (IClosingMessageProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IClosingMessageProperty.class);
/* 320 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IClosingMessageProperty> getProperties() {
/* 329 */     if (this._properties == null) {
/* 330 */       this._properties = new HistoricalList(null);
/*     */     }
/* 332 */     return (List<IClosingMessageProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IClosingMessageProperty> argProperties) {
/* 336 */     if (this._properties == null) {
/* 337 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 339 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 342 */     for (IClosingMessageProperty child : this._properties) {
/* 343 */       ClosingMessagePropertyModel model = (ClosingMessagePropertyModel)child;
/* 344 */       model.setOrganizationId_noev(getOrganizationId());
/* 345 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 346 */       if (child instanceof IDataModelImpl) {
/* 347 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 348 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 349 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 350 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 353 */       if (postEventsForChanges()) {
/* 354 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addClosingMessageProperty(IClosingMessageProperty argClosingMessageProperty) {
/* 360 */     if (this._properties == null) {
/* 361 */       this._properties = new HistoricalList(null);
/*     */     }
/* 363 */     argClosingMessageProperty.setOrganizationId(getOrganizationId());
/* 364 */     argClosingMessageProperty.setRetailLocationId(getRetailLocationId());
/* 365 */     if (argClosingMessageProperty instanceof IDataModelImpl) {
/* 366 */       IDataAccessObject childDao = ((IDataModelImpl)argClosingMessageProperty).getDAO();
/* 367 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 368 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 369 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 374 */     if (postEventsForChanges()) {
/* 375 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argClosingMessageProperty));
/*     */     }
/*     */     
/* 378 */     this._properties.add(argClosingMessageProperty);
/* 379 */     if (postEventsForChanges()) {
/* 380 */       this._events.post(IClosingMessage.ADD_PROPERTIES, argClosingMessageProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeClosingMessageProperty(IClosingMessageProperty argClosingMessageProperty) {
/* 385 */     if (this._properties != null) {
/*     */       
/* 387 */       if (postEventsForChanges()) {
/* 388 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argClosingMessageProperty));
/*     */       }
/* 390 */       this._properties.remove(argClosingMessageProperty);
/* 391 */       if (postEventsForChanges()) {
/* 392 */         this._events.post(IClosingMessage.REMOVE_PROPERTIES, argClosingMessageProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 399 */     if ("Properties".equals(argFieldId)) {
/* 400 */       return getProperties();
/*     */     }
/* 402 */     if ("ClosingMessageExtension".equals(argFieldId)) {
/* 403 */       return this._myExtension;
/*     */     }
/*     */     
/* 406 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 412 */     if ("Properties".equals(argFieldId)) {
/* 413 */       setProperties(changeToList(argValue, IClosingMessageProperty.class));
/*     */     }
/* 415 */     else if ("ClosingMessageExtension".equals(argFieldId)) {
/* 416 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 419 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 425 */     this._persistenceDefaults = argPD;
/* 426 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 427 */     this._eventManager = argEM;
/* 428 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 429 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 430 */     if (this._properties != null) {
/* 431 */       for (IClosingMessageProperty relationship : this._properties) {
/* 432 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getClosingMessageExt() {
/* 438 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setClosingMessageExt(IDataModel argExt) {
/* 442 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 447 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 451 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 454 */     super.startTransaction();
/*     */     
/* 456 */     this._propertiesSavepoint = this._properties;
/* 457 */     if (this._properties != null) {
/* 458 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 459 */       Iterator<IDataModel> it = this._properties.iterator();
/* 460 */       while (it.hasNext()) {
/* 461 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 466 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 471 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 474 */     super.rollbackChanges();
/*     */     
/* 476 */     this._properties = this._propertiesSavepoint;
/* 477 */     this._propertiesSavepoint = null;
/* 478 */     if (this._properties != null) {
/* 479 */       Iterator<IDataModel> it = this._properties.iterator();
/* 480 */       while (it.hasNext()) {
/* 481 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 489 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 492 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 495 */     super.commitTransaction();
/*     */     
/* 497 */     this._propertiesSavepoint = this._properties;
/* 498 */     if (this._properties != null) {
/* 499 */       Iterator<IDataModel> it = this._properties.iterator();
/* 500 */       while (it.hasNext()) {
/* 501 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 503 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 507 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 512 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\ClosingMessageModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */