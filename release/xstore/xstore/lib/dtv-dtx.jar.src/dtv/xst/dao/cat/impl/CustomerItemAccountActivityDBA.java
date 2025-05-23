/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerItemAccountActivityId;
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
/*     */ public class CustomerItemAccountActivityDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 570978283L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Long _custAccountDetailNum;
/*     */   private Long _sequenceNumber;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _extendedAmount;
/*     */   private Date _activityDateTime;
/*     */   private String _activityCode;
/*     */   private String _accountLineItemStateCode;
/*     */   private String _typeCode;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _businessDate;
/*     */   private Long _transSequence;
/*     */   private Long _transLineItemSeq;
/*     */   private BigDecimal _netAmount;
/*     */   private BigDecimal _unitPrice;
/*     */   private BigDecimal _quantity;
/*     */   private Date _scheduledPickupDate;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.cust_item_acct_detail_item_nbr, t.seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.extended_amt, t.activity_datetime, t.item_acct_activity_code, t.item_acct_lineitm_statcode, t.line_typcode, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.rtrans_lineitm_seq, t.net_amt, t.unit_price, t.quantity, t.scheduled_pickup_date FROM cat_cust_item_acct_activity t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND cust_item_acct_detail_item_nbr = ?  AND seq_nbr = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  52 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  56 */     return "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.cust_item_acct_detail_item_nbr, t.seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.extended_amt, t.activity_datetime, t.item_acct_activity_code, t.item_acct_lineitm_statcode, t.line_typcode, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.rtrans_lineitm_seq, t.net_amt, t.unit_price, t.quantity, t.scheduled_pickup_date FROM cat_cust_item_acct_activity t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  62 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND cust_item_acct_detail_item_nbr = ?  AND seq_nbr = ?  ";
/*     */   }
/*     */   
/*  65 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_cust_item_acct_activity(organization_id, cust_acct_id, cust_acct_code, cust_item_acct_detail_item_nbr, seq_nbr, create_date, create_user_id, update_date, update_user_id, extended_amt, activity_datetime, item_acct_activity_code, item_acct_lineitm_statcode, line_typcode, rtl_loc_id, wkstn_id, business_date, trans_seq, rtrans_lineitm_seq, net_amt, unit_price, quantity, scheduled_pickup_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  68 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  72 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._custAccountCode, this._custAccountDetailNum, this._sequenceNumber, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._extendedAmount, this._activityDateTime, this._activityCode, this._accountLineItemStateCode, this._typeCode, this._retailLocationId, this._workstationId, this._businessDate, this._transSequence, this._transLineItemSeq, this._netAmount, this._unitPrice, this._quantity, this._scheduledPickupDate } };
/*  73 */     return insertParameterObject;
/*     */   }
/*     */   
/*  76 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, -5, -5, 91, 12, 91, 12, 3, 91, 12, 12, 12, -5, -5, 91, -5, -5, 3, 3, 3, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  79 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  82 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_cust_item_acct_activity SET update_date = ?, update_user_id = ?, extended_amt = ?, activity_datetime = ?, item_acct_activity_code = ?, item_acct_lineitm_statcode = ?, line_typcode = ?, rtl_loc_id = ?, wkstn_id = ?, business_date = ?, trans_seq = ?, rtrans_lineitm_seq = ?, net_amt = ?, unit_price = ?, quantity = ?, scheduled_pickup_date = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  85 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  89 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._extendedAmount, this._activityDateTime, this._activityCode, this._accountLineItemStateCode, this._typeCode, this._retailLocationId, this._workstationId, this._businessDate, this._transSequence, this._transLineItemSeq, this._netAmount, this._unitPrice, this._quantity, this._scheduledPickupDate } };
/*  90 */     return updateParameterObject;
/*     */   }
/*     */   
/*  93 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 91, 12, 12, 12, -5, -5, 91, -5, -5, 3, 3, 3, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  95 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  98 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_cust_item_acct_activity" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND cust_item_acct_detail_item_nbr = ?  AND seq_nbr = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 101 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 107 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND cust_item_acct_detail_item_nbr = ?  AND seq_nbr = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 110 */     return new Object[] { this._organizationId, this._custAccountId, this._custAccountCode, this._custAccountDetailNum, this._sequenceNumber };
/*     */   }
/*     */   
/* 113 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 116 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 119 */     return "cat_cust_item_acct_activity";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 123 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 127 */     return new CustomerItemAccountActivityFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerItemAccountActivityFiller
/*     */     implements IFiller {
/*     */     private CustomerItemAccountActivityDBA _parent;
/*     */     
/*     */     public CustomerItemAccountActivityFiller(CustomerItemAccountActivityDBA argParent) {
/* 135 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 140 */       long primitiveResult = argResultSet.getLong(1);
/* 141 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 142 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 146 */       this._parent._custAccountId = argResultSet.getString(2);
/* 147 */       this._parent._custAccountCode = argResultSet.getString(3);
/*     */ 
/*     */       
/* 150 */       primitiveResult = argResultSet.getLong(4);
/* 151 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 152 */         this._parent._custAccountDetailNum = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 158 */       primitiveResult = argResultSet.getLong(5);
/* 159 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 160 */         this._parent._sequenceNumber = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 165 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 166 */       if (t6 != null) {
/* 167 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 175 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 176 */       if (t8 != null) {
/* 177 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 183 */       this._parent._updateUserId = argResultSet.getString(9);
/* 184 */       this._parent._extendedAmount = argResultSet.getBigDecimal(10);
/*     */       
/* 186 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 187 */       if (t11 != null) {
/* 188 */         this._parent._activityDateTime = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 191 */         this._parent._activityDateTime = null;
/*     */       } 
/*     */       
/* 194 */       this._parent._activityCode = argResultSet.getString(12);
/* 195 */       this._parent._accountLineItemStateCode = argResultSet.getString(13);
/* 196 */       this._parent._typeCode = argResultSet.getString(14);
/*     */ 
/*     */       
/* 199 */       long l1 = argResultSet.getLong(15);
/* 200 */       if (l1 != 0L || argResultSet.getObject(15) != null) {
/* 201 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 207 */       l1 = argResultSet.getLong(16);
/* 208 */       if (l1 != 0L || argResultSet.getObject(16) != null) {
/* 209 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 214 */       Timestamp t17 = argResultSet.getTimestamp(17);
/* 215 */       if (t17 != null) {
/* 216 */         this._parent._businessDate = (Date)new DtvDate(t17.getTime());
/*     */       } else {
/*     */         
/* 219 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 224 */       long l2 = argResultSet.getLong(18);
/* 225 */       if (l2 != 0L || argResultSet.getObject(18) != null) {
/* 226 */         this._parent._transSequence = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 232 */       l2 = argResultSet.getLong(19);
/* 233 */       if (l2 != 0L || argResultSet.getObject(19) != null) {
/* 234 */         this._parent._transLineItemSeq = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 238 */       this._parent._netAmount = argResultSet.getBigDecimal(20);
/* 239 */       this._parent._unitPrice = argResultSet.getBigDecimal(21);
/* 240 */       this._parent._quantity = argResultSet.getBigDecimal(22);
/*     */       
/* 242 */       Timestamp t23 = argResultSet.getTimestamp(23);
/* 243 */       if (t23 != null) {
/* 244 */         this._parent._scheduledPickupDate = (Date)new DtvDate(t23.getTime());
/*     */       } else {
/*     */         
/* 247 */         this._parent._scheduledPickupDate = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 254 */     argDAO.suppressStateChanges(true);
/* 255 */     CustomerItemAccountActivityDAO dao = (CustomerItemAccountActivityDAO)argDAO;
/* 256 */     dao.setOrganizationId(this._organizationId);
/* 257 */     dao.setCustAccountId(this._custAccountId);
/* 258 */     dao.setCustAccountCode(this._custAccountCode);
/* 259 */     dao.setCustAccountDetailNum(this._custAccountDetailNum);
/* 260 */     dao.setSequenceNumber(this._sequenceNumber);
/* 261 */     dao.setCreateDate(this._createDate);
/* 262 */     dao.setCreateUserId(this._createUserId);
/* 263 */     dao.setUpdateDate(this._updateDate);
/* 264 */     dao.setUpdateUserId(this._updateUserId);
/* 265 */     dao.setExtendedAmount(this._extendedAmount);
/* 266 */     dao.setActivityDateTime(this._activityDateTime);
/* 267 */     dao.setActivityCode(this._activityCode);
/* 268 */     dao.setAccountLineItemStateCode(this._accountLineItemStateCode);
/* 269 */     dao.setTypeCode(this._typeCode);
/* 270 */     dao.setRetailLocationId(this._retailLocationId);
/* 271 */     dao.setWorkstationId(this._workstationId);
/* 272 */     dao.setBusinessDate(this._businessDate);
/* 273 */     dao.setTransSequence(this._transSequence);
/* 274 */     dao.setTransLineItemSeq(this._transLineItemSeq);
/* 275 */     dao.setNetAmount(this._netAmount);
/* 276 */     dao.setUnitPrice(this._unitPrice);
/* 277 */     dao.setQuantity(this._quantity);
/* 278 */     dao.setScheduledPickupDate(this._scheduledPickupDate);
/* 279 */     argDAO.suppressStateChanges(false);
/* 280 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 284 */     return loadDAO((IDataAccessObject)new CustomerItemAccountActivityDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 288 */     CustomerItemAccountActivityDAO dao = (CustomerItemAccountActivityDAO)argDAO;
/* 289 */     this._organizationId = dao.getOrganizationId();
/* 290 */     this._custAccountId = dao.getCustAccountId();
/* 291 */     this._custAccountCode = dao.getCustAccountCode();
/* 292 */     this._custAccountDetailNum = dao.getCustAccountDetailNum();
/* 293 */     this._sequenceNumber = dao.getSequenceNumber();
/* 294 */     this._createDate = dao.getCreateDate();
/* 295 */     this._createUserId = dao.getCreateUserId();
/* 296 */     this._updateDate = dao.getUpdateDate();
/* 297 */     this._updateUserId = dao.getUpdateUserId();
/* 298 */     this._extendedAmount = dao.getExtendedAmount();
/* 299 */     this._activityDateTime = dao.getActivityDateTime();
/* 300 */     this._activityCode = dao.getActivityCode();
/* 301 */     this._accountLineItemStateCode = dao.getAccountLineItemStateCode();
/* 302 */     this._typeCode = dao.getTypeCode();
/* 303 */     this._retailLocationId = dao.getRetailLocationId();
/* 304 */     this._workstationId = dao.getWorkstationId();
/* 305 */     this._businessDate = dao.getBusinessDate();
/* 306 */     this._transSequence = dao.getTransSequence();
/* 307 */     this._transLineItemSeq = dao.getTransLineItemSeq();
/* 308 */     this._netAmount = dao.getNetAmount();
/* 309 */     this._unitPrice = dao.getUnitPrice();
/* 310 */     this._quantity = dao.getQuantity();
/* 311 */     this._scheduledPickupDate = dao.getScheduledPickupDate();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 315 */     CustomerItemAccountActivityId id = (CustomerItemAccountActivityId)argId;
/* 316 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 317 */     argStatement.setString(2, id.getCustAccountId());
/* 318 */     argStatement.setString(3, id.getCustAccountCode());
/* 319 */     argStatement.setLong(4, id.getCustAccountDetailNum().longValue());
/* 320 */     argStatement.setLong(5, id.getSequenceNumber().longValue());
/* 321 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 325 */     CustomerItemAccountActivityId id = new CustomerItemAccountActivityId();
/* 326 */     id.setOrganizationId(this._organizationId);
/* 327 */     id.setCustAccountId(this._custAccountId);
/* 328 */     id.setCustAccountCode(this._custAccountCode);
/* 329 */     id.setCustAccountDetailNum(this._custAccountDetailNum);
/* 330 */     id.setSequenceNumber(this._sequenceNumber);
/* 331 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 339 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 343 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerItemAccountActivityDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */