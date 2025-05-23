/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemOptionsId;
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
/*     */ public class ItemOptionsDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -115523605L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Boolean _applyRestockingFee;
/*     */   private Boolean _attachedItems;
/*     */   private BigDecimal _compareAtPrice;
/*     */   private Boolean _disallowDiscounts;
/*     */   private Boolean _disallowDeals;
/*     */   private Boolean _disallowPriceChange;
/*     */   private Boolean _disallowSendSale;
/*     */   private Boolean _disallowCommission;
/*     */   private Boolean _disallowLayaway;
/*     */   private Boolean _disallowWorkOrder;
/*     */   private Boolean _disallowSpecialOrder;
/*     */   private Boolean _disallowOrder;
/*     */   private Boolean _disallowRainCheck;
/*     */   private Boolean _forceQuantityOfOne;
/*     */   private BigDecimal _maximumSaleUnitCount;
/*     */   private BigDecimal _minimumSaleUnitCount;
/*     */   private Boolean _noGiveaways;
/*     */   private Boolean _notReturnable;
/*     */   private String _partNumber;
/*     */   private Boolean _promptForPrice;
/*     */   private Boolean _promptForQuantity;
/*     */   private Boolean _promptForDescription;
/*     */   private String _promptForCustomer;
/*     */   private BigDecimal _restockingFee;
/*     */   private String _seasonCode;
/*     */   private Boolean _substituteAvailable;
/*     */   private BigDecimal _unitCost;
/*     */   private String _vendorId;
/*     */   private Integer _specialOrderLeadDays;
/*     */   private Integer _qtyScale;
/*     */   private Boolean _messages;
/*     */   private String _unitOfMeasureCode;
/*     */   private String _taxGroupId;
/*     */   private Boolean _warranty;
/*     */   private Boolean _genericItem;
/*     */   private BigDecimal _currentSalePrice;
/*     */   private BigDecimal _initialSaleQuantity;
/*     */   private String _dispositionCode;
/*     */   private String _itemAvailabilityCode;
/*     */   private Integer _minAgeRequired;
/*     */   private String _stockStatus;
/*     */   private Boolean _foodStampEligible;
/*     */   private BigDecimal _shippingWeight;
/*     */   private BigDecimal _packSize;
/*     */   private String _defaultSourceType;
/*     */   private String _defaultSourceId;
/*     */   private String _sellingGroupId;
/*     */   private Boolean _excludeFromNetSales;
/*     */   private String _fiscalItemId;
/*     */   private String _fiscalItemDescription;
/*     */   private String _externalSystem;
/*     */   private BigDecimal _tareValue;
/*     */   private String _tareUnitOfMeasureCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.level_code, t.level_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.apply_restocking_fee_flag, t.attached_items_flag, t.compare_at_price, t.disallow_discounts_flag, t.disallow_deals_flag, t.disallow_price_change_flag, t.disallow_send_sale_flag, t.disallow_commission_flag, t.disallow_layaway_flag, t.disallow_work_order_flag, t.disallow_special_order_flag, t.disallow_order_flag, t.disallow_rain_check, t.force_quantity_of_one_flag, t.max_sale_unit_count, t.min_sale_unit_count, t.no_giveaways_flag, t.not_returnable_flag, t.part_number, t.prompt_for_price_flag, t.prompt_for_quantity_flag, t.prompt_for_description_flag, t.prompt_for_customer, t.restocking_fee, t.season_code, t.substitute_available_flag, t.unit_cost, t.vendor, t.special_order_lead_days, t.qty_scale, t.messages_flag, t.unit_of_measure_code, t.tax_group_id, t.warranty_flag, t.generic_item_flag, t.curr_sale_price, t.initial_sale_qty, t.disposition_code, t.item_availability_code, t.min_age_required, t.stock_status, t.foodstamp_eligible_flag, t.shipping_weight, t.pack_size, t.default_source_type, t.default_source_id, t.selling_group_id, t.exclude_from_net_sales_flag, t.fiscal_item_id, t.fiscal_item_description, t.external_system, t.tare_value, t.tare_unit_of_measure_code FROM itm_item_options t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  90 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  94 */     return "SELECT t.organization_id, t.item_id, t.level_code, t.level_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.apply_restocking_fee_flag, t.attached_items_flag, t.compare_at_price, t.disallow_discounts_flag, t.disallow_deals_flag, t.disallow_price_change_flag, t.disallow_send_sale_flag, t.disallow_commission_flag, t.disallow_layaway_flag, t.disallow_work_order_flag, t.disallow_special_order_flag, t.disallow_order_flag, t.disallow_rain_check, t.force_quantity_of_one_flag, t.max_sale_unit_count, t.min_sale_unit_count, t.no_giveaways_flag, t.not_returnable_flag, t.part_number, t.prompt_for_price_flag, t.prompt_for_quantity_flag, t.prompt_for_description_flag, t.prompt_for_customer, t.restocking_fee, t.season_code, t.substitute_available_flag, t.unit_cost, t.vendor, t.special_order_lead_days, t.qty_scale, t.messages_flag, t.unit_of_measure_code, t.tax_group_id, t.warranty_flag, t.generic_item_flag, t.curr_sale_price, t.initial_sale_qty, t.disposition_code, t.item_availability_code, t.min_age_required, t.stock_status, t.foodstamp_eligible_flag, t.shipping_weight, t.pack_size, t.default_source_type, t.default_source_id, t.selling_group_id, t.exclude_from_net_sales_flag, t.fiscal_item_id, t.fiscal_item_description, t.external_system, t.tare_value, t.tare_unit_of_measure_code FROM itm_item_options t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/* 100 */     return " WHERE organization_id = ?  AND item_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   }
/*     */   
/* 103 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_options(organization_id, item_id, level_code, level_value, create_date, create_user_id, update_date, update_user_id, apply_restocking_fee_flag, attached_items_flag, compare_at_price, disallow_discounts_flag, disallow_deals_flag, disallow_price_change_flag, disallow_send_sale_flag, disallow_commission_flag, disallow_layaway_flag, disallow_work_order_flag, disallow_special_order_flag, disallow_order_flag, disallow_rain_check, force_quantity_of_one_flag, max_sale_unit_count, min_sale_unit_count, no_giveaways_flag, not_returnable_flag, part_number, prompt_for_price_flag, prompt_for_quantity_flag, prompt_for_description_flag, prompt_for_customer, restocking_fee, season_code, substitute_available_flag, unit_cost, vendor, special_order_lead_days, qty_scale, messages_flag, unit_of_measure_code, tax_group_id, warranty_flag, generic_item_flag, curr_sale_price, initial_sale_qty, disposition_code, item_availability_code, min_age_required, stock_status, foodstamp_eligible_flag, shipping_weight, pack_size, default_source_type, default_source_id, selling_group_id, exclude_from_net_sales_flag, fiscal_item_id, fiscal_item_description, external_system, tare_value, tare_unit_of_measure_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/* 106 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/* 110 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, this._levelCode, this._levelValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._applyRestockingFee, this._attachedItems, this._compareAtPrice, this._disallowDiscounts, this._disallowDeals, this._disallowPriceChange, this._disallowSendSale, this._disallowCommission, this._disallowLayaway, this._disallowWorkOrder, this._disallowSpecialOrder, this._disallowOrder, this._disallowRainCheck, this._forceQuantityOfOne, this._maximumSaleUnitCount, this._minimumSaleUnitCount, this._noGiveaways, this._notReturnable, this._partNumber, this._promptForPrice, this._promptForQuantity, this._promptForDescription, this._promptForCustomer, this._restockingFee, this._seasonCode, this._substituteAvailable, this._unitCost, this._vendorId, this._specialOrderLeadDays, this._qtyScale, this._messages, this._unitOfMeasureCode, this._taxGroupId, this._warranty, this._genericItem, this._currentSalePrice, this._initialSaleQuantity, this._dispositionCode, this._itemAvailabilityCode, this._minAgeRequired, this._stockStatus, this._foodStampEligible, this._shippingWeight, this._packSize, this._defaultSourceType, this._defaultSourceId, this._sellingGroupId, this._excludeFromNetSales, this._fiscalItemId, this._fiscalItemDescription, this._externalSystem, this._tareValue, this._tareUnitOfMeasureCode } };
/* 111 */     return insertParameterObject;
/*     */   }
/*     */   
/* 114 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 12, 91, 12, -7, -7, 3, -7, -7, -7, -7, -7, -7, -7, -7, -7, -7, -7, 3, 3, -7, -7, 12, -7, -7, -7, 12, 3, 12, -7, 3, 12, 4, 4, -7, 12, 12, -7, -7, 3, 3, 12, 12, 4, 12, -7, 3, 3, 12, 12, 12, -7, 12, 12, 12, 3, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/* 117 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/* 120 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_options SET update_date = ?, update_user_id = ?, apply_restocking_fee_flag = ?, attached_items_flag = ?, compare_at_price = ?, disallow_discounts_flag = ?, disallow_deals_flag = ?, disallow_price_change_flag = ?, disallow_send_sale_flag = ?, disallow_commission_flag = ?, disallow_layaway_flag = ?, disallow_work_order_flag = ?, disallow_special_order_flag = ?, disallow_order_flag = ?, disallow_rain_check = ?, force_quantity_of_one_flag = ?, max_sale_unit_count = ?, min_sale_unit_count = ?, no_giveaways_flag = ?, not_returnable_flag = ?, part_number = ?, prompt_for_price_flag = ?, prompt_for_quantity_flag = ?, prompt_for_description_flag = ?, prompt_for_customer = ?, restocking_fee = ?, season_code = ?, substitute_available_flag = ?, unit_cost = ?, vendor = ?, special_order_lead_days = ?, qty_scale = ?, messages_flag = ?, unit_of_measure_code = ?, tax_group_id = ?, warranty_flag = ?, generic_item_flag = ?, curr_sale_price = ?, initial_sale_qty = ?, disposition_code = ?, item_availability_code = ?, min_age_required = ?, stock_status = ?, foodstamp_eligible_flag = ?, shipping_weight = ?, pack_size = ?, default_source_type = ?, default_source_id = ?, selling_group_id = ?, exclude_from_net_sales_flag = ?, fiscal_item_id = ?, fiscal_item_description = ?, external_system = ?, tare_value = ?, tare_unit_of_measure_code = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/* 123 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 127 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._applyRestockingFee, this._attachedItems, this._compareAtPrice, this._disallowDiscounts, this._disallowDeals, this._disallowPriceChange, this._disallowSendSale, this._disallowCommission, this._disallowLayaway, this._disallowWorkOrder, this._disallowSpecialOrder, this._disallowOrder, this._disallowRainCheck, this._forceQuantityOfOne, this._maximumSaleUnitCount, this._minimumSaleUnitCount, this._noGiveaways, this._notReturnable, this._partNumber, this._promptForPrice, this._promptForQuantity, this._promptForDescription, this._promptForCustomer, this._restockingFee, this._seasonCode, this._substituteAvailable, this._unitCost, this._vendorId, this._specialOrderLeadDays, this._qtyScale, this._messages, this._unitOfMeasureCode, this._taxGroupId, this._warranty, this._genericItem, this._currentSalePrice, this._initialSaleQuantity, this._dispositionCode, this._itemAvailabilityCode, this._minAgeRequired, this._stockStatus, this._foodStampEligible, this._shippingWeight, this._packSize, this._defaultSourceType, this._defaultSourceId, this._sellingGroupId, this._excludeFromNetSales, this._fiscalItemId, this._fiscalItemDescription, this._externalSystem, this._tareValue, this._tareUnitOfMeasureCode } };
/* 128 */     return updateParameterObject;
/*     */   }
/*     */   
/* 131 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -7, -7, 3, -7, -7, -7, -7, -7, -7, -7, -7, -7, -7, -7, 3, 3, -7, -7, 12, -7, -7, -7, 12, 3, 12, -7, 3, 12, 4, 4, -7, 12, 12, -7, -7, 3, 3, 12, 12, 4, 12, -7, 3, 3, 12, 12, 12, -7, 12, 12, 12, 3, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 133 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 136 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_options" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 139 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 145 */     return " WHERE organization_id = ?  AND item_id = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 148 */     return new Object[] { this._organizationId, this._itemId, this._levelCode, this._levelValue };
/*     */   }
/*     */   
/* 151 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 154 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 157 */     return "itm_item_options";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 161 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 165 */     return new ItemOptionsFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemOptionsFiller
/*     */     implements IFiller {
/*     */     private ItemOptionsDBA _parent;
/*     */     
/*     */     public ItemOptionsFiller(ItemOptionsDBA argParent) {
/* 173 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 178 */       long primitiveResult = argResultSet.getLong(1);
/* 179 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 180 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 184 */       this._parent._itemId = argResultSet.getString(2);
/* 185 */       this._parent._levelCode = argResultSet.getString(3);
/* 186 */       this._parent._levelValue = argResultSet.getString(4);
/*     */       
/* 188 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 189 */       if (t5 != null) {
/* 190 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 193 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 196 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 198 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 199 */       if (t7 != null) {
/* 200 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 203 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 206 */       this._parent._updateUserId = argResultSet.getString(8);
/* 207 */       this._parent._applyRestockingFee = Boolean.valueOf(argResultSet.getBoolean(9));
/* 208 */       this._parent._attachedItems = Boolean.valueOf(argResultSet.getBoolean(10));
/* 209 */       this._parent._compareAtPrice = argResultSet.getBigDecimal(11);
/* 210 */       this._parent._disallowDiscounts = Boolean.valueOf(argResultSet.getBoolean(12));
/* 211 */       this._parent._disallowDeals = Boolean.valueOf(argResultSet.getBoolean(13));
/* 212 */       this._parent._disallowPriceChange = Boolean.valueOf(argResultSet.getBoolean(14));
/* 213 */       this._parent._disallowSendSale = Boolean.valueOf(argResultSet.getBoolean(15));
/* 214 */       this._parent._disallowCommission = Boolean.valueOf(argResultSet.getBoolean(16));
/* 215 */       this._parent._disallowLayaway = Boolean.valueOf(argResultSet.getBoolean(17));
/* 216 */       this._parent._disallowWorkOrder = Boolean.valueOf(argResultSet.getBoolean(18));
/* 217 */       this._parent._disallowSpecialOrder = Boolean.valueOf(argResultSet.getBoolean(19));
/* 218 */       this._parent._disallowOrder = Boolean.valueOf(argResultSet.getBoolean(20));
/* 219 */       this._parent._disallowRainCheck = Boolean.valueOf(argResultSet.getBoolean(21));
/* 220 */       this._parent._forceQuantityOfOne = Boolean.valueOf(argResultSet.getBoolean(22));
/* 221 */       this._parent._maximumSaleUnitCount = argResultSet.getBigDecimal(23);
/* 222 */       this._parent._minimumSaleUnitCount = argResultSet.getBigDecimal(24);
/* 223 */       this._parent._noGiveaways = Boolean.valueOf(argResultSet.getBoolean(25));
/* 224 */       this._parent._notReturnable = Boolean.valueOf(argResultSet.getBoolean(26));
/* 225 */       this._parent._partNumber = argResultSet.getString(27);
/* 226 */       this._parent._promptForPrice = Boolean.valueOf(argResultSet.getBoolean(28));
/* 227 */       this._parent._promptForQuantity = Boolean.valueOf(argResultSet.getBoolean(29));
/* 228 */       this._parent._promptForDescription = Boolean.valueOf(argResultSet.getBoolean(30));
/* 229 */       this._parent._promptForCustomer = argResultSet.getString(31);
/* 230 */       this._parent._restockingFee = argResultSet.getBigDecimal(32);
/* 231 */       this._parent._seasonCode = argResultSet.getString(33);
/* 232 */       this._parent._substituteAvailable = Boolean.valueOf(argResultSet.getBoolean(34));
/* 233 */       this._parent._unitCost = argResultSet.getBigDecimal(35);
/* 234 */       this._parent._vendorId = argResultSet.getString(36);
/*     */ 
/*     */       
/* 237 */       int i = argResultSet.getInt(37);
/* 238 */       if (i != 0 || argResultSet.getObject(37) != null) {
/* 239 */         this._parent._specialOrderLeadDays = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 245 */       i = argResultSet.getInt(38);
/* 246 */       if (i != 0 || argResultSet.getObject(38) != null) {
/* 247 */         this._parent._qtyScale = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 251 */       this._parent._messages = Boolean.valueOf(argResultSet.getBoolean(39));
/* 252 */       this._parent._unitOfMeasureCode = argResultSet.getString(40);
/* 253 */       this._parent._taxGroupId = argResultSet.getString(41);
/* 254 */       this._parent._warranty = Boolean.valueOf(argResultSet.getBoolean(42));
/* 255 */       this._parent._genericItem = Boolean.valueOf(argResultSet.getBoolean(43));
/* 256 */       this._parent._currentSalePrice = argResultSet.getBigDecimal(44);
/* 257 */       this._parent._initialSaleQuantity = argResultSet.getBigDecimal(45);
/* 258 */       this._parent._dispositionCode = argResultSet.getString(46);
/* 259 */       this._parent._itemAvailabilityCode = argResultSet.getString(47);
/*     */ 
/*     */       
/* 262 */       i = argResultSet.getInt(48);
/* 263 */       if (i != 0 || argResultSet.getObject(48) != null) {
/* 264 */         this._parent._minAgeRequired = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 268 */       this._parent._stockStatus = argResultSet.getString(49);
/* 269 */       this._parent._foodStampEligible = Boolean.valueOf(argResultSet.getBoolean(50));
/* 270 */       this._parent._shippingWeight = argResultSet.getBigDecimal(51);
/* 271 */       this._parent._packSize = argResultSet.getBigDecimal(52);
/* 272 */       this._parent._defaultSourceType = argResultSet.getString(53);
/* 273 */       this._parent._defaultSourceId = argResultSet.getString(54);
/* 274 */       this._parent._sellingGroupId = argResultSet.getString(55);
/* 275 */       this._parent._excludeFromNetSales = Boolean.valueOf(argResultSet.getBoolean(56));
/* 276 */       this._parent._fiscalItemId = argResultSet.getString(57);
/* 277 */       this._parent._fiscalItemDescription = argResultSet.getString(58);
/* 278 */       this._parent._externalSystem = argResultSet.getString(59);
/* 279 */       this._parent._tareValue = argResultSet.getBigDecimal(60);
/* 280 */       this._parent._tareUnitOfMeasureCode = argResultSet.getString(61);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 285 */     argDAO.suppressStateChanges(true);
/* 286 */     ItemOptionsDAO dao = (ItemOptionsDAO)argDAO;
/* 287 */     dao.setOrganizationId(this._organizationId);
/* 288 */     dao.setItemId(this._itemId);
/* 289 */     dao.setLevelCode(this._levelCode);
/* 290 */     dao.setLevelValue(this._levelValue);
/* 291 */     dao.setCreateDate(this._createDate);
/* 292 */     dao.setCreateUserId(this._createUserId);
/* 293 */     dao.setUpdateDate(this._updateDate);
/* 294 */     dao.setUpdateUserId(this._updateUserId);
/* 295 */     dao.setApplyRestockingFee(this._applyRestockingFee);
/* 296 */     dao.setAttachedItems(this._attachedItems);
/* 297 */     dao.setCompareAtPrice(this._compareAtPrice);
/* 298 */     dao.setDisallowDiscounts(this._disallowDiscounts);
/* 299 */     dao.setDisallowDeals(this._disallowDeals);
/* 300 */     dao.setDisallowPriceChange(this._disallowPriceChange);
/* 301 */     dao.setDisallowSendSale(this._disallowSendSale);
/* 302 */     dao.setDisallowCommission(this._disallowCommission);
/* 303 */     dao.setDisallowLayaway(this._disallowLayaway);
/* 304 */     dao.setDisallowWorkOrder(this._disallowWorkOrder);
/* 305 */     dao.setDisallowSpecialOrder(this._disallowSpecialOrder);
/* 306 */     dao.setDisallowOrder(this._disallowOrder);
/* 307 */     dao.setDisallowRainCheck(this._disallowRainCheck);
/* 308 */     dao.setForceQuantityOfOne(this._forceQuantityOfOne);
/* 309 */     dao.setMaximumSaleUnitCount(this._maximumSaleUnitCount);
/* 310 */     dao.setMinimumSaleUnitCount(this._minimumSaleUnitCount);
/* 311 */     dao.setNoGiveaways(this._noGiveaways);
/* 312 */     dao.setNotReturnable(this._notReturnable);
/* 313 */     dao.setPartNumber(this._partNumber);
/* 314 */     dao.setPromptForPrice(this._promptForPrice);
/* 315 */     dao.setPromptForQuantity(this._promptForQuantity);
/* 316 */     dao.setPromptForDescription(this._promptForDescription);
/* 317 */     dao.setPromptForCustomer(this._promptForCustomer);
/* 318 */     dao.setRestockingFee(this._restockingFee);
/* 319 */     dao.setSeasonCode(this._seasonCode);
/* 320 */     dao.setSubstituteAvailable(this._substituteAvailable);
/* 321 */     dao.setUnitCost(this._unitCost);
/* 322 */     dao.setVendorId(this._vendorId);
/* 323 */     dao.setSpecialOrderLeadDays(this._specialOrderLeadDays);
/* 324 */     dao.setQtyScale(this._qtyScale);
/* 325 */     dao.setMessages(this._messages);
/* 326 */     dao.setUnitOfMeasureCode(this._unitOfMeasureCode);
/* 327 */     dao.setTaxGroupId(this._taxGroupId);
/* 328 */     dao.setWarranty(this._warranty);
/* 329 */     dao.setGenericItem(this._genericItem);
/* 330 */     dao.setCurrentSalePrice(this._currentSalePrice);
/* 331 */     dao.setInitialSaleQuantity(this._initialSaleQuantity);
/* 332 */     dao.setDispositionCode(this._dispositionCode);
/* 333 */     dao.setItemAvailabilityCode(this._itemAvailabilityCode);
/* 334 */     dao.setMinAgeRequired(this._minAgeRequired);
/* 335 */     dao.setStockStatus(this._stockStatus);
/* 336 */     dao.setFoodStampEligible(this._foodStampEligible);
/* 337 */     dao.setShippingWeight(this._shippingWeight);
/* 338 */     dao.setPackSize(this._packSize);
/* 339 */     dao.setDefaultSourceType(this._defaultSourceType);
/* 340 */     dao.setDefaultSourceId(this._defaultSourceId);
/* 341 */     dao.setSellingGroupId(this._sellingGroupId);
/* 342 */     dao.setExcludeFromNetSales(this._excludeFromNetSales);
/* 343 */     dao.setFiscalItemId(this._fiscalItemId);
/* 344 */     dao.setFiscalItemDescription(this._fiscalItemDescription);
/* 345 */     dao.setExternalSystem(this._externalSystem);
/* 346 */     dao.setTareValue(this._tareValue);
/* 347 */     dao.setTareUnitOfMeasureCode(this._tareUnitOfMeasureCode);
/* 348 */     argDAO.suppressStateChanges(false);
/* 349 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 353 */     return loadDAO((IDataAccessObject)new ItemOptionsDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 357 */     ItemOptionsDAO dao = (ItemOptionsDAO)argDAO;
/* 358 */     this._organizationId = dao.getOrganizationId();
/* 359 */     this._itemId = dao.getItemId();
/* 360 */     this._levelCode = dao.getLevelCode();
/* 361 */     this._levelValue = dao.getLevelValue();
/* 362 */     this._createDate = dao.getCreateDate();
/* 363 */     this._createUserId = dao.getCreateUserId();
/* 364 */     this._updateDate = dao.getUpdateDate();
/* 365 */     this._updateUserId = dao.getUpdateUserId();
/* 366 */     this._applyRestockingFee = (dao.getApplyRestockingFee() != null) ? dao.getApplyRestockingFee() : Boolean.valueOf(false);
/* 367 */     this._attachedItems = (dao.getAttachedItems() != null) ? dao.getAttachedItems() : Boolean.valueOf(false);
/* 368 */     this._compareAtPrice = dao.getCompareAtPrice();
/* 369 */     this._disallowDiscounts = (dao.getDisallowDiscounts() != null) ? dao.getDisallowDiscounts() : Boolean.valueOf(false);
/* 370 */     this._disallowDeals = (dao.getDisallowDeals() != null) ? dao.getDisallowDeals() : Boolean.valueOf(false);
/* 371 */     this._disallowPriceChange = (dao.getDisallowPriceChange() != null) ? dao.getDisallowPriceChange() : Boolean.valueOf(false);
/* 372 */     this._disallowSendSale = (dao.getDisallowSendSale() != null) ? dao.getDisallowSendSale() : Boolean.valueOf(false);
/* 373 */     this._disallowCommission = (dao.getDisallowCommission() != null) ? dao.getDisallowCommission() : Boolean.valueOf(false);
/* 374 */     this._disallowLayaway = (dao.getDisallowLayaway() != null) ? dao.getDisallowLayaway() : Boolean.valueOf(false);
/* 375 */     this._disallowWorkOrder = (dao.getDisallowWorkOrder() != null) ? dao.getDisallowWorkOrder() : Boolean.valueOf(false);
/* 376 */     this._disallowSpecialOrder = (dao.getDisallowSpecialOrder() != null) ? dao.getDisallowSpecialOrder() : Boolean.valueOf(false);
/* 377 */     this._disallowOrder = (dao.getDisallowOrder() != null) ? dao.getDisallowOrder() : Boolean.valueOf(false);
/* 378 */     this._disallowRainCheck = (dao.getDisallowRainCheck() != null) ? dao.getDisallowRainCheck() : Boolean.valueOf(false);
/* 379 */     this._forceQuantityOfOne = (dao.getForceQuantityOfOne() != null) ? dao.getForceQuantityOfOne() : Boolean.valueOf(false);
/* 380 */     this._maximumSaleUnitCount = dao.getMaximumSaleUnitCount();
/* 381 */     this._minimumSaleUnitCount = dao.getMinimumSaleUnitCount();
/* 382 */     this._noGiveaways = (dao.getNoGiveaways() != null) ? dao.getNoGiveaways() : Boolean.valueOf(false);
/* 383 */     this._notReturnable = (dao.getNotReturnable() != null) ? dao.getNotReturnable() : Boolean.valueOf(false);
/* 384 */     this._partNumber = dao.getPartNumber();
/* 385 */     this._promptForPrice = (dao.getPromptForPrice() != null) ? dao.getPromptForPrice() : Boolean.valueOf(false);
/* 386 */     this._promptForQuantity = (dao.getPromptForQuantity() != null) ? dao.getPromptForQuantity() : Boolean.valueOf(false);
/* 387 */     this._promptForDescription = (dao.getPromptForDescription() != null) ? dao.getPromptForDescription() : Boolean.valueOf(false);
/* 388 */     this._promptForCustomer = dao.getPromptForCustomer();
/* 389 */     this._restockingFee = dao.getRestockingFee();
/* 390 */     this._seasonCode = dao.getSeasonCode();
/* 391 */     this._substituteAvailable = (dao.getSubstituteAvailable() != null) ? dao.getSubstituteAvailable() : Boolean.valueOf(false);
/* 392 */     this._unitCost = dao.getUnitCost();
/* 393 */     this._vendorId = dao.getVendorId();
/* 394 */     this._specialOrderLeadDays = dao.getSpecialOrderLeadDays();
/* 395 */     this._qtyScale = dao.getQtyScale();
/* 396 */     this._messages = (dao.getMessages() != null) ? dao.getMessages() : Boolean.valueOf(false);
/* 397 */     this._unitOfMeasureCode = dao.getUnitOfMeasureCode();
/* 398 */     this._taxGroupId = dao.getTaxGroupId();
/* 399 */     this._warranty = (dao.getWarranty() != null) ? dao.getWarranty() : Boolean.valueOf(false);
/* 400 */     this._genericItem = (dao.getGenericItem() != null) ? dao.getGenericItem() : Boolean.valueOf(false);
/* 401 */     this._currentSalePrice = dao.getCurrentSalePrice();
/* 402 */     this._initialSaleQuantity = dao.getInitialSaleQuantity();
/* 403 */     this._dispositionCode = dao.getDispositionCode();
/* 404 */     this._itemAvailabilityCode = dao.getItemAvailabilityCode();
/* 405 */     this._minAgeRequired = dao.getMinAgeRequired();
/* 406 */     this._stockStatus = dao.getStockStatus();
/* 407 */     this._foodStampEligible = (dao.getFoodStampEligible() != null) ? dao.getFoodStampEligible() : Boolean.valueOf(false);
/* 408 */     this._shippingWeight = dao.getShippingWeight();
/* 409 */     this._packSize = dao.getPackSize();
/* 410 */     this._defaultSourceType = dao.getDefaultSourceType();
/* 411 */     this._defaultSourceId = dao.getDefaultSourceId();
/* 412 */     this._sellingGroupId = dao.getSellingGroupId();
/* 413 */     this._excludeFromNetSales = (dao.getExcludeFromNetSales() != null) ? dao.getExcludeFromNetSales() : Boolean.valueOf(false);
/* 414 */     this._fiscalItemId = dao.getFiscalItemId();
/* 415 */     this._fiscalItemDescription = dao.getFiscalItemDescription();
/* 416 */     this._externalSystem = dao.getExternalSystem();
/* 417 */     this._tareValue = dao.getTareValue();
/* 418 */     this._tareUnitOfMeasureCode = dao.getTareUnitOfMeasureCode();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 422 */     ItemOptionsId id = (ItemOptionsId)argId;
/* 423 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 424 */     argStatement.setString(2, id.getItemId());
/* 425 */     argStatement.setString(3, id.getLevelCode());
/* 426 */     argStatement.setString(4, id.getLevelValue());
/* 427 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 431 */     ItemOptionsId id = new ItemOptionsId();
/* 432 */     id.setOrganizationId(this._organizationId);
/* 433 */     id.setItemId(this._itemId);
/* 434 */     id.setLevelCode(this._levelCode);
/* 435 */     id.setLevelValue(this._levelValue);
/* 436 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 444 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 448 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemOptionsDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */