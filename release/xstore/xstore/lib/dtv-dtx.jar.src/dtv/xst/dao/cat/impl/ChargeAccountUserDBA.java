/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.ChargeAccountUserId;
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
/*     */ 
/*     */ public class ChargeAccountUserDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -143206364L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private String _accountUserId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _accountUserName;
/*     */   private Date _effectiveDate;
/*     */   private Date _expirationDate;
/*     */   private Boolean _primaryContact;
/*     */   private Long _partyId;
/*     */   private String _accountUserFirstName;
/*     */   private String _accountUserLastName;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.acct_user_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.acct_user_name, t.effective_date, t.expiration_date, t.primary_contact_flag, t.party_id, t.acct_user_first_name, t.acct_user_last_name FROM cat_charge_acct_users t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND acct_user_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.acct_user_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.acct_user_name, t.effective_date, t.expiration_date, t.primary_contact_flag, t.party_id, t.acct_user_first_name, t.acct_user_last_name FROM cat_charge_acct_users t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND acct_user_id = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_charge_acct_users(organization_id, cust_acct_id, cust_acct_code, acct_user_id, create_date, create_user_id, update_date, update_user_id, acct_user_name, effective_date, expiration_date, primary_contact_flag, party_id, acct_user_first_name, acct_user_last_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._custAccountCode, this._accountUserId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._accountUserName, this._effectiveDate, this._expirationDate, this._primaryContact, this._partyId, this._accountUserFirstName, this._accountUserLastName } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 12, 91, 12, 12, 91, 91, -7, -5, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_charge_acct_users SET update_date = ?, update_user_id = ?, acct_user_name = ?, effective_date = ?, expiration_date = ?, primary_contact_flag = ?, party_id = ?, acct_user_first_name = ?, acct_user_last_name = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._accountUserName, this._effectiveDate, this._expirationDate, this._primaryContact, this._partyId, this._accountUserFirstName, this._accountUserLastName } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 91, 91, -7, -5, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_charge_acct_users" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND acct_user_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND acct_user_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._custAccountId, this._custAccountCode, this._accountUserId };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "cat_charge_acct_users";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new ChargeAccountUserFiller(this);
/*     */   }
/*     */   
/*     */   private static class ChargeAccountUserFiller
/*     */     implements IFiller {
/*     */     private ChargeAccountUserDBA _parent;
/*     */     
/*     */     public ChargeAccountUserFiller(ChargeAccountUserDBA argParent) {
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
/* 138 */       this._parent._custAccountId = argResultSet.getString(2);
/* 139 */       this._parent._custAccountCode = argResultSet.getString(3);
/* 140 */       this._parent._accountUserId = argResultSet.getString(4);
/*     */       
/* 142 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 143 */       if (t5 != null) {
/* 144 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 147 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 150 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 152 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 153 */       if (t7 != null) {
/* 154 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._updateUserId = argResultSet.getString(8);
/* 161 */       this._parent._accountUserName = argResultSet.getString(9);
/*     */       
/* 163 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 164 */       if (t10 != null) {
/* 165 */         this._parent._effectiveDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 168 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 172 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 173 */       if (t11 != null) {
/* 174 */         this._parent._expirationDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 177 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 180 */       this._parent._primaryContact = Boolean.valueOf(argResultSet.getBoolean(12));
/*     */ 
/*     */       
/* 183 */       long l1 = argResultSet.getLong(13);
/* 184 */       if (l1 != 0L || argResultSet.getObject(13) != null) {
/* 185 */         this._parent._partyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 189 */       this._parent._accountUserFirstName = argResultSet.getString(14);
/* 190 */       this._parent._accountUserLastName = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 195 */     argDAO.suppressStateChanges(true);
/* 196 */     ChargeAccountUserDAO dao = (ChargeAccountUserDAO)argDAO;
/* 197 */     dao.setOrganizationId(this._organizationId);
/* 198 */     dao.setCustAccountId(this._custAccountId);
/* 199 */     dao.setCustAccountCode(this._custAccountCode);
/* 200 */     dao.setAccountUserId(this._accountUserId);
/* 201 */     dao.setCreateDate(this._createDate);
/* 202 */     dao.setCreateUserId(this._createUserId);
/* 203 */     dao.setUpdateDate(this._updateDate);
/* 204 */     dao.setUpdateUserId(this._updateUserId);
/* 205 */     dao.setAccountUserName(this._accountUserName);
/* 206 */     dao.setEffectiveDate(this._effectiveDate);
/* 207 */     dao.setExpirationDate(this._expirationDate);
/* 208 */     dao.setPrimaryContact(this._primaryContact);
/* 209 */     dao.setPartyId(this._partyId);
/* 210 */     dao.setAccountUserFirstName(this._accountUserFirstName);
/* 211 */     dao.setAccountUserLastName(this._accountUserLastName);
/* 212 */     argDAO.suppressStateChanges(false);
/* 213 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 217 */     return loadDAO((IDataAccessObject)new ChargeAccountUserDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 221 */     ChargeAccountUserDAO dao = (ChargeAccountUserDAO)argDAO;
/* 222 */     this._organizationId = dao.getOrganizationId();
/* 223 */     this._custAccountId = dao.getCustAccountId();
/* 224 */     this._custAccountCode = dao.getCustAccountCode();
/* 225 */     this._accountUserId = dao.getAccountUserId();
/* 226 */     this._createDate = dao.getCreateDate();
/* 227 */     this._createUserId = dao.getCreateUserId();
/* 228 */     this._updateDate = dao.getUpdateDate();
/* 229 */     this._updateUserId = dao.getUpdateUserId();
/* 230 */     this._accountUserName = dao.getAccountUserName();
/* 231 */     this._effectiveDate = dao.getEffectiveDate();
/* 232 */     this._expirationDate = dao.getExpirationDate();
/* 233 */     this._primaryContact = (dao.getPrimaryContact() != null) ? dao.getPrimaryContact() : Boolean.valueOf(false);
/* 234 */     this._partyId = dao.getPartyId();
/* 235 */     this._accountUserFirstName = dao.getAccountUserFirstName();
/* 236 */     this._accountUserLastName = dao.getAccountUserLastName();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 240 */     ChargeAccountUserId id = (ChargeAccountUserId)argId;
/* 241 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 242 */     argStatement.setString(2, id.getCustAccountId());
/* 243 */     argStatement.setString(3, id.getCustAccountCode());
/* 244 */     argStatement.setString(4, id.getAccountUserId());
/* 245 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 249 */     ChargeAccountUserId id = new ChargeAccountUserId();
/* 250 */     id.setOrganizationId(this._organizationId);
/* 251 */     id.setCustAccountId(this._custAccountId);
/* 252 */     id.setCustAccountCode(this._custAccountCode);
/* 253 */     id.setAccountUserId(this._accountUserId);
/* 254 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 262 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 266 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\ChargeAccountUserDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */