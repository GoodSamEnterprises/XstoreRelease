/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerItemAccountDetailId;
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
/*     */ public class CustomerItemAccountDetailDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -2003297235L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Long _custAccountDetailNum;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _extendedAmount;
/*     */   private String _stateCode;
/*     */   private String _typeCode;
/*     */   private Date _origItemAddDate;
/*     */   private Date _scheduledPickupDate;
/*     */   private Date _businessDate;
/*     */   private Long _retailLocationId;
/*     */   private Long _sourceLocationId;
/*     */   private String _deliveryType;
/*     */   private Long _fullfillmentLocationId;
/*     */   private Date _receivedByCustDate;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private BigDecimal _netAmount;
/*     */   private BigDecimal _unitPrice;
/*     */   private BigDecimal _quantity;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.cust_item_acct_detail_item_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.extended_amt, t.item_acct_lineitm_statcode, t.line_typcode, t.original_item_add_date, t.scheduled_pickup_date, t.business_date, t.rtl_loc_id, t.source_loc_id, t.delivery_type_id, t.fullfillment_loc_id, t.received_by_cust_date, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.net_amt, t.unit_price, t.quantity FROM cat_cust_item_acct_detail t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND cust_item_acct_detail_item_nbr = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  54 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  58 */     return "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.cust_item_acct_detail_item_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.extended_amt, t.item_acct_lineitm_statcode, t.line_typcode, t.original_item_add_date, t.scheduled_pickup_date, t.business_date, t.rtl_loc_id, t.source_loc_id, t.delivery_type_id, t.fullfillment_loc_id, t.received_by_cust_date, t.rtrans_lineitm_seq, t.trans_seq, t.wkstn_id, t.net_amt, t.unit_price, t.quantity FROM cat_cust_item_acct_detail t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  64 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND cust_item_acct_detail_item_nbr = ?  ";
/*     */   }
/*     */   
/*  67 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_cust_item_acct_detail(organization_id, cust_acct_id, cust_acct_code, cust_item_acct_detail_item_nbr, create_date, create_user_id, update_date, update_user_id, extended_amt, item_acct_lineitm_statcode, line_typcode, original_item_add_date, scheduled_pickup_date, business_date, rtl_loc_id, source_loc_id, delivery_type_id, fullfillment_loc_id, received_by_cust_date, rtrans_lineitm_seq, trans_seq, wkstn_id, net_amt, unit_price, quantity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  70 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  74 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._custAccountCode, this._custAccountDetailNum, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._extendedAmount, this._stateCode, this._typeCode, this._origItemAddDate, this._scheduledPickupDate, this._businessDate, this._retailLocationId, this._sourceLocationId, this._deliveryType, this._fullfillmentLocationId, this._receivedByCustDate, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId, this._netAmount, this._unitPrice, this._quantity } };
/*  75 */     return insertParameterObject;
/*     */   }
/*     */   
/*  78 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, -5, 91, 12, 91, 12, 3, 12, 12, 91, 91, 91, -5, -5, 12, -5, 91, 4, -5, -5, 3, 3, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  81 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_cust_item_acct_detail SET update_date = ?, update_user_id = ?, extended_amt = ?, item_acct_lineitm_statcode = ?, line_typcode = ?, original_item_add_date = ?, scheduled_pickup_date = ?, business_date = ?, rtl_loc_id = ?, source_loc_id = ?, delivery_type_id = ?, fullfillment_loc_id = ?, received_by_cust_date = ?, rtrans_lineitm_seq = ?, trans_seq = ?, wkstn_id = ?, net_amt = ?, unit_price = ?, quantity = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  87 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  91 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._extendedAmount, this._stateCode, this._typeCode, this._origItemAddDate, this._scheduledPickupDate, this._businessDate, this._retailLocationId, this._sourceLocationId, this._deliveryType, this._fullfillmentLocationId, this._receivedByCustDate, this._retailTransactionLineItemSequence, this._transactionSequence, this._workstationId, this._netAmount, this._unitPrice, this._quantity } };
/*  92 */     return updateParameterObject;
/*     */   }
/*     */   
/*  95 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 12, 12, 91, 91, 91, -5, -5, 12, -5, 91, 4, -5, -5, 3, 3, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  97 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 100 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_cust_item_acct_detail" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND cust_item_acct_detail_item_nbr = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 103 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 109 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND cust_item_acct_detail_item_nbr = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 112 */     return new Object[] { this._organizationId, this._custAccountId, this._custAccountCode, this._custAccountDetailNum };
/*     */   }
/*     */   
/* 115 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 118 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 121 */     return "cat_cust_item_acct_detail";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 125 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 129 */     return new CustomerItemAccountDetailFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerItemAccountDetailFiller
/*     */     implements IFiller {
/*     */     private CustomerItemAccountDetailDBA _parent;
/*     */     
/*     */     public CustomerItemAccountDetailFiller(CustomerItemAccountDetailDBA argParent) {
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
/* 148 */       this._parent._custAccountId = argResultSet.getString(2);
/* 149 */       this._parent._custAccountCode = argResultSet.getString(3);
/*     */ 
/*     */       
/* 152 */       primitiveResult = argResultSet.getLong(4);
/* 153 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 154 */         this._parent._custAccountDetailNum = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 159 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 160 */       if (t5 != null) {
/* 161 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 167 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 169 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 170 */       if (t7 != null) {
/* 171 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 174 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 177 */       this._parent._updateUserId = argResultSet.getString(8);
/* 178 */       this._parent._extendedAmount = argResultSet.getBigDecimal(9);
/* 179 */       this._parent._stateCode = argResultSet.getString(10);
/* 180 */       this._parent._typeCode = argResultSet.getString(11);
/*     */       
/* 182 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 183 */       if (t12 != null) {
/* 184 */         this._parent._origItemAddDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 187 */         this._parent._origItemAddDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 191 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 192 */       if (t13 != null) {
/* 193 */         this._parent._scheduledPickupDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 196 */         this._parent._scheduledPickupDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 200 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 201 */       if (t14 != null) {
/* 202 */         this._parent._businessDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 205 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 210 */       long l1 = argResultSet.getLong(15);
/* 211 */       if (l1 != 0L || argResultSet.getObject(15) != null) {
/* 212 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 218 */       l1 = argResultSet.getLong(16);
/* 219 */       if (l1 != 0L || argResultSet.getObject(16) != null) {
/* 220 */         this._parent._sourceLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 224 */       this._parent._deliveryType = argResultSet.getString(17);
/*     */ 
/*     */       
/* 227 */       l1 = argResultSet.getLong(18);
/* 228 */       if (l1 != 0L || argResultSet.getObject(18) != null) {
/* 229 */         this._parent._fullfillmentLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 234 */       Timestamp t19 = argResultSet.getTimestamp(19);
/* 235 */       if (t19 != null) {
/* 236 */         this._parent._receivedByCustDate = (Date)new DtvDate(t19.getTime());
/*     */       } else {
/*     */         
/* 239 */         this._parent._receivedByCustDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 244 */       int i = argResultSet.getInt(20);
/* 245 */       if (i != 0 || argResultSet.getObject(20) != null) {
/* 246 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 252 */       long l2 = argResultSet.getLong(21);
/* 253 */       if (l2 != 0L || argResultSet.getObject(21) != null) {
/* 254 */         this._parent._transactionSequence = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 260 */       l2 = argResultSet.getLong(22);
/* 261 */       if (l2 != 0L || argResultSet.getObject(22) != null) {
/* 262 */         this._parent._workstationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 266 */       this._parent._netAmount = argResultSet.getBigDecimal(23);
/* 267 */       this._parent._unitPrice = argResultSet.getBigDecimal(24);
/* 268 */       this._parent._quantity = argResultSet.getBigDecimal(25);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 273 */     argDAO.suppressStateChanges(true);
/* 274 */     CustomerItemAccountDetailDAO dao = (CustomerItemAccountDetailDAO)argDAO;
/* 275 */     dao.setOrganizationId(this._organizationId);
/* 276 */     dao.setCustAccountId(this._custAccountId);
/* 277 */     dao.setCustAccountCode(this._custAccountCode);
/* 278 */     dao.setCustAccountDetailNum(this._custAccountDetailNum);
/* 279 */     dao.setCreateDate(this._createDate);
/* 280 */     dao.setCreateUserId(this._createUserId);
/* 281 */     dao.setUpdateDate(this._updateDate);
/* 282 */     dao.setUpdateUserId(this._updateUserId);
/* 283 */     dao.setExtendedAmount(this._extendedAmount);
/* 284 */     dao.setStateCode(this._stateCode);
/* 285 */     dao.setTypeCode(this._typeCode);
/* 286 */     dao.setOrigItemAddDate(this._origItemAddDate);
/* 287 */     dao.setScheduledPickupDate(this._scheduledPickupDate);
/* 288 */     dao.setBusinessDate(this._businessDate);
/* 289 */     dao.setRetailLocationId(this._retailLocationId);
/* 290 */     dao.setSourceLocationId(this._sourceLocationId);
/* 291 */     dao.setDeliveryType(this._deliveryType);
/* 292 */     dao.setFullfillmentLocationId(this._fullfillmentLocationId);
/* 293 */     dao.setReceivedByCustDate(this._receivedByCustDate);
/* 294 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 295 */     dao.setTransactionSequence(this._transactionSequence);
/* 296 */     dao.setWorkstationId(this._workstationId);
/* 297 */     dao.setNetAmount(this._netAmount);
/* 298 */     dao.setUnitPrice(this._unitPrice);
/* 299 */     dao.setQuantity(this._quantity);
/* 300 */     argDAO.suppressStateChanges(false);
/* 301 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 305 */     return loadDAO((IDataAccessObject)new CustomerItemAccountDetailDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 309 */     CustomerItemAccountDetailDAO dao = (CustomerItemAccountDetailDAO)argDAO;
/* 310 */     this._organizationId = dao.getOrganizationId();
/* 311 */     this._custAccountId = dao.getCustAccountId();
/* 312 */     this._custAccountCode = dao.getCustAccountCode();
/* 313 */     this._custAccountDetailNum = dao.getCustAccountDetailNum();
/* 314 */     this._createDate = dao.getCreateDate();
/* 315 */     this._createUserId = dao.getCreateUserId();
/* 316 */     this._updateDate = dao.getUpdateDate();
/* 317 */     this._updateUserId = dao.getUpdateUserId();
/* 318 */     this._extendedAmount = dao.getExtendedAmount();
/* 319 */     this._stateCode = dao.getStateCode();
/* 320 */     this._typeCode = dao.getTypeCode();
/* 321 */     this._origItemAddDate = dao.getOrigItemAddDate();
/* 322 */     this._scheduledPickupDate = dao.getScheduledPickupDate();
/* 323 */     this._businessDate = dao.getBusinessDate();
/* 324 */     this._retailLocationId = dao.getRetailLocationId();
/* 325 */     this._sourceLocationId = dao.getSourceLocationId();
/* 326 */     this._deliveryType = dao.getDeliveryType();
/* 327 */     this._fullfillmentLocationId = dao.getFullfillmentLocationId();
/* 328 */     this._receivedByCustDate = dao.getReceivedByCustDate();
/* 329 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 330 */     this._transactionSequence = dao.getTransactionSequence();
/* 331 */     this._workstationId = dao.getWorkstationId();
/* 332 */     this._netAmount = dao.getNetAmount();
/* 333 */     this._unitPrice = dao.getUnitPrice();
/* 334 */     this._quantity = dao.getQuantity();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 338 */     CustomerItemAccountDetailId id = (CustomerItemAccountDetailId)argId;
/* 339 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 340 */     argStatement.setString(2, id.getCustAccountId());
/* 341 */     argStatement.setString(3, id.getCustAccountCode());
/* 342 */     argStatement.setLong(4, id.getCustAccountDetailNum().longValue());
/* 343 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 347 */     CustomerItemAccountDetailId id = new CustomerItemAccountDetailId();
/* 348 */     id.setOrganizationId(this._organizationId);
/* 349 */     id.setCustAccountId(this._custAccountId);
/* 350 */     id.setCustAccountCode(this._custAccountCode);
/* 351 */     id.setCustAccountDetailNum(this._custAccountDetailNum);
/* 352 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 360 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 364 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerItemAccountDetailDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */