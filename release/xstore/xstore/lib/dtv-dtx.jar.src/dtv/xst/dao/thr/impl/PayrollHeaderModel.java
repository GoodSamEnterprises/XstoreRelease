/*     */ package dtv.xst.dao.thr.impl;
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
/*     */ import dtv.xst.dao.thr.IPayrollHeader;
/*     */ import dtv.xst.dao.thr.IPayrollHeaderProperty;
/*     */ import dtv.xst.dao.thr.PayrollHeaderPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class PayrollHeaderModel extends AbstractDataModelWithPropertyImpl<IPayrollHeaderProperty> implements IPayrollHeader {
/*     */   private static final long serialVersionUID = -1972081678L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IPayrollHeaderProperty> _properties; private transient HistoricalList<IPayrollHeaderProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new PayrollHeaderDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PayrollHeaderDAO getDAO_() {
/*  46 */     return (PayrollHeaderDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocId() {
/*  54 */     if (getDAO_().getRetailLocId() != null) {
/*  55 */       return getDAO_().getRetailLocId().longValue();
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
/*     */   public void setRetailLocId(long argRetailLocId) {
/*  67 */     if (setRetailLocId_noev(argRetailLocId) && 
/*  68 */       this._events != null && 
/*  69 */       postEventsForChanges()) {
/*  70 */       this._events.post(IPayrollHeader.SET_RETAILLOCID, Long.valueOf(argRetailLocId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocId_noev(long argRetailLocId) {
/*  77 */     boolean ev_postable = false;
/*     */     
/*  79 */     if ((getDAO_().getRetailLocId() == null && Long.valueOf(argRetailLocId) != null) || (
/*  80 */       getDAO_().getRetailLocId() != null && !getDAO_().getRetailLocId().equals(Long.valueOf(argRetailLocId)))) {
/*  81 */       getDAO_().setRetailLocId(Long.valueOf(argRetailLocId));
/*  82 */       ev_postable = true;
/*  83 */       if (this._properties != null) {
/*     */         
/*  85 */         Iterator<PayrollHeaderPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((PayrollHeaderPropertyModel)it.next()).setRetailLocId_noev(argRetailLocId);
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
/*     */   public long getPartyId() {
/* 101 */     if (getDAO_().getPartyId() != null) {
/* 102 */       return getDAO_().getPartyId().longValue();
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
/*     */   public void setPartyId(long argPartyId) {
/* 114 */     if (setPartyId_noev(argPartyId) && 
/* 115 */       this._events != null && 
/* 116 */       postEventsForChanges()) {
/* 117 */       this._events.post(IPayrollHeader.SET_PARTYID, Long.valueOf(argPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPartyId_noev(long argPartyId) {
/* 124 */     boolean ev_postable = false;
/*     */     
/* 126 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/* 127 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/* 128 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/* 129 */       ev_postable = true;
/* 130 */       if (this._properties != null) {
/*     */         
/* 132 */         Iterator<PayrollHeaderPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((PayrollHeaderPropertyModel)it.next()).setPartyId_noev(argPartyId);
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
/*     */   public long getOrganizationId() {
/* 148 */     if (getDAO_().getOrganizationId() != null) {
/* 149 */       return getDAO_().getOrganizationId().longValue();
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
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 161 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 162 */       this._events != null && 
/* 163 */       postEventsForChanges()) {
/* 164 */       this._events.post(IPayrollHeader.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 171 */     boolean ev_postable = false;
/*     */     
/* 173 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 174 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 175 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 176 */       ev_postable = true;
/* 177 */       if (this._properties != null) {
/*     */         
/* 179 */         Iterator<PayrollHeaderPropertyModel> it = this._properties.iterator();
/* 180 */         while (it.hasNext())
/*     */         {
/* 182 */           ((PayrollHeaderPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public Date getWeekEndingDate() {
/* 195 */     return getDAO_().getWeekEndingDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWeekEndingDate(Date argWeekEndingDate) {
/* 203 */     if (setWeekEndingDate_noev(argWeekEndingDate) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(IPayrollHeader.SET_WEEKENDINGDATE, argWeekEndingDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWeekEndingDate_noev(Date argWeekEndingDate) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getWeekEndingDate() == null && argWeekEndingDate != null) || (
/* 216 */       getDAO_().getWeekEndingDate() != null && !getDAO_().getWeekEndingDate().equals(argWeekEndingDate))) {
/* 217 */       getDAO_().setWeekEndingDate(argWeekEndingDate);
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<PayrollHeaderPropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((PayrollHeaderPropertyModel)it.next()).setWeekEndingDate_noev(argWeekEndingDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 229 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 237 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 245 */     if (setCreateDate_noev(argCreateDate) && 
/* 246 */       this._events != null && 
/* 247 */       postEventsForChanges()) {
/* 248 */       this._events.post(IPayrollHeader.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 255 */     boolean ev_postable = false;
/*     */     
/* 257 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 258 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 259 */       getDAO_().setCreateDate(argCreateDate);
/* 260 */       ev_postable = true;
/*     */     } 
/*     */     
/* 263 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 271 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 279 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 280 */       this._events != null && 
/* 281 */       postEventsForChanges()) {
/* 282 */       this._events.post(IPayrollHeader.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 289 */     boolean ev_postable = false;
/*     */     
/* 291 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 292 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 293 */       getDAO_().setCreateUserId(argCreateUserId);
/* 294 */       ev_postable = true;
/*     */     } 
/*     */     
/* 297 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 305 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 313 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 314 */       this._events != null && 
/* 315 */       postEventsForChanges()) {
/* 316 */       this._events.post(IPayrollHeader.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 323 */     boolean ev_postable = false;
/*     */     
/* 325 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 326 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 327 */       getDAO_().setUpdateDate(argUpdateDate);
/* 328 */       ev_postable = true;
/*     */     } 
/*     */     
/* 331 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 339 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 347 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 348 */       this._events != null && 
/* 349 */       postEventsForChanges()) {
/* 350 */       this._events.post(IPayrollHeader.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 357 */     boolean ev_postable = false;
/*     */     
/* 359 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 360 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 361 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 362 */       ev_postable = true;
/*     */     } 
/*     */     
/* 365 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getReviewedDate() {
/* 373 */     return getDAO_().getReviewedDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReviewedDate(Date argReviewedDate) {
/* 381 */     if (setReviewedDate_noev(argReviewedDate) && 
/* 382 */       this._events != null && 
/* 383 */       postEventsForChanges()) {
/* 384 */       this._events.post(IPayrollHeader.SET_REVIEWEDDATE, argReviewedDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReviewedDate_noev(Date argReviewedDate) {
/* 391 */     boolean ev_postable = false;
/*     */     
/* 393 */     if ((getDAO_().getReviewedDate() == null && argReviewedDate != null) || (
/* 394 */       getDAO_().getReviewedDate() != null && !getDAO_().getReviewedDate().equals(argReviewedDate))) {
/* 395 */       getDAO_().setReviewedDate(argReviewedDate);
/* 396 */       ev_postable = true;
/*     */     } 
/*     */     
/* 399 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IPayrollHeaderProperty newProperty(String argPropertyName) {
/* 403 */     PayrollHeaderPropertyId id = new PayrollHeaderPropertyId();
/*     */     
/* 405 */     id.setRetailLocId(Long.valueOf(getRetailLocId()));
/* 406 */     id.setPartyId(Long.valueOf(getPartyId()));
/* 407 */     id.setWeekEndingDate(getWeekEndingDate());
/* 408 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 410 */     IPayrollHeaderProperty prop = (IPayrollHeaderProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPayrollHeaderProperty.class);
/* 411 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IPayrollHeaderProperty> getProperties() {
/* 420 */     if (this._properties == null) {
/* 421 */       this._properties = new HistoricalList(null);
/*     */     }
/* 423 */     return (List<IPayrollHeaderProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IPayrollHeaderProperty> argProperties) {
/* 427 */     if (this._properties == null) {
/* 428 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 430 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 433 */     for (IPayrollHeaderProperty child : this._properties) {
/* 434 */       PayrollHeaderPropertyModel model = (PayrollHeaderPropertyModel)child;
/* 435 */       model.setRetailLocId_noev(getRetailLocId());
/* 436 */       model.setPartyId_noev(getPartyId());
/* 437 */       model.setOrganizationId_noev(getOrganizationId());
/* 438 */       model.setWeekEndingDate_noev(getWeekEndingDate());
/* 439 */       if (child instanceof IDataModelImpl) {
/* 440 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 441 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 442 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 443 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 446 */       if (postEventsForChanges()) {
/* 447 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addPayrollHeaderProperty(IPayrollHeaderProperty argPayrollHeaderProperty) {
/* 453 */     if (this._properties == null) {
/* 454 */       this._properties = new HistoricalList(null);
/*     */     }
/* 456 */     argPayrollHeaderProperty.setRetailLocId(getRetailLocId());
/* 457 */     argPayrollHeaderProperty.setPartyId(getPartyId());
/* 458 */     argPayrollHeaderProperty.setOrganizationId(getOrganizationId());
/* 459 */     argPayrollHeaderProperty.setWeekEndingDate(getWeekEndingDate());
/* 460 */     if (argPayrollHeaderProperty instanceof IDataModelImpl) {
/* 461 */       IDataAccessObject childDao = ((IDataModelImpl)argPayrollHeaderProperty).getDAO();
/* 462 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 463 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 464 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 469 */     if (postEventsForChanges()) {
/* 470 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPayrollHeaderProperty));
/*     */     }
/*     */     
/* 473 */     this._properties.add(argPayrollHeaderProperty);
/* 474 */     if (postEventsForChanges()) {
/* 475 */       this._events.post(IPayrollHeader.ADD_PROPERTIES, argPayrollHeaderProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePayrollHeaderProperty(IPayrollHeaderProperty argPayrollHeaderProperty) {
/* 480 */     if (this._properties != null) {
/*     */       
/* 482 */       if (postEventsForChanges()) {
/* 483 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPayrollHeaderProperty));
/*     */       }
/* 485 */       this._properties.remove(argPayrollHeaderProperty);
/* 486 */       if (postEventsForChanges()) {
/* 487 */         this._events.post(IPayrollHeader.REMOVE_PROPERTIES, argPayrollHeaderProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 494 */     if ("Properties".equals(argFieldId)) {
/* 495 */       return getProperties();
/*     */     }
/* 497 */     if ("PayrollHeaderExtension".equals(argFieldId)) {
/* 498 */       return this._myExtension;
/*     */     }
/*     */     
/* 501 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 507 */     if ("Properties".equals(argFieldId)) {
/* 508 */       setProperties(changeToList(argValue, IPayrollHeaderProperty.class));
/*     */     }
/* 510 */     else if ("PayrollHeaderExtension".equals(argFieldId)) {
/* 511 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 514 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 520 */     this._persistenceDefaults = argPD;
/* 521 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 522 */     this._eventManager = argEM;
/* 523 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 524 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 525 */     if (this._properties != null) {
/* 526 */       for (IPayrollHeaderProperty relationship : this._properties) {
/* 527 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getPayrollHeaderExt() {
/* 533 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setPayrollHeaderExt(IDataModel argExt) {
/* 537 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 542 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 546 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 549 */     super.startTransaction();
/*     */     
/* 551 */     this._propertiesSavepoint = this._properties;
/* 552 */     if (this._properties != null) {
/* 553 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 554 */       Iterator<IDataModel> it = this._properties.iterator();
/* 555 */       while (it.hasNext()) {
/* 556 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 561 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 566 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 569 */     super.rollbackChanges();
/*     */     
/* 571 */     this._properties = this._propertiesSavepoint;
/* 572 */     this._propertiesSavepoint = null;
/* 573 */     if (this._properties != null) {
/* 574 */       Iterator<IDataModel> it = this._properties.iterator();
/* 575 */       while (it.hasNext()) {
/* 576 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 584 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 587 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 590 */     super.commitTransaction();
/*     */     
/* 592 */     this._propertiesSavepoint = this._properties;
/* 593 */     if (this._properties != null) {
/* 594 */       Iterator<IDataModel> it = this._properties.iterator();
/* 595 */       while (it.hasNext()) {
/* 596 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 598 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 602 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 607 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\PayrollHeaderModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */