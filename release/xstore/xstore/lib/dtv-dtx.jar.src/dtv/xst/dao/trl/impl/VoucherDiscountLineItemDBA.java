/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemId;
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
/*     */ public class VoucherDiscountLineItemDBA
/*     */   extends DiscountLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -379249610L;
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
/*     */   private String _serialNumber;
/*     */   private String _voucherTypeCode;
/*     */   private String _bankReferenceNumber;
/*     */   private Date _effectiveDate;
/*     */   private Date _expirationDate;
/*     */   private BigDecimal _faceValueAmount;
/*     */   private Date _issueDatetimestamp;
/*     */   private String _issueTypeCode;
/*     */   private BigDecimal _unspentBalanceAmount;
/*     */   private String _voucherStatusCode;
/*     */   private String _traceNumber;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.activity_code, t.adjudication_code, t.auth_code, t.auth_mthd_code, t.entry_mthd_code, t.serial_nbr, t.voucher_typcode, t.reference_nbr, t.effective_date, t.expr_date, t.face_value_amt, t.issue_datetime, t.issue_typcode, t.unspent_balance_amt, t.voucher_status_code, t.trace_number FROM trl_voucher_discount_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  56 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  60 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.activity_code, t.adjudication_code, t.auth_code, t.auth_mthd_code, t.entry_mthd_code, t.serial_nbr, t.voucher_typcode, t.reference_nbr, t.effective_date, t.expr_date, t.face_value_amt, t.issue_datetime, t.issue_typcode, t.unspent_balance_amt, t.voucher_status_code, t.trace_number FROM trl_voucher_discount_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  67 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  70 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_voucher_discount_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, activity_code, adjudication_code, auth_code, auth_mthd_code, entry_mthd_code, serial_nbr, voucher_typcode, reference_nbr, effective_date, expr_date, face_value_amt, issue_datetime, issue_typcode, unspent_balance_amt, voucher_status_code, trace_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  74 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  79 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._activityCode, this._adjudicationCode, this._authorizationCode, this._authorizationMethodCode, this._entryMethodCode, this._serialNumber, this._voucherTypeCode, this._bankReferenceNumber, this._effectiveDate, this._expirationDate, this._faceValueAmount, this._issueDatetimestamp, this._issueTypeCode, this._unspentBalanceAmount, this._voucherStatusCode, this._traceNumber } };
/*  80 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  83 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 91, 91, 3, 91, 12, 3, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  87 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  90 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_voucher_discount_lineitm SET update_date = ?, update_user_id = ?, activity_code = ?, adjudication_code = ?, auth_code = ?, auth_mthd_code = ?, entry_mthd_code = ?, serial_nbr = ?, voucher_typcode = ?, reference_nbr = ?, effective_date = ?, expr_date = ?, face_value_amt = ?, issue_datetime = ?, issue_typcode = ?, unspent_balance_amt = ?, voucher_status_code = ?, trace_number = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  94 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  99 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._activityCode, this._adjudicationCode, this._authorizationCode, this._authorizationMethodCode, this._entryMethodCode, this._serialNumber, this._voucherTypeCode, this._bankReferenceNumber, this._effectiveDate, this._expirationDate, this._faceValueAmount, this._issueDatetimestamp, this._issueTypeCode, this._unspentBalanceAmount, this._voucherStatusCode, this._traceNumber } };
/* 100 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/* 103 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 91, 91, 3, 91, 12, 3, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/* 106 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 109 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_voucher_discount_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 113 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 120 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 124 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 127 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 131 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 135 */     return "trl_voucher_discount_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 140 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 144 */     return new VoucherDiscountLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class VoucherDiscountLineItemFiller
/*     */     implements IFiller {
/*     */     private VoucherDiscountLineItemDBA _parent;
/*     */     
/*     */     public VoucherDiscountLineItemFiller(VoucherDiscountLineItemDBA argParent) {
/* 152 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 157 */       long primitiveResult = argResultSet.getLong(1);
/* 158 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 159 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 165 */       primitiveResult = argResultSet.getLong(2);
/* 166 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 167 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 172 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 173 */       if (t3 != null) {
/* 174 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 177 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 182 */       long l1 = argResultSet.getLong(4);
/* 183 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 184 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 190 */       l1 = argResultSet.getLong(5);
/* 191 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 192 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 198 */       int i = argResultSet.getInt(6);
/* 199 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 200 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 205 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 206 */       if (t7 != null) {
/* 207 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 210 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 213 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 215 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 216 */       if (t9 != null) {
/* 217 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 220 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 223 */       this._parent._updateUserId = argResultSet.getString(10);
/* 224 */       this._parent._activityCode = argResultSet.getString(11);
/* 225 */       this._parent._adjudicationCode = argResultSet.getString(12);
/* 226 */       this._parent._authorizationCode = argResultSet.getString(13);
/* 227 */       this._parent._authorizationMethodCode = argResultSet.getString(14);
/* 228 */       this._parent._entryMethodCode = argResultSet.getString(15);
/* 229 */       this._parent._serialNumber = argResultSet.getString(16);
/* 230 */       this._parent._voucherTypeCode = argResultSet.getString(17);
/* 231 */       this._parent._bankReferenceNumber = argResultSet.getString(18);
/*     */       
/* 233 */       Timestamp t19 = argResultSet.getTimestamp(19);
/* 234 */       if (t19 != null) {
/* 235 */         this._parent._effectiveDate = (Date)new DtvDate(t19.getTime());
/*     */       } else {
/*     */         
/* 238 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 242 */       Timestamp t20 = argResultSet.getTimestamp(20);
/* 243 */       if (t20 != null) {
/* 244 */         this._parent._expirationDate = (Date)new DtvDate(t20.getTime());
/*     */       } else {
/*     */         
/* 247 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 250 */       this._parent._faceValueAmount = argResultSet.getBigDecimal(21);
/*     */       
/* 252 */       Timestamp t22 = argResultSet.getTimestamp(22);
/* 253 */       if (t22 != null) {
/* 254 */         this._parent._issueDatetimestamp = (Date)new DtvDate(t22.getTime());
/*     */       } else {
/*     */         
/* 257 */         this._parent._issueDatetimestamp = null;
/*     */       } 
/*     */       
/* 260 */       this._parent._issueTypeCode = argResultSet.getString(23);
/* 261 */       this._parent._unspentBalanceAmount = argResultSet.getBigDecimal(24);
/* 262 */       this._parent._voucherStatusCode = argResultSet.getString(25);
/* 263 */       this._parent._traceNumber = argResultSet.getString(26);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 269 */     super.loadDAO(argDAO);
/* 270 */     argDAO.suppressStateChanges(true);
/* 271 */     VoucherDiscountLineItemDAO dao = (VoucherDiscountLineItemDAO)argDAO;
/* 272 */     dao.setOrganizationId(this._organizationId);
/* 273 */     dao.setRetailLocationId(this._retailLocationId);
/* 274 */     dao.setBusinessDate(this._businessDate);
/* 275 */     dao.setWorkstationId(this._workstationId);
/* 276 */     dao.setTransactionSequence(this._transactionSequence);
/* 277 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 278 */     dao.setCreateDate(this._createDate);
/* 279 */     dao.setCreateUserId(this._createUserId);
/* 280 */     dao.setUpdateDate(this._updateDate);
/* 281 */     dao.setUpdateUserId(this._updateUserId);
/* 282 */     dao.setActivityCode(this._activityCode);
/* 283 */     dao.setAdjudicationCode(this._adjudicationCode);
/* 284 */     dao.setAuthorizationCode(this._authorizationCode);
/* 285 */     dao.setAuthorizationMethodCode(this._authorizationMethodCode);
/* 286 */     dao.setEntryMethodCode(this._entryMethodCode);
/* 287 */     dao.setSerialNumber(this._serialNumber);
/* 288 */     dao.setVoucherTypeCode(this._voucherTypeCode);
/* 289 */     dao.setBankReferenceNumber(this._bankReferenceNumber);
/* 290 */     dao.setEffectiveDate(this._effectiveDate);
/* 291 */     dao.setExpirationDate(this._expirationDate);
/* 292 */     dao.setFaceValueAmount(this._faceValueAmount);
/* 293 */     dao.setIssueDatetimestamp(this._issueDatetimestamp);
/* 294 */     dao.setIssueTypeCode(this._issueTypeCode);
/* 295 */     dao.setUnspentBalanceAmount(this._unspentBalanceAmount);
/* 296 */     dao.setVoucherStatusCode(this._voucherStatusCode);
/* 297 */     dao.setTraceNumber(this._traceNumber);
/* 298 */     argDAO.suppressStateChanges(false);
/* 299 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 304 */     return loadDAO((IDataAccessObject)new VoucherDiscountLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 309 */     VoucherDiscountLineItemDAO dao = (VoucherDiscountLineItemDAO)argDAO;
/* 310 */     super.fill((IDataAccessObject)dao);
/* 311 */     this._organizationId = dao.getOrganizationId();
/* 312 */     this._retailLocationId = dao.getRetailLocationId();
/* 313 */     this._businessDate = dao.getBusinessDate();
/* 314 */     this._workstationId = dao.getWorkstationId();
/* 315 */     this._transactionSequence = dao.getTransactionSequence();
/* 316 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 317 */     this._createDate = dao.getCreateDate();
/* 318 */     this._createUserId = dao.getCreateUserId();
/* 319 */     this._updateDate = dao.getUpdateDate();
/* 320 */     this._updateUserId = dao.getUpdateUserId();
/* 321 */     this._activityCode = dao.getActivityCode();
/* 322 */     this._adjudicationCode = dao.getAdjudicationCode();
/* 323 */     this._authorizationCode = dao.getAuthorizationCode();
/* 324 */     this._authorizationMethodCode = dao.getAuthorizationMethodCode();
/* 325 */     this._entryMethodCode = dao.getEntryMethodCode();
/* 326 */     this._serialNumber = dao.getSerialNumber();
/* 327 */     this._voucherTypeCode = dao.getVoucherTypeCode();
/* 328 */     this._bankReferenceNumber = dao.getBankReferenceNumber();
/* 329 */     this._effectiveDate = dao.getEffectiveDate();
/* 330 */     this._expirationDate = dao.getExpirationDate();
/* 331 */     this._faceValueAmount = dao.getFaceValueAmount();
/* 332 */     this._issueDatetimestamp = dao.getIssueDatetimestamp();
/* 333 */     this._issueTypeCode = dao.getIssueTypeCode();
/* 334 */     this._unspentBalanceAmount = dao.getUnspentBalanceAmount();
/* 335 */     this._voucherStatusCode = dao.getVoucherStatusCode();
/* 336 */     this._traceNumber = dao.getTraceNumber();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 341 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 342 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 343 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 344 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 345 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 346 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 347 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 348 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 352 */     String[] sels = super.getAllSelects();
/* 353 */     String[] result = new String[sels.length + 1];
/* 354 */     result[0] = getSelectImpl();
/* 355 */     System.arraycopy(sels, 0, result, 1, sels.length);
/* 356 */     return result;
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 360 */     IFiller[] fills = super.getAllFillers();
/* 361 */     IFiller[] result = new IFiller[fills.length + 1];
/* 362 */     result[0] = getFillerImpl();
/* 363 */     System.arraycopy(fills, 0, result, 1, fills.length);
/* 364 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\VoucherDiscountLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */