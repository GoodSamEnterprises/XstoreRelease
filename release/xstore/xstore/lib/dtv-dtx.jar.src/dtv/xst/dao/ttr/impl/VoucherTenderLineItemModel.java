/*      */ package dtv.xst.dao.ttr.impl;
/*      */ 
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.crypto.EncString;
/*      */ import dtv.xst.dao.ttr.IVoucher;
/*      */ import dtv.xst.dao.ttr.IVoucherTenderLineItem;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class VoucherTenderLineItemModel
/*      */   extends TenderLineItemModel
/*      */   implements IVoucherTenderLineItem
/*      */ {
/*      */   private static final long serialVersionUID = -715118007L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private IVoucher _voucher;
/*      */   
/*      */   public void initDAO() {
/*   31 */     setDAO((IDataAccessObject)new VoucherTenderLineItemDAO());
/*      */   }
/*      */   private transient IVoucher _voucherSavepoint; private transient EncString _track1;
/*      */   private transient EncString _track2;
/*      */   private transient EncString _track3;
/*      */   private transient EncString _cid;
/*      */   
/*      */   private VoucherTenderLineItemDAO getDAO_() {
/*   39 */     return (VoucherTenderLineItemDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*   47 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*   55 */     if (setCreateDate_noev(argCreateDate) && 
/*   56 */       this._events != null && 
/*   57 */       postEventsForChanges()) {
/*   58 */       this._events.post(IVoucherTenderLineItem.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*   65 */     boolean ev_postable = false;
/*      */     
/*   67 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*   68 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*   69 */       getDAO_().setCreateDate(argCreateDate);
/*   70 */       ev_postable = true;
/*      */     } 
/*      */     
/*   73 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*   81 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*   89 */     if (setCreateUserId_noev(argCreateUserId) && 
/*   90 */       this._events != null && 
/*   91 */       postEventsForChanges()) {
/*   92 */       this._events.post(IVoucherTenderLineItem.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*   99 */     boolean ev_postable = false;
/*      */     
/*  101 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  102 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  103 */       getDAO_().setCreateUserId(argCreateUserId);
/*  104 */       ev_postable = true;
/*      */     } 
/*      */     
/*  107 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  115 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  123 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  124 */       this._events != null && 
/*  125 */       postEventsForChanges()) {
/*  126 */       this._events.post(IVoucherTenderLineItem.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  133 */     boolean ev_postable = false;
/*      */     
/*  135 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  136 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  137 */       getDAO_().setUpdateDate(argUpdateDate);
/*  138 */       ev_postable = true;
/*      */     } 
/*      */     
/*  141 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  149 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  157 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  158 */       this._events != null && 
/*  159 */       postEventsForChanges()) {
/*  160 */       this._events.post(IVoucherTenderLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  167 */     boolean ev_postable = false;
/*      */     
/*  169 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  170 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  171 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  172 */       ev_postable = true;
/*      */     } 
/*      */     
/*  175 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getActivityCode() {
/*  183 */     return getDAO_().getActivityCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActivityCode(String argActivityCode) {
/*  191 */     if (setActivityCode_noev(argActivityCode) && 
/*  192 */       this._events != null && 
/*  193 */       postEventsForChanges()) {
/*  194 */       this._events.post(IVoucherTenderLineItem.SET_ACTIVITYCODE, argActivityCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setActivityCode_noev(String argActivityCode) {
/*  201 */     boolean ev_postable = false;
/*      */     
/*  203 */     if ((getDAO_().getActivityCode() == null && argActivityCode != null) || (
/*  204 */       getDAO_().getActivityCode() != null && !getDAO_().getActivityCode().equals(argActivityCode))) {
/*  205 */       getDAO_().setActivityCode(argActivityCode);
/*  206 */       ev_postable = true;
/*      */     } 
/*      */     
/*  209 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAdjudicationCode() {
/*  217 */     return getDAO_().getAdjudicationCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAdjudicationCode(String argAdjudicationCode) {
/*  225 */     if (setAdjudicationCode_noev(argAdjudicationCode) && 
/*  226 */       this._events != null && 
/*  227 */       postEventsForChanges()) {
/*  228 */       this._events.post(IVoucherTenderLineItem.SET_ADJUDICATIONCODE, argAdjudicationCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAdjudicationCode_noev(String argAdjudicationCode) {
/*  235 */     boolean ev_postable = false;
/*      */     
/*  237 */     if ((getDAO_().getAdjudicationCode() == null && argAdjudicationCode != null) || (
/*  238 */       getDAO_().getAdjudicationCode() != null && !getDAO_().getAdjudicationCode().equals(argAdjudicationCode))) {
/*  239 */       getDAO_().setAdjudicationCode(argAdjudicationCode);
/*  240 */       ev_postable = true;
/*      */     } 
/*      */     
/*  243 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAuthorizationCode() {
/*  251 */     return getDAO_().getAuthorizationCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAuthorizationCode(String argAuthorizationCode) {
/*  259 */     if (setAuthorizationCode_noev(argAuthorizationCode) && 
/*  260 */       this._events != null && 
/*  261 */       postEventsForChanges()) {
/*  262 */       this._events.post(IVoucherTenderLineItem.SET_AUTHORIZATIONCODE, argAuthorizationCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAuthorizationCode_noev(String argAuthorizationCode) {
/*  269 */     boolean ev_postable = false;
/*      */     
/*  271 */     if ((getDAO_().getAuthorizationCode() == null && argAuthorizationCode != null) || (
/*  272 */       getDAO_().getAuthorizationCode() != null && !getDAO_().getAuthorizationCode().equals(argAuthorizationCode))) {
/*  273 */       getDAO_().setAuthorizationCode(argAuthorizationCode);
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
/*      */   public String getAuthorizationMethodCode() {
/*  285 */     return getDAO_().getAuthorizationMethodCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAuthorizationMethodCode(String argAuthorizationMethodCode) {
/*  293 */     if (setAuthorizationMethodCode_noev(argAuthorizationMethodCode) && 
/*  294 */       this._events != null && 
/*  295 */       postEventsForChanges()) {
/*  296 */       this._events.post(IVoucherTenderLineItem.SET_AUTHORIZATIONMETHODCODE, argAuthorizationMethodCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAuthorizationMethodCode_noev(String argAuthorizationMethodCode) {
/*  303 */     boolean ev_postable = false;
/*      */     
/*  305 */     if ((getDAO_().getAuthorizationMethodCode() == null && argAuthorizationMethodCode != null) || (
/*  306 */       getDAO_().getAuthorizationMethodCode() != null && !getDAO_().getAuthorizationMethodCode().equals(argAuthorizationMethodCode))) {
/*  307 */       getDAO_().setAuthorizationMethodCode(argAuthorizationMethodCode);
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
/*      */   public String getEntryMethodCode() {
/*  319 */     return getDAO_().getEntryMethodCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEntryMethodCode(String argEntryMethodCode) {
/*  327 */     if (setEntryMethodCode_noev(argEntryMethodCode) && 
/*  328 */       this._events != null && 
/*  329 */       postEventsForChanges()) {
/*  330 */       this._events.post(IVoucherTenderLineItem.SET_ENTRYMETHODCODE, argEntryMethodCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEntryMethodCode_noev(String argEntryMethodCode) {
/*  337 */     boolean ev_postable = false;
/*      */     
/*  339 */     if ((getDAO_().getEntryMethodCode() == null && argEntryMethodCode != null) || (
/*  340 */       getDAO_().getEntryMethodCode() != null && !getDAO_().getEntryMethodCode().equals(argEntryMethodCode))) {
/*  341 */       getDAO_().setEntryMethodCode(argEntryMethodCode);
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
/*      */   public String getVoucherTypeCode() {
/*  353 */     return getDAO_().getVoucherTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVoucherTypeCode(String argVoucherTypeCode) {
/*  361 */     if (setVoucherTypeCode_noev(argVoucherTypeCode) && 
/*  362 */       this._events != null && 
/*  363 */       postEventsForChanges()) {
/*  364 */       this._events.post(IVoucherTenderLineItem.SET_VOUCHERTYPECODE, argVoucherTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVoucherTypeCode_noev(String argVoucherTypeCode) {
/*  371 */     boolean ev_postable = false;
/*      */     
/*  373 */     if ((getDAO_().getVoucherTypeCode() == null && argVoucherTypeCode != null) || (
/*  374 */       getDAO_().getVoucherTypeCode() != null && !getDAO_().getVoucherTypeCode().equals(argVoucherTypeCode))) {
/*  375 */       getDAO_().setVoucherTypeCode(argVoucherTypeCode);
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
/*      */   public String getBankReferenceNumber() {
/*  387 */     return getDAO_().getBankReferenceNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBankReferenceNumber(String argBankReferenceNumber) {
/*  395 */     if (setBankReferenceNumber_noev(argBankReferenceNumber) && 
/*  396 */       this._events != null && 
/*  397 */       postEventsForChanges()) {
/*  398 */       this._events.post(IVoucherTenderLineItem.SET_BANKREFERENCENUMBER, argBankReferenceNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBankReferenceNumber_noev(String argBankReferenceNumber) {
/*  405 */     boolean ev_postable = false;
/*      */     
/*  407 */     if ((getDAO_().getBankReferenceNumber() == null && argBankReferenceNumber != null) || (
/*  408 */       getDAO_().getBankReferenceNumber() != null && !getDAO_().getBankReferenceNumber().equals(argBankReferenceNumber))) {
/*  409 */       getDAO_().setBankReferenceNumber(argBankReferenceNumber);
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
/*      */   protected Date getEffectiveDateImpl() {
/*  421 */     return getDAO_().getEffectiveDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setEffectiveDateImpl(Date argEffectiveDate) {
/*  429 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/*  430 */       this._events != null && 
/*  431 */       postEventsForChanges()) {
/*  432 */       this._events.post(IVoucherTenderLineItem.SET_EFFECTIVEDATE, argEffectiveDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/*  439 */     boolean ev_postable = false;
/*      */     
/*  441 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/*  442 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/*  443 */       getDAO_().setEffectiveDate(argEffectiveDate);
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
/*      */   protected Date getExpirationDateImpl() {
/*  455 */     return getDAO_().getExpirationDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setExpirationDateImpl(Date argExpirationDate) {
/*  463 */     if (setExpirationDate_noev(argExpirationDate) && 
/*  464 */       this._events != null && 
/*  465 */       postEventsForChanges()) {
/*  466 */       this._events.post(IVoucherTenderLineItem.SET_EXPIRATIONDATE, argExpirationDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/*  473 */     boolean ev_postable = false;
/*      */     
/*  475 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/*  476 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/*  477 */       getDAO_().setExpirationDate(argExpirationDate);
/*  478 */       ev_postable = true;
/*      */     } 
/*      */     
/*  481 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal getFaceValueAmountImpl() {
/*  489 */     return getDAO_().getFaceValueAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setFaceValueAmountImpl(BigDecimal argFaceValueAmount) {
/*  497 */     if (setFaceValueAmount_noev(argFaceValueAmount) && 
/*  498 */       this._events != null && 
/*  499 */       postEventsForChanges()) {
/*  500 */       this._events.post(IVoucherTenderLineItem.SET_FACEVALUEAMOUNT, argFaceValueAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFaceValueAmount_noev(BigDecimal argFaceValueAmount) {
/*  507 */     boolean ev_postable = false;
/*      */     
/*  509 */     if ((getDAO_().getFaceValueAmount() == null && argFaceValueAmount != null) || (
/*  510 */       getDAO_().getFaceValueAmount() != null && !getDAO_().getFaceValueAmount().equals(argFaceValueAmount))) {
/*  511 */       getDAO_().setFaceValueAmount(argFaceValueAmount);
/*  512 */       ev_postable = true;
/*      */     } 
/*      */     
/*  515 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Date getIssueDatetimestampImpl() {
/*  523 */     return getDAO_().getIssueDatetimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setIssueDatetimestampImpl(Date argIssueDatetimestamp) {
/*  531 */     if (setIssueDatetimestamp_noev(argIssueDatetimestamp) && 
/*  532 */       this._events != null && 
/*  533 */       postEventsForChanges()) {
/*  534 */       this._events.post(IVoucherTenderLineItem.SET_ISSUEDATETIMESTAMP, argIssueDatetimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setIssueDatetimestamp_noev(Date argIssueDatetimestamp) {
/*  541 */     boolean ev_postable = false;
/*      */     
/*  543 */     if ((getDAO_().getIssueDatetimestamp() == null && argIssueDatetimestamp != null) || (
/*  544 */       getDAO_().getIssueDatetimestamp() != null && !getDAO_().getIssueDatetimestamp().equals(argIssueDatetimestamp))) {
/*  545 */       getDAO_().setIssueDatetimestamp(argIssueDatetimestamp);
/*  546 */       ev_postable = true;
/*      */     } 
/*      */     
/*  549 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getIssueTypeCodeImpl() {
/*  557 */     return getDAO_().getIssueTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setIssueTypeCodeImpl(String argIssueTypeCode) {
/*  565 */     if (setIssueTypeCode_noev(argIssueTypeCode) && 
/*  566 */       this._events != null && 
/*  567 */       postEventsForChanges()) {
/*  568 */       this._events.post(IVoucherTenderLineItem.SET_ISSUETYPECODE, argIssueTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setIssueTypeCode_noev(String argIssueTypeCode) {
/*  575 */     boolean ev_postable = false;
/*      */     
/*  577 */     if ((getDAO_().getIssueTypeCode() == null && argIssueTypeCode != null) || (
/*  578 */       getDAO_().getIssueTypeCode() != null && !getDAO_().getIssueTypeCode().equals(argIssueTypeCode))) {
/*  579 */       getDAO_().setIssueTypeCode(argIssueTypeCode);
/*  580 */       ev_postable = true;
/*      */     } 
/*      */     
/*  583 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal getUnspentBalanceAmountImpl() {
/*  591 */     return getDAO_().getUnspentBalanceAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUnspentBalanceAmountImpl(BigDecimal argUnspentBalanceAmount) {
/*  599 */     if (setUnspentBalanceAmount_noev(argUnspentBalanceAmount) && 
/*  600 */       this._events != null && 
/*  601 */       postEventsForChanges()) {
/*  602 */       this._events.post(IVoucherTenderLineItem.SET_UNSPENTBALANCEAMOUNT, argUnspentBalanceAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUnspentBalanceAmount_noev(BigDecimal argUnspentBalanceAmount) {
/*  609 */     boolean ev_postable = false;
/*      */     
/*  611 */     if ((getDAO_().getUnspentBalanceAmount() == null && argUnspentBalanceAmount != null) || (
/*  612 */       getDAO_().getUnspentBalanceAmount() != null && !getDAO_().getUnspentBalanceAmount().equals(argUnspentBalanceAmount))) {
/*  613 */       getDAO_().setUnspentBalanceAmount(argUnspentBalanceAmount);
/*  614 */       ev_postable = true;
/*      */     } 
/*      */     
/*  617 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getVoucherStatusCodeImpl() {
/*  625 */     return getDAO_().getVoucherStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setVoucherStatusCodeImpl(String argVoucherStatusCode) {
/*  633 */     if (setVoucherStatusCode_noev(argVoucherStatusCode) && 
/*  634 */       this._events != null && 
/*  635 */       postEventsForChanges()) {
/*  636 */       this._events.post(IVoucherTenderLineItem.SET_VOUCHERSTATUSCODE, argVoucherStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVoucherStatusCode_noev(String argVoucherStatusCode) {
/*  643 */     boolean ev_postable = false;
/*      */     
/*  645 */     if ((getDAO_().getVoucherStatusCode() == null && argVoucherStatusCode != null) || (
/*  646 */       getDAO_().getVoucherStatusCode() != null && !getDAO_().getVoucherStatusCode().equals(argVoucherStatusCode))) {
/*  647 */       getDAO_().setVoucherStatusCode(argVoucherStatusCode);
/*  648 */       ev_postable = true;
/*      */     } 
/*      */     
/*  651 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTraceNumber() {
/*  659 */     return getDAO_().getTraceNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTraceNumber(String argTraceNumber) {
/*  667 */     if (setTraceNumber_noev(argTraceNumber) && 
/*  668 */       this._events != null && 
/*  669 */       postEventsForChanges()) {
/*  670 */       this._events.post(IVoucherTenderLineItem.SET_TRACENUMBER, argTraceNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTraceNumber_noev(String argTraceNumber) {
/*  677 */     boolean ev_postable = false;
/*      */     
/*  679 */     if ((getDAO_().getTraceNumber() == null && argTraceNumber != null) || (
/*  680 */       getDAO_().getTraceNumber() != null && !getDAO_().getTraceNumber().equals(argTraceNumber))) {
/*  681 */       getDAO_().setTraceNumber(argTraceNumber);
/*  682 */       ev_postable = true;
/*      */     } 
/*      */     
/*  685 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrigLocalDateTime() {
/*  693 */     return getDAO_().getOrigLocalDateTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrigLocalDateTime(String argOrigLocalDateTime) {
/*  701 */     if (setOrigLocalDateTime_noev(argOrigLocalDateTime) && 
/*  702 */       this._events != null && 
/*  703 */       postEventsForChanges()) {
/*  704 */       this._events.post(IVoucherTenderLineItem.SET_ORIGLOCALDATETIME, argOrigLocalDateTime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrigLocalDateTime_noev(String argOrigLocalDateTime) {
/*  711 */     boolean ev_postable = false;
/*      */     
/*  713 */     if ((getDAO_().getOrigLocalDateTime() == null && argOrigLocalDateTime != null) || (
/*  714 */       getDAO_().getOrigLocalDateTime() != null && !getDAO_().getOrigLocalDateTime().equals(argOrigLocalDateTime))) {
/*  715 */       getDAO_().setOrigLocalDateTime(argOrigLocalDateTime);
/*  716 */       ev_postable = true;
/*      */     } 
/*      */     
/*  719 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrigTransmissionDateTime() {
/*  727 */     return getDAO_().getOrigTransmissionDateTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrigTransmissionDateTime(String argOrigTransmissionDateTime) {
/*  735 */     if (setOrigTransmissionDateTime_noev(argOrigTransmissionDateTime) && 
/*  736 */       this._events != null && 
/*  737 */       postEventsForChanges()) {
/*  738 */       this._events.post(IVoucherTenderLineItem.SET_ORIGTRANSMISSIONDATETIME, argOrigTransmissionDateTime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrigTransmissionDateTime_noev(String argOrigTransmissionDateTime) {
/*  745 */     boolean ev_postable = false;
/*      */     
/*  747 */     if ((getDAO_().getOrigTransmissionDateTime() == null && argOrigTransmissionDateTime != null) || (
/*  748 */       getDAO_().getOrigTransmissionDateTime() != null && !getDAO_().getOrigTransmissionDateTime().equals(argOrigTransmissionDateTime))) {
/*  749 */       getDAO_().setOrigTransmissionDateTime(argOrigTransmissionDateTime);
/*  750 */       ev_postable = true;
/*      */     } 
/*      */     
/*  753 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrigSTAN() {
/*  761 */     return getDAO_().getOrigSTAN();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrigSTAN(String argOrigSTAN) {
/*  769 */     if (setOrigSTAN_noev(argOrigSTAN) && 
/*  770 */       this._events != null && 
/*  771 */       postEventsForChanges()) {
/*  772 */       this._events.post(IVoucherTenderLineItem.SET_ORIGSTAN, argOrigSTAN);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrigSTAN_noev(String argOrigSTAN) {
/*  779 */     boolean ev_postable = false;
/*      */     
/*  781 */     if ((getDAO_().getOrigSTAN() == null && argOrigSTAN != null) || (
/*  782 */       getDAO_().getOrigSTAN() != null && !getDAO_().getOrigSTAN().equals(argOrigSTAN))) {
/*  783 */       getDAO_().setOrigSTAN(argOrigSTAN);
/*  784 */       ev_postable = true;
/*      */     } 
/*      */     
/*  787 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getMerchantCategoryCode() {
/*  795 */     return getDAO_().getMerchantCategoryCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMerchantCategoryCode(String argMerchantCategoryCode) {
/*  803 */     if (setMerchantCategoryCode_noev(argMerchantCategoryCode) && 
/*  804 */       this._events != null && 
/*  805 */       postEventsForChanges()) {
/*  806 */       this._events.post(IVoucherTenderLineItem.SET_MERCHANTCATEGORYCODE, argMerchantCategoryCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMerchantCategoryCode_noev(String argMerchantCategoryCode) {
/*  813 */     boolean ev_postable = false;
/*      */     
/*  815 */     if ((getDAO_().getMerchantCategoryCode() == null && argMerchantCategoryCode != null) || (
/*  816 */       getDAO_().getMerchantCategoryCode() != null && !getDAO_().getMerchantCategoryCode().equals(argMerchantCategoryCode))) {
/*  817 */       getDAO_().setMerchantCategoryCode(argMerchantCategoryCode);
/*  818 */       ev_postable = true;
/*      */     } 
/*      */     
/*  821 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Voucher")
/*      */   public IVoucher getVoucher() {
/*  830 */     return this._voucher;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void setVoucherImpl(IVoucher argVoucher) {
/*  835 */     if (argVoucher == null) {
/*      */       
/*  837 */       getDAO_().setSerialNumber(null);
/*  838 */       getDAO_().setVoucherTypeCode((String)null);
/*  839 */       if (this._voucher != null)
/*      */       {
/*  841 */         if (postEventsForChanges()) {
/*  842 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._voucher));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  847 */       getDAO_().setSerialNumber(argVoucher.getSerialNumber());
/*  848 */       getDAO_().setVoucherTypeCode(argVoucher.getVoucherTypeCode());
/*      */       
/*  850 */       if (postEventsForChanges()) {
/*  851 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argVoucher));
/*      */       }
/*      */     } 
/*      */     
/*  855 */     this._voucher = argVoucher;
/*  856 */     if (postEventsForChanges()) {
/*  857 */       this._events.post(IVoucherTenderLineItem.SET_VOUCHER, argVoucher);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  863 */     if ("Voucher".equals(argFieldId)) {
/*  864 */       return getVoucher();
/*      */     }
/*  866 */     if ("VoucherTenderLineItemExtension".equals(argFieldId)) {
/*  867 */       return this._myExtension;
/*      */     }
/*      */     
/*  870 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  876 */     if ("Voucher".equals(argFieldId)) {
/*  877 */       setVoucher((IVoucher)argValue);
/*      */     }
/*  879 */     else if ("VoucherTenderLineItemExtension".equals(argFieldId)) {
/*  880 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  883 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  889 */     super.setDependencies(argPD, argEM);
/*  890 */     if (this._voucher != null) {
/*  891 */       ((IDataModelImpl)this._voucher).setDependencies(argPD, argEM);
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getVoucherTenderLineItemExt() {
/*  896 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setVoucherTenderLineItemExt(IDataModel argExt) {
/*  900 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  905 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  909 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  912 */     super.startTransaction();
/*      */     
/*  914 */     this._voucherSavepoint = this._voucher;
/*  915 */     if (this._voucher != null) {
/*  916 */       this._voucher.startTransaction();
/*      */     }
/*      */ 
/*      */     
/*  920 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/*  925 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/*  928 */     super.rollbackChanges();
/*      */     
/*  930 */     this._voucher = this._voucherSavepoint;
/*  931 */     this._voucherSavepoint = null;
/*  932 */     if (this._voucher != null) {
/*  933 */       this._voucher.rollbackChanges();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/*  940 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/*  943 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/*  946 */     super.commitTransaction();
/*      */     
/*  948 */     this._voucherSavepoint = this._voucher;
/*  949 */     if (this._voucher != null) {
/*  950 */       this._voucher.commitTransaction();
/*      */     }
/*      */ 
/*      */     
/*  954 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/*  959 */     argStream.defaultReadObject();
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
/*      */   public void setTrack1(EncString argTrack) {
/*  976 */     this._track1 = argTrack;
/*      */   }
/*      */   public void setTrack2(EncString argTrack) {
/*  979 */     this._track2 = argTrack;
/*      */   }
/*      */   public void setTrack3(EncString argTrack) {
/*  982 */     this._track3 = argTrack;
/*      */   }
/*      */   public void setCid(EncString argValue) {
/*  985 */     this._cid = argValue;
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   public void setTrack1(String argTrack) {
/*  990 */     setTrack1(EncString.valueOf(argTrack));
/*      */   }
/*      */   @Deprecated
/*      */   public void setTrack2(String argTrack) {
/*  994 */     setTrack2(EncString.valueOf(argTrack));
/*      */   }
/*      */   @Deprecated
/*      */   public void setTrack3(String argTrack) {
/*  998 */     setTrack3(EncString.valueOf(argTrack));
/*      */   }
/*      */   @Deprecated
/*      */   public void setCid(String newValue) {
/* 1002 */     setCid(EncString.valueOf(newValue));
/*      */   }
/*      */   
/*      */   public EncString getTrack1() {
/* 1006 */     return this._track1;
/*      */   }
/*      */   public EncString getTrack2() {
/* 1009 */     return this._track2;
/*      */   }
/*      */   public EncString getTrack3() {
/* 1012 */     return this._track3;
/*      */   }
/*      */   public EncString getCid() {
/* 1015 */     return this._cid;
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
/*      */   public Date getEffectiveDate() {
/* 1029 */     if (this._voucher == null) {
/* 1030 */       return getEffectiveDateImpl();
/*      */     }
/*      */     
/* 1033 */     return this._voucher.getEffectiveDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEffectiveDate(Date argEffectiveDate) {
/* 1040 */     setEffectiveDateImpl(argEffectiveDate);
/*      */     
/* 1042 */     if (this._voucher != null) {
/* 1043 */       this._voucher.setEffectiveDate(argEffectiveDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getExpirationDate() {
/* 1051 */     if (this._voucher == null) {
/* 1052 */       return getExpirationDateImpl();
/*      */     }
/*      */     
/* 1055 */     return this._voucher.getExpirationDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExpirationDate(Date argExpirationDate) {
/* 1062 */     setExpirationDateImpl(argExpirationDate);
/*      */     
/* 1064 */     if (this._voucher != null) {
/* 1065 */       this._voucher.setExpirationDate(argExpirationDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getFaceValueAmount() {
/* 1073 */     if (this._voucher == null) {
/* 1074 */       return getFaceValueAmountImpl();
/*      */     }
/*      */     
/* 1077 */     return this._voucher.getFaceValueAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFaceValueAmount(BigDecimal argFaceValueAmount) {
/* 1084 */     setFaceValueAmountImpl(argFaceValueAmount);
/*      */     
/* 1086 */     if (this._voucher != null) {
/* 1087 */       this._voucher.setFaceValueAmount(argFaceValueAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getIssueDatetimestamp() {
/* 1095 */     if (this._voucher == null) {
/* 1096 */       return getIssueDatetimestampImpl();
/*      */     }
/*      */     
/* 1099 */     return this._voucher.getIssueDatetimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIssueDatetimestamp(Date argIssueDatetimestamp) {
/* 1106 */     setIssueDatetimestampImpl(argIssueDatetimestamp);
/*      */     
/* 1108 */     if (this._voucher != null) {
/* 1109 */       this._voucher.setIssueDatetimestamp(argIssueDatetimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getIssueTypeCode() {
/* 1117 */     if (this._voucher == null) {
/* 1118 */       return getIssueTypeCodeImpl();
/*      */     }
/*      */     
/* 1121 */     return this._voucher.getIssueTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIssueTypeCode(String argIssueTypeCode) {
/* 1128 */     setIssueTypeCodeImpl(argIssueTypeCode);
/*      */     
/* 1130 */     if (this._voucher != null) {
/* 1131 */       this._voucher.setIssueTypeCode(argIssueTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getUnspentBalanceAmount() {
/* 1139 */     if (this._voucher == null) {
/* 1140 */       return getUnspentBalanceAmountImpl();
/*      */     }
/*      */     
/* 1143 */     return this._voucher.getUnspentBalanceAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUnspentBalanceAmount(BigDecimal argUnspentBalanceAmount) {
/* 1150 */     setUnspentBalanceAmountImpl(argUnspentBalanceAmount);
/*      */     
/* 1152 */     if (this._voucher != null) {
/* 1153 */       this._voucher.setUnspentBalanceAmount(argUnspentBalanceAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getVoucherStatusCode() {
/* 1161 */     if (this._voucher == null) {
/* 1162 */       return getVoucherStatusCodeImpl();
/*      */     }
/*      */     
/* 1165 */     return this._voucher.getVoucherStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVoucherStatusCode(String argVoucherStatusCode) {
/* 1172 */     setVoucherStatusCodeImpl(argVoucherStatusCode);
/*      */     
/* 1174 */     if (this._voucher != null) {
/* 1175 */       this._voucher.setVoucherStatusCode(argVoucherStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVoucher(IVoucher argVoucher) {
/* 1183 */     setVoucherImpl(argVoucher);
/*      */     
/* 1185 */     if (argVoucher != null) {
/* 1186 */       setEffectiveDate(argVoucher.getEffectiveDate());
/* 1187 */       setExpirationDate(argVoucher.getExpirationDate());
/* 1188 */       setFaceValueAmount(argVoucher.getFaceValueAmount());
/* 1189 */       setIssueDatetimestamp(argVoucher.getIssueDatetimestamp());
/* 1190 */       setIssueTypeCode(argVoucher.getIssueTypeCode());
/* 1191 */       setUnspentBalanceAmount(argVoucher.getUnspentBalanceAmount());
/* 1192 */       setVoucherStatusCode(argVoucher.getVoucherStatusCode());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAuthorizationToken(String argAuthorizationToken) {}
/*      */ 
/*      */   
/*      */   public String getAuthorizationToken() {
/* 1201 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTransactionReferenceData(String argTransactionReferenceData) {}
/*      */ 
/*      */   
/*      */   public String getTransactionReferenceData() {
/* 1209 */     return null;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\VoucherTenderLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */