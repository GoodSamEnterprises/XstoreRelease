/*     */ package dtv.xst.dao.sec.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCHelper;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.sec.PrivilegeId;
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
/*     */ public class PrivilegeDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 426579601L;
/*     */   private Long _organizationId;
/*     */   private String _privilegeType;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _configElement;
/*     */   private Boolean _authenticationRequired;
/*     */   private String _groupMembershipRaw;
/*     */   private Boolean _overridable;
/*     */   private String _description;
/*     */   private String _secondPromptSettings;
/*     */   private Boolean _secondPromptReqrDiffEmp;
/*     */   private String _secondPromptGroupMembershipRaw;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.privilege_type, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.config_element, t.authentication_req, t.group_membership, t.overridable_flag, t.description, t.second_prompt_settings, t.second_prompt_req_diff_emp, t.second_prompt_group_membership FROM sec_privilege t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND privilege_type = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.privilege_type, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.config_element, t.authentication_req, t.group_membership, t.overridable_flag, t.description, t.second_prompt_settings, t.second_prompt_req_diff_emp, t.second_prompt_group_membership FROM sec_privilege t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND privilege_type = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO sec_privilege(organization_id, privilege_type, create_date, create_user_id, update_date, update_user_id, config_element, authentication_req, group_membership, overridable_flag, description, second_prompt_settings, second_prompt_req_diff_emp, second_prompt_group_membership) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._privilegeType, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._authenticationRequired, this._groupMembershipRaw, this._overridable, this._description, this._secondPromptSettings, this._secondPromptReqrDiffEmp, this._secondPromptGroupMembershipRaw } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, -7, 2005, -7, 12, 12, -7, 2005 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE sec_privilege SET update_date = ?, update_user_id = ?, config_element = ?, authentication_req = ?, group_membership = ?, overridable_flag = ?, description = ?, second_prompt_settings = ?, second_prompt_req_diff_emp = ?, second_prompt_group_membership = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._authenticationRequired, this._groupMembershipRaw, this._overridable, this._description, this._secondPromptSettings, this._secondPromptReqrDiffEmp, this._secondPromptGroupMembershipRaw } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, -7, 2005, -7, 12, 12, -7, 2005 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM sec_privilege" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND privilege_type = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND privilege_type = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._privilegeType };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "sec_privilege";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new PrivilegeFiller(this);
/*     */   }
/*     */   
/*     */   private static class PrivilegeFiller
/*     */     implements IFiller {
/*     */     private PrivilegeDBA _parent;
/*     */     
/*     */     public PrivilegeFiller(PrivilegeDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long primitiveResult = argResultSet.getLong(1);
/* 132 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 137 */       this._parent._privilegeType = argResultSet.getString(2);
/*     */       
/* 139 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 140 */       if (t3 != null) {
/* 141 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 147 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 149 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 150 */       if (t5 != null) {
/* 151 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._updateUserId = argResultSet.getString(6);
/* 158 */       this._parent._configElement = argResultSet.getString(7);
/* 159 */       this._parent._authenticationRequired = Boolean.valueOf(argResultSet.getBoolean(8));
/*     */ 
/*     */       
/* 162 */       this._parent._groupMembershipRaw = JDBCHelper.clobToString(argResultSet, 9);
/*     */       
/* 164 */       this._parent._overridable = Boolean.valueOf(argResultSet.getBoolean(10));
/* 165 */       this._parent._description = argResultSet.getString(11);
/* 166 */       this._parent._secondPromptSettings = argResultSet.getString(12);
/* 167 */       this._parent._secondPromptReqrDiffEmp = Boolean.valueOf(argResultSet.getBoolean(13));
/*     */ 
/*     */       
/* 170 */       this._parent._secondPromptGroupMembershipRaw = JDBCHelper.clobToString(argResultSet, 14);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 176 */     argDAO.suppressStateChanges(true);
/* 177 */     PrivilegeDAO dao = (PrivilegeDAO)argDAO;
/* 178 */     dao.setOrganizationId(this._organizationId);
/* 179 */     dao.setPrivilegeType(this._privilegeType);
/* 180 */     dao.setCreateDate(this._createDate);
/* 181 */     dao.setCreateUserId(this._createUserId);
/* 182 */     dao.setUpdateDate(this._updateDate);
/* 183 */     dao.setUpdateUserId(this._updateUserId);
/* 184 */     dao.setConfigElement(this._configElement);
/* 185 */     dao.setAuthenticationRequired(this._authenticationRequired);
/* 186 */     dao.setGroupMembershipRaw(this._groupMembershipRaw);
/* 187 */     dao.setOverridable(this._overridable);
/* 188 */     dao.setDescription(this._description);
/* 189 */     dao.setSecondPromptSettings(this._secondPromptSettings);
/* 190 */     dao.setSecondPromptReqrDiffEmp(this._secondPromptReqrDiffEmp);
/* 191 */     dao.setSecondPromptGroupMembershipRaw(this._secondPromptGroupMembershipRaw);
/* 192 */     argDAO.suppressStateChanges(false);
/* 193 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 197 */     return loadDAO((IDataAccessObject)new PrivilegeDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 201 */     PrivilegeDAO dao = (PrivilegeDAO)argDAO;
/* 202 */     this._organizationId = dao.getOrganizationId();
/* 203 */     this._privilegeType = dao.getPrivilegeType();
/* 204 */     this._createDate = dao.getCreateDate();
/* 205 */     this._createUserId = dao.getCreateUserId();
/* 206 */     this._updateDate = dao.getUpdateDate();
/* 207 */     this._updateUserId = dao.getUpdateUserId();
/* 208 */     this._configElement = dao.getConfigElement();
/* 209 */     this._authenticationRequired = (dao.getAuthenticationRequired() != null) ? dao.getAuthenticationRequired() : Boolean.valueOf(false);
/* 210 */     this._groupMembershipRaw = dao.getGroupMembershipRaw();
/* 211 */     this._overridable = (dao.getOverridable() != null) ? dao.getOverridable() : Boolean.valueOf(false);
/* 212 */     this._description = dao.getDescription();
/* 213 */     this._secondPromptSettings = dao.getSecondPromptSettings();
/* 214 */     this._secondPromptReqrDiffEmp = (dao.getSecondPromptReqrDiffEmp() != null) ? dao.getSecondPromptReqrDiffEmp() : Boolean.valueOf(false);
/* 215 */     this._secondPromptGroupMembershipRaw = dao.getSecondPromptGroupMembershipRaw();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 219 */     PrivilegeId id = (PrivilegeId)argId;
/* 220 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 221 */     argStatement.setString(2, id.getPrivilegeType());
/* 222 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 226 */     PrivilegeId id = new PrivilegeId();
/* 227 */     id.setOrganizationId(this._organizationId);
/* 228 */     id.setPrivilegeType(this._privilegeType);
/* 229 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 237 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 241 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\PrivilegeDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */