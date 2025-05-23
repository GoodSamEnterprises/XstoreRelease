/*     */ package dtv.xst.dao.tax.impl;
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
/*     */ import dtv.xst.dao.tax.ITaxBracket;
/*     */ import dtv.xst.dao.tax.ITaxBracketProperty;
/*     */ import dtv.xst.dao.tax.TaxBracketPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TaxBracketModel extends AbstractDataModelWithPropertyImpl<ITaxBracketProperty> implements ITaxBracket {
/*     */   private static final long serialVersionUID = 1929214621L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ITaxBracketProperty> _properties; private transient HistoricalList<ITaxBracketProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new TaxBracketDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TaxBracketDAO getDAO_() {
/*  46 */     return (TaxBracketDAO)this._daoImpl;
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
/*  70 */       this._events.post(ITaxBracket.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<TaxBracketPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((TaxBracketPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getTaxBracketId() {
/* 101 */     return getDAO_().getTaxBracketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxBracketId(String argTaxBracketId) {
/* 109 */     if (setTaxBracketId_noev(argTaxBracketId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(ITaxBracket.SET_TAXBRACKETID, argTaxBracketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxBracketId_noev(String argTaxBracketId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getTaxBracketId() == null && argTaxBracketId != null) || (
/* 122 */       getDAO_().getTaxBracketId() != null && !getDAO_().getTaxBracketId().equals(argTaxBracketId))) {
/* 123 */       getDAO_().setTaxBracketId(argTaxBracketId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<TaxBracketPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((TaxBracketPropertyModel)it.next()).setTaxBracketId_noev(argTaxBracketId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 135 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTaxBracketSequence() {
/* 143 */     if (getDAO_().getTaxBracketSequence() != null) {
/* 144 */       return getDAO_().getTaxBracketSequence().intValue();
/*     */     }
/*     */     
/* 147 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxBracketSequence(int argTaxBracketSequence) {
/* 156 */     if (setTaxBracketSequence_noev(argTaxBracketSequence) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(ITaxBracket.SET_TAXBRACKETSEQUENCE, Integer.valueOf(argTaxBracketSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxBracketSequence_noev(int argTaxBracketSequence) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getTaxBracketSequence() == null && Integer.valueOf(argTaxBracketSequence) != null) || (
/* 169 */       getDAO_().getTaxBracketSequence() != null && !getDAO_().getTaxBracketSequence().equals(Integer.valueOf(argTaxBracketSequence)))) {
/* 170 */       getDAO_().setTaxBracketSequence(Integer.valueOf(argTaxBracketSequence));
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<TaxBracketPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((TaxBracketPropertyModel)it.next()).setTaxBracketSequence_noev(argTaxBracketSequence);
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
/*     */   public String getOrgCode() {
/* 190 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 198 */     if (setOrgCode_noev(argOrgCode) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(ITaxBracket.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 211 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 212 */       getDAO_().setOrgCode(argOrgCode);
/* 213 */       ev_postable = true;
/*     */     } 
/*     */     
/* 216 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 224 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 232 */     if (setOrgValue_noev(argOrgValue) && 
/* 233 */       this._events != null && 
/* 234 */       postEventsForChanges()) {
/* 235 */       this._events.post(ITaxBracket.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 242 */     boolean ev_postable = false;
/*     */     
/* 244 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 245 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 246 */       getDAO_().setOrgValue(argOrgValue);
/* 247 */       ev_postable = true;
/*     */     } 
/*     */     
/* 250 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 258 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 266 */     if (setCreateDate_noev(argCreateDate) && 
/* 267 */       this._events != null && 
/* 268 */       postEventsForChanges()) {
/* 269 */       this._events.post(ITaxBracket.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 276 */     boolean ev_postable = false;
/*     */     
/* 278 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 279 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 280 */       getDAO_().setCreateDate(argCreateDate);
/* 281 */       ev_postable = true;
/*     */     } 
/*     */     
/* 284 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 292 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 300 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 301 */       this._events != null && 
/* 302 */       postEventsForChanges()) {
/* 303 */       this._events.post(ITaxBracket.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 310 */     boolean ev_postable = false;
/*     */     
/* 312 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 313 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 314 */       getDAO_().setCreateUserId(argCreateUserId);
/* 315 */       ev_postable = true;
/*     */     } 
/*     */     
/* 318 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 326 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 334 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 335 */       this._events != null && 
/* 336 */       postEventsForChanges()) {
/* 337 */       this._events.post(ITaxBracket.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 344 */     boolean ev_postable = false;
/*     */     
/* 346 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 347 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 348 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 360 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 368 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 369 */       this._events != null && 
/* 370 */       postEventsForChanges()) {
/* 371 */       this._events.post(ITaxBracket.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 378 */     boolean ev_postable = false;
/*     */     
/* 380 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 381 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 382 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public BigDecimal getTaxBreakpoint() {
/* 394 */     return getDAO_().getTaxBreakpoint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxBreakpoint(BigDecimal argTaxBreakpoint) {
/* 402 */     if (setTaxBreakpoint_noev(argTaxBreakpoint) && 
/* 403 */       this._events != null && 
/* 404 */       postEventsForChanges()) {
/* 405 */       this._events.post(ITaxBracket.SET_TAXBREAKPOINT, argTaxBreakpoint);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxBreakpoint_noev(BigDecimal argTaxBreakpoint) {
/* 412 */     boolean ev_postable = false;
/*     */     
/* 414 */     if ((getDAO_().getTaxBreakpoint() == null && argTaxBreakpoint != null) || (
/* 415 */       getDAO_().getTaxBreakpoint() != null && !getDAO_().getTaxBreakpoint().equals(argTaxBreakpoint))) {
/* 416 */       getDAO_().setTaxBreakpoint(argTaxBreakpoint);
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
/*     */   public BigDecimal getTaxAmount() {
/* 428 */     return getDAO_().getTaxAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxAmount(BigDecimal argTaxAmount) {
/* 436 */     if (setTaxAmount_noev(argTaxAmount) && 
/* 437 */       this._events != null && 
/* 438 */       postEventsForChanges()) {
/* 439 */       this._events.post(ITaxBracket.SET_TAXAMOUNT, argTaxAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxAmount_noev(BigDecimal argTaxAmount) {
/* 446 */     boolean ev_postable = false;
/*     */     
/* 448 */     if ((getDAO_().getTaxAmount() == null && argTaxAmount != null) || (
/* 449 */       getDAO_().getTaxAmount() != null && !getDAO_().getTaxAmount().equals(argTaxAmount))) {
/* 450 */       getDAO_().setTaxAmount(argTaxAmount);
/* 451 */       ev_postable = true;
/*     */     } 
/*     */     
/* 454 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITaxBracketProperty newProperty(String argPropertyName) {
/* 458 */     TaxBracketPropertyId id = new TaxBracketPropertyId();
/*     */     
/* 460 */     id.setTaxBracketId(getTaxBracketId());
/* 461 */     id.setTaxBracketSequence(Integer.valueOf(getTaxBracketSequence()));
/* 462 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 464 */     ITaxBracketProperty prop = (ITaxBracketProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITaxBracketProperty.class);
/* 465 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITaxBracketProperty> getProperties() {
/* 474 */     if (this._properties == null) {
/* 475 */       this._properties = new HistoricalList(null);
/*     */     }
/* 477 */     return (List<ITaxBracketProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITaxBracketProperty> argProperties) {
/* 481 */     if (this._properties == null) {
/* 482 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 484 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 487 */     for (ITaxBracketProperty child : this._properties) {
/* 488 */       TaxBracketPropertyModel model = (TaxBracketPropertyModel)child;
/* 489 */       model.setOrganizationId_noev(getOrganizationId());
/* 490 */       model.setTaxBracketId_noev(getTaxBracketId());
/* 491 */       model.setTaxBracketSequence_noev(getTaxBracketSequence());
/* 492 */       if (child instanceof IDataModelImpl) {
/* 493 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 494 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 495 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 496 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 499 */       if (postEventsForChanges()) {
/* 500 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTaxBracketProperty(ITaxBracketProperty argTaxBracketProperty) {
/* 506 */     if (this._properties == null) {
/* 507 */       this._properties = new HistoricalList(null);
/*     */     }
/* 509 */     argTaxBracketProperty.setOrganizationId(getOrganizationId());
/* 510 */     argTaxBracketProperty.setTaxBracketId(getTaxBracketId());
/* 511 */     argTaxBracketProperty.setTaxBracketSequence(getTaxBracketSequence());
/* 512 */     if (argTaxBracketProperty instanceof IDataModelImpl) {
/* 513 */       IDataAccessObject childDao = ((IDataModelImpl)argTaxBracketProperty).getDAO();
/* 514 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 515 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 516 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 521 */     if (postEventsForChanges()) {
/* 522 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxBracketProperty));
/*     */     }
/*     */     
/* 525 */     this._properties.add(argTaxBracketProperty);
/* 526 */     if (postEventsForChanges()) {
/* 527 */       this._events.post(ITaxBracket.ADD_PROPERTIES, argTaxBracketProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTaxBracketProperty(ITaxBracketProperty argTaxBracketProperty) {
/* 532 */     if (this._properties != null) {
/*     */       
/* 534 */       if (postEventsForChanges()) {
/* 535 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxBracketProperty));
/*     */       }
/* 537 */       this._properties.remove(argTaxBracketProperty);
/* 538 */       if (postEventsForChanges()) {
/* 539 */         this._events.post(ITaxBracket.REMOVE_PROPERTIES, argTaxBracketProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 546 */     if ("Properties".equals(argFieldId)) {
/* 547 */       return getProperties();
/*     */     }
/* 549 */     if ("TaxBracketExtension".equals(argFieldId)) {
/* 550 */       return this._myExtension;
/*     */     }
/*     */     
/* 553 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 559 */     if ("Properties".equals(argFieldId)) {
/* 560 */       setProperties(changeToList(argValue, ITaxBracketProperty.class));
/*     */     }
/* 562 */     else if ("TaxBracketExtension".equals(argFieldId)) {
/* 563 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 566 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 572 */     this._persistenceDefaults = argPD;
/* 573 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 574 */     this._eventManager = argEM;
/* 575 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 576 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 577 */     if (this._properties != null) {
/* 578 */       for (ITaxBracketProperty relationship : this._properties) {
/* 579 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTaxBracketExt() {
/* 585 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTaxBracketExt(IDataModel argExt) {
/* 589 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 594 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 598 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 601 */     super.startTransaction();
/*     */     
/* 603 */     this._propertiesSavepoint = this._properties;
/* 604 */     if (this._properties != null) {
/* 605 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 606 */       Iterator<IDataModel> it = this._properties.iterator();
/* 607 */       while (it.hasNext()) {
/* 608 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 613 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 618 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 621 */     super.rollbackChanges();
/*     */     
/* 623 */     this._properties = this._propertiesSavepoint;
/* 624 */     this._propertiesSavepoint = null;
/* 625 */     if (this._properties != null) {
/* 626 */       Iterator<IDataModel> it = this._properties.iterator();
/* 627 */       while (it.hasNext()) {
/* 628 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 636 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 639 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 642 */     super.commitTransaction();
/*     */     
/* 644 */     this._propertiesSavepoint = this._properties;
/* 645 */     if (this._properties != null) {
/* 646 */       Iterator<IDataModel> it = this._properties.iterator();
/* 647 */       while (it.hasNext()) {
/* 648 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 650 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 654 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 659 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxBracketModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */