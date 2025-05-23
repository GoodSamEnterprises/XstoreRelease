/*     */ package dtv.xst.dao.sch.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sch.EmployeeTimeOffId;
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
/*     */ public class EmployeeTimeOffDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1854604108L;
/*     */   private Long _organizationId;
/*     */   private String _employeeId;
/*     */   private Long _timeOffSeq;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _startTime;
/*     */   private Date _endTime;
/*     */   private String _reasonCode;
/*     */   private String _typeCode;
/*     */   private Boolean _void;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.employee_id, t.time_off_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.start_datetime, t.end_datetime, t.reason_code, t.time_off_typcode, t.void_flag FROM sch_emp_time_off t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  AND time_off_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.employee_id, t.time_off_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.start_datetime, t.end_datetime, t.reason_code, t.time_off_typcode, t.void_flag FROM sch_emp_time_off t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND employee_id = ?  AND time_off_seq = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO sch_emp_time_off(organization_id, employee_id, time_off_seq, create_date, create_user_id, update_date, update_user_id, start_datetime, end_datetime, reason_code, time_off_typcode, void_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._employeeId, this._timeOffSeq, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._startTime, this._endTime, this._reasonCode, this._typeCode, this._void } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, -5, 91, 12, 91, 12, 91, 91, 12, 12, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE sch_emp_time_off SET update_date = ?, update_user_id = ?, start_datetime = ?, end_datetime = ?, reason_code = ?, time_off_typcode = ?, void_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._startTime, this._endTime, this._reasonCode, this._typeCode, this._void } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 91, 12, 12, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM sch_emp_time_off" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  AND time_off_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND employee_id = ?  AND time_off_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._employeeId, this._timeOffSeq };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "sch_emp_time_off";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new EmployeeTimeOffFiller(this);
/*     */   }
/*     */   
/*     */   private static class EmployeeTimeOffFiller
/*     */     implements IFiller {
/*     */     private EmployeeTimeOffDBA _parent;
/*     */     
/*     */     public EmployeeTimeOffFiller(EmployeeTimeOffDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long primitiveResult = argResultSet.getLong(1);
/* 130 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 135 */       this._parent._employeeId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 138 */       primitiveResult = argResultSet.getLong(3);
/* 139 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 140 */         this._parent._timeOffSeq = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 145 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 146 */       if (t4 != null) {
/* 147 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 155 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 156 */       if (t6 != null) {
/* 157 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._updateUserId = argResultSet.getString(7);
/*     */       
/* 165 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 166 */       if (t8 != null) {
/* 167 */         this._parent._startTime = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._startTime = null;
/*     */       } 
/*     */ 
/*     */       
/* 174 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 175 */       if (t9 != null) {
/* 176 */         this._parent._endTime = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 179 */         this._parent._endTime = null;
/*     */       } 
/*     */       
/* 182 */       this._parent._reasonCode = argResultSet.getString(10);
/* 183 */       this._parent._typeCode = argResultSet.getString(11);
/* 184 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(12));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 189 */     argDAO.suppressStateChanges(true);
/* 190 */     EmployeeTimeOffDAO dao = (EmployeeTimeOffDAO)argDAO;
/* 191 */     dao.setOrganizationId(this._organizationId);
/* 192 */     dao.setEmployeeId(this._employeeId);
/* 193 */     dao.setTimeOffSeq(this._timeOffSeq);
/* 194 */     dao.setCreateDate(this._createDate);
/* 195 */     dao.setCreateUserId(this._createUserId);
/* 196 */     dao.setUpdateDate(this._updateDate);
/* 197 */     dao.setUpdateUserId(this._updateUserId);
/* 198 */     dao.setStartTime(this._startTime);
/* 199 */     dao.setEndTime(this._endTime);
/* 200 */     dao.setReasonCode(this._reasonCode);
/* 201 */     dao.setTypeCode(this._typeCode);
/* 202 */     dao.setVoid(this._void);
/* 203 */     argDAO.suppressStateChanges(false);
/* 204 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 208 */     return loadDAO((IDataAccessObject)new EmployeeTimeOffDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 212 */     EmployeeTimeOffDAO dao = (EmployeeTimeOffDAO)argDAO;
/* 213 */     this._organizationId = dao.getOrganizationId();
/* 214 */     this._employeeId = dao.getEmployeeId();
/* 215 */     this._timeOffSeq = dao.getTimeOffSeq();
/* 216 */     this._createDate = dao.getCreateDate();
/* 217 */     this._createUserId = dao.getCreateUserId();
/* 218 */     this._updateDate = dao.getUpdateDate();
/* 219 */     this._updateUserId = dao.getUpdateUserId();
/* 220 */     this._startTime = dao.getStartTime();
/* 221 */     this._endTime = dao.getEndTime();
/* 222 */     this._reasonCode = dao.getReasonCode();
/* 223 */     this._typeCode = dao.getTypeCode();
/* 224 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 228 */     EmployeeTimeOffId id = (EmployeeTimeOffId)argId;
/* 229 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 230 */     argStatement.setString(2, id.getEmployeeId());
/* 231 */     argStatement.setLong(3, id.getTimeOffSeq().longValue());
/* 232 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 236 */     EmployeeTimeOffId id = new EmployeeTimeOffId();
/* 237 */     id.setOrganizationId(this._organizationId);
/* 238 */     id.setEmployeeId(this._employeeId);
/* 239 */     id.setTimeOffSeq(this._timeOffSeq);
/* 240 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 248 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 252 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sch\impl\EmployeeTimeOffDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */