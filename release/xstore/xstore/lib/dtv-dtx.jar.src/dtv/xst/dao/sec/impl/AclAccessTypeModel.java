/*     */ package dtv.xst.dao.sec.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.Base64;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.sec.AclAccessTypePropertyId;
/*     */ import dtv.xst.dao.sec.IAclAccessType;
/*     */ import dtv.xst.dao.sec.IAclAccessTypeProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class AclAccessTypeModel extends AbstractDataModelWithPropertyImpl<IAclAccessTypeProperty> implements IAclAccessType {
/*     */   private static final long serialVersionUID = -1942796600L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IAclAccessTypeProperty> _properties; private transient HistoricalList<IAclAccessTypeProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new AclAccessTypeDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private AclAccessTypeDAO getDAO_() {
/*  46 */     return (AclAccessTypeDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccessTypeCode() {
/*  54 */     return getDAO_().getAccessTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccessTypeCode(String argAccessTypeCode) {
/*  62 */     if (setAccessTypeCode_noev(argAccessTypeCode) && 
/*  63 */       this._events != null && 
/*  64 */       postEventsForChanges()) {
/*  65 */       this._events.post(IAclAccessType.SET_ACCESSTYPECODE, argAccessTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccessTypeCode_noev(String argAccessTypeCode) {
/*  72 */     boolean ev_postable = false;
/*     */     
/*  74 */     if ((getDAO_().getAccessTypeCode() == null && argAccessTypeCode != null) || (
/*  75 */       getDAO_().getAccessTypeCode() != null && !getDAO_().getAccessTypeCode().equals(argAccessTypeCode))) {
/*  76 */       getDAO_().setAccessTypeCode(argAccessTypeCode);
/*  77 */       ev_postable = true;
/*  78 */       if (this._properties != null) {
/*     */         
/*  80 */         Iterator<AclAccessTypePropertyModel> it = this._properties.iterator();
/*  81 */         while (it.hasNext())
/*     */         {
/*  83 */           ((AclAccessTypePropertyModel)it.next()).setAccessTypeCode_noev(argAccessTypeCode);
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
/* 112 */       this._events.post(IAclAccessType.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/* 127 */         Iterator<AclAccessTypePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((AclAccessTypePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getSecuredObjectId() {
/* 143 */     return getDAO_().getSecuredObjectId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSecuredObjectId(String argSecuredObjectId) {
/* 151 */     if (setSecuredObjectId_noev(argSecuredObjectId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IAclAccessType.SET_SECUREDOBJECTID, argSecuredObjectId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSecuredObjectId_noev(String argSecuredObjectId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getSecuredObjectId() == null && argSecuredObjectId != null) || (
/* 164 */       getDAO_().getSecuredObjectId() != null && !getDAO_().getSecuredObjectId().equals(argSecuredObjectId))) {
/* 165 */       getDAO_().setSecuredObjectId(argSecuredObjectId);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<AclAccessTypePropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((AclAccessTypePropertyModel)it.next()).setSecuredObjectId_noev(argSecuredObjectId);
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
/* 196 */       this._events.post(IAclAccessType.SET_CREATEDATE, argCreateDate);
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
/* 230 */       this._events.post(IAclAccessType.SET_CREATEUSERID, argCreateUserId);
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
/* 264 */       this._events.post(IAclAccessType.SET_UPDATEDATE, argUpdateDate);
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
/* 298 */       this._events.post(IAclAccessType.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getGroupMembershipRaw() {
/* 321 */     return getDAO_().getGroupMembershipRaw();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupMembershipRaw(String argGroupMembershipRaw) {
/* 329 */     if (setGroupMembershipRaw_noev(argGroupMembershipRaw) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(IAclAccessType.SET_GROUPMEMBERSHIPRAW, argGroupMembershipRaw);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setGroupMembershipRaw_noev(String argGroupMembershipRaw) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getGroupMembershipRaw() == null && argGroupMembershipRaw != null) || (
/* 342 */       getDAO_().getGroupMembershipRaw() != null && !getDAO_().getGroupMembershipRaw().equals(argGroupMembershipRaw))) {
/* 343 */       getDAO_().setGroupMembershipRaw(argGroupMembershipRaw);
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
/*     */   public String getNoAccessSettings() {
/* 355 */     return getDAO_().getNoAccessSettings();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoAccessSettings(String argNoAccessSettings) {
/* 363 */     if (setNoAccessSettings_noev(argNoAccessSettings) && 
/* 364 */       this._events != null && 
/* 365 */       postEventsForChanges()) {
/* 366 */       this._events.post(IAclAccessType.SET_NOACCESSSETTINGS, argNoAccessSettings);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoAccessSettings_noev(String argNoAccessSettings) {
/* 373 */     boolean ev_postable = false;
/*     */     
/* 375 */     if ((getDAO_().getNoAccessSettings() == null && argNoAccessSettings != null) || (
/* 376 */       getDAO_().getNoAccessSettings() != null && !getDAO_().getNoAccessSettings().equals(argNoAccessSettings))) {
/* 377 */       getDAO_().setNoAccessSettings(argNoAccessSettings);
/* 378 */       ev_postable = true;
/*     */     } 
/*     */     
/* 381 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IAclAccessTypeProperty newProperty(String argPropertyName) {
/* 385 */     AclAccessTypePropertyId id = new AclAccessTypePropertyId();
/*     */     
/* 387 */     id.setAccessTypeCode(getAccessTypeCode());
/* 388 */     id.setSecuredObjectId(getSecuredObjectId());
/* 389 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 391 */     IAclAccessTypeProperty prop = (IAclAccessTypeProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IAclAccessTypeProperty.class);
/* 392 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IAclAccessTypeProperty> getProperties() {
/* 401 */     if (this._properties == null) {
/* 402 */       this._properties = new HistoricalList(null);
/*     */     }
/* 404 */     return (List<IAclAccessTypeProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IAclAccessTypeProperty> argProperties) {
/* 408 */     if (this._properties == null) {
/* 409 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 411 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 414 */     for (IAclAccessTypeProperty child : this._properties) {
/* 415 */       AclAccessTypePropertyModel model = (AclAccessTypePropertyModel)child;
/* 416 */       model.setAccessTypeCode_noev(getAccessTypeCode());
/* 417 */       model.setOrganizationId_noev(getOrganizationId());
/* 418 */       model.setSecuredObjectId_noev(getSecuredObjectId());
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
/*     */   public void addAclAccessTypeProperty(IAclAccessTypeProperty argAclAccessTypeProperty) {
/* 433 */     if (this._properties == null) {
/* 434 */       this._properties = new HistoricalList(null);
/*     */     }
/* 436 */     argAclAccessTypeProperty.setAccessTypeCode(getAccessTypeCode());
/* 437 */     argAclAccessTypeProperty.setOrganizationId(getOrganizationId());
/* 438 */     argAclAccessTypeProperty.setSecuredObjectId(getSecuredObjectId());
/* 439 */     if (argAclAccessTypeProperty instanceof IDataModelImpl) {
/* 440 */       IDataAccessObject childDao = ((IDataModelImpl)argAclAccessTypeProperty).getDAO();
/* 441 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 442 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 443 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 448 */     if (postEventsForChanges()) {
/* 449 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAclAccessTypeProperty));
/*     */     }
/*     */     
/* 452 */     this._properties.add(argAclAccessTypeProperty);
/* 453 */     if (postEventsForChanges()) {
/* 454 */       this._events.post(IAclAccessType.ADD_PROPERTIES, argAclAccessTypeProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeAclAccessTypeProperty(IAclAccessTypeProperty argAclAccessTypeProperty) {
/* 459 */     if (this._properties != null) {
/*     */       
/* 461 */       if (postEventsForChanges()) {
/* 462 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAclAccessTypeProperty));
/*     */       }
/* 464 */       this._properties.remove(argAclAccessTypeProperty);
/* 465 */       if (postEventsForChanges()) {
/* 466 */         this._events.post(IAclAccessType.REMOVE_PROPERTIES, argAclAccessTypeProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 473 */     if ("Properties".equals(argFieldId)) {
/* 474 */       return getProperties();
/*     */     }
/* 476 */     if ("AclAccessTypeExtension".equals(argFieldId)) {
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
/* 487 */       setProperties(changeToList(argValue, IAclAccessTypeProperty.class));
/*     */     }
/* 489 */     else if ("AclAccessTypeExtension".equals(argFieldId)) {
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
/* 505 */       for (IAclAccessTypeProperty relationship : this._properties) {
/* 506 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getAclAccessTypeExt() {
/* 512 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setAclAccessTypeExt(IDataModel argExt) {
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getGroupMembership() {
/*     */     try {
/* 599 */       return Base64.base64ToByteArray(getDAO_().getGroupMembershipRaw());
/*     */     }
/* 601 */     catch (Exception ex) {
/* 602 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setGroupMembership(byte[] groupMembership) {
/* 607 */     getDAO_().setGroupMembershipRaw(Base64.byteArrayToBase64(groupMembership));
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\AclAccessTypeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */