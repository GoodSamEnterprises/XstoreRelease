/*     */ package dtv.xst.dao.sec.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sec.UserPasswordId;
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
/*     */ public class UserPasswordDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 613376934L;
/*     */   private Long _organizationId;
/*     */   private String _user;
/*     */   private Long _sequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _hash;
/*     */   private Date _effectiveDate;
/*     */   private Integer _failedAttempts;
/*     */   private Date _lockedOutTimeStamp;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.username, t.password_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.password, t.effective_date, t.failed_attempts, t.locked_out_timestamp FROM sec_user_password t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND username = ?  AND password_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.username, t.password_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.password, t.effective_date, t.failed_attempts, t.locked_out_timestamp FROM sec_user_password t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND username = ?  AND password_seq = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO sec_user_password(organization_id, username, password_seq, create_date, create_user_id, update_date, update_user_id, password, effective_date, failed_attempts, locked_out_timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._user, this._sequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._hash, this._effectiveDate, this._failedAttempts, this._lockedOutTimeStamp } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, -5, 91, 12, 91, 12, 12, 91, 4, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE sec_user_password SET update_date = ?, update_user_id = ?, password = ?, effective_date = ?, failed_attempts = ?, locked_out_timestamp = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._hash, this._effectiveDate, this._failedAttempts, this._lockedOutTimeStamp } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 91, 4, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM sec_user_password" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND username = ?  AND password_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND username = ?  AND password_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._user, this._sequence };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "sec_user_password";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new UserPasswordFiller(this);
/*     */   }
/*     */   
/*     */   private static class UserPasswordFiller
/*     */     implements IFiller {
/*     */     private UserPasswordDBA _parent;
/*     */     
/*     */     public UserPasswordFiller(UserPasswordDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long primitiveResult = argResultSet.getLong(1);
/* 129 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 134 */       this._parent._user = argResultSet.getString(2);
/*     */ 
/*     */       
/* 137 */       primitiveResult = argResultSet.getLong(3);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 139 */         this._parent._sequence = Long.valueOf(primitiveResult);
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
/* 163 */       this._parent._hash = argResultSet.getString(8);
/*     */       
/* 165 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 166 */       if (t9 != null) {
/* 167 */         this._parent._effectiveDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 175 */       int i = argResultSet.getInt(10);
/* 176 */       if (i != 0 || argResultSet.getObject(10) != null) {
/* 177 */         this._parent._failedAttempts = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 182 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 183 */       if (t11 != null) {
/* 184 */         this._parent._lockedOutTimeStamp = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 187 */         this._parent._lockedOutTimeStamp = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 194 */     argDAO.suppressStateChanges(true);
/* 195 */     UserPasswordDAO dao = (UserPasswordDAO)argDAO;
/* 196 */     dao.setOrganizationId(this._organizationId);
/* 197 */     dao.setUser(this._user);
/* 198 */     dao.setSequence(this._sequence);
/* 199 */     dao.setCreateDate(this._createDate);
/* 200 */     dao.setCreateUserId(this._createUserId);
/* 201 */     dao.setUpdateDate(this._updateDate);
/* 202 */     dao.setUpdateUserId(this._updateUserId);
/* 203 */     dao.setHash(this._hash);
/* 204 */     dao.setEffectiveDate(this._effectiveDate);
/* 205 */     dao.setFailedAttempts(this._failedAttempts);
/* 206 */     dao.setLockedOutTimeStamp(this._lockedOutTimeStamp);
/* 207 */     argDAO.suppressStateChanges(false);
/* 208 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 212 */     return loadDAO((IDataAccessObject)new UserPasswordDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 216 */     UserPasswordDAO dao = (UserPasswordDAO)argDAO;
/* 217 */     this._organizationId = dao.getOrganizationId();
/* 218 */     this._user = dao.getUser();
/* 219 */     this._sequence = dao.getSequence();
/* 220 */     this._createDate = dao.getCreateDate();
/* 221 */     this._createUserId = dao.getCreateUserId();
/* 222 */     this._updateDate = dao.getUpdateDate();
/* 223 */     this._updateUserId = dao.getUpdateUserId();
/* 224 */     this._hash = dao.getHash();
/* 225 */     this._effectiveDate = dao.getEffectiveDate();
/* 226 */     this._failedAttempts = dao.getFailedAttempts();
/* 227 */     this._lockedOutTimeStamp = dao.getLockedOutTimeStamp();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 231 */     UserPasswordId id = (UserPasswordId)argId;
/* 232 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 233 */     argStatement.setString(2, id.getUser());
/* 234 */     argStatement.setLong(3, id.getSequence().longValue());
/* 235 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 239 */     UserPasswordId id = new UserPasswordId();
/* 240 */     id.setOrganizationId(this._organizationId);
/* 241 */     id.setUser(this._user);
/* 242 */     id.setSequence(this._sequence);
/* 243 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 251 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 255 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\UserPasswordDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */