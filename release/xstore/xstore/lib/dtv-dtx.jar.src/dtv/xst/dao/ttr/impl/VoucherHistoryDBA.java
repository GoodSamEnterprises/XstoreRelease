/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ttr.VoucherHistoryId;
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
/*     */ public class VoucherHistoryDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -41453018L;
/*     */   private Long _organizationId;
/*     */   private String _serialNumber;
/*     */   private String _voucherTypeCode;
/*     */   private Long _historySequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _activityCode;
/*     */   private BigDecimal _amount;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.serial_nbr, t.voucher_typcode, t.history_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.activity_code, t.amt, t.rtrans_lineitm_seq, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq FROM ttr_voucher_history t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND serial_nbr = ?  AND voucher_typcode = ?  AND history_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.serial_nbr, t.voucher_typcode, t.history_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.activity_code, t.amt, t.rtrans_lineitm_seq, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq FROM ttr_voucher_history t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND serial_nbr = ?  AND voucher_typcode = ?  AND history_seq = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ttr_voucher_history(organization_id, serial_nbr, voucher_typcode, history_seq, create_date, create_user_id, update_date, update_user_id, activity_code, amt, rtrans_lineitm_seq, rtl_loc_id, wkstn_id, business_date, trans_seq) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._serialNumber, this._voucherTypeCode, this._historySequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._activityCode, this._amount, this._retailTransactionLineItemSequence, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, -5, 91, 12, 91, 12, 12, 3, 4, -5, -5, 91, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ttr_voucher_history SET update_date = ?, update_user_id = ?, activity_code = ?, amt = ?, rtrans_lineitm_seq = ?, rtl_loc_id = ?, wkstn_id = ?, business_date = ?, trans_seq = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._activityCode, this._amount, this._retailTransactionLineItemSequence, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 3, 4, -5, -5, 91, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ttr_voucher_history" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND serial_nbr = ?  AND voucher_typcode = ?  AND history_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND serial_nbr = ?  AND voucher_typcode = ?  AND history_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._serialNumber, this._voucherTypeCode, this._historySequence };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "ttr_voucher_history";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new VoucherHistoryFiller(this);
/*     */   }
/*     */   
/*     */   private static class VoucherHistoryFiller
/*     */     implements IFiller {
/*     */     private VoucherHistoryDBA _parent;
/*     */     
/*     */     public VoucherHistoryFiller(VoucherHistoryDBA argParent) {
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
/* 138 */       this._parent._serialNumber = argResultSet.getString(2);
/* 139 */       this._parent._voucherTypeCode = argResultSet.getString(3);
/*     */ 
/*     */       
/* 142 */       primitiveResult = argResultSet.getLong(4);
/* 143 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 144 */         this._parent._historySequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 149 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 150 */       if (t5 != null) {
/* 151 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 159 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 160 */       if (t7 != null) {
/* 161 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 167 */       this._parent._updateUserId = argResultSet.getString(8);
/* 168 */       this._parent._activityCode = argResultSet.getString(9);
/* 169 */       this._parent._amount = argResultSet.getBigDecimal(10);
/*     */ 
/*     */       
/* 172 */       int i = argResultSet.getInt(11);
/* 173 */       if (i != 0 || argResultSet.getObject(11) != null) {
/* 174 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 180 */       long l1 = argResultSet.getLong(12);
/* 181 */       if (l1 != 0L || argResultSet.getObject(12) != null) {
/* 182 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 188 */       l1 = argResultSet.getLong(13);
/* 189 */       if (l1 != 0L || argResultSet.getObject(13) != null) {
/* 190 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 195 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 196 */       if (t14 != null) {
/* 197 */         this._parent._businessDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 200 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 205 */       long l2 = argResultSet.getLong(15);
/* 206 */       if (l2 != 0L || argResultSet.getObject(15) != null) {
/* 207 */         this._parent._transactionSequence = Long.valueOf(l2);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 215 */     argDAO.suppressStateChanges(true);
/* 216 */     VoucherHistoryDAO dao = (VoucherHistoryDAO)argDAO;
/* 217 */     dao.setOrganizationId(this._organizationId);
/* 218 */     dao.setSerialNumber(this._serialNumber);
/* 219 */     dao.setVoucherTypeCode(this._voucherTypeCode);
/* 220 */     dao.setHistorySequence(this._historySequence);
/* 221 */     dao.setCreateDate(this._createDate);
/* 222 */     dao.setCreateUserId(this._createUserId);
/* 223 */     dao.setUpdateDate(this._updateDate);
/* 224 */     dao.setUpdateUserId(this._updateUserId);
/* 225 */     dao.setActivityCode(this._activityCode);
/* 226 */     dao.setAmount(this._amount);
/* 227 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 228 */     dao.setRetailLocationId(this._retailLocationId);
/* 229 */     dao.setWorkstationId(this._workstationId);
/* 230 */     dao.setBusinessDate(this._businessDate);
/* 231 */     dao.setTransactionSequence(this._transactionSequence);
/* 232 */     argDAO.suppressStateChanges(false);
/* 233 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 237 */     return loadDAO((IDataAccessObject)new VoucherHistoryDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 241 */     VoucherHistoryDAO dao = (VoucherHistoryDAO)argDAO;
/* 242 */     this._organizationId = dao.getOrganizationId();
/* 243 */     this._serialNumber = dao.getSerialNumber();
/* 244 */     this._voucherTypeCode = dao.getVoucherTypeCode();
/* 245 */     this._historySequence = dao.getHistorySequence();
/* 246 */     this._createDate = dao.getCreateDate();
/* 247 */     this._createUserId = dao.getCreateUserId();
/* 248 */     this._updateDate = dao.getUpdateDate();
/* 249 */     this._updateUserId = dao.getUpdateUserId();
/* 250 */     this._activityCode = dao.getActivityCode();
/* 251 */     this._amount = dao.getAmount();
/* 252 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 253 */     this._retailLocationId = dao.getRetailLocationId();
/* 254 */     this._workstationId = dao.getWorkstationId();
/* 255 */     this._businessDate = dao.getBusinessDate();
/* 256 */     this._transactionSequence = dao.getTransactionSequence();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 260 */     VoucherHistoryId id = (VoucherHistoryId)argId;
/* 261 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 262 */     argStatement.setString(2, id.getSerialNumber());
/* 263 */     argStatement.setString(3, id.getVoucherTypeCode());
/* 264 */     argStatement.setLong(4, id.getHistorySequence().longValue());
/* 265 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 269 */     VoucherHistoryId id = new VoucherHistoryId();
/* 270 */     id.setOrganizationId(this._organizationId);
/* 271 */     id.setSerialNumber(this._serialNumber);
/* 272 */     id.setVoucherTypeCode(this._voucherTypeCode);
/* 273 */     id.setHistorySequence(this._historySequence);
/* 274 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 282 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 286 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\VoucherHistoryDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */