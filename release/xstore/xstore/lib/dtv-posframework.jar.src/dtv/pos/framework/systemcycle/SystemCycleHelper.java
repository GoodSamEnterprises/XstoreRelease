/*     */ package dtv.pos.framework.systemcycle;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.data2.access.exception.PersistenceException;
/*     */ import dtv.event.EventEnum;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.eventor.DefaultEventor;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.common.OpExecutionException;
/*     */ import dtv.pos.framework.comm.MessageRouter;
/*     */ import dtv.pos.framework.comm.constraint.TaskNameConstraint;
/*     */ import dtv.pos.iframework.assistance.ITrainingModeHelper;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.message.IMessageConstraint;
/*     */ import dtv.util.message.IMessageListener;
/*     */ import dtv.util.message.Message;
/*     */ import dtv.xst.dao.loc.ClosingMessageId;
/*     */ import dtv.xst.dao.loc.IClosingMessage;
/*     */ import dtv.xst.dao.loc.IStateJournal;
/*     */ import dtv.xst.dao.loc.IWorkstation;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.SortedMap;
/*     */ import java.util.TreeMap;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class SystemCycleHelper implements IEventSource {
/*  39 */   public static final EventEnum WORKSTATION_OPEN_CHANGE = new EventEnum("WorkstationOpenStateChanged");
/*  40 */   public static final EventEnum RETAIL_LOCATION_OPEN_CHANGE = new EventEnum("RetailLocationOpenStateChanged");
/*     */   
/*  42 */   private static final Logger logger_ = Logger.getLogger(SystemCycleHelper.class);
/*     */   
/*  44 */   private static final IQueryKey<IWorkstation> OPEN_WKSTNS = (IQueryKey<IWorkstation>)new QueryKey("OPEN_WKSTNS", IWorkstation.class);
/*     */ 
/*     */   
/*  47 */   private static final IQueryKey<BusinessDayQueryResult> END_OF_DAY_BUSINESS_DATES = (IQueryKey<BusinessDayQueryResult>)new QueryKey("END_OF_DAY_BUSINESS_DATES", BusinessDayQueryResult.class);
/*     */ 
/*     */   
/*  50 */   private static final IQueryKey<BusinessDayQueryResult> END_OF_DAY_COMPLETED = (IQueryKey<BusinessDayQueryResult>)new QueryKey("END_OF_DAY_COMPLETED", BusinessDayQueryResult.class);
/*     */ 
/*     */   
/*  53 */   private static final IQueryKey<BusinessDayQueryResult> STARTED_BUSINESS_PERIODS = (IQueryKey<BusinessDayQueryResult>)new QueryKey("STARTED_BUSINESS_PERIODS", BusinessDayQueryResult.class);
/*     */ 
/*     */   
/*  56 */   private static final IQueryKey<RetailLocationIdQueryResult> HAS_STORE_EVER_BEEN_OPENED = (IQueryKey<RetailLocationIdQueryResult>)new QueryKey("HAS_STORE_EVER_BEEN_OPENED", RetailLocationIdQueryResult.class);
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private StateJournalHelper stateJournalHelper_;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private ITrainingModeHelper _trainingModeHelper;
/*     */ 
/*     */   
/*     */   private final Map<Boolean, State> states_;
/*     */ 
/*     */   
/*  71 */   protected Eventor events_ = (Eventor)new DefaultEventor(this);
/*     */   
/*     */   private final IMessageListener storeCloseMsgListener_;
/*     */   private final IMessageListener storeOpenMsgListener_;
/*     */   
/*     */   protected SystemCycleHelper() {
/*  77 */     Map<Boolean, State> temp = new HashMap<>(4);
/*  78 */     temp.put(Boolean.TRUE, new State());
/*  79 */     temp.put(Boolean.FALSE, new State());
/*  80 */     this.states_ = Collections.unmodifiableMap(temp);
/*     */ 
/*     */ 
/*     */     
/*  84 */     this.storeOpenMsgListener_ = (msg -> setRetailLocationOpenState(true));
/*     */     
/*  86 */     this.storeCloseMsgListener_ = (msg -> {
/*     */         if (!ConfigurationMgr.isRollingCloseEnabled() || !msg.getSource().equals("ENVIRONMENT")) {
/*     */           setRetailLocationOpenState(false);
/*     */         }
/*     */       });
/*     */     
/*  92 */     MessageRouter.getInstance().addMessageListener(this.storeOpenMsgListener_, (IMessageConstraint)new TaskNameConstraint(
/*  93 */           ConfigurationMgr.getEndOpeningTask()));
/*     */     
/*  95 */     MessageRouter.getInstance().addMessageListener(this.storeCloseMsgListener_, (IMessageConstraint)new TaskNameConstraint(
/*  96 */           ConfigurationMgr.getEndClosingTask()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void beginBusinessPeriod(long argRetailLocatoinId, long argWorkstationId, Date argCurrentBusinessDate) {
/* 103 */     IStateJournal persistStateJournal = this.stateJournalHelper_.createStateJournal(StateJournalType.BUSINESS_PERIOD, argRetailLocatoinId, argWorkstationId);
/* 104 */     persistStateJournal.setStringValue(BusinessPeriodStateType.OPEN.getName());
/* 105 */     persistStateJournal.setDateValue(argCurrentBusinessDate);
/*     */     
/*     */     try {
/* 108 */       DataFactory.makePersistent(persistStateJournal);
/* 109 */       this.stateJournalHelper_.syncJournalLocally(persistStateJournal);
/*     */     }
/* 111 */     catch (PersistenceException ex) {
/* 112 */       logger_.error("Exception caught trying to persist business period data when setting business period to open.", (Throwable)ex);
/*     */       
/* 114 */       throw new RuntimeException(ex);
/*     */     } 
/*     */     
/* 117 */     if (logger_.isInfoEnabled()) {
/* 118 */       logger_.info("BusinessPeriod: " + argCurrentBusinessDate + " has been Opened.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<BusinessDayQueryResult> businessPeriodHasClosed(long argRetailLocationId, Date argBusinessDate) {
/* 125 */     Map<String, Object> params = new HashMap<>();
/* 126 */     params.put("argRetailLocationId", Long.valueOf(argRetailLocationId));
/* 127 */     params.put("argBusinessDate", argBusinessDate);
/* 128 */     return (List<BusinessDayQueryResult>)DataFactory.getObjectByQueryNoThrow(END_OF_DAY_COMPLETED, params);
/*     */   }
/*     */   
/*     */   public List<BusinessDayQueryResult> businessPeriodStarted(long argRetailLocationId, Date argBusinessDate) {
/* 132 */     Map<String, Object> params = new HashMap<>();
/* 133 */     params.put("argRetailLocationId", Long.valueOf(argRetailLocationId));
/* 134 */     params.put("argBusinessDate", argBusinessDate);
/* 135 */     return (List<BusinessDayQueryResult>)DataFactory.getObjectByQueryNoThrow(STARTED_BUSINESS_PERIODS, params);
/*     */   }
/*     */   
/*     */   public boolean checkRetailLocationIs(RetailLocationStateType locState) {
/* 139 */     RetailLocationStateType type = getRetailLocationState();
/* 140 */     if (logger_.isInfoEnabled()) {
/* 141 */       logger_.info("Retail Location State is: " + type);
/*     */     }
/* 143 */     return (type == locState);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkWorkStationIs(WorkstationStateType argState, long argRetailLocationId, long argWorkstationId) {
/* 148 */     return (getWorkStationState(argRetailLocationId, argWorkstationId) == argState);
/*     */   }
/*     */   
/*     */   public boolean closeRetailLocation(long argRetailLocationId, long argWorkstationId) {
/*     */     RetailLocationStateType state;
/* 153 */     IStateJournal stateJournal = this.stateJournalHelper_.lookupStateJournal(StateJournalType.RTL_LOC_STATE, argRetailLocationId, argWorkstationId);
/*     */ 
/*     */     
/* 156 */     if (stateJournal == null) {
/* 157 */       state = RetailLocationStateType.CLOSED;
/*     */     } else {
/*     */       
/* 160 */       state = RetailLocationStateType.forName(stateJournal.getStringValue());
/*     */     } 
/*     */     
/* 163 */     if (state == RetailLocationStateType.CLOSED) {
/* 164 */       logger_.warn("location already " + RetailLocationStateType.CLOSED.getName());
/* 165 */       return false;
/*     */     } 
/*     */     
/* 168 */     if (state == RetailLocationStateType.OPEN) {
/*     */       
/* 170 */       IStateJournal persistStateJournal = this.stateJournalHelper_.createStateJournal(StateJournalType.RTL_LOC_STATE, argRetailLocationId, argWorkstationId);
/* 171 */       persistStateJournal.setStringValue(RetailLocationStateType.CLOSED.getName());
/*     */       
/*     */       try {
/* 174 */         DataFactory.makePersistent(persistStateJournal);
/*     */         
/* 176 */         this.stateJournalHelper_.syncJournalLocally(persistStateJournal);
/*     */       }
/* 178 */       catch (PersistenceException ex) {
/* 179 */         logger_.error("Exception caught trying to persist retail location data when setting location to closed.", (Throwable)ex);
/*     */ 
/*     */         
/* 182 */         throw new OpExecutionException(ex);
/*     */       } 
/*     */       
/* 185 */       if (logger_.isInfoEnabled()) {
/* 186 */         logger_.info("Retail Loaction: " + argRetailLocationId + " has been Closed.");
/*     */       }
/*     */       
/* 189 */       setRetailLocationOpenState(false);
/*     */       
/* 191 */       return true;
/*     */     } 
/*     */     
/* 194 */     logger_.warn("unexpected location state " + state);
/* 195 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean closeWorkstation(long argRetailLocationId, long argWorkstationId, Date argCurrentBusinessDate) {
/* 201 */     IStateJournal stateJournal = this.stateJournalHelper_.lookupStateJournal(StateJournalType.WKSTN_STATE, argRetailLocationId, argWorkstationId);
/*     */ 
/*     */ 
/*     */     
/* 205 */     WorkstationStateType state = (stateJournal == null) ? WorkstationStateType.CLOSED : WorkstationStateType.forName(stateJournal.getStringValue());
/*     */     
/* 207 */     if (state == WorkstationStateType.CLOSED) {
/* 208 */       logger_.warn("workstation already " + WorkstationStateType.CLOSED.getName());
/* 209 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 213 */     if (state == WorkstationStateType.OPEN || state == WorkstationStateType.PENDING_CLOSE) {
/*     */       
/* 215 */       IStateJournal persistStateJournal = this.stateJournalHelper_.createStateJournal(StateJournalType.WKSTN_STATE, argRetailLocationId, argWorkstationId);
/* 216 */       persistStateJournal.setStringValue(WorkstationStateType.CLOSED.getName());
/* 217 */       persistStateJournal.setDateValue(argCurrentBusinessDate);
/*     */       
/*     */       try {
/* 220 */         DataFactory.makePersistent(persistStateJournal);
/* 221 */         this.stateJournalHelper_.syncJournalLocally(persistStateJournal);
/*     */       }
/* 223 */       catch (PersistenceException ex) {
/* 224 */         logger_.error("Exception caught trying to persist workstation data when setting workstation to closed.", (Throwable)ex);
/*     */ 
/*     */         
/* 227 */         throw new RuntimeException(ex);
/*     */       } 
/*     */       
/* 230 */       if (logger_.isInfoEnabled()) {
/* 231 */         logger_.info("workstation " + argWorkstationId + " has been Closed and is now ready for workstations to close");
/*     */       }
/*     */       
/* 234 */       setWorkstationOpenState(WorkstationStateType.CLOSED);
/*     */       
/* 236 */       return true;
/*     */     } 
/*     */     
/* 239 */     logger_.warn("unexpected station state");
/* 240 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean closeWorkstations(List<IWorkstation> workstations, long argRetailLocationId, long argLocalWorkstationId, Date argCurrentBusinessDate) {
/* 246 */     boolean status = false;
/* 247 */     boolean localWkstnClosed = false;
/*     */     
/* 249 */     if (workstations.isEmpty()) {
/* 250 */       return false;
/*     */     }
/*     */     
/* 253 */     Collection<IStateJournal> persistStateJournals = new ArrayList<>();
/* 254 */     for (IWorkstation workstation : workstations) {
/*     */       
/* 256 */       IStateJournal persistStateJournal = this.stateJournalHelper_.createStateJournal(StateJournalType.WKSTN_STATE, argRetailLocationId, workstation
/* 257 */           .getWorkstationId());
/*     */       
/* 259 */       persistStateJournal.setStringValue(WorkstationStateType.CLOSED.getName());
/* 260 */       persistStateJournal.setDateValue(argCurrentBusinessDate);
/* 261 */       persistStateJournals.add(persistStateJournal);
/*     */       
/* 263 */       if (workstation.getWorkstationId() == argLocalWorkstationId) {
/* 264 */         localWkstnClosed = true;
/*     */       }
/*     */     } 
/*     */     
/*     */     try {
/* 269 */       DataFactory.makePersistent(workstations.toArray());
/* 270 */       DataFactory.makePersistent(persistStateJournals.toArray());
/* 271 */       logger_.info("Retail Location: Workstations have been closed!");
/* 272 */       status = true;
/*     */     }
/* 274 */     catch (PersistenceException ex) {
/* 275 */       logger_.error("Exception caught trying to persist workstation data when setting workstation(s) to closed.", (Throwable)ex);
/*     */ 
/*     */       
/* 278 */       throw new OpExecutionException(ex);
/*     */     }
/* 280 */     catch (Exception ex) {
/* 281 */       logger_.error("Exception caught trying to close workstation(s).", ex);
/*     */     } 
/*     */     
/* 284 */     if (status && localWkstnClosed) {
/* 285 */       setWorkstationOpenState(WorkstationStateType.CLOSED);
/*     */     }
/* 287 */     return status;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void endBusinessPeriod(long argRetailLocatoinId, long argWorkstationId, Date argCurrentBusinessDate) {
/* 294 */     IStateJournal persistStateJournal = this.stateJournalHelper_.createStateJournal(StateJournalType.BUSINESS_PERIOD, argRetailLocatoinId, argWorkstationId);
/* 295 */     persistStateJournal.setStringValue(BusinessPeriodStateType.CLOSED.getName());
/* 296 */     persistStateJournal.setDateValue(argCurrentBusinessDate);
/*     */     
/*     */     try {
/* 299 */       DataFactory.makePersistent(persistStateJournal);
/* 300 */       this.stateJournalHelper_.syncJournalLocally(persistStateJournal);
/*     */     }
/* 302 */     catch (PersistenceException ex) {
/* 303 */       logger_.error("Exception caught trying to persist business period data when setting business period to open.", (Throwable)ex);
/*     */       
/* 305 */       throw new RuntimeException(ex);
/*     */     } 
/*     */     
/* 308 */     if (logger_.isInfoEnabled()) {
/* 309 */       logger_.info("BusinessPeriod: " + argCurrentBusinessDate + " has been Opened.");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getClosingMessage(long argRetailLocationId) {
/* 315 */     String message = null;
/*     */     try {
/* 317 */       ClosingMessageId id = new ClosingMessageId();
/* 318 */       id.setRetailLocationId(Long.valueOf(argRetailLocationId));
/*     */       
/* 320 */       IClosingMessage tempMessage = (IClosingMessage)DataFactory.getObjectById((IObjectId)id);
/*     */       
/* 322 */       if (tempMessage != null) {
/* 323 */         message = tempMessage.getClosingMessage();
/*     */       }
/*     */     }
/* 326 */     catch (ObjectNotFoundException ex) {
/* 327 */       logger_.info("No closing message to display");
/*     */     } 
/*     */     
/* 330 */     logger_.info("Processing Closing messages (Get Msg for display)");
/* 331 */     return message;
/*     */   }
/*     */   
/*     */   public List<BusinessDayQueryResult> getNonClosedBusinessPeriods(long argRetailLocationId) {
/* 335 */     Map<String, Object> params = new HashMap<>();
/* 336 */     params.put("argRetailLocationId", Long.valueOf(argRetailLocationId));
/* 337 */     return (List<BusinessDayQueryResult>)DataFactory.getObjectByQueryNoThrow(END_OF_DAY_BUSINESS_DATES, params);
/*     */   }
/*     */   
/*     */   public List<IWorkstation> getNonClosedWorkStations(long argRetailLocationId) {
/* 341 */     List<IWorkstation> wkstns = new ArrayList<>();
/* 342 */     SortedMap<Long, IWorkstation> tempSort = new TreeMap<>();
/*     */     
/* 344 */     List<IWorkstation> openWkstns = null;
/* 345 */     List<IWorkstation> pendingClosedWkstns = null;
/*     */     
/* 347 */     Map<String, Object> params = new HashMap<>();
/* 348 */     params.put("argRtlLocId", Long.valueOf(argRetailLocationId));
/* 349 */     params.put("argWsState", WorkstationStateType.OPEN.getName());
/*     */     
/* 351 */     IQueryResultList iQueryResultList1 = DataFactory.getObjectByQueryNoThrow(OPEN_WKSTNS, params);
/*     */     
/* 353 */     for (IWorkstation wkstn : iQueryResultList1) {
/*     */       
/* 355 */       wkstn.setWorkstationState(WorkstationStateType.OPEN.getName());
/* 356 */       tempSort.put(Long.valueOf(wkstn.getWorkstationId()), wkstn);
/*     */     } 
/*     */     
/* 359 */     params.put("argWsState", WorkstationStateType.PENDING_CLOSE.getName());
/*     */     
/* 361 */     IQueryResultList iQueryResultList2 = DataFactory.getObjectByQueryNoThrow(OPEN_WKSTNS, params);
/*     */     
/* 363 */     for (IWorkstation wkstn : iQueryResultList2) {
/*     */       
/* 365 */       tempSort.put(Long.valueOf(wkstn.getWorkstationId()), wkstn);
/* 366 */       wkstn.setWorkstationState(WorkstationStateType.PENDING_CLOSE.getName());
/*     */     } 
/*     */     
/* 369 */     if (tempSort.size() > 0) {
/* 370 */       wkstns.addAll(tempSort.values());
/*     */     }
/*     */     
/* 373 */     return wkstns;
/*     */   }
/*     */   
/*     */   public List<IWorkstation> getOpenWorkStations(long argRetailLocationId) {
/*     */     try {
/* 378 */       Map<String, Object> params = new HashMap<>();
/* 379 */       params.put("argRtlLocId", Long.valueOf(argRetailLocationId));
/* 380 */       params.put("argWsState", WorkstationStateType.OPEN.getName());
/* 381 */       IQueryResultList iQueryResultList = DataFactory.getObjectByQuery(OPEN_WKSTNS, params);
/*     */       
/* 383 */       if (iQueryResultList != null) {
/* 384 */         for (IWorkstation wkstn : iQueryResultList) {
/* 385 */           wkstn.setWorkstationState(WorkstationStateType.OPEN.getName());
/*     */         }
/*     */       }
/*     */       
/* 389 */       return (List<IWorkstation>)iQueryResultList;
/*     */     }
/* 391 */     catch (ObjectNotFoundException ex) {
/* 392 */       return new ArrayList<>();
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<IWorkstation> getPendingCloseWorkStations(long argRetailLocationId) {
/*     */     try {
/* 398 */       Map<String, Object> params = new HashMap<>();
/* 399 */       params.put("argRtlLocId", Long.valueOf(argRetailLocationId));
/* 400 */       params.put("argWsState", WorkstationStateType.PENDING_CLOSE.getName());
/* 401 */       IQueryResultList iQueryResultList = DataFactory.getObjectByQuery(OPEN_WKSTNS, params);
/*     */       
/* 403 */       if (iQueryResultList != null) {
/* 404 */         for (IWorkstation wkstn : iQueryResultList) {
/* 405 */           wkstn.setWorkstationState(WorkstationStateType.PENDING_CLOSE.getName());
/*     */         }
/*     */       }
/*     */       
/* 409 */       return (List<IWorkstation>)iQueryResultList;
/*     */     }
/* 411 */     catch (ObjectNotFoundException ex) {
/* 412 */       return new ArrayList<>();
/*     */     } 
/*     */   }
/*     */   
/*     */   public RetailLocationStateType getRetailLocationState() {
/* 417 */     return (getApplicableState()).storeState_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WorkstationStateType getWorkStationState(long argRetailLocationId, long workStationId) {
/* 424 */     IStateJournal stateJournal = this.stateJournalHelper_.lookupStateJournal(StateJournalType.WKSTN_STATE, argRetailLocationId, workStationId);
/*     */     
/* 426 */     if (stateJournal != null) {
/* 427 */       String state = stateJournal.getStringValue();
/* 428 */       (getApplicableState()).workstationState_ = WorkstationStateType.forName(state);
/*     */     } else {
/*     */       
/* 431 */       (getApplicableState()).workstationState_ = WorkstationStateType.CLOSED;
/*     */     } 
/* 433 */     return (getApplicableState()).workstationState_;
/*     */   }
/*     */   
/*     */   public boolean hasStoreEverBeenOpened(long argRetailLocationId) {
/* 437 */     Map<String, Object> params = new HashMap<>();
/* 438 */     params.put("argRetailLocationId", Long.valueOf(argRetailLocationId));
/*     */     
/* 440 */     IQueryResultList iQueryResultList = DataFactory.getObjectByQueryNoThrow(HAS_STORE_EVER_BEEN_OPENED, params);
/* 441 */     return !iQueryResultList.isEmpty();
/*     */   }
/*     */   
/*     */   public boolean isRetailLocationOpen() {
/*     */     try {
/* 446 */       boolean open = true;
/*     */       
/* 448 */       if (RetailLocationStateType.OPEN != (getApplicableState()).storeState_) {
/* 449 */         open = false;
/* 450 */         setRetailLocationOpenState(false);
/*     */       } 
/* 452 */       return open;
/*     */     }
/* 454 */     catch (Exception ex) {
/* 455 */       logger_.info("CAUGHT EXCEPTION", ex);
/* 456 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isWorkstationOpen(long argRetailLocationId, long argWorkstationId) {
/*     */     try {
/* 462 */       WorkstationStateType currentState = getWorkStationState(argRetailLocationId, argWorkstationId);
/* 463 */       boolean result = WorkstationStateType.OPEN.equals(currentState);
/*     */ 
/*     */ 
/*     */       
/* 467 */       if (!result) {
/* 468 */         this.events_.post(WORKSTATION_OPEN_CHANGE, currentState);
/*     */       }
/* 470 */       return result;
/*     */     }
/* 472 */     catch (Exception ex) {
/* 473 */       logger_.info("CAUGHT EXCEPTION", ex);
/* 474 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean openRetailLocation(long argRetailLocationId, long argWorkstationId) {
/* 480 */     IStateJournal stateJournal = this.stateJournalHelper_.lookupStateJournal(StateJournalType.RTL_LOC_STATE, argRetailLocationId, argWorkstationId);
/*     */ 
/*     */     
/* 483 */     RetailLocationStateType state = (stateJournal == null) ? RetailLocationStateType.CLOSED : RetailLocationStateType.forName(stateJournal.getStringValue());
/*     */     
/* 485 */     if (state == RetailLocationStateType.OPEN) {
/* 486 */       logger_.warn("location already " + RetailLocationStateType.OPEN.getName());
/* 487 */       return false;
/*     */     } 
/*     */     
/* 490 */     if (state == RetailLocationStateType.CLOSED) {
/*     */       
/* 492 */       IStateJournal persistStateJournal = this.stateJournalHelper_.createStateJournal(StateJournalType.RTL_LOC_STATE, argRetailLocationId, argWorkstationId);
/* 493 */       persistStateJournal.setStringValue(RetailLocationStateType.OPEN.getName());
/*     */       
/*     */       try {
/* 496 */         DataFactory.makePersistent(persistStateJournal);
/* 497 */         this.stateJournalHelper_.syncJournalLocally(persistStateJournal);
/*     */       }
/* 499 */       catch (PersistenceException ex) {
/* 500 */         logger_.error("Exception caught trying to persist retail location data when setting location to open.", (Throwable)ex);
/*     */ 
/*     */         
/* 503 */         throw new OpExecutionException(ex);
/*     */       } 
/*     */       
/* 506 */       if (logger_.isInfoEnabled()) {
/* 507 */         logger_.info("Retail Location: " + argRetailLocationId + " has been Opened and is now ready for workstations to open.");
/*     */       }
/*     */       
/* 510 */       setRetailLocationOpenState(true);
/*     */       
/* 512 */       return true;
/*     */     } 
/* 514 */     logger_.warn("unexpected location state " + state);
/* 515 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean openWorkstation(long argRetailLocatoinId, long argWorkstationId, Date argCurrentBusinessDate) {
/* 521 */     IStateJournal stateJournal = this.stateJournalHelper_.lookupStateJournal(StateJournalType.WKSTN_STATE, argRetailLocatoinId, argWorkstationId);
/*     */ 
/*     */     
/* 524 */     WorkstationStateType state = (stateJournal == null) ? WorkstationStateType.CLOSED : WorkstationStateType.forName(stateJournal.getStringValue());
/*     */     
/* 526 */     if (state == WorkstationStateType.OPEN) {
/* 527 */       logger_.warn("workstation is already " + WorkstationStateType.OPEN.getName());
/* 528 */       return false;
/*     */     } 
/*     */     
/* 531 */     if (state == WorkstationStateType.CLOSED) {
/*     */       
/* 533 */       IStateJournal persistStateJournal = this.stateJournalHelper_.createStateJournal(StateJournalType.WKSTN_STATE, argRetailLocatoinId, argWorkstationId);
/* 534 */       persistStateJournal.setStringValue(WorkstationStateType.OPEN.getName());
/* 535 */       persistStateJournal.setDateValue(argCurrentBusinessDate);
/*     */       
/*     */       try {
/* 538 */         DataFactory.makePersistent(persistStateJournal);
/* 539 */         this.stateJournalHelper_.syncJournalLocally(persistStateJournal);
/*     */       }
/* 541 */       catch (PersistenceException ex) {
/* 542 */         logger_.error("Exception caught trying to persist workstation data when setting workstation to open.", (Throwable)ex);
/*     */         
/* 544 */         throw new RuntimeException(ex);
/*     */       } 
/*     */       
/* 547 */       if (logger_.isInfoEnabled()) {
/* 548 */         logger_.info("Workstation: " + argWorkstationId + " has been Opened.");
/*     */       }
/* 550 */       setWorkstationOpenState(WorkstationStateType.OPEN);
/*     */ 
/*     */ 
/*     */       
/* 554 */       if (ConfigurationMgr.isRollingCloseEnabled() && 
/* 555 */         businessPeriodStarted(argRetailLocatoinId, argCurrentBusinessDate).isEmpty()) {
/* 556 */         beginBusinessPeriod(argRetailLocatoinId, argWorkstationId, argCurrentBusinessDate);
/*     */       }
/*     */       
/* 559 */       return true;
/*     */     } 
/* 561 */     logger_.warn("unexpected workstation state " + state);
/* 562 */     return false;
/*     */   }
/*     */   
/*     */   public void refreshStatusIndicators() {
/* 566 */     State currentState = getApplicableState();
/*     */     
/* 568 */     this.events_.post(WORKSTATION_OPEN_CHANGE, currentState.workstationState_);
/* 569 */     this.events_.post(RETAIL_LOCATION_OPEN_CHANGE, currentState.storeState_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate(long argRetailLocatoinId, long argWorkstationId, Date argCurrentBusinessDate) {
/* 574 */     IStateJournal stateJournal = this.stateJournalHelper_.lookupStateJournal(StateJournalType.BUSINESS_DATE, argRetailLocatoinId, argWorkstationId);
/*     */ 
/*     */ 
/*     */     
/* 578 */     Date businessDate = (stateJournal == null) ? null : stateJournal.getDateValue();
/* 579 */     if (businessDate != null && businessDate.equals(argCurrentBusinessDate)) {
/* 580 */       logger_.warn("business date has already been recorded for date " + 
/* 581 */           DateUtils.format(argCurrentBusinessDate));
/* 582 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 586 */     IStateJournal persistStateJournal = this.stateJournalHelper_.createStateJournal(StateJournalType.BUSINESS_DATE, argRetailLocatoinId, argWorkstationId);
/* 587 */     persistStateJournal.setDateValue(argCurrentBusinessDate);
/*     */     
/*     */     try {
/* 590 */       DataFactory.makePersistent(persistStateJournal);
/* 591 */       this.stateJournalHelper_.syncJournalLocally(persistStateJournal);
/*     */     }
/* 593 */     catch (PersistenceException ex) {
/* 594 */       logger_.error("Exception caught trying to persist workstation data when setting workstation to open.", (Throwable)ex);
/*     */       
/* 596 */       throw new RuntimeException(ex);
/*     */     } 
/*     */     
/* 599 */     if (logger_.isInfoEnabled()) {
/* 600 */       logger_.info("Business Date: " + 
/* 601 */           DateUtils.format(argCurrentBusinessDate) + " has been recorded to database.");
/*     */     }
/* 603 */     setWorkstationOpenState(WorkstationStateType.OPEN);
/*     */     
/* 605 */     return true;
/*     */   }
/*     */   
/*     */   public void setClosingMessage(String message, long argRetailLocationId) {
/* 609 */     ClosingMessageId id = new ClosingMessageId();
/* 610 */     id.setRetailLocationId(Long.valueOf(argRetailLocationId));
/*     */     
/* 612 */     IClosingMessage tempMessage = null;
/*     */     try {
/* 614 */       tempMessage = (IClosingMessage)DataFactory.getObjectById((IObjectId)id);
/*     */     }
/* 616 */     catch (ObjectNotFoundException ex) {
/* 617 */       tempMessage = (IClosingMessage)DataFactory.createObject((IObjectId)id, IClosingMessage.class);
/*     */     } 
/* 619 */     tempMessage.setClosingMessage(message);
/*     */ 
/*     */     
/*     */     try {
/* 623 */       DataFactory.makePersistent(tempMessage);
/*     */     }
/* 625 */     catch (PersistenceException ex) {
/* 626 */       logger_.error("Exception caught trying to persist closing message data.", (Throwable)ex);
/* 627 */       throw new OpExecutionException(ex);
/*     */     } 
/*     */     
/* 630 */     logger_.info("Processing Closing messages (Set Msg)");
/*     */   }
/*     */   
/*     */   public void setRetailLocationOpenState(boolean argOpen) {
/* 634 */     RetailLocationStateType newStoreState = argOpen ? RetailLocationStateType.OPEN : RetailLocationStateType.CLOSED;
/*     */     
/* 636 */     (getApplicableState()).storeState_ = newStoreState;
/* 637 */     this.events_.post(RETAIL_LOCATION_OPEN_CHANGE, argOpen ? RetailLocationStateType.OPEN : RetailLocationStateType.CLOSED);
/*     */   }
/*     */   
/*     */   public void setWorkstationOpenState(WorkstationStateType argState) {
/* 641 */     (getApplicableState()).workstationState_ = argState;
/* 642 */     this.events_.post(WORKSTATION_OPEN_CHANGE, argState);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean startRemoteCloseWorkstation(long argRetailLocationId, long argWorkstationId) {
/* 647 */     IStateJournal stateJournal = this.stateJournalHelper_.lookupStateJournal(StateJournalType.WKSTN_STATE, argRetailLocationId, argWorkstationId);
/*     */     
/* 649 */     WorkstationStateType state = (stateJournal == null) ? WorkstationStateType.CLOSED : WorkstationStateType.forName(stateJournal.getStringValue());
/*     */     
/* 651 */     if (state == WorkstationStateType.CLOSED) {
/* 652 */       logger_.warn("workstation already " + WorkstationStateType.CLOSED.getName());
/* 653 */       return false;
/*     */     } 
/*     */     
/* 656 */     if (state == WorkstationStateType.PENDING_CLOSE) {
/* 657 */       logger_.warn("workstation already " + WorkstationStateType.PENDING_CLOSE.getName());
/* 658 */       return false;
/*     */     } 
/*     */     
/* 661 */     if (state == WorkstationStateType.OPEN) {
/*     */       
/* 663 */       IStateJournal persistStateJournal = this.stateJournalHelper_.createStateJournal(StateJournalType.WKSTN_STATE, argRetailLocationId, argWorkstationId);
/* 664 */       persistStateJournal.setStringValue(WorkstationStateType.PENDING_CLOSE.getName());
/*     */       
/*     */       try {
/* 667 */         DataFactory.makePersistent(persistStateJournal);
/* 668 */         this.stateJournalHelper_.syncJournalLocally(persistStateJournal);
/*     */       }
/* 670 */       catch (PersistenceException ex) {
/* 671 */         logger_.error("Exception caught trying to persist workstation data when setting workstation to closed.", (Throwable)ex);
/*     */ 
/*     */         
/* 674 */         throw new RuntimeException(ex);
/*     */       } 
/*     */       
/* 677 */       if (logger_.isInfoEnabled()) {
/* 678 */         logger_.info("workstation " + argWorkstationId + " has been Closed and is now ready for workstations to close");
/*     */       }
/*     */ 
/*     */       
/* 682 */       setWorkstationOpenState(WorkstationStateType.PENDING_CLOSE);
/* 683 */       return true;
/*     */     } 
/*     */     
/* 686 */     logger_.warn("unexpected station state");
/* 687 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected State getApplicableState() {
/* 695 */     return this.states_.get(Boolean.valueOf(this._trainingModeHelper.isTrainingMode()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ITrainingModeHelper getTrainingModeHelper() {
/* 702 */     return this._trainingModeHelper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setTrainingModeHelper(ITrainingModeHelper argTrainingModeHelper) {
/* 709 */     this._trainingModeHelper = argTrainingModeHelper;
/*     */   }
/*     */   
/*     */   protected static class State
/*     */   {
/* 714 */     protected RetailLocationStateType storeState_ = RetailLocationStateType.CLOSED;
/* 715 */     protected WorkstationStateType workstationState_ = WorkstationStateType.CLOSED;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\systemcycle\SystemCycleHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */