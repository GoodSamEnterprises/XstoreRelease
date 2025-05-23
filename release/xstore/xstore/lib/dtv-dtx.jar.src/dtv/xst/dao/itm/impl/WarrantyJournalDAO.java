/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.WarrantyJournalId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WarrantyJournalDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 2069047931L;
/*  23 */   private static final Logger _logger = Logger.getLogger(WarrantyJournalDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _warrantyNbr;
/*     */   private String _warrantyTypeCode;
/*     */   private Long _journalSequence;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _transBusinessDate;
/*     */   private Long _transRtlLocId;
/*     */   private Long _transWkstnId;
/*     */   private Long _transTransSeq;
/*     */   private String _warrantyPlanId;
/*     */   private DtvDate _warrantyIssueDate;
/*     */   private DtvDate _warrantyExpirationDate;
/*     */   private String _statusCode;
/*     */   private BigDecimal _purchasePrice;
/*     */   private String _customerId;
/*     */   private Long _partyId;
/*     */   private String _certificateNbr;
/*     */   private String _certificateCompanyName;
/*     */   private String _warrantyItemId;
/*     */   private DtvDate _warrantyLineBusinessDate;
/*     */   private Long _warrantyLineRtlLocId;
/*     */   private Long _warrantyLineWkstnId;
/*     */   private Long _warrantyLineTransSeq;
/*     */   private Integer _warrantyLineTransLineItemSeq;
/*     */   private String _coveredItemId;
/*     */   private DtvDate _coveredLineBusinessDate;
/*     */   private Long _coveredLineRtlLocId;
/*     */   private Long _coveredLineWkstnId;
/*     */   private Long _coveredLineTransSeq;
/*     */   private Integer _coveredLineTransLineItemSeq;
/*     */   
/*     */   public Long getOrganizationId() {
/*  62 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  66 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  67 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWarrantyNbr() {
/*  72 */     return this._warrantyNbr;
/*     */   }
/*     */   
/*     */   public void setWarrantyNbr(String argWarrantyNbr) {
/*  76 */     if (changed(argWarrantyNbr, this._warrantyNbr, "warrantyNbr")) {
/*  77 */       this._warrantyNbr = (argWarrantyNbr != null && MANAGE_CASE) ? argWarrantyNbr.toUpperCase() : argWarrantyNbr;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWarrantyTypeCode() {
/*  82 */     return this._warrantyTypeCode;
/*     */   }
/*     */   
/*     */   public void setWarrantyTypeCode(String argWarrantyTypeCode) {
/*  86 */     if (changed(argWarrantyTypeCode, this._warrantyTypeCode, "warrantyTypeCode")) {
/*  87 */       this._warrantyTypeCode = (argWarrantyTypeCode != null && MANAGE_CASE) ? argWarrantyTypeCode.toUpperCase() : argWarrantyTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getJournalSequence() {
/*  92 */     return this._journalSequence;
/*     */   }
/*     */   
/*     */   public void setJournalSequence(Long argJournalSequence) {
/*  96 */     if (changed(argJournalSequence, this._journalSequence, "journalSequence")) {
/*  97 */       this._journalSequence = argJournalSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 102 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 106 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 107 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 112 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 116 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 117 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 122 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 126 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 127 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 133 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 137 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 138 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 143 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 147 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 148 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 154 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 158 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 159 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getTransBusinessDate() {
/* 164 */     return (Date)this._transBusinessDate;
/*     */   }
/*     */   
/*     */   public void setTransBusinessDate(Date argTransBusinessDate) {
/* 168 */     if (changed(argTransBusinessDate, this._transBusinessDate, "transBusinessDate")) {
/* 169 */       this._transBusinessDate = (argTransBusinessDate == null || argTransBusinessDate instanceof DtvDate) ? (DtvDate)argTransBusinessDate : new DtvDate(argTransBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransRtlLocId() {
/* 175 */     return this._transRtlLocId;
/*     */   }
/*     */   
/*     */   public void setTransRtlLocId(Long argTransRtlLocId) {
/* 179 */     if (changed(argTransRtlLocId, this._transRtlLocId, "transRtlLocId")) {
/* 180 */       this._transRtlLocId = argTransRtlLocId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransWkstnId() {
/* 185 */     return this._transWkstnId;
/*     */   }
/*     */   
/*     */   public void setTransWkstnId(Long argTransWkstnId) {
/* 189 */     if (changed(argTransWkstnId, this._transWkstnId, "transWkstnId")) {
/* 190 */       this._transWkstnId = argTransWkstnId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransTransSeq() {
/* 195 */     return this._transTransSeq;
/*     */   }
/*     */   
/*     */   public void setTransTransSeq(Long argTransTransSeq) {
/* 199 */     if (changed(argTransTransSeq, this._transTransSeq, "transTransSeq")) {
/* 200 */       this._transTransSeq = argTransTransSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWarrantyPlanId() {
/* 205 */     return this._warrantyPlanId;
/*     */   }
/*     */   
/*     */   public void setWarrantyPlanId(String argWarrantyPlanId) {
/* 209 */     if (changed(argWarrantyPlanId, this._warrantyPlanId, "warrantyPlanId")) {
/* 210 */       this._warrantyPlanId = argWarrantyPlanId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getWarrantyIssueDate() {
/* 215 */     return (Date)this._warrantyIssueDate;
/*     */   }
/*     */   
/*     */   public void setWarrantyIssueDate(Date argWarrantyIssueDate) {
/* 219 */     if (changed(argWarrantyIssueDate, this._warrantyIssueDate, "warrantyIssueDate")) {
/* 220 */       this._warrantyIssueDate = (argWarrantyIssueDate == null || argWarrantyIssueDate instanceof DtvDate) ? (DtvDate)argWarrantyIssueDate : new DtvDate(argWarrantyIssueDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getWarrantyExpirationDate() {
/* 226 */     return (Date)this._warrantyExpirationDate;
/*     */   }
/*     */   
/*     */   public void setWarrantyExpirationDate(Date argWarrantyExpirationDate) {
/* 230 */     if (changed(argWarrantyExpirationDate, this._warrantyExpirationDate, "warrantyExpirationDate")) {
/* 231 */       this._warrantyExpirationDate = (argWarrantyExpirationDate == null || argWarrantyExpirationDate instanceof DtvDate) ? (DtvDate)argWarrantyExpirationDate : new DtvDate(argWarrantyExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStatusCode() {
/* 237 */     return this._statusCode;
/*     */   }
/*     */   
/*     */   public void setStatusCode(String argStatusCode) {
/* 241 */     if (changed(argStatusCode, this._statusCode, "statusCode")) {
/* 242 */       this._statusCode = argStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPurchasePrice() {
/* 247 */     return this._purchasePrice;
/*     */   }
/*     */   
/*     */   public void setPurchasePrice(BigDecimal argPurchasePrice) {
/* 251 */     if (changed(argPurchasePrice, this._purchasePrice, "purchasePrice")) {
/* 252 */       this._purchasePrice = argPurchasePrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustomerId() {
/* 257 */     return this._customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(String argCustomerId) {
/* 261 */     if (changed(argCustomerId, this._customerId, "customerId")) {
/* 262 */       this._customerId = argCustomerId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/* 267 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/* 271 */     if (changed(argPartyId, this._partyId, "partyId")) {
/* 272 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCertificateNbr() {
/* 277 */     return this._certificateNbr;
/*     */   }
/*     */   
/*     */   public void setCertificateNbr(String argCertificateNbr) {
/* 281 */     if (changed(argCertificateNbr, this._certificateNbr, "certificateNbr")) {
/* 282 */       this._certificateNbr = argCertificateNbr;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCertificateCompanyName() {
/* 287 */     return this._certificateCompanyName;
/*     */   }
/*     */   
/*     */   public void setCertificateCompanyName(String argCertificateCompanyName) {
/* 291 */     if (changed(argCertificateCompanyName, this._certificateCompanyName, "certificateCompanyName")) {
/* 292 */       this._certificateCompanyName = argCertificateCompanyName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWarrantyItemId() {
/* 297 */     return this._warrantyItemId;
/*     */   }
/*     */   
/*     */   public void setWarrantyItemId(String argWarrantyItemId) {
/* 301 */     if (changed(argWarrantyItemId, this._warrantyItemId, "warrantyItemId")) {
/* 302 */       this._warrantyItemId = argWarrantyItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getWarrantyLineBusinessDate() {
/* 307 */     return (Date)this._warrantyLineBusinessDate;
/*     */   }
/*     */   
/*     */   public void setWarrantyLineBusinessDate(Date argWarrantyLineBusinessDate) {
/* 311 */     if (changed(argWarrantyLineBusinessDate, this._warrantyLineBusinessDate, "warrantyLineBusinessDate")) {
/* 312 */       this._warrantyLineBusinessDate = (argWarrantyLineBusinessDate == null || argWarrantyLineBusinessDate instanceof DtvDate) ? (DtvDate)argWarrantyLineBusinessDate : new DtvDate(argWarrantyLineBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWarrantyLineRtlLocId() {
/* 318 */     return this._warrantyLineRtlLocId;
/*     */   }
/*     */   
/*     */   public void setWarrantyLineRtlLocId(Long argWarrantyLineRtlLocId) {
/* 322 */     if (changed(argWarrantyLineRtlLocId, this._warrantyLineRtlLocId, "warrantyLineRtlLocId")) {
/* 323 */       this._warrantyLineRtlLocId = argWarrantyLineRtlLocId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWarrantyLineWkstnId() {
/* 328 */     return this._warrantyLineWkstnId;
/*     */   }
/*     */   
/*     */   public void setWarrantyLineWkstnId(Long argWarrantyLineWkstnId) {
/* 332 */     if (changed(argWarrantyLineWkstnId, this._warrantyLineWkstnId, "warrantyLineWkstnId")) {
/* 333 */       this._warrantyLineWkstnId = argWarrantyLineWkstnId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWarrantyLineTransSeq() {
/* 338 */     return this._warrantyLineTransSeq;
/*     */   }
/*     */   
/*     */   public void setWarrantyLineTransSeq(Long argWarrantyLineTransSeq) {
/* 342 */     if (changed(argWarrantyLineTransSeq, this._warrantyLineTransSeq, "warrantyLineTransSeq")) {
/* 343 */       this._warrantyLineTransSeq = argWarrantyLineTransSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getWarrantyLineTransLineItemSeq() {
/* 348 */     return this._warrantyLineTransLineItemSeq;
/*     */   }
/*     */   
/*     */   public void setWarrantyLineTransLineItemSeq(Integer argWarrantyLineTransLineItemSeq) {
/* 352 */     if (changed(argWarrantyLineTransLineItemSeq, this._warrantyLineTransLineItemSeq, "warrantyLineTransLineItemSeq")) {
/* 353 */       this._warrantyLineTransLineItemSeq = argWarrantyLineTransLineItemSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCoveredItemId() {
/* 358 */     return this._coveredItemId;
/*     */   }
/*     */   
/*     */   public void setCoveredItemId(String argCoveredItemId) {
/* 362 */     if (changed(argCoveredItemId, this._coveredItemId, "coveredItemId")) {
/* 363 */       this._coveredItemId = argCoveredItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCoveredLineBusinessDate() {
/* 368 */     return (Date)this._coveredLineBusinessDate;
/*     */   }
/*     */   
/*     */   public void setCoveredLineBusinessDate(Date argCoveredLineBusinessDate) {
/* 372 */     if (changed(argCoveredLineBusinessDate, this._coveredLineBusinessDate, "coveredLineBusinessDate")) {
/* 373 */       this._coveredLineBusinessDate = (argCoveredLineBusinessDate == null || argCoveredLineBusinessDate instanceof DtvDate) ? (DtvDate)argCoveredLineBusinessDate : new DtvDate(argCoveredLineBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getCoveredLineRtlLocId() {
/* 379 */     return this._coveredLineRtlLocId;
/*     */   }
/*     */   
/*     */   public void setCoveredLineRtlLocId(Long argCoveredLineRtlLocId) {
/* 383 */     if (changed(argCoveredLineRtlLocId, this._coveredLineRtlLocId, "coveredLineRtlLocId")) {
/* 384 */       this._coveredLineRtlLocId = argCoveredLineRtlLocId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCoveredLineWkstnId() {
/* 389 */     return this._coveredLineWkstnId;
/*     */   }
/*     */   
/*     */   public void setCoveredLineWkstnId(Long argCoveredLineWkstnId) {
/* 393 */     if (changed(argCoveredLineWkstnId, this._coveredLineWkstnId, "coveredLineWkstnId")) {
/* 394 */       this._coveredLineWkstnId = argCoveredLineWkstnId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCoveredLineTransSeq() {
/* 399 */     return this._coveredLineTransSeq;
/*     */   }
/*     */   
/*     */   public void setCoveredLineTransSeq(Long argCoveredLineTransSeq) {
/* 403 */     if (changed(argCoveredLineTransSeq, this._coveredLineTransSeq, "coveredLineTransSeq")) {
/* 404 */       this._coveredLineTransSeq = argCoveredLineTransSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getCoveredLineTransLineItemSeq() {
/* 409 */     return this._coveredLineTransLineItemSeq;
/*     */   }
/*     */   
/*     */   public void setCoveredLineTransLineItemSeq(Integer argCoveredLineTransLineItemSeq) {
/* 413 */     if (changed(argCoveredLineTransLineItemSeq, this._coveredLineTransLineItemSeq, "coveredLineTransLineItemSeq")) {
/* 414 */       this._coveredLineTransLineItemSeq = argCoveredLineTransLineItemSeq;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 421 */     StringBuilder buf = new StringBuilder(512);
/* 422 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 423 */     if (getOrganizationId() != null) {
/* 424 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 426 */     if (getWarrantyNbr() != null) {
/* 427 */       buf.append("warrantyNbr").append("=").append(getWarrantyNbr()).append(" ");
/*     */     }
/* 429 */     if (getWarrantyTypeCode() != null) {
/* 430 */       buf.append("warrantyTypeCode").append("=").append(getWarrantyTypeCode()).append(" ");
/*     */     }
/* 432 */     if (getJournalSequence() != null) {
/* 433 */       buf.append("journalSequence").append("=").append(getJournalSequence()).append(" ");
/*     */     }
/* 435 */     if (getOrgCode() != null) {
/* 436 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 438 */     if (getOrgValue() != null) {
/* 439 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 441 */     if (getCreateDate() != null) {
/* 442 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 444 */     if (getCreateUserId() != null) {
/* 445 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 447 */     if (getUpdateDate() != null) {
/* 448 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 450 */     if (getUpdateUserId() != null) {
/* 451 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 453 */     if (getTransBusinessDate() != null) {
/* 454 */       buf.append("transBusinessDate").append("=").append(getTransBusinessDate()).append(" ");
/*     */     }
/* 456 */     if (getTransRtlLocId() != null) {
/* 457 */       buf.append("transRtlLocId").append("=").append(getTransRtlLocId()).append(" ");
/*     */     }
/* 459 */     if (getTransWkstnId() != null) {
/* 460 */       buf.append("transWkstnId").append("=").append(getTransWkstnId()).append(" ");
/*     */     }
/* 462 */     if (getTransTransSeq() != null) {
/* 463 */       buf.append("transTransSeq").append("=").append(getTransTransSeq()).append(" ");
/*     */     }
/* 465 */     if (getWarrantyPlanId() != null) {
/* 466 */       buf.append("warrantyPlanId").append("=").append(getWarrantyPlanId()).append(" ");
/*     */     }
/* 468 */     if (getWarrantyIssueDate() != null) {
/* 469 */       buf.append("warrantyIssueDate").append("=").append(getWarrantyIssueDate()).append(" ");
/*     */     }
/* 471 */     if (getWarrantyExpirationDate() != null) {
/* 472 */       buf.append("warrantyExpirationDate").append("=").append(getWarrantyExpirationDate()).append(" ");
/*     */     }
/* 474 */     if (getStatusCode() != null) {
/* 475 */       buf.append("statusCode").append("=").append(getStatusCode()).append(" ");
/*     */     }
/* 477 */     if (getPurchasePrice() != null) {
/* 478 */       buf.append("purchasePrice").append("=").append(getPurchasePrice()).append(" ");
/*     */     }
/* 480 */     if (getCustomerId() != null) {
/* 481 */       buf.append("customerId").append("=").append(getCustomerId()).append(" ");
/*     */     }
/* 483 */     if (getPartyId() != null) {
/* 484 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 486 */     if (getCertificateNbr() != null) {
/* 487 */       buf.append("certificateNbr").append("=").append(getCertificateNbr()).append(" ");
/*     */     }
/* 489 */     if (getCertificateCompanyName() != null) {
/* 490 */       buf.append("certificateCompanyName").append("=").append(getCertificateCompanyName()).append(" ");
/*     */     }
/* 492 */     if (getWarrantyItemId() != null) {
/* 493 */       buf.append("warrantyItemId").append("=").append(getWarrantyItemId()).append(" ");
/*     */     }
/* 495 */     if (getWarrantyLineBusinessDate() != null) {
/* 496 */       buf.append("warrantyLineBusinessDate").append("=").append(getWarrantyLineBusinessDate()).append(" ");
/*     */     }
/* 498 */     if (getWarrantyLineRtlLocId() != null) {
/* 499 */       buf.append("warrantyLineRtlLocId").append("=").append(getWarrantyLineRtlLocId()).append(" ");
/*     */     }
/* 501 */     if (getWarrantyLineWkstnId() != null) {
/* 502 */       buf.append("warrantyLineWkstnId").append("=").append(getWarrantyLineWkstnId()).append(" ");
/*     */     }
/* 504 */     if (getWarrantyLineTransSeq() != null) {
/* 505 */       buf.append("warrantyLineTransSeq").append("=").append(getWarrantyLineTransSeq()).append(" ");
/*     */     }
/* 507 */     if (getWarrantyLineTransLineItemSeq() != null) {
/* 508 */       buf.append("warrantyLineTransLineItemSeq").append("=").append(getWarrantyLineTransLineItemSeq()).append(" ");
/*     */     }
/* 510 */     if (getCoveredItemId() != null) {
/* 511 */       buf.append("coveredItemId").append("=").append(getCoveredItemId()).append(" ");
/*     */     }
/* 513 */     if (getCoveredLineBusinessDate() != null) {
/* 514 */       buf.append("coveredLineBusinessDate").append("=").append(getCoveredLineBusinessDate()).append(" ");
/*     */     }
/* 516 */     if (getCoveredLineRtlLocId() != null) {
/* 517 */       buf.append("coveredLineRtlLocId").append("=").append(getCoveredLineRtlLocId()).append(" ");
/*     */     }
/* 519 */     if (getCoveredLineWkstnId() != null) {
/* 520 */       buf.append("coveredLineWkstnId").append("=").append(getCoveredLineWkstnId()).append(" ");
/*     */     }
/* 522 */     if (getCoveredLineTransSeq() != null) {
/* 523 */       buf.append("coveredLineTransSeq").append("=").append(getCoveredLineTransSeq()).append(" ");
/*     */     }
/* 525 */     if (getCoveredLineTransLineItemSeq() != null) {
/* 526 */       buf.append("coveredLineTransLineItemSeq").append("=").append(getCoveredLineTransLineItemSeq()).append(" ");
/*     */     }
/*     */     
/* 529 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 533 */     WarrantyJournalId id = new WarrantyJournalId();
/* 534 */     id.setOrganizationId(getOrganizationId());
/* 535 */     id.setWarrantyNbr(getWarrantyNbr());
/* 536 */     id.setWarrantyTypeCode(getWarrantyTypeCode());
/* 537 */     id.setJournalSequence(getJournalSequence());
/* 538 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 542 */     setOrganizationId(((WarrantyJournalId)argObjectId).getOrganizationId());
/* 543 */     setWarrantyNbr(((WarrantyJournalId)argObjectId).getWarrantyNbr());
/* 544 */     setWarrantyTypeCode(((WarrantyJournalId)argObjectId).getWarrantyTypeCode());
/* 545 */     setJournalSequence(((WarrantyJournalId)argObjectId).getJournalSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 549 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 553 */     StringBuilder buf = new StringBuilder(1750);
/* 554 */     buf.append("<").append("dao").append(" name=\"WarrantyJournal\" cmd=\"" + getObjectStateString() + "\">");
/* 555 */     getFieldsAsXml(buf);
/* 556 */     buf.append("</").append("dao").append(">");
/*     */     
/* 558 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 562 */     Map<String, String> values = super.getValues();
/* 563 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 564 */     if (this._warrantyNbr != null) values.put("WarrantyNbr", DaoUtils.getXmlSafeFieldValue(12, this._warrantyNbr)); 
/* 565 */     if (this._warrantyTypeCode != null) values.put("WarrantyTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._warrantyTypeCode)); 
/* 566 */     if (this._journalSequence != null) values.put("JournalSequence", DaoUtils.getXmlSafeFieldValue(-5, this._journalSequence)); 
/* 567 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 568 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 569 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 570 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 571 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 572 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 573 */     if (this._transBusinessDate != null) values.put("TransBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._transBusinessDate)); 
/* 574 */     if (this._transRtlLocId != null) values.put("TransRtlLocId", DaoUtils.getXmlSafeFieldValue(-5, this._transRtlLocId)); 
/* 575 */     if (this._transWkstnId != null) values.put("TransWkstnId", DaoUtils.getXmlSafeFieldValue(-5, this._transWkstnId)); 
/* 576 */     if (this._transTransSeq != null) values.put("TransTransSeq", DaoUtils.getXmlSafeFieldValue(-5, this._transTransSeq)); 
/* 577 */     if (this._warrantyPlanId != null) values.put("WarrantyPlanId", DaoUtils.getXmlSafeFieldValue(12, this._warrantyPlanId)); 
/* 578 */     if (this._warrantyIssueDate != null) values.put("WarrantyIssueDate", DaoUtils.getXmlSafeFieldValue(91, this._warrantyIssueDate)); 
/* 579 */     if (this._warrantyExpirationDate != null) values.put("WarrantyExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._warrantyExpirationDate)); 
/* 580 */     if (this._statusCode != null) values.put("StatusCode", DaoUtils.getXmlSafeFieldValue(12, this._statusCode)); 
/* 581 */     if (this._purchasePrice != null) values.put("PurchasePrice", DaoUtils.getXmlSafeFieldValue(3, this._purchasePrice)); 
/* 582 */     if (this._customerId != null) values.put("CustomerId", DaoUtils.getXmlSafeFieldValue(12, this._customerId)); 
/* 583 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 584 */     if (this._certificateNbr != null) values.put("CertificateNbr", DaoUtils.getXmlSafeFieldValue(12, this._certificateNbr)); 
/* 585 */     if (this._certificateCompanyName != null) values.put("CertificateCompanyName", DaoUtils.getXmlSafeFieldValue(12, this._certificateCompanyName)); 
/* 586 */     if (this._warrantyItemId != null) values.put("WarrantyItemId", DaoUtils.getXmlSafeFieldValue(12, this._warrantyItemId)); 
/* 587 */     if (this._warrantyLineBusinessDate != null) values.put("WarrantyLineBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._warrantyLineBusinessDate)); 
/* 588 */     if (this._warrantyLineRtlLocId != null) values.put("WarrantyLineRtlLocId", DaoUtils.getXmlSafeFieldValue(-5, this._warrantyLineRtlLocId)); 
/* 589 */     if (this._warrantyLineWkstnId != null) values.put("WarrantyLineWkstnId", DaoUtils.getXmlSafeFieldValue(-5, this._warrantyLineWkstnId)); 
/* 590 */     if (this._warrantyLineTransSeq != null) values.put("WarrantyLineTransSeq", DaoUtils.getXmlSafeFieldValue(-5, this._warrantyLineTransSeq)); 
/* 591 */     if (this._warrantyLineTransLineItemSeq != null) values.put("WarrantyLineTransLineItemSeq", DaoUtils.getXmlSafeFieldValue(4, this._warrantyLineTransLineItemSeq)); 
/* 592 */     if (this._coveredItemId != null) values.put("CoveredItemId", DaoUtils.getXmlSafeFieldValue(12, this._coveredItemId)); 
/* 593 */     if (this._coveredLineBusinessDate != null) values.put("CoveredLineBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._coveredLineBusinessDate)); 
/* 594 */     if (this._coveredLineRtlLocId != null) values.put("CoveredLineRtlLocId", DaoUtils.getXmlSafeFieldValue(-5, this._coveredLineRtlLocId)); 
/* 595 */     if (this._coveredLineWkstnId != null) values.put("CoveredLineWkstnId", DaoUtils.getXmlSafeFieldValue(-5, this._coveredLineWkstnId)); 
/* 596 */     if (this._coveredLineTransSeq != null) values.put("CoveredLineTransSeq", DaoUtils.getXmlSafeFieldValue(-5, this._coveredLineTransSeq)); 
/* 597 */     if (this._coveredLineTransLineItemSeq != null) values.put("CoveredLineTransLineItemSeq", DaoUtils.getXmlSafeFieldValue(4, this._coveredLineTransLineItemSeq)); 
/* 598 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 603 */     super.setValues(argValues);
/* 604 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 606 */       String fieldName = field.getKey();
/* 607 */       String fieldValue = field.getValue();
/* 608 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 612 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 613 */             setOrganizationId((Long)value);
/* 614 */           } catch (Exception ee) {
/* 615 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyNbr":
/*     */           try {
/* 621 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 622 */             setWarrantyNbr((String)value);
/* 623 */           } catch (Exception ee) {
/* 624 */             throw new DtxException("An exception occurred while calling setWarrantyNbr() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyTypeCode":
/*     */           try {
/* 630 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 631 */             setWarrantyTypeCode((String)value);
/* 632 */           } catch (Exception ee) {
/* 633 */             throw new DtxException("An exception occurred while calling setWarrantyTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "JournalSequence":
/*     */           try {
/* 639 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 640 */             setJournalSequence((Long)value);
/* 641 */           } catch (Exception ee) {
/* 642 */             throw new DtxException("An exception occurred while calling setJournalSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 648 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 649 */             setOrgCode((String)value);
/* 650 */           } catch (Exception ee) {
/* 651 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 657 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 658 */             setOrgValue((String)value);
/* 659 */           } catch (Exception ee) {
/* 660 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 666 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 667 */             setCreateDate((Date)value);
/* 668 */           } catch (Exception ee) {
/* 669 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 675 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 676 */             setCreateUserId((String)value);
/* 677 */           } catch (Exception ee) {
/* 678 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 684 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 685 */             setUpdateDate((Date)value);
/* 686 */           } catch (Exception ee) {
/* 687 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 693 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 694 */             setUpdateUserId((String)value);
/* 695 */           } catch (Exception ee) {
/* 696 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransBusinessDate":
/*     */           try {
/* 702 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 703 */             setTransBusinessDate((Date)value);
/* 704 */           } catch (Exception ee) {
/* 705 */             throw new DtxException("An exception occurred while calling setTransBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransRtlLocId":
/*     */           try {
/* 711 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 712 */             setTransRtlLocId((Long)value);
/* 713 */           } catch (Exception ee) {
/* 714 */             throw new DtxException("An exception occurred while calling setTransRtlLocId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransWkstnId":
/*     */           try {
/* 720 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 721 */             setTransWkstnId((Long)value);
/* 722 */           } catch (Exception ee) {
/* 723 */             throw new DtxException("An exception occurred while calling setTransWkstnId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransTransSeq":
/*     */           try {
/* 729 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 730 */             setTransTransSeq((Long)value);
/* 731 */           } catch (Exception ee) {
/* 732 */             throw new DtxException("An exception occurred while calling setTransTransSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyPlanId":
/*     */           try {
/* 738 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 739 */             setWarrantyPlanId((String)value);
/* 740 */           } catch (Exception ee) {
/* 741 */             throw new DtxException("An exception occurred while calling setWarrantyPlanId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyIssueDate":
/*     */           try {
/* 747 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 748 */             setWarrantyIssueDate((Date)value);
/* 749 */           } catch (Exception ee) {
/* 750 */             throw new DtxException("An exception occurred while calling setWarrantyIssueDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyExpirationDate":
/*     */           try {
/* 756 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 757 */             setWarrantyExpirationDate((Date)value);
/* 758 */           } catch (Exception ee) {
/* 759 */             throw new DtxException("An exception occurred while calling setWarrantyExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusCode":
/*     */           try {
/* 765 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 766 */             setStatusCode((String)value);
/* 767 */           } catch (Exception ee) {
/* 768 */             throw new DtxException("An exception occurred while calling setStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PurchasePrice":
/*     */           try {
/* 774 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 775 */             setPurchasePrice((BigDecimal)value);
/* 776 */           } catch (Exception ee) {
/* 777 */             throw new DtxException("An exception occurred while calling setPurchasePrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerId":
/*     */           try {
/* 783 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 784 */             setCustomerId((String)value);
/* 785 */           } catch (Exception ee) {
/* 786 */             throw new DtxException("An exception occurred while calling setCustomerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 792 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 793 */             setPartyId((Long)value);
/* 794 */           } catch (Exception ee) {
/* 795 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CertificateNbr":
/*     */           try {
/* 801 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 802 */             setCertificateNbr((String)value);
/* 803 */           } catch (Exception ee) {
/* 804 */             throw new DtxException("An exception occurred while calling setCertificateNbr() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CertificateCompanyName":
/*     */           try {
/* 810 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 811 */             setCertificateCompanyName((String)value);
/* 812 */           } catch (Exception ee) {
/* 813 */             throw new DtxException("An exception occurred while calling setCertificateCompanyName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyItemId":
/*     */           try {
/* 819 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 820 */             setWarrantyItemId((String)value);
/* 821 */           } catch (Exception ee) {
/* 822 */             throw new DtxException("An exception occurred while calling setWarrantyItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyLineBusinessDate":
/*     */           try {
/* 828 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 829 */             setWarrantyLineBusinessDate((Date)value);
/* 830 */           } catch (Exception ee) {
/* 831 */             throw new DtxException("An exception occurred while calling setWarrantyLineBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyLineRtlLocId":
/*     */           try {
/* 837 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 838 */             setWarrantyLineRtlLocId((Long)value);
/* 839 */           } catch (Exception ee) {
/* 840 */             throw new DtxException("An exception occurred while calling setWarrantyLineRtlLocId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyLineWkstnId":
/*     */           try {
/* 846 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 847 */             setWarrantyLineWkstnId((Long)value);
/* 848 */           } catch (Exception ee) {
/* 849 */             throw new DtxException("An exception occurred while calling setWarrantyLineWkstnId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyLineTransSeq":
/*     */           try {
/* 855 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 856 */             setWarrantyLineTransSeq((Long)value);
/* 857 */           } catch (Exception ee) {
/* 858 */             throw new DtxException("An exception occurred while calling setWarrantyLineTransSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyLineTransLineItemSeq":
/*     */           try {
/* 864 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 865 */             setWarrantyLineTransLineItemSeq((Integer)value);
/* 866 */           } catch (Exception ee) {
/* 867 */             throw new DtxException("An exception occurred while calling setWarrantyLineTransLineItemSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CoveredItemId":
/*     */           try {
/* 873 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 874 */             setCoveredItemId((String)value);
/* 875 */           } catch (Exception ee) {
/* 876 */             throw new DtxException("An exception occurred while calling setCoveredItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CoveredLineBusinessDate":
/*     */           try {
/* 882 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 883 */             setCoveredLineBusinessDate((Date)value);
/* 884 */           } catch (Exception ee) {
/* 885 */             throw new DtxException("An exception occurred while calling setCoveredLineBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CoveredLineRtlLocId":
/*     */           try {
/* 891 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 892 */             setCoveredLineRtlLocId((Long)value);
/* 893 */           } catch (Exception ee) {
/* 894 */             throw new DtxException("An exception occurred while calling setCoveredLineRtlLocId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CoveredLineWkstnId":
/*     */           try {
/* 900 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 901 */             setCoveredLineWkstnId((Long)value);
/* 902 */           } catch (Exception ee) {
/* 903 */             throw new DtxException("An exception occurred while calling setCoveredLineWkstnId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CoveredLineTransSeq":
/*     */           try {
/* 909 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 910 */             setCoveredLineTransSeq((Long)value);
/* 911 */           } catch (Exception ee) {
/* 912 */             throw new DtxException("An exception occurred while calling setCoveredLineTransSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CoveredLineTransLineItemSeq":
/*     */           try {
/* 918 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 919 */             setCoveredLineTransLineItemSeq((Integer)value);
/* 920 */           } catch (Exception ee) {
/* 921 */             throw new DtxException("An exception occurred while calling setCoveredLineTransLineItemSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyJournalDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */