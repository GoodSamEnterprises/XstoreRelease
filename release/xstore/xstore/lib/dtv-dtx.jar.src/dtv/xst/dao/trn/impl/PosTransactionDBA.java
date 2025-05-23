/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.PosTransactionId;
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
/*     */ public class PosTransactionDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1475778570L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private String _className;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _beginDateTimestamp;
/*     */   private Date _transactionDate;
/*     */   private Integer _beginTimeInt;
/*     */   private Date _endDateTimestamp;
/*     */   private Boolean _keyedOffline;
/*     */   private Boolean _posted;
/*     */   private Long _sessionId;
/*     */   private BigDecimal _subtotal;
/*     */   private BigDecimal _taxAmount;
/*     */   private BigDecimal _roundedAmount;
/*     */   private BigDecimal _total;
/*     */   private String _transactionStatusCode;
/*     */   private String _transactionTypeCode;
/*     */   private String _transactionCancelledReasonCode;
/*     */   private Boolean _genericStorage;
/*     */   private Long _operatorPartyId;
/*     */   private Boolean _postVoid;
/*     */   private String _cashDrawerId;
/*     */   private String _fiscalNumber;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.dtv_class_name, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_datetime, t.trans_date, t.begin_time_int, t.end_datetime, t.keyed_offline_flag, t.posted_flag, t.session_id, t.subtotal, t.taxtotal, t.roundtotal, t.total, t.trans_statcode, t.trans_typcode, t.trans_cancel_reascode, t.generic_storage_flag, t.operator_party_id, t.post_void_flag, t.cash_drawer_id, t.fiscal_number FROM trn_trans t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  58 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  62 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.dtv_class_name, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_datetime, t.trans_date, t.begin_time_int, t.end_datetime, t.keyed_offline_flag, t.posted_flag, t.session_id, t.subtotal, t.taxtotal, t.roundtotal, t.total, t.trans_statcode, t.trans_typcode, t.trans_cancel_reascode, t.generic_storage_flag, t.operator_party_id, t.post_void_flag, t.cash_drawer_id, t.fiscal_number FROM trn_trans t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  68 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   
/*  71 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trn_trans(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, dtv_class_name, create_date, create_user_id, update_date, update_user_id, begin_datetime, trans_date, begin_time_int, end_datetime, keyed_offline_flag, posted_flag, session_id, subtotal, taxtotal, roundtotal, total, trans_statcode, trans_typcode, trans_cancel_reascode, generic_storage_flag, operator_party_id, post_void_flag, cash_drawer_id, fiscal_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  74 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  78 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._className, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._beginDateTimestamp, this._transactionDate, this._beginTimeInt, this._endDateTimestamp, this._keyedOffline, this._posted, this._sessionId, this._subtotal, this._taxAmount, this._roundedAmount, this._total, this._transactionStatusCode, this._transactionTypeCode, this._transactionCancelledReasonCode, this._genericStorage, this._operatorPartyId, this._postVoid, this._cashDrawerId, this._fiscalNumber } };
/*  79 */     return insertParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 12, 91, 12, 91, 12, 91, 91, 4, 91, -7, -7, -5, 3, 3, 3, 3, 12, 12, 12, -7, -5, -7, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  85 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trn_trans SET dtv_class_name = ?, update_date = ?, update_user_id = ?, begin_datetime = ?, trans_date = ?, begin_time_int = ?, end_datetime = ?, keyed_offline_flag = ?, posted_flag = ?, session_id = ?, subtotal = ?, taxtotal = ?, roundtotal = ?, total = ?, trans_statcode = ?, trans_typcode = ?, trans_cancel_reascode = ?, generic_storage_flag = ?, operator_party_id = ?, post_void_flag = ?, cash_drawer_id = ?, fiscal_number = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  91 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  95 */     Object[][] updateParameterObject = { { this._className, this._updateDate, this._updateUserId, this._beginDateTimestamp, this._transactionDate, this._beginTimeInt, this._endDateTimestamp, this._keyedOffline, this._posted, this._sessionId, this._subtotal, this._taxAmount, this._roundedAmount, this._total, this._transactionStatusCode, this._transactionTypeCode, this._transactionCancelledReasonCode, this._genericStorage, this._operatorPartyId, this._postVoid, this._cashDrawerId, this._fiscalNumber } };
/*  96 */     return updateParameterObject;
/*     */   }
/*     */   
/*  99 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 91, 12, 91, 91, 4, 91, -7, -7, -5, 3, 3, 3, 3, 12, 12, 12, -7, -5, -7, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 101 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 104 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trn_trans" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 107 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 113 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 116 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence };
/*     */   }
/*     */   
/* 119 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 122 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 125 */     return "trn_trans";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 129 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 133 */     return new PosTransactionFiller(this);
/*     */   }
/*     */   
/*     */   private static class PosTransactionFiller
/*     */     implements IFiller {
/*     */     private PosTransactionDBA _parent;
/*     */     
/*     */     public PosTransactionFiller(PosTransactionDBA argParent) {
/* 141 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 146 */       long primitiveResult = argResultSet.getLong(1);
/* 147 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 148 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 154 */       primitiveResult = argResultSet.getLong(2);
/* 155 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 156 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 161 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 162 */       if (t3 != null) {
/* 163 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 166 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 171 */       long l1 = argResultSet.getLong(4);
/* 172 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 173 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 179 */       l1 = argResultSet.getLong(5);
/* 180 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 181 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 185 */       this._parent._className = argResultSet.getString(6);
/*     */       
/* 187 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 188 */       if (t7 != null) {
/* 189 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 192 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 195 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 197 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 198 */       if (t9 != null) {
/* 199 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 205 */       this._parent._updateUserId = argResultSet.getString(10);
/*     */       
/* 207 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 208 */       if (t11 != null) {
/* 209 */         this._parent._beginDateTimestamp = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 212 */         this._parent._beginDateTimestamp = null;
/*     */       } 
/*     */ 
/*     */       
/* 216 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 217 */       if (t12 != null) {
/* 218 */         this._parent._transactionDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 221 */         this._parent._transactionDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 226 */       int i = argResultSet.getInt(13);
/* 227 */       if (i != 0 || argResultSet.getObject(13) != null) {
/* 228 */         this._parent._beginTimeInt = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 233 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 234 */       if (t14 != null) {
/* 235 */         this._parent._endDateTimestamp = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 238 */         this._parent._endDateTimestamp = null;
/*     */       } 
/*     */       
/* 241 */       this._parent._keyedOffline = Boolean.valueOf(argResultSet.getBoolean(15));
/* 242 */       this._parent._posted = Boolean.valueOf(argResultSet.getBoolean(16));
/*     */ 
/*     */       
/* 245 */       long l2 = argResultSet.getLong(17);
/* 246 */       if (l2 != 0L || argResultSet.getObject(17) != null) {
/* 247 */         this._parent._sessionId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 251 */       this._parent._subtotal = argResultSet.getBigDecimal(18);
/* 252 */       this._parent._taxAmount = argResultSet.getBigDecimal(19);
/* 253 */       this._parent._roundedAmount = argResultSet.getBigDecimal(20);
/* 254 */       this._parent._total = argResultSet.getBigDecimal(21);
/* 255 */       this._parent._transactionStatusCode = argResultSet.getString(22);
/* 256 */       this._parent._transactionTypeCode = argResultSet.getString(23);
/* 257 */       this._parent._transactionCancelledReasonCode = argResultSet.getString(24);
/* 258 */       this._parent._genericStorage = Boolean.valueOf(argResultSet.getBoolean(25));
/*     */ 
/*     */       
/* 261 */       l2 = argResultSet.getLong(26);
/* 262 */       if (l2 != 0L || argResultSet.getObject(26) != null) {
/* 263 */         this._parent._operatorPartyId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 267 */       this._parent._postVoid = Boolean.valueOf(argResultSet.getBoolean(27));
/* 268 */       this._parent._cashDrawerId = argResultSet.getString(28);
/* 269 */       this._parent._fiscalNumber = argResultSet.getString(29);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 274 */     argDAO.suppressStateChanges(true);
/* 275 */     PosTransactionDAO dao = (PosTransactionDAO)argDAO;
/* 276 */     dao.setOrganizationId(this._organizationId);
/* 277 */     dao.setRetailLocationId(this._retailLocationId);
/* 278 */     dao.setBusinessDate(this._businessDate);
/* 279 */     dao.setWorkstationId(this._workstationId);
/* 280 */     dao.setTransactionSequence(this._transactionSequence);
/* 281 */     dao.setClassName(this._className);
/* 282 */     dao.setCreateDate(this._createDate);
/* 283 */     dao.setCreateUserId(this._createUserId);
/* 284 */     dao.setUpdateDate(this._updateDate);
/* 285 */     dao.setUpdateUserId(this._updateUserId);
/* 286 */     dao.setBeginDateTimestamp(this._beginDateTimestamp);
/* 287 */     dao.setTransactionDate(this._transactionDate);
/* 288 */     dao.setBeginTimeInt(this._beginTimeInt);
/* 289 */     dao.setEndDateTimestamp(this._endDateTimestamp);
/* 290 */     dao.setKeyedOffline(this._keyedOffline);
/* 291 */     dao.setPosted(this._posted);
/* 292 */     dao.setSessionId(this._sessionId);
/* 293 */     dao.setSubtotal(this._subtotal);
/* 294 */     dao.setTaxAmount(this._taxAmount);
/* 295 */     dao.setRoundedAmount(this._roundedAmount);
/* 296 */     dao.setTotal(this._total);
/* 297 */     dao.setTransactionStatusCode(this._transactionStatusCode);
/* 298 */     dao.setTransactionTypeCode(this._transactionTypeCode);
/* 299 */     dao.setTransactionCancelledReasonCode(this._transactionCancelledReasonCode);
/* 300 */     dao.setGenericStorage(this._genericStorage);
/* 301 */     dao.setOperatorPartyId(this._operatorPartyId);
/* 302 */     dao.setPostVoid(this._postVoid);
/* 303 */     dao.setCashDrawerId(this._cashDrawerId);
/* 304 */     dao.setFiscalNumber(this._fiscalNumber);
/* 305 */     argDAO.suppressStateChanges(false);
/* 306 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 310 */     return loadDAO((IDataAccessObject)new PosTransactionDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 314 */     PosTransactionDAO dao = (PosTransactionDAO)argDAO;
/* 315 */     this._organizationId = dao.getOrganizationId();
/* 316 */     this._retailLocationId = dao.getRetailLocationId();
/* 317 */     this._businessDate = dao.getBusinessDate();
/* 318 */     this._workstationId = dao.getWorkstationId();
/* 319 */     this._transactionSequence = dao.getTransactionSequence();
/* 320 */     this._className = dao.getClassName();
/* 321 */     this._createDate = dao.getCreateDate();
/* 322 */     this._createUserId = dao.getCreateUserId();
/* 323 */     this._updateDate = dao.getUpdateDate();
/* 324 */     this._updateUserId = dao.getUpdateUserId();
/* 325 */     this._beginDateTimestamp = dao.getBeginDateTimestamp();
/* 326 */     this._transactionDate = dao.getTransactionDate();
/* 327 */     this._beginTimeInt = dao.getBeginTimeInt();
/* 328 */     this._endDateTimestamp = dao.getEndDateTimestamp();
/* 329 */     this._keyedOffline = (dao.getKeyedOffline() != null) ? dao.getKeyedOffline() : Boolean.valueOf(false);
/* 330 */     this._posted = (dao.getPosted() != null) ? dao.getPosted() : Boolean.valueOf(false);
/* 331 */     this._sessionId = dao.getSessionId();
/* 332 */     this._subtotal = dao.getSubtotal();
/* 333 */     this._taxAmount = dao.getTaxAmount();
/* 334 */     this._roundedAmount = dao.getRoundedAmount();
/* 335 */     this._total = dao.getTotal();
/* 336 */     this._transactionStatusCode = dao.getTransactionStatusCode();
/* 337 */     this._transactionTypeCode = dao.getTransactionTypeCode();
/* 338 */     this._transactionCancelledReasonCode = dao.getTransactionCancelledReasonCode();
/* 339 */     this._genericStorage = (dao.getGenericStorage() != null) ? dao.getGenericStorage() : Boolean.valueOf(false);
/* 340 */     this._operatorPartyId = dao.getOperatorPartyId();
/* 341 */     this._postVoid = (dao.getPostVoid() != null) ? dao.getPostVoid() : Boolean.valueOf(false);
/* 342 */     this._cashDrawerId = dao.getCashDrawerId();
/* 343 */     this._fiscalNumber = dao.getFiscalNumber();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 347 */     PosTransactionId id = (PosTransactionId)argId;
/* 348 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 349 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 350 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 351 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 352 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 353 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 357 */     PosTransactionId id = new PosTransactionId();
/* 358 */     id.setOrganizationId(this._organizationId);
/* 359 */     id.setRetailLocationId(this._retailLocationId);
/* 360 */     id.setBusinessDate(this._businessDate);
/* 361 */     id.setWorkstationId(this._workstationId);
/* 362 */     id.setTransactionSequence(this._transactionSequence);
/* 363 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {
/* 367 */     PosTransactionDBA adapter = (PosTransactionDBA)argAdapter;
/* 368 */     this._organizationId = adapter._organizationId;
/* 369 */     this._retailLocationId = adapter._retailLocationId;
/* 370 */     this._businessDate = adapter._businessDate;
/* 371 */     this._workstationId = adapter._workstationId;
/* 372 */     this._transactionSequence = adapter._transactionSequence;
/* 373 */     this._className = adapter._className;
/* 374 */     this._createDate = adapter._createDate;
/* 375 */     this._createUserId = adapter._createUserId;
/* 376 */     this._updateDate = adapter._updateDate;
/* 377 */     this._updateUserId = adapter._updateUserId;
/* 378 */     this._beginDateTimestamp = adapter._beginDateTimestamp;
/* 379 */     this._transactionDate = adapter._transactionDate;
/* 380 */     this._beginTimeInt = adapter._beginTimeInt;
/* 381 */     this._endDateTimestamp = adapter._endDateTimestamp;
/* 382 */     this._keyedOffline = adapter._keyedOffline;
/* 383 */     this._posted = adapter._posted;
/* 384 */     this._sessionId = adapter._sessionId;
/* 385 */     this._subtotal = adapter._subtotal;
/* 386 */     this._taxAmount = adapter._taxAmount;
/* 387 */     this._roundedAmount = adapter._roundedAmount;
/* 388 */     this._total = adapter._total;
/* 389 */     this._transactionStatusCode = adapter._transactionStatusCode;
/* 390 */     this._transactionTypeCode = adapter._transactionTypeCode;
/* 391 */     this._transactionCancelledReasonCode = adapter._transactionCancelledReasonCode;
/* 392 */     this._genericStorage = adapter._genericStorage;
/* 393 */     this._operatorPartyId = adapter._operatorPartyId;
/* 394 */     this._postVoid = adapter._postVoid;
/* 395 */     this._cashDrawerId = adapter._cashDrawerId;
/* 396 */     this._fiscalNumber = adapter._fiscalNumber;
/*     */   }
/*     */   
/*     */   public boolean isExtensible() {
/* 400 */     return true;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 404 */     return this._className;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PosTransactionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */