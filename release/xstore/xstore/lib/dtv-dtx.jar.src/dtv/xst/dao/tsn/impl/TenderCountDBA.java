/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderCountId;
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
/*     */ public class TenderCountDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 715373179L;
/*     */   private Date _businessDayDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _tenderId;
/*     */   private String _tenderTypeCode;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private BigDecimal _differenceAmount;
/*     */   private Integer _differenceMediaCount;
/*     */   private Integer _mediaCount;
/*     */   private BigDecimal _depositAmount;
/*     */   private BigDecimal _localCurrencyAmount;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.tndr_id, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.difference_amt, t.difference_media_count, t.media_count, t.deposit_amt, t.local_currency_amt FROM tsn_tndr_tndr_count t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.tndr_id, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.difference_amt, t.difference_media_count, t.media_count, t.deposit_amt, t.local_currency_amt FROM tsn_tndr_tndr_count t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_tndr_tndr_count(business_date, organization_id, rtl_loc_id, tndr_id, tndr_typcode, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, amt, difference_amt, difference_media_count, media_count, deposit_amt, local_currency_amt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._businessDayDate, this._organizationId, this._retailLocationId, this._tenderId, this._tenderTypeCode, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._amount, this._differenceAmount, this._differenceMediaCount, this._mediaCount, this._depositAmount, this._localCurrencyAmount } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, -5, 12, 12, -5, -5, 91, 12, 91, 12, 3, 3, 4, 4, 3, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_tndr_tndr_count SET update_date = ?, update_user_id = ?, amt = ?, difference_amt = ?, difference_media_count = ?, media_count = ?, deposit_amt = ?, local_currency_amt = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._amount, this._differenceAmount, this._differenceMediaCount, this._mediaCount, this._depositAmount, this._localCurrencyAmount } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 3, 4, 4, 3, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_tndr_tndr_count" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[] { this._businessDayDate, this._organizationId, this._retailLocationId, this._tenderId, this._tenderTypeCode, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, -5, 12, 12, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "tsn_tndr_tndr_count";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new TenderCountFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderCountFiller
/*     */     implements IFiller {
/*     */     private TenderCountDBA _parent;
/*     */     
/*     */     public TenderCountFiller(TenderCountDBA argParent) {
/* 129 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 133 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 134 */       if (t1 != null) {
/* 135 */         this._parent._businessDayDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 138 */         this._parent._businessDayDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 143 */       long primitiveResult = argResultSet.getLong(2);
/* 144 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 145 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 151 */       primitiveResult = argResultSet.getLong(3);
/* 152 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 153 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 157 */       this._parent._tenderId = argResultSet.getString(4);
/* 158 */       this._parent._tenderTypeCode = argResultSet.getString(5);
/*     */ 
/*     */       
/* 161 */       primitiveResult = argResultSet.getLong(6);
/* 162 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 163 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 169 */       primitiveResult = argResultSet.getLong(7);
/* 170 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 171 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 176 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 177 */       if (t8 != null) {
/* 178 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 184 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 186 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 187 */       if (t10 != null) {
/* 188 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 191 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 194 */       this._parent._updateUserId = argResultSet.getString(11);
/* 195 */       this._parent._amount = argResultSet.getBigDecimal(12);
/* 196 */       this._parent._differenceAmount = argResultSet.getBigDecimal(13);
/*     */ 
/*     */       
/* 199 */       int i = argResultSet.getInt(14);
/* 200 */       if (i != 0 || argResultSet.getObject(14) != null) {
/* 201 */         this._parent._differenceMediaCount = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 207 */       i = argResultSet.getInt(15);
/* 208 */       if (i != 0 || argResultSet.getObject(15) != null) {
/* 209 */         this._parent._mediaCount = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 213 */       this._parent._depositAmount = argResultSet.getBigDecimal(16);
/* 214 */       this._parent._localCurrencyAmount = argResultSet.getBigDecimal(17);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 219 */     argDAO.suppressStateChanges(true);
/* 220 */     TenderCountDAO dao = (TenderCountDAO)argDAO;
/* 221 */     dao.setBusinessDayDate(this._businessDayDate);
/* 222 */     dao.setOrganizationId(this._organizationId);
/* 223 */     dao.setRetailLocationId(this._retailLocationId);
/* 224 */     dao.setTenderId(this._tenderId);
/* 225 */     dao.setTenderTypeCode(this._tenderTypeCode);
/* 226 */     dao.setTransactionSequence(this._transactionSequence);
/* 227 */     dao.setWorkstationId(this._workstationId);
/* 228 */     dao.setCreateDate(this._createDate);
/* 229 */     dao.setCreateUserId(this._createUserId);
/* 230 */     dao.setUpdateDate(this._updateDate);
/* 231 */     dao.setUpdateUserId(this._updateUserId);
/* 232 */     dao.setAmount(this._amount);
/* 233 */     dao.setDifferenceAmount(this._differenceAmount);
/* 234 */     dao.setDifferenceMediaCount(this._differenceMediaCount);
/* 235 */     dao.setMediaCount(this._mediaCount);
/* 236 */     dao.setDepositAmount(this._depositAmount);
/* 237 */     dao.setLocalCurrencyAmount(this._localCurrencyAmount);
/* 238 */     argDAO.suppressStateChanges(false);
/* 239 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 243 */     return loadDAO((IDataAccessObject)new TenderCountDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 247 */     TenderCountDAO dao = (TenderCountDAO)argDAO;
/* 248 */     this._businessDayDate = dao.getBusinessDayDate();
/* 249 */     this._organizationId = dao.getOrganizationId();
/* 250 */     this._retailLocationId = dao.getRetailLocationId();
/* 251 */     this._tenderId = dao.getTenderId();
/* 252 */     this._tenderTypeCode = dao.getTenderTypeCode();
/* 253 */     this._transactionSequence = dao.getTransactionSequence();
/* 254 */     this._workstationId = dao.getWorkstationId();
/* 255 */     this._createDate = dao.getCreateDate();
/* 256 */     this._createUserId = dao.getCreateUserId();
/* 257 */     this._updateDate = dao.getUpdateDate();
/* 258 */     this._updateUserId = dao.getUpdateUserId();
/* 259 */     this._amount = dao.getAmount();
/* 260 */     this._differenceAmount = dao.getDifferenceAmount();
/* 261 */     this._differenceMediaCount = dao.getDifferenceMediaCount();
/* 262 */     this._mediaCount = dao.getMediaCount();
/* 263 */     this._depositAmount = dao.getDepositAmount();
/* 264 */     this._localCurrencyAmount = dao.getLocalCurrencyAmount();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 268 */     TenderCountId id = (TenderCountId)argId;
/* 269 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDayDate().getTime()));
/* 270 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 271 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 272 */     argStatement.setString(4, id.getTenderId());
/* 273 */     argStatement.setString(5, id.getTenderTypeCode());
/* 274 */     argStatement.setLong(6, id.getTransactionSequence().longValue());
/* 275 */     argStatement.setLong(7, id.getWorkstationId().longValue());
/* 276 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 280 */     TenderCountId id = new TenderCountId();
/* 281 */     id.setBusinessDayDate(this._businessDayDate);
/* 282 */     id.setOrganizationId(this._organizationId);
/* 283 */     id.setRetailLocationId(this._retailLocationId);
/* 284 */     id.setTenderId(this._tenderId);
/* 285 */     id.setTenderTypeCode(this._tenderTypeCode);
/* 286 */     id.setTransactionSequence(this._transactionSequence);
/* 287 */     id.setWorkstationId(this._workstationId);
/* 288 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 296 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 300 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderCountDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */