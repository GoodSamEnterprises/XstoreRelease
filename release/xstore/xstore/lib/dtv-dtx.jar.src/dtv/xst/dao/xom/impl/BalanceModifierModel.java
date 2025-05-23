/*     */ package dtv.xst.dao.xom.impl;
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
/*     */ import dtv.xst.dao.xom.BalanceModifierPropertyId;
/*     */ import dtv.xst.dao.xom.IBalanceModifier;
/*     */ import dtv.xst.dao.xom.IBalanceModifierProperty;
/*     */ import dtv.xst.dao.xom.IOrderLine;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class BalanceModifierModel extends AbstractDataModelWithPropertyImpl<IBalanceModifierProperty> implements IBalanceModifier {
/*     */   private static final long serialVersionUID = 436662707L;
/*     */   private IOrderLine _parentOrderLine;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IBalanceModifierProperty> _properties; private transient HistoricalList<IBalanceModifierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new BalanceModifierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private BalanceModifierDAO getDAO_() {
/*  48 */     return (BalanceModifierDAO)this._daoImpl;
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
/*  72 */       this._events.post(IBalanceModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<BalanceModifierPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((BalanceModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 114 */       this._events.post(IBalanceModifier.SET_ORDERID, argOrderId);
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
/* 129 */         Iterator<BalanceModifierPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((BalanceModifierPropertyModel)it.next()).setOrderId_noev(argOrderId);
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
/* 161 */       this._events.post(IBalanceModifier.SET_SEQUENCE, Integer.valueOf(argSequence));
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
/* 176 */         Iterator<BalanceModifierPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((BalanceModifierPropertyModel)it.next()).setSequence_noev(argSequence);
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
/*     */   public int getModSequence() {
/* 192 */     if (getDAO_().getModSequence() != null) {
/* 193 */       return getDAO_().getModSequence().intValue();
/*     */     }
/*     */     
/* 196 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setModSequence(int argModSequence) {
/* 205 */     if (setModSequence_noev(argModSequence) && 
/* 206 */       this._events != null && 
/* 207 */       postEventsForChanges()) {
/* 208 */       this._events.post(IBalanceModifier.SET_MODSEQUENCE, Integer.valueOf(argModSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setModSequence_noev(int argModSequence) {
/* 215 */     boolean ev_postable = false;
/*     */     
/* 217 */     if ((getDAO_().getModSequence() == null && Integer.valueOf(argModSequence) != null) || (
/* 218 */       getDAO_().getModSequence() != null && !getDAO_().getModSequence().equals(Integer.valueOf(argModSequence)))) {
/* 219 */       getDAO_().setModSequence(Integer.valueOf(argModSequence));
/* 220 */       ev_postable = true;
/* 221 */       if (this._properties != null) {
/*     */         
/* 223 */         Iterator<BalanceModifierPropertyModel> it = this._properties.iterator();
/* 224 */         while (it.hasNext())
/*     */         {
/* 226 */           ((BalanceModifierPropertyModel)it.next()).setModSequence_noev(argModSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 231 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 239 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 247 */     if (setCreateDate_noev(argCreateDate) && 
/* 248 */       this._events != null && 
/* 249 */       postEventsForChanges()) {
/* 250 */       this._events.post(IBalanceModifier.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 257 */     boolean ev_postable = false;
/*     */     
/* 259 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 260 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 261 */       getDAO_().setCreateDate(argCreateDate);
/* 262 */       ev_postable = true;
/*     */     } 
/*     */     
/* 265 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 273 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 281 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 282 */       this._events != null && 
/* 283 */       postEventsForChanges()) {
/* 284 */       this._events.post(IBalanceModifier.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 291 */     boolean ev_postable = false;
/*     */     
/* 293 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 294 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 295 */       getDAO_().setCreateUserId(argCreateUserId);
/* 296 */       ev_postable = true;
/*     */     } 
/*     */     
/* 299 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 307 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 315 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 316 */       this._events != null && 
/* 317 */       postEventsForChanges()) {
/* 318 */       this._events.post(IBalanceModifier.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 325 */     boolean ev_postable = false;
/*     */     
/* 327 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 328 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 329 */       getDAO_().setUpdateDate(argUpdateDate);
/* 330 */       ev_postable = true;
/*     */     } 
/*     */     
/* 333 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 341 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 349 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 350 */       this._events != null && 
/* 351 */       postEventsForChanges()) {
/* 352 */       this._events.post(IBalanceModifier.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 359 */     boolean ev_postable = false;
/*     */     
/* 361 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 362 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 363 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 364 */       ev_postable = true;
/*     */     } 
/*     */     
/* 367 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTypeCode() {
/* 375 */     return getDAO_().getTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 383 */     if (setTypeCode_noev(argTypeCode) && 
/* 384 */       this._events != null && 
/* 385 */       postEventsForChanges()) {
/* 386 */       this._events.post(IBalanceModifier.SET_TYPECODE, argTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTypeCode_noev(String argTypeCode) {
/* 393 */     boolean ev_postable = false;
/*     */     
/* 395 */     if ((getDAO_().getTypeCode() == null && argTypeCode != null) || (
/* 396 */       getDAO_().getTypeCode() != null && !getDAO_().getTypeCode().equals(argTypeCode))) {
/* 397 */       getDAO_().setTypeCode(argTypeCode);
/* 398 */       ev_postable = true;
/*     */     } 
/*     */     
/* 401 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAmount() {
/* 409 */     return getDAO_().getAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 417 */     if (setAmount_noev(argAmount) && 
/* 418 */       this._events != null && 
/* 419 */       postEventsForChanges()) {
/* 420 */       this._events.post(IBalanceModifier.SET_AMOUNT, argAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAmount_noev(BigDecimal argAmount) {
/* 427 */     boolean ev_postable = false;
/*     */     
/* 429 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/* 430 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/* 431 */       getDAO_().setAmount(argAmount);
/* 432 */       ev_postable = true;
/*     */     } 
/*     */     
/* 435 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getVoid() {
/* 443 */     if (getDAO_().getVoid() != null) {
/* 444 */       return getDAO_().getVoid().booleanValue();
/*     */     }
/*     */     
/* 447 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoid(boolean argVoid) {
/* 456 */     if (setVoid_noev(argVoid) && 
/* 457 */       this._events != null && 
/* 458 */       postEventsForChanges()) {
/* 459 */       this._events.post(IBalanceModifier.SET_VOID, Boolean.valueOf(argVoid));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoid_noev(boolean argVoid) {
/* 466 */     boolean ev_postable = false;
/*     */     
/* 468 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/* 469 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/* 470 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/* 471 */       ev_postable = true;
/*     */     } 
/*     */     
/* 474 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IBalanceModifierProperty newProperty(String argPropertyName) {
/* 478 */     BalanceModifierPropertyId id = new BalanceModifierPropertyId();
/*     */     
/* 480 */     id.setOrderId(getOrderId());
/* 481 */     id.setSequence(Integer.valueOf(getSequence()));
/* 482 */     id.setModSequence(Integer.valueOf(getModSequence()));
/* 483 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 485 */     IBalanceModifierProperty prop = (IBalanceModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IBalanceModifierProperty.class);
/* 486 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IBalanceModifierProperty> getProperties() {
/* 495 */     if (this._properties == null) {
/* 496 */       this._properties = new HistoricalList(null);
/*     */     }
/* 498 */     return (List<IBalanceModifierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IBalanceModifierProperty> argProperties) {
/* 502 */     if (this._properties == null) {
/* 503 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 505 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 508 */     for (IBalanceModifierProperty child : this._properties) {
/* 509 */       BalanceModifierPropertyModel model = (BalanceModifierPropertyModel)child;
/* 510 */       model.setOrganizationId_noev(getOrganizationId());
/* 511 */       model.setOrderId_noev(getOrderId());
/* 512 */       model.setSequence_noev(getSequence());
/* 513 */       model.setModSequence_noev(getModSequence());
/* 514 */       if (child instanceof IDataModelImpl) {
/* 515 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 516 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 517 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 518 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 521 */       if (postEventsForChanges()) {
/* 522 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addBalanceModifierProperty(IBalanceModifierProperty argBalanceModifierProperty) {
/* 528 */     if (this._properties == null) {
/* 529 */       this._properties = new HistoricalList(null);
/*     */     }
/* 531 */     argBalanceModifierProperty.setOrganizationId(getOrganizationId());
/* 532 */     argBalanceModifierProperty.setOrderId(getOrderId());
/* 533 */     argBalanceModifierProperty.setSequence(getSequence());
/* 534 */     argBalanceModifierProperty.setModSequence(getModSequence());
/* 535 */     if (argBalanceModifierProperty instanceof IDataModelImpl) {
/* 536 */       IDataAccessObject childDao = ((IDataModelImpl)argBalanceModifierProperty).getDAO();
/* 537 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 538 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 539 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 544 */     if (postEventsForChanges()) {
/* 545 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argBalanceModifierProperty));
/*     */     }
/*     */     
/* 548 */     this._properties.add(argBalanceModifierProperty);
/* 549 */     if (postEventsForChanges()) {
/* 550 */       this._events.post(IBalanceModifier.ADD_PROPERTIES, argBalanceModifierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeBalanceModifierProperty(IBalanceModifierProperty argBalanceModifierProperty) {
/* 555 */     if (this._properties != null) {
/*     */       
/* 557 */       if (postEventsForChanges()) {
/* 558 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argBalanceModifierProperty));
/*     */       }
/* 560 */       this._properties.remove(argBalanceModifierProperty);
/* 561 */       if (postEventsForChanges()) {
/* 562 */         this._events.post(IBalanceModifier.REMOVE_PROPERTIES, argBalanceModifierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentOrderLine(IOrderLine argParentOrderLine) {
/* 568 */     this._parentOrderLine = argParentOrderLine;
/*     */   }
/*     */   
/*     */   public IOrderLine getParentOrderLine() {
/* 572 */     return this._parentOrderLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 577 */     if ("Properties".equals(argFieldId)) {
/* 578 */       return getProperties();
/*     */     }
/* 580 */     if ("BalanceModifierExtension".equals(argFieldId)) {
/* 581 */       return this._myExtension;
/*     */     }
/*     */     
/* 584 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 590 */     if ("Properties".equals(argFieldId)) {
/* 591 */       setProperties(changeToList(argValue, IBalanceModifierProperty.class));
/*     */     }
/* 593 */     else if ("BalanceModifierExtension".equals(argFieldId)) {
/* 594 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 597 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 603 */     this._persistenceDefaults = argPD;
/* 604 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 605 */     this._eventManager = argEM;
/* 606 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 607 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 608 */     if (this._properties != null) {
/* 609 */       for (IBalanceModifierProperty relationship : this._properties) {
/* 610 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getBalanceModifierExt() {
/* 616 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setBalanceModifierExt(IDataModel argExt) {
/* 620 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 625 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 629 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 632 */     super.startTransaction();
/*     */     
/* 634 */     this._propertiesSavepoint = this._properties;
/* 635 */     if (this._properties != null) {
/* 636 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 637 */       Iterator<IDataModel> it = this._properties.iterator();
/* 638 */       while (it.hasNext()) {
/* 639 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 644 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 649 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 652 */     super.rollbackChanges();
/*     */     
/* 654 */     this._properties = this._propertiesSavepoint;
/* 655 */     this._propertiesSavepoint = null;
/* 656 */     if (this._properties != null) {
/* 657 */       Iterator<IDataModel> it = this._properties.iterator();
/* 658 */       while (it.hasNext()) {
/* 659 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 667 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 670 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 673 */     super.commitTransaction();
/*     */     
/* 675 */     this._propertiesSavepoint = this._properties;
/* 676 */     if (this._properties != null) {
/* 677 */       Iterator<IDataModel> it = this._properties.iterator();
/* 678 */       while (it.hasNext()) {
/* 679 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 681 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 685 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 690 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\BalanceModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */