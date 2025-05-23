/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.OrderId;
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
/*     */ public class OrderDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 76453678L;
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orderType;
/*     */   private String _statusCode;
/*     */   private Date _orderDate;
/*     */   private String _orderLocationId;
/*     */   private BigDecimal _subtotal;
/*     */   private BigDecimal _taxAmount;
/*     */   private BigDecimal _total;
/*     */   private BigDecimal _balanceDue;
/*     */   private String _notes;
/*     */   private String _referenceNumber;
/*     */   private BigDecimal _additionalFreightCharges;
/*     */   private BigDecimal _additionalCharges;
/*     */   private Boolean _shipComplete;
/*     */   private BigDecimal _freightTax;
/*     */   private String _orderMessage;
/*     */   private String _giftMessage;
/*     */   private Boolean _underReview;
/*     */   private String _statusCodeReason;
/*     */   private String _statusCodeReasonNote;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.order_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.order_type, t.status_code, t.order_date, t.order_loc_id, t.subtotal, t.tax_amount, t.total, t.balance_due, t.notes, t.ref_nbr, t.additional_freight_charges, t.additional_charges, t.ship_complete_flag, t.freight_tax, t.order_message, t.gift_message, t.under_review_flag, t.status_code_reason, t.status_code_reason_note FROM xom_order t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  54 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  58 */     return "SELECT t.organization_id, t.order_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.order_type, t.status_code, t.order_date, t.order_loc_id, t.subtotal, t.tax_amount, t.total, t.balance_due, t.notes, t.ref_nbr, t.additional_freight_charges, t.additional_charges, t.ship_complete_flag, t.freight_tax, t.order_message, t.gift_message, t.under_review_flag, t.status_code_reason, t.status_code_reason_note FROM xom_order t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  64 */     return " WHERE organization_id = ?  AND order_id = ?  ";
/*     */   }
/*     */   
/*  67 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO xom_order(organization_id, order_id, create_date, create_user_id, update_date, update_user_id, order_type, status_code, order_date, order_loc_id, subtotal, tax_amount, total, balance_due, notes, ref_nbr, additional_freight_charges, additional_charges, ship_complete_flag, freight_tax, order_message, gift_message, under_review_flag, status_code_reason, status_code_reason_note) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  70 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  74 */     Object[][] insertParameterObject = { { this._organizationId, this._orderId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._orderType, this._statusCode, this._orderDate, this._orderLocationId, this._subtotal, this._taxAmount, this._total, this._balanceDue, this._notes, this._referenceNumber, this._additionalFreightCharges, this._additionalCharges, this._shipComplete, this._freightTax, this._orderMessage, this._giftMessage, this._underReview, this._statusCodeReason, this._statusCodeReasonNote } };
/*  75 */     return insertParameterObject;
/*     */   }
/*     */   
/*  78 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 12, 91, 12, 3, 3, 3, 3, 12, 12, 3, 3, -7, 3, 12, 12, -7, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  81 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE xom_order SET update_date = ?, update_user_id = ?, order_type = ?, status_code = ?, order_date = ?, order_loc_id = ?, subtotal = ?, tax_amount = ?, total = ?, balance_due = ?, notes = ?, ref_nbr = ?, additional_freight_charges = ?, additional_charges = ?, ship_complete_flag = ?, freight_tax = ?, order_message = ?, gift_message = ?, under_review_flag = ?, status_code_reason = ?, status_code_reason_note = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  87 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  91 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orderType, this._statusCode, this._orderDate, this._orderLocationId, this._subtotal, this._taxAmount, this._total, this._balanceDue, this._notes, this._referenceNumber, this._additionalFreightCharges, this._additionalCharges, this._shipComplete, this._freightTax, this._orderMessage, this._giftMessage, this._underReview, this._statusCodeReason, this._statusCodeReasonNote } };
/*  92 */     return updateParameterObject;
/*     */   }
/*     */   
/*  95 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 91, 12, 3, 3, 3, 3, 12, 12, 3, 3, -7, 3, 12, 12, -7, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  97 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 100 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM xom_order" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 103 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 109 */     return " WHERE organization_id = ?  AND order_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 112 */     return new Object[] { this._organizationId, this._orderId };
/*     */   }
/*     */   
/* 115 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 118 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 121 */     return "xom_order";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 125 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 129 */     return new OrderFiller(this);
/*     */   }
/*     */   
/*     */   private static class OrderFiller
/*     */     implements IFiller {
/*     */     private OrderDBA _parent;
/*     */     
/*     */     public OrderFiller(OrderDBA argParent) {
/* 137 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 142 */       long primitiveResult = argResultSet.getLong(1);
/* 143 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 144 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 148 */       this._parent._orderId = argResultSet.getString(2);
/*     */       
/* 150 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 151 */       if (t3 != null) {
/* 152 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 155 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 158 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 160 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 161 */       if (t5 != null) {
/* 162 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 165 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 168 */       this._parent._updateUserId = argResultSet.getString(6);
/* 169 */       this._parent._orderType = argResultSet.getString(7);
/* 170 */       this._parent._statusCode = argResultSet.getString(8);
/*     */       
/* 172 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 173 */       if (t9 != null) {
/* 174 */         this._parent._orderDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 177 */         this._parent._orderDate = null;
/*     */       } 
/*     */       
/* 180 */       this._parent._orderLocationId = argResultSet.getString(10);
/* 181 */       this._parent._subtotal = argResultSet.getBigDecimal(11);
/* 182 */       this._parent._taxAmount = argResultSet.getBigDecimal(12);
/* 183 */       this._parent._total = argResultSet.getBigDecimal(13);
/* 184 */       this._parent._balanceDue = argResultSet.getBigDecimal(14);
/* 185 */       this._parent._notes = argResultSet.getString(15);
/* 186 */       this._parent._referenceNumber = argResultSet.getString(16);
/* 187 */       this._parent._additionalFreightCharges = argResultSet.getBigDecimal(17);
/* 188 */       this._parent._additionalCharges = argResultSet.getBigDecimal(18);
/* 189 */       this._parent._shipComplete = Boolean.valueOf(argResultSet.getBoolean(19));
/* 190 */       this._parent._freightTax = argResultSet.getBigDecimal(20);
/* 191 */       this._parent._orderMessage = argResultSet.getString(21);
/* 192 */       this._parent._giftMessage = argResultSet.getString(22);
/* 193 */       this._parent._underReview = Boolean.valueOf(argResultSet.getBoolean(23));
/* 194 */       this._parent._statusCodeReason = argResultSet.getString(24);
/* 195 */       this._parent._statusCodeReasonNote = argResultSet.getString(25);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 200 */     argDAO.suppressStateChanges(true);
/* 201 */     OrderDAO dao = (OrderDAO)argDAO;
/* 202 */     dao.setOrganizationId(this._organizationId);
/* 203 */     dao.setOrderId(this._orderId);
/* 204 */     dao.setCreateDate(this._createDate);
/* 205 */     dao.setCreateUserId(this._createUserId);
/* 206 */     dao.setUpdateDate(this._updateDate);
/* 207 */     dao.setUpdateUserId(this._updateUserId);
/* 208 */     dao.setOrderType(this._orderType);
/* 209 */     dao.setStatusCode(this._statusCode);
/* 210 */     dao.setOrderDate(this._orderDate);
/* 211 */     dao.setOrderLocationId(this._orderLocationId);
/* 212 */     dao.setSubtotal(this._subtotal);
/* 213 */     dao.setTaxAmount(this._taxAmount);
/* 214 */     dao.setTotal(this._total);
/* 215 */     dao.setBalanceDue(this._balanceDue);
/* 216 */     dao.setNotes(this._notes);
/* 217 */     dao.setReferenceNumber(this._referenceNumber);
/* 218 */     dao.setAdditionalFreightCharges(this._additionalFreightCharges);
/* 219 */     dao.setAdditionalCharges(this._additionalCharges);
/* 220 */     dao.setShipComplete(this._shipComplete);
/* 221 */     dao.setFreightTax(this._freightTax);
/* 222 */     dao.setOrderMessage(this._orderMessage);
/* 223 */     dao.setGiftMessage(this._giftMessage);
/* 224 */     dao.setUnderReview(this._underReview);
/* 225 */     dao.setStatusCodeReason(this._statusCodeReason);
/* 226 */     dao.setStatusCodeReasonNote(this._statusCodeReasonNote);
/* 227 */     argDAO.suppressStateChanges(false);
/* 228 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 232 */     return loadDAO((IDataAccessObject)new OrderDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 236 */     OrderDAO dao = (OrderDAO)argDAO;
/* 237 */     this._organizationId = dao.getOrganizationId();
/* 238 */     this._orderId = dao.getOrderId();
/* 239 */     this._createDate = dao.getCreateDate();
/* 240 */     this._createUserId = dao.getCreateUserId();
/* 241 */     this._updateDate = dao.getUpdateDate();
/* 242 */     this._updateUserId = dao.getUpdateUserId();
/* 243 */     this._orderType = dao.getOrderType();
/* 244 */     this._statusCode = dao.getStatusCode();
/* 245 */     this._orderDate = dao.getOrderDate();
/* 246 */     this._orderLocationId = dao.getOrderLocationId();
/* 247 */     this._subtotal = dao.getSubtotal();
/* 248 */     this._taxAmount = dao.getTaxAmount();
/* 249 */     this._total = dao.getTotal();
/* 250 */     this._balanceDue = dao.getBalanceDue();
/* 251 */     this._notes = dao.getNotes();
/* 252 */     this._referenceNumber = dao.getReferenceNumber();
/* 253 */     this._additionalFreightCharges = dao.getAdditionalFreightCharges();
/* 254 */     this._additionalCharges = dao.getAdditionalCharges();
/* 255 */     this._shipComplete = (dao.getShipComplete() != null) ? dao.getShipComplete() : Boolean.valueOf(false);
/* 256 */     this._freightTax = dao.getFreightTax();
/* 257 */     this._orderMessage = dao.getOrderMessage();
/* 258 */     this._giftMessage = dao.getGiftMessage();
/* 259 */     this._underReview = (dao.getUnderReview() != null) ? dao.getUnderReview() : Boolean.valueOf(false);
/* 260 */     this._statusCodeReason = dao.getStatusCodeReason();
/* 261 */     this._statusCodeReasonNote = dao.getStatusCodeReasonNote();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 265 */     OrderId id = (OrderId)argId;
/* 266 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 267 */     argStatement.setString(2, id.getOrderId());
/* 268 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 272 */     OrderId id = new OrderId();
/* 273 */     id.setOrganizationId(this._organizationId);
/* 274 */     id.setOrderId(this._orderId);
/* 275 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 283 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 287 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\OrderDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */