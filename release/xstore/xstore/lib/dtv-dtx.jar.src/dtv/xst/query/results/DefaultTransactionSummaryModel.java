/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.trn.PosTransactionId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultTransactionSummaryModel
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 8675309L;
/*     */   private long organizationId_;
/*     */   private Date businessDate_;
/*     */   private long retailLocationId_;
/*     */   private long workstationId_;
/*     */   private long transactionSequence_;
/*     */   private String transactionTypeCode_;
/*     */   private String tenderControlTranTypeCode_;
/*     */   private String sessionControlTranTypeCode_;
/*     */   private Date beginDatetimestamp_;
/*     */   private Date endDatetimestamp_;
/*     */   private String operatorId_;
/*     */   private String transactionStatusCode_;
/*     */   private BigDecimal total_;
/*     */   private String firstName_;
/*     */   private String lastName_;
/*     */   private boolean postVoid_;
/*     */   private String currencyId_;
/*     */   private Date _transactionDate;
/*     */   private IFormattable formattedTransactionTypeCode_;
/*     */   private IFormattable formattedTransactionStatusCode_;
/*     */   private PosTransactionId tranId_;
/*     */   
/*     */   @Deprecated
/*     */   public Date getBeginDatetimestamp() {
/*  57 */     return getBeginDateTimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBeginDateTimestamp() {
/*  66 */     return this.beginDatetimestamp_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/*  75 */     return this.businessDate_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCurrencyId() {
/*  84 */     return this.currencyId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerName() {
/*  93 */     return StringUtils.nonNull(this.firstName_) + " " + StringUtils.nonNull(this.lastName_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndDatetimestamp() {
/* 102 */     return this.endDatetimestamp_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOperatorId() {
/* 111 */     return this.operatorId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 120 */     return this.organizationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPostVoid() {
/* 129 */     return this.postVoid_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 138 */     return this.retailLocationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSessionControlTranTypeCode() {
/* 147 */     return this.sessionControlTranTypeCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTenderControlTranTypeCode() {
/* 156 */     return this.tenderControlTranTypeCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTotal() {
/* 165 */     return this.total_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getTransactionDate() {
/* 174 */     return this._transactionDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PosTransactionId getTransactionId() {
/* 183 */     return (PosTransactionId)getObjectId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 192 */     return this.transactionSequence_;
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
/*     */   public IFormattable getTransactionStatusCode() {
/* 204 */     if (getPostVoid()) {
/* 205 */       return FormattableFactory.getInstance()
/* 206 */         .getTranslatable("_dtv.pos.common.TransactionStatus.VOID");
/*     */     }
/* 208 */     return this.formattedTransactionStatusCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTransactionStatusCodeStringOnly() {
/* 217 */     return this.transactionStatusCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getTransactionTypeCode() {
/* 226 */     return this.formattedTransactionTypeCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTransactionTypeCodeStringOnly() {
/* 235 */     return this.transactionTypeCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 244 */     return this.workstationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setBeginDatetimestamp(Date argDate) {
/* 254 */     setBeginDateTimestamp(argDate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBeginDateTimestamp(Date argDate) {
/* 263 */     this.beginDatetimestamp_ = argDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argDate) {
/* 272 */     this.businessDate_ = argDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrencyId(String argCurrencyId) {
/* 281 */     this.currencyId_ = argCurrencyId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndDatetimestamp(Date argDate) {
/* 290 */     this.endDatetimestamp_ = argDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstName(String argName) {
/* 299 */     this.firstName_ = argName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormattedTransactionStatusCode(IFormattable argFormattedTransactionStatusCode) {
/* 308 */     this.formattedTransactionStatusCode_ = argFormattedTransactionStatusCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormattedTransactionTypeCode(IFormattable argFormattedTransactionTypeCode) {
/* 317 */     this.formattedTransactionTypeCode_ = argFormattedTransactionTypeCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastName(String argName) {
/* 326 */     this.lastName_ = argName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOperatorId(String argId) {
/* 335 */     this.operatorId_ = argId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(Long argId) {
/* 344 */     this.organizationId_ = argId.longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPostVoid(boolean argPostVoid) {
/* 353 */     this.postVoid_ = argPostVoid;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(Long argId) {
/* 362 */     this.retailLocationId_ = argId.longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSessionControlTypeCode(String argCode) {
/* 371 */     this.sessionControlTranTypeCode_ = argCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTenderControlTypeCode(String argCode) {
/* 380 */     this.tenderControlTranTypeCode_ = argCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTotal(BigDecimal argValue) {
/* 389 */     this.total_ = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionDate(Date argTransactionDate) {
/* 398 */     this._transactionDate = argTransactionDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(Long argSeq) {
/* 407 */     this.transactionSequence_ = argSeq.longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionStatusCode(String argValue) {
/* 416 */     this.transactionStatusCode_ = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionTypeCode(String argCode) {
/* 425 */     this.transactionTypeCode_ = argCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(Long argId) {
/* 434 */     this.workstationId_ = argId.longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 440 */     if (this.tranId_ == null) {
/* 441 */       this.tranId_ = new PosTransactionId();
/* 442 */       this.tranId_.setBusinessDate(this.businessDate_);
/* 443 */       this.tranId_.setRetailLocationId(Long.valueOf(this.retailLocationId_));
/* 444 */       this.tranId_.setWorkstationId(Long.valueOf(this.workstationId_));
/* 445 */       this.tranId_.setTransactionSequence(Long.valueOf(this.transactionSequence_));
/* 446 */       this.tranId_.setOrganizationId(Long.valueOf(this.organizationId_));
/*     */     } 
/* 448 */     return (IObjectId)this.tranId_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\DefaultTransactionSummaryModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */