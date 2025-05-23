/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
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
/*     */ 
/*     */ public class RetailTransactionLineItemDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1772623874L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private String _className;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _beginDateTimestamp;
/*     */   private Date _endDateTimestamp;
/*     */   private String _lineItemStatusCode;
/*     */   private String _lineItemTypeCode;
/*     */   private String _notes;
/*     */   private String _voidLineItemReasonCode;
/*     */   private Boolean _void;
/*     */   private Boolean _genericStorage;
/*     */   private Integer _tLogSequence;
/*     */   private String _currencyId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.dtv_class_name, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_date_timestamp, t.end_date_timestamp, t.rtrans_lineitm_statcode, t.rtrans_lineitm_typcode, t.notes, t.void_lineitm_reascode, t.void_flag, t.generic_storage_flag, t.tlog_lineitm_seq, t.currency_id FROM trl_rtrans_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  50 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  54 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.dtv_class_name, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.begin_date_timestamp, t.end_date_timestamp, t.rtrans_lineitm_statcode, t.rtrans_lineitm_typcode, t.notes, t.void_lineitm_reascode, t.void_flag, t.generic_storage_flag, t.tlog_lineitm_seq, t.currency_id FROM trl_rtrans_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  60 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  63 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_rtrans_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, dtv_class_name, create_date, create_user_id, update_date, update_user_id, begin_date_timestamp, end_date_timestamp, rtrans_lineitm_statcode, rtrans_lineitm_typcode, notes, void_lineitm_reascode, void_flag, generic_storage_flag, tlog_lineitm_seq, currency_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  66 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  70 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._className, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._beginDateTimestamp, this._endDateTimestamp, this._lineItemStatusCode, this._lineItemTypeCode, this._notes, this._voidLineItemReasonCode, this._void, this._genericStorage, this._tLogSequence, this._currencyId } };
/*  71 */     return insertParameterObject;
/*     */   }
/*     */   
/*  74 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 12, 91, 12, 91, 12, 91, 91, 12, 12, 12, 12, -7, -7, 4, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  77 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  80 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_rtrans_lineitm SET dtv_class_name = ?, update_date = ?, update_user_id = ?, begin_date_timestamp = ?, end_date_timestamp = ?, rtrans_lineitm_statcode = ?, rtrans_lineitm_typcode = ?, notes = ?, void_lineitm_reascode = ?, void_flag = ?, generic_storage_flag = ?, tlog_lineitm_seq = ?, currency_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  83 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  87 */     Object[][] updateParameterObject = { { this._className, this._updateDate, this._updateUserId, this._beginDateTimestamp, this._endDateTimestamp, this._lineItemStatusCode, this._lineItemTypeCode, this._notes, this._voidLineItemReasonCode, this._void, this._genericStorage, this._tLogSequence, this._currencyId } };
/*  88 */     return updateParameterObject;
/*     */   }
/*     */   
/*  91 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 91, 12, 91, 91, 12, 12, 12, 12, -7, -7, 4, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  93 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  96 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_rtrans_lineitm" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  99 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 105 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 108 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 111 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 114 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 117 */     return "trl_rtrans_lineitm";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 121 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 125 */     return new RetailTransactionLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class RetailTransactionLineItemFiller
/*     */     implements IFiller {
/*     */     private RetailTransactionLineItemDBA _parent;
/*     */     
/*     */     public RetailTransactionLineItemFiller(RetailTransactionLineItemDBA argParent) {
/* 133 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 138 */       long primitiveResult = argResultSet.getLong(1);
/* 139 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 140 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 146 */       primitiveResult = argResultSet.getLong(2);
/* 147 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 148 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 153 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 154 */       if (t3 != null) {
/* 155 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 158 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 163 */       long l1 = argResultSet.getLong(4);
/* 164 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 165 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 171 */       l1 = argResultSet.getLong(5);
/* 172 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 173 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 179 */       int i = argResultSet.getInt(6);
/* 180 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 181 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 185 */       this._parent._className = argResultSet.getString(7);
/*     */       
/* 187 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 188 */       if (t8 != null) {
/* 189 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 192 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 195 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 197 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 198 */       if (t10 != null) {
/* 199 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 205 */       this._parent._updateUserId = argResultSet.getString(11);
/*     */       
/* 207 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 208 */       if (t12 != null) {
/* 209 */         this._parent._beginDateTimestamp = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 212 */         this._parent._beginDateTimestamp = null;
/*     */       } 
/*     */ 
/*     */       
/* 216 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 217 */       if (t13 != null) {
/* 218 */         this._parent._endDateTimestamp = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 221 */         this._parent._endDateTimestamp = null;
/*     */       } 
/*     */       
/* 224 */       this._parent._lineItemStatusCode = argResultSet.getString(14);
/* 225 */       this._parent._lineItemTypeCode = argResultSet.getString(15);
/* 226 */       this._parent._notes = argResultSet.getString(16);
/* 227 */       this._parent._voidLineItemReasonCode = argResultSet.getString(17);
/* 228 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(18));
/* 229 */       this._parent._genericStorage = Boolean.valueOf(argResultSet.getBoolean(19));
/*     */ 
/*     */       
/* 232 */       int j = argResultSet.getInt(20);
/* 233 */       if (j != 0 || argResultSet.getObject(20) != null) {
/* 234 */         this._parent._tLogSequence = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */       
/* 238 */       this._parent._currencyId = argResultSet.getString(21);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 243 */     argDAO.suppressStateChanges(true);
/* 244 */     RetailTransactionLineItemDAO dao = (RetailTransactionLineItemDAO)argDAO;
/* 245 */     dao.setOrganizationId(this._organizationId);
/* 246 */     dao.setRetailLocationId(this._retailLocationId);
/* 247 */     dao.setBusinessDate(this._businessDate);
/* 248 */     dao.setWorkstationId(this._workstationId);
/* 249 */     dao.setTransactionSequence(this._transactionSequence);
/* 250 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 251 */     dao.setClassName(this._className);
/* 252 */     dao.setCreateDate(this._createDate);
/* 253 */     dao.setCreateUserId(this._createUserId);
/* 254 */     dao.setUpdateDate(this._updateDate);
/* 255 */     dao.setUpdateUserId(this._updateUserId);
/* 256 */     dao.setBeginDateTimestamp(this._beginDateTimestamp);
/* 257 */     dao.setEndDateTimestamp(this._endDateTimestamp);
/* 258 */     dao.setLineItemStatusCode(this._lineItemStatusCode);
/* 259 */     dao.setLineItemTypeCode(this._lineItemTypeCode);
/* 260 */     dao.setNotes(this._notes);
/* 261 */     dao.setVoidLineItemReasonCode(this._voidLineItemReasonCode);
/* 262 */     dao.setVoid(this._void);
/* 263 */     dao.setGenericStorage(this._genericStorage);
/* 264 */     dao.setTLogSequence(this._tLogSequence);
/* 265 */     dao.setCurrencyId(this._currencyId);
/* 266 */     argDAO.suppressStateChanges(false);
/* 267 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 271 */     return loadDAO((IDataAccessObject)new RetailTransactionLineItemDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 275 */     RetailTransactionLineItemDAO dao = (RetailTransactionLineItemDAO)argDAO;
/* 276 */     this._organizationId = dao.getOrganizationId();
/* 277 */     this._retailLocationId = dao.getRetailLocationId();
/* 278 */     this._businessDate = dao.getBusinessDate();
/* 279 */     this._workstationId = dao.getWorkstationId();
/* 280 */     this._transactionSequence = dao.getTransactionSequence();
/* 281 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 282 */     this._className = dao.getClassName();
/* 283 */     this._createDate = dao.getCreateDate();
/* 284 */     this._createUserId = dao.getCreateUserId();
/* 285 */     this._updateDate = dao.getUpdateDate();
/* 286 */     this._updateUserId = dao.getUpdateUserId();
/* 287 */     this._beginDateTimestamp = dao.getBeginDateTimestamp();
/* 288 */     this._endDateTimestamp = dao.getEndDateTimestamp();
/* 289 */     this._lineItemStatusCode = dao.getLineItemStatusCode();
/* 290 */     this._lineItemTypeCode = dao.getLineItemTypeCode();
/* 291 */     this._notes = dao.getNotes();
/* 292 */     this._voidLineItemReasonCode = dao.getVoidLineItemReasonCode();
/* 293 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/* 294 */     this._genericStorage = (dao.getGenericStorage() != null) ? dao.getGenericStorage() : Boolean.valueOf(false);
/* 295 */     this._tLogSequence = dao.getTLogSequence();
/* 296 */     this._currencyId = dao.getCurrencyId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 300 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 301 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 302 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 303 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 304 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 305 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 306 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 307 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 311 */     RetailTransactionLineItemId id = new RetailTransactionLineItemId();
/* 312 */     id.setOrganizationId(this._organizationId);
/* 313 */     id.setRetailLocationId(this._retailLocationId);
/* 314 */     id.setBusinessDate(this._businessDate);
/* 315 */     id.setWorkstationId(this._workstationId);
/* 316 */     id.setTransactionSequence(this._transactionSequence);
/* 317 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 318 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {
/* 322 */     RetailTransactionLineItemDBA adapter = (RetailTransactionLineItemDBA)argAdapter;
/* 323 */     this._organizationId = adapter._organizationId;
/* 324 */     this._retailLocationId = adapter._retailLocationId;
/* 325 */     this._businessDate = adapter._businessDate;
/* 326 */     this._workstationId = adapter._workstationId;
/* 327 */     this._transactionSequence = adapter._transactionSequence;
/* 328 */     this._retailTransactionLineItemSequence = adapter._retailTransactionLineItemSequence;
/* 329 */     this._className = adapter._className;
/* 330 */     this._createDate = adapter._createDate;
/* 331 */     this._createUserId = adapter._createUserId;
/* 332 */     this._updateDate = adapter._updateDate;
/* 333 */     this._updateUserId = adapter._updateUserId;
/* 334 */     this._beginDateTimestamp = adapter._beginDateTimestamp;
/* 335 */     this._endDateTimestamp = adapter._endDateTimestamp;
/* 336 */     this._lineItemStatusCode = adapter._lineItemStatusCode;
/* 337 */     this._lineItemTypeCode = adapter._lineItemTypeCode;
/* 338 */     this._notes = adapter._notes;
/* 339 */     this._voidLineItemReasonCode = adapter._voidLineItemReasonCode;
/* 340 */     this._void = adapter._void;
/* 341 */     this._genericStorage = adapter._genericStorage;
/* 342 */     this._tLogSequence = adapter._tLogSequence;
/* 343 */     this._currencyId = adapter._currencyId;
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */