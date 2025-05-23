/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.cat.IChargeAccountHistory;
/*     */ import dtv.xst.dao.cat.IChargeAccountUser;
/*     */ import dtv.xst.dao.cat.ICustomerConsumerChargeAccount;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CustomerConsumerChargeAccountModel
/*     */   extends CustomerAccountModel
/*     */   implements ICustomerConsumerChargeAccount {
/*     */   private static final long serialVersionUID = 424808229L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public void initDAO() {
/*  32 */     setDAO((IDataAccessObject)new CustomerConsumerChargeAccountDAO());
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension;
/*     */   private HistoricalList<IChargeAccountUser> _chargeAccountUsers;
/*     */   private transient HistoricalList<IChargeAccountUser> _chargeAccountUsersSavepoint;
/*     */   private HistoricalList<IChargeAccountHistory> _chargeAccountHistories;
/*     */   
/*     */   private CustomerConsumerChargeAccountDAO getDAO_() {
/*  40 */     return (CustomerConsumerChargeAccountDAO)this._daoImpl;
/*     */   }
/*     */   
/*     */   private transient HistoricalList<IChargeAccountHistory> _chargeAccountHistoriesSavepoint;
/*     */   private transient BigDecimal availableCredit;
/*     */   private transient String accountName;
/*     */   
/*     */   public long getOrganizationId() {
/*  48 */     if (getDAO_().getOrganizationId() != null) {
/*  49 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  52 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  61 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  62 */       this._events != null && 
/*  63 */       postEventsForChanges()) {
/*  64 */       this._events.post(ICustomerConsumerChargeAccount.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  71 */     boolean ev_postable = false;
/*     */ 
/*     */     
/*  74 */     if (super.setOrganizationId_noev(argOrganizationId)) {
/*  75 */       if (this._chargeAccountUsers != null) {
/*     */         
/*  77 */         Iterator<ChargeAccountUserModel> it = this._chargeAccountUsers.iterator();
/*  78 */         while (it.hasNext())
/*     */         {
/*  80 */           ((ChargeAccountUserModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  83 */       if (this._chargeAccountHistories != null) {
/*     */         
/*  85 */         Iterator<ChargeAccountHistoryModel> it = this._chargeAccountHistories.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ChargeAccountHistoryModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 112 */       this._events.post(ICustomerConsumerChargeAccount.SET_CUSTACCOUNTID, argCustAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountId_noev(String argCustAccountId) {
/* 119 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 122 */     if (super.setCustAccountId_noev(argCustAccountId)) {
/* 123 */       if (this._chargeAccountUsers != null) {
/*     */         
/* 125 */         Iterator<ChargeAccountUserModel> it = this._chargeAccountUsers.iterator();
/* 126 */         while (it.hasNext())
/*     */         {
/* 128 */           ((ChargeAccountUserModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*     */         }
/*     */       } 
/* 131 */       if (this._chargeAccountHistories != null) {
/*     */         
/* 133 */         Iterator<ChargeAccountHistoryModel> it = this._chargeAccountHistories.iterator();
/* 134 */         while (it.hasNext())
/*     */         {
/* 136 */           ((ChargeAccountHistoryModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 141 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountCode() {
/* 149 */     return getDAO_().getCustAccountCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/* 157 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/* 158 */       this._events != null && 
/* 159 */       postEventsForChanges()) {
/* 160 */       this._events.post(ICustomerConsumerChargeAccount.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/* 167 */     boolean ev_postable = false;
/*     */ 
/*     */     
/* 170 */     if (super.setCustAccountCode_noev(argCustAccountCode)) {
/* 171 */       if (this._chargeAccountUsers != null) {
/*     */         
/* 173 */         Iterator<ChargeAccountUserModel> it = this._chargeAccountUsers.iterator();
/* 174 */         while (it.hasNext())
/*     */         {
/* 176 */           ((ChargeAccountUserModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*     */         }
/*     */       } 
/* 179 */       if (this._chargeAccountHistories != null) {
/*     */         
/* 181 */         Iterator<ChargeAccountHistoryModel> it = this._chargeAccountHistories.iterator();
/* 182 */         while (it.hasNext())
/*     */         {
/* 184 */           ((ChargeAccountHistoryModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 189 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 197 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 205 */     if (setCreateDate_noev(argCreateDate) && 
/* 206 */       this._events != null && 
/* 207 */       postEventsForChanges()) {
/* 208 */       this._events.post(ICustomerConsumerChargeAccount.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 215 */     boolean ev_postable = false;
/*     */     
/* 217 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 218 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 219 */       getDAO_().setCreateDate(argCreateDate);
/* 220 */       ev_postable = true;
/*     */     } 
/*     */     
/* 223 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 231 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 239 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 240 */       this._events != null && 
/* 241 */       postEventsForChanges()) {
/* 242 */       this._events.post(ICustomerConsumerChargeAccount.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 249 */     boolean ev_postable = false;
/*     */     
/* 251 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 252 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 253 */       getDAO_().setCreateUserId(argCreateUserId);
/* 254 */       ev_postable = true;
/*     */     } 
/*     */     
/* 257 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 265 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 273 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 274 */       this._events != null && 
/* 275 */       postEventsForChanges()) {
/* 276 */       this._events.post(ICustomerConsumerChargeAccount.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 283 */     boolean ev_postable = false;
/*     */     
/* 285 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 286 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 287 */       getDAO_().setUpdateDate(argUpdateDate);
/* 288 */       ev_postable = true;
/*     */     } 
/*     */     
/* 291 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 299 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 307 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 308 */       this._events != null && 
/* 309 */       postEventsForChanges()) {
/* 310 */       this._events.post(ICustomerConsumerChargeAccount.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 317 */     boolean ev_postable = false;
/*     */     
/* 319 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 320 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 321 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 322 */       ev_postable = true;
/*     */     } 
/*     */     
/* 325 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BigDecimal getCreditLimitImpl() {
/* 333 */     return getDAO_().getCreditLimit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreditLimit(BigDecimal argCreditLimit) {
/* 341 */     if (setCreditLimit_noev(argCreditLimit) && 
/* 342 */       this._events != null && 
/* 343 */       postEventsForChanges()) {
/* 344 */       this._events.post(ICustomerConsumerChargeAccount.SET_CREDITLIMIT, argCreditLimit);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreditLimit_noev(BigDecimal argCreditLimit) {
/* 351 */     boolean ev_postable = false;
/*     */     
/* 353 */     if ((getDAO_().getCreditLimit() == null && argCreditLimit != null) || (
/* 354 */       getDAO_().getCreditLimit() != null && !getDAO_().getCreditLimit().equals(argCreditLimit))) {
/* 355 */       getDAO_().setCreditLimit(argCreditLimit);
/* 356 */       ev_postable = true;
/*     */     } 
/*     */     
/* 359 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPoRequired() {
/* 367 */     if (getDAO_().getPoRequired() != null) {
/* 368 */       return getDAO_().getPoRequired().booleanValue();
/*     */     }
/*     */     
/* 371 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPoRequired(boolean argPoRequired) {
/* 380 */     if (setPoRequired_noev(argPoRequired) && 
/* 381 */       this._events != null && 
/* 382 */       postEventsForChanges()) {
/* 383 */       this._events.post(ICustomerConsumerChargeAccount.SET_POREQUIRED, Boolean.valueOf(argPoRequired));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPoRequired_noev(boolean argPoRequired) {
/* 390 */     boolean ev_postable = false;
/*     */     
/* 392 */     if ((getDAO_().getPoRequired() == null && Boolean.valueOf(argPoRequired) != null) || (
/* 393 */       getDAO_().getPoRequired() != null && !getDAO_().getPoRequired().equals(Boolean.valueOf(argPoRequired)))) {
/* 394 */       getDAO_().setPoRequired(Boolean.valueOf(argPoRequired));
/* 395 */       ev_postable = true;
/*     */     } 
/*     */     
/* 398 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getOnHold() {
/* 406 */     if (getDAO_().getOnHold() != null) {
/* 407 */       return getDAO_().getOnHold().booleanValue();
/*     */     }
/*     */     
/* 410 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOnHold(boolean argOnHold) {
/* 419 */     if (setOnHold_noev(argOnHold) && 
/* 420 */       this._events != null && 
/* 421 */       postEventsForChanges()) {
/* 422 */       this._events.post(ICustomerConsumerChargeAccount.SET_ONHOLD, Boolean.valueOf(argOnHold));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOnHold_noev(boolean argOnHold) {
/* 429 */     boolean ev_postable = false;
/*     */     
/* 431 */     if ((getDAO_().getOnHold() == null && Boolean.valueOf(argOnHold) != null) || (
/* 432 */       getDAO_().getOnHold() != null && !getDAO_().getOnHold().equals(Boolean.valueOf(argOnHold)))) {
/* 433 */       getDAO_().setOnHold(Boolean.valueOf(argOnHold));
/* 434 */       ev_postable = true;
/*     */     } 
/*     */     
/* 437 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getIsCorporateAccount() {
/* 445 */     if (getDAO_().getIsCorporateAccount() != null) {
/* 446 */       return getDAO_().getIsCorporateAccount().booleanValue();
/*     */     }
/*     */     
/* 449 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsCorporateAccount(boolean argIsCorporateAccount) {
/* 458 */     if (setIsCorporateAccount_noev(argIsCorporateAccount) && 
/* 459 */       this._events != null && 
/* 460 */       postEventsForChanges()) {
/* 461 */       this._events.post(ICustomerConsumerChargeAccount.SET_ISCORPORATEACCOUNT, Boolean.valueOf(argIsCorporateAccount));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIsCorporateAccount_noev(boolean argIsCorporateAccount) {
/* 468 */     boolean ev_postable = false;
/*     */     
/* 470 */     if ((getDAO_().getIsCorporateAccount() == null && Boolean.valueOf(argIsCorporateAccount) != null) || (
/* 471 */       getDAO_().getIsCorporateAccount() != null && !getDAO_().getIsCorporateAccount().equals(Boolean.valueOf(argIsCorporateAccount)))) {
/* 472 */       getDAO_().setIsCorporateAccount(Boolean.valueOf(argIsCorporateAccount));
/* 473 */       ev_postable = true;
/*     */     } 
/*     */     
/* 476 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "ChargeAccountUsers")
/*     */   public List<IChargeAccountUser> getChargeAccountUsers() {
/* 488 */     if (this._chargeAccountUsers == null) {
/* 489 */       this._chargeAccountUsers = new HistoricalList(null);
/*     */     }
/* 491 */     return (List<IChargeAccountUser>)this._chargeAccountUsers;
/*     */   }
/*     */   
/*     */   public void setChargeAccountUsers(List<IChargeAccountUser> argChargeAccountUsers) {
/* 495 */     if (this._chargeAccountUsers == null) {
/* 496 */       this._chargeAccountUsers = new HistoricalList(argChargeAccountUsers);
/*     */     } else {
/* 498 */       this._chargeAccountUsers.setCurrentList(argChargeAccountUsers);
/*     */     } 
/*     */     
/* 501 */     for (IChargeAccountUser child : this._chargeAccountUsers) {
/* 502 */       ChargeAccountUserModel model = (ChargeAccountUserModel)child;
/* 503 */       model.setOrganizationId_noev(getOrganizationId());
/* 504 */       model.setCustAccountId_noev(getCustAccountId());
/* 505 */       model.setCustAccountCode_noev(getCustAccountCode());
/* 506 */       if (child instanceof IDataModelImpl) {
/* 507 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 508 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 509 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 510 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 513 */       if (postEventsForChanges()) {
/* 514 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addChargeAccountUser(IChargeAccountUser argChargeAccountUser) {
/* 520 */     if (this._chargeAccountUsers == null) {
/* 521 */       this._chargeAccountUsers = new HistoricalList(null);
/*     */     }
/* 523 */     argChargeAccountUser.setOrganizationId(getOrganizationId());
/* 524 */     argChargeAccountUser.setCustAccountId(getCustAccountId());
/* 525 */     argChargeAccountUser.setCustAccountCode(getCustAccountCode());
/* 526 */     if (argChargeAccountUser instanceof IDataModelImpl) {
/* 527 */       IDataAccessObject childDao = ((IDataModelImpl)argChargeAccountUser).getDAO();
/* 528 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 529 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 530 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 535 */     if (postEventsForChanges()) {
/* 536 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argChargeAccountUser));
/*     */     }
/*     */     
/* 539 */     this._chargeAccountUsers.add(argChargeAccountUser);
/* 540 */     if (postEventsForChanges()) {
/* 541 */       this._events.post(ICustomerConsumerChargeAccount.ADD_CHARGEACCOUNTUSERS, argChargeAccountUser);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeChargeAccountUser(IChargeAccountUser argChargeAccountUser) {
/* 546 */     if (this._chargeAccountUsers != null) {
/*     */       
/* 548 */       if (postEventsForChanges()) {
/* 549 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argChargeAccountUser));
/*     */       }
/* 551 */       this._chargeAccountUsers.remove(argChargeAccountUser);
/* 552 */       if (postEventsForChanges()) {
/* 553 */         this._events.post(ICustomerConsumerChargeAccount.REMOVE_CHARGEACCOUNTUSERS, argChargeAccountUser);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "ChargeAccountHistories")
/*     */   public List<IChargeAccountHistory> getChargeAccountHistories() {
/* 560 */     if (this._chargeAccountHistories == null) {
/* 561 */       this._chargeAccountHistories = new HistoricalList(null);
/*     */     }
/* 563 */     return (List<IChargeAccountHistory>)this._chargeAccountHistories;
/*     */   }
/*     */   
/*     */   public void setChargeAccountHistories(List<IChargeAccountHistory> argChargeAccountHistories) {
/* 567 */     if (this._chargeAccountHistories == null) {
/* 568 */       this._chargeAccountHistories = new HistoricalList(argChargeAccountHistories);
/*     */     } else {
/* 570 */       this._chargeAccountHistories.setCurrentList(argChargeAccountHistories);
/*     */     } 
/*     */     
/* 573 */     for (IChargeAccountHistory child : this._chargeAccountHistories) {
/* 574 */       ChargeAccountHistoryModel model = (ChargeAccountHistoryModel)child;
/* 575 */       model.setOrganizationId_noev(getOrganizationId());
/* 576 */       model.setCustAccountId_noev(getCustAccountId());
/* 577 */       model.setCustAccountCode_noev(getCustAccountCode());
/* 578 */       if (child instanceof IDataModelImpl) {
/* 579 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 580 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 581 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 582 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 585 */       if (postEventsForChanges()) {
/* 586 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addChargeAccountHistory(IChargeAccountHistory argChargeAccountHistory) {
/* 592 */     if (this._chargeAccountHistories == null) {
/* 593 */       this._chargeAccountHistories = new HistoricalList(null);
/*     */     }
/* 595 */     argChargeAccountHistory.setOrganizationId(getOrganizationId());
/* 596 */     argChargeAccountHistory.setCustAccountId(getCustAccountId());
/* 597 */     argChargeAccountHistory.setCustAccountCode(getCustAccountCode());
/* 598 */     if (argChargeAccountHistory instanceof IDataModelImpl) {
/* 599 */       IDataAccessObject childDao = ((IDataModelImpl)argChargeAccountHistory).getDAO();
/* 600 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 601 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 602 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 607 */     if (postEventsForChanges()) {
/* 608 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argChargeAccountHistory));
/*     */     }
/*     */     
/* 611 */     this._chargeAccountHistories.add(argChargeAccountHistory);
/* 612 */     if (postEventsForChanges()) {
/* 613 */       this._events.post(ICustomerConsumerChargeAccount.ADD_CHARGEACCOUNTHISTORIES, argChargeAccountHistory);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeChargeAccountHistory(IChargeAccountHistory argChargeAccountHistory) {
/* 618 */     if (this._chargeAccountHistories != null) {
/*     */       
/* 620 */       if (postEventsForChanges()) {
/* 621 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argChargeAccountHistory));
/*     */       }
/* 623 */       this._chargeAccountHistories.remove(argChargeAccountHistory);
/* 624 */       if (postEventsForChanges()) {
/* 625 */         this._events.post(ICustomerConsumerChargeAccount.REMOVE_CHARGEACCOUNTHISTORIES, argChargeAccountHistory);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 632 */     if ("ChargeAccountUsers".equals(argFieldId)) {
/* 633 */       return getChargeAccountUsers();
/*     */     }
/* 635 */     if ("ChargeAccountHistories".equals(argFieldId)) {
/* 636 */       return getChargeAccountHistories();
/*     */     }
/* 638 */     if ("CustomerConsumerChargeAccountExtension".equals(argFieldId)) {
/* 639 */       return this._myExtension;
/*     */     }
/*     */     
/* 642 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 648 */     if ("ChargeAccountUsers".equals(argFieldId)) {
/* 649 */       setChargeAccountUsers(changeToList(argValue, IChargeAccountUser.class));
/*     */     }
/* 651 */     else if ("ChargeAccountHistories".equals(argFieldId)) {
/* 652 */       setChargeAccountHistories(changeToList(argValue, IChargeAccountHistory.class));
/*     */     }
/* 654 */     else if ("CustomerConsumerChargeAccountExtension".equals(argFieldId)) {
/* 655 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 658 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 664 */     super.setDependencies(argPD, argEM);
/* 665 */     if (this._chargeAccountUsers != null) {
/* 666 */       for (IChargeAccountUser relationship : this._chargeAccountUsers) {
/* 667 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 670 */     if (this._chargeAccountHistories != null) {
/* 671 */       for (IChargeAccountHistory relationship : this._chargeAccountHistories) {
/* 672 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCustomerConsumerChargeAccountExt() {
/* 678 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCustomerConsumerChargeAccountExt(IDataModel argExt) {
/* 682 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 687 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 691 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 694 */     super.startTransaction();
/*     */     
/* 696 */     this._chargeAccountUsersSavepoint = this._chargeAccountUsers;
/* 697 */     if (this._chargeAccountUsers != null) {
/* 698 */       this._chargeAccountUsersSavepoint = new HistoricalList((List)this._chargeAccountUsers);
/* 699 */       Iterator<IDataModel> it = this._chargeAccountUsers.iterator();
/* 700 */       while (it.hasNext()) {
/* 701 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 705 */     this._chargeAccountHistoriesSavepoint = this._chargeAccountHistories;
/* 706 */     if (this._chargeAccountHistories != null) {
/* 707 */       this._chargeAccountHistoriesSavepoint = new HistoricalList((List)this._chargeAccountHistories);
/* 708 */       Iterator<IDataModel> it = this._chargeAccountHistories.iterator();
/* 709 */       while (it.hasNext()) {
/* 710 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 715 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 720 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 723 */     super.rollbackChanges();
/*     */     
/* 725 */     this._chargeAccountUsers = this._chargeAccountUsersSavepoint;
/* 726 */     this._chargeAccountUsersSavepoint = null;
/* 727 */     if (this._chargeAccountUsers != null) {
/* 728 */       Iterator<IDataModel> it = this._chargeAccountUsers.iterator();
/* 729 */       while (it.hasNext()) {
/* 730 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 734 */     this._chargeAccountHistories = this._chargeAccountHistoriesSavepoint;
/* 735 */     this._chargeAccountHistoriesSavepoint = null;
/* 736 */     if (this._chargeAccountHistories != null) {
/* 737 */       Iterator<IDataModel> it = this._chargeAccountHistories.iterator();
/* 738 */       while (it.hasNext()) {
/* 739 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 747 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 750 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 753 */     super.commitTransaction();
/*     */     
/* 755 */     this._chargeAccountUsersSavepoint = this._chargeAccountUsers;
/* 756 */     if (this._chargeAccountUsers != null) {
/* 757 */       Iterator<IDataModel> it = this._chargeAccountUsers.iterator();
/* 758 */       while (it.hasNext()) {
/* 759 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 761 */       this._chargeAccountUsers = new HistoricalList((List)this._chargeAccountUsers);
/*     */     } 
/*     */     
/* 764 */     this._chargeAccountHistoriesSavepoint = this._chargeAccountHistories;
/* 765 */     if (this._chargeAccountHistories != null) {
/* 766 */       Iterator<IDataModel> it = this._chargeAccountHistories.iterator();
/* 767 */       while (it.hasNext()) {
/* 768 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 770 */       this._chargeAccountHistories = new HistoricalList((List)this._chargeAccountHistories);
/*     */     } 
/*     */ 
/*     */     
/* 774 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 779 */     argStream.defaultReadObject();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateAccountBalance() {
/* 796 */     BigDecimal balanceAmt = NumberUtils.ZERO;
/*     */     
/* 798 */     if (this._chargeAccountHistories != null && !this._chargeAccountHistories.isEmpty()) {
/* 799 */       Iterator<IChargeAccountHistory> it = this._chargeAccountHistories.iterator();
/* 800 */       while (it.hasNext()) {
/* 801 */         IChargeAccountHistory history = it.next();
/* 802 */         balanceAmt = balanceAmt.add(NumberUtils.nonNull(history.getAmt()));
/*     */       } 
/*     */     } 
/*     */     
/* 806 */     setAccountBalance(balanceAmt);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAccountName() {
/* 811 */     return this.accountName;
/*     */   }
/*     */   
/*     */   public void setAccountName(String argName) {
/* 815 */     this.accountName = argName;
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getAvailableCredit() {
/* 820 */     this.availableCredit = NumberUtils.add(getCreditLimit(), getAccountBalance().negate());
/* 821 */     return this.availableCredit;
/*     */   }
/*     */   
/*     */   public BigDecimal getAccountBalance() {
/* 825 */     return (getDAO_().getAccountBalance() != null) ? getDAO_().getAccountBalance() : NumberUtils.ZERO;
/*     */   }
/*     */   
/*     */   public void setAvailableCredit(BigDecimal argValue) {
/* 829 */     this.availableCredit = argValue;
/*     */   }
/*     */   
/*     */   public String getOrganizationName() {
/* 833 */     if (getParty() != null) {
/* 834 */       setAccountName(getParty().getOrganizationName());
/*     */     }
/* 836 */     return this.accountName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getCreditLimit() {
/* 843 */     return (getDAO_().getCreditLimit() != null) ? getDAO_().getCreditLimit() : NumberUtils.ZERO;
/*     */   }
/*     */   
/*     */   public IChargeAccountHistory getLastPaymentAccountHistory() {
/* 847 */     IChargeAccountHistory lastActivity = null;
/* 848 */     List<IChargeAccountHistory> activities = getChargeAccountHistories();
/* 849 */     if (activities != null && activities.size() > 0) {
/* 850 */       for (IChargeAccountHistory activity : activities) {
/* 851 */         if (activity.getActivityEnum().equals("PAYMENT") && !activity.getReversedFlag()) {
/* 852 */           if (lastActivity != null) {
/* 853 */             if (activity.getActivityDate().compareTo(lastActivity.getActivityDate()) > 0 || (activity
/* 854 */               .getActivityDate().compareTo(lastActivity.getActivityDate()) == 0 && activity
/* 855 */               .getTransactionSequence() > lastActivity.getTransactionSequence()))
/* 856 */               lastActivity = activity; 
/*     */             continue;
/*     */           } 
/* 859 */           lastActivity = activity;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 865 */     return lastActivity;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerConsumerChargeAccountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */