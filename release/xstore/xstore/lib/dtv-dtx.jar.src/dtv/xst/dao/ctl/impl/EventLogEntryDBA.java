/*     */ package dtv.xst.dao.ctl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ctl.EventLogEntryId;
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
/*     */ 
/*     */ 
/*     */ public class EventLogEntryDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 879668264L;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _businessDate;
/*     */   private Long _operatorPartyId;
/*     */   private String _logLevel;
/*     */   private Date _logTimestamp;
/*     */   private String _source;
/*     */   private String _threadName;
/*     */   private Boolean _criticalToDeliver;
/*     */   private String _loggerCategory;
/*     */   private String _logMessage;
/*     */   private Date _arrivalTimestamp;
/*     */   private static final String SELECT_OBJECT = "SELECT t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.operator_party_id, t.log_level, t.log_timestamp, t.source, t.thread_name, t.critical_to_deliver, t.logger_category, t.log_message, t.arrival_timestamp FROM ctl_event_log t";
/*     */   private static final String SELECT_WHERE_OBJECT = " ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.operator_party_id, t.log_level, t.log_timestamp, t.source, t.thread_name, t.critical_to_deliver, t.logger_category, t.log_message, t.arrival_timestamp FROM ctl_event_log t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ctl_event_log(create_date, create_user_id, update_date, update_user_id, organization_id, rtl_loc_id, wkstn_id, business_date, operator_party_id, log_level, log_timestamp, source, thread_name, critical_to_deliver, logger_category, log_message, arrival_timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._operatorPartyId, this._logLevel, this._logTimestamp, this._source, this._threadName, this._criticalToDeliver, this._loggerCategory, this._logMessage, this._arrivalTimestamp } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, 12, 91, 12, -5, -5, -5, 91, -5, 12, 91, 12, 12, -7, 12, 12, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ctl_event_log SET update_date = ?, update_user_id = ?, organization_id = ?, rtl_loc_id = ?, wkstn_id = ?, business_date = ?, operator_party_id = ?, log_level = ?, log_timestamp = ?, source = ?, thread_name = ?, critical_to_deliver = ?, logger_category = ?, log_message = ?, arrival_timestamp = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._operatorPartyId, this._logLevel, this._logTimestamp, this._source, this._threadName, this._criticalToDeliver, this._loggerCategory, this._logMessage, this._arrivalTimestamp } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -5, -5, -5, 91, -5, 12, 91, 12, 12, -7, 12, 12, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ctl_event_log" }; private static final String WHERE_OBJECT = " ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[0];
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[0];
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "ctl_event_log";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new EventLogEntryFiller(this);
/*     */   }
/*     */   
/*     */   private static class EventLogEntryFiller
/*     */     implements IFiller {
/*     */     private EventLogEntryDBA _parent;
/*     */     
/*     */     public EventLogEntryFiller(EventLogEntryDBA argParent) {
/* 129 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 133 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 134 */       if (t1 != null) {
/* 135 */         this._parent._createDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 138 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 141 */       this._parent._createUserId = argResultSet.getString(2);
/*     */       
/* 143 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 144 */       if (t3 != null) {
/* 145 */         this._parent._updateDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 148 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 151 */       this._parent._updateUserId = argResultSet.getString(4);
/*     */ 
/*     */       
/* 154 */       long primitiveResult = argResultSet.getLong(5);
/* 155 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 156 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 162 */       primitiveResult = argResultSet.getLong(6);
/* 163 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 164 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 170 */       primitiveResult = argResultSet.getLong(7);
/* 171 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 172 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 177 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 178 */       if (t8 != null) {
/* 179 */         this._parent._businessDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 182 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 187 */       long l1 = argResultSet.getLong(9);
/* 188 */       if (l1 != 0L || argResultSet.getObject(9) != null) {
/* 189 */         this._parent._operatorPartyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 193 */       this._parent._logLevel = argResultSet.getString(10);
/*     */       
/* 195 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 196 */       if (t11 != null) {
/* 197 */         this._parent._logTimestamp = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 200 */         this._parent._logTimestamp = null;
/*     */       } 
/*     */       
/* 203 */       this._parent._source = argResultSet.getString(12);
/* 204 */       this._parent._threadName = argResultSet.getString(13);
/* 205 */       this._parent._criticalToDeliver = Boolean.valueOf(argResultSet.getBoolean(14));
/* 206 */       this._parent._loggerCategory = argResultSet.getString(15);
/* 207 */       this._parent._logMessage = argResultSet.getString(16);
/*     */       
/* 209 */       Timestamp t17 = argResultSet.getTimestamp(17);
/* 210 */       if (t17 != null) {
/* 211 */         this._parent._arrivalTimestamp = (Date)new DtvDate(t17.getTime());
/*     */       } else {
/*     */         
/* 214 */         this._parent._arrivalTimestamp = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 221 */     argDAO.suppressStateChanges(true);
/* 222 */     EventLogEntryDAO dao = (EventLogEntryDAO)argDAO;
/* 223 */     dao.setCreateDate(this._createDate);
/* 224 */     dao.setCreateUserId(this._createUserId);
/* 225 */     dao.setUpdateDate(this._updateDate);
/* 226 */     dao.setUpdateUserId(this._updateUserId);
/* 227 */     dao.setOrganizationId(this._organizationId);
/* 228 */     dao.setRetailLocationId(this._retailLocationId);
/* 229 */     dao.setWorkstationId(this._workstationId);
/* 230 */     dao.setBusinessDate(this._businessDate);
/* 231 */     dao.setOperatorPartyId(this._operatorPartyId);
/* 232 */     dao.setLogLevel(this._logLevel);
/* 233 */     dao.setLogTimestamp(this._logTimestamp);
/* 234 */     dao.setSource(this._source);
/* 235 */     dao.setThreadName(this._threadName);
/* 236 */     dao.setCriticalToDeliver(this._criticalToDeliver);
/* 237 */     dao.setLoggerCategory(this._loggerCategory);
/* 238 */     dao.setLogMessage(this._logMessage);
/* 239 */     dao.setArrivalTimestamp(this._arrivalTimestamp);
/* 240 */     argDAO.suppressStateChanges(false);
/* 241 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 245 */     return loadDAO((IDataAccessObject)new EventLogEntryDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 249 */     EventLogEntryDAO dao = (EventLogEntryDAO)argDAO;
/* 250 */     this._createDate = dao.getCreateDate();
/* 251 */     this._createUserId = dao.getCreateUserId();
/* 252 */     this._updateDate = dao.getUpdateDate();
/* 253 */     this._updateUserId = dao.getUpdateUserId();
/* 254 */     this._organizationId = dao.getOrganizationId();
/* 255 */     this._retailLocationId = dao.getRetailLocationId();
/* 256 */     this._workstationId = dao.getWorkstationId();
/* 257 */     this._businessDate = dao.getBusinessDate();
/* 258 */     this._operatorPartyId = dao.getOperatorPartyId();
/* 259 */     this._logLevel = dao.getLogLevel();
/* 260 */     this._logTimestamp = dao.getLogTimestamp();
/* 261 */     this._source = dao.getSource();
/* 262 */     this._threadName = dao.getThreadName();
/* 263 */     this._criticalToDeliver = (dao.getCriticalToDeliver() != null) ? dao.getCriticalToDeliver() : Boolean.valueOf(false);
/* 264 */     this._loggerCategory = dao.getLoggerCategory();
/* 265 */     this._logMessage = dao.getLogMessage();
/* 266 */     this._arrivalTimestamp = dao.getArrivalTimestamp();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) {
/* 270 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 274 */     EventLogEntryId id = new EventLogEntryId();
/* 275 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 283 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 287 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\EventLogEntryDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */