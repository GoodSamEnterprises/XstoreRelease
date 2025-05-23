/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.EmployeePasswordId;
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
/*     */ public class EmployeePasswordDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1636350857L;
/*     */   private Long _organizationId;
/*     */   private String _employeeId;
/*     */   private Integer _sequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _password;
/*     */   private Date _effectiveDate;
/*     */   private Boolean _temporary;
/*     */   private Boolean _current;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.employee_id, t.password_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.password, t.effective_date, t.temp_password_flag, t.current_password_flag FROM hrs_employee_password t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  AND password_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.employee_id, t.password_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.password, t.effective_date, t.temp_password_flag, t.current_password_flag FROM hrs_employee_password t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND employee_id = ?  AND password_seq = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO hrs_employee_password(organization_id, employee_id, password_seq, create_date, create_user_id, update_date, update_user_id, password, effective_date, temp_password_flag, current_password_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._employeeId, this._sequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._password, this._effectiveDate, this._temporary, this._current } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 91, 12, 91, 12, 12, 91, -7, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE hrs_employee_password SET update_date = ?, update_user_id = ?, password = ?, effective_date = ?, temp_password_flag = ?, current_password_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._password, this._effectiveDate, this._temporary, this._current } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 91, -7, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM hrs_employee_password" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  AND password_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND employee_id = ?  AND password_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._employeeId, this._sequence };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "hrs_employee_password";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new EmployeePasswordFiller(this);
/*     */   }
/*     */   
/*     */   private static class EmployeePasswordFiller
/*     */     implements IFiller {
/*     */     private EmployeePasswordDBA _parent;
/*     */     
/*     */     public EmployeePasswordFiller(EmployeePasswordDBA argParent) {
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
/* 137 */       int primitiveResult = argResultSet.getInt(3);
/* 138 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 139 */         this._parent._sequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 144 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 145 */       if (t4 != null) {
/* 146 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 154 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 155 */       if (t6 != null) {
/* 156 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 162 */       this._parent._updateUserId = argResultSet.getString(7);
/* 163 */       this._parent._password = argResultSet.getString(8);
/*     */       
/* 165 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 166 */       if (t9 != null) {
/* 167 */         this._parent._effectiveDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._temporary = Boolean.valueOf(argResultSet.getBoolean(10));
/* 174 */       this._parent._current = Boolean.valueOf(argResultSet.getBoolean(11));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 179 */     argDAO.suppressStateChanges(true);
/* 180 */     EmployeePasswordDAO dao = (EmployeePasswordDAO)argDAO;
/* 181 */     dao.setOrganizationId(this._organizationId);
/* 182 */     dao.setEmployeeId(this._employeeId);
/* 183 */     dao.setSequence(this._sequence);
/* 184 */     dao.setCreateDate(this._createDate);
/* 185 */     dao.setCreateUserId(this._createUserId);
/* 186 */     dao.setUpdateDate(this._updateDate);
/* 187 */     dao.setUpdateUserId(this._updateUserId);
/* 188 */     dao.setPassword(this._password);
/* 189 */     dao.setEffectiveDate(this._effectiveDate);
/* 190 */     dao.setTemporary(this._temporary);
/* 191 */     dao.setCurrent(this._current);
/* 192 */     argDAO.suppressStateChanges(false);
/* 193 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 197 */     return loadDAO((IDataAccessObject)new EmployeePasswordDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 201 */     EmployeePasswordDAO dao = (EmployeePasswordDAO)argDAO;
/* 202 */     this._organizationId = dao.getOrganizationId();
/* 203 */     this._employeeId = dao.getEmployeeId();
/* 204 */     this._sequence = dao.getSequence();
/* 205 */     this._createDate = dao.getCreateDate();
/* 206 */     this._createUserId = dao.getCreateUserId();
/* 207 */     this._updateDate = dao.getUpdateDate();
/* 208 */     this._updateUserId = dao.getUpdateUserId();
/* 209 */     this._password = dao.getPassword();
/* 210 */     this._effectiveDate = dao.getEffectiveDate();
/* 211 */     this._temporary = (dao.getTemporary() != null) ? dao.getTemporary() : Boolean.valueOf(false);
/* 212 */     this._current = (dao.getCurrent() != null) ? dao.getCurrent() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 216 */     EmployeePasswordId id = (EmployeePasswordId)argId;
/* 217 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 218 */     argStatement.setString(2, id.getEmployeeId());
/* 219 */     argStatement.setInt(3, id.getSequence().intValue());
/* 220 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 224 */     EmployeePasswordId id = new EmployeePasswordId();
/* 225 */     id.setOrganizationId(this._organizationId);
/* 226 */     id.setEmployeeId(this._employeeId);
/* 227 */     id.setSequence(this._sequence);
/* 228 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 236 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 240 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeePasswordDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */