/*     */ package dtv.pos.framework.systemcycle;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.util.sequence.SequenceFactory;
/*     */ import dtv.xst.dao.loc.IStateJournal;
/*     */ import dtv.xst.dao.loc.StateJournalId;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StateJournalHelper
/*     */ {
/*  26 */   private static final Logger logger_ = Logger.getLogger(StateJournalHelper.class);
/*     */   private static final String SEQ_TYPE_STATE_JOURNAL = "STATE_JOURNAL";
/*  28 */   private static final IQueryKey<IStateJournal> RETRIEVE_STATE_VALUES = (IQueryKey<IStateJournal>)new QueryKey("RETRIEVE_STATE_VALUES", IStateJournal.class);
/*     */   
/*  30 */   private static final IQueryKey<IStateJournal> RETRIEVE_STATE_VALUES_LOCAL = (IQueryKey<IStateJournal>)new QueryKey("RETRIEVE_STATE_VALUES_LOCAL", IStateJournal.class);
/*     */   
/*  32 */   private static final IQueryKey<IStateJournal> RETRIEVE_STATE_VALUES_WKSTN_SPECIFIC = (IQueryKey<IStateJournal>)new QueryKey("RETRIEVE_STATE_VALUES_WKSTN_SPECIFIC", IStateJournal.class);
/*     */   
/*  34 */   private static final IQueryKey<IStateJournal> RETRIEVE_STATE_VALUES_WKSTN_SPECIFIC_LOCAL = (IQueryKey<IStateJournal>)new QueryKey("RETRIEVE_STATE_VALUES_WKSTN_SPECIFIC_LOCAL", IStateJournal.class);
/*     */   
/*  36 */   private static final IQueryKey<IStateJournal> LOOKUP_JOURNAL_LOCALLY = (IQueryKey<IStateJournal>)new QueryKey("LOOKUP_JOURNAL_LOCALLY", IStateJournal.class);
/*     */   
/*  38 */   private static final IQueryKey<Object[]> SYNC_JOURNAL_LOCALLY = (IQueryKey<Object[]>)new QueryKey("SYNC_JOURNAL_LOCALLY", Object[].class);
/*     */ 
/*     */ 
/*     */   
/*     */   public IStateJournal createStateJournal(StateJournalType argStateJournalType, long argRetailLocationId, long argWorkstationId) {
/*  43 */     StateJournalId id = new StateJournalId();
/*  44 */     id.setOrganizationId(Long.valueOf(ConfigurationMgr.getOrganizationId()));
/*  45 */     id.setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  46 */     id.setWorkstationId(Long.valueOf(argWorkstationId));
/*  47 */     id.setStatusTypcode(argStateJournalType.getName());
/*     */     
/*     */     try {
/*  50 */       id.setStateJournalId(SequenceFactory.getNextStringValue("STATE_JOURNAL", new Object[0]));
/*     */     }
/*  52 */     catch (Exception ex) {
/*  53 */       logger_.error("Could not retrieve next sequence number.", ex);
/*     */     } 
/*     */     
/*  56 */     IStateJournal stateJournal = (IStateJournal)DataFactory.createObject((IObjectId)id, IStateJournal.class);
/*  57 */     stateJournal.setTimeStamp(new Date());
/*     */     
/*  59 */     return stateJournal;
/*     */   }
/*     */ 
/*     */   
/*     */   public IStateJournal lookupStateJournal(StateJournalType argStateJournalType, long argRetailLocationId, long argWorkstationId) {
/*  64 */     return lookupStateJournal(argStateJournalType, argRetailLocationId, argWorkstationId, false);
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
/*     */   public IStateJournal lookupStateJournal(StateJournalType argStateJournalType, long argRetailLocationId, long argWorkstationId, boolean argLocalOnly) {
/*  78 */     IStateJournal primaryStateJournal = null;
/*  79 */     IStateJournal localStateJournal = null;
/*     */     
/*  81 */     Map<String, Object> params = new HashMap<>();
/*  82 */     params.put("argRetailLocationId", Long.valueOf(argRetailLocationId));
/*  83 */     params.put("argStatusTypcode", argStateJournalType.getName());
/*     */     
/*  85 */     boolean isWorkstation = StateJournalType.WKSTN_STATE.equals(argStateJournalType);
/*     */     
/*  87 */     if (isWorkstation) {
/*  88 */       params.put("argWorkstationId", Long.valueOf(argWorkstationId));
/*     */     }
/*     */     
/*     */     try {
/*  92 */       IQueryKey<IStateJournal> queryToRun = isWorkstation ? RETRIEVE_STATE_VALUES_WKSTN_SPECIFIC : RETRIEVE_STATE_VALUES;
/*     */ 
/*     */ 
/*     */       
/*  96 */       IQueryResultList<IStateJournal> iQueryResultList = DataFactory.getObjectByQuery(queryToRun, params);
/*  97 */       primaryStateJournal = iQueryResultList.get(0);
/*     */     }
/*  99 */     catch (ObjectNotFoundException ex) {
/* 100 */       logger_.debug("Could not find State Journal information in primary data source.");
/*     */     }
/* 102 */     catch (Exception ex) {
/* 103 */       logger_.error("Error retrieving State Journal information in primary data source.", ex);
/*     */     } 
/*     */     
/*     */     try {
/* 107 */       IQueryKey<IStateJournal> queryToRun = isWorkstation ? RETRIEVE_STATE_VALUES_WKSTN_SPECIFIC_LOCAL : RETRIEVE_STATE_VALUES_LOCAL;
/*     */ 
/*     */ 
/*     */       
/* 111 */       IQueryResultList<IStateJournal> iQueryResultList = DataFactory.getObjectByQuery(queryToRun, params);
/* 112 */       localStateJournal = iQueryResultList.get(0);
/*     */     }
/* 114 */     catch (ObjectNotFoundException ex) {
/* 115 */       logger_.debug("Could not find State Journal information in local data source.");
/*     */     }
/* 117 */     catch (Exception ex) {
/* 118 */       logger_.error("Error retrieving State Journal information in local data source.", ex);
/*     */     } 
/* 120 */     if (argLocalOnly)
/*     */     {
/* 122 */       return localStateJournal;
/*     */     }
/* 124 */     if (localStateJournal != null && (primaryStateJournal == null || primaryStateJournal
/* 125 */       .getTimeStamp().before(localStateJournal.getTimeStamp())))
/*     */     {
/* 127 */       return localStateJournal;
/*     */     }
/*     */ 
/*     */     
/* 131 */     return primaryStateJournal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void syncJournalLocally(IStateJournal argStateJournal) {
/* 141 */     if (doesRowAlreadyExists(argStateJournal)) {
/*     */       return;
/*     */     }
/*     */     
/* 145 */     Map<String, Object> params = new HashMap<>();
/* 146 */     params.put("argRetailLocationId", Long.valueOf(argStateJournal.getRetailLocationId()));
/* 147 */     params.put("argWorkstationId", Long.valueOf(argStateJournal.getWorkstationId()));
/* 148 */     params.put("argStatusTypcode", argStateJournal.getStatusTypcode());
/* 149 */     params.put("argTimestamp", argStateJournal.getTimeStamp());
/* 150 */     params.put("argStringValue", argStateJournal.getStringValue());
/* 151 */     params.put("argStateJournalId", argStateJournal.getStateJournalId());
/* 152 */     params.put("argDateValue", argStateJournal.getDateValue());
/*     */     
/*     */     try {
/* 155 */       DataFactory.getObjectByQuery(SYNC_JOURNAL_LOCALLY, params);
/*     */     }
/* 157 */     catch (Exception ex) {
/* 158 */       logger_.error("Unable to synchronize state entry locally.", ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean doesRowAlreadyExists(IStateJournal argStateJournal) {
/* 163 */     Map<String, Object> params = new HashMap<>();
/* 164 */     params.put("argRetailLocationId", Long.valueOf(argStateJournal.getRetailLocationId()));
/* 165 */     params.put("argWorkstationId", Long.valueOf(argStateJournal.getWorkstationId()));
/* 166 */     params.put("argStatusTypcode", argStateJournal.getStatusTypcode());
/* 167 */     params.put("argStateJournalId", argStateJournal.getStateJournalId());
/*     */     
/*     */     try {
/* 170 */       DataFactory.getObjectByQuery(LOOKUP_JOURNAL_LOCALLY, params);
/* 171 */       return true;
/*     */     }
/* 173 */     catch (ObjectNotFoundException ex) {
/* 174 */       logger_.debug("CAUGHT EXCEPTION", (Throwable)ex);
/*     */     }
/* 176 */     catch (Exception ex) {
/* 177 */       logger_.error("Unable to check local data source.", ex);
/*     */     } 
/* 179 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\systemcycle\StateJournalHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */