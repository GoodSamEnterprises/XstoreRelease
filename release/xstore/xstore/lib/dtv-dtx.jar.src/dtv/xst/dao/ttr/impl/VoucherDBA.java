/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.IHasIncrementalValues;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ttr.VoucherId;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VoucherDBA
/*     */   implements IJDBCTableAdapter, IHasIncrementalValues
/*     */ {
/*     */   private static final long serialVersionUID = -1990121842L;
/*     */   private Long _organizationId;
/*     */   private String _serialNumber;
/*     */   private String _voucherTypeCode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _effectiveDate;
/*     */   private Date _expirationDate;
/*     */   private BigDecimal _faceValueAmount;
/*     */   private Date _issueDatetimestamp;
/*     */   private String _issueTypeCode;
/*     */   private BigDecimal _unspentBalanceAmount;
/*     */   private BigDecimal _initUnspentBalanceAmount;
/*     */   private String _voucherStatusCode;
/*     */   private String _currencyId;
/*     */   protected boolean _incrementalActive = true;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.serial_nbr, t.voucher_typcode, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.effective_date, t.expr_date, t.face_value_amt, t.issue_datetime, t.issue_typcode, t.unspent_balance_amt, t.voucher_status_code, t.currency_id FROM ttr_voucher t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND serial_nbr = ?  AND voucher_typcode = ?  ";
/*     */   
/*     */   public void setIncrementalActive(boolean argActive) {
/*  44 */     this._incrementalActive = argActive;
/*     */   }
/*     */   
/*     */   public boolean getIncrementalActive() {
/*  48 */     return this._incrementalActive;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelect() {
/*  54 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  58 */     return "SELECT t.organization_id, t.serial_nbr, t.voucher_typcode, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.effective_date, t.expr_date, t.face_value_amt, t.issue_datetime, t.issue_typcode, t.unspent_balance_amt, t.voucher_status_code, t.currency_id FROM ttr_voucher t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  64 */     return " WHERE organization_id = ?  AND serial_nbr = ?  AND voucher_typcode = ?  ";
/*     */   }
/*     */   
/*  67 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ttr_voucher(organization_id, serial_nbr, voucher_typcode, create_date, create_user_id, update_date, update_user_id, effective_date, expr_date, face_value_amt, issue_datetime, issue_typcode, unspent_balance_amt, voucher_status_code, currency_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  70 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  74 */     Object[][] insertParameterObject = { { this._organizationId, this._serialNumber, this._voucherTypeCode, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._effectiveDate, this._expirationDate, this._faceValueAmount, this._issueDatetimestamp, this._issueTypeCode, this._unspentBalanceAmount, this._voucherStatusCode, this._currencyId } };
/*  75 */     return insertParameterObject;
/*     */   }
/*     */   
/*  78 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 91, 91, 3, 91, 12, 3, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  81 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*     */   public String[] getUpdate() {
/*  85 */     if (this._incrementalActive) {
/*  86 */       return getIncrementalUpdate();
/*     */     }
/*     */     
/*  89 */     return getStandardUpdate();
/*     */   }
/*     */ 
/*     */   
/*  93 */   private static final String[] INCREMENTAL_UPDATE_OBJECT = new String[] { "UPDATE ttr_voucher SET update_date = ?, update_user_id = ?, effective_date = ?, expr_date = ?, face_value_amt = ?, issue_datetime = ?, issue_typcode = ?, unspent_balance_amt = COALESCE(unspent_balance_amt,0) + ?, voucher_status_code = ?, currency_id = ?" };
/*     */   
/*     */   public String[] getIncrementalUpdate() {
/*  96 */     return INCREMENTAL_UPDATE_OBJECT;
/*     */   }
/*     */   
/*  99 */   private static final String[] STANDARD_UPDATE_OBJECT = new String[] { "UPDATE ttr_voucher SET update_date = ?, update_user_id = ?, effective_date = ?, expr_date = ?, face_value_amt = ?, issue_datetime = ?, issue_typcode = ?, unspent_balance_amt = ?, voucher_status_code = ?, currency_id = ?" };
/*     */   
/*     */   public String[] getStandardUpdate() {
/* 102 */     return STANDARD_UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 106 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._effectiveDate, this._expirationDate, this._faceValueAmount, this._issueDatetimestamp, this._issueTypeCode, getUnspentBalanceAmountDiff(), this._voucherStatusCode, this._currencyId } };
/* 107 */     return updateParameterObject;
/*     */   }
/*     */   
/* 110 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 91, 3, 91, 12, 3, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 112 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 115 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ttr_voucher" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND serial_nbr = ?  AND voucher_typcode = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 118 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 124 */     return " WHERE organization_id = ?  AND serial_nbr = ?  AND voucher_typcode = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 127 */     return new Object[] { this._organizationId, this._serialNumber, this._voucherTypeCode };
/*     */   }
/*     */   
/* 130 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 133 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */ 
/*     */   
/*     */   private BigDecimal getUnspentBalanceAmountDiff() {
/*     */     BigDecimal val1, val2;
/* 139 */     if (this._unspentBalanceAmount == null) {
/* 140 */       val1 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 143 */       val1 = this._unspentBalanceAmount;
/*     */     } 
/*     */     
/* 146 */     if (this._initUnspentBalanceAmount == null) {
/* 147 */       val2 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 150 */       val2 = this._initUnspentBalanceAmount;
/*     */     } 
/*     */     
/* 153 */     BigDecimal res = val1.subtract(val2);
/*     */     
/* 155 */     if (res.scale() < 8) {
/* 156 */       res = res.setScale(8);
/*     */     }
/*     */     
/* 159 */     return res;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 163 */     return "ttr_voucher";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 167 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 171 */     return new VoucherFiller(this);
/*     */   }
/*     */   
/*     */   private static class VoucherFiller
/*     */     implements IFiller {
/*     */     private VoucherDBA _parent;
/*     */     
/*     */     public VoucherFiller(VoucherDBA argParent) {
/* 179 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 184 */       long primitiveResult = argResultSet.getLong(1);
/* 185 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 186 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 190 */       this._parent._serialNumber = argResultSet.getString(2);
/* 191 */       this._parent._voucherTypeCode = argResultSet.getString(3);
/*     */       
/* 193 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 194 */       if (t4 != null) {
/* 195 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 198 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 201 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 203 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 204 */       if (t6 != null) {
/* 205 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 208 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 211 */       this._parent._updateUserId = argResultSet.getString(7);
/*     */       
/* 213 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 214 */       if (t8 != null) {
/* 215 */         this._parent._effectiveDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 218 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 222 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 223 */       if (t9 != null) {
/* 224 */         this._parent._expirationDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 227 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 230 */       this._parent._faceValueAmount = argResultSet.getBigDecimal(10);
/*     */       
/* 232 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 233 */       if (t11 != null) {
/* 234 */         this._parent._issueDatetimestamp = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 237 */         this._parent._issueDatetimestamp = null;
/*     */       } 
/*     */       
/* 240 */       this._parent._issueTypeCode = argResultSet.getString(12);
/* 241 */       this._parent._unspentBalanceAmount = argResultSet.getBigDecimal(13);
/* 242 */       this._parent._initUnspentBalanceAmount = argResultSet.getBigDecimal(13);
/* 243 */       this._parent._voucherStatusCode = argResultSet.getString(14);
/* 244 */       this._parent._currencyId = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 249 */     argDAO.suppressStateChanges(true);
/* 250 */     VoucherDAO dao = (VoucherDAO)argDAO;
/* 251 */     dao.setOrganizationId(this._organizationId);
/* 252 */     dao.setSerialNumber(this._serialNumber);
/* 253 */     dao.setVoucherTypeCode(this._voucherTypeCode);
/* 254 */     dao.setCreateDate(this._createDate);
/* 255 */     dao.setCreateUserId(this._createUserId);
/* 256 */     dao.setUpdateDate(this._updateDate);
/* 257 */     dao.setUpdateUserId(this._updateUserId);
/* 258 */     dao.setEffectiveDate(this._effectiveDate);
/* 259 */     dao.setExpirationDate(this._expirationDate);
/* 260 */     dao.setFaceValueAmount(this._faceValueAmount);
/* 261 */     dao.setIssueDatetimestamp(this._issueDatetimestamp);
/* 262 */     dao.setIssueTypeCode(this._issueTypeCode);
/* 263 */     dao.setUnspentBalanceAmount(this._unspentBalanceAmount);
/* 264 */     dao.setInitUnspentBalanceAmount(this._unspentBalanceAmount);
/* 265 */     dao.setVoucherStatusCode(this._voucherStatusCode);
/* 266 */     dao.setCurrencyId(this._currencyId);
/* 267 */     argDAO.suppressStateChanges(false);
/* 268 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 272 */     return loadDAO((IDataAccessObject)new VoucherDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 276 */     VoucherDAO dao = (VoucherDAO)argDAO;
/* 277 */     this._organizationId = dao.getOrganizationId();
/* 278 */     this._serialNumber = dao.getSerialNumber();
/* 279 */     this._voucherTypeCode = dao.getVoucherTypeCode();
/* 280 */     this._createDate = dao.getCreateDate();
/* 281 */     this._createUserId = dao.getCreateUserId();
/* 282 */     this._updateDate = dao.getUpdateDate();
/* 283 */     this._updateUserId = dao.getUpdateUserId();
/* 284 */     this._effectiveDate = dao.getEffectiveDate();
/* 285 */     this._expirationDate = dao.getExpirationDate();
/* 286 */     this._faceValueAmount = dao.getFaceValueAmount();
/* 287 */     this._issueDatetimestamp = dao.getIssueDatetimestamp();
/* 288 */     this._issueTypeCode = dao.getIssueTypeCode();
/* 289 */     this._unspentBalanceAmount = dao.getUnspentBalanceAmount();
/* 290 */     this._initUnspentBalanceAmount = dao.getInitUnspentBalanceAmount();
/* 291 */     this._voucherStatusCode = dao.getVoucherStatusCode();
/* 292 */     this._currencyId = dao.getCurrencyId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 296 */     VoucherId id = (VoucherId)argId;
/* 297 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 298 */     argStatement.setString(2, id.getSerialNumber());
/* 299 */     argStatement.setString(3, id.getVoucherTypeCode());
/* 300 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 304 */     VoucherId id = new VoucherId();
/* 305 */     id.setOrganizationId(this._organizationId);
/* 306 */     id.setSerialNumber(this._serialNumber);
/* 307 */     id.setVoucherTypeCode(this._voucherTypeCode);
/* 308 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 316 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 320 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\VoucherDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */