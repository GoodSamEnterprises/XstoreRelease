/*     */ package dtv.xst.dao.sch.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.sch.ShiftId;
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
/*     */ public class ShiftDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 79854690L;
/*     */   private Long _organizationId;
/*     */   private Long _shiftId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _name;
/*     */   private String _description;
/*     */   private String _workCode;
/*     */   private Date _startTime;
/*     */   private Date _endTime;
/*     */   private Boolean _void;
/*     */   private Long _breakDuration;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.shift_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.name, t.description, t.work_code, t.start_time, t.end_time, t.void_flag, t.break_duration FROM sch_shift t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND shift_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.shift_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.name, t.description, t.work_code, t.start_time, t.end_time, t.void_flag, t.break_duration FROM sch_shift t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND shift_id = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO sch_shift(organization_id, shift_id, org_code, org_value, create_date, create_user_id, update_date, update_user_id, name, description, work_code, start_time, end_time, void_flag, break_duration) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._shiftId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._name, this._description, this._workCode, this._startTime, this._endTime, this._void, this._breakDuration } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 91, 12, 91, 12, 12, 12, 12, 91, 91, -7, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE sch_shift SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, name = ?, description = ?, work_code = ?, start_time = ?, end_time = ?, void_flag = ?, break_duration = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._name, this._description, this._workCode, this._startTime, this._endTime, this._void, this._breakDuration } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 12, 12, 12, 91, 91, -7, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM sch_shift" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND shift_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND shift_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._shiftId };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "sch_shift";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new ShiftFiller(this);
/*     */   }
/*     */   
/*     */   private static class ShiftFiller
/*     */     implements IFiller {
/*     */     private ShiftDBA _parent;
/*     */     
/*     */     public ShiftFiller(ShiftDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 132 */       long primitiveResult = argResultSet.getLong(1);
/* 133 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 134 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 140 */       primitiveResult = argResultSet.getLong(2);
/* 141 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 142 */         this._parent._shiftId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 146 */       this._parent._orgCode = argResultSet.getString(3);
/* 147 */       this._parent._orgValue = argResultSet.getString(4);
/*     */       
/* 149 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 150 */       if (t5 != null) {
/* 151 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 159 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 160 */       if (t7 != null) {
/* 161 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 167 */       this._parent._updateUserId = argResultSet.getString(8);
/* 168 */       this._parent._name = argResultSet.getString(9);
/* 169 */       this._parent._description = argResultSet.getString(10);
/* 170 */       this._parent._workCode = argResultSet.getString(11);
/*     */       
/* 172 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 173 */       if (t12 != null) {
/* 174 */         this._parent._startTime = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 177 */         this._parent._startTime = null;
/*     */       } 
/*     */ 
/*     */       
/* 181 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 182 */       if (t13 != null) {
/* 183 */         this._parent._endTime = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 186 */         this._parent._endTime = null;
/*     */       } 
/*     */       
/* 189 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(14));
/*     */ 
/*     */       
/* 192 */       long l1 = argResultSet.getLong(15);
/* 193 */       if (l1 != 0L || argResultSet.getObject(15) != null) {
/* 194 */         this._parent._breakDuration = Long.valueOf(l1);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 202 */     argDAO.suppressStateChanges(true);
/* 203 */     ShiftDAO dao = (ShiftDAO)argDAO;
/* 204 */     dao.setOrganizationId(this._organizationId);
/* 205 */     dao.setShiftId(this._shiftId);
/* 206 */     dao.setOrgCode(this._orgCode);
/* 207 */     dao.setOrgValue(this._orgValue);
/* 208 */     dao.setCreateDate(this._createDate);
/* 209 */     dao.setCreateUserId(this._createUserId);
/* 210 */     dao.setUpdateDate(this._updateDate);
/* 211 */     dao.setUpdateUserId(this._updateUserId);
/* 212 */     dao.setName(this._name);
/* 213 */     dao.setDescription(this._description);
/* 214 */     dao.setWorkCode(this._workCode);
/* 215 */     dao.setStartTime(this._startTime);
/* 216 */     dao.setEndTime(this._endTime);
/* 217 */     dao.setVoid(this._void);
/* 218 */     dao.setBreakDuration(this._breakDuration);
/* 219 */     argDAO.suppressStateChanges(false);
/* 220 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 224 */     return loadDAO((IDataAccessObject)new ShiftDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 228 */     ShiftDAO dao = (ShiftDAO)argDAO;
/* 229 */     this._organizationId = dao.getOrganizationId();
/* 230 */     this._shiftId = dao.getShiftId();
/* 231 */     this._orgCode = dao.getOrgCode();
/* 232 */     this._orgValue = dao.getOrgValue();
/* 233 */     this._createDate = dao.getCreateDate();
/* 234 */     this._createUserId = dao.getCreateUserId();
/* 235 */     this._updateDate = dao.getUpdateDate();
/* 236 */     this._updateUserId = dao.getUpdateUserId();
/* 237 */     this._name = dao.getName();
/* 238 */     this._description = dao.getDescription();
/* 239 */     this._workCode = dao.getWorkCode();
/* 240 */     this._startTime = dao.getStartTime();
/* 241 */     this._endTime = dao.getEndTime();
/* 242 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/* 243 */     this._breakDuration = dao.getBreakDuration();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 247 */     ShiftId id = (ShiftId)argId;
/* 248 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 249 */     argStatement.setLong(2, id.getShiftId().longValue());
/* 250 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 254 */     ShiftId id = new ShiftId();
/* 255 */     id.setOrganizationId(this._organizationId);
/* 256 */     id.setShiftId(this._shiftId);
/* 257 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 265 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 269 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sch\impl\ShiftDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */