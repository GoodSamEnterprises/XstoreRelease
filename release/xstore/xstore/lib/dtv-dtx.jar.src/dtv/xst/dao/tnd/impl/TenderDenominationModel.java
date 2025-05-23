/*     */ package dtv.xst.dao.tnd.impl;
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
/*     */ import dtv.xst.dao.tnd.ITender;
/*     */ import dtv.xst.dao.tnd.ITenderDenomination;
/*     */ import dtv.xst.dao.tnd.ITenderDenominationProperty;
/*     */ import dtv.xst.dao.tnd.TenderDenominationPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TenderDenominationModel extends AbstractDataModelWithPropertyImpl<ITenderDenominationProperty> implements ITenderDenomination {
/*     */   private static final long serialVersionUID = 1700067577L;
/*     */   private ITender _parentTender;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<ITenderDenominationProperty> _properties; private transient HistoricalList<ITenderDenominationProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new TenderDenominationDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TenderDenominationDAO getDAO_() {
/*  48 */     return (TenderDenominationDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDenominationId() {
/*  56 */     return getDAO_().getDenominationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDenominationId(String argDenominationId) {
/*  64 */     if (setDenominationId_noev(argDenominationId) && 
/*  65 */       this._events != null && 
/*  66 */       postEventsForChanges()) {
/*  67 */       this._events.post(ITenderDenomination.SET_DENOMINATIONID, argDenominationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDenominationId_noev(String argDenominationId) {
/*  74 */     boolean ev_postable = false;
/*     */     
/*  76 */     if ((getDAO_().getDenominationId() == null && argDenominationId != null) || (
/*  77 */       getDAO_().getDenominationId() != null && !getDAO_().getDenominationId().equals(argDenominationId))) {
/*  78 */       getDAO_().setDenominationId(argDenominationId);
/*  79 */       ev_postable = true;
/*  80 */       if (this._properties != null) {
/*     */         
/*  82 */         Iterator<TenderDenominationPropertyModel> it = this._properties.iterator();
/*  83 */         while (it.hasNext())
/*     */         {
/*  85 */           ((TenderDenominationPropertyModel)it.next()).setDenominationId_noev(argDenominationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  90 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  98 */     if (getDAO_().getOrganizationId() != null) {
/*  99 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 102 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 111 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(ITenderDenomination.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 124 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 125 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<TenderDenominationPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((TenderDenominationPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 137 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTenderId() {
/* 145 */     return getDAO_().getTenderId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/* 153 */     if (setTenderId_noev(argTenderId) && 
/* 154 */       this._events != null && 
/* 155 */       postEventsForChanges()) {
/* 156 */       this._events.post(ITenderDenomination.SET_TENDERID, argTenderId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTenderId_noev(String argTenderId) {
/* 163 */     boolean ev_postable = false;
/*     */     
/* 165 */     if ((getDAO_().getTenderId() == null && argTenderId != null) || (
/* 166 */       getDAO_().getTenderId() != null && !getDAO_().getTenderId().equals(argTenderId))) {
/* 167 */       getDAO_().setTenderId(argTenderId);
/* 168 */       ev_postable = true;
/* 169 */       if (this._properties != null) {
/*     */         
/* 171 */         Iterator<TenderDenominationPropertyModel> it = this._properties.iterator();
/* 172 */         while (it.hasNext())
/*     */         {
/* 174 */           ((TenderDenominationPropertyModel)it.next()).setTenderId_noev(argTenderId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 179 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 187 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 195 */     if (setCreateDate_noev(argCreateDate) && 
/* 196 */       this._events != null && 
/* 197 */       postEventsForChanges()) {
/* 198 */       this._events.post(ITenderDenomination.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 205 */     boolean ev_postable = false;
/*     */     
/* 207 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 208 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 209 */       getDAO_().setCreateDate(argCreateDate);
/* 210 */       ev_postable = true;
/*     */     } 
/*     */     
/* 213 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 221 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 229 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 230 */       this._events != null && 
/* 231 */       postEventsForChanges()) {
/* 232 */       this._events.post(ITenderDenomination.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 239 */     boolean ev_postable = false;
/*     */     
/* 241 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 242 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 243 */       getDAO_().setCreateUserId(argCreateUserId);
/* 244 */       ev_postable = true;
/*     */     } 
/*     */     
/* 247 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 255 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 263 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 264 */       this._events != null && 
/* 265 */       postEventsForChanges()) {
/* 266 */       this._events.post(ITenderDenomination.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 273 */     boolean ev_postable = false;
/*     */     
/* 275 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 276 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 277 */       getDAO_().setUpdateDate(argUpdateDate);
/* 278 */       ev_postable = true;
/*     */     } 
/*     */     
/* 281 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 289 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 297 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 298 */       this._events != null && 
/* 299 */       postEventsForChanges()) {
/* 300 */       this._events.post(ITenderDenomination.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 307 */     boolean ev_postable = false;
/*     */     
/* 309 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 310 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 311 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public String getDescription() {
/* 323 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 331 */     if (setDescription_noev(argDescription) && 
/* 332 */       this._events != null && 
/* 333 */       postEventsForChanges()) {
/* 334 */       this._events.post(ITenderDenomination.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 341 */     boolean ev_postable = false;
/*     */     
/* 343 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 344 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 345 */       getDAO_().setDescription(argDescription);
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
/*     */   public int getSortOrder() {
/* 357 */     if (getDAO_().getSortOrder() != null) {
/* 358 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 361 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 370 */     if (setSortOrder_noev(argSortOrder) && 
/* 371 */       this._events != null && 
/* 372 */       postEventsForChanges()) {
/* 373 */       this._events.post(ITenderDenomination.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 380 */     boolean ev_postable = false;
/*     */     
/* 382 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 383 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 384 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 385 */       ev_postable = true;
/*     */     } 
/*     */     
/* 388 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getValue() {
/* 396 */     return getDAO_().getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(BigDecimal argValue) {
/* 404 */     if (setValue_noev(argValue) && 
/* 405 */       this._events != null && 
/* 406 */       postEventsForChanges()) {
/* 407 */       this._events.post(ITenderDenomination.SET_VALUE, argValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setValue_noev(BigDecimal argValue) {
/* 414 */     boolean ev_postable = false;
/*     */     
/* 416 */     if ((getDAO_().getValue() == null && argValue != null) || (
/* 417 */       getDAO_().getValue() != null && !getDAO_().getValue().equals(argValue))) {
/* 418 */       getDAO_().setValue(argValue);
/* 419 */       ev_postable = true;
/*     */     } 
/*     */     
/* 422 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITenderDenominationProperty newProperty(String argPropertyName) {
/* 426 */     TenderDenominationPropertyId id = new TenderDenominationPropertyId();
/*     */     
/* 428 */     id.setDenominationId(getDenominationId());
/* 429 */     id.setTenderId(getTenderId());
/* 430 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 432 */     ITenderDenominationProperty prop = (ITenderDenominationProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITenderDenominationProperty.class);
/* 433 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITenderDenominationProperty> getProperties() {
/* 442 */     if (this._properties == null) {
/* 443 */       this._properties = new HistoricalList(null);
/*     */     }
/* 445 */     return (List<ITenderDenominationProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITenderDenominationProperty> argProperties) {
/* 449 */     if (this._properties == null) {
/* 450 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 452 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 455 */     for (ITenderDenominationProperty child : this._properties) {
/* 456 */       TenderDenominationPropertyModel model = (TenderDenominationPropertyModel)child;
/* 457 */       model.setDenominationId_noev(getDenominationId());
/* 458 */       model.setOrganizationId_noev(getOrganizationId());
/* 459 */       model.setTenderId_noev(getTenderId());
/* 460 */       if (child instanceof IDataModelImpl) {
/* 461 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 462 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 463 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 464 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 467 */       if (postEventsForChanges()) {
/* 468 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTenderDenominationProperty(ITenderDenominationProperty argTenderDenominationProperty) {
/* 474 */     if (this._properties == null) {
/* 475 */       this._properties = new HistoricalList(null);
/*     */     }
/* 477 */     argTenderDenominationProperty.setDenominationId(getDenominationId());
/* 478 */     argTenderDenominationProperty.setOrganizationId(getOrganizationId());
/* 479 */     argTenderDenominationProperty.setTenderId(getTenderId());
/* 480 */     if (argTenderDenominationProperty instanceof IDataModelImpl) {
/* 481 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderDenominationProperty).getDAO();
/* 482 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 483 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 484 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 489 */     if (postEventsForChanges()) {
/* 490 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderDenominationProperty));
/*     */     }
/*     */     
/* 493 */     this._properties.add(argTenderDenominationProperty);
/* 494 */     if (postEventsForChanges()) {
/* 495 */       this._events.post(ITenderDenomination.ADD_PROPERTIES, argTenderDenominationProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTenderDenominationProperty(ITenderDenominationProperty argTenderDenominationProperty) {
/* 500 */     if (this._properties != null) {
/*     */       
/* 502 */       if (postEventsForChanges()) {
/* 503 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderDenominationProperty));
/*     */       }
/* 505 */       this._properties.remove(argTenderDenominationProperty);
/* 506 */       if (postEventsForChanges()) {
/* 507 */         this._events.post(ITenderDenomination.REMOVE_PROPERTIES, argTenderDenominationProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentTender(ITender argParentTender) {
/* 513 */     this._parentTender = argParentTender;
/*     */   }
/*     */   
/*     */   public ITender getParentTender() {
/* 517 */     return this._parentTender;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 522 */     if ("Properties".equals(argFieldId)) {
/* 523 */       return getProperties();
/*     */     }
/* 525 */     if ("TenderDenominationExtension".equals(argFieldId)) {
/* 526 */       return this._myExtension;
/*     */     }
/*     */     
/* 529 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 535 */     if ("Properties".equals(argFieldId)) {
/* 536 */       setProperties(changeToList(argValue, ITenderDenominationProperty.class));
/*     */     }
/* 538 */     else if ("TenderDenominationExtension".equals(argFieldId)) {
/* 539 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 542 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 548 */     this._persistenceDefaults = argPD;
/* 549 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 550 */     this._eventManager = argEM;
/* 551 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 552 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 553 */     if (this._properties != null) {
/* 554 */       for (ITenderDenominationProperty relationship : this._properties) {
/* 555 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTenderDenominationExt() {
/* 561 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTenderDenominationExt(IDataModel argExt) {
/* 565 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 570 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 574 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 577 */     super.startTransaction();
/*     */     
/* 579 */     this._propertiesSavepoint = this._properties;
/* 580 */     if (this._properties != null) {
/* 581 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 582 */       Iterator<IDataModel> it = this._properties.iterator();
/* 583 */       while (it.hasNext()) {
/* 584 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 589 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 594 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 597 */     super.rollbackChanges();
/*     */     
/* 599 */     this._properties = this._propertiesSavepoint;
/* 600 */     this._propertiesSavepoint = null;
/* 601 */     if (this._properties != null) {
/* 602 */       Iterator<IDataModel> it = this._properties.iterator();
/* 603 */       while (it.hasNext()) {
/* 604 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 612 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 615 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 618 */     super.commitTransaction();
/*     */     
/* 620 */     this._propertiesSavepoint = this._properties;
/* 621 */     if (this._properties != null) {
/* 622 */       Iterator<IDataModel> it = this._properties.iterator();
/* 623 */       while (it.hasNext()) {
/* 624 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 626 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 630 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 635 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderDenominationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */