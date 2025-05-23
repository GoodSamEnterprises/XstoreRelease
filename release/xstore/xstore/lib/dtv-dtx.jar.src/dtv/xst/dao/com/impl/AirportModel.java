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
/*     */ import dtv.xst.dao.com.AirportPropertyId;
/*     */ import dtv.xst.dao.com.IAirport;
/*     */ import dtv.xst.dao.com.IAirportProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class AirportModel extends AbstractDataModelWithPropertyImpl<IAirportProperty> implements IAirport {
/*     */   private static final long serialVersionUID = 672986283L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IAirportProperty> _properties; private transient HistoricalList<IAirportProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new AirportDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private AirportDAO getDAO_() {
/*  46 */     return (AirportDAO)this._daoImpl;
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
/*  70 */       this._events.post(IAirport.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<AirportPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((AirportPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getAirportCode() {
/* 101 */     return getDAO_().getAirportCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAirportCode(String argAirportCode) {
/* 109 */     if (setAirportCode_noev(argAirportCode) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IAirport.SET_AIRPORTCODE, argAirportCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAirportCode_noev(String argAirportCode) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getAirportCode() == null && argAirportCode != null) || (
/* 122 */       getDAO_().getAirportCode() != null && !getDAO_().getAirportCode().equals(argAirportCode))) {
/* 123 */       getDAO_().setAirportCode(argAirportCode);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<AirportPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((AirportPropertyModel)it.next()).setAirportCode_noev(argAirportCode);
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
/*     */   public Date getCreateDate() {
/* 143 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 151 */     if (setCreateDate_noev(argCreateDate) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IAirport.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 164 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 165 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 177 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 185 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 186 */       this._events != null && 
/* 187 */       postEventsForChanges()) {
/* 188 */       this._events.post(IAirport.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 195 */     boolean ev_postable = false;
/*     */     
/* 197 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 198 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 199 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 211 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 219 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 220 */       this._events != null && 
/* 221 */       postEventsForChanges()) {
/* 222 */       this._events.post(IAirport.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 229 */     boolean ev_postable = false;
/*     */     
/* 231 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 232 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 233 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 245 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 253 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 254 */       this._events != null && 
/* 255 */       postEventsForChanges()) {
/* 256 */       this._events.post(IAirport.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 263 */     boolean ev_postable = false;
/*     */     
/* 265 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 266 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 267 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public String getZoneId() {
/* 279 */     return getDAO_().getZoneId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setZoneId(String argZoneId) {
/* 287 */     if (setZoneId_noev(argZoneId) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(IAirport.SET_ZONEID, argZoneId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setZoneId_noev(String argZoneId) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getZoneId() == null && argZoneId != null) || (
/* 300 */       getDAO_().getZoneId() != null && !getDAO_().getZoneId().equals(argZoneId))) {
/* 301 */       getDAO_().setZoneId(argZoneId);
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
/*     */   public String getAirportName() {
/* 313 */     return getDAO_().getAirportName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAirportName(String argAirportName) {
/* 321 */     if (setAirportName_noev(argAirportName) && 
/* 322 */       this._events != null && 
/* 323 */       postEventsForChanges()) {
/* 324 */       this._events.post(IAirport.SET_AIRPORTNAME, argAirportName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAirportName_noev(String argAirportName) {
/* 331 */     boolean ev_postable = false;
/*     */     
/* 333 */     if ((getDAO_().getAirportName() == null && argAirportName != null) || (
/* 334 */       getDAO_().getAirportName() != null && !getDAO_().getAirportName().equals(argAirportName))) {
/* 335 */       getDAO_().setAirportName(argAirportName);
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
/*     */   public String getCountryCode() {
/* 347 */     return getDAO_().getCountryCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountryCode(String argCountryCode) {
/* 355 */     if (setCountryCode_noev(argCountryCode) && 
/* 356 */       this._events != null && 
/* 357 */       postEventsForChanges()) {
/* 358 */       this._events.post(IAirport.SET_COUNTRYCODE, argCountryCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCountryCode_noev(String argCountryCode) {
/* 365 */     boolean ev_postable = false;
/*     */     
/* 367 */     if ((getDAO_().getCountryCode() == null && argCountryCode != null) || (
/* 368 */       getDAO_().getCountryCode() != null && !getDAO_().getCountryCode().equals(argCountryCode))) {
/* 369 */       getDAO_().setCountryCode(argCountryCode);
/* 370 */       ev_postable = true;
/*     */     } 
/*     */     
/* 373 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IAirportProperty newProperty(String argPropertyName) {
/* 377 */     AirportPropertyId id = new AirportPropertyId();
/*     */     
/* 379 */     id.setAirportCode(getAirportCode());
/* 380 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 382 */     IAirportProperty prop = (IAirportProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IAirportProperty.class);
/* 383 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IAirportProperty> getProperties() {
/* 392 */     if (this._properties == null) {
/* 393 */       this._properties = new HistoricalList(null);
/*     */     }
/* 395 */     return (List<IAirportProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IAirportProperty> argProperties) {
/* 399 */     if (this._properties == null) {
/* 400 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 402 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 405 */     for (IAirportProperty child : this._properties) {
/* 406 */       AirportPropertyModel model = (AirportPropertyModel)child;
/* 407 */       model.setOrganizationId_noev(getOrganizationId());
/* 408 */       model.setAirportCode_noev(getAirportCode());
/* 409 */       if (child instanceof IDataModelImpl) {
/* 410 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 411 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 412 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 413 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 416 */       if (postEventsForChanges()) {
/* 417 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addAirportProperty(IAirportProperty argAirportProperty) {
/* 423 */     if (this._properties == null) {
/* 424 */       this._properties = new HistoricalList(null);
/*     */     }
/* 426 */     argAirportProperty.setOrganizationId(getOrganizationId());
/* 427 */     argAirportProperty.setAirportCode(getAirportCode());
/* 428 */     if (argAirportProperty instanceof IDataModelImpl) {
/* 429 */       IDataAccessObject childDao = ((IDataModelImpl)argAirportProperty).getDAO();
/* 430 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 431 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 432 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 437 */     if (postEventsForChanges()) {
/* 438 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAirportProperty));
/*     */     }
/*     */     
/* 441 */     this._properties.add(argAirportProperty);
/* 442 */     if (postEventsForChanges()) {
/* 443 */       this._events.post(IAirport.ADD_PROPERTIES, argAirportProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeAirportProperty(IAirportProperty argAirportProperty) {
/* 448 */     if (this._properties != null) {
/*     */       
/* 450 */       if (postEventsForChanges()) {
/* 451 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAirportProperty));
/*     */       }
/* 453 */       this._properties.remove(argAirportProperty);
/* 454 */       if (postEventsForChanges()) {
/* 455 */         this._events.post(IAirport.REMOVE_PROPERTIES, argAirportProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 462 */     if ("Properties".equals(argFieldId)) {
/* 463 */       return getProperties();
/*     */     }
/* 465 */     if ("AirportExtension".equals(argFieldId)) {
/* 466 */       return this._myExtension;
/*     */     }
/*     */     
/* 469 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 475 */     if ("Properties".equals(argFieldId)) {
/* 476 */       setProperties(changeToList(argValue, IAirportProperty.class));
/*     */     }
/* 478 */     else if ("AirportExtension".equals(argFieldId)) {
/* 479 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 482 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 488 */     this._persistenceDefaults = argPD;
/* 489 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 490 */     this._eventManager = argEM;
/* 491 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 492 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 493 */     if (this._properties != null) {
/* 494 */       for (IAirportProperty relationship : this._properties) {
/* 495 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getAirportExt() {
/* 501 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setAirportExt(IDataModel argExt) {
/* 505 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 510 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 514 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 517 */     super.startTransaction();
/*     */     
/* 519 */     this._propertiesSavepoint = this._properties;
/* 520 */     if (this._properties != null) {
/* 521 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 522 */       Iterator<IDataModel> it = this._properties.iterator();
/* 523 */       while (it.hasNext()) {
/* 524 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 529 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 534 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 537 */     super.rollbackChanges();
/*     */     
/* 539 */     this._properties = this._propertiesSavepoint;
/* 540 */     this._propertiesSavepoint = null;
/* 541 */     if (this._properties != null) {
/* 542 */       Iterator<IDataModel> it = this._properties.iterator();
/* 543 */       while (it.hasNext()) {
/* 544 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 552 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 555 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 558 */     super.commitTransaction();
/*     */     
/* 560 */     this._propertiesSavepoint = this._properties;
/* 561 */     if (this._properties != null) {
/* 562 */       Iterator<IDataModel> it = this._properties.iterator();
/* 563 */       while (it.hasNext()) {
/* 564 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 566 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 570 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 575 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AirportModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */