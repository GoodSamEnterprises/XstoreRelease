/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.EmployeeFingerprintId;
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
/*     */ public class EmployeeFingerprintDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -2130044618L;
/*     */   private Long _organizationId;
/*     */   private String _employeeId;
/*     */   private Integer _sequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _biometricStorage;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.employee_id, t.fingerprint_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.fingerprint_storage FROM hrs_employee_fingerprint t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  AND fingerprint_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  37 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  41 */     return "SELECT t.organization_id, t.employee_id, t.fingerprint_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.fingerprint_storage FROM hrs_employee_fingerprint t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  47 */     return " WHERE organization_id = ?  AND employee_id = ?  AND fingerprint_seq = ?  ";
/*     */   }
/*     */   
/*  50 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO hrs_employee_fingerprint(organization_id, employee_id, fingerprint_seq, create_date, create_user_id, update_date, update_user_id, fingerprint_storage) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  53 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  57 */     Object[][] insertParameterObject = { { this._organizationId, this._employeeId, this._sequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._biometricStorage } };
/*  58 */     return insertParameterObject;
/*     */   }
/*     */   
/*  61 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 91, 12, 91, 12, 2005 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  64 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  67 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE hrs_employee_fingerprint SET update_date = ?, update_user_id = ?, fingerprint_storage = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  70 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  74 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._biometricStorage } };
/*  75 */     return updateParameterObject;
/*     */   }
/*     */   
/*  78 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 2005 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  80 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  83 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM hrs_employee_fingerprint" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND employee_id = ?  AND fingerprint_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  86 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  92 */     return " WHERE organization_id = ?  AND employee_id = ?  AND fingerprint_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  95 */     return new Object[] { this._organizationId, this._employeeId, this._sequence };
/*     */   }
/*     */   
/*  98 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 101 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 104 */     return "hrs_employee_fingerprint";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 108 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 112 */     return new EmployeeFingerprintFiller(this);
/*     */   }
/*     */   
/*     */   private static class EmployeeFingerprintFiller
/*     */     implements IFiller {
/*     */     private EmployeeFingerprintDBA _parent;
/*     */     
/*     */     public EmployeeFingerprintFiller(EmployeeFingerprintDBA argParent) {
/* 120 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 125 */       long l = argResultSet.getLong(1);
/* 126 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 127 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 131 */       this._parent._employeeId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 134 */       int primitiveResult = argResultSet.getInt(3);
/* 135 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 136 */         this._parent._sequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 141 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 142 */       if (t4 != null) {
/* 143 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 146 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 149 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 151 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 152 */       if (t6 != null) {
/* 153 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._updateUserId = argResultSet.getString(7);
/*     */ 
/*     */       
/* 162 */       this._parent._biometricStorage = JDBCHelper.clobToString(argResultSet, 8);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 168 */     argDAO.suppressStateChanges(true);
/* 169 */     EmployeeFingerprintDAO dao = (EmployeeFingerprintDAO)argDAO;
/* 170 */     dao.setOrganizationId(this._organizationId);
/* 171 */     dao.setEmployeeId(this._employeeId);
/* 172 */     dao.setSequence(this._sequence);
/* 173 */     dao.setCreateDate(this._createDate);
/* 174 */     dao.setCreateUserId(this._createUserId);
/* 175 */     dao.setUpdateDate(this._updateDate);
/* 176 */     dao.setUpdateUserId(this._updateUserId);
/* 177 */     dao.setBiometricStorage(this._biometricStorage);
/* 178 */     argDAO.suppressStateChanges(false);
/* 179 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 183 */     return loadDAO((IDataAccessObject)new EmployeeFingerprintDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 187 */     EmployeeFingerprintDAO dao = (EmployeeFingerprintDAO)argDAO;
/* 188 */     this._organizationId = dao.getOrganizationId();
/* 189 */     this._employeeId = dao.getEmployeeId();
/* 190 */     this._sequence = dao.getSequence();
/* 191 */     this._createDate = dao.getCreateDate();
/* 192 */     this._createUserId = dao.getCreateUserId();
/* 193 */     this._updateDate = dao.getUpdateDate();
/* 194 */     this._updateUserId = dao.getUpdateUserId();
/* 195 */     this._biometricStorage = dao.getBiometricStorage();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 199 */     EmployeeFingerprintId id = (EmployeeFingerprintId)argId;
/* 200 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 201 */     argStatement.setString(2, id.getEmployeeId());
/* 202 */     argStatement.setInt(3, id.getSequence().intValue());
/* 203 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 207 */     EmployeeFingerprintId id = new EmployeeFingerprintId();
/* 208 */     id.setOrganizationId(this._organizationId);
/* 209 */     id.setEmployeeId(this._employeeId);
/* 210 */     id.setSequence(this._sequence);
/* 211 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 219 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 223 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeFingerprintDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */