/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.EmployeeTaskId;
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
/*     */ public class EmployeeTaskDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1564025485L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _taskId;
/*     */   private Date _startDate;
/*     */   private Date _endDate;
/*     */   private Date _completeDate;
/*     */   private String _typeCode;
/*     */   private String _visibility;
/*     */   private String _assignmentId;
/*     */   private Boolean _storeCreated;
/*     */   private String _title;
/*     */   private String _description;
/*     */   private String _priority;
/*     */   private String _statusCode;
/*     */   private Boolean _void;
/*     */   private Long _partyId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.task_id, t.start_date, t.end_date, t.complete_date, t.typcode, t.visibility, t.assignment_id, t.store_created_flag, t.title, t.description, t.priority, t.status_code, t.void_flag, t.party_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM hrs_employee_task t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  49 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  53 */     return "SELECT t.organization_id, t.rtl_loc_id, t.task_id, t.start_date, t.end_date, t.complete_date, t.typcode, t.visibility, t.assignment_id, t.store_created_flag, t.title, t.description, t.priority, t.status_code, t.void_flag, t.party_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM hrs_employee_task t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  59 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  ";
/*     */   }
/*     */   
/*  62 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO hrs_employee_task(organization_id, rtl_loc_id, task_id, start_date, end_date, complete_date, typcode, visibility, assignment_id, store_created_flag, title, description, priority, status_code, void_flag, party_id, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  65 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  69 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._taskId, this._startDate, this._endDate, this._completeDate, this._typeCode, this._visibility, this._assignmentId, this._storeCreated, this._title, this._description, this._priority, this._statusCode, this._void, this._partyId, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  70 */     return insertParameterObject;
/*     */   }
/*     */   
/*  73 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, 91, 91, 12, 12, 12, -7, 12, 12, 12, 12, -7, -5, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  76 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  79 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE hrs_employee_task SET start_date = ?, end_date = ?, complete_date = ?, typcode = ?, visibility = ?, assignment_id = ?, store_created_flag = ?, title = ?, description = ?, priority = ?, status_code = ?, void_flag = ?, party_id = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  82 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  86 */     Object[][] updateParameterObject = { { this._startDate, this._endDate, this._completeDate, this._typeCode, this._visibility, this._assignmentId, this._storeCreated, this._title, this._description, this._priority, this._statusCode, this._void, this._partyId, this._updateDate, this._updateUserId } };
/*  87 */     return updateParameterObject;
/*     */   }
/*     */   
/*  90 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 91, 91, 12, 12, 12, -7, 12, 12, 12, 12, -7, -5, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  92 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  95 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM hrs_employee_task" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  98 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 104 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND task_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 107 */     return new Object[] { this._organizationId, this._retailLocationId, this._taskId };
/*     */   }
/*     */   
/* 110 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 113 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 116 */     return "hrs_employee_task";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 120 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 124 */     return new EmployeeTaskFiller(this);
/*     */   }
/*     */   
/*     */   private static class EmployeeTaskFiller
/*     */     implements IFiller {
/*     */     private EmployeeTaskDBA _parent;
/*     */     
/*     */     public EmployeeTaskFiller(EmployeeTaskDBA argParent) {
/* 132 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 137 */       long primitiveResult = argResultSet.getLong(1);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 139 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 145 */       primitiveResult = argResultSet.getLong(2);
/* 146 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 147 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 153 */       primitiveResult = argResultSet.getLong(3);
/* 154 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 155 */         this._parent._taskId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 160 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 161 */       if (t4 != null) {
/* 162 */         this._parent._startDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 165 */         this._parent._startDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 169 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 170 */       if (t5 != null) {
/* 171 */         this._parent._endDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 174 */         this._parent._endDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 178 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 179 */       if (t6 != null) {
/* 180 */         this._parent._completeDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 183 */         this._parent._completeDate = null;
/*     */       } 
/*     */       
/* 186 */       this._parent._typeCode = argResultSet.getString(7);
/* 187 */       this._parent._visibility = argResultSet.getString(8);
/* 188 */       this._parent._assignmentId = argResultSet.getString(9);
/* 189 */       this._parent._storeCreated = Boolean.valueOf(argResultSet.getBoolean(10));
/* 190 */       this._parent._title = argResultSet.getString(11);
/* 191 */       this._parent._description = argResultSet.getString(12);
/* 192 */       this._parent._priority = argResultSet.getString(13);
/* 193 */       this._parent._statusCode = argResultSet.getString(14);
/* 194 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(15));
/*     */ 
/*     */       
/* 197 */       long l1 = argResultSet.getLong(16);
/* 198 */       if (l1 != 0L || argResultSet.getObject(16) != null) {
/* 199 */         this._parent._partyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 204 */       Timestamp t17 = argResultSet.getTimestamp(17);
/* 205 */       if (t17 != null) {
/* 206 */         this._parent._createDate = (Date)new DtvDate(t17.getTime());
/*     */       } else {
/*     */         
/* 209 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 212 */       this._parent._createUserId = argResultSet.getString(18);
/*     */       
/* 214 */       Timestamp t19 = argResultSet.getTimestamp(19);
/* 215 */       if (t19 != null) {
/* 216 */         this._parent._updateDate = (Date)new DtvDate(t19.getTime());
/*     */       } else {
/*     */         
/* 219 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 222 */       this._parent._updateUserId = argResultSet.getString(20);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 227 */     argDAO.suppressStateChanges(true);
/* 228 */     EmployeeTaskDAO dao = (EmployeeTaskDAO)argDAO;
/* 229 */     dao.setOrganizationId(this._organizationId);
/* 230 */     dao.setRetailLocationId(this._retailLocationId);
/* 231 */     dao.setTaskId(this._taskId);
/* 232 */     dao.setStartDate(this._startDate);
/* 233 */     dao.setEndDate(this._endDate);
/* 234 */     dao.setCompleteDate(this._completeDate);
/* 235 */     dao.setTypeCode(this._typeCode);
/* 236 */     dao.setVisibility(this._visibility);
/* 237 */     dao.setAssignmentId(this._assignmentId);
/* 238 */     dao.setStoreCreated(this._storeCreated);
/* 239 */     dao.setTitle(this._title);
/* 240 */     dao.setDescription(this._description);
/* 241 */     dao.setPriority(this._priority);
/* 242 */     dao.setStatusCode(this._statusCode);
/* 243 */     dao.setVoid(this._void);
/* 244 */     dao.setPartyId(this._partyId);
/* 245 */     dao.setCreateDate(this._createDate);
/* 246 */     dao.setCreateUserId(this._createUserId);
/* 247 */     dao.setUpdateDate(this._updateDate);
/* 248 */     dao.setUpdateUserId(this._updateUserId);
/* 249 */     argDAO.suppressStateChanges(false);
/* 250 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 254 */     return loadDAO((IDataAccessObject)new EmployeeTaskDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 258 */     EmployeeTaskDAO dao = (EmployeeTaskDAO)argDAO;
/* 259 */     this._organizationId = dao.getOrganizationId();
/* 260 */     this._retailLocationId = dao.getRetailLocationId();
/* 261 */     this._taskId = dao.getTaskId();
/* 262 */     this._startDate = dao.getStartDate();
/* 263 */     this._endDate = dao.getEndDate();
/* 264 */     this._completeDate = dao.getCompleteDate();
/* 265 */     this._typeCode = dao.getTypeCode();
/* 266 */     this._visibility = dao.getVisibility();
/* 267 */     this._assignmentId = dao.getAssignmentId();
/* 268 */     this._storeCreated = (dao.getStoreCreated() != null) ? dao.getStoreCreated() : Boolean.valueOf(false);
/* 269 */     this._title = dao.getTitle();
/* 270 */     this._description = dao.getDescription();
/* 271 */     this._priority = dao.getPriority();
/* 272 */     this._statusCode = dao.getStatusCode();
/* 273 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/* 274 */     this._partyId = dao.getPartyId();
/* 275 */     this._createDate = dao.getCreateDate();
/* 276 */     this._createUserId = dao.getCreateUserId();
/* 277 */     this._updateDate = dao.getUpdateDate();
/* 278 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 282 */     EmployeeTaskId id = (EmployeeTaskId)argId;
/* 283 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 284 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 285 */     argStatement.setLong(3, id.getTaskId().longValue());
/* 286 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 290 */     EmployeeTaskId id = new EmployeeTaskId();
/* 291 */     id.setOrganizationId(this._organizationId);
/* 292 */     id.setRetailLocationId(this._retailLocationId);
/* 293 */     id.setTaskId(this._taskId);
/* 294 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 302 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 306 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeTaskDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */