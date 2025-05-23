/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.IHasIncrementalValues;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
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
/*     */ public class CustomerAccountDBA
/*     */   implements IJDBCTableAdapter, IHasIncrementalValues
/*     */ {
/*     */   private static final long serialVersionUID = -790272945L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private String _className;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _accountBalance;
/*     */   private BigDecimal _initAccountBalance;
/*     */   private Long _retailLocationId;
/*     */   private Boolean _custIdentityReq;
/*     */   private String _custIdentityTypeCode;
/*     */   private String _custAccountStateCode;
/*     */   private Date _accountSetupDate;
/*     */   private Date _lastActivityDate;
/*     */   private Long _partyId;
/*     */   private String _accountPurchaseOrderNumber;
/*     */   protected boolean _incrementalActive = true;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.dtv_class_name, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.acct_balance, t.rtl_loc_id, t.cust_identity_req_flag, t.cust_identity_typcode, t.cust_acct_statcode, t.acct_setup_date, t.last_activity_date, t.party_id, t.acct_po_nbr FROM cat_cust_acct t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   
/*     */   public void setIncrementalActive(boolean argActive) {
/*  46 */     this._incrementalActive = argActive;
/*     */   }
/*     */   
/*     */   public boolean getIncrementalActive() {
/*  50 */     return this._incrementalActive;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelect() {
/*  56 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  60 */     return "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.dtv_class_name, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.acct_balance, t.rtl_loc_id, t.cust_identity_req_flag, t.cust_identity_typcode, t.cust_acct_statcode, t.acct_setup_date, t.last_activity_date, t.party_id, t.acct_po_nbr FROM cat_cust_acct t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  66 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   }
/*     */   
/*  69 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_cust_acct(organization_id, cust_acct_id, cust_acct_code, dtv_class_name, create_date, create_user_id, update_date, update_user_id, acct_balance, rtl_loc_id, cust_identity_req_flag, cust_identity_typcode, cust_acct_statcode, acct_setup_date, last_activity_date, party_id, acct_po_nbr) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  72 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  76 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._custAccountCode, this._className, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._accountBalance, this._retailLocationId, this._custIdentityReq, this._custIdentityTypeCode, this._custAccountStateCode, this._accountSetupDate, this._lastActivityDate, this._partyId, this._accountPurchaseOrderNumber } };
/*  77 */     return insertParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 12, 91, 12, 3, -5, -7, 12, 12, 91, 91, -5, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  83 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*     */   public String[] getUpdate() {
/*  87 */     if (this._incrementalActive) {
/*  88 */       return getIncrementalUpdate();
/*     */     }
/*     */     
/*  91 */     return getStandardUpdate();
/*     */   }
/*     */ 
/*     */   
/*  95 */   private static final String[] INCREMENTAL_UPDATE_OBJECT = new String[] { "UPDATE cat_cust_acct SET dtv_class_name = ?, update_date = ?, update_user_id = ?, acct_balance = COALESCE(acct_balance,0) + ?, rtl_loc_id = ?, cust_identity_req_flag = ?, cust_identity_typcode = ?, cust_acct_statcode = ?, acct_setup_date = ?, last_activity_date = ?, party_id = ?, acct_po_nbr = ?" };
/*     */   
/*     */   public String[] getIncrementalUpdate() {
/*  98 */     return INCREMENTAL_UPDATE_OBJECT;
/*     */   }
/*     */   
/* 101 */   private static final String[] STANDARD_UPDATE_OBJECT = new String[] { "UPDATE cat_cust_acct SET dtv_class_name = ?, update_date = ?, update_user_id = ?, acct_balance = ?, rtl_loc_id = ?, cust_identity_req_flag = ?, cust_identity_typcode = ?, cust_acct_statcode = ?, acct_setup_date = ?, last_activity_date = ?, party_id = ?, acct_po_nbr = ?" };
/*     */   
/*     */   public String[] getStandardUpdate() {
/* 104 */     return STANDARD_UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 108 */     Object[][] updateParameterObject = { { this._className, this._updateDate, this._updateUserId, getAccountBalanceDiff(), this._retailLocationId, this._custIdentityReq, this._custIdentityTypeCode, this._custAccountStateCode, this._accountSetupDate, this._lastActivityDate, this._partyId, this._accountPurchaseOrderNumber } };
/* 109 */     return updateParameterObject;
/*     */   }
/*     */   
/* 112 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 91, 12, 3, -5, -7, 12, 12, 91, 91, -5, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 114 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 117 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_cust_acct" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 120 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 126 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 129 */     return new Object[] { this._organizationId, this._custAccountId, this._custAccountCode };
/*     */   }
/*     */   
/* 132 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 135 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */ 
/*     */   
/*     */   private BigDecimal getAccountBalanceDiff() {
/*     */     BigDecimal val1, val2;
/* 141 */     if (this._accountBalance == null) {
/* 142 */       val1 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 145 */       val1 = this._accountBalance;
/*     */     } 
/*     */     
/* 148 */     if (this._initAccountBalance == null) {
/* 149 */       val2 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 152 */       val2 = this._initAccountBalance;
/*     */     } 
/*     */     
/* 155 */     BigDecimal res = val1.subtract(val2);
/*     */     
/* 157 */     if (res.scale() < 8) {
/* 158 */       res = res.setScale(8);
/*     */     }
/*     */     
/* 161 */     return res;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 165 */     return "cat_cust_acct";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 169 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 173 */     return new CustomerAccountFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerAccountFiller
/*     */     implements IFiller {
/*     */     private CustomerAccountDBA _parent;
/*     */     
/*     */     public CustomerAccountFiller(CustomerAccountDBA argParent) {
/* 181 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 186 */       long primitiveResult = argResultSet.getLong(1);
/* 187 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 188 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 192 */       this._parent._custAccountId = argResultSet.getString(2);
/* 193 */       this._parent._custAccountCode = argResultSet.getString(3);
/* 194 */       this._parent._className = argResultSet.getString(4);
/*     */       
/* 196 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 197 */       if (t5 != null) {
/* 198 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 201 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 204 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 206 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 207 */       if (t7 != null) {
/* 208 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 211 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 214 */       this._parent._updateUserId = argResultSet.getString(8);
/* 215 */       this._parent._accountBalance = argResultSet.getBigDecimal(9);
/* 216 */       this._parent._initAccountBalance = argResultSet.getBigDecimal(9);
/*     */ 
/*     */       
/* 219 */       long l1 = argResultSet.getLong(10);
/* 220 */       if (l1 != 0L || argResultSet.getObject(10) != null) {
/* 221 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 225 */       this._parent._custIdentityReq = Boolean.valueOf(argResultSet.getBoolean(11));
/* 226 */       this._parent._custIdentityTypeCode = argResultSet.getString(12);
/* 227 */       this._parent._custAccountStateCode = argResultSet.getString(13);
/*     */       
/* 229 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 230 */       if (t14 != null) {
/* 231 */         this._parent._accountSetupDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 234 */         this._parent._accountSetupDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 238 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 239 */       if (t15 != null) {
/* 240 */         this._parent._lastActivityDate = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 243 */         this._parent._lastActivityDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 248 */       long l2 = argResultSet.getLong(16);
/* 249 */       if (l2 != 0L || argResultSet.getObject(16) != null) {
/* 250 */         this._parent._partyId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 254 */       this._parent._accountPurchaseOrderNumber = argResultSet.getString(17);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 259 */     argDAO.suppressStateChanges(true);
/* 260 */     CustomerAccountDAO dao = (CustomerAccountDAO)argDAO;
/* 261 */     dao.setOrganizationId(this._organizationId);
/* 262 */     dao.setCustAccountId(this._custAccountId);
/* 263 */     dao.setCustAccountCode(this._custAccountCode);
/* 264 */     dao.setClassName(this._className);
/* 265 */     dao.setCreateDate(this._createDate);
/* 266 */     dao.setCreateUserId(this._createUserId);
/* 267 */     dao.setUpdateDate(this._updateDate);
/* 268 */     dao.setUpdateUserId(this._updateUserId);
/* 269 */     dao.setAccountBalance(this._accountBalance);
/* 270 */     dao.setInitAccountBalance(this._accountBalance);
/* 271 */     dao.setRetailLocationId(this._retailLocationId);
/* 272 */     dao.setCustIdentityReq(this._custIdentityReq);
/* 273 */     dao.setCustIdentityTypeCode(this._custIdentityTypeCode);
/* 274 */     dao.setCustAccountStateCode(this._custAccountStateCode);
/* 275 */     dao.setAccountSetupDate(this._accountSetupDate);
/* 276 */     dao.setLastActivityDate(this._lastActivityDate);
/* 277 */     dao.setPartyId(this._partyId);
/* 278 */     dao.setAccountPurchaseOrderNumber(this._accountPurchaseOrderNumber);
/* 279 */     argDAO.suppressStateChanges(false);
/* 280 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 284 */     return loadDAO((IDataAccessObject)new CustomerAccountDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 288 */     CustomerAccountDAO dao = (CustomerAccountDAO)argDAO;
/* 289 */     this._organizationId = dao.getOrganizationId();
/* 290 */     this._custAccountId = dao.getCustAccountId();
/* 291 */     this._custAccountCode = dao.getCustAccountCode();
/* 292 */     this._className = dao.getClassName();
/* 293 */     this._createDate = dao.getCreateDate();
/* 294 */     this._createUserId = dao.getCreateUserId();
/* 295 */     this._updateDate = dao.getUpdateDate();
/* 296 */     this._updateUserId = dao.getUpdateUserId();
/* 297 */     this._accountBalance = dao.getAccountBalance();
/* 298 */     this._initAccountBalance = dao.getInitAccountBalance();
/* 299 */     this._retailLocationId = dao.getRetailLocationId();
/* 300 */     this._custIdentityReq = (dao.getCustIdentityReq() != null) ? dao.getCustIdentityReq() : Boolean.valueOf(false);
/* 301 */     this._custIdentityTypeCode = dao.getCustIdentityTypeCode();
/* 302 */     this._custAccountStateCode = dao.getCustAccountStateCode();
/* 303 */     this._accountSetupDate = dao.getAccountSetupDate();
/* 304 */     this._lastActivityDate = dao.getLastActivityDate();
/* 305 */     this._partyId = dao.getPartyId();
/* 306 */     this._accountPurchaseOrderNumber = dao.getAccountPurchaseOrderNumber();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 310 */     CustomerAccountId id = (CustomerAccountId)argId;
/* 311 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 312 */     argStatement.setString(2, id.getCustAccountId());
/* 313 */     argStatement.setString(3, id.getCustAccountCode());
/* 314 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 318 */     CustomerAccountId id = new CustomerAccountId();
/* 319 */     id.setOrganizationId(this._organizationId);
/* 320 */     id.setCustAccountId(this._custAccountId);
/* 321 */     id.setCustAccountCode(this._custAccountCode);
/* 322 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {
/* 326 */     CustomerAccountDBA adapter = (CustomerAccountDBA)argAdapter;
/* 327 */     this._organizationId = adapter._organizationId;
/* 328 */     this._custAccountId = adapter._custAccountId;
/* 329 */     this._custAccountCode = adapter._custAccountCode;
/* 330 */     this._className = adapter._className;
/* 331 */     this._createDate = adapter._createDate;
/* 332 */     this._createUserId = adapter._createUserId;
/* 333 */     this._updateDate = adapter._updateDate;
/* 334 */     this._updateUserId = adapter._updateUserId;
/* 335 */     this._accountBalance = adapter._accountBalance;
/* 336 */     this._retailLocationId = adapter._retailLocationId;
/* 337 */     this._custIdentityReq = adapter._custIdentityReq;
/* 338 */     this._custIdentityTypeCode = adapter._custIdentityTypeCode;
/* 339 */     this._custAccountStateCode = adapter._custAccountStateCode;
/* 340 */     this._accountSetupDate = adapter._accountSetupDate;
/* 341 */     this._lastActivityDate = adapter._lastActivityDate;
/* 342 */     this._partyId = adapter._partyId;
/* 343 */     this._accountPurchaseOrderNumber = adapter._accountPurchaseOrderNumber;
/*     */   }
/*     */   
/*     */   public boolean isExtensible() {
/* 347 */     return true;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 351 */     return this._className;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */