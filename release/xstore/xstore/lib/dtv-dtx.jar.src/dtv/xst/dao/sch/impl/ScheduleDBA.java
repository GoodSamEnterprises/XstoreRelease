/*     */ package dtv.xst.dao.sch.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sch.ScheduleId;
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
/*     */ public class ScheduleDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -633276745L;
/*     */   private Long _organizationId;
/*     */   private String _employeeId;
/*     */   private Date _businessDate;
/*     */   private Long _scheduleSeq;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _startTime;
/*     */   private Date _endTime;
/*     */   private Boolean _void;
/*     */   private String _workCodeString;
/*     */   private Long _scheduleDuration;
/*     */   private Long _breakDuration;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.employee_id, t.business_date, t.schedule_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.start_time, t.end_time, t.void_flag, t.work_code, t.schedule_duration, t.break_duration FROM sch_schedule t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  AND business_date = ?  AND schedule_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.employee_id, t.business_date, t.schedule_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.start_time, t.end_time, t.void_flag, t.work_code, t.schedule_duration, t.break_duration FROM sch_schedule t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND employee_id = ?  AND business_date = ?  AND schedule_seq = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO sch_schedule(organization_id, employee_id, business_date, schedule_seq, create_date, create_user_id, update_date, update_user_id, start_time, end_time, void_flag, work_code, schedule_duration, break_duration) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._employeeId, this._businessDate, this._scheduleSeq, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._startTime, this._endTime, this._void, this._workCodeString, this._scheduleDuration, this._breakDuration } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, -5, 91, 12, 91, 12, 91, 91, -7, 12, -5, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE sch_schedule SET update_date = ?, update_user_id = ?, start_time = ?, end_time = ?, void_flag = ?, work_code = ?, schedule_duration = ?, break_duration = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._startTime, this._endTime, this._void, this._workCodeString, this._scheduleDuration, this._breakDuration } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 91, -7, 12, -5, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM sch_schedule" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  AND business_date = ?  AND schedule_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND employee_id = ?  AND business_date = ?  AND schedule_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._employeeId, this._businessDate, this._scheduleSeq };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 91, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "sch_schedule";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new ScheduleFiller(this);
/*     */   }
/*     */   
/*     */   private static class ScheduleFiller
/*     */     implements IFiller {
/*     */     private ScheduleDBA _parent;
/*     */     
/*     */     public ScheduleFiller(ScheduleDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long primitiveResult = argResultSet.getLong(1);
/* 132 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 137 */       this._parent._employeeId = argResultSet.getString(2);
/*     */       
/* 139 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 140 */       if (t3 != null) {
/* 141 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 149 */       long l1 = argResultSet.getLong(4);
/* 150 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 151 */         this._parent._scheduleSeq = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 156 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 157 */       if (t5 != null) {
/* 158 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 161 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 164 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 166 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 167 */       if (t7 != null) {
/* 168 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 171 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 174 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */       
/* 176 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 177 */       if (t9 != null) {
/* 178 */         this._parent._startTime = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._startTime = null;
/*     */       } 
/*     */ 
/*     */       
/* 185 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 186 */       if (t10 != null) {
/* 187 */         this._parent._endTime = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 190 */         this._parent._endTime = null;
/*     */       } 
/*     */       
/* 193 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(11));
/* 194 */       this._parent._workCodeString = argResultSet.getString(12);
/*     */ 
/*     */       
/* 197 */       long l2 = argResultSet.getLong(13);
/* 198 */       if (l2 != 0L || argResultSet.getObject(13) != null) {
/* 199 */         this._parent._scheduleDuration = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 205 */       l2 = argResultSet.getLong(14);
/* 206 */       if (l2 != 0L || argResultSet.getObject(14) != null) {
/* 207 */         this._parent._breakDuration = Long.valueOf(l2);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 215 */     argDAO.suppressStateChanges(true);
/* 216 */     ScheduleDAO dao = (ScheduleDAO)argDAO;
/* 217 */     dao.setOrganizationId(this._organizationId);
/* 218 */     dao.setEmployeeId(this._employeeId);
/* 219 */     dao.setBusinessDate(this._businessDate);
/* 220 */     dao.setScheduleSeq(this._scheduleSeq);
/* 221 */     dao.setCreateDate(this._createDate);
/* 222 */     dao.setCreateUserId(this._createUserId);
/* 223 */     dao.setUpdateDate(this._updateDate);
/* 224 */     dao.setUpdateUserId(this._updateUserId);
/* 225 */     dao.setStartTime(this._startTime);
/* 226 */     dao.setEndTime(this._endTime);
/* 227 */     dao.setVoid(this._void);
/* 228 */     dao.setWorkCodeString(this._workCodeString);
/* 229 */     dao.setScheduleDuration(this._scheduleDuration);
/* 230 */     dao.setBreakDuration(this._breakDuration);
/* 231 */     argDAO.suppressStateChanges(false);
/* 232 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 236 */     return loadDAO((IDataAccessObject)new ScheduleDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 240 */     ScheduleDAO dao = (ScheduleDAO)argDAO;
/* 241 */     this._organizationId = dao.getOrganizationId();
/* 242 */     this._employeeId = dao.getEmployeeId();
/* 243 */     this._businessDate = dao.getBusinessDate();
/* 244 */     this._scheduleSeq = dao.getScheduleSeq();
/* 245 */     this._createDate = dao.getCreateDate();
/* 246 */     this._createUserId = dao.getCreateUserId();
/* 247 */     this._updateDate = dao.getUpdateDate();
/* 248 */     this._updateUserId = dao.getUpdateUserId();
/* 249 */     this._startTime = dao.getStartTime();
/* 250 */     this._endTime = dao.getEndTime();
/* 251 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/* 252 */     this._workCodeString = dao.getWorkCodeString();
/* 253 */     this._scheduleDuration = dao.getScheduleDuration();
/* 254 */     this._breakDuration = dao.getBreakDuration();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 258 */     ScheduleId id = (ScheduleId)argId;
/* 259 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 260 */     argStatement.setString(2, id.getEmployeeId());
/* 261 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 262 */     argStatement.setLong(4, id.getScheduleSeq().longValue());
/* 263 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 267 */     ScheduleId id = new ScheduleId();
/* 268 */     id.setOrganizationId(this._organizationId);
/* 269 */     id.setEmployeeId(this._employeeId);
/* 270 */     id.setBusinessDate(this._businessDate);
/* 271 */     id.setScheduleSeq(this._scheduleSeq);
/* 272 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 280 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 284 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sch\impl\ScheduleDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */