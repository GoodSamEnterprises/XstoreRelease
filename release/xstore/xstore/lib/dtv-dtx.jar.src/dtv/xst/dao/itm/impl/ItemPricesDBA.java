/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemPricesId;
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
/*     */ public class ItemPricesDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -389226147L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private String _itemPricePropertyCode;
/*     */   private Date _effectiveDate;
/*     */   private BigDecimal _pricingQuantity;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _expirationDate;
/*     */   private BigDecimal _price;
/*     */   private String _externalId;
/*     */   private String _externalSystem;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.level_code, t.level_value, t.itm_price_property_code, t.effective_date, t.price_qty, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.expiration_date, t.price, t.external_id, t.external_system FROM itm_item_prices t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND level_code = ?  AND level_value = ?  AND itm_price_property_code = ?  AND effective_date = ?  AND price_qty = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.item_id, t.level_code, t.level_value, t.itm_price_property_code, t.effective_date, t.price_qty, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.expiration_date, t.price, t.external_id, t.external_system FROM itm_item_prices t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND item_id = ?  AND level_code = ?  AND level_value = ?  AND itm_price_property_code = ?  AND effective_date = ?  AND price_qty = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_prices(organization_id, item_id, level_code, level_value, itm_price_property_code, effective_date, price_qty, create_date, create_user_id, update_date, update_user_id, expiration_date, price, external_id, external_system) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, this._levelCode, this._levelValue, this._itemPricePropertyCode, this._effectiveDate, this._pricingQuantity, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._expirationDate, this._price, this._externalId, this._externalSystem } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 12, 91, 3, 91, 12, 91, 12, 91, 3, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_prices SET update_date = ?, update_user_id = ?, expiration_date = ?, price = ?, external_id = ?, external_system = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._expirationDate, this._price, this._externalId, this._externalSystem } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 3, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_prices" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND level_code = ?  AND level_value = ?  AND itm_price_property_code = ?  AND effective_date = ?  AND price_qty = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND item_id = ?  AND level_code = ?  AND level_value = ?  AND itm_price_property_code = ?  AND effective_date = ?  AND price_qty = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._itemId, this._levelCode, this._levelValue, this._itemPricePropertyCode, this._effectiveDate, this._pricingQuantity };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12, 12, 91, 3 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "itm_item_prices";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new ItemPricesFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemPricesFiller
/*     */     implements IFiller {
/*     */     private ItemPricesDBA _parent;
/*     */     
/*     */     public ItemPricesFiller(ItemPricesDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 132 */       long primitiveResult = argResultSet.getLong(1);
/* 133 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 134 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 138 */       this._parent._itemId = argResultSet.getString(2);
/* 139 */       this._parent._levelCode = argResultSet.getString(3);
/* 140 */       this._parent._levelValue = argResultSet.getString(4);
/* 141 */       this._parent._itemPricePropertyCode = argResultSet.getString(5);
/*     */       
/* 143 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 144 */       if (t6 != null) {
/* 145 */         this._parent._effectiveDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 148 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */       
/* 151 */       this._parent._pricingQuantity = argResultSet.getBigDecimal(7);
/*     */       
/* 153 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 154 */       if (t8 != null) {
/* 155 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 158 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 161 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 163 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 164 */       if (t10 != null) {
/* 165 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 168 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 171 */       this._parent._updateUserId = argResultSet.getString(11);
/*     */       
/* 173 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 174 */       if (t12 != null) {
/* 175 */         this._parent._expirationDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 178 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 181 */       this._parent._price = argResultSet.getBigDecimal(13);
/* 182 */       this._parent._externalId = argResultSet.getString(14);
/* 183 */       this._parent._externalSystem = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 188 */     argDAO.suppressStateChanges(true);
/* 189 */     ItemPricesDAO dao = (ItemPricesDAO)argDAO;
/* 190 */     dao.setOrganizationId(this._organizationId);
/* 191 */     dao.setItemId(this._itemId);
/* 192 */     dao.setLevelCode(this._levelCode);
/* 193 */     dao.setLevelValue(this._levelValue);
/* 194 */     dao.setItemPricePropertyCode(this._itemPricePropertyCode);
/* 195 */     dao.setEffectiveDate(this._effectiveDate);
/* 196 */     dao.setPricingQuantity(this._pricingQuantity);
/* 197 */     dao.setCreateDate(this._createDate);
/* 198 */     dao.setCreateUserId(this._createUserId);
/* 199 */     dao.setUpdateDate(this._updateDate);
/* 200 */     dao.setUpdateUserId(this._updateUserId);
/* 201 */     dao.setExpirationDate(this._expirationDate);
/* 202 */     dao.setPrice(this._price);
/* 203 */     dao.setExternalId(this._externalId);
/* 204 */     dao.setExternalSystem(this._externalSystem);
/* 205 */     argDAO.suppressStateChanges(false);
/* 206 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 210 */     return loadDAO((IDataAccessObject)new ItemPricesDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 214 */     ItemPricesDAO dao = (ItemPricesDAO)argDAO;
/* 215 */     this._organizationId = dao.getOrganizationId();
/* 216 */     this._itemId = dao.getItemId();
/* 217 */     this._levelCode = dao.getLevelCode();
/* 218 */     this._levelValue = dao.getLevelValue();
/* 219 */     this._itemPricePropertyCode = dao.getItemPricePropertyCode();
/* 220 */     this._effectiveDate = dao.getEffectiveDate();
/* 221 */     this._pricingQuantity = dao.getPricingQuantity();
/* 222 */     this._createDate = dao.getCreateDate();
/* 223 */     this._createUserId = dao.getCreateUserId();
/* 224 */     this._updateDate = dao.getUpdateDate();
/* 225 */     this._updateUserId = dao.getUpdateUserId();
/* 226 */     this._expirationDate = dao.getExpirationDate();
/* 227 */     this._price = dao.getPrice();
/* 228 */     this._externalId = dao.getExternalId();
/* 229 */     this._externalSystem = dao.getExternalSystem();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 233 */     ItemPricesId id = (ItemPricesId)argId;
/* 234 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 235 */     argStatement.setString(2, id.getItemId());
/* 236 */     argStatement.setString(3, id.getLevelCode());
/* 237 */     argStatement.setString(4, id.getLevelValue());
/* 238 */     argStatement.setString(5, id.getItemPricePropertyCode());
/* 239 */     argStatement.setTimestamp(6, new Timestamp(id.getEffectiveDate().getTime()));
/* 240 */     argStatement.setBigDecimal(7, id.getPricingQuantity());
/* 241 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 245 */     ItemPricesId id = new ItemPricesId();
/* 246 */     id.setOrganizationId(this._organizationId);
/* 247 */     id.setItemId(this._itemId);
/* 248 */     id.setLevelCode(this._levelCode);
/* 249 */     id.setLevelValue(this._levelValue);
/* 250 */     id.setItemPricePropertyCode(this._itemPricePropertyCode);
/* 251 */     id.setEffectiveDate(this._effectiveDate);
/* 252 */     id.setPricingQuantity(this._pricingQuantity);
/* 253 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 261 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 265 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemPricesDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */