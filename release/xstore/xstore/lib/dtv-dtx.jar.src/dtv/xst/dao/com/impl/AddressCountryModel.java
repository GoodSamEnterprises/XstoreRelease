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
/*     */ import dtv.xst.dao.com.AddressCountryPropertyId;
/*     */ import dtv.xst.dao.com.IAddressCountry;
/*     */ import dtv.xst.dao.com.IAddressCountryProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class AddressCountryModel extends AbstractDataModelWithPropertyImpl<IAddressCountryProperty> implements IAddressCountry {
/*     */   private static final long serialVersionUID = 367625506L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IAddressCountryProperty> _properties; private transient HistoricalList<IAddressCountryProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new AddressCountryDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private AddressCountryDAO getDAO_() {
/*  46 */     return (AddressCountryDAO)this._daoImpl;
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
/*  70 */       this._events.post(IAddressCountry.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<AddressCountryPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((AddressCountryPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getCountryId() {
/* 101 */     return getDAO_().getCountryId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountryId(String argCountryId) {
/* 109 */     if (setCountryId_noev(argCountryId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IAddressCountry.SET_COUNTRYID, argCountryId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCountryId_noev(String argCountryId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getCountryId() == null && argCountryId != null) || (
/* 122 */       getDAO_().getCountryId() != null && !getDAO_().getCountryId().equals(argCountryId))) {
/* 123 */       getDAO_().setCountryId(argCountryId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<AddressCountryPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((AddressCountryPropertyModel)it.next()).setCountryId_noev(argCountryId);
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
/*     */   public String getAddressMode() {
/* 143 */     return getDAO_().getAddressMode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddressMode(String argAddressMode) {
/* 151 */     if (setAddressMode_noev(argAddressMode) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IAddressCountry.SET_ADDRESSMODE, argAddressMode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddressMode_noev(String argAddressMode) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getAddressMode() == null && argAddressMode != null) || (
/* 164 */       getDAO_().getAddressMode() != null && !getDAO_().getAddressMode().equals(argAddressMode))) {
/* 165 */       getDAO_().setAddressMode(argAddressMode);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<AddressCountryPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((AddressCountryPropertyModel)it.next()).setAddressMode_noev(argAddressMode);
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
/* 196 */       this._events.post(IAddressCountry.SET_CREATEDATE, argCreateDate);
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
/* 230 */       this._events.post(IAddressCountry.SET_CREATEUSERID, argCreateUserId);
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
/* 264 */       this._events.post(IAddressCountry.SET_UPDATEDATE, argUpdateDate);
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
/* 298 */       this._events.post(IAddressCountry.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getCountryName() {
/* 321 */     return getDAO_().getCountryName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountryName(String argCountryName) {
/* 329 */     if (setCountryName_noev(argCountryName) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(IAddressCountry.SET_COUNTRYNAME, argCountryName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCountryName_noev(String argCountryName) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getCountryName() == null && argCountryName != null) || (
/* 342 */       getDAO_().getCountryName() != null && !getDAO_().getCountryName().equals(argCountryName))) {
/* 343 */       getDAO_().setCountryName(argCountryName);
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
/*     */   public int getPostalCodeMaxLength() {
/* 355 */     if (getDAO_().getPostalCodeMaxLength() != null) {
/* 356 */       return getDAO_().getPostalCodeMaxLength().intValue();
/*     */     }
/*     */     
/* 359 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPostalCodeMaxLength(int argPostalCodeMaxLength) {
/* 368 */     if (setPostalCodeMaxLength_noev(argPostalCodeMaxLength) && 
/* 369 */       this._events != null && 
/* 370 */       postEventsForChanges()) {
/* 371 */       this._events.post(IAddressCountry.SET_POSTALCODEMAXLENGTH, Integer.valueOf(argPostalCodeMaxLength));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPostalCodeMaxLength_noev(int argPostalCodeMaxLength) {
/* 378 */     boolean ev_postable = false;
/*     */     
/* 380 */     if ((getDAO_().getPostalCodeMaxLength() == null && Integer.valueOf(argPostalCodeMaxLength) != null) || (
/* 381 */       getDAO_().getPostalCodeMaxLength() != null && !getDAO_().getPostalCodeMaxLength().equals(Integer.valueOf(argPostalCodeMaxLength)))) {
/* 382 */       getDAO_().setPostalCodeMaxLength(Integer.valueOf(argPostalCodeMaxLength));
/* 383 */       ev_postable = true;
/*     */     } 
/*     */     
/* 386 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IAddressCountryProperty newProperty(String argPropertyName) {
/* 390 */     AddressCountryPropertyId id = new AddressCountryPropertyId();
/*     */     
/* 392 */     id.setCountryId(getCountryId());
/* 393 */     id.setAddressMode(getAddressMode());
/* 394 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 396 */     IAddressCountryProperty prop = (IAddressCountryProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IAddressCountryProperty.class);
/* 397 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IAddressCountryProperty> getProperties() {
/* 406 */     if (this._properties == null) {
/* 407 */       this._properties = new HistoricalList(null);
/*     */     }
/* 409 */     return (List<IAddressCountryProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IAddressCountryProperty> argProperties) {
/* 413 */     if (this._properties == null) {
/* 414 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 416 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 419 */     for (IAddressCountryProperty child : this._properties) {
/* 420 */       AddressCountryPropertyModel model = (AddressCountryPropertyModel)child;
/* 421 */       model.setOrganizationId_noev(getOrganizationId());
/* 422 */       model.setCountryId_noev(getCountryId());
/* 423 */       model.setAddressMode_noev(getAddressMode());
/* 424 */       if (child instanceof IDataModelImpl) {
/* 425 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 426 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 427 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 428 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 431 */       if (postEventsForChanges()) {
/* 432 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addAddressCountryProperty(IAddressCountryProperty argAddressCountryProperty) {
/* 438 */     if (this._properties == null) {
/* 439 */       this._properties = new HistoricalList(null);
/*     */     }
/* 441 */     argAddressCountryProperty.setOrganizationId(getOrganizationId());
/* 442 */     argAddressCountryProperty.setCountryId(getCountryId());
/* 443 */     argAddressCountryProperty.setAddressMode(getAddressMode());
/* 444 */     if (argAddressCountryProperty instanceof IDataModelImpl) {
/* 445 */       IDataAccessObject childDao = ((IDataModelImpl)argAddressCountryProperty).getDAO();
/* 446 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 447 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 448 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 453 */     if (postEventsForChanges()) {
/* 454 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddressCountryProperty));
/*     */     }
/*     */     
/* 457 */     this._properties.add(argAddressCountryProperty);
/* 458 */     if (postEventsForChanges()) {
/* 459 */       this._events.post(IAddressCountry.ADD_PROPERTIES, argAddressCountryProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeAddressCountryProperty(IAddressCountryProperty argAddressCountryProperty) {
/* 464 */     if (this._properties != null) {
/*     */       
/* 466 */       if (postEventsForChanges()) {
/* 467 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddressCountryProperty));
/*     */       }
/* 469 */       this._properties.remove(argAddressCountryProperty);
/* 470 */       if (postEventsForChanges()) {
/* 471 */         this._events.post(IAddressCountry.REMOVE_PROPERTIES, argAddressCountryProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 478 */     if ("Properties".equals(argFieldId)) {
/* 479 */       return getProperties();
/*     */     }
/* 481 */     if ("AddressCountryExtension".equals(argFieldId)) {
/* 482 */       return this._myExtension;
/*     */     }
/*     */     
/* 485 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 491 */     if ("Properties".equals(argFieldId)) {
/* 492 */       setProperties(changeToList(argValue, IAddressCountryProperty.class));
/*     */     }
/* 494 */     else if ("AddressCountryExtension".equals(argFieldId)) {
/* 495 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 498 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 504 */     this._persistenceDefaults = argPD;
/* 505 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 506 */     this._eventManager = argEM;
/* 507 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 508 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 509 */     if (this._properties != null) {
/* 510 */       for (IAddressCountryProperty relationship : this._properties) {
/* 511 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getAddressCountryExt() {
/* 517 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setAddressCountryExt(IDataModel argExt) {
/* 521 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 526 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 530 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 533 */     super.startTransaction();
/*     */     
/* 535 */     this._propertiesSavepoint = this._properties;
/* 536 */     if (this._properties != null) {
/* 537 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 538 */       Iterator<IDataModel> it = this._properties.iterator();
/* 539 */       while (it.hasNext()) {
/* 540 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 545 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 550 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 553 */     super.rollbackChanges();
/*     */     
/* 555 */     this._properties = this._propertiesSavepoint;
/* 556 */     this._propertiesSavepoint = null;
/* 557 */     if (this._properties != null) {
/* 558 */       Iterator<IDataModel> it = this._properties.iterator();
/* 559 */       while (it.hasNext()) {
/* 560 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 568 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 571 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 574 */     super.commitTransaction();
/*     */     
/* 576 */     this._propertiesSavepoint = this._properties;
/* 577 */     if (this._properties != null) {
/* 578 */       Iterator<IDataModel> it = this._properties.iterator();
/* 579 */       while (it.hasNext()) {
/* 580 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 582 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 586 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 591 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AddressCountryModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */