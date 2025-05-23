/*      */ package dtv.xst.dao.ttr.impl;
/*      */ 
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.util.DateUtils;
/*      */ import dtv.util.crypto.EncString;
/*      */ import dtv.util.hash.Hasher;
/*      */ import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.List;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class CreditDebitTenderLineItemModel
/*      */   extends TenderLineItemModel
/*      */   implements ICreditDebitTenderLineItem
/*      */ {
/*      */   private static final long serialVersionUID = 1871830094L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private transient EncString encryptedPin;
/*      */   
/*      */   public void initDAO() {
/*   30 */     setDAO((IDataAccessObject)new CreditDebitTenderLineItemDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CreditDebitTenderLineItemDAO getDAO_() {
/*   38 */     return (CreditDebitTenderLineItemDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*   46 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*   54 */     if (setCreateDate_noev(argCreateDate) && 
/*   55 */       this._events != null && 
/*   56 */       postEventsForChanges()) {
/*   57 */       this._events.post(ICreditDebitTenderLineItem.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*   64 */     boolean ev_postable = false;
/*      */     
/*   66 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*   67 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*   68 */       getDAO_().setCreateDate(argCreateDate);
/*   69 */       ev_postable = true;
/*      */     } 
/*      */     
/*   72 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*   80 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*   88 */     if (setCreateUserId_noev(argCreateUserId) && 
/*   89 */       this._events != null && 
/*   90 */       postEventsForChanges()) {
/*   91 */       this._events.post(ICreditDebitTenderLineItem.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*   98 */     boolean ev_postable = false;
/*      */     
/*  100 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  101 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  102 */       getDAO_().setCreateUserId(argCreateUserId);
/*  103 */       ev_postable = true;
/*      */     } 
/*      */     
/*  106 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  114 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  122 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  123 */       this._events != null && 
/*  124 */       postEventsForChanges()) {
/*  125 */       this._events.post(ICreditDebitTenderLineItem.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  132 */     boolean ev_postable = false;
/*      */     
/*  134 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  135 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  136 */       getDAO_().setUpdateDate(argUpdateDate);
/*  137 */       ev_postable = true;
/*      */     } 
/*      */     
/*  140 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  148 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  156 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  157 */       this._events != null && 
/*  158 */       postEventsForChanges()) {
/*  159 */       this._events.post(ICreditDebitTenderLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  166 */     boolean ev_postable = false;
/*      */     
/*  168 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  169 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  170 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  171 */       ev_postable = true;
/*      */     } 
/*      */     
/*  174 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getAccountNumberImpl() {
/*  182 */     return decryptField("ccenc", getDAO_().getAccountNumber());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAccountNumberEncrypted() {
/*  190 */     return getDAO_().getAccountNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setAccountNumberImpl(String argAccountNumber) {
/*  198 */     if (setAccountNumber_noev(argAccountNumber) && 
/*  199 */       this._events != null && 
/*  200 */       postEventsForChanges()) {
/*  201 */       this._events.post(ICreditDebitTenderLineItem.SET_ACCOUNTNUMBER, argAccountNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAccountNumber_noev(String argAccountNumber) {
/*  208 */     boolean ev_postable = false;
/*      */     
/*  210 */     if ((getDAO_().getAccountNumber() == null && argAccountNumber != null) || (
/*  211 */       getDAO_().getAccountNumber() != null && !getDAO_().getAccountNumber().equals(argAccountNumber))) {
/*  212 */       getDAO_().setAccountNumber(encryptField("ccenc", argAccountNumber));
/*  213 */       ev_postable = true;
/*      */     } 
/*      */     
/*  216 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAdjudicationCode() {
/*  224 */     return getDAO_().getAdjudicationCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAdjudicationCode(String argAdjudicationCode) {
/*  232 */     if (setAdjudicationCode_noev(argAdjudicationCode) && 
/*  233 */       this._events != null && 
/*  234 */       postEventsForChanges()) {
/*  235 */       this._events.post(ICreditDebitTenderLineItem.SET_ADJUDICATIONCODE, argAdjudicationCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAdjudicationCode_noev(String argAdjudicationCode) {
/*  242 */     boolean ev_postable = false;
/*      */     
/*  244 */     if ((getDAO_().getAdjudicationCode() == null && argAdjudicationCode != null) || (
/*  245 */       getDAO_().getAdjudicationCode() != null && !getDAO_().getAdjudicationCode().equals(argAdjudicationCode))) {
/*  246 */       getDAO_().setAdjudicationCode(argAdjudicationCode);
/*  247 */       ev_postable = true;
/*      */     } 
/*      */     
/*  250 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAuthorizationMethodCode() {
/*  258 */     return getDAO_().getAuthorizationMethodCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAuthorizationMethodCode(String argAuthorizationMethodCode) {
/*  266 */     if (setAuthorizationMethodCode_noev(argAuthorizationMethodCode) && 
/*  267 */       this._events != null && 
/*  268 */       postEventsForChanges()) {
/*  269 */       this._events.post(ICreditDebitTenderLineItem.SET_AUTHORIZATIONMETHODCODE, argAuthorizationMethodCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAuthorizationMethodCode_noev(String argAuthorizationMethodCode) {
/*  276 */     boolean ev_postable = false;
/*      */     
/*  278 */     if ((getDAO_().getAuthorizationMethodCode() == null && argAuthorizationMethodCode != null) || (
/*  279 */       getDAO_().getAuthorizationMethodCode() != null && !getDAO_().getAuthorizationMethodCode().equals(argAuthorizationMethodCode))) {
/*  280 */       getDAO_().setAuthorizationMethodCode(argAuthorizationMethodCode);
/*  281 */       ev_postable = true;
/*      */     } 
/*      */     
/*  284 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAuthorizationCode() {
/*  292 */     return getDAO_().getAuthorizationCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAuthorizationCode(String argAuthorizationCode) {
/*  300 */     if (setAuthorizationCode_noev(argAuthorizationCode) && 
/*  301 */       this._events != null && 
/*  302 */       postEventsForChanges()) {
/*  303 */       this._events.post(ICreditDebitTenderLineItem.SET_AUTHORIZATIONCODE, argAuthorizationCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAuthorizationCode_noev(String argAuthorizationCode) {
/*  310 */     boolean ev_postable = false;
/*      */     
/*  312 */     if ((getDAO_().getAuthorizationCode() == null && argAuthorizationCode != null) || (
/*  313 */       getDAO_().getAuthorizationCode() != null && !getDAO_().getAuthorizationCode().equals(argAuthorizationCode))) {
/*  314 */       getDAO_().setAuthorizationCode(argAuthorizationCode);
/*  315 */       ev_postable = true;
/*      */     } 
/*      */     
/*  318 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getBankReferenceNumber() {
/*  326 */     return getDAO_().getBankReferenceNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBankReferenceNumber(String argBankReferenceNumber) {
/*  334 */     if (setBankReferenceNumber_noev(argBankReferenceNumber) && 
/*  335 */       this._events != null && 
/*  336 */       postEventsForChanges()) {
/*  337 */       this._events.post(ICreditDebitTenderLineItem.SET_BANKREFERENCENUMBER, argBankReferenceNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBankReferenceNumber_noev(String argBankReferenceNumber) {
/*  344 */     boolean ev_postable = false;
/*      */     
/*  346 */     if ((getDAO_().getBankReferenceNumber() == null && argBankReferenceNumber != null) || (
/*  347 */       getDAO_().getBankReferenceNumber() != null && !getDAO_().getBankReferenceNumber().equals(argBankReferenceNumber))) {
/*  348 */       getDAO_().setBankReferenceNumber(argBankReferenceNumber);
/*  349 */       ev_postable = true;
/*      */     } 
/*      */     
/*  352 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustomerName() {
/*  360 */     return getDAO_().getCustomerName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustomerName(String argCustomerName) {
/*  368 */     if (setCustomerName_noev(argCustomerName) && 
/*  369 */       this._events != null && 
/*  370 */       postEventsForChanges()) {
/*  371 */       this._events.post(ICreditDebitTenderLineItem.SET_CUSTOMERNAME, argCustomerName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustomerName_noev(String argCustomerName) {
/*  378 */     boolean ev_postable = false;
/*      */     
/*  380 */     if ((getDAO_().getCustomerName() == null && argCustomerName != null) || (
/*  381 */       getDAO_().getCustomerName() != null && !getDAO_().getCustomerName().equals(argCustomerName))) {
/*  382 */       getDAO_().setCustomerName(argCustomerName);
/*  383 */       ev_postable = true;
/*      */     } 
/*      */     
/*  386 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEntryMethodCode() {
/*  394 */     return getDAO_().getEntryMethodCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEntryMethodCode(String argEntryMethodCode) {
/*  402 */     if (setEntryMethodCode_noev(argEntryMethodCode) && 
/*  403 */       this._events != null && 
/*  404 */       postEventsForChanges()) {
/*  405 */       this._events.post(ICreditDebitTenderLineItem.SET_ENTRYMETHODCODE, argEntryMethodCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEntryMethodCode_noev(String argEntryMethodCode) {
/*  412 */     boolean ev_postable = false;
/*      */     
/*  414 */     if ((getDAO_().getEntryMethodCode() == null && argEntryMethodCode != null) || (
/*  415 */       getDAO_().getEntryMethodCode() != null && !getDAO_().getEntryMethodCode().equals(argEntryMethodCode))) {
/*  416 */       getDAO_().setEntryMethodCode(argEntryMethodCode);
/*  417 */       ev_postable = true;
/*      */     } 
/*      */     
/*  420 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPs2000() {
/*  428 */     return getDAO_().getPs2000();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPs2000(String argPs2000) {
/*  436 */     if (setPs2000_noev(argPs2000) && 
/*  437 */       this._events != null && 
/*  438 */       postEventsForChanges()) {
/*  439 */       this._events.post(ICreditDebitTenderLineItem.SET_PS2000, argPs2000);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPs2000_noev(String argPs2000) {
/*  446 */     boolean ev_postable = false;
/*      */     
/*  448 */     if ((getDAO_().getPs2000() == null && argPs2000 != null) || (
/*  449 */       getDAO_().getPs2000() != null && !getDAO_().getPs2000().equals(argPs2000))) {
/*  450 */       getDAO_().setPs2000(argPs2000);
/*  451 */       ev_postable = true;
/*      */     } 
/*      */     
/*  454 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getMediaIssuerId() {
/*  462 */     return getDAO_().getMediaIssuerId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMediaIssuerId(String argMediaIssuerId) {
/*  470 */     if (setMediaIssuerId_noev(argMediaIssuerId) && 
/*  471 */       this._events != null && 
/*  472 */       postEventsForChanges()) {
/*  473 */       this._events.post(ICreditDebitTenderLineItem.SET_MEDIAISSUERID, argMediaIssuerId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMediaIssuerId_noev(String argMediaIssuerId) {
/*  480 */     boolean ev_postable = false;
/*      */     
/*  482 */     if ((getDAO_().getMediaIssuerId() == null && argMediaIssuerId != null) || (
/*  483 */       getDAO_().getMediaIssuerId() != null && !getDAO_().getMediaIssuerId().equals(argMediaIssuerId))) {
/*  484 */       getDAO_().setMediaIssuerId(argMediaIssuerId);
/*  485 */       ev_postable = true;
/*      */     } 
/*      */     
/*  488 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPersonalIdReferenceNumber() {
/*  496 */     return getDAO_().getPersonalIdReferenceNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPersonalIdReferenceNumber(String argPersonalIdReferenceNumber) {
/*  504 */     if (setPersonalIdReferenceNumber_noev(argPersonalIdReferenceNumber) && 
/*  505 */       this._events != null && 
/*  506 */       postEventsForChanges()) {
/*  507 */       this._events.post(ICreditDebitTenderLineItem.SET_PERSONALIDREFERENCENUMBER, argPersonalIdReferenceNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPersonalIdReferenceNumber_noev(String argPersonalIdReferenceNumber) {
/*  514 */     boolean ev_postable = false;
/*      */     
/*  516 */     if ((getDAO_().getPersonalIdReferenceNumber() == null && argPersonalIdReferenceNumber != null) || (
/*  517 */       getDAO_().getPersonalIdReferenceNumber() != null && !getDAO_().getPersonalIdReferenceNumber().equals(argPersonalIdReferenceNumber))) {
/*  518 */       getDAO_().setPersonalIdReferenceNumber(argPersonalIdReferenceNumber);
/*  519 */       ev_postable = true;
/*      */     } 
/*      */     
/*  522 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPersonalIdRequiredTypeCode() {
/*  530 */     return getDAO_().getPersonalIdRequiredTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPersonalIdRequiredTypeCode(String argPersonalIdRequiredTypeCode) {
/*  538 */     if (setPersonalIdRequiredTypeCode_noev(argPersonalIdRequiredTypeCode) && 
/*  539 */       this._events != null && 
/*  540 */       postEventsForChanges()) {
/*  541 */       this._events.post(ICreditDebitTenderLineItem.SET_PERSONALIDREQUIREDTYPECODE, argPersonalIdRequiredTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPersonalIdRequiredTypeCode_noev(String argPersonalIdRequiredTypeCode) {
/*  548 */     boolean ev_postable = false;
/*      */     
/*  550 */     if ((getDAO_().getPersonalIdRequiredTypeCode() == null && argPersonalIdRequiredTypeCode != null) || (
/*  551 */       getDAO_().getPersonalIdRequiredTypeCode() != null && !getDAO_().getPersonalIdRequiredTypeCode().equals(argPersonalIdRequiredTypeCode))) {
/*  552 */       getDAO_().setPersonalIdRequiredTypeCode(argPersonalIdRequiredTypeCode);
/*  553 */       ev_postable = true;
/*      */     } 
/*      */     
/*  556 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getExpirationDateStringImpl() {
/*  564 */     return decryptField("ccenc", getDAO_().getExpirationDateString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getExpirationDateStringEncryptedImpl() {
/*  572 */     return getDAO_().getExpirationDateString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setExpirationDateStringImpl(String argExpirationDateString) {
/*  580 */     if (setExpirationDateString_noev(argExpirationDateString) && 
/*  581 */       this._events != null && 
/*  582 */       postEventsForChanges()) {
/*  583 */       this._events.post(ICreditDebitTenderLineItem.SET_EXPIRATIONDATESTRING, argExpirationDateString);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExpirationDateString_noev(String argExpirationDateString) {
/*  590 */     boolean ev_postable = false;
/*      */     
/*  592 */     if ((getDAO_().getExpirationDateString() == null && argExpirationDateString != null) || (
/*  593 */       getDAO_().getExpirationDateString() != null && !getDAO_().getExpirationDateString().equals(argExpirationDateString))) {
/*  594 */       getDAO_().setExpirationDateString(encryptField("ccenc", argExpirationDateString));
/*  595 */       ev_postable = true;
/*      */     } 
/*      */     
/*  598 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getCashbackAmount() {
/*  606 */     return getDAO_().getCashbackAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCashbackAmount(BigDecimal argCashbackAmount) {
/*  614 */     if (setCashbackAmount_noev(argCashbackAmount) && 
/*  615 */       this._events != null && 
/*  616 */       postEventsForChanges()) {
/*  617 */       this._events.post(ICreditDebitTenderLineItem.SET_CASHBACKAMOUNT, argCashbackAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCashbackAmount_noev(BigDecimal argCashbackAmount) {
/*  624 */     boolean ev_postable = false;
/*      */     
/*  626 */     if ((getDAO_().getCashbackAmount() == null && argCashbackAmount != null) || (
/*  627 */       getDAO_().getCashbackAmount() != null && !getDAO_().getCashbackAmount().equals(argCashbackAmount))) {
/*  628 */       getDAO_().setCashbackAmount(argCashbackAmount);
/*  629 */       ev_postable = true;
/*      */     } 
/*      */     
/*  632 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCardLevelIndicator() {
/*  640 */     return getDAO_().getCardLevelIndicator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCardLevelIndicator(String argCardLevelIndicator) {
/*  648 */     if (setCardLevelIndicator_noev(argCardLevelIndicator) && 
/*  649 */       this._events != null && 
/*  650 */       postEventsForChanges()) {
/*  651 */       this._events.post(ICreditDebitTenderLineItem.SET_CARDLEVELINDICATOR, argCardLevelIndicator);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCardLevelIndicator_noev(String argCardLevelIndicator) {
/*  658 */     boolean ev_postable = false;
/*      */     
/*  660 */     if ((getDAO_().getCardLevelIndicator() == null && argCardLevelIndicator != null) || (
/*  661 */       getDAO_().getCardLevelIndicator() != null && !getDAO_().getCardLevelIndicator().equals(argCardLevelIndicator))) {
/*  662 */       getDAO_().setCardLevelIndicator(argCardLevelIndicator);
/*  663 */       ev_postable = true;
/*      */     } 
/*      */     
/*  666 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAccountNumberHash() {
/*  674 */     return getDAO_().getAccountNumberHash();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAccountNumberHash(String argAccountNumberHash) {
/*  682 */     if (setAccountNumberHash_noev(argAccountNumberHash) && 
/*  683 */       this._events != null && 
/*  684 */       postEventsForChanges()) {
/*  685 */       this._events.post(ICreditDebitTenderLineItem.SET_ACCOUNTNUMBERHASH, argAccountNumberHash);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAccountNumberHash_noev(String argAccountNumberHash) {
/*  692 */     boolean ev_postable = false;
/*      */     
/*  694 */     if ((getDAO_().getAccountNumberHash() == null && argAccountNumberHash != null) || (
/*  695 */       getDAO_().getAccountNumberHash() != null && !getDAO_().getAccountNumberHash().equals(argAccountNumberHash))) {
/*  696 */       getDAO_().setAccountNumberHash(argAccountNumberHash);
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
/*      */   public String getAuthorizationToken() {
/*  708 */     return getDAO_().getAuthorizationToken();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAuthorizationToken(String argAuthorizationToken) {
/*  716 */     if (setAuthorizationToken_noev(argAuthorizationToken) && 
/*  717 */       this._events != null && 
/*  718 */       postEventsForChanges()) {
/*  719 */       this._events.post(ICreditDebitTenderLineItem.SET_AUTHORIZATIONTOKEN, argAuthorizationToken);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAuthorizationToken_noev(String argAuthorizationToken) {
/*  726 */     boolean ev_postable = false;
/*      */     
/*  728 */     if ((getDAO_().getAuthorizationToken() == null && argAuthorizationToken != null) || (
/*  729 */       getDAO_().getAuthorizationToken() != null && !getDAO_().getAuthorizationToken().equals(argAuthorizationToken))) {
/*  730 */       getDAO_().setAuthorizationToken(argAuthorizationToken);
/*  731 */       ev_postable = true;
/*      */     } 
/*      */     
/*  734 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTransactionReferenceData() {
/*  742 */     return getDAO_().getTransactionReferenceData();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionReferenceData(String argTransactionReferenceData) {
/*  750 */     if (setTransactionReferenceData_noev(argTransactionReferenceData) && 
/*  751 */       this._events != null && 
/*  752 */       postEventsForChanges()) {
/*  753 */       this._events.post(ICreditDebitTenderLineItem.SET_TRANSACTIONREFERENCEDATA, argTransactionReferenceData);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionReferenceData_noev(String argTransactionReferenceData) {
/*  760 */     boolean ev_postable = false;
/*      */     
/*  762 */     if ((getDAO_().getTransactionReferenceData() == null && argTransactionReferenceData != null) || (
/*  763 */       getDAO_().getTransactionReferenceData() != null && !getDAO_().getTransactionReferenceData().equals(argTransactionReferenceData))) {
/*  764 */       getDAO_().setTransactionReferenceData(argTransactionReferenceData);
/*  765 */       ev_postable = true;
/*      */     } 
/*      */     
/*  768 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTraceNumber() {
/*  776 */     return getDAO_().getTraceNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTraceNumber(String argTraceNumber) {
/*  784 */     if (setTraceNumber_noev(argTraceNumber) && 
/*  785 */       this._events != null && 
/*  786 */       postEventsForChanges()) {
/*  787 */       this._events.post(ICreditDebitTenderLineItem.SET_TRACENUMBER, argTraceNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTraceNumber_noev(String argTraceNumber) {
/*  794 */     boolean ev_postable = false;
/*      */     
/*  796 */     if ((getDAO_().getTraceNumber() == null && argTraceNumber != null) || (
/*  797 */       getDAO_().getTraceNumber() != null && !getDAO_().getTraceNumber().equals(argTraceNumber))) {
/*  798 */       getDAO_().setTraceNumber(argTraceNumber);
/*  799 */       ev_postable = true;
/*      */     } 
/*      */     
/*  802 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTaxAmount() {
/*  810 */     return getDAO_().getTaxAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxAmount(BigDecimal argTaxAmount) {
/*  818 */     if (setTaxAmount_noev(argTaxAmount) && 
/*  819 */       this._events != null && 
/*  820 */       postEventsForChanges()) {
/*  821 */       this._events.post(ICreditDebitTenderLineItem.SET_TAXAMOUNT, argTaxAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxAmount_noev(BigDecimal argTaxAmount) {
/*  828 */     boolean ev_postable = false;
/*      */     
/*  830 */     if ((getDAO_().getTaxAmount() == null && argTaxAmount != null) || (
/*  831 */       getDAO_().getTaxAmount() != null && !getDAO_().getTaxAmount().equals(argTaxAmount))) {
/*  832 */       getDAO_().setTaxAmount(argTaxAmount);
/*  833 */       ev_postable = true;
/*      */     } 
/*      */     
/*  836 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getDiscountAmount() {
/*  844 */     return getDAO_().getDiscountAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDiscountAmount(BigDecimal argDiscountAmount) {
/*  852 */     if (setDiscountAmount_noev(argDiscountAmount) && 
/*  853 */       this._events != null && 
/*  854 */       postEventsForChanges()) {
/*  855 */       this._events.post(ICreditDebitTenderLineItem.SET_DISCOUNTAMOUNT, argDiscountAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDiscountAmount_noev(BigDecimal argDiscountAmount) {
/*  862 */     boolean ev_postable = false;
/*      */     
/*  864 */     if ((getDAO_().getDiscountAmount() == null && argDiscountAmount != null) || (
/*  865 */       getDAO_().getDiscountAmount() != null && !getDAO_().getDiscountAmount().equals(argDiscountAmount))) {
/*  866 */       getDAO_().setDiscountAmount(argDiscountAmount);
/*  867 */       ev_postable = true;
/*      */     } 
/*      */     
/*  870 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getFreightAmount() {
/*  878 */     return getDAO_().getFreightAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFreightAmount(BigDecimal argFreightAmount) {
/*  886 */     if (setFreightAmount_noev(argFreightAmount) && 
/*  887 */       this._events != null && 
/*  888 */       postEventsForChanges()) {
/*  889 */       this._events.post(ICreditDebitTenderLineItem.SET_FREIGHTAMOUNT, argFreightAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFreightAmount_noev(BigDecimal argFreightAmount) {
/*  896 */     boolean ev_postable = false;
/*      */     
/*  898 */     if ((getDAO_().getFreightAmount() == null && argFreightAmount != null) || (
/*  899 */       getDAO_().getFreightAmount() != null && !getDAO_().getFreightAmount().equals(argFreightAmount))) {
/*  900 */       getDAO_().setFreightAmount(argFreightAmount);
/*  901 */       ev_postable = true;
/*      */     } 
/*      */     
/*  904 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getDutyAmount() {
/*  912 */     return getDAO_().getDutyAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDutyAmount(BigDecimal argDutyAmount) {
/*  920 */     if (setDutyAmount_noev(argDutyAmount) && 
/*  921 */       this._events != null && 
/*  922 */       postEventsForChanges()) {
/*  923 */       this._events.post(ICreditDebitTenderLineItem.SET_DUTYAMOUNT, argDutyAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDutyAmount_noev(BigDecimal argDutyAmount) {
/*  930 */     boolean ev_postable = false;
/*      */     
/*  932 */     if ((getDAO_().getDutyAmount() == null && argDutyAmount != null) || (
/*  933 */       getDAO_().getDutyAmount() != null && !getDAO_().getDutyAmount().equals(argDutyAmount))) {
/*  934 */       getDAO_().setDutyAmount(argDutyAmount);
/*  935 */       ev_postable = true;
/*      */     } 
/*      */     
/*  938 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrigLocalDateTime() {
/*  946 */     return getDAO_().getOrigLocalDateTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrigLocalDateTime(String argOrigLocalDateTime) {
/*  954 */     if (setOrigLocalDateTime_noev(argOrigLocalDateTime) && 
/*  955 */       this._events != null && 
/*  956 */       postEventsForChanges()) {
/*  957 */       this._events.post(ICreditDebitTenderLineItem.SET_ORIGLOCALDATETIME, argOrigLocalDateTime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrigLocalDateTime_noev(String argOrigLocalDateTime) {
/*  964 */     boolean ev_postable = false;
/*      */     
/*  966 */     if ((getDAO_().getOrigLocalDateTime() == null && argOrigLocalDateTime != null) || (
/*  967 */       getDAO_().getOrigLocalDateTime() != null && !getDAO_().getOrigLocalDateTime().equals(argOrigLocalDateTime))) {
/*  968 */       getDAO_().setOrigLocalDateTime(argOrigLocalDateTime);
/*  969 */       ev_postable = true;
/*      */     } 
/*      */     
/*  972 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrigTransmissionDateTime() {
/*  980 */     return getDAO_().getOrigTransmissionDateTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrigTransmissionDateTime(String argOrigTransmissionDateTime) {
/*  988 */     if (setOrigTransmissionDateTime_noev(argOrigTransmissionDateTime) && 
/*  989 */       this._events != null && 
/*  990 */       postEventsForChanges()) {
/*  991 */       this._events.post(ICreditDebitTenderLineItem.SET_ORIGTRANSMISSIONDATETIME, argOrigTransmissionDateTime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrigTransmissionDateTime_noev(String argOrigTransmissionDateTime) {
/*  998 */     boolean ev_postable = false;
/*      */     
/* 1000 */     if ((getDAO_().getOrigTransmissionDateTime() == null && argOrigTransmissionDateTime != null) || (
/* 1001 */       getDAO_().getOrigTransmissionDateTime() != null && !getDAO_().getOrigTransmissionDateTime().equals(argOrigTransmissionDateTime))) {
/* 1002 */       getDAO_().setOrigTransmissionDateTime(argOrigTransmissionDateTime);
/* 1003 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1006 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrigSTAN() {
/* 1014 */     return getDAO_().getOrigSTAN();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrigSTAN(String argOrigSTAN) {
/* 1022 */     if (setOrigSTAN_noev(argOrigSTAN) && 
/* 1023 */       this._events != null && 
/* 1024 */       postEventsForChanges()) {
/* 1025 */       this._events.post(ICreditDebitTenderLineItem.SET_ORIGSTAN, argOrigSTAN);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrigSTAN_noev(String argOrigSTAN) {
/* 1032 */     boolean ev_postable = false;
/*      */     
/* 1034 */     if ((getDAO_().getOrigSTAN() == null && argOrigSTAN != null) || (
/* 1035 */       getDAO_().getOrigSTAN() != null && !getDAO_().getOrigSTAN().equals(argOrigSTAN))) {
/* 1036 */       getDAO_().setOrigSTAN(argOrigSTAN);
/* 1037 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1040 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTransactionIdentifier() {
/* 1048 */     return getDAO_().getTransactionIdentifier();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionIdentifier(String argTransactionIdentifier) {
/* 1056 */     if (setTransactionIdentifier_noev(argTransactionIdentifier) && 
/* 1057 */       this._events != null && 
/* 1058 */       postEventsForChanges()) {
/* 1059 */       this._events.post(ICreditDebitTenderLineItem.SET_TRANSACTIONIDENTIFIER, argTransactionIdentifier);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionIdentifier_noev(String argTransactionIdentifier) {
/* 1066 */     boolean ev_postable = false;
/*      */     
/* 1068 */     if ((getDAO_().getTransactionIdentifier() == null && argTransactionIdentifier != null) || (
/* 1069 */       getDAO_().getTransactionIdentifier() != null && !getDAO_().getTransactionIdentifier().equals(argTransactionIdentifier))) {
/* 1070 */       getDAO_().setTransactionIdentifier(argTransactionIdentifier);
/* 1071 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1074 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCcvErrorCode() {
/* 1082 */     return getDAO_().getCcvErrorCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCcvErrorCode(String argCcvErrorCode) {
/* 1090 */     if (setCcvErrorCode_noev(argCcvErrorCode) && 
/* 1091 */       this._events != null && 
/* 1092 */       postEventsForChanges()) {
/* 1093 */       this._events.post(ICreditDebitTenderLineItem.SET_CCVERRORCODE, argCcvErrorCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCcvErrorCode_noev(String argCcvErrorCode) {
/* 1100 */     boolean ev_postable = false;
/*      */     
/* 1102 */     if ((getDAO_().getCcvErrorCode() == null && argCcvErrorCode != null) || (
/* 1103 */       getDAO_().getCcvErrorCode() != null && !getDAO_().getCcvErrorCode().equals(argCcvErrorCode))) {
/* 1104 */       getDAO_().setCcvErrorCode(argCcvErrorCode);
/* 1105 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1108 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPosEntryModeChange() {
/* 1116 */     return getDAO_().getPosEntryModeChange();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPosEntryModeChange(String argPosEntryModeChange) {
/* 1124 */     if (setPosEntryModeChange_noev(argPosEntryModeChange) && 
/* 1125 */       this._events != null && 
/* 1126 */       postEventsForChanges()) {
/* 1127 */       this._events.post(ICreditDebitTenderLineItem.SET_POSENTRYMODECHANGE, argPosEntryModeChange);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPosEntryModeChange_noev(String argPosEntryModeChange) {
/* 1134 */     boolean ev_postable = false;
/*      */     
/* 1136 */     if ((getDAO_().getPosEntryModeChange() == null && argPosEntryModeChange != null) || (
/* 1137 */       getDAO_().getPosEntryModeChange() != null && !getDAO_().getPosEntryModeChange().equals(argPosEntryModeChange))) {
/* 1138 */       getDAO_().setPosEntryModeChange(argPosEntryModeChange);
/* 1139 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1142 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getProcessingCode() {
/* 1150 */     return getDAO_().getProcessingCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setProcessingCode(String argProcessingCode) {
/* 1158 */     if (setProcessingCode_noev(argProcessingCode) && 
/* 1159 */       this._events != null && 
/* 1160 */       postEventsForChanges()) {
/* 1161 */       this._events.post(ICreditDebitTenderLineItem.SET_PROCESSINGCODE, argProcessingCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setProcessingCode_noev(String argProcessingCode) {
/* 1168 */     boolean ev_postable = false;
/*      */     
/* 1170 */     if ((getDAO_().getProcessingCode() == null && argProcessingCode != null) || (
/* 1171 */       getDAO_().getProcessingCode() != null && !getDAO_().getProcessingCode().equals(argProcessingCode))) {
/* 1172 */       getDAO_().setProcessingCode(argProcessingCode);
/* 1173 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1176 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPosEntryMode() {
/* 1184 */     return getDAO_().getPosEntryMode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPosEntryMode(String argPosEntryMode) {
/* 1192 */     if (setPosEntryMode_noev(argPosEntryMode) && 
/* 1193 */       this._events != null && 
/* 1194 */       postEventsForChanges()) {
/* 1195 */       this._events.post(ICreditDebitTenderLineItem.SET_POSENTRYMODE, argPosEntryMode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPosEntryMode_noev(String argPosEntryMode) {
/* 1202 */     boolean ev_postable = false;
/*      */     
/* 1204 */     if ((getDAO_().getPosEntryMode() == null && argPosEntryMode != null) || (
/* 1205 */       getDAO_().getPosEntryMode() != null && !getDAO_().getPosEntryMode().equals(argPosEntryMode))) {
/* 1206 */       getDAO_().setPosEntryMode(argPosEntryMode);
/* 1207 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1210 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPosAdditionalData() {
/* 1218 */     return getDAO_().getPosAdditionalData();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPosAdditionalData(String argPosAdditionalData) {
/* 1226 */     if (setPosAdditionalData_noev(argPosAdditionalData) && 
/* 1227 */       this._events != null && 
/* 1228 */       postEventsForChanges()) {
/* 1229 */       this._events.post(ICreditDebitTenderLineItem.SET_POSADDITIONALDATA, argPosAdditionalData);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPosAdditionalData_noev(String argPosAdditionalData) {
/* 1236 */     boolean ev_postable = false;
/*      */     
/* 1238 */     if ((getDAO_().getPosAdditionalData() == null && argPosAdditionalData != null) || (
/* 1239 */       getDAO_().getPosAdditionalData() != null && !getDAO_().getPosAdditionalData().equals(argPosAdditionalData))) {
/* 1240 */       getDAO_().setPosAdditionalData(argPosAdditionalData);
/* 1241 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1244 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNetworkResultIndicator() {
/* 1252 */     return getDAO_().getNetworkResultIndicator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNetworkResultIndicator(String argNetworkResultIndicator) {
/* 1260 */     if (setNetworkResultIndicator_noev(argNetworkResultIndicator) && 
/* 1261 */       this._events != null && 
/* 1262 */       postEventsForChanges()) {
/* 1263 */       this._events.post(ICreditDebitTenderLineItem.SET_NETWORKRESULTINDICATOR, argNetworkResultIndicator);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNetworkResultIndicator_noev(String argNetworkResultIndicator) {
/* 1270 */     boolean ev_postable = false;
/*      */     
/* 1272 */     if ((getDAO_().getNetworkResultIndicator() == null && argNetworkResultIndicator != null) || (
/* 1273 */       getDAO_().getNetworkResultIndicator() != null && !getDAO_().getNetworkResultIndicator().equals(argNetworkResultIndicator))) {
/* 1274 */       getDAO_().setNetworkResultIndicator(argNetworkResultIndicator);
/* 1275 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1278 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getMerchantCategoryCode() {
/* 1286 */     return getDAO_().getMerchantCategoryCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMerchantCategoryCode(String argMerchantCategoryCode) {
/* 1294 */     if (setMerchantCategoryCode_noev(argMerchantCategoryCode) && 
/* 1295 */       this._events != null && 
/* 1296 */       postEventsForChanges()) {
/* 1297 */       this._events.post(ICreditDebitTenderLineItem.SET_MERCHANTCATEGORYCODE, argMerchantCategoryCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMerchantCategoryCode_noev(String argMerchantCategoryCode) {
/* 1304 */     boolean ev_postable = false;
/*      */     
/* 1306 */     if ((getDAO_().getMerchantCategoryCode() == null && argMerchantCategoryCode != null) || (
/* 1307 */       getDAO_().getMerchantCategoryCode() != null && !getDAO_().getMerchantCategoryCode().equals(argMerchantCategoryCode))) {
/* 1308 */       getDAO_().setMerchantCategoryCode(argMerchantCategoryCode);
/* 1309 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1312 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1318 */     if ("CreditDebitTenderLineItemExtension".equals(argFieldId)) {
/* 1319 */       return this._myExtension;
/*      */     }
/*      */     
/* 1322 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1328 */     if ("CreditDebitTenderLineItemExtension".equals(argFieldId)) {
/* 1329 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1332 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1338 */     super.setDependencies(argPD, argEM);
/*      */   }
/*      */   
/*      */   public IDataModel getCreditDebitTenderLineItemExt() {
/* 1342 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setCreditDebitTenderLineItemExt(IDataModel argExt) {
/* 1346 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1351 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1355 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1358 */     super.startTransaction();
/*      */ 
/*      */     
/* 1361 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1366 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1369 */     super.rollbackChanges();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1375 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1378 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1381 */     super.commitTransaction();
/*      */ 
/*      */     
/* 1384 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1389 */     argStream.defaultReadObject();
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
/* 1401 */   private transient EncString track1 = null;
/* 1402 */   private transient EncString track2 = null;
/* 1403 */   private transient EncString track3 = null;
/*      */   private transient Date expirationDate;
/*      */   private transient String expirationDateStringUnencrypted;
/*      */   private transient EncString additionalPinSecurityInfo;
/*      */   private transient EncString cid;
/*      */   private transient boolean imprint;
/*      */   private transient String eftlinkRequestType;
/*      */   private transient EncString binNumber;
/*      */   private transient List receiptLines;
/*      */   private transient String miscellaneousData;
/*      */   
/*      */   public String getMiscellaneousData() {
/* 1415 */     return this.miscellaneousData;
/*      */   }
/*      */   
/*      */   public void setMiscellaneousData(String argMiscellaneousData) {
/* 1419 */     this.miscellaneousData = argMiscellaneousData;
/*      */   }
/*      */   
/*      */   public void setReceiptLines(List argReceiptLines) {
/* 1423 */     this.receiptLines = argReceiptLines;
/*      */   }
/*      */   
/*      */   public List getReceiptLines() {
/* 1427 */     return this.receiptLines;
/*      */   }
/*      */   
/*      */   public String getEftLinkRequestType() {
/* 1431 */     return this.eftlinkRequestType;
/*      */   }
/*      */   
/*      */   public void setEftLinkRequestType(String argRequestType) {
/* 1435 */     this.eftlinkRequestType = argRequestType;
/*      */   }
/*      */   
/*      */   public void setTrack1(EncString newValue) {
/* 1439 */     this.track1 = newValue;
/*      */   }
/*      */   
/*      */   public void setTrack2(EncString newValue) {
/* 1443 */     this.track2 = newValue;
/*      */   }
/*      */   
/*      */   public void setTrack3(EncString newValue) {
/* 1447 */     this.track3 = newValue;
/*      */   }
/*      */   
/*      */   public void setTrack1(String newValue) {
/* 1451 */     setTrack1(EncString.valueOf(newValue));
/*      */   }
/*      */   
/*      */   public void setTrack2(String newValue) {
/* 1455 */     setTrack2(EncString.valueOf(newValue));
/*      */   }
/*      */   
/*      */   public void setTrack3(String newValue) {
/* 1459 */     setTrack3(EncString.valueOf(newValue));
/*      */   }
/*      */   
/*      */   public EncString getTrack3() {
/* 1463 */     return this.track3;
/*      */   }
/*      */   
/*      */   public EncString getTrack2() {
/* 1467 */     return this.track2;
/*      */   }
/*      */   
/*      */   public EncString getTrack1() {
/* 1471 */     return this.track1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getExpirationDateString() {
/* 1480 */     this.expirationDateStringUnencrypted = getExpirationDateStringImpl();
/* 1481 */     return this.expirationDateStringUnencrypted;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getExpirationDateStringEncrypted() {
/* 1488 */     return getExpirationDateStringEncryptedImpl();
/*      */   }
/*      */   
/*      */   public Date getExpirationDate() {
/* 1492 */     this.expirationDateStringUnencrypted = getExpirationDateStringImpl();
/* 1493 */     this.expirationDate = DateUtils.parseDtvExpirationDate(this.expirationDateStringUnencrypted);
/* 1494 */     return this.expirationDate;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExpirationDateString(String newValue) {
/* 1501 */     String expirationDateString = null;
/* 1502 */     this.expirationDateStringUnencrypted = newValue;
/* 1503 */     setExpirationDateStringImpl(this.expirationDateStringUnencrypted);
/* 1504 */     expirationDateString = getExpirationDateStringImpl();
/*      */     
/* 1506 */     if (this.expirationDateStringUnencrypted == null) {
/* 1507 */       this.expirationDate = null;
/*      */     } else {
/*      */       
/* 1510 */       this.expirationDate = DateUtils.parseDtvExpirationDate(this.expirationDateStringUnencrypted);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setImprint(boolean argFlag) {
/* 1520 */     this.imprint = argFlag;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getImprint() {
/* 1529 */     return this.imprint;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEncryptedPin(EncString newValue) {
/* 1538 */     this.encryptedPin = newValue;
/*      */   }
/*      */   
/*      */   public void setEncryptedPin(String newValue) {
/* 1542 */     setEncryptedPin(EncString.valueOf(newValue));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEncryptedPin() {
/* 1551 */     return EncString.getSensitiveData(this.encryptedPin);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAdditionalPinSecurityInfo(EncString newValue) {
/* 1560 */     this.additionalPinSecurityInfo = newValue;
/*      */   }
/*      */   
/*      */   public void setAdditionalPinSecurityInfo(String newValue) {
/* 1564 */     setAdditionalPinSecurityInfo(EncString.valueOf(newValue));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAdditionalPinSecurityInfo() {
/* 1573 */     return EncString.getSensitiveData(this.additionalPinSecurityInfo);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCid(EncString newValue) {
/* 1582 */     this.cid = newValue;
/*      */   }
/*      */   
/*      */   public void setCid(String newValue) {
/* 1586 */     setCid(EncString.valueOf(newValue));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCid() {
/* 1595 */     return EncString.getSensitiveData(this.cid);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAccountNumber(String newValue) {
/* 1603 */     setAccountNumberHash(Hasher.hash("CreditDebitTenderLineItem.accountNumber", newValue));
/*      */ 
/*      */     
/* 1606 */     setAccountNumberImpl(newValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAccountNumber() {
/* 1613 */     return getAccountNumberImpl();
/*      */   }
/*      */   
/*      */   public void clearTokenInformation() {
/* 1617 */     setAccountNumberImpl((String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getMaskAccountNumberDao() {
/* 1626 */     return getStringProperty("MASKED_ACCOUNT_NUMBER");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaskAccountNumberDao(String argMaskAccountNumberDao) {
/* 1634 */     setStringProperty("MASKED_ACCOUNT_NUMBER", argMaskAccountNumberDao);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBinNumber(String newValue) {
/* 1641 */     this.binNumber = EncString.valueOf(newValue);
/*      */   }
/*      */   
/*      */   public String getBinNumber() {
/* 1645 */     return EncString.getSensitiveData(this.binNumber);
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\CreditDebitTenderLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */