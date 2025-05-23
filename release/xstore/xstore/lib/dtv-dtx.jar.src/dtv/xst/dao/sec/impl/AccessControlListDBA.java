/*     */ package dtv.xst.dao.sec.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sec.AccessControlListId;
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
/*     */ public class AccessControlListDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 699875191L;
/*     */   private Long _organizationId;
/*     */   private String _securedObjectId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Boolean _authenticationRequired;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.secured_object_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.authentication_req_flag FROM sec_acl t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND secured_object_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  36 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  40 */     return "SELECT t.organization_id, t.secured_object_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.authentication_req_flag FROM sec_acl t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  46 */     return " WHERE organization_id = ?  AND secured_object_id = ?  ";
/*     */   }
/*     */   
/*  49 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO sec_acl(organization_id, secured_object_id, create_date, create_user_id, update_date, update_user_id, authentication_req_flag) VALUES (?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  52 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  56 */     Object[][] insertParameterObject = { { this._organizationId, this._securedObjectId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._authenticationRequired } };
/*  57 */     return insertParameterObject;
/*     */   }
/*     */   
/*  60 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  63 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  66 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE sec_acl SET update_date = ?, update_user_id = ?, authentication_req_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  69 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  73 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._authenticationRequired } };
/*  74 */     return updateParameterObject;
/*     */   }
/*     */   
/*  77 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  79 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  82 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM sec_acl" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND secured_object_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  85 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  91 */     return " WHERE organization_id = ?  AND secured_object_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  94 */     return new Object[] { this._organizationId, this._securedObjectId };
/*     */   }
/*     */   
/*  97 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 100 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 103 */     return "sec_acl";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 107 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 111 */     return new AccessControlListFiller(this);
/*     */   }
/*     */   
/*     */   private static class AccessControlListFiller
/*     */     implements IFiller {
/*     */     private AccessControlListDBA _parent;
/*     */     
/*     */     public AccessControlListFiller(AccessControlListDBA argParent) {
/* 119 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 124 */       long primitiveResult = argResultSet.getLong(1);
/* 125 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 126 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 130 */       this._parent._securedObjectId = argResultSet.getString(2);
/*     */       
/* 132 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 133 */       if (t3 != null) {
/* 134 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 137 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 140 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 142 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 143 */       if (t5 != null) {
/* 144 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 147 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 150 */       this._parent._updateUserId = argResultSet.getString(6);
/* 151 */       this._parent._authenticationRequired = Boolean.valueOf(argResultSet.getBoolean(7));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 156 */     argDAO.suppressStateChanges(true);
/* 157 */     AccessControlListDAO dao = (AccessControlListDAO)argDAO;
/* 158 */     dao.setOrganizationId(this._organizationId);
/* 159 */     dao.setSecuredObjectId(this._securedObjectId);
/* 160 */     dao.setCreateDate(this._createDate);
/* 161 */     dao.setCreateUserId(this._createUserId);
/* 162 */     dao.setUpdateDate(this._updateDate);
/* 163 */     dao.setUpdateUserId(this._updateUserId);
/* 164 */     dao.setAuthenticationRequired(this._authenticationRequired);
/* 165 */     argDAO.suppressStateChanges(false);
/* 166 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 170 */     return loadDAO((IDataAccessObject)new AccessControlListDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 174 */     AccessControlListDAO dao = (AccessControlListDAO)argDAO;
/* 175 */     this._organizationId = dao.getOrganizationId();
/* 176 */     this._securedObjectId = dao.getSecuredObjectId();
/* 177 */     this._createDate = dao.getCreateDate();
/* 178 */     this._createUserId = dao.getCreateUserId();
/* 179 */     this._updateDate = dao.getUpdateDate();
/* 180 */     this._updateUserId = dao.getUpdateUserId();
/* 181 */     this._authenticationRequired = (dao.getAuthenticationRequired() != null) ? dao.getAuthenticationRequired() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 185 */     AccessControlListId id = (AccessControlListId)argId;
/* 186 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 187 */     argStatement.setString(2, id.getSecuredObjectId());
/* 188 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     AccessControlListId id = new AccessControlListId();
/* 193 */     id.setOrganizationId(this._organizationId);
/* 194 */     id.setSecuredObjectId(this._securedObjectId);
/* 195 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 203 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 207 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\AccessControlListDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */