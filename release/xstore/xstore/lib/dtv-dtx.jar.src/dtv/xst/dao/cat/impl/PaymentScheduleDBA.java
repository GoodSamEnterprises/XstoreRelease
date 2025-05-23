/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.PaymentScheduleId;
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
/*     */ public class PaymentScheduleDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1798863517L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _beginDate;
/*     */   private String _intervalTypeEnum;
/*     */   private Integer _intervalCount;
/*     */   private BigDecimal _totalPaymentAmount;
/*     */   private Integer _paymentCount;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_date, t.interval_type_enum, t.interval_count, t.total_payment_amt, t.payment_count FROM cat_payment_schedule t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_date, t.interval_type_enum, t.interval_count, t.total_payment_amt, t.payment_count FROM cat_payment_schedule t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_payment_schedule(organization_id, cust_acct_id, cust_acct_code, create_date, create_user_id, update_date, update_user_id, begin_date, interval_type_enum, interval_count, total_payment_amt, payment_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._custAccountCode, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._beginDate, this._intervalTypeEnum, this._intervalCount, this._totalPaymentAmount, this._paymentCount } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 91, 12, 4, 3, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_payment_schedule SET update_date = ?, update_user_id = ?, begin_date = ?, interval_type_enum = ?, interval_count = ?, total_payment_amt = ?, payment_count = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._beginDate, this._intervalTypeEnum, this._intervalCount, this._totalPaymentAmount, this._paymentCount } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 12, 4, 3, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_payment_schedule" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._custAccountId, this._custAccountCode };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "cat_payment_schedule";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new PaymentScheduleFiller(this);
/*     */   }
/*     */   
/*     */   private static class PaymentScheduleFiller
/*     */     implements IFiller {
/*     */     private PaymentScheduleDBA _parent;
/*     */     
/*     */     public PaymentScheduleFiller(PaymentScheduleDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long primitiveResult = argResultSet.getLong(1);
/* 130 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 135 */       this._parent._custAccountId = argResultSet.getString(2);
/* 136 */       this._parent._custAccountCode = argResultSet.getString(3);
/*     */       
/* 138 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 139 */       if (t4 != null) {
/* 140 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 143 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 146 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 148 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 149 */       if (t6 != null) {
/* 150 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 153 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 156 */       this._parent._updateUserId = argResultSet.getString(7);
/*     */       
/* 158 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 159 */       if (t8 != null) {
/* 160 */         this._parent._beginDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 163 */         this._parent._beginDate = null;
/*     */       } 
/*     */       
/* 166 */       this._parent._intervalTypeEnum = argResultSet.getString(9);
/*     */ 
/*     */       
/* 169 */       int i = argResultSet.getInt(10);
/* 170 */       if (i != 0 || argResultSet.getObject(10) != null) {
/* 171 */         this._parent._intervalCount = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 175 */       this._parent._totalPaymentAmount = argResultSet.getBigDecimal(11);
/*     */ 
/*     */       
/* 178 */       i = argResultSet.getInt(12);
/* 179 */       if (i != 0 || argResultSet.getObject(12) != null) {
/* 180 */         this._parent._paymentCount = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 188 */     argDAO.suppressStateChanges(true);
/* 189 */     PaymentScheduleDAO dao = (PaymentScheduleDAO)argDAO;
/* 190 */     dao.setOrganizationId(this._organizationId);
/* 191 */     dao.setCustAccountId(this._custAccountId);
/* 192 */     dao.setCustAccountCode(this._custAccountCode);
/* 193 */     dao.setCreateDate(this._createDate);
/* 194 */     dao.setCreateUserId(this._createUserId);
/* 195 */     dao.setUpdateDate(this._updateDate);
/* 196 */     dao.setUpdateUserId(this._updateUserId);
/* 197 */     dao.setBeginDate(this._beginDate);
/* 198 */     dao.setIntervalTypeEnum(this._intervalTypeEnum);
/* 199 */     dao.setIntervalCount(this._intervalCount);
/* 200 */     dao.setTotalPaymentAmount(this._totalPaymentAmount);
/* 201 */     dao.setPaymentCount(this._paymentCount);
/* 202 */     argDAO.suppressStateChanges(false);
/* 203 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 207 */     return loadDAO((IDataAccessObject)new PaymentScheduleDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 211 */     PaymentScheduleDAO dao = (PaymentScheduleDAO)argDAO;
/* 212 */     this._organizationId = dao.getOrganizationId();
/* 213 */     this._custAccountId = dao.getCustAccountId();
/* 214 */     this._custAccountCode = dao.getCustAccountCode();
/* 215 */     this._createDate = dao.getCreateDate();
/* 216 */     this._createUserId = dao.getCreateUserId();
/* 217 */     this._updateDate = dao.getUpdateDate();
/* 218 */     this._updateUserId = dao.getUpdateUserId();
/* 219 */     this._beginDate = dao.getBeginDate();
/* 220 */     this._intervalTypeEnum = dao.getIntervalTypeEnum();
/* 221 */     this._intervalCount = dao.getIntervalCount();
/* 222 */     this._totalPaymentAmount = dao.getTotalPaymentAmount();
/* 223 */     this._paymentCount = dao.getPaymentCount();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 227 */     PaymentScheduleId id = (PaymentScheduleId)argId;
/* 228 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 229 */     argStatement.setString(2, id.getCustAccountId());
/* 230 */     argStatement.setString(3, id.getCustAccountCode());
/* 231 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 235 */     PaymentScheduleId id = new PaymentScheduleId();
/* 236 */     id.setOrganizationId(this._organizationId);
/* 237 */     id.setCustAccountId(this._custAccountId);
/* 238 */     id.setCustAccountCode(this._custAccountCode);
/* 239 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 247 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 251 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\PaymentScheduleDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */