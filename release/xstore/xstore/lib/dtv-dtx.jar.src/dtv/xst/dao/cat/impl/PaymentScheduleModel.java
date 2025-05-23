/*     */ package dtv.xst.dao.cat.impl;
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
/*     */ import dtv.xst.dao.cat.IPaymentSchedule;
/*     */ import dtv.xst.dao.cat.IPaymentScheduleProperty;
/*     */ import dtv.xst.dao.cat.PaymentSchedulePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class PaymentScheduleModel extends AbstractDataModelWithPropertyImpl<IPaymentScheduleProperty> implements IPaymentSchedule {
/*     */   private static final long serialVersionUID = 1798863517L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IPaymentScheduleProperty> _properties; private transient HistoricalList<IPaymentScheduleProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new PaymentScheduleDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PaymentScheduleDAO getDAO_() {
/*  46 */     return (PaymentScheduleDAO)this._daoImpl;
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
/*  70 */       this._events.post(IPaymentSchedule.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<PaymentSchedulePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((PaymentSchedulePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getCustAccountId() {
/* 101 */     return getDAO_().getCustAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 109 */     if (setCustAccountId_noev(argCustAccountId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IPaymentSchedule.SET_CUSTACCOUNTID, argCustAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountId_noev(String argCustAccountId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/* 122 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/* 123 */       getDAO_().setCustAccountId(argCustAccountId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<PaymentSchedulePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((PaymentSchedulePropertyModel)it.next()).setCustAccountId_noev(argCustAccountId);
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
/*     */   public String getCustAccountCode() {
/* 143 */     return getDAO_().getCustAccountCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/* 151 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IPaymentSchedule.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getCustAccountCode() == null && argCustAccountCode != null) || (
/* 164 */       getDAO_().getCustAccountCode() != null && !getDAO_().getCustAccountCode().equals(argCustAccountCode))) {
/* 165 */       getDAO_().setCustAccountCode(argCustAccountCode);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<PaymentSchedulePropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((PaymentSchedulePropertyModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 185 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 193 */     if (setCreateDate_noev(argCreateDate) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IPaymentSchedule.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 206 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 207 */       getDAO_().setCreateDate(argCreateDate);
/* 208 */       ev_postable = true;
/*     */     } 
/*     */     
/* 211 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 219 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 227 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 228 */       this._events != null && 
/* 229 */       postEventsForChanges()) {
/* 230 */       this._events.post(IPaymentSchedule.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 237 */     boolean ev_postable = false;
/*     */     
/* 239 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 240 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 241 */       getDAO_().setCreateUserId(argCreateUserId);
/* 242 */       ev_postable = true;
/*     */     } 
/*     */     
/* 245 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 253 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 261 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 262 */       this._events != null && 
/* 263 */       postEventsForChanges()) {
/* 264 */       this._events.post(IPaymentSchedule.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 271 */     boolean ev_postable = false;
/*     */     
/* 273 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 274 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 275 */       getDAO_().setUpdateDate(argUpdateDate);
/* 276 */       ev_postable = true;
/*     */     } 
/*     */     
/* 279 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 287 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 295 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(IPaymentSchedule.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 308 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 309 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 310 */       ev_postable = true;
/*     */     } 
/*     */     
/* 313 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBeginDate() {
/* 321 */     return getDAO_().getBeginDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBeginDate(Date argBeginDate) {
/* 329 */     if (setBeginDate_noev(argBeginDate) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(IPaymentSchedule.SET_BEGINDATE, argBeginDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBeginDate_noev(Date argBeginDate) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getBeginDate() == null && argBeginDate != null) || (
/* 342 */       getDAO_().getBeginDate() != null && !getDAO_().getBeginDate().equals(argBeginDate))) {
/* 343 */       getDAO_().setBeginDate(argBeginDate);
/* 344 */       ev_postable = true;
/*     */     } 
/*     */     
/* 347 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIntervalTypeEnum() {
/* 355 */     return getDAO_().getIntervalTypeEnum();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIntervalTypeEnum(String argIntervalTypeEnum) {
/* 363 */     if (setIntervalTypeEnum_noev(argIntervalTypeEnum) && 
/* 364 */       this._events != null && 
/* 365 */       postEventsForChanges()) {
/* 366 */       this._events.post(IPaymentSchedule.SET_INTERVALTYPEENUM, argIntervalTypeEnum);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIntervalTypeEnum_noev(String argIntervalTypeEnum) {
/* 373 */     boolean ev_postable = false;
/*     */     
/* 375 */     if ((getDAO_().getIntervalTypeEnum() == null && argIntervalTypeEnum != null) || (
/* 376 */       getDAO_().getIntervalTypeEnum() != null && !getDAO_().getIntervalTypeEnum().equals(argIntervalTypeEnum))) {
/* 377 */       getDAO_().setIntervalTypeEnum(argIntervalTypeEnum);
/* 378 */       ev_postable = true;
/*     */     } 
/*     */     
/* 381 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIntervalCount() {
/* 389 */     if (getDAO_().getIntervalCount() != null) {
/* 390 */       return getDAO_().getIntervalCount().intValue();
/*     */     }
/*     */     
/* 393 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIntervalCount(int argIntervalCount) {
/* 402 */     if (setIntervalCount_noev(argIntervalCount) && 
/* 403 */       this._events != null && 
/* 404 */       postEventsForChanges()) {
/* 405 */       this._events.post(IPaymentSchedule.SET_INTERVALCOUNT, Integer.valueOf(argIntervalCount));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIntervalCount_noev(int argIntervalCount) {
/* 412 */     boolean ev_postable = false;
/*     */     
/* 414 */     if ((getDAO_().getIntervalCount() == null && Integer.valueOf(argIntervalCount) != null) || (
/* 415 */       getDAO_().getIntervalCount() != null && !getDAO_().getIntervalCount().equals(Integer.valueOf(argIntervalCount)))) {
/* 416 */       getDAO_().setIntervalCount(Integer.valueOf(argIntervalCount));
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
/*     */   public BigDecimal getTotalPaymentAmount() {
/* 428 */     return getDAO_().getTotalPaymentAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTotalPaymentAmount(BigDecimal argTotalPaymentAmount) {
/* 436 */     if (setTotalPaymentAmount_noev(argTotalPaymentAmount) && 
/* 437 */       this._events != null && 
/* 438 */       postEventsForChanges()) {
/* 439 */       this._events.post(IPaymentSchedule.SET_TOTALPAYMENTAMOUNT, argTotalPaymentAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTotalPaymentAmount_noev(BigDecimal argTotalPaymentAmount) {
/* 446 */     boolean ev_postable = false;
/*     */     
/* 448 */     if ((getDAO_().getTotalPaymentAmount() == null && argTotalPaymentAmount != null) || (
/* 449 */       getDAO_().getTotalPaymentAmount() != null && !getDAO_().getTotalPaymentAmount().equals(argTotalPaymentAmount))) {
/* 450 */       getDAO_().setTotalPaymentAmount(argTotalPaymentAmount);
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
/*     */   public int getPaymentCount() {
/* 462 */     if (getDAO_().getPaymentCount() != null) {
/* 463 */       return getDAO_().getPaymentCount().intValue();
/*     */     }
/*     */     
/* 466 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPaymentCount(int argPaymentCount) {
/* 475 */     if (setPaymentCount_noev(argPaymentCount) && 
/* 476 */       this._events != null && 
/* 477 */       postEventsForChanges()) {
/* 478 */       this._events.post(IPaymentSchedule.SET_PAYMENTCOUNT, Integer.valueOf(argPaymentCount));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPaymentCount_noev(int argPaymentCount) {
/* 485 */     boolean ev_postable = false;
/*     */     
/* 487 */     if ((getDAO_().getPaymentCount() == null && Integer.valueOf(argPaymentCount) != null) || (
/* 488 */       getDAO_().getPaymentCount() != null && !getDAO_().getPaymentCount().equals(Integer.valueOf(argPaymentCount)))) {
/* 489 */       getDAO_().setPaymentCount(Integer.valueOf(argPaymentCount));
/* 490 */       ev_postable = true;
/*     */     } 
/*     */     
/* 493 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IPaymentScheduleProperty newProperty(String argPropertyName) {
/* 497 */     PaymentSchedulePropertyId id = new PaymentSchedulePropertyId();
/*     */     
/* 499 */     id.setCustAccountId(getCustAccountId());
/* 500 */     id.setCustAccountCode(getCustAccountCode());
/* 501 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 503 */     IPaymentScheduleProperty prop = (IPaymentScheduleProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPaymentScheduleProperty.class);
/* 504 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IPaymentScheduleProperty> getProperties() {
/* 513 */     if (this._properties == null) {
/* 514 */       this._properties = new HistoricalList(null);
/*     */     }
/* 516 */     return (List<IPaymentScheduleProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IPaymentScheduleProperty> argProperties) {
/* 520 */     if (this._properties == null) {
/* 521 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 523 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 526 */     for (IPaymentScheduleProperty child : this._properties) {
/* 527 */       PaymentSchedulePropertyModel model = (PaymentSchedulePropertyModel)child;
/* 528 */       model.setOrganizationId_noev(getOrganizationId());
/* 529 */       model.setCustAccountId_noev(getCustAccountId());
/* 530 */       model.setCustAccountCode_noev(getCustAccountCode());
/* 531 */       if (child instanceof IDataModelImpl) {
/* 532 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 533 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 534 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 535 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 538 */       if (postEventsForChanges()) {
/* 539 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addPaymentScheduleProperty(IPaymentScheduleProperty argPaymentScheduleProperty) {
/* 545 */     if (this._properties == null) {
/* 546 */       this._properties = new HistoricalList(null);
/*     */     }
/* 548 */     argPaymentScheduleProperty.setOrganizationId(getOrganizationId());
/* 549 */     argPaymentScheduleProperty.setCustAccountId(getCustAccountId());
/* 550 */     argPaymentScheduleProperty.setCustAccountCode(getCustAccountCode());
/* 551 */     if (argPaymentScheduleProperty instanceof IDataModelImpl) {
/* 552 */       IDataAccessObject childDao = ((IDataModelImpl)argPaymentScheduleProperty).getDAO();
/* 553 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 554 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 555 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 560 */     if (postEventsForChanges()) {
/* 561 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPaymentScheduleProperty));
/*     */     }
/*     */     
/* 564 */     this._properties.add(argPaymentScheduleProperty);
/* 565 */     if (postEventsForChanges()) {
/* 566 */       this._events.post(IPaymentSchedule.ADD_PROPERTIES, argPaymentScheduleProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePaymentScheduleProperty(IPaymentScheduleProperty argPaymentScheduleProperty) {
/* 571 */     if (this._properties != null) {
/*     */       
/* 573 */       if (postEventsForChanges()) {
/* 574 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPaymentScheduleProperty));
/*     */       }
/* 576 */       this._properties.remove(argPaymentScheduleProperty);
/* 577 */       if (postEventsForChanges()) {
/* 578 */         this._events.post(IPaymentSchedule.REMOVE_PROPERTIES, argPaymentScheduleProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 585 */     if ("Properties".equals(argFieldId)) {
/* 586 */       return getProperties();
/*     */     }
/* 588 */     if ("PaymentScheduleExtension".equals(argFieldId)) {
/* 589 */       return this._myExtension;
/*     */     }
/*     */     
/* 592 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 598 */     if ("Properties".equals(argFieldId)) {
/* 599 */       setProperties(changeToList(argValue, IPaymentScheduleProperty.class));
/*     */     }
/* 601 */     else if ("PaymentScheduleExtension".equals(argFieldId)) {
/* 602 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 605 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 611 */     this._persistenceDefaults = argPD;
/* 612 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 613 */     this._eventManager = argEM;
/* 614 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 615 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 616 */     if (this._properties != null) {
/* 617 */       for (IPaymentScheduleProperty relationship : this._properties) {
/* 618 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getPaymentScheduleExt() {
/* 624 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setPaymentScheduleExt(IDataModel argExt) {
/* 628 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 633 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 637 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 640 */     super.startTransaction();
/*     */     
/* 642 */     this._propertiesSavepoint = this._properties;
/* 643 */     if (this._properties != null) {
/* 644 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 645 */       Iterator<IDataModel> it = this._properties.iterator();
/* 646 */       while (it.hasNext()) {
/* 647 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 652 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 657 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 660 */     super.rollbackChanges();
/*     */     
/* 662 */     this._properties = this._propertiesSavepoint;
/* 663 */     this._propertiesSavepoint = null;
/* 664 */     if (this._properties != null) {
/* 665 */       Iterator<IDataModel> it = this._properties.iterator();
/* 666 */       while (it.hasNext()) {
/* 667 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 675 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 678 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 681 */     super.commitTransaction();
/*     */     
/* 683 */     this._propertiesSavepoint = this._properties;
/* 684 */     if (this._properties != null) {
/* 685 */       Iterator<IDataModel> it = this._properties.iterator();
/* 686 */       while (it.hasNext()) {
/* 687 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 689 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 693 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 698 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\PaymentScheduleModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */