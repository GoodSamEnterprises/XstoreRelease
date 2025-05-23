/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.PricingHierarchyId;
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
/*     */ public class PricingHierarchyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1021266641L;
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
/*     */   private Integer _levelOrder;
/*     */   private Integer _sortOrder;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.level_code, t.level_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.parent_code, t.parent_value, t.description, t.level_order, t.sort_order FROM loc_pricing_hierarchy t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.level_code, t.level_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.parent_code, t.parent_value, t.description, t.level_order, t.sort_order FROM loc_pricing_hierarchy t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO loc_pricing_hierarchy(organization_id, level_code, level_value, create_date, create_user_id, update_date, update_user_id, parent_code, parent_value, description, level_order, sort_order) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._levelCode, this._levelValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._parentCode, this._parentValue, this._description, this._levelOrder, this._sortOrder } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12, 12, 12, 4, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE loc_pricing_hierarchy SET update_date = ?, update_user_id = ?, parent_code = ?, parent_value = ?, description = ?, level_order = ?, sort_order = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._parentCode, this._parentValue, this._description, this._levelOrder, this._sortOrder } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 4, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM loc_pricing_hierarchy" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._levelCode, this._levelValue };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "loc_pricing_hierarchy";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new PricingHierarchyFiller(this);
/*     */   }
/*     */   
/*     */   private static class PricingHierarchyFiller
/*     */     implements IFiller {
/*     */     private PricingHierarchyDBA _parent;
/*     */     
/*     */     public PricingHierarchyFiller(PricingHierarchyDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long primitiveResult = argResultSet.getLong(1);
/* 130 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 135 */       this._parent._levelCode = argResultSet.getString(2);
/* 136 */       this._parent._levelValue = argResultSet.getString(3);
/*     */       
/* 138 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 139 */       if (t4 != null) {
/* 140 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 143 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 146 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 148 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 149 */       if (t6 != null) {
/* 150 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 153 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 156 */       this._parent._updateUserId = argResultSet.getString(7);
/* 157 */       this._parent._parentCode = argResultSet.getString(8);
/* 158 */       this._parent._parentValue = argResultSet.getString(9);
/* 159 */       this._parent._description = argResultSet.getString(10);
/*     */ 
/*     */       
/* 162 */       int i = argResultSet.getInt(11);
/* 163 */       if (i != 0 || argResultSet.getObject(11) != null) {
/* 164 */         this._parent._levelOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 170 */       i = argResultSet.getInt(12);
/* 171 */       if (i != 0 || argResultSet.getObject(12) != null) {
/* 172 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 180 */     argDAO.suppressStateChanges(true);
/* 181 */     PricingHierarchyDAO dao = (PricingHierarchyDAO)argDAO;
/* 182 */     dao.setOrganizationId(this._organizationId);
/* 183 */     dao.setLevelCode(this._levelCode);
/* 184 */     dao.setLevelValue(this._levelValue);
/* 185 */     dao.setCreateDate(this._createDate);
/* 186 */     dao.setCreateUserId(this._createUserId);
/* 187 */     dao.setUpdateDate(this._updateDate);
/* 188 */     dao.setUpdateUserId(this._updateUserId);
/* 189 */     dao.setParentCode(this._parentCode);
/* 190 */     dao.setParentValue(this._parentValue);
/* 191 */     dao.setDescription(this._description);
/* 192 */     dao.setLevelOrder(this._levelOrder);
/* 193 */     dao.setSortOrder(this._sortOrder);
/* 194 */     argDAO.suppressStateChanges(false);
/* 195 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 199 */     return loadDAO((IDataAccessObject)new PricingHierarchyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 203 */     PricingHierarchyDAO dao = (PricingHierarchyDAO)argDAO;
/* 204 */     this._organizationId = dao.getOrganizationId();
/* 205 */     this._levelCode = dao.getLevelCode();
/* 206 */     this._levelValue = dao.getLevelValue();
/* 207 */     this._createDate = dao.getCreateDate();
/* 208 */     this._createUserId = dao.getCreateUserId();
/* 209 */     this._updateDate = dao.getUpdateDate();
/* 210 */     this._updateUserId = dao.getUpdateUserId();
/* 211 */     this._parentCode = dao.getParentCode();
/* 212 */     this._parentValue = dao.getParentValue();
/* 213 */     this._description = dao.getDescription();
/* 214 */     this._levelOrder = dao.getLevelOrder();
/* 215 */     this._sortOrder = dao.getSortOrder();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 219 */     PricingHierarchyId id = (PricingHierarchyId)argId;
/* 220 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 221 */     argStatement.setString(2, id.getLevelCode());
/* 222 */     argStatement.setString(3, id.getLevelValue());
/* 223 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 227 */     PricingHierarchyId id = new PricingHierarchyId();
/* 228 */     id.setOrganizationId(this._organizationId);
/* 229 */     id.setLevelCode(this._levelCode);
/* 230 */     id.setLevelValue(this._levelValue);
/* 231 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 239 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 243 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\PricingHierarchyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */