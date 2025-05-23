/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.MerchandiseHierarchyId;
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
/*     */ public class MerchandiseHierarchyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -746218030L;
/*     */   private String _hierarchyId;
/*     */   private Long _organizationId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _parentId;
/*     */   private String _description;
/*     */   private String _levelCode;
/*     */   private Integer _sortOrder;
/*     */   private Boolean _hidden;
/*     */   private Boolean _disallowItemMatrixDisplay;
/*     */   private String _itemMatrixColor;
/*     */   private static final String SELECT_OBJECT = "SELECT t.hierarchy_id, t.organization_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.parent_id, t.description, t.level_code, t.sort_order, t.hidden_flag, t.disallow_matrix_display_flag, t.item_matrix_color FROM itm_merch_hierarchy t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE hierarchy_id = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.hierarchy_id, t.organization_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.parent_id, t.description, t.level_code, t.sort_order, t.hidden_flag, t.disallow_matrix_display_flag, t.item_matrix_color FROM itm_merch_hierarchy t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE hierarchy_id = ?  AND organization_id = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_merch_hierarchy(hierarchy_id, organization_id, org_code, org_value, create_date, create_user_id, update_date, update_user_id, parent_id, description, level_code, sort_order, hidden_flag, disallow_matrix_display_flag, item_matrix_color) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._hierarchyId, this._organizationId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._parentId, this._description, this._levelCode, this._sortOrder, this._hidden, this._disallowItemMatrixDisplay, this._itemMatrixColor } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 12, 91, 12, 91, 12, 12, 12, 12, 4, -7, -7, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_merch_hierarchy SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, parent_id = ?, description = ?, level_code = ?, sort_order = ?, hidden_flag = ?, disallow_matrix_display_flag = ?, item_matrix_color = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._parentId, this._description, this._levelCode, this._sortOrder, this._hidden, this._disallowItemMatrixDisplay, this._itemMatrixColor } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 12, 12, 12, 4, -7, -7, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_merch_hierarchy" }; private static final String WHERE_OBJECT = " WHERE hierarchy_id = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE hierarchy_id = ?  AND organization_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._hierarchyId, this._organizationId };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "itm_merch_hierarchy";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new MerchandiseHierarchyFiller(this);
/*     */   }
/*     */   
/*     */   private static class MerchandiseHierarchyFiller
/*     */     implements IFiller {
/*     */     private MerchandiseHierarchyDBA _parent;
/*     */     
/*     */     public MerchandiseHierarchyFiller(MerchandiseHierarchyDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       this._parent._hierarchyId = argResultSet.getString(1);
/*     */ 
/*     */       
/* 133 */       long primitiveResult = argResultSet.getLong(2);
/* 134 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 135 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 139 */       this._parent._orgCode = argResultSet.getString(3);
/* 140 */       this._parent._orgValue = argResultSet.getString(4);
/*     */       
/* 142 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 143 */       if (t5 != null) {
/* 144 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 147 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 150 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 152 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 153 */       if (t7 != null) {
/* 154 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._updateUserId = argResultSet.getString(8);
/* 161 */       this._parent._parentId = argResultSet.getString(9);
/* 162 */       this._parent._description = argResultSet.getString(10);
/* 163 */       this._parent._levelCode = argResultSet.getString(11);
/*     */ 
/*     */       
/* 166 */       int i = argResultSet.getInt(12);
/* 167 */       if (i != 0 || argResultSet.getObject(12) != null) {
/* 168 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 172 */       this._parent._hidden = Boolean.valueOf(argResultSet.getBoolean(13));
/* 173 */       this._parent._disallowItemMatrixDisplay = Boolean.valueOf(argResultSet.getBoolean(14));
/* 174 */       this._parent._itemMatrixColor = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 179 */     argDAO.suppressStateChanges(true);
/* 180 */     MerchandiseHierarchyDAO dao = (MerchandiseHierarchyDAO)argDAO;
/* 181 */     dao.setHierarchyId(this._hierarchyId);
/* 182 */     dao.setOrganizationId(this._organizationId);
/* 183 */     dao.setOrgCode(this._orgCode);
/* 184 */     dao.setOrgValue(this._orgValue);
/* 185 */     dao.setCreateDate(this._createDate);
/* 186 */     dao.setCreateUserId(this._createUserId);
/* 187 */     dao.setUpdateDate(this._updateDate);
/* 188 */     dao.setUpdateUserId(this._updateUserId);
/* 189 */     dao.setParentId(this._parentId);
/* 190 */     dao.setDescription(this._description);
/* 191 */     dao.setLevelCode(this._levelCode);
/* 192 */     dao.setSortOrder(this._sortOrder);
/* 193 */     dao.setHidden(this._hidden);
/* 194 */     dao.setDisallowItemMatrixDisplay(this._disallowItemMatrixDisplay);
/* 195 */     dao.setItemMatrixColor(this._itemMatrixColor);
/* 196 */     argDAO.suppressStateChanges(false);
/* 197 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 201 */     return loadDAO((IDataAccessObject)new MerchandiseHierarchyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 205 */     MerchandiseHierarchyDAO dao = (MerchandiseHierarchyDAO)argDAO;
/* 206 */     this._hierarchyId = dao.getHierarchyId();
/* 207 */     this._organizationId = dao.getOrganizationId();
/* 208 */     this._orgCode = dao.getOrgCode();
/* 209 */     this._orgValue = dao.getOrgValue();
/* 210 */     this._createDate = dao.getCreateDate();
/* 211 */     this._createUserId = dao.getCreateUserId();
/* 212 */     this._updateDate = dao.getUpdateDate();
/* 213 */     this._updateUserId = dao.getUpdateUserId();
/* 214 */     this._parentId = dao.getParentId();
/* 215 */     this._description = dao.getDescription();
/* 216 */     this._levelCode = dao.getLevelCode();
/* 217 */     this._sortOrder = dao.getSortOrder();
/* 218 */     this._hidden = (dao.getHidden() != null) ? dao.getHidden() : Boolean.valueOf(false);
/* 219 */     this._disallowItemMatrixDisplay = (dao.getDisallowItemMatrixDisplay() != null) ? dao.getDisallowItemMatrixDisplay() : Boolean.valueOf(false);
/* 220 */     this._itemMatrixColor = dao.getItemMatrixColor();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 224 */     MerchandiseHierarchyId id = (MerchandiseHierarchyId)argId;
/* 225 */     argStatement.setString(1, id.getHierarchyId());
/* 226 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 227 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 231 */     MerchandiseHierarchyId id = new MerchandiseHierarchyId();
/* 232 */     id.setHierarchyId(this._hierarchyId);
/* 233 */     id.setOrganizationId(this._organizationId);
/* 234 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 242 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 246 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\MerchandiseHierarchyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */