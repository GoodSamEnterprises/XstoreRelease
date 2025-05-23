/*     */ package dtv.xst.dao.ttr.impl;
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
/*     */ public class AccountReceivableTenderLineItemDBA
/*     */   extends TenderLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -42857340L;
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
/*     */   private String _accountNumber;
/*     */   private String _approvalCode;
/*     */   private Long _partyId;
/*     */   private String _accountUserName;
/*     */   private String _poNumber;
/*     */   private String _adjudicationCode;
/*     */   private String _authorizationMethodCode;
/*     */   private String _activityCode;
/*     */   private String _entryMethodCode;
/*     */   private String _authorizationCode;
/*     */   private String _accountUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.acct_nbr, t.approval_code, t.party_id, t.acct_user_name, t.po_number, t.adjudication_code, t.auth_mthd_code, t.activity_code, t.entry_mthd_code, t.auth_code, t.acct_user_id FROM ttr_ar_tndr_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  51 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  55 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.acct_nbr, t.approval_code, t.party_id, t.acct_user_name, t.po_number, t.adjudication_code, t.auth_mthd_code, t.activity_code, t.entry_mthd_code, t.auth_code, t.acct_user_id FROM ttr_ar_tndr_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  62 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  65 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ttr_ar_tndr_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, acct_nbr, approval_code, party_id, acct_user_name, po_number, adjudication_code, auth_mthd_code, activity_code, entry_mthd_code, auth_code, acct_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  69 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  74 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._accountNumber, this._approvalCode, this._partyId, this._accountUserName, this._poNumber, this._adjudicationCode, this._authorizationMethodCode, this._activityCode, this._entryMethodCode, this._authorizationCode, this._accountUserId } };
/*  75 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  78 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 12, -5, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  82 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  85 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ttr_ar_tndr_lineitm SET update_date = ?, update_user_id = ?, acct_nbr = ?, approval_code = ?, party_id = ?, acct_user_name = ?, po_number = ?, adjudication_code = ?, auth_mthd_code = ?, activity_code = ?, entry_mthd_code = ?, auth_code = ?, acct_user_id = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  89 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  94 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._accountNumber, this._approvalCode, this._partyId, this._accountUserName, this._poNumber, this._adjudicationCode, this._authorizationMethodCode, this._activityCode, this._entryMethodCode, this._authorizationCode, this._accountUserId } };
/*  95 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  98 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, -5, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/* 101 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 104 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ttr_ar_tndr_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 108 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 115 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 119 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 122 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 126 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 130 */     return "ttr_ar_tndr_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 135 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 139 */     return new AccountReceivableTenderLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class AccountReceivableTenderLineItemFiller
/*     */     implements IFiller {
/*     */     private AccountReceivableTenderLineItemDBA _parent;
/*     */     
/*     */     public AccountReceivableTenderLineItemFiller(AccountReceivableTenderLineItemDBA argParent) {
/* 147 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 152 */       long primitiveResult = argResultSet.getLong(1);
/* 153 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 154 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 160 */       primitiveResult = argResultSet.getLong(2);
/* 161 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 162 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 167 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 168 */       if (t3 != null) {
/* 169 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 172 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 177 */       long l1 = argResultSet.getLong(4);
/* 178 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 179 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 185 */       l1 = argResultSet.getLong(5);
/* 186 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 187 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 193 */       int i = argResultSet.getInt(6);
/* 194 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 195 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 200 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 201 */       if (t7 != null) {
/* 202 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 205 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 208 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 210 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 211 */       if (t9 != null) {
/* 212 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 215 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 218 */       this._parent._updateUserId = argResultSet.getString(10);
/* 219 */       this._parent._accountNumber = argResultSet.getString(11);
/* 220 */       this._parent._approvalCode = argResultSet.getString(12);
/*     */ 
/*     */       
/* 223 */       long l2 = argResultSet.getLong(13);
/* 224 */       if (l2 != 0L || argResultSet.getObject(13) != null) {
/* 225 */         this._parent._partyId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 229 */       this._parent._accountUserName = argResultSet.getString(14);
/* 230 */       this._parent._poNumber = argResultSet.getString(15);
/* 231 */       this._parent._adjudicationCode = argResultSet.getString(16);
/* 232 */       this._parent._authorizationMethodCode = argResultSet.getString(17);
/* 233 */       this._parent._activityCode = argResultSet.getString(18);
/* 234 */       this._parent._entryMethodCode = argResultSet.getString(19);
/* 235 */       this._parent._authorizationCode = argResultSet.getString(20);
/* 236 */       this._parent._accountUserId = argResultSet.getString(21);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 242 */     super.loadDAO(argDAO);
/* 243 */     argDAO.suppressStateChanges(true);
/* 244 */     AccountReceivableTenderLineItemDAO dao = (AccountReceivableTenderLineItemDAO)argDAO;
/* 245 */     dao.setOrganizationId(this._organizationId);
/* 246 */     dao.setRetailLocationId(this._retailLocationId);
/* 247 */     dao.setBusinessDate(this._businessDate);
/* 248 */     dao.setWorkstationId(this._workstationId);
/* 249 */     dao.setTransactionSequence(this._transactionSequence);
/* 250 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 251 */     dao.setCreateDate(this._createDate);
/* 252 */     dao.setCreateUserId(this._createUserId);
/* 253 */     dao.setUpdateDate(this._updateDate);
/* 254 */     dao.setUpdateUserId(this._updateUserId);
/* 255 */     dao.setAccountNumber(this._accountNumber);
/* 256 */     dao.setApprovalCode(this._approvalCode);
/* 257 */     dao.setPartyId(this._partyId);
/* 258 */     dao.setAccountUserName(this._accountUserName);
/* 259 */     dao.setPoNumber(this._poNumber);
/* 260 */     dao.setAdjudicationCode(this._adjudicationCode);
/* 261 */     dao.setAuthorizationMethodCode(this._authorizationMethodCode);
/* 262 */     dao.setActivityCode(this._activityCode);
/* 263 */     dao.setEntryMethodCode(this._entryMethodCode);
/* 264 */     dao.setAuthorizationCode(this._authorizationCode);
/* 265 */     dao.setAccountUserId(this._accountUserId);
/* 266 */     argDAO.suppressStateChanges(false);
/* 267 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 272 */     return loadDAO((IDataAccessObject)new AccountReceivableTenderLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 277 */     AccountReceivableTenderLineItemDAO dao = (AccountReceivableTenderLineItemDAO)argDAO;
/* 278 */     super.fill((IDataAccessObject)dao);
/* 279 */     this._organizationId = dao.getOrganizationId();
/* 280 */     this._retailLocationId = dao.getRetailLocationId();
/* 281 */     this._businessDate = dao.getBusinessDate();
/* 282 */     this._workstationId = dao.getWorkstationId();
/* 283 */     this._transactionSequence = dao.getTransactionSequence();
/* 284 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 285 */     this._createDate = dao.getCreateDate();
/* 286 */     this._createUserId = dao.getCreateUserId();
/* 287 */     this._updateDate = dao.getUpdateDate();
/* 288 */     this._updateUserId = dao.getUpdateUserId();
/* 289 */     this._accountNumber = dao.getAccountNumber();
/* 290 */     this._approvalCode = dao.getApprovalCode();
/* 291 */     this._partyId = dao.getPartyId();
/* 292 */     this._accountUserName = dao.getAccountUserName();
/* 293 */     this._poNumber = dao.getPoNumber();
/* 294 */     this._adjudicationCode = dao.getAdjudicationCode();
/* 295 */     this._authorizationMethodCode = dao.getAuthorizationMethodCode();
/* 296 */     this._activityCode = dao.getActivityCode();
/* 297 */     this._entryMethodCode = dao.getEntryMethodCode();
/* 298 */     this._authorizationCode = dao.getAuthorizationCode();
/* 299 */     this._accountUserId = dao.getAccountUserId();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 304 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 305 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 306 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 307 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 308 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 309 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 310 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 311 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 315 */     String[] sels = super.getAllSelects();
/* 316 */     String[] result = new String[sels.length + 1];
/* 317 */     result[0] = getSelectImpl();
/* 318 */     System.arraycopy(sels, 0, result, 1, sels.length);
/* 319 */     return result;
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 323 */     IFiller[] fills = super.getAllFillers();
/* 324 */     IFiller[] result = new IFiller[fills.length + 1];
/* 325 */     result[0] = getFillerImpl();
/* 326 */     System.arraycopy(fills, 0, result, 1, fills.length);
/* 327 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\AccountReceivableTenderLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */