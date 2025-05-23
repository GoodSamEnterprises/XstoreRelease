/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ttr.TenderAuthLogId;
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
/*     */ public class TenderAuthLogDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1325511960L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Integer _attemptSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _responseCode;
/*     */   private String _approvalCode;
/*     */   private String _authType;
/*     */   private String _customerName;
/*     */   private String _referenceNumber;
/*     */   private String _errorCode;
/*     */   private String _errorText;
/*     */   private Date _startTimestamp;
/*     */   private Date _endTimestamp;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.rtrans_lineitm_seq, t.attempt_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.response_code, t.approval_code, t.auth_type, t.customer_name, t.reference_nbr, t.error_code, t.error_text, t.start_timestamp, t.end_timestamp FROM ttr_tndr_auth_log t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND attempt_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  49 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  53 */     return "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.rtrans_lineitm_seq, t.attempt_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.response_code, t.approval_code, t.auth_type, t.customer_name, t.reference_nbr, t.error_code, t.error_text, t.start_timestamp, t.end_timestamp FROM ttr_tndr_auth_log t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  59 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND attempt_seq = ?  ";
/*     */   }
/*     */   
/*  62 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ttr_tndr_auth_log(organization_id, rtl_loc_id, wkstn_id, business_date, trans_seq, rtrans_lineitm_seq, attempt_seq, create_date, create_user_id, update_date, update_user_id, response_code, approval_code, auth_type, customer_name, reference_nbr, error_code, error_text, start_timestamp, end_timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  65 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  69 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._retailTransactionLineItemSequence, this._attemptSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._responseCode, this._approvalCode, this._authType, this._customerName, this._referenceNumber, this._errorCode, this._errorText, this._startTimestamp, this._endTimestamp } };
/*  70 */     return insertParameterObject;
/*     */   }
/*     */   
/*  73 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, -5, 4, 4, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 91, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  76 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  79 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ttr_tndr_auth_log SET update_date = ?, update_user_id = ?, response_code = ?, approval_code = ?, auth_type = ?, customer_name = ?, reference_nbr = ?, error_code = ?, error_text = ?, start_timestamp = ?, end_timestamp = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  82 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  86 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._responseCode, this._approvalCode, this._authType, this._customerName, this._referenceNumber, this._errorCode, this._errorText, this._startTimestamp, this._endTimestamp } };
/*  87 */     return updateParameterObject;
/*     */   }
/*     */   
/*  90 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 91, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  92 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  95 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ttr_tndr_auth_log" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND attempt_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  98 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 104 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND attempt_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 107 */     return new Object[] { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._retailTransactionLineItemSequence, this._attemptSequence };
/*     */   }
/*     */   
/* 110 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 91, -5, 4, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 113 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 116 */     return "ttr_tndr_auth_log";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 120 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 124 */     return new TenderAuthLogFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderAuthLogFiller
/*     */     implements IFiller {
/*     */     private TenderAuthLogDBA _parent;
/*     */     
/*     */     public TenderAuthLogFiller(TenderAuthLogDBA argParent) {
/* 132 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 137 */       long primitiveResult = argResultSet.getLong(1);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 139 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 145 */       primitiveResult = argResultSet.getLong(2);
/* 146 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 147 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 153 */       primitiveResult = argResultSet.getLong(3);
/* 154 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 155 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 160 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 161 */       if (t4 != null) {
/* 162 */         this._parent._businessDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 165 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 170 */       long l1 = argResultSet.getLong(5);
/* 171 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 172 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 178 */       int i = argResultSet.getInt(6);
/* 179 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 180 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 186 */       i = argResultSet.getInt(7);
/* 187 */       if (i != 0 || argResultSet.getObject(7) != null) {
/* 188 */         this._parent._attemptSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 193 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 194 */       if (t8 != null) {
/* 195 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 198 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 201 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 203 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 204 */       if (t10 != null) {
/* 205 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 208 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 211 */       this._parent._updateUserId = argResultSet.getString(11);
/* 212 */       this._parent._responseCode = argResultSet.getString(12);
/* 213 */       this._parent._approvalCode = argResultSet.getString(13);
/* 214 */       this._parent._authType = argResultSet.getString(14);
/* 215 */       this._parent._customerName = argResultSet.getString(15);
/* 216 */       this._parent._referenceNumber = argResultSet.getString(16);
/* 217 */       this._parent._errorCode = argResultSet.getString(17);
/* 218 */       this._parent._errorText = argResultSet.getString(18);
/*     */       
/* 220 */       Timestamp t19 = argResultSet.getTimestamp(19);
/* 221 */       if (t19 != null) {
/* 222 */         this._parent._startTimestamp = (Date)new DtvDate(t19.getTime());
/*     */       } else {
/*     */         
/* 225 */         this._parent._startTimestamp = null;
/*     */       } 
/*     */ 
/*     */       
/* 229 */       Timestamp t20 = argResultSet.getTimestamp(20);
/* 230 */       if (t20 != null) {
/* 231 */         this._parent._endTimestamp = (Date)new DtvDate(t20.getTime());
/*     */       } else {
/*     */         
/* 234 */         this._parent._endTimestamp = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 241 */     argDAO.suppressStateChanges(true);
/* 242 */     TenderAuthLogDAO dao = (TenderAuthLogDAO)argDAO;
/* 243 */     dao.setOrganizationId(this._organizationId);
/* 244 */     dao.setRetailLocationId(this._retailLocationId);
/* 245 */     dao.setWorkstationId(this._workstationId);
/* 246 */     dao.setBusinessDate(this._businessDate);
/* 247 */     dao.setTransactionSequence(this._transactionSequence);
/* 248 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 249 */     dao.setAttemptSequence(this._attemptSequence);
/* 250 */     dao.setCreateDate(this._createDate);
/* 251 */     dao.setCreateUserId(this._createUserId);
/* 252 */     dao.setUpdateDate(this._updateDate);
/* 253 */     dao.setUpdateUserId(this._updateUserId);
/* 254 */     dao.setResponseCode(this._responseCode);
/* 255 */     dao.setApprovalCode(this._approvalCode);
/* 256 */     dao.setAuthType(this._authType);
/* 257 */     dao.setCustomerName(this._customerName);
/* 258 */     dao.setReferenceNumber(this._referenceNumber);
/* 259 */     dao.setErrorCode(this._errorCode);
/* 260 */     dao.setErrorText(this._errorText);
/* 261 */     dao.setStartTimestamp(this._startTimestamp);
/* 262 */     dao.setEndTimestamp(this._endTimestamp);
/* 263 */     argDAO.suppressStateChanges(false);
/* 264 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 268 */     return loadDAO((IDataAccessObject)new TenderAuthLogDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 272 */     TenderAuthLogDAO dao = (TenderAuthLogDAO)argDAO;
/* 273 */     this._organizationId = dao.getOrganizationId();
/* 274 */     this._retailLocationId = dao.getRetailLocationId();
/* 275 */     this._workstationId = dao.getWorkstationId();
/* 276 */     this._businessDate = dao.getBusinessDate();
/* 277 */     this._transactionSequence = dao.getTransactionSequence();
/* 278 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 279 */     this._attemptSequence = dao.getAttemptSequence();
/* 280 */     this._createDate = dao.getCreateDate();
/* 281 */     this._createUserId = dao.getCreateUserId();
/* 282 */     this._updateDate = dao.getUpdateDate();
/* 283 */     this._updateUserId = dao.getUpdateUserId();
/* 284 */     this._responseCode = dao.getResponseCode();
/* 285 */     this._approvalCode = dao.getApprovalCode();
/* 286 */     this._authType = dao.getAuthType();
/* 287 */     this._customerName = dao.getCustomerName();
/* 288 */     this._referenceNumber = dao.getReferenceNumber();
/* 289 */     this._errorCode = dao.getErrorCode();
/* 290 */     this._errorText = dao.getErrorText();
/* 291 */     this._startTimestamp = dao.getStartTimestamp();
/* 292 */     this._endTimestamp = dao.getEndTimestamp();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 296 */     TenderAuthLogId id = (TenderAuthLogId)argId;
/* 297 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 298 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 299 */     argStatement.setLong(3, id.getWorkstationId().longValue());
/* 300 */     argStatement.setTimestamp(4, new Timestamp(id.getBusinessDate().getTime()));
/* 301 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 302 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 303 */     argStatement.setInt(7, id.getAttemptSequence().intValue());
/* 304 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 308 */     TenderAuthLogId id = new TenderAuthLogId();
/* 309 */     id.setOrganizationId(this._organizationId);
/* 310 */     id.setRetailLocationId(this._retailLocationId);
/* 311 */     id.setWorkstationId(this._workstationId);
/* 312 */     id.setBusinessDate(this._businessDate);
/* 313 */     id.setTransactionSequence(this._transactionSequence);
/* 314 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 315 */     id.setAttemptSequence(this._attemptSequence);
/* 316 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 324 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 328 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\TenderAuthLogDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */