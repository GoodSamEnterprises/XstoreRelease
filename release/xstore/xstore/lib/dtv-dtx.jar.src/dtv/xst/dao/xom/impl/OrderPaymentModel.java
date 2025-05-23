/*     */ package dtv.xst.dao.xom.impl;
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
/*     */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*     */ import dtv.xst.dao.xom.IOrder;
/*     */ import dtv.xst.dao.xom.IOrderPayment;
/*     */ import dtv.xst.dao.xom.IOrderPaymentProperty;
/*     */ import dtv.xst.dao.xom.OrderDetailType;
/*     */ import dtv.xst.dao.xom.OrderPaymentPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class OrderPaymentModel extends AbstractDataModelWithPropertyImpl<IOrderPaymentProperty> implements IOrderPayment {
/*     */   private static final long serialVersionUID = 267674360L;
/*     */   private IOrder _parentOrder;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IOrderPaymentProperty> _properties; private transient HistoricalList<IOrderPaymentProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new OrderPaymentDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private OrderPaymentDAO getDAO_() {
/*  48 */     return (OrderPaymentDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  56 */     if (getDAO_().getOrganizationId() != null) {
/*  57 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  60 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  69 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  70 */       this._events != null && 
/*  71 */       postEventsForChanges()) {
/*  72 */       this._events.post(IOrderPayment.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  79 */     boolean ev_postable = false;
/*     */     
/*  81 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  82 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  83 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  84 */       ev_postable = true;
/*  85 */       if (this._properties != null) {
/*     */         
/*  87 */         Iterator<OrderPaymentPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((OrderPaymentPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrderId() {
/* 103 */     return getDAO_().getOrderId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/* 111 */     if (setOrderId_noev(argOrderId) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(IOrderPayment.SET_ORDERID, argOrderId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrderId_noev(String argOrderId) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getOrderId() == null && argOrderId != null) || (
/* 124 */       getDAO_().getOrderId() != null && !getDAO_().getOrderId().equals(argOrderId))) {
/* 125 */       getDAO_().setOrderId(argOrderId);
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<OrderPaymentPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((OrderPaymentPropertyModel)it.next()).setOrderId_noev(argOrderId);
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
/*     */   public int getSequence() {
/* 145 */     if (getDAO_().getSequence() != null) {
/* 146 */       return getDAO_().getSequence().intValue();
/*     */     }
/*     */     
/* 149 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequence(int argSequence) {
/* 158 */     if (setSequence_noev(argSequence) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(IOrderPayment.SET_SEQUENCE, Integer.valueOf(argSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequence_noev(int argSequence) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getSequence() == null && Integer.valueOf(argSequence) != null) || (
/* 171 */       getDAO_().getSequence() != null && !getDAO_().getSequence().equals(Integer.valueOf(argSequence)))) {
/* 172 */       getDAO_().setSequence(Integer.valueOf(argSequence));
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<OrderPaymentPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((OrderPaymentPropertyModel)it.next()).setSequence_noev(argSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 184 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 192 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 200 */     if (setCreateDate_noev(argCreateDate) && 
/* 201 */       this._events != null && 
/* 202 */       postEventsForChanges()) {
/* 203 */       this._events.post(IOrderPayment.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 210 */     boolean ev_postable = false;
/*     */     
/* 212 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 213 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 214 */       getDAO_().setCreateDate(argCreateDate);
/* 215 */       ev_postable = true;
/*     */     } 
/*     */     
/* 218 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 226 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 234 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 235 */       this._events != null && 
/* 236 */       postEventsForChanges()) {
/* 237 */       this._events.post(IOrderPayment.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 244 */     boolean ev_postable = false;
/*     */     
/* 246 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 247 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 248 */       getDAO_().setCreateUserId(argCreateUserId);
/* 249 */       ev_postable = true;
/*     */     } 
/*     */     
/* 252 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 260 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 268 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 269 */       this._events != null && 
/* 270 */       postEventsForChanges()) {
/* 271 */       this._events.post(IOrderPayment.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 278 */     boolean ev_postable = false;
/*     */     
/* 280 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 281 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 282 */       getDAO_().setUpdateDate(argUpdateDate);
/* 283 */       ev_postable = true;
/*     */     } 
/*     */     
/* 286 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 294 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 302 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 303 */       this._events != null && 
/* 304 */       postEventsForChanges()) {
/* 305 */       this._events.post(IOrderPayment.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 312 */     boolean ev_postable = false;
/*     */     
/* 314 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 315 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 316 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 317 */       ev_postable = true;
/*     */     } 
/*     */     
/* 320 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTypeCode() {
/* 328 */     return getDAO_().getTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 336 */     if (setTypeCode_noev(argTypeCode) && 
/* 337 */       this._events != null && 
/* 338 */       postEventsForChanges()) {
/* 339 */       this._events.post(IOrderPayment.SET_TYPECODE, argTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTypeCode_noev(String argTypeCode) {
/* 346 */     boolean ev_postable = false;
/*     */     
/* 348 */     if ((getDAO_().getTypeCode() == null && argTypeCode != null) || (
/* 349 */       getDAO_().getTypeCode() != null && !getDAO_().getTypeCode().equals(argTypeCode))) {
/* 350 */       getDAO_().setTypeCode(argTypeCode);
/* 351 */       ev_postable = true;
/*     */     } 
/*     */     
/* 354 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/* 362 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 370 */     if (setItemId_noev(argItemId) && 
/* 371 */       this._events != null && 
/* 372 */       postEventsForChanges()) {
/* 373 */       this._events.post(IOrderPayment.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 380 */     boolean ev_postable = false;
/*     */     
/* 382 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 383 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 384 */       getDAO_().setItemId(argItemId);
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
/*     */   public BigDecimal getAmount() {
/* 396 */     return getDAO_().getAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 404 */     if (setAmount_noev(argAmount) && 
/* 405 */       this._events != null && 
/* 406 */       postEventsForChanges()) {
/* 407 */       this._events.post(IOrderPayment.SET_AMOUNT, argAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAmount_noev(BigDecimal argAmount) {
/* 414 */     boolean ev_postable = false;
/*     */     
/* 416 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/* 417 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/* 418 */       getDAO_().setAmount(argAmount);
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
/*     */   public boolean getVoid() {
/* 430 */     if (getDAO_().getVoid() != null) {
/* 431 */       return getDAO_().getVoid().booleanValue();
/*     */     }
/*     */     
/* 434 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoid(boolean argVoid) {
/* 443 */     if (setVoid_noev(argVoid) && 
/* 444 */       this._events != null && 
/* 445 */       postEventsForChanges()) {
/* 446 */       this._events.post(IOrderPayment.SET_VOID, Boolean.valueOf(argVoid));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoid_noev(boolean argVoid) {
/* 453 */     boolean ev_postable = false;
/*     */     
/* 455 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/* 456 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/* 457 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/* 458 */       ev_postable = true;
/*     */     } 
/*     */     
/* 461 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IOrderPaymentProperty newProperty(String argPropertyName) {
/* 465 */     OrderPaymentPropertyId id = new OrderPaymentPropertyId();
/*     */     
/* 467 */     id.setOrderId(getOrderId());
/* 468 */     id.setSequence(Integer.valueOf(getSequence()));
/* 469 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 471 */     IOrderPaymentProperty prop = (IOrderPaymentProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IOrderPaymentProperty.class);
/* 472 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IOrderPaymentProperty> getProperties() {
/* 481 */     if (this._properties == null) {
/* 482 */       this._properties = new HistoricalList(null);
/*     */     }
/* 484 */     return (List<IOrderPaymentProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IOrderPaymentProperty> argProperties) {
/* 488 */     if (this._properties == null) {
/* 489 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 491 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 494 */     for (IOrderPaymentProperty child : this._properties) {
/* 495 */       OrderPaymentPropertyModel model = (OrderPaymentPropertyModel)child;
/* 496 */       model.setOrganizationId_noev(getOrganizationId());
/* 497 */       model.setOrderId_noev(getOrderId());
/* 498 */       model.setSequence_noev(getSequence());
/* 499 */       if (child instanceof IDataModelImpl) {
/* 500 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 501 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 502 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 503 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 506 */       if (postEventsForChanges()) {
/* 507 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addOrderPaymentProperty(IOrderPaymentProperty argOrderPaymentProperty) {
/* 513 */     if (this._properties == null) {
/* 514 */       this._properties = new HistoricalList(null);
/*     */     }
/* 516 */     argOrderPaymentProperty.setOrganizationId(getOrganizationId());
/* 517 */     argOrderPaymentProperty.setOrderId(getOrderId());
/* 518 */     argOrderPaymentProperty.setSequence(getSequence());
/* 519 */     if (argOrderPaymentProperty instanceof IDataModelImpl) {
/* 520 */       IDataAccessObject childDao = ((IDataModelImpl)argOrderPaymentProperty).getDAO();
/* 521 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 522 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 523 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 528 */     if (postEventsForChanges()) {
/* 529 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderPaymentProperty));
/*     */     }
/*     */     
/* 532 */     this._properties.add(argOrderPaymentProperty);
/* 533 */     if (postEventsForChanges()) {
/* 534 */       this._events.post(IOrderPayment.ADD_PROPERTIES, argOrderPaymentProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeOrderPaymentProperty(IOrderPaymentProperty argOrderPaymentProperty) {
/* 539 */     if (this._properties != null) {
/*     */       
/* 541 */       if (postEventsForChanges()) {
/* 542 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderPaymentProperty));
/*     */       }
/* 544 */       this._properties.remove(argOrderPaymentProperty);
/* 545 */       if (postEventsForChanges()) {
/* 546 */         this._events.post(IOrderPayment.REMOVE_PROPERTIES, argOrderPaymentProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentOrder(IOrder argParentOrder) {
/* 552 */     this._parentOrder = argParentOrder;
/*     */   }
/*     */   
/*     */   public IOrder getParentOrder() {
/* 556 */     return this._parentOrder;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 561 */     if ("Properties".equals(argFieldId)) {
/* 562 */       return getProperties();
/*     */     }
/* 564 */     if ("OrderPaymentExtension".equals(argFieldId)) {
/* 565 */       return this._myExtension;
/*     */     }
/*     */     
/* 568 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 574 */     if ("Properties".equals(argFieldId)) {
/* 575 */       setProperties(changeToList(argValue, IOrderPaymentProperty.class));
/*     */     }
/* 577 */     else if ("OrderPaymentExtension".equals(argFieldId)) {
/* 578 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 581 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 587 */     this._persistenceDefaults = argPD;
/* 588 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 589 */     this._eventManager = argEM;
/* 590 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 591 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 592 */     if (this._properties != null) {
/* 593 */       for (IOrderPaymentProperty relationship : this._properties) {
/* 594 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getOrderPaymentExt() {
/* 600 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setOrderPaymentExt(IDataModel argExt) {
/* 604 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 609 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 613 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 616 */     super.startTransaction();
/*     */     
/* 618 */     this._propertiesSavepoint = this._properties;
/* 619 */     if (this._properties != null) {
/* 620 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 621 */       Iterator<IDataModel> it = this._properties.iterator();
/* 622 */       while (it.hasNext()) {
/* 623 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 628 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 633 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 636 */     super.rollbackChanges();
/*     */     
/* 638 */     this._properties = this._propertiesSavepoint;
/* 639 */     this._propertiesSavepoint = null;
/* 640 */     if (this._properties != null) {
/* 641 */       Iterator<IDataModel> it = this._properties.iterator();
/* 642 */       while (it.hasNext()) {
/* 643 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 651 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 654 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 657 */     super.commitTransaction();
/*     */     
/* 659 */     this._propertiesSavepoint = this._properties;
/* 660 */     if (this._properties != null) {
/* 661 */       Iterator<IDataModel> it = this._properties.iterator();
/* 662 */       while (it.hasNext()) {
/* 663 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 665 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 669 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 674 */     argStream.defaultReadObject();
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
/*     */   
/* 686 */   private transient ISaleReturnLineItem _shadowedSaleItem = null;
/*     */ 
/*     */   
/*     */   public ISaleReturnLineItem getShadowedSaleItem() {
/* 690 */     return this._shadowedSaleItem;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setShadowedSaleItem(ISaleReturnLineItem argSaleItem) {
/* 695 */     this._shadowedSaleItem = argSaleItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OrderDetailType getDetailType() {
/* 701 */     return OrderDetailType.PAYMENT;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\OrderPaymentModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */