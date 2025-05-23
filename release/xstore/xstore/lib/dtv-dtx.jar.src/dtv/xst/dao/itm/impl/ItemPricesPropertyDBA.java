/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemPricesPropertyId;
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
/*     */ public class ItemPricesPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 669021778L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private String _itemPricePropertyCode;
/*     */   private Date _effectiveDate;
/*     */   private BigDecimal _pricingQuantity;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.level_code, t.level_value, t.itm_price_property_code, t.effective_date, t.price_qty, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_prices_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND level_code = ?  AND level_value = ?  AND itm_price_property_code = ?  AND effective_date = ?  AND price_qty = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.organization_id, t.item_id, t.level_code, t.level_value, t.itm_price_property_code, t.effective_date, t.price_qty, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_prices_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE organization_id = ?  AND item_id = ?  AND level_code = ?  AND level_value = ?  AND itm_price_property_code = ?  AND effective_date = ?  AND price_qty = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_prices_p(organization_id, item_id, level_code, level_value, itm_price_property_code, effective_date, price_qty, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, this._levelCode, this._levelValue, this._itemPricePropertyCode, this._effectiveDate, this._pricingQuantity, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 12, 91, 3, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_prices_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_prices_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND level_code = ?  AND level_value = ?  AND itm_price_property_code = ?  AND effective_date = ?  AND price_qty = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE organization_id = ?  AND item_id = ?  AND level_code = ?  AND level_value = ?  AND itm_price_property_code = ?  AND effective_date = ?  AND price_qty = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._organizationId, this._itemId, this._levelCode, this._levelValue, this._itemPricePropertyCode, this._effectiveDate, this._pricingQuantity, this._propertyCode };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12, 12, 91, 3, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "itm_item_prices_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new ItemPricesPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemPricesPropertyFiller
/*     */     implements IFiller {
/*     */     private ItemPricesPropertyDBA _parent;
/*     */     
/*     */     public ItemPricesPropertyFiller(ItemPricesPropertyDBA argParent) {
/* 128 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 133 */       long primitiveResult = argResultSet.getLong(1);
/* 134 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 135 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 139 */       this._parent._itemId = argResultSet.getString(2);
/* 140 */       this._parent._levelCode = argResultSet.getString(3);
/* 141 */       this._parent._levelValue = argResultSet.getString(4);
/* 142 */       this._parent._itemPricePropertyCode = argResultSet.getString(5);
/*     */       
/* 144 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 145 */       if (t6 != null) {
/* 146 */         this._parent._effectiveDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._pricingQuantity = argResultSet.getBigDecimal(7);
/* 153 */       this._parent._propertyCode = argResultSet.getString(8);
/* 154 */       this._parent._type = argResultSet.getString(9);
/* 155 */       this._parent._stringValue = argResultSet.getString(10);
/*     */       
/* 157 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 158 */       if (t11 != null) {
/* 159 */         this._parent._dateValue = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 162 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 165 */       this._parent._decimalValue = argResultSet.getBigDecimal(12);
/*     */       
/* 167 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 168 */       if (t13 != null) {
/* 169 */         this._parent._createDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 175 */       this._parent._createUserId = argResultSet.getString(14);
/*     */       
/* 177 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 178 */       if (t15 != null) {
/* 179 */         this._parent._updateDate = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 182 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 185 */       this._parent._updateUserId = argResultSet.getString(16);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 190 */     argDAO.suppressStateChanges(true);
/* 191 */     ItemPricesPropertyDAO dao = (ItemPricesPropertyDAO)argDAO;
/* 192 */     dao.setOrganizationId(this._organizationId);
/* 193 */     dao.setItemId(this._itemId);
/* 194 */     dao.setLevelCode(this._levelCode);
/* 195 */     dao.setLevelValue(this._levelValue);
/* 196 */     dao.setItemPricePropertyCode(this._itemPricePropertyCode);
/* 197 */     dao.setEffectiveDate(this._effectiveDate);
/* 198 */     dao.setPricingQuantity(this._pricingQuantity);
/* 199 */     dao.setPropertyCode(this._propertyCode);
/* 200 */     dao.setType(this._type);
/* 201 */     dao.setStringValue(this._stringValue);
/* 202 */     dao.setDateValue(this._dateValue);
/* 203 */     dao.setDecimalValue(this._decimalValue);
/* 204 */     dao.setCreateDate(this._createDate);
/* 205 */     dao.setCreateUserId(this._createUserId);
/* 206 */     dao.setUpdateDate(this._updateDate);
/* 207 */     dao.setUpdateUserId(this._updateUserId);
/* 208 */     argDAO.suppressStateChanges(false);
/* 209 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 213 */     return loadDAO((IDataAccessObject)new ItemPricesPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 217 */     ItemPricesPropertyDAO dao = (ItemPricesPropertyDAO)argDAO;
/* 218 */     this._organizationId = dao.getOrganizationId();
/* 219 */     this._itemId = dao.getItemId();
/* 220 */     this._levelCode = dao.getLevelCode();
/* 221 */     this._levelValue = dao.getLevelValue();
/* 222 */     this._itemPricePropertyCode = dao.getItemPricePropertyCode();
/* 223 */     this._effectiveDate = dao.getEffectiveDate();
/* 224 */     this._pricingQuantity = dao.getPricingQuantity();
/* 225 */     this._propertyCode = dao.getPropertyCode();
/* 226 */     this._type = dao.getType();
/* 227 */     this._stringValue = dao.getStringValue();
/* 228 */     this._dateValue = dao.getDateValue();
/* 229 */     this._decimalValue = dao.getDecimalValue();
/* 230 */     this._createDate = dao.getCreateDate();
/* 231 */     this._createUserId = dao.getCreateUserId();
/* 232 */     this._updateDate = dao.getUpdateDate();
/* 233 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 237 */     ItemPricesPropertyId id = (ItemPricesPropertyId)argId;
/* 238 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 239 */     argStatement.setString(2, id.getItemId());
/* 240 */     argStatement.setString(3, id.getLevelCode());
/* 241 */     argStatement.setString(4, id.getLevelValue());
/* 242 */     argStatement.setString(5, id.getItemPricePropertyCode());
/* 243 */     argStatement.setTimestamp(6, new Timestamp(id.getEffectiveDate().getTime()));
/* 244 */     argStatement.setBigDecimal(7, id.getPricingQuantity());
/* 245 */     argStatement.setString(8, id.getPropertyCode());
/* 246 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 250 */     ItemPricesPropertyId id = new ItemPricesPropertyId();
/* 251 */     id.setOrganizationId(this._organizationId);
/* 252 */     id.setItemId(this._itemId);
/* 253 */     id.setLevelCode(this._levelCode);
/* 254 */     id.setLevelValue(this._levelValue);
/* 255 */     id.setItemPricePropertyCode(this._itemPricePropertyCode);
/* 256 */     id.setEffectiveDate(this._effectiveDate);
/* 257 */     id.setPricingQuantity(this._pricingQuantity);
/* 258 */     id.setPropertyCode(this._propertyCode);
/* 259 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 267 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 271 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemPricesPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */