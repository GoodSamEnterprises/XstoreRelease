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
/*     */ import dtv.xst.dao.xom.FeeModifierPropertyId;
/*     */ import dtv.xst.dao.xom.IFeeModifier;
/*     */ import dtv.xst.dao.xom.IFeeModifierProperty;
/*     */ import dtv.xst.dao.xom.IOrderLine;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class FeeModifierModel extends AbstractDataModelWithPropertyImpl<IFeeModifierProperty> implements IFeeModifier {
/*     */   private static final long serialVersionUID = 1974252637L;
/*     */   private IOrderLine _parentOrderLine;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IFeeModifierProperty> _properties; private transient HistoricalList<IFeeModifierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new FeeModifierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FeeModifierDAO getDAO_() {
/*  48 */     return (FeeModifierDAO)this._daoImpl;
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
/*  72 */       this._events.post(IFeeModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<FeeModifierPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((FeeModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 114 */       this._events.post(IFeeModifier.SET_ORDERID, argOrderId);
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
/* 129 */         Iterator<FeeModifierPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((FeeModifierPropertyModel)it.next()).setOrderId_noev(argOrderId);
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
/* 161 */       this._events.post(IFeeModifier.SET_SEQUENCE, Integer.valueOf(argSequence));
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
/* 176 */         Iterator<FeeModifierPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((FeeModifierPropertyModel)it.next()).setSequence_noev(argSequence);
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
/* 208 */       this._events.post(IFeeModifier.SET_MODSEQUENCE, Integer.valueOf(argModSequence));
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
/* 223 */         Iterator<FeeModifierPropertyModel> it = this._properties.iterator();
/* 224 */         while (it.hasNext())
/*     */         {
/* 226 */           ((FeeModifierPropertyModel)it.next()).setModSequence_noev(argModSequence);
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
/* 250 */       this._events.post(IFeeModifier.SET_CREATEDATE, argCreateDate);
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
/* 284 */       this._events.post(IFeeModifier.SET_CREATEUSERID, argCreateUserId);
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
/* 318 */       this._events.post(IFeeModifier.SET_UPDATEDATE, argUpdateDate);
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
/* 352 */       this._events.post(IFeeModifier.SET_UPDATEUSERID, argUpdateUserId);
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
/* 386 */       this._events.post(IFeeModifier.SET_TYPECODE, argTypeCode);
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
/* 420 */       this._events.post(IFeeModifier.SET_AMOUNT, argAmount);
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
/*     */   public BigDecimal getTaxAmount() {
/* 443 */     return getDAO_().getTaxAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxAmount(BigDecimal argTaxAmount) {
/* 451 */     if (setTaxAmount_noev(argTaxAmount) && 
/* 452 */       this._events != null && 
/* 453 */       postEventsForChanges()) {
/* 454 */       this._events.post(IFeeModifier.SET_TAXAMOUNT, argTaxAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxAmount_noev(BigDecimal argTaxAmount) {
/* 461 */     boolean ev_postable = false;
/*     */     
/* 463 */     if ((getDAO_().getTaxAmount() == null && argTaxAmount != null) || (
/* 464 */       getDAO_().getTaxAmount() != null && !getDAO_().getTaxAmount().equals(argTaxAmount))) {
/* 465 */       getDAO_().setTaxAmount(argTaxAmount);
/* 466 */       ev_postable = true;
/*     */     } 
/*     */     
/* 469 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getVoid() {
/* 477 */     if (getDAO_().getVoid() != null) {
/* 478 */       return getDAO_().getVoid().booleanValue();
/*     */     }
/*     */     
/* 481 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoid(boolean argVoid) {
/* 490 */     if (setVoid_noev(argVoid) && 
/* 491 */       this._events != null && 
/* 492 */       postEventsForChanges()) {
/* 493 */       this._events.post(IFeeModifier.SET_VOID, Boolean.valueOf(argVoid));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoid_noev(boolean argVoid) {
/* 500 */     boolean ev_postable = false;
/*     */     
/* 502 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/* 503 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/* 504 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/* 505 */       ev_postable = true;
/*     */     } 
/*     */     
/* 508 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IFeeModifierProperty newProperty(String argPropertyName) {
/* 512 */     FeeModifierPropertyId id = new FeeModifierPropertyId();
/*     */     
/* 514 */     id.setOrderId(getOrderId());
/* 515 */     id.setSequence(Integer.valueOf(getSequence()));
/* 516 */     id.setModSequence(Integer.valueOf(getModSequence()));
/* 517 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 519 */     IFeeModifierProperty prop = (IFeeModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IFeeModifierProperty.class);
/* 520 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IFeeModifierProperty> getProperties() {
/* 529 */     if (this._properties == null) {
/* 530 */       this._properties = new HistoricalList(null);
/*     */     }
/* 532 */     return (List<IFeeModifierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IFeeModifierProperty> argProperties) {
/* 536 */     if (this._properties == null) {
/* 537 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 539 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 542 */     for (IFeeModifierProperty child : this._properties) {
/* 543 */       FeeModifierPropertyModel model = (FeeModifierPropertyModel)child;
/* 544 */       model.setOrganizationId_noev(getOrganizationId());
/* 545 */       model.setOrderId_noev(getOrderId());
/* 546 */       model.setSequence_noev(getSequence());
/* 547 */       model.setModSequence_noev(getModSequence());
/* 548 */       if (child instanceof IDataModelImpl) {
/* 549 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 550 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 551 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 552 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 555 */       if (postEventsForChanges()) {
/* 556 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addFeeModifierProperty(IFeeModifierProperty argFeeModifierProperty) {
/* 562 */     if (this._properties == null) {
/* 563 */       this._properties = new HistoricalList(null);
/*     */     }
/* 565 */     argFeeModifierProperty.setOrganizationId(getOrganizationId());
/* 566 */     argFeeModifierProperty.setOrderId(getOrderId());
/* 567 */     argFeeModifierProperty.setSequence(getSequence());
/* 568 */     argFeeModifierProperty.setModSequence(getModSequence());
/* 569 */     if (argFeeModifierProperty instanceof IDataModelImpl) {
/* 570 */       IDataAccessObject childDao = ((IDataModelImpl)argFeeModifierProperty).getDAO();
/* 571 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 572 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 573 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 578 */     if (postEventsForChanges()) {
/* 579 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argFeeModifierProperty));
/*     */     }
/*     */     
/* 582 */     this._properties.add(argFeeModifierProperty);
/* 583 */     if (postEventsForChanges()) {
/* 584 */       this._events.post(IFeeModifier.ADD_PROPERTIES, argFeeModifierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeFeeModifierProperty(IFeeModifierProperty argFeeModifierProperty) {
/* 589 */     if (this._properties != null) {
/*     */       
/* 591 */       if (postEventsForChanges()) {
/* 592 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argFeeModifierProperty));
/*     */       }
/* 594 */       this._properties.remove(argFeeModifierProperty);
/* 595 */       if (postEventsForChanges()) {
/* 596 */         this._events.post(IFeeModifier.REMOVE_PROPERTIES, argFeeModifierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentOrderLine(IOrderLine argParentOrderLine) {
/* 602 */     this._parentOrderLine = argParentOrderLine;
/*     */   }
/*     */   
/*     */   public IOrderLine getParentOrderLine() {
/* 606 */     return this._parentOrderLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 611 */     if ("Properties".equals(argFieldId)) {
/* 612 */       return getProperties();
/*     */     }
/* 614 */     if ("FeeModifierExtension".equals(argFieldId)) {
/* 615 */       return this._myExtension;
/*     */     }
/*     */     
/* 618 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 624 */     if ("Properties".equals(argFieldId)) {
/* 625 */       setProperties(changeToList(argValue, IFeeModifierProperty.class));
/*     */     }
/* 627 */     else if ("FeeModifierExtension".equals(argFieldId)) {
/* 628 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 631 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 637 */     this._persistenceDefaults = argPD;
/* 638 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 639 */     this._eventManager = argEM;
/* 640 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 641 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 642 */     if (this._properties != null) {
/* 643 */       for (IFeeModifierProperty relationship : this._properties) {
/* 644 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getFeeModifierExt() {
/* 650 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setFeeModifierExt(IDataModel argExt) {
/* 654 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 659 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 663 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 666 */     super.startTransaction();
/*     */     
/* 668 */     this._propertiesSavepoint = this._properties;
/* 669 */     if (this._properties != null) {
/* 670 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 671 */       Iterator<IDataModel> it = this._properties.iterator();
/* 672 */       while (it.hasNext()) {
/* 673 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 678 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 683 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 686 */     super.rollbackChanges();
/*     */     
/* 688 */     this._properties = this._propertiesSavepoint;
/* 689 */     this._propertiesSavepoint = null;
/* 690 */     if (this._properties != null) {
/* 691 */       Iterator<IDataModel> it = this._properties.iterator();
/* 692 */       while (it.hasNext()) {
/* 693 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 701 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 704 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 707 */     super.commitTransaction();
/*     */     
/* 709 */     this._propertiesSavepoint = this._properties;
/* 710 */     if (this._properties != null) {
/* 711 */       Iterator<IDataModel> it = this._properties.iterator();
/* 712 */       while (it.hasNext()) {
/* 713 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 715 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 719 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 724 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\FeeModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */