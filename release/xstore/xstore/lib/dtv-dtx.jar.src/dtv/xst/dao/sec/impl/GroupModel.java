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
/*     */ import dtv.xst.dao.sec.GroupPropertyId;
/*     */ import dtv.xst.dao.sec.IGroup;
/*     */ import dtv.xst.dao.sec.IGroupProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class GroupModel extends AbstractDataModelWithPropertyImpl<IGroupProperty> implements IGroup {
/*     */   private static final long serialVersionUID = 69076575L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IGroupProperty> _properties; private transient HistoricalList<IGroupProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new GroupDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private GroupDAO getDAO_() {
/*  46 */     return (GroupDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGroupId() {
/*  54 */     return getDAO_().getGroupId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupId(String argGroupId) {
/*  62 */     if (setGroupId_noev(argGroupId) && 
/*  63 */       this._events != null && 
/*  64 */       postEventsForChanges()) {
/*  65 */       this._events.post(IGroup.SET_GROUPID, argGroupId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setGroupId_noev(String argGroupId) {
/*  72 */     boolean ev_postable = false;
/*     */     
/*  74 */     if ((getDAO_().getGroupId() == null && argGroupId != null) || (
/*  75 */       getDAO_().getGroupId() != null && !getDAO_().getGroupId().equals(argGroupId))) {
/*  76 */       getDAO_().setGroupId(argGroupId);
/*  77 */       ev_postable = true;
/*  78 */       if (this._properties != null) {
/*     */         
/*  80 */         Iterator<GroupPropertyModel> it = this._properties.iterator();
/*  81 */         while (it.hasNext())
/*     */         {
/*  83 */           ((GroupPropertyModel)it.next()).setGroupId_noev(argGroupId);
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
/* 112 */       this._events.post(IGroup.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/* 127 */         Iterator<GroupPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((GroupPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 154 */       this._events.post(IGroup.SET_CREATEDATE, argCreateDate);
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
/* 188 */       this._events.post(IGroup.SET_CREATEUSERID, argCreateUserId);
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
/* 222 */       this._events.post(IGroup.SET_UPDATEDATE, argUpdateDate);
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
/* 256 */       this._events.post(IGroup.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getConfigElement() {
/* 279 */     return getDAO_().getConfigElement();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 287 */     if (setConfigElement_noev(argConfigElement) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(IGroup.SET_CONFIGELEMENT, argConfigElement);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConfigElement_noev(String argConfigElement) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getConfigElement() == null && argConfigElement != null) || (
/* 300 */       getDAO_().getConfigElement() != null && !getDAO_().getConfigElement().equals(argConfigElement))) {
/* 301 */       getDAO_().setConfigElement(argConfigElement);
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
/*     */   public int getBitmapPosition() {
/* 313 */     if (getDAO_().getBitmapPosition() != null) {
/* 314 */       return getDAO_().getBitmapPosition().intValue();
/*     */     }
/*     */     
/* 317 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBitmapPosition(int argBitmapPosition) {
/* 326 */     if (setBitmapPosition_noev(argBitmapPosition) && 
/* 327 */       this._events != null && 
/* 328 */       postEventsForChanges()) {
/* 329 */       this._events.post(IGroup.SET_BITMAPPOSITION, Integer.valueOf(argBitmapPosition));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBitmapPosition_noev(int argBitmapPosition) {
/* 336 */     boolean ev_postable = false;
/*     */     
/* 338 */     if ((getDAO_().getBitmapPosition() == null && Integer.valueOf(argBitmapPosition) != null) || (
/* 339 */       getDAO_().getBitmapPosition() != null && !getDAO_().getBitmapPosition().equals(Integer.valueOf(argBitmapPosition)))) {
/* 340 */       getDAO_().setBitmapPosition(Integer.valueOf(argBitmapPosition));
/* 341 */       ev_postable = true;
/*     */     } 
/*     */     
/* 344 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 352 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 360 */     if (setDescription_noev(argDescription) && 
/* 361 */       this._events != null && 
/* 362 */       postEventsForChanges()) {
/* 363 */       this._events.post(IGroup.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 370 */     boolean ev_postable = false;
/*     */     
/* 372 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 373 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 374 */       getDAO_().setDescription(argDescription);
/* 375 */       ev_postable = true;
/*     */     } 
/*     */     
/* 378 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGroupRank() {
/* 386 */     if (getDAO_().getGroupRank() != null) {
/* 387 */       return getDAO_().getGroupRank().intValue();
/*     */     }
/*     */     
/* 390 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupRank(int argGroupRank) {
/* 399 */     if (setGroupRank_noev(argGroupRank) && 
/* 400 */       this._events != null && 
/* 401 */       postEventsForChanges()) {
/* 402 */       this._events.post(IGroup.SET_GROUPRANK, Integer.valueOf(argGroupRank));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setGroupRank_noev(int argGroupRank) {
/* 409 */     boolean ev_postable = false;
/*     */     
/* 411 */     if ((getDAO_().getGroupRank() == null && Integer.valueOf(argGroupRank) != null) || (
/* 412 */       getDAO_().getGroupRank() != null && !getDAO_().getGroupRank().equals(Integer.valueOf(argGroupRank)))) {
/* 413 */       getDAO_().setGroupRank(Integer.valueOf(argGroupRank));
/* 414 */       ev_postable = true;
/*     */     } 
/*     */     
/* 417 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IGroupProperty newProperty(String argPropertyName) {
/* 421 */     GroupPropertyId id = new GroupPropertyId();
/*     */     
/* 423 */     id.setGroupId(getGroupId());
/* 424 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 426 */     IGroupProperty prop = (IGroupProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IGroupProperty.class);
/* 427 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IGroupProperty> getProperties() {
/* 436 */     if (this._properties == null) {
/* 437 */       this._properties = new HistoricalList(null);
/*     */     }
/* 439 */     return (List<IGroupProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IGroupProperty> argProperties) {
/* 443 */     if (this._properties == null) {
/* 444 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 446 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 449 */     for (IGroupProperty child : this._properties) {
/* 450 */       GroupPropertyModel model = (GroupPropertyModel)child;
/* 451 */       model.setGroupId_noev(getGroupId());
/* 452 */       model.setOrganizationId_noev(getOrganizationId());
/* 453 */       if (child instanceof IDataModelImpl) {
/* 454 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 455 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 456 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 457 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 460 */       if (postEventsForChanges()) {
/* 461 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addGroupProperty(IGroupProperty argGroupProperty) {
/* 467 */     if (this._properties == null) {
/* 468 */       this._properties = new HistoricalList(null);
/*     */     }
/* 470 */     argGroupProperty.setGroupId(getGroupId());
/* 471 */     argGroupProperty.setOrganizationId(getOrganizationId());
/* 472 */     if (argGroupProperty instanceof IDataModelImpl) {
/* 473 */       IDataAccessObject childDao = ((IDataModelImpl)argGroupProperty).getDAO();
/* 474 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 475 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 476 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 481 */     if (postEventsForChanges()) {
/* 482 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argGroupProperty));
/*     */     }
/*     */     
/* 485 */     this._properties.add(argGroupProperty);
/* 486 */     if (postEventsForChanges()) {
/* 487 */       this._events.post(IGroup.ADD_PROPERTIES, argGroupProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeGroupProperty(IGroupProperty argGroupProperty) {
/* 492 */     if (this._properties != null) {
/*     */       
/* 494 */       if (postEventsForChanges()) {
/* 495 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argGroupProperty));
/*     */       }
/* 497 */       this._properties.remove(argGroupProperty);
/* 498 */       if (postEventsForChanges()) {
/* 499 */         this._events.post(IGroup.REMOVE_PROPERTIES, argGroupProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 506 */     if ("Properties".equals(argFieldId)) {
/* 507 */       return getProperties();
/*     */     }
/* 509 */     if ("GroupExtension".equals(argFieldId)) {
/* 510 */       return this._myExtension;
/*     */     }
/*     */     
/* 513 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 519 */     if ("Properties".equals(argFieldId)) {
/* 520 */       setProperties(changeToList(argValue, IGroupProperty.class));
/*     */     }
/* 522 */     else if ("GroupExtension".equals(argFieldId)) {
/* 523 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 526 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 532 */     this._persistenceDefaults = argPD;
/* 533 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 534 */     this._eventManager = argEM;
/* 535 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 536 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 537 */     if (this._properties != null) {
/* 538 */       for (IGroupProperty relationship : this._properties) {
/* 539 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getGroupExt() {
/* 545 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setGroupExt(IDataModel argExt) {
/* 549 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 554 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 558 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 561 */     super.startTransaction();
/*     */     
/* 563 */     this._propertiesSavepoint = this._properties;
/* 564 */     if (this._properties != null) {
/* 565 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 566 */       Iterator<IDataModel> it = this._properties.iterator();
/* 567 */       while (it.hasNext()) {
/* 568 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 573 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 578 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 581 */     super.rollbackChanges();
/*     */     
/* 583 */     this._properties = this._propertiesSavepoint;
/* 584 */     this._propertiesSavepoint = null;
/* 585 */     if (this._properties != null) {
/* 586 */       Iterator<IDataModel> it = this._properties.iterator();
/* 587 */       while (it.hasNext()) {
/* 588 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 596 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 599 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 602 */     super.commitTransaction();
/*     */     
/* 604 */     this._propertiesSavepoint = this._properties;
/* 605 */     if (this._properties != null) {
/* 606 */       Iterator<IDataModel> it = this._properties.iterator();
/* 607 */       while (it.hasNext()) {
/* 608 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 610 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 614 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 619 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\GroupModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */