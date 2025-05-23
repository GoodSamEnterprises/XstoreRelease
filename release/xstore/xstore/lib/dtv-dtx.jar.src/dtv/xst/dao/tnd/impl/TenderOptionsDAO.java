/*      */ package dtv.xst.dao.tnd.impl;
/*      */ 
/*      */ import dtv.data2.access.DaoUtils;
/*      */ import dtv.data2.access.IHasConfigElement;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.exception.DtxException;
/*      */ import dtv.data2.access.impl.AbstractDAOImpl;
/*      */ import dtv.util.DtvDate;
/*      */ import dtv.xst.dao.tnd.TenderOptionsId;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TenderOptionsDAO
/*      */   extends AbstractDAOImpl
/*      */   implements IHasConfigElement
/*      */ {
/*      */   private static final long serialVersionUID = -1928444662L;
/*   23 */   private static final Logger _logger = Logger.getLogger(TenderOptionsDAO.class);
/*      */   
/*      */   private Long _organizationId;
/*      */   private String _tenderId;
/*      */   private String _configElement;
/*      */   private DtvDate _createDate;
/*      */   private String _createUserId;
/*      */   private DtvDate _updateDate;
/*      */   private String _updateUserId;
/*   32 */   private Boolean _authExpirationDateRequired = Boolean.FALSE;
/*      */   private String _authMethodCode;
/*   34 */   private Boolean _authRequired = Boolean.FALSE;
/*   35 */   private Boolean _custAssociation = Boolean.FALSE;
/*      */   private String _custIdReqCode;
/*   37 */   private Boolean _customerSignatureRequired = Boolean.FALSE;
/*   38 */   private Boolean _dfltToAmountDue = Boolean.FALSE;
/*      */   private DtvDate _effectiveDate;
/*   40 */   private Boolean _endorsementRequired = Boolean.FALSE;
/*      */   private DtvDate _expirationDate;
/*   42 */   private Boolean _includeInTypeCount = Boolean.FALSE;
/*   43 */   private Boolean _magneticSwipeReaderRequired = Boolean.FALSE;
/*      */   private Integer _maxDaysForReturn;
/*      */   private Integer _minDaysForReturn;
/*      */   private BigDecimal _minimumDenominationAmount;
/*   47 */   private Boolean _openCashDrawerRequired = Boolean.FALSE;
/*   48 */   private Boolean _pinRequired = Boolean.FALSE;
/*   49 */   private Boolean _populateSystemCount = Boolean.FALSE;
/*   50 */   private Boolean _serialIdentificationNbrRequired = Boolean.FALSE;
/*      */   private String _unitCountCode;
/*   52 */   private Boolean _suggestDeposit = Boolean.FALSE;
/*      */   private BigDecimal _suggestedDepositThreshold;
/*      */   private BigDecimal _cashChangeLimit;
/*      */   private String _changeTenderId;
/*   56 */   private Boolean _overtenderOverridable = Boolean.FALSE;
/*   57 */   private Boolean _nonVoidable = Boolean.FALSE;
/*      */   private BigDecimal _closeCountDiscrepancyThreshold;
/*   59 */   private Boolean _cidMsrRequired = Boolean.FALSE;
/*   60 */   private Boolean _cidKeyedRequired = Boolean.FALSE;
/*   61 */   private Boolean _postalRequired = Boolean.FALSE;
/*   62 */   private Boolean _disallowSplitTender = Boolean.FALSE;
/*   63 */   private Boolean _postVoidOpenCashDrawerRequired = Boolean.FALSE;
/*      */   private String _reportingGroup;
/*   65 */   private Boolean _changeAllowedWhenForeign = Boolean.FALSE;
/*      */   private String _fiscalTenderId;
/*      */   private String _roundingMode;
/*   68 */   private Boolean _assignCashDrawerRequired = Boolean.FALSE;
/*   69 */   private Boolean _postVoidAssignCashDrawerRequired = Boolean.FALSE;
/*      */   
/*      */   public Long getOrganizationId() {
/*   72 */     return this._organizationId;
/*      */   }
/*      */   
/*      */   public void setOrganizationId(Long argOrganizationId) {
/*   76 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*   77 */       this._organizationId = argOrganizationId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getTenderId() {
/*   82 */     return this._tenderId;
/*      */   }
/*      */   
/*      */   public void setTenderId(String argTenderId) {
/*   86 */     if (changed(argTenderId, this._tenderId, "tenderId")) {
/*   87 */       this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getConfigElement() {
/*   92 */     return this._configElement;
/*      */   }
/*      */   
/*      */   public void setConfigElement(String argConfigElement) {
/*   96 */     if (changed(argConfigElement, this._configElement, "configElement")) {
/*   97 */       this._configElement = (argConfigElement != null && MANAGE_CASE) ? argConfigElement.toUpperCase() : argConfigElement;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getCreateDate() {
/*  102 */     return (Date)this._createDate;
/*      */   }
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  106 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  107 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  113 */     return this._createUserId;
/*      */   }
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  117 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  118 */       this._createUserId = argCreateUserId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getUpdateDate() {
/*  123 */     return (Date)this._updateDate;
/*      */   }
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  127 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  128 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  134 */     return this._updateUserId;
/*      */   }
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  138 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  139 */       this._updateUserId = argUpdateUserId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getAuthExpirationDateRequired() {
/*  144 */     return this._authExpirationDateRequired;
/*      */   }
/*      */   
/*      */   public void setAuthExpirationDateRequired(Boolean argAuthExpirationDateRequired) {
/*  148 */     if (changed(argAuthExpirationDateRequired, this._authExpirationDateRequired, "authExpirationDateRequired")) {
/*  149 */       this._authExpirationDateRequired = argAuthExpirationDateRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getAuthMethodCode() {
/*  154 */     return this._authMethodCode;
/*      */   }
/*      */   
/*      */   public void setAuthMethodCode(String argAuthMethodCode) {
/*  158 */     if (changed(argAuthMethodCode, this._authMethodCode, "authMethodCode")) {
/*  159 */       this._authMethodCode = argAuthMethodCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getAuthRequired() {
/*  164 */     return this._authRequired;
/*      */   }
/*      */   
/*      */   public void setAuthRequired(Boolean argAuthRequired) {
/*  168 */     if (changed(argAuthRequired, this._authRequired, "authRequired")) {
/*  169 */       this._authRequired = argAuthRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getCustAssociation() {
/*  174 */     return this._custAssociation;
/*      */   }
/*      */   
/*      */   public void setCustAssociation(Boolean argCustAssociation) {
/*  178 */     if (changed(argCustAssociation, this._custAssociation, "custAssociation")) {
/*  179 */       this._custAssociation = argCustAssociation;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getCustIdReqCode() {
/*  184 */     return this._custIdReqCode;
/*      */   }
/*      */   
/*      */   public void setCustIdReqCode(String argCustIdReqCode) {
/*  188 */     if (changed(argCustIdReqCode, this._custIdReqCode, "custIdReqCode")) {
/*  189 */       this._custIdReqCode = argCustIdReqCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getCustomerSignatureRequired() {
/*  194 */     return this._customerSignatureRequired;
/*      */   }
/*      */   
/*      */   public void setCustomerSignatureRequired(Boolean argCustomerSignatureRequired) {
/*  198 */     if (changed(argCustomerSignatureRequired, this._customerSignatureRequired, "customerSignatureRequired")) {
/*  199 */       this._customerSignatureRequired = argCustomerSignatureRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getDfltToAmountDue() {
/*  204 */     return this._dfltToAmountDue;
/*      */   }
/*      */   
/*      */   public void setDfltToAmountDue(Boolean argDfltToAmountDue) {
/*  208 */     if (changed(argDfltToAmountDue, this._dfltToAmountDue, "dfltToAmountDue")) {
/*  209 */       this._dfltToAmountDue = argDfltToAmountDue;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getEffectiveDate() {
/*  214 */     return (Date)this._effectiveDate;
/*      */   }
/*      */   
/*      */   public void setEffectiveDate(Date argEffectiveDate) {
/*  218 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/*  219 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public Boolean getEndorsementRequired() {
/*  225 */     return this._endorsementRequired;
/*      */   }
/*      */   
/*      */   public void setEndorsementRequired(Boolean argEndorsementRequired) {
/*  229 */     if (changed(argEndorsementRequired, this._endorsementRequired, "endorsementRequired")) {
/*  230 */       this._endorsementRequired = argEndorsementRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getExpirationDate() {
/*  235 */     return (Date)this._expirationDate;
/*      */   }
/*      */   
/*      */   public void setExpirationDate(Date argExpirationDate) {
/*  239 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/*  240 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public Boolean getIncludeInTypeCount() {
/*  246 */     return this._includeInTypeCount;
/*      */   }
/*      */   
/*      */   public void setIncludeInTypeCount(Boolean argIncludeInTypeCount) {
/*  250 */     if (changed(argIncludeInTypeCount, this._includeInTypeCount, "includeInTypeCount")) {
/*  251 */       this._includeInTypeCount = argIncludeInTypeCount;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getMagneticSwipeReaderRequired() {
/*  256 */     return this._magneticSwipeReaderRequired;
/*      */   }
/*      */   
/*      */   public void setMagneticSwipeReaderRequired(Boolean argMagneticSwipeReaderRequired) {
/*  260 */     if (changed(argMagneticSwipeReaderRequired, this._magneticSwipeReaderRequired, "magneticSwipeReaderRequired")) {
/*  261 */       this._magneticSwipeReaderRequired = argMagneticSwipeReaderRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public Integer getMaxDaysForReturn() {
/*  266 */     return this._maxDaysForReturn;
/*      */   }
/*      */   
/*      */   public void setMaxDaysForReturn(Integer argMaxDaysForReturn) {
/*  270 */     if (changed(argMaxDaysForReturn, this._maxDaysForReturn, "maxDaysForReturn")) {
/*  271 */       this._maxDaysForReturn = argMaxDaysForReturn;
/*      */     }
/*      */   }
/*      */   
/*      */   public Integer getMinDaysForReturn() {
/*  276 */     return this._minDaysForReturn;
/*      */   }
/*      */   
/*      */   public void setMinDaysForReturn(Integer argMinDaysForReturn) {
/*  280 */     if (changed(argMinDaysForReturn, this._minDaysForReturn, "minDaysForReturn")) {
/*  281 */       this._minDaysForReturn = argMinDaysForReturn;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getMinimumDenominationAmount() {
/*  286 */     return this._minimumDenominationAmount;
/*      */   }
/*      */   
/*      */   public void setMinimumDenominationAmount(BigDecimal argMinimumDenominationAmount) {
/*  290 */     if (changed(argMinimumDenominationAmount, this._minimumDenominationAmount, "minimumDenominationAmount")) {
/*  291 */       this._minimumDenominationAmount = argMinimumDenominationAmount;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getOpenCashDrawerRequired() {
/*  296 */     return this._openCashDrawerRequired;
/*      */   }
/*      */   
/*      */   public void setOpenCashDrawerRequired(Boolean argOpenCashDrawerRequired) {
/*  300 */     if (changed(argOpenCashDrawerRequired, this._openCashDrawerRequired, "openCashDrawerRequired")) {
/*  301 */       this._openCashDrawerRequired = argOpenCashDrawerRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getPinRequired() {
/*  306 */     return this._pinRequired;
/*      */   }
/*      */   
/*      */   public void setPinRequired(Boolean argPinRequired) {
/*  310 */     if (changed(argPinRequired, this._pinRequired, "pinRequired")) {
/*  311 */       this._pinRequired = argPinRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getPopulateSystemCount() {
/*  316 */     return this._populateSystemCount;
/*      */   }
/*      */   
/*      */   public void setPopulateSystemCount(Boolean argPopulateSystemCount) {
/*  320 */     if (changed(argPopulateSystemCount, this._populateSystemCount, "populateSystemCount")) {
/*  321 */       this._populateSystemCount = argPopulateSystemCount;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getSerialIdentificationNbrRequired() {
/*  326 */     return this._serialIdentificationNbrRequired;
/*      */   }
/*      */   
/*      */   public void setSerialIdentificationNbrRequired(Boolean argSerialIdentificationNbrRequired) {
/*  330 */     if (changed(argSerialIdentificationNbrRequired, this._serialIdentificationNbrRequired, "serialIdentificationNbrRequired")) {
/*  331 */       this._serialIdentificationNbrRequired = argSerialIdentificationNbrRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getUnitCountCode() {
/*  336 */     return this._unitCountCode;
/*      */   }
/*      */   
/*      */   public void setUnitCountCode(String argUnitCountCode) {
/*  340 */     if (changed(argUnitCountCode, this._unitCountCode, "unitCountCode")) {
/*  341 */       this._unitCountCode = argUnitCountCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getSuggestDeposit() {
/*  346 */     return this._suggestDeposit;
/*      */   }
/*      */   
/*      */   public void setSuggestDeposit(Boolean argSuggestDeposit) {
/*  350 */     if (changed(argSuggestDeposit, this._suggestDeposit, "suggestDeposit")) {
/*  351 */       this._suggestDeposit = argSuggestDeposit;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getSuggestedDepositThreshold() {
/*  356 */     return this._suggestedDepositThreshold;
/*      */   }
/*      */   
/*      */   public void setSuggestedDepositThreshold(BigDecimal argSuggestedDepositThreshold) {
/*  360 */     if (changed(argSuggestedDepositThreshold, this._suggestedDepositThreshold, "suggestedDepositThreshold")) {
/*  361 */       this._suggestedDepositThreshold = argSuggestedDepositThreshold;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getCashChangeLimit() {
/*  366 */     return this._cashChangeLimit;
/*      */   }
/*      */   
/*      */   public void setCashChangeLimit(BigDecimal argCashChangeLimit) {
/*  370 */     if (changed(argCashChangeLimit, this._cashChangeLimit, "cashChangeLimit")) {
/*  371 */       this._cashChangeLimit = argCashChangeLimit;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getChangeTenderId() {
/*  376 */     return this._changeTenderId;
/*      */   }
/*      */   
/*      */   public void setChangeTenderId(String argChangeTenderId) {
/*  380 */     if (changed(argChangeTenderId, this._changeTenderId, "changeTenderId")) {
/*  381 */       this._changeTenderId = argChangeTenderId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getOvertenderOverridable() {
/*  386 */     return this._overtenderOverridable;
/*      */   }
/*      */   
/*      */   public void setOvertenderOverridable(Boolean argOvertenderOverridable) {
/*  390 */     if (changed(argOvertenderOverridable, this._overtenderOverridable, "overtenderOverridable")) {
/*  391 */       this._overtenderOverridable = argOvertenderOverridable;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getNonVoidable() {
/*  396 */     return this._nonVoidable;
/*      */   }
/*      */   
/*      */   public void setNonVoidable(Boolean argNonVoidable) {
/*  400 */     if (changed(argNonVoidable, this._nonVoidable, "nonVoidable")) {
/*  401 */       this._nonVoidable = argNonVoidable;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getCloseCountDiscrepancyThreshold() {
/*  406 */     return this._closeCountDiscrepancyThreshold;
/*      */   }
/*      */   
/*      */   public void setCloseCountDiscrepancyThreshold(BigDecimal argCloseCountDiscrepancyThreshold) {
/*  410 */     if (changed(argCloseCountDiscrepancyThreshold, this._closeCountDiscrepancyThreshold, "closeCountDiscrepancyThreshold")) {
/*  411 */       this._closeCountDiscrepancyThreshold = argCloseCountDiscrepancyThreshold;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getCidMsrRequired() {
/*  416 */     return this._cidMsrRequired;
/*      */   }
/*      */   
/*      */   public void setCidMsrRequired(Boolean argCidMsrRequired) {
/*  420 */     if (changed(argCidMsrRequired, this._cidMsrRequired, "cidMsrRequired")) {
/*  421 */       this._cidMsrRequired = argCidMsrRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getCidKeyedRequired() {
/*  426 */     return this._cidKeyedRequired;
/*      */   }
/*      */   
/*      */   public void setCidKeyedRequired(Boolean argCidKeyedRequired) {
/*  430 */     if (changed(argCidKeyedRequired, this._cidKeyedRequired, "cidKeyedRequired")) {
/*  431 */       this._cidKeyedRequired = argCidKeyedRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getPostalRequired() {
/*  436 */     return this._postalRequired;
/*      */   }
/*      */   
/*      */   public void setPostalRequired(Boolean argPostalRequired) {
/*  440 */     if (changed(argPostalRequired, this._postalRequired, "postalRequired")) {
/*  441 */       this._postalRequired = argPostalRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getDisallowSplitTender() {
/*  446 */     return this._disallowSplitTender;
/*      */   }
/*      */   
/*      */   public void setDisallowSplitTender(Boolean argDisallowSplitTender) {
/*  450 */     if (changed(argDisallowSplitTender, this._disallowSplitTender, "disallowSplitTender")) {
/*  451 */       this._disallowSplitTender = argDisallowSplitTender;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getPostVoidOpenCashDrawerRequired() {
/*  456 */     return this._postVoidOpenCashDrawerRequired;
/*      */   }
/*      */   
/*      */   public void setPostVoidOpenCashDrawerRequired(Boolean argPostVoidOpenCashDrawerRequired) {
/*  460 */     if (changed(argPostVoidOpenCashDrawerRequired, this._postVoidOpenCashDrawerRequired, "postVoidOpenCashDrawerRequired")) {
/*  461 */       this._postVoidOpenCashDrawerRequired = argPostVoidOpenCashDrawerRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getReportingGroup() {
/*  466 */     return this._reportingGroup;
/*      */   }
/*      */   
/*      */   public void setReportingGroup(String argReportingGroup) {
/*  470 */     if (changed(argReportingGroup, this._reportingGroup, "reportingGroup")) {
/*  471 */       this._reportingGroup = argReportingGroup;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getChangeAllowedWhenForeign() {
/*  476 */     return this._changeAllowedWhenForeign;
/*      */   }
/*      */   
/*      */   public void setChangeAllowedWhenForeign(Boolean argChangeAllowedWhenForeign) {
/*  480 */     if (changed(argChangeAllowedWhenForeign, this._changeAllowedWhenForeign, "changeAllowedWhenForeign")) {
/*  481 */       this._changeAllowedWhenForeign = argChangeAllowedWhenForeign;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getFiscalTenderId() {
/*  486 */     return this._fiscalTenderId;
/*      */   }
/*      */   
/*      */   public void setFiscalTenderId(String argFiscalTenderId) {
/*  490 */     if (changed(argFiscalTenderId, this._fiscalTenderId, "fiscalTenderId")) {
/*  491 */       this._fiscalTenderId = argFiscalTenderId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getRoundingMode() {
/*  496 */     return this._roundingMode;
/*      */   }
/*      */   
/*      */   public void setRoundingMode(String argRoundingMode) {
/*  500 */     if (changed(argRoundingMode, this._roundingMode, "roundingMode")) {
/*  501 */       this._roundingMode = argRoundingMode;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getAssignCashDrawerRequired() {
/*  506 */     return this._assignCashDrawerRequired;
/*      */   }
/*      */   
/*      */   public void setAssignCashDrawerRequired(Boolean argAssignCashDrawerRequired) {
/*  510 */     if (changed(argAssignCashDrawerRequired, this._assignCashDrawerRequired, "assignCashDrawerRequired")) {
/*  511 */       this._assignCashDrawerRequired = argAssignCashDrawerRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getPostVoidAssignCashDrawerRequired() {
/*  516 */     return this._postVoidAssignCashDrawerRequired;
/*      */   }
/*      */   
/*      */   public void setPostVoidAssignCashDrawerRequired(Boolean argPostVoidAssignCashDrawerRequired) {
/*  520 */     if (changed(argPostVoidAssignCashDrawerRequired, this._postVoidAssignCashDrawerRequired, "postVoidAssignCashDrawerRequired")) {
/*  521 */       this._postVoidAssignCashDrawerRequired = argPostVoidAssignCashDrawerRequired;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  528 */     StringBuilder buf = new StringBuilder(512);
/*  529 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/*  530 */     if (getOrganizationId() != null) {
/*  531 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*      */     }
/*  533 */     if (getTenderId() != null) {
/*  534 */       buf.append("tenderId").append("=").append(getTenderId()).append(" ");
/*      */     }
/*  536 */     if (getConfigElement() != null) {
/*  537 */       buf.append("configElement").append("=").append(getConfigElement()).append(" ");
/*      */     }
/*  539 */     if (getCreateDate() != null) {
/*  540 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*      */     }
/*  542 */     if (getCreateUserId() != null) {
/*  543 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*      */     }
/*  545 */     if (getUpdateDate() != null) {
/*  546 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*      */     }
/*  548 */     if (getUpdateUserId() != null) {
/*  549 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*      */     }
/*  551 */     if (getAuthExpirationDateRequired() != null && getAuthExpirationDateRequired().booleanValue()) {
/*  552 */       buf.append("authExpirationDateRequired").append("=").append(getAuthExpirationDateRequired()).append(" ");
/*      */     }
/*  554 */     if (getAuthMethodCode() != null) {
/*  555 */       buf.append("authMethodCode").append("=").append(getAuthMethodCode()).append(" ");
/*      */     }
/*  557 */     if (getAuthRequired() != null && getAuthRequired().booleanValue()) {
/*  558 */       buf.append("authRequired").append("=").append(getAuthRequired()).append(" ");
/*      */     }
/*  560 */     if (getCustAssociation() != null && getCustAssociation().booleanValue()) {
/*  561 */       buf.append("custAssociation").append("=").append(getCustAssociation()).append(" ");
/*      */     }
/*  563 */     if (getCustIdReqCode() != null) {
/*  564 */       buf.append("custIdReqCode").append("=").append(getCustIdReqCode()).append(" ");
/*      */     }
/*  566 */     if (getCustomerSignatureRequired() != null && getCustomerSignatureRequired().booleanValue()) {
/*  567 */       buf.append("customerSignatureRequired").append("=").append(getCustomerSignatureRequired()).append(" ");
/*      */     }
/*  569 */     if (getDfltToAmountDue() != null && getDfltToAmountDue().booleanValue()) {
/*  570 */       buf.append("dfltToAmountDue").append("=").append(getDfltToAmountDue()).append(" ");
/*      */     }
/*  572 */     if (getEffectiveDate() != null) {
/*  573 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*      */     }
/*  575 */     if (getEndorsementRequired() != null && getEndorsementRequired().booleanValue()) {
/*  576 */       buf.append("endorsementRequired").append("=").append(getEndorsementRequired()).append(" ");
/*      */     }
/*  578 */     if (getExpirationDate() != null) {
/*  579 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*      */     }
/*  581 */     if (getIncludeInTypeCount() != null && getIncludeInTypeCount().booleanValue()) {
/*  582 */       buf.append("includeInTypeCount").append("=").append(getIncludeInTypeCount()).append(" ");
/*      */     }
/*  584 */     if (getMagneticSwipeReaderRequired() != null && getMagneticSwipeReaderRequired().booleanValue()) {
/*  585 */       buf.append("magneticSwipeReaderRequired").append("=").append(getMagneticSwipeReaderRequired()).append(" ");
/*      */     }
/*  587 */     if (getMaxDaysForReturn() != null) {
/*  588 */       buf.append("maxDaysForReturn").append("=").append(getMaxDaysForReturn()).append(" ");
/*      */     }
/*  590 */     if (getMinDaysForReturn() != null) {
/*  591 */       buf.append("minDaysForReturn").append("=").append(getMinDaysForReturn()).append(" ");
/*      */     }
/*  593 */     if (getMinimumDenominationAmount() != null) {
/*  594 */       buf.append("minimumDenominationAmount").append("=").append(getMinimumDenominationAmount()).append(" ");
/*      */     }
/*  596 */     if (getOpenCashDrawerRequired() != null && getOpenCashDrawerRequired().booleanValue()) {
/*  597 */       buf.append("openCashDrawerRequired").append("=").append(getOpenCashDrawerRequired()).append(" ");
/*      */     }
/*  599 */     if (getPinRequired() != null && getPinRequired().booleanValue()) {
/*  600 */       buf.append("pinRequired").append("=").append(getPinRequired()).append(" ");
/*      */     }
/*  602 */     if (getPopulateSystemCount() != null && getPopulateSystemCount().booleanValue()) {
/*  603 */       buf.append("populateSystemCount").append("=").append(getPopulateSystemCount()).append(" ");
/*      */     }
/*  605 */     if (getSerialIdentificationNbrRequired() != null && getSerialIdentificationNbrRequired().booleanValue()) {
/*  606 */       buf.append("serialIdentificationNbrRequired").append("=").append(getSerialIdentificationNbrRequired()).append(" ");
/*      */     }
/*  608 */     if (getUnitCountCode() != null) {
/*  609 */       buf.append("unitCountCode").append("=").append(getUnitCountCode()).append(" ");
/*      */     }
/*  611 */     if (getSuggestDeposit() != null && getSuggestDeposit().booleanValue()) {
/*  612 */       buf.append("suggestDeposit").append("=").append(getSuggestDeposit()).append(" ");
/*      */     }
/*  614 */     if (getSuggestedDepositThreshold() != null) {
/*  615 */       buf.append("suggestedDepositThreshold").append("=").append(getSuggestedDepositThreshold()).append(" ");
/*      */     }
/*  617 */     if (getCashChangeLimit() != null) {
/*  618 */       buf.append("cashChangeLimit").append("=").append(getCashChangeLimit()).append(" ");
/*      */     }
/*  620 */     if (getChangeTenderId() != null) {
/*  621 */       buf.append("changeTenderId").append("=").append(getChangeTenderId()).append(" ");
/*      */     }
/*  623 */     if (getOvertenderOverridable() != null && getOvertenderOverridable().booleanValue()) {
/*  624 */       buf.append("overtenderOverridable").append("=").append(getOvertenderOverridable()).append(" ");
/*      */     }
/*  626 */     if (getNonVoidable() != null && getNonVoidable().booleanValue()) {
/*  627 */       buf.append("nonVoidable").append("=").append(getNonVoidable()).append(" ");
/*      */     }
/*  629 */     if (getCloseCountDiscrepancyThreshold() != null) {
/*  630 */       buf.append("closeCountDiscrepancyThreshold").append("=").append(getCloseCountDiscrepancyThreshold()).append(" ");
/*      */     }
/*  632 */     if (getCidMsrRequired() != null && getCidMsrRequired().booleanValue()) {
/*  633 */       buf.append("cidMsrRequired").append("=").append(getCidMsrRequired()).append(" ");
/*      */     }
/*  635 */     if (getCidKeyedRequired() != null && getCidKeyedRequired().booleanValue()) {
/*  636 */       buf.append("cidKeyedRequired").append("=").append(getCidKeyedRequired()).append(" ");
/*      */     }
/*  638 */     if (getPostalRequired() != null && getPostalRequired().booleanValue()) {
/*  639 */       buf.append("postalRequired").append("=").append(getPostalRequired()).append(" ");
/*      */     }
/*  641 */     if (getDisallowSplitTender() != null && getDisallowSplitTender().booleanValue()) {
/*  642 */       buf.append("disallowSplitTender").append("=").append(getDisallowSplitTender()).append(" ");
/*      */     }
/*  644 */     if (getPostVoidOpenCashDrawerRequired() != null && getPostVoidOpenCashDrawerRequired().booleanValue()) {
/*  645 */       buf.append("postVoidOpenCashDrawerRequired").append("=").append(getPostVoidOpenCashDrawerRequired()).append(" ");
/*      */     }
/*  647 */     if (getReportingGroup() != null) {
/*  648 */       buf.append("reportingGroup").append("=").append(getReportingGroup()).append(" ");
/*      */     }
/*  650 */     if (getChangeAllowedWhenForeign() != null && getChangeAllowedWhenForeign().booleanValue()) {
/*  651 */       buf.append("changeAllowedWhenForeign").append("=").append(getChangeAllowedWhenForeign()).append(" ");
/*      */     }
/*  653 */     if (getFiscalTenderId() != null) {
/*  654 */       buf.append("fiscalTenderId").append("=").append(getFiscalTenderId()).append(" ");
/*      */     }
/*  656 */     if (getRoundingMode() != null) {
/*  657 */       buf.append("roundingMode").append("=").append(getRoundingMode()).append(" ");
/*      */     }
/*  659 */     if (getAssignCashDrawerRequired() != null && getAssignCashDrawerRequired().booleanValue()) {
/*  660 */       buf.append("assignCashDrawerRequired").append("=").append(getAssignCashDrawerRequired()).append(" ");
/*      */     }
/*  662 */     if (getPostVoidAssignCashDrawerRequired() != null && getPostVoidAssignCashDrawerRequired().booleanValue()) {
/*  663 */       buf.append("postVoidAssignCashDrawerRequired").append("=").append(getPostVoidAssignCashDrawerRequired()).append(" ");
/*      */     }
/*      */     
/*  666 */     return buf.toString();
/*      */   }
/*      */   
/*      */   public IObjectId getObjectId() {
/*  670 */     TenderOptionsId id = new TenderOptionsId();
/*  671 */     id.setOrganizationId(getOrganizationId());
/*  672 */     id.setTenderId(getTenderId());
/*  673 */     id.setConfigElement(getConfigElement());
/*  674 */     return (IObjectId)id;
/*      */   }
/*      */   
/*      */   public void setObjectId(IObjectId argObjectId) {
/*  678 */     setOrganizationId(((TenderOptionsId)argObjectId).getOrganizationId());
/*  679 */     setTenderId(((TenderOptionsId)argObjectId).getTenderId());
/*  680 */     setConfigElement(((TenderOptionsId)argObjectId).getConfigElement());
/*      */   }
/*      */   
/*      */   public String getImplementingClass() {
/*  684 */     return null;
/*      */   }
/*      */   
/*      */   public String toXmlString() {
/*  688 */     StringBuilder buf = new StringBuilder(2250);
/*  689 */     buf.append("<").append("dao").append(" name=\"TenderOptions\" cmd=\"" + getObjectStateString() + "\">");
/*  690 */     getFieldsAsXml(buf);
/*  691 */     buf.append("</").append("dao").append(">");
/*      */     
/*  693 */     return buf.toString();
/*      */   }
/*      */   
/*      */   public Map<String, String> getValues() {
/*  697 */     Map<String, String> values = super.getValues();
/*  698 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/*  699 */     if (this._tenderId != null) values.put("TenderId", DaoUtils.getXmlSafeFieldValue(12, this._tenderId)); 
/*  700 */     if (this._configElement != null) values.put("ConfigElement", DaoUtils.getXmlSafeFieldValue(12, this._configElement)); 
/*  701 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/*  702 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/*  703 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/*  704 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/*  705 */     if (this._authExpirationDateRequired != null) values.put("AuthExpirationDateRequired", DaoUtils.getXmlSafeFieldValue(-7, this._authExpirationDateRequired)); 
/*  706 */     if (this._authMethodCode != null) values.put("AuthMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._authMethodCode)); 
/*  707 */     if (this._authRequired != null) values.put("AuthRequired", DaoUtils.getXmlSafeFieldValue(-7, this._authRequired)); 
/*  708 */     if (this._custAssociation != null) values.put("CustAssociation", DaoUtils.getXmlSafeFieldValue(-7, this._custAssociation)); 
/*  709 */     if (this._custIdReqCode != null) values.put("CustIdReqCode", DaoUtils.getXmlSafeFieldValue(12, this._custIdReqCode)); 
/*  710 */     if (this._customerSignatureRequired != null) values.put("CustomerSignatureRequired", DaoUtils.getXmlSafeFieldValue(-7, this._customerSignatureRequired)); 
/*  711 */     if (this._dfltToAmountDue != null) values.put("DfltToAmountDue", DaoUtils.getXmlSafeFieldValue(-7, this._dfltToAmountDue)); 
/*  712 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/*  713 */     if (this._endorsementRequired != null) values.put("EndorsementRequired", DaoUtils.getXmlSafeFieldValue(-7, this._endorsementRequired)); 
/*  714 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/*  715 */     if (this._includeInTypeCount != null) values.put("IncludeInTypeCount", DaoUtils.getXmlSafeFieldValue(-7, this._includeInTypeCount)); 
/*  716 */     if (this._magneticSwipeReaderRequired != null) values.put("MagneticSwipeReaderRequired", DaoUtils.getXmlSafeFieldValue(-7, this._magneticSwipeReaderRequired)); 
/*  717 */     if (this._maxDaysForReturn != null) values.put("MaxDaysForReturn", DaoUtils.getXmlSafeFieldValue(4, this._maxDaysForReturn)); 
/*  718 */     if (this._minDaysForReturn != null) values.put("MinDaysForReturn", DaoUtils.getXmlSafeFieldValue(4, this._minDaysForReturn)); 
/*  719 */     if (this._minimumDenominationAmount != null) values.put("MinimumDenominationAmount", DaoUtils.getXmlSafeFieldValue(3, this._minimumDenominationAmount)); 
/*  720 */     if (this._openCashDrawerRequired != null) values.put("OpenCashDrawerRequired", DaoUtils.getXmlSafeFieldValue(-7, this._openCashDrawerRequired)); 
/*  721 */     if (this._pinRequired != null) values.put("PinRequired", DaoUtils.getXmlSafeFieldValue(-7, this._pinRequired)); 
/*  722 */     if (this._populateSystemCount != null) values.put("PopulateSystemCount", DaoUtils.getXmlSafeFieldValue(-7, this._populateSystemCount)); 
/*  723 */     if (this._serialIdentificationNbrRequired != null) values.put("SerialIdentificationNbrRequired", DaoUtils.getXmlSafeFieldValue(-7, this._serialIdentificationNbrRequired)); 
/*  724 */     if (this._unitCountCode != null) values.put("UnitCountCode", DaoUtils.getXmlSafeFieldValue(12, this._unitCountCode)); 
/*  725 */     if (this._suggestDeposit != null) values.put("SuggestDeposit", DaoUtils.getXmlSafeFieldValue(-7, this._suggestDeposit)); 
/*  726 */     if (this._suggestedDepositThreshold != null) values.put("SuggestedDepositThreshold", DaoUtils.getXmlSafeFieldValue(3, this._suggestedDepositThreshold)); 
/*  727 */     if (this._cashChangeLimit != null) values.put("CashChangeLimit", DaoUtils.getXmlSafeFieldValue(3, this._cashChangeLimit)); 
/*  728 */     if (this._changeTenderId != null) values.put("ChangeTenderId", DaoUtils.getXmlSafeFieldValue(12, this._changeTenderId)); 
/*  729 */     if (this._overtenderOverridable != null) values.put("OvertenderOverridable", DaoUtils.getXmlSafeFieldValue(-7, this._overtenderOverridable)); 
/*  730 */     if (this._nonVoidable != null) values.put("NonVoidable", DaoUtils.getXmlSafeFieldValue(-7, this._nonVoidable)); 
/*  731 */     if (this._closeCountDiscrepancyThreshold != null) values.put("CloseCountDiscrepancyThreshold", DaoUtils.getXmlSafeFieldValue(3, this._closeCountDiscrepancyThreshold)); 
/*  732 */     if (this._cidMsrRequired != null) values.put("CidMsrRequired", DaoUtils.getXmlSafeFieldValue(-7, this._cidMsrRequired)); 
/*  733 */     if (this._cidKeyedRequired != null) values.put("CidKeyedRequired", DaoUtils.getXmlSafeFieldValue(-7, this._cidKeyedRequired)); 
/*  734 */     if (this._postalRequired != null) values.put("PostalRequired", DaoUtils.getXmlSafeFieldValue(-7, this._postalRequired)); 
/*  735 */     if (this._disallowSplitTender != null) values.put("DisallowSplitTender", DaoUtils.getXmlSafeFieldValue(-7, this._disallowSplitTender)); 
/*  736 */     if (this._postVoidOpenCashDrawerRequired != null) values.put("PostVoidOpenCashDrawerRequired", DaoUtils.getXmlSafeFieldValue(-7, this._postVoidOpenCashDrawerRequired)); 
/*  737 */     if (this._reportingGroup != null) values.put("ReportingGroup", DaoUtils.getXmlSafeFieldValue(12, this._reportingGroup)); 
/*  738 */     if (this._changeAllowedWhenForeign != null) values.put("ChangeAllowedWhenForeign", DaoUtils.getXmlSafeFieldValue(-7, this._changeAllowedWhenForeign)); 
/*  739 */     if (this._fiscalTenderId != null) values.put("FiscalTenderId", DaoUtils.getXmlSafeFieldValue(12, this._fiscalTenderId)); 
/*  740 */     if (this._roundingMode != null) values.put("RoundingMode", DaoUtils.getXmlSafeFieldValue(12, this._roundingMode)); 
/*  741 */     if (this._assignCashDrawerRequired != null) values.put("AssignCashDrawerRequired", DaoUtils.getXmlSafeFieldValue(-7, this._assignCashDrawerRequired)); 
/*  742 */     if (this._postVoidAssignCashDrawerRequired != null) values.put("PostVoidAssignCashDrawerRequired", DaoUtils.getXmlSafeFieldValue(-7, this._postVoidAssignCashDrawerRequired)); 
/*  743 */     return values;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setValues(Map<String, String> argValues) {
/*  748 */     super.setValues(argValues);
/*  749 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*      */       
/*  751 */       String fieldName = field.getKey();
/*  752 */       String fieldValue = field.getValue();
/*  753 */       switch (fieldName) {
/*      */         
/*      */         case "OrganizationId":
/*      */           try {
/*  757 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/*  758 */             setOrganizationId((Long)value);
/*  759 */           } catch (Exception ee) {
/*  760 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "TenderId":
/*      */           try {
/*  766 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  767 */             setTenderId((String)value);
/*  768 */           } catch (Exception ee) {
/*  769 */             throw new DtxException("An exception occurred while calling setTenderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ConfigElement":
/*      */           try {
/*  775 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  776 */             setConfigElement((String)value);
/*  777 */           } catch (Exception ee) {
/*  778 */             throw new DtxException("An exception occurred while calling setConfigElement() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CreateDate":
/*      */           try {
/*  784 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  785 */             setCreateDate((Date)value);
/*  786 */           } catch (Exception ee) {
/*  787 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CreateUserId":
/*      */           try {
/*  793 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  794 */             setCreateUserId((String)value);
/*  795 */           } catch (Exception ee) {
/*  796 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UpdateDate":
/*      */           try {
/*  802 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  803 */             setUpdateDate((Date)value);
/*  804 */           } catch (Exception ee) {
/*  805 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UpdateUserId":
/*      */           try {
/*  811 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  812 */             setUpdateUserId((String)value);
/*  813 */           } catch (Exception ee) {
/*  814 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "AuthExpirationDateRequired":
/*      */           try {
/*  820 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/*  821 */             setAuthExpirationDateRequired((Boolean)value);
/*  822 */           } catch (Exception ee) {
/*  823 */             throw new DtxException("An exception occurred while calling setAuthExpirationDateRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "AuthMethodCode":
/*      */           try {
/*  829 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  830 */             setAuthMethodCode((String)value);
/*  831 */           } catch (Exception ee) {
/*  832 */             throw new DtxException("An exception occurred while calling setAuthMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "AuthRequired":
/*      */           try {
/*  838 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/*  839 */             setAuthRequired((Boolean)value);
/*  840 */           } catch (Exception ee) {
/*  841 */             throw new DtxException("An exception occurred while calling setAuthRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CustAssociation":
/*      */           try {
/*  847 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/*  848 */             setCustAssociation((Boolean)value);
/*  849 */           } catch (Exception ee) {
/*  850 */             throw new DtxException("An exception occurred while calling setCustAssociation() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CustIdReqCode":
/*      */           try {
/*  856 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  857 */             setCustIdReqCode((String)value);
/*  858 */           } catch (Exception ee) {
/*  859 */             throw new DtxException("An exception occurred while calling setCustIdReqCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CustomerSignatureRequired":
/*      */           try {
/*  865 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/*  866 */             setCustomerSignatureRequired((Boolean)value);
/*  867 */           } catch (Exception ee) {
/*  868 */             throw new DtxException("An exception occurred while calling setCustomerSignatureRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DfltToAmountDue":
/*      */           try {
/*  874 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/*  875 */             setDfltToAmountDue((Boolean)value);
/*  876 */           } catch (Exception ee) {
/*  877 */             throw new DtxException("An exception occurred while calling setDfltToAmountDue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "EffectiveDate":
/*      */           try {
/*  883 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  884 */             setEffectiveDate((Date)value);
/*  885 */           } catch (Exception ee) {
/*  886 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "EndorsementRequired":
/*      */           try {
/*  892 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/*  893 */             setEndorsementRequired((Boolean)value);
/*  894 */           } catch (Exception ee) {
/*  895 */             throw new DtxException("An exception occurred while calling setEndorsementRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ExpirationDate":
/*      */           try {
/*  901 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  902 */             setExpirationDate((Date)value);
/*  903 */           } catch (Exception ee) {
/*  904 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "IncludeInTypeCount":
/*      */           try {
/*  910 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/*  911 */             setIncludeInTypeCount((Boolean)value);
/*  912 */           } catch (Exception ee) {
/*  913 */             throw new DtxException("An exception occurred while calling setIncludeInTypeCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "MagneticSwipeReaderRequired":
/*      */           try {
/*  919 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/*  920 */             setMagneticSwipeReaderRequired((Boolean)value);
/*  921 */           } catch (Exception ee) {
/*  922 */             throw new DtxException("An exception occurred while calling setMagneticSwipeReaderRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "MaxDaysForReturn":
/*      */           try {
/*  928 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/*  929 */             setMaxDaysForReturn((Integer)value);
/*  930 */           } catch (Exception ee) {
/*  931 */             throw new DtxException("An exception occurred while calling setMaxDaysForReturn() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "MinDaysForReturn":
/*      */           try {
/*  937 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/*  938 */             setMinDaysForReturn((Integer)value);
/*  939 */           } catch (Exception ee) {
/*  940 */             throw new DtxException("An exception occurred while calling setMinDaysForReturn() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "MinimumDenominationAmount":
/*      */           try {
/*  946 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/*  947 */             setMinimumDenominationAmount((BigDecimal)value);
/*  948 */           } catch (Exception ee) {
/*  949 */             throw new DtxException("An exception occurred while calling setMinimumDenominationAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "OpenCashDrawerRequired":
/*      */           try {
/*  955 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/*  956 */             setOpenCashDrawerRequired((Boolean)value);
/*  957 */           } catch (Exception ee) {
/*  958 */             throw new DtxException("An exception occurred while calling setOpenCashDrawerRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PinRequired":
/*      */           try {
/*  964 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/*  965 */             setPinRequired((Boolean)value);
/*  966 */           } catch (Exception ee) {
/*  967 */             throw new DtxException("An exception occurred while calling setPinRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PopulateSystemCount":
/*      */           try {
/*  973 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/*  974 */             setPopulateSystemCount((Boolean)value);
/*  975 */           } catch (Exception ee) {
/*  976 */             throw new DtxException("An exception occurred while calling setPopulateSystemCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "SerialIdentificationNbrRequired":
/*      */           try {
/*  982 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/*  983 */             setSerialIdentificationNbrRequired((Boolean)value);
/*  984 */           } catch (Exception ee) {
/*  985 */             throw new DtxException("An exception occurred while calling setSerialIdentificationNbrRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UnitCountCode":
/*      */           try {
/*  991 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  992 */             setUnitCountCode((String)value);
/*  993 */           } catch (Exception ee) {
/*  994 */             throw new DtxException("An exception occurred while calling setUnitCountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "SuggestDeposit":
/*      */           try {
/* 1000 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1001 */             setSuggestDeposit((Boolean)value);
/* 1002 */           } catch (Exception ee) {
/* 1003 */             throw new DtxException("An exception occurred while calling setSuggestDeposit() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "SuggestedDepositThreshold":
/*      */           try {
/* 1009 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1010 */             setSuggestedDepositThreshold((BigDecimal)value);
/* 1011 */           } catch (Exception ee) {
/* 1012 */             throw new DtxException("An exception occurred while calling setSuggestedDepositThreshold() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CashChangeLimit":
/*      */           try {
/* 1018 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1019 */             setCashChangeLimit((BigDecimal)value);
/* 1020 */           } catch (Exception ee) {
/* 1021 */             throw new DtxException("An exception occurred while calling setCashChangeLimit() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ChangeTenderId":
/*      */           try {
/* 1027 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1028 */             setChangeTenderId((String)value);
/* 1029 */           } catch (Exception ee) {
/* 1030 */             throw new DtxException("An exception occurred while calling setChangeTenderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "OvertenderOverridable":
/*      */           try {
/* 1036 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1037 */             setOvertenderOverridable((Boolean)value);
/* 1038 */           } catch (Exception ee) {
/* 1039 */             throw new DtxException("An exception occurred while calling setOvertenderOverridable() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "NonVoidable":
/*      */           try {
/* 1045 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1046 */             setNonVoidable((Boolean)value);
/* 1047 */           } catch (Exception ee) {
/* 1048 */             throw new DtxException("An exception occurred while calling setNonVoidable() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CloseCountDiscrepancyThreshold":
/*      */           try {
/* 1054 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1055 */             setCloseCountDiscrepancyThreshold((BigDecimal)value);
/* 1056 */           } catch (Exception ee) {
/* 1057 */             throw new DtxException("An exception occurred while calling setCloseCountDiscrepancyThreshold() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CidMsrRequired":
/*      */           try {
/* 1063 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1064 */             setCidMsrRequired((Boolean)value);
/* 1065 */           } catch (Exception ee) {
/* 1066 */             throw new DtxException("An exception occurred while calling setCidMsrRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CidKeyedRequired":
/*      */           try {
/* 1072 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1073 */             setCidKeyedRequired((Boolean)value);
/* 1074 */           } catch (Exception ee) {
/* 1075 */             throw new DtxException("An exception occurred while calling setCidKeyedRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PostalRequired":
/*      */           try {
/* 1081 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1082 */             setPostalRequired((Boolean)value);
/* 1083 */           } catch (Exception ee) {
/* 1084 */             throw new DtxException("An exception occurred while calling setPostalRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DisallowSplitTender":
/*      */           try {
/* 1090 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1091 */             setDisallowSplitTender((Boolean)value);
/* 1092 */           } catch (Exception ee) {
/* 1093 */             throw new DtxException("An exception occurred while calling setDisallowSplitTender() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PostVoidOpenCashDrawerRequired":
/*      */           try {
/* 1099 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1100 */             setPostVoidOpenCashDrawerRequired((Boolean)value);
/* 1101 */           } catch (Exception ee) {
/* 1102 */             throw new DtxException("An exception occurred while calling setPostVoidOpenCashDrawerRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ReportingGroup":
/*      */           try {
/* 1108 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1109 */             setReportingGroup((String)value);
/* 1110 */           } catch (Exception ee) {
/* 1111 */             throw new DtxException("An exception occurred while calling setReportingGroup() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ChangeAllowedWhenForeign":
/*      */           try {
/* 1117 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1118 */             setChangeAllowedWhenForeign((Boolean)value);
/* 1119 */           } catch (Exception ee) {
/* 1120 */             throw new DtxException("An exception occurred while calling setChangeAllowedWhenForeign() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "FiscalTenderId":
/*      */           try {
/* 1126 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1127 */             setFiscalTenderId((String)value);
/* 1128 */           } catch (Exception ee) {
/* 1129 */             throw new DtxException("An exception occurred while calling setFiscalTenderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "RoundingMode":
/*      */           try {
/* 1135 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1136 */             setRoundingMode((String)value);
/* 1137 */           } catch (Exception ee) {
/* 1138 */             throw new DtxException("An exception occurred while calling setRoundingMode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "AssignCashDrawerRequired":
/*      */           try {
/* 1144 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1145 */             setAssignCashDrawerRequired((Boolean)value);
/* 1146 */           } catch (Exception ee) {
/* 1147 */             throw new DtxException("An exception occurred while calling setAssignCashDrawerRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PostVoidAssignCashDrawerRequired":
/*      */           try {
/* 1153 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1154 */             setPostVoidAssignCashDrawerRequired((Boolean)value);
/* 1155 */           } catch (Exception ee) {
/* 1156 */             throw new DtxException("An exception occurred while calling setPostVoidAssignCashDrawerRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderOptionsDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */