/*     */ package dtv.xst.dao.prc.impl;
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
/*     */ import dtv.xst.dao.prc.DealTriggerPropertyId;
/*     */ import dtv.xst.dao.prc.IDealTrigger;
/*     */ import dtv.xst.dao.prc.IDealTriggerProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DealTriggerModel extends AbstractDataModelWithPropertyImpl<IDealTriggerProperty> implements IDealTrigger {
/*     */   private static final long serialVersionUID = 313657228L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IDealTriggerProperty> _properties; private transient HistoricalList<IDealTriggerProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new DealTriggerDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DealTriggerDAO getDAO_() {
/*  46 */     return (DealTriggerDAO)this._daoImpl;
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
/*  70 */       this._events.post(IDealTrigger.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<DealTriggerPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((DealTriggerPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getDealId() {
/* 101 */     return getDAO_().getDealId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDealId(String argDealId) {
/* 109 */     if (setDealId_noev(argDealId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IDealTrigger.SET_DEALID, argDealId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDealId_noev(String argDealId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getDealId() == null && argDealId != null) || (
/* 122 */       getDAO_().getDealId() != null && !getDAO_().getDealId().equals(argDealId))) {
/* 123 */       getDAO_().setDealId(argDealId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<DealTriggerPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((DealTriggerPropertyModel)it.next()).setDealId_noev(argDealId);
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
/*     */   public String getTrigger() {
/* 143 */     return getDAO_().getTrigger();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTrigger(String argTrigger) {
/* 151 */     if (setTrigger_noev(argTrigger) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IDealTrigger.SET_TRIGGER, argTrigger);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTrigger_noev(String argTrigger) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getTrigger() == null && argTrigger != null) || (
/* 164 */       getDAO_().getTrigger() != null && !getDAO_().getTrigger().equals(argTrigger))) {
/* 165 */       getDAO_().setTrigger(argTrigger);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<DealTriggerPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((DealTriggerPropertyModel)it.next()).setTrigger_noev(argTrigger);
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
/* 196 */       this._events.post(IDealTrigger.SET_ORGCODE, argOrgCode);
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
/* 230 */       this._events.post(IDealTrigger.SET_ORGVALUE, argOrgValue);
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
/* 264 */       this._events.post(IDealTrigger.SET_CREATEDATE, argCreateDate);
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
/* 298 */       this._events.post(IDealTrigger.SET_CREATEUSERID, argCreateUserId);
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
/* 332 */       this._events.post(IDealTrigger.SET_UPDATEDATE, argUpdateDate);
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
/* 366 */       this._events.post(IDealTrigger.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   protected IDealTriggerProperty newProperty(String argPropertyName) {
/* 385 */     DealTriggerPropertyId id = new DealTriggerPropertyId();
/*     */     
/* 387 */     id.setDealId(getDealId());
/* 388 */     id.setTrigger(getTrigger());
/* 389 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 391 */     IDealTriggerProperty prop = (IDealTriggerProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDealTriggerProperty.class);
/* 392 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDealTriggerProperty> getProperties() {
/* 401 */     if (this._properties == null) {
/* 402 */       this._properties = new HistoricalList(null);
/*     */     }
/* 404 */     return (List<IDealTriggerProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDealTriggerProperty> argProperties) {
/* 408 */     if (this._properties == null) {
/* 409 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 411 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 414 */     for (IDealTriggerProperty child : this._properties) {
/* 415 */       DealTriggerPropertyModel model = (DealTriggerPropertyModel)child;
/* 416 */       model.setOrganizationId_noev(getOrganizationId());
/* 417 */       model.setDealId_noev(getDealId());
/* 418 */       model.setTrigger_noev(getTrigger());
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
/*     */   public void addDealTriggerProperty(IDealTriggerProperty argDealTriggerProperty) {
/* 433 */     if (this._properties == null) {
/* 434 */       this._properties = new HistoricalList(null);
/*     */     }
/* 436 */     argDealTriggerProperty.setOrganizationId(getOrganizationId());
/* 437 */     argDealTriggerProperty.setDealId(getDealId());
/* 438 */     argDealTriggerProperty.setTrigger(getTrigger());
/* 439 */     if (argDealTriggerProperty instanceof IDataModelImpl) {
/* 440 */       IDataAccessObject childDao = ((IDataModelImpl)argDealTriggerProperty).getDAO();
/* 441 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 442 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 443 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 448 */     if (postEventsForChanges()) {
/* 449 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealTriggerProperty));
/*     */     }
/*     */     
/* 452 */     this._properties.add(argDealTriggerProperty);
/* 453 */     if (postEventsForChanges()) {
/* 454 */       this._events.post(IDealTrigger.ADD_PROPERTIES, argDealTriggerProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDealTriggerProperty(IDealTriggerProperty argDealTriggerProperty) {
/* 459 */     if (this._properties != null) {
/*     */       
/* 461 */       if (postEventsForChanges()) {
/* 462 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealTriggerProperty));
/*     */       }
/* 464 */       this._properties.remove(argDealTriggerProperty);
/* 465 */       if (postEventsForChanges()) {
/* 466 */         this._events.post(IDealTrigger.REMOVE_PROPERTIES, argDealTriggerProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 473 */     if ("Properties".equals(argFieldId)) {
/* 474 */       return getProperties();
/*     */     }
/* 476 */     if ("DealTriggerExtension".equals(argFieldId)) {
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
/* 487 */       setProperties(changeToList(argValue, IDealTriggerProperty.class));
/*     */     }
/* 489 */     else if ("DealTriggerExtension".equals(argFieldId)) {
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
/* 505 */       for (IDealTriggerProperty relationship : this._properties) {
/* 506 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDealTriggerExt() {
/* 512 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDealTriggerExt(IDataModel argExt) {
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealTriggerModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */