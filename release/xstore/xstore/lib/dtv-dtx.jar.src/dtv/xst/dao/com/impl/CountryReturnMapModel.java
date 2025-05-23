/*     */ package dtv.xst.dao.com.impl;
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
/*     */ import dtv.xst.dao.com.CountryReturnMapPropertyId;
/*     */ import dtv.xst.dao.com.ICountryReturnMap;
/*     */ import dtv.xst.dao.com.ICountryReturnMapProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CountryReturnMapModel extends AbstractDataModelWithPropertyImpl<ICountryReturnMapProperty> implements ICountryReturnMap {
/*     */   private static final long serialVersionUID = 926734134L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ICountryReturnMapProperty> _properties; private transient HistoricalList<ICountryReturnMapProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new CountryReturnMapDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CountryReturnMapDAO getDAO_() {
/*  46 */     return (CountryReturnMapDAO)this._daoImpl;
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
/*  70 */       this._events.post(ICountryReturnMap.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<CountryReturnMapPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((CountryReturnMapPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getPurchasedFrom() {
/* 101 */     return getDAO_().getPurchasedFrom();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPurchasedFrom(String argPurchasedFrom) {
/* 109 */     if (setPurchasedFrom_noev(argPurchasedFrom) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(ICountryReturnMap.SET_PURCHASEDFROM, argPurchasedFrom);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPurchasedFrom_noev(String argPurchasedFrom) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getPurchasedFrom() == null && argPurchasedFrom != null) || (
/* 122 */       getDAO_().getPurchasedFrom() != null && !getDAO_().getPurchasedFrom().equals(argPurchasedFrom))) {
/* 123 */       getDAO_().setPurchasedFrom(argPurchasedFrom);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<CountryReturnMapPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((CountryReturnMapPropertyModel)it.next()).setPurchasedFrom_noev(argPurchasedFrom);
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
/*     */   public String getReturnTo() {
/* 143 */     return getDAO_().getReturnTo();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReturnTo(String argReturnTo) {
/* 151 */     if (setReturnTo_noev(argReturnTo) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(ICountryReturnMap.SET_RETURNTO, argReturnTo);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReturnTo_noev(String argReturnTo) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getReturnTo() == null && argReturnTo != null) || (
/* 164 */       getDAO_().getReturnTo() != null && !getDAO_().getReturnTo().equals(argReturnTo))) {
/* 165 */       getDAO_().setReturnTo(argReturnTo);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<CountryReturnMapPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((CountryReturnMapPropertyModel)it.next()).setReturnTo_noev(argReturnTo);
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
/*     */   public Date getCreateDate() {
/* 185 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 193 */     if (setCreateDate_noev(argCreateDate) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(ICountryReturnMap.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 206 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 207 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 219 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 227 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 228 */       this._events != null && 
/* 229 */       postEventsForChanges()) {
/* 230 */       this._events.post(ICountryReturnMap.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 237 */     boolean ev_postable = false;
/*     */     
/* 239 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 240 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 241 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 253 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 261 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 262 */       this._events != null && 
/* 263 */       postEventsForChanges()) {
/* 264 */       this._events.post(ICountryReturnMap.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 271 */     boolean ev_postable = false;
/*     */     
/* 273 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 274 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 275 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 287 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 295 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(ICountryReturnMap.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 308 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 309 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public boolean getDisallowCrossBorderFlag() {
/* 321 */     if (getDAO_().getDisallowCrossBorderFlag() != null) {
/* 322 */       return getDAO_().getDisallowCrossBorderFlag().booleanValue();
/*     */     }
/*     */     
/* 325 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisallowCrossBorderFlag(boolean argDisallowCrossBorderFlag) {
/* 334 */     if (setDisallowCrossBorderFlag_noev(argDisallowCrossBorderFlag) && 
/* 335 */       this._events != null && 
/* 336 */       postEventsForChanges()) {
/* 337 */       this._events.post(ICountryReturnMap.SET_DISALLOWCROSSBORDERFLAG, Boolean.valueOf(argDisallowCrossBorderFlag));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDisallowCrossBorderFlag_noev(boolean argDisallowCrossBorderFlag) {
/* 344 */     boolean ev_postable = false;
/*     */     
/* 346 */     if ((getDAO_().getDisallowCrossBorderFlag() == null && Boolean.valueOf(argDisallowCrossBorderFlag) != null) || (
/* 347 */       getDAO_().getDisallowCrossBorderFlag() != null && !getDAO_().getDisallowCrossBorderFlag().equals(Boolean.valueOf(argDisallowCrossBorderFlag)))) {
/* 348 */       getDAO_().setDisallowCrossBorderFlag(Boolean.valueOf(argDisallowCrossBorderFlag));
/* 349 */       ev_postable = true;
/*     */     } 
/*     */     
/* 352 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICountryReturnMapProperty newProperty(String argPropertyName) {
/* 356 */     CountryReturnMapPropertyId id = new CountryReturnMapPropertyId();
/*     */     
/* 358 */     id.setPurchasedFrom(getPurchasedFrom());
/* 359 */     id.setReturnTo(getReturnTo());
/* 360 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 362 */     ICountryReturnMapProperty prop = (ICountryReturnMapProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICountryReturnMapProperty.class);
/* 363 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICountryReturnMapProperty> getProperties() {
/* 372 */     if (this._properties == null) {
/* 373 */       this._properties = new HistoricalList(null);
/*     */     }
/* 375 */     return (List<ICountryReturnMapProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICountryReturnMapProperty> argProperties) {
/* 379 */     if (this._properties == null) {
/* 380 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 382 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 385 */     for (ICountryReturnMapProperty child : this._properties) {
/* 386 */       CountryReturnMapPropertyModel model = (CountryReturnMapPropertyModel)child;
/* 387 */       model.setOrganizationId_noev(getOrganizationId());
/* 388 */       model.setPurchasedFrom_noev(getPurchasedFrom());
/* 389 */       model.setReturnTo_noev(getReturnTo());
/* 390 */       if (child instanceof IDataModelImpl) {
/* 391 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 392 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 393 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 394 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 397 */       if (postEventsForChanges()) {
/* 398 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCountryReturnMapProperty(ICountryReturnMapProperty argCountryReturnMapProperty) {
/* 404 */     if (this._properties == null) {
/* 405 */       this._properties = new HistoricalList(null);
/*     */     }
/* 407 */     argCountryReturnMapProperty.setOrganizationId(getOrganizationId());
/* 408 */     argCountryReturnMapProperty.setPurchasedFrom(getPurchasedFrom());
/* 409 */     argCountryReturnMapProperty.setReturnTo(getReturnTo());
/* 410 */     if (argCountryReturnMapProperty instanceof IDataModelImpl) {
/* 411 */       IDataAccessObject childDao = ((IDataModelImpl)argCountryReturnMapProperty).getDAO();
/* 412 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 413 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 414 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 419 */     if (postEventsForChanges()) {
/* 420 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCountryReturnMapProperty));
/*     */     }
/*     */     
/* 423 */     this._properties.add(argCountryReturnMapProperty);
/* 424 */     if (postEventsForChanges()) {
/* 425 */       this._events.post(ICountryReturnMap.ADD_PROPERTIES, argCountryReturnMapProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCountryReturnMapProperty(ICountryReturnMapProperty argCountryReturnMapProperty) {
/* 430 */     if (this._properties != null) {
/*     */       
/* 432 */       if (postEventsForChanges()) {
/* 433 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCountryReturnMapProperty));
/*     */       }
/* 435 */       this._properties.remove(argCountryReturnMapProperty);
/* 436 */       if (postEventsForChanges()) {
/* 437 */         this._events.post(ICountryReturnMap.REMOVE_PROPERTIES, argCountryReturnMapProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 444 */     if ("Properties".equals(argFieldId)) {
/* 445 */       return getProperties();
/*     */     }
/* 447 */     if ("CountryReturnMapExtension".equals(argFieldId)) {
/* 448 */       return this._myExtension;
/*     */     }
/*     */     
/* 451 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 457 */     if ("Properties".equals(argFieldId)) {
/* 458 */       setProperties(changeToList(argValue, ICountryReturnMapProperty.class));
/*     */     }
/* 460 */     else if ("CountryReturnMapExtension".equals(argFieldId)) {
/* 461 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 464 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 470 */     this._persistenceDefaults = argPD;
/* 471 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 472 */     this._eventManager = argEM;
/* 473 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 474 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 475 */     if (this._properties != null) {
/* 476 */       for (ICountryReturnMapProperty relationship : this._properties) {
/* 477 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCountryReturnMapExt() {
/* 483 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCountryReturnMapExt(IDataModel argExt) {
/* 487 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 492 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 496 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 499 */     super.startTransaction();
/*     */     
/* 501 */     this._propertiesSavepoint = this._properties;
/* 502 */     if (this._properties != null) {
/* 503 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 504 */       Iterator<IDataModel> it = this._properties.iterator();
/* 505 */       while (it.hasNext()) {
/* 506 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 511 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 516 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 519 */     super.rollbackChanges();
/*     */     
/* 521 */     this._properties = this._propertiesSavepoint;
/* 522 */     this._propertiesSavepoint = null;
/* 523 */     if (this._properties != null) {
/* 524 */       Iterator<IDataModel> it = this._properties.iterator();
/* 525 */       while (it.hasNext()) {
/* 526 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 534 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 537 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 540 */     super.commitTransaction();
/*     */     
/* 542 */     this._propertiesSavepoint = this._properties;
/* 543 */     if (this._properties != null) {
/* 544 */       Iterator<IDataModel> it = this._properties.iterator();
/* 545 */       while (it.hasNext()) {
/* 546 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 548 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 552 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 557 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\CountryReturnMapModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */