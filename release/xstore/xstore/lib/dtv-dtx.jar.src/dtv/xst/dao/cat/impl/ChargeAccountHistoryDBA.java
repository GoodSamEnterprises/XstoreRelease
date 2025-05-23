/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.ChargeAccountHistoryId;
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
/*     */ public class ChargeAccountHistoryDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -284103269L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Long _historySeq;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _activityDate;
/*     */   private String _activityEnum;
/*     */   private BigDecimal _amt;
/*     */   private Long _partyId;
/*     */   private Date _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private BigDecimal _accountBalance;
/*     */   private String _accountUserName;
/*     */   private String _accountUserId;
/*     */   private Boolean _reversedFlag;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.history_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.activity_date, t.activity_enum, t.amt, t.party_id, t.business_date, t.trans_seq, t.wkstn_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.acct_balance, t.acct_user_name, t.acct_user_id, t.reversed_flag FROM cat_charge_acct_history t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND history_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  50 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  54 */     return "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.history_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.activity_date, t.activity_enum, t.amt, t.party_id, t.business_date, t.trans_seq, t.wkstn_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.acct_balance, t.acct_user_name, t.acct_user_id, t.reversed_flag FROM cat_charge_acct_history t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  60 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND history_seq = ?  ";
/*     */   }
/*     */   
/*  63 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_charge_acct_history(organization_id, cust_acct_id, cust_acct_code, history_seq, create_date, create_user_id, update_date, update_user_id, activity_date, activity_enum, amt, party_id, business_date, trans_seq, wkstn_id, rtl_loc_id, rtrans_lineitm_seq, acct_balance, acct_user_name, acct_user_id, reversed_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  66 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  70 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._custAccountCode, this._historySeq, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._activityDate, this._activityEnum, this._amt, this._partyId, this._businessDate, this._transactionSequence, this._workstationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._accountBalance, this._accountUserName, this._accountUserId, this._reversedFlag } };
/*  71 */     return insertParameterObject;
/*     */   }
/*     */   
/*  74 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, -5, 91, 12, 91, 12, 91, 12, 3, -5, 91, -5, -5, -5, 4, 3, 12, 12, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  77 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  80 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_charge_acct_history SET update_date = ?, update_user_id = ?, activity_date = ?, activity_enum = ?, amt = ?, party_id = ?, business_date = ?, trans_seq = ?, wkstn_id = ?, rtl_loc_id = ?, rtrans_lineitm_seq = ?, acct_balance = ?, acct_user_name = ?, acct_user_id = ?, reversed_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  83 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  87 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._activityDate, this._activityEnum, this._amt, this._partyId, this._businessDate, this._transactionSequence, this._workstationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._accountBalance, this._accountUserName, this._accountUserId, this._reversedFlag } };
/*  88 */     return updateParameterObject;
/*     */   }
/*     */   
/*  91 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 12, 3, -5, 91, -5, -5, -5, 4, 3, 12, 12, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  93 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  96 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_charge_acct_history" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND history_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  99 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 105 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND history_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 108 */     return new Object[] { this._organizationId, this._custAccountId, this._custAccountCode, this._historySeq };
/*     */   }
/*     */   
/* 111 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 114 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 117 */     return "cat_charge_acct_history";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 121 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 125 */     return new ChargeAccountHistoryFiller(this);
/*     */   }
/*     */   
/*     */   private static class ChargeAccountHistoryFiller
/*     */     implements IFiller {
/*     */     private ChargeAccountHistoryDBA _parent;
/*     */     
/*     */     public ChargeAccountHistoryFiller(ChargeAccountHistoryDBA argParent) {
/* 133 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 138 */       long primitiveResult = argResultSet.getLong(1);
/* 139 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 140 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 144 */       this._parent._custAccountId = argResultSet.getString(2);
/* 145 */       this._parent._custAccountCode = argResultSet.getString(3);
/*     */ 
/*     */       
/* 148 */       primitiveResult = argResultSet.getLong(4);
/* 149 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 150 */         this._parent._historySeq = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 155 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 156 */       if (t5 != null) {
/* 157 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 165 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 166 */       if (t7 != null) {
/* 167 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */       
/* 175 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 176 */       if (t9 != null) {
/* 177 */         this._parent._activityDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._activityDate = null;
/*     */       } 
/*     */       
/* 183 */       this._parent._activityEnum = argResultSet.getString(10);
/* 184 */       this._parent._amt = argResultSet.getBigDecimal(11);
/*     */ 
/*     */       
/* 187 */       long l1 = argResultSet.getLong(12);
/* 188 */       if (l1 != 0L || argResultSet.getObject(12) != null) {
/* 189 */         this._parent._partyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 194 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 195 */       if (t13 != null) {
/* 196 */         this._parent._businessDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 199 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 204 */       long l2 = argResultSet.getLong(14);
/* 205 */       if (l2 != 0L || argResultSet.getObject(14) != null) {
/* 206 */         this._parent._transactionSequence = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 212 */       l2 = argResultSet.getLong(15);
/* 213 */       if (l2 != 0L || argResultSet.getObject(15) != null) {
/* 214 */         this._parent._workstationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 220 */       l2 = argResultSet.getLong(16);
/* 221 */       if (l2 != 0L || argResultSet.getObject(16) != null) {
/* 222 */         this._parent._retailLocationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 228 */       int i = argResultSet.getInt(17);
/* 229 */       if (i != 0 || argResultSet.getObject(17) != null) {
/* 230 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 234 */       this._parent._accountBalance = argResultSet.getBigDecimal(18);
/* 235 */       this._parent._accountUserName = argResultSet.getString(19);
/* 236 */       this._parent._accountUserId = argResultSet.getString(20);
/* 237 */       this._parent._reversedFlag = Boolean.valueOf(argResultSet.getBoolean(21));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 242 */     argDAO.suppressStateChanges(true);
/* 243 */     ChargeAccountHistoryDAO dao = (ChargeAccountHistoryDAO)argDAO;
/* 244 */     dao.setOrganizationId(this._organizationId);
/* 245 */     dao.setCustAccountId(this._custAccountId);
/* 246 */     dao.setCustAccountCode(this._custAccountCode);
/* 247 */     dao.setHistorySeq(this._historySeq);
/* 248 */     dao.setCreateDate(this._createDate);
/* 249 */     dao.setCreateUserId(this._createUserId);
/* 250 */     dao.setUpdateDate(this._updateDate);
/* 251 */     dao.setUpdateUserId(this._updateUserId);
/* 252 */     dao.setActivityDate(this._activityDate);
/* 253 */     dao.setActivityEnum(this._activityEnum);
/* 254 */     dao.setAmt(this._amt);
/* 255 */     dao.setPartyId(this._partyId);
/* 256 */     dao.setBusinessDate(this._businessDate);
/* 257 */     dao.setTransactionSequence(this._transactionSequence);
/* 258 */     dao.setWorkstationId(this._workstationId);
/* 259 */     dao.setRetailLocationId(this._retailLocationId);
/* 260 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 261 */     dao.setAccountBalance(this._accountBalance);
/* 262 */     dao.setAccountUserName(this._accountUserName);
/* 263 */     dao.setAccountUserId(this._accountUserId);
/* 264 */     dao.setReversedFlag(this._reversedFlag);
/* 265 */     argDAO.suppressStateChanges(false);
/* 266 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 270 */     return loadDAO((IDataAccessObject)new ChargeAccountHistoryDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 274 */     ChargeAccountHistoryDAO dao = (ChargeAccountHistoryDAO)argDAO;
/* 275 */     this._organizationId = dao.getOrganizationId();
/* 276 */     this._custAccountId = dao.getCustAccountId();
/* 277 */     this._custAccountCode = dao.getCustAccountCode();
/* 278 */     this._historySeq = dao.getHistorySeq();
/* 279 */     this._createDate = dao.getCreateDate();
/* 280 */     this._createUserId = dao.getCreateUserId();
/* 281 */     this._updateDate = dao.getUpdateDate();
/* 282 */     this._updateUserId = dao.getUpdateUserId();
/* 283 */     this._activityDate = dao.getActivityDate();
/* 284 */     this._activityEnum = dao.getActivityEnum();
/* 285 */     this._amt = dao.getAmt();
/* 286 */     this._partyId = dao.getPartyId();
/* 287 */     this._businessDate = dao.getBusinessDate();
/* 288 */     this._transactionSequence = dao.getTransactionSequence();
/* 289 */     this._workstationId = dao.getWorkstationId();
/* 290 */     this._retailLocationId = dao.getRetailLocationId();
/* 291 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 292 */     this._accountBalance = dao.getAccountBalance();
/* 293 */     this._accountUserName = dao.getAccountUserName();
/* 294 */     this._accountUserId = dao.getAccountUserId();
/* 295 */     this._reversedFlag = (dao.getReversedFlag() != null) ? dao.getReversedFlag() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 299 */     ChargeAccountHistoryId id = (ChargeAccountHistoryId)argId;
/* 300 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 301 */     argStatement.setString(2, id.getCustAccountId());
/* 302 */     argStatement.setString(3, id.getCustAccountCode());
/* 303 */     argStatement.setLong(4, id.getHistorySeq().longValue());
/* 304 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 308 */     ChargeAccountHistoryId id = new ChargeAccountHistoryId();
/* 309 */     id.setOrganizationId(this._organizationId);
/* 310 */     id.setCustAccountId(this._custAccountId);
/* 311 */     id.setCustAccountCode(this._custAccountCode);
/* 312 */     id.setHistorySeq(this._historySeq);
/* 313 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 321 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 325 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\ChargeAccountHistoryDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */