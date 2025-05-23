/*     */ package dtv.xst.dao.cfg.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cfg.XadminUserId;
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
/*     */ public class XadminUserDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -91421086L;
/*     */   private String _userName;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private String _firstName;
/*     */   private String _lastName;
/*     */   private String _roleId;
/*     */   private String _locale;
/*     */   private Long _organizationId;
/*     */   private String _emailAddress;
/*     */   private String _directoryType;
/*     */   private static final String SELECT_OBJECT = "SELECT t.user_name, t.update_date, t.update_user_id, t.create_date, t.create_user_id, t.first_name, t.last_name, t.role_id, t.locale, t.organization_id, t.email_address, t.directory_type FROM cfg_user t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE user_name = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.user_name, t.update_date, t.update_user_id, t.create_date, t.create_user_id, t.first_name, t.last_name, t.role_id, t.locale, t.organization_id, t.email_address, t.directory_type FROM cfg_user t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE user_name = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cfg_user(user_name, update_date, update_user_id, create_date, create_user_id, first_name, last_name, role_id, locale, organization_id, email_address, directory_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._userName, this._updateDate, this._updateUserId, this._createDate, this._createUserId, this._firstName, this._lastName, this._roleId, this._locale, this._organizationId, this._emailAddress, this._directoryType } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, 91, 12, 91, 12, 12, 12, 12, 12, -5, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cfg_user SET update_date = ?, update_user_id = ?, first_name = ?, last_name = ?, role_id = ?, locale = ?, organization_id = ?, email_address = ?, directory_type = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._firstName, this._lastName, this._roleId, this._locale, this._organizationId, this._emailAddress, this._directoryType } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, -5, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cfg_user" }; private static final String WHERE_OBJECT = " WHERE user_name = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE user_name = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._userName };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "cfg_user";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new XadminUserFiller(this);
/*     */   }
/*     */   
/*     */   private static class XadminUserFiller
/*     */     implements IFiller {
/*     */     private XadminUserDBA _parent;
/*     */     
/*     */     public XadminUserFiller(XadminUserDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       this._parent._userName = argResultSet.getString(1);
/*     */       
/* 129 */       Timestamp t2 = argResultSet.getTimestamp(2);
/* 130 */       if (t2 != null) {
/* 131 */         this._parent._updateDate = (Date)new DtvDate(t2.getTime());
/*     */       } else {
/*     */         
/* 134 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 137 */       this._parent._updateUserId = argResultSet.getString(3);
/*     */       
/* 139 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 140 */       if (t4 != null) {
/* 141 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 147 */       this._parent._createUserId = argResultSet.getString(5);
/* 148 */       this._parent._firstName = argResultSet.getString(6);
/* 149 */       this._parent._lastName = argResultSet.getString(7);
/* 150 */       this._parent._roleId = argResultSet.getString(8);
/* 151 */       this._parent._locale = argResultSet.getString(9);
/*     */ 
/*     */       
/* 154 */       long primitiveResult = argResultSet.getLong(10);
/* 155 */       if (primitiveResult != 0L || argResultSet.getObject(10) != null) {
/* 156 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 160 */       this._parent._emailAddress = argResultSet.getString(11);
/* 161 */       this._parent._directoryType = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 166 */     argDAO.suppressStateChanges(true);
/* 167 */     XadminUserDAO dao = (XadminUserDAO)argDAO;
/* 168 */     dao.setUserName(this._userName);
/* 169 */     dao.setUpdateDate(this._updateDate);
/* 170 */     dao.setUpdateUserId(this._updateUserId);
/* 171 */     dao.setCreateDate(this._createDate);
/* 172 */     dao.setCreateUserId(this._createUserId);
/* 173 */     dao.setFirstName(this._firstName);
/* 174 */     dao.setLastName(this._lastName);
/* 175 */     dao.setRoleId(this._roleId);
/* 176 */     dao.setLocale(this._locale);
/* 177 */     dao.setOrganizationId(this._organizationId);
/* 178 */     dao.setEmailAddress(this._emailAddress);
/* 179 */     dao.setDirectoryType(this._directoryType);
/* 180 */     argDAO.suppressStateChanges(false);
/* 181 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 185 */     return loadDAO((IDataAccessObject)new XadminUserDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 189 */     XadminUserDAO dao = (XadminUserDAO)argDAO;
/* 190 */     this._userName = dao.getUserName();
/* 191 */     this._updateDate = dao.getUpdateDate();
/* 192 */     this._updateUserId = dao.getUpdateUserId();
/* 193 */     this._createDate = dao.getCreateDate();
/* 194 */     this._createUserId = dao.getCreateUserId();
/* 195 */     this._firstName = dao.getFirstName();
/* 196 */     this._lastName = dao.getLastName();
/* 197 */     this._roleId = dao.getRoleId();
/* 198 */     this._locale = dao.getLocale();
/* 199 */     this._organizationId = dao.getOrganizationId();
/* 200 */     this._emailAddress = dao.getEmailAddress();
/* 201 */     this._directoryType = dao.getDirectoryType();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 205 */     XadminUserId id = (XadminUserId)argId;
/* 206 */     argStatement.setString(1, id.getUserName());
/* 207 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 211 */     XadminUserId id = new XadminUserId();
/* 212 */     id.setUserName(this._userName);
/* 213 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 221 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 225 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cfg\impl\XadminUserDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */