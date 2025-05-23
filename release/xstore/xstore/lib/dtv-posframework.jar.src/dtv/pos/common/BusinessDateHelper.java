/*     */ package dtv.pos.common;
/*     */ 
/*     */ import dtv.i18n.FormatterFactory;
/*     */ import dtv.i18n.IFormatter;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.framework.systemcycle.StateJournalHelper;
/*     */ import dtv.pos.framework.systemcycle.StateJournalType;
/*     */ import dtv.pos.framework.systemcycle.SystemCycleHelper;
/*     */ import dtv.pos.iframework.security.StationState;
/*     */ import dtv.pos.storecalendar.DateOutOfRangeException;
/*     */ import dtv.pos.storecalendar.IStoreCalendar;
/*     */ import dtv.pos.storecalendar.OperationRestrictedException;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.IStateJournal;
/*     */ import java.time.LocalDate;
/*     */ import java.time.LocalDateTime;
/*     */ import java.time.LocalTime;
/*     */ import java.time.ZoneId;
/*     */ import java.util.Date;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BusinessDateHelper
/*     */ {
/*     */   @Inject
/*     */   private StateJournalHelper _stateJournalHelper;
/*     */   @Inject
/*     */   private IStoreCalendar _storeCalendar;
/*     */   @Inject
/*     */   private SystemCycleHelper _systemCycleHelper;
/*     */   
/*     */   public static String getDateTimeRange(Date argRetailPeriodDate) {
/*  36 */     LocalDate retailPeriodDate = argRetailPeriodDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
/*  37 */     LocalTime storeOpenTime = ConfigurationMgr.getStoreOpenTime();
/*  38 */     LocalDateTime retailPeriodOpenDateTime = LocalDateTime.of(retailPeriodDate, storeOpenTime);
/*  39 */     LocalDateTime retailPeriodCloseDateTime = retailPeriodOpenDateTime.plusHours(23L).plusMinutes(59L);
/*     */     
/*  41 */     IFormatter dateTimeShortFormatter = FormatterFactory.getInstance().getDateTimeShortFormatter();
/*  42 */     Date open = Date.from(retailPeriodOpenDateTime.atZone(ZoneId.systemDefault()).toInstant());
/*  43 */     Date close = Date.from(retailPeriodCloseDateTime.atZone(ZoneId.systemDefault()).toInstant());
/*     */     
/*  45 */     StringBuilder retailPeriodString = new StringBuilder(40);
/*  46 */     retailPeriodString.append(dateTimeShortFormatter.format(open, OutputContextType.VIEW));
/*  47 */     retailPeriodString.append(" - ");
/*  48 */     retailPeriodString.append(dateTimeShortFormatter.format(close, OutputContextType.VIEW));
/*     */     
/*  50 */     return retailPeriodString.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static LocalDate calculateAssignedBusinessDate(BusinessDayPhase argBusinessDayPhase, LocalDateTime argSystemDate) {
/*     */     LocalDate assignedBusinessDate;
/*  60 */     switch (argBusinessDayPhase.assignedTimeframe()) {
/*     */       case TODAY:
/*  62 */         assignedBusinessDate = argSystemDate.toLocalDate();
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
/*  74 */         return assignedBusinessDate;case YESTERDAY: assignedBusinessDate = argSystemDate.toLocalDate().minusDays(1L); return assignedBusinessDate;case YESTER_YESTERDAY: assignedBusinessDate = argSystemDate.toLocalDate().minusDays(2L); return assignedBusinessDate;
/*     */     } 
/*     */     throw new RuntimeException("Business day assigned timeframe has resolved to an undefined timeframe");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static LocalDate calculateOptimalBusinessDate(BusinessDayPhase argBusinessDayPhase, LocalDateTime argSystemDate) {
/*     */     LocalDate optimalBusinessDate;
/*  84 */     switch (argBusinessDayPhase.optimalTimeframe()) {
/*     */       case YESTERDAY:
/*  86 */         optimalBusinessDate = argSystemDate.toLocalDate().minusDays(1L);
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
/*  99 */         return optimalBusinessDate;case TODAY: optimalBusinessDate = argSystemDate.toLocalDate(); return optimalBusinessDate;case TOMORROW: optimalBusinessDate = argSystemDate.toLocalDate().plusDays(1L); return optimalBusinessDate;
/*     */     } 
/*     */     throw new RuntimeException("Business day assigned timeframe has resolved to an undefined timeframe");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static BusinessDayPhase getBusinessDayPhase(LocalDateTime argSystemDateTime) {
/*     */     BusinessDayPhase businessDayPhase;
/* 112 */     LocalTime storeOpenTime = ConfigurationMgr.getStoreOpenTime();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     LocalDateTime todayOpenDateTime = LocalDateTime.of(argSystemDateTime.toLocalDate(), storeOpenTime);
/*     */ 
/*     */ 
/*     */     
/* 125 */     LocalDateTime yesterdayWarningDateTime = todayOpenDateTime.minusMinutes(ConfigurationMgr.getStoreCloseWarningSpan());
/* 126 */     LocalDateTime todayWarningDateTime = yesterdayWarningDateTime.plusDays(1L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     LocalDateTime yesterdayDropDeadDateTime = todayWarningDateTime.plusMinutes((ConfigurationMgr.getStoreCloseGracePeriod() + ConfigurationMgr.getStoreCloseWarningSpan())).minusDays(1L);
/* 133 */     LocalDateTime yesterYesterdayDropDeadDateTime = yesterdayDropDeadDateTime.minusDays(1L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 140 */     if (argSystemDateTime.isBefore(yesterYesterdayDropDeadDateTime)) {
/* 141 */       businessDayPhase = BusinessDayPhase.YEST_YEST_GRACE;
/*     */     }
/* 143 */     else if (argSystemDateTime.isBefore(yesterdayWarningDateTime)) {
/* 144 */       businessDayPhase = BusinessDayPhase.YEST_REGULAR;
/*     */     }
/* 146 */     else if (argSystemDateTime.isBefore(todayOpenDateTime)) {
/* 147 */       businessDayPhase = BusinessDayPhase.YEST_WARN;
/*     */     }
/* 149 */     else if (argSystemDateTime.isBefore(yesterdayDropDeadDateTime)) {
/* 150 */       businessDayPhase = BusinessDayPhase.YEST_GRACE;
/*     */     }
/* 152 */     else if (argSystemDateTime.isBefore(todayWarningDateTime)) {
/* 153 */       businessDayPhase = BusinessDayPhase.TODAY_REGULAR;
/*     */     } else {
/*     */       
/* 156 */       businessDayPhase = BusinessDayPhase.TODAY_WARN;
/*     */     } 
/*     */     
/* 159 */     return businessDayPhase;
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
/*     */   public BusinessDate calculateAssignedBusinessDate(LocalDateTime argSystemDate, long argRetailLocationId) {
/* 184 */     LocalDate assignedBusinessDateCandidate = calculateAssignedBusinessDate(getBusinessDayPhase(argSystemDate), argSystemDate);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 192 */     boolean businessPeriodHasEnded = !this._systemCycleHelper.businessPeriodHasClosed(argRetailLocationId, Date.from(assignedBusinessDateCandidate.atStartOfDay(ZoneId.systemDefault()).toInstant())).isEmpty();
/*     */ 
/*     */     
/* 195 */     boolean scheduledStoreClose = (!ConfigurationMgr.getAllowUnscheduledBusinessDateOpen() && this._storeCalendar.isScheduledCloseDate(
/* 196 */         Date.from(assignedBusinessDateCandidate.atStartOfDay(ZoneId.systemDefault()).toInstant()), (int)argRetailLocationId));
/*     */ 
/*     */     
/* 199 */     return (businessPeriodHasEnded || scheduledStoreClose) ? 
/* 200 */       calculateOptimalBusinessDate(argSystemDate, argRetailLocationId) : new BusinessDate(assignedBusinessDateCandidate, BusinessDateQualifier.ELIGIBLE_FOR_REGISTER_OPEN);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DtvDate calculateInitialBusinessDate(int argRetailLocationId, int argWorkstationId) throws DateOutOfRangeException {
/* 219 */     Date adjustedDate, now = DateUtils.clearTime(DateUtils.getNewDate());
/*     */ 
/*     */ 
/*     */     
/* 223 */     if (ConfigurationMgr.isRollingCloseEnabled()) {
/* 224 */       Date dateCandidate; IStateJournal stateJournal = this._stateJournalHelper.lookupStateJournal(StateJournalType.WKSTN_STATE, argRetailLocationId, argWorkstationId);
/*     */       
/* 226 */       if (stateJournal != null) {
/* 227 */         dateCandidate = stateJournal.getDateValue();
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 232 */         dateCandidate = now;
/*     */       } 
/*     */       
/* 235 */       adjustedDate = dateCandidate;
/*     */     } else {
/*     */       Date dateCandidate;
/*     */ 
/*     */       
/* 240 */       IStateJournal stateJournal = this._stateJournalHelper.lookupStateJournal(StateJournalType.BUSINESS_DATE, argRetailLocationId, argWorkstationId);
/*     */       
/* 242 */       if (stateJournal != null) {
/* 243 */         dateCandidate = stateJournal.getDateValue();
/*     */       }
/*     */       else {
/*     */         
/* 247 */         dateCandidate = now;
/*     */       } 
/*     */ 
/*     */       
/* 251 */       if (!ConfigurationMgr.getAllowUnscheduledBusinessDateOpen() && this._storeCalendar
/* 252 */         .isScheduledCloseDate(dateCandidate, argRetailLocationId)) {
/* 253 */         adjustedDate = this._storeCalendar.getNextOpenDate(dateCandidate, argRetailLocationId);
/*     */       } else {
/*     */         
/* 256 */         adjustedDate = dateCandidate;
/*     */       } 
/*     */     } 
/*     */     
/* 260 */     return new DtvDate(adjustedDate);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BusinessDate calculateOptimalBusinessDate(LocalDateTime argSystemDate, long argRetailLocationId) {
/* 276 */     LocalDate optimalBusinessDate = calculateOptimalBusinessDate(getBusinessDayPhase(argSystemDate), argSystemDate);
/*     */ 
/*     */     
/* 279 */     if (!this._systemCycleHelper.businessPeriodHasClosed(argRetailLocationId, Date.from(optimalBusinessDate.atStartOfDay(ZoneId.systemDefault()).toInstant())).isEmpty()) {
/* 280 */       return new BusinessDate(optimalBusinessDate, BusinessDateQualifier.BUSINESS_PERIOD_ENDED);
/*     */     }
/* 282 */     if (!ConfigurationMgr.getAllowUnscheduledBusinessDateOpen() && this._storeCalendar.isScheduledCloseDate(
/* 283 */         Date.from(optimalBusinessDate.atStartOfDay(ZoneId.systemDefault()).toInstant()), (int)argRetailLocationId))
/*     */     {
/* 285 */       return new BusinessDate(optimalBusinessDate, BusinessDateQualifier.STORE_CLOSED_DATE);
/*     */     }
/*     */     
/* 288 */     return new BusinessDate(optimalBusinessDate, BusinessDateQualifier.ELIGIBLE_FOR_REGISTER_OPEN);
/*     */   }
/*     */ 
/*     */   
/*     */   public void forceUpdateBusinessDate(StationState argStationState, Date argNewBusinessDate) {
/* 293 */     if (argNewBusinessDate instanceof DtvDate) {
/* 294 */       argStationState.setBusinessDate((DtvDate)argNewBusinessDate);
/*     */     } else {
/*     */       
/* 297 */       argStationState.setBusinessDate(new DtvDate(DateUtils.clearTime(argNewBusinessDate)));
/*     */     } 
/*     */ 
/*     */     
/* 301 */     if (this._storeCalendar.isBusinessDateSettable() && 
/* 302 */       !ConfigurationMgr.isRollingCloseEnabled())
/*     */     {
/* 304 */       this._systemCycleHelper.setBusinessDate(argStationState.getRetailLocationId(), argStationState
/* 305 */           .getWorkstationId(), (Date)argStationState.getCurrentBusinessDate());
/*     */     }
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
/*     */   
/*     */   public boolean inExpiredPeriod(Date argCurrentBusinessDate, LocalDateTime argSystemDate, int argRetailLocationId) {
/* 319 */     BusinessDate businessDate = calculateAssignedBusinessDate(argSystemDate, argRetailLocationId);
/*     */     
/* 321 */     if (!businessDate.getQualifier().equals(BusinessDateQualifier.ELIGIBLE_FOR_REGISTER_OPEN)) {
/* 322 */       return true;
/*     */     }
/*     */     
/* 325 */     return argCurrentBusinessDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
/* 326 */       .isBefore(businessDate.getBusinessDate());
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
/*     */   
/*     */   public boolean inGracePeriod(Date argCurrentBusinessDate, LocalDateTime argSystemDate, int argRetailLocationId) {
/* 339 */     return (BusinessDaySubphase.GRACE.equals(getBusinessDayPhase(argSystemDate).subphase()) && argCurrentBusinessDate
/* 340 */       .toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
/* 341 */       .isEqual(calculateAssignedBusinessDate(argSystemDate, argRetailLocationId).getBusinessDate()));
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
/*     */   
/*     */   public boolean inWarningPeriod(Date argCurrentBusinessDate, LocalDateTime argSystemDate, int argRetailLocationId) {
/* 354 */     return (BusinessDaySubphase.WARN.equals(getBusinessDayPhase(argSystemDate).subphase()) && argCurrentBusinessDate
/* 355 */       .toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
/* 356 */       .isEqual(calculateAssignedBusinessDate(argSystemDate, argRetailLocationId).getBusinessDate()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateBusinessDate(StationState argStationState, Date argNewBusinessDate) throws DateOutOfRangeException, OperationRestrictedException {
/* 362 */     this._storeCalendar.validateNewBusinessDate(argNewBusinessDate, (Date)argStationState.getCurrentBusinessDate());
/* 363 */     forceUpdateBusinessDate(argStationState, argNewBusinessDate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setStateJournalHelper(StateJournalHelper argStateJournalHelper) {
/* 371 */     this._stateJournalHelper = argStateJournalHelper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setStoreCalendar(IStoreCalendar argStoreCalendar) {
/* 379 */     this._storeCalendar = argStoreCalendar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSystemCycleHelper(SystemCycleHelper argSystemCycleHelper) {
/* 387 */     this._systemCycleHelper = argSystemCycleHelper;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private enum BusinessDayPhase
/*     */   {
/* 407 */     YEST_YEST_GRACE((String)BusinessDateHelper.BusinessDaySubphase.GRACE, BusinessDateHelper.BusinessDayTimeframe.YESTER_YESTERDAY, (BusinessDateHelper.BusinessDaySubphase)BusinessDateHelper.BusinessDayTimeframe.YESTERDAY),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 412 */     YEST_REGULAR((String)BusinessDateHelper.BusinessDaySubphase.REGULAR, BusinessDateHelper.BusinessDayTimeframe.YESTERDAY, (BusinessDateHelper.BusinessDaySubphase)BusinessDateHelper.BusinessDayTimeframe.YESTERDAY),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 419 */     YEST_WARN((String)BusinessDateHelper.BusinessDaySubphase.WARN, BusinessDateHelper.BusinessDayTimeframe.YESTERDAY, (BusinessDateHelper.BusinessDaySubphase)BusinessDateHelper.BusinessDayTimeframe.TODAY),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 426 */     YEST_GRACE((String)BusinessDateHelper.BusinessDaySubphase.GRACE, BusinessDateHelper.BusinessDayTimeframe.YESTERDAY, (BusinessDateHelper.BusinessDaySubphase)BusinessDateHelper.BusinessDayTimeframe.TODAY),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 431 */     TODAY_REGULAR((String)BusinessDateHelper.BusinessDaySubphase.REGULAR, BusinessDateHelper.BusinessDayTimeframe.TODAY, (BusinessDateHelper.BusinessDaySubphase)BusinessDateHelper.BusinessDayTimeframe.TODAY),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 438 */     TODAY_WARN((String)BusinessDateHelper.BusinessDaySubphase.WARN, BusinessDateHelper.BusinessDayTimeframe.TODAY, (BusinessDateHelper.BusinessDaySubphase)BusinessDateHelper.BusinessDayTimeframe.TOMORROW);
/*     */ 
/*     */     
/*     */     private final BusinessDateHelper.BusinessDaySubphase _subphase;
/*     */ 
/*     */     
/*     */     private final BusinessDateHelper.BusinessDayTimeframe _assignedTimeframe;
/*     */ 
/*     */     
/*     */     private final BusinessDateHelper.BusinessDayTimeframe _optimalTimeframe;
/*     */ 
/*     */     
/*     */     BusinessDayPhase(BusinessDateHelper.BusinessDaySubphase argSubphase, BusinessDateHelper.BusinessDayTimeframe argAssignedTimeframe, BusinessDateHelper.BusinessDayTimeframe optimalTimeframe) {
/* 451 */       this._subphase = argSubphase;
/* 452 */       this._assignedTimeframe = argAssignedTimeframe;
/* 453 */       this._optimalTimeframe = optimalTimeframe;
/*     */     }
/*     */     
/*     */     public BusinessDateHelper.BusinessDayTimeframe assignedTimeframe() {
/* 457 */       return this._assignedTimeframe;
/*     */     }
/*     */     
/*     */     public BusinessDateHelper.BusinessDayTimeframe optimalTimeframe() {
/* 461 */       return this._optimalTimeframe;
/*     */     }
/*     */     
/*     */     public BusinessDateHelper.BusinessDaySubphase subphase() {
/* 465 */       return this._subphase;
/*     */     }
/*     */   }
/*     */   
/*     */   private enum BusinessDaySubphase {
/* 470 */     REGULAR, GRACE, WARN;
/*     */   }
/*     */   
/*     */   private enum BusinessDayTimeframe {
/* 474 */     YESTER_YESTERDAY, YESTERDAY, TODAY, TOMORROW;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\BusinessDateHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */