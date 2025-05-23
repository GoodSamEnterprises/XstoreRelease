/*     */ package dtv.xst.dao.sec.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sec.AclAccessTypeId;
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
/*     */ public class AclAccessTypeDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1942796600L;
/*     */   private String _accessTypeCode;
/*     */   private Long _organizationId;
/*     */   private String _securedObjectId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _groupMembershipRaw;
/*     */   private String _noAccessSettings;
/*     */   private static final String SELECT_OBJECT = "SELECT t.access_typcode, t.organization_id, t.secured_object_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.group_membership, t.no_access_settings FROM sec_access_types t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE access_typcode = ?  AND organization_id = ?  AND secured_object_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.access_typcode, t.organization_id, t.secured_object_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.group_membership, t.no_access_settings FROM sec_access_types t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  48 */     return " WHERE access_typcode = ?  AND organization_id = ?  AND secured_object_id = ?  ";
/*     */   }
/*     */   
/*  51 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO sec_access_types(access_typcode, organization_id, secured_object_id, create_date, create_user_id, update_date, update_user_id, group_membership, no_access_settings) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  54 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  58 */     Object[][] insertParameterObject = { { this._accessTypeCode, this._organizationId, this._securedObjectId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._groupMembershipRaw, this._noAccessSettings } };
/*  59 */     return insertParameterObject;
/*     */   }
/*     */   
/*  62 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 91, 12, 91, 12, 2005, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  65 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  68 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE sec_access_types SET update_date = ?, update_user_id = ?, group_membership = ?, no_access_settings = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  71 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  75 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._groupMembershipRaw, this._noAccessSettings } };
/*  76 */     return updateParameterObject;
/*     */   }
/*     */   
/*  79 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 2005, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  81 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM sec_access_types" }; private static final String WHERE_OBJECT = " WHERE access_typcode = ?  AND organization_id = ?  AND secured_object_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  87 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  93 */     return " WHERE access_typcode = ?  AND organization_id = ?  AND secured_object_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  96 */     return new Object[] { this._accessTypeCode, this._organizationId, this._securedObjectId };
/*     */   }
/*     */   
/*  99 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 102 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 105 */     return "sec_access_types";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 109 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 113 */     return new AclAccessTypeFiller(this);
/*     */   }
/*     */   
/*     */   private static class AclAccessTypeFiller
/*     */     implements IFiller {
/*     */     private AclAccessTypeDBA _parent;
/*     */     
/*     */     public AclAccessTypeFiller(AclAccessTypeDBA argParent) {
/* 121 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 124 */       this._parent._accessTypeCode = argResultSet.getString(1);
/*     */ 
/*     */       
/* 127 */       long primitiveResult = argResultSet.getLong(2);
/* 128 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 133 */       this._parent._securedObjectId = argResultSet.getString(3);
/*     */       
/* 135 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 136 */       if (t4 != null) {
/* 137 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 140 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 143 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 145 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 146 */       if (t6 != null) {
/* 147 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._updateUserId = argResultSet.getString(7);
/*     */ 
/*     */       
/* 156 */       this._parent._groupMembershipRaw = JDBCHelper.clobToString(argResultSet, 8);
/*     */       
/* 158 */       this._parent._noAccessSettings = argResultSet.getString(9);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 163 */     argDAO.suppressStateChanges(true);
/* 164 */     AclAccessTypeDAO dao = (AclAccessTypeDAO)argDAO;
/* 165 */     dao.setAccessTypeCode(this._accessTypeCode);
/* 166 */     dao.setOrganizationId(this._organizationId);
/* 167 */     dao.setSecuredObjectId(this._securedObjectId);
/* 168 */     dao.setCreateDate(this._createDate);
/* 169 */     dao.setCreateUserId(this._createUserId);
/* 170 */     dao.setUpdateDate(this._updateDate);
/* 171 */     dao.setUpdateUserId(this._updateUserId);
/* 172 */     dao.setGroupMembershipRaw(this._groupMembershipRaw);
/* 173 */     dao.setNoAccessSettings(this._noAccessSettings);
/* 174 */     argDAO.suppressStateChanges(false);
/* 175 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 179 */     return loadDAO((IDataAccessObject)new AclAccessTypeDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 183 */     AclAccessTypeDAO dao = (AclAccessTypeDAO)argDAO;
/* 184 */     this._accessTypeCode = dao.getAccessTypeCode();
/* 185 */     this._organizationId = dao.getOrganizationId();
/* 186 */     this._securedObjectId = dao.getSecuredObjectId();
/* 187 */     this._createDate = dao.getCreateDate();
/* 188 */     this._createUserId = dao.getCreateUserId();
/* 189 */     this._updateDate = dao.getUpdateDate();
/* 190 */     this._updateUserId = dao.getUpdateUserId();
/* 191 */     this._groupMembershipRaw = dao.getGroupMembershipRaw();
/* 192 */     this._noAccessSettings = dao.getNoAccessSettings();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 196 */     AclAccessTypeId id = (AclAccessTypeId)argId;
/* 197 */     argStatement.setString(1, id.getAccessTypeCode());
/* 198 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 199 */     argStatement.setString(3, id.getSecuredObjectId());
/* 200 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 204 */     AclAccessTypeId id = new AclAccessTypeId();
/* 205 */     id.setAccessTypeCode(this._accessTypeCode);
/* 206 */     id.setOrganizationId(this._organizationId);
/* 207 */     id.setSecuredObjectId(this._securedObjectId);
/* 208 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 216 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 220 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\AclAccessTypeDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */