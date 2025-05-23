/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.ItemDimensionValueId;
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
/*     */ public class ItemDimensionValueDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1859499586L;
/*     */   private Long _organizationId;
/*     */   private String _dimensionSystem;
/*     */   private String _dimension;
/*     */   private String _dimensionValue;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _sortOrder;
/*     */   private String _description;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.dimension_system, t.dimension, t.value, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.sort_order, t.description FROM itm_item_dimension_value t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND dimension_system = ?  AND dimension = ?  AND value = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.dimension_system, t.dimension, t.value, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.sort_order, t.description FROM itm_item_dimension_value t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND dimension_system = ?  AND dimension = ?  AND value = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_dimension_value(organization_id, dimension_system, dimension, value, org_code, org_value, create_date, create_user_id, update_date, update_user_id, sort_order, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._dimensionSystem, this._dimension, this._dimensionValue, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._sortOrder, this._description } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 12, 12, 91, 12, 91, 12, 4, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_dimension_value SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, sort_order = ?, description = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._sortOrder, this._description } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 4, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_dimension_value" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND dimension_system = ?  AND dimension = ?  AND value = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND dimension_system = ?  AND dimension = ?  AND value = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._dimensionSystem, this._dimension, this._dimensionValue };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "itm_item_dimension_value";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new ItemDimensionValueFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemDimensionValueFiller
/*     */     implements IFiller {
/*     */     private ItemDimensionValueDBA _parent;
/*     */     
/*     */     public ItemDimensionValueFiller(ItemDimensionValueDBA argParent) {
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
/* 135 */       this._parent._dimensionSystem = argResultSet.getString(2);
/* 136 */       this._parent._dimension = argResultSet.getString(3);
/* 137 */       this._parent._dimensionValue = argResultSet.getString(4);
/* 138 */       this._parent._orgCode = argResultSet.getString(5);
/* 139 */       this._parent._orgValue = argResultSet.getString(6);
/*     */       
/* 141 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 142 */       if (t7 != null) {
/* 143 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 146 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 149 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 151 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 152 */       if (t9 != null) {
/* 153 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._updateUserId = argResultSet.getString(10);
/*     */ 
/*     */       
/* 162 */       int i = argResultSet.getInt(11);
/* 163 */       if (i != 0 || argResultSet.getObject(11) != null) {
/* 164 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 168 */       this._parent._description = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 173 */     argDAO.suppressStateChanges(true);
/* 174 */     ItemDimensionValueDAO dao = (ItemDimensionValueDAO)argDAO;
/* 175 */     dao.setOrganizationId(this._organizationId);
/* 176 */     dao.setDimensionSystem(this._dimensionSystem);
/* 177 */     dao.setDimension(this._dimension);
/* 178 */     dao.setDimensionValue(this._dimensionValue);
/* 179 */     dao.setOrgCode(this._orgCode);
/* 180 */     dao.setOrgValue(this._orgValue);
/* 181 */     dao.setCreateDate(this._createDate);
/* 182 */     dao.setCreateUserId(this._createUserId);
/* 183 */     dao.setUpdateDate(this._updateDate);
/* 184 */     dao.setUpdateUserId(this._updateUserId);
/* 185 */     dao.setSortOrder(this._sortOrder);
/* 186 */     dao.setDescription(this._description);
/* 187 */     argDAO.suppressStateChanges(false);
/* 188 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 192 */     return loadDAO((IDataAccessObject)new ItemDimensionValueDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 196 */     ItemDimensionValueDAO dao = (ItemDimensionValueDAO)argDAO;
/* 197 */     this._organizationId = dao.getOrganizationId();
/* 198 */     this._dimensionSystem = dao.getDimensionSystem();
/* 199 */     this._dimension = dao.getDimension();
/* 200 */     this._dimensionValue = dao.getDimensionValue();
/* 201 */     this._orgCode = dao.getOrgCode();
/* 202 */     this._orgValue = dao.getOrgValue();
/* 203 */     this._createDate = dao.getCreateDate();
/* 204 */     this._createUserId = dao.getCreateUserId();
/* 205 */     this._updateDate = dao.getUpdateDate();
/* 206 */     this._updateUserId = dao.getUpdateUserId();
/* 207 */     this._sortOrder = dao.getSortOrder();
/* 208 */     this._description = dao.getDescription();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 212 */     ItemDimensionValueId id = (ItemDimensionValueId)argId;
/* 213 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 214 */     argStatement.setString(2, id.getDimensionSystem());
/* 215 */     argStatement.setString(3, id.getDimension());
/* 216 */     argStatement.setString(4, id.getDimensionValue());
/* 217 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 221 */     ItemDimensionValueId id = new ItemDimensionValueId();
/* 222 */     id.setOrganizationId(this._organizationId);
/* 223 */     id.setDimensionSystem(this._dimensionSystem);
/* 224 */     id.setDimension(this._dimension);
/* 225 */     id.setDimensionValue(this._dimensionValue);
/* 226 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 234 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 238 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemDimensionValueDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */