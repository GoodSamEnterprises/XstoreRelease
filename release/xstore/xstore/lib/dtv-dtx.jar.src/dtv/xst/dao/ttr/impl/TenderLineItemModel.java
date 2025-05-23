/*      */ package dtv.xst.dao.ttr.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.ObjectManager;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.i18n.FormattableFactory;
/*      */ import dtv.i18n.OutputContextType;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.Money;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.tnd.ITender;
/*      */ import dtv.xst.dao.tnd.TenderId;
/*      */ import dtv.xst.dao.tnd.TenderStatus;
/*      */ import dtv.xst.dao.ttr.IIdentityVerification;
/*      */ import dtv.xst.dao.ttr.ITenderLineItem;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Currency;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class TenderLineItemModel extends RetailTransactionLineItemModel implements ITenderLineItem {
/*      */   private static final long serialVersionUID = 1615107131L;
/*      */   
/*      */   public void initDAO() {
/*   32 */     setDAO((IDataAccessObject)new TenderLineItemDAO());
/*      */   }
/*      */   private transient boolean _alreadyInStart = false; private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private HistoricalList<IIdentityVerification> _identityVerifications;
/*      */   private transient HistoricalList<IIdentityVerification> _identityVerificationsSavepoint;
/*      */   
/*      */   private TenderLineItemDAO getDAO_() {
/*   40 */     return (TenderLineItemDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   48 */     if (getDAO_().getOrganizationId() != null) {
/*   49 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   52 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   61 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   62 */       this._events != null && 
/*   63 */       postEventsForChanges()) {
/*   64 */       this._events.post(ITenderLineItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   71 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*   74 */     if (super.setOrganizationId_noev(argOrganizationId) && 
/*   75 */       this._identityVerifications != null) {
/*      */       
/*   77 */       Iterator<IdentityVerificationModel> it = this._identityVerifications.iterator();
/*   78 */       while (it.hasNext())
/*      */       {
/*   80 */         ((IdentityVerificationModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*   85 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*   93 */     if (getDAO_().getRetailLocationId() != null) {
/*   94 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*   97 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  106 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  107 */       this._events != null && 
/*  108 */       postEventsForChanges()) {
/*  109 */       this._events.post(ITenderLineItem.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  116 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  119 */     if (super.setRetailLocationId_noev(argRetailLocationId) && 
/*  120 */       this._identityVerifications != null) {
/*      */       
/*  122 */       Iterator<IdentityVerificationModel> it = this._identityVerifications.iterator();
/*  123 */       while (it.hasNext())
/*      */       {
/*  125 */         ((IdentityVerificationModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  130 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  138 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  146 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  147 */       this._events != null && 
/*  148 */       postEventsForChanges()) {
/*  149 */       this._events.post(ITenderLineItem.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  156 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  159 */     if (super.setBusinessDate_noev(argBusinessDate) && 
/*  160 */       this._identityVerifications != null) {
/*      */       
/*  162 */       Iterator<IdentityVerificationModel> it = this._identityVerifications.iterator();
/*  163 */       while (it.hasNext())
/*      */       {
/*  165 */         ((IdentityVerificationModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  170 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  178 */     if (getDAO_().getWorkstationId() != null) {
/*  179 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  182 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  191 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  192 */       this._events != null && 
/*  193 */       postEventsForChanges()) {
/*  194 */       this._events.post(ITenderLineItem.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  201 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  204 */     if (super.setWorkstationId_noev(argWorkstationId) && 
/*  205 */       this._identityVerifications != null) {
/*      */       
/*  207 */       Iterator<IdentityVerificationModel> it = this._identityVerifications.iterator();
/*  208 */       while (it.hasNext())
/*      */       {
/*  210 */         ((IdentityVerificationModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  215 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  223 */     if (getDAO_().getTransactionSequence() != null) {
/*  224 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  227 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  236 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  237 */       this._events != null && 
/*  238 */       postEventsForChanges()) {
/*  239 */       this._events.post(ITenderLineItem.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  246 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  249 */     if (super.setTransactionSequence_noev(argTransactionSequence) && 
/*  250 */       this._identityVerifications != null) {
/*      */       
/*  252 */       Iterator<IdentityVerificationModel> it = this._identityVerifications.iterator();
/*  253 */       while (it.hasNext())
/*      */       {
/*  255 */         ((IdentityVerificationModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  260 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRetailTransactionLineItemSequence() {
/*  268 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/*  269 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  272 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/*  281 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/*  282 */       this._events != null && 
/*  283 */       postEventsForChanges()) {
/*  284 */       this._events.post(ITenderLineItem.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/*  291 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  294 */     if (super.setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/*  295 */       this._identityVerifications != null) {
/*      */       
/*  297 */       Iterator<IdentityVerificationModel> it = this._identityVerifications.iterator();
/*  298 */       while (it.hasNext())
/*      */       {
/*  300 */         ((IdentityVerificationModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  305 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  313 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  321 */     if (setCreateDate_noev(argCreateDate) && 
/*  322 */       this._events != null && 
/*  323 */       postEventsForChanges()) {
/*  324 */       this._events.post(ITenderLineItem.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  331 */     boolean ev_postable = false;
/*      */     
/*  333 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  334 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  335 */       getDAO_().setCreateDate(argCreateDate);
/*  336 */       ev_postable = true;
/*      */     } 
/*      */     
/*  339 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  347 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  355 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  356 */       this._events != null && 
/*  357 */       postEventsForChanges()) {
/*  358 */       this._events.post(ITenderLineItem.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  365 */     boolean ev_postable = false;
/*      */     
/*  367 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  368 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  369 */       getDAO_().setCreateUserId(argCreateUserId);
/*  370 */       ev_postable = true;
/*      */     } 
/*      */     
/*  373 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  381 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  389 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  390 */       this._events != null && 
/*  391 */       postEventsForChanges()) {
/*  392 */       this._events.post(ITenderLineItem.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  399 */     boolean ev_postable = false;
/*      */     
/*  401 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  402 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  403 */       getDAO_().setUpdateDate(argUpdateDate);
/*  404 */       ev_postable = true;
/*      */     } 
/*      */     
/*  407 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  415 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  423 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  424 */       this._events != null && 
/*  425 */       postEventsForChanges()) {
/*  426 */       this._events.post(ITenderLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  433 */     boolean ev_postable = false;
/*      */     
/*  435 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  436 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  437 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  438 */       ev_postable = true;
/*      */     } 
/*      */     
/*  441 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAmount() {
/*  449 */     return getDAO_().getAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAmount(BigDecimal argAmount) {
/*  457 */     if (setAmount_noev(argAmount) && 
/*  458 */       this._events != null && 
/*  459 */       postEventsForChanges()) {
/*  460 */       this._events.post(ITenderLineItem.SET_AMOUNT, argAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAmount_noev(BigDecimal argAmount) {
/*  467 */     boolean ev_postable = false;
/*      */     
/*  469 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/*  470 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/*  471 */       getDAO_().setAmount(argAmount);
/*  472 */       ev_postable = true;
/*      */     } 
/*      */     
/*  475 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getChange() {
/*  483 */     if (getDAO_().getChange() != null) {
/*  484 */       return getDAO_().getChange().booleanValue();
/*      */     }
/*      */     
/*  487 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChange(boolean argChange) {
/*  496 */     if (setChange_noev(argChange) && 
/*  497 */       this._events != null && 
/*  498 */       postEventsForChanges()) {
/*  499 */       this._events.post(ITenderLineItem.SET_CHANGE, Boolean.valueOf(argChange));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setChange_noev(boolean argChange) {
/*  506 */     boolean ev_postable = false;
/*      */     
/*  508 */     if ((getDAO_().getChange() == null && Boolean.valueOf(argChange) != null) || (
/*  509 */       getDAO_().getChange() != null && !getDAO_().getChange().equals(Boolean.valueOf(argChange)))) {
/*  510 */       getDAO_().setChange(Boolean.valueOf(argChange));
/*  511 */       ev_postable = true;
/*      */     } 
/*      */     
/*  514 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getHostValidation() {
/*  522 */     if (getDAO_().getHostValidation() != null) {
/*  523 */       return getDAO_().getHostValidation().booleanValue();
/*      */     }
/*      */     
/*  526 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHostValidation(boolean argHostValidation) {
/*  535 */     if (setHostValidation_noev(argHostValidation) && 
/*  536 */       this._events != null && 
/*  537 */       postEventsForChanges()) {
/*  538 */       this._events.post(ITenderLineItem.SET_HOSTVALIDATION, Boolean.valueOf(argHostValidation));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setHostValidation_noev(boolean argHostValidation) {
/*  545 */     boolean ev_postable = false;
/*      */     
/*  547 */     if ((getDAO_().getHostValidation() == null && Boolean.valueOf(argHostValidation) != null) || (
/*  548 */       getDAO_().getHostValidation() != null && !getDAO_().getHostValidation().equals(Boolean.valueOf(argHostValidation)))) {
/*  549 */       getDAO_().setHostValidation(Boolean.valueOf(argHostValidation));
/*  550 */       ev_postable = true;
/*      */     } 
/*      */     
/*  553 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSerialNumber() {
/*  561 */     return getDAO_().getSerialNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSerialNumber(String argSerialNumber) {
/*  569 */     if (setSerialNumber_noev(argSerialNumber) && 
/*  570 */       this._events != null && 
/*  571 */       postEventsForChanges()) {
/*  572 */       this._events.post(ITenderLineItem.SET_SERIALNUMBER, argSerialNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSerialNumber_noev(String argSerialNumber) {
/*  579 */     boolean ev_postable = false;
/*      */     
/*  581 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/*  582 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/*  583 */       getDAO_().setSerialNumber(argSerialNumber);
/*  584 */       ev_postable = true;
/*      */     } 
/*      */     
/*  587 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTenderId() {
/*  595 */     return getDAO_().getTenderId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTenderId(String argTenderId) {
/*  603 */     if (setTenderId_noev(argTenderId) && 
/*  604 */       this._events != null && 
/*  605 */       postEventsForChanges()) {
/*  606 */       this._events.post(ITenderLineItem.SET_TENDERID, argTenderId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTenderId_noev(String argTenderId) {
/*  613 */     boolean ev_postable = false;
/*      */     
/*  615 */     if ((getDAO_().getTenderId() == null && argTenderId != null) || (
/*  616 */       getDAO_().getTenderId() != null && !getDAO_().getTenderId().equals(argTenderId))) {
/*  617 */       getDAO_().setTenderId(argTenderId);
/*  618 */       ev_postable = true;
/*      */     } 
/*      */     
/*  621 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTenderStatusCode() {
/*  629 */     return getDAO_().getTenderStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTenderStatusCode(String argTenderStatusCode) {
/*  637 */     if (setTenderStatusCode_noev(argTenderStatusCode) && 
/*  638 */       this._events != null && 
/*  639 */       postEventsForChanges()) {
/*  640 */       this._events.post(ITenderLineItem.SET_TENDERSTATUSCODE, argTenderStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTenderStatusCode_noev(String argTenderStatusCode) {
/*  647 */     boolean ev_postable = false;
/*      */     
/*  649 */     if ((getDAO_().getTenderStatusCode() == null && argTenderStatusCode != null) || (
/*  650 */       getDAO_().getTenderStatusCode() != null && !getDAO_().getTenderStatusCode().equals(argTenderStatusCode))) {
/*  651 */       getDAO_().setTenderStatusCode(argTenderStatusCode);
/*  652 */       ev_postable = true;
/*      */     } 
/*      */     
/*  655 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getExchangeRate() {
/*  663 */     return getDAO_().getExchangeRate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExchangeRate(BigDecimal argExchangeRate) {
/*  671 */     if (setExchangeRate_noev(argExchangeRate) && 
/*  672 */       this._events != null && 
/*  673 */       postEventsForChanges()) {
/*  674 */       this._events.post(ITenderLineItem.SET_EXCHANGERATE, argExchangeRate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExchangeRate_noev(BigDecimal argExchangeRate) {
/*  681 */     boolean ev_postable = false;
/*      */     
/*  683 */     if ((getDAO_().getExchangeRate() == null && argExchangeRate != null) || (
/*  684 */       getDAO_().getExchangeRate() != null && !getDAO_().getExchangeRate().equals(argExchangeRate))) {
/*  685 */       getDAO_().setExchangeRate(argExchangeRate);
/*  686 */       ev_postable = true;
/*      */     } 
/*      */     
/*  689 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getForeignAmount() {
/*  697 */     return getDAO_().getForeignAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setForeignAmount(BigDecimal argForeignAmount) {
/*  705 */     if (setForeignAmount_noev(argForeignAmount) && 
/*  706 */       this._events != null && 
/*  707 */       postEventsForChanges()) {
/*  708 */       this._events.post(ITenderLineItem.SET_FOREIGNAMOUNT, argForeignAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setForeignAmount_noev(BigDecimal argForeignAmount) {
/*  715 */     boolean ev_postable = false;
/*      */     
/*  717 */     if ((getDAO_().getForeignAmount() == null && argForeignAmount != null) || (
/*  718 */       getDAO_().getForeignAmount() != null && !getDAO_().getForeignAmount().equals(argForeignAmount))) {
/*  719 */       getDAO_().setForeignAmount(argForeignAmount);
/*  720 */       ev_postable = true;
/*      */     } 
/*      */     
/*  723 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "IdentityVerifications")
/*      */   public List<IIdentityVerification> getIdentityVerifications() {
/*  732 */     if (this._identityVerifications == null) {
/*  733 */       this._identityVerifications = new HistoricalList(null);
/*      */     }
/*  735 */     return (List<IIdentityVerification>)this._identityVerifications;
/*      */   }
/*      */   
/*      */   public void setIdentityVerifications(List<IIdentityVerification> argIdentityVerifications) {
/*  739 */     if (this._identityVerifications == null) {
/*  740 */       this._identityVerifications = new HistoricalList(argIdentityVerifications);
/*      */     } else {
/*  742 */       this._identityVerifications.setCurrentList(argIdentityVerifications);
/*      */     } 
/*      */     
/*  745 */     for (IIdentityVerification child : this._identityVerifications) {
/*  746 */       child.setParentLine(this);
/*      */     }
/*      */     
/*  749 */     for (IIdentityVerification child : this._identityVerifications) {
/*  750 */       IdentityVerificationModel model = (IdentityVerificationModel)child;
/*  751 */       model.setBusinessDate_noev(getBusinessDate());
/*  752 */       model.setOrganizationId_noev(getOrganizationId());
/*  753 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  754 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/*  755 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  756 */       model.setWorkstationId_noev(getWorkstationId());
/*  757 */       if (child instanceof IDataModelImpl) {
/*  758 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  759 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  760 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  761 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  764 */       if (postEventsForChanges()) {
/*  765 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addIdentityVerificationImpl(IIdentityVerification argIdentityVerification) {
/*  772 */     argIdentityVerification.setParentLine(this);
/*  773 */     if (this._identityVerifications == null) {
/*  774 */       this._identityVerifications = new HistoricalList(null);
/*      */     }
/*  776 */     argIdentityVerification.setBusinessDate(getBusinessDate());
/*  777 */     argIdentityVerification.setOrganizationId(getOrganizationId());
/*  778 */     argIdentityVerification.setRetailLocationId(getRetailLocationId());
/*  779 */     argIdentityVerification.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/*  780 */     argIdentityVerification.setTransactionSequence(getTransactionSequence());
/*  781 */     argIdentityVerification.setWorkstationId(getWorkstationId());
/*  782 */     if (argIdentityVerification instanceof IDataModelImpl) {
/*  783 */       IDataAccessObject childDao = ((IDataModelImpl)argIdentityVerification).getDAO();
/*  784 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  785 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  786 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  791 */     if (postEventsForChanges()) {
/*  792 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argIdentityVerification));
/*      */     }
/*      */     
/*  795 */     this._identityVerifications.add(argIdentityVerification);
/*  796 */     if (postEventsForChanges()) {
/*  797 */       this._events.post(ITenderLineItem.ADD_IDENTITYVERIFICATIONS, argIdentityVerification);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeIdentityVerification(IIdentityVerification argIdentityVerification) {
/*  802 */     if (this._identityVerifications != null) {
/*      */       
/*  804 */       if (postEventsForChanges()) {
/*  805 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argIdentityVerification));
/*      */       }
/*  807 */       this._identityVerifications.remove(argIdentityVerification);
/*      */       
/*  809 */       argIdentityVerification.setParentLine(null);
/*  810 */       if (postEventsForChanges()) {
/*  811 */         this._events.post(ITenderLineItem.REMOVE_IDENTITYVERIFICATIONS, argIdentityVerification);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  818 */     if ("IdentityVerifications".equals(argFieldId)) {
/*  819 */       return getIdentityVerifications();
/*      */     }
/*  821 */     if ("TenderLineItemExtension".equals(argFieldId)) {
/*  822 */       return this._myExtension;
/*      */     }
/*      */     
/*  825 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  831 */     if ("IdentityVerifications".equals(argFieldId)) {
/*  832 */       setIdentityVerifications(changeToList(argValue, IIdentityVerification.class));
/*      */     }
/*  834 */     else if ("TenderLineItemExtension".equals(argFieldId)) {
/*  835 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  838 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  844 */     super.setDependencies(argPD, argEM);
/*  845 */     if (this._identityVerifications != null) {
/*  846 */       for (IIdentityVerification relationship : this._identityVerifications) {
/*  847 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getTenderLineItemExt() {
/*  853 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setTenderLineItemExt(IDataModel argExt) {
/*  857 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  862 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  866 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  869 */     super.startTransaction();
/*      */     
/*  871 */     this._identityVerificationsSavepoint = this._identityVerifications;
/*  872 */     if (this._identityVerifications != null) {
/*  873 */       this._identityVerificationsSavepoint = new HistoricalList((List)this._identityVerifications);
/*  874 */       Iterator<IDataModel> it = this._identityVerifications.iterator();
/*  875 */       while (it.hasNext()) {
/*  876 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  881 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/*  886 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/*  889 */     super.rollbackChanges();
/*      */     
/*  891 */     this._identityVerifications = this._identityVerificationsSavepoint;
/*  892 */     this._identityVerificationsSavepoint = null;
/*  893 */     if (this._identityVerifications != null) {
/*  894 */       Iterator<IDataModel> it = this._identityVerifications.iterator();
/*  895 */       while (it.hasNext()) {
/*  896 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/*  904 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/*  907 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/*  910 */     super.commitTransaction();
/*      */     
/*  912 */     this._identityVerificationsSavepoint = this._identityVerifications;
/*  913 */     if (this._identityVerifications != null) {
/*  914 */       Iterator<IDataModel> it = this._identityVerifications.iterator();
/*  915 */       while (it.hasNext()) {
/*  916 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/*  918 */       this._identityVerifications = new HistoricalList((List)this._identityVerifications);
/*      */     } 
/*      */ 
/*      */     
/*  922 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/*  927 */     argStream.defaultReadObject();
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
/*  939 */   private transient ITender _tender = null;
/*  940 */   private transient Object _inputEvent = null;
/*  941 */   private transient SerialLockBox _securedInputEvent = null;
/*  942 */   private transient ObjectManager _manager = null;
/*      */   
/*      */   public ITender getTender() {
/*  945 */     if (this._tender == null && getTenderId() != null) {
/*  946 */       if (this._manager == null) {
/*  947 */         this._manager = ObjectManager.getInstance();
/*      */       }
/*  949 */       TenderId id = new TenderId();
/*  950 */       id.setTenderId(getTenderId());
/*      */       
/*  952 */       this._tender = (ITender)this._manager.getManagedObject((IObjectId)id);
/*      */     } 
/*  954 */     return this._tender;
/*      */   }
/*      */   
/*      */   public void setTender(ITender argTender) {
/*  958 */     if (argTender != null) {
/*  959 */       setTenderId(argTender.getTenderId());
/*      */       
/*  961 */       if (this._manager == null) {
/*  962 */         this._manager = ObjectManager.getInstance();
/*      */       }
/*  964 */       this._manager.manageObject((IDataModel)argTender);
/*      */     } else {
/*      */       
/*  967 */       setTenderId((String)null);
/*      */     } 
/*  969 */     this._tender = argTender;
/*      */   }
/*      */   
/*      */   public Money getForeignMoney() {
/*  973 */     ITender tender = getTender();
/*  974 */     Currency currency = null;
/*      */     
/*  976 */     if (tender != null) {
/*  977 */       String currencyId = tender.getCurrencyId();
/*      */       try {
/*  979 */         currency = Currency.getInstance(currencyId);
/*      */       }
/*  981 */       catch (Exception ex) {
/*  982 */         _logger.error("CAUGHT EXCEPTION", ex);
/*      */       } 
/*      */     } 
/*  985 */     return new Money(getForeignAmount(), currency);
/*      */   }
/*      */   
/*      */   public void setInputEvent(Object argNewValue) {
/*  989 */     this._inputEvent = argNewValue;
/*      */   }
/*      */   
/*      */   public void setSecuredInputEvent(Object argNewValue) {
/*  993 */     if (argNewValue instanceof Serializable) {
/*      */       try {
/*  995 */         this._securedInputEvent = DtvEncrypter.getInstance("ccenc").getLockBox((Serializable)argNewValue);
/*      */       }
/*  997 */       catch (Exception e) {
/*  998 */         _logger.warn("Unable to encrypt secured input event.", e);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public Object getInputEvent() {
/* 1004 */     if (this._inputEvent == null && this._securedInputEvent != null) {
/*      */       try {
/* 1006 */         return DtvDecrypter.getInstance("ccenc").getLockBoxContents(this._securedInputEvent);
/*      */       }
/* 1008 */       catch (Exception e) {
/* 1009 */         _logger.warn("Unable to decrypt secured input event.", e);
/*      */       } 
/*      */     }
/* 1012 */     return this._inputEvent;
/*      */   }
/*      */   
/*      */   public String getTenderStatusCodeTranslated() {
/* 1016 */     if (getTenderStatusCode() != null) {
/* 1017 */       TenderStatus type = TenderStatus.forName(getTenderStatusCode());
/* 1018 */       String transKey = type.getTranslationKey();
/* 1019 */       return FormattableFactory.getInstance().getTranslatable(transKey).toString(OutputContextType.VIEW);
/*      */     } 
/*      */     
/* 1022 */     return null;
/*      */   }
/*      */   
/*      */   public String getLineDescription() {
/* 1026 */     ITender tender = getTender();
/* 1027 */     return (tender == null) ? null : tender.getDescription();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addIdentityVerification(IIdentityVerification argIdentityVerification) {
/* 1034 */     synchronized (this) {
/* 1035 */       argIdentityVerification.setIdentityVerificationSequence(getIdentityVerifications().size() + 1);
/*      */     } 
/* 1037 */     addIdentityVerificationImpl(argIdentityVerification);
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\TenderLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */