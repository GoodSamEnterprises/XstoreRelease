/*     */ package dtv.xst.dao.sec.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sec.UserRoleId;
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
/*     */ public class UserRoleDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -201890047L;
/*     */   private Long _organizationId;
/*     */   private Integer _userRoleId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _user;
/*     */   private String _roleCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.user_role_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.username, t.role_code FROM sec_user_role t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND user_role_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  37 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  41 */     return "SELECT t.organization_id, t.user_role_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.username, t.role_code FROM sec_user_role t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  47 */     return " WHERE organization_id = ?  AND user_role_id = ?  ";
/*     */   }
/*     */   
/*  50 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO sec_user_role(organization_id, user_role_id, create_date, create_user_id, update_date, update_user_id, username, role_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  53 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  57 */     Object[][] insertParameterObject = { { this._organizationId, this._userRoleId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._user, this._roleCode } };
/*  58 */     return insertParameterObject;
/*     */   }
/*     */   
/*  61 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 4, 91, 12, 91, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  64 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  67 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE sec_user_role SET update_date = ?, update_user_id = ?, username = ?, role_code = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  70 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  74 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._user, this._roleCode } };
/*  75 */     return updateParameterObject;
/*     */   }
/*     */   
/*  78 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  80 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  83 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM sec_user_role" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND user_role_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  86 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  92 */     return " WHERE organization_id = ?  AND user_role_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  95 */     return new Object[] { this._organizationId, this._userRoleId };
/*     */   }
/*     */   
/*  98 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 101 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 104 */     return "sec_user_role";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 108 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 112 */     return new UserRoleFiller(this);
/*     */   }
/*     */   
/*     */   private static class UserRoleFiller
/*     */     implements IFiller {
/*     */     private UserRoleDBA _parent;
/*     */     
/*     */     public UserRoleFiller(UserRoleDBA argParent) {
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
/*     */ 
/*     */       
/* 133 */       int primitiveResult = argResultSet.getInt(2);
/* 134 */       if (primitiveResult != 0 || argResultSet.getObject(2) != null) {
/* 135 */         this._parent._userRoleId = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 140 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 141 */       if (t3 != null) {
/* 142 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 145 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 148 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 150 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 151 */       if (t5 != null) {
/* 152 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 155 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 158 */       this._parent._updateUserId = argResultSet.getString(6);
/* 159 */       this._parent._user = argResultSet.getString(7);
/* 160 */       this._parent._roleCode = argResultSet.getString(8);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 165 */     argDAO.suppressStateChanges(true);
/* 166 */     UserRoleDAO dao = (UserRoleDAO)argDAO;
/* 167 */     dao.setOrganizationId(this._organizationId);
/* 168 */     dao.setUserRoleId(this._userRoleId);
/* 169 */     dao.setCreateDate(this._createDate);
/* 170 */     dao.setCreateUserId(this._createUserId);
/* 171 */     dao.setUpdateDate(this._updateDate);
/* 172 */     dao.setUpdateUserId(this._updateUserId);
/* 173 */     dao.setUser(this._user);
/* 174 */     dao.setRoleCode(this._roleCode);
/* 175 */     argDAO.suppressStateChanges(false);
/* 176 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 180 */     return loadDAO((IDataAccessObject)new UserRoleDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 184 */     UserRoleDAO dao = (UserRoleDAO)argDAO;
/* 185 */     this._organizationId = dao.getOrganizationId();
/* 186 */     this._userRoleId = dao.getUserRoleId();
/* 187 */     this._createDate = dao.getCreateDate();
/* 188 */     this._createUserId = dao.getCreateUserId();
/* 189 */     this._updateDate = dao.getUpdateDate();
/* 190 */     this._updateUserId = dao.getUpdateUserId();
/* 191 */     this._user = dao.getUser();
/* 192 */     this._roleCode = dao.getRoleCode();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 196 */     UserRoleId id = (UserRoleId)argId;
/* 197 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 198 */     argStatement.setInt(2, id.getUserRoleId().intValue());
/* 199 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 203 */     UserRoleId id = new UserRoleId();
/* 204 */     id.setOrganizationId(this._organizationId);
/* 205 */     id.setUserRoleId(this._userRoleId);
/* 206 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 214 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 218 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\UserRoleDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */