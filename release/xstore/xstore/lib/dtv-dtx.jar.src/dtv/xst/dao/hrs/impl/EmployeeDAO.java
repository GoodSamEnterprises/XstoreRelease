/*      */ package dtv.xst.dao.hrs.impl;
/*      */ 
/*      */ import dtv.data2.access.DaoUtils;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.exception.DtxException;
/*      */ import dtv.data2.access.impl.AbstractDAOImpl;
/*      */ import dtv.util.DtvDate;
/*      */ import dtv.xst.dao.hrs.EmployeeId;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class EmployeeDAO
/*      */   extends AbstractDAOImpl
/*      */ {
/*      */   private static final long serialVersionUID = 1258113742L;
/*   23 */   private static final Logger _logger = Logger.getLogger(EmployeeDAO.class);
/*      */   
/*      */   private Long _organizationId;
/*      */   private String _employeeId;
/*      */   private DtvDate _createDate;
/*      */   private String _createUserId;
/*      */   private DtvDate _updateDate;
/*      */   private String _updateUserId;
/*      */   private String _loginId;
/*      */   private DtvDate _activeDate;
/*      */   private DtvDate _addDate;
/*      */   private BigDecimal _additionalWithholdings;
/*      */   private BigDecimal _basePay;
/*   36 */   private Boolean _clockInNotRequired = Boolean.FALSE;
/*   37 */   private Boolean _clockedIn = Boolean.FALSE;
/*      */   private String _emergencyContactName;
/*      */   private String _emergencyContactPhone;
/*      */   private String _employeeGroup;
/*      */   private String _employeePayStatus;
/*      */   private String _employeeRoleCode;
/*      */   private String _employeeStatusCode;
/*      */   private String _employeeTypeCode;
/*      */   private String _employeeWorkStatus;
/*      */   private String _groupMembershipRaw;
/*      */   private DtvDate _hireDate;
/*      */   private String _jobTitle;
/*      */   private DtvDate _lastReviewDate;
/*      */   private String _maritalStatus;
/*      */   private DtvDate _nextReviewDate;
/*      */   private BigDecimal _personalDays;
/*      */   private BigDecimal _personalDaysUsed;
/*      */   private BigDecimal _sickDays;
/*      */   private BigDecimal _sickDaysUsed;
/*      */   private String _spouseName;
/*      */   private DtvDate _terminatedDate;
/*      */   private BigDecimal _vacationDays;
/*      */   private BigDecimal _vacationDaysUsed;
/*      */   private String _trainingStatusEnum;
/*   61 */   private Boolean _lockedOut = Boolean.FALSE;
/*      */   private DtvDate _lockedOutTimestamp;
/*   63 */   private Boolean _overtimeEligible = Boolean.FALSE;
/*      */   private String _primaryGroupId;
/*      */   private String _departmentId;
/*      */   private Long _partyId;
/*      */   private String _workCodeString;
/*      */   
/*      */   public Long getOrganizationId() {
/*   70 */     return this._organizationId;
/*      */   }
/*      */   
/*      */   public void setOrganizationId(Long argOrganizationId) {
/*   74 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*   75 */       this._organizationId = argOrganizationId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getEmployeeId() {
/*   80 */     return this._employeeId;
/*      */   }
/*      */   
/*      */   public void setEmployeeId(String argEmployeeId) {
/*   84 */     if (changed(argEmployeeId, this._employeeId, "employeeId")) {
/*   85 */       this._employeeId = (argEmployeeId != null && MANAGE_CASE) ? argEmployeeId.toUpperCase() : argEmployeeId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getCreateDate() {
/*   90 */     return (Date)this._createDate;
/*      */   }
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*   94 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*   95 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  101 */     return this._createUserId;
/*      */   }
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  105 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  106 */       this._createUserId = argCreateUserId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getUpdateDate() {
/*  111 */     return (Date)this._updateDate;
/*      */   }
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  115 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  116 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  122 */     return this._updateUserId;
/*      */   }
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  126 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  127 */       this._updateUserId = argUpdateUserId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getLoginId() {
/*  132 */     return this._loginId;
/*      */   }
/*      */   
/*      */   public void setLoginId(String argLoginId) {
/*  136 */     if (changed(argLoginId, this._loginId, "loginId")) {
/*  137 */       this._loginId = argLoginId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getActiveDate() {
/*  142 */     return (Date)this._activeDate;
/*      */   }
/*      */   
/*      */   public void setActiveDate(Date argActiveDate) {
/*  146 */     if (changed(argActiveDate, this._activeDate, "activeDate")) {
/*  147 */       this._activeDate = (argActiveDate == null || argActiveDate instanceof DtvDate) ? (DtvDate)argActiveDate : new DtvDate(argActiveDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public Date getAddDate() {
/*  153 */     return (Date)this._addDate;
/*      */   }
/*      */   
/*      */   public void setAddDate(Date argAddDate) {
/*  157 */     if (changed(argAddDate, this._addDate, "addDate")) {
/*  158 */       this._addDate = (argAddDate == null || argAddDate instanceof DtvDate) ? (DtvDate)argAddDate : new DtvDate(argAddDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public BigDecimal getAdditionalWithholdings() {
/*  164 */     return this._additionalWithholdings;
/*      */   }
/*      */   
/*      */   public void setAdditionalWithholdings(BigDecimal argAdditionalWithholdings) {
/*  168 */     if (changed(argAdditionalWithholdings, this._additionalWithholdings, "additionalWithholdings")) {
/*  169 */       this._additionalWithholdings = argAdditionalWithholdings;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getBasePay() {
/*  174 */     return this._basePay;
/*      */   }
/*      */   
/*      */   public void setBasePay(BigDecimal argBasePay) {
/*  178 */     if (changed(argBasePay, this._basePay, "basePay")) {
/*  179 */       this._basePay = argBasePay;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getClockInNotRequired() {
/*  184 */     return this._clockInNotRequired;
/*      */   }
/*      */   
/*      */   public void setClockInNotRequired(Boolean argClockInNotRequired) {
/*  188 */     if (changed(argClockInNotRequired, this._clockInNotRequired, "clockInNotRequired")) {
/*  189 */       this._clockInNotRequired = argClockInNotRequired;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getClockedIn() {
/*  194 */     return this._clockedIn;
/*      */   }
/*      */   
/*      */   public void setClockedIn(Boolean argClockedIn) {
/*  198 */     if (changed(argClockedIn, this._clockedIn, "clockedIn")) {
/*  199 */       this._clockedIn = argClockedIn;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getEmergencyContactName() {
/*  204 */     return this._emergencyContactName;
/*      */   }
/*      */   
/*      */   public void setEmergencyContactName(String argEmergencyContactName) {
/*  208 */     if (changed(argEmergencyContactName, this._emergencyContactName, "emergencyContactName")) {
/*  209 */       this._emergencyContactName = argEmergencyContactName;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getEmergencyContactPhone() {
/*  214 */     return this._emergencyContactPhone;
/*      */   }
/*      */   
/*      */   public void setEmergencyContactPhone(String argEmergencyContactPhone) {
/*  218 */     if (changed(argEmergencyContactPhone, this._emergencyContactPhone, "emergencyContactPhone")) {
/*  219 */       this._emergencyContactPhone = argEmergencyContactPhone;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getEmployeeGroup() {
/*  224 */     return this._employeeGroup;
/*      */   }
/*      */   
/*      */   public void setEmployeeGroup(String argEmployeeGroup) {
/*  228 */     if (changed(argEmployeeGroup, this._employeeGroup, "employeeGroup")) {
/*  229 */       this._employeeGroup = argEmployeeGroup;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getEmployeePayStatus() {
/*  234 */     return this._employeePayStatus;
/*      */   }
/*      */   
/*      */   public void setEmployeePayStatus(String argEmployeePayStatus) {
/*  238 */     if (changed(argEmployeePayStatus, this._employeePayStatus, "employeePayStatus")) {
/*  239 */       this._employeePayStatus = argEmployeePayStatus;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getEmployeeRoleCode() {
/*  244 */     return this._employeeRoleCode;
/*      */   }
/*      */   
/*      */   public void setEmployeeRoleCode(String argEmployeeRoleCode) {
/*  248 */     if (changed(argEmployeeRoleCode, this._employeeRoleCode, "employeeRoleCode")) {
/*  249 */       this._employeeRoleCode = argEmployeeRoleCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getEmployeeStatusCode() {
/*  254 */     return this._employeeStatusCode;
/*      */   }
/*      */   
/*      */   public void setEmployeeStatusCode(String argEmployeeStatusCode) {
/*  258 */     if (changed(argEmployeeStatusCode, this._employeeStatusCode, "employeeStatusCode")) {
/*  259 */       this._employeeStatusCode = argEmployeeStatusCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getEmployeeTypeCode() {
/*  264 */     return this._employeeTypeCode;
/*      */   }
/*      */   
/*      */   public void setEmployeeTypeCode(String argEmployeeTypeCode) {
/*  268 */     if (changed(argEmployeeTypeCode, this._employeeTypeCode, "employeeTypeCode")) {
/*  269 */       this._employeeTypeCode = argEmployeeTypeCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getEmployeeWorkStatus() {
/*  274 */     return this._employeeWorkStatus;
/*      */   }
/*      */   
/*      */   public void setEmployeeWorkStatus(String argEmployeeWorkStatus) {
/*  278 */     if (changed(argEmployeeWorkStatus, this._employeeWorkStatus, "employeeWorkStatus")) {
/*  279 */       this._employeeWorkStatus = argEmployeeWorkStatus;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getGroupMembershipRaw() {
/*  284 */     return this._groupMembershipRaw;
/*      */   }
/*      */   
/*      */   public void setGroupMembershipRaw(String argGroupMembershipRaw) {
/*  288 */     if (changed(argGroupMembershipRaw, this._groupMembershipRaw, "groupMembershipRaw")) {
/*  289 */       this._groupMembershipRaw = argGroupMembershipRaw;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getHireDate() {
/*  294 */     return (Date)this._hireDate;
/*      */   }
/*      */   
/*      */   public void setHireDate(Date argHireDate) {
/*  298 */     if (changed(argHireDate, this._hireDate, "hireDate")) {
/*  299 */       this._hireDate = (argHireDate == null || argHireDate instanceof DtvDate) ? (DtvDate)argHireDate : new DtvDate(argHireDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String getJobTitle() {
/*  305 */     return this._jobTitle;
/*      */   }
/*      */   
/*      */   public void setJobTitle(String argJobTitle) {
/*  309 */     if (changed(argJobTitle, this._jobTitle, "jobTitle")) {
/*  310 */       this._jobTitle = argJobTitle;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getLastReviewDate() {
/*  315 */     return (Date)this._lastReviewDate;
/*      */   }
/*      */   
/*      */   public void setLastReviewDate(Date argLastReviewDate) {
/*  319 */     if (changed(argLastReviewDate, this._lastReviewDate, "lastReviewDate")) {
/*  320 */       this._lastReviewDate = (argLastReviewDate == null || argLastReviewDate instanceof DtvDate) ? (DtvDate)argLastReviewDate : new DtvDate(argLastReviewDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String getMaritalStatus() {
/*  326 */     return this._maritalStatus;
/*      */   }
/*      */   
/*      */   public void setMaritalStatus(String argMaritalStatus) {
/*  330 */     if (changed(argMaritalStatus, this._maritalStatus, "maritalStatus")) {
/*  331 */       this._maritalStatus = argMaritalStatus;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getNextReviewDate() {
/*  336 */     return (Date)this._nextReviewDate;
/*      */   }
/*      */   
/*      */   public void setNextReviewDate(Date argNextReviewDate) {
/*  340 */     if (changed(argNextReviewDate, this._nextReviewDate, "nextReviewDate")) {
/*  341 */       this._nextReviewDate = (argNextReviewDate == null || argNextReviewDate instanceof DtvDate) ? (DtvDate)argNextReviewDate : new DtvDate(argNextReviewDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public BigDecimal getPersonalDays() {
/*  347 */     return this._personalDays;
/*      */   }
/*      */   
/*      */   public void setPersonalDays(BigDecimal argPersonalDays) {
/*  351 */     if (changed(argPersonalDays, this._personalDays, "personalDays")) {
/*  352 */       this._personalDays = argPersonalDays;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getPersonalDaysUsed() {
/*  357 */     return this._personalDaysUsed;
/*      */   }
/*      */   
/*      */   public void setPersonalDaysUsed(BigDecimal argPersonalDaysUsed) {
/*  361 */     if (changed(argPersonalDaysUsed, this._personalDaysUsed, "personalDaysUsed")) {
/*  362 */       this._personalDaysUsed = argPersonalDaysUsed;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getSickDays() {
/*  367 */     return this._sickDays;
/*      */   }
/*      */   
/*      */   public void setSickDays(BigDecimal argSickDays) {
/*  371 */     if (changed(argSickDays, this._sickDays, "sickDays")) {
/*  372 */       this._sickDays = argSickDays;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getSickDaysUsed() {
/*  377 */     return this._sickDaysUsed;
/*      */   }
/*      */   
/*      */   public void setSickDaysUsed(BigDecimal argSickDaysUsed) {
/*  381 */     if (changed(argSickDaysUsed, this._sickDaysUsed, "sickDaysUsed")) {
/*  382 */       this._sickDaysUsed = argSickDaysUsed;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getSpouseName() {
/*  387 */     return this._spouseName;
/*      */   }
/*      */   
/*      */   public void setSpouseName(String argSpouseName) {
/*  391 */     if (changed(argSpouseName, this._spouseName, "spouseName")) {
/*  392 */       this._spouseName = argSpouseName;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getTerminatedDate() {
/*  397 */     return (Date)this._terminatedDate;
/*      */   }
/*      */   
/*      */   public void setTerminatedDate(Date argTerminatedDate) {
/*  401 */     if (changed(argTerminatedDate, this._terminatedDate, "terminatedDate")) {
/*  402 */       this._terminatedDate = (argTerminatedDate == null || argTerminatedDate instanceof DtvDate) ? (DtvDate)argTerminatedDate : new DtvDate(argTerminatedDate);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public BigDecimal getVacationDays() {
/*  408 */     return this._vacationDays;
/*      */   }
/*      */   
/*      */   public void setVacationDays(BigDecimal argVacationDays) {
/*  412 */     if (changed(argVacationDays, this._vacationDays, "vacationDays")) {
/*  413 */       this._vacationDays = argVacationDays;
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getVacationDaysUsed() {
/*  418 */     return this._vacationDaysUsed;
/*      */   }
/*      */   
/*      */   public void setVacationDaysUsed(BigDecimal argVacationDaysUsed) {
/*  422 */     if (changed(argVacationDaysUsed, this._vacationDaysUsed, "vacationDaysUsed")) {
/*  423 */       this._vacationDaysUsed = argVacationDaysUsed;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getTrainingStatusEnum() {
/*  428 */     return this._trainingStatusEnum;
/*      */   }
/*      */   
/*      */   public void setTrainingStatusEnum(String argTrainingStatusEnum) {
/*  432 */     if (changed(argTrainingStatusEnum, this._trainingStatusEnum, "trainingStatusEnum")) {
/*  433 */       this._trainingStatusEnum = argTrainingStatusEnum;
/*      */     }
/*      */   }
/*      */   
/*      */   public Boolean getLockedOut() {
/*  438 */     return this._lockedOut;
/*      */   }
/*      */   
/*      */   public void setLockedOut(Boolean argLockedOut) {
/*  442 */     if (changed(argLockedOut, this._lockedOut, "lockedOut")) {
/*  443 */       this._lockedOut = argLockedOut;
/*      */     }
/*      */   }
/*      */   
/*      */   public Date getLockedOutTimestamp() {
/*  448 */     return (Date)this._lockedOutTimestamp;
/*      */   }
/*      */   
/*      */   public void setLockedOutTimestamp(Date argLockedOutTimestamp) {
/*  452 */     if (changed(argLockedOutTimestamp, this._lockedOutTimestamp, "lockedOutTimestamp")) {
/*  453 */       this._lockedOutTimestamp = (argLockedOutTimestamp == null || argLockedOutTimestamp instanceof DtvDate) ? (DtvDate)argLockedOutTimestamp : new DtvDate(argLockedOutTimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public Boolean getOvertimeEligible() {
/*  459 */     return this._overtimeEligible;
/*      */   }
/*      */   
/*      */   public void setOvertimeEligible(Boolean argOvertimeEligible) {
/*  463 */     if (changed(argOvertimeEligible, this._overtimeEligible, "overtimeEligible")) {
/*  464 */       this._overtimeEligible = argOvertimeEligible;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getPrimaryGroupId() {
/*  469 */     return this._primaryGroupId;
/*      */   }
/*      */   
/*      */   public void setPrimaryGroupId(String argPrimaryGroupId) {
/*  473 */     if (changed(argPrimaryGroupId, this._primaryGroupId, "primaryGroupId")) {
/*  474 */       this._primaryGroupId = argPrimaryGroupId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getDepartmentId() {
/*  479 */     return this._departmentId;
/*      */   }
/*      */   
/*      */   public void setDepartmentId(String argDepartmentId) {
/*  483 */     if (changed(argDepartmentId, this._departmentId, "departmentId")) {
/*  484 */       this._departmentId = argDepartmentId;
/*      */     }
/*      */   }
/*      */   
/*      */   public Long getPartyId() {
/*  489 */     return this._partyId;
/*      */   }
/*      */   
/*      */   public void setPartyId(Long argPartyId) {
/*  493 */     if (changed(argPartyId, this._partyId, "partyId")) {
/*  494 */       this._partyId = argPartyId;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getWorkCodeString() {
/*  499 */     return this._workCodeString;
/*      */   }
/*      */   
/*      */   public void setWorkCodeString(String argWorkCodeString) {
/*  503 */     if (changed(argWorkCodeString, this._workCodeString, "workCodeString")) {
/*  504 */       this._workCodeString = argWorkCodeString;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  511 */     StringBuilder buf = new StringBuilder(512);
/*  512 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/*  513 */     if (getOrganizationId() != null) {
/*  514 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*      */     }
/*  516 */     if (getEmployeeId() != null) {
/*  517 */       buf.append("employeeId").append("=").append(getEmployeeId()).append(" ");
/*      */     }
/*  519 */     if (getCreateDate() != null) {
/*  520 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*      */     }
/*  522 */     if (getCreateUserId() != null) {
/*  523 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*      */     }
/*  525 */     if (getUpdateDate() != null) {
/*  526 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*      */     }
/*  528 */     if (getUpdateUserId() != null) {
/*  529 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*      */     }
/*  531 */     if (getLoginId() != null) {
/*  532 */       buf.append("loginId").append("=").append(getLoginId()).append(" ");
/*      */     }
/*  534 */     if (getActiveDate() != null) {
/*  535 */       buf.append("activeDate").append("=").append(getActiveDate()).append(" ");
/*      */     }
/*  537 */     if (getAddDate() != null) {
/*  538 */       buf.append("addDate").append("=").append(getAddDate()).append(" ");
/*      */     }
/*  540 */     if (getAdditionalWithholdings() != null) {
/*  541 */       buf.append("additionalWithholdings").append("=").append(getAdditionalWithholdings()).append(" ");
/*      */     }
/*  543 */     if (getBasePay() != null) {
/*  544 */       buf.append("basePay").append("=").append(getBasePay()).append(" ");
/*      */     }
/*  546 */     if (getClockInNotRequired() != null && getClockInNotRequired().booleanValue()) {
/*  547 */       buf.append("clockInNotRequired").append("=").append(getClockInNotRequired()).append(" ");
/*      */     }
/*  549 */     if (getClockedIn() != null && getClockedIn().booleanValue()) {
/*  550 */       buf.append("clockedIn").append("=").append(getClockedIn()).append(" ");
/*      */     }
/*  552 */     if (getEmergencyContactName() != null) {
/*  553 */       buf.append("emergencyContactName").append("=").append(getEmergencyContactName()).append(" ");
/*      */     }
/*  555 */     if (getEmergencyContactPhone() != null) {
/*  556 */       buf.append("emergencyContactPhone").append("=").append(getEmergencyContactPhone()).append(" ");
/*      */     }
/*  558 */     if (getEmployeeGroup() != null) {
/*  559 */       buf.append("employeeGroup").append("=").append(getEmployeeGroup()).append(" ");
/*      */     }
/*  561 */     if (getEmployeePayStatus() != null) {
/*  562 */       buf.append("employeePayStatus").append("=").append(getEmployeePayStatus()).append(" ");
/*      */     }
/*  564 */     if (getEmployeeRoleCode() != null) {
/*  565 */       buf.append("employeeRoleCode").append("=").append(getEmployeeRoleCode()).append(" ");
/*      */     }
/*  567 */     if (getEmployeeStatusCode() != null) {
/*  568 */       buf.append("employeeStatusCode").append("=").append(getEmployeeStatusCode()).append(" ");
/*      */     }
/*  570 */     if (getEmployeeTypeCode() != null) {
/*  571 */       buf.append("employeeTypeCode").append("=").append(getEmployeeTypeCode()).append(" ");
/*      */     }
/*  573 */     if (getEmployeeWorkStatus() != null) {
/*  574 */       buf.append("employeeWorkStatus").append("=").append(getEmployeeWorkStatus()).append(" ");
/*      */     }
/*  576 */     if (getGroupMembershipRaw() != null) {
/*  577 */       buf.append("groupMembershipRaw").append("=").append(getGroupMembershipRaw()).append(" ");
/*      */     }
/*  579 */     if (getHireDate() != null) {
/*  580 */       buf.append("hireDate").append("=").append(getHireDate()).append(" ");
/*      */     }
/*  582 */     if (getJobTitle() != null) {
/*  583 */       buf.append("jobTitle").append("=").append(getJobTitle()).append(" ");
/*      */     }
/*  585 */     if (getLastReviewDate() != null) {
/*  586 */       buf.append("lastReviewDate").append("=").append(getLastReviewDate()).append(" ");
/*      */     }
/*  588 */     if (getMaritalStatus() != null) {
/*  589 */       buf.append("maritalStatus").append("=").append(getMaritalStatus()).append(" ");
/*      */     }
/*  591 */     if (getNextReviewDate() != null) {
/*  592 */       buf.append("nextReviewDate").append("=").append(getNextReviewDate()).append(" ");
/*      */     }
/*  594 */     if (getPersonalDays() != null) {
/*  595 */       buf.append("personalDays").append("=").append(getPersonalDays()).append(" ");
/*      */     }
/*  597 */     if (getPersonalDaysUsed() != null) {
/*  598 */       buf.append("personalDaysUsed").append("=").append(getPersonalDaysUsed()).append(" ");
/*      */     }
/*  600 */     if (getSickDays() != null) {
/*  601 */       buf.append("sickDays").append("=").append(getSickDays()).append(" ");
/*      */     }
/*  603 */     if (getSickDaysUsed() != null) {
/*  604 */       buf.append("sickDaysUsed").append("=").append(getSickDaysUsed()).append(" ");
/*      */     }
/*  606 */     if (getSpouseName() != null) {
/*  607 */       buf.append("spouseName").append("=").append(getSpouseName()).append(" ");
/*      */     }
/*  609 */     if (getTerminatedDate() != null) {
/*  610 */       buf.append("terminatedDate").append("=").append(getTerminatedDate()).append(" ");
/*      */     }
/*  612 */     if (getVacationDays() != null) {
/*  613 */       buf.append("vacationDays").append("=").append(getVacationDays()).append(" ");
/*      */     }
/*  615 */     if (getVacationDaysUsed() != null) {
/*  616 */       buf.append("vacationDaysUsed").append("=").append(getVacationDaysUsed()).append(" ");
/*      */     }
/*  618 */     if (getTrainingStatusEnum() != null) {
/*  619 */       buf.append("trainingStatusEnum").append("=").append(getTrainingStatusEnum()).append(" ");
/*      */     }
/*  621 */     if (getLockedOut() != null && getLockedOut().booleanValue()) {
/*  622 */       buf.append("lockedOut").append("=").append(getLockedOut()).append(" ");
/*      */     }
/*  624 */     if (getLockedOutTimestamp() != null) {
/*  625 */       buf.append("lockedOutTimestamp").append("=").append(getLockedOutTimestamp()).append(" ");
/*      */     }
/*  627 */     if (getOvertimeEligible() != null && getOvertimeEligible().booleanValue()) {
/*  628 */       buf.append("overtimeEligible").append("=").append(getOvertimeEligible()).append(" ");
/*      */     }
/*  630 */     if (getPrimaryGroupId() != null) {
/*  631 */       buf.append("primaryGroupId").append("=").append(getPrimaryGroupId()).append(" ");
/*      */     }
/*  633 */     if (getDepartmentId() != null) {
/*  634 */       buf.append("departmentId").append("=").append(getDepartmentId()).append(" ");
/*      */     }
/*  636 */     if (getPartyId() != null) {
/*  637 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*      */     }
/*  639 */     if (getWorkCodeString() != null) {
/*  640 */       buf.append("workCodeString").append("=").append(getWorkCodeString()).append(" ");
/*      */     }
/*      */     
/*  643 */     return buf.toString();
/*      */   }
/*      */   
/*      */   public IObjectId getObjectId() {
/*  647 */     EmployeeId id = new EmployeeId();
/*  648 */     id.setOrganizationId(getOrganizationId());
/*  649 */     id.setEmployeeId(getEmployeeId());
/*  650 */     return (IObjectId)id;
/*      */   }
/*      */   
/*      */   public void setObjectId(IObjectId argObjectId) {
/*  654 */     setOrganizationId(((EmployeeId)argObjectId).getOrganizationId());
/*  655 */     setEmployeeId(((EmployeeId)argObjectId).getEmployeeId());
/*      */   }
/*      */   
/*      */   public String getImplementingClass() {
/*  659 */     return null;
/*      */   }
/*      */   
/*      */   public String toXmlString() {
/*  663 */     StringBuilder buf = new StringBuilder(2150);
/*  664 */     buf.append("<").append("dao").append(" name=\"Employee\" cmd=\"" + getObjectStateString() + "\">");
/*  665 */     getFieldsAsXml(buf);
/*  666 */     buf.append("</").append("dao").append(">");
/*      */     
/*  668 */     return buf.toString();
/*      */   }
/*      */   
/*      */   public Map<String, String> getValues() {
/*  672 */     Map<String, String> values = super.getValues();
/*  673 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/*  674 */     if (this._employeeId != null) values.put("EmployeeId", DaoUtils.getXmlSafeFieldValue(12, this._employeeId)); 
/*  675 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/*  676 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/*  677 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/*  678 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/*  679 */     if (this._loginId != null) values.put("LoginId", DaoUtils.getXmlSafeFieldValue(12, this._loginId)); 
/*  680 */     if (this._activeDate != null) values.put("ActiveDate", DaoUtils.getXmlSafeFieldValue(91, this._activeDate)); 
/*  681 */     if (this._addDate != null) values.put("AddDate", DaoUtils.getXmlSafeFieldValue(91, this._addDate)); 
/*  682 */     if (this._additionalWithholdings != null) values.put("AdditionalWithholdings", DaoUtils.getXmlSafeFieldValue(3, this._additionalWithholdings)); 
/*  683 */     if (this._basePay != null) values.put("BasePay", DaoUtils.getXmlSafeFieldValue(3, this._basePay)); 
/*  684 */     if (this._clockInNotRequired != null) values.put("ClockInNotRequired", DaoUtils.getXmlSafeFieldValue(-7, this._clockInNotRequired)); 
/*  685 */     if (this._clockedIn != null) values.put("ClockedIn", DaoUtils.getXmlSafeFieldValue(-7, this._clockedIn)); 
/*  686 */     if (this._emergencyContactName != null) values.put("EmergencyContactName", DaoUtils.getXmlSafeFieldValue(12, this._emergencyContactName)); 
/*  687 */     if (this._emergencyContactPhone != null) values.put("EmergencyContactPhone", DaoUtils.getXmlSafeFieldValue(12, this._emergencyContactPhone)); 
/*  688 */     if (this._employeeGroup != null) values.put("EmployeeGroup", DaoUtils.getXmlSafeFieldValue(12, this._employeeGroup)); 
/*  689 */     if (this._employeePayStatus != null) values.put("EmployeePayStatus", DaoUtils.getXmlSafeFieldValue(12, this._employeePayStatus)); 
/*  690 */     if (this._employeeRoleCode != null) values.put("EmployeeRoleCode", DaoUtils.getXmlSafeFieldValue(12, this._employeeRoleCode)); 
/*  691 */     if (this._employeeStatusCode != null) values.put("EmployeeStatusCode", DaoUtils.getXmlSafeFieldValue(12, this._employeeStatusCode)); 
/*  692 */     if (this._employeeTypeCode != null) values.put("EmployeeTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._employeeTypeCode)); 
/*  693 */     if (this._employeeWorkStatus != null) values.put("EmployeeWorkStatus", DaoUtils.getXmlSafeFieldValue(12, this._employeeWorkStatus)); 
/*  694 */     if (this._groupMembershipRaw != null) values.put("GroupMembershipRaw", DaoUtils.getXmlSafeFieldValue(2005, this._groupMembershipRaw)); 
/*  695 */     if (this._hireDate != null) values.put("HireDate", DaoUtils.getXmlSafeFieldValue(91, this._hireDate)); 
/*  696 */     if (this._jobTitle != null) values.put("JobTitle", DaoUtils.getXmlSafeFieldValue(12, this._jobTitle)); 
/*  697 */     if (this._lastReviewDate != null) values.put("LastReviewDate", DaoUtils.getXmlSafeFieldValue(91, this._lastReviewDate)); 
/*  698 */     if (this._maritalStatus != null) values.put("MaritalStatus", DaoUtils.getXmlSafeFieldValue(12, this._maritalStatus)); 
/*  699 */     if (this._nextReviewDate != null) values.put("NextReviewDate", DaoUtils.getXmlSafeFieldValue(91, this._nextReviewDate)); 
/*  700 */     if (this._personalDays != null) values.put("PersonalDays", DaoUtils.getXmlSafeFieldValue(3, this._personalDays)); 
/*  701 */     if (this._personalDaysUsed != null) values.put("PersonalDaysUsed", DaoUtils.getXmlSafeFieldValue(3, this._personalDaysUsed)); 
/*  702 */     if (this._sickDays != null) values.put("SickDays", DaoUtils.getXmlSafeFieldValue(3, this._sickDays)); 
/*  703 */     if (this._sickDaysUsed != null) values.put("SickDaysUsed", DaoUtils.getXmlSafeFieldValue(3, this._sickDaysUsed)); 
/*  704 */     if (this._spouseName != null) values.put("SpouseName", DaoUtils.getXmlSafeFieldValue(12, this._spouseName)); 
/*  705 */     if (this._terminatedDate != null) values.put("TerminatedDate", DaoUtils.getXmlSafeFieldValue(91, this._terminatedDate)); 
/*  706 */     if (this._vacationDays != null) values.put("VacationDays", DaoUtils.getXmlSafeFieldValue(3, this._vacationDays)); 
/*  707 */     if (this._vacationDaysUsed != null) values.put("VacationDaysUsed", DaoUtils.getXmlSafeFieldValue(3, this._vacationDaysUsed)); 
/*  708 */     if (this._trainingStatusEnum != null) values.put("TrainingStatusEnum", DaoUtils.getXmlSafeFieldValue(12, this._trainingStatusEnum)); 
/*  709 */     if (this._lockedOut != null) values.put("LockedOut", DaoUtils.getXmlSafeFieldValue(-7, this._lockedOut)); 
/*  710 */     if (this._lockedOutTimestamp != null) values.put("LockedOutTimestamp", DaoUtils.getXmlSafeFieldValue(91, this._lockedOutTimestamp)); 
/*  711 */     if (this._overtimeEligible != null) values.put("OvertimeEligible", DaoUtils.getXmlSafeFieldValue(-7, this._overtimeEligible)); 
/*  712 */     if (this._primaryGroupId != null) values.put("PrimaryGroupId", DaoUtils.getXmlSafeFieldValue(12, this._primaryGroupId)); 
/*  713 */     if (this._departmentId != null) values.put("DepartmentId", DaoUtils.getXmlSafeFieldValue(12, this._departmentId)); 
/*  714 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/*  715 */     if (this._workCodeString != null) values.put("WorkCodeString", DaoUtils.getXmlSafeFieldValue(12, this._workCodeString)); 
/*  716 */     return values;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setValues(Map<String, String> argValues) {
/*  721 */     super.setValues(argValues);
/*  722 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*      */       
/*  724 */       String fieldName = field.getKey();
/*  725 */       String fieldValue = field.getValue();
/*  726 */       switch (fieldName) {
/*      */         
/*      */         case "OrganizationId":
/*      */           try {
/*  730 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/*  731 */             setOrganizationId((Long)value);
/*  732 */           } catch (Exception ee) {
/*  733 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "EmployeeId":
/*      */           try {
/*  739 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  740 */             setEmployeeId((String)value);
/*  741 */           } catch (Exception ee) {
/*  742 */             throw new DtxException("An exception occurred while calling setEmployeeId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CreateDate":
/*      */           try {
/*  748 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  749 */             setCreateDate((Date)value);
/*  750 */           } catch (Exception ee) {
/*  751 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "CreateUserId":
/*      */           try {
/*  757 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  758 */             setCreateUserId((String)value);
/*  759 */           } catch (Exception ee) {
/*  760 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UpdateDate":
/*      */           try {
/*  766 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  767 */             setUpdateDate((Date)value);
/*  768 */           } catch (Exception ee) {
/*  769 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "UpdateUserId":
/*      */           try {
/*  775 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  776 */             setUpdateUserId((String)value);
/*  777 */           } catch (Exception ee) {
/*  778 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "LoginId":
/*      */           try {
/*  784 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  785 */             setLoginId((String)value);
/*  786 */           } catch (Exception ee) {
/*  787 */             throw new DtxException("An exception occurred while calling setLoginId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ActiveDate":
/*      */           try {
/*  793 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  794 */             setActiveDate((Date)value);
/*  795 */           } catch (Exception ee) {
/*  796 */             throw new DtxException("An exception occurred while calling setActiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "AddDate":
/*      */           try {
/*  802 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  803 */             setAddDate((Date)value);
/*  804 */           } catch (Exception ee) {
/*  805 */             throw new DtxException("An exception occurred while calling setAddDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "AdditionalWithholdings":
/*      */           try {
/*  811 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/*  812 */             setAdditionalWithholdings((BigDecimal)value);
/*  813 */           } catch (Exception ee) {
/*  814 */             throw new DtxException("An exception occurred while calling setAdditionalWithholdings() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "BasePay":
/*      */           try {
/*  820 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/*  821 */             setBasePay((BigDecimal)value);
/*  822 */           } catch (Exception ee) {
/*  823 */             throw new DtxException("An exception occurred while calling setBasePay() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ClockInNotRequired":
/*      */           try {
/*  829 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/*  830 */             setClockInNotRequired((Boolean)value);
/*  831 */           } catch (Exception ee) {
/*  832 */             throw new DtxException("An exception occurred while calling setClockInNotRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "ClockedIn":
/*      */           try {
/*  838 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/*  839 */             setClockedIn((Boolean)value);
/*  840 */           } catch (Exception ee) {
/*  841 */             throw new DtxException("An exception occurred while calling setClockedIn() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "EmergencyContactName":
/*      */           try {
/*  847 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  848 */             setEmergencyContactName((String)value);
/*  849 */           } catch (Exception ee) {
/*  850 */             throw new DtxException("An exception occurred while calling setEmergencyContactName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "EmergencyContactPhone":
/*      */           try {
/*  856 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  857 */             setEmergencyContactPhone((String)value);
/*  858 */           } catch (Exception ee) {
/*  859 */             throw new DtxException("An exception occurred while calling setEmergencyContactPhone() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "EmployeeGroup":
/*      */           try {
/*  865 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  866 */             setEmployeeGroup((String)value);
/*  867 */           } catch (Exception ee) {
/*  868 */             throw new DtxException("An exception occurred while calling setEmployeeGroup() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "EmployeePayStatus":
/*      */           try {
/*  874 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  875 */             setEmployeePayStatus((String)value);
/*  876 */           } catch (Exception ee) {
/*  877 */             throw new DtxException("An exception occurred while calling setEmployeePayStatus() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "EmployeeRoleCode":
/*      */           try {
/*  883 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  884 */             setEmployeeRoleCode((String)value);
/*  885 */           } catch (Exception ee) {
/*  886 */             throw new DtxException("An exception occurred while calling setEmployeeRoleCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "EmployeeStatusCode":
/*      */           try {
/*  892 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  893 */             setEmployeeStatusCode((String)value);
/*  894 */           } catch (Exception ee) {
/*  895 */             throw new DtxException("An exception occurred while calling setEmployeeStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "EmployeeTypeCode":
/*      */           try {
/*  901 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  902 */             setEmployeeTypeCode((String)value);
/*  903 */           } catch (Exception ee) {
/*  904 */             throw new DtxException("An exception occurred while calling setEmployeeTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "EmployeeWorkStatus":
/*      */           try {
/*  910 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  911 */             setEmployeeWorkStatus((String)value);
/*  912 */           } catch (Exception ee) {
/*  913 */             throw new DtxException("An exception occurred while calling setEmployeeWorkStatus() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "GroupMembershipRaw":
/*      */           try {
/*  919 */             Object value = DaoUtils.getFieldValueForXmlString(2005, fieldValue);
/*  920 */             setGroupMembershipRaw((String)value);
/*  921 */           } catch (Exception ee) {
/*  922 */             throw new DtxException("An exception occurred while calling setGroupMembershipRaw() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "HireDate":
/*      */           try {
/*  928 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  929 */             setHireDate((Date)value);
/*  930 */           } catch (Exception ee) {
/*  931 */             throw new DtxException("An exception occurred while calling setHireDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "JobTitle":
/*      */           try {
/*  937 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  938 */             setJobTitle((String)value);
/*  939 */           } catch (Exception ee) {
/*  940 */             throw new DtxException("An exception occurred while calling setJobTitle() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "LastReviewDate":
/*      */           try {
/*  946 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  947 */             setLastReviewDate((Date)value);
/*  948 */           } catch (Exception ee) {
/*  949 */             throw new DtxException("An exception occurred while calling setLastReviewDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "MaritalStatus":
/*      */           try {
/*  955 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/*  956 */             setMaritalStatus((String)value);
/*  957 */           } catch (Exception ee) {
/*  958 */             throw new DtxException("An exception occurred while calling setMaritalStatus() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "NextReviewDate":
/*      */           try {
/*  964 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/*  965 */             setNextReviewDate((Date)value);
/*  966 */           } catch (Exception ee) {
/*  967 */             throw new DtxException("An exception occurred while calling setNextReviewDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PersonalDays":
/*      */           try {
/*  973 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/*  974 */             setPersonalDays((BigDecimal)value);
/*  975 */           } catch (Exception ee) {
/*  976 */             throw new DtxException("An exception occurred while calling setPersonalDays() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PersonalDaysUsed":
/*      */           try {
/*  982 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/*  983 */             setPersonalDaysUsed((BigDecimal)value);
/*  984 */           } catch (Exception ee) {
/*  985 */             throw new DtxException("An exception occurred while calling setPersonalDaysUsed() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "SickDays":
/*      */           try {
/*  991 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/*  992 */             setSickDays((BigDecimal)value);
/*  993 */           } catch (Exception ee) {
/*  994 */             throw new DtxException("An exception occurred while calling setSickDays() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "SickDaysUsed":
/*      */           try {
/* 1000 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1001 */             setSickDaysUsed((BigDecimal)value);
/* 1002 */           } catch (Exception ee) {
/* 1003 */             throw new DtxException("An exception occurred while calling setSickDaysUsed() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "SpouseName":
/*      */           try {
/* 1009 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1010 */             setSpouseName((String)value);
/* 1011 */           } catch (Exception ee) {
/* 1012 */             throw new DtxException("An exception occurred while calling setSpouseName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "TerminatedDate":
/*      */           try {
/* 1018 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 1019 */             setTerminatedDate((Date)value);
/* 1020 */           } catch (Exception ee) {
/* 1021 */             throw new DtxException("An exception occurred while calling setTerminatedDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "VacationDays":
/*      */           try {
/* 1027 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1028 */             setVacationDays((BigDecimal)value);
/* 1029 */           } catch (Exception ee) {
/* 1030 */             throw new DtxException("An exception occurred while calling setVacationDays() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "VacationDaysUsed":
/*      */           try {
/* 1036 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 1037 */             setVacationDaysUsed((BigDecimal)value);
/* 1038 */           } catch (Exception ee) {
/* 1039 */             throw new DtxException("An exception occurred while calling setVacationDaysUsed() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "TrainingStatusEnum":
/*      */           try {
/* 1045 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1046 */             setTrainingStatusEnum((String)value);
/* 1047 */           } catch (Exception ee) {
/* 1048 */             throw new DtxException("An exception occurred while calling setTrainingStatusEnum() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "LockedOut":
/*      */           try {
/* 1054 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1055 */             setLockedOut((Boolean)value);
/* 1056 */           } catch (Exception ee) {
/* 1057 */             throw new DtxException("An exception occurred while calling setLockedOut() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "LockedOutTimestamp":
/*      */           try {
/* 1063 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 1064 */             setLockedOutTimestamp((Date)value);
/* 1065 */           } catch (Exception ee) {
/* 1066 */             throw new DtxException("An exception occurred while calling setLockedOutTimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "OvertimeEligible":
/*      */           try {
/* 1072 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 1073 */             setOvertimeEligible((Boolean)value);
/* 1074 */           } catch (Exception ee) {
/* 1075 */             throw new DtxException("An exception occurred while calling setOvertimeEligible() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PrimaryGroupId":
/*      */           try {
/* 1081 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1082 */             setPrimaryGroupId((String)value);
/* 1083 */           } catch (Exception ee) {
/* 1084 */             throw new DtxException("An exception occurred while calling setPrimaryGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "DepartmentId":
/*      */           try {
/* 1090 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1091 */             setDepartmentId((String)value);
/* 1092 */           } catch (Exception ee) {
/* 1093 */             throw new DtxException("An exception occurred while calling setDepartmentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "PartyId":
/*      */           try {
/* 1099 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 1100 */             setPartyId((Long)value);
/* 1101 */           } catch (Exception ee) {
/* 1102 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */ 
/*      */         
/*      */         case "WorkCodeString":
/*      */           try {
/* 1108 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 1109 */             setWorkCodeString((String)value);
/* 1110 */           } catch (Exception ee) {
/* 1111 */             throw new DtxException("An exception occurred while calling setWorkCodeString() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*      */           } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */