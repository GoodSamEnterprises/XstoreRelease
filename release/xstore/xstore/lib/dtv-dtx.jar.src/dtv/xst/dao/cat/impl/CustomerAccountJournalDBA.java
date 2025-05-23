/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
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
/*     */ 
/*     */ public class CustomerAccountJournalDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1713126376L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Long _journalSequence;
/*     */   private String _className;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _retailLocationId;
/*     */   private BigDecimal _accountBalance;
/*     */   private String _custIdentityTypeCode;
/*     */   private Long _transRetailLocationId;
/*     */   private Long _transWorkstationId;
/*     */   private Date _transBusinessDate;
/*     */   private Long _transSequence;
/*     */   private Long _partyId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.journal_seq, t.dtv_class_name, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.rtl_loc_id, t.acct_balance, t.cust_identity_typcode, t.trans_rtl_loc_id, t.trans_wkstn_id, t.trans_business_date, t.trans_trans_seq, t.party_id FROM cat_cust_acct_journal t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND journal_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.journal_seq, t.dtv_class_name, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.rtl_loc_id, t.acct_balance, t.cust_identity_typcode, t.trans_rtl_loc_id, t.trans_wkstn_id, t.trans_business_date, t.trans_trans_seq, t.party_id FROM cat_cust_acct_journal t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND journal_seq = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_cust_acct_journal(organization_id, cust_acct_id, cust_acct_code, journal_seq, dtv_class_name, create_date, create_user_id, update_date, update_user_id, rtl_loc_id, acct_balance, cust_identity_typcode, trans_rtl_loc_id, trans_wkstn_id, trans_business_date, trans_trans_seq, party_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._custAccountCode, this._journalSequence, this._className, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._retailLocationId, this._accountBalance, this._custIdentityTypeCode, this._transRetailLocationId, this._transWorkstationId, this._transBusinessDate, this._transSequence, this._partyId } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, -5, 12, 91, 12, 91, 12, -5, 3, 12, -5, -5, 91, -5, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_cust_acct_journal SET dtv_class_name = ?, update_date = ?, update_user_id = ?, rtl_loc_id = ?, acct_balance = ?, cust_identity_typcode = ?, trans_rtl_loc_id = ?, trans_wkstn_id = ?, trans_business_date = ?, trans_trans_seq = ?, party_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._className, this._updateDate, this._updateUserId, this._retailLocationId, this._accountBalance, this._custIdentityTypeCode, this._transRetailLocationId, this._transWorkstationId, this._transBusinessDate, this._transSequence, this._partyId } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 91, 12, -5, 3, 12, -5, -5, 91, -5, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_cust_acct_journal" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND journal_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND journal_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[] { this._organizationId, this._custAccountId, this._custAccountCode, this._journalSequence };
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "cat_cust_acct_journal";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new CustomerAccountJournalFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerAccountJournalFiller
/*     */     implements IFiller {
/*     */     private CustomerAccountJournalDBA _parent;
/*     */     
/*     */     public CustomerAccountJournalFiller(CustomerAccountJournalDBA argParent) {
/* 129 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 134 */       long primitiveResult = argResultSet.getLong(1);
/* 135 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 136 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 140 */       this._parent._custAccountId = argResultSet.getString(2);
/* 141 */       this._parent._custAccountCode = argResultSet.getString(3);
/*     */ 
/*     */       
/* 144 */       primitiveResult = argResultSet.getLong(4);
/* 145 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 146 */         this._parent._journalSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 150 */       this._parent._className = argResultSet.getString(5);
/*     */       
/* 152 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 153 */       if (t6 != null) {
/* 154 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 162 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 163 */       if (t8 != null) {
/* 164 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 167 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 170 */       this._parent._updateUserId = argResultSet.getString(9);
/*     */ 
/*     */       
/* 173 */       long l1 = argResultSet.getLong(10);
/* 174 */       if (l1 != 0L || argResultSet.getObject(10) != null) {
/* 175 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 179 */       this._parent._accountBalance = argResultSet.getBigDecimal(11);
/* 180 */       this._parent._custIdentityTypeCode = argResultSet.getString(12);
/*     */ 
/*     */       
/* 183 */       l1 = argResultSet.getLong(13);
/* 184 */       if (l1 != 0L || argResultSet.getObject(13) != null) {
/* 185 */         this._parent._transRetailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 191 */       l1 = argResultSet.getLong(14);
/* 192 */       if (l1 != 0L || argResultSet.getObject(14) != null) {
/* 193 */         this._parent._transWorkstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 198 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 199 */       if (t15 != null) {
/* 200 */         this._parent._transBusinessDate = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 203 */         this._parent._transBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 208 */       long l2 = argResultSet.getLong(16);
/* 209 */       if (l2 != 0L || argResultSet.getObject(16) != null) {
/* 210 */         this._parent._transSequence = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 216 */       l2 = argResultSet.getLong(17);
/* 217 */       if (l2 != 0L || argResultSet.getObject(17) != null) {
/* 218 */         this._parent._partyId = Long.valueOf(l2);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 226 */     argDAO.suppressStateChanges(true);
/* 227 */     CustomerAccountJournalDAO dao = (CustomerAccountJournalDAO)argDAO;
/* 228 */     dao.setOrganizationId(this._organizationId);
/* 229 */     dao.setCustAccountId(this._custAccountId);
/* 230 */     dao.setCustAccountCode(this._custAccountCode);
/* 231 */     dao.setJournalSequence(this._journalSequence);
/* 232 */     dao.setClassName(this._className);
/* 233 */     dao.setCreateDate(this._createDate);
/* 234 */     dao.setCreateUserId(this._createUserId);
/* 235 */     dao.setUpdateDate(this._updateDate);
/* 236 */     dao.setUpdateUserId(this._updateUserId);
/* 237 */     dao.setRetailLocationId(this._retailLocationId);
/* 238 */     dao.setAccountBalance(this._accountBalance);
/* 239 */     dao.setCustIdentityTypeCode(this._custIdentityTypeCode);
/* 240 */     dao.setTransRetailLocationId(this._transRetailLocationId);
/* 241 */     dao.setTransWorkstationId(this._transWorkstationId);
/* 242 */     dao.setTransBusinessDate(this._transBusinessDate);
/* 243 */     dao.setTransSequence(this._transSequence);
/* 244 */     dao.setPartyId(this._partyId);
/* 245 */     argDAO.suppressStateChanges(false);
/* 246 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 250 */     return loadDAO((IDataAccessObject)new CustomerAccountJournalDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 254 */     CustomerAccountJournalDAO dao = (CustomerAccountJournalDAO)argDAO;
/* 255 */     this._organizationId = dao.getOrganizationId();
/* 256 */     this._custAccountId = dao.getCustAccountId();
/* 257 */     this._custAccountCode = dao.getCustAccountCode();
/* 258 */     this._journalSequence = dao.getJournalSequence();
/* 259 */     this._className = dao.getClassName();
/* 260 */     this._createDate = dao.getCreateDate();
/* 261 */     this._createUserId = dao.getCreateUserId();
/* 262 */     this._updateDate = dao.getUpdateDate();
/* 263 */     this._updateUserId = dao.getUpdateUserId();
/* 264 */     this._retailLocationId = dao.getRetailLocationId();
/* 265 */     this._accountBalance = dao.getAccountBalance();
/* 266 */     this._custIdentityTypeCode = dao.getCustIdentityTypeCode();
/* 267 */     this._transRetailLocationId = dao.getTransRetailLocationId();
/* 268 */     this._transWorkstationId = dao.getTransWorkstationId();
/* 269 */     this._transBusinessDate = dao.getTransBusinessDate();
/* 270 */     this._transSequence = dao.getTransSequence();
/* 271 */     this._partyId = dao.getPartyId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 275 */     CustomerAccountJournalId id = (CustomerAccountJournalId)argId;
/* 276 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 277 */     argStatement.setString(2, id.getCustAccountId());
/* 278 */     argStatement.setString(3, id.getCustAccountCode());
/* 279 */     argStatement.setLong(4, id.getJournalSequence().longValue());
/* 280 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 284 */     CustomerAccountJournalId id = new CustomerAccountJournalId();
/* 285 */     id.setOrganizationId(this._organizationId);
/* 286 */     id.setCustAccountId(this._custAccountId);
/* 287 */     id.setCustAccountCode(this._custAccountCode);
/* 288 */     id.setJournalSequence(this._journalSequence);
/* 289 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {
/* 293 */     CustomerAccountJournalDBA adapter = (CustomerAccountJournalDBA)argAdapter;
/* 294 */     this._organizationId = adapter._organizationId;
/* 295 */     this._custAccountId = adapter._custAccountId;
/* 296 */     this._custAccountCode = adapter._custAccountCode;
/* 297 */     this._journalSequence = adapter._journalSequence;
/* 298 */     this._className = adapter._className;
/* 299 */     this._createDate = adapter._createDate;
/* 300 */     this._createUserId = adapter._createUserId;
/* 301 */     this._updateDate = adapter._updateDate;
/* 302 */     this._updateUserId = adapter._updateUserId;
/* 303 */     this._retailLocationId = adapter._retailLocationId;
/* 304 */     this._accountBalance = adapter._accountBalance;
/* 305 */     this._custIdentityTypeCode = adapter._custIdentityTypeCode;
/* 306 */     this._transRetailLocationId = adapter._transRetailLocationId;
/* 307 */     this._transWorkstationId = adapter._transWorkstationId;
/* 308 */     this._transBusinessDate = adapter._transBusinessDate;
/* 309 */     this._transSequence = adapter._transSequence;
/* 310 */     this._partyId = adapter._partyId;
/*     */   }
/*     */   
/*     */   public boolean isExtensible() {
/* 314 */     return true;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 318 */     return this._className;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountJournalDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */