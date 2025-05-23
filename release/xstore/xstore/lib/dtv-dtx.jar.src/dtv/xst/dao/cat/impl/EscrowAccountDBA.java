/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.EscrowAccountId;
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
/*     */ public class EscrowAccountDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -878204408L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _accountBalance;
/*     */   private String _custAccountStateCode;
/*     */   private Date _accountSetupDate;
/*     */   private Date _lastActivityDate;
/*     */   private Long _partyId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.acct_balance, t.cust_acct_statcode, t.acct_setup_date, t.last_activity_date, t.party_id FROM cat_escrow_acct t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.cust_acct_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.acct_balance, t.cust_acct_statcode, t.acct_setup_date, t.last_activity_date, t.party_id FROM cat_escrow_acct t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_escrow_acct(organization_id, cust_acct_id, create_date, create_user_id, update_date, update_user_id, acct_balance, cust_acct_statcode, acct_setup_date, last_activity_date, party_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._accountBalance, this._custAccountStateCode, this._accountSetupDate, this._lastActivityDate, this._partyId } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 3, 12, 91, 91, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_escrow_acct SET update_date = ?, update_user_id = ?, acct_balance = ?, cust_acct_statcode = ?, acct_setup_date = ?, last_activity_date = ?, party_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._accountBalance, this._custAccountStateCode, this._accountSetupDate, this._lastActivityDate, this._partyId } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 12, 91, 91, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_escrow_acct" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._custAccountId };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "cat_escrow_acct";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new EscrowAccountFiller(this);
/*     */   }
/*     */   
/*     */   private static class EscrowAccountFiller
/*     */     implements IFiller {
/*     */     private EscrowAccountDBA _parent;
/*     */     
/*     */     public EscrowAccountFiller(EscrowAccountDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long primitiveResult = argResultSet.getLong(1);
/* 129 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 134 */       this._parent._custAccountId = argResultSet.getString(2);
/*     */       
/* 136 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 137 */       if (t3 != null) {
/* 138 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 141 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 144 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 146 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 147 */       if (t5 != null) {
/* 148 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._updateUserId = argResultSet.getString(6);
/* 155 */       this._parent._accountBalance = argResultSet.getBigDecimal(7);
/* 156 */       this._parent._custAccountStateCode = argResultSet.getString(8);
/*     */       
/* 158 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 159 */       if (t9 != null) {
/* 160 */         this._parent._accountSetupDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 163 */         this._parent._accountSetupDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 167 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 168 */       if (t10 != null) {
/* 169 */         this._parent._lastActivityDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._lastActivityDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 177 */       long l1 = argResultSet.getLong(11);
/* 178 */       if (l1 != 0L || argResultSet.getObject(11) != null) {
/* 179 */         this._parent._partyId = Long.valueOf(l1);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 187 */     argDAO.suppressStateChanges(true);
/* 188 */     EscrowAccountDAO dao = (EscrowAccountDAO)argDAO;
/* 189 */     dao.setOrganizationId(this._organizationId);
/* 190 */     dao.setCustAccountId(this._custAccountId);
/* 191 */     dao.setCreateDate(this._createDate);
/* 192 */     dao.setCreateUserId(this._createUserId);
/* 193 */     dao.setUpdateDate(this._updateDate);
/* 194 */     dao.setUpdateUserId(this._updateUserId);
/* 195 */     dao.setAccountBalance(this._accountBalance);
/* 196 */     dao.setCustAccountStateCode(this._custAccountStateCode);
/* 197 */     dao.setAccountSetupDate(this._accountSetupDate);
/* 198 */     dao.setLastActivityDate(this._lastActivityDate);
/* 199 */     dao.setPartyId(this._partyId);
/* 200 */     argDAO.suppressStateChanges(false);
/* 201 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 205 */     return loadDAO((IDataAccessObject)new EscrowAccountDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 209 */     EscrowAccountDAO dao = (EscrowAccountDAO)argDAO;
/* 210 */     this._organizationId = dao.getOrganizationId();
/* 211 */     this._custAccountId = dao.getCustAccountId();
/* 212 */     this._createDate = dao.getCreateDate();
/* 213 */     this._createUserId = dao.getCreateUserId();
/* 214 */     this._updateDate = dao.getUpdateDate();
/* 215 */     this._updateUserId = dao.getUpdateUserId();
/* 216 */     this._accountBalance = dao.getAccountBalance();
/* 217 */     this._custAccountStateCode = dao.getCustAccountStateCode();
/* 218 */     this._accountSetupDate = dao.getAccountSetupDate();
/* 219 */     this._lastActivityDate = dao.getLastActivityDate();
/* 220 */     this._partyId = dao.getPartyId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 224 */     EscrowAccountId id = (EscrowAccountId)argId;
/* 225 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 226 */     argStatement.setString(2, id.getCustAccountId());
/* 227 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 231 */     EscrowAccountId id = new EscrowAccountId();
/* 232 */     id.setOrganizationId(this._organizationId);
/* 233 */     id.setCustAccountId(this._custAccountId);
/* 234 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 242 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 246 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\EscrowAccountDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */