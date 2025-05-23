/*     */ package dtv.xst.dao.ttr.impl;
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
/*     */ public class VoucherTenderLineItemDBA
/*     */   extends TenderLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -715118007L;
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
/*     */   private String _origLocalDateTime;
/*     */   private String _origTransmissionDateTime;
/*     */   private String _origSTAN;
/*     */   private String _merchantCategoryCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.activity_code, t.adjudication_code, t.auth_code, t.auth_mthd_code, t.entry_mthd_code, t.voucher_typcode, t.reference_nbr, t.effective_date, t.expr_date, t.face_value_amt, t.issue_datetime, t.issue_typcode, t.unspent_balance_amt, t.voucher_status_code, t.trace_number, t.orig_local_date_time, t.orig_transmission_date_time, t.orig_STAN, t.merchant_cat_code  FROM ttr_voucher_tndr_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  59 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  63 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.activity_code, t.adjudication_code, t.auth_code, t.auth_mthd_code, t.entry_mthd_code, t.voucher_typcode, t.reference_nbr, t.effective_date, t.expr_date, t.face_value_amt, t.issue_datetime, t.issue_typcode, t.unspent_balance_amt, t.voucher_status_code, t.trace_number, t.orig_local_date_time, t.orig_transmission_date_time, t.orig_STAN, t.merchant_cat_code  FROM ttr_voucher_tndr_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  70 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  73 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ttr_voucher_tndr_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, activity_code, adjudication_code, auth_code, auth_mthd_code, entry_mthd_code, voucher_typcode, reference_nbr, effective_date, expr_date, face_value_amt, issue_datetime, issue_typcode, unspent_balance_amt, voucher_status_code, trace_number, orig_local_date_time, orig_transmission_date_time, orig_STAN, merchant_cat_code ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  77 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  82 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._activityCode, this._adjudicationCode, this._authorizationCode, this._authorizationMethodCode, this._entryMethodCode, this._voucherTypeCode, this._bankReferenceNumber, this._effectiveDate, this._expirationDate, this._faceValueAmount, this._issueDatetimestamp, this._issueTypeCode, this._unspentBalanceAmount, this._voucherStatusCode, this._traceNumber, this._origLocalDateTime, this._origTransmissionDateTime, this._origSTAN, this._merchantCategoryCode } };
/*  83 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  86 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 91, 91, 3, 91, 12, 3, 12, 12, 12, 12, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  90 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  93 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ttr_voucher_tndr_lineitm SET update_date = ?, update_user_id = ?, activity_code = ?, adjudication_code = ?, auth_code = ?, auth_mthd_code = ?, entry_mthd_code = ?, voucher_typcode = ?, reference_nbr = ?, effective_date = ?, expr_date = ?, face_value_amt = ?, issue_datetime = ?, issue_typcode = ?, unspent_balance_amt = ?, voucher_status_code = ?, trace_number = ?, orig_local_date_time = ?, orig_transmission_date_time = ?, orig_STAN = ?, merchant_cat_code  = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  97 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 102 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._activityCode, this._adjudicationCode, this._authorizationCode, this._authorizationMethodCode, this._entryMethodCode, this._voucherTypeCode, this._bankReferenceNumber, this._effectiveDate, this._expirationDate, this._faceValueAmount, this._issueDatetimestamp, this._issueTypeCode, this._unspentBalanceAmount, this._voucherStatusCode, this._traceNumber, this._origLocalDateTime, this._origTransmissionDateTime, this._origSTAN, this._merchantCategoryCode } };
/* 103 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/* 106 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 91, 91, 3, 91, 12, 3, 12, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/* 109 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 112 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ttr_voucher_tndr_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 116 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 123 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 127 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 130 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 134 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 138 */     return "ttr_voucher_tndr_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 143 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 147 */     return new VoucherTenderLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class VoucherTenderLineItemFiller
/*     */     implements IFiller {
/*     */     private VoucherTenderLineItemDBA _parent;
/*     */     
/*     */     public VoucherTenderLineItemFiller(VoucherTenderLineItemDBA argParent) {
/* 155 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 160 */       long primitiveResult = argResultSet.getLong(1);
/* 161 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 162 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 168 */       primitiveResult = argResultSet.getLong(2);
/* 169 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 170 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 175 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 176 */       if (t3 != null) {
/* 177 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 185 */       long l1 = argResultSet.getLong(4);
/* 186 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 187 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 193 */       l1 = argResultSet.getLong(5);
/* 194 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 195 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 201 */       int i = argResultSet.getInt(6);
/* 202 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 203 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 208 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 209 */       if (t7 != null) {
/* 210 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 213 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 216 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 218 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 219 */       if (t9 != null) {
/* 220 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 223 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 226 */       this._parent._updateUserId = argResultSet.getString(10);
/* 227 */       this._parent._activityCode = argResultSet.getString(11);
/* 228 */       this._parent._adjudicationCode = argResultSet.getString(12);
/* 229 */       this._parent._authorizationCode = argResultSet.getString(13);
/* 230 */       this._parent._authorizationMethodCode = argResultSet.getString(14);
/* 231 */       this._parent._entryMethodCode = argResultSet.getString(15);
/* 232 */       this._parent._voucherTypeCode = argResultSet.getString(16);
/* 233 */       this._parent._bankReferenceNumber = argResultSet.getString(17);
/*     */       
/* 235 */       Timestamp t18 = argResultSet.getTimestamp(18);
/* 236 */       if (t18 != null) {
/* 237 */         this._parent._effectiveDate = (Date)new DtvDate(t18.getTime());
/*     */       } else {
/*     */         
/* 240 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 244 */       Timestamp t19 = argResultSet.getTimestamp(19);
/* 245 */       if (t19 != null) {
/* 246 */         this._parent._expirationDate = (Date)new DtvDate(t19.getTime());
/*     */       } else {
/*     */         
/* 249 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 252 */       this._parent._faceValueAmount = argResultSet.getBigDecimal(20);
/*     */       
/* 254 */       Timestamp t21 = argResultSet.getTimestamp(21);
/* 255 */       if (t21 != null) {
/* 256 */         this._parent._issueDatetimestamp = (Date)new DtvDate(t21.getTime());
/*     */       } else {
/*     */         
/* 259 */         this._parent._issueDatetimestamp = null;
/*     */       } 
/*     */       
/* 262 */       this._parent._issueTypeCode = argResultSet.getString(22);
/* 263 */       this._parent._unspentBalanceAmount = argResultSet.getBigDecimal(23);
/* 264 */       this._parent._voucherStatusCode = argResultSet.getString(24);
/* 265 */       this._parent._traceNumber = argResultSet.getString(25);
/* 266 */       this._parent._origLocalDateTime = argResultSet.getString(26);
/* 267 */       this._parent._origTransmissionDateTime = argResultSet.getString(27);
/* 268 */       this._parent._origSTAN = argResultSet.getString(28);
/* 269 */       this._parent._merchantCategoryCode = argResultSet.getString(29);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 275 */     super.loadDAO(argDAO);
/* 276 */     argDAO.suppressStateChanges(true);
/* 277 */     VoucherTenderLineItemDAO dao = (VoucherTenderLineItemDAO)argDAO;
/* 278 */     dao.setOrganizationId(this._organizationId);
/* 279 */     dao.setRetailLocationId(this._retailLocationId);
/* 280 */     dao.setBusinessDate(this._businessDate);
/* 281 */     dao.setWorkstationId(this._workstationId);
/* 282 */     dao.setTransactionSequence(this._transactionSequence);
/* 283 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 284 */     dao.setCreateDate(this._createDate);
/* 285 */     dao.setCreateUserId(this._createUserId);
/* 286 */     dao.setUpdateDate(this._updateDate);
/* 287 */     dao.setUpdateUserId(this._updateUserId);
/* 288 */     dao.setActivityCode(this._activityCode);
/* 289 */     dao.setAdjudicationCode(this._adjudicationCode);
/* 290 */     dao.setAuthorizationCode(this._authorizationCode);
/* 291 */     dao.setAuthorizationMethodCode(this._authorizationMethodCode);
/* 292 */     dao.setEntryMethodCode(this._entryMethodCode);
/* 293 */     dao.setVoucherTypeCode(this._voucherTypeCode);
/* 294 */     dao.setBankReferenceNumber(this._bankReferenceNumber);
/* 295 */     dao.setEffectiveDate(this._effectiveDate);
/* 296 */     dao.setExpirationDate(this._expirationDate);
/* 297 */     dao.setFaceValueAmount(this._faceValueAmount);
/* 298 */     dao.setIssueDatetimestamp(this._issueDatetimestamp);
/* 299 */     dao.setIssueTypeCode(this._issueTypeCode);
/* 300 */     dao.setUnspentBalanceAmount(this._unspentBalanceAmount);
/* 301 */     dao.setVoucherStatusCode(this._voucherStatusCode);
/* 302 */     dao.setTraceNumber(this._traceNumber);
/* 303 */     dao.setOrigLocalDateTime(this._origLocalDateTime);
/* 304 */     dao.setOrigTransmissionDateTime(this._origTransmissionDateTime);
/* 305 */     dao.setOrigSTAN(this._origSTAN);
/* 306 */     dao.setMerchantCategoryCode(this._merchantCategoryCode);
/* 307 */     argDAO.suppressStateChanges(false);
/* 308 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 313 */     return loadDAO((IDataAccessObject)new VoucherTenderLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 318 */     VoucherTenderLineItemDAO dao = (VoucherTenderLineItemDAO)argDAO;
/* 319 */     super.fill((IDataAccessObject)dao);
/* 320 */     this._organizationId = dao.getOrganizationId();
/* 321 */     this._retailLocationId = dao.getRetailLocationId();
/* 322 */     this._businessDate = dao.getBusinessDate();
/* 323 */     this._workstationId = dao.getWorkstationId();
/* 324 */     this._transactionSequence = dao.getTransactionSequence();
/* 325 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 326 */     this._createDate = dao.getCreateDate();
/* 327 */     this._createUserId = dao.getCreateUserId();
/* 328 */     this._updateDate = dao.getUpdateDate();
/* 329 */     this._updateUserId = dao.getUpdateUserId();
/* 330 */     this._activityCode = dao.getActivityCode();
/* 331 */     this._adjudicationCode = dao.getAdjudicationCode();
/* 332 */     this._authorizationCode = dao.getAuthorizationCode();
/* 333 */     this._authorizationMethodCode = dao.getAuthorizationMethodCode();
/* 334 */     this._entryMethodCode = dao.getEntryMethodCode();
/* 335 */     this._voucherTypeCode = dao.getVoucherTypeCode();
/* 336 */     this._bankReferenceNumber = dao.getBankReferenceNumber();
/* 337 */     this._effectiveDate = dao.getEffectiveDate();
/* 338 */     this._expirationDate = dao.getExpirationDate();
/* 339 */     this._faceValueAmount = dao.getFaceValueAmount();
/* 340 */     this._issueDatetimestamp = dao.getIssueDatetimestamp();
/* 341 */     this._issueTypeCode = dao.getIssueTypeCode();
/* 342 */     this._unspentBalanceAmount = dao.getUnspentBalanceAmount();
/* 343 */     this._voucherStatusCode = dao.getVoucherStatusCode();
/* 344 */     this._traceNumber = dao.getTraceNumber();
/* 345 */     this._origLocalDateTime = dao.getOrigLocalDateTime();
/* 346 */     this._origTransmissionDateTime = dao.getOrigTransmissionDateTime();
/* 347 */     this._origSTAN = dao.getOrigSTAN();
/* 348 */     this._merchantCategoryCode = dao.getMerchantCategoryCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 353 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 354 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 355 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 356 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 357 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 358 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 359 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 360 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 364 */     String[] sels = super.getAllSelects();
/* 365 */     String[] result = new String[sels.length + 1];
/* 366 */     result[0] = getSelectImpl();
/* 367 */     System.arraycopy(sels, 0, result, 1, sels.length);
/* 368 */     return result;
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 372 */     IFiller[] fills = super.getAllFillers();
/* 373 */     IFiller[] result = new IFiller[fills.length + 1];
/* 374 */     result[0] = getFillerImpl();
/* 375 */     System.arraycopy(fills, 0, result, 1, fills.length);
/* 376 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\VoucherTenderLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */