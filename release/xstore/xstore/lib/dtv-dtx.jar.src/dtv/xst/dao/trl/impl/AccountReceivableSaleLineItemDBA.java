/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemId;
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
/*     */ public class AccountReceivableSaleLineItemDBA
/*     */   extends SaleReturnLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 2138815799L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _activityCode;
/*     */   private String _adjudicationCode;
/*     */   private String _authorizationCode;
/*     */   private String _authorizationMethodCode;
/*     */   private String _entryMethodCode;
/*     */   private String _accountNumber;
/*     */   private String _bankReferenceNumber;
/*     */   private String _accountUserId;
/*     */   private String _accountUserName;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.activity_code, t.adjudication_code, t.auth_code, t.auth_mthd_code, t.entry_mthd_code, t.acct_nbr, t.reference_nbr, t.acct_user_id, t.acct_user_name FROM trl_ar_sale_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  49 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  53 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.activity_code, t.adjudication_code, t.auth_code, t.auth_mthd_code, t.entry_mthd_code, t.acct_nbr, t.reference_nbr, t.acct_user_id, t.acct_user_name FROM trl_ar_sale_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  60 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  63 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_ar_sale_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, activity_code, adjudication_code, auth_code, auth_mthd_code, entry_mthd_code, acct_nbr, reference_nbr, acct_user_id, acct_user_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  67 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  72 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._activityCode, this._adjudicationCode, this._authorizationCode, this._authorizationMethodCode, this._entryMethodCode, this._accountNumber, this._bankReferenceNumber, this._accountUserId, this._accountUserName } };
/*  73 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  76 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  80 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  83 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_ar_sale_lineitm SET update_date = ?, update_user_id = ?, activity_code = ?, adjudication_code = ?, auth_code = ?, auth_mthd_code = ?, entry_mthd_code = ?, acct_nbr = ?, reference_nbr = ?, acct_user_id = ?, acct_user_name = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  87 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  92 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._activityCode, this._adjudicationCode, this._authorizationCode, this._authorizationMethodCode, this._entryMethodCode, this._accountNumber, this._bankReferenceNumber, this._accountUserId, this._accountUserName } };
/*  93 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  96 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  99 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 102 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_ar_sale_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 106 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 113 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 117 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 120 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 124 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 128 */     return "trl_ar_sale_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 133 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 137 */     return new AccountReceivableSaleLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class AccountReceivableSaleLineItemFiller
/*     */     implements IFiller {
/*     */     private AccountReceivableSaleLineItemDBA _parent;
/*     */     
/*     */     public AccountReceivableSaleLineItemFiller(AccountReceivableSaleLineItemDBA argParent) {
/* 145 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 150 */       long primitiveResult = argResultSet.getLong(1);
/* 151 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 152 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 158 */       primitiveResult = argResultSet.getLong(2);
/* 159 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 160 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 165 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 166 */       if (t3 != null) {
/* 167 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 175 */       long l1 = argResultSet.getLong(4);
/* 176 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 177 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 183 */       l1 = argResultSet.getLong(5);
/* 184 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 185 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 191 */       int i = argResultSet.getInt(6);
/* 192 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 193 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 198 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 199 */       if (t7 != null) {
/* 200 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 203 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 206 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 208 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 209 */       if (t9 != null) {
/* 210 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 213 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 216 */       this._parent._updateUserId = argResultSet.getString(10);
/* 217 */       this._parent._activityCode = argResultSet.getString(11);
/* 218 */       this._parent._adjudicationCode = argResultSet.getString(12);
/* 219 */       this._parent._authorizationCode = argResultSet.getString(13);
/* 220 */       this._parent._authorizationMethodCode = argResultSet.getString(14);
/* 221 */       this._parent._entryMethodCode = argResultSet.getString(15);
/* 222 */       this._parent._accountNumber = argResultSet.getString(16);
/* 223 */       this._parent._bankReferenceNumber = argResultSet.getString(17);
/* 224 */       this._parent._accountUserId = argResultSet.getString(18);
/* 225 */       this._parent._accountUserName = argResultSet.getString(19);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 231 */     super.loadDAO(argDAO);
/* 232 */     argDAO.suppressStateChanges(true);
/* 233 */     AccountReceivableSaleLineItemDAO dao = (AccountReceivableSaleLineItemDAO)argDAO;
/* 234 */     dao.setOrganizationId(this._organizationId);
/* 235 */     dao.setRetailLocationId(this._retailLocationId);
/* 236 */     dao.setBusinessDate(this._businessDate);
/* 237 */     dao.setWorkstationId(this._workstationId);
/* 238 */     dao.setTransactionSequence(this._transactionSequence);
/* 239 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 240 */     dao.setCreateDate(this._createDate);
/* 241 */     dao.setCreateUserId(this._createUserId);
/* 242 */     dao.setUpdateDate(this._updateDate);
/* 243 */     dao.setUpdateUserId(this._updateUserId);
/* 244 */     dao.setActivityCode(this._activityCode);
/* 245 */     dao.setAdjudicationCode(this._adjudicationCode);
/* 246 */     dao.setAuthorizationCode(this._authorizationCode);
/* 247 */     dao.setAuthorizationMethodCode(this._authorizationMethodCode);
/* 248 */     dao.setEntryMethodCode(this._entryMethodCode);
/* 249 */     dao.setAccountNumber(this._accountNumber);
/* 250 */     dao.setBankReferenceNumber(this._bankReferenceNumber);
/* 251 */     dao.setAccountUserId(this._accountUserId);
/* 252 */     dao.setAccountUserName(this._accountUserName);
/* 253 */     argDAO.suppressStateChanges(false);
/* 254 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 259 */     return loadDAO((IDataAccessObject)new AccountReceivableSaleLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 264 */     AccountReceivableSaleLineItemDAO dao = (AccountReceivableSaleLineItemDAO)argDAO;
/* 265 */     super.fill((IDataAccessObject)dao);
/* 266 */     this._organizationId = dao.getOrganizationId();
/* 267 */     this._retailLocationId = dao.getRetailLocationId();
/* 268 */     this._businessDate = dao.getBusinessDate();
/* 269 */     this._workstationId = dao.getWorkstationId();
/* 270 */     this._transactionSequence = dao.getTransactionSequence();
/* 271 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 272 */     this._createDate = dao.getCreateDate();
/* 273 */     this._createUserId = dao.getCreateUserId();
/* 274 */     this._updateDate = dao.getUpdateDate();
/* 275 */     this._updateUserId = dao.getUpdateUserId();
/* 276 */     this._activityCode = dao.getActivityCode();
/* 277 */     this._adjudicationCode = dao.getAdjudicationCode();
/* 278 */     this._authorizationCode = dao.getAuthorizationCode();
/* 279 */     this._authorizationMethodCode = dao.getAuthorizationMethodCode();
/* 280 */     this._entryMethodCode = dao.getEntryMethodCode();
/* 281 */     this._accountNumber = dao.getAccountNumber();
/* 282 */     this._bankReferenceNumber = dao.getBankReferenceNumber();
/* 283 */     this._accountUserId = dao.getAccountUserId();
/* 284 */     this._accountUserName = dao.getAccountUserName();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 289 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 290 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 291 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 292 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 293 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 294 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 295 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 296 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 300 */     String[] sels = super.getAllSelects();
/* 301 */     String[] result = new String[sels.length + 1];
/* 302 */     result[0] = getSelectImpl();
/* 303 */     System.arraycopy(sels, 0, result, 1, sels.length);
/* 304 */     return result;
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 308 */     IFiller[] fills = super.getAllFillers();
/* 309 */     IFiller[] result = new IFiller[fills.length + 1];
/* 310 */     result[0] = getFillerImpl();
/* 311 */     System.arraycopy(fills, 0, result, 1, fills.length);
/* 312 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\AccountReceivableSaleLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */