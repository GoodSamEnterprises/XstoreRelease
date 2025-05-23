/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
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
/*     */ import dtv.xst.dao.cat.CustomerLoyaltyAccountPropertyId;
/*     */ import dtv.xst.dao.cat.ICustomerLoyaltyAccount;
/*     */ import dtv.xst.dao.cat.ICustomerLoyaltyAccountProperty;
/*     */ import dtv.xst.dao.cat.ICustomerLoyaltyCard;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CustomerLoyaltyAccountModel extends CustomerLoyaltyAccountBaseModel implements ICustomerLoyaltyAccount {
/*     */   private static final long serialVersionUID = -966459739L;
/*     */   private ICustomerLoyaltyCard _parentCard;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<ICustomerLoyaltyAccountProperty> _properties; private transient HistoricalList<ICustomerLoyaltyAccountProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new CustomerLoyaltyAccountDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CustomerLoyaltyAccountDAO getDAO_() {
/*  49 */     return (CustomerLoyaltyAccountDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  57 */     if (getDAO_().getOrganizationId() != null) {
/*  58 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  61 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  70 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  71 */       this._events != null && 
/*  72 */       postEventsForChanges()) {
/*  73 */       this._events.post(ICustomerLoyaltyAccount.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  80 */     boolean ev_postable = false;
/*     */     
/*  82 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  83 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  84 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  85 */       ev_postable = true;
/*  86 */       if (this._properties != null) {
/*     */         
/*  88 */         Iterator<CustomerLoyaltyAccountPropertyModel> it = this._properties.iterator();
/*  89 */         while (it.hasNext())
/*     */         {
/*  91 */           ((CustomerLoyaltyAccountPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCardNumber() {
/* 104 */     return getDAO_().getCardNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCardNumber(String argCardNumber) {
/* 112 */     if (setCardNumber_noev(argCardNumber) && 
/* 113 */       this._events != null && 
/* 114 */       postEventsForChanges()) {
/* 115 */       this._events.post(ICustomerLoyaltyAccount.SET_CARDNUMBER, argCardNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCardNumber_noev(String argCardNumber) {
/* 122 */     boolean ev_postable = false;
/*     */     
/* 124 */     if ((getDAO_().getCardNumber() == null && argCardNumber != null) || (
/* 125 */       getDAO_().getCardNumber() != null && !getDAO_().getCardNumber().equals(argCardNumber))) {
/* 126 */       getDAO_().setCardNumber(argCardNumber);
/* 127 */       ev_postable = true;
/* 128 */       if (this._properties != null) {
/*     */         
/* 130 */         Iterator<CustomerLoyaltyAccountPropertyModel> it = this._properties.iterator();
/* 131 */         while (it.hasNext())
/*     */         {
/* 133 */           ((CustomerLoyaltyAccountPropertyModel)it.next()).setCardNumber_noev(argCardNumber);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 138 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountId() {
/* 146 */     return getDAO_().getAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountId(String argAccountId) {
/* 154 */     if (setAccountId_noev(argAccountId) && 
/* 155 */       this._events != null && 
/* 156 */       postEventsForChanges()) {
/* 157 */       this._events.post(ICustomerLoyaltyAccount.SET_ACCOUNTID, argAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountId_noev(String argAccountId) {
/* 164 */     boolean ev_postable = false;
/*     */     
/* 166 */     if ((getDAO_().getAccountId() == null && argAccountId != null) || (
/* 167 */       getDAO_().getAccountId() != null && !getDAO_().getAccountId().equals(argAccountId))) {
/* 168 */       getDAO_().setAccountId(argAccountId);
/* 169 */       ev_postable = true;
/* 170 */       if (this._properties != null) {
/*     */         
/* 172 */         Iterator<CustomerLoyaltyAccountPropertyModel> it = this._properties.iterator();
/* 173 */         while (it.hasNext())
/*     */         {
/* 175 */           ((CustomerLoyaltyAccountPropertyModel)it.next()).setAccountId_noev(argAccountId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 180 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 188 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 196 */     if (setCreateDate_noev(argCreateDate) && 
/* 197 */       this._events != null && 
/* 198 */       postEventsForChanges()) {
/* 199 */       this._events.post(ICustomerLoyaltyAccount.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 206 */     boolean ev_postable = false;
/*     */     
/* 208 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 209 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 210 */       getDAO_().setCreateDate(argCreateDate);
/* 211 */       ev_postable = true;
/*     */     } 
/*     */     
/* 214 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 222 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 230 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 231 */       this._events != null && 
/* 232 */       postEventsForChanges()) {
/* 233 */       this._events.post(ICustomerLoyaltyAccount.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 240 */     boolean ev_postable = false;
/*     */     
/* 242 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 243 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 244 */       getDAO_().setCreateUserId(argCreateUserId);
/* 245 */       ev_postable = true;
/*     */     } 
/*     */     
/* 248 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 256 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 264 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 265 */       this._events != null && 
/* 266 */       postEventsForChanges()) {
/* 267 */       this._events.post(ICustomerLoyaltyAccount.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 274 */     boolean ev_postable = false;
/*     */     
/* 276 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 277 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 278 */       getDAO_().setUpdateDate(argUpdateDate);
/* 279 */       ev_postable = true;
/*     */     } 
/*     */     
/* 282 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 290 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 298 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 299 */       this._events != null && 
/* 300 */       postEventsForChanges()) {
/* 301 */       this._events.post(ICustomerLoyaltyAccount.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 308 */     boolean ev_postable = false;
/*     */     
/* 310 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 311 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 312 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 313 */       ev_postable = true;
/*     */     } 
/*     */     
/* 316 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLoyaltyProgramId() {
/* 324 */     return getDAO_().getLoyaltyProgramId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoyaltyProgramId(String argLoyaltyProgramId) {
/* 332 */     if (setLoyaltyProgramId_noev(argLoyaltyProgramId) && 
/* 333 */       this._events != null && 
/* 334 */       postEventsForChanges()) {
/* 335 */       this._events.post(ICustomerLoyaltyAccount.SET_LOYALTYPROGRAMID, argLoyaltyProgramId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLoyaltyProgramId_noev(String argLoyaltyProgramId) {
/* 342 */     boolean ev_postable = false;
/*     */     
/* 344 */     if ((getDAO_().getLoyaltyProgramId() == null && argLoyaltyProgramId != null) || (
/* 345 */       getDAO_().getLoyaltyProgramId() != null && !getDAO_().getLoyaltyProgramId().equals(argLoyaltyProgramId))) {
/* 346 */       getDAO_().setLoyaltyProgramId(argLoyaltyProgramId);
/* 347 */       ev_postable = true;
/*     */     } 
/*     */     
/* 350 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLoyaltyProgramName() {
/* 358 */     return getDAO_().getLoyaltyProgramName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoyaltyProgramName(String argLoyaltyProgramName) {
/* 366 */     if (setLoyaltyProgramName_noev(argLoyaltyProgramName) && 
/* 367 */       this._events != null && 
/* 368 */       postEventsForChanges()) {
/* 369 */       this._events.post(ICustomerLoyaltyAccount.SET_LOYALTYPROGRAMNAME, argLoyaltyProgramName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLoyaltyProgramName_noev(String argLoyaltyProgramName) {
/* 376 */     boolean ev_postable = false;
/*     */     
/* 378 */     if ((getDAO_().getLoyaltyProgramName() == null && argLoyaltyProgramName != null) || (
/* 379 */       getDAO_().getLoyaltyProgramName() != null && !getDAO_().getLoyaltyProgramName().equals(argLoyaltyProgramName))) {
/* 380 */       getDAO_().setLoyaltyProgramName(argLoyaltyProgramName);
/* 381 */       ev_postable = true;
/*     */     } 
/*     */     
/* 384 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLoyaltyProgramLevelId() {
/* 392 */     return getDAO_().getLoyaltyProgramLevelId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoyaltyProgramLevelId(String argLoyaltyProgramLevelId) {
/* 400 */     if (setLoyaltyProgramLevelId_noev(argLoyaltyProgramLevelId) && 
/* 401 */       this._events != null && 
/* 402 */       postEventsForChanges()) {
/* 403 */       this._events.post(ICustomerLoyaltyAccount.SET_LOYALTYPROGRAMLEVELID, argLoyaltyProgramLevelId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLoyaltyProgramLevelId_noev(String argLoyaltyProgramLevelId) {
/* 410 */     boolean ev_postable = false;
/*     */     
/* 412 */     if ((getDAO_().getLoyaltyProgramLevelId() == null && argLoyaltyProgramLevelId != null) || (
/* 413 */       getDAO_().getLoyaltyProgramLevelId() != null && !getDAO_().getLoyaltyProgramLevelId().equals(argLoyaltyProgramLevelId))) {
/* 414 */       getDAO_().setLoyaltyProgramLevelId(argLoyaltyProgramLevelId);
/* 415 */       ev_postable = true;
/*     */     } 
/*     */     
/* 418 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLoyaltyProgramLevelName() {
/* 426 */     return getDAO_().getLoyaltyProgramLevelName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoyaltyProgramLevelName(String argLoyaltyProgramLevelName) {
/* 434 */     if (setLoyaltyProgramLevelName_noev(argLoyaltyProgramLevelName) && 
/* 435 */       this._events != null && 
/* 436 */       postEventsForChanges()) {
/* 437 */       this._events.post(ICustomerLoyaltyAccount.SET_LOYALTYPROGRAMLEVELNAME, argLoyaltyProgramLevelName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLoyaltyProgramLevelName_noev(String argLoyaltyProgramLevelName) {
/* 444 */     boolean ev_postable = false;
/*     */     
/* 446 */     if ((getDAO_().getLoyaltyProgramLevelName() == null && argLoyaltyProgramLevelName != null) || (
/* 447 */       getDAO_().getLoyaltyProgramLevelName() != null && !getDAO_().getLoyaltyProgramLevelName().equals(argLoyaltyProgramLevelName))) {
/* 448 */       getDAO_().setLoyaltyProgramLevelName(argLoyaltyProgramLevelName);
/* 449 */       ev_postable = true;
/*     */     } 
/*     */     
/* 452 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 460 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 468 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 469 */       this._events != null && 
/* 470 */       postEventsForChanges()) {
/* 471 */       this._events.post(ICustomerLoyaltyAccount.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 478 */     boolean ev_postable = false;
/*     */     
/* 480 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 481 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 482 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 483 */       ev_postable = true;
/*     */     } 
/*     */     
/* 486 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 494 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 502 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 503 */       this._events != null && 
/* 504 */       postEventsForChanges()) {
/* 505 */       this._events.post(ICustomerLoyaltyAccount.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 512 */     boolean ev_postable = false;
/*     */     
/* 514 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 515 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 516 */       getDAO_().setExpirationDate(argExpirationDate);
/* 517 */       ev_postable = true;
/*     */     } 
/*     */     
/* 520 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAccountBalance() {
/* 528 */     return getDAO_().getAccountBalance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountBalance(BigDecimal argAccountBalance) {
/* 536 */     if (setAccountBalance_noev(argAccountBalance) && 
/* 537 */       this._events != null && 
/* 538 */       postEventsForChanges()) {
/* 539 */       this._events.post(ICustomerLoyaltyAccount.SET_ACCOUNTBALANCE, argAccountBalance);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountBalance_noev(BigDecimal argAccountBalance) {
/* 546 */     boolean ev_postable = false;
/*     */     
/* 548 */     if ((getDAO_().getAccountBalance() == null && argAccountBalance != null) || (
/* 549 */       getDAO_().getAccountBalance() != null && !getDAO_().getAccountBalance().equals(argAccountBalance))) {
/* 550 */       getDAO_().setAccountBalance(argAccountBalance);
/* 551 */       ev_postable = true;
/*     */     } 
/*     */     
/* 554 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getEscrowBalance() {
/* 562 */     return getDAO_().getEscrowBalance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEscrowBalance(BigDecimal argEscrowBalance) {
/* 570 */     if (setEscrowBalance_noev(argEscrowBalance) && 
/* 571 */       this._events != null && 
/* 572 */       postEventsForChanges()) {
/* 573 */       this._events.post(ICustomerLoyaltyAccount.SET_ESCROWBALANCE, argEscrowBalance);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEscrowBalance_noev(BigDecimal argEscrowBalance) {
/* 580 */     boolean ev_postable = false;
/*     */     
/* 582 */     if ((getDAO_().getEscrowBalance() == null && argEscrowBalance != null) || (
/* 583 */       getDAO_().getEscrowBalance() != null && !getDAO_().getEscrowBalance().equals(argEscrowBalance))) {
/* 584 */       getDAO_().setEscrowBalance(argEscrowBalance);
/* 585 */       ev_postable = true;
/*     */     } 
/*     */     
/* 588 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getBonusBalance() {
/* 596 */     return getDAO_().getBonusBalance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBonusBalance(BigDecimal argBonusBalance) {
/* 604 */     if (setBonusBalance_noev(argBonusBalance) && 
/* 605 */       this._events != null && 
/* 606 */       postEventsForChanges()) {
/* 607 */       this._events.post(ICustomerLoyaltyAccount.SET_BONUSBALANCE, argBonusBalance);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBonusBalance_noev(BigDecimal argBonusBalance) {
/* 614 */     boolean ev_postable = false;
/*     */     
/* 616 */     if ((getDAO_().getBonusBalance() == null && argBonusBalance != null) || (
/* 617 */       getDAO_().getBonusBalance() != null && !getDAO_().getBonusBalance().equals(argBonusBalance))) {
/* 618 */       getDAO_().setBonusBalance(argBonusBalance);
/* 619 */       ev_postable = true;
/*     */     } 
/*     */     
/* 622 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICustomerLoyaltyAccountProperty newProperty(String argPropertyName) {
/* 626 */     CustomerLoyaltyAccountPropertyId id = new CustomerLoyaltyAccountPropertyId();
/*     */     
/* 628 */     id.setCardNumber(getCardNumber());
/* 629 */     id.setAccountId(getAccountId());
/* 630 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 632 */     ICustomerLoyaltyAccountProperty prop = (ICustomerLoyaltyAccountProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICustomerLoyaltyAccountProperty.class);
/* 633 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICustomerLoyaltyAccountProperty> getProperties() {
/* 642 */     if (this._properties == null) {
/* 643 */       this._properties = new HistoricalList(null);
/*     */     }
/* 645 */     return (List<ICustomerLoyaltyAccountProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICustomerLoyaltyAccountProperty> argProperties) {
/* 649 */     if (this._properties == null) {
/* 650 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 652 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 655 */     for (ICustomerLoyaltyAccountProperty child : this._properties) {
/* 656 */       CustomerLoyaltyAccountPropertyModel model = (CustomerLoyaltyAccountPropertyModel)child;
/* 657 */       model.setOrganizationId_noev(getOrganizationId());
/* 658 */       model.setCardNumber_noev(getCardNumber());
/* 659 */       model.setAccountId_noev(getAccountId());
/* 660 */       if (child instanceof IDataModelImpl) {
/* 661 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 662 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 663 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 664 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 667 */       if (postEventsForChanges()) {
/* 668 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCustomerLoyaltyAccountProperty(ICustomerLoyaltyAccountProperty argCustomerLoyaltyAccountProperty) {
/* 674 */     if (this._properties == null) {
/* 675 */       this._properties = new HistoricalList(null);
/*     */     }
/* 677 */     argCustomerLoyaltyAccountProperty.setOrganizationId(getOrganizationId());
/* 678 */     argCustomerLoyaltyAccountProperty.setCardNumber(getCardNumber());
/* 679 */     argCustomerLoyaltyAccountProperty.setAccountId(getAccountId());
/* 680 */     if (argCustomerLoyaltyAccountProperty instanceof IDataModelImpl) {
/* 681 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerLoyaltyAccountProperty).getDAO();
/* 682 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 683 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 684 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 689 */     if (postEventsForChanges()) {
/* 690 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerLoyaltyAccountProperty));
/*     */     }
/*     */     
/* 693 */     this._properties.add(argCustomerLoyaltyAccountProperty);
/* 694 */     if (postEventsForChanges()) {
/* 695 */       this._events.post(ICustomerLoyaltyAccount.ADD_PROPERTIES, argCustomerLoyaltyAccountProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCustomerLoyaltyAccountProperty(ICustomerLoyaltyAccountProperty argCustomerLoyaltyAccountProperty) {
/* 700 */     if (this._properties != null) {
/*     */       
/* 702 */       if (postEventsForChanges()) {
/* 703 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerLoyaltyAccountProperty));
/*     */       }
/* 705 */       this._properties.remove(argCustomerLoyaltyAccountProperty);
/* 706 */       if (postEventsForChanges()) {
/* 707 */         this._events.post(ICustomerLoyaltyAccount.REMOVE_PROPERTIES, argCustomerLoyaltyAccountProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentCard(ICustomerLoyaltyCard argParentCard) {
/* 713 */     this._parentCard = argParentCard;
/*     */   }
/*     */   
/*     */   public ICustomerLoyaltyCard getParentCard() {
/* 717 */     return this._parentCard;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 722 */     if ("Properties".equals(argFieldId)) {
/* 723 */       return getProperties();
/*     */     }
/* 725 */     if ("CustomerLoyaltyAccountExtension".equals(argFieldId)) {
/* 726 */       return this._myExtension;
/*     */     }
/*     */     
/* 729 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 735 */     if ("Properties".equals(argFieldId)) {
/* 736 */       setProperties(changeToList(argValue, ICustomerLoyaltyAccountProperty.class));
/*     */     }
/* 738 */     else if ("CustomerLoyaltyAccountExtension".equals(argFieldId)) {
/* 739 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 742 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 748 */     this._persistenceDefaults = argPD;
/* 749 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 750 */     this._eventManager = argEM;
/* 751 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 752 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 753 */     if (this._properties != null) {
/* 754 */       for (ICustomerLoyaltyAccountProperty relationship : this._properties) {
/* 755 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCustomerLoyaltyAccountExt() {
/* 761 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCustomerLoyaltyAccountExt(IDataModel argExt) {
/* 765 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 770 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 774 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 777 */     super.startTransaction();
/*     */     
/* 779 */     this._propertiesSavepoint = this._properties;
/* 780 */     if (this._properties != null) {
/* 781 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 782 */       Iterator<IDataModel> it = this._properties.iterator();
/* 783 */       while (it.hasNext()) {
/* 784 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 789 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 794 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 797 */     super.rollbackChanges();
/*     */     
/* 799 */     this._properties = this._propertiesSavepoint;
/* 800 */     this._propertiesSavepoint = null;
/* 801 */     if (this._properties != null) {
/* 802 */       Iterator<IDataModel> it = this._properties.iterator();
/* 803 */       while (it.hasNext()) {
/* 804 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 812 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 815 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 818 */     super.commitTransaction();
/*     */     
/* 820 */     this._propertiesSavepoint = this._properties;
/* 821 */     if (this._properties != null) {
/* 822 */       Iterator<IDataModel> it = this._properties.iterator();
/* 823 */       while (it.hasNext()) {
/* 824 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 826 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 830 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerLoyaltyAccountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */