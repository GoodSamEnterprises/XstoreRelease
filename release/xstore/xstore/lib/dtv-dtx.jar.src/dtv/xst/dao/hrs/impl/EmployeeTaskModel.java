/*      */ package dtv.xst.dao.hrs.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.crm.IParty;
/*      */ import dtv.xst.dao.hrs.EmployeeTaskPropertyId;
/*      */ import dtv.xst.dao.hrs.IEmployeeTask;
/*      */ import dtv.xst.dao.hrs.IEmployeeTaskNote;
/*      */ import dtv.xst.dao.hrs.IEmployeeTaskProperty;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class EmployeeTaskModel extends AbstractDataModelWithPropertyImpl<IEmployeeTaskProperty> implements IEmployeeTask {
/*      */   private static final long serialVersionUID = -1564025485L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private IParty _customerParty;
/*      */   
/*      */   public String toString() {
/*   34 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient IParty _customerPartySavepoint; private HistoricalList<IEmployeeTaskNote> _employeeTaskNotes; private transient HistoricalList<IEmployeeTaskNote> _employeeTaskNotesSavepoint; private HistoricalList<IEmployeeTaskProperty> _properties; private transient HistoricalList<IEmployeeTaskProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   39 */     setDAO((IDataAccessObject)new EmployeeTaskDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private EmployeeTaskDAO getDAO_() {
/*   47 */     return (EmployeeTaskDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   55 */     if (getDAO_().getOrganizationId() != null) {
/*   56 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   59 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   68 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   69 */       this._events != null && 
/*   70 */       postEventsForChanges()) {
/*   71 */       this._events.post(IEmployeeTask.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   78 */     boolean ev_postable = false;
/*      */     
/*   80 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   81 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   82 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   83 */       ev_postable = true;
/*   84 */       if (this._employeeTaskNotes != null) {
/*      */         
/*   86 */         Iterator<EmployeeTaskNoteModel> it = this._employeeTaskNotes.iterator();
/*   87 */         while (it.hasNext())
/*      */         {
/*   89 */           ((EmployeeTaskNoteModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   92 */       if (this._properties != null) {
/*      */         
/*   94 */         Iterator<EmployeeTaskPropertyModel> it = this._properties.iterator();
/*   95 */         while (it.hasNext())
/*      */         {
/*   97 */           ((EmployeeTaskPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  102 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  110 */     if (getDAO_().getRetailLocationId() != null) {
/*  111 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  114 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  123 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  124 */       this._events != null && 
/*  125 */       postEventsForChanges()) {
/*  126 */       this._events.post(IEmployeeTask.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  133 */     boolean ev_postable = false;
/*      */     
/*  135 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  136 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  137 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  138 */       ev_postable = true;
/*  139 */       if (this._employeeTaskNotes != null) {
/*      */         
/*  141 */         Iterator<EmployeeTaskNoteModel> it = this._employeeTaskNotes.iterator();
/*  142 */         while (it.hasNext())
/*      */         {
/*  144 */           ((EmployeeTaskNoteModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  147 */       if (this._properties != null) {
/*      */         
/*  149 */         Iterator<EmployeeTaskPropertyModel> it = this._properties.iterator();
/*  150 */         while (it.hasNext())
/*      */         {
/*  152 */           ((EmployeeTaskPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  157 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTaskId() {
/*  165 */     if (getDAO_().getTaskId() != null) {
/*  166 */       return getDAO_().getTaskId().longValue();
/*      */     }
/*      */     
/*  169 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaskId(long argTaskId) {
/*  178 */     if (setTaskId_noev(argTaskId) && 
/*  179 */       this._events != null && 
/*  180 */       postEventsForChanges()) {
/*  181 */       this._events.post(IEmployeeTask.SET_TASKID, Long.valueOf(argTaskId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaskId_noev(long argTaskId) {
/*  188 */     boolean ev_postable = false;
/*      */     
/*  190 */     if ((getDAO_().getTaskId() == null && Long.valueOf(argTaskId) != null) || (
/*  191 */       getDAO_().getTaskId() != null && !getDAO_().getTaskId().equals(Long.valueOf(argTaskId)))) {
/*  192 */       getDAO_().setTaskId(Long.valueOf(argTaskId));
/*  193 */       ev_postable = true;
/*  194 */       if (this._employeeTaskNotes != null) {
/*      */         
/*  196 */         Iterator<EmployeeTaskNoteModel> it = this._employeeTaskNotes.iterator();
/*  197 */         while (it.hasNext())
/*      */         {
/*  199 */           ((EmployeeTaskNoteModel)it.next()).setTaskId_noev(argTaskId);
/*      */         }
/*      */       } 
/*  202 */       if (this._properties != null) {
/*      */         
/*  204 */         Iterator<EmployeeTaskPropertyModel> it = this._properties.iterator();
/*  205 */         while (it.hasNext())
/*      */         {
/*  207 */           ((EmployeeTaskPropertyModel)it.next()).setTaskId_noev(argTaskId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  212 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getStartDate() {
/*  220 */     return getDAO_().getStartDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStartDate(Date argStartDate) {
/*  228 */     if (setStartDate_noev(argStartDate) && 
/*  229 */       this._events != null && 
/*  230 */       postEventsForChanges()) {
/*  231 */       this._events.post(IEmployeeTask.SET_STARTDATE, argStartDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStartDate_noev(Date argStartDate) {
/*  238 */     boolean ev_postable = false;
/*      */     
/*  240 */     if ((getDAO_().getStartDate() == null && argStartDate != null) || (
/*  241 */       getDAO_().getStartDate() != null && !getDAO_().getStartDate().equals(argStartDate))) {
/*  242 */       getDAO_().setStartDate(argStartDate);
/*  243 */       ev_postable = true;
/*      */     } 
/*      */     
/*  246 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEndDate() {
/*  254 */     return getDAO_().getEndDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEndDate(Date argEndDate) {
/*  262 */     if (setEndDate_noev(argEndDate) && 
/*  263 */       this._events != null && 
/*  264 */       postEventsForChanges()) {
/*  265 */       this._events.post(IEmployeeTask.SET_ENDDATE, argEndDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEndDate_noev(Date argEndDate) {
/*  272 */     boolean ev_postable = false;
/*      */     
/*  274 */     if ((getDAO_().getEndDate() == null && argEndDate != null) || (
/*  275 */       getDAO_().getEndDate() != null && !getDAO_().getEndDate().equals(argEndDate))) {
/*  276 */       getDAO_().setEndDate(argEndDate);
/*  277 */       ev_postable = true;
/*      */     } 
/*      */     
/*  280 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCompleteDate() {
/*  288 */     return getDAO_().getCompleteDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCompleteDate(Date argCompleteDate) {
/*  296 */     if (setCompleteDate_noev(argCompleteDate) && 
/*  297 */       this._events != null && 
/*  298 */       postEventsForChanges()) {
/*  299 */       this._events.post(IEmployeeTask.SET_COMPLETEDATE, argCompleteDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCompleteDate_noev(Date argCompleteDate) {
/*  306 */     boolean ev_postable = false;
/*      */     
/*  308 */     if ((getDAO_().getCompleteDate() == null && argCompleteDate != null) || (
/*  309 */       getDAO_().getCompleteDate() != null && !getDAO_().getCompleteDate().equals(argCompleteDate))) {
/*  310 */       getDAO_().setCompleteDate(argCompleteDate);
/*  311 */       ev_postable = true;
/*      */     } 
/*      */     
/*  314 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTypeCode() {
/*  322 */     return getDAO_().getTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTypeCode(String argTypeCode) {
/*  330 */     if (setTypeCode_noev(argTypeCode) && 
/*  331 */       this._events != null && 
/*  332 */       postEventsForChanges()) {
/*  333 */       this._events.post(IEmployeeTask.SET_TYPECODE, argTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTypeCode_noev(String argTypeCode) {
/*  340 */     boolean ev_postable = false;
/*      */     
/*  342 */     if ((getDAO_().getTypeCode() == null && argTypeCode != null) || (
/*  343 */       getDAO_().getTypeCode() != null && !getDAO_().getTypeCode().equals(argTypeCode))) {
/*  344 */       getDAO_().setTypeCode(argTypeCode);
/*  345 */       ev_postable = true;
/*      */     } 
/*      */     
/*  348 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getVisibility() {
/*  356 */     return getDAO_().getVisibility();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVisibility(String argVisibility) {
/*  364 */     if (setVisibility_noev(argVisibility) && 
/*  365 */       this._events != null && 
/*  366 */       postEventsForChanges()) {
/*  367 */       this._events.post(IEmployeeTask.SET_VISIBILITY, argVisibility);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVisibility_noev(String argVisibility) {
/*  374 */     boolean ev_postable = false;
/*      */     
/*  376 */     if ((getDAO_().getVisibility() == null && argVisibility != null) || (
/*  377 */       getDAO_().getVisibility() != null && !getDAO_().getVisibility().equals(argVisibility))) {
/*  378 */       getDAO_().setVisibility(argVisibility);
/*  379 */       ev_postable = true;
/*      */     } 
/*      */     
/*  382 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAssignmentId() {
/*  390 */     return getDAO_().getAssignmentId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAssignmentId(String argAssignmentId) {
/*  398 */     if (setAssignmentId_noev(argAssignmentId) && 
/*  399 */       this._events != null && 
/*  400 */       postEventsForChanges()) {
/*  401 */       this._events.post(IEmployeeTask.SET_ASSIGNMENTID, argAssignmentId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAssignmentId_noev(String argAssignmentId) {
/*  408 */     boolean ev_postable = false;
/*      */     
/*  410 */     if ((getDAO_().getAssignmentId() == null && argAssignmentId != null) || (
/*  411 */       getDAO_().getAssignmentId() != null && !getDAO_().getAssignmentId().equals(argAssignmentId))) {
/*  412 */       getDAO_().setAssignmentId(argAssignmentId);
/*  413 */       ev_postable = true;
/*      */     } 
/*      */     
/*  416 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getStoreCreated() {
/*  424 */     if (getDAO_().getStoreCreated() != null) {
/*  425 */       return getDAO_().getStoreCreated().booleanValue();
/*      */     }
/*      */     
/*  428 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStoreCreated(boolean argStoreCreated) {
/*  437 */     if (setStoreCreated_noev(argStoreCreated) && 
/*  438 */       this._events != null && 
/*  439 */       postEventsForChanges()) {
/*  440 */       this._events.post(IEmployeeTask.SET_STORECREATED, Boolean.valueOf(argStoreCreated));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStoreCreated_noev(boolean argStoreCreated) {
/*  447 */     boolean ev_postable = false;
/*      */     
/*  449 */     if ((getDAO_().getStoreCreated() == null && Boolean.valueOf(argStoreCreated) != null) || (
/*  450 */       getDAO_().getStoreCreated() != null && !getDAO_().getStoreCreated().equals(Boolean.valueOf(argStoreCreated)))) {
/*  451 */       getDAO_().setStoreCreated(Boolean.valueOf(argStoreCreated));
/*  452 */       ev_postable = true;
/*      */     } 
/*      */     
/*  455 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTitle() {
/*  463 */     return getDAO_().getTitle();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTitle(String argTitle) {
/*  471 */     if (setTitle_noev(argTitle) && 
/*  472 */       this._events != null && 
/*  473 */       postEventsForChanges()) {
/*  474 */       this._events.post(IEmployeeTask.SET_TITLE, argTitle);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTitle_noev(String argTitle) {
/*  481 */     boolean ev_postable = false;
/*      */     
/*  483 */     if ((getDAO_().getTitle() == null && argTitle != null) || (
/*  484 */       getDAO_().getTitle() != null && !getDAO_().getTitle().equals(argTitle))) {
/*  485 */       getDAO_().setTitle(argTitle);
/*  486 */       ev_postable = true;
/*      */     } 
/*      */     
/*  489 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDescription() {
/*  497 */     return getDAO_().getDescription();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDescription(String argDescription) {
/*  505 */     if (setDescription_noev(argDescription) && 
/*  506 */       this._events != null && 
/*  507 */       postEventsForChanges()) {
/*  508 */       this._events.post(IEmployeeTask.SET_DESCRIPTION, argDescription);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDescription_noev(String argDescription) {
/*  515 */     boolean ev_postable = false;
/*      */     
/*  517 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/*  518 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/*  519 */       getDAO_().setDescription(argDescription);
/*  520 */       ev_postable = true;
/*      */     } 
/*      */     
/*  523 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPriority() {
/*  531 */     return getDAO_().getPriority();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPriority(String argPriority) {
/*  539 */     if (setPriority_noev(argPriority) && 
/*  540 */       this._events != null && 
/*  541 */       postEventsForChanges()) {
/*  542 */       this._events.post(IEmployeeTask.SET_PRIORITY, argPriority);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPriority_noev(String argPriority) {
/*  549 */     boolean ev_postable = false;
/*      */     
/*  551 */     if ((getDAO_().getPriority() == null && argPriority != null) || (
/*  552 */       getDAO_().getPriority() != null && !getDAO_().getPriority().equals(argPriority))) {
/*  553 */       getDAO_().setPriority(argPriority);
/*  554 */       ev_postable = true;
/*      */     } 
/*      */     
/*  557 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStatusCode() {
/*  565 */     return getDAO_().getStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStatusCode(String argStatusCode) {
/*  573 */     if (setStatusCode_noev(argStatusCode) && 
/*  574 */       this._events != null && 
/*  575 */       postEventsForChanges()) {
/*  576 */       this._events.post(IEmployeeTask.SET_STATUSCODE, argStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStatusCode_noev(String argStatusCode) {
/*  583 */     boolean ev_postable = false;
/*      */     
/*  585 */     if ((getDAO_().getStatusCode() == null && argStatusCode != null) || (
/*  586 */       getDAO_().getStatusCode() != null && !getDAO_().getStatusCode().equals(argStatusCode))) {
/*  587 */       getDAO_().setStatusCode(argStatusCode);
/*  588 */       ev_postable = true;
/*      */     } 
/*      */     
/*  591 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getVoid() {
/*  599 */     if (getDAO_().getVoid() != null) {
/*  600 */       return getDAO_().getVoid().booleanValue();
/*      */     }
/*      */     
/*  603 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVoid(boolean argVoid) {
/*  612 */     if (setVoid_noev(argVoid) && 
/*  613 */       this._events != null && 
/*  614 */       postEventsForChanges()) {
/*  615 */       this._events.post(IEmployeeTask.SET_VOID, Boolean.valueOf(argVoid));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVoid_noev(boolean argVoid) {
/*  622 */     boolean ev_postable = false;
/*      */     
/*  624 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/*  625 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/*  626 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/*  627 */       ev_postable = true;
/*      */     } 
/*      */     
/*  630 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getPartyId() {
/*  638 */     if (getDAO_().getPartyId() != null) {
/*  639 */       return getDAO_().getPartyId().longValue();
/*      */     }
/*      */     
/*  642 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPartyId(long argPartyId) {
/*  651 */     if (setPartyId_noev(argPartyId) && 
/*  652 */       this._events != null && 
/*  653 */       postEventsForChanges()) {
/*  654 */       this._events.post(IEmployeeTask.SET_PARTYID, Long.valueOf(argPartyId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPartyId_noev(long argPartyId) {
/*  661 */     boolean ev_postable = false;
/*      */     
/*  663 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/*  664 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/*  665 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/*  666 */       ev_postable = true;
/*      */     } 
/*      */     
/*  669 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  677 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  685 */     if (setCreateDate_noev(argCreateDate) && 
/*  686 */       this._events != null && 
/*  687 */       postEventsForChanges()) {
/*  688 */       this._events.post(IEmployeeTask.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  695 */     boolean ev_postable = false;
/*      */     
/*  697 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  698 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  699 */       getDAO_().setCreateDate(argCreateDate);
/*  700 */       ev_postable = true;
/*      */     } 
/*      */     
/*  703 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  711 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  719 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  720 */       this._events != null && 
/*  721 */       postEventsForChanges()) {
/*  722 */       this._events.post(IEmployeeTask.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  729 */     boolean ev_postable = false;
/*      */     
/*  731 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  732 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  733 */       getDAO_().setCreateUserId(argCreateUserId);
/*  734 */       ev_postable = true;
/*      */     } 
/*      */     
/*  737 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  745 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  753 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  754 */       this._events != null && 
/*  755 */       postEventsForChanges()) {
/*  756 */       this._events.post(IEmployeeTask.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  763 */     boolean ev_postable = false;
/*      */     
/*  765 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  766 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  767 */       getDAO_().setUpdateDate(argUpdateDate);
/*  768 */       ev_postable = true;
/*      */     } 
/*      */     
/*  771 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  779 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  787 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  788 */       this._events != null && 
/*  789 */       postEventsForChanges()) {
/*  790 */       this._events.post(IEmployeeTask.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  797 */     boolean ev_postable = false;
/*      */     
/*  799 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  800 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  801 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  802 */       ev_postable = true;
/*      */     } 
/*      */     
/*  805 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IEmployeeTaskProperty newProperty(String argPropertyName) {
/*  809 */     EmployeeTaskPropertyId id = new EmployeeTaskPropertyId();
/*      */     
/*  811 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  812 */     id.setTaskId(Long.valueOf(getTaskId()));
/*  813 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  815 */     IEmployeeTaskProperty prop = (IEmployeeTaskProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IEmployeeTaskProperty.class);
/*  816 */     return prop;
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
/*      */   @Relationship(name = "CustomerParty")
/*      */   public IParty getCustomerParty() {
/*  831 */     return this._customerParty;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setCustomerParty(IParty argCustomerParty) {
/*  836 */     if (argCustomerParty == null) {
/*      */       
/*  838 */       getDAO_().setPartyId(null);
/*  839 */       if (this._customerParty != null)
/*      */       {
/*  841 */         if (postEventsForChanges()) {
/*  842 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._customerParty));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  847 */       getDAO_().setPartyId(Long.valueOf(argCustomerParty.getPartyId()));
/*      */       
/*  849 */       if (postEventsForChanges()) {
/*  850 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerParty));
/*      */       }
/*      */     } 
/*      */     
/*  854 */     this._customerParty = argCustomerParty;
/*  855 */     if (postEventsForChanges()) {
/*  856 */       this._events.post(IEmployeeTask.SET_CUSTOMERPARTY, argCustomerParty);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "EmployeeTaskNotes")
/*      */   public List<IEmployeeTaskNote> getEmployeeTaskNotes() {
/*  862 */     if (this._employeeTaskNotes == null) {
/*  863 */       this._employeeTaskNotes = new HistoricalList(null);
/*      */     }
/*  865 */     return (List<IEmployeeTaskNote>)this._employeeTaskNotes;
/*      */   }
/*      */   
/*      */   public void setEmployeeTaskNotes(List<IEmployeeTaskNote> argEmployeeTaskNotes) {
/*  869 */     if (this._employeeTaskNotes == null) {
/*  870 */       this._employeeTaskNotes = new HistoricalList(argEmployeeTaskNotes);
/*      */     } else {
/*  872 */       this._employeeTaskNotes.setCurrentList(argEmployeeTaskNotes);
/*      */     } 
/*      */     
/*  875 */     for (IEmployeeTaskNote child : this._employeeTaskNotes) {
/*  876 */       EmployeeTaskNoteModel model = (EmployeeTaskNoteModel)child;
/*  877 */       model.setOrganizationId_noev(getOrganizationId());
/*  878 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  879 */       model.setTaskId_noev(getTaskId());
/*  880 */       if (child instanceof IDataModelImpl) {
/*  881 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  882 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  883 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  884 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  887 */       if (postEventsForChanges()) {
/*  888 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addEmployeeTaskNote(IEmployeeTaskNote argEmployeeTaskNote) {
/*  894 */     if (this._employeeTaskNotes == null) {
/*  895 */       this._employeeTaskNotes = new HistoricalList(null);
/*      */     }
/*  897 */     argEmployeeTaskNote.setOrganizationId(getOrganizationId());
/*  898 */     argEmployeeTaskNote.setRetailLocationId(getRetailLocationId());
/*  899 */     argEmployeeTaskNote.setTaskId(getTaskId());
/*  900 */     if (argEmployeeTaskNote instanceof IDataModelImpl) {
/*  901 */       IDataAccessObject childDao = ((IDataModelImpl)argEmployeeTaskNote).getDAO();
/*  902 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  903 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  904 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  909 */     if (postEventsForChanges()) {
/*  910 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeTaskNote));
/*      */     }
/*      */     
/*  913 */     this._employeeTaskNotes.add(argEmployeeTaskNote);
/*  914 */     if (postEventsForChanges()) {
/*  915 */       this._events.post(IEmployeeTask.ADD_EMPLOYEETASKNOTES, argEmployeeTaskNote);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeEmployeeTaskNote(IEmployeeTaskNote argEmployeeTaskNote) {
/*  920 */     if (this._employeeTaskNotes != null) {
/*      */       
/*  922 */       if (postEventsForChanges()) {
/*  923 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeTaskNote));
/*      */       }
/*  925 */       this._employeeTaskNotes.remove(argEmployeeTaskNote);
/*  926 */       if (postEventsForChanges()) {
/*  927 */         this._events.post(IEmployeeTask.REMOVE_EMPLOYEETASKNOTES, argEmployeeTaskNote);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IEmployeeTaskProperty> getProperties() {
/*  934 */     if (this._properties == null) {
/*  935 */       this._properties = new HistoricalList(null);
/*      */     }
/*  937 */     return (List<IEmployeeTaskProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IEmployeeTaskProperty> argProperties) {
/*  941 */     if (this._properties == null) {
/*  942 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  944 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  947 */     for (IEmployeeTaskProperty child : this._properties) {
/*  948 */       EmployeeTaskPropertyModel model = (EmployeeTaskPropertyModel)child;
/*  949 */       model.setOrganizationId_noev(getOrganizationId());
/*  950 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  951 */       model.setTaskId_noev(getTaskId());
/*  952 */       if (child instanceof IDataModelImpl) {
/*  953 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  954 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  955 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  956 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  959 */       if (postEventsForChanges()) {
/*  960 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addEmployeeTaskProperty(IEmployeeTaskProperty argEmployeeTaskProperty) {
/*  966 */     if (this._properties == null) {
/*  967 */       this._properties = new HistoricalList(null);
/*      */     }
/*  969 */     argEmployeeTaskProperty.setOrganizationId(getOrganizationId());
/*  970 */     argEmployeeTaskProperty.setRetailLocationId(getRetailLocationId());
/*  971 */     argEmployeeTaskProperty.setTaskId(getTaskId());
/*  972 */     if (argEmployeeTaskProperty instanceof IDataModelImpl) {
/*  973 */       IDataAccessObject childDao = ((IDataModelImpl)argEmployeeTaskProperty).getDAO();
/*  974 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  975 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  976 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  981 */     if (postEventsForChanges()) {
/*  982 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeTaskProperty));
/*      */     }
/*      */     
/*  985 */     this._properties.add(argEmployeeTaskProperty);
/*  986 */     if (postEventsForChanges()) {
/*  987 */       this._events.post(IEmployeeTask.ADD_PROPERTIES, argEmployeeTaskProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeEmployeeTaskProperty(IEmployeeTaskProperty argEmployeeTaskProperty) {
/*  992 */     if (this._properties != null) {
/*      */       
/*  994 */       if (postEventsForChanges()) {
/*  995 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeTaskProperty));
/*      */       }
/*  997 */       this._properties.remove(argEmployeeTaskProperty);
/*  998 */       if (postEventsForChanges()) {
/*  999 */         this._events.post(IEmployeeTask.REMOVE_PROPERTIES, argEmployeeTaskProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1006 */     if ("CustomerParty".equals(argFieldId)) {
/* 1007 */       return getCustomerParty();
/*      */     }
/* 1009 */     if ("EmployeeTaskNotes".equals(argFieldId)) {
/* 1010 */       return getEmployeeTaskNotes();
/*      */     }
/* 1012 */     if ("Properties".equals(argFieldId)) {
/* 1013 */       return getProperties();
/*      */     }
/* 1015 */     if ("EmployeeTaskExtension".equals(argFieldId)) {
/* 1016 */       return this._myExtension;
/*      */     }
/*      */     
/* 1019 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1025 */     if ("CustomerParty".equals(argFieldId)) {
/* 1026 */       setCustomerParty((IParty)argValue);
/*      */     }
/* 1028 */     else if ("EmployeeTaskNotes".equals(argFieldId)) {
/* 1029 */       setEmployeeTaskNotes(changeToList(argValue, IEmployeeTaskNote.class));
/*      */     }
/* 1031 */     else if ("Properties".equals(argFieldId)) {
/* 1032 */       setProperties(changeToList(argValue, IEmployeeTaskProperty.class));
/*      */     }
/* 1034 */     else if ("EmployeeTaskExtension".equals(argFieldId)) {
/* 1035 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1038 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1044 */     this._persistenceDefaults = argPD;
/* 1045 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1046 */     this._eventManager = argEM;
/* 1047 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1048 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1049 */     if (this._customerParty != null) {
/* 1050 */       ((IDataModelImpl)this._customerParty).setDependencies(argPD, argEM);
/*      */     }
/* 1052 */     if (this._employeeTaskNotes != null) {
/* 1053 */       for (IEmployeeTaskNote relationship : this._employeeTaskNotes) {
/* 1054 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1057 */     if (this._properties != null) {
/* 1058 */       for (IEmployeeTaskProperty relationship : this._properties) {
/* 1059 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getEmployeeTaskExt() {
/* 1065 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setEmployeeTaskExt(IDataModel argExt) {
/* 1069 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1074 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1078 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1081 */     super.startTransaction();
/*      */     
/* 1083 */     this._customerPartySavepoint = this._customerParty;
/* 1084 */     if (this._customerParty != null) {
/* 1085 */       this._customerParty.startTransaction();
/*      */     }
/*      */     
/* 1088 */     this._employeeTaskNotesSavepoint = this._employeeTaskNotes;
/* 1089 */     if (this._employeeTaskNotes != null) {
/* 1090 */       this._employeeTaskNotesSavepoint = new HistoricalList((List)this._employeeTaskNotes);
/* 1091 */       Iterator<IDataModel> it = this._employeeTaskNotes.iterator();
/* 1092 */       while (it.hasNext()) {
/* 1093 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1097 */     this._propertiesSavepoint = this._properties;
/* 1098 */     if (this._properties != null) {
/* 1099 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1100 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1101 */       while (it.hasNext()) {
/* 1102 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1107 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1112 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1115 */     super.rollbackChanges();
/*      */     
/* 1117 */     this._customerParty = this._customerPartySavepoint;
/* 1118 */     this._customerPartySavepoint = null;
/* 1119 */     if (this._customerParty != null) {
/* 1120 */       this._customerParty.rollbackChanges();
/*      */     }
/*      */     
/* 1123 */     this._employeeTaskNotes = this._employeeTaskNotesSavepoint;
/* 1124 */     this._employeeTaskNotesSavepoint = null;
/* 1125 */     if (this._employeeTaskNotes != null) {
/* 1126 */       Iterator<IDataModel> it = this._employeeTaskNotes.iterator();
/* 1127 */       while (it.hasNext()) {
/* 1128 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1132 */     this._properties = this._propertiesSavepoint;
/* 1133 */     this._propertiesSavepoint = null;
/* 1134 */     if (this._properties != null) {
/* 1135 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1136 */       while (it.hasNext()) {
/* 1137 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1145 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1148 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1151 */     super.commitTransaction();
/*      */     
/* 1153 */     this._customerPartySavepoint = this._customerParty;
/* 1154 */     if (this._customerParty != null) {
/* 1155 */       this._customerParty.commitTransaction();
/*      */     }
/*      */     
/* 1158 */     this._employeeTaskNotesSavepoint = this._employeeTaskNotes;
/* 1159 */     if (this._employeeTaskNotes != null) {
/* 1160 */       Iterator<IDataModel> it = this._employeeTaskNotes.iterator();
/* 1161 */       while (it.hasNext()) {
/* 1162 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1164 */       this._employeeTaskNotes = new HistoricalList((List)this._employeeTaskNotes);
/*      */     } 
/*      */     
/* 1167 */     this._propertiesSavepoint = this._properties;
/* 1168 */     if (this._properties != null) {
/* 1169 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1170 */       while (it.hasNext()) {
/* 1171 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1173 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1177 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1182 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeTaskModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */