/*     */ package dtv.xst.dao.ctl.impl;
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
/*     */ import dtv.xst.dao.ctl.DeviceRegistrationPropertyId;
/*     */ import dtv.xst.dao.ctl.IDeviceRegistration;
/*     */ import dtv.xst.dao.ctl.IDeviceRegistrationProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DeviceRegistrationModel extends AbstractDataModelWithPropertyImpl<IDeviceRegistrationProperty> implements IDeviceRegistration {
/*     */   private static final long serialVersionUID = 163923535L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IDeviceRegistrationProperty> _properties; private transient HistoricalList<IDeviceRegistrationProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new DeviceRegistrationDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DeviceRegistrationDAO getDAO_() {
/*  46 */     return (DeviceRegistrationDAO)this._daoImpl;
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
/*  70 */       this._events.post(IDeviceRegistration.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<DeviceRegistrationPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((DeviceRegistrationPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(IDeviceRegistration.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 132 */         Iterator<DeviceRegistrationPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((DeviceRegistrationPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public long getWorkstationId() {
/* 148 */     if (getDAO_().getWorkstationId() != null) {
/* 149 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 152 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 161 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 162 */       this._events != null && 
/* 163 */       postEventsForChanges()) {
/* 164 */       this._events.post(IDeviceRegistration.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 171 */     boolean ev_postable = false;
/*     */     
/* 173 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 174 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 175 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 176 */       ev_postable = true;
/* 177 */       if (this._properties != null) {
/*     */         
/* 179 */         Iterator<DeviceRegistrationPropertyModel> it = this._properties.iterator();
/* 180 */         while (it.hasNext())
/*     */         {
/* 182 */           ((DeviceRegistrationPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 187 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 195 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 203 */     if (setCreateDate_noev(argCreateDate) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(IDeviceRegistration.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 216 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 217 */       getDAO_().setCreateDate(argCreateDate);
/* 218 */       ev_postable = true;
/*     */     } 
/*     */     
/* 221 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 229 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 237 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 238 */       this._events != null && 
/* 239 */       postEventsForChanges()) {
/* 240 */       this._events.post(IDeviceRegistration.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 247 */     boolean ev_postable = false;
/*     */     
/* 249 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 250 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 251 */       getDAO_().setCreateUserId(argCreateUserId);
/* 252 */       ev_postable = true;
/*     */     } 
/*     */     
/* 255 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 263 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 271 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 272 */       this._events != null && 
/* 273 */       postEventsForChanges()) {
/* 274 */       this._events.post(IDeviceRegistration.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 281 */     boolean ev_postable = false;
/*     */     
/* 283 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 284 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 285 */       getDAO_().setUpdateDate(argUpdateDate);
/* 286 */       ev_postable = true;
/*     */     } 
/*     */     
/* 289 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 297 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 305 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 306 */       this._events != null && 
/* 307 */       postEventsForChanges()) {
/* 308 */       this._events.post(IDeviceRegistration.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 315 */     boolean ev_postable = false;
/*     */     
/* 317 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 318 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 319 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 320 */       ev_postable = true;
/*     */     } 
/*     */     
/* 323 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIpAddress() {
/* 331 */     return getDAO_().getIpAddress();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIpAddress(String argIpAddress) {
/* 339 */     if (setIpAddress_noev(argIpAddress) && 
/* 340 */       this._events != null && 
/* 341 */       postEventsForChanges()) {
/* 342 */       this._events.post(IDeviceRegistration.SET_IPADDRESS, argIpAddress);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIpAddress_noev(String argIpAddress) {
/* 349 */     boolean ev_postable = false;
/*     */     
/* 351 */     if ((getDAO_().getIpAddress() == null && argIpAddress != null) || (
/* 352 */       getDAO_().getIpAddress() != null && !getDAO_().getIpAddress().equals(argIpAddress))) {
/* 353 */       getDAO_().setIpAddress(argIpAddress);
/* 354 */       ev_postable = true;
/*     */     } 
/*     */     
/* 357 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDateTimestamp() {
/* 365 */     return getDAO_().getDateTimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateTimestamp(Date argDateTimestamp) {
/* 373 */     if (setDateTimestamp_noev(argDateTimestamp) && 
/* 374 */       this._events != null && 
/* 375 */       postEventsForChanges()) {
/* 376 */       this._events.post(IDeviceRegistration.SET_DATETIMESTAMP, argDateTimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateTimestamp_noev(Date argDateTimestamp) {
/* 383 */     boolean ev_postable = false;
/*     */     
/* 385 */     if ((getDAO_().getDateTimestamp() == null && argDateTimestamp != null) || (
/* 386 */       getDAO_().getDateTimestamp() != null && !getDAO_().getDateTimestamp().equals(argDateTimestamp))) {
/* 387 */       getDAO_().setDateTimestamp(argDateTimestamp);
/* 388 */       ev_postable = true;
/*     */     } 
/*     */     
/* 391 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 399 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 407 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 408 */       this._events != null && 
/* 409 */       postEventsForChanges()) {
/* 410 */       this._events.post(IDeviceRegistration.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 417 */     boolean ev_postable = false;
/*     */     
/* 419 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 420 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 421 */       getDAO_().setBusinessDate(argBusinessDate);
/* 422 */       ev_postable = true;
/*     */     } 
/*     */     
/* 425 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getXtoreVersion() {
/* 433 */     return getDAO_().getXtoreVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXtoreVersion(String argXtoreVersion) {
/* 441 */     if (setXtoreVersion_noev(argXtoreVersion) && 
/* 442 */       this._events != null && 
/* 443 */       postEventsForChanges()) {
/* 444 */       this._events.post(IDeviceRegistration.SET_XTOREVERSION, argXtoreVersion);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setXtoreVersion_noev(String argXtoreVersion) {
/* 451 */     boolean ev_postable = false;
/*     */     
/* 453 */     if ((getDAO_().getXtoreVersion() == null && argXtoreVersion != null) || (
/* 454 */       getDAO_().getXtoreVersion() != null && !getDAO_().getXtoreVersion().equals(argXtoreVersion))) {
/* 455 */       getDAO_().setXtoreVersion(argXtoreVersion);
/* 456 */       ev_postable = true;
/*     */     } 
/*     */     
/* 459 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEnvVersion() {
/* 467 */     return getDAO_().getEnvVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnvVersion(String argEnvVersion) {
/* 475 */     if (setEnvVersion_noev(argEnvVersion) && 
/* 476 */       this._events != null && 
/* 477 */       postEventsForChanges()) {
/* 478 */       this._events.post(IDeviceRegistration.SET_ENVVERSION, argEnvVersion);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEnvVersion_noev(String argEnvVersion) {
/* 485 */     boolean ev_postable = false;
/*     */     
/* 487 */     if ((getDAO_().getEnvVersion() == null && argEnvVersion != null) || (
/* 488 */       getDAO_().getEnvVersion() != null && !getDAO_().getEnvVersion().equals(argEnvVersion))) {
/* 489 */       getDAO_().setEnvVersion(argEnvVersion);
/* 490 */       ev_postable = true;
/*     */     } 
/*     */     
/* 493 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getActiveFlag() {
/* 501 */     if (getDAO_().getActiveFlag() != null) {
/* 502 */       return getDAO_().getActiveFlag().booleanValue();
/*     */     }
/*     */     
/* 505 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActiveFlag(boolean argActiveFlag) {
/* 514 */     if (setActiveFlag_noev(argActiveFlag) && 
/* 515 */       this._events != null && 
/* 516 */       postEventsForChanges()) {
/* 517 */       this._events.post(IDeviceRegistration.SET_ACTIVEFLAG, Boolean.valueOf(argActiveFlag));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActiveFlag_noev(boolean argActiveFlag) {
/* 524 */     boolean ev_postable = false;
/*     */     
/* 526 */     if ((getDAO_().getActiveFlag() == null && Boolean.valueOf(argActiveFlag) != null) || (
/* 527 */       getDAO_().getActiveFlag() != null && !getDAO_().getActiveFlag().equals(Boolean.valueOf(argActiveFlag)))) {
/* 528 */       getDAO_().setActiveFlag(Boolean.valueOf(argActiveFlag));
/* 529 */       ev_postable = true;
/*     */     } 
/*     */     
/* 532 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigVersion() {
/* 540 */     return getDAO_().getConfigVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigVersion(String argConfigVersion) {
/* 548 */     if (setConfigVersion_noev(argConfigVersion) && 
/* 549 */       this._events != null && 
/* 550 */       postEventsForChanges()) {
/* 551 */       this._events.post(IDeviceRegistration.SET_CONFIGVERSION, argConfigVersion);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConfigVersion_noev(String argConfigVersion) {
/* 558 */     boolean ev_postable = false;
/*     */     
/* 560 */     if ((getDAO_().getConfigVersion() == null && argConfigVersion != null) || (
/* 561 */       getDAO_().getConfigVersion() != null && !getDAO_().getConfigVersion().equals(argConfigVersion))) {
/* 562 */       getDAO_().setConfigVersion(argConfigVersion);
/* 563 */       ev_postable = true;
/*     */     } 
/*     */     
/* 566 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPrimaryRegister() {
/* 574 */     if (getDAO_().getPrimaryRegister() != null) {
/* 575 */       return getDAO_().getPrimaryRegister().booleanValue();
/*     */     }
/*     */     
/* 578 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrimaryRegister(boolean argPrimaryRegister) {
/* 587 */     if (setPrimaryRegister_noev(argPrimaryRegister) && 
/* 588 */       this._events != null && 
/* 589 */       postEventsForChanges()) {
/* 590 */       this._events.post(IDeviceRegistration.SET_PRIMARYREGISTER, Boolean.valueOf(argPrimaryRegister));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPrimaryRegister_noev(boolean argPrimaryRegister) {
/* 597 */     boolean ev_postable = false;
/*     */     
/* 599 */     if ((getDAO_().getPrimaryRegister() == null && Boolean.valueOf(argPrimaryRegister) != null) || (
/* 600 */       getDAO_().getPrimaryRegister() != null && !getDAO_().getPrimaryRegister().equals(Boolean.valueOf(argPrimaryRegister)))) {
/* 601 */       getDAO_().setPrimaryRegister(Boolean.valueOf(argPrimaryRegister));
/* 602 */       ev_postable = true;
/*     */     } 
/*     */     
/* 605 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDeviceRegistrationProperty newProperty(String argPropertyName) {
/* 609 */     DeviceRegistrationPropertyId id = new DeviceRegistrationPropertyId();
/*     */     
/* 611 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 612 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 613 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 615 */     IDeviceRegistrationProperty prop = (IDeviceRegistrationProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDeviceRegistrationProperty.class);
/* 616 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDeviceRegistrationProperty> getProperties() {
/* 625 */     if (this._properties == null) {
/* 626 */       this._properties = new HistoricalList(null);
/*     */     }
/* 628 */     return (List<IDeviceRegistrationProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDeviceRegistrationProperty> argProperties) {
/* 632 */     if (this._properties == null) {
/* 633 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 635 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 638 */     for (IDeviceRegistrationProperty child : this._properties) {
/* 639 */       DeviceRegistrationPropertyModel model = (DeviceRegistrationPropertyModel)child;
/* 640 */       model.setOrganizationId_noev(getOrganizationId());
/* 641 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 642 */       model.setWorkstationId_noev(getWorkstationId());
/* 643 */       if (child instanceof IDataModelImpl) {
/* 644 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 645 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 646 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 647 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 650 */       if (postEventsForChanges()) {
/* 651 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDeviceRegistrationProperty(IDeviceRegistrationProperty argDeviceRegistrationProperty) {
/* 657 */     if (this._properties == null) {
/* 658 */       this._properties = new HistoricalList(null);
/*     */     }
/* 660 */     argDeviceRegistrationProperty.setOrganizationId(getOrganizationId());
/* 661 */     argDeviceRegistrationProperty.setRetailLocationId(getRetailLocationId());
/* 662 */     argDeviceRegistrationProperty.setWorkstationId(getWorkstationId());
/* 663 */     if (argDeviceRegistrationProperty instanceof IDataModelImpl) {
/* 664 */       IDataAccessObject childDao = ((IDataModelImpl)argDeviceRegistrationProperty).getDAO();
/* 665 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 666 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 667 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 672 */     if (postEventsForChanges()) {
/* 673 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDeviceRegistrationProperty));
/*     */     }
/*     */     
/* 676 */     this._properties.add(argDeviceRegistrationProperty);
/* 677 */     if (postEventsForChanges()) {
/* 678 */       this._events.post(IDeviceRegistration.ADD_PROPERTIES, argDeviceRegistrationProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDeviceRegistrationProperty(IDeviceRegistrationProperty argDeviceRegistrationProperty) {
/* 683 */     if (this._properties != null) {
/*     */       
/* 685 */       if (postEventsForChanges()) {
/* 686 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDeviceRegistrationProperty));
/*     */       }
/* 688 */       this._properties.remove(argDeviceRegistrationProperty);
/* 689 */       if (postEventsForChanges()) {
/* 690 */         this._events.post(IDeviceRegistration.REMOVE_PROPERTIES, argDeviceRegistrationProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 697 */     if ("Properties".equals(argFieldId)) {
/* 698 */       return getProperties();
/*     */     }
/* 700 */     if ("DeviceRegistrationExtension".equals(argFieldId)) {
/* 701 */       return this._myExtension;
/*     */     }
/*     */     
/* 704 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 710 */     if ("Properties".equals(argFieldId)) {
/* 711 */       setProperties(changeToList(argValue, IDeviceRegistrationProperty.class));
/*     */     }
/* 713 */     else if ("DeviceRegistrationExtension".equals(argFieldId)) {
/* 714 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 717 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 723 */     this._persistenceDefaults = argPD;
/* 724 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 725 */     this._eventManager = argEM;
/* 726 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 727 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 728 */     if (this._properties != null) {
/* 729 */       for (IDeviceRegistrationProperty relationship : this._properties) {
/* 730 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDeviceRegistrationExt() {
/* 736 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDeviceRegistrationExt(IDataModel argExt) {
/* 740 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 745 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 749 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 752 */     super.startTransaction();
/*     */     
/* 754 */     this._propertiesSavepoint = this._properties;
/* 755 */     if (this._properties != null) {
/* 756 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 757 */       Iterator<IDataModel> it = this._properties.iterator();
/* 758 */       while (it.hasNext()) {
/* 759 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 764 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 769 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 772 */     super.rollbackChanges();
/*     */     
/* 774 */     this._properties = this._propertiesSavepoint;
/* 775 */     this._propertiesSavepoint = null;
/* 776 */     if (this._properties != null) {
/* 777 */       Iterator<IDataModel> it = this._properties.iterator();
/* 778 */       while (it.hasNext()) {
/* 779 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 787 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 790 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 793 */     super.commitTransaction();
/*     */     
/* 795 */     this._propertiesSavepoint = this._properties;
/* 796 */     if (this._properties != null) {
/* 797 */       Iterator<IDataModel> it = this._properties.iterator();
/* 798 */       while (it.hasNext()) {
/* 799 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 801 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 805 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 810 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\DeviceRegistrationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */