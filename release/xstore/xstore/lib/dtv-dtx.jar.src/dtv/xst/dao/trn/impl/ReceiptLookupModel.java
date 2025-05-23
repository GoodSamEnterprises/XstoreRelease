/*     */ package dtv.xst.dao.trn.impl;
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
/*     */ import dtv.xst.dao.trn.IReceiptLookup;
/*     */ import dtv.xst.dao.trn.IReceiptLookupProperty;
/*     */ import dtv.xst.dao.trn.ReceiptLookupPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ReceiptLookupModel extends AbstractDataModelWithPropertyImpl<IReceiptLookupProperty> implements IReceiptLookup {
/*     */   private static final long serialVersionUID = 660712882L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IReceiptLookupProperty> _properties; private transient HistoricalList<IReceiptLookupProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ReceiptLookupDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ReceiptLookupDAO getDAO_() {
/*  46 */     return (ReceiptLookupDAO)this._daoImpl;
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
/*  70 */       this._events.post(IReceiptLookup.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ReceiptLookupPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ReceiptLookupPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(IReceiptLookup.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 132 */         Iterator<ReceiptLookupPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((ReceiptLookupPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/* 164 */       this._events.post(IReceiptLookup.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
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
/* 179 */         Iterator<ReceiptLookupPropertyModel> it = this._properties.iterator();
/* 180 */         while (it.hasNext())
/*     */         {
/* 182 */           ((ReceiptLookupPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/*     */   public Date getBusinessDate() {
/* 195 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 203 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(IReceiptLookup.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 216 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 217 */       getDAO_().setBusinessDate(argBusinessDate);
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<ReceiptLookupPropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((ReceiptLookupPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*     */   public long getTransactionSequence() {
/* 237 */     if (getDAO_().getTransactionSequence() != null) {
/* 238 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 241 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 250 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 251 */       this._events != null && 
/* 252 */       postEventsForChanges()) {
/* 253 */       this._events.post(IReceiptLookup.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 260 */     boolean ev_postable = false;
/*     */     
/* 262 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 263 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 264 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 265 */       ev_postable = true;
/* 266 */       if (this._properties != null) {
/*     */         
/* 268 */         Iterator<ReceiptLookupPropertyModel> it = this._properties.iterator();
/* 269 */         while (it.hasNext())
/*     */         {
/* 271 */           ((ReceiptLookupPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 276 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReceiptId() {
/* 284 */     return getDAO_().getReceiptId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReceiptId(String argReceiptId) {
/* 292 */     if (setReceiptId_noev(argReceiptId) && 
/* 293 */       this._events != null && 
/* 294 */       postEventsForChanges()) {
/* 295 */       this._events.post(IReceiptLookup.SET_RECEIPTID, argReceiptId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReceiptId_noev(String argReceiptId) {
/* 302 */     boolean ev_postable = false;
/*     */     
/* 304 */     if ((getDAO_().getReceiptId() == null && argReceiptId != null) || (
/* 305 */       getDAO_().getReceiptId() != null && !getDAO_().getReceiptId().equals(argReceiptId))) {
/* 306 */       getDAO_().setReceiptId(argReceiptId);
/* 307 */       ev_postable = true;
/* 308 */       if (this._properties != null) {
/*     */         
/* 310 */         Iterator<ReceiptLookupPropertyModel> it = this._properties.iterator();
/* 311 */         while (it.hasNext())
/*     */         {
/* 313 */           ((ReceiptLookupPropertyModel)it.next()).setReceiptId_noev(argReceiptId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 318 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 326 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 334 */     if (setCreateDate_noev(argCreateDate) && 
/* 335 */       this._events != null && 
/* 336 */       postEventsForChanges()) {
/* 337 */       this._events.post(IReceiptLookup.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 344 */     boolean ev_postable = false;
/*     */     
/* 346 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 347 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 348 */       getDAO_().setCreateDate(argCreateDate);
/* 349 */       ev_postable = true;
/*     */     } 
/*     */     
/* 352 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 360 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 368 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 369 */       this._events != null && 
/* 370 */       postEventsForChanges()) {
/* 371 */       this._events.post(IReceiptLookup.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 378 */     boolean ev_postable = false;
/*     */     
/* 380 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 381 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 382 */       getDAO_().setCreateUserId(argCreateUserId);
/* 383 */       ev_postable = true;
/*     */     } 
/*     */     
/* 386 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 394 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 402 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 403 */       this._events != null && 
/* 404 */       postEventsForChanges()) {
/* 405 */       this._events.post(IReceiptLookup.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 412 */     boolean ev_postable = false;
/*     */     
/* 414 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 415 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 416 */       getDAO_().setUpdateDate(argUpdateDate);
/* 417 */       ev_postable = true;
/*     */     } 
/*     */     
/* 420 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 428 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 436 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 437 */       this._events != null && 
/* 438 */       postEventsForChanges()) {
/* 439 */       this._events.post(IReceiptLookup.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 446 */     boolean ev_postable = false;
/*     */     
/* 448 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 449 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 450 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 451 */       ev_postable = true;
/*     */     } 
/*     */     
/* 454 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReceiptUrl() {
/* 462 */     return getDAO_().getReceiptUrl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReceiptUrl(String argReceiptUrl) {
/* 470 */     if (setReceiptUrl_noev(argReceiptUrl) && 
/* 471 */       this._events != null && 
/* 472 */       postEventsForChanges()) {
/* 473 */       this._events.post(IReceiptLookup.SET_RECEIPTURL, argReceiptUrl);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReceiptUrl_noev(String argReceiptUrl) {
/* 480 */     boolean ev_postable = false;
/*     */     
/* 482 */     if ((getDAO_().getReceiptUrl() == null && argReceiptUrl != null) || (
/* 483 */       getDAO_().getReceiptUrl() != null && !getDAO_().getReceiptUrl().equals(argReceiptUrl))) {
/* 484 */       getDAO_().setReceiptUrl(argReceiptUrl);
/* 485 */       ev_postable = true;
/*     */     } 
/*     */     
/* 488 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IReceiptLookupProperty newProperty(String argPropertyName) {
/* 492 */     ReceiptLookupPropertyId id = new ReceiptLookupPropertyId();
/*     */     
/* 494 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 495 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 496 */     id.setBusinessDate(getBusinessDate());
/* 497 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 498 */     id.setReceiptId(getReceiptId());
/* 499 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 501 */     IReceiptLookupProperty prop = (IReceiptLookupProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IReceiptLookupProperty.class);
/* 502 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IReceiptLookupProperty> getProperties() {
/* 511 */     if (this._properties == null) {
/* 512 */       this._properties = new HistoricalList(null);
/*     */     }
/* 514 */     return (List<IReceiptLookupProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IReceiptLookupProperty> argProperties) {
/* 518 */     if (this._properties == null) {
/* 519 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 521 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 524 */     for (IReceiptLookupProperty child : this._properties) {
/* 525 */       ReceiptLookupPropertyModel model = (ReceiptLookupPropertyModel)child;
/* 526 */       model.setOrganizationId_noev(getOrganizationId());
/* 527 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 528 */       model.setWorkstationId_noev(getWorkstationId());
/* 529 */       model.setBusinessDate_noev(getBusinessDate());
/* 530 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 531 */       model.setReceiptId_noev(getReceiptId());
/* 532 */       if (child instanceof IDataModelImpl) {
/* 533 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 534 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 535 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 536 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 539 */       if (postEventsForChanges()) {
/* 540 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addReceiptLookupProperty(IReceiptLookupProperty argReceiptLookupProperty) {
/* 546 */     if (this._properties == null) {
/* 547 */       this._properties = new HistoricalList(null);
/*     */     }
/* 549 */     argReceiptLookupProperty.setOrganizationId(getOrganizationId());
/* 550 */     argReceiptLookupProperty.setRetailLocationId(getRetailLocationId());
/* 551 */     argReceiptLookupProperty.setWorkstationId(getWorkstationId());
/* 552 */     argReceiptLookupProperty.setBusinessDate(getBusinessDate());
/* 553 */     argReceiptLookupProperty.setTransactionSequence(getTransactionSequence());
/* 554 */     argReceiptLookupProperty.setReceiptId(getReceiptId());
/* 555 */     if (argReceiptLookupProperty instanceof IDataModelImpl) {
/* 556 */       IDataAccessObject childDao = ((IDataModelImpl)argReceiptLookupProperty).getDAO();
/* 557 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 558 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 559 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 564 */     if (postEventsForChanges()) {
/* 565 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReceiptLookupProperty));
/*     */     }
/*     */     
/* 568 */     this._properties.add(argReceiptLookupProperty);
/* 569 */     if (postEventsForChanges()) {
/* 570 */       this._events.post(IReceiptLookup.ADD_PROPERTIES, argReceiptLookupProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeReceiptLookupProperty(IReceiptLookupProperty argReceiptLookupProperty) {
/* 575 */     if (this._properties != null) {
/*     */       
/* 577 */       if (postEventsForChanges()) {
/* 578 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReceiptLookupProperty));
/*     */       }
/* 580 */       this._properties.remove(argReceiptLookupProperty);
/* 581 */       if (postEventsForChanges()) {
/* 582 */         this._events.post(IReceiptLookup.REMOVE_PROPERTIES, argReceiptLookupProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 589 */     if ("Properties".equals(argFieldId)) {
/* 590 */       return getProperties();
/*     */     }
/* 592 */     if ("ReceiptLookupExtension".equals(argFieldId)) {
/* 593 */       return this._myExtension;
/*     */     }
/*     */     
/* 596 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 602 */     if ("Properties".equals(argFieldId)) {
/* 603 */       setProperties(changeToList(argValue, IReceiptLookupProperty.class));
/*     */     }
/* 605 */     else if ("ReceiptLookupExtension".equals(argFieldId)) {
/* 606 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 609 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 615 */     this._persistenceDefaults = argPD;
/* 616 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 617 */     this._eventManager = argEM;
/* 618 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 619 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 620 */     if (this._properties != null) {
/* 621 */       for (IReceiptLookupProperty relationship : this._properties) {
/* 622 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getReceiptLookupExt() {
/* 628 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setReceiptLookupExt(IDataModel argExt) {
/* 632 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 637 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 641 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 644 */     super.startTransaction();
/*     */     
/* 646 */     this._propertiesSavepoint = this._properties;
/* 647 */     if (this._properties != null) {
/* 648 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 649 */       Iterator<IDataModel> it = this._properties.iterator();
/* 650 */       while (it.hasNext()) {
/* 651 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 656 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 661 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 664 */     super.rollbackChanges();
/*     */     
/* 666 */     this._properties = this._propertiesSavepoint;
/* 667 */     this._propertiesSavepoint = null;
/* 668 */     if (this._properties != null) {
/* 669 */       Iterator<IDataModel> it = this._properties.iterator();
/* 670 */       while (it.hasNext()) {
/* 671 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 679 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 682 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 685 */     super.commitTransaction();
/*     */     
/* 687 */     this._propertiesSavepoint = this._properties;
/* 688 */     if (this._properties != null) {
/* 689 */       Iterator<IDataModel> it = this._properties.iterator();
/* 690 */       while (it.hasNext()) {
/* 691 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 693 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 697 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 702 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\ReceiptLookupModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */