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
/*     */ import dtv.xst.dao.cat.CustomerAccountJournalPropertyId;
/*     */ import dtv.xst.dao.cat.ICustomerAccount;
/*     */ import dtv.xst.dao.cat.ICustomerAccountJournal;
/*     */ import dtv.xst.dao.cat.ICustomerAccountJournalProperty;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CustomerAccountJournalModel extends CustomerAccountJournalBaseModel implements ICustomerAccountJournal {
/*     */   private static final long serialVersionUID = 1713126376L;
/*     */   private ICustomerAccount _parentCustomerAccount;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<ICustomerAccountJournalProperty> _properties; private transient HistoricalList<ICustomerAccountJournalProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new CustomerAccountJournalDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CustomerAccountJournalDAO getDAO_() {
/*  49 */     return (CustomerAccountJournalDAO)this._daoImpl;
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
/*  73 */       this._events.post(ICustomerAccountJournal.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  88 */         Iterator<CustomerAccountJournalPropertyModel> it = this._properties.iterator();
/*  89 */         while (it.hasNext())
/*     */         {
/*  91 */           ((CustomerAccountJournalPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getCustAccountId() {
/* 104 */     return getDAO_().getCustAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 112 */     if (setCustAccountId_noev(argCustAccountId) && 
/* 113 */       this._events != null && 
/* 114 */       postEventsForChanges()) {
/* 115 */       this._events.post(ICustomerAccountJournal.SET_CUSTACCOUNTID, argCustAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountId_noev(String argCustAccountId) {
/* 122 */     boolean ev_postable = false;
/*     */     
/* 124 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/* 125 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/* 126 */       getDAO_().setCustAccountId(argCustAccountId);
/* 127 */       ev_postable = true;
/* 128 */       if (this._properties != null) {
/*     */         
/* 130 */         Iterator<CustomerAccountJournalPropertyModel> it = this._properties.iterator();
/* 131 */         while (it.hasNext())
/*     */         {
/* 133 */           ((CustomerAccountJournalPropertyModel)it.next()).setCustAccountId_noev(argCustAccountId);
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
/*     */   public String getCustAccountCode() {
/* 146 */     return getDAO_().getCustAccountCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/* 154 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/* 155 */       this._events != null && 
/* 156 */       postEventsForChanges()) {
/* 157 */       this._events.post(ICustomerAccountJournal.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/* 164 */     boolean ev_postable = false;
/*     */     
/* 166 */     if ((getDAO_().getCustAccountCode() == null && argCustAccountCode != null) || (
/* 167 */       getDAO_().getCustAccountCode() != null && !getDAO_().getCustAccountCode().equals(argCustAccountCode))) {
/* 168 */       getDAO_().setCustAccountCode(argCustAccountCode);
/* 169 */       ev_postable = true;
/* 170 */       if (this._properties != null) {
/*     */         
/* 172 */         Iterator<CustomerAccountJournalPropertyModel> it = this._properties.iterator();
/* 173 */         while (it.hasNext())
/*     */         {
/* 175 */           ((CustomerAccountJournalPropertyModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
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
/*     */   public long getJournalSequence() {
/* 188 */     if (getDAO_().getJournalSequence() != null) {
/* 189 */       return getDAO_().getJournalSequence().longValue();
/*     */     }
/*     */     
/* 192 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setJournalSequence(long argJournalSequence) {
/* 201 */     if (setJournalSequence_noev(argJournalSequence) && 
/* 202 */       this._events != null && 
/* 203 */       postEventsForChanges()) {
/* 204 */       this._events.post(ICustomerAccountJournal.SET_JOURNALSEQUENCE, Long.valueOf(argJournalSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setJournalSequence_noev(long argJournalSequence) {
/* 211 */     boolean ev_postable = false;
/*     */     
/* 213 */     if ((getDAO_().getJournalSequence() == null && Long.valueOf(argJournalSequence) != null) || (
/* 214 */       getDAO_().getJournalSequence() != null && !getDAO_().getJournalSequence().equals(Long.valueOf(argJournalSequence)))) {
/* 215 */       getDAO_().setJournalSequence(Long.valueOf(argJournalSequence));
/* 216 */       ev_postable = true;
/* 217 */       if (this._properties != null) {
/*     */         
/* 219 */         Iterator<CustomerAccountJournalPropertyModel> it = this._properties.iterator();
/* 220 */         while (it.hasNext())
/*     */         {
/* 222 */           ((CustomerAccountJournalPropertyModel)it.next()).setJournalSequence_noev(argJournalSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 227 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getClassName() {
/* 235 */     return getDAO_().getClassName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClassName(String argClassName) {
/* 243 */     if (setClassName_noev(argClassName) && 
/* 244 */       this._events != null && 
/* 245 */       postEventsForChanges()) {
/* 246 */       this._events.post(ICustomerAccountJournal.SET_CLASSNAME, argClassName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setClassName_noev(String argClassName) {
/* 253 */     boolean ev_postable = false;
/*     */     
/* 255 */     if ((getDAO_().getClassName() == null && argClassName != null) || (
/* 256 */       getDAO_().getClassName() != null && !getDAO_().getClassName().equals(argClassName))) {
/* 257 */       getDAO_().setClassName(argClassName);
/* 258 */       ev_postable = true;
/*     */     } 
/*     */     
/* 261 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 269 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 277 */     if (setCreateDate_noev(argCreateDate) && 
/* 278 */       this._events != null && 
/* 279 */       postEventsForChanges()) {
/* 280 */       this._events.post(ICustomerAccountJournal.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 287 */     boolean ev_postable = false;
/*     */     
/* 289 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 290 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 291 */       getDAO_().setCreateDate(argCreateDate);
/* 292 */       ev_postable = true;
/*     */     } 
/*     */     
/* 295 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 303 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 311 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 312 */       this._events != null && 
/* 313 */       postEventsForChanges()) {
/* 314 */       this._events.post(ICustomerAccountJournal.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 321 */     boolean ev_postable = false;
/*     */     
/* 323 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 324 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 325 */       getDAO_().setCreateUserId(argCreateUserId);
/* 326 */       ev_postable = true;
/*     */     } 
/*     */     
/* 329 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 337 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 345 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 346 */       this._events != null && 
/* 347 */       postEventsForChanges()) {
/* 348 */       this._events.post(ICustomerAccountJournal.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 355 */     boolean ev_postable = false;
/*     */     
/* 357 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 358 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 359 */       getDAO_().setUpdateDate(argUpdateDate);
/* 360 */       ev_postable = true;
/*     */     } 
/*     */     
/* 363 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 371 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 379 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 380 */       this._events != null && 
/* 381 */       postEventsForChanges()) {
/* 382 */       this._events.post(ICustomerAccountJournal.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 389 */     boolean ev_postable = false;
/*     */     
/* 391 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 392 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 393 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 394 */       ev_postable = true;
/*     */     } 
/*     */     
/* 397 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 405 */     if (getDAO_().getRetailLocationId() != null) {
/* 406 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 409 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 418 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 419 */       this._events != null && 
/* 420 */       postEventsForChanges()) {
/* 421 */       this._events.post(ICustomerAccountJournal.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 428 */     boolean ev_postable = false;
/*     */     
/* 430 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 431 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 432 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 433 */       ev_postable = true;
/*     */     } 
/*     */     
/* 436 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAccountBalance() {
/* 444 */     return getDAO_().getAccountBalance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountBalance(BigDecimal argAccountBalance) {
/* 452 */     if (setAccountBalance_noev(argAccountBalance) && 
/* 453 */       this._events != null && 
/* 454 */       postEventsForChanges()) {
/* 455 */       this._events.post(ICustomerAccountJournal.SET_ACCOUNTBALANCE, argAccountBalance);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountBalance_noev(BigDecimal argAccountBalance) {
/* 462 */     boolean ev_postable = false;
/*     */     
/* 464 */     if ((getDAO_().getAccountBalance() == null && argAccountBalance != null) || (
/* 465 */       getDAO_().getAccountBalance() != null && !getDAO_().getAccountBalance().equals(argAccountBalance))) {
/* 466 */       getDAO_().setAccountBalance(argAccountBalance);
/* 467 */       ev_postable = true;
/*     */     } 
/*     */     
/* 470 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustIdentityTypeCode() {
/* 478 */     return getDAO_().getCustIdentityTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustIdentityTypeCode(String argCustIdentityTypeCode) {
/* 486 */     if (setCustIdentityTypeCode_noev(argCustIdentityTypeCode) && 
/* 487 */       this._events != null && 
/* 488 */       postEventsForChanges()) {
/* 489 */       this._events.post(ICustomerAccountJournal.SET_CUSTIDENTITYTYPECODE, argCustIdentityTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustIdentityTypeCode_noev(String argCustIdentityTypeCode) {
/* 496 */     boolean ev_postable = false;
/*     */     
/* 498 */     if ((getDAO_().getCustIdentityTypeCode() == null && argCustIdentityTypeCode != null) || (
/* 499 */       getDAO_().getCustIdentityTypeCode() != null && !getDAO_().getCustIdentityTypeCode().equals(argCustIdentityTypeCode))) {
/* 500 */       getDAO_().setCustIdentityTypeCode(argCustIdentityTypeCode);
/* 501 */       ev_postable = true;
/*     */     } 
/*     */     
/* 504 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransRetailLocationId() {
/* 512 */     if (getDAO_().getTransRetailLocationId() != null) {
/* 513 */       return getDAO_().getTransRetailLocationId().longValue();
/*     */     }
/*     */     
/* 516 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransRetailLocationId(long argTransRetailLocationId) {
/* 525 */     if (setTransRetailLocationId_noev(argTransRetailLocationId) && 
/* 526 */       this._events != null && 
/* 527 */       postEventsForChanges()) {
/* 528 */       this._events.post(ICustomerAccountJournal.SET_TRANSRETAILLOCATIONID, Long.valueOf(argTransRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransRetailLocationId_noev(long argTransRetailLocationId) {
/* 535 */     boolean ev_postable = false;
/*     */     
/* 537 */     if ((getDAO_().getTransRetailLocationId() == null && Long.valueOf(argTransRetailLocationId) != null) || (
/* 538 */       getDAO_().getTransRetailLocationId() != null && !getDAO_().getTransRetailLocationId().equals(Long.valueOf(argTransRetailLocationId)))) {
/* 539 */       getDAO_().setTransRetailLocationId(Long.valueOf(argTransRetailLocationId));
/* 540 */       ev_postable = true;
/*     */     } 
/*     */     
/* 543 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransWorkstationId() {
/* 551 */     if (getDAO_().getTransWorkstationId() != null) {
/* 552 */       return getDAO_().getTransWorkstationId().longValue();
/*     */     }
/*     */     
/* 555 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransWorkstationId(long argTransWorkstationId) {
/* 564 */     if (setTransWorkstationId_noev(argTransWorkstationId) && 
/* 565 */       this._events != null && 
/* 566 */       postEventsForChanges()) {
/* 567 */       this._events.post(ICustomerAccountJournal.SET_TRANSWORKSTATIONID, Long.valueOf(argTransWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransWorkstationId_noev(long argTransWorkstationId) {
/* 574 */     boolean ev_postable = false;
/*     */     
/* 576 */     if ((getDAO_().getTransWorkstationId() == null && Long.valueOf(argTransWorkstationId) != null) || (
/* 577 */       getDAO_().getTransWorkstationId() != null && !getDAO_().getTransWorkstationId().equals(Long.valueOf(argTransWorkstationId)))) {
/* 578 */       getDAO_().setTransWorkstationId(Long.valueOf(argTransWorkstationId));
/* 579 */       ev_postable = true;
/*     */     } 
/*     */     
/* 582 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getTransBusinessDate() {
/* 590 */     return getDAO_().getTransBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransBusinessDate(Date argTransBusinessDate) {
/* 598 */     if (setTransBusinessDate_noev(argTransBusinessDate) && 
/* 599 */       this._events != null && 
/* 600 */       postEventsForChanges()) {
/* 601 */       this._events.post(ICustomerAccountJournal.SET_TRANSBUSINESSDATE, argTransBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransBusinessDate_noev(Date argTransBusinessDate) {
/* 608 */     boolean ev_postable = false;
/*     */     
/* 610 */     if ((getDAO_().getTransBusinessDate() == null && argTransBusinessDate != null) || (
/* 611 */       getDAO_().getTransBusinessDate() != null && !getDAO_().getTransBusinessDate().equals(argTransBusinessDate))) {
/* 612 */       getDAO_().setTransBusinessDate(argTransBusinessDate);
/* 613 */       ev_postable = true;
/*     */     } 
/*     */     
/* 616 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransSequence() {
/* 624 */     if (getDAO_().getTransSequence() != null) {
/* 625 */       return getDAO_().getTransSequence().longValue();
/*     */     }
/*     */     
/* 628 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransSequence(long argTransSequence) {
/* 637 */     if (setTransSequence_noev(argTransSequence) && 
/* 638 */       this._events != null && 
/* 639 */       postEventsForChanges()) {
/* 640 */       this._events.post(ICustomerAccountJournal.SET_TRANSSEQUENCE, Long.valueOf(argTransSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransSequence_noev(long argTransSequence) {
/* 647 */     boolean ev_postable = false;
/*     */     
/* 649 */     if ((getDAO_().getTransSequence() == null && Long.valueOf(argTransSequence) != null) || (
/* 650 */       getDAO_().getTransSequence() != null && !getDAO_().getTransSequence().equals(Long.valueOf(argTransSequence)))) {
/* 651 */       getDAO_().setTransSequence(Long.valueOf(argTransSequence));
/* 652 */       ev_postable = true;
/*     */     } 
/*     */     
/* 655 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPartyId() {
/* 663 */     if (getDAO_().getPartyId() != null) {
/* 664 */       return getDAO_().getPartyId().longValue();
/*     */     }
/*     */     
/* 667 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPartyId(long argPartyId) {
/* 676 */     if (setPartyId_noev(argPartyId) && 
/* 677 */       this._events != null && 
/* 678 */       postEventsForChanges()) {
/* 679 */       this._events.post(ICustomerAccountJournal.SET_PARTYID, Long.valueOf(argPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPartyId_noev(long argPartyId) {
/* 686 */     boolean ev_postable = false;
/*     */     
/* 688 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/* 689 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/* 690 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/* 691 */       ev_postable = true;
/*     */     } 
/*     */     
/* 694 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICustomerAccountJournalProperty newProperty(String argPropertyName) {
/* 698 */     CustomerAccountJournalPropertyId id = new CustomerAccountJournalPropertyId();
/*     */     
/* 700 */     id.setCustAccountId(getCustAccountId());
/* 701 */     id.setCustAccountCode(getCustAccountCode());
/* 702 */     id.setJournalSequence(Long.valueOf(getJournalSequence()));
/* 703 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 705 */     ICustomerAccountJournalProperty prop = (ICustomerAccountJournalProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICustomerAccountJournalProperty.class);
/* 706 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICustomerAccountJournalProperty> getProperties() {
/* 715 */     if (this._properties == null) {
/* 716 */       this._properties = new HistoricalList(null);
/*     */     }
/* 718 */     return (List<ICustomerAccountJournalProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICustomerAccountJournalProperty> argProperties) {
/* 722 */     if (this._properties == null) {
/* 723 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 725 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 728 */     for (ICustomerAccountJournalProperty child : this._properties) {
/* 729 */       CustomerAccountJournalPropertyModel model = (CustomerAccountJournalPropertyModel)child;
/* 730 */       model.setOrganizationId_noev(getOrganizationId());
/* 731 */       model.setCustAccountId_noev(getCustAccountId());
/* 732 */       model.setCustAccountCode_noev(getCustAccountCode());
/* 733 */       model.setJournalSequence_noev(getJournalSequence());
/* 734 */       if (child instanceof IDataModelImpl) {
/* 735 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 736 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 737 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 738 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 741 */       if (postEventsForChanges()) {
/* 742 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCustomerAccountJournalProperty(ICustomerAccountJournalProperty argCustomerAccountJournalProperty) {
/* 748 */     if (this._properties == null) {
/* 749 */       this._properties = new HistoricalList(null);
/*     */     }
/* 751 */     argCustomerAccountJournalProperty.setOrganizationId(getOrganizationId());
/* 752 */     argCustomerAccountJournalProperty.setCustAccountId(getCustAccountId());
/* 753 */     argCustomerAccountJournalProperty.setCustAccountCode(getCustAccountCode());
/* 754 */     argCustomerAccountJournalProperty.setJournalSequence(getJournalSequence());
/* 755 */     if (argCustomerAccountJournalProperty instanceof IDataModelImpl) {
/* 756 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerAccountJournalProperty).getDAO();
/* 757 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 758 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 759 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 764 */     if (postEventsForChanges()) {
/* 765 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAccountJournalProperty));
/*     */     }
/*     */     
/* 768 */     this._properties.add(argCustomerAccountJournalProperty);
/* 769 */     if (postEventsForChanges()) {
/* 770 */       this._events.post(ICustomerAccountJournal.ADD_PROPERTIES, argCustomerAccountJournalProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCustomerAccountJournalProperty(ICustomerAccountJournalProperty argCustomerAccountJournalProperty) {
/* 775 */     if (this._properties != null) {
/*     */       
/* 777 */       if (postEventsForChanges()) {
/* 778 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAccountJournalProperty));
/*     */       }
/* 780 */       this._properties.remove(argCustomerAccountJournalProperty);
/* 781 */       if (postEventsForChanges()) {
/* 782 */         this._events.post(ICustomerAccountJournal.REMOVE_PROPERTIES, argCustomerAccountJournalProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentCustomerAccount(ICustomerAccount argParentCustomerAccount) {
/* 788 */     this._parentCustomerAccount = argParentCustomerAccount;
/*     */   }
/*     */   
/*     */   public ICustomerAccount getParentCustomerAccount() {
/* 792 */     return this._parentCustomerAccount;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 797 */     if ("Properties".equals(argFieldId)) {
/* 798 */       return getProperties();
/*     */     }
/* 800 */     if ("CustomerAccountJournalExtension".equals(argFieldId)) {
/* 801 */       return this._myExtension;
/*     */     }
/*     */     
/* 804 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 810 */     if ("Properties".equals(argFieldId)) {
/* 811 */       setProperties(changeToList(argValue, ICustomerAccountJournalProperty.class));
/*     */     }
/* 813 */     else if ("CustomerAccountJournalExtension".equals(argFieldId)) {
/* 814 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 817 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 823 */     this._persistenceDefaults = argPD;
/* 824 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 825 */     this._eventManager = argEM;
/* 826 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 827 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 828 */     if (this._properties != null) {
/* 829 */       for (ICustomerAccountJournalProperty relationship : this._properties) {
/* 830 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCustomerAccountJournalExt() {
/* 836 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCustomerAccountJournalExt(IDataModel argExt) {
/* 840 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 845 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 849 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 852 */     super.startTransaction();
/*     */     
/* 854 */     this._propertiesSavepoint = this._properties;
/* 855 */     if (this._properties != null) {
/* 856 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 857 */       Iterator<IDataModel> it = this._properties.iterator();
/* 858 */       while (it.hasNext()) {
/* 859 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 864 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 869 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 872 */     super.rollbackChanges();
/*     */     
/* 874 */     this._properties = this._propertiesSavepoint;
/* 875 */     this._propertiesSavepoint = null;
/* 876 */     if (this._properties != null) {
/* 877 */       Iterator<IDataModel> it = this._properties.iterator();
/* 878 */       while (it.hasNext()) {
/* 879 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 887 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 890 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 893 */     super.commitTransaction();
/*     */     
/* 895 */     this._propertiesSavepoint = this._properties;
/* 896 */     if (this._properties != null) {
/* 897 */       Iterator<IDataModel> it = this._properties.iterator();
/* 898 */       while (it.hasNext()) {
/* 899 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 901 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 905 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountJournalModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */