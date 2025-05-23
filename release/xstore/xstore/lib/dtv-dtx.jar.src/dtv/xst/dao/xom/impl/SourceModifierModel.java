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
/*     */ import dtv.util.address.IAddress;
/*     */ import dtv.xst.dao.xom.IAddressModifier;
/*     */ import dtv.xst.dao.xom.IOrderLine;
/*     */ import dtv.xst.dao.xom.ISourceModifier;
/*     */ import dtv.xst.dao.xom.ISourceModifierProperty;
/*     */ import dtv.xst.dao.xom.SourceModifierPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SourceModifierModel extends AbstractDataModelWithPropertyImpl<ISourceModifierProperty> implements ISourceModifier {
/*     */   private static final long serialVersionUID = 1313951794L;
/*     */   private IOrderLine _parentLine;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private IAddressModifier _address; private transient IAddressModifier _addressSavepoint; private HistoricalList<ISourceModifierProperty> _properties; private transient HistoricalList<ISourceModifierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new SourceModifierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SourceModifierDAO getDAO_() {
/*  49 */     return (SourceModifierDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  57 */     if (getDAO_().getOrganizationId() != null) {
/*  58 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  61 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  70 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  71 */       this._events != null && 
/*  72 */       postEventsForChanges()) {
/*  73 */       this._events.post(ISourceModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  80 */     boolean ev_postable = false;
/*     */     
/*  82 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  83 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  84 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  85 */       ev_postable = true;
/*  86 */       if (this._properties != null) {
/*     */         
/*  88 */         Iterator<SourceModifierPropertyModel> it = this._properties.iterator();
/*  89 */         while (it.hasNext())
/*     */         {
/*  91 */           ((SourceModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrderId() {
/* 104 */     return getDAO_().getOrderId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/* 112 */     if (setOrderId_noev(argOrderId) && 
/* 113 */       this._events != null && 
/* 114 */       postEventsForChanges()) {
/* 115 */       this._events.post(ISourceModifier.SET_ORDERID, argOrderId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrderId_noev(String argOrderId) {
/* 122 */     boolean ev_postable = false;
/*     */     
/* 124 */     if ((getDAO_().getOrderId() == null && argOrderId != null) || (
/* 125 */       getDAO_().getOrderId() != null && !getDAO_().getOrderId().equals(argOrderId))) {
/* 126 */       getDAO_().setOrderId(argOrderId);
/* 127 */       ev_postable = true;
/* 128 */       if (this._properties != null) {
/*     */         
/* 130 */         Iterator<SourceModifierPropertyModel> it = this._properties.iterator();
/* 131 */         while (it.hasNext())
/*     */         {
/* 133 */           ((SourceModifierPropertyModel)it.next()).setOrderId_noev(argOrderId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 138 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSequence() {
/* 146 */     if (getDAO_().getSequence() != null) {
/* 147 */       return getDAO_().getSequence().intValue();
/*     */     }
/*     */     
/* 150 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequence(int argSequence) {
/* 159 */     if (setSequence_noev(argSequence) && 
/* 160 */       this._events != null && 
/* 161 */       postEventsForChanges()) {
/* 162 */       this._events.post(ISourceModifier.SET_SEQUENCE, Integer.valueOf(argSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequence_noev(int argSequence) {
/* 169 */     boolean ev_postable = false;
/*     */     
/* 171 */     if ((getDAO_().getSequence() == null && Integer.valueOf(argSequence) != null) || (
/* 172 */       getDAO_().getSequence() != null && !getDAO_().getSequence().equals(Integer.valueOf(argSequence)))) {
/* 173 */       getDAO_().setSequence(Integer.valueOf(argSequence));
/* 174 */       ev_postable = true;
/* 175 */       if (this._properties != null) {
/*     */         
/* 177 */         Iterator<SourceModifierPropertyModel> it = this._properties.iterator();
/* 178 */         while (it.hasNext())
/*     */         {
/* 180 */           ((SourceModifierPropertyModel)it.next()).setSequence_noev(argSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 185 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 193 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 201 */     if (setCreateDate_noev(argCreateDate) && 
/* 202 */       this._events != null && 
/* 203 */       postEventsForChanges()) {
/* 204 */       this._events.post(ISourceModifier.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 211 */     boolean ev_postable = false;
/*     */     
/* 213 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 214 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 215 */       getDAO_().setCreateDate(argCreateDate);
/* 216 */       ev_postable = true;
/*     */     } 
/*     */     
/* 219 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 227 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 235 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(ISourceModifier.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 248 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 249 */       getDAO_().setCreateUserId(argCreateUserId);
/* 250 */       ev_postable = true;
/*     */     } 
/*     */     
/* 253 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 261 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 269 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(ISourceModifier.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 282 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 283 */       getDAO_().setUpdateDate(argUpdateDate);
/* 284 */       ev_postable = true;
/*     */     } 
/*     */     
/* 287 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 295 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 303 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 304 */       this._events != null && 
/* 305 */       postEventsForChanges()) {
/* 306 */       this._events.post(ISourceModifier.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 313 */     boolean ev_postable = false;
/*     */     
/* 315 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 316 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 317 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 318 */       ev_postable = true;
/*     */     } 
/*     */     
/* 321 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocationId() {
/* 329 */     return getDAO_().getLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocationId(String argLocationId) {
/* 337 */     if (setLocationId_noev(argLocationId) && 
/* 338 */       this._events != null && 
/* 339 */       postEventsForChanges()) {
/* 340 */       this._events.post(ISourceModifier.SET_LOCATIONID, argLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLocationId_noev(String argLocationId) {
/* 347 */     boolean ev_postable = false;
/*     */     
/* 349 */     if ((getDAO_().getLocationId() == null && argLocationId != null) || (
/* 350 */       getDAO_().getLocationId() != null && !getDAO_().getLocationId().equals(argLocationId))) {
/* 351 */       getDAO_().setLocationId(argLocationId);
/* 352 */       ev_postable = true;
/*     */     } 
/*     */     
/* 355 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocationType() {
/* 363 */     return getDAO_().getLocationType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocationType(String argLocationType) {
/* 371 */     if (setLocationType_noev(argLocationType) && 
/* 372 */       this._events != null && 
/* 373 */       postEventsForChanges()) {
/* 374 */       this._events.post(ISourceModifier.SET_LOCATIONTYPE, argLocationType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLocationType_noev(String argLocationType) {
/* 381 */     boolean ev_postable = false;
/*     */     
/* 383 */     if ((getDAO_().getLocationType() == null && argLocationType != null) || (
/* 384 */       getDAO_().getLocationType() != null && !getDAO_().getLocationType().equals(argLocationType))) {
/* 385 */       getDAO_().setLocationType(argLocationType);
/* 386 */       ev_postable = true;
/*     */     } 
/*     */     
/* 389 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocationName1() {
/* 397 */     return getDAO_().getLocationName1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocationName1(String argLocationName1) {
/* 405 */     if (setLocationName1_noev(argLocationName1) && 
/* 406 */       this._events != null && 
/* 407 */       postEventsForChanges()) {
/* 408 */       this._events.post(ISourceModifier.SET_LOCATIONNAME1, argLocationName1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLocationName1_noev(String argLocationName1) {
/* 415 */     boolean ev_postable = false;
/*     */     
/* 417 */     if ((getDAO_().getLocationName1() == null && argLocationName1 != null) || (
/* 418 */       getDAO_().getLocationName1() != null && !getDAO_().getLocationName1().equals(argLocationName1))) {
/* 419 */       getDAO_().setLocationName1(argLocationName1);
/* 420 */       ev_postable = true;
/*     */     } 
/*     */     
/* 423 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocationName2() {
/* 431 */     return getDAO_().getLocationName2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocationName2(String argLocationName2) {
/* 439 */     if (setLocationName2_noev(argLocationName2) && 
/* 440 */       this._events != null && 
/* 441 */       postEventsForChanges()) {
/* 442 */       this._events.post(ISourceModifier.SET_LOCATIONNAME2, argLocationName2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLocationName2_noev(String argLocationName2) {
/* 449 */     boolean ev_postable = false;
/*     */     
/* 451 */     if ((getDAO_().getLocationName2() == null && argLocationName2 != null) || (
/* 452 */       getDAO_().getLocationName2() != null && !getDAO_().getLocationName2().equals(argLocationName2))) {
/* 453 */       getDAO_().setLocationName2(argLocationName2);
/* 454 */       ev_postable = true;
/*     */     } 
/*     */     
/* 457 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone1() {
/* 465 */     return getDAO_().getTelephone1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone1(String argTelephone1) {
/* 473 */     if (setTelephone1_noev(argTelephone1) && 
/* 474 */       this._events != null && 
/* 475 */       postEventsForChanges()) {
/* 476 */       this._events.post(ISourceModifier.SET_TELEPHONE1, argTelephone1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTelephone1_noev(String argTelephone1) {
/* 483 */     boolean ev_postable = false;
/*     */     
/* 485 */     if ((getDAO_().getTelephone1() == null && argTelephone1 != null) || (
/* 486 */       getDAO_().getTelephone1() != null && !getDAO_().getTelephone1().equals(argTelephone1))) {
/* 487 */       getDAO_().setTelephone1(argTelephone1);
/* 488 */       ev_postable = true;
/*     */     } 
/*     */     
/* 491 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmailAddress() {
/* 499 */     return getDAO_().getEmailAddress();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmailAddress(String argEmailAddress) {
/* 507 */     if (setEmailAddress_noev(argEmailAddress) && 
/* 508 */       this._events != null && 
/* 509 */       postEventsForChanges()) {
/* 510 */       this._events.post(ISourceModifier.SET_EMAILADDRESS, argEmailAddress);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEmailAddress_noev(String argEmailAddress) {
/* 517 */     boolean ev_postable = false;
/*     */     
/* 519 */     if ((getDAO_().getEmailAddress() == null && argEmailAddress != null) || (
/* 520 */       getDAO_().getEmailAddress() != null && !getDAO_().getEmailAddress().equals(argEmailAddress))) {
/* 521 */       getDAO_().setEmailAddress(argEmailAddress);
/* 522 */       ev_postable = true;
/*     */     } 
/*     */     
/* 525 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getAddressSequence() {
/* 533 */     if (getDAO_().getAddressSequence() != null) {
/* 534 */       return getDAO_().getAddressSequence().longValue();
/*     */     }
/*     */     
/* 537 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddressSequence(long argAddressSequence) {
/* 546 */     if (setAddressSequence_noev(argAddressSequence) && 
/* 547 */       this._events != null && 
/* 548 */       postEventsForChanges()) {
/* 549 */       this._events.post(ISourceModifier.SET_ADDRESSSEQUENCE, Long.valueOf(argAddressSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAddressSequence_noev(long argAddressSequence) {
/* 556 */     boolean ev_postable = false;
/*     */     
/* 558 */     if ((getDAO_().getAddressSequence() == null && Long.valueOf(argAddressSequence) != null) || (
/* 559 */       getDAO_().getAddressSequence() != null && !getDAO_().getAddressSequence().equals(Long.valueOf(argAddressSequence)))) {
/* 560 */       getDAO_().setAddressSequence(Long.valueOf(argAddressSequence));
/* 561 */       ev_postable = true;
/*     */     } 
/*     */     
/* 564 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ISourceModifierProperty newProperty(String argPropertyName) {
/* 568 */     SourceModifierPropertyId id = new SourceModifierPropertyId();
/*     */     
/* 570 */     id.setOrderId(getOrderId());
/* 571 */     id.setSequence(Integer.valueOf(getSequence()));
/* 572 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 574 */     ISourceModifierProperty prop = (ISourceModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ISourceModifierProperty.class);
/* 575 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Address")
/*     */   public IAddressModifier getAddress() {
/* 587 */     return this._address;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAddress(IAddressModifier argAddress) {
/* 592 */     if (argAddress == null) {
/*     */       
/* 594 */       getDAO_().setAddressSequence(null);
/* 595 */       if (this._address != null)
/*     */       {
/* 597 */         if (postEventsForChanges()) {
/* 598 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._address));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 603 */       getDAO_().setAddressSequence(Long.valueOf(argAddress.getSequence()));
/*     */       
/* 605 */       if (postEventsForChanges()) {
/* 606 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAddress));
/*     */       }
/*     */     } 
/*     */     
/* 610 */     this._address = argAddress;
/* 611 */     if (postEventsForChanges()) {
/* 612 */       this._events.post(ISourceModifier.SET_ADDRESS, argAddress);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ISourceModifierProperty> getProperties() {
/* 618 */     if (this._properties == null) {
/* 619 */       this._properties = new HistoricalList(null);
/*     */     }
/* 621 */     return (List<ISourceModifierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ISourceModifierProperty> argProperties) {
/* 625 */     if (this._properties == null) {
/* 626 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 628 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 631 */     for (ISourceModifierProperty child : this._properties) {
/* 632 */       SourceModifierPropertyModel model = (SourceModifierPropertyModel)child;
/* 633 */       model.setOrganizationId_noev(getOrganizationId());
/* 634 */       model.setOrderId_noev(getOrderId());
/* 635 */       model.setSequence_noev(getSequence());
/* 636 */       if (child instanceof IDataModelImpl) {
/* 637 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 638 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 639 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 640 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 643 */       if (postEventsForChanges()) {
/* 644 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addSourceModifierProperty(ISourceModifierProperty argSourceModifierProperty) {
/* 650 */     if (this._properties == null) {
/* 651 */       this._properties = new HistoricalList(null);
/*     */     }
/* 653 */     argSourceModifierProperty.setOrganizationId(getOrganizationId());
/* 654 */     argSourceModifierProperty.setOrderId(getOrderId());
/* 655 */     argSourceModifierProperty.setSequence(getSequence());
/* 656 */     if (argSourceModifierProperty instanceof IDataModelImpl) {
/* 657 */       IDataAccessObject childDao = ((IDataModelImpl)argSourceModifierProperty).getDAO();
/* 658 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 659 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 660 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 665 */     if (postEventsForChanges()) {
/* 666 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSourceModifierProperty));
/*     */     }
/*     */     
/* 669 */     this._properties.add(argSourceModifierProperty);
/* 670 */     if (postEventsForChanges()) {
/* 671 */       this._events.post(ISourceModifier.ADD_PROPERTIES, argSourceModifierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeSourceModifierProperty(ISourceModifierProperty argSourceModifierProperty) {
/* 676 */     if (this._properties != null) {
/*     */       
/* 678 */       if (postEventsForChanges()) {
/* 679 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSourceModifierProperty));
/*     */       }
/* 681 */       this._properties.remove(argSourceModifierProperty);
/* 682 */       if (postEventsForChanges()) {
/* 683 */         this._events.post(ISourceModifier.REMOVE_PROPERTIES, argSourceModifierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentLine(IOrderLine argParentLine) {
/* 689 */     this._parentLine = argParentLine;
/*     */   }
/*     */   
/*     */   public IOrderLine getParentLine() {
/* 693 */     return this._parentLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 698 */     if ("Address".equals(argFieldId)) {
/* 699 */       return getAddress();
/*     */     }
/* 701 */     if ("Properties".equals(argFieldId)) {
/* 702 */       return getProperties();
/*     */     }
/* 704 */     if ("SourceModifierExtension".equals(argFieldId)) {
/* 705 */       return this._myExtension;
/*     */     }
/*     */     
/* 708 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 714 */     if ("Address".equals(argFieldId)) {
/* 715 */       setAddress((IAddressModifier)argValue);
/*     */     }
/* 717 */     else if ("Properties".equals(argFieldId)) {
/* 718 */       setProperties(changeToList(argValue, ISourceModifierProperty.class));
/*     */     }
/* 720 */     else if ("SourceModifierExtension".equals(argFieldId)) {
/* 721 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 724 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 730 */     this._persistenceDefaults = argPD;
/* 731 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 732 */     this._eventManager = argEM;
/* 733 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 734 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 735 */     if (this._address != null) {
/* 736 */       ((IDataModelImpl)this._address).setDependencies(argPD, argEM);
/*     */     }
/* 738 */     if (this._properties != null) {
/* 739 */       for (ISourceModifierProperty relationship : this._properties) {
/* 740 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getSourceModifierExt() {
/* 746 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setSourceModifierExt(IDataModel argExt) {
/* 750 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 755 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 759 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 762 */     super.startTransaction();
/*     */     
/* 764 */     this._addressSavepoint = this._address;
/* 765 */     if (this._address != null) {
/* 766 */       this._address.startTransaction();
/*     */     }
/*     */     
/* 769 */     this._propertiesSavepoint = this._properties;
/* 770 */     if (this._properties != null) {
/* 771 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 772 */       Iterator<IDataModel> it = this._properties.iterator();
/* 773 */       while (it.hasNext()) {
/* 774 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 779 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 784 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 787 */     super.rollbackChanges();
/*     */     
/* 789 */     this._address = this._addressSavepoint;
/* 790 */     this._addressSavepoint = null;
/* 791 */     if (this._address != null) {
/* 792 */       this._address.rollbackChanges();
/*     */     }
/*     */     
/* 795 */     this._properties = this._propertiesSavepoint;
/* 796 */     this._propertiesSavepoint = null;
/* 797 */     if (this._properties != null) {
/* 798 */       Iterator<IDataModel> it = this._properties.iterator();
/* 799 */       while (it.hasNext()) {
/* 800 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 808 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 811 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 814 */     super.commitTransaction();
/*     */     
/* 816 */     this._addressSavepoint = this._address;
/* 817 */     if (this._address != null) {
/* 818 */       this._address.commitTransaction();
/*     */     }
/*     */     
/* 821 */     this._propertiesSavepoint = this._properties;
/* 822 */     if (this._properties != null) {
/* 823 */       Iterator<IDataModel> it = this._properties.iterator();
/* 824 */       while (it.hasNext()) {
/* 825 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 827 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 831 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 836 */     argStream.defaultReadObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IAddress getLocationAddress() {
/* 850 */     return (IAddress)getAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLocationAddress(IAddressModifier argLocationAddress) {
/* 855 */     setAddress(argLocationAddress);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\SourceModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */