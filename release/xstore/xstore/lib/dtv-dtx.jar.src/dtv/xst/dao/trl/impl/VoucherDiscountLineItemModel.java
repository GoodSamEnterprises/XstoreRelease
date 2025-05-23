/*      */ package dtv.xst.dao.trl.impl;
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
/*      */ import dtv.util.NumberUtils;
/*      */ import dtv.util.crypto.EncString;
/*      */ import dtv.xst.dao.dsc.IDiscount;
/*      */ import dtv.xst.dao.trl.IVoucherDiscountLineItem;
/*      */ import dtv.xst.dao.ttr.IVoucher;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class VoucherDiscountLineItemModel
/*      */   extends DiscountLineItemModel implements IVoucherDiscountLineItem {
/*      */   private static final long serialVersionUID = -379249610L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private IVoucher _voucher;
/*      */   
/*      */   public void initDAO() {
/*   31 */     setDAO((IDataAccessObject)new VoucherDiscountLineItemDAO());
/*      */   }
/*      */ 
/*      */   
/*      */   private transient IVoucher _voucherSavepoint;
/*      */   private transient EncString _track1;
/*      */   
/*      */   private VoucherDiscountLineItemDAO getDAO_() {
/*   39 */     return (VoucherDiscountLineItemDAO)this._daoImpl;
/*      */   }
/*      */   
/*      */   private transient EncString _track2;
/*      */   private transient EncString _track3;
/*      */   private transient EncString _cid;
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
/*   58 */       this._events.post(IVoucherDiscountLineItem.SET_CREATEDATE, argCreateDate);
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
/*   92 */       this._events.post(IVoucherDiscountLineItem.SET_CREATEUSERID, argCreateUserId);
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
/*  126 */       this._events.post(IVoucherDiscountLineItem.SET_UPDATEDATE, argUpdateDate);
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
/*  160 */       this._events.post(IVoucherDiscountLineItem.SET_UPDATEUSERID, argUpdateUserId);
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
/*  194 */       this._events.post(IVoucherDiscountLineItem.SET_ACTIVITYCODE, argActivityCode);
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
/*  228 */       this._events.post(IVoucherDiscountLineItem.SET_ADJUDICATIONCODE, argAdjudicationCode);
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
/*  262 */       this._events.post(IVoucherDiscountLineItem.SET_AUTHORIZATIONCODE, argAuthorizationCode);
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
/*  296 */       this._events.post(IVoucherDiscountLineItem.SET_AUTHORIZATIONMETHODCODE, argAuthorizationMethodCode);
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
/*  330 */       this._events.post(IVoucherDiscountLineItem.SET_ENTRYMETHODCODE, argEntryMethodCode);
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
/*      */   public String getSerialNumber() {
/*  353 */     return getDAO_().getSerialNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSerialNumber(String argSerialNumber) {
/*  361 */     if (setSerialNumber_noev(argSerialNumber) && 
/*  362 */       this._events != null && 
/*  363 */       postEventsForChanges()) {
/*  364 */       this._events.post(IVoucherDiscountLineItem.SET_SERIALNUMBER, argSerialNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSerialNumber_noev(String argSerialNumber) {
/*  371 */     boolean ev_postable = false;
/*      */     
/*  373 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/*  374 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/*  375 */       getDAO_().setSerialNumber(argSerialNumber);
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
/*      */   public String getVoucherTypeCode() {
/*  387 */     return getDAO_().getVoucherTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVoucherTypeCode(String argVoucherTypeCode) {
/*  395 */     if (setVoucherTypeCode_noev(argVoucherTypeCode) && 
/*  396 */       this._events != null && 
/*  397 */       postEventsForChanges()) {
/*  398 */       this._events.post(IVoucherDiscountLineItem.SET_VOUCHERTYPECODE, argVoucherTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVoucherTypeCode_noev(String argVoucherTypeCode) {
/*  405 */     boolean ev_postable = false;
/*      */     
/*  407 */     if ((getDAO_().getVoucherTypeCode() == null && argVoucherTypeCode != null) || (
/*  408 */       getDAO_().getVoucherTypeCode() != null && !getDAO_().getVoucherTypeCode().equals(argVoucherTypeCode))) {
/*  409 */       getDAO_().setVoucherTypeCode(argVoucherTypeCode);
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
/*      */   public String getBankReferenceNumber() {
/*  421 */     return getDAO_().getBankReferenceNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBankReferenceNumber(String argBankReferenceNumber) {
/*  429 */     if (setBankReferenceNumber_noev(argBankReferenceNumber) && 
/*  430 */       this._events != null && 
/*  431 */       postEventsForChanges()) {
/*  432 */       this._events.post(IVoucherDiscountLineItem.SET_BANKREFERENCENUMBER, argBankReferenceNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBankReferenceNumber_noev(String argBankReferenceNumber) {
/*  439 */     boolean ev_postable = false;
/*      */     
/*  441 */     if ((getDAO_().getBankReferenceNumber() == null && argBankReferenceNumber != null) || (
/*  442 */       getDAO_().getBankReferenceNumber() != null && !getDAO_().getBankReferenceNumber().equals(argBankReferenceNumber))) {
/*  443 */       getDAO_().setBankReferenceNumber(argBankReferenceNumber);
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
/*      */   protected Date getEffectiveDateImpl() {
/*  455 */     return getDAO_().getEffectiveDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setEffectiveDateImpl(Date argEffectiveDate) {
/*  463 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/*  464 */       this._events != null && 
/*  465 */       postEventsForChanges()) {
/*  466 */       this._events.post(IVoucherDiscountLineItem.SET_EFFECTIVEDATE, argEffectiveDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/*  473 */     boolean ev_postable = false;
/*      */     
/*  475 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/*  476 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/*  477 */       getDAO_().setEffectiveDate(argEffectiveDate);
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
/*      */   protected Date getExpirationDateImpl() {
/*  489 */     return getDAO_().getExpirationDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setExpirationDateImpl(Date argExpirationDate) {
/*  497 */     if (setExpirationDate_noev(argExpirationDate) && 
/*  498 */       this._events != null && 
/*  499 */       postEventsForChanges()) {
/*  500 */       this._events.post(IVoucherDiscountLineItem.SET_EXPIRATIONDATE, argExpirationDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/*  507 */     boolean ev_postable = false;
/*      */     
/*  509 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/*  510 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/*  511 */       getDAO_().setExpirationDate(argExpirationDate);
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
/*      */   protected BigDecimal getFaceValueAmountImpl() {
/*  523 */     return getDAO_().getFaceValueAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setFaceValueAmountImpl(BigDecimal argFaceValueAmount) {
/*  531 */     if (setFaceValueAmount_noev(argFaceValueAmount) && 
/*  532 */       this._events != null && 
/*  533 */       postEventsForChanges()) {
/*  534 */       this._events.post(IVoucherDiscountLineItem.SET_FACEVALUEAMOUNT, argFaceValueAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFaceValueAmount_noev(BigDecimal argFaceValueAmount) {
/*  541 */     boolean ev_postable = false;
/*      */     
/*  543 */     if ((getDAO_().getFaceValueAmount() == null && argFaceValueAmount != null) || (
/*  544 */       getDAO_().getFaceValueAmount() != null && !getDAO_().getFaceValueAmount().equals(argFaceValueAmount))) {
/*  545 */       getDAO_().setFaceValueAmount(argFaceValueAmount);
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
/*      */   protected Date getIssueDatetimestampImpl() {
/*  557 */     return getDAO_().getIssueDatetimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setIssueDatetimestampImpl(Date argIssueDatetimestamp) {
/*  565 */     if (setIssueDatetimestamp_noev(argIssueDatetimestamp) && 
/*  566 */       this._events != null && 
/*  567 */       postEventsForChanges()) {
/*  568 */       this._events.post(IVoucherDiscountLineItem.SET_ISSUEDATETIMESTAMP, argIssueDatetimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setIssueDatetimestamp_noev(Date argIssueDatetimestamp) {
/*  575 */     boolean ev_postable = false;
/*      */     
/*  577 */     if ((getDAO_().getIssueDatetimestamp() == null && argIssueDatetimestamp != null) || (
/*  578 */       getDAO_().getIssueDatetimestamp() != null && !getDAO_().getIssueDatetimestamp().equals(argIssueDatetimestamp))) {
/*  579 */       getDAO_().setIssueDatetimestamp(argIssueDatetimestamp);
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
/*      */   protected String getIssueTypeCodeImpl() {
/*  591 */     return getDAO_().getIssueTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setIssueTypeCodeImpl(String argIssueTypeCode) {
/*  599 */     if (setIssueTypeCode_noev(argIssueTypeCode) && 
/*  600 */       this._events != null && 
/*  601 */       postEventsForChanges()) {
/*  602 */       this._events.post(IVoucherDiscountLineItem.SET_ISSUETYPECODE, argIssueTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setIssueTypeCode_noev(String argIssueTypeCode) {
/*  609 */     boolean ev_postable = false;
/*      */     
/*  611 */     if ((getDAO_().getIssueTypeCode() == null && argIssueTypeCode != null) || (
/*  612 */       getDAO_().getIssueTypeCode() != null && !getDAO_().getIssueTypeCode().equals(argIssueTypeCode))) {
/*  613 */       getDAO_().setIssueTypeCode(argIssueTypeCode);
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
/*      */   protected BigDecimal getUnspentBalanceAmountImpl() {
/*  625 */     return getDAO_().getUnspentBalanceAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUnspentBalanceAmountImpl(BigDecimal argUnspentBalanceAmount) {
/*  633 */     if (setUnspentBalanceAmount_noev(argUnspentBalanceAmount) && 
/*  634 */       this._events != null && 
/*  635 */       postEventsForChanges()) {
/*  636 */       this._events.post(IVoucherDiscountLineItem.SET_UNSPENTBALANCEAMOUNT, argUnspentBalanceAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUnspentBalanceAmount_noev(BigDecimal argUnspentBalanceAmount) {
/*  643 */     boolean ev_postable = false;
/*      */     
/*  645 */     if ((getDAO_().getUnspentBalanceAmount() == null && argUnspentBalanceAmount != null) || (
/*  646 */       getDAO_().getUnspentBalanceAmount() != null && !getDAO_().getUnspentBalanceAmount().equals(argUnspentBalanceAmount))) {
/*  647 */       getDAO_().setUnspentBalanceAmount(argUnspentBalanceAmount);
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
/*      */   protected String getVoucherStatusCodeImpl() {
/*  659 */     return getDAO_().getVoucherStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setVoucherStatusCodeImpl(String argVoucherStatusCode) {
/*  667 */     if (setVoucherStatusCode_noev(argVoucherStatusCode) && 
/*  668 */       this._events != null && 
/*  669 */       postEventsForChanges()) {
/*  670 */       this._events.post(IVoucherDiscountLineItem.SET_VOUCHERSTATUSCODE, argVoucherStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVoucherStatusCode_noev(String argVoucherStatusCode) {
/*  677 */     boolean ev_postable = false;
/*      */     
/*  679 */     if ((getDAO_().getVoucherStatusCode() == null && argVoucherStatusCode != null) || (
/*  680 */       getDAO_().getVoucherStatusCode() != null && !getDAO_().getVoucherStatusCode().equals(argVoucherStatusCode))) {
/*  681 */       getDAO_().setVoucherStatusCode(argVoucherStatusCode);
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
/*      */   public String getTraceNumber() {
/*  693 */     return getDAO_().getTraceNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTraceNumber(String argTraceNumber) {
/*  701 */     if (setTraceNumber_noev(argTraceNumber) && 
/*  702 */       this._events != null && 
/*  703 */       postEventsForChanges()) {
/*  704 */       this._events.post(IVoucherDiscountLineItem.SET_TRACENUMBER, argTraceNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTraceNumber_noev(String argTraceNumber) {
/*  711 */     boolean ev_postable = false;
/*      */     
/*  713 */     if ((getDAO_().getTraceNumber() == null && argTraceNumber != null) || (
/*  714 */       getDAO_().getTraceNumber() != null && !getDAO_().getTraceNumber().equals(argTraceNumber))) {
/*  715 */       getDAO_().setTraceNumber(argTraceNumber);
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
/*      */   @Relationship(name = "Voucher")
/*      */   public IVoucher getVoucher() {
/*  728 */     return this._voucher;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void setVoucherImpl(IVoucher argVoucher) {
/*  733 */     if (argVoucher == null) {
/*      */       
/*  735 */       getDAO_().setSerialNumber(null);
/*  736 */       getDAO_().setVoucherTypeCode(null);
/*  737 */       if (this._voucher != null)
/*      */       {
/*  739 */         if (postEventsForChanges()) {
/*  740 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._voucher));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  745 */       getDAO_().setSerialNumber(argVoucher.getSerialNumber());
/*  746 */       getDAO_().setVoucherTypeCode(argVoucher.getVoucherTypeCode());
/*      */       
/*  748 */       if (postEventsForChanges()) {
/*  749 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argVoucher));
/*      */       }
/*      */     } 
/*      */     
/*  753 */     this._voucher = argVoucher;
/*  754 */     if (postEventsForChanges()) {
/*  755 */       this._events.post(IVoucherDiscountLineItem.SET_VOUCHER, argVoucher);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  761 */     if ("Voucher".equals(argFieldId)) {
/*  762 */       return getVoucher();
/*      */     }
/*  764 */     if ("VoucherDiscountLineItemExtension".equals(argFieldId)) {
/*  765 */       return this._myExtension;
/*      */     }
/*      */     
/*  768 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  774 */     if ("Voucher".equals(argFieldId)) {
/*  775 */       setVoucher((IVoucher)argValue);
/*      */     }
/*  777 */     else if ("VoucherDiscountLineItemExtension".equals(argFieldId)) {
/*  778 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  781 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  787 */     super.setDependencies(argPD, argEM);
/*  788 */     if (this._voucher != null) {
/*  789 */       ((IDataModelImpl)this._voucher).setDependencies(argPD, argEM);
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getVoucherDiscountLineItemExt() {
/*  794 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setVoucherDiscountLineItemExt(IDataModel argExt) {
/*  798 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  803 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  807 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  810 */     super.startTransaction();
/*      */     
/*  812 */     this._voucherSavepoint = this._voucher;
/*  813 */     if (this._voucher != null) {
/*  814 */       this._voucher.startTransaction();
/*      */     }
/*      */ 
/*      */     
/*  818 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/*  823 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/*  826 */     super.rollbackChanges();
/*      */     
/*  828 */     this._voucher = this._voucherSavepoint;
/*  829 */     this._voucherSavepoint = null;
/*  830 */     if (this._voucher != null) {
/*  831 */       this._voucher.rollbackChanges();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/*  838 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/*  841 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/*  844 */     super.commitTransaction();
/*      */     
/*  846 */     this._voucherSavepoint = this._voucher;
/*  847 */     if (this._voucher != null) {
/*  848 */       this._voucher.commitTransaction();
/*      */     }
/*      */ 
/*      */     
/*  852 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/*  857 */     argStream.defaultReadObject();
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
/*  874 */     this._track1 = argTrack;
/*      */   }
/*      */   public void setTrack2(EncString argTrack) {
/*  877 */     this._track2 = argTrack;
/*      */   }
/*      */   public void setTrack3(EncString argTrack) {
/*  880 */     this._track3 = argTrack;
/*      */   }
/*      */   public void setCid(EncString argValue) {
/*  883 */     this._cid = argValue;
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   public void setTrack1(String argTrack) {
/*  888 */     setTrack1(EncString.valueOf(argTrack));
/*      */   }
/*      */   @Deprecated
/*      */   public void setTrack2(String argTrack) {
/*  892 */     setTrack2(EncString.valueOf(argTrack));
/*      */   }
/*      */   @Deprecated
/*      */   public void setTrack3(String argTrack) {
/*  896 */     setTrack3(EncString.valueOf(argTrack));
/*      */   }
/*      */   @Deprecated
/*      */   public void setCid(String newValue) {
/*  900 */     setCid(EncString.valueOf(newValue));
/*      */   }
/*      */   
/*      */   public EncString getTrack1() {
/*  904 */     return this._track1;
/*      */   }
/*      */   public EncString getTrack2() {
/*  907 */     return this._track2;
/*      */   }
/*      */   public EncString getTrack3() {
/*  910 */     return this._track3;
/*      */   }
/*      */   public EncString getCid() {
/*  913 */     return this._cid;
/*      */   }
/*      */   
/*      */   public String getLineDescription() {
/*  917 */     IDiscount d = getLineItemDiscount();
/*  918 */     if (d == null) {
/*  919 */       return null;
/*      */     }
/*      */     
/*  922 */     return d.getDescription();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAmount() {
/*  928 */     BigDecimal amount = super.getAmount();
/*  929 */     if (!NumberUtils.isZeroOrNull(amount)) {
/*  930 */       return amount;
/*      */     }
/*  932 */     IVoucher l_voucher = getVoucher();
/*  933 */     if (l_voucher == null) {
/*  934 */       return amount;
/*      */     }
/*      */     
/*  937 */     return l_voucher.getFaceValueAmount();
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
/*  951 */     if (this._voucher == null) {
/*  952 */       return getEffectiveDateImpl();
/*      */     }
/*      */     
/*  955 */     return this._voucher.getEffectiveDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEffectiveDate(Date argEffectiveDate) {
/*  962 */     setEffectiveDateImpl(argEffectiveDate);
/*      */     
/*  964 */     if (this._voucher != null) {
/*  965 */       this._voucher.setEffectiveDate(argEffectiveDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getExpirationDate() {
/*  973 */     if (this._voucher == null) {
/*  974 */       return getExpirationDateImpl();
/*      */     }
/*      */     
/*  977 */     return this._voucher.getExpirationDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExpirationDate(Date argExpirationDate) {
/*  984 */     setExpirationDateImpl(argExpirationDate);
/*      */     
/*  986 */     if (this._voucher != null) {
/*  987 */       this._voucher.setExpirationDate(argExpirationDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getFaceValueAmount() {
/*  995 */     if (this._voucher == null) {
/*  996 */       return getFaceValueAmountImpl();
/*      */     }
/*      */     
/*  999 */     return this._voucher.getFaceValueAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFaceValueAmount(BigDecimal argFaceValueAmount) {
/* 1006 */     setFaceValueAmountImpl(argFaceValueAmount);
/*      */     
/* 1008 */     if (this._voucher != null) {
/* 1009 */       this._voucher.setFaceValueAmount(argFaceValueAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getIssueDatetimestamp() {
/* 1017 */     if (this._voucher == null) {
/* 1018 */       return getIssueDatetimestampImpl();
/*      */     }
/*      */     
/* 1021 */     return this._voucher.getIssueDatetimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIssueDatetimestamp(Date argIssueDatetimestamp) {
/* 1028 */     setIssueDatetimestampImpl(argIssueDatetimestamp);
/*      */     
/* 1030 */     if (this._voucher != null) {
/* 1031 */       this._voucher.setIssueDatetimestamp(argIssueDatetimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getIssueTypeCode() {
/* 1039 */     if (this._voucher == null) {
/* 1040 */       return getIssueTypeCodeImpl();
/*      */     }
/*      */     
/* 1043 */     return this._voucher.getIssueTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIssueTypeCode(String argIssueTypeCode) {
/* 1050 */     setIssueTypeCodeImpl(argIssueTypeCode);
/*      */     
/* 1052 */     if (this._voucher != null) {
/* 1053 */       this._voucher.setIssueTypeCode(argIssueTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getUnspentBalanceAmount() {
/* 1061 */     if (this._voucher == null) {
/* 1062 */       return getUnspentBalanceAmountImpl();
/*      */     }
/*      */     
/* 1065 */     return this._voucher.getUnspentBalanceAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUnspentBalanceAmount(BigDecimal argUnspentBalanceAmount) {
/* 1072 */     setUnspentBalanceAmountImpl(argUnspentBalanceAmount);
/*      */     
/* 1074 */     if (this._voucher != null) {
/* 1075 */       this._voucher.setUnspentBalanceAmount(argUnspentBalanceAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getVoucherStatusCode() {
/* 1083 */     if (this._voucher == null) {
/* 1084 */       return getVoucherStatusCodeImpl();
/*      */     }
/*      */     
/* 1087 */     return this._voucher.getVoucherStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVoucherStatusCode(String argVoucherStatusCode) {
/* 1094 */     setVoucherStatusCodeImpl(argVoucherStatusCode);
/*      */     
/* 1096 */     if (this._voucher != null) {
/* 1097 */       this._voucher.setVoucherStatusCode(argVoucherStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVoucher(IVoucher argVoucher) {
/* 1105 */     setVoucherImpl(argVoucher);
/*      */     
/* 1107 */     if (argVoucher != null) {
/* 1108 */       setEffectiveDate(argVoucher.getEffectiveDate());
/* 1109 */       setExpirationDate(argVoucher.getExpirationDate());
/* 1110 */       setFaceValueAmount(argVoucher.getFaceValueAmount());
/* 1111 */       setIssueDatetimestamp(argVoucher.getIssueDatetimestamp());
/* 1112 */       setIssueTypeCode(argVoucher.getIssueTypeCode());
/* 1113 */       setUnspentBalanceAmount(argVoucher.getUnspentBalanceAmount());
/* 1114 */       setVoucherStatusCode(argVoucher.getVoucherStatusCode());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAuthorizationToken(String argAuthorizationToken) {}
/*      */ 
/*      */   
/*      */   public String getAuthorizationToken() {
/* 1123 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTransactionReferenceData(String argTransactionReferenceData) {}
/*      */ 
/*      */   
/*      */   public String getTransactionReferenceData() {
/* 1131 */     return null;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\VoucherDiscountLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */