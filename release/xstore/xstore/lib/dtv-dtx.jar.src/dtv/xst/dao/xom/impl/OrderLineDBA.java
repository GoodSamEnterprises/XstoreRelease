/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.OrderLineId;
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
/*     */ public class OrderLineDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1612149826L;
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _externalOrderId;
/*     */   private String _itemId;
/*     */   private BigDecimal _quantity;
/*     */   private String _fulfillmentType;
/*     */   private String _statusCode;
/*     */   private BigDecimal _unitPrice;
/*     */   private BigDecimal _extendedPrice;
/*     */   private BigDecimal _taxAmount;
/*     */   private String _notes;
/*     */   private String _selectedShipMethod;
/*     */   private String _actualShipMethod;
/*     */   private String _trackingNumber;
/*     */   private Boolean _dropShip;
/*     */   private Boolean _void;
/*     */   private String _statusCodeReason;
/*     */   private Integer _lineNumber;
/*     */   private String _statusCodeReasonNote;
/*     */   private String _itemUpcCode;
/*     */   private String _itemEanCode;
/*     */   private BigDecimal _extendedFreight;
/*     */   private BigDecimal _customizationCharge;
/*     */   private Boolean _giftWrap;
/*     */   private Boolean _shipAlone;
/*     */   private BigDecimal _shipWeight;
/*     */   private String _lineMessage;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.order_id, t.detail_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.external_order_id, t.item_id, t.quantity, t.fulfillment_type, t.status_code, t.unit_price, t.extended_price, t.tax_amount, t.notes, t.selected_ship_method, t.actual_ship_method, t.tracking_nbr, t.drop_ship_flag, t.void_flag, t.status_code_reason, t.line_no, t.status_code_reason_note, t.item_upc_code, t.item_ean_code, t.extended_freight, t.customization_charge, t.gift_wrap_flag, t.ship_alone_flag, t.ship_weight, t.line_message FROM xom_order_line t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  61 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  65 */     return "SELECT t.organization_id, t.order_id, t.detail_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.external_order_id, t.item_id, t.quantity, t.fulfillment_type, t.status_code, t.unit_price, t.extended_price, t.tax_amount, t.notes, t.selected_ship_method, t.actual_ship_method, t.tracking_nbr, t.drop_ship_flag, t.void_flag, t.status_code_reason, t.line_no, t.status_code_reason_note, t.item_upc_code, t.item_ean_code, t.extended_freight, t.customization_charge, t.gift_wrap_flag, t.ship_alone_flag, t.ship_weight, t.line_message FROM xom_order_line t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  71 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   }
/*     */   
/*  74 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO xom_order_line(organization_id, order_id, detail_seq, create_date, create_user_id, update_date, update_user_id, external_order_id, item_id, quantity, fulfillment_type, status_code, unit_price, extended_price, tax_amount, notes, selected_ship_method, actual_ship_method, tracking_nbr, drop_ship_flag, void_flag, status_code_reason, line_no, status_code_reason_note, item_upc_code, item_ean_code, extended_freight, customization_charge, gift_wrap_flag, ship_alone_flag, ship_weight, line_message) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  77 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  81 */     Object[][] insertParameterObject = { { this._organizationId, this._orderId, this._sequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._externalOrderId, this._itemId, this._quantity, this._fulfillmentType, this._statusCode, this._unitPrice, this._extendedPrice, this._taxAmount, this._notes, this._selectedShipMethod, this._actualShipMethod, this._trackingNumber, this._dropShip, this._void, this._statusCodeReason, this._lineNumber, this._statusCodeReasonNote, this._itemUpcCode, this._itemEanCode, this._extendedFreight, this._customizationCharge, this._giftWrap, this._shipAlone, this._shipWeight, this._lineMessage } };
/*  82 */     return insertParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 91, 12, 91, 12, 12, 12, 3, 12, 12, 3, 3, 3, 12, 12, 12, 12, -7, -7, 12, 4, 12, 12, 12, 3, 3, -7, -7, 3, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  88 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE xom_order_line SET update_date = ?, update_user_id = ?, external_order_id = ?, item_id = ?, quantity = ?, fulfillment_type = ?, status_code = ?, unit_price = ?, extended_price = ?, tax_amount = ?, notes = ?, selected_ship_method = ?, actual_ship_method = ?, tracking_nbr = ?, drop_ship_flag = ?, void_flag = ?, status_code_reason = ?, line_no = ?, status_code_reason_note = ?, item_upc_code = ?, item_ean_code = ?, extended_freight = ?, customization_charge = ?, gift_wrap_flag = ?, ship_alone_flag = ?, ship_weight = ?, line_message = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  94 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  98 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._externalOrderId, this._itemId, this._quantity, this._fulfillmentType, this._statusCode, this._unitPrice, this._extendedPrice, this._taxAmount, this._notes, this._selectedShipMethod, this._actualShipMethod, this._trackingNumber, this._dropShip, this._void, this._statusCodeReason, this._lineNumber, this._statusCodeReasonNote, this._itemUpcCode, this._itemEanCode, this._extendedFreight, this._customizationCharge, this._giftWrap, this._shipAlone, this._shipWeight, this._lineMessage } };
/*  99 */     return updateParameterObject;
/*     */   }
/*     */   
/* 102 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 3, 12, 12, 3, 3, 3, 12, 12, 12, 12, -7, -7, 12, 4, 12, 12, 12, 3, 3, -7, -7, 3, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 104 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 107 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM xom_order_line" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 110 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 116 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 119 */     return new Object[] { this._organizationId, this._orderId, this._sequence };
/*     */   }
/*     */   
/* 122 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 125 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 128 */     return "xom_order_line";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 132 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 136 */     return new OrderLineFiller(this);
/*     */   }
/*     */   
/*     */   private static class OrderLineFiller
/*     */     implements IFiller {
/*     */     private OrderLineDBA _parent;
/*     */     
/*     */     public OrderLineFiller(OrderLineDBA argParent) {
/* 144 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 149 */       long l = argResultSet.getLong(1);
/* 150 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 151 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 155 */       this._parent._orderId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 158 */       int primitiveResult = argResultSet.getInt(3);
/* 159 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 160 */         this._parent._sequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 165 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 166 */       if (t4 != null) {
/* 167 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 175 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 176 */       if (t6 != null) {
/* 177 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 183 */       this._parent._updateUserId = argResultSet.getString(7);
/* 184 */       this._parent._externalOrderId = argResultSet.getString(8);
/* 185 */       this._parent._itemId = argResultSet.getString(9);
/* 186 */       this._parent._quantity = argResultSet.getBigDecimal(10);
/* 187 */       this._parent._fulfillmentType = argResultSet.getString(11);
/* 188 */       this._parent._statusCode = argResultSet.getString(12);
/* 189 */       this._parent._unitPrice = argResultSet.getBigDecimal(13);
/* 190 */       this._parent._extendedPrice = argResultSet.getBigDecimal(14);
/* 191 */       this._parent._taxAmount = argResultSet.getBigDecimal(15);
/* 192 */       this._parent._notes = argResultSet.getString(16);
/* 193 */       this._parent._selectedShipMethod = argResultSet.getString(17);
/* 194 */       this._parent._actualShipMethod = argResultSet.getString(18);
/* 195 */       this._parent._trackingNumber = argResultSet.getString(19);
/* 196 */       this._parent._dropShip = Boolean.valueOf(argResultSet.getBoolean(20));
/* 197 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(21));
/* 198 */       this._parent._statusCodeReason = argResultSet.getString(22);
/*     */ 
/*     */       
/* 201 */       int i = argResultSet.getInt(23);
/* 202 */       if (i != 0 || argResultSet.getObject(23) != null) {
/* 203 */         this._parent._lineNumber = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 207 */       this._parent._statusCodeReasonNote = argResultSet.getString(24);
/* 208 */       this._parent._itemUpcCode = argResultSet.getString(25);
/* 209 */       this._parent._itemEanCode = argResultSet.getString(26);
/* 210 */       this._parent._extendedFreight = argResultSet.getBigDecimal(27);
/* 211 */       this._parent._customizationCharge = argResultSet.getBigDecimal(28);
/* 212 */       this._parent._giftWrap = Boolean.valueOf(argResultSet.getBoolean(29));
/* 213 */       this._parent._shipAlone = Boolean.valueOf(argResultSet.getBoolean(30));
/* 214 */       this._parent._shipWeight = argResultSet.getBigDecimal(31);
/* 215 */       this._parent._lineMessage = argResultSet.getString(32);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 220 */     argDAO.suppressStateChanges(true);
/* 221 */     OrderLineDAO dao = (OrderLineDAO)argDAO;
/* 222 */     dao.setOrganizationId(this._organizationId);
/* 223 */     dao.setOrderId(this._orderId);
/* 224 */     dao.setSequence(this._sequence);
/* 225 */     dao.setCreateDate(this._createDate);
/* 226 */     dao.setCreateUserId(this._createUserId);
/* 227 */     dao.setUpdateDate(this._updateDate);
/* 228 */     dao.setUpdateUserId(this._updateUserId);
/* 229 */     dao.setExternalOrderId(this._externalOrderId);
/* 230 */     dao.setItemId(this._itemId);
/* 231 */     dao.setQuantity(this._quantity);
/* 232 */     dao.setFulfillmentType(this._fulfillmentType);
/* 233 */     dao.setStatusCode(this._statusCode);
/* 234 */     dao.setUnitPrice(this._unitPrice);
/* 235 */     dao.setExtendedPrice(this._extendedPrice);
/* 236 */     dao.setTaxAmount(this._taxAmount);
/* 237 */     dao.setNotes(this._notes);
/* 238 */     dao.setSelectedShipMethod(this._selectedShipMethod);
/* 239 */     dao.setActualShipMethod(this._actualShipMethod);
/* 240 */     dao.setTrackingNumber(this._trackingNumber);
/* 241 */     dao.setDropShip(this._dropShip);
/* 242 */     dao.setVoid(this._void);
/* 243 */     dao.setStatusCodeReason(this._statusCodeReason);
/* 244 */     dao.setLineNumber(this._lineNumber);
/* 245 */     dao.setStatusCodeReasonNote(this._statusCodeReasonNote);
/* 246 */     dao.setItemUpcCode(this._itemUpcCode);
/* 247 */     dao.setItemEanCode(this._itemEanCode);
/* 248 */     dao.setExtendedFreight(this._extendedFreight);
/* 249 */     dao.setCustomizationCharge(this._customizationCharge);
/* 250 */     dao.setGiftWrap(this._giftWrap);
/* 251 */     dao.setShipAlone(this._shipAlone);
/* 252 */     dao.setShipWeight(this._shipWeight);
/* 253 */     dao.setLineMessage(this._lineMessage);
/* 254 */     argDAO.suppressStateChanges(false);
/* 255 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 259 */     return loadDAO((IDataAccessObject)new OrderLineDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 263 */     OrderLineDAO dao = (OrderLineDAO)argDAO;
/* 264 */     this._organizationId = dao.getOrganizationId();
/* 265 */     this._orderId = dao.getOrderId();
/* 266 */     this._sequence = dao.getSequence();
/* 267 */     this._createDate = dao.getCreateDate();
/* 268 */     this._createUserId = dao.getCreateUserId();
/* 269 */     this._updateDate = dao.getUpdateDate();
/* 270 */     this._updateUserId = dao.getUpdateUserId();
/* 271 */     this._externalOrderId = dao.getExternalOrderId();
/* 272 */     this._itemId = dao.getItemId();
/* 273 */     this._quantity = dao.getQuantity();
/* 274 */     this._fulfillmentType = dao.getFulfillmentType();
/* 275 */     this._statusCode = dao.getStatusCode();
/* 276 */     this._unitPrice = dao.getUnitPrice();
/* 277 */     this._extendedPrice = dao.getExtendedPrice();
/* 278 */     this._taxAmount = dao.getTaxAmount();
/* 279 */     this._notes = dao.getNotes();
/* 280 */     this._selectedShipMethod = dao.getSelectedShipMethod();
/* 281 */     this._actualShipMethod = dao.getActualShipMethod();
/* 282 */     this._trackingNumber = dao.getTrackingNumber();
/* 283 */     this._dropShip = (dao.getDropShip() != null) ? dao.getDropShip() : Boolean.valueOf(false);
/* 284 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/* 285 */     this._statusCodeReason = dao.getStatusCodeReason();
/* 286 */     this._lineNumber = dao.getLineNumber();
/* 287 */     this._statusCodeReasonNote = dao.getStatusCodeReasonNote();
/* 288 */     this._itemUpcCode = dao.getItemUpcCode();
/* 289 */     this._itemEanCode = dao.getItemEanCode();
/* 290 */     this._extendedFreight = dao.getExtendedFreight();
/* 291 */     this._customizationCharge = dao.getCustomizationCharge();
/* 292 */     this._giftWrap = (dao.getGiftWrap() != null) ? dao.getGiftWrap() : Boolean.valueOf(false);
/* 293 */     this._shipAlone = (dao.getShipAlone() != null) ? dao.getShipAlone() : Boolean.valueOf(false);
/* 294 */     this._shipWeight = dao.getShipWeight();
/* 295 */     this._lineMessage = dao.getLineMessage();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 299 */     OrderLineId id = (OrderLineId)argId;
/* 300 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 301 */     argStatement.setString(2, id.getOrderId());
/* 302 */     argStatement.setInt(3, id.getSequence().intValue());
/* 303 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 307 */     OrderLineId id = new OrderLineId();
/* 308 */     id.setOrganizationId(this._organizationId);
/* 309 */     id.setOrderId(this._orderId);
/* 310 */     id.setSequence(this._sequence);
/* 311 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 319 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 323 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\OrderLineDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */