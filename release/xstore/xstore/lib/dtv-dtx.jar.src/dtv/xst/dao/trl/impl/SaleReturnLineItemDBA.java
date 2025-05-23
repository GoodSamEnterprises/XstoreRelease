/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemId;
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
/*     */ public class SaleReturnLineItemDBA
/*     */   extends RetailTransactionLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1387284802L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _baseExtendedPrice;
/*     */   private BigDecimal _baseUnitPrice;
/*     */   private String _merchLevel1Id;
/*     */   private BigDecimal _extendedAmount;
/*     */   private Integer _giftReceiptCount;
/*     */   private BigDecimal _grossAmount;
/*     */   private String _inventoryActionCode;
/*     */   private String _itemId;
/*     */   private String _itemIdEntryMethodCode;
/*     */   private BigDecimal _netAmount;
/*     */   private BigDecimal _rptBaseUnitPrice;
/*     */   private Date _originalBusinessDate;
/*     */   private Integer _originalLineItemSequence;
/*     */   private Long _originalRetailLocationId;
/*     */   private Long _originalTransactionSequence;
/*     */   private Long _originalWorkstationId;
/*     */   private String _priceDerivationMethodCode;
/*     */   private String _priceEntryMethodCode;
/*     */   private BigDecimal _quantity;
/*     */   private String _returnComment;
/*     */   private Boolean _return;
/*     */   private String _returnTypeCode;
/*     */   private String _saleReturnLineItemTypeCode;
/*     */   private String _scannedItemId;
/*     */   private String _serialNumber;
/*     */   private String _enteredDescription;
/*     */   private BigDecimal _unitPrice;
/*     */   private BigDecimal _vatAmount;
/*     */   private Boolean _forceZeroExtendedAmt;
/*     */   private String _returnReasonCode;
/*     */   private String _taxGroupId;
/*     */   private BigDecimal _netQuantity;
/*     */   private BigDecimal _grossQuantity;
/*     */   private BigDecimal _foodStampsAppliedAmount;
/*     */   private String _vendorId;
/*     */   private BigDecimal _regularBasePrice;
/*     */   private String _pricePropertyCode;
/*     */   private BigDecimal _shippingWeight;
/*     */   private BigDecimal _unitCost;
/*     */   private Boolean _attachedItemFlag;
/*     */   private BigDecimal _initialQuantity;
/*     */   private Boolean _notReturnable;
/*     */   private Boolean _excludeFromNetSales;
/*     */   private Boolean _measurementRequired;
/*     */   private String _weightEntryMethodCode;
/*     */   private BigDecimal _tareValue;
/*     */   private String _tareType;
/*     */   private String _tareUnitOfMeasureCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.base_extended_price, t.base_unit_price, t.merch_level_1, t.extended_amt, t.rcpt_count, t.gross_amt, t.inventory_action_code, t.item_id, t.item_id_entry_mthd_code, t.net_amt, t.rpt_base_unit_price, t.original_business_date, t. original_rtrans_lineitm_seq, t.original_rtl_loc_id, t.original_trans_seq, t.original_wkstn_id, t.price_derivtn_mthd_code, t.price_entry_mthd_code, t.quantity, t.return_comment, t.return_flag, t.return_typcode, t.sale_lineitm_typcode, t.scanned_item_id, t.serial_nbr, t.entered_description, t.unit_price, t.vat_amt, t.force_zero_extended_amt_flag, t.return_reascode, t.tax_group_id, t.net_quantity, t.gross_quantity, t.food_stamps_applied_amount, t.vendor_id, t.regular_base_price, t.price_property_code, t.shipping_weight, t.unit_cost, t.attached_item_flag, t.initial_quantity, t.not_returnable_flag, t.exclude_from_net_sales_flag, t.measure_req_flag, t.weight_entry_mthd_code, t.tare_value, t.tare_type, t.tare_unit_of_measure_code FROM trl_sale_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  88 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  92 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.base_extended_price, t.base_unit_price, t.merch_level_1, t.extended_amt, t.rcpt_count, t.gross_amt, t.inventory_action_code, t.item_id, t.item_id_entry_mthd_code, t.net_amt, t.rpt_base_unit_price, t.original_business_date, t. original_rtrans_lineitm_seq, t.original_rtl_loc_id, t.original_trans_seq, t.original_wkstn_id, t.price_derivtn_mthd_code, t.price_entry_mthd_code, t.quantity, t.return_comment, t.return_flag, t.return_typcode, t.sale_lineitm_typcode, t.scanned_item_id, t.serial_nbr, t.entered_description, t.unit_price, t.vat_amt, t.force_zero_extended_amt_flag, t.return_reascode, t.tax_group_id, t.net_quantity, t.gross_quantity, t.food_stamps_applied_amount, t.vendor_id, t.regular_base_price, t.price_property_code, t.shipping_weight, t.unit_cost, t.attached_item_flag, t.initial_quantity, t.not_returnable_flag, t.exclude_from_net_sales_flag, t.measure_req_flag, t.weight_entry_mthd_code, t.tare_value, t.tare_type, t.tare_unit_of_measure_code FROM trl_sale_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  99 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/* 102 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_sale_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, base_extended_price, base_unit_price, merch_level_1, extended_amt, rcpt_count, gross_amt, inventory_action_code, item_id, item_id_entry_mthd_code, net_amt, rpt_base_unit_price, original_business_date,  original_rtrans_lineitm_seq, original_rtl_loc_id, original_trans_seq, original_wkstn_id, price_derivtn_mthd_code, price_entry_mthd_code, quantity, return_comment, return_flag, return_typcode, sale_lineitm_typcode, scanned_item_id, serial_nbr, entered_description, unit_price, vat_amt, force_zero_extended_amt_flag, return_reascode, tax_group_id, net_quantity, gross_quantity, food_stamps_applied_amount, vendor_id, regular_base_price, price_property_code, shipping_weight, unit_cost, attached_item_flag, initial_quantity, not_returnable_flag, exclude_from_net_sales_flag, measure_req_flag, weight_entry_mthd_code, tare_value, tare_type, tare_unit_of_measure_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/* 106 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/* 111 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._baseExtendedPrice, this._baseUnitPrice, this._merchLevel1Id, this._extendedAmount, this._giftReceiptCount, this._grossAmount, this._inventoryActionCode, this._itemId, this._itemIdEntryMethodCode, this._netAmount, this._rptBaseUnitPrice, this._originalBusinessDate, this._originalLineItemSequence, this._originalRetailLocationId, this._originalTransactionSequence, this._originalWorkstationId, this._priceDerivationMethodCode, this._priceEntryMethodCode, this._quantity, this._returnComment, this._return, this._returnTypeCode, this._saleReturnLineItemTypeCode, this._scannedItemId, this._serialNumber, this._enteredDescription, this._unitPrice, this._vatAmount, this._forceZeroExtendedAmt, this._returnReasonCode, this._taxGroupId, this._netQuantity, this._grossQuantity, this._foodStampsAppliedAmount, this._vendorId, this._regularBasePrice, this._pricePropertyCode, this._shippingWeight, this._unitCost, this._attachedItemFlag, this._initialQuantity, this._notReturnable, this._excludeFromNetSales, this._measurementRequired, this._weightEntryMethodCode, this._tareValue, this._tareType, this._tareUnitOfMeasureCode } };
/* 112 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/* 115 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 3, 3, 12, 3, 4, 3, 12, 12, 12, 3, 3, 91, 4, -5, -5, -5, 12, 12, 3, 12, -7, 12, 12, 12, 12, 12, 3, 3, -7, 12, 12, 3, 3, 3, 12, 3, 12, 3, 3, -7, 3, -7, -7, -7, 12, 3, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/* 119 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/* 122 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_sale_lineitm SET update_date = ?, update_user_id = ?, base_extended_price = ?, base_unit_price = ?, merch_level_1 = ?, extended_amt = ?, rcpt_count = ?, gross_amt = ?, inventory_action_code = ?, item_id = ?, item_id_entry_mthd_code = ?, net_amt = ?, rpt_base_unit_price = ?, original_business_date = ?,  original_rtrans_lineitm_seq = ?, original_rtl_loc_id = ?, original_trans_seq = ?, original_wkstn_id = ?, price_derivtn_mthd_code = ?, price_entry_mthd_code = ?, quantity = ?, return_comment = ?, return_flag = ?, return_typcode = ?, sale_lineitm_typcode = ?, scanned_item_id = ?, serial_nbr = ?, entered_description = ?, unit_price = ?, vat_amt = ?, force_zero_extended_amt_flag = ?, return_reascode = ?, tax_group_id = ?, net_quantity = ?, gross_quantity = ?, food_stamps_applied_amount = ?, vendor_id = ?, regular_base_price = ?, price_property_code = ?, shipping_weight = ?, unit_cost = ?, attached_item_flag = ?, initial_quantity = ?, not_returnable_flag = ?, exclude_from_net_sales_flag = ?, measure_req_flag = ?, weight_entry_mthd_code = ?, tare_value = ?, tare_type = ?, tare_unit_of_measure_code = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/* 126 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 131 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._baseExtendedPrice, this._baseUnitPrice, this._merchLevel1Id, this._extendedAmount, this._giftReceiptCount, this._grossAmount, this._inventoryActionCode, this._itemId, this._itemIdEntryMethodCode, this._netAmount, this._rptBaseUnitPrice, this._originalBusinessDate, this._originalLineItemSequence, this._originalRetailLocationId, this._originalTransactionSequence, this._originalWorkstationId, this._priceDerivationMethodCode, this._priceEntryMethodCode, this._quantity, this._returnComment, this._return, this._returnTypeCode, this._saleReturnLineItemTypeCode, this._scannedItemId, this._serialNumber, this._enteredDescription, this._unitPrice, this._vatAmount, this._forceZeroExtendedAmt, this._returnReasonCode, this._taxGroupId, this._netQuantity, this._grossQuantity, this._foodStampsAppliedAmount, this._vendorId, this._regularBasePrice, this._pricePropertyCode, this._shippingWeight, this._unitCost, this._attachedItemFlag, this._initialQuantity, this._notReturnable, this._excludeFromNetSales, this._measurementRequired, this._weightEntryMethodCode, this._tareValue, this._tareType, this._tareUnitOfMeasureCode } };
/* 132 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/* 135 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 3, 12, 3, 4, 3, 12, 12, 12, 3, 3, 91, 4, -5, -5, -5, 12, 12, 3, 12, -7, 12, 12, 12, 12, 12, 3, 3, -7, 12, 12, 3, 3, 3, 12, 3, 12, 3, 3, -7, 3, -7, -7, -7, 12, 3, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/* 138 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 141 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_sale_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 145 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 152 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 156 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 159 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 163 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 167 */     return "trl_sale_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 172 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 176 */     return new SaleReturnLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class SaleReturnLineItemFiller
/*     */     implements IFiller {
/*     */     private SaleReturnLineItemDBA _parent;
/*     */     
/*     */     public SaleReturnLineItemFiller(SaleReturnLineItemDBA argParent) {
/* 184 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 189 */       long primitiveResult = argResultSet.getLong(1);
/* 190 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 191 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 197 */       primitiveResult = argResultSet.getLong(2);
/* 198 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 199 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 204 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 205 */       if (t3 != null) {
/* 206 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 209 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 214 */       long l1 = argResultSet.getLong(4);
/* 215 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 216 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 222 */       l1 = argResultSet.getLong(5);
/* 223 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 224 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 230 */       int i = argResultSet.getInt(6);
/* 231 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 232 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 237 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 238 */       if (t7 != null) {
/* 239 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 242 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 245 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 247 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 248 */       if (t9 != null) {
/* 249 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 252 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 255 */       this._parent._updateUserId = argResultSet.getString(10);
/* 256 */       this._parent._baseExtendedPrice = argResultSet.getBigDecimal(11);
/* 257 */       this._parent._baseUnitPrice = argResultSet.getBigDecimal(12);
/* 258 */       this._parent._merchLevel1Id = argResultSet.getString(13);
/* 259 */       this._parent._extendedAmount = argResultSet.getBigDecimal(14);
/*     */ 
/*     */       
/* 262 */       int j = argResultSet.getInt(15);
/* 263 */       if (j != 0 || argResultSet.getObject(15) != null) {
/* 264 */         this._parent._giftReceiptCount = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */       
/* 268 */       this._parent._grossAmount = argResultSet.getBigDecimal(16);
/* 269 */       this._parent._inventoryActionCode = argResultSet.getString(17);
/* 270 */       this._parent._itemId = argResultSet.getString(18);
/* 271 */       this._parent._itemIdEntryMethodCode = argResultSet.getString(19);
/* 272 */       this._parent._netAmount = argResultSet.getBigDecimal(20);
/* 273 */       this._parent._rptBaseUnitPrice = argResultSet.getBigDecimal(21);
/*     */       
/* 275 */       Timestamp t22 = argResultSet.getTimestamp(22);
/* 276 */       if (t22 != null) {
/* 277 */         this._parent._originalBusinessDate = (Date)new DtvDate(t22.getTime());
/*     */       } else {
/*     */         
/* 280 */         this._parent._originalBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 285 */       int k = argResultSet.getInt(23);
/* 286 */       if (k != 0 || argResultSet.getObject(23) != null) {
/* 287 */         this._parent._originalLineItemSequence = Integer.valueOf(k);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 293 */       long l2 = argResultSet.getLong(24);
/* 294 */       if (l2 != 0L || argResultSet.getObject(24) != null) {
/* 295 */         this._parent._originalRetailLocationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 301 */       l2 = argResultSet.getLong(25);
/* 302 */       if (l2 != 0L || argResultSet.getObject(25) != null) {
/* 303 */         this._parent._originalTransactionSequence = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 309 */       l2 = argResultSet.getLong(26);
/* 310 */       if (l2 != 0L || argResultSet.getObject(26) != null) {
/* 311 */         this._parent._originalWorkstationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 315 */       this._parent._priceDerivationMethodCode = argResultSet.getString(27);
/* 316 */       this._parent._priceEntryMethodCode = argResultSet.getString(28);
/* 317 */       this._parent._quantity = argResultSet.getBigDecimal(29);
/* 318 */       this._parent._returnComment = argResultSet.getString(30);
/* 319 */       this._parent._return = Boolean.valueOf(argResultSet.getBoolean(31));
/* 320 */       this._parent._returnTypeCode = argResultSet.getString(32);
/* 321 */       this._parent._saleReturnLineItemTypeCode = argResultSet.getString(33);
/* 322 */       this._parent._scannedItemId = argResultSet.getString(34);
/* 323 */       this._parent._serialNumber = argResultSet.getString(35);
/* 324 */       this._parent._enteredDescription = argResultSet.getString(36);
/* 325 */       this._parent._unitPrice = argResultSet.getBigDecimal(37);
/* 326 */       this._parent._vatAmount = argResultSet.getBigDecimal(38);
/* 327 */       this._parent._forceZeroExtendedAmt = Boolean.valueOf(argResultSet.getBoolean(39));
/* 328 */       this._parent._returnReasonCode = argResultSet.getString(40);
/* 329 */       this._parent._taxGroupId = argResultSet.getString(41);
/* 330 */       this._parent._netQuantity = argResultSet.getBigDecimal(42);
/* 331 */       this._parent._grossQuantity = argResultSet.getBigDecimal(43);
/* 332 */       this._parent._foodStampsAppliedAmount = argResultSet.getBigDecimal(44);
/* 333 */       this._parent._vendorId = argResultSet.getString(45);
/* 334 */       this._parent._regularBasePrice = argResultSet.getBigDecimal(46);
/* 335 */       this._parent._pricePropertyCode = argResultSet.getString(47);
/* 336 */       this._parent._shippingWeight = argResultSet.getBigDecimal(48);
/* 337 */       this._parent._unitCost = argResultSet.getBigDecimal(49);
/* 338 */       this._parent._attachedItemFlag = Boolean.valueOf(argResultSet.getBoolean(50));
/* 339 */       this._parent._initialQuantity = argResultSet.getBigDecimal(51);
/* 340 */       this._parent._notReturnable = Boolean.valueOf(argResultSet.getBoolean(52));
/* 341 */       this._parent._excludeFromNetSales = Boolean.valueOf(argResultSet.getBoolean(53));
/* 342 */       this._parent._measurementRequired = Boolean.valueOf(argResultSet.getBoolean(54));
/* 343 */       this._parent._weightEntryMethodCode = argResultSet.getString(55);
/* 344 */       this._parent._tareValue = argResultSet.getBigDecimal(56);
/* 345 */       this._parent._tareType = argResultSet.getString(57);
/* 346 */       this._parent._tareUnitOfMeasureCode = argResultSet.getString(58);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 352 */     super.loadDAO(argDAO);
/* 353 */     argDAO.suppressStateChanges(true);
/* 354 */     SaleReturnLineItemDAO dao = (SaleReturnLineItemDAO)argDAO;
/* 355 */     dao.setOrganizationId(this._organizationId);
/* 356 */     dao.setRetailLocationId(this._retailLocationId);
/* 357 */     dao.setBusinessDate(this._businessDate);
/* 358 */     dao.setWorkstationId(this._workstationId);
/* 359 */     dao.setTransactionSequence(this._transactionSequence);
/* 360 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 361 */     dao.setCreateDate(this._createDate);
/* 362 */     dao.setCreateUserId(this._createUserId);
/* 363 */     dao.setUpdateDate(this._updateDate);
/* 364 */     dao.setUpdateUserId(this._updateUserId);
/* 365 */     dao.setBaseExtendedPrice(this._baseExtendedPrice);
/* 366 */     dao.setBaseUnitPrice(this._baseUnitPrice);
/* 367 */     dao.setMerchLevel1Id(this._merchLevel1Id);
/* 368 */     dao.setExtendedAmount(this._extendedAmount);
/* 369 */     dao.setGiftReceiptCount(this._giftReceiptCount);
/* 370 */     dao.setGrossAmount(this._grossAmount);
/* 371 */     dao.setInventoryActionCode(this._inventoryActionCode);
/* 372 */     dao.setItemId(this._itemId);
/* 373 */     dao.setItemIdEntryMethodCode(this._itemIdEntryMethodCode);
/* 374 */     dao.setNetAmount(this._netAmount);
/* 375 */     dao.setRptBaseUnitPrice(this._rptBaseUnitPrice);
/* 376 */     dao.setOriginalBusinessDate(this._originalBusinessDate);
/* 377 */     dao.setOriginalLineItemSequence(this._originalLineItemSequence);
/* 378 */     dao.setOriginalRetailLocationId(this._originalRetailLocationId);
/* 379 */     dao.setOriginalTransactionSequence(this._originalTransactionSequence);
/* 380 */     dao.setOriginalWorkstationId(this._originalWorkstationId);
/* 381 */     dao.setPriceDerivationMethodCode(this._priceDerivationMethodCode);
/* 382 */     dao.setPriceEntryMethodCode(this._priceEntryMethodCode);
/* 383 */     dao.setQuantity(this._quantity);
/* 384 */     dao.setReturnComment(this._returnComment);
/* 385 */     dao.setReturn(this._return);
/* 386 */     dao.setReturnTypeCode(this._returnTypeCode);
/* 387 */     dao.setSaleReturnLineItemTypeCode(this._saleReturnLineItemTypeCode);
/* 388 */     dao.setScannedItemId(this._scannedItemId);
/* 389 */     dao.setSerialNumber(this._serialNumber);
/* 390 */     dao.setEnteredDescription(this._enteredDescription);
/* 391 */     dao.setUnitPrice(this._unitPrice);
/* 392 */     dao.setVatAmount(this._vatAmount);
/* 393 */     dao.setForceZeroExtendedAmt(this._forceZeroExtendedAmt);
/* 394 */     dao.setReturnReasonCode(this._returnReasonCode);
/* 395 */     dao.setTaxGroupId(this._taxGroupId);
/* 396 */     dao.setNetQuantity(this._netQuantity);
/* 397 */     dao.setGrossQuantity(this._grossQuantity);
/* 398 */     dao.setFoodStampsAppliedAmount(this._foodStampsAppliedAmount);
/* 399 */     dao.setVendorId(this._vendorId);
/* 400 */     dao.setRegularBasePrice(this._regularBasePrice);
/* 401 */     dao.setPricePropertyCode(this._pricePropertyCode);
/* 402 */     dao.setShippingWeight(this._shippingWeight);
/* 403 */     dao.setUnitCost(this._unitCost);
/* 404 */     dao.setAttachedItemFlag(this._attachedItemFlag);
/* 405 */     dao.setInitialQuantity(this._initialQuantity);
/* 406 */     dao.setNotReturnable(this._notReturnable);
/* 407 */     dao.setExcludeFromNetSales(this._excludeFromNetSales);
/* 408 */     dao.setMeasurementRequired(this._measurementRequired);
/* 409 */     dao.setWeightEntryMethodCode(this._weightEntryMethodCode);
/* 410 */     dao.setTareValue(this._tareValue);
/* 411 */     dao.setTareType(this._tareType);
/* 412 */     dao.setTareUnitOfMeasureCode(this._tareUnitOfMeasureCode);
/* 413 */     argDAO.suppressStateChanges(false);
/* 414 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 419 */     return loadDAO((IDataAccessObject)new SaleReturnLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 424 */     SaleReturnLineItemDAO dao = (SaleReturnLineItemDAO)argDAO;
/* 425 */     super.fill((IDataAccessObject)dao);
/* 426 */     this._organizationId = dao.getOrganizationId();
/* 427 */     this._retailLocationId = dao.getRetailLocationId();
/* 428 */     this._businessDate = dao.getBusinessDate();
/* 429 */     this._workstationId = dao.getWorkstationId();
/* 430 */     this._transactionSequence = dao.getTransactionSequence();
/* 431 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 432 */     this._createDate = dao.getCreateDate();
/* 433 */     this._createUserId = dao.getCreateUserId();
/* 434 */     this._updateDate = dao.getUpdateDate();
/* 435 */     this._updateUserId = dao.getUpdateUserId();
/* 436 */     this._baseExtendedPrice = dao.getBaseExtendedPrice();
/* 437 */     this._baseUnitPrice = dao.getBaseUnitPrice();
/* 438 */     this._merchLevel1Id = dao.getMerchLevel1Id();
/* 439 */     this._extendedAmount = dao.getExtendedAmount();
/* 440 */     this._giftReceiptCount = dao.getGiftReceiptCount();
/* 441 */     this._grossAmount = dao.getGrossAmount();
/* 442 */     this._inventoryActionCode = dao.getInventoryActionCode();
/* 443 */     this._itemId = dao.getItemId();
/* 444 */     this._itemIdEntryMethodCode = dao.getItemIdEntryMethodCode();
/* 445 */     this._netAmount = dao.getNetAmount();
/* 446 */     this._rptBaseUnitPrice = dao.getRptBaseUnitPrice();
/* 447 */     this._originalBusinessDate = dao.getOriginalBusinessDate();
/* 448 */     this._originalLineItemSequence = dao.getOriginalLineItemSequence();
/* 449 */     this._originalRetailLocationId = dao.getOriginalRetailLocationId();
/* 450 */     this._originalTransactionSequence = dao.getOriginalTransactionSequence();
/* 451 */     this._originalWorkstationId = dao.getOriginalWorkstationId();
/* 452 */     this._priceDerivationMethodCode = dao.getPriceDerivationMethodCode();
/* 453 */     this._priceEntryMethodCode = dao.getPriceEntryMethodCode();
/* 454 */     this._quantity = dao.getQuantity();
/* 455 */     this._returnComment = dao.getReturnComment();
/* 456 */     this._return = (dao.getReturn() != null) ? dao.getReturn() : Boolean.valueOf(false);
/* 457 */     this._returnTypeCode = dao.getReturnTypeCode();
/* 458 */     this._saleReturnLineItemTypeCode = dao.getSaleReturnLineItemTypeCode();
/* 459 */     this._scannedItemId = dao.getScannedItemId();
/* 460 */     this._serialNumber = dao.getSerialNumber();
/* 461 */     this._enteredDescription = dao.getEnteredDescription();
/* 462 */     this._unitPrice = dao.getUnitPrice();
/* 463 */     this._vatAmount = dao.getVatAmount();
/* 464 */     this._forceZeroExtendedAmt = (dao.getForceZeroExtendedAmt() != null) ? dao.getForceZeroExtendedAmt() : Boolean.valueOf(false);
/* 465 */     this._returnReasonCode = dao.getReturnReasonCode();
/* 466 */     this._taxGroupId = dao.getTaxGroupId();
/* 467 */     this._netQuantity = dao.getNetQuantity();
/* 468 */     this._grossQuantity = dao.getGrossQuantity();
/* 469 */     this._foodStampsAppliedAmount = dao.getFoodStampsAppliedAmount();
/* 470 */     this._vendorId = dao.getVendorId();
/* 471 */     this._regularBasePrice = dao.getRegularBasePrice();
/* 472 */     this._pricePropertyCode = dao.getPricePropertyCode();
/* 473 */     this._shippingWeight = dao.getShippingWeight();
/* 474 */     this._unitCost = dao.getUnitCost();
/* 475 */     this._attachedItemFlag = (dao.getAttachedItemFlag() != null) ? dao.getAttachedItemFlag() : Boolean.valueOf(false);
/* 476 */     this._initialQuantity = dao.getInitialQuantity();
/* 477 */     this._notReturnable = (dao.getNotReturnable() != null) ? dao.getNotReturnable() : Boolean.valueOf(false);
/* 478 */     this._excludeFromNetSales = (dao.getExcludeFromNetSales() != null) ? dao.getExcludeFromNetSales() : Boolean.valueOf(false);
/* 479 */     this._measurementRequired = (dao.getMeasurementRequired() != null) ? dao.getMeasurementRequired() : Boolean.valueOf(false);
/* 480 */     this._weightEntryMethodCode = dao.getWeightEntryMethodCode();
/* 481 */     this._tareValue = dao.getTareValue();
/* 482 */     this._tareType = dao.getTareType();
/* 483 */     this._tareUnitOfMeasureCode = dao.getTareUnitOfMeasureCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 488 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 489 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 490 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 491 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 492 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 493 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 494 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 495 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 499 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 503 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\SaleReturnLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */