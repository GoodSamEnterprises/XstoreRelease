/*      */ package dtv.xst.dao.hrs.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.crm.IParty;
/*      */ import dtv.xst.dao.hrs.IEmployee;
/*      */ import dtv.xst.dao.hrs.IEmployeeAnswers;
/*      */ import dtv.xst.dao.hrs.IEmployeeNote;
/*      */ import dtv.xst.dao.hrs.IEmployeeProperty;
/*      */ import dtv.xst.dao.hrs.IEmployeeStore;
/*      */ import dtv.xst.dao.hrs.IWorkCodes;
/*      */ import dtv.xst.dao.sec.IGroup;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class EmployeeModel extends EmployeeBaseModel implements IEmployee {
/*      */   private static final long serialVersionUID = 1258113742L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private IParty _party;
/*      */   private transient IParty _partySavepoint;
/*      */   private IGroup _primaryGroup;
/*      */   private transient IGroup _primaryGroupSavepoint;
/*      */   private IWorkCodes _workCode;
/*      */   
/*      */   public String toString() {
/*   37 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient IWorkCodes _workCodeSavepoint; private HistoricalList<IEmployeeStore> _employeeStores; private transient HistoricalList<IEmployeeStore> _employeeStoresSavepoint; private HistoricalList<IEmployeeNote> _employeeNotes; private transient HistoricalList<IEmployeeNote> _employeeNotesSavepoint; private HistoricalList<IEmployeeAnswers> _employeeAnswers; private transient HistoricalList<IEmployeeAnswers> _employeeAnswersSavepoint; private HistoricalList<IEmployeeProperty> _properties; private transient HistoricalList<IEmployeeProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   42 */     setDAO((IDataAccessObject)new EmployeeDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private EmployeeDAO getDAO_() {
/*   50 */     return (EmployeeDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   58 */     if (getDAO_().getOrganizationId() != null) {
/*   59 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   62 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   71 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   72 */       this._events != null && 
/*   73 */       postEventsForChanges()) {
/*   74 */       this._events.post(IEmployee.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   81 */     boolean ev_postable = false;
/*      */     
/*   83 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   84 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   85 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   86 */       ev_postable = true;
/*   87 */       if (this._employeeStores != null) {
/*      */         
/*   89 */         Iterator<EmployeeStoreModel> it = this._employeeStores.iterator();
/*   90 */         while (it.hasNext())
/*      */         {
/*   92 */           ((EmployeeStoreModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   95 */       if (this._employeeNotes != null) {
/*      */         
/*   97 */         Iterator<EmployeeNoteModel> it = this._employeeNotes.iterator();
/*   98 */         while (it.hasNext())
/*      */         {
/*  100 */           ((EmployeeNoteModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  103 */       if (this._employeeAnswers != null) {
/*      */         
/*  105 */         Iterator<EmployeeAnswersModel> it = this._employeeAnswers.iterator();
/*  106 */         while (it.hasNext())
/*      */         {
/*  108 */           ((EmployeeAnswersModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  111 */       if (this._properties != null) {
/*      */         
/*  113 */         Iterator<EmployeePropertyModel> it = this._properties.iterator();
/*  114 */         while (it.hasNext())
/*      */         {
/*  116 */           ((EmployeePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  121 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEmployeeId() {
/*  129 */     return getDAO_().getEmployeeId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEmployeeId(String argEmployeeId) {
/*  137 */     if (setEmployeeId_noev(argEmployeeId) && 
/*  138 */       this._events != null && 
/*  139 */       postEventsForChanges()) {
/*  140 */       this._events.post(IEmployee.SET_EMPLOYEEID, argEmployeeId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEmployeeId_noev(String argEmployeeId) {
/*  147 */     boolean ev_postable = false;
/*      */     
/*  149 */     if ((getDAO_().getEmployeeId() == null && argEmployeeId != null) || (
/*  150 */       getDAO_().getEmployeeId() != null && !getDAO_().getEmployeeId().equals(argEmployeeId))) {
/*  151 */       getDAO_().setEmployeeId(argEmployeeId);
/*  152 */       ev_postable = true;
/*  153 */       if (this._employeeStores != null) {
/*      */         
/*  155 */         Iterator<EmployeeStoreModel> it = this._employeeStores.iterator();
/*  156 */         while (it.hasNext())
/*      */         {
/*  158 */           ((EmployeeStoreModel)it.next()).setEmployeeId_noev(argEmployeeId);
/*      */         }
/*      */       } 
/*  161 */       if (this._employeeNotes != null) {
/*      */         
/*  163 */         Iterator<EmployeeNoteModel> it = this._employeeNotes.iterator();
/*  164 */         while (it.hasNext())
/*      */         {
/*  166 */           ((EmployeeNoteModel)it.next()).setEmployeeId_noev(argEmployeeId);
/*      */         }
/*      */       } 
/*  169 */       if (this._employeeAnswers != null) {
/*      */         
/*  171 */         Iterator<EmployeeAnswersModel> it = this._employeeAnswers.iterator();
/*  172 */         while (it.hasNext())
/*      */         {
/*  174 */           ((EmployeeAnswersModel)it.next()).setEmployeeId_noev(argEmployeeId);
/*      */         }
/*      */       } 
/*  177 */       if (this._properties != null) {
/*      */         
/*  179 */         Iterator<EmployeePropertyModel> it = this._properties.iterator();
/*  180 */         while (it.hasNext())
/*      */         {
/*  182 */           ((EmployeePropertyModel)it.next()).setEmployeeId_noev(argEmployeeId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  187 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  195 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  203 */     if (setCreateDate_noev(argCreateDate) && 
/*  204 */       this._events != null && 
/*  205 */       postEventsForChanges()) {
/*  206 */       this._events.post(IEmployee.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  213 */     boolean ev_postable = false;
/*      */     
/*  215 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  216 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  217 */       getDAO_().setCreateDate(argCreateDate);
/*  218 */       ev_postable = true;
/*      */     } 
/*      */     
/*  221 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  229 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  237 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  238 */       this._events != null && 
/*  239 */       postEventsForChanges()) {
/*  240 */       this._events.post(IEmployee.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  247 */     boolean ev_postable = false;
/*      */     
/*  249 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  250 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  251 */       getDAO_().setCreateUserId(argCreateUserId);
/*  252 */       ev_postable = true;
/*      */     } 
/*      */     
/*  255 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  263 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  271 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  272 */       this._events != null && 
/*  273 */       postEventsForChanges()) {
/*  274 */       this._events.post(IEmployee.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  281 */     boolean ev_postable = false;
/*      */     
/*  283 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  284 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  285 */       getDAO_().setUpdateDate(argUpdateDate);
/*  286 */       ev_postable = true;
/*      */     } 
/*      */     
/*  289 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  297 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  305 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  306 */       this._events != null && 
/*  307 */       postEventsForChanges()) {
/*  308 */       this._events.post(IEmployee.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  315 */     boolean ev_postable = false;
/*      */     
/*  317 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  318 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  319 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  320 */       ev_postable = true;
/*      */     } 
/*      */     
/*  323 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLoginId() {
/*  331 */     return getDAO_().getLoginId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLoginId(String argLoginId) {
/*  339 */     if (setLoginId_noev(argLoginId) && 
/*  340 */       this._events != null && 
/*  341 */       postEventsForChanges()) {
/*  342 */       this._events.post(IEmployee.SET_LOGINID, argLoginId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLoginId_noev(String argLoginId) {
/*  349 */     boolean ev_postable = false;
/*      */     
/*  351 */     if ((getDAO_().getLoginId() == null && argLoginId != null) || (
/*  352 */       getDAO_().getLoginId() != null && !getDAO_().getLoginId().equals(argLoginId))) {
/*  353 */       getDAO_().setLoginId(argLoginId);
/*  354 */       ev_postable = true;
/*      */     } 
/*      */     
/*  357 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getActiveDate() {
/*  365 */     return getDAO_().getActiveDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActiveDate(Date argActiveDate) {
/*  373 */     if (setActiveDate_noev(argActiveDate) && 
/*  374 */       this._events != null && 
/*  375 */       postEventsForChanges()) {
/*  376 */       this._events.post(IEmployee.SET_ACTIVEDATE, argActiveDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setActiveDate_noev(Date argActiveDate) {
/*  383 */     boolean ev_postable = false;
/*      */     
/*  385 */     if ((getDAO_().getActiveDate() == null && argActiveDate != null) || (
/*  386 */       getDAO_().getActiveDate() != null && !getDAO_().getActiveDate().equals(argActiveDate))) {
/*  387 */       getDAO_().setActiveDate(argActiveDate);
/*  388 */       ev_postable = true;
/*      */     } 
/*      */     
/*  391 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getAddDate() {
/*  399 */     return getDAO_().getAddDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAddDate(Date argAddDate) {
/*  407 */     if (setAddDate_noev(argAddDate) && 
/*  408 */       this._events != null && 
/*  409 */       postEventsForChanges()) {
/*  410 */       this._events.post(IEmployee.SET_ADDDATE, argAddDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAddDate_noev(Date argAddDate) {
/*  417 */     boolean ev_postable = false;
/*      */     
/*  419 */     if ((getDAO_().getAddDate() == null && argAddDate != null) || (
/*  420 */       getDAO_().getAddDate() != null && !getDAO_().getAddDate().equals(argAddDate))) {
/*  421 */       getDAO_().setAddDate(argAddDate);
/*  422 */       ev_postable = true;
/*      */     } 
/*      */     
/*  425 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAdditionalWithholdings() {
/*  433 */     return getDAO_().getAdditionalWithholdings();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAdditionalWithholdings(BigDecimal argAdditionalWithholdings) {
/*  441 */     if (setAdditionalWithholdings_noev(argAdditionalWithholdings) && 
/*  442 */       this._events != null && 
/*  443 */       postEventsForChanges()) {
/*  444 */       this._events.post(IEmployee.SET_ADDITIONALWITHHOLDINGS, argAdditionalWithholdings);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAdditionalWithholdings_noev(BigDecimal argAdditionalWithholdings) {
/*  451 */     boolean ev_postable = false;
/*      */     
/*  453 */     if ((getDAO_().getAdditionalWithholdings() == null && argAdditionalWithholdings != null) || (
/*  454 */       getDAO_().getAdditionalWithholdings() != null && !getDAO_().getAdditionalWithholdings().equals(argAdditionalWithholdings))) {
/*  455 */       getDAO_().setAdditionalWithholdings(argAdditionalWithholdings);
/*  456 */       ev_postable = true;
/*      */     } 
/*      */     
/*  459 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getBasePay() {
/*  467 */     return getDAO_().getBasePay();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBasePay(BigDecimal argBasePay) {
/*  475 */     if (setBasePay_noev(argBasePay) && 
/*  476 */       this._events != null && 
/*  477 */       postEventsForChanges()) {
/*  478 */       this._events.post(IEmployee.SET_BASEPAY, argBasePay);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBasePay_noev(BigDecimal argBasePay) {
/*  485 */     boolean ev_postable = false;
/*      */     
/*  487 */     if ((getDAO_().getBasePay() == null && argBasePay != null) || (
/*  488 */       getDAO_().getBasePay() != null && !getDAO_().getBasePay().equals(argBasePay))) {
/*  489 */       getDAO_().setBasePay(argBasePay);
/*  490 */       ev_postable = true;
/*      */     } 
/*      */     
/*  493 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getClockInNotRequired() {
/*  501 */     if (getDAO_().getClockInNotRequired() != null) {
/*  502 */       return getDAO_().getClockInNotRequired().booleanValue();
/*      */     }
/*      */     
/*  505 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClockInNotRequired(boolean argClockInNotRequired) {
/*  514 */     if (setClockInNotRequired_noev(argClockInNotRequired) && 
/*  515 */       this._events != null && 
/*  516 */       postEventsForChanges()) {
/*  517 */       this._events.post(IEmployee.SET_CLOCKINNOTREQUIRED, Boolean.valueOf(argClockInNotRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setClockInNotRequired_noev(boolean argClockInNotRequired) {
/*  524 */     boolean ev_postable = false;
/*      */     
/*  526 */     if ((getDAO_().getClockInNotRequired() == null && Boolean.valueOf(argClockInNotRequired) != null) || (
/*  527 */       getDAO_().getClockInNotRequired() != null && !getDAO_().getClockInNotRequired().equals(Boolean.valueOf(argClockInNotRequired)))) {
/*  528 */       getDAO_().setClockInNotRequired(Boolean.valueOf(argClockInNotRequired));
/*  529 */       ev_postable = true;
/*      */     } 
/*      */     
/*  532 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getClockedIn() {
/*  540 */     if (getDAO_().getClockedIn() != null) {
/*  541 */       return getDAO_().getClockedIn().booleanValue();
/*      */     }
/*      */     
/*  544 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClockedIn(boolean argClockedIn) {
/*  553 */     if (setClockedIn_noev(argClockedIn) && 
/*  554 */       this._events != null && 
/*  555 */       postEventsForChanges()) {
/*  556 */       this._events.post(IEmployee.SET_CLOCKEDIN, Boolean.valueOf(argClockedIn));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setClockedIn_noev(boolean argClockedIn) {
/*  563 */     boolean ev_postable = false;
/*      */     
/*  565 */     if ((getDAO_().getClockedIn() == null && Boolean.valueOf(argClockedIn) != null) || (
/*  566 */       getDAO_().getClockedIn() != null && !getDAO_().getClockedIn().equals(Boolean.valueOf(argClockedIn)))) {
/*  567 */       getDAO_().setClockedIn(Boolean.valueOf(argClockedIn));
/*  568 */       ev_postable = true;
/*      */     } 
/*      */     
/*  571 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEmergencyContactName() {
/*  579 */     return getDAO_().getEmergencyContactName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEmergencyContactName(String argEmergencyContactName) {
/*  587 */     if (setEmergencyContactName_noev(argEmergencyContactName) && 
/*  588 */       this._events != null && 
/*  589 */       postEventsForChanges()) {
/*  590 */       this._events.post(IEmployee.SET_EMERGENCYCONTACTNAME, argEmergencyContactName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEmergencyContactName_noev(String argEmergencyContactName) {
/*  597 */     boolean ev_postable = false;
/*      */     
/*  599 */     if ((getDAO_().getEmergencyContactName() == null && argEmergencyContactName != null) || (
/*  600 */       getDAO_().getEmergencyContactName() != null && !getDAO_().getEmergencyContactName().equals(argEmergencyContactName))) {
/*  601 */       getDAO_().setEmergencyContactName(argEmergencyContactName);
/*  602 */       ev_postable = true;
/*      */     } 
/*      */     
/*  605 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEmergencyContactPhone() {
/*  613 */     return getDAO_().getEmergencyContactPhone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEmergencyContactPhone(String argEmergencyContactPhone) {
/*  621 */     if (setEmergencyContactPhone_noev(argEmergencyContactPhone) && 
/*  622 */       this._events != null && 
/*  623 */       postEventsForChanges()) {
/*  624 */       this._events.post(IEmployee.SET_EMERGENCYCONTACTPHONE, argEmergencyContactPhone);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEmergencyContactPhone_noev(String argEmergencyContactPhone) {
/*  631 */     boolean ev_postable = false;
/*      */     
/*  633 */     if ((getDAO_().getEmergencyContactPhone() == null && argEmergencyContactPhone != null) || (
/*  634 */       getDAO_().getEmergencyContactPhone() != null && !getDAO_().getEmergencyContactPhone().equals(argEmergencyContactPhone))) {
/*  635 */       getDAO_().setEmergencyContactPhone(argEmergencyContactPhone);
/*  636 */       ev_postable = true;
/*      */     } 
/*      */     
/*  639 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEmployeeGroup() {
/*  647 */     return getDAO_().getEmployeeGroup();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEmployeeGroup(String argEmployeeGroup) {
/*  655 */     if (setEmployeeGroup_noev(argEmployeeGroup) && 
/*  656 */       this._events != null && 
/*  657 */       postEventsForChanges()) {
/*  658 */       this._events.post(IEmployee.SET_EMPLOYEEGROUP, argEmployeeGroup);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEmployeeGroup_noev(String argEmployeeGroup) {
/*  665 */     boolean ev_postable = false;
/*      */     
/*  667 */     if ((getDAO_().getEmployeeGroup() == null && argEmployeeGroup != null) || (
/*  668 */       getDAO_().getEmployeeGroup() != null && !getDAO_().getEmployeeGroup().equals(argEmployeeGroup))) {
/*  669 */       getDAO_().setEmployeeGroup(argEmployeeGroup);
/*  670 */       ev_postable = true;
/*      */     } 
/*      */     
/*  673 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEmployeePayStatus() {
/*  681 */     return getDAO_().getEmployeePayStatus();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEmployeePayStatus(String argEmployeePayStatus) {
/*  689 */     if (setEmployeePayStatus_noev(argEmployeePayStatus) && 
/*  690 */       this._events != null && 
/*  691 */       postEventsForChanges()) {
/*  692 */       this._events.post(IEmployee.SET_EMPLOYEEPAYSTATUS, argEmployeePayStatus);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEmployeePayStatus_noev(String argEmployeePayStatus) {
/*  699 */     boolean ev_postable = false;
/*      */     
/*  701 */     if ((getDAO_().getEmployeePayStatus() == null && argEmployeePayStatus != null) || (
/*  702 */       getDAO_().getEmployeePayStatus() != null && !getDAO_().getEmployeePayStatus().equals(argEmployeePayStatus))) {
/*  703 */       getDAO_().setEmployeePayStatus(argEmployeePayStatus);
/*  704 */       ev_postable = true;
/*      */     } 
/*      */     
/*  707 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEmployeeRoleCode() {
/*  715 */     return getDAO_().getEmployeeRoleCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEmployeeRoleCode(String argEmployeeRoleCode) {
/*  723 */     if (setEmployeeRoleCode_noev(argEmployeeRoleCode) && 
/*  724 */       this._events != null && 
/*  725 */       postEventsForChanges()) {
/*  726 */       this._events.post(IEmployee.SET_EMPLOYEEROLECODE, argEmployeeRoleCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEmployeeRoleCode_noev(String argEmployeeRoleCode) {
/*  733 */     boolean ev_postable = false;
/*      */     
/*  735 */     if ((getDAO_().getEmployeeRoleCode() == null && argEmployeeRoleCode != null) || (
/*  736 */       getDAO_().getEmployeeRoleCode() != null && !getDAO_().getEmployeeRoleCode().equals(argEmployeeRoleCode))) {
/*  737 */       getDAO_().setEmployeeRoleCode(argEmployeeRoleCode);
/*  738 */       ev_postable = true;
/*      */     } 
/*      */     
/*  741 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEmployeeStatusCode() {
/*  749 */     return getDAO_().getEmployeeStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEmployeeStatusCode(String argEmployeeStatusCode) {
/*  757 */     if (setEmployeeStatusCode_noev(argEmployeeStatusCode) && 
/*  758 */       this._events != null && 
/*  759 */       postEventsForChanges()) {
/*  760 */       this._events.post(IEmployee.SET_EMPLOYEESTATUSCODE, argEmployeeStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEmployeeStatusCode_noev(String argEmployeeStatusCode) {
/*  767 */     boolean ev_postable = false;
/*      */     
/*  769 */     if ((getDAO_().getEmployeeStatusCode() == null && argEmployeeStatusCode != null) || (
/*  770 */       getDAO_().getEmployeeStatusCode() != null && !getDAO_().getEmployeeStatusCode().equals(argEmployeeStatusCode))) {
/*  771 */       getDAO_().setEmployeeStatusCode(argEmployeeStatusCode);
/*  772 */       ev_postable = true;
/*      */     } 
/*      */     
/*  775 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEmployeeTypeCode() {
/*  783 */     return getDAO_().getEmployeeTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEmployeeTypeCode(String argEmployeeTypeCode) {
/*  791 */     if (setEmployeeTypeCode_noev(argEmployeeTypeCode) && 
/*  792 */       this._events != null && 
/*  793 */       postEventsForChanges()) {
/*  794 */       this._events.post(IEmployee.SET_EMPLOYEETYPECODE, argEmployeeTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEmployeeTypeCode_noev(String argEmployeeTypeCode) {
/*  801 */     boolean ev_postable = false;
/*      */     
/*  803 */     if ((getDAO_().getEmployeeTypeCode() == null && argEmployeeTypeCode != null) || (
/*  804 */       getDAO_().getEmployeeTypeCode() != null && !getDAO_().getEmployeeTypeCode().equals(argEmployeeTypeCode))) {
/*  805 */       getDAO_().setEmployeeTypeCode(argEmployeeTypeCode);
/*  806 */       ev_postable = true;
/*      */     } 
/*      */     
/*  809 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEmployeeWorkStatus() {
/*  817 */     return getDAO_().getEmployeeWorkStatus();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEmployeeWorkStatus(String argEmployeeWorkStatus) {
/*  825 */     if (setEmployeeWorkStatus_noev(argEmployeeWorkStatus) && 
/*  826 */       this._events != null && 
/*  827 */       postEventsForChanges()) {
/*  828 */       this._events.post(IEmployee.SET_EMPLOYEEWORKSTATUS, argEmployeeWorkStatus);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEmployeeWorkStatus_noev(String argEmployeeWorkStatus) {
/*  835 */     boolean ev_postable = false;
/*      */     
/*  837 */     if ((getDAO_().getEmployeeWorkStatus() == null && argEmployeeWorkStatus != null) || (
/*  838 */       getDAO_().getEmployeeWorkStatus() != null && !getDAO_().getEmployeeWorkStatus().equals(argEmployeeWorkStatus))) {
/*  839 */       getDAO_().setEmployeeWorkStatus(argEmployeeWorkStatus);
/*  840 */       ev_postable = true;
/*      */     } 
/*      */     
/*  843 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getGroupMembershipRaw() {
/*  851 */     return getDAO_().getGroupMembershipRaw();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGroupMembershipRaw(String argGroupMembershipRaw) {
/*  859 */     if (setGroupMembershipRaw_noev(argGroupMembershipRaw) && 
/*  860 */       this._events != null && 
/*  861 */       postEventsForChanges()) {
/*  862 */       this._events.post(IEmployee.SET_GROUPMEMBERSHIPRAW, argGroupMembershipRaw);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGroupMembershipRaw_noev(String argGroupMembershipRaw) {
/*  869 */     boolean ev_postable = false;
/*      */     
/*  871 */     if ((getDAO_().getGroupMembershipRaw() == null && argGroupMembershipRaw != null) || (
/*  872 */       getDAO_().getGroupMembershipRaw() != null && !getDAO_().getGroupMembershipRaw().equals(argGroupMembershipRaw))) {
/*  873 */       getDAO_().setGroupMembershipRaw(argGroupMembershipRaw);
/*  874 */       ev_postable = true;
/*      */     } 
/*      */     
/*  877 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getHireDate() {
/*  885 */     return getDAO_().getHireDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHireDate(Date argHireDate) {
/*  893 */     if (setHireDate_noev(argHireDate) && 
/*  894 */       this._events != null && 
/*  895 */       postEventsForChanges()) {
/*  896 */       this._events.post(IEmployee.SET_HIREDATE, argHireDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setHireDate_noev(Date argHireDate) {
/*  903 */     boolean ev_postable = false;
/*      */     
/*  905 */     if ((getDAO_().getHireDate() == null && argHireDate != null) || (
/*  906 */       getDAO_().getHireDate() != null && !getDAO_().getHireDate().equals(argHireDate))) {
/*  907 */       getDAO_().setHireDate(argHireDate);
/*  908 */       ev_postable = true;
/*      */     } 
/*      */     
/*  911 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getJobTitle() {
/*  919 */     return getDAO_().getJobTitle();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setJobTitle(String argJobTitle) {
/*  927 */     if (setJobTitle_noev(argJobTitle) && 
/*  928 */       this._events != null && 
/*  929 */       postEventsForChanges()) {
/*  930 */       this._events.post(IEmployee.SET_JOBTITLE, argJobTitle);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setJobTitle_noev(String argJobTitle) {
/*  937 */     boolean ev_postable = false;
/*      */     
/*  939 */     if ((getDAO_().getJobTitle() == null && argJobTitle != null) || (
/*  940 */       getDAO_().getJobTitle() != null && !getDAO_().getJobTitle().equals(argJobTitle))) {
/*  941 */       getDAO_().setJobTitle(argJobTitle);
/*  942 */       ev_postable = true;
/*      */     } 
/*      */     
/*  945 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getLastReviewDate() {
/*  953 */     return getDAO_().getLastReviewDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLastReviewDate(Date argLastReviewDate) {
/*  961 */     if (setLastReviewDate_noev(argLastReviewDate) && 
/*  962 */       this._events != null && 
/*  963 */       postEventsForChanges()) {
/*  964 */       this._events.post(IEmployee.SET_LASTREVIEWDATE, argLastReviewDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLastReviewDate_noev(Date argLastReviewDate) {
/*  971 */     boolean ev_postable = false;
/*      */     
/*  973 */     if ((getDAO_().getLastReviewDate() == null && argLastReviewDate != null) || (
/*  974 */       getDAO_().getLastReviewDate() != null && !getDAO_().getLastReviewDate().equals(argLastReviewDate))) {
/*  975 */       getDAO_().setLastReviewDate(argLastReviewDate);
/*  976 */       ev_postable = true;
/*      */     } 
/*      */     
/*  979 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getMaritalStatus() {
/*  987 */     return getDAO_().getMaritalStatus();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaritalStatus(String argMaritalStatus) {
/*  995 */     if (setMaritalStatus_noev(argMaritalStatus) && 
/*  996 */       this._events != null && 
/*  997 */       postEventsForChanges()) {
/*  998 */       this._events.post(IEmployee.SET_MARITALSTATUS, argMaritalStatus);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMaritalStatus_noev(String argMaritalStatus) {
/* 1005 */     boolean ev_postable = false;
/*      */     
/* 1007 */     if ((getDAO_().getMaritalStatus() == null && argMaritalStatus != null) || (
/* 1008 */       getDAO_().getMaritalStatus() != null && !getDAO_().getMaritalStatus().equals(argMaritalStatus))) {
/* 1009 */       getDAO_().setMaritalStatus(argMaritalStatus);
/* 1010 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1013 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getNextReviewDate() {
/* 1021 */     return getDAO_().getNextReviewDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNextReviewDate(Date argNextReviewDate) {
/* 1029 */     if (setNextReviewDate_noev(argNextReviewDate) && 
/* 1030 */       this._events != null && 
/* 1031 */       postEventsForChanges()) {
/* 1032 */       this._events.post(IEmployee.SET_NEXTREVIEWDATE, argNextReviewDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNextReviewDate_noev(Date argNextReviewDate) {
/* 1039 */     boolean ev_postable = false;
/*      */     
/* 1041 */     if ((getDAO_().getNextReviewDate() == null && argNextReviewDate != null) || (
/* 1042 */       getDAO_().getNextReviewDate() != null && !getDAO_().getNextReviewDate().equals(argNextReviewDate))) {
/* 1043 */       getDAO_().setNextReviewDate(argNextReviewDate);
/* 1044 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1047 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPersonalDays() {
/* 1055 */     return getDAO_().getPersonalDays();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPersonalDays(BigDecimal argPersonalDays) {
/* 1063 */     if (setPersonalDays_noev(argPersonalDays) && 
/* 1064 */       this._events != null && 
/* 1065 */       postEventsForChanges()) {
/* 1066 */       this._events.post(IEmployee.SET_PERSONALDAYS, argPersonalDays);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPersonalDays_noev(BigDecimal argPersonalDays) {
/* 1073 */     boolean ev_postable = false;
/*      */     
/* 1075 */     if ((getDAO_().getPersonalDays() == null && argPersonalDays != null) || (
/* 1076 */       getDAO_().getPersonalDays() != null && !getDAO_().getPersonalDays().equals(argPersonalDays))) {
/* 1077 */       getDAO_().setPersonalDays(argPersonalDays);
/* 1078 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1081 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPersonalDaysUsed() {
/* 1089 */     return getDAO_().getPersonalDaysUsed();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPersonalDaysUsed(BigDecimal argPersonalDaysUsed) {
/* 1097 */     if (setPersonalDaysUsed_noev(argPersonalDaysUsed) && 
/* 1098 */       this._events != null && 
/* 1099 */       postEventsForChanges()) {
/* 1100 */       this._events.post(IEmployee.SET_PERSONALDAYSUSED, argPersonalDaysUsed);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPersonalDaysUsed_noev(BigDecimal argPersonalDaysUsed) {
/* 1107 */     boolean ev_postable = false;
/*      */     
/* 1109 */     if ((getDAO_().getPersonalDaysUsed() == null && argPersonalDaysUsed != null) || (
/* 1110 */       getDAO_().getPersonalDaysUsed() != null && !getDAO_().getPersonalDaysUsed().equals(argPersonalDaysUsed))) {
/* 1111 */       getDAO_().setPersonalDaysUsed(argPersonalDaysUsed);
/* 1112 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1115 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getSickDays() {
/* 1123 */     return getDAO_().getSickDays();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSickDays(BigDecimal argSickDays) {
/* 1131 */     if (setSickDays_noev(argSickDays) && 
/* 1132 */       this._events != null && 
/* 1133 */       postEventsForChanges()) {
/* 1134 */       this._events.post(IEmployee.SET_SICKDAYS, argSickDays);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSickDays_noev(BigDecimal argSickDays) {
/* 1141 */     boolean ev_postable = false;
/*      */     
/* 1143 */     if ((getDAO_().getSickDays() == null && argSickDays != null) || (
/* 1144 */       getDAO_().getSickDays() != null && !getDAO_().getSickDays().equals(argSickDays))) {
/* 1145 */       getDAO_().setSickDays(argSickDays);
/* 1146 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1149 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getSickDaysUsed() {
/* 1157 */     return getDAO_().getSickDaysUsed();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSickDaysUsed(BigDecimal argSickDaysUsed) {
/* 1165 */     if (setSickDaysUsed_noev(argSickDaysUsed) && 
/* 1166 */       this._events != null && 
/* 1167 */       postEventsForChanges()) {
/* 1168 */       this._events.post(IEmployee.SET_SICKDAYSUSED, argSickDaysUsed);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSickDaysUsed_noev(BigDecimal argSickDaysUsed) {
/* 1175 */     boolean ev_postable = false;
/*      */     
/* 1177 */     if ((getDAO_().getSickDaysUsed() == null && argSickDaysUsed != null) || (
/* 1178 */       getDAO_().getSickDaysUsed() != null && !getDAO_().getSickDaysUsed().equals(argSickDaysUsed))) {
/* 1179 */       getDAO_().setSickDaysUsed(argSickDaysUsed);
/* 1180 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1183 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSpouseName() {
/* 1191 */     return getDAO_().getSpouseName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSpouseName(String argSpouseName) {
/* 1199 */     if (setSpouseName_noev(argSpouseName) && 
/* 1200 */       this._events != null && 
/* 1201 */       postEventsForChanges()) {
/* 1202 */       this._events.post(IEmployee.SET_SPOUSENAME, argSpouseName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSpouseName_noev(String argSpouseName) {
/* 1209 */     boolean ev_postable = false;
/*      */     
/* 1211 */     if ((getDAO_().getSpouseName() == null && argSpouseName != null) || (
/* 1212 */       getDAO_().getSpouseName() != null && !getDAO_().getSpouseName().equals(argSpouseName))) {
/* 1213 */       getDAO_().setSpouseName(argSpouseName);
/* 1214 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1217 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getTerminatedDate() {
/* 1225 */     return getDAO_().getTerminatedDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTerminatedDate(Date argTerminatedDate) {
/* 1233 */     if (setTerminatedDate_noev(argTerminatedDate) && 
/* 1234 */       this._events != null && 
/* 1235 */       postEventsForChanges()) {
/* 1236 */       this._events.post(IEmployee.SET_TERMINATEDDATE, argTerminatedDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTerminatedDate_noev(Date argTerminatedDate) {
/* 1243 */     boolean ev_postable = false;
/*      */     
/* 1245 */     if ((getDAO_().getTerminatedDate() == null && argTerminatedDate != null) || (
/* 1246 */       getDAO_().getTerminatedDate() != null && !getDAO_().getTerminatedDate().equals(argTerminatedDate))) {
/* 1247 */       getDAO_().setTerminatedDate(argTerminatedDate);
/* 1248 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1251 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getVacationDays() {
/* 1259 */     return getDAO_().getVacationDays();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVacationDays(BigDecimal argVacationDays) {
/* 1267 */     if (setVacationDays_noev(argVacationDays) && 
/* 1268 */       this._events != null && 
/* 1269 */       postEventsForChanges()) {
/* 1270 */       this._events.post(IEmployee.SET_VACATIONDAYS, argVacationDays);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVacationDays_noev(BigDecimal argVacationDays) {
/* 1277 */     boolean ev_postable = false;
/*      */     
/* 1279 */     if ((getDAO_().getVacationDays() == null && argVacationDays != null) || (
/* 1280 */       getDAO_().getVacationDays() != null && !getDAO_().getVacationDays().equals(argVacationDays))) {
/* 1281 */       getDAO_().setVacationDays(argVacationDays);
/* 1282 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1285 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getVacationDaysUsed() {
/* 1293 */     return getDAO_().getVacationDaysUsed();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVacationDaysUsed(BigDecimal argVacationDaysUsed) {
/* 1301 */     if (setVacationDaysUsed_noev(argVacationDaysUsed) && 
/* 1302 */       this._events != null && 
/* 1303 */       postEventsForChanges()) {
/* 1304 */       this._events.post(IEmployee.SET_VACATIONDAYSUSED, argVacationDaysUsed);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVacationDaysUsed_noev(BigDecimal argVacationDaysUsed) {
/* 1311 */     boolean ev_postable = false;
/*      */     
/* 1313 */     if ((getDAO_().getVacationDaysUsed() == null && argVacationDaysUsed != null) || (
/* 1314 */       getDAO_().getVacationDaysUsed() != null && !getDAO_().getVacationDaysUsed().equals(argVacationDaysUsed))) {
/* 1315 */       getDAO_().setVacationDaysUsed(argVacationDaysUsed);
/* 1316 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1319 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTrainingStatusEnum() {
/* 1327 */     return getDAO_().getTrainingStatusEnum();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTrainingStatusEnum(String argTrainingStatusEnum) {
/* 1335 */     if (setTrainingStatusEnum_noev(argTrainingStatusEnum) && 
/* 1336 */       this._events != null && 
/* 1337 */       postEventsForChanges()) {
/* 1338 */       this._events.post(IEmployee.SET_TRAININGSTATUSENUM, argTrainingStatusEnum);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTrainingStatusEnum_noev(String argTrainingStatusEnum) {
/* 1345 */     boolean ev_postable = false;
/*      */     
/* 1347 */     if ((getDAO_().getTrainingStatusEnum() == null && argTrainingStatusEnum != null) || (
/* 1348 */       getDAO_().getTrainingStatusEnum() != null && !getDAO_().getTrainingStatusEnum().equals(argTrainingStatusEnum))) {
/* 1349 */       getDAO_().setTrainingStatusEnum(argTrainingStatusEnum);
/* 1350 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1353 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getLockedOut() {
/* 1361 */     if (getDAO_().getLockedOut() != null) {
/* 1362 */       return getDAO_().getLockedOut().booleanValue();
/*      */     }
/*      */     
/* 1365 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLockedOut(boolean argLockedOut) {
/* 1374 */     if (setLockedOut_noev(argLockedOut) && 
/* 1375 */       this._events != null && 
/* 1376 */       postEventsForChanges()) {
/* 1377 */       this._events.post(IEmployee.SET_LOCKEDOUT, Boolean.valueOf(argLockedOut));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLockedOut_noev(boolean argLockedOut) {
/* 1384 */     boolean ev_postable = false;
/*      */     
/* 1386 */     if ((getDAO_().getLockedOut() == null && Boolean.valueOf(argLockedOut) != null) || (
/* 1387 */       getDAO_().getLockedOut() != null && !getDAO_().getLockedOut().equals(Boolean.valueOf(argLockedOut)))) {
/* 1388 */       getDAO_().setLockedOut(Boolean.valueOf(argLockedOut));
/* 1389 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1392 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getLockedOutTimestamp() {
/* 1400 */     return getDAO_().getLockedOutTimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLockedOutTimestamp(Date argLockedOutTimestamp) {
/* 1408 */     if (setLockedOutTimestamp_noev(argLockedOutTimestamp) && 
/* 1409 */       this._events != null && 
/* 1410 */       postEventsForChanges()) {
/* 1411 */       this._events.post(IEmployee.SET_LOCKEDOUTTIMESTAMP, argLockedOutTimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLockedOutTimestamp_noev(Date argLockedOutTimestamp) {
/* 1418 */     boolean ev_postable = false;
/*      */     
/* 1420 */     if ((getDAO_().getLockedOutTimestamp() == null && argLockedOutTimestamp != null) || (
/* 1421 */       getDAO_().getLockedOutTimestamp() != null && !getDAO_().getLockedOutTimestamp().equals(argLockedOutTimestamp))) {
/* 1422 */       getDAO_().setLockedOutTimestamp(argLockedOutTimestamp);
/* 1423 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1426 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getOvertimeEligible() {
/* 1434 */     if (getDAO_().getOvertimeEligible() != null) {
/* 1435 */       return getDAO_().getOvertimeEligible().booleanValue();
/*      */     }
/*      */     
/* 1438 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOvertimeEligible(boolean argOvertimeEligible) {
/* 1447 */     if (setOvertimeEligible_noev(argOvertimeEligible) && 
/* 1448 */       this._events != null && 
/* 1449 */       postEventsForChanges()) {
/* 1450 */       this._events.post(IEmployee.SET_OVERTIMEELIGIBLE, Boolean.valueOf(argOvertimeEligible));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOvertimeEligible_noev(boolean argOvertimeEligible) {
/* 1457 */     boolean ev_postable = false;
/*      */     
/* 1459 */     if ((getDAO_().getOvertimeEligible() == null && Boolean.valueOf(argOvertimeEligible) != null) || (
/* 1460 */       getDAO_().getOvertimeEligible() != null && !getDAO_().getOvertimeEligible().equals(Boolean.valueOf(argOvertimeEligible)))) {
/* 1461 */       getDAO_().setOvertimeEligible(Boolean.valueOf(argOvertimeEligible));
/* 1462 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1465 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPrimaryGroupId() {
/* 1473 */     return getDAO_().getPrimaryGroupId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPrimaryGroupId(String argPrimaryGroupId) {
/* 1481 */     if (setPrimaryGroupId_noev(argPrimaryGroupId) && 
/* 1482 */       this._events != null && 
/* 1483 */       postEventsForChanges()) {
/* 1484 */       this._events.post(IEmployee.SET_PRIMARYGROUPID, argPrimaryGroupId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPrimaryGroupId_noev(String argPrimaryGroupId) {
/* 1491 */     boolean ev_postable = false;
/*      */     
/* 1493 */     if ((getDAO_().getPrimaryGroupId() == null && argPrimaryGroupId != null) || (
/* 1494 */       getDAO_().getPrimaryGroupId() != null && !getDAO_().getPrimaryGroupId().equals(argPrimaryGroupId))) {
/* 1495 */       getDAO_().setPrimaryGroupId(argPrimaryGroupId);
/* 1496 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1499 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDepartmentId() {
/* 1507 */     return getDAO_().getDepartmentId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDepartmentId(String argDepartmentId) {
/* 1515 */     if (setDepartmentId_noev(argDepartmentId) && 
/* 1516 */       this._events != null && 
/* 1517 */       postEventsForChanges()) {
/* 1518 */       this._events.post(IEmployee.SET_DEPARTMENTID, argDepartmentId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDepartmentId_noev(String argDepartmentId) {
/* 1525 */     boolean ev_postable = false;
/*      */     
/* 1527 */     if ((getDAO_().getDepartmentId() == null && argDepartmentId != null) || (
/* 1528 */       getDAO_().getDepartmentId() != null && !getDAO_().getDepartmentId().equals(argDepartmentId))) {
/* 1529 */       getDAO_().setDepartmentId(argDepartmentId);
/* 1530 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1533 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getPartyId() {
/* 1541 */     if (getDAO_().getPartyId() != null) {
/* 1542 */       return getDAO_().getPartyId().longValue();
/*      */     }
/*      */     
/* 1545 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPartyId(long argPartyId) {
/* 1554 */     if (setPartyId_noev(argPartyId) && 
/* 1555 */       this._events != null && 
/* 1556 */       postEventsForChanges()) {
/* 1557 */       this._events.post(IEmployee.SET_PARTYID, Long.valueOf(argPartyId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPartyId_noev(long argPartyId) {
/* 1564 */     boolean ev_postable = false;
/*      */     
/* 1566 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/* 1567 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/* 1568 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/* 1569 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1572 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getWorkCodeString() {
/* 1580 */     return getDAO_().getWorkCodeString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkCodeString(String argWorkCodeString) {
/* 1588 */     if (setWorkCodeString_noev(argWorkCodeString) && 
/* 1589 */       this._events != null && 
/* 1590 */       postEventsForChanges()) {
/* 1591 */       this._events.post(IEmployee.SET_WORKCODESTRING, argWorkCodeString);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkCodeString_noev(String argWorkCodeString) {
/* 1598 */     boolean ev_postable = false;
/*      */     
/* 1600 */     if ((getDAO_().getWorkCodeString() == null && argWorkCodeString != null) || (
/* 1601 */       getDAO_().getWorkCodeString() != null && !getDAO_().getWorkCodeString().equals(argWorkCodeString))) {
/* 1602 */       getDAO_().setWorkCodeString(argWorkCodeString);
/* 1603 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1606 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IEmployeeProperty newProperty(String argPropertyName) {
/* 1610 */     EmployeePropertyId id = new EmployeePropertyId();
/*      */     
/* 1612 */     id.setEmployeeId(getEmployeeId());
/* 1613 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1615 */     IEmployeeProperty prop = (IEmployeeProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IEmployeeProperty.class);
/* 1616 */     return prop;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Party")
/*      */   public IParty getParty() {
/* 1643 */     return this._party;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setParty(IParty argParty) {
/* 1648 */     if (argParty == null) {
/*      */       
/* 1650 */       getDAO_().setPartyId(null);
/* 1651 */       if (this._party != null)
/*      */       {
/* 1653 */         if (postEventsForChanges()) {
/* 1654 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._party));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 1659 */       getDAO_().setPartyId(Long.valueOf(argParty.getPartyId()));
/*      */       
/* 1661 */       if (postEventsForChanges()) {
/* 1662 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argParty));
/*      */       }
/*      */     } 
/*      */     
/* 1666 */     this._party = argParty;
/* 1667 */     if (postEventsForChanges()) {
/* 1668 */       this._events.post(IEmployee.SET_PARTY, argParty);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "PrimaryGroup")
/*      */   public IGroup getPrimaryGroup() {
/* 1674 */     return this._primaryGroup;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPrimaryGroup(IGroup argPrimaryGroup) {
/* 1679 */     if (argPrimaryGroup == null) {
/*      */       
/* 1681 */       getDAO_().setPrimaryGroupId(null);
/* 1682 */       if (this._primaryGroup != null)
/*      */       {
/* 1684 */         if (postEventsForChanges()) {
/* 1685 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._primaryGroup));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 1690 */       getDAO_().setPrimaryGroupId(argPrimaryGroup.getGroupId());
/*      */       
/* 1692 */       if (postEventsForChanges()) {
/* 1693 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPrimaryGroup));
/*      */       }
/*      */     } 
/*      */     
/* 1697 */     this._primaryGroup = argPrimaryGroup;
/* 1698 */     if (postEventsForChanges()) {
/* 1699 */       this._events.post(IEmployee.SET_PRIMARYGROUP, argPrimaryGroup);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "WorkCode")
/*      */   public IWorkCodes getWorkCode() {
/* 1705 */     return this._workCode;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setWorkCode(IWorkCodes argWorkCode) {
/* 1710 */     if (argWorkCode == null) {
/*      */       
/* 1712 */       getDAO_().setWorkCodeString(null);
/* 1713 */       if (this._workCode != null)
/*      */       {
/* 1715 */         if (postEventsForChanges()) {
/* 1716 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._workCode));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 1721 */       getDAO_().setWorkCodeString(argWorkCode.getWorkCode());
/*      */       
/* 1723 */       if (postEventsForChanges()) {
/* 1724 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkCode));
/*      */       }
/*      */     } 
/*      */     
/* 1728 */     this._workCode = argWorkCode;
/* 1729 */     if (postEventsForChanges()) {
/* 1730 */       this._events.post(IEmployee.SET_WORKCODE, argWorkCode);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "EmployeeStores")
/*      */   public List<IEmployeeStore> getEmployeeStores() {
/* 1736 */     if (this._employeeStores == null) {
/* 1737 */       this._employeeStores = new HistoricalList(null);
/*      */     }
/* 1739 */     return (List<IEmployeeStore>)this._employeeStores;
/*      */   }
/*      */   
/*      */   public void setEmployeeStores(List<IEmployeeStore> argEmployeeStores) {
/* 1743 */     if (this._employeeStores == null) {
/* 1744 */       this._employeeStores = new HistoricalList(argEmployeeStores);
/*      */     } else {
/* 1746 */       this._employeeStores.setCurrentList(argEmployeeStores);
/*      */     } 
/*      */     
/* 1749 */     for (IEmployeeStore child : this._employeeStores) {
/* 1750 */       EmployeeStoreModel model = (EmployeeStoreModel)child;
/* 1751 */       model.setOrganizationId_noev(getOrganizationId());
/* 1752 */       model.setEmployeeId_noev(getEmployeeId());
/* 1753 */       if (child instanceof IDataModelImpl) {
/* 1754 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1755 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1756 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1757 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1760 */       if (postEventsForChanges()) {
/* 1761 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addEmployeeStore(IEmployeeStore argEmployeeStore) {
/* 1767 */     super.addEmployeeStore(argEmployeeStore);
/*      */     
/* 1769 */     if (this._employeeStores == null) {
/* 1770 */       this._employeeStores = new HistoricalList(null);
/*      */     }
/* 1772 */     argEmployeeStore.setOrganizationId(getOrganizationId());
/* 1773 */     argEmployeeStore.setEmployeeId(getEmployeeId());
/* 1774 */     if (argEmployeeStore instanceof IDataModelImpl) {
/* 1775 */       IDataAccessObject childDao = ((IDataModelImpl)argEmployeeStore).getDAO();
/* 1776 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1777 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1778 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1783 */     if (postEventsForChanges()) {
/* 1784 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeStore));
/*      */     }
/*      */     
/* 1787 */     this._employeeStores.add(argEmployeeStore);
/* 1788 */     if (postEventsForChanges()) {
/* 1789 */       this._events.post(IEmployee.ADD_EMPLOYEESTORES, argEmployeeStore);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeEmployeeStore(IEmployeeStore argEmployeeStore) {
/* 1794 */     if (this._employeeStores != null) {
/*      */       
/* 1796 */       if (postEventsForChanges()) {
/* 1797 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeStore));
/*      */       }
/* 1799 */       this._employeeStores.remove(argEmployeeStore);
/* 1800 */       if (postEventsForChanges()) {
/* 1801 */         this._events.post(IEmployee.REMOVE_EMPLOYEESTORES, argEmployeeStore);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "EmployeeNotes")
/*      */   public List<IEmployeeNote> getEmployeeNotes() {
/* 1808 */     if (this._employeeNotes == null) {
/* 1809 */       this._employeeNotes = new HistoricalList(null);
/*      */     }
/* 1811 */     return (List<IEmployeeNote>)this._employeeNotes;
/*      */   }
/*      */   
/*      */   public void setEmployeeNotes(List<IEmployeeNote> argEmployeeNotes) {
/* 1815 */     if (this._employeeNotes == null) {
/* 1816 */       this._employeeNotes = new HistoricalList(argEmployeeNotes);
/*      */     } else {
/* 1818 */       this._employeeNotes.setCurrentList(argEmployeeNotes);
/*      */     } 
/*      */     
/* 1821 */     for (IEmployeeNote child : this._employeeNotes) {
/* 1822 */       EmployeeNoteModel model = (EmployeeNoteModel)child;
/* 1823 */       model.setOrganizationId_noev(getOrganizationId());
/* 1824 */       model.setEmployeeId_noev(getEmployeeId());
/* 1825 */       if (child instanceof IDataModelImpl) {
/* 1826 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1827 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1828 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1829 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1832 */       if (postEventsForChanges()) {
/* 1833 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addEmployeeNote(IEmployeeNote argEmployeeNote) {
/* 1839 */     if (this._employeeNotes == null) {
/* 1840 */       this._employeeNotes = new HistoricalList(null);
/*      */     }
/* 1842 */     argEmployeeNote.setOrganizationId(getOrganizationId());
/* 1843 */     argEmployeeNote.setEmployeeId(getEmployeeId());
/* 1844 */     if (argEmployeeNote instanceof IDataModelImpl) {
/* 1845 */       IDataAccessObject childDao = ((IDataModelImpl)argEmployeeNote).getDAO();
/* 1846 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1847 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1848 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1853 */     if (postEventsForChanges()) {
/* 1854 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeNote));
/*      */     }
/*      */     
/* 1857 */     this._employeeNotes.add(argEmployeeNote);
/* 1858 */     if (postEventsForChanges()) {
/* 1859 */       this._events.post(IEmployee.ADD_EMPLOYEENOTES, argEmployeeNote);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeEmployeeNote(IEmployeeNote argEmployeeNote) {
/* 1864 */     if (this._employeeNotes != null) {
/*      */       
/* 1866 */       if (postEventsForChanges()) {
/* 1867 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeNote));
/*      */       }
/* 1869 */       this._employeeNotes.remove(argEmployeeNote);
/* 1870 */       if (postEventsForChanges()) {
/* 1871 */         this._events.post(IEmployee.REMOVE_EMPLOYEENOTES, argEmployeeNote);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "EmployeeAnswers")
/*      */   public List<IEmployeeAnswers> getEmployeeAnswers() {
/* 1878 */     if (this._employeeAnswers == null) {
/* 1879 */       this._employeeAnswers = new HistoricalList(null);
/*      */     }
/* 1881 */     return (List<IEmployeeAnswers>)this._employeeAnswers;
/*      */   }
/*      */   
/*      */   public void setEmployeeAnswers(List<IEmployeeAnswers> argEmployeeAnswers) {
/* 1885 */     if (this._employeeAnswers == null) {
/* 1886 */       this._employeeAnswers = new HistoricalList(argEmployeeAnswers);
/*      */     } else {
/* 1888 */       this._employeeAnswers.setCurrentList(argEmployeeAnswers);
/*      */     } 
/*      */     
/* 1891 */     for (IEmployeeAnswers child : this._employeeAnswers) {
/* 1892 */       EmployeeAnswersModel model = (EmployeeAnswersModel)child;
/* 1893 */       model.setOrganizationId_noev(getOrganizationId());
/* 1894 */       model.setEmployeeId_noev(getEmployeeId());
/* 1895 */       if (child instanceof IDataModelImpl) {
/* 1896 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1897 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1898 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1899 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1902 */       if (postEventsForChanges()) {
/* 1903 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addEmployeeAnswers(IEmployeeAnswers argEmployeeAnswers) {
/* 1909 */     if (this._employeeAnswers == null) {
/* 1910 */       this._employeeAnswers = new HistoricalList(null);
/*      */     }
/* 1912 */     argEmployeeAnswers.setOrganizationId(getOrganizationId());
/* 1913 */     argEmployeeAnswers.setEmployeeId(getEmployeeId());
/* 1914 */     if (argEmployeeAnswers instanceof IDataModelImpl) {
/* 1915 */       IDataAccessObject childDao = ((IDataModelImpl)argEmployeeAnswers).getDAO();
/* 1916 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1917 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1918 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1923 */     if (postEventsForChanges()) {
/* 1924 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeAnswers));
/*      */     }
/*      */     
/* 1927 */     this._employeeAnswers.add(argEmployeeAnswers);
/* 1928 */     if (postEventsForChanges()) {
/* 1929 */       this._events.post(IEmployee.ADD_EMPLOYEEANSWERS, argEmployeeAnswers);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeEmployeeAnswers(IEmployeeAnswers argEmployeeAnswers) {
/* 1934 */     if (this._employeeAnswers != null) {
/*      */       
/* 1936 */       if (postEventsForChanges()) {
/* 1937 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeAnswers));
/*      */       }
/* 1939 */       this._employeeAnswers.remove(argEmployeeAnswers);
/* 1940 */       if (postEventsForChanges()) {
/* 1941 */         this._events.post(IEmployee.REMOVE_EMPLOYEEANSWERS, argEmployeeAnswers);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IEmployeeProperty> getProperties() {
/* 1948 */     if (this._properties == null) {
/* 1949 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1951 */     return (List<IEmployeeProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IEmployeeProperty> argProperties) {
/* 1955 */     if (this._properties == null) {
/* 1956 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1958 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1961 */     for (IEmployeeProperty child : this._properties) {
/* 1962 */       EmployeePropertyModel model = (EmployeePropertyModel)child;
/* 1963 */       model.setOrganizationId_noev(getOrganizationId());
/* 1964 */       model.setEmployeeId_noev(getEmployeeId());
/* 1965 */       if (child instanceof IDataModelImpl) {
/* 1966 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1967 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1968 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1969 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1972 */       if (postEventsForChanges()) {
/* 1973 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addEmployeeProperty(IEmployeeProperty argEmployeeProperty) {
/* 1979 */     if (this._properties == null) {
/* 1980 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1982 */     argEmployeeProperty.setOrganizationId(getOrganizationId());
/* 1983 */     argEmployeeProperty.setEmployeeId(getEmployeeId());
/* 1984 */     if (argEmployeeProperty instanceof IDataModelImpl) {
/* 1985 */       IDataAccessObject childDao = ((IDataModelImpl)argEmployeeProperty).getDAO();
/* 1986 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1987 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1988 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1993 */     if (postEventsForChanges()) {
/* 1994 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeProperty));
/*      */     }
/*      */     
/* 1997 */     this._properties.add(argEmployeeProperty);
/* 1998 */     if (postEventsForChanges()) {
/* 1999 */       this._events.post(IEmployee.ADD_PROPERTIES, argEmployeeProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeEmployeeProperty(IEmployeeProperty argEmployeeProperty) {
/* 2004 */     if (this._properties != null) {
/*      */       
/* 2006 */       if (postEventsForChanges()) {
/* 2007 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeProperty));
/*      */       }
/* 2009 */       this._properties.remove(argEmployeeProperty);
/* 2010 */       if (postEventsForChanges()) {
/* 2011 */         this._events.post(IEmployee.REMOVE_PROPERTIES, argEmployeeProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 2018 */     if ("Party".equals(argFieldId)) {
/* 2019 */       return getParty();
/*      */     }
/* 2021 */     if ("PrimaryGroup".equals(argFieldId)) {
/* 2022 */       return getPrimaryGroup();
/*      */     }
/* 2024 */     if ("WorkCode".equals(argFieldId)) {
/* 2025 */       return getWorkCode();
/*      */     }
/* 2027 */     if ("EmployeeStores".equals(argFieldId)) {
/* 2028 */       return getEmployeeStores();
/*      */     }
/* 2030 */     if ("EmployeeNotes".equals(argFieldId)) {
/* 2031 */       return getEmployeeNotes();
/*      */     }
/* 2033 */     if ("EmployeeAnswers".equals(argFieldId)) {
/* 2034 */       return getEmployeeAnswers();
/*      */     }
/* 2036 */     if ("Properties".equals(argFieldId)) {
/* 2037 */       return getProperties();
/*      */     }
/* 2039 */     if ("EmployeeExtension".equals(argFieldId)) {
/* 2040 */       return this._myExtension;
/*      */     }
/*      */     
/* 2043 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 2049 */     if ("Party".equals(argFieldId)) {
/* 2050 */       setParty((IParty)argValue);
/*      */     }
/* 2052 */     else if ("PrimaryGroup".equals(argFieldId)) {
/* 2053 */       setPrimaryGroup((IGroup)argValue);
/*      */     }
/* 2055 */     else if ("WorkCode".equals(argFieldId)) {
/* 2056 */       setWorkCode((IWorkCodes)argValue);
/*      */     }
/* 2058 */     else if ("EmployeeStores".equals(argFieldId)) {
/* 2059 */       setEmployeeStores(changeToList(argValue, IEmployeeStore.class));
/*      */     }
/* 2061 */     else if ("EmployeeNotes".equals(argFieldId)) {
/* 2062 */       setEmployeeNotes(changeToList(argValue, IEmployeeNote.class));
/*      */     }
/* 2064 */     else if ("EmployeeAnswers".equals(argFieldId)) {
/* 2065 */       setEmployeeAnswers(changeToList(argValue, IEmployeeAnswers.class));
/*      */     }
/* 2067 */     else if ("Properties".equals(argFieldId)) {
/* 2068 */       setProperties(changeToList(argValue, IEmployeeProperty.class));
/*      */     }
/* 2070 */     else if ("EmployeeExtension".equals(argFieldId)) {
/* 2071 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 2074 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 2080 */     this._persistenceDefaults = argPD;
/* 2081 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 2082 */     this._eventManager = argEM;
/* 2083 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 2084 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 2085 */     if (this._party != null) {
/* 2086 */       ((IDataModelImpl)this._party).setDependencies(argPD, argEM);
/*      */     }
/* 2088 */     if (this._primaryGroup != null) {
/* 2089 */       ((IDataModelImpl)this._primaryGroup).setDependencies(argPD, argEM);
/*      */     }
/* 2091 */     if (this._workCode != null) {
/* 2092 */       ((IDataModelImpl)this._workCode).setDependencies(argPD, argEM);
/*      */     }
/* 2094 */     if (this._employeeStores != null) {
/* 2095 */       for (IEmployeeStore relationship : this._employeeStores) {
/* 2096 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 2099 */     if (this._employeeNotes != null) {
/* 2100 */       for (IEmployeeNote relationship : this._employeeNotes) {
/* 2101 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 2104 */     if (this._employeeAnswers != null) {
/* 2105 */       for (IEmployeeAnswers relationship : this._employeeAnswers) {
/* 2106 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 2109 */     if (this._properties != null) {
/* 2110 */       for (IEmployeeProperty relationship : this._properties) {
/* 2111 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getEmployeeExt() {
/* 2117 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setEmployeeExt(IDataModel argExt) {
/* 2121 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 2126 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 2130 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 2133 */     super.startTransaction();
/*      */     
/* 2135 */     this._partySavepoint = this._party;
/* 2136 */     if (this._party != null) {
/* 2137 */       this._party.startTransaction();
/*      */     }
/*      */     
/* 2140 */     this._primaryGroupSavepoint = this._primaryGroup;
/* 2141 */     if (this._primaryGroup != null) {
/* 2142 */       this._primaryGroup.startTransaction();
/*      */     }
/*      */     
/* 2145 */     this._workCodeSavepoint = this._workCode;
/* 2146 */     if (this._workCode != null) {
/* 2147 */       this._workCode.startTransaction();
/*      */     }
/*      */     
/* 2150 */     this._employeeStoresSavepoint = this._employeeStores;
/* 2151 */     if (this._employeeStores != null) {
/* 2152 */       this._employeeStoresSavepoint = new HistoricalList((List)this._employeeStores);
/* 2153 */       Iterator<IDataModel> it = this._employeeStores.iterator();
/* 2154 */       while (it.hasNext()) {
/* 2155 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 2159 */     this._employeeNotesSavepoint = this._employeeNotes;
/* 2160 */     if (this._employeeNotes != null) {
/* 2161 */       this._employeeNotesSavepoint = new HistoricalList((List)this._employeeNotes);
/* 2162 */       Iterator<IDataModel> it = this._employeeNotes.iterator();
/* 2163 */       while (it.hasNext()) {
/* 2164 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 2168 */     this._employeeAnswersSavepoint = this._employeeAnswers;
/* 2169 */     if (this._employeeAnswers != null) {
/* 2170 */       this._employeeAnswersSavepoint = new HistoricalList((List)this._employeeAnswers);
/* 2171 */       Iterator<IDataModel> it = this._employeeAnswers.iterator();
/* 2172 */       while (it.hasNext()) {
/* 2173 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 2177 */     this._propertiesSavepoint = this._properties;
/* 2178 */     if (this._properties != null) {
/* 2179 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 2180 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2181 */       while (it.hasNext()) {
/* 2182 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2187 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 2192 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 2195 */     super.rollbackChanges();
/*      */     
/* 2197 */     this._party = this._partySavepoint;
/* 2198 */     this._partySavepoint = null;
/* 2199 */     if (this._party != null) {
/* 2200 */       this._party.rollbackChanges();
/*      */     }
/*      */     
/* 2203 */     this._primaryGroup = this._primaryGroupSavepoint;
/* 2204 */     this._primaryGroupSavepoint = null;
/* 2205 */     if (this._primaryGroup != null) {
/* 2206 */       this._primaryGroup.rollbackChanges();
/*      */     }
/*      */     
/* 2209 */     this._workCode = this._workCodeSavepoint;
/* 2210 */     this._workCodeSavepoint = null;
/* 2211 */     if (this._workCode != null) {
/* 2212 */       this._workCode.rollbackChanges();
/*      */     }
/*      */     
/* 2215 */     this._employeeStores = this._employeeStoresSavepoint;
/* 2216 */     this._employeeStoresSavepoint = null;
/* 2217 */     if (this._employeeStores != null) {
/* 2218 */       Iterator<IDataModel> it = this._employeeStores.iterator();
/* 2219 */       while (it.hasNext()) {
/* 2220 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2224 */     this._employeeNotes = this._employeeNotesSavepoint;
/* 2225 */     this._employeeNotesSavepoint = null;
/* 2226 */     if (this._employeeNotes != null) {
/* 2227 */       Iterator<IDataModel> it = this._employeeNotes.iterator();
/* 2228 */       while (it.hasNext()) {
/* 2229 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2233 */     this._employeeAnswers = this._employeeAnswersSavepoint;
/* 2234 */     this._employeeAnswersSavepoint = null;
/* 2235 */     if (this._employeeAnswers != null) {
/* 2236 */       Iterator<IDataModel> it = this._employeeAnswers.iterator();
/* 2237 */       while (it.hasNext()) {
/* 2238 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2242 */     this._properties = this._propertiesSavepoint;
/* 2243 */     this._propertiesSavepoint = null;
/* 2244 */     if (this._properties != null) {
/* 2245 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2246 */       while (it.hasNext()) {
/* 2247 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 2255 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 2258 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 2261 */     super.commitTransaction();
/*      */     
/* 2263 */     this._partySavepoint = this._party;
/* 2264 */     if (this._party != null) {
/* 2265 */       this._party.commitTransaction();
/*      */     }
/*      */     
/* 2268 */     this._primaryGroupSavepoint = this._primaryGroup;
/* 2269 */     if (this._primaryGroup != null) {
/* 2270 */       this._primaryGroup.commitTransaction();
/*      */     }
/*      */     
/* 2273 */     this._workCodeSavepoint = this._workCode;
/* 2274 */     if (this._workCode != null) {
/* 2275 */       this._workCode.commitTransaction();
/*      */     }
/*      */     
/* 2278 */     this._employeeStoresSavepoint = this._employeeStores;
/* 2279 */     if (this._employeeStores != null) {
/* 2280 */       Iterator<IDataModel> it = this._employeeStores.iterator();
/* 2281 */       while (it.hasNext()) {
/* 2282 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2284 */       this._employeeStores = new HistoricalList((List)this._employeeStores);
/*      */     } 
/*      */     
/* 2287 */     this._employeeNotesSavepoint = this._employeeNotes;
/* 2288 */     if (this._employeeNotes != null) {
/* 2289 */       Iterator<IDataModel> it = this._employeeNotes.iterator();
/* 2290 */       while (it.hasNext()) {
/* 2291 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2293 */       this._employeeNotes = new HistoricalList((List)this._employeeNotes);
/*      */     } 
/*      */     
/* 2296 */     this._employeeAnswersSavepoint = this._employeeAnswers;
/* 2297 */     if (this._employeeAnswers != null) {
/* 2298 */       Iterator<IDataModel> it = this._employeeAnswers.iterator();
/* 2299 */       while (it.hasNext()) {
/* 2300 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2302 */       this._employeeAnswers = new HistoricalList((List)this._employeeAnswers);
/*      */     } 
/*      */     
/* 2305 */     this._propertiesSavepoint = this._properties;
/* 2306 */     if (this._properties != null) {
/* 2307 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2308 */       while (it.hasNext()) {
/* 2309 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2311 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 2315 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */