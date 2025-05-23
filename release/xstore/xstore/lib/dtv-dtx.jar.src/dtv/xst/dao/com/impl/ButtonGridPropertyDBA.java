/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.ButtonGridPropertyId;
/*     */ import java.math.BigDecimal;
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
/*     */ public class ButtonGridPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 970597293L;
/*     */   private Long _organizationId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private String _gridId;
/*     */   private Integer _rowId;
/*     */   private Integer _columnId;
/*     */   private String _componentId;
/*     */   private Integer _sortOrder;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.level_code, t.level_value, t.grid_id, t.row_id, t.column_id, t.component_id, t.sort_order, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM com_button_grid_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND level_code = ?  AND level_value = ?  AND grid_id = ?  AND row_id = ?  AND column_id = ?  AND component_id = ?  AND sort_order = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.organization_id, t.level_code, t.level_value, t.grid_id, t.row_id, t.column_id, t.component_id, t.sort_order, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM com_button_grid_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE organization_id = ?  AND level_code = ?  AND level_value = ?  AND grid_id = ?  AND row_id = ?  AND column_id = ?  AND component_id = ?  AND sort_order = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_button_grid_p(organization_id, level_code, level_value, grid_id, row_id, column_id, component_id, sort_order, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._organizationId, this._levelCode, this._levelValue, this._gridId, this._rowId, this._columnId, this._componentId, this._sortOrder, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 4, 4, 12, 4, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_button_grid_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_button_grid_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND level_code = ?  AND level_value = ?  AND grid_id = ?  AND row_id = ?  AND column_id = ?  AND component_id = ?  AND sort_order = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " WHERE organization_id = ?  AND level_code = ?  AND level_value = ?  AND grid_id = ?  AND row_id = ?  AND column_id = ?  AND component_id = ?  AND sort_order = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[] { this._organizationId, this._levelCode, this._levelValue, this._gridId, this._rowId, this._columnId, this._componentId, this._sortOrder, this._propertyCode };
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12, 4, 4, 12, 4, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "com_button_grid_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new ButtonGridPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class ButtonGridPropertyFiller
/*     */     implements IFiller {
/*     */     private ButtonGridPropertyDBA _parent;
/*     */     
/*     */     public ButtonGridPropertyFiller(ButtonGridPropertyDBA argParent) {
/* 129 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 134 */       long l = argResultSet.getLong(1);
/* 135 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 136 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 140 */       this._parent._levelCode = argResultSet.getString(2);
/* 141 */       this._parent._levelValue = argResultSet.getString(3);
/* 142 */       this._parent._gridId = argResultSet.getString(4);
/*     */ 
/*     */       
/* 145 */       int primitiveResult = argResultSet.getInt(5);
/* 146 */       if (primitiveResult != 0 || argResultSet.getObject(5) != null) {
/* 147 */         this._parent._rowId = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 153 */       primitiveResult = argResultSet.getInt(6);
/* 154 */       if (primitiveResult != 0 || argResultSet.getObject(6) != null) {
/* 155 */         this._parent._columnId = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 159 */       this._parent._componentId = argResultSet.getString(7);
/*     */ 
/*     */       
/* 162 */       primitiveResult = argResultSet.getInt(8);
/* 163 */       if (primitiveResult != 0 || argResultSet.getObject(8) != null) {
/* 164 */         this._parent._sortOrder = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 168 */       this._parent._propertyCode = argResultSet.getString(9);
/* 169 */       this._parent._type = argResultSet.getString(10);
/* 170 */       this._parent._stringValue = argResultSet.getString(11);
/*     */       
/* 172 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 173 */       if (t12 != null) {
/* 174 */         this._parent._dateValue = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 177 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 180 */       this._parent._decimalValue = argResultSet.getBigDecimal(13);
/*     */       
/* 182 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 183 */       if (t14 != null) {
/* 184 */         this._parent._createDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 187 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 190 */       this._parent._createUserId = argResultSet.getString(15);
/*     */       
/* 192 */       Timestamp t16 = argResultSet.getTimestamp(16);
/* 193 */       if (t16 != null) {
/* 194 */         this._parent._updateDate = (Date)new DtvDate(t16.getTime());
/*     */       } else {
/*     */         
/* 197 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 200 */       this._parent._updateUserId = argResultSet.getString(17);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 205 */     argDAO.suppressStateChanges(true);
/* 206 */     ButtonGridPropertyDAO dao = (ButtonGridPropertyDAO)argDAO;
/* 207 */     dao.setOrganizationId(this._organizationId);
/* 208 */     dao.setLevelCode(this._levelCode);
/* 209 */     dao.setLevelValue(this._levelValue);
/* 210 */     dao.setGridId(this._gridId);
/* 211 */     dao.setRowId(this._rowId);
/* 212 */     dao.setColumnId(this._columnId);
/* 213 */     dao.setComponentId(this._componentId);
/* 214 */     dao.setSortOrder(this._sortOrder);
/* 215 */     dao.setPropertyCode(this._propertyCode);
/* 216 */     dao.setType(this._type);
/* 217 */     dao.setStringValue(this._stringValue);
/* 218 */     dao.setDateValue(this._dateValue);
/* 219 */     dao.setDecimalValue(this._decimalValue);
/* 220 */     dao.setCreateDate(this._createDate);
/* 221 */     dao.setCreateUserId(this._createUserId);
/* 222 */     dao.setUpdateDate(this._updateDate);
/* 223 */     dao.setUpdateUserId(this._updateUserId);
/* 224 */     argDAO.suppressStateChanges(false);
/* 225 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 229 */     return loadDAO((IDataAccessObject)new ButtonGridPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 233 */     ButtonGridPropertyDAO dao = (ButtonGridPropertyDAO)argDAO;
/* 234 */     this._organizationId = dao.getOrganizationId();
/* 235 */     this._levelCode = dao.getLevelCode();
/* 236 */     this._levelValue = dao.getLevelValue();
/* 237 */     this._gridId = dao.getGridId();
/* 238 */     this._rowId = dao.getRowId();
/* 239 */     this._columnId = dao.getColumnId();
/* 240 */     this._componentId = dao.getComponentId();
/* 241 */     this._sortOrder = dao.getSortOrder();
/* 242 */     this._propertyCode = dao.getPropertyCode();
/* 243 */     this._type = dao.getType();
/* 244 */     this._stringValue = dao.getStringValue();
/* 245 */     this._dateValue = dao.getDateValue();
/* 246 */     this._decimalValue = dao.getDecimalValue();
/* 247 */     this._createDate = dao.getCreateDate();
/* 248 */     this._createUserId = dao.getCreateUserId();
/* 249 */     this._updateDate = dao.getUpdateDate();
/* 250 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 254 */     ButtonGridPropertyId id = (ButtonGridPropertyId)argId;
/* 255 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 256 */     argStatement.setString(2, id.getLevelCode());
/* 257 */     argStatement.setString(3, id.getLevelValue());
/* 258 */     argStatement.setString(4, id.getGridId());
/* 259 */     argStatement.setInt(5, id.getRowId().intValue());
/* 260 */     argStatement.setInt(6, id.getColumnId().intValue());
/* 261 */     argStatement.setString(7, id.getComponentId());
/* 262 */     argStatement.setInt(8, id.getSortOrder().intValue());
/* 263 */     argStatement.setString(9, id.getPropertyCode());
/* 264 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 268 */     ButtonGridPropertyId id = new ButtonGridPropertyId();
/* 269 */     id.setOrganizationId(this._organizationId);
/* 270 */     id.setLevelCode(this._levelCode);
/* 271 */     id.setLevelValue(this._levelValue);
/* 272 */     id.setGridId(this._gridId);
/* 273 */     id.setRowId(this._rowId);
/* 274 */     id.setColumnId(this._columnId);
/* 275 */     id.setComponentId(this._componentId);
/* 276 */     id.setSortOrder(this._sortOrder);
/* 277 */     id.setPropertyCode(this._propertyCode);
/* 278 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 286 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 290 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ButtonGridPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */