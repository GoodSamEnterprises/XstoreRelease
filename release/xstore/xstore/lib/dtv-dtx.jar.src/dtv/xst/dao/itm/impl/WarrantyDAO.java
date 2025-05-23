/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.WarrantyId;
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
/*     */ public class WarrantyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 566191388L;
/*  23 */   private static final Logger _logger = Logger.getLogger(WarrantyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _warrantyNbr;
/*     */   private String _warrantyTypeCode;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
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
/*     */   private DtvDate _coveredItemPurchaseDate;
/*     */   private BigDecimal _coveredItemPurchasePrice;
/*     */   private String _coveredItemPurchaseLocation;
/*     */   
/*     */   public Long getOrganizationId() {
/*  58 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  62 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  63 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWarrantyNbr() {
/*  68 */     return this._warrantyNbr;
/*     */   }
/*     */   
/*     */   public void setWarrantyNbr(String argWarrantyNbr) {
/*  72 */     if (changed(argWarrantyNbr, this._warrantyNbr, "warrantyNbr")) {
/*  73 */       this._warrantyNbr = (argWarrantyNbr != null && MANAGE_CASE) ? argWarrantyNbr.toUpperCase() : argWarrantyNbr;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWarrantyTypeCode() {
/*  78 */     return this._warrantyTypeCode;
/*     */   }
/*     */   
/*     */   public void setWarrantyTypeCode(String argWarrantyTypeCode) {
/*  82 */     if (changed(argWarrantyTypeCode, this._warrantyTypeCode, "warrantyTypeCode")) {
/*  83 */       this._warrantyTypeCode = (argWarrantyTypeCode != null && MANAGE_CASE) ? argWarrantyTypeCode.toUpperCase() : argWarrantyTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  88 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  92 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  93 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  99 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 103 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 104 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 109 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 113 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 114 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 120 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 124 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 125 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWarrantyPlanId() {
/* 130 */     return this._warrantyPlanId;
/*     */   }
/*     */   
/*     */   public void setWarrantyPlanId(String argWarrantyPlanId) {
/* 134 */     if (changed(argWarrantyPlanId, this._warrantyPlanId, "warrantyPlanId")) {
/* 135 */       this._warrantyPlanId = argWarrantyPlanId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getWarrantyIssueDate() {
/* 140 */     return (Date)this._warrantyIssueDate;
/*     */   }
/*     */   
/*     */   public void setWarrantyIssueDate(Date argWarrantyIssueDate) {
/* 144 */     if (changed(argWarrantyIssueDate, this._warrantyIssueDate, "warrantyIssueDate")) {
/* 145 */       this._warrantyIssueDate = (argWarrantyIssueDate == null || argWarrantyIssueDate instanceof DtvDate) ? (DtvDate)argWarrantyIssueDate : new DtvDate(argWarrantyIssueDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getWarrantyExpirationDate() {
/* 151 */     return (Date)this._warrantyExpirationDate;
/*     */   }
/*     */   
/*     */   public void setWarrantyExpirationDate(Date argWarrantyExpirationDate) {
/* 155 */     if (changed(argWarrantyExpirationDate, this._warrantyExpirationDate, "warrantyExpirationDate")) {
/* 156 */       this._warrantyExpirationDate = (argWarrantyExpirationDate == null || argWarrantyExpirationDate instanceof DtvDate) ? (DtvDate)argWarrantyExpirationDate : new DtvDate(argWarrantyExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStatusCode() {
/* 162 */     return this._statusCode;
/*     */   }
/*     */   
/*     */   public void setStatusCode(String argStatusCode) {
/* 166 */     if (changed(argStatusCode, this._statusCode, "statusCode")) {
/* 167 */       this._statusCode = argStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPurchasePrice() {
/* 172 */     return this._purchasePrice;
/*     */   }
/*     */   
/*     */   public void setPurchasePrice(BigDecimal argPurchasePrice) {
/* 176 */     if (changed(argPurchasePrice, this._purchasePrice, "purchasePrice")) {
/* 177 */       this._purchasePrice = argPurchasePrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustomerId() {
/* 182 */     return this._customerId;
/*     */   }
/*     */   
/*     */   public void setCustomerId(String argCustomerId) {
/* 186 */     if (changed(argCustomerId, this._customerId, "customerId")) {
/* 187 */       this._customerId = argCustomerId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/* 192 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/* 196 */     if (changed(argPartyId, this._partyId, "partyId")) {
/* 197 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCertificateNbr() {
/* 202 */     return this._certificateNbr;
/*     */   }
/*     */   
/*     */   public void setCertificateNbr(String argCertificateNbr) {
/* 206 */     if (changed(argCertificateNbr, this._certificateNbr, "certificateNbr")) {
/* 207 */       this._certificateNbr = argCertificateNbr;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCertificateCompanyName() {
/* 212 */     return this._certificateCompanyName;
/*     */   }
/*     */   
/*     */   public void setCertificateCompanyName(String argCertificateCompanyName) {
/* 216 */     if (changed(argCertificateCompanyName, this._certificateCompanyName, "certificateCompanyName")) {
/* 217 */       this._certificateCompanyName = argCertificateCompanyName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWarrantyItemId() {
/* 222 */     return this._warrantyItemId;
/*     */   }
/*     */   
/*     */   public void setWarrantyItemId(String argWarrantyItemId) {
/* 226 */     if (changed(argWarrantyItemId, this._warrantyItemId, "warrantyItemId")) {
/* 227 */       this._warrantyItemId = argWarrantyItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getWarrantyLineBusinessDate() {
/* 232 */     return (Date)this._warrantyLineBusinessDate;
/*     */   }
/*     */   
/*     */   public void setWarrantyLineBusinessDate(Date argWarrantyLineBusinessDate) {
/* 236 */     if (changed(argWarrantyLineBusinessDate, this._warrantyLineBusinessDate, "warrantyLineBusinessDate")) {
/* 237 */       this._warrantyLineBusinessDate = (argWarrantyLineBusinessDate == null || argWarrantyLineBusinessDate instanceof DtvDate) ? (DtvDate)argWarrantyLineBusinessDate : new DtvDate(argWarrantyLineBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWarrantyLineRtlLocId() {
/* 243 */     return this._warrantyLineRtlLocId;
/*     */   }
/*     */   
/*     */   public void setWarrantyLineRtlLocId(Long argWarrantyLineRtlLocId) {
/* 247 */     if (changed(argWarrantyLineRtlLocId, this._warrantyLineRtlLocId, "warrantyLineRtlLocId")) {
/* 248 */       this._warrantyLineRtlLocId = argWarrantyLineRtlLocId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWarrantyLineWkstnId() {
/* 253 */     return this._warrantyLineWkstnId;
/*     */   }
/*     */   
/*     */   public void setWarrantyLineWkstnId(Long argWarrantyLineWkstnId) {
/* 257 */     if (changed(argWarrantyLineWkstnId, this._warrantyLineWkstnId, "warrantyLineWkstnId")) {
/* 258 */       this._warrantyLineWkstnId = argWarrantyLineWkstnId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWarrantyLineTransSeq() {
/* 263 */     return this._warrantyLineTransSeq;
/*     */   }
/*     */   
/*     */   public void setWarrantyLineTransSeq(Long argWarrantyLineTransSeq) {
/* 267 */     if (changed(argWarrantyLineTransSeq, this._warrantyLineTransSeq, "warrantyLineTransSeq")) {
/* 268 */       this._warrantyLineTransSeq = argWarrantyLineTransSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getWarrantyLineTransLineItemSeq() {
/* 273 */     return this._warrantyLineTransLineItemSeq;
/*     */   }
/*     */   
/*     */   public void setWarrantyLineTransLineItemSeq(Integer argWarrantyLineTransLineItemSeq) {
/* 277 */     if (changed(argWarrantyLineTransLineItemSeq, this._warrantyLineTransLineItemSeq, "warrantyLineTransLineItemSeq")) {
/* 278 */       this._warrantyLineTransLineItemSeq = argWarrantyLineTransLineItemSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCoveredItemId() {
/* 283 */     return this._coveredItemId;
/*     */   }
/*     */   
/*     */   public void setCoveredItemId(String argCoveredItemId) {
/* 287 */     if (changed(argCoveredItemId, this._coveredItemId, "coveredItemId")) {
/* 288 */       this._coveredItemId = argCoveredItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCoveredLineBusinessDate() {
/* 293 */     return (Date)this._coveredLineBusinessDate;
/*     */   }
/*     */   
/*     */   public void setCoveredLineBusinessDate(Date argCoveredLineBusinessDate) {
/* 297 */     if (changed(argCoveredLineBusinessDate, this._coveredLineBusinessDate, "coveredLineBusinessDate")) {
/* 298 */       this._coveredLineBusinessDate = (argCoveredLineBusinessDate == null || argCoveredLineBusinessDate instanceof DtvDate) ? (DtvDate)argCoveredLineBusinessDate : new DtvDate(argCoveredLineBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getCoveredLineRtlLocId() {
/* 304 */     return this._coveredLineRtlLocId;
/*     */   }
/*     */   
/*     */   public void setCoveredLineRtlLocId(Long argCoveredLineRtlLocId) {
/* 308 */     if (changed(argCoveredLineRtlLocId, this._coveredLineRtlLocId, "coveredLineRtlLocId")) {
/* 309 */       this._coveredLineRtlLocId = argCoveredLineRtlLocId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCoveredLineWkstnId() {
/* 314 */     return this._coveredLineWkstnId;
/*     */   }
/*     */   
/*     */   public void setCoveredLineWkstnId(Long argCoveredLineWkstnId) {
/* 318 */     if (changed(argCoveredLineWkstnId, this._coveredLineWkstnId, "coveredLineWkstnId")) {
/* 319 */       this._coveredLineWkstnId = argCoveredLineWkstnId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCoveredLineTransSeq() {
/* 324 */     return this._coveredLineTransSeq;
/*     */   }
/*     */   
/*     */   public void setCoveredLineTransSeq(Long argCoveredLineTransSeq) {
/* 328 */     if (changed(argCoveredLineTransSeq, this._coveredLineTransSeq, "coveredLineTransSeq")) {
/* 329 */       this._coveredLineTransSeq = argCoveredLineTransSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getCoveredLineTransLineItemSeq() {
/* 334 */     return this._coveredLineTransLineItemSeq;
/*     */   }
/*     */   
/*     */   public void setCoveredLineTransLineItemSeq(Integer argCoveredLineTransLineItemSeq) {
/* 338 */     if (changed(argCoveredLineTransLineItemSeq, this._coveredLineTransLineItemSeq, "coveredLineTransLineItemSeq")) {
/* 339 */       this._coveredLineTransLineItemSeq = argCoveredLineTransLineItemSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCoveredItemPurchaseDate() {
/* 344 */     return (Date)this._coveredItemPurchaseDate;
/*     */   }
/*     */   
/*     */   public void setCoveredItemPurchaseDate(Date argCoveredItemPurchaseDate) {
/* 348 */     if (changed(argCoveredItemPurchaseDate, this._coveredItemPurchaseDate, "coveredItemPurchaseDate")) {
/* 349 */       this._coveredItemPurchaseDate = (argCoveredItemPurchaseDate == null || argCoveredItemPurchaseDate instanceof DtvDate) ? (DtvDate)argCoveredItemPurchaseDate : new DtvDate(argCoveredItemPurchaseDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getCoveredItemPurchasePrice() {
/* 355 */     return this._coveredItemPurchasePrice;
/*     */   }
/*     */   
/*     */   public void setCoveredItemPurchasePrice(BigDecimal argCoveredItemPurchasePrice) {
/* 359 */     if (changed(argCoveredItemPurchasePrice, this._coveredItemPurchasePrice, "coveredItemPurchasePrice")) {
/* 360 */       this._coveredItemPurchasePrice = argCoveredItemPurchasePrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCoveredItemPurchaseLocation() {
/* 365 */     return this._coveredItemPurchaseLocation;
/*     */   }
/*     */   
/*     */   public void setCoveredItemPurchaseLocation(String argCoveredItemPurchaseLocation) {
/* 369 */     if (changed(argCoveredItemPurchaseLocation, this._coveredItemPurchaseLocation, "coveredItemPurchaseLocation")) {
/* 370 */       this._coveredItemPurchaseLocation = argCoveredItemPurchaseLocation;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 377 */     StringBuilder buf = new StringBuilder(512);
/* 378 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 379 */     if (getOrganizationId() != null) {
/* 380 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 382 */     if (getWarrantyNbr() != null) {
/* 383 */       buf.append("warrantyNbr").append("=").append(getWarrantyNbr()).append(" ");
/*     */     }
/* 385 */     if (getWarrantyTypeCode() != null) {
/* 386 */       buf.append("warrantyTypeCode").append("=").append(getWarrantyTypeCode()).append(" ");
/*     */     }
/* 388 */     if (getCreateDate() != null) {
/* 389 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 391 */     if (getCreateUserId() != null) {
/* 392 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 394 */     if (getUpdateDate() != null) {
/* 395 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 397 */     if (getUpdateUserId() != null) {
/* 398 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 400 */     if (getWarrantyPlanId() != null) {
/* 401 */       buf.append("warrantyPlanId").append("=").append(getWarrantyPlanId()).append(" ");
/*     */     }
/* 403 */     if (getWarrantyIssueDate() != null) {
/* 404 */       buf.append("warrantyIssueDate").append("=").append(getWarrantyIssueDate()).append(" ");
/*     */     }
/* 406 */     if (getWarrantyExpirationDate() != null) {
/* 407 */       buf.append("warrantyExpirationDate").append("=").append(getWarrantyExpirationDate()).append(" ");
/*     */     }
/* 409 */     if (getStatusCode() != null) {
/* 410 */       buf.append("statusCode").append("=").append(getStatusCode()).append(" ");
/*     */     }
/* 412 */     if (getPurchasePrice() != null) {
/* 413 */       buf.append("purchasePrice").append("=").append(getPurchasePrice()).append(" ");
/*     */     }
/* 415 */     if (getCustomerId() != null) {
/* 416 */       buf.append("customerId").append("=").append(getCustomerId()).append(" ");
/*     */     }
/* 418 */     if (getPartyId() != null) {
/* 419 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 421 */     if (getCertificateNbr() != null) {
/* 422 */       buf.append("certificateNbr").append("=").append(getCertificateNbr()).append(" ");
/*     */     }
/* 424 */     if (getCertificateCompanyName() != null) {
/* 425 */       buf.append("certificateCompanyName").append("=").append(getCertificateCompanyName()).append(" ");
/*     */     }
/* 427 */     if (getWarrantyItemId() != null) {
/* 428 */       buf.append("warrantyItemId").append("=").append(getWarrantyItemId()).append(" ");
/*     */     }
/* 430 */     if (getWarrantyLineBusinessDate() != null) {
/* 431 */       buf.append("warrantyLineBusinessDate").append("=").append(getWarrantyLineBusinessDate()).append(" ");
/*     */     }
/* 433 */     if (getWarrantyLineRtlLocId() != null) {
/* 434 */       buf.append("warrantyLineRtlLocId").append("=").append(getWarrantyLineRtlLocId()).append(" ");
/*     */     }
/* 436 */     if (getWarrantyLineWkstnId() != null) {
/* 437 */       buf.append("warrantyLineWkstnId").append("=").append(getWarrantyLineWkstnId()).append(" ");
/*     */     }
/* 439 */     if (getWarrantyLineTransSeq() != null) {
/* 440 */       buf.append("warrantyLineTransSeq").append("=").append(getWarrantyLineTransSeq()).append(" ");
/*     */     }
/* 442 */     if (getWarrantyLineTransLineItemSeq() != null) {
/* 443 */       buf.append("warrantyLineTransLineItemSeq").append("=").append(getWarrantyLineTransLineItemSeq()).append(" ");
/*     */     }
/* 445 */     if (getCoveredItemId() != null) {
/* 446 */       buf.append("coveredItemId").append("=").append(getCoveredItemId()).append(" ");
/*     */     }
/* 448 */     if (getCoveredLineBusinessDate() != null) {
/* 449 */       buf.append("coveredLineBusinessDate").append("=").append(getCoveredLineBusinessDate()).append(" ");
/*     */     }
/* 451 */     if (getCoveredLineRtlLocId() != null) {
/* 452 */       buf.append("coveredLineRtlLocId").append("=").append(getCoveredLineRtlLocId()).append(" ");
/*     */     }
/* 454 */     if (getCoveredLineWkstnId() != null) {
/* 455 */       buf.append("coveredLineWkstnId").append("=").append(getCoveredLineWkstnId()).append(" ");
/*     */     }
/* 457 */     if (getCoveredLineTransSeq() != null) {
/* 458 */       buf.append("coveredLineTransSeq").append("=").append(getCoveredLineTransSeq()).append(" ");
/*     */     }
/* 460 */     if (getCoveredLineTransLineItemSeq() != null) {
/* 461 */       buf.append("coveredLineTransLineItemSeq").append("=").append(getCoveredLineTransLineItemSeq()).append(" ");
/*     */     }
/* 463 */     if (getCoveredItemPurchaseDate() != null) {
/* 464 */       buf.append("coveredItemPurchaseDate").append("=").append(getCoveredItemPurchaseDate()).append(" ");
/*     */     }
/* 466 */     if (getCoveredItemPurchasePrice() != null) {
/* 467 */       buf.append("coveredItemPurchasePrice").append("=").append(getCoveredItemPurchasePrice()).append(" ");
/*     */     }
/* 469 */     if (getCoveredItemPurchaseLocation() != null) {
/* 470 */       buf.append("coveredItemPurchaseLocation").append("=").append(getCoveredItemPurchaseLocation()).append(" ");
/*     */     }
/*     */     
/* 473 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 477 */     WarrantyId id = new WarrantyId();
/* 478 */     id.setOrganizationId(getOrganizationId());
/* 479 */     id.setWarrantyNbr(getWarrantyNbr());
/* 480 */     id.setWarrantyTypeCode(getWarrantyTypeCode());
/* 481 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 485 */     setOrganizationId(((WarrantyId)argObjectId).getOrganizationId());
/* 486 */     setWarrantyNbr(((WarrantyId)argObjectId).getWarrantyNbr());
/* 487 */     setWarrantyTypeCode(((WarrantyId)argObjectId).getWarrantyTypeCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 491 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 495 */     StringBuilder buf = new StringBuilder(1550);
/* 496 */     buf.append("<").append("dao").append(" name=\"Warranty\" cmd=\"" + getObjectStateString() + "\">");
/* 497 */     getFieldsAsXml(buf);
/* 498 */     buf.append("</").append("dao").append(">");
/*     */     
/* 500 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 504 */     Map<String, String> values = super.getValues();
/* 505 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 506 */     if (this._warrantyNbr != null) values.put("WarrantyNbr", DaoUtils.getXmlSafeFieldValue(12, this._warrantyNbr)); 
/* 507 */     if (this._warrantyTypeCode != null) values.put("WarrantyTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._warrantyTypeCode)); 
/* 508 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 509 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 510 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 511 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 512 */     if (this._warrantyPlanId != null) values.put("WarrantyPlanId", DaoUtils.getXmlSafeFieldValue(12, this._warrantyPlanId)); 
/* 513 */     if (this._warrantyIssueDate != null) values.put("WarrantyIssueDate", DaoUtils.getXmlSafeFieldValue(91, this._warrantyIssueDate)); 
/* 514 */     if (this._warrantyExpirationDate != null) values.put("WarrantyExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._warrantyExpirationDate)); 
/* 515 */     if (this._statusCode != null) values.put("StatusCode", DaoUtils.getXmlSafeFieldValue(12, this._statusCode)); 
/* 516 */     if (this._purchasePrice != null) values.put("PurchasePrice", DaoUtils.getXmlSafeFieldValue(3, this._purchasePrice)); 
/* 517 */     if (this._customerId != null) values.put("CustomerId", DaoUtils.getXmlSafeFieldValue(12, this._customerId)); 
/* 518 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 519 */     if (this._certificateNbr != null) values.put("CertificateNbr", DaoUtils.getXmlSafeFieldValue(12, this._certificateNbr)); 
/* 520 */     if (this._certificateCompanyName != null) values.put("CertificateCompanyName", DaoUtils.getXmlSafeFieldValue(12, this._certificateCompanyName)); 
/* 521 */     if (this._warrantyItemId != null) values.put("WarrantyItemId", DaoUtils.getXmlSafeFieldValue(12, this._warrantyItemId)); 
/* 522 */     if (this._warrantyLineBusinessDate != null) values.put("WarrantyLineBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._warrantyLineBusinessDate)); 
/* 523 */     if (this._warrantyLineRtlLocId != null) values.put("WarrantyLineRtlLocId", DaoUtils.getXmlSafeFieldValue(-5, this._warrantyLineRtlLocId)); 
/* 524 */     if (this._warrantyLineWkstnId != null) values.put("WarrantyLineWkstnId", DaoUtils.getXmlSafeFieldValue(-5, this._warrantyLineWkstnId)); 
/* 525 */     if (this._warrantyLineTransSeq != null) values.put("WarrantyLineTransSeq", DaoUtils.getXmlSafeFieldValue(-5, this._warrantyLineTransSeq)); 
/* 526 */     if (this._warrantyLineTransLineItemSeq != null) values.put("WarrantyLineTransLineItemSeq", DaoUtils.getXmlSafeFieldValue(4, this._warrantyLineTransLineItemSeq)); 
/* 527 */     if (this._coveredItemId != null) values.put("CoveredItemId", DaoUtils.getXmlSafeFieldValue(12, this._coveredItemId)); 
/* 528 */     if (this._coveredLineBusinessDate != null) values.put("CoveredLineBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._coveredLineBusinessDate)); 
/* 529 */     if (this._coveredLineRtlLocId != null) values.put("CoveredLineRtlLocId", DaoUtils.getXmlSafeFieldValue(-5, this._coveredLineRtlLocId)); 
/* 530 */     if (this._coveredLineWkstnId != null) values.put("CoveredLineWkstnId", DaoUtils.getXmlSafeFieldValue(-5, this._coveredLineWkstnId)); 
/* 531 */     if (this._coveredLineTransSeq != null) values.put("CoveredLineTransSeq", DaoUtils.getXmlSafeFieldValue(-5, this._coveredLineTransSeq)); 
/* 532 */     if (this._coveredLineTransLineItemSeq != null) values.put("CoveredLineTransLineItemSeq", DaoUtils.getXmlSafeFieldValue(4, this._coveredLineTransLineItemSeq)); 
/* 533 */     if (this._coveredItemPurchaseDate != null) values.put("CoveredItemPurchaseDate", DaoUtils.getXmlSafeFieldValue(91, this._coveredItemPurchaseDate)); 
/* 534 */     if (this._coveredItemPurchasePrice != null) values.put("CoveredItemPurchasePrice", DaoUtils.getXmlSafeFieldValue(3, this._coveredItemPurchasePrice)); 
/* 535 */     if (this._coveredItemPurchaseLocation != null) values.put("CoveredItemPurchaseLocation", DaoUtils.getXmlSafeFieldValue(12, this._coveredItemPurchaseLocation)); 
/* 536 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 541 */     super.setValues(argValues);
/* 542 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 544 */       String fieldName = field.getKey();
/* 545 */       String fieldValue = field.getValue();
/* 546 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 550 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 551 */             setOrganizationId((Long)value);
/* 552 */           } catch (Exception ee) {
/* 553 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyNbr":
/*     */           try {
/* 559 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 560 */             setWarrantyNbr((String)value);
/* 561 */           } catch (Exception ee) {
/* 562 */             throw new DtxException("An exception occurred while calling setWarrantyNbr() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyTypeCode":
/*     */           try {
/* 568 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 569 */             setWarrantyTypeCode((String)value);
/* 570 */           } catch (Exception ee) {
/* 571 */             throw new DtxException("An exception occurred while calling setWarrantyTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 577 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 578 */             setCreateDate((Date)value);
/* 579 */           } catch (Exception ee) {
/* 580 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 586 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 587 */             setCreateUserId((String)value);
/* 588 */           } catch (Exception ee) {
/* 589 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 595 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 596 */             setUpdateDate((Date)value);
/* 597 */           } catch (Exception ee) {
/* 598 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 604 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 605 */             setUpdateUserId((String)value);
/* 606 */           } catch (Exception ee) {
/* 607 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyPlanId":
/*     */           try {
/* 613 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 614 */             setWarrantyPlanId((String)value);
/* 615 */           } catch (Exception ee) {
/* 616 */             throw new DtxException("An exception occurred while calling setWarrantyPlanId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyIssueDate":
/*     */           try {
/* 622 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 623 */             setWarrantyIssueDate((Date)value);
/* 624 */           } catch (Exception ee) {
/* 625 */             throw new DtxException("An exception occurred while calling setWarrantyIssueDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyExpirationDate":
/*     */           try {
/* 631 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 632 */             setWarrantyExpirationDate((Date)value);
/* 633 */           } catch (Exception ee) {
/* 634 */             throw new DtxException("An exception occurred while calling setWarrantyExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusCode":
/*     */           try {
/* 640 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 641 */             setStatusCode((String)value);
/* 642 */           } catch (Exception ee) {
/* 643 */             throw new DtxException("An exception occurred while calling setStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PurchasePrice":
/*     */           try {
/* 649 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 650 */             setPurchasePrice((BigDecimal)value);
/* 651 */           } catch (Exception ee) {
/* 652 */             throw new DtxException("An exception occurred while calling setPurchasePrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerId":
/*     */           try {
/* 658 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 659 */             setCustomerId((String)value);
/* 660 */           } catch (Exception ee) {
/* 661 */             throw new DtxException("An exception occurred while calling setCustomerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 667 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 668 */             setPartyId((Long)value);
/* 669 */           } catch (Exception ee) {
/* 670 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CertificateNbr":
/*     */           try {
/* 676 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 677 */             setCertificateNbr((String)value);
/* 678 */           } catch (Exception ee) {
/* 679 */             throw new DtxException("An exception occurred while calling setCertificateNbr() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CertificateCompanyName":
/*     */           try {
/* 685 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 686 */             setCertificateCompanyName((String)value);
/* 687 */           } catch (Exception ee) {
/* 688 */             throw new DtxException("An exception occurred while calling setCertificateCompanyName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyItemId":
/*     */           try {
/* 694 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 695 */             setWarrantyItemId((String)value);
/* 696 */           } catch (Exception ee) {
/* 697 */             throw new DtxException("An exception occurred while calling setWarrantyItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyLineBusinessDate":
/*     */           try {
/* 703 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 704 */             setWarrantyLineBusinessDate((Date)value);
/* 705 */           } catch (Exception ee) {
/* 706 */             throw new DtxException("An exception occurred while calling setWarrantyLineBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyLineRtlLocId":
/*     */           try {
/* 712 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 713 */             setWarrantyLineRtlLocId((Long)value);
/* 714 */           } catch (Exception ee) {
/* 715 */             throw new DtxException("An exception occurred while calling setWarrantyLineRtlLocId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyLineWkstnId":
/*     */           try {
/* 721 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 722 */             setWarrantyLineWkstnId((Long)value);
/* 723 */           } catch (Exception ee) {
/* 724 */             throw new DtxException("An exception occurred while calling setWarrantyLineWkstnId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyLineTransSeq":
/*     */           try {
/* 730 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 731 */             setWarrantyLineTransSeq((Long)value);
/* 732 */           } catch (Exception ee) {
/* 733 */             throw new DtxException("An exception occurred while calling setWarrantyLineTransSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyLineTransLineItemSeq":
/*     */           try {
/* 739 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 740 */             setWarrantyLineTransLineItemSeq((Integer)value);
/* 741 */           } catch (Exception ee) {
/* 742 */             throw new DtxException("An exception occurred while calling setWarrantyLineTransLineItemSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CoveredItemId":
/*     */           try {
/* 748 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 749 */             setCoveredItemId((String)value);
/* 750 */           } catch (Exception ee) {
/* 751 */             throw new DtxException("An exception occurred while calling setCoveredItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CoveredLineBusinessDate":
/*     */           try {
/* 757 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 758 */             setCoveredLineBusinessDate((Date)value);
/* 759 */           } catch (Exception ee) {
/* 760 */             throw new DtxException("An exception occurred while calling setCoveredLineBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CoveredLineRtlLocId":
/*     */           try {
/* 766 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 767 */             setCoveredLineRtlLocId((Long)value);
/* 768 */           } catch (Exception ee) {
/* 769 */             throw new DtxException("An exception occurred while calling setCoveredLineRtlLocId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CoveredLineWkstnId":
/*     */           try {
/* 775 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 776 */             setCoveredLineWkstnId((Long)value);
/* 777 */           } catch (Exception ee) {
/* 778 */             throw new DtxException("An exception occurred while calling setCoveredLineWkstnId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CoveredLineTransSeq":
/*     */           try {
/* 784 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 785 */             setCoveredLineTransSeq((Long)value);
/* 786 */           } catch (Exception ee) {
/* 787 */             throw new DtxException("An exception occurred while calling setCoveredLineTransSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CoveredLineTransLineItemSeq":
/*     */           try {
/* 793 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 794 */             setCoveredLineTransLineItemSeq((Integer)value);
/* 795 */           } catch (Exception ee) {
/* 796 */             throw new DtxException("An exception occurred while calling setCoveredLineTransLineItemSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CoveredItemPurchaseDate":
/*     */           try {
/* 802 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 803 */             setCoveredItemPurchaseDate((Date)value);
/* 804 */           } catch (Exception ee) {
/* 805 */             throw new DtxException("An exception occurred while calling setCoveredItemPurchaseDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CoveredItemPurchasePrice":
/*     */           try {
/* 811 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 812 */             setCoveredItemPurchasePrice((BigDecimal)value);
/* 813 */           } catch (Exception ee) {
/* 814 */             throw new DtxException("An exception occurred while calling setCoveredItemPurchasePrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CoveredItemPurchaseLocation":
/*     */           try {
/* 820 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 821 */             setCoveredItemPurchaseLocation((String)value);
/* 822 */           } catch (Exception ee) {
/* 823 */             throw new DtxException("An exception occurred while calling setCoveredItemPurchaseLocation() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */