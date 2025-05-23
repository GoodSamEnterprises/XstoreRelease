/*     */ package dtv.xst.dao.cat.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.cat.ChargeAccountInvoicePropertyId;
/*     */ import dtv.xst.dao.cat.IChargeAccountInvoice;
/*     */ import dtv.xst.dao.cat.IChargeAccountInvoiceProperty;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ChargeAccountInvoiceModel extends ChargeAccountInvoiceBaseModel implements IChargeAccountInvoice {
/*     */   private static final long serialVersionUID = 749161524L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IChargeAccountInvoiceProperty> _properties; private transient HistoricalList<IChargeAccountInvoiceProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new ChargeAccountInvoiceDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ChargeAccountInvoiceDAO getDAO_() {
/*  47 */     return (ChargeAccountInvoiceDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  55 */     if (getDAO_().getOrganizationId() != null) {
/*  56 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  59 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  68 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  69 */       this._events != null && 
/*  70 */       postEventsForChanges()) {
/*  71 */       this._events.post(IChargeAccountInvoice.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  78 */     boolean ev_postable = false;
/*     */     
/*  80 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  81 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  82 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  83 */       ev_postable = true;
/*  84 */       if (this._properties != null) {
/*     */         
/*  86 */         Iterator<ChargeAccountInvoicePropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((ChargeAccountInvoicePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  94 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/* 102 */     return getDAO_().getCustAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 110 */     if (setCustAccountId_noev(argCustAccountId) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(IChargeAccountInvoice.SET_CUSTACCOUNTID, argCustAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountId_noev(String argCustAccountId) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/* 123 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/* 124 */       getDAO_().setCustAccountId(argCustAccountId);
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<ChargeAccountInvoicePropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((ChargeAccountInvoicePropertyModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 136 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountCode() {
/* 144 */     return getDAO_().getCustAccountCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/* 152 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/* 153 */       this._events != null && 
/* 154 */       postEventsForChanges()) {
/* 155 */       this._events.post(IChargeAccountInvoice.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/* 162 */     boolean ev_postable = false;
/*     */     
/* 164 */     if ((getDAO_().getCustAccountCode() == null && argCustAccountCode != null) || (
/* 165 */       getDAO_().getCustAccountCode() != null && !getDAO_().getCustAccountCode().equals(argCustAccountCode))) {
/* 166 */       getDAO_().setCustAccountCode(argCustAccountCode);
/* 167 */       ev_postable = true;
/* 168 */       if (this._properties != null) {
/*     */         
/* 170 */         Iterator<ChargeAccountInvoicePropertyModel> it = this._properties.iterator();
/* 171 */         while (it.hasNext())
/*     */         {
/* 173 */           ((ChargeAccountInvoicePropertyModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 178 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInvoiceNumber() {
/* 186 */     return getDAO_().getInvoiceNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInvoiceNumber(String argInvoiceNumber) {
/* 194 */     if (setInvoiceNumber_noev(argInvoiceNumber) && 
/* 195 */       this._events != null && 
/* 196 */       postEventsForChanges()) {
/* 197 */       this._events.post(IChargeAccountInvoice.SET_INVOICENUMBER, argInvoiceNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInvoiceNumber_noev(String argInvoiceNumber) {
/* 204 */     boolean ev_postable = false;
/*     */     
/* 206 */     if ((getDAO_().getInvoiceNumber() == null && argInvoiceNumber != null) || (
/* 207 */       getDAO_().getInvoiceNumber() != null && !getDAO_().getInvoiceNumber().equals(argInvoiceNumber))) {
/* 208 */       getDAO_().setInvoiceNumber(argInvoiceNumber);
/* 209 */       ev_postable = true;
/* 210 */       if (this._properties != null) {
/*     */         
/* 212 */         Iterator<ChargeAccountInvoicePropertyModel> it = this._properties.iterator();
/* 213 */         while (it.hasNext())
/*     */         {
/* 215 */           ((ChargeAccountInvoicePropertyModel)it.next()).setInvoiceNumber_noev(argInvoiceNumber);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 220 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 228 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 236 */     if (setCreateDate_noev(argCreateDate) && 
/* 237 */       this._events != null && 
/* 238 */       postEventsForChanges()) {
/* 239 */       this._events.post(IChargeAccountInvoice.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 246 */     boolean ev_postable = false;
/*     */     
/* 248 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 249 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 250 */       getDAO_().setCreateDate(argCreateDate);
/* 251 */       ev_postable = true;
/*     */     } 
/*     */     
/* 254 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 262 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 270 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 271 */       this._events != null && 
/* 272 */       postEventsForChanges()) {
/* 273 */       this._events.post(IChargeAccountInvoice.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 280 */     boolean ev_postable = false;
/*     */     
/* 282 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 283 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 284 */       getDAO_().setCreateUserId(argCreateUserId);
/* 285 */       ev_postable = true;
/*     */     } 
/*     */     
/* 288 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 296 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 304 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 305 */       this._events != null && 
/* 306 */       postEventsForChanges()) {
/* 307 */       this._events.post(IChargeAccountInvoice.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 314 */     boolean ev_postable = false;
/*     */     
/* 316 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 317 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 318 */       getDAO_().setUpdateDate(argUpdateDate);
/* 319 */       ev_postable = true;
/*     */     } 
/*     */     
/* 322 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 330 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 338 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 339 */       this._events != null && 
/* 340 */       postEventsForChanges()) {
/* 341 */       this._events.post(IChargeAccountInvoice.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 348 */     boolean ev_postable = false;
/*     */     
/* 350 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 351 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 352 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 353 */       ev_postable = true;
/*     */     } 
/*     */     
/* 356 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getOriginalInvoiceBalance() {
/* 364 */     return getDAO_().getOriginalInvoiceBalance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOriginalInvoiceBalance(BigDecimal argOriginalInvoiceBalance) {
/* 372 */     if (setOriginalInvoiceBalance_noev(argOriginalInvoiceBalance) && 
/* 373 */       this._events != null && 
/* 374 */       postEventsForChanges()) {
/* 375 */       this._events.post(IChargeAccountInvoice.SET_ORIGINALINVOICEBALANCE, argOriginalInvoiceBalance);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOriginalInvoiceBalance_noev(BigDecimal argOriginalInvoiceBalance) {
/* 382 */     boolean ev_postable = false;
/*     */     
/* 384 */     if ((getDAO_().getOriginalInvoiceBalance() == null && argOriginalInvoiceBalance != null) || (
/* 385 */       getDAO_().getOriginalInvoiceBalance() != null && !getDAO_().getOriginalInvoiceBalance().equals(argOriginalInvoiceBalance))) {
/* 386 */       getDAO_().setOriginalInvoiceBalance(argOriginalInvoiceBalance);
/* 387 */       ev_postable = true;
/*     */     } 
/*     */     
/* 390 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getInvoiceBalance() {
/* 398 */     return getDAO_().getInvoiceBalance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInvoiceBalance(BigDecimal argInvoiceBalance) {
/* 406 */     if (setInvoiceBalance_noev(argInvoiceBalance) && 
/* 407 */       this._events != null && 
/* 408 */       postEventsForChanges()) {
/* 409 */       this._events.post(IChargeAccountInvoice.SET_INVOICEBALANCE, argInvoiceBalance);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInvoiceBalance_noev(BigDecimal argInvoiceBalance) {
/* 416 */     boolean ev_postable = false;
/*     */     
/* 418 */     if ((getDAO_().getInvoiceBalance() == null && argInvoiceBalance != null) || (
/* 419 */       getDAO_().getInvoiceBalance() != null && !getDAO_().getInvoiceBalance().equals(argInvoiceBalance))) {
/* 420 */       getDAO_().setInvoiceBalance(argInvoiceBalance);
/* 421 */       ev_postable = true;
/*     */     } 
/*     */     
/* 424 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getLastActivityDate() {
/* 432 */     return getDAO_().getLastActivityDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastActivityDate(Date argLastActivityDate) {
/* 440 */     if (setLastActivityDate_noev(argLastActivityDate) && 
/* 441 */       this._events != null && 
/* 442 */       postEventsForChanges()) {
/* 443 */       this._events.post(IChargeAccountInvoice.SET_LASTACTIVITYDATE, argLastActivityDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLastActivityDate_noev(Date argLastActivityDate) {
/* 450 */     boolean ev_postable = false;
/*     */     
/* 452 */     if ((getDAO_().getLastActivityDate() == null && argLastActivityDate != null) || (
/* 453 */       getDAO_().getLastActivityDate() != null && !getDAO_().getLastActivityDate().equals(argLastActivityDate))) {
/* 454 */       getDAO_().setLastActivityDate(argLastActivityDate);
/* 455 */       ev_postable = true;
/*     */     } 
/*     */     
/* 458 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getInvoiceDate() {
/* 466 */     return getDAO_().getInvoiceDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInvoiceDate(Date argInvoiceDate) {
/* 474 */     if (setInvoiceDate_noev(argInvoiceDate) && 
/* 475 */       this._events != null && 
/* 476 */       postEventsForChanges()) {
/* 477 */       this._events.post(IChargeAccountInvoice.SET_INVOICEDATE, argInvoiceDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInvoiceDate_noev(Date argInvoiceDate) {
/* 484 */     boolean ev_postable = false;
/*     */     
/* 486 */     if ((getDAO_().getInvoiceDate() == null && argInvoiceDate != null) || (
/* 487 */       getDAO_().getInvoiceDate() != null && !getDAO_().getInvoiceDate().equals(argInvoiceDate))) {
/* 488 */       getDAO_().setInvoiceDate(argInvoiceDate);
/* 489 */       ev_postable = true;
/*     */     } 
/*     */     
/* 492 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IChargeAccountInvoiceProperty newProperty(String argPropertyName) {
/* 496 */     ChargeAccountInvoicePropertyId id = new ChargeAccountInvoicePropertyId();
/*     */     
/* 498 */     id.setCustAccountId(getCustAccountId());
/* 499 */     id.setCustAccountCode(getCustAccountCode());
/* 500 */     id.setInvoiceNumber(getInvoiceNumber());
/* 501 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 503 */     IChargeAccountInvoiceProperty prop = (IChargeAccountInvoiceProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IChargeAccountInvoiceProperty.class);
/* 504 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IChargeAccountInvoiceProperty> getProperties() {
/* 513 */     if (this._properties == null) {
/* 514 */       this._properties = new HistoricalList(null);
/*     */     }
/* 516 */     return (List<IChargeAccountInvoiceProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IChargeAccountInvoiceProperty> argProperties) {
/* 520 */     if (this._properties == null) {
/* 521 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 523 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 526 */     for (IChargeAccountInvoiceProperty child : this._properties) {
/* 527 */       ChargeAccountInvoicePropertyModel model = (ChargeAccountInvoicePropertyModel)child;
/* 528 */       model.setOrganizationId_noev(getOrganizationId());
/* 529 */       model.setCustAccountId_noev(getCustAccountId());
/* 530 */       model.setCustAccountCode_noev(getCustAccountCode());
/* 531 */       model.setInvoiceNumber_noev(getInvoiceNumber());
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
/*     */   public void addChargeAccountInvoiceProperty(IChargeAccountInvoiceProperty argChargeAccountInvoiceProperty) {
/* 546 */     if (this._properties == null) {
/* 547 */       this._properties = new HistoricalList(null);
/*     */     }
/* 549 */     argChargeAccountInvoiceProperty.setOrganizationId(getOrganizationId());
/* 550 */     argChargeAccountInvoiceProperty.setCustAccountId(getCustAccountId());
/* 551 */     argChargeAccountInvoiceProperty.setCustAccountCode(getCustAccountCode());
/* 552 */     argChargeAccountInvoiceProperty.setInvoiceNumber(getInvoiceNumber());
/* 553 */     if (argChargeAccountInvoiceProperty instanceof IDataModelImpl) {
/* 554 */       IDataAccessObject childDao = ((IDataModelImpl)argChargeAccountInvoiceProperty).getDAO();
/* 555 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 556 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 557 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 562 */     if (postEventsForChanges()) {
/* 563 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argChargeAccountInvoiceProperty));
/*     */     }
/*     */     
/* 566 */     this._properties.add(argChargeAccountInvoiceProperty);
/* 567 */     if (postEventsForChanges()) {
/* 568 */       this._events.post(IChargeAccountInvoice.ADD_PROPERTIES, argChargeAccountInvoiceProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeChargeAccountInvoiceProperty(IChargeAccountInvoiceProperty argChargeAccountInvoiceProperty) {
/* 573 */     if (this._properties != null) {
/*     */       
/* 575 */       if (postEventsForChanges()) {
/* 576 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argChargeAccountInvoiceProperty));
/*     */       }
/* 578 */       this._properties.remove(argChargeAccountInvoiceProperty);
/* 579 */       if (postEventsForChanges()) {
/* 580 */         this._events.post(IChargeAccountInvoice.REMOVE_PROPERTIES, argChargeAccountInvoiceProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 587 */     if ("Properties".equals(argFieldId)) {
/* 588 */       return getProperties();
/*     */     }
/* 590 */     if ("ChargeAccountInvoiceExtension".equals(argFieldId)) {
/* 591 */       return this._myExtension;
/*     */     }
/*     */     
/* 594 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 600 */     if ("Properties".equals(argFieldId)) {
/* 601 */       setProperties(changeToList(argValue, IChargeAccountInvoiceProperty.class));
/*     */     }
/* 603 */     else if ("ChargeAccountInvoiceExtension".equals(argFieldId)) {
/* 604 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 607 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 613 */     this._persistenceDefaults = argPD;
/* 614 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 615 */     this._eventManager = argEM;
/* 616 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 617 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 618 */     if (this._properties != null) {
/* 619 */       for (IChargeAccountInvoiceProperty relationship : this._properties) {
/* 620 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getChargeAccountInvoiceExt() {
/* 626 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setChargeAccountInvoiceExt(IDataModel argExt) {
/* 630 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 635 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 639 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 642 */     super.startTransaction();
/*     */     
/* 644 */     this._propertiesSavepoint = this._properties;
/* 645 */     if (this._properties != null) {
/* 646 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 647 */       Iterator<IDataModel> it = this._properties.iterator();
/* 648 */       while (it.hasNext()) {
/* 649 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 654 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 659 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 662 */     super.rollbackChanges();
/*     */     
/* 664 */     this._properties = this._propertiesSavepoint;
/* 665 */     this._propertiesSavepoint = null;
/* 666 */     if (this._properties != null) {
/* 667 */       Iterator<IDataModel> it = this._properties.iterator();
/* 668 */       while (it.hasNext()) {
/* 669 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 677 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 680 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 683 */     super.commitTransaction();
/*     */     
/* 685 */     this._propertiesSavepoint = this._properties;
/* 686 */     if (this._properties != null) {
/* 687 */       Iterator<IDataModel> it = this._properties.iterator();
/* 688 */       while (it.hasNext()) {
/* 689 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 691 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 695 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\ChargeAccountInvoiceModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */