/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.ItemId;
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
/*     */ public class ItemDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 2289459L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _className;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _description;
/*     */   private String _itemLevelCode;
/*     */   private String _itemTypeCode;
/*     */   private String _merchLevel1Id;
/*     */   private String _merchLevel2Id;
/*     */   private String _merchLevel3Id;
/*     */   private String _merchLevel4Id;
/*     */   private Boolean _serializedItem;
/*     */   private String _parentItemId;
/*     */   private String _name;
/*     */   private Boolean _disallowItemMatrixDisplay;
/*     */   private String _itemMatrixColor;
/*     */   private String _dimensionSystem;
/*     */   private String _dimension1;
/*     */   private String _dimension2;
/*     */   private String _dimension3;
/*     */   private BigDecimal _listPrice;
/*     */   private Boolean _measurementRequired;
/*     */   private Boolean _notInventoried;
/*     */   private String _externalSystem;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.dtv_class_name, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.description, t.item_lvlcode, t.item_typcode, t.merch_level_1, t.merch_level_2, t.merch_level_3, t.merch_level_4, t.serialized_item_flag, t.parent_item_id, t.name, t.disallow_matrix_display_flag, t.item_matrix_color, t.dimension_system, t.dimension1, t.dimension2, t.dimension3, t.list_price, t.measure_req_flag, t.not_inventoried_flag, t.external_system FROM itm_item t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  58 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  62 */     return "SELECT t.organization_id, t.item_id, t.dtv_class_name, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.description, t.item_lvlcode, t.item_typcode, t.merch_level_1, t.merch_level_2, t.merch_level_3, t.merch_level_4, t.serialized_item_flag, t.parent_item_id, t.name, t.disallow_matrix_display_flag, t.item_matrix_color, t.dimension_system, t.dimension1, t.dimension2, t.dimension3, t.list_price, t.measure_req_flag, t.not_inventoried_flag, t.external_system FROM itm_item t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  68 */     return " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   
/*  71 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item(organization_id, item_id, dtv_class_name, create_date, create_user_id, update_date, update_user_id, org_code, org_value, description, item_lvlcode, item_typcode, merch_level_1, merch_level_2, merch_level_3, merch_level_4, serialized_item_flag, parent_item_id, name, disallow_matrix_display_flag, item_matrix_color, dimension_system, dimension1, dimension2, dimension3, list_price, measure_req_flag, not_inventoried_flag, external_system) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  74 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  78 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, this._className, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._description, this._itemLevelCode, this._itemTypeCode, this._merchLevel1Id, this._merchLevel2Id, this._merchLevel3Id, this._merchLevel4Id, this._serializedItem, this._parentItemId, this._name, this._disallowItemMatrixDisplay, this._itemMatrixColor, this._dimensionSystem, this._dimension1, this._dimension2, this._dimension3, this._listPrice, this._measurementRequired, this._notInventoried, this._externalSystem } };
/*  79 */     return insertParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, -7, 12, 12, -7, 12, 12, 12, 12, 12, 3, -7, -7, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  85 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item SET dtv_class_name = ?, update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, description = ?, item_lvlcode = ?, item_typcode = ?, merch_level_1 = ?, merch_level_2 = ?, merch_level_3 = ?, merch_level_4 = ?, serialized_item_flag = ?, parent_item_id = ?, name = ?, disallow_matrix_display_flag = ?, item_matrix_color = ?, dimension_system = ?, dimension1 = ?, dimension2 = ?, dimension3 = ?, list_price = ?, measure_req_flag = ?, not_inventoried_flag = ?, external_system = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  91 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  95 */     Object[][] updateParameterObject = { { this._className, this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._description, this._itemLevelCode, this._itemTypeCode, this._merchLevel1Id, this._merchLevel2Id, this._merchLevel3Id, this._merchLevel4Id, this._serializedItem, this._parentItemId, this._name, this._disallowItemMatrixDisplay, this._itemMatrixColor, this._dimensionSystem, this._dimension1, this._dimension2, this._dimension3, this._listPrice, this._measurementRequired, this._notInventoried, this._externalSystem } };
/*  96 */     return updateParameterObject;
/*     */   }
/*     */   
/*  99 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, -7, 12, 12, -7, 12, 12, 12, 12, 12, 3, -7, -7, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 101 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 104 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 107 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 113 */     return " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 116 */     return new Object[] { this._organizationId, this._itemId };
/*     */   }
/*     */   
/* 119 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 122 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 125 */     return "itm_item";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 129 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 133 */     return new ItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemFiller
/*     */     implements IFiller {
/*     */     private ItemDBA _parent;
/*     */     
/*     */     public ItemFiller(ItemDBA argParent) {
/* 141 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 146 */       long primitiveResult = argResultSet.getLong(1);
/* 147 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 148 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 152 */       this._parent._itemId = argResultSet.getString(2);
/* 153 */       this._parent._className = argResultSet.getString(3);
/*     */       
/* 155 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 156 */       if (t4 != null) {
/* 157 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 165 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 166 */       if (t6 != null) {
/* 167 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._updateUserId = argResultSet.getString(7);
/* 174 */       this._parent._orgCode = argResultSet.getString(8);
/* 175 */       this._parent._orgValue = argResultSet.getString(9);
/* 176 */       this._parent._description = argResultSet.getString(10);
/* 177 */       this._parent._itemLevelCode = argResultSet.getString(11);
/* 178 */       this._parent._itemTypeCode = argResultSet.getString(12);
/* 179 */       this._parent._merchLevel1Id = argResultSet.getString(13);
/* 180 */       this._parent._merchLevel2Id = argResultSet.getString(14);
/* 181 */       this._parent._merchLevel3Id = argResultSet.getString(15);
/* 182 */       this._parent._merchLevel4Id = argResultSet.getString(16);
/* 183 */       this._parent._serializedItem = Boolean.valueOf(argResultSet.getBoolean(17));
/* 184 */       this._parent._parentItemId = argResultSet.getString(18);
/* 185 */       this._parent._name = argResultSet.getString(19);
/* 186 */       this._parent._disallowItemMatrixDisplay = Boolean.valueOf(argResultSet.getBoolean(20));
/* 187 */       this._parent._itemMatrixColor = argResultSet.getString(21);
/* 188 */       this._parent._dimensionSystem = argResultSet.getString(22);
/* 189 */       this._parent._dimension1 = argResultSet.getString(23);
/* 190 */       this._parent._dimension2 = argResultSet.getString(24);
/* 191 */       this._parent._dimension3 = argResultSet.getString(25);
/* 192 */       this._parent._listPrice = argResultSet.getBigDecimal(26);
/* 193 */       this._parent._measurementRequired = Boolean.valueOf(argResultSet.getBoolean(27));
/* 194 */       this._parent._notInventoried = Boolean.valueOf(argResultSet.getBoolean(28));
/* 195 */       this._parent._externalSystem = argResultSet.getString(29);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 200 */     argDAO.suppressStateChanges(true);
/* 201 */     ItemDAO dao = (ItemDAO)argDAO;
/* 202 */     dao.setOrganizationId(this._organizationId);
/* 203 */     dao.setItemId(this._itemId);
/* 204 */     dao.setClassName(this._className);
/* 205 */     dao.setCreateDate(this._createDate);
/* 206 */     dao.setCreateUserId(this._createUserId);
/* 207 */     dao.setUpdateDate(this._updateDate);
/* 208 */     dao.setUpdateUserId(this._updateUserId);
/* 209 */     dao.setOrgCode(this._orgCode);
/* 210 */     dao.setOrgValue(this._orgValue);
/* 211 */     dao.setDescription(this._description);
/* 212 */     dao.setItemLevelCode(this._itemLevelCode);
/* 213 */     dao.setItemTypeCode(this._itemTypeCode);
/* 214 */     dao.setMerchLevel1Id(this._merchLevel1Id);
/* 215 */     dao.setMerchLevel2Id(this._merchLevel2Id);
/* 216 */     dao.setMerchLevel3Id(this._merchLevel3Id);
/* 217 */     dao.setMerchLevel4Id(this._merchLevel4Id);
/* 218 */     dao.setSerializedItem(this._serializedItem);
/* 219 */     dao.setParentItemId(this._parentItemId);
/* 220 */     dao.setName(this._name);
/* 221 */     dao.setDisallowItemMatrixDisplay(this._disallowItemMatrixDisplay);
/* 222 */     dao.setItemMatrixColor(this._itemMatrixColor);
/* 223 */     dao.setDimensionSystem(this._dimensionSystem);
/* 224 */     dao.setDimension1(this._dimension1);
/* 225 */     dao.setDimension2(this._dimension2);
/* 226 */     dao.setDimension3(this._dimension3);
/* 227 */     dao.setListPrice(this._listPrice);
/* 228 */     dao.setMeasurementRequired(this._measurementRequired);
/* 229 */     dao.setNotInventoried(this._notInventoried);
/* 230 */     dao.setExternalSystem(this._externalSystem);
/* 231 */     argDAO.suppressStateChanges(false);
/* 232 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 236 */     return loadDAO((IDataAccessObject)new ItemDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 240 */     ItemDAO dao = (ItemDAO)argDAO;
/* 241 */     this._organizationId = dao.getOrganizationId();
/* 242 */     this._itemId = dao.getItemId();
/* 243 */     this._className = dao.getClassName();
/* 244 */     this._createDate = dao.getCreateDate();
/* 245 */     this._createUserId = dao.getCreateUserId();
/* 246 */     this._updateDate = dao.getUpdateDate();
/* 247 */     this._updateUserId = dao.getUpdateUserId();
/* 248 */     this._orgCode = dao.getOrgCode();
/* 249 */     this._orgValue = dao.getOrgValue();
/* 250 */     this._description = dao.getDescription();
/* 251 */     this._itemLevelCode = dao.getItemLevelCode();
/* 252 */     this._itemTypeCode = dao.getItemTypeCode();
/* 253 */     this._merchLevel1Id = dao.getMerchLevel1Id();
/* 254 */     this._merchLevel2Id = dao.getMerchLevel2Id();
/* 255 */     this._merchLevel3Id = dao.getMerchLevel3Id();
/* 256 */     this._merchLevel4Id = dao.getMerchLevel4Id();
/* 257 */     this._serializedItem = (dao.getSerializedItem() != null) ? dao.getSerializedItem() : Boolean.valueOf(false);
/* 258 */     this._parentItemId = dao.getParentItemId();
/* 259 */     this._name = dao.getName();
/* 260 */     this._disallowItemMatrixDisplay = (dao.getDisallowItemMatrixDisplay() != null) ? dao.getDisallowItemMatrixDisplay() : Boolean.valueOf(false);
/* 261 */     this._itemMatrixColor = dao.getItemMatrixColor();
/* 262 */     this._dimensionSystem = dao.getDimensionSystem();
/* 263 */     this._dimension1 = dao.getDimension1();
/* 264 */     this._dimension2 = dao.getDimension2();
/* 265 */     this._dimension3 = dao.getDimension3();
/* 266 */     this._listPrice = dao.getListPrice();
/* 267 */     this._measurementRequired = (dao.getMeasurementRequired() != null) ? dao.getMeasurementRequired() : Boolean.valueOf(false);
/* 268 */     this._notInventoried = (dao.getNotInventoried() != null) ? dao.getNotInventoried() : Boolean.valueOf(false);
/* 269 */     this._externalSystem = dao.getExternalSystem();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 273 */     ItemId id = (ItemId)argId;
/* 274 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 275 */     argStatement.setString(2, id.getItemId());
/* 276 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 280 */     ItemId id = new ItemId();
/* 281 */     id.setOrganizationId(this._organizationId);
/* 282 */     id.setItemId(this._itemId);
/* 283 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {
/* 287 */     ItemDBA adapter = (ItemDBA)argAdapter;
/* 288 */     this._organizationId = adapter._organizationId;
/* 289 */     this._itemId = adapter._itemId;
/* 290 */     this._className = adapter._className;
/* 291 */     this._createDate = adapter._createDate;
/* 292 */     this._createUserId = adapter._createUserId;
/* 293 */     this._updateDate = adapter._updateDate;
/* 294 */     this._updateUserId = adapter._updateUserId;
/* 295 */     this._orgCode = adapter._orgCode;
/* 296 */     this._orgValue = adapter._orgValue;
/* 297 */     this._description = adapter._description;
/* 298 */     this._itemLevelCode = adapter._itemLevelCode;
/* 299 */     this._itemTypeCode = adapter._itemTypeCode;
/* 300 */     this._merchLevel1Id = adapter._merchLevel1Id;
/* 301 */     this._merchLevel2Id = adapter._merchLevel2Id;
/* 302 */     this._merchLevel3Id = adapter._merchLevel3Id;
/* 303 */     this._merchLevel4Id = adapter._merchLevel4Id;
/* 304 */     this._serializedItem = adapter._serializedItem;
/* 305 */     this._parentItemId = adapter._parentItemId;
/* 306 */     this._name = adapter._name;
/* 307 */     this._disallowItemMatrixDisplay = adapter._disallowItemMatrixDisplay;
/* 308 */     this._itemMatrixColor = adapter._itemMatrixColor;
/* 309 */     this._dimensionSystem = adapter._dimensionSystem;
/* 310 */     this._dimension1 = adapter._dimension1;
/* 311 */     this._dimension2 = adapter._dimension2;
/* 312 */     this._dimension3 = adapter._dimension3;
/* 313 */     this._listPrice = adapter._listPrice;
/* 314 */     this._measurementRequired = adapter._measurementRequired;
/* 315 */     this._notInventoried = adapter._notInventoried;
/* 316 */     this._externalSystem = adapter._externalSystem;
/*     */   }
/*     */   
/*     */   public boolean isExtensible() {
/* 320 */     return true;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 324 */     return this._className;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */