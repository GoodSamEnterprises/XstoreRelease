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
/*     */ import dtv.xst.dao.xom.IOrderFee;
/*     */ import dtv.xst.dao.xom.IOrderFeeProperty;
/*     */ import dtv.xst.dao.xom.OrderDetailType;
/*     */ import dtv.xst.dao.xom.OrderFeePropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class OrderFeeModel extends AbstractDataModelWithPropertyImpl<IOrderFeeProperty> implements IOrderFee {
/*     */   private static final long serialVersionUID = 1298924920L;
/*     */   private IOrder _parentOrder;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IOrderFeeProperty> _properties; private transient HistoricalList<IOrderFeeProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new OrderFeeDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private OrderFeeDAO getDAO_() {
/*  48 */     return (OrderFeeDAO)this._daoImpl;
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
/*  72 */       this._events.post(IOrderFee.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<OrderFeePropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((OrderFeePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 114 */       this._events.post(IOrderFee.SET_ORDERID, argOrderId);
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
/* 129 */         Iterator<OrderFeePropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((OrderFeePropertyModel)it.next()).setOrderId_noev(argOrderId);
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
/* 161 */       this._events.post(IOrderFee.SET_SEQUENCE, Integer.valueOf(argSequence));
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
/* 176 */         Iterator<OrderFeePropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((OrderFeePropertyModel)it.next()).setSequence_noev(argSequence);
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
/* 203 */       this._events.post(IOrderFee.SET_CREATEDATE, argCreateDate);
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
/* 237 */       this._events.post(IOrderFee.SET_CREATEUSERID, argCreateUserId);
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
/* 271 */       this._events.post(IOrderFee.SET_UPDATEDATE, argUpdateDate);
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
/* 305 */       this._events.post(IOrderFee.SET_UPDATEUSERID, argUpdateUserId);
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
/* 339 */       this._events.post(IOrderFee.SET_TYPECODE, argTypeCode);
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
/* 373 */       this._events.post(IOrderFee.SET_ITEMID, argItemId);
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
/* 407 */       this._events.post(IOrderFee.SET_AMOUNT, argAmount);
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
/*     */   public BigDecimal getTaxAmount() {
/* 430 */     return getDAO_().getTaxAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxAmount(BigDecimal argTaxAmount) {
/* 438 */     if (setTaxAmount_noev(argTaxAmount) && 
/* 439 */       this._events != null && 
/* 440 */       postEventsForChanges()) {
/* 441 */       this._events.post(IOrderFee.SET_TAXAMOUNT, argTaxAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxAmount_noev(BigDecimal argTaxAmount) {
/* 448 */     boolean ev_postable = false;
/*     */     
/* 450 */     if ((getDAO_().getTaxAmount() == null && argTaxAmount != null) || (
/* 451 */       getDAO_().getTaxAmount() != null && !getDAO_().getTaxAmount().equals(argTaxAmount))) {
/* 452 */       getDAO_().setTaxAmount(argTaxAmount);
/* 453 */       ev_postable = true;
/*     */     } 
/*     */     
/* 456 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getVoid() {
/* 464 */     if (getDAO_().getVoid() != null) {
/* 465 */       return getDAO_().getVoid().booleanValue();
/*     */     }
/*     */     
/* 468 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoid(boolean argVoid) {
/* 477 */     if (setVoid_noev(argVoid) && 
/* 478 */       this._events != null && 
/* 479 */       postEventsForChanges()) {
/* 480 */       this._events.post(IOrderFee.SET_VOID, Boolean.valueOf(argVoid));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoid_noev(boolean argVoid) {
/* 487 */     boolean ev_postable = false;
/*     */     
/* 489 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/* 490 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/* 491 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/* 492 */       ev_postable = true;
/*     */     } 
/*     */     
/* 495 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IOrderFeeProperty newProperty(String argPropertyName) {
/* 499 */     OrderFeePropertyId id = new OrderFeePropertyId();
/*     */     
/* 501 */     id.setOrderId(getOrderId());
/* 502 */     id.setSequence(Integer.valueOf(getSequence()));
/* 503 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 505 */     IOrderFeeProperty prop = (IOrderFeeProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IOrderFeeProperty.class);
/* 506 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IOrderFeeProperty> getProperties() {
/* 515 */     if (this._properties == null) {
/* 516 */       this._properties = new HistoricalList(null);
/*     */     }
/* 518 */     return (List<IOrderFeeProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IOrderFeeProperty> argProperties) {
/* 522 */     if (this._properties == null) {
/* 523 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 525 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 528 */     for (IOrderFeeProperty child : this._properties) {
/* 529 */       OrderFeePropertyModel model = (OrderFeePropertyModel)child;
/* 530 */       model.setOrganizationId_noev(getOrganizationId());
/* 531 */       model.setOrderId_noev(getOrderId());
/* 532 */       model.setSequence_noev(getSequence());
/* 533 */       if (child instanceof IDataModelImpl) {
/* 534 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 535 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 536 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 537 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 540 */       if (postEventsForChanges()) {
/* 541 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addOrderFeeProperty(IOrderFeeProperty argOrderFeeProperty) {
/* 547 */     if (this._properties == null) {
/* 548 */       this._properties = new HistoricalList(null);
/*     */     }
/* 550 */     argOrderFeeProperty.setOrganizationId(getOrganizationId());
/* 551 */     argOrderFeeProperty.setOrderId(getOrderId());
/* 552 */     argOrderFeeProperty.setSequence(getSequence());
/* 553 */     if (argOrderFeeProperty instanceof IDataModelImpl) {
/* 554 */       IDataAccessObject childDao = ((IDataModelImpl)argOrderFeeProperty).getDAO();
/* 555 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 556 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 557 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 562 */     if (postEventsForChanges()) {
/* 563 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderFeeProperty));
/*     */     }
/*     */     
/* 566 */     this._properties.add(argOrderFeeProperty);
/* 567 */     if (postEventsForChanges()) {
/* 568 */       this._events.post(IOrderFee.ADD_PROPERTIES, argOrderFeeProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeOrderFeeProperty(IOrderFeeProperty argOrderFeeProperty) {
/* 573 */     if (this._properties != null) {
/*     */       
/* 575 */       if (postEventsForChanges()) {
/* 576 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderFeeProperty));
/*     */       }
/* 578 */       this._properties.remove(argOrderFeeProperty);
/* 579 */       if (postEventsForChanges()) {
/* 580 */         this._events.post(IOrderFee.REMOVE_PROPERTIES, argOrderFeeProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentOrder(IOrder argParentOrder) {
/* 586 */     this._parentOrder = argParentOrder;
/*     */   }
/*     */   
/*     */   public IOrder getParentOrder() {
/* 590 */     return this._parentOrder;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 595 */     if ("Properties".equals(argFieldId)) {
/* 596 */       return getProperties();
/*     */     }
/* 598 */     if ("OrderFeeExtension".equals(argFieldId)) {
/* 599 */       return this._myExtension;
/*     */     }
/*     */     
/* 602 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 608 */     if ("Properties".equals(argFieldId)) {
/* 609 */       setProperties(changeToList(argValue, IOrderFeeProperty.class));
/*     */     }
/* 611 */     else if ("OrderFeeExtension".equals(argFieldId)) {
/* 612 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 615 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 621 */     this._persistenceDefaults = argPD;
/* 622 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 623 */     this._eventManager = argEM;
/* 624 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 625 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 626 */     if (this._properties != null) {
/* 627 */       for (IOrderFeeProperty relationship : this._properties) {
/* 628 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getOrderFeeExt() {
/* 634 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setOrderFeeExt(IDataModel argExt) {
/* 638 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 643 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 647 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 650 */     super.startTransaction();
/*     */     
/* 652 */     this._propertiesSavepoint = this._properties;
/* 653 */     if (this._properties != null) {
/* 654 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 655 */       Iterator<IDataModel> it = this._properties.iterator();
/* 656 */       while (it.hasNext()) {
/* 657 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 662 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 667 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 670 */     super.rollbackChanges();
/*     */     
/* 672 */     this._properties = this._propertiesSavepoint;
/* 673 */     this._propertiesSavepoint = null;
/* 674 */     if (this._properties != null) {
/* 675 */       Iterator<IDataModel> it = this._properties.iterator();
/* 676 */       while (it.hasNext()) {
/* 677 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 685 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 688 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 691 */     super.commitTransaction();
/*     */     
/* 693 */     this._propertiesSavepoint = this._properties;
/* 694 */     if (this._properties != null) {
/* 695 */       Iterator<IDataModel> it = this._properties.iterator();
/* 696 */       while (it.hasNext()) {
/* 697 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 699 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 703 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 708 */     argStream.defaultReadObject();
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
/* 720 */   private transient ISaleReturnLineItem _shadowedSaleItem = null;
/* 721 */   private transient String _taxType = null;
/*     */ 
/*     */   
/*     */   public ISaleReturnLineItem getShadowedSaleItem() {
/* 725 */     return this._shadowedSaleItem;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setShadowedSaleItem(ISaleReturnLineItem argSaleItem) {
/* 730 */     this._shadowedSaleItem = argSaleItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OrderDetailType getDetailType() {
/* 736 */     return OrderDetailType.FEE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxType(String argTaxType) {
/* 744 */     this._taxType = argTaxType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxType() {
/* 751 */     return this._taxType;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\OrderFeeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */