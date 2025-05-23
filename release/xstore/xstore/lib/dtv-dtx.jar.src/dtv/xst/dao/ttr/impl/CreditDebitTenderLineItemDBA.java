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
/*     */ public class CreditDebitTenderLineItemDBA
/*     */   extends TenderLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1871830094L;
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
/*     */   private String _adjudicationCode;
/*     */   private String _authorizationMethodCode;
/*     */   private String _authorizationCode;
/*     */   private String _bankReferenceNumber;
/*     */   private String _customerName;
/*     */   private String _entryMethodCode;
/*     */   private String _ps2000;
/*     */   private String _mediaIssuerId;
/*     */   private String _personalIdReferenceNumber;
/*     */   private String _personalIdRequiredTypeCode;
/*     */   private String _expirationDateString;
/*     */   private BigDecimal _cashbackAmount;
/*     */   private String _cardLevelIndicator;
/*     */   private String _accountNumberHash;
/*     */   private String _authorizationToken;
/*     */   private String _transactionReferenceData;
/*     */   private String _traceNumber;
/*     */   private BigDecimal _taxAmount;
/*     */   private BigDecimal _discountAmount;
/*     */   private BigDecimal _freightAmount;
/*     */   private BigDecimal _dutyAmount;
/*     */   private String _origLocalDateTime;
/*     */   private String _origTransmissionDateTime;
/*     */   private String _origSTAN;
/*     */   private String _transactionIdentifier;
/*     */   private String _ccvErrorCode;
/*     */   private String _posEntryModeChange;
/*     */   private String _processingCode;
/*     */   private String _posEntryMode;
/*     */   private String _posAdditionalData;
/*     */   private String _networkResultIndicator;
/*     */   private String _merchantCategoryCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.acct_nbr, t.adjudication_code, t.auth_mthd_code, t.auth_nbr, t.bank_reference_number, t.customer_name, t.entry_mthd_code, t.ps2000, t.mediaissuer_id, t.personal_id_ref_nbr, t.personal_id_req_typcode, t.expr_date, t.cashback_amt, t.card_level_indicator, t.acct_nbr_hash, t.authorization_token, t.transaction_reference_data, t.trace_number, t.tax_amt, t.discount_amt, t.freight_amt, t.duty_amt, t.orig_local_date_time, t.orig_transmission_date_time, t.orig_STAN, t.transaction_identifier, t.CCV_error_code, t.POS_entry_mode_change, t.processing_code, t.POS_entry_mode, t.POS_addl_data , t.network_result_indicator , t.merchant_cat_code  FROM ttr_credit_debit_tndr_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  73 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  77 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.acct_nbr, t.adjudication_code, t.auth_mthd_code, t.auth_nbr, t.bank_reference_number, t.customer_name, t.entry_mthd_code, t.ps2000, t.mediaissuer_id, t.personal_id_ref_nbr, t.personal_id_req_typcode, t.expr_date, t.cashback_amt, t.card_level_indicator, t.acct_nbr_hash, t.authorization_token, t.transaction_reference_data, t.trace_number, t.tax_amt, t.discount_amt, t.freight_amt, t.duty_amt, t.orig_local_date_time, t.orig_transmission_date_time, t.orig_STAN, t.transaction_identifier, t.CCV_error_code, t.POS_entry_mode_change, t.processing_code, t.POS_entry_mode, t.POS_addl_data , t.network_result_indicator , t.merchant_cat_code  FROM ttr_credit_debit_tndr_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  84 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  87 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ttr_credit_debit_tndr_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, acct_nbr, adjudication_code, auth_mthd_code, auth_nbr, bank_reference_number, customer_name, entry_mthd_code, ps2000, mediaissuer_id, personal_id_ref_nbr, personal_id_req_typcode, expr_date, cashback_amt, card_level_indicator, acct_nbr_hash, authorization_token, transaction_reference_data, trace_number, tax_amt, discount_amt, freight_amt, duty_amt, orig_local_date_time, orig_transmission_date_time, orig_STAN, transaction_identifier, CCV_error_code, POS_entry_mode_change, processing_code, POS_entry_mode, POS_addl_data , network_result_indicator , merchant_cat_code ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  91 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  96 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._accountNumber, this._adjudicationCode, this._authorizationMethodCode, this._authorizationCode, this._bankReferenceNumber, this._customerName, this._entryMethodCode, this._ps2000, this._mediaIssuerId, this._personalIdReferenceNumber, this._personalIdRequiredTypeCode, this._expirationDateString, this._cashbackAmount, this._cardLevelIndicator, this._accountNumberHash, this._authorizationToken, this._transactionReferenceData, this._traceNumber, this._taxAmount, this._discountAmount, this._freightAmount, this._dutyAmount, this._origLocalDateTime, this._origTransmissionDateTime, this._origSTAN, this._transactionIdentifier, this._ccvErrorCode, this._posEntryModeChange, this._processingCode, this._posEntryMode, this._posAdditionalData, this._networkResultIndicator, this._merchantCategoryCode } };
/*  97 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/* 100 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 3, 12, 12, 12, 12, 12, 3, 3, 3, 3, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/* 104 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/* 107 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ttr_credit_debit_tndr_lineitm SET update_date = ?, update_user_id = ?, acct_nbr = ?, adjudication_code = ?, auth_mthd_code = ?, auth_nbr = ?, bank_reference_number = ?, customer_name = ?, entry_mthd_code = ?, ps2000 = ?, mediaissuer_id = ?, personal_id_ref_nbr = ?, personal_id_req_typcode = ?, expr_date = ?, cashback_amt = ?, card_level_indicator = ?, acct_nbr_hash = ?, authorization_token = ?, transaction_reference_data = ?, trace_number = ?, tax_amt = ?, discount_amt = ?, freight_amt = ?, duty_amt = ?, orig_local_date_time = ?, orig_transmission_date_time = ?, orig_STAN = ?, transaction_identifier = ?, CCV_error_code = ?, POS_entry_mode_change = ?, processing_code = ?, POS_entry_mode = ?, POS_addl_data  = ?, network_result_indicator  = ?, merchant_cat_code  = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/* 111 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 116 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._accountNumber, this._adjudicationCode, this._authorizationMethodCode, this._authorizationCode, this._bankReferenceNumber, this._customerName, this._entryMethodCode, this._ps2000, this._mediaIssuerId, this._personalIdReferenceNumber, this._personalIdRequiredTypeCode, this._expirationDateString, this._cashbackAmount, this._cardLevelIndicator, this._accountNumberHash, this._authorizationToken, this._transactionReferenceData, this._traceNumber, this._taxAmount, this._discountAmount, this._freightAmount, this._dutyAmount, this._origLocalDateTime, this._origTransmissionDateTime, this._origSTAN, this._transactionIdentifier, this._ccvErrorCode, this._posEntryModeChange, this._processingCode, this._posEntryMode, this._posAdditionalData, this._networkResultIndicator, this._merchantCategoryCode } };
/* 117 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/* 120 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 3, 12, 12, 12, 12, 12, 3, 3, 3, 3, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/* 123 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 126 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ttr_credit_debit_tndr_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 130 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 137 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 141 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 144 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 148 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 152 */     return "ttr_credit_debit_tndr_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 157 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 161 */     return new CreditDebitTenderLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class CreditDebitTenderLineItemFiller
/*     */     implements IFiller {
/*     */     private CreditDebitTenderLineItemDBA _parent;
/*     */     
/*     */     public CreditDebitTenderLineItemFiller(CreditDebitTenderLineItemDBA argParent) {
/* 169 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 174 */       long primitiveResult = argResultSet.getLong(1);
/* 175 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 176 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 182 */       primitiveResult = argResultSet.getLong(2);
/* 183 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 184 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 189 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 190 */       if (t3 != null) {
/* 191 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 194 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 199 */       long l1 = argResultSet.getLong(4);
/* 200 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 201 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 207 */       l1 = argResultSet.getLong(5);
/* 208 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 209 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 215 */       int i = argResultSet.getInt(6);
/* 216 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 217 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 222 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 223 */       if (t7 != null) {
/* 224 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 227 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 230 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 232 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 233 */       if (t9 != null) {
/* 234 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 237 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 240 */       this._parent._updateUserId = argResultSet.getString(10);
/* 241 */       this._parent._accountNumber = argResultSet.getString(11);
/* 242 */       this._parent._adjudicationCode = argResultSet.getString(12);
/* 243 */       this._parent._authorizationMethodCode = argResultSet.getString(13);
/* 244 */       this._parent._authorizationCode = argResultSet.getString(14);
/* 245 */       this._parent._bankReferenceNumber = argResultSet.getString(15);
/* 246 */       this._parent._customerName = argResultSet.getString(16);
/* 247 */       this._parent._entryMethodCode = argResultSet.getString(17);
/* 248 */       this._parent._ps2000 = argResultSet.getString(18);
/* 249 */       this._parent._mediaIssuerId = argResultSet.getString(19);
/* 250 */       this._parent._personalIdReferenceNumber = argResultSet.getString(20);
/* 251 */       this._parent._personalIdRequiredTypeCode = argResultSet.getString(21);
/* 252 */       this._parent._expirationDateString = argResultSet.getString(22);
/* 253 */       this._parent._cashbackAmount = argResultSet.getBigDecimal(23);
/* 254 */       this._parent._cardLevelIndicator = argResultSet.getString(24);
/* 255 */       this._parent._accountNumberHash = argResultSet.getString(25);
/* 256 */       this._parent._authorizationToken = argResultSet.getString(26);
/* 257 */       this._parent._transactionReferenceData = argResultSet.getString(27);
/* 258 */       this._parent._traceNumber = argResultSet.getString(28);
/* 259 */       this._parent._taxAmount = argResultSet.getBigDecimal(29);
/* 260 */       this._parent._discountAmount = argResultSet.getBigDecimal(30);
/* 261 */       this._parent._freightAmount = argResultSet.getBigDecimal(31);
/* 262 */       this._parent._dutyAmount = argResultSet.getBigDecimal(32);
/* 263 */       this._parent._origLocalDateTime = argResultSet.getString(33);
/* 264 */       this._parent._origTransmissionDateTime = argResultSet.getString(34);
/* 265 */       this._parent._origSTAN = argResultSet.getString(35);
/* 266 */       this._parent._transactionIdentifier = argResultSet.getString(36);
/* 267 */       this._parent._ccvErrorCode = argResultSet.getString(37);
/* 268 */       this._parent._posEntryModeChange = argResultSet.getString(38);
/* 269 */       this._parent._processingCode = argResultSet.getString(39);
/* 270 */       this._parent._posEntryMode = argResultSet.getString(40);
/* 271 */       this._parent._posAdditionalData = argResultSet.getString(41);
/* 272 */       this._parent._networkResultIndicator = argResultSet.getString(42);
/* 273 */       this._parent._merchantCategoryCode = argResultSet.getString(43);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 279 */     super.loadDAO(argDAO);
/* 280 */     argDAO.suppressStateChanges(true);
/* 281 */     CreditDebitTenderLineItemDAO dao = (CreditDebitTenderLineItemDAO)argDAO;
/* 282 */     dao.setOrganizationId(this._organizationId);
/* 283 */     dao.setRetailLocationId(this._retailLocationId);
/* 284 */     dao.setBusinessDate(this._businessDate);
/* 285 */     dao.setWorkstationId(this._workstationId);
/* 286 */     dao.setTransactionSequence(this._transactionSequence);
/* 287 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 288 */     dao.setCreateDate(this._createDate);
/* 289 */     dao.setCreateUserId(this._createUserId);
/* 290 */     dao.setUpdateDate(this._updateDate);
/* 291 */     dao.setUpdateUserId(this._updateUserId);
/* 292 */     dao.setAccountNumber(this._accountNumber);
/* 293 */     dao.setAdjudicationCode(this._adjudicationCode);
/* 294 */     dao.setAuthorizationMethodCode(this._authorizationMethodCode);
/* 295 */     dao.setAuthorizationCode(this._authorizationCode);
/* 296 */     dao.setBankReferenceNumber(this._bankReferenceNumber);
/* 297 */     dao.setCustomerName(this._customerName);
/* 298 */     dao.setEntryMethodCode(this._entryMethodCode);
/* 299 */     dao.setPs2000(this._ps2000);
/* 300 */     dao.setMediaIssuerId(this._mediaIssuerId);
/* 301 */     dao.setPersonalIdReferenceNumber(this._personalIdReferenceNumber);
/* 302 */     dao.setPersonalIdRequiredTypeCode(this._personalIdRequiredTypeCode);
/* 303 */     dao.setExpirationDateString(this._expirationDateString);
/* 304 */     dao.setCashbackAmount(this._cashbackAmount);
/* 305 */     dao.setCardLevelIndicator(this._cardLevelIndicator);
/* 306 */     dao.setAccountNumberHash(this._accountNumberHash);
/* 307 */     dao.setAuthorizationToken(this._authorizationToken);
/* 308 */     dao.setTransactionReferenceData(this._transactionReferenceData);
/* 309 */     dao.setTraceNumber(this._traceNumber);
/* 310 */     dao.setTaxAmount(this._taxAmount);
/* 311 */     dao.setDiscountAmount(this._discountAmount);
/* 312 */     dao.setFreightAmount(this._freightAmount);
/* 313 */     dao.setDutyAmount(this._dutyAmount);
/* 314 */     dao.setOrigLocalDateTime(this._origLocalDateTime);
/* 315 */     dao.setOrigTransmissionDateTime(this._origTransmissionDateTime);
/* 316 */     dao.setOrigSTAN(this._origSTAN);
/* 317 */     dao.setTransactionIdentifier(this._transactionIdentifier);
/* 318 */     dao.setCcvErrorCode(this._ccvErrorCode);
/* 319 */     dao.setPosEntryModeChange(this._posEntryModeChange);
/* 320 */     dao.setProcessingCode(this._processingCode);
/* 321 */     dao.setPosEntryMode(this._posEntryMode);
/* 322 */     dao.setPosAdditionalData(this._posAdditionalData);
/* 323 */     dao.setNetworkResultIndicator(this._networkResultIndicator);
/* 324 */     dao.setMerchantCategoryCode(this._merchantCategoryCode);
/* 325 */     argDAO.suppressStateChanges(false);
/* 326 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 331 */     return loadDAO((IDataAccessObject)new CreditDebitTenderLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 336 */     CreditDebitTenderLineItemDAO dao = (CreditDebitTenderLineItemDAO)argDAO;
/* 337 */     super.fill((IDataAccessObject)dao);
/* 338 */     this._organizationId = dao.getOrganizationId();
/* 339 */     this._retailLocationId = dao.getRetailLocationId();
/* 340 */     this._businessDate = dao.getBusinessDate();
/* 341 */     this._workstationId = dao.getWorkstationId();
/* 342 */     this._transactionSequence = dao.getTransactionSequence();
/* 343 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 344 */     this._createDate = dao.getCreateDate();
/* 345 */     this._createUserId = dao.getCreateUserId();
/* 346 */     this._updateDate = dao.getUpdateDate();
/* 347 */     this._updateUserId = dao.getUpdateUserId();
/* 348 */     this._accountNumber = dao.getAccountNumber();
/* 349 */     this._adjudicationCode = dao.getAdjudicationCode();
/* 350 */     this._authorizationMethodCode = dao.getAuthorizationMethodCode();
/* 351 */     this._authorizationCode = dao.getAuthorizationCode();
/* 352 */     this._bankReferenceNumber = dao.getBankReferenceNumber();
/* 353 */     this._customerName = dao.getCustomerName();
/* 354 */     this._entryMethodCode = dao.getEntryMethodCode();
/* 355 */     this._ps2000 = dao.getPs2000();
/* 356 */     this._mediaIssuerId = dao.getMediaIssuerId();
/* 357 */     this._personalIdReferenceNumber = dao.getPersonalIdReferenceNumber();
/* 358 */     this._personalIdRequiredTypeCode = dao.getPersonalIdRequiredTypeCode();
/* 359 */     this._expirationDateString = dao.getExpirationDateString();
/* 360 */     this._cashbackAmount = dao.getCashbackAmount();
/* 361 */     this._cardLevelIndicator = dao.getCardLevelIndicator();
/* 362 */     this._accountNumberHash = dao.getAccountNumberHash();
/* 363 */     this._authorizationToken = dao.getAuthorizationToken();
/* 364 */     this._transactionReferenceData = dao.getTransactionReferenceData();
/* 365 */     this._traceNumber = dao.getTraceNumber();
/* 366 */     this._taxAmount = dao.getTaxAmount();
/* 367 */     this._discountAmount = dao.getDiscountAmount();
/* 368 */     this._freightAmount = dao.getFreightAmount();
/* 369 */     this._dutyAmount = dao.getDutyAmount();
/* 370 */     this._origLocalDateTime = dao.getOrigLocalDateTime();
/* 371 */     this._origTransmissionDateTime = dao.getOrigTransmissionDateTime();
/* 372 */     this._origSTAN = dao.getOrigSTAN();
/* 373 */     this._transactionIdentifier = dao.getTransactionIdentifier();
/* 374 */     this._ccvErrorCode = dao.getCcvErrorCode();
/* 375 */     this._posEntryModeChange = dao.getPosEntryModeChange();
/* 376 */     this._processingCode = dao.getProcessingCode();
/* 377 */     this._posEntryMode = dao.getPosEntryMode();
/* 378 */     this._posAdditionalData = dao.getPosAdditionalData();
/* 379 */     this._networkResultIndicator = dao.getNetworkResultIndicator();
/* 380 */     this._merchantCategoryCode = dao.getMerchantCategoryCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 385 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 386 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 387 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 388 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 389 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 390 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 391 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 392 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 396 */     String[] sels = super.getAllSelects();
/* 397 */     String[] result = new String[sels.length + 1];
/* 398 */     result[0] = getSelectImpl();
/* 399 */     System.arraycopy(sels, 0, result, 1, sels.length);
/* 400 */     return result;
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 404 */     IFiller[] fills = super.getAllFillers();
/* 405 */     IFiller[] result = new IFiller[fills.length + 1];
/* 406 */     result[0] = getFillerImpl();
/* 407 */     System.arraycopy(fills, 0, result, 1, fills.length);
/* 408 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\CreditDebitTenderLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */