/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.EmployeeStoreId;
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
/*     */ public class EmployeeStoreDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1240510797L;
/*     */   private Long _organizationId;
/*     */   private String _employeeId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _employeeStoreSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _beginDate;
/*     */   private Date _endDate;
/*     */   private Boolean _temporaryAssignment;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.employee_id, t.rtl_loc_id, t.employee_store_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_date, t.end_date, t.temp_assignment_flag FROM hrs_employee_store t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  AND rtl_loc_id = ?  AND employee_store_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.employee_id, t.rtl_loc_id, t.employee_store_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_date, t.end_date, t.temp_assignment_flag FROM hrs_employee_store t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND employee_id = ?  AND rtl_loc_id = ?  AND employee_store_seq = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO hrs_employee_store(organization_id, employee_id, rtl_loc_id, employee_store_seq, create_date, create_user_id, update_date, update_user_id, begin_date, end_date, temp_assignment_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._employeeId, this._retailLocationId, this._employeeStoreSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._beginDate, this._endDate, this._temporaryAssignment } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, -5, 4, 91, 12, 91, 12, 91, 91, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE hrs_employee_store SET update_date = ?, update_user_id = ?, begin_date = ?, end_date = ?, temp_assignment_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._beginDate, this._endDate, this._temporaryAssignment } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 91, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM hrs_employee_store" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  AND rtl_loc_id = ?  AND employee_store_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND employee_id = ?  AND rtl_loc_id = ?  AND employee_store_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._employeeId, this._retailLocationId, this._employeeStoreSequence };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, -5, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "hrs_employee_store";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new EmployeeStoreFiller(this);
/*     */   }
/*     */   
/*     */   private static class EmployeeStoreFiller
/*     */     implements IFiller {
/*     */     private EmployeeStoreDBA _parent;
/*     */     
/*     */     public EmployeeStoreFiller(EmployeeStoreDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long l = argResultSet.getLong(1);
/* 129 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 134 */       this._parent._employeeId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 137 */       l = argResultSet.getLong(3);
/* 138 */       if (l != 0L || argResultSet.getObject(3) != null) {
/* 139 */         this._parent._retailLocationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 145 */       int primitiveResult = argResultSet.getInt(4);
/* 146 */       if (primitiveResult != 0 || argResultSet.getObject(4) != null) {
/* 147 */         this._parent._employeeStoreSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 152 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 153 */       if (t5 != null) {
/* 154 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 162 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 163 */       if (t7 != null) {
/* 164 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 167 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 170 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */       
/* 172 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 173 */       if (t9 != null) {
/* 174 */         this._parent._beginDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 177 */         this._parent._beginDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 181 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 182 */       if (t10 != null) {
/* 183 */         this._parent._endDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 186 */         this._parent._endDate = null;
/*     */       } 
/*     */       
/* 189 */       this._parent._temporaryAssignment = Boolean.valueOf(argResultSet.getBoolean(11));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 194 */     argDAO.suppressStateChanges(true);
/* 195 */     EmployeeStoreDAO dao = (EmployeeStoreDAO)argDAO;
/* 196 */     dao.setOrganizationId(this._organizationId);
/* 197 */     dao.setEmployeeId(this._employeeId);
/* 198 */     dao.setRetailLocationId(this._retailLocationId);
/* 199 */     dao.setEmployeeStoreSequence(this._employeeStoreSequence);
/* 200 */     dao.setCreateDate(this._createDate);
/* 201 */     dao.setCreateUserId(this._createUserId);
/* 202 */     dao.setUpdateDate(this._updateDate);
/* 203 */     dao.setUpdateUserId(this._updateUserId);
/* 204 */     dao.setBeginDate(this._beginDate);
/* 205 */     dao.setEndDate(this._endDate);
/* 206 */     dao.setTemporaryAssignment(this._temporaryAssignment);
/* 207 */     argDAO.suppressStateChanges(false);
/* 208 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 212 */     return loadDAO((IDataAccessObject)new EmployeeStoreDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 216 */     EmployeeStoreDAO dao = (EmployeeStoreDAO)argDAO;
/* 217 */     this._organizationId = dao.getOrganizationId();
/* 218 */     this._employeeId = dao.getEmployeeId();
/* 219 */     this._retailLocationId = dao.getRetailLocationId();
/* 220 */     this._employeeStoreSequence = dao.getEmployeeStoreSequence();
/* 221 */     this._createDate = dao.getCreateDate();
/* 222 */     this._createUserId = dao.getCreateUserId();
/* 223 */     this._updateDate = dao.getUpdateDate();
/* 224 */     this._updateUserId = dao.getUpdateUserId();
/* 225 */     this._beginDate = dao.getBeginDate();
/* 226 */     this._endDate = dao.getEndDate();
/* 227 */     this._temporaryAssignment = (dao.getTemporaryAssignment() != null) ? dao.getTemporaryAssignment() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 231 */     EmployeeStoreId id = (EmployeeStoreId)argId;
/* 232 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 233 */     argStatement.setString(2, id.getEmployeeId());
/* 234 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 235 */     argStatement.setInt(4, id.getEmployeeStoreSequence().intValue());
/* 236 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 240 */     EmployeeStoreId id = new EmployeeStoreId();
/* 241 */     id.setOrganizationId(this._organizationId);
/* 242 */     id.setEmployeeId(this._employeeId);
/* 243 */     id.setRetailLocationId(this._retailLocationId);
/* 244 */     id.setEmployeeStoreSequence(this._employeeStoreSequence);
/* 245 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 253 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 257 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeStoreDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */