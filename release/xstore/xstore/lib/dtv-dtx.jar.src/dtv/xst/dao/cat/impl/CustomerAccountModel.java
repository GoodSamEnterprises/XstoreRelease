/*      */ package dtv.xst.dao.cat.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.cat.CustomerAccountPropertyId;
/*      */ import dtv.xst.dao.cat.ICustomerAccount;
/*      */ import dtv.xst.dao.cat.ICustomerAccountJournal;
/*      */ import dtv.xst.dao.cat.ICustomerAccountNote;
/*      */ import dtv.xst.dao.cat.ICustomerAccountProperty;
/*      */ import dtv.xst.dao.cat.IPaymentSchedule;
/*      */ import dtv.xst.dao.loc.IRetailLocation;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class CustomerAccountModel extends CustomerAccountBaseModel implements ICustomerAccount {
/*      */   private static final long serialVersionUID = -790272945L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private HistoricalList<ICustomerAccountJournal> _journals;
/*      */   private transient HistoricalList<ICustomerAccountJournal> _journalsSavepoint;
/*      */   private IPaymentSchedule _paymentSchedule;
/*      */   
/*      */   public String toString() {
/*   36 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient IPaymentSchedule _paymentScheduleSavepoint; private IRetailLocation _retailLocation; private transient IRetailLocation _retailLocationSavepoint; private HistoricalList<ICustomerAccountNote> _custAccountNotes; private transient HistoricalList<ICustomerAccountNote> _custAccountNotesSavepoint; private HistoricalList<ICustomerAccountProperty> _properties; private transient HistoricalList<ICustomerAccountProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   41 */     setDAO((IDataAccessObject)new CustomerAccountDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CustomerAccountDAO getDAO_() {
/*   49 */     return (CustomerAccountDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   57 */     if (getDAO_().getOrganizationId() != null) {
/*   58 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   61 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   70 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   71 */       this._events != null && 
/*   72 */       postEventsForChanges()) {
/*   73 */       this._events.post(ICustomerAccount.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   80 */     boolean ev_postable = false;
/*      */     
/*   82 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   83 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   84 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   85 */       ev_postable = true;
/*   86 */       if (this._journals != null) {
/*      */         
/*   88 */         Iterator<CustomerAccountJournalModel> it = this._journals.iterator();
/*   89 */         while (it.hasNext())
/*      */         {
/*   91 */           ((CustomerAccountJournalModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   94 */       if (this._custAccountNotes != null) {
/*      */         
/*   96 */         Iterator<CustomerAccountNoteModel> it = this._custAccountNotes.iterator();
/*   97 */         while (it.hasNext())
/*      */         {
/*   99 */           ((CustomerAccountNoteModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  102 */       if (this._properties != null) {
/*      */         
/*  104 */         Iterator<CustomerAccountPropertyModel> it = this._properties.iterator();
/*  105 */         while (it.hasNext())
/*      */         {
/*  107 */           ((CustomerAccountPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  110 */       if (this._paymentSchedule != null)
/*      */       {
/*      */         
/*  113 */         ((PaymentScheduleModel)this._paymentSchedule).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*      */     } 
/*      */     
/*  117 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustAccountId() {
/*  125 */     return getDAO_().getCustAccountId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAccountId(String argCustAccountId) {
/*  133 */     if (setCustAccountId_noev(argCustAccountId) && 
/*  134 */       this._events != null && 
/*  135 */       postEventsForChanges()) {
/*  136 */       this._events.post(ICustomerAccount.SET_CUSTACCOUNTID, argCustAccountId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAccountId_noev(String argCustAccountId) {
/*  143 */     boolean ev_postable = false;
/*      */     
/*  145 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/*  146 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/*  147 */       getDAO_().setCustAccountId(argCustAccountId);
/*  148 */       ev_postable = true;
/*  149 */       if (this._journals != null) {
/*      */         
/*  151 */         Iterator<CustomerAccountJournalModel> it = this._journals.iterator();
/*  152 */         while (it.hasNext())
/*      */         {
/*  154 */           ((CustomerAccountJournalModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*      */         }
/*      */       } 
/*  157 */       if (this._custAccountNotes != null) {
/*      */         
/*  159 */         Iterator<CustomerAccountNoteModel> it = this._custAccountNotes.iterator();
/*  160 */         while (it.hasNext())
/*      */         {
/*  162 */           ((CustomerAccountNoteModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*      */         }
/*      */       } 
/*  165 */       if (this._properties != null) {
/*      */         
/*  167 */         Iterator<CustomerAccountPropertyModel> it = this._properties.iterator();
/*  168 */         while (it.hasNext())
/*      */         {
/*  170 */           ((CustomerAccountPropertyModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*      */         }
/*      */       } 
/*  173 */       if (this._paymentSchedule != null)
/*      */       {
/*      */         
/*  176 */         ((PaymentScheduleModel)this._paymentSchedule).setCustAccountId_noev(argCustAccountId);
/*      */       }
/*      */     } 
/*      */     
/*  180 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustAccountCode() {
/*  188 */     return getDAO_().getCustAccountCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAccountCode(String argCustAccountCode) {
/*  196 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/*  197 */       this._events != null && 
/*  198 */       postEventsForChanges()) {
/*  199 */       this._events.post(ICustomerAccount.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/*  206 */     boolean ev_postable = false;
/*      */     
/*  208 */     if ((getDAO_().getCustAccountCode() == null && argCustAccountCode != null) || (
/*  209 */       getDAO_().getCustAccountCode() != null && !getDAO_().getCustAccountCode().equals(argCustAccountCode))) {
/*  210 */       getDAO_().setCustAccountCode(argCustAccountCode);
/*  211 */       ev_postable = true;
/*  212 */       if (this._journals != null) {
/*      */         
/*  214 */         Iterator<CustomerAccountJournalModel> it = this._journals.iterator();
/*  215 */         while (it.hasNext())
/*      */         {
/*  217 */           ((CustomerAccountJournalModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*      */         }
/*      */       } 
/*  220 */       if (this._custAccountNotes != null) {
/*      */         
/*  222 */         Iterator<CustomerAccountNoteModel> it = this._custAccountNotes.iterator();
/*  223 */         while (it.hasNext())
/*      */         {
/*  225 */           ((CustomerAccountNoteModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*      */         }
/*      */       } 
/*  228 */       if (this._properties != null) {
/*      */         
/*  230 */         Iterator<CustomerAccountPropertyModel> it = this._properties.iterator();
/*  231 */         while (it.hasNext())
/*      */         {
/*  233 */           ((CustomerAccountPropertyModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*      */         }
/*      */       } 
/*  236 */       if (this._paymentSchedule != null)
/*      */       {
/*      */         
/*  239 */         ((PaymentScheduleModel)this._paymentSchedule).setCustAccountCode_noev(argCustAccountCode);
/*      */       }
/*      */     } 
/*      */     
/*  243 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getClassName() {
/*  251 */     return getDAO_().getClassName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClassName(String argClassName) {
/*  259 */     if (setClassName_noev(argClassName) && 
/*  260 */       this._events != null && 
/*  261 */       postEventsForChanges()) {
/*  262 */       this._events.post(ICustomerAccount.SET_CLASSNAME, argClassName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setClassName_noev(String argClassName) {
/*  269 */     boolean ev_postable = false;
/*      */     
/*  271 */     if ((getDAO_().getClassName() == null && argClassName != null) || (
/*  272 */       getDAO_().getClassName() != null && !getDAO_().getClassName().equals(argClassName))) {
/*  273 */       getDAO_().setClassName(argClassName);
/*  274 */       ev_postable = true;
/*      */     } 
/*      */     
/*  277 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  285 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  293 */     if (setCreateDate_noev(argCreateDate) && 
/*  294 */       this._events != null && 
/*  295 */       postEventsForChanges()) {
/*  296 */       this._events.post(ICustomerAccount.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  303 */     boolean ev_postable = false;
/*      */     
/*  305 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  306 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  307 */       getDAO_().setCreateDate(argCreateDate);
/*  308 */       ev_postable = true;
/*      */     } 
/*      */     
/*  311 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  319 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  327 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  328 */       this._events != null && 
/*  329 */       postEventsForChanges()) {
/*  330 */       this._events.post(ICustomerAccount.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  337 */     boolean ev_postable = false;
/*      */     
/*  339 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  340 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  341 */       getDAO_().setCreateUserId(argCreateUserId);
/*  342 */       ev_postable = true;
/*      */     } 
/*      */     
/*  345 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  353 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  361 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  362 */       this._events != null && 
/*  363 */       postEventsForChanges()) {
/*  364 */       this._events.post(ICustomerAccount.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  371 */     boolean ev_postable = false;
/*      */     
/*  373 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  374 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  375 */       getDAO_().setUpdateDate(argUpdateDate);
/*  376 */       ev_postable = true;
/*      */     } 
/*      */     
/*  379 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  387 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  395 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  396 */       this._events != null && 
/*  397 */       postEventsForChanges()) {
/*  398 */       this._events.post(ICustomerAccount.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  405 */     boolean ev_postable = false;
/*      */     
/*  407 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  408 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  409 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  410 */       ev_postable = true;
/*      */     } 
/*      */     
/*  413 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAccountBalance() {
/*  421 */     return getDAO_().getAccountBalance();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAccountBalance(BigDecimal argAccountBalance) {
/*  429 */     if (setAccountBalance_noev(argAccountBalance) && 
/*  430 */       this._events != null && 
/*  431 */       postEventsForChanges()) {
/*  432 */       this._events.post(ICustomerAccount.SET_ACCOUNTBALANCE, argAccountBalance);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAccountBalance_noev(BigDecimal argAccountBalance) {
/*  439 */     boolean ev_postable = false;
/*      */     
/*  441 */     if ((getDAO_().getAccountBalance() == null && argAccountBalance != null) || (
/*  442 */       getDAO_().getAccountBalance() != null && !getDAO_().getAccountBalance().equals(argAccountBalance))) {
/*  443 */       getDAO_().setAccountBalance(argAccountBalance);
/*  444 */       ev_postable = true;
/*      */     } 
/*      */     
/*  447 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  455 */     if (getDAO_().getRetailLocationId() != null) {
/*  456 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  459 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  468 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  469 */       this._events != null && 
/*  470 */       postEventsForChanges()) {
/*  471 */       this._events.post(ICustomerAccount.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  478 */     boolean ev_postable = false;
/*      */     
/*  480 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  481 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  482 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  483 */       ev_postable = true;
/*      */     } 
/*      */     
/*  486 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCustIdentityReq() {
/*  494 */     if (getDAO_().getCustIdentityReq() != null) {
/*  495 */       return getDAO_().getCustIdentityReq().booleanValue();
/*      */     }
/*      */     
/*  498 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustIdentityReq(boolean argCustIdentityReq) {
/*  507 */     if (setCustIdentityReq_noev(argCustIdentityReq) && 
/*  508 */       this._events != null && 
/*  509 */       postEventsForChanges()) {
/*  510 */       this._events.post(ICustomerAccount.SET_CUSTIDENTITYREQ, Boolean.valueOf(argCustIdentityReq));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustIdentityReq_noev(boolean argCustIdentityReq) {
/*  517 */     boolean ev_postable = false;
/*      */     
/*  519 */     if ((getDAO_().getCustIdentityReq() == null && Boolean.valueOf(argCustIdentityReq) != null) || (
/*  520 */       getDAO_().getCustIdentityReq() != null && !getDAO_().getCustIdentityReq().equals(Boolean.valueOf(argCustIdentityReq)))) {
/*  521 */       getDAO_().setCustIdentityReq(Boolean.valueOf(argCustIdentityReq));
/*  522 */       ev_postable = true;
/*      */     } 
/*      */     
/*  525 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustIdentityTypeCode() {
/*  533 */     return getDAO_().getCustIdentityTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustIdentityTypeCode(String argCustIdentityTypeCode) {
/*  541 */     if (setCustIdentityTypeCode_noev(argCustIdentityTypeCode) && 
/*  542 */       this._events != null && 
/*  543 */       postEventsForChanges()) {
/*  544 */       this._events.post(ICustomerAccount.SET_CUSTIDENTITYTYPECODE, argCustIdentityTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustIdentityTypeCode_noev(String argCustIdentityTypeCode) {
/*  551 */     boolean ev_postable = false;
/*      */     
/*  553 */     if ((getDAO_().getCustIdentityTypeCode() == null && argCustIdentityTypeCode != null) || (
/*  554 */       getDAO_().getCustIdentityTypeCode() != null && !getDAO_().getCustIdentityTypeCode().equals(argCustIdentityTypeCode))) {
/*  555 */       getDAO_().setCustIdentityTypeCode(argCustIdentityTypeCode);
/*  556 */       ev_postable = true;
/*      */     } 
/*      */     
/*  559 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustAccountStateCode() {
/*  567 */     return getDAO_().getCustAccountStateCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAccountStateCode(String argCustAccountStateCode) {
/*  575 */     if (setCustAccountStateCode_noev(argCustAccountStateCode) && 
/*  576 */       this._events != null && 
/*  577 */       postEventsForChanges()) {
/*  578 */       this._events.post(ICustomerAccount.SET_CUSTACCOUNTSTATECODE, argCustAccountStateCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAccountStateCode_noev(String argCustAccountStateCode) {
/*  585 */     boolean ev_postable = false;
/*      */     
/*  587 */     if ((getDAO_().getCustAccountStateCode() == null && argCustAccountStateCode != null) || (
/*  588 */       getDAO_().getCustAccountStateCode() != null && !getDAO_().getCustAccountStateCode().equals(argCustAccountStateCode))) {
/*  589 */       getDAO_().setCustAccountStateCode(argCustAccountStateCode);
/*  590 */       ev_postable = true;
/*      */     } 
/*      */     
/*  593 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getAccountSetupDate() {
/*  601 */     return getDAO_().getAccountSetupDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAccountSetupDate(Date argAccountSetupDate) {
/*  609 */     if (setAccountSetupDate_noev(argAccountSetupDate) && 
/*  610 */       this._events != null && 
/*  611 */       postEventsForChanges()) {
/*  612 */       this._events.post(ICustomerAccount.SET_ACCOUNTSETUPDATE, argAccountSetupDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAccountSetupDate_noev(Date argAccountSetupDate) {
/*  619 */     boolean ev_postable = false;
/*      */     
/*  621 */     if ((getDAO_().getAccountSetupDate() == null && argAccountSetupDate != null) || (
/*  622 */       getDAO_().getAccountSetupDate() != null && !getDAO_().getAccountSetupDate().equals(argAccountSetupDate))) {
/*  623 */       getDAO_().setAccountSetupDate(argAccountSetupDate);
/*  624 */       ev_postable = true;
/*      */     } 
/*      */     
/*  627 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getLastActivityDate() {
/*  635 */     return getDAO_().getLastActivityDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLastActivityDate(Date argLastActivityDate) {
/*  643 */     if (setLastActivityDate_noev(argLastActivityDate) && 
/*  644 */       this._events != null && 
/*  645 */       postEventsForChanges()) {
/*  646 */       this._events.post(ICustomerAccount.SET_LASTACTIVITYDATE, argLastActivityDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLastActivityDate_noev(Date argLastActivityDate) {
/*  653 */     boolean ev_postable = false;
/*      */     
/*  655 */     if ((getDAO_().getLastActivityDate() == null && argLastActivityDate != null) || (
/*  656 */       getDAO_().getLastActivityDate() != null && !getDAO_().getLastActivityDate().equals(argLastActivityDate))) {
/*  657 */       getDAO_().setLastActivityDate(argLastActivityDate);
/*  658 */       ev_postable = true;
/*      */     } 
/*      */     
/*  661 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getPartyId() {
/*  669 */     if (getDAO_().getPartyId() != null) {
/*  670 */       return getDAO_().getPartyId().longValue();
/*      */     }
/*      */     
/*  673 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPartyId(long argPartyId) {
/*  682 */     if (setPartyId_noev(argPartyId) && 
/*  683 */       this._events != null && 
/*  684 */       postEventsForChanges()) {
/*  685 */       this._events.post(ICustomerAccount.SET_PARTYID, Long.valueOf(argPartyId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPartyId_noev(long argPartyId) {
/*  692 */     boolean ev_postable = false;
/*      */     
/*  694 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/*  695 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/*  696 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/*  697 */       ev_postable = true;
/*      */     } 
/*      */     
/*  700 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAccountPurchaseOrderNumber() {
/*  708 */     return getDAO_().getAccountPurchaseOrderNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAccountPurchaseOrderNumber(String argAccountPurchaseOrderNumber) {
/*  716 */     if (setAccountPurchaseOrderNumber_noev(argAccountPurchaseOrderNumber) && 
/*  717 */       this._events != null && 
/*  718 */       postEventsForChanges()) {
/*  719 */       this._events.post(ICustomerAccount.SET_ACCOUNTPURCHASEORDERNUMBER, argAccountPurchaseOrderNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAccountPurchaseOrderNumber_noev(String argAccountPurchaseOrderNumber) {
/*  726 */     boolean ev_postable = false;
/*      */     
/*  728 */     if ((getDAO_().getAccountPurchaseOrderNumber() == null && argAccountPurchaseOrderNumber != null) || (
/*  729 */       getDAO_().getAccountPurchaseOrderNumber() != null && !getDAO_().getAccountPurchaseOrderNumber().equals(argAccountPurchaseOrderNumber))) {
/*  730 */       getDAO_().setAccountPurchaseOrderNumber(argAccountPurchaseOrderNumber);
/*  731 */       ev_postable = true;
/*      */     } 
/*      */     
/*  734 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ICustomerAccountProperty newProperty(String argPropertyName) {
/*  738 */     CustomerAccountPropertyId id = new CustomerAccountPropertyId();
/*      */     
/*  740 */     id.setCustAccountId(getCustAccountId());
/*  741 */     id.setCustAccountCode(getCustAccountCode());
/*  742 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  744 */     ICustomerAccountProperty prop = (ICustomerAccountProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICustomerAccountProperty.class);
/*  745 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Journals")
/*      */   public List<ICustomerAccountJournal> getJournals() {
/*  766 */     if (this._journals == null) {
/*  767 */       this._journals = new HistoricalList(null);
/*      */     }
/*  769 */     return (List<ICustomerAccountJournal>)this._journals;
/*      */   }
/*      */   
/*      */   public void setJournals(List<ICustomerAccountJournal> argJournals) {
/*  773 */     if (this._journals == null) {
/*  774 */       this._journals = new HistoricalList(argJournals);
/*      */     } else {
/*  776 */       this._journals.setCurrentList(argJournals);
/*      */     } 
/*      */     
/*  779 */     for (ICustomerAccountJournal child : this._journals) {
/*  780 */       child.setParentCustomerAccount(this);
/*      */     }
/*      */ 
/*      */     
/*  784 */     for (ICustomerAccountJournal child : this._journals) {
/*  785 */       CustomerAccountJournalModel model = (CustomerAccountJournalModel)child;
/*  786 */       model.setOrganizationId_noev(getOrganizationId());
/*  787 */       model.setCustAccountId_noev(getCustAccountId());
/*  788 */       model.setCustAccountCode_noev(getCustAccountCode());
/*  789 */       if (child instanceof IDataModelImpl) {
/*  790 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  791 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  792 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  793 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  796 */       if (postEventsForChanges()) {
/*  797 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addCustomerAccountJournal(ICustomerAccountJournal argCustomerAccountJournal) {
/*  804 */     argCustomerAccountJournal.setParentCustomerAccount(this);
/*  805 */     if (this._journals == null) {
/*  806 */       this._journals = new HistoricalList(null);
/*      */     }
/*  808 */     argCustomerAccountJournal.setOrganizationId(getOrganizationId());
/*  809 */     argCustomerAccountJournal.setCustAccountId(getCustAccountId());
/*  810 */     argCustomerAccountJournal.setCustAccountCode(getCustAccountCode());
/*  811 */     if (argCustomerAccountJournal instanceof IDataModelImpl) {
/*  812 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerAccountJournal).getDAO();
/*  813 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  814 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  815 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  820 */     if (postEventsForChanges()) {
/*  821 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAccountJournal));
/*      */     }
/*      */     
/*  824 */     this._journals.add(argCustomerAccountJournal);
/*  825 */     if (postEventsForChanges()) {
/*  826 */       this._events.post(ICustomerAccount.ADD_JOURNALS, argCustomerAccountJournal);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeCustomerAccountJournal(ICustomerAccountJournal argCustomerAccountJournal) {
/*  831 */     if (this._journals != null) {
/*      */       
/*  833 */       if (postEventsForChanges()) {
/*  834 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAccountJournal));
/*      */       }
/*  836 */       this._journals.remove(argCustomerAccountJournal);
/*      */       
/*  838 */       argCustomerAccountJournal.setParentCustomerAccount(null);
/*  839 */       if (postEventsForChanges()) {
/*  840 */         this._events.post(ICustomerAccount.REMOVE_JOURNALS, argCustomerAccountJournal);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "PaymentSchedule")
/*      */   public IPaymentSchedule getPaymentSchedule() {
/*  847 */     return this._paymentSchedule;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPaymentSchedule(IPaymentSchedule argPaymentSchedule) {
/*  852 */     if (argPaymentSchedule == null) {
/*      */       
/*  854 */       if (this._paymentSchedule != null) {
/*  855 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/*  857 */       if (this._paymentSchedule != null) {
/*      */         
/*  859 */         if (postEventsForChanges()) {
/*  860 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._paymentSchedule));
/*      */         }
/*  862 */         addDeletedObject((IDataModel)this._paymentSchedule);
/*      */       } 
/*      */     } else {
/*      */       
/*  866 */       argPaymentSchedule.setOrganizationId(getOrganizationId());
/*  867 */       argPaymentSchedule.setCustAccountId(getCustAccountId());
/*  868 */       argPaymentSchedule.setCustAccountCode(getCustAccountCode());
/*      */ 
/*      */       
/*  871 */       if (postEventsForChanges()) {
/*  872 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPaymentSchedule));
/*      */       }
/*      */     } 
/*      */     
/*  876 */     this._paymentSchedule = argPaymentSchedule;
/*  877 */     if (postEventsForChanges()) {
/*  878 */       this._events.post(ICustomerAccount.SET_PAYMENTSCHEDULE, argPaymentSchedule);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "RetailLocation")
/*      */   public IRetailLocation getRetailLocation() {
/*  884 */     return this._retailLocation;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRetailLocation(IRetailLocation argRetailLocation) {
/*  889 */     if (argRetailLocation == null) {
/*      */       
/*  891 */       getDAO_().setRetailLocationId(null);
/*  892 */       if (this._retailLocation != null)
/*      */       {
/*  894 */         if (postEventsForChanges()) {
/*  895 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._retailLocation));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  900 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocation.getRetailLocationId()));
/*      */       
/*  902 */       if (postEventsForChanges()) {
/*  903 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailLocation));
/*      */       }
/*      */     } 
/*      */     
/*  907 */     this._retailLocation = argRetailLocation;
/*  908 */     if (postEventsForChanges()) {
/*  909 */       this._events.post(ICustomerAccount.SET_RETAILLOCATION, argRetailLocation);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "CustAccountNotes")
/*      */   public List<ICustomerAccountNote> getCustAccountNotes() {
/*  915 */     if (this._custAccountNotes == null) {
/*  916 */       this._custAccountNotes = new HistoricalList(null);
/*      */     }
/*  918 */     return (List<ICustomerAccountNote>)this._custAccountNotes;
/*      */   }
/*      */   
/*      */   public void setCustAccountNotes(List<ICustomerAccountNote> argCustAccountNotes) {
/*  922 */     if (this._custAccountNotes == null) {
/*  923 */       this._custAccountNotes = new HistoricalList(argCustAccountNotes);
/*      */     } else {
/*  925 */       this._custAccountNotes.setCurrentList(argCustAccountNotes);
/*      */     } 
/*      */     
/*  928 */     for (ICustomerAccountNote child : this._custAccountNotes) {
/*  929 */       CustomerAccountNoteModel model = (CustomerAccountNoteModel)child;
/*  930 */       model.setOrganizationId_noev(getOrganizationId());
/*  931 */       model.setCustAccountId_noev(getCustAccountId());
/*  932 */       model.setCustAccountCode_noev(getCustAccountCode());
/*  933 */       if (child instanceof IDataModelImpl) {
/*  934 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  935 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  936 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  937 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  940 */       if (postEventsForChanges()) {
/*  941 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addCustomerAccountNote(ICustomerAccountNote argCustomerAccountNote) {
/*  947 */     super.addCustomerAccountNote(argCustomerAccountNote);
/*      */     
/*  949 */     if (this._custAccountNotes == null) {
/*  950 */       this._custAccountNotes = new HistoricalList(null);
/*      */     }
/*  952 */     argCustomerAccountNote.setOrganizationId(getOrganizationId());
/*  953 */     argCustomerAccountNote.setCustAccountId(getCustAccountId());
/*  954 */     argCustomerAccountNote.setCustAccountCode(getCustAccountCode());
/*  955 */     if (argCustomerAccountNote instanceof IDataModelImpl) {
/*  956 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerAccountNote).getDAO();
/*  957 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  958 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  959 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  964 */     if (postEventsForChanges()) {
/*  965 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAccountNote));
/*      */     }
/*      */     
/*  968 */     this._custAccountNotes.add(argCustomerAccountNote);
/*  969 */     if (postEventsForChanges()) {
/*  970 */       this._events.post(ICustomerAccount.ADD_CUSTACCOUNTNOTES, argCustomerAccountNote);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeCustomerAccountNote(ICustomerAccountNote argCustomerAccountNote) {
/*  975 */     if (this._custAccountNotes != null) {
/*      */       
/*  977 */       if (postEventsForChanges()) {
/*  978 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAccountNote));
/*      */       }
/*  980 */       this._custAccountNotes.remove(argCustomerAccountNote);
/*  981 */       if (postEventsForChanges()) {
/*  982 */         this._events.post(ICustomerAccount.REMOVE_CUSTACCOUNTNOTES, argCustomerAccountNote);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ICustomerAccountProperty> getProperties() {
/*  989 */     if (this._properties == null) {
/*  990 */       this._properties = new HistoricalList(null);
/*      */     }
/*  992 */     return (List<ICustomerAccountProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ICustomerAccountProperty> argProperties) {
/*  996 */     if (this._properties == null) {
/*  997 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  999 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1002 */     for (ICustomerAccountProperty child : this._properties) {
/* 1003 */       CustomerAccountPropertyModel model = (CustomerAccountPropertyModel)child;
/* 1004 */       model.setOrganizationId_noev(getOrganizationId());
/* 1005 */       model.setCustAccountId_noev(getCustAccountId());
/* 1006 */       model.setCustAccountCode_noev(getCustAccountCode());
/* 1007 */       if (child instanceof IDataModelImpl) {
/* 1008 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1009 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1010 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1011 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1014 */       if (postEventsForChanges()) {
/* 1015 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addCustomerAccountProperty(ICustomerAccountProperty argCustomerAccountProperty) {
/* 1021 */     if (this._properties == null) {
/* 1022 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1024 */     argCustomerAccountProperty.setOrganizationId(getOrganizationId());
/* 1025 */     argCustomerAccountProperty.setCustAccountId(getCustAccountId());
/* 1026 */     argCustomerAccountProperty.setCustAccountCode(getCustAccountCode());
/* 1027 */     if (argCustomerAccountProperty instanceof IDataModelImpl) {
/* 1028 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerAccountProperty).getDAO();
/* 1029 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1030 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1031 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1036 */     if (postEventsForChanges()) {
/* 1037 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAccountProperty));
/*      */     }
/*      */     
/* 1040 */     this._properties.add(argCustomerAccountProperty);
/* 1041 */     if (postEventsForChanges()) {
/* 1042 */       this._events.post(ICustomerAccount.ADD_PROPERTIES, argCustomerAccountProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeCustomerAccountProperty(ICustomerAccountProperty argCustomerAccountProperty) {
/* 1047 */     if (this._properties != null) {
/*      */       
/* 1049 */       if (postEventsForChanges()) {
/* 1050 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAccountProperty));
/*      */       }
/* 1052 */       this._properties.remove(argCustomerAccountProperty);
/* 1053 */       if (postEventsForChanges()) {
/* 1054 */         this._events.post(ICustomerAccount.REMOVE_PROPERTIES, argCustomerAccountProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1061 */     if ("Journals".equals(argFieldId)) {
/* 1062 */       return getJournals();
/*      */     }
/* 1064 */     if ("PaymentSchedule".equals(argFieldId)) {
/* 1065 */       return getPaymentSchedule();
/*      */     }
/* 1067 */     if ("RetailLocation".equals(argFieldId)) {
/* 1068 */       return getRetailLocation();
/*      */     }
/* 1070 */     if ("CustAccountNotes".equals(argFieldId)) {
/* 1071 */       return getCustAccountNotes();
/*      */     }
/* 1073 */     if ("Properties".equals(argFieldId)) {
/* 1074 */       return getProperties();
/*      */     }
/* 1076 */     if ("CustomerAccountExtension".equals(argFieldId)) {
/* 1077 */       return this._myExtension;
/*      */     }
/*      */     
/* 1080 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1086 */     if ("Journals".equals(argFieldId)) {
/* 1087 */       setJournals(changeToList(argValue, ICustomerAccountJournal.class));
/*      */     }
/* 1089 */     else if ("PaymentSchedule".equals(argFieldId)) {
/* 1090 */       setPaymentSchedule((IPaymentSchedule)argValue);
/*      */     }
/* 1092 */     else if ("RetailLocation".equals(argFieldId)) {
/* 1093 */       setRetailLocation((IRetailLocation)argValue);
/*      */     }
/* 1095 */     else if ("CustAccountNotes".equals(argFieldId)) {
/* 1096 */       setCustAccountNotes(changeToList(argValue, ICustomerAccountNote.class));
/*      */     }
/* 1098 */     else if ("Properties".equals(argFieldId)) {
/* 1099 */       setProperties(changeToList(argValue, ICustomerAccountProperty.class));
/*      */     }
/* 1101 */     else if ("CustomerAccountExtension".equals(argFieldId)) {
/* 1102 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1105 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1111 */     this._persistenceDefaults = argPD;
/* 1112 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1113 */     this._eventManager = argEM;
/* 1114 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1115 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1116 */     if (this._journals != null) {
/* 1117 */       for (ICustomerAccountJournal relationship : this._journals) {
/* 1118 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1121 */     if (this._paymentSchedule != null) {
/* 1122 */       ((IDataModelImpl)this._paymentSchedule).setDependencies(argPD, argEM);
/*      */     }
/* 1124 */     if (this._retailLocation != null) {
/* 1125 */       ((IDataModelImpl)this._retailLocation).setDependencies(argPD, argEM);
/*      */     }
/* 1127 */     if (this._custAccountNotes != null) {
/* 1128 */       for (ICustomerAccountNote relationship : this._custAccountNotes) {
/* 1129 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1132 */     if (this._properties != null) {
/* 1133 */       for (ICustomerAccountProperty relationship : this._properties) {
/* 1134 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getCustomerAccountExt() {
/* 1140 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setCustomerAccountExt(IDataModel argExt) {
/* 1144 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1149 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1153 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1156 */     super.startTransaction();
/*      */     
/* 1158 */     this._journalsSavepoint = this._journals;
/* 1159 */     if (this._journals != null) {
/* 1160 */       this._journalsSavepoint = new HistoricalList((List)this._journals);
/* 1161 */       Iterator<IDataModel> it = this._journals.iterator();
/* 1162 */       while (it.hasNext()) {
/* 1163 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1167 */     this._paymentScheduleSavepoint = this._paymentSchedule;
/* 1168 */     if (this._paymentSchedule != null) {
/* 1169 */       this._paymentSchedule.startTransaction();
/*      */     }
/*      */     
/* 1172 */     this._retailLocationSavepoint = this._retailLocation;
/* 1173 */     if (this._retailLocation != null) {
/* 1174 */       this._retailLocation.startTransaction();
/*      */     }
/*      */     
/* 1177 */     this._custAccountNotesSavepoint = this._custAccountNotes;
/* 1178 */     if (this._custAccountNotes != null) {
/* 1179 */       this._custAccountNotesSavepoint = new HistoricalList((List)this._custAccountNotes);
/* 1180 */       Iterator<IDataModel> it = this._custAccountNotes.iterator();
/* 1181 */       while (it.hasNext()) {
/* 1182 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1186 */     this._propertiesSavepoint = this._properties;
/* 1187 */     if (this._properties != null) {
/* 1188 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1189 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1190 */       while (it.hasNext()) {
/* 1191 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1196 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1201 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1204 */     super.rollbackChanges();
/*      */     
/* 1206 */     this._journals = this._journalsSavepoint;
/* 1207 */     this._journalsSavepoint = null;
/* 1208 */     if (this._journals != null) {
/* 1209 */       Iterator<IDataModel> it = this._journals.iterator();
/* 1210 */       while (it.hasNext()) {
/* 1211 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1215 */     this._paymentSchedule = this._paymentScheduleSavepoint;
/* 1216 */     this._paymentScheduleSavepoint = null;
/* 1217 */     if (this._paymentSchedule != null) {
/* 1218 */       this._paymentSchedule.rollbackChanges();
/*      */     }
/*      */     
/* 1221 */     this._retailLocation = this._retailLocationSavepoint;
/* 1222 */     this._retailLocationSavepoint = null;
/* 1223 */     if (this._retailLocation != null) {
/* 1224 */       this._retailLocation.rollbackChanges();
/*      */     }
/*      */     
/* 1227 */     this._custAccountNotes = this._custAccountNotesSavepoint;
/* 1228 */     this._custAccountNotesSavepoint = null;
/* 1229 */     if (this._custAccountNotes != null) {
/* 1230 */       Iterator<IDataModel> it = this._custAccountNotes.iterator();
/* 1231 */       while (it.hasNext()) {
/* 1232 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1236 */     this._properties = this._propertiesSavepoint;
/* 1237 */     this._propertiesSavepoint = null;
/* 1238 */     if (this._properties != null) {
/* 1239 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1240 */       while (it.hasNext()) {
/* 1241 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1249 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1252 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1255 */     super.commitTransaction();
/*      */     
/* 1257 */     this._journalsSavepoint = this._journals;
/* 1258 */     if (this._journals != null) {
/* 1259 */       Iterator<IDataModel> it = this._journals.iterator();
/* 1260 */       while (it.hasNext()) {
/* 1261 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1263 */       this._journals = new HistoricalList((List)this._journals);
/*      */     } 
/*      */     
/* 1266 */     this._paymentScheduleSavepoint = this._paymentSchedule;
/* 1267 */     if (this._paymentSchedule != null) {
/* 1268 */       this._paymentSchedule.commitTransaction();
/*      */     }
/*      */     
/* 1271 */     this._retailLocationSavepoint = this._retailLocation;
/* 1272 */     if (this._retailLocation != null) {
/* 1273 */       this._retailLocation.commitTransaction();
/*      */     }
/*      */     
/* 1276 */     this._custAccountNotesSavepoint = this._custAccountNotes;
/* 1277 */     if (this._custAccountNotes != null) {
/* 1278 */       Iterator<IDataModel> it = this._custAccountNotes.iterator();
/* 1279 */       while (it.hasNext()) {
/* 1280 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1282 */       this._custAccountNotes = new HistoricalList((List)this._custAccountNotes);
/*      */     } 
/*      */     
/* 1285 */     this._propertiesSavepoint = this._properties;
/* 1286 */     if (this._properties != null) {
/* 1287 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1288 */       while (it.hasNext()) {
/* 1289 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1291 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */     
/* 1294 */     getDAO_().setInitAccountBalance(getAccountBalance());
/*      */     
/* 1296 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */