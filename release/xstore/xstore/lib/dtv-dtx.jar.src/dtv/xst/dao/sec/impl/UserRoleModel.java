/*     */ package dtv.xst.dao.sec.impl;
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
/*     */ import dtv.xst.dao.sec.IUserRole;
/*     */ import dtv.xst.dao.sec.IUserRoleProperty;
/*     */ import dtv.xst.dao.sec.UserRolePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class UserRoleModel extends AbstractDataModelWithPropertyImpl<IUserRoleProperty> implements IUserRole {
/*     */   private static final long serialVersionUID = -201890047L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IUserRoleProperty> _properties; private transient HistoricalList<IUserRoleProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new UserRoleDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private UserRoleDAO getDAO_() {
/*  46 */     return (UserRoleDAO)this._daoImpl;
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
/*  70 */       this._events.post(IUserRole.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<UserRolePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((UserRolePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public int getUserRoleId() {
/* 101 */     if (getDAO_().getUserRoleId() != null) {
/* 102 */       return getDAO_().getUserRoleId().intValue();
/*     */     }
/*     */     
/* 105 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUserRoleId(int argUserRoleId) {
/* 114 */     if (setUserRoleId_noev(argUserRoleId) && 
/* 115 */       this._events != null && 
/* 116 */       postEventsForChanges()) {
/* 117 */       this._events.post(IUserRole.SET_USERROLEID, Integer.valueOf(argUserRoleId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUserRoleId_noev(int argUserRoleId) {
/* 124 */     boolean ev_postable = false;
/*     */     
/* 126 */     if ((getDAO_().getUserRoleId() == null && Integer.valueOf(argUserRoleId) != null) || (
/* 127 */       getDAO_().getUserRoleId() != null && !getDAO_().getUserRoleId().equals(Integer.valueOf(argUserRoleId)))) {
/* 128 */       getDAO_().setUserRoleId(Integer.valueOf(argUserRoleId));
/* 129 */       ev_postable = true;
/* 130 */       if (this._properties != null) {
/*     */         
/* 132 */         Iterator<UserRolePropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((UserRolePropertyModel)it.next()).setUserRoleId_noev(argUserRoleId);
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
/* 159 */       this._events.post(IUserRole.SET_CREATEDATE, argCreateDate);
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
/* 193 */       this._events.post(IUserRole.SET_CREATEUSERID, argCreateUserId);
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
/* 227 */       this._events.post(IUserRole.SET_UPDATEDATE, argUpdateDate);
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
/* 261 */       this._events.post(IUserRole.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getUser() {
/* 284 */     return getDAO_().getUser();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUser(String argUser) {
/* 292 */     if (setUser_noev(argUser) && 
/* 293 */       this._events != null && 
/* 294 */       postEventsForChanges()) {
/* 295 */       this._events.post(IUserRole.SET_USER, argUser);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUser_noev(String argUser) {
/* 302 */     boolean ev_postable = false;
/*     */     
/* 304 */     if ((getDAO_().getUser() == null && argUser != null) || (
/* 305 */       getDAO_().getUser() != null && !getDAO_().getUser().equals(argUser))) {
/* 306 */       getDAO_().setUser(argUser);
/* 307 */       ev_postable = true;
/*     */     } 
/*     */     
/* 310 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRoleCode() {
/* 318 */     return getDAO_().getRoleCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRoleCode(String argRoleCode) {
/* 326 */     if (setRoleCode_noev(argRoleCode) && 
/* 327 */       this._events != null && 
/* 328 */       postEventsForChanges()) {
/* 329 */       this._events.post(IUserRole.SET_ROLECODE, argRoleCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRoleCode_noev(String argRoleCode) {
/* 336 */     boolean ev_postable = false;
/*     */     
/* 338 */     if ((getDAO_().getRoleCode() == null && argRoleCode != null) || (
/* 339 */       getDAO_().getRoleCode() != null && !getDAO_().getRoleCode().equals(argRoleCode))) {
/* 340 */       getDAO_().setRoleCode(argRoleCode);
/* 341 */       ev_postable = true;
/*     */     } 
/*     */     
/* 344 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IUserRoleProperty newProperty(String argPropertyName) {
/* 348 */     UserRolePropertyId id = new UserRolePropertyId();
/*     */     
/* 350 */     id.setUserRoleId(Integer.valueOf(getUserRoleId()));
/* 351 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 353 */     IUserRoleProperty prop = (IUserRoleProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IUserRoleProperty.class);
/* 354 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IUserRoleProperty> getProperties() {
/* 363 */     if (this._properties == null) {
/* 364 */       this._properties = new HistoricalList(null);
/*     */     }
/* 366 */     return (List<IUserRoleProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IUserRoleProperty> argProperties) {
/* 370 */     if (this._properties == null) {
/* 371 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 373 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 376 */     for (IUserRoleProperty child : this._properties) {
/* 377 */       UserRolePropertyModel model = (UserRolePropertyModel)child;
/* 378 */       model.setOrganizationId_noev(getOrganizationId());
/* 379 */       model.setUserRoleId_noev(getUserRoleId());
/* 380 */       if (child instanceof IDataModelImpl) {
/* 381 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 382 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 383 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 384 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 387 */       if (postEventsForChanges()) {
/* 388 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addUserRoleProperty(IUserRoleProperty argUserRoleProperty) {
/* 394 */     if (this._properties == null) {
/* 395 */       this._properties = new HistoricalList(null);
/*     */     }
/* 397 */     argUserRoleProperty.setOrganizationId(getOrganizationId());
/* 398 */     argUserRoleProperty.setUserRoleId(getUserRoleId());
/* 399 */     if (argUserRoleProperty instanceof IDataModelImpl) {
/* 400 */       IDataAccessObject childDao = ((IDataModelImpl)argUserRoleProperty).getDAO();
/* 401 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 402 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 403 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 408 */     if (postEventsForChanges()) {
/* 409 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argUserRoleProperty));
/*     */     }
/*     */     
/* 412 */     this._properties.add(argUserRoleProperty);
/* 413 */     if (postEventsForChanges()) {
/* 414 */       this._events.post(IUserRole.ADD_PROPERTIES, argUserRoleProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeUserRoleProperty(IUserRoleProperty argUserRoleProperty) {
/* 419 */     if (this._properties != null) {
/*     */       
/* 421 */       if (postEventsForChanges()) {
/* 422 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argUserRoleProperty));
/*     */       }
/* 424 */       this._properties.remove(argUserRoleProperty);
/* 425 */       if (postEventsForChanges()) {
/* 426 */         this._events.post(IUserRole.REMOVE_PROPERTIES, argUserRoleProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 433 */     if ("Properties".equals(argFieldId)) {
/* 434 */       return getProperties();
/*     */     }
/* 436 */     if ("UserRoleExtension".equals(argFieldId)) {
/* 437 */       return this._myExtension;
/*     */     }
/*     */     
/* 440 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 446 */     if ("Properties".equals(argFieldId)) {
/* 447 */       setProperties(changeToList(argValue, IUserRoleProperty.class));
/*     */     }
/* 449 */     else if ("UserRoleExtension".equals(argFieldId)) {
/* 450 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 453 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 459 */     this._persistenceDefaults = argPD;
/* 460 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 461 */     this._eventManager = argEM;
/* 462 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 463 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 464 */     if (this._properties != null) {
/* 465 */       for (IUserRoleProperty relationship : this._properties) {
/* 466 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getUserRoleExt() {
/* 472 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setUserRoleExt(IDataModel argExt) {
/* 476 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 481 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 485 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 488 */     super.startTransaction();
/*     */     
/* 490 */     this._propertiesSavepoint = this._properties;
/* 491 */     if (this._properties != null) {
/* 492 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 493 */       Iterator<IDataModel> it = this._properties.iterator();
/* 494 */       while (it.hasNext()) {
/* 495 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 500 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 505 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 508 */     super.rollbackChanges();
/*     */     
/* 510 */     this._properties = this._propertiesSavepoint;
/* 511 */     this._propertiesSavepoint = null;
/* 512 */     if (this._properties != null) {
/* 513 */       Iterator<IDataModel> it = this._properties.iterator();
/* 514 */       while (it.hasNext()) {
/* 515 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 523 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 526 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 529 */     super.commitTransaction();
/*     */     
/* 531 */     this._propertiesSavepoint = this._properties;
/* 532 */     if (this._properties != null) {
/* 533 */       Iterator<IDataModel> it = this._properties.iterator();
/* 534 */       while (it.hasNext()) {
/* 535 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 537 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 541 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 546 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\UserRoleModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */