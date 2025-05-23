/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerLoyaltyAccountId;
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
/*     */ public class CustomerLoyaltyAccountDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -966459739L;
/*     */   private Long _organizationId;
/*     */   private String _cardNumber;
/*     */   private String _accountId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _loyaltyProgramId;
/*     */   private String _loyaltyProgramName;
/*     */   private String _loyaltyProgramLevelId;
/*     */   private String _loyaltyProgramLevelName;
/*     */   private Date _effectiveDate;
/*     */   private Date _expirationDate;
/*     */   private BigDecimal _accountBalance;
/*     */   private BigDecimal _escrowBalance;
/*     */   private BigDecimal _bonusBalance;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_card_nbr, t.cust_acct_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.loyalty_program_id, t.loyalty_program_name, t.loyalty_program_level_id, t.loyalty_program_level_name, t.effective_date, t.expiration_date, t.acct_balance, t.escrow_balance, t.bonus_balance FROM cat_cust_loyalty_acct t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_card_nbr = ?  AND cust_acct_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.organization_id, t.cust_card_nbr, t.cust_acct_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.loyalty_program_id, t.loyalty_program_name, t.loyalty_program_level_id, t.loyalty_program_level_name, t.effective_date, t.expiration_date, t.acct_balance, t.escrow_balance, t.bonus_balance FROM cat_cust_loyalty_acct t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE organization_id = ?  AND cust_card_nbr = ?  AND cust_acct_id = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_cust_loyalty_acct(organization_id, cust_card_nbr, cust_acct_id, create_date, create_user_id, update_date, update_user_id, loyalty_program_id, loyalty_program_name, loyalty_program_level_id, loyalty_program_level_name, effective_date, expiration_date, acct_balance, escrow_balance, bonus_balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._organizationId, this._cardNumber, this._accountId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._loyaltyProgramId, this._loyaltyProgramName, this._loyaltyProgramLevelId, this._loyaltyProgramLevelName, this._effectiveDate, this._expirationDate, this._accountBalance, this._escrowBalance, this._bonusBalance } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12, 12, 12, 12, 91, 91, 3, 3, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_cust_loyalty_acct SET update_date = ?, update_user_id = ?, loyalty_program_id = ?, loyalty_program_name = ?, loyalty_program_level_id = ?, loyalty_program_level_name = ?, effective_date = ?, expiration_date = ?, acct_balance = ?, escrow_balance = ?, bonus_balance = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._loyaltyProgramId, this._loyaltyProgramName, this._loyaltyProgramLevelId, this._loyaltyProgramLevelName, this._effectiveDate, this._expirationDate, this._accountBalance, this._escrowBalance, this._bonusBalance } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 91, 91, 3, 3, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_cust_loyalty_acct" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_card_nbr = ?  AND cust_acct_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE organization_id = ?  AND cust_card_nbr = ?  AND cust_acct_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._organizationId, this._cardNumber, this._accountId };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "cat_cust_loyalty_acct";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new CustomerLoyaltyAccountFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerLoyaltyAccountFiller
/*     */     implements IFiller {
/*     */     private CustomerLoyaltyAccountDBA _parent;
/*     */     
/*     */     public CustomerLoyaltyAccountFiller(CustomerLoyaltyAccountDBA argParent) {
/* 128 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 133 */       long primitiveResult = argResultSet.getLong(1);
/* 134 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 135 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 139 */       this._parent._cardNumber = argResultSet.getString(2);
/* 140 */       this._parent._accountId = argResultSet.getString(3);
/*     */       
/* 142 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 143 */       if (t4 != null) {
/* 144 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 147 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 150 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 152 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 153 */       if (t6 != null) {
/* 154 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._updateUserId = argResultSet.getString(7);
/* 161 */       this._parent._loyaltyProgramId = argResultSet.getString(8);
/* 162 */       this._parent._loyaltyProgramName = argResultSet.getString(9);
/* 163 */       this._parent._loyaltyProgramLevelId = argResultSet.getString(10);
/* 164 */       this._parent._loyaltyProgramLevelName = argResultSet.getString(11);
/*     */       
/* 166 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 167 */       if (t12 != null) {
/* 168 */         this._parent._effectiveDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 171 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 175 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 176 */       if (t13 != null) {
/* 177 */         this._parent._expirationDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 183 */       this._parent._accountBalance = argResultSet.getBigDecimal(14);
/* 184 */       this._parent._escrowBalance = argResultSet.getBigDecimal(15);
/* 185 */       this._parent._bonusBalance = argResultSet.getBigDecimal(16);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 190 */     argDAO.suppressStateChanges(true);
/* 191 */     CustomerLoyaltyAccountDAO dao = (CustomerLoyaltyAccountDAO)argDAO;
/* 192 */     dao.setOrganizationId(this._organizationId);
/* 193 */     dao.setCardNumber(this._cardNumber);
/* 194 */     dao.setAccountId(this._accountId);
/* 195 */     dao.setCreateDate(this._createDate);
/* 196 */     dao.setCreateUserId(this._createUserId);
/* 197 */     dao.setUpdateDate(this._updateDate);
/* 198 */     dao.setUpdateUserId(this._updateUserId);
/* 199 */     dao.setLoyaltyProgramId(this._loyaltyProgramId);
/* 200 */     dao.setLoyaltyProgramName(this._loyaltyProgramName);
/* 201 */     dao.setLoyaltyProgramLevelId(this._loyaltyProgramLevelId);
/* 202 */     dao.setLoyaltyProgramLevelName(this._loyaltyProgramLevelName);
/* 203 */     dao.setEffectiveDate(this._effectiveDate);
/* 204 */     dao.setExpirationDate(this._expirationDate);
/* 205 */     dao.setAccountBalance(this._accountBalance);
/* 206 */     dao.setEscrowBalance(this._escrowBalance);
/* 207 */     dao.setBonusBalance(this._bonusBalance);
/* 208 */     argDAO.suppressStateChanges(false);
/* 209 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 213 */     return loadDAO((IDataAccessObject)new CustomerLoyaltyAccountDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 217 */     CustomerLoyaltyAccountDAO dao = (CustomerLoyaltyAccountDAO)argDAO;
/* 218 */     this._organizationId = dao.getOrganizationId();
/* 219 */     this._cardNumber = dao.getCardNumber();
/* 220 */     this._accountId = dao.getAccountId();
/* 221 */     this._createDate = dao.getCreateDate();
/* 222 */     this._createUserId = dao.getCreateUserId();
/* 223 */     this._updateDate = dao.getUpdateDate();
/* 224 */     this._updateUserId = dao.getUpdateUserId();
/* 225 */     this._loyaltyProgramId = dao.getLoyaltyProgramId();
/* 226 */     this._loyaltyProgramName = dao.getLoyaltyProgramName();
/* 227 */     this._loyaltyProgramLevelId = dao.getLoyaltyProgramLevelId();
/* 228 */     this._loyaltyProgramLevelName = dao.getLoyaltyProgramLevelName();
/* 229 */     this._effectiveDate = dao.getEffectiveDate();
/* 230 */     this._expirationDate = dao.getExpirationDate();
/* 231 */     this._accountBalance = dao.getAccountBalance();
/* 232 */     this._escrowBalance = dao.getEscrowBalance();
/* 233 */     this._bonusBalance = dao.getBonusBalance();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 237 */     CustomerLoyaltyAccountId id = (CustomerLoyaltyAccountId)argId;
/* 238 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 239 */     argStatement.setString(2, id.getCardNumber());
/* 240 */     argStatement.setString(3, id.getAccountId());
/* 241 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 245 */     CustomerLoyaltyAccountId id = new CustomerLoyaltyAccountId();
/* 246 */     id.setOrganizationId(this._organizationId);
/* 247 */     id.setCardNumber(this._cardNumber);
/* 248 */     id.setAccountId(this._accountId);
/* 249 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 257 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 261 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerLoyaltyAccountDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */