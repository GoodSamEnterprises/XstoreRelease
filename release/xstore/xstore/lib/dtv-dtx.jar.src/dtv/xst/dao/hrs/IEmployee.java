/*    */ package dtv.xst.dao.hrs;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IEmployee extends IDataModel, IEmployeeModel, IHasDataProperty<IEmployeeProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_EMPLOYEEID = new EventEnum("set employeeId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_LOGINID = new EventEnum("set loginId");
/* 16 */   public static final EventEnum SET_ACTIVEDATE = new EventEnum("set activeDate");
/* 17 */   public static final EventEnum SET_ADDDATE = new EventEnum("set addDate");
/* 18 */   public static final EventEnum SET_ADDITIONALWITHHOLDINGS = new EventEnum("set additionalWithholdings");
/* 19 */   public static final EventEnum SET_BASEPAY = new EventEnum("set basePay");
/* 20 */   public static final EventEnum SET_CLOCKINNOTREQUIRED = new EventEnum("set clockInNotRequired");
/* 21 */   public static final EventEnum SET_CLOCKEDIN = new EventEnum("set clockedIn");
/* 22 */   public static final EventEnum SET_EMERGENCYCONTACTNAME = new EventEnum("set emergencyContactName");
/* 23 */   public static final EventEnum SET_EMERGENCYCONTACTPHONE = new EventEnum("set emergencyContactPhone");
/* 24 */   public static final EventEnum SET_EMPLOYEEGROUP = new EventEnum("set employeeGroup");
/* 25 */   public static final EventEnum SET_EMPLOYEEPAYSTATUS = new EventEnum("set employeePayStatus");
/* 26 */   public static final EventEnum SET_EMPLOYEEROLECODE = new EventEnum("set employeeRoleCode");
/* 27 */   public static final EventEnum SET_EMPLOYEESTATUSCODE = new EventEnum("set employeeStatusCode");
/* 28 */   public static final EventEnum SET_EMPLOYEETYPECODE = new EventEnum("set employeeTypeCode");
/* 29 */   public static final EventEnum SET_EMPLOYEEWORKSTATUS = new EventEnum("set employeeWorkStatus");
/* 30 */   public static final EventEnum SET_GROUPMEMBERSHIPRAW = new EventEnum("set groupMembershipRaw");
/* 31 */   public static final EventEnum SET_HIREDATE = new EventEnum("set hireDate");
/* 32 */   public static final EventEnum SET_JOBTITLE = new EventEnum("set jobTitle");
/* 33 */   public static final EventEnum SET_LASTREVIEWDATE = new EventEnum("set lastReviewDate");
/* 34 */   public static final EventEnum SET_MARITALSTATUS = new EventEnum("set maritalStatus");
/* 35 */   public static final EventEnum SET_NEXTREVIEWDATE = new EventEnum("set nextReviewDate");
/* 36 */   public static final EventEnum SET_PERSONALDAYS = new EventEnum("set personalDays");
/* 37 */   public static final EventEnum SET_PERSONALDAYSUSED = new EventEnum("set personalDaysUsed");
/* 38 */   public static final EventEnum SET_SICKDAYS = new EventEnum("set sickDays");
/* 39 */   public static final EventEnum SET_SICKDAYSUSED = new EventEnum("set sickDaysUsed");
/* 40 */   public static final EventEnum SET_SPOUSENAME = new EventEnum("set spouseName");
/* 41 */   public static final EventEnum SET_TERMINATEDDATE = new EventEnum("set terminatedDate");
/* 42 */   public static final EventEnum SET_VACATIONDAYS = new EventEnum("set vacationDays");
/* 43 */   public static final EventEnum SET_VACATIONDAYSUSED = new EventEnum("set vacationDaysUsed");
/* 44 */   public static final EventEnum SET_TRAININGSTATUSENUM = new EventEnum("set trainingStatusEnum");
/* 45 */   public static final EventEnum SET_LOCKEDOUT = new EventEnum("set lockedOut");
/* 46 */   public static final EventEnum SET_LOCKEDOUTTIMESTAMP = new EventEnum("set lockedOutTimestamp");
/* 47 */   public static final EventEnum SET_OVERTIMEELIGIBLE = new EventEnum("set overtimeEligible");
/* 48 */   public static final EventEnum SET_PRIMARYGROUPID = new EventEnum("set primaryGroupId");
/* 49 */   public static final EventEnum SET_DEPARTMENTID = new EventEnum("set departmentId");
/* 50 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 51 */   public static final EventEnum SET_WORKCODESTRING = new EventEnum("set workCodeString");
/* 52 */   public static final EventEnum SET_PARTY = new EventEnum("set Party");
/* 53 */   public static final EventEnum SET_PRIMARYGROUP = new EventEnum("set PrimaryGroup");
/* 54 */   public static final EventEnum SET_WORKCODE = new EventEnum("set WorkCode");
/* 55 */   public static final EventEnum ADD_EMPLOYEESTORES = new EventEnum("add EmployeeStores");
/* 56 */   public static final EventEnum REMOVE_EMPLOYEESTORES = new EventEnum("remove EmployeeStores");
/* 57 */   public static final EventEnum SET_EMPLOYEESTORES = new EventEnum("set EmployeeStores");
/* 58 */   public static final EventEnum ADD_EMPLOYEENOTES = new EventEnum("add EmployeeNotes");
/* 59 */   public static final EventEnum REMOVE_EMPLOYEENOTES = new EventEnum("remove EmployeeNotes");
/* 60 */   public static final EventEnum SET_EMPLOYEENOTES = new EventEnum("set EmployeeNotes");
/* 61 */   public static final EventEnum ADD_EMPLOYEEANSWERS = new EventEnum("add EmployeeAnswers");
/* 62 */   public static final EventEnum REMOVE_EMPLOYEEANSWERS = new EventEnum("remove EmployeeAnswers");
/* 63 */   public static final EventEnum SET_EMPLOYEEANSWERS = new EventEnum("set EmployeeAnswers");
/* 64 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 65 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 66 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 67 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 68 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 69 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getEmployeeId();
/*    */   
/*    */   void setEmployeeId(String paramString);
/*    */   
/*    */   Date getCreateDate();
/*    */   
/*    */   void setCreateDate(Date paramDate);
/*    */   
/*    */   String getCreateUserId();
/*    */   
/*    */   void setCreateUserId(String paramString);
/*    */   
/*    */   Date getUpdateDate();
/*    */   
/*    */   void setUpdateDate(Date paramDate);
/*    */   
/*    */   String getUpdateUserId();
/*    */   
/*    */   void setUpdateUserId(String paramString);
/*    */   
/*    */   String getLoginId();
/*    */   
/*    */   void setLoginId(String paramString);
/*    */   
/*    */   Date getActiveDate();
/*    */   
/*    */   void setActiveDate(Date paramDate);
/*    */   
/*    */   Date getAddDate();
/*    */   
/*    */   void setAddDate(Date paramDate);
/*    */   
/*    */   BigDecimal getAdditionalWithholdings();
/*    */   
/*    */   void setAdditionalWithholdings(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getBasePay();
/*    */   
/*    */   void setBasePay(BigDecimal paramBigDecimal);
/*    */   
/*    */   boolean getClockInNotRequired();
/*    */   
/*    */   void setClockInNotRequired(boolean paramBoolean);
/*    */   
/*    */   boolean getClockedIn();
/*    */   
/*    */   void setClockedIn(boolean paramBoolean);
/*    */   
/*    */   String getEmergencyContactName();
/*    */   
/*    */   void setEmergencyContactName(String paramString);
/*    */   
/*    */   String getEmergencyContactPhone();
/*    */   
/*    */   void setEmergencyContactPhone(String paramString);
/*    */   
/*    */   String getEmployeeGroup();
/*    */   
/*    */   void setEmployeeGroup(String paramString);
/*    */   
/*    */   String getEmployeePayStatus();
/*    */   
/*    */   void setEmployeePayStatus(String paramString);
/*    */   
/*    */   String getEmployeeRoleCode();
/*    */   
/*    */   void setEmployeeRoleCode(String paramString);
/*    */   
/*    */   String getEmployeeStatusCode();
/*    */   
/*    */   void setEmployeeStatusCode(String paramString);
/*    */   
/*    */   String getEmployeeTypeCode();
/*    */   
/*    */   void setEmployeeTypeCode(String paramString);
/*    */   
/*    */   String getEmployeeWorkStatus();
/*    */   
/*    */   void setEmployeeWorkStatus(String paramString);
/*    */   
/*    */   String getGroupMembershipRaw();
/*    */   
/*    */   void setGroupMembershipRaw(String paramString);
/*    */   
/*    */   Date getHireDate();
/*    */   
/*    */   void setHireDate(Date paramDate);
/*    */   
/*    */   String getJobTitle();
/*    */   
/*    */   void setJobTitle(String paramString);
/*    */   
/*    */   Date getLastReviewDate();
/*    */   
/*    */   void setLastReviewDate(Date paramDate);
/*    */   
/*    */   String getMaritalStatus();
/*    */   
/*    */   void setMaritalStatus(String paramString);
/*    */   
/*    */   Date getNextReviewDate();
/*    */   
/*    */   void setNextReviewDate(Date paramDate);
/*    */   
/*    */   BigDecimal getPersonalDays();
/*    */   
/*    */   void setPersonalDays(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getPersonalDaysUsed();
/*    */   
/*    */   void setPersonalDaysUsed(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getSickDays();
/*    */   
/*    */   void setSickDays(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getSickDaysUsed();
/*    */   
/*    */   void setSickDaysUsed(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getSpouseName();
/*    */   
/*    */   void setSpouseName(String paramString);
/*    */   
/*    */   Date getTerminatedDate();
/*    */   
/*    */   void setTerminatedDate(Date paramDate);
/*    */   
/*    */   BigDecimal getVacationDays();
/*    */   
/*    */   void setVacationDays(BigDecimal paramBigDecimal);
/*    */   
/*    */   BigDecimal getVacationDaysUsed();
/*    */   
/*    */   void setVacationDaysUsed(BigDecimal paramBigDecimal);
/*    */   
/*    */   String getTrainingStatusEnum();
/*    */   
/*    */   void setTrainingStatusEnum(String paramString);
/*    */   
/*    */   Date getLockedOutTimestamp();
/*    */   
/*    */   void setLockedOutTimestamp(Date paramDate);
/*    */   
/*    */   boolean getOvertimeEligible();
/*    */   
/*    */   void setOvertimeEligible(boolean paramBoolean);
/*    */   
/*    */   String getPrimaryGroupId();
/*    */   
/*    */   void setPrimaryGroupId(String paramString);
/*    */   
/*    */   String getDepartmentId();
/*    */   
/*    */   void setDepartmentId(String paramString);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   String getWorkCodeString();
/*    */   
/*    */   void setWorkCodeString(String paramString);
/*    */   
/*    */   IDataModel getEmployeeExt();
/*    */   
/*    */   void setEmployeeExt(IDataModel paramIDataModel);
/*    */   
/*    */   IParty getParty();
/*    */   
/*    */   void setParty(IParty paramIParty);
/*    */   
/*    */   IGroup getPrimaryGroup();
/*    */   
/*    */   void setPrimaryGroup(IGroup paramIGroup);
/*    */   
/*    */   IWorkCodes getWorkCode();
/*    */   
/*    */   void setWorkCode(IWorkCodes paramIWorkCodes);
/*    */   
/*    */   List<IEmployeeStore> getEmployeeStores();
/*    */   
/*    */   void setEmployeeStores(List<IEmployeeStore> paramList);
/*    */   
/*    */   void addEmployeeStore(IEmployeeStore paramIEmployeeStore);
/*    */   
/*    */   void removeEmployeeStore(IEmployeeStore paramIEmployeeStore);
/*    */   
/*    */   List<IEmployeeNote> getEmployeeNotes();
/*    */   
/*    */   void setEmployeeNotes(List<IEmployeeNote> paramList);
/*    */   
/*    */   void addEmployeeNote(IEmployeeNote paramIEmployeeNote);
/*    */   
/*    */   void removeEmployeeNote(IEmployeeNote paramIEmployeeNote);
/*    */   
/*    */   List<IEmployeeAnswers> getEmployeeAnswers();
/*    */   
/*    */   void setEmployeeAnswers(List<IEmployeeAnswers> paramList);
/*    */   
/*    */   void addEmployeeAnswers(IEmployeeAnswers paramIEmployeeAnswers);
/*    */   
/*    */   void removeEmployeeAnswers(IEmployeeAnswers paramIEmployeeAnswers);
/*    */   
/*    */   List<IEmployeeProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IEmployeeProperty> paramList);
/*    */   
/*    */   void addEmployeeProperty(IEmployeeProperty paramIEmployeeProperty);
/*    */   
/*    */   void removeEmployeeProperty(IEmployeeProperty paramIEmployeeProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\IEmployee.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */