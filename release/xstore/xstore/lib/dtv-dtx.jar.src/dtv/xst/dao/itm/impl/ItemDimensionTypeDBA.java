/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.ItemDimensionTypeId;
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
/*     */ public class ItemDimensionTypeDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -198567603L;
/*     */   private Long _organizationId;
/*     */   private String _dimensionSystem;
/*     */   private String _dimension;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _sequence;
/*     */   private Integer _sortOrder;
/*     */   private String _description;
/*     */   private String _promptMessage;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.dimension_system, t.dimension, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.seq, t.sort_order, t.description, t.prompt_msg FROM itm_item_dimension_type t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND dimension_system = ?  AND dimension = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.dimension_system, t.dimension, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.seq, t.sort_order, t.description, t.prompt_msg FROM itm_item_dimension_type t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND dimension_system = ?  AND dimension = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_dimension_type(organization_id, dimension_system, dimension, org_code, org_value, create_date, create_user_id, update_date, update_user_id, seq, sort_order, description, prompt_msg) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._dimensionSystem, this._dimension, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._sequence, this._sortOrder, this._description, this._promptMessage } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 12, 91, 12, 91, 12, 4, 4, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_dimension_type SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, seq = ?, sort_order = ?, description = ?, prompt_msg = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._sequence, this._sortOrder, this._description, this._promptMessage } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 4, 4, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_dimension_type" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND dimension_system = ?  AND dimension = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND dimension_system = ?  AND dimension = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._dimensionSystem, this._dimension };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "itm_item_dimension_type";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new ItemDimensionTypeFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemDimensionTypeFiller
/*     */     implements IFiller {
/*     */     private ItemDimensionTypeDBA _parent;
/*     */     
/*     */     public ItemDimensionTypeFiller(ItemDimensionTypeDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       long primitiveResult = argResultSet.getLong(1);
/* 131 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 132 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 136 */       this._parent._dimensionSystem = argResultSet.getString(2);
/* 137 */       this._parent._dimension = argResultSet.getString(3);
/* 138 */       this._parent._orgCode = argResultSet.getString(4);
/* 139 */       this._parent._orgValue = argResultSet.getString(5);
/*     */       
/* 141 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 142 */       if (t6 != null) {
/* 143 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 146 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 149 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 151 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 152 */       if (t8 != null) {
/* 153 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._updateUserId = argResultSet.getString(9);
/*     */ 
/*     */       
/* 162 */       int i = argResultSet.getInt(10);
/* 163 */       if (i != 0 || argResultSet.getObject(10) != null) {
/* 164 */         this._parent._sequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 170 */       i = argResultSet.getInt(11);
/* 171 */       if (i != 0 || argResultSet.getObject(11) != null) {
/* 172 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 176 */       this._parent._description = argResultSet.getString(12);
/* 177 */       this._parent._promptMessage = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 182 */     argDAO.suppressStateChanges(true);
/* 183 */     ItemDimensionTypeDAO dao = (ItemDimensionTypeDAO)argDAO;
/* 184 */     dao.setOrganizationId(this._organizationId);
/* 185 */     dao.setDimensionSystem(this._dimensionSystem);
/* 186 */     dao.setDimension(this._dimension);
/* 187 */     dao.setOrgCode(this._orgCode);
/* 188 */     dao.setOrgValue(this._orgValue);
/* 189 */     dao.setCreateDate(this._createDate);
/* 190 */     dao.setCreateUserId(this._createUserId);
/* 191 */     dao.setUpdateDate(this._updateDate);
/* 192 */     dao.setUpdateUserId(this._updateUserId);
/* 193 */     dao.setSequence(this._sequence);
/* 194 */     dao.setSortOrder(this._sortOrder);
/* 195 */     dao.setDescription(this._description);
/* 196 */     dao.setPromptMessage(this._promptMessage);
/* 197 */     argDAO.suppressStateChanges(false);
/* 198 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 202 */     return loadDAO((IDataAccessObject)new ItemDimensionTypeDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 206 */     ItemDimensionTypeDAO dao = (ItemDimensionTypeDAO)argDAO;
/* 207 */     this._organizationId = dao.getOrganizationId();
/* 208 */     this._dimensionSystem = dao.getDimensionSystem();
/* 209 */     this._dimension = dao.getDimension();
/* 210 */     this._orgCode = dao.getOrgCode();
/* 211 */     this._orgValue = dao.getOrgValue();
/* 212 */     this._createDate = dao.getCreateDate();
/* 213 */     this._createUserId = dao.getCreateUserId();
/* 214 */     this._updateDate = dao.getUpdateDate();
/* 215 */     this._updateUserId = dao.getUpdateUserId();
/* 216 */     this._sequence = dao.getSequence();
/* 217 */     this._sortOrder = dao.getSortOrder();
/* 218 */     this._description = dao.getDescription();
/* 219 */     this._promptMessage = dao.getPromptMessage();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 223 */     ItemDimensionTypeId id = (ItemDimensionTypeId)argId;
/* 224 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 225 */     argStatement.setString(2, id.getDimensionSystem());
/* 226 */     argStatement.setString(3, id.getDimension());
/* 227 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 231 */     ItemDimensionTypeId id = new ItemDimensionTypeId();
/* 232 */     id.setOrganizationId(this._organizationId);
/* 233 */     id.setDimensionSystem(this._dimensionSystem);
/* 234 */     id.setDimension(this._dimension);
/* 235 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 243 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 247 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemDimensionTypeDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */