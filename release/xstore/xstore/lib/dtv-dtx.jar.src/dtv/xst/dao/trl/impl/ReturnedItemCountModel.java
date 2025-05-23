/*     */ package dtv.xst.dao.trl.impl;
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
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.trl.IReturnedItemCount;
/*     */ import dtv.xst.dao.trl.IReturnedItemCountProperty;
/*     */ import dtv.xst.dao.trl.ReturnedItemCountPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ReturnedItemCountModel extends AbstractDataModelWithPropertyImpl<IReturnedItemCountProperty> implements IReturnedItemCount {
/*     */   private static final long serialVersionUID = 1822266509L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IReturnedItemCountProperty> _properties; private transient HistoricalList<IReturnedItemCountProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ReturnedItemCountDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ReturnedItemCountDAO getDAO_() {
/*  46 */     return (ReturnedItemCountDAO)this._daoImpl;
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
/*  70 */       this._events.post(IReturnedItemCount.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ReturnedItemCountPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ReturnedItemCountPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(IReturnedItemCount.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 132 */         Iterator<ReturnedItemCountPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((ReturnedItemCountPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/* 164 */       this._events.post(IReturnedItemCount.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
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
/* 179 */         Iterator<ReturnedItemCountPropertyModel> it = this._properties.iterator();
/* 180 */         while (it.hasNext())
/*     */         {
/* 182 */           ((ReturnedItemCountPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/* 206 */       this._events.post(IReturnedItemCount.SET_BUSINESSDATE, argBusinessDate);
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
/* 221 */         Iterator<ReturnedItemCountPropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((ReturnedItemCountPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*     */   public int getRetailTransactionLineItemSequence() {
/* 237 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/* 238 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*     */     }
/*     */     
/* 241 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/* 250 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/* 251 */       this._events != null && 
/* 252 */       postEventsForChanges()) {
/* 253 */       this._events.post(IReturnedItemCount.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/* 260 */     boolean ev_postable = false;
/*     */     
/* 262 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/* 263 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/* 264 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/* 265 */       ev_postable = true;
/* 266 */       if (this._properties != null) {
/*     */         
/* 268 */         Iterator<ReturnedItemCountPropertyModel> it = this._properties.iterator();
/* 269 */         while (it.hasNext())
/*     */         {
/* 271 */           ((ReturnedItemCountPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
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
/*     */   public long getTransactionSequence() {
/* 284 */     if (getDAO_().getTransactionSequence() != null) {
/* 285 */       return getDAO_().getTransactionSequence().longValue();
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
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 297 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 298 */       this._events != null && 
/* 299 */       postEventsForChanges()) {
/* 300 */       this._events.post(IReturnedItemCount.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 307 */     boolean ev_postable = false;
/*     */     
/* 309 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 310 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 311 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 312 */       ev_postable = true;
/* 313 */       if (this._properties != null) {
/*     */         
/* 315 */         Iterator<ReturnedItemCountPropertyModel> it = this._properties.iterator();
/* 316 */         while (it.hasNext())
/*     */         {
/* 318 */           ((ReturnedItemCountPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
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
/* 342 */       this._events.post(IReturnedItemCount.SET_CREATEDATE, argCreateDate);
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
/* 376 */       this._events.post(IReturnedItemCount.SET_CREATEUSERID, argCreateUserId);
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
/* 410 */       this._events.post(IReturnedItemCount.SET_UPDATEDATE, argUpdateDate);
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
/* 444 */       this._events.post(IReturnedItemCount.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public BigDecimal getReturnedCount() {
/* 467 */     return getDAO_().getReturnedCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReturnedCount(BigDecimal argReturnedCount) {
/* 475 */     if (setReturnedCount_noev(argReturnedCount) && 
/* 476 */       this._events != null && 
/* 477 */       postEventsForChanges()) {
/* 478 */       this._events.post(IReturnedItemCount.SET_RETURNEDCOUNT, argReturnedCount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReturnedCount_noev(BigDecimal argReturnedCount) {
/* 485 */     boolean ev_postable = false;
/*     */     
/* 487 */     if ((getDAO_().getReturnedCount() == null && argReturnedCount != null) || (
/* 488 */       getDAO_().getReturnedCount() != null && !getDAO_().getReturnedCount().equals(argReturnedCount))) {
/* 489 */       getDAO_().setReturnedCount(argReturnedCount);
/* 490 */       ev_postable = true;
/*     */     } 
/*     */     
/* 493 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IReturnedItemCountProperty newProperty(String argPropertyName) {
/* 497 */     ReturnedItemCountPropertyId id = new ReturnedItemCountPropertyId();
/*     */     
/* 499 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 500 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 501 */     id.setBusinessDate(getBusinessDate());
/* 502 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/* 503 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 504 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 506 */     IReturnedItemCountProperty prop = (IReturnedItemCountProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IReturnedItemCountProperty.class);
/* 507 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IReturnedItemCountProperty> getProperties() {
/* 516 */     if (this._properties == null) {
/* 517 */       this._properties = new HistoricalList(null);
/*     */     }
/* 519 */     return (List<IReturnedItemCountProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IReturnedItemCountProperty> argProperties) {
/* 523 */     if (this._properties == null) {
/* 524 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 526 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 529 */     for (IReturnedItemCountProperty child : this._properties) {
/* 530 */       ReturnedItemCountPropertyModel model = (ReturnedItemCountPropertyModel)child;
/* 531 */       model.setOrganizationId_noev(getOrganizationId());
/* 532 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 533 */       model.setWorkstationId_noev(getWorkstationId());
/* 534 */       model.setBusinessDate_noev(getBusinessDate());
/* 535 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 536 */       model.setTransactionSequence_noev(getTransactionSequence());
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
/*     */   public void addReturnedItemCountProperty(IReturnedItemCountProperty argReturnedItemCountProperty) {
/* 551 */     if (this._properties == null) {
/* 552 */       this._properties = new HistoricalList(null);
/*     */     }
/* 554 */     argReturnedItemCountProperty.setOrganizationId(getOrganizationId());
/* 555 */     argReturnedItemCountProperty.setRetailLocationId(getRetailLocationId());
/* 556 */     argReturnedItemCountProperty.setWorkstationId(getWorkstationId());
/* 557 */     argReturnedItemCountProperty.setBusinessDate(getBusinessDate());
/* 558 */     argReturnedItemCountProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 559 */     argReturnedItemCountProperty.setTransactionSequence(getTransactionSequence());
/* 560 */     if (argReturnedItemCountProperty instanceof IDataModelImpl) {
/* 561 */       IDataAccessObject childDao = ((IDataModelImpl)argReturnedItemCountProperty).getDAO();
/* 562 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 563 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 564 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 569 */     if (postEventsForChanges()) {
/* 570 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReturnedItemCountProperty));
/*     */     }
/*     */     
/* 573 */     this._properties.add(argReturnedItemCountProperty);
/* 574 */     if (postEventsForChanges()) {
/* 575 */       this._events.post(IReturnedItemCount.ADD_PROPERTIES, argReturnedItemCountProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeReturnedItemCountProperty(IReturnedItemCountProperty argReturnedItemCountProperty) {
/* 580 */     if (this._properties != null) {
/*     */       
/* 582 */       if (postEventsForChanges()) {
/* 583 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReturnedItemCountProperty));
/*     */       }
/* 585 */       this._properties.remove(argReturnedItemCountProperty);
/* 586 */       if (postEventsForChanges()) {
/* 587 */         this._events.post(IReturnedItemCount.REMOVE_PROPERTIES, argReturnedItemCountProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 594 */     if ("Properties".equals(argFieldId)) {
/* 595 */       return getProperties();
/*     */     }
/* 597 */     if ("ReturnedItemCountExtension".equals(argFieldId)) {
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
/* 608 */       setProperties(changeToList(argValue, IReturnedItemCountProperty.class));
/*     */     }
/* 610 */     else if ("ReturnedItemCountExtension".equals(argFieldId)) {
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
/* 626 */       for (IReturnedItemCountProperty relationship : this._properties) {
/* 627 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getReturnedItemCountExt() {
/* 633 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setReturnedItemCountExt(IDataModel argExt) {
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\ReturnedItemCountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */