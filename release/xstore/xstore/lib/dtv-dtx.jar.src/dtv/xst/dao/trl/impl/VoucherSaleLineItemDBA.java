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
/*     */ public class VoucherSaleLineItemDBA
/*     */   extends SaleReturnLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 24152124L;
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
/*     */   private String _origLocalDateTime;
/*     */   private String _origTransmissionDateTime;
/*     */   private String _origSTAN;
/*     */   private String _merchantCategoryCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.activity_code, t.adjudication_code, t.auth_code, t.auth_mthd_code, t.entry_mthd_code, t.serial_nbr, t.voucher_typcode, t.reference_nbr, t.effective_date, t.expr_date, t.face_value_amt, t.issue_datetime, t.issue_typcode, t.unspent_balance_amt, t.voucher_status_code, t.trace_number, t.orig_local_date_time, t.orig_transmission_date_time, t.orig_STAN, t.merchant_cat_code  FROM trl_voucher_sale_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  60 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  64 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.activity_code, t.adjudication_code, t.auth_code, t.auth_mthd_code, t.entry_mthd_code, t.serial_nbr, t.voucher_typcode, t.reference_nbr, t.effective_date, t.expr_date, t.face_value_amt, t.issue_datetime, t.issue_typcode, t.unspent_balance_amt, t.voucher_status_code, t.trace_number, t.orig_local_date_time, t.orig_transmission_date_time, t.orig_STAN, t.merchant_cat_code  FROM trl_voucher_sale_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  71 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  74 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_voucher_sale_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, activity_code, adjudication_code, auth_code, auth_mthd_code, entry_mthd_code, serial_nbr, voucher_typcode, reference_nbr, effective_date, expr_date, face_value_amt, issue_datetime, issue_typcode, unspent_balance_amt, voucher_status_code, trace_number, orig_local_date_time, orig_transmission_date_time, orig_STAN, merchant_cat_code ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  78 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  83 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._activityCode, this._adjudicationCode, this._authorizationCode, this._authorizationMethodCode, this._entryMethodCode, this._serialNumber, this._voucherTypeCode, this._bankReferenceNumber, this._effectiveDate, this._expirationDate, this._faceValueAmount, this._issueDatetimestamp, this._issueTypeCode, this._unspentBalanceAmount, this._voucherStatusCode, this._traceNumber, this._origLocalDateTime, this._origTransmissionDateTime, this._origSTAN, this._merchantCategoryCode } };
/*  84 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  87 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 91, 91, 3, 91, 12, 3, 12, 12, 12, 12, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  91 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  94 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_voucher_sale_lineitm SET update_date = ?, update_user_id = ?, activity_code = ?, adjudication_code = ?, auth_code = ?, auth_mthd_code = ?, entry_mthd_code = ?, serial_nbr = ?, voucher_typcode = ?, reference_nbr = ?, effective_date = ?, expr_date = ?, face_value_amt = ?, issue_datetime = ?, issue_typcode = ?, unspent_balance_amt = ?, voucher_status_code = ?, trace_number = ?, orig_local_date_time = ?, orig_transmission_date_time = ?, orig_STAN = ?, merchant_cat_code  = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  98 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 103 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._activityCode, this._adjudicationCode, this._authorizationCode, this._authorizationMethodCode, this._entryMethodCode, this._serialNumber, this._voucherTypeCode, this._bankReferenceNumber, this._effectiveDate, this._expirationDate, this._faceValueAmount, this._issueDatetimestamp, this._issueTypeCode, this._unspentBalanceAmount, this._voucherStatusCode, this._traceNumber, this._origLocalDateTime, this._origTransmissionDateTime, this._origSTAN, this._merchantCategoryCode } };
/* 104 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/* 107 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 91, 91, 3, 91, 12, 3, 12, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/* 110 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 113 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_voucher_sale_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 117 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 124 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 128 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 131 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 135 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 139 */     return "trl_voucher_sale_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 144 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 148 */     return new VoucherSaleLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class VoucherSaleLineItemFiller
/*     */     implements IFiller {
/*     */     private VoucherSaleLineItemDBA _parent;
/*     */     
/*     */     public VoucherSaleLineItemFiller(VoucherSaleLineItemDBA argParent) {
/* 156 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 161 */       long primitiveResult = argResultSet.getLong(1);
/* 162 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 163 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 169 */       primitiveResult = argResultSet.getLong(2);
/* 170 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 171 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 176 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 177 */       if (t3 != null) {
/* 178 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 186 */       long l1 = argResultSet.getLong(4);
/* 187 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 188 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 194 */       l1 = argResultSet.getLong(5);
/* 195 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 196 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 202 */       int i = argResultSet.getInt(6);
/* 203 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 204 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 209 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 210 */       if (t7 != null) {
/* 211 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 214 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 217 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 219 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 220 */       if (t9 != null) {
/* 221 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 224 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 227 */       this._parent._updateUserId = argResultSet.getString(10);
/* 228 */       this._parent._activityCode = argResultSet.getString(11);
/* 229 */       this._parent._adjudicationCode = argResultSet.getString(12);
/* 230 */       this._parent._authorizationCode = argResultSet.getString(13);
/* 231 */       this._parent._authorizationMethodCode = argResultSet.getString(14);
/* 232 */       this._parent._entryMethodCode = argResultSet.getString(15);
/* 233 */       this._parent._serialNumber = argResultSet.getString(16);
/* 234 */       this._parent._voucherTypeCode = argResultSet.getString(17);
/* 235 */       this._parent._bankReferenceNumber = argResultSet.getString(18);
/*     */       
/* 237 */       Timestamp t19 = argResultSet.getTimestamp(19);
/* 238 */       if (t19 != null) {
/* 239 */         this._parent._effectiveDate = (Date)new DtvDate(t19.getTime());
/*     */       } else {
/*     */         
/* 242 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 246 */       Timestamp t20 = argResultSet.getTimestamp(20);
/* 247 */       if (t20 != null) {
/* 248 */         this._parent._expirationDate = (Date)new DtvDate(t20.getTime());
/*     */       } else {
/*     */         
/* 251 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 254 */       this._parent._faceValueAmount = argResultSet.getBigDecimal(21);
/*     */       
/* 256 */       Timestamp t22 = argResultSet.getTimestamp(22);
/* 257 */       if (t22 != null) {
/* 258 */         this._parent._issueDatetimestamp = (Date)new DtvDate(t22.getTime());
/*     */       } else {
/*     */         
/* 261 */         this._parent._issueDatetimestamp = null;
/*     */       } 
/*     */       
/* 264 */       this._parent._issueTypeCode = argResultSet.getString(23);
/* 265 */       this._parent._unspentBalanceAmount = argResultSet.getBigDecimal(24);
/* 266 */       this._parent._voucherStatusCode = argResultSet.getString(25);
/* 267 */       this._parent._traceNumber = argResultSet.getString(26);
/* 268 */       this._parent._origLocalDateTime = argResultSet.getString(27);
/* 269 */       this._parent._origTransmissionDateTime = argResultSet.getString(28);
/* 270 */       this._parent._origSTAN = argResultSet.getString(29);
/* 271 */       this._parent._merchantCategoryCode = argResultSet.getString(30);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 277 */     super.loadDAO(argDAO);
/* 278 */     argDAO.suppressStateChanges(true);
/* 279 */     VoucherSaleLineItemDAO dao = (VoucherSaleLineItemDAO)argDAO;
/* 280 */     dao.setOrganizationId(this._organizationId);
/* 281 */     dao.setRetailLocationId(this._retailLocationId);
/* 282 */     dao.setBusinessDate(this._businessDate);
/* 283 */     dao.setWorkstationId(this._workstationId);
/* 284 */     dao.setTransactionSequence(this._transactionSequence);
/* 285 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 286 */     dao.setCreateDate(this._createDate);
/* 287 */     dao.setCreateUserId(this._createUserId);
/* 288 */     dao.setUpdateDate(this._updateDate);
/* 289 */     dao.setUpdateUserId(this._updateUserId);
/* 290 */     dao.setActivityCode(this._activityCode);
/* 291 */     dao.setAdjudicationCode(this._adjudicationCode);
/* 292 */     dao.setAuthorizationCode(this._authorizationCode);
/* 293 */     dao.setAuthorizationMethodCode(this._authorizationMethodCode);
/* 294 */     dao.setEntryMethodCode(this._entryMethodCode);
/* 295 */     dao.setSerialNumber(this._serialNumber);
/* 296 */     dao.setVoucherTypeCode(this._voucherTypeCode);
/* 297 */     dao.setBankReferenceNumber(this._bankReferenceNumber);
/* 298 */     dao.setEffectiveDate(this._effectiveDate);
/* 299 */     dao.setExpirationDate(this._expirationDate);
/* 300 */     dao.setFaceValueAmount(this._faceValueAmount);
/* 301 */     dao.setIssueDatetimestamp(this._issueDatetimestamp);
/* 302 */     dao.setIssueTypeCode(this._issueTypeCode);
/* 303 */     dao.setUnspentBalanceAmount(this._unspentBalanceAmount);
/* 304 */     dao.setVoucherStatusCode(this._voucherStatusCode);
/* 305 */     dao.setTraceNumber(this._traceNumber);
/* 306 */     dao.setOrigLocalDateTime(this._origLocalDateTime);
/* 307 */     dao.setOrigTransmissionDateTime(this._origTransmissionDateTime);
/* 308 */     dao.setOrigSTAN(this._origSTAN);
/* 309 */     dao.setMerchantCategoryCode(this._merchantCategoryCode);
/* 310 */     argDAO.suppressStateChanges(false);
/* 311 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 316 */     return loadDAO((IDataAccessObject)new VoucherSaleLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 321 */     VoucherSaleLineItemDAO dao = (VoucherSaleLineItemDAO)argDAO;
/* 322 */     super.fill((IDataAccessObject)dao);
/* 323 */     this._organizationId = dao.getOrganizationId();
/* 324 */     this._retailLocationId = dao.getRetailLocationId();
/* 325 */     this._businessDate = dao.getBusinessDate();
/* 326 */     this._workstationId = dao.getWorkstationId();
/* 327 */     this._transactionSequence = dao.getTransactionSequence();
/* 328 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 329 */     this._createDate = dao.getCreateDate();
/* 330 */     this._createUserId = dao.getCreateUserId();
/* 331 */     this._updateDate = dao.getUpdateDate();
/* 332 */     this._updateUserId = dao.getUpdateUserId();
/* 333 */     this._activityCode = dao.getActivityCode();
/* 334 */     this._adjudicationCode = dao.getAdjudicationCode();
/* 335 */     this._authorizationCode = dao.getAuthorizationCode();
/* 336 */     this._authorizationMethodCode = dao.getAuthorizationMethodCode();
/* 337 */     this._entryMethodCode = dao.getEntryMethodCode();
/* 338 */     this._serialNumber = dao.getSerialNumber();
/* 339 */     this._voucherTypeCode = dao.getVoucherTypeCode();
/* 340 */     this._bankReferenceNumber = dao.getBankReferenceNumber();
/* 341 */     this._effectiveDate = dao.getEffectiveDate();
/* 342 */     this._expirationDate = dao.getExpirationDate();
/* 343 */     this._faceValueAmount = dao.getFaceValueAmount();
/* 344 */     this._issueDatetimestamp = dao.getIssueDatetimestamp();
/* 345 */     this._issueTypeCode = dao.getIssueTypeCode();
/* 346 */     this._unspentBalanceAmount = dao.getUnspentBalanceAmount();
/* 347 */     this._voucherStatusCode = dao.getVoucherStatusCode();
/* 348 */     this._traceNumber = dao.getTraceNumber();
/* 349 */     this._origLocalDateTime = dao.getOrigLocalDateTime();
/* 350 */     this._origTransmissionDateTime = dao.getOrigTransmissionDateTime();
/* 351 */     this._origSTAN = dao.getOrigSTAN();
/* 352 */     this._merchantCategoryCode = dao.getMerchantCategoryCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 357 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 358 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 359 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 360 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 361 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 362 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 363 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 364 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 368 */     String[] sels = super.getAllSelects();
/* 369 */     String[] result = new String[sels.length + 1];
/* 370 */     result[0] = getSelectImpl();
/* 371 */     System.arraycopy(sels, 0, result, 1, sels.length);
/* 372 */     return result;
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 376 */     IFiller[] fills = super.getAllFillers();
/* 377 */     IFiller[] result = new IFiller[fills.length + 1];
/* 378 */     result[0] = getFillerImpl();
/* 379 */     System.arraycopy(fills, 0, result, 1, fills.length);
/* 380 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\VoucherSaleLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */