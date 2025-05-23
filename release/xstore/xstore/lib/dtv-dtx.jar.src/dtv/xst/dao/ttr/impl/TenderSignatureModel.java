/*     */ package dtv.xst.dao.ttr.impl;
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
/*     */ import dtv.xst.dao.ttr.ITenderSignature;
/*     */ import dtv.xst.dao.ttr.ITenderSignatureProperty;
/*     */ import dtv.xst.dao.ttr.TenderSignaturePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TenderSignatureModel extends AbstractDataModelWithPropertyImpl<ITenderSignatureProperty> implements ITenderSignature {
/*     */   private static final long serialVersionUID = 1418685476L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ITenderSignatureProperty> _properties; private transient HistoricalList<ITenderSignatureProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new TenderSignatureDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TenderSignatureDAO getDAO_() {
/*  46 */     return (TenderSignatureDAO)this._daoImpl;
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
/*  70 */       this._events.post(ITenderSignature.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<TenderSignaturePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((TenderSignaturePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(ITenderSignature.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 132 */         Iterator<TenderSignaturePropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((TenderSignaturePropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public Date getBusinessDate() {
/* 148 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 156 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(ITenderSignature.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 169 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 170 */       getDAO_().setBusinessDate(argBusinessDate);
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<TenderSignaturePropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((TenderSignaturePropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 190 */     if (getDAO_().getWorkstationId() != null) {
/* 191 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 194 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 203 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(ITenderSignature.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 216 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 217 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<TenderSignaturePropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((TenderSignaturePropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/* 253 */       this._events.post(ITenderSignature.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
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
/* 268 */         Iterator<TenderSignaturePropertyModel> it = this._properties.iterator();
/* 269 */         while (it.hasNext())
/*     */         {
/* 271 */           ((TenderSignaturePropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
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
/*     */   public int getRetailTransactionLineItemSequence() {
/* 284 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/* 285 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*     */     }
/*     */     
/* 288 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/* 297 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/* 298 */       this._events != null && 
/* 299 */       postEventsForChanges()) {
/* 300 */       this._events.post(ITenderSignature.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/* 307 */     boolean ev_postable = false;
/*     */     
/* 309 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/* 310 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/* 311 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/* 312 */       ev_postable = true;
/* 313 */       if (this._properties != null) {
/*     */         
/* 315 */         Iterator<TenderSignaturePropertyModel> it = this._properties.iterator();
/* 316 */         while (it.hasNext())
/*     */         {
/* 318 */           ((TenderSignaturePropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 323 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 331 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 339 */     if (setCreateDate_noev(argCreateDate) && 
/* 340 */       this._events != null && 
/* 341 */       postEventsForChanges()) {
/* 342 */       this._events.post(ITenderSignature.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 349 */     boolean ev_postable = false;
/*     */     
/* 351 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 352 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 353 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 365 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 373 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 374 */       this._events != null && 
/* 375 */       postEventsForChanges()) {
/* 376 */       this._events.post(ITenderSignature.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 383 */     boolean ev_postable = false;
/*     */     
/* 385 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 386 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 387 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 399 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 407 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 408 */       this._events != null && 
/* 409 */       postEventsForChanges()) {
/* 410 */       this._events.post(ITenderSignature.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 417 */     boolean ev_postable = false;
/*     */     
/* 419 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 420 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 421 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 433 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 441 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 442 */       this._events != null && 
/* 443 */       postEventsForChanges()) {
/* 444 */       this._events.post(ITenderSignature.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 451 */     boolean ev_postable = false;
/*     */     
/* 453 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 454 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 455 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public String getSignature() {
/* 467 */     return getDAO_().getSignature();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSignature(String argSignature) {
/* 475 */     if (setSignature_noev(argSignature) && 
/* 476 */       this._events != null && 
/* 477 */       postEventsForChanges()) {
/* 478 */       this._events.post(ITenderSignature.SET_SIGNATURE, argSignature);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSignature_noev(String argSignature) {
/* 485 */     boolean ev_postable = false;
/*     */     
/* 487 */     if ((getDAO_().getSignature() == null && argSignature != null) || (
/* 488 */       getDAO_().getSignature() != null && !getDAO_().getSignature().equals(argSignature))) {
/* 489 */       getDAO_().setSignature(argSignature);
/* 490 */       ev_postable = true;
/*     */     } 
/*     */     
/* 493 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITenderSignatureProperty newProperty(String argPropertyName) {
/* 497 */     TenderSignaturePropertyId id = new TenderSignaturePropertyId();
/*     */     
/* 499 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 500 */     id.setBusinessDate(getBusinessDate());
/* 501 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 502 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 503 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/* 504 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 506 */     ITenderSignatureProperty prop = (ITenderSignatureProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITenderSignatureProperty.class);
/* 507 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITenderSignatureProperty> getProperties() {
/* 516 */     if (this._properties == null) {
/* 517 */       this._properties = new HistoricalList(null);
/*     */     }
/* 519 */     return (List<ITenderSignatureProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITenderSignatureProperty> argProperties) {
/* 523 */     if (this._properties == null) {
/* 524 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 526 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 529 */     for (ITenderSignatureProperty child : this._properties) {
/* 530 */       TenderSignaturePropertyModel model = (TenderSignaturePropertyModel)child;
/* 531 */       model.setOrganizationId_noev(getOrganizationId());
/* 532 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 533 */       model.setBusinessDate_noev(getBusinessDate());
/* 534 */       model.setWorkstationId_noev(getWorkstationId());
/* 535 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 536 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 537 */       if (child instanceof IDataModelImpl) {
/* 538 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 539 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 540 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 541 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 544 */       if (postEventsForChanges()) {
/* 545 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTenderSignatureProperty(ITenderSignatureProperty argTenderSignatureProperty) {
/* 551 */     if (this._properties == null) {
/* 552 */       this._properties = new HistoricalList(null);
/*     */     }
/* 554 */     argTenderSignatureProperty.setOrganizationId(getOrganizationId());
/* 555 */     argTenderSignatureProperty.setRetailLocationId(getRetailLocationId());
/* 556 */     argTenderSignatureProperty.setBusinessDate(getBusinessDate());
/* 557 */     argTenderSignatureProperty.setWorkstationId(getWorkstationId());
/* 558 */     argTenderSignatureProperty.setTransactionSequence(getTransactionSequence());
/* 559 */     argTenderSignatureProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 560 */     if (argTenderSignatureProperty instanceof IDataModelImpl) {
/* 561 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderSignatureProperty).getDAO();
/* 562 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 563 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 564 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 569 */     if (postEventsForChanges()) {
/* 570 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderSignatureProperty));
/*     */     }
/*     */     
/* 573 */     this._properties.add(argTenderSignatureProperty);
/* 574 */     if (postEventsForChanges()) {
/* 575 */       this._events.post(ITenderSignature.ADD_PROPERTIES, argTenderSignatureProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTenderSignatureProperty(ITenderSignatureProperty argTenderSignatureProperty) {
/* 580 */     if (this._properties != null) {
/*     */       
/* 582 */       if (postEventsForChanges()) {
/* 583 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderSignatureProperty));
/*     */       }
/* 585 */       this._properties.remove(argTenderSignatureProperty);
/* 586 */       if (postEventsForChanges()) {
/* 587 */         this._events.post(ITenderSignature.REMOVE_PROPERTIES, argTenderSignatureProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 594 */     if ("Properties".equals(argFieldId)) {
/* 595 */       return getProperties();
/*     */     }
/* 597 */     if ("TenderSignatureExtension".equals(argFieldId)) {
/* 598 */       return this._myExtension;
/*     */     }
/*     */     
/* 601 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 607 */     if ("Properties".equals(argFieldId)) {
/* 608 */       setProperties(changeToList(argValue, ITenderSignatureProperty.class));
/*     */     }
/* 610 */     else if ("TenderSignatureExtension".equals(argFieldId)) {
/* 611 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 614 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 620 */     this._persistenceDefaults = argPD;
/* 621 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 622 */     this._eventManager = argEM;
/* 623 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 624 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 625 */     if (this._properties != null) {
/* 626 */       for (ITenderSignatureProperty relationship : this._properties) {
/* 627 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTenderSignatureExt() {
/* 633 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTenderSignatureExt(IDataModel argExt) {
/* 637 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 642 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 646 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 649 */     super.startTransaction();
/*     */     
/* 651 */     this._propertiesSavepoint = this._properties;
/* 652 */     if (this._properties != null) {
/* 653 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 654 */       Iterator<IDataModel> it = this._properties.iterator();
/* 655 */       while (it.hasNext()) {
/* 656 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 661 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 666 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 669 */     super.rollbackChanges();
/*     */     
/* 671 */     this._properties = this._propertiesSavepoint;
/* 672 */     this._propertiesSavepoint = null;
/* 673 */     if (this._properties != null) {
/* 674 */       Iterator<IDataModel> it = this._properties.iterator();
/* 675 */       while (it.hasNext()) {
/* 676 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 684 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 687 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 690 */     super.commitTransaction();
/*     */     
/* 692 */     this._propertiesSavepoint = this._properties;
/* 693 */     if (this._properties != null) {
/* 694 */       Iterator<IDataModel> it = this._properties.iterator();
/* 695 */       while (it.hasNext()) {
/* 696 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 698 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 702 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 707 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\TenderSignatureModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */