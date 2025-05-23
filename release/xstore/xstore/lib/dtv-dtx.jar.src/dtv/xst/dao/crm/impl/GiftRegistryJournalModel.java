/*     */ package dtv.xst.dao.crm.impl;
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
/*     */ import dtv.xst.dao.crm.GiftRegistryJournalPropertyId;
/*     */ import dtv.xst.dao.crm.IGiftRegistryJournal;
/*     */ import dtv.xst.dao.crm.IGiftRegistryJournalProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class GiftRegistryJournalModel extends AbstractDataModelWithPropertyImpl<IGiftRegistryJournalProperty> implements IGiftRegistryJournal {
/*     */   private static final long serialVersionUID = -909944630L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IGiftRegistryJournalProperty> _properties; private transient HistoricalList<IGiftRegistryJournalProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new GiftRegistryJournalDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private GiftRegistryJournalDAO getDAO_() {
/*  46 */     return (GiftRegistryJournalDAO)this._daoImpl;
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
/*  70 */       this._events.post(IGiftRegistryJournal.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<GiftRegistryJournalPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((GiftRegistryJournalPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getJournalSequence() {
/* 101 */     if (getDAO_().getJournalSequence() != null) {
/* 102 */       return getDAO_().getJournalSequence().longValue();
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
/*     */   public void setJournalSequence(long argJournalSequence) {
/* 114 */     if (setJournalSequence_noev(argJournalSequence) && 
/* 115 */       this._events != null && 
/* 116 */       postEventsForChanges()) {
/* 117 */       this._events.post(IGiftRegistryJournal.SET_JOURNALSEQUENCE, Long.valueOf(argJournalSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setJournalSequence_noev(long argJournalSequence) {
/* 124 */     boolean ev_postable = false;
/*     */     
/* 126 */     if ((getDAO_().getJournalSequence() == null && Long.valueOf(argJournalSequence) != null) || (
/* 127 */       getDAO_().getJournalSequence() != null && !getDAO_().getJournalSequence().equals(Long.valueOf(argJournalSequence)))) {
/* 128 */       getDAO_().setJournalSequence(Long.valueOf(argJournalSequence));
/* 129 */       ev_postable = true;
/* 130 */       if (this._properties != null) {
/*     */         
/* 132 */         Iterator<GiftRegistryJournalPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((GiftRegistryJournalPropertyModel)it.next()).setJournalSequence_noev(argJournalSequence);
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
/* 159 */       this._events.post(IGiftRegistryJournal.SET_CREATEDATE, argCreateDate);
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
/* 193 */       this._events.post(IGiftRegistryJournal.SET_CREATEUSERID, argCreateUserId);
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
/* 227 */       this._events.post(IGiftRegistryJournal.SET_UPDATEDATE, argUpdateDate);
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
/* 261 */       this._events.post(IGiftRegistryJournal.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public long getRegistryId() {
/* 284 */     if (getDAO_().getRegistryId() != null) {
/* 285 */       return getDAO_().getRegistryId().longValue();
/*     */     }
/*     */     
/* 288 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRegistryId(long argRegistryId) {
/* 297 */     if (setRegistryId_noev(argRegistryId) && 
/* 298 */       this._events != null && 
/* 299 */       postEventsForChanges()) {
/* 300 */       this._events.post(IGiftRegistryJournal.SET_REGISTRYID, Long.valueOf(argRegistryId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRegistryId_noev(long argRegistryId) {
/* 307 */     boolean ev_postable = false;
/*     */     
/* 309 */     if ((getDAO_().getRegistryId() == null && Long.valueOf(argRegistryId) != null) || (
/* 310 */       getDAO_().getRegistryId() != null && !getDAO_().getRegistryId().equals(Long.valueOf(argRegistryId)))) {
/* 311 */       getDAO_().setRegistryId(Long.valueOf(argRegistryId));
/* 312 */       ev_postable = true;
/*     */     } 
/*     */     
/* 315 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActionCode() {
/* 323 */     return getDAO_().getActionCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActionCode(String argActionCode) {
/* 331 */     if (setActionCode_noev(argActionCode) && 
/* 332 */       this._events != null && 
/* 333 */       postEventsForChanges()) {
/* 334 */       this._events.post(IGiftRegistryJournal.SET_ACTIONCODE, argActionCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActionCode_noev(String argActionCode) {
/* 341 */     boolean ev_postable = false;
/*     */     
/* 343 */     if ((getDAO_().getActionCode() == null && argActionCode != null) || (
/* 344 */       getDAO_().getActionCode() != null && !getDAO_().getActionCode().equals(argActionCode))) {
/* 345 */       getDAO_().setActionCode(argActionCode);
/* 346 */       ev_postable = true;
/*     */     } 
/*     */     
/* 349 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRegistryStatus() {
/* 357 */     return getDAO_().getRegistryStatus();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRegistryStatus(String argRegistryStatus) {
/* 365 */     if (setRegistryStatus_noev(argRegistryStatus) && 
/* 366 */       this._events != null && 
/* 367 */       postEventsForChanges()) {
/* 368 */       this._events.post(IGiftRegistryJournal.SET_REGISTRYSTATUS, argRegistryStatus);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRegistryStatus_noev(String argRegistryStatus) {
/* 375 */     boolean ev_postable = false;
/*     */     
/* 377 */     if ((getDAO_().getRegistryStatus() == null && argRegistryStatus != null) || (
/* 378 */       getDAO_().getRegistryStatus() != null && !getDAO_().getRegistryStatus().equals(argRegistryStatus))) {
/* 379 */       getDAO_().setRegistryStatus(argRegistryStatus);
/* 380 */       ev_postable = true;
/*     */     } 
/*     */     
/* 383 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransRetailLocationId() {
/* 391 */     if (getDAO_().getTransRetailLocationId() != null) {
/* 392 */       return getDAO_().getTransRetailLocationId().longValue();
/*     */     }
/*     */     
/* 395 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransRetailLocationId(long argTransRetailLocationId) {
/* 404 */     if (setTransRetailLocationId_noev(argTransRetailLocationId) && 
/* 405 */       this._events != null && 
/* 406 */       postEventsForChanges()) {
/* 407 */       this._events.post(IGiftRegistryJournal.SET_TRANSRETAILLOCATIONID, Long.valueOf(argTransRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransRetailLocationId_noev(long argTransRetailLocationId) {
/* 414 */     boolean ev_postable = false;
/*     */     
/* 416 */     if ((getDAO_().getTransRetailLocationId() == null && Long.valueOf(argTransRetailLocationId) != null) || (
/* 417 */       getDAO_().getTransRetailLocationId() != null && !getDAO_().getTransRetailLocationId().equals(Long.valueOf(argTransRetailLocationId)))) {
/* 418 */       getDAO_().setTransRetailLocationId(Long.valueOf(argTransRetailLocationId));
/* 419 */       ev_postable = true;
/*     */     } 
/*     */     
/* 422 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransWorkstationId() {
/* 430 */     if (getDAO_().getTransWorkstationId() != null) {
/* 431 */       return getDAO_().getTransWorkstationId().longValue();
/*     */     }
/*     */     
/* 434 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransWorkstationId(long argTransWorkstationId) {
/* 443 */     if (setTransWorkstationId_noev(argTransWorkstationId) && 
/* 444 */       this._events != null && 
/* 445 */       postEventsForChanges()) {
/* 446 */       this._events.post(IGiftRegistryJournal.SET_TRANSWORKSTATIONID, Long.valueOf(argTransWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransWorkstationId_noev(long argTransWorkstationId) {
/* 453 */     boolean ev_postable = false;
/*     */     
/* 455 */     if ((getDAO_().getTransWorkstationId() == null && Long.valueOf(argTransWorkstationId) != null) || (
/* 456 */       getDAO_().getTransWorkstationId() != null && !getDAO_().getTransWorkstationId().equals(Long.valueOf(argTransWorkstationId)))) {
/* 457 */       getDAO_().setTransWorkstationId(Long.valueOf(argTransWorkstationId));
/* 458 */       ev_postable = true;
/*     */     } 
/*     */     
/* 461 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getTransBusinessDate() {
/* 469 */     return getDAO_().getTransBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransBusinessDate(Date argTransBusinessDate) {
/* 477 */     if (setTransBusinessDate_noev(argTransBusinessDate) && 
/* 478 */       this._events != null && 
/* 479 */       postEventsForChanges()) {
/* 480 */       this._events.post(IGiftRegistryJournal.SET_TRANSBUSINESSDATE, argTransBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransBusinessDate_noev(Date argTransBusinessDate) {
/* 487 */     boolean ev_postable = false;
/*     */     
/* 489 */     if ((getDAO_().getTransBusinessDate() == null && argTransBusinessDate != null) || (
/* 490 */       getDAO_().getTransBusinessDate() != null && !getDAO_().getTransBusinessDate().equals(argTransBusinessDate))) {
/* 491 */       getDAO_().setTransBusinessDate(argTransBusinessDate);
/* 492 */       ev_postable = true;
/*     */     } 
/*     */     
/* 495 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransSequence() {
/* 503 */     if (getDAO_().getTransSequence() != null) {
/* 504 */       return getDAO_().getTransSequence().longValue();
/*     */     }
/*     */     
/* 507 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransSequence(long argTransSequence) {
/* 516 */     if (setTransSequence_noev(argTransSequence) && 
/* 517 */       this._events != null && 
/* 518 */       postEventsForChanges()) {
/* 519 */       this._events.post(IGiftRegistryJournal.SET_TRANSSEQUENCE, Long.valueOf(argTransSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransSequence_noev(long argTransSequence) {
/* 526 */     boolean ev_postable = false;
/*     */     
/* 528 */     if ((getDAO_().getTransSequence() == null && Long.valueOf(argTransSequence) != null) || (
/* 529 */       getDAO_().getTransSequence() != null && !getDAO_().getTransSequence().equals(Long.valueOf(argTransSequence)))) {
/* 530 */       getDAO_().setTransSequence(Long.valueOf(argTransSequence));
/* 531 */       ev_postable = true;
/*     */     } 
/*     */     
/* 534 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IGiftRegistryJournalProperty newProperty(String argPropertyName) {
/* 538 */     GiftRegistryJournalPropertyId id = new GiftRegistryJournalPropertyId();
/*     */     
/* 540 */     id.setJournalSequence(Long.valueOf(getJournalSequence()));
/* 541 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 543 */     IGiftRegistryJournalProperty prop = (IGiftRegistryJournalProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IGiftRegistryJournalProperty.class);
/* 544 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IGiftRegistryJournalProperty> getProperties() {
/* 553 */     if (this._properties == null) {
/* 554 */       this._properties = new HistoricalList(null);
/*     */     }
/* 556 */     return (List<IGiftRegistryJournalProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IGiftRegistryJournalProperty> argProperties) {
/* 560 */     if (this._properties == null) {
/* 561 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 563 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 566 */     for (IGiftRegistryJournalProperty child : this._properties) {
/* 567 */       GiftRegistryJournalPropertyModel model = (GiftRegistryJournalPropertyModel)child;
/* 568 */       model.setOrganizationId_noev(getOrganizationId());
/* 569 */       model.setJournalSequence_noev(getJournalSequence());
/* 570 */       if (child instanceof IDataModelImpl) {
/* 571 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 572 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 573 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 574 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 577 */       if (postEventsForChanges()) {
/* 578 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addGiftRegistryJournalProperty(IGiftRegistryJournalProperty argGiftRegistryJournalProperty) {
/* 584 */     if (this._properties == null) {
/* 585 */       this._properties = new HistoricalList(null);
/*     */     }
/* 587 */     argGiftRegistryJournalProperty.setOrganizationId(getOrganizationId());
/* 588 */     argGiftRegistryJournalProperty.setJournalSequence(getJournalSequence());
/* 589 */     if (argGiftRegistryJournalProperty instanceof IDataModelImpl) {
/* 590 */       IDataAccessObject childDao = ((IDataModelImpl)argGiftRegistryJournalProperty).getDAO();
/* 591 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 592 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 593 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 598 */     if (postEventsForChanges()) {
/* 599 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argGiftRegistryJournalProperty));
/*     */     }
/*     */     
/* 602 */     this._properties.add(argGiftRegistryJournalProperty);
/* 603 */     if (postEventsForChanges()) {
/* 604 */       this._events.post(IGiftRegistryJournal.ADD_PROPERTIES, argGiftRegistryJournalProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeGiftRegistryJournalProperty(IGiftRegistryJournalProperty argGiftRegistryJournalProperty) {
/* 609 */     if (this._properties != null) {
/*     */       
/* 611 */       if (postEventsForChanges()) {
/* 612 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argGiftRegistryJournalProperty));
/*     */       }
/* 614 */       this._properties.remove(argGiftRegistryJournalProperty);
/* 615 */       if (postEventsForChanges()) {
/* 616 */         this._events.post(IGiftRegistryJournal.REMOVE_PROPERTIES, argGiftRegistryJournalProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 623 */     if ("Properties".equals(argFieldId)) {
/* 624 */       return getProperties();
/*     */     }
/* 626 */     if ("GiftRegistryJournalExtension".equals(argFieldId)) {
/* 627 */       return this._myExtension;
/*     */     }
/*     */     
/* 630 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 636 */     if ("Properties".equals(argFieldId)) {
/* 637 */       setProperties(changeToList(argValue, IGiftRegistryJournalProperty.class));
/*     */     }
/* 639 */     else if ("GiftRegistryJournalExtension".equals(argFieldId)) {
/* 640 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 643 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 649 */     this._persistenceDefaults = argPD;
/* 650 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 651 */     this._eventManager = argEM;
/* 652 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 653 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 654 */     if (this._properties != null) {
/* 655 */       for (IGiftRegistryJournalProperty relationship : this._properties) {
/* 656 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getGiftRegistryJournalExt() {
/* 662 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setGiftRegistryJournalExt(IDataModel argExt) {
/* 666 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 671 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 675 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 678 */     super.startTransaction();
/*     */     
/* 680 */     this._propertiesSavepoint = this._properties;
/* 681 */     if (this._properties != null) {
/* 682 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 683 */       Iterator<IDataModel> it = this._properties.iterator();
/* 684 */       while (it.hasNext()) {
/* 685 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 690 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 695 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 698 */     super.rollbackChanges();
/*     */     
/* 700 */     this._properties = this._propertiesSavepoint;
/* 701 */     this._propertiesSavepoint = null;
/* 702 */     if (this._properties != null) {
/* 703 */       Iterator<IDataModel> it = this._properties.iterator();
/* 704 */       while (it.hasNext()) {
/* 705 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 713 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 716 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 719 */     super.commitTransaction();
/*     */     
/* 721 */     this._propertiesSavepoint = this._properties;
/* 722 */     if (this._properties != null) {
/* 723 */       Iterator<IDataModel> it = this._properties.iterator();
/* 724 */       while (it.hasNext()) {
/* 725 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 727 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 731 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 736 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\GiftRegistryJournalModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */