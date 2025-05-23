/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.EmployeeId;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EmployeeDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1258113742L;
/*     */   private Long _organizationId;
/*     */   private String _employeeId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _loginId;
/*     */   private Date _activeDate;
/*     */   private Date _addDate;
/*     */   private BigDecimal _additionalWithholdings;
/*     */   private BigDecimal _basePay;
/*     */   private Boolean _clockInNotRequired;
/*     */   private Boolean _clockedIn;
/*     */   private String _emergencyContactName;
/*     */   private String _emergencyContactPhone;
/*     */   private String _employeeGroup;
/*     */   private String _employeePayStatus;
/*     */   private String _employeeRoleCode;
/*     */   private String _employeeStatusCode;
/*     */   private String _employeeTypeCode;
/*     */   private String _employeeWorkStatus;
/*     */   private String _groupMembershipRaw;
/*     */   private Date _hireDate;
/*     */   private String _jobTitle;
/*     */   private Date _lastReviewDate;
/*     */   private String _maritalStatus;
/*     */   private Date _nextReviewDate;
/*     */   private BigDecimal _personalDays;
/*     */   private BigDecimal _personalDaysUsed;
/*     */   private BigDecimal _sickDays;
/*     */   private BigDecimal _sickDaysUsed;
/*     */   private String _spouseName;
/*     */   private Date _terminatedDate;
/*     */   private BigDecimal _vacationDays;
/*     */   private BigDecimal _vacationDaysUsed;
/*     */   private String _trainingStatusEnum;
/*     */   private Boolean _lockedOut;
/*     */   private Date _lockedOutTimestamp;
/*     */   private Boolean _overtimeEligible;
/*     */   private String _primaryGroupId;
/*     */   private String _departmentId;
/*     */   private Long _partyId;
/*     */   private String _workCodeString;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.employee_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.login_id, t.active_date, t.add_date, t.additional_withholdings, t.base_pay, t.clock_in_not_req_flag, t.clocked_in_flag, t.emergency_contact_name, t.emergency_contact_phone, t.employee_group_id, t.employee_pay_status, t.employee_role_code, t.employee_statcode, t.employee_typcode, t.employee_work_status, t.group_membership, t.hire_date, t.job_title, t.last_review_date, t.marital_status, t.next_review_date, t.personal_days, t.personal_days_used, t.sick_days, t.sick_days_used, t.spouse_name, t.terminated_date, t.vacation_days, t.vacation_days_used, t.training_status_enum, t.locked_out_flag, t.locked_out_timestamp, t.overtime_eligible_flag, t.primary_group, t.department_id, t.party_id, t.work_code FROM hrs_employee t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  72 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  76 */     return "SELECT t.organization_id, t.employee_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.login_id, t.active_date, t.add_date, t.additional_withholdings, t.base_pay, t.clock_in_not_req_flag, t.clocked_in_flag, t.emergency_contact_name, t.emergency_contact_phone, t.employee_group_id, t.employee_pay_status, t.employee_role_code, t.employee_statcode, t.employee_typcode, t.employee_work_status, t.group_membership, t.hire_date, t.job_title, t.last_review_date, t.marital_status, t.next_review_date, t.personal_days, t.personal_days_used, t.sick_days, t.sick_days_used, t.spouse_name, t.terminated_date, t.vacation_days, t.vacation_days_used, t.training_status_enum, t.locked_out_flag, t.locked_out_timestamp, t.overtime_eligible_flag, t.primary_group, t.department_id, t.party_id, t.work_code FROM hrs_employee t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  82 */     return " WHERE organization_id = ?  AND employee_id = ?  ";
/*     */   }
/*     */   
/*  85 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO hrs_employee(organization_id, employee_id, create_date, create_user_id, update_date, update_user_id, login_id, active_date, add_date, additional_withholdings, base_pay, clock_in_not_req_flag, clocked_in_flag, emergency_contact_name, emergency_contact_phone, employee_group_id, employee_pay_status, employee_role_code, employee_statcode, employee_typcode, employee_work_status, group_membership, hire_date, job_title, last_review_date, marital_status, next_review_date, personal_days, personal_days_used, sick_days, sick_days_used, spouse_name, terminated_date, vacation_days, vacation_days_used, training_status_enum, locked_out_flag, locked_out_timestamp, overtime_eligible_flag, primary_group, department_id, party_id, work_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  88 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  92 */     Object[][] insertParameterObject = { { this._organizationId, this._employeeId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._loginId, this._activeDate, this._addDate, this._additionalWithholdings, this._basePay, this._clockInNotRequired, this._clockedIn, this._emergencyContactName, this._emergencyContactPhone, this._employeeGroup, this._employeePayStatus, this._employeeRoleCode, this._employeeStatusCode, this._employeeTypeCode, this._employeeWorkStatus, this._groupMembershipRaw, this._hireDate, this._jobTitle, this._lastReviewDate, this._maritalStatus, this._nextReviewDate, this._personalDays, this._personalDaysUsed, this._sickDays, this._sickDaysUsed, this._spouseName, this._terminatedDate, this._vacationDays, this._vacationDaysUsed, this._trainingStatusEnum, this._lockedOut, this._lockedOutTimestamp, this._overtimeEligible, this._primaryGroupId, this._departmentId, this._partyId, this._workCodeString } };
/*  93 */     return insertParameterObject;
/*     */   }
/*     */   
/*  96 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 91, 91, 3, 3, -7, -7, 12, 12, 12, 12, 12, 12, 12, 12, 2005, 91, 12, 91, 12, 91, 3, 3, 3, 3, 12, 91, 3, 3, 12, -7, 91, -7, 12, 12, -5, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  99 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/* 102 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE hrs_employee SET update_date = ?, update_user_id = ?, login_id = ?, active_date = ?, add_date = ?, additional_withholdings = ?, base_pay = ?, clock_in_not_req_flag = ?, clocked_in_flag = ?, emergency_contact_name = ?, emergency_contact_phone = ?, employee_group_id = ?, employee_pay_status = ?, employee_role_code = ?, employee_statcode = ?, employee_typcode = ?, employee_work_status = ?, group_membership = ?, hire_date = ?, job_title = ?, last_review_date = ?, marital_status = ?, next_review_date = ?, personal_days = ?, personal_days_used = ?, sick_days = ?, sick_days_used = ?, spouse_name = ?, terminated_date = ?, vacation_days = ?, vacation_days_used = ?, training_status_enum = ?, locked_out_flag = ?, locked_out_timestamp = ?, overtime_eligible_flag = ?, primary_group = ?, department_id = ?, party_id = ?, work_code = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/* 105 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 109 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._loginId, this._activeDate, this._addDate, this._additionalWithholdings, this._basePay, this._clockInNotRequired, this._clockedIn, this._emergencyContactName, this._emergencyContactPhone, this._employeeGroup, this._employeePayStatus, this._employeeRoleCode, this._employeeStatusCode, this._employeeTypeCode, this._employeeWorkStatus, this._groupMembershipRaw, this._hireDate, this._jobTitle, this._lastReviewDate, this._maritalStatus, this._nextReviewDate, this._personalDays, this._personalDaysUsed, this._sickDays, this._sickDaysUsed, this._spouseName, this._terminatedDate, this._vacationDays, this._vacationDaysUsed, this._trainingStatusEnum, this._lockedOut, this._lockedOutTimestamp, this._overtimeEligible, this._primaryGroupId, this._departmentId, this._partyId, this._workCodeString } };
/* 110 */     return updateParameterObject;
/*     */   }
/*     */   
/* 113 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 91, 91, 3, 3, -7, -7, 12, 12, 12, 12, 12, 12, 12, 12, 2005, 91, 12, 91, 12, 91, 3, 3, 3, 3, 12, 91, 3, 3, 12, -7, 91, -7, 12, 12, -5, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 115 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 118 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM hrs_employee" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 121 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 127 */     return " WHERE organization_id = ?  AND employee_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 130 */     return new Object[] { this._organizationId, this._employeeId };
/*     */   }
/*     */   
/* 133 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 136 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 139 */     return "hrs_employee";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 143 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 147 */     return new EmployeeFiller(this);
/*     */   }
/*     */   
/*     */   private static class EmployeeFiller
/*     */     implements IFiller {
/*     */     private EmployeeDBA _parent;
/*     */     
/*     */     public EmployeeFiller(EmployeeDBA argParent) {
/* 155 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 160 */       long primitiveResult = argResultSet.getLong(1);
/* 161 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 162 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 166 */       this._parent._employeeId = argResultSet.getString(2);
/*     */       
/* 168 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 169 */       if (t3 != null) {
/* 170 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 173 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 176 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 178 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 179 */       if (t5 != null) {
/* 180 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 183 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 186 */       this._parent._updateUserId = argResultSet.getString(6);
/* 187 */       this._parent._loginId = argResultSet.getString(7);
/*     */       
/* 189 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 190 */       if (t8 != null) {
/* 191 */         this._parent._activeDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 194 */         this._parent._activeDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 198 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 199 */       if (t9 != null) {
/* 200 */         this._parent._addDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 203 */         this._parent._addDate = null;
/*     */       } 
/*     */       
/* 206 */       this._parent._additionalWithholdings = argResultSet.getBigDecimal(10);
/* 207 */       this._parent._basePay = argResultSet.getBigDecimal(11);
/* 208 */       this._parent._clockInNotRequired = Boolean.valueOf(argResultSet.getBoolean(12));
/* 209 */       this._parent._clockedIn = Boolean.valueOf(argResultSet.getBoolean(13));
/* 210 */       this._parent._emergencyContactName = argResultSet.getString(14);
/* 211 */       this._parent._emergencyContactPhone = argResultSet.getString(15);
/* 212 */       this._parent._employeeGroup = argResultSet.getString(16);
/* 213 */       this._parent._employeePayStatus = argResultSet.getString(17);
/* 214 */       this._parent._employeeRoleCode = argResultSet.getString(18);
/* 215 */       this._parent._employeeStatusCode = argResultSet.getString(19);
/* 216 */       this._parent._employeeTypeCode = argResultSet.getString(20);
/* 217 */       this._parent._employeeWorkStatus = argResultSet.getString(21);
/*     */ 
/*     */       
/* 220 */       this._parent._groupMembershipRaw = JDBCHelper.clobToString(argResultSet, 22);
/*     */ 
/*     */       
/* 223 */       Timestamp t23 = argResultSet.getTimestamp(23);
/* 224 */       if (t23 != null) {
/* 225 */         this._parent._hireDate = (Date)new DtvDate(t23.getTime());
/*     */       } else {
/*     */         
/* 228 */         this._parent._hireDate = null;
/*     */       } 
/*     */       
/* 231 */       this._parent._jobTitle = argResultSet.getString(24);
/*     */       
/* 233 */       Timestamp t25 = argResultSet.getTimestamp(25);
/* 234 */       if (t25 != null) {
/* 235 */         this._parent._lastReviewDate = (Date)new DtvDate(t25.getTime());
/*     */       } else {
/*     */         
/* 238 */         this._parent._lastReviewDate = null;
/*     */       } 
/*     */       
/* 241 */       this._parent._maritalStatus = argResultSet.getString(26);
/*     */       
/* 243 */       Timestamp t27 = argResultSet.getTimestamp(27);
/* 244 */       if (t27 != null) {
/* 245 */         this._parent._nextReviewDate = (Date)new DtvDate(t27.getTime());
/*     */       } else {
/*     */         
/* 248 */         this._parent._nextReviewDate = null;
/*     */       } 
/*     */       
/* 251 */       this._parent._personalDays = argResultSet.getBigDecimal(28);
/* 252 */       this._parent._personalDaysUsed = argResultSet.getBigDecimal(29);
/* 253 */       this._parent._sickDays = argResultSet.getBigDecimal(30);
/* 254 */       this._parent._sickDaysUsed = argResultSet.getBigDecimal(31);
/* 255 */       this._parent._spouseName = argResultSet.getString(32);
/*     */       
/* 257 */       Timestamp t33 = argResultSet.getTimestamp(33);
/* 258 */       if (t33 != null) {
/* 259 */         this._parent._terminatedDate = (Date)new DtvDate(t33.getTime());
/*     */       } else {
/*     */         
/* 262 */         this._parent._terminatedDate = null;
/*     */       } 
/*     */       
/* 265 */       this._parent._vacationDays = argResultSet.getBigDecimal(34);
/* 266 */       this._parent._vacationDaysUsed = argResultSet.getBigDecimal(35);
/* 267 */       this._parent._trainingStatusEnum = argResultSet.getString(36);
/* 268 */       this._parent._lockedOut = Boolean.valueOf(argResultSet.getBoolean(37));
/*     */       
/* 270 */       Timestamp t38 = argResultSet.getTimestamp(38);
/* 271 */       if (t38 != null) {
/* 272 */         this._parent._lockedOutTimestamp = (Date)new DtvDate(t38.getTime());
/*     */       } else {
/*     */         
/* 275 */         this._parent._lockedOutTimestamp = null;
/*     */       } 
/*     */       
/* 278 */       this._parent._overtimeEligible = Boolean.valueOf(argResultSet.getBoolean(39));
/* 279 */       this._parent._primaryGroupId = argResultSet.getString(40);
/* 280 */       this._parent._departmentId = argResultSet.getString(41);
/*     */ 
/*     */       
/* 283 */       long l1 = argResultSet.getLong(42);
/* 284 */       if (l1 != 0L || argResultSet.getObject(42) != null) {
/* 285 */         this._parent._partyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 289 */       this._parent._workCodeString = argResultSet.getString(43);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 294 */     argDAO.suppressStateChanges(true);
/* 295 */     EmployeeDAO dao = (EmployeeDAO)argDAO;
/* 296 */     dao.setOrganizationId(this._organizationId);
/* 297 */     dao.setEmployeeId(this._employeeId);
/* 298 */     dao.setCreateDate(this._createDate);
/* 299 */     dao.setCreateUserId(this._createUserId);
/* 300 */     dao.setUpdateDate(this._updateDate);
/* 301 */     dao.setUpdateUserId(this._updateUserId);
/* 302 */     dao.setLoginId(this._loginId);
/* 303 */     dao.setActiveDate(this._activeDate);
/* 304 */     dao.setAddDate(this._addDate);
/* 305 */     dao.setAdditionalWithholdings(this._additionalWithholdings);
/* 306 */     dao.setBasePay(this._basePay);
/* 307 */     dao.setClockInNotRequired(this._clockInNotRequired);
/* 308 */     dao.setClockedIn(this._clockedIn);
/* 309 */     dao.setEmergencyContactName(this._emergencyContactName);
/* 310 */     dao.setEmergencyContactPhone(this._emergencyContactPhone);
/* 311 */     dao.setEmployeeGroup(this._employeeGroup);
/* 312 */     dao.setEmployeePayStatus(this._employeePayStatus);
/* 313 */     dao.setEmployeeRoleCode(this._employeeRoleCode);
/* 314 */     dao.setEmployeeStatusCode(this._employeeStatusCode);
/* 315 */     dao.setEmployeeTypeCode(this._employeeTypeCode);
/* 316 */     dao.setEmployeeWorkStatus(this._employeeWorkStatus);
/* 317 */     dao.setGroupMembershipRaw(this._groupMembershipRaw);
/* 318 */     dao.setHireDate(this._hireDate);
/* 319 */     dao.setJobTitle(this._jobTitle);
/* 320 */     dao.setLastReviewDate(this._lastReviewDate);
/* 321 */     dao.setMaritalStatus(this._maritalStatus);
/* 322 */     dao.setNextReviewDate(this._nextReviewDate);
/* 323 */     dao.setPersonalDays(this._personalDays);
/* 324 */     dao.setPersonalDaysUsed(this._personalDaysUsed);
/* 325 */     dao.setSickDays(this._sickDays);
/* 326 */     dao.setSickDaysUsed(this._sickDaysUsed);
/* 327 */     dao.setSpouseName(this._spouseName);
/* 328 */     dao.setTerminatedDate(this._terminatedDate);
/* 329 */     dao.setVacationDays(this._vacationDays);
/* 330 */     dao.setVacationDaysUsed(this._vacationDaysUsed);
/* 331 */     dao.setTrainingStatusEnum(this._trainingStatusEnum);
/* 332 */     dao.setLockedOut(this._lockedOut);
/* 333 */     dao.setLockedOutTimestamp(this._lockedOutTimestamp);
/* 334 */     dao.setOvertimeEligible(this._overtimeEligible);
/* 335 */     dao.setPrimaryGroupId(this._primaryGroupId);
/* 336 */     dao.setDepartmentId(this._departmentId);
/* 337 */     dao.setPartyId(this._partyId);
/* 338 */     dao.setWorkCodeString(this._workCodeString);
/* 339 */     argDAO.suppressStateChanges(false);
/* 340 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 344 */     return loadDAO((IDataAccessObject)new EmployeeDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 348 */     EmployeeDAO dao = (EmployeeDAO)argDAO;
/* 349 */     this._organizationId = dao.getOrganizationId();
/* 350 */     this._employeeId = dao.getEmployeeId();
/* 351 */     this._createDate = dao.getCreateDate();
/* 352 */     this._createUserId = dao.getCreateUserId();
/* 353 */     this._updateDate = dao.getUpdateDate();
/* 354 */     this._updateUserId = dao.getUpdateUserId();
/* 355 */     this._loginId = dao.getLoginId();
/* 356 */     this._activeDate = dao.getActiveDate();
/* 357 */     this._addDate = dao.getAddDate();
/* 358 */     this._additionalWithholdings = dao.getAdditionalWithholdings();
/* 359 */     this._basePay = dao.getBasePay();
/* 360 */     this._clockInNotRequired = (dao.getClockInNotRequired() != null) ? dao.getClockInNotRequired() : Boolean.valueOf(false);
/* 361 */     this._clockedIn = (dao.getClockedIn() != null) ? dao.getClockedIn() : Boolean.valueOf(false);
/* 362 */     this._emergencyContactName = dao.getEmergencyContactName();
/* 363 */     this._emergencyContactPhone = dao.getEmergencyContactPhone();
/* 364 */     this._employeeGroup = dao.getEmployeeGroup();
/* 365 */     this._employeePayStatus = dao.getEmployeePayStatus();
/* 366 */     this._employeeRoleCode = dao.getEmployeeRoleCode();
/* 367 */     this._employeeStatusCode = dao.getEmployeeStatusCode();
/* 368 */     this._employeeTypeCode = dao.getEmployeeTypeCode();
/* 369 */     this._employeeWorkStatus = dao.getEmployeeWorkStatus();
/* 370 */     this._groupMembershipRaw = dao.getGroupMembershipRaw();
/* 371 */     this._hireDate = dao.getHireDate();
/* 372 */     this._jobTitle = dao.getJobTitle();
/* 373 */     this._lastReviewDate = dao.getLastReviewDate();
/* 374 */     this._maritalStatus = dao.getMaritalStatus();
/* 375 */     this._nextReviewDate = dao.getNextReviewDate();
/* 376 */     this._personalDays = dao.getPersonalDays();
/* 377 */     this._personalDaysUsed = dao.getPersonalDaysUsed();
/* 378 */     this._sickDays = dao.getSickDays();
/* 379 */     this._sickDaysUsed = dao.getSickDaysUsed();
/* 380 */     this._spouseName = dao.getSpouseName();
/* 381 */     this._terminatedDate = dao.getTerminatedDate();
/* 382 */     this._vacationDays = dao.getVacationDays();
/* 383 */     this._vacationDaysUsed = dao.getVacationDaysUsed();
/* 384 */     this._trainingStatusEnum = dao.getTrainingStatusEnum();
/* 385 */     this._lockedOut = (dao.getLockedOut() != null) ? dao.getLockedOut() : Boolean.valueOf(false);
/* 386 */     this._lockedOutTimestamp = dao.getLockedOutTimestamp();
/* 387 */     this._overtimeEligible = (dao.getOvertimeEligible() != null) ? dao.getOvertimeEligible() : Boolean.valueOf(false);
/* 388 */     this._primaryGroupId = dao.getPrimaryGroupId();
/* 389 */     this._departmentId = dao.getDepartmentId();
/* 390 */     this._partyId = dao.getPartyId();
/* 391 */     this._workCodeString = dao.getWorkCodeString();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 395 */     EmployeeId id = (EmployeeId)argId;
/* 396 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 397 */     argStatement.setString(2, id.getEmployeeId());
/* 398 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 402 */     EmployeeId id = new EmployeeId();
/* 403 */     id.setOrganizationId(this._organizationId);
/* 404 */     id.setEmployeeId(this._employeeId);
/* 405 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 413 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 417 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */