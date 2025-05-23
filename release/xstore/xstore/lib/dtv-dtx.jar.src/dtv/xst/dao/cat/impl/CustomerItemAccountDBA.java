/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerAccountId;
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
/*     */ public class CustomerItemAccountDBA
/*     */   extends CustomerAccountDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1032547140L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _accountTotal;
/*     */   private BigDecimal _accountPayments;
/*     */   private BigDecimal _activeAccountPayments;
/*     */   private BigDecimal _activeAccountTotal;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.acct_total, t.total_payment_amt, t.active_payment_amt, t.active_acct_total FROM cat_cust_item_acct t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.acct_total, t.total_payment_amt, t.active_payment_amt, t.active_acct_total FROM cat_cust_item_acct t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_cust_item_acct(organization_id, cust_acct_id, cust_acct_code, create_date, create_user_id, update_date, update_user_id, acct_total, total_payment_amt, active_payment_amt, active_acct_total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._custAccountCode, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._accountTotal, this._accountPayments, this._activeAccountPayments, this._activeAccountTotal } };
/*  65 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 3, 3, 3, 3 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_cust_item_acct SET update_date = ?, update_user_id = ?, acct_total = ?, total_payment_amt = ?, active_payment_amt = ?, active_acct_total = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  84 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._accountTotal, this._accountPayments, this._activeAccountPayments, this._activeAccountTotal } };
/*  85 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  88 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 3, 3, 3 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  91 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  94 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_cust_item_acct" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  98 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 105 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 109 */     return new Object[] { this._organizationId, this._custAccountId, this._custAccountCode };
/*     */   }
/*     */   
/* 112 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 116 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 120 */     return "cat_cust_item_acct";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 125 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 129 */     return new CustomerItemAccountFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerItemAccountFiller
/*     */     implements IFiller {
/*     */     private CustomerItemAccountDBA _parent;
/*     */     
/*     */     public CustomerItemAccountFiller(CustomerItemAccountDBA argParent) {
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
/* 151 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 152 */       if (t4 != null) {
/* 153 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 161 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 162 */       if (t6 != null) {
/* 163 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 166 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 169 */       this._parent._updateUserId = argResultSet.getString(7);
/* 170 */       this._parent._accountTotal = argResultSet.getBigDecimal(8);
/* 171 */       this._parent._accountPayments = argResultSet.getBigDecimal(9);
/* 172 */       this._parent._activeAccountPayments = argResultSet.getBigDecimal(10);
/* 173 */       this._parent._activeAccountTotal = argResultSet.getBigDecimal(11);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 179 */     super.loadDAO(argDAO);
/* 180 */     argDAO.suppressStateChanges(true);
/* 181 */     CustomerItemAccountDAO dao = (CustomerItemAccountDAO)argDAO;
/* 182 */     dao.setOrganizationId(this._organizationId);
/* 183 */     dao.setCustAccountId(this._custAccountId);
/* 184 */     dao.setCustAccountCode(this._custAccountCode);
/* 185 */     dao.setCreateDate(this._createDate);
/* 186 */     dao.setCreateUserId(this._createUserId);
/* 187 */     dao.setUpdateDate(this._updateDate);
/* 188 */     dao.setUpdateUserId(this._updateUserId);
/* 189 */     dao.setAccountTotal(this._accountTotal);
/* 190 */     dao.setAccountPayments(this._accountPayments);
/* 191 */     dao.setActiveAccountPayments(this._activeAccountPayments);
/* 192 */     dao.setActiveAccountTotal(this._activeAccountTotal);
/* 193 */     argDAO.suppressStateChanges(false);
/* 194 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 199 */     return loadDAO((IDataAccessObject)new CustomerItemAccountDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 204 */     CustomerItemAccountDAO dao = (CustomerItemAccountDAO)argDAO;
/* 205 */     super.fill((IDataAccessObject)dao);
/* 206 */     this._organizationId = dao.getOrganizationId();
/* 207 */     this._custAccountId = dao.getCustAccountId();
/* 208 */     this._custAccountCode = dao.getCustAccountCode();
/* 209 */     this._createDate = dao.getCreateDate();
/* 210 */     this._createUserId = dao.getCreateUserId();
/* 211 */     this._updateDate = dao.getUpdateDate();
/* 212 */     this._updateUserId = dao.getUpdateUserId();
/* 213 */     this._accountTotal = dao.getAccountTotal();
/* 214 */     this._accountPayments = dao.getAccountPayments();
/* 215 */     this._activeAccountPayments = dao.getActiveAccountPayments();
/* 216 */     this._activeAccountTotal = dao.getActiveAccountTotal();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 221 */     CustomerAccountId id = (CustomerAccountId)argId;
/* 222 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 223 */     argStatement.setString(2, id.getCustAccountId());
/* 224 */     argStatement.setString(3, id.getCustAccountCode());
/* 225 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 229 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 233 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerItemAccountDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */