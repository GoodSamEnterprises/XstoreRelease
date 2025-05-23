/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.OrgHierarchyId;
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
/*     */ public class OrgHierarchyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -323299375L;
/*     */   private Long _organizationId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _parentCode;
/*     */   private String _parentValue;
/*     */   private String _description;
/*     */   private String _levelManager;
/*     */   private Integer _levelOrder;
/*     */   private Integer _sortOrder;
/*     */   private Boolean _inactive;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.parent_code, t.parent_value, t.description, t.level_mgr, t.level_order, t.sort_order, t.inactive_flag FROM loc_org_hierarchy t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND org_code = ?  AND org_value = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.parent_code, t.parent_value, t.description, t.level_mgr, t.level_order, t.sort_order, t.inactive_flag FROM loc_org_hierarchy t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND org_code = ?  AND org_value = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO loc_org_hierarchy(organization_id, org_code, org_value, create_date, create_user_id, update_date, update_user_id, parent_code, parent_value, description, level_mgr, level_order, sort_order, inactive_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._levelCode, this._levelValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._parentCode, this._parentValue, this._description, this._levelManager, this._levelOrder, this._sortOrder, this._inactive } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12, 12, 12, 12, 4, 4, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE loc_org_hierarchy SET update_date = ?, update_user_id = ?, parent_code = ?, parent_value = ?, description = ?, level_mgr = ?, level_order = ?, sort_order = ?, inactive_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._parentCode, this._parentValue, this._description, this._levelManager, this._levelOrder, this._sortOrder, this._inactive } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 4, 4, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM loc_org_hierarchy" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND org_code = ?  AND org_value = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND org_code = ?  AND org_value = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._levelCode, this._levelValue };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "loc_org_hierarchy";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new OrgHierarchyFiller(this);
/*     */   }
/*     */   
/*     */   private static class OrgHierarchyFiller
/*     */     implements IFiller {
/*     */     private OrgHierarchyDBA _parent;
/*     */     
/*     */     public OrgHierarchyFiller(OrgHierarchyDBA argParent) {
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
/* 137 */       this._parent._levelCode = argResultSet.getString(2);
/* 138 */       this._parent._levelValue = argResultSet.getString(3);
/*     */       
/* 140 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 141 */       if (t4 != null) {
/* 142 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 145 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 148 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 150 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 151 */       if (t6 != null) {
/* 152 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 155 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 158 */       this._parent._updateUserId = argResultSet.getString(7);
/* 159 */       this._parent._parentCode = argResultSet.getString(8);
/* 160 */       this._parent._parentValue = argResultSet.getString(9);
/* 161 */       this._parent._description = argResultSet.getString(10);
/* 162 */       this._parent._levelManager = argResultSet.getString(11);
/*     */ 
/*     */       
/* 165 */       int i = argResultSet.getInt(12);
/* 166 */       if (i != 0 || argResultSet.getObject(12) != null) {
/* 167 */         this._parent._levelOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       i = argResultSet.getInt(13);
/* 174 */       if (i != 0 || argResultSet.getObject(13) != null) {
/* 175 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 179 */       this._parent._inactive = Boolean.valueOf(argResultSet.getBoolean(14));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 184 */     argDAO.suppressStateChanges(true);
/* 185 */     OrgHierarchyDAO dao = (OrgHierarchyDAO)argDAO;
/* 186 */     dao.setOrganizationId(this._organizationId);
/* 187 */     dao.setLevelCode(this._levelCode);
/* 188 */     dao.setLevelValue(this._levelValue);
/* 189 */     dao.setCreateDate(this._createDate);
/* 190 */     dao.setCreateUserId(this._createUserId);
/* 191 */     dao.setUpdateDate(this._updateDate);
/* 192 */     dao.setUpdateUserId(this._updateUserId);
/* 193 */     dao.setParentCode(this._parentCode);
/* 194 */     dao.setParentValue(this._parentValue);
/* 195 */     dao.setDescription(this._description);
/* 196 */     dao.setLevelManager(this._levelManager);
/* 197 */     dao.setLevelOrder(this._levelOrder);
/* 198 */     dao.setSortOrder(this._sortOrder);
/* 199 */     dao.setInactive(this._inactive);
/* 200 */     argDAO.suppressStateChanges(false);
/* 201 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 205 */     return loadDAO((IDataAccessObject)new OrgHierarchyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 209 */     OrgHierarchyDAO dao = (OrgHierarchyDAO)argDAO;
/* 210 */     this._organizationId = dao.getOrganizationId();
/* 211 */     this._levelCode = dao.getLevelCode();
/* 212 */     this._levelValue = dao.getLevelValue();
/* 213 */     this._createDate = dao.getCreateDate();
/* 214 */     this._createUserId = dao.getCreateUserId();
/* 215 */     this._updateDate = dao.getUpdateDate();
/* 216 */     this._updateUserId = dao.getUpdateUserId();
/* 217 */     this._parentCode = dao.getParentCode();
/* 218 */     this._parentValue = dao.getParentValue();
/* 219 */     this._description = dao.getDescription();
/* 220 */     this._levelManager = dao.getLevelManager();
/* 221 */     this._levelOrder = dao.getLevelOrder();
/* 222 */     this._sortOrder = dao.getSortOrder();
/* 223 */     this._inactive = (dao.getInactive() != null) ? dao.getInactive() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 227 */     OrgHierarchyId id = (OrgHierarchyId)argId;
/* 228 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 229 */     argStatement.setString(2, id.getLevelCode());
/* 230 */     argStatement.setString(3, id.getLevelValue());
/* 231 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 235 */     OrgHierarchyId id = new OrgHierarchyId();
/* 236 */     id.setOrganizationId(this._organizationId);
/* 237 */     id.setLevelCode(this._levelCode);
/* 238 */     id.setLevelValue(this._levelValue);
/* 239 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 247 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 251 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\OrgHierarchyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */