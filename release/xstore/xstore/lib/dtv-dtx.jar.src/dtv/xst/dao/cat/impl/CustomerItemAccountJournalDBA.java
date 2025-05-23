/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerAccountJournalId;
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
/*     */ public class CustomerItemAccountJournalDBA
/*     */   extends CustomerAccountJournalDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -654891301L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Long _journalSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _custAccountStateCode;
/*     */   private Date _accountSetupDate;
/*     */   private Date _lastActivityDate;
/*     */   private BigDecimal _accountTotal;
/*     */   private BigDecimal _accountPayments;
/*     */   private BigDecimal _activeAccountPayments;
/*     */   private BigDecimal _activeAccountTotal;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.journal_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cust_acct_statcode, t.acct_setup_date, t.last_activity_date, t.acct_total, t.total_payment_amt, t.active_payment_amt, t.active_acct_total FROM cat_cust_item_acct_journal t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND journal_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.journal_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cust_acct_statcode, t.acct_setup_date, t.last_activity_date, t.acct_total, t.total_payment_amt, t.active_payment_amt, t.active_acct_total FROM cat_cust_item_acct_journal t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND journal_seq = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_cust_item_acct_journal(organization_id, cust_acct_id, cust_acct_code, journal_seq, create_date, create_user_id, update_date, update_user_id, cust_acct_statcode, acct_setup_date, last_activity_date, acct_total, total_payment_amt, active_payment_amt, active_acct_total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  63 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  68 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._custAccountCode, this._journalSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._custAccountStateCode, this._accountSetupDate, this._lastActivityDate, this._accountTotal, this._accountPayments, this._activeAccountPayments, this._activeAccountTotal } };
/*  69 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  72 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, -5, 91, 12, 91, 12, 12, 91, 91, 3, 3, 3, 3 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  76 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  79 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_cust_item_acct_journal SET update_date = ?, update_user_id = ?, cust_acct_statcode = ?, acct_setup_date = ?, last_activity_date = ?, acct_total = ?, total_payment_amt = ?, active_payment_amt = ?, active_acct_total = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  83 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  88 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._custAccountStateCode, this._accountSetupDate, this._lastActivityDate, this._accountTotal, this._accountPayments, this._activeAccountPayments, this._activeAccountTotal } };
/*  89 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  92 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 91, 91, 3, 3, 3, 3 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  95 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  98 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_cust_item_acct_journal" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND journal_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 102 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 109 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND journal_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 113 */     return new Object[] { this._organizationId, this._custAccountId, this._custAccountCode, this._journalSequence };
/*     */   }
/*     */   
/* 116 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, -5 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 120 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 124 */     return "cat_cust_item_acct_journal";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 129 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 133 */     return new CustomerItemAccountJournalFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerItemAccountJournalFiller
/*     */     implements IFiller {
/*     */     private CustomerItemAccountJournalDBA _parent;
/*     */     
/*     */     public CustomerItemAccountJournalFiller(CustomerItemAccountJournalDBA argParent) {
/* 141 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 146 */       long primitiveResult = argResultSet.getLong(1);
/* 147 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 148 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 152 */       this._parent._custAccountId = argResultSet.getString(2);
/* 153 */       this._parent._custAccountCode = argResultSet.getString(3);
/*     */ 
/*     */       
/* 156 */       primitiveResult = argResultSet.getLong(4);
/* 157 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 158 */         this._parent._journalSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 163 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 164 */       if (t5 != null) {
/* 165 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 168 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 171 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 173 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 174 */       if (t7 != null) {
/* 175 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 178 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 181 */       this._parent._updateUserId = argResultSet.getString(8);
/* 182 */       this._parent._custAccountStateCode = argResultSet.getString(9);
/*     */       
/* 184 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 185 */       if (t10 != null) {
/* 186 */         this._parent._accountSetupDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 189 */         this._parent._accountSetupDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 193 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 194 */       if (t11 != null) {
/* 195 */         this._parent._lastActivityDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 198 */         this._parent._lastActivityDate = null;
/*     */       } 
/*     */       
/* 201 */       this._parent._accountTotal = argResultSet.getBigDecimal(12);
/* 202 */       this._parent._accountPayments = argResultSet.getBigDecimal(13);
/* 203 */       this._parent._activeAccountPayments = argResultSet.getBigDecimal(14);
/* 204 */       this._parent._activeAccountTotal = argResultSet.getBigDecimal(15);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 210 */     super.loadDAO(argDAO);
/* 211 */     argDAO.suppressStateChanges(true);
/* 212 */     CustomerItemAccountJournalDAO dao = (CustomerItemAccountJournalDAO)argDAO;
/* 213 */     dao.setOrganizationId(this._organizationId);
/* 214 */     dao.setCustAccountId(this._custAccountId);
/* 215 */     dao.setCustAccountCode(this._custAccountCode);
/* 216 */     dao.setJournalSequence(this._journalSequence);
/* 217 */     dao.setCreateDate(this._createDate);
/* 218 */     dao.setCreateUserId(this._createUserId);
/* 219 */     dao.setUpdateDate(this._updateDate);
/* 220 */     dao.setUpdateUserId(this._updateUserId);
/* 221 */     dao.setCustAccountStateCode(this._custAccountStateCode);
/* 222 */     dao.setAccountSetupDate(this._accountSetupDate);
/* 223 */     dao.setLastActivityDate(this._lastActivityDate);
/* 224 */     dao.setAccountTotal(this._accountTotal);
/* 225 */     dao.setAccountPayments(this._accountPayments);
/* 226 */     dao.setActiveAccountPayments(this._activeAccountPayments);
/* 227 */     dao.setActiveAccountTotal(this._activeAccountTotal);
/* 228 */     argDAO.suppressStateChanges(false);
/* 229 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 234 */     return loadDAO((IDataAccessObject)new CustomerItemAccountJournalDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 239 */     CustomerItemAccountJournalDAO dao = (CustomerItemAccountJournalDAO)argDAO;
/* 240 */     super.fill((IDataAccessObject)dao);
/* 241 */     this._organizationId = dao.getOrganizationId();
/* 242 */     this._custAccountId = dao.getCustAccountId();
/* 243 */     this._custAccountCode = dao.getCustAccountCode();
/* 244 */     this._journalSequence = dao.getJournalSequence();
/* 245 */     this._createDate = dao.getCreateDate();
/* 246 */     this._createUserId = dao.getCreateUserId();
/* 247 */     this._updateDate = dao.getUpdateDate();
/* 248 */     this._updateUserId = dao.getUpdateUserId();
/* 249 */     this._custAccountStateCode = dao.getCustAccountStateCode();
/* 250 */     this._accountSetupDate = dao.getAccountSetupDate();
/* 251 */     this._lastActivityDate = dao.getLastActivityDate();
/* 252 */     this._accountTotal = dao.getAccountTotal();
/* 253 */     this._accountPayments = dao.getAccountPayments();
/* 254 */     this._activeAccountPayments = dao.getActiveAccountPayments();
/* 255 */     this._activeAccountTotal = dao.getActiveAccountTotal();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 260 */     CustomerAccountJournalId id = (CustomerAccountJournalId)argId;
/* 261 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 262 */     argStatement.setString(2, id.getCustAccountId());
/* 263 */     argStatement.setString(3, id.getCustAccountCode());
/* 264 */     argStatement.setLong(4, id.getJournalSequence().longValue());
/* 265 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 269 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 273 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerItemAccountJournalDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */