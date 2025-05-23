/*     */ package dtv.xst.dao.cat.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.cat.ICustomerAccountJournal;
/*     */ import dtv.xst.dao.cat.ICustomerItemAccount;
/*     */ import dtv.xst.dao.cat.ICustomerItemAccountDetail;
/*     */ import dtv.xst.dao.cat.ICustomerItemAccountJournal;
/*     */ import dtv.xst.dao.cat.IDeliveryModifier;
/*     */ import dtv.xst.daocommon.ILineItemFilter;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class CustomerItemAccountModel extends CustomerAccountModel implements ICustomerItemAccount {
/*     */   private static final long serialVersionUID = -1032547140L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public void initDAO() {
/*  33 */     setDAO((IDataAccessObject)new CustomerItemAccountDAO());
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private IDeliveryModifier _deliveryModifier;
/*     */   private transient IDeliveryModifier _deliveryModifierSavepoint;
/*     */   private HistoricalList<ICustomerItemAccountDetail> _custItemAccountDetails;
/*     */   private transient HistoricalList<ICustomerItemAccountDetail> _custItemAccountDetailsSavepoint;
/*     */   
/*     */   private CustomerItemAccountDAO getDAO_() {
/*  41 */     return (CustomerItemAccountDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  49 */     if (getDAO_().getOrganizationId() != null) {
/*  50 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  53 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  62 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  63 */       this._events != null && 
/*  64 */       postEventsForChanges()) {
/*  65 */       this._events.post(ICustomerItemAccount.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  72 */     boolean ev_postable = false;
/*     */ 
/*     */     
/*  75 */     if (super.setOrganizationId_noev(argOrganizationId)) {
/*  76 */       if (this._custItemAccountDetails != null) {
/*     */         
/*  78 */         Iterator<CustomerItemAccountDetailModel> it = this._custItemAccountDetails.iterator();
/*  79 */         while (it.hasNext())
/*     */         {
/*  81 */           ((CustomerItemAccountDetailModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  84 */       if (this._deliveryModifier != null)
/*     */       {
/*     */         
/*  87 */         ((DeliveryModifierModel)this._deliveryModifier).setOrganizationId_noev(argOrganizationId);
/*     */       }
/*     */     } 
/*     */     
/*  91 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/*  99 */     return getDAO_().getCustAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 107 */     if (setCustAccountId_noev(argCustAccountId) && 
/* 108 */       this._events != null && 
/* 109 */       postEventsForChanges()) {
/* 110 */       this._events.post(ICustomerItemAccount.SET_CUSTACCOUNTID, argCustAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountId_noev(String argCustAccountId) {
/* 117 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 120 */     if (super.setCustAccountId_noev(argCustAccountId)) {
/* 121 */       if (this._custItemAccountDetails != null) {
/*     */         
/* 123 */         Iterator<CustomerItemAccountDetailModel> it = this._custItemAccountDetails.iterator();
/* 124 */         while (it.hasNext())
/*     */         {
/* 126 */           ((CustomerItemAccountDetailModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*     */         }
/*     */       } 
/* 129 */       if (this._deliveryModifier != null)
/*     */       {
/*     */         
/* 132 */         ((DeliveryModifierModel)this._deliveryModifier).setCustAccountId_noev(argCustAccountId);
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
/* 155 */       this._events.post(ICustomerItemAccount.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/* 162 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 165 */     if (super.setCustAccountCode_noev(argCustAccountCode)) {
/* 166 */       if (this._custItemAccountDetails != null) {
/*     */         
/* 168 */         Iterator<CustomerItemAccountDetailModel> it = this._custItemAccountDetails.iterator();
/* 169 */         while (it.hasNext())
/*     */         {
/* 171 */           ((CustomerItemAccountDetailModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*     */         }
/*     */       } 
/* 174 */       if (this._deliveryModifier != null)
/*     */       {
/*     */         
/* 177 */         ((DeliveryModifierModel)this._deliveryModifier).setCustAccountCode_noev(argCustAccountCode);
/*     */       }
/*     */     } 
/*     */     
/* 181 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 189 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 197 */     if (setCreateDate_noev(argCreateDate) && 
/* 198 */       this._events != null && 
/* 199 */       postEventsForChanges()) {
/* 200 */       this._events.post(ICustomerItemAccount.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 207 */     boolean ev_postable = false;
/*     */     
/* 209 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 210 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 211 */       getDAO_().setCreateDate(argCreateDate);
/* 212 */       ev_postable = true;
/*     */     } 
/*     */     
/* 215 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 223 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 231 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 232 */       this._events != null && 
/* 233 */       postEventsForChanges()) {
/* 234 */       this._events.post(ICustomerItemAccount.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 241 */     boolean ev_postable = false;
/*     */     
/* 243 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 244 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 245 */       getDAO_().setCreateUserId(argCreateUserId);
/* 246 */       ev_postable = true;
/*     */     } 
/*     */     
/* 249 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 257 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 265 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 266 */       this._events != null && 
/* 267 */       postEventsForChanges()) {
/* 268 */       this._events.post(ICustomerItemAccount.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 275 */     boolean ev_postable = false;
/*     */     
/* 277 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 278 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 279 */       getDAO_().setUpdateDate(argUpdateDate);
/* 280 */       ev_postable = true;
/*     */     } 
/*     */     
/* 283 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 291 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 299 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 300 */       this._events != null && 
/* 301 */       postEventsForChanges()) {
/* 302 */       this._events.post(ICustomerItemAccount.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 309 */     boolean ev_postable = false;
/*     */     
/* 311 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 312 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 313 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 314 */       ev_postable = true;
/*     */     } 
/*     */     
/* 317 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAccountTotal() {
/* 325 */     return getDAO_().getAccountTotal();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountTotal(BigDecimal argAccountTotal) {
/* 333 */     if (setAccountTotal_noev(argAccountTotal) && 
/* 334 */       this._events != null && 
/* 335 */       postEventsForChanges()) {
/* 336 */       this._events.post(ICustomerItemAccount.SET_ACCOUNTTOTAL, argAccountTotal);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountTotal_noev(BigDecimal argAccountTotal) {
/* 343 */     boolean ev_postable = false;
/*     */     
/* 345 */     if ((getDAO_().getAccountTotal() == null && argAccountTotal != null) || (
/* 346 */       getDAO_().getAccountTotal() != null && !getDAO_().getAccountTotal().equals(argAccountTotal))) {
/* 347 */       getDAO_().setAccountTotal(argAccountTotal);
/* 348 */       ev_postable = true;
/*     */     } 
/*     */     
/* 351 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAccountPayments() {
/* 359 */     return getDAO_().getAccountPayments();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountPayments(BigDecimal argAccountPayments) {
/* 367 */     if (setAccountPayments_noev(argAccountPayments) && 
/* 368 */       this._events != null && 
/* 369 */       postEventsForChanges()) {
/* 370 */       this._events.post(ICustomerItemAccount.SET_ACCOUNTPAYMENTS, argAccountPayments);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountPayments_noev(BigDecimal argAccountPayments) {
/* 377 */     boolean ev_postable = false;
/*     */     
/* 379 */     if ((getDAO_().getAccountPayments() == null && argAccountPayments != null) || (
/* 380 */       getDAO_().getAccountPayments() != null && !getDAO_().getAccountPayments().equals(argAccountPayments))) {
/* 381 */       getDAO_().setAccountPayments(argAccountPayments);
/* 382 */       ev_postable = true;
/*     */     } 
/*     */     
/* 385 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getActiveAccountPayments() {
/* 393 */     return getDAO_().getActiveAccountPayments();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActiveAccountPayments(BigDecimal argActiveAccountPayments) {
/* 401 */     if (setActiveAccountPayments_noev(argActiveAccountPayments) && 
/* 402 */       this._events != null && 
/* 403 */       postEventsForChanges()) {
/* 404 */       this._events.post(ICustomerItemAccount.SET_ACTIVEACCOUNTPAYMENTS, argActiveAccountPayments);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActiveAccountPayments_noev(BigDecimal argActiveAccountPayments) {
/* 411 */     boolean ev_postable = false;
/*     */     
/* 413 */     if ((getDAO_().getActiveAccountPayments() == null && argActiveAccountPayments != null) || (
/* 414 */       getDAO_().getActiveAccountPayments() != null && !getDAO_().getActiveAccountPayments().equals(argActiveAccountPayments))) {
/* 415 */       getDAO_().setActiveAccountPayments(argActiveAccountPayments);
/* 416 */       ev_postable = true;
/*     */     } 
/*     */     
/* 419 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getActiveAccountTotal() {
/* 427 */     return getDAO_().getActiveAccountTotal();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActiveAccountTotal(BigDecimal argActiveAccountTotal) {
/* 435 */     if (setActiveAccountTotal_noev(argActiveAccountTotal) && 
/* 436 */       this._events != null && 
/* 437 */       postEventsForChanges()) {
/* 438 */       this._events.post(ICustomerItemAccount.SET_ACTIVEACCOUNTTOTAL, argActiveAccountTotal);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActiveAccountTotal_noev(BigDecimal argActiveAccountTotal) {
/* 445 */     boolean ev_postable = false;
/*     */     
/* 447 */     if ((getDAO_().getActiveAccountTotal() == null && argActiveAccountTotal != null) || (
/* 448 */       getDAO_().getActiveAccountTotal() != null && !getDAO_().getActiveAccountTotal().equals(argActiveAccountTotal))) {
/* 449 */       getDAO_().setActiveAccountTotal(argActiveAccountTotal);
/* 450 */       ev_postable = true;
/*     */     } 
/*     */     
/* 453 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "DeliveryModifier")
/*     */   public IDeliveryModifier getDeliveryModifier() {
/* 465 */     return this._deliveryModifier;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeliveryModifier(IDeliveryModifier argDeliveryModifier) {
/* 470 */     if (argDeliveryModifier == null) {
/*     */       
/* 472 */       if (this._deliveryModifier != null) {
/* 473 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*     */       }
/* 475 */       if (this._deliveryModifier != null) {
/*     */         
/* 477 */         if (postEventsForChanges()) {
/* 478 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._deliveryModifier));
/*     */         }
/* 480 */         addDeletedObject((IDataModel)this._deliveryModifier);
/*     */       } 
/*     */     } else {
/*     */       
/* 484 */       argDeliveryModifier.setOrganizationId(getOrganizationId());
/* 485 */       argDeliveryModifier.setCustAccountId(getCustAccountId());
/* 486 */       argDeliveryModifier.setCustAccountCode(getCustAccountCode());
/*     */ 
/*     */       
/* 489 */       if (postEventsForChanges()) {
/* 490 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDeliveryModifier));
/*     */       }
/*     */     } 
/*     */     
/* 494 */     this._deliveryModifier = argDeliveryModifier;
/* 495 */     if (postEventsForChanges()) {
/* 496 */       this._events.post(ICustomerItemAccount.SET_DELIVERYMODIFIER, argDeliveryModifier);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "CustItemAccountDetails")
/*     */   public List<ICustomerItemAccountDetail> getCustItemAccountDetails() {
/* 502 */     if (this._custItemAccountDetails == null) {
/* 503 */       this._custItemAccountDetails = new HistoricalList(null);
/*     */     }
/* 505 */     return (List<ICustomerItemAccountDetail>)this._custItemAccountDetails;
/*     */   }
/*     */   
/*     */   public void setCustItemAccountDetails(List<ICustomerItemAccountDetail> argCustItemAccountDetails) {
/* 509 */     if (this._custItemAccountDetails == null) {
/* 510 */       this._custItemAccountDetails = new HistoricalList(argCustItemAccountDetails);
/*     */     } else {
/* 512 */       this._custItemAccountDetails.setCurrentList(argCustItemAccountDetails);
/*     */     } 
/*     */     
/* 515 */     for (ICustomerItemAccountDetail child : this._custItemAccountDetails) {
/* 516 */       child.setParentCustItemAccount(this);
/*     */     }
/*     */     
/* 519 */     for (ICustomerItemAccountDetail child : this._custItemAccountDetails) {
/* 520 */       CustomerItemAccountDetailModel model = (CustomerItemAccountDetailModel)child;
/* 521 */       model.setOrganizationId_noev(getOrganizationId());
/* 522 */       model.setCustAccountId_noev(getCustAccountId());
/* 523 */       model.setCustAccountCode_noev(getCustAccountCode());
/* 524 */       if (child instanceof IDataModelImpl) {
/* 525 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 526 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 527 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 528 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 531 */       if (postEventsForChanges()) {
/* 532 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addCustomerItemAccountDetailImpl(ICustomerItemAccountDetail argCustomerItemAccountDetail) {
/* 539 */     argCustomerItemAccountDetail.setParentCustItemAccount(this);
/* 540 */     if (this._custItemAccountDetails == null) {
/* 541 */       this._custItemAccountDetails = new HistoricalList(null);
/*     */     }
/* 543 */     argCustomerItemAccountDetail.setOrganizationId(getOrganizationId());
/* 544 */     argCustomerItemAccountDetail.setCustAccountId(getCustAccountId());
/* 545 */     argCustomerItemAccountDetail.setCustAccountCode(getCustAccountCode());
/* 546 */     if (argCustomerItemAccountDetail instanceof IDataModelImpl) {
/* 547 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerItemAccountDetail).getDAO();
/* 548 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 549 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 550 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 555 */     if (postEventsForChanges()) {
/* 556 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerItemAccountDetail));
/*     */     }
/*     */     
/* 559 */     this._custItemAccountDetails.add(argCustomerItemAccountDetail);
/* 560 */     if (postEventsForChanges()) {
/* 561 */       this._events.post(ICustomerItemAccount.ADD_CUSTITEMACCOUNTDETAILS, argCustomerItemAccountDetail);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCustomerItemAccountDetail(ICustomerItemAccountDetail argCustomerItemAccountDetail) {
/* 566 */     if (this._custItemAccountDetails != null) {
/*     */       
/* 568 */       if (postEventsForChanges()) {
/* 569 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerItemAccountDetail));
/*     */       }
/* 571 */       this._custItemAccountDetails.remove(argCustomerItemAccountDetail);
/*     */       
/* 573 */       argCustomerItemAccountDetail.setParentCustItemAccount(null);
/* 574 */       if (postEventsForChanges()) {
/* 575 */         this._events.post(ICustomerItemAccount.REMOVE_CUSTITEMACCOUNTDETAILS, argCustomerItemAccountDetail);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 582 */     if ("DeliveryModifier".equals(argFieldId)) {
/* 583 */       return getDeliveryModifier();
/*     */     }
/* 585 */     if ("CustItemAccountDetails".equals(argFieldId)) {
/* 586 */       return getCustItemAccountDetails();
/*     */     }
/* 588 */     if ("CustomerItemAccountExtension".equals(argFieldId)) {
/* 589 */       return this._myExtension;
/*     */     }
/*     */     
/* 592 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 598 */     if ("DeliveryModifier".equals(argFieldId)) {
/* 599 */       setDeliveryModifier((IDeliveryModifier)argValue);
/*     */     }
/* 601 */     else if ("CustItemAccountDetails".equals(argFieldId)) {
/* 602 */       setCustItemAccountDetails(changeToList(argValue, ICustomerItemAccountDetail.class));
/*     */     }
/* 604 */     else if ("CustomerItemAccountExtension".equals(argFieldId)) {
/* 605 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 608 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 614 */     super.setDependencies(argPD, argEM);
/* 615 */     if (this._deliveryModifier != null) {
/* 616 */       ((IDataModelImpl)this._deliveryModifier).setDependencies(argPD, argEM);
/*     */     }
/* 618 */     if (this._custItemAccountDetails != null) {
/* 619 */       for (ICustomerItemAccountDetail relationship : this._custItemAccountDetails) {
/* 620 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCustomerItemAccountExt() {
/* 626 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCustomerItemAccountExt(IDataModel argExt) {
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
/* 644 */     this._deliveryModifierSavepoint = this._deliveryModifier;
/* 645 */     if (this._deliveryModifier != null) {
/* 646 */       this._deliveryModifier.startTransaction();
/*     */     }
/*     */     
/* 649 */     this._custItemAccountDetailsSavepoint = this._custItemAccountDetails;
/* 650 */     if (this._custItemAccountDetails != null) {
/* 651 */       this._custItemAccountDetailsSavepoint = new HistoricalList((List)this._custItemAccountDetails);
/* 652 */       Iterator<IDataModel> it = this._custItemAccountDetails.iterator();
/* 653 */       while (it.hasNext()) {
/* 654 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 659 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 664 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 667 */     super.rollbackChanges();
/*     */     
/* 669 */     this._deliveryModifier = this._deliveryModifierSavepoint;
/* 670 */     this._deliveryModifierSavepoint = null;
/* 671 */     if (this._deliveryModifier != null) {
/* 672 */       this._deliveryModifier.rollbackChanges();
/*     */     }
/*     */     
/* 675 */     this._custItemAccountDetails = this._custItemAccountDetailsSavepoint;
/* 676 */     this._custItemAccountDetailsSavepoint = null;
/* 677 */     if (this._custItemAccountDetails != null) {
/* 678 */       Iterator<IDataModel> it = this._custItemAccountDetails.iterator();
/* 679 */       while (it.hasNext()) {
/* 680 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 688 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 691 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 694 */     super.commitTransaction();
/*     */     
/* 696 */     this._deliveryModifierSavepoint = this._deliveryModifier;
/* 697 */     if (this._deliveryModifier != null) {
/* 698 */       this._deliveryModifier.commitTransaction();
/*     */     }
/*     */     
/* 701 */     this._custItemAccountDetailsSavepoint = this._custItemAccountDetails;
/* 702 */     if (this._custItemAccountDetails != null) {
/* 703 */       Iterator<IDataModel> it = this._custItemAccountDetails.iterator();
/* 704 */       while (it.hasNext()) {
/* 705 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 707 */       this._custItemAccountDetails = new HistoricalList((List)this._custItemAccountDetails);
/*     */     } 
/*     */ 
/*     */     
/* 711 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 716 */     argStream.defaultReadObject();
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
/* 727 */   private transient int _openItemCount = 0;
/*     */   
/*     */   private transient BigDecimal _roundingAmount;
/*     */   
/*     */   public int getOpenItemCount() {
/* 732 */     return this._openItemCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOpenItemCount(int argOpenItemCount) {
/* 737 */     this._openItemCount = argOpenItemCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getRoundedAmount() {
/* 742 */     return this._roundingAmount;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRoundedAmount(BigDecimal argAmount) {
/* 747 */     this._roundingAmount = argAmount;
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveToJournal(ICustomerAccountJournal argJournal) {
/* 752 */     super.saveToJournal(argJournal);
/*     */     
/* 754 */     if (argJournal instanceof ICustomerItemAccountJournal) {
/* 755 */       ICustomerItemAccountJournal journal = (ICustomerItemAccountJournal)argJournal;
/*     */ 
/*     */       
/* 758 */       journal.setAccountPayments(getAccountPayments());
/* 759 */       journal.setAccountSetupDate(getAccountSetupDate());
/* 760 */       journal.setAccountTotal(getAccountTotal());
/* 761 */       journal.setActiveAccountPayments(getActiveAccountPayments());
/* 762 */       journal.setActiveAccountTotal(getActiveAccountTotal());
/* 763 */       journal.setCustAccountStateCode(getCustAccountStateCode());
/* 764 */       journal.setLastActivityDate(getLastActivityDate());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addCustomerItemAccountDetail(ICustomerItemAccountDetail argCustomerItemAccountDetail) {
/* 772 */     synchronized (this) {
/* 773 */       argCustomerItemAccountDetail.setCustAccountDetailNum((getCustItemAccountDetails().size() + 1));
/* 774 */       addCustomerItemAccountDetailImpl(argCustomerItemAccountDetail);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeliveryLastName() {
/* 780 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getLastName();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeliveryLastName(String argLastName) {
/* 785 */     if (this._deliveryModifier != null) {
/* 786 */       this._deliveryModifier.setLastName(argLastName);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeliveryFirstName() {
/* 792 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getFirstName();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeliveryFirstName(String argFirstName) {
/* 797 */     if (this._deliveryModifier != null) {
/* 798 */       this._deliveryModifier.setFirstName(argFirstName);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeliveryMiddleName() {
/* 804 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getMiddleName();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeliveryMiddleName(String argMiddleName) {
/* 809 */     if (this._deliveryModifier != null) {
/* 810 */       this._deliveryModifier.setMiddleName(argMiddleName);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeliveryAddress1() {
/* 816 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getAddress1();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeliveryAddress1(String argAddress1) {
/* 821 */     if (this._deliveryModifier != null) {
/* 822 */       this._deliveryModifier.setAddress1(argAddress1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeliveryAddress2() {
/* 828 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getAddress2();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeliveryAddress2(String argAddress2) {
/* 833 */     if (this._deliveryModifier != null) {
/* 834 */       this._deliveryModifier.setAddress2(argAddress2);
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDeliveryAddress3() {
/* 839 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getAddress3();
/*     */   }
/*     */   
/*     */   public void setDeliveryAddress3(String argAddress3) {
/* 843 */     if (this._deliveryModifier != null) {
/* 844 */       this._deliveryModifier.setAddress3(argAddress3);
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDeliveryAddress4() {
/* 849 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getAddress4();
/*     */   }
/*     */   
/*     */   public void setDeliveryAddress4(String argAddress4) {
/* 853 */     if (this._deliveryModifier != null) {
/* 854 */       this._deliveryModifier.setAddress4(argAddress4);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeliveryApartment() {
/* 860 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getApartment();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeliveryApartment(String argApartment) {
/* 865 */     if (this._deliveryModifier != null) {
/* 866 */       this._deliveryModifier.setApartment(argApartment);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeliveryCity() {
/* 872 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getCity();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeliveryCity(String argCity) {
/* 877 */     if (this._deliveryModifier != null) {
/* 878 */       this._deliveryModifier.setCity(argCity);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeliveryState() {
/* 884 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getState();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeliveryState(String argState) {
/* 889 */     if (this._deliveryModifier != null) {
/* 890 */       this._deliveryModifier.setState(argState);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeliveryPostalCode() {
/* 896 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getPostalCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeliveryPostalCode(String argPostalCode) {
/* 901 */     if (this._deliveryModifier != null) {
/* 902 */       this._deliveryModifier.setPostalCode(argPostalCode);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeliveryCountry() {
/* 908 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getCountry();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeliveryCountry(String argCountry) {
/* 913 */     if (this._deliveryModifier != null) {
/* 914 */       this._deliveryModifier.setCountry(argCountry);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeliveryTelephone1() {
/* 920 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getTelephone1();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeliveryTelephone1(String argTelephone1) {
/* 925 */     if (this._deliveryModifier != null) {
/* 926 */       this._deliveryModifier.setTelephone1(argTelephone1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeliveryTelephone2() {
/* 932 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getTelephone2();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeliveryTelephone2(String argTelephone2) {
/* 937 */     if (this._deliveryModifier != null) {
/* 938 */       this._deliveryModifier.setTelephone2(argTelephone2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeliveryTelephone3() {
/* 944 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getTelephone3();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeliveryTelephone3(String argTelephone3) {
/* 949 */     if (this._deliveryModifier != null) {
/* 950 */       this._deliveryModifier.setTelephone3(argTelephone3);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeliveryTelephone4() {
/* 956 */     return (this._deliveryModifier == null) ? null : this._deliveryModifier.getTelephone4();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeliveryTelephone4(String argTelephone4) {
/* 961 */     if (this._deliveryModifier != null) {
/* 962 */       this._deliveryModifier.setTelephone4(argTelephone4);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public List<? extends IDataModel> getCustItemAccountDetailsFiltered(String argFilterClass) {
/* 968 */     if (this._custItemAccountDetails == null) {
/* 969 */       this._custItemAccountDetails = new HistoricalList(null);
/*     */     } else {
/*     */       
/* 972 */       ILineItemFilter lineItemFilter = null;
/*     */       try {
/* 974 */         lineItemFilter = (ILineItemFilter)Class.forName(argFilterClass).newInstance();
/*     */       }
/* 976 */       catch (Exception ex) {
/* 977 */         Logger.getLogger(getClass()).error("CAUGHT EXCEPTION", ex);
/* 978 */         return (List)this._custItemAccountDetails;
/*     */       } 
/* 980 */       return lineItemFilter.filter((List)this._custItemAccountDetails);
/*     */     } 
/* 982 */     return (List)this._custItemAccountDetails;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerItemAccountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */