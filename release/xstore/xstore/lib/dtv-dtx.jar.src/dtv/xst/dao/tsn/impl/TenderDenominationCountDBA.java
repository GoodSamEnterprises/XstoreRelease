/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderDenominationCountId;
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
/*     */ public class TenderDenominationCountDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1378804842L;
/*     */   private Date _businessDayDate;
/*     */   private String _denominationId;
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
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.denomination_id, t.organization_id, t.rtl_loc_id, t.tndr_id, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.difference_amt, t.difference_media_count, t.media_count FROM tsn_tndr_denomination_count t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND denomination_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.business_date, t.denomination_id, t.organization_id, t.rtl_loc_id, t.tndr_id, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.difference_amt, t.difference_media_count, t.media_count FROM tsn_tndr_denomination_count t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE business_date = ?  AND denomination_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_tndr_denomination_count(business_date, denomination_id, organization_id, rtl_loc_id, tndr_id, tndr_typcode, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, amt, difference_amt, difference_media_count, media_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._businessDayDate, this._denominationId, this._organizationId, this._retailLocationId, this._tenderId, this._tenderTypeCode, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._amount, this._differenceAmount, this._differenceMediaCount, this._mediaCount } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, 12, -5, -5, 12, 12, -5, -5, 91, 12, 91, 12, 3, 3, 4, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_tndr_denomination_count SET update_date = ?, update_user_id = ?, amt = ?, difference_amt = ?, difference_media_count = ?, media_count = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._amount, this._differenceAmount, this._differenceMediaCount, this._mediaCount } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 3, 4, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_tndr_denomination_count" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND denomination_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE business_date = ?  AND denomination_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._businessDayDate, this._denominationId, this._organizationId, this._retailLocationId, this._tenderId, this._tenderTypeCode, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, 12, -5, -5, 12, 12, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "tsn_tndr_denomination_count";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new TenderDenominationCountFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderDenominationCountFiller
/*     */     implements IFiller {
/*     */     private TenderDenominationCountDBA _parent;
/*     */     
/*     */     public TenderDenominationCountFiller(TenderDenominationCountDBA argParent) {
/* 128 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 132 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 133 */       if (t1 != null) {
/* 134 */         this._parent._businessDayDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 137 */         this._parent._businessDayDate = null;
/*     */       } 
/*     */       
/* 140 */       this._parent._denominationId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 143 */       long primitiveResult = argResultSet.getLong(3);
/* 144 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 145 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 151 */       primitiveResult = argResultSet.getLong(4);
/* 152 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 153 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 157 */       this._parent._tenderId = argResultSet.getString(5);
/* 158 */       this._parent._tenderTypeCode = argResultSet.getString(6);
/*     */ 
/*     */       
/* 161 */       primitiveResult = argResultSet.getLong(7);
/* 162 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 163 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 169 */       primitiveResult = argResultSet.getLong(8);
/* 170 */       if (primitiveResult != 0L || argResultSet.getObject(8) != null) {
/* 171 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 176 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 177 */       if (t9 != null) {
/* 178 */         this._parent._createDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 184 */       this._parent._createUserId = argResultSet.getString(10);
/*     */       
/* 186 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 187 */       if (t11 != null) {
/* 188 */         this._parent._updateDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 191 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 194 */       this._parent._updateUserId = argResultSet.getString(12);
/* 195 */       this._parent._amount = argResultSet.getBigDecimal(13);
/* 196 */       this._parent._differenceAmount = argResultSet.getBigDecimal(14);
/*     */ 
/*     */       
/* 199 */       int i = argResultSet.getInt(15);
/* 200 */       if (i != 0 || argResultSet.getObject(15) != null) {
/* 201 */         this._parent._differenceMediaCount = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 207 */       i = argResultSet.getInt(16);
/* 208 */       if (i != 0 || argResultSet.getObject(16) != null) {
/* 209 */         this._parent._mediaCount = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 217 */     argDAO.suppressStateChanges(true);
/* 218 */     TenderDenominationCountDAO dao = (TenderDenominationCountDAO)argDAO;
/* 219 */     dao.setBusinessDayDate(this._businessDayDate);
/* 220 */     dao.setDenominationId(this._denominationId);
/* 221 */     dao.setOrganizationId(this._organizationId);
/* 222 */     dao.setRetailLocationId(this._retailLocationId);
/* 223 */     dao.setTenderId(this._tenderId);
/* 224 */     dao.setTenderTypeCode(this._tenderTypeCode);
/* 225 */     dao.setTransactionSequence(this._transactionSequence);
/* 226 */     dao.setWorkstationId(this._workstationId);
/* 227 */     dao.setCreateDate(this._createDate);
/* 228 */     dao.setCreateUserId(this._createUserId);
/* 229 */     dao.setUpdateDate(this._updateDate);
/* 230 */     dao.setUpdateUserId(this._updateUserId);
/* 231 */     dao.setAmount(this._amount);
/* 232 */     dao.setDifferenceAmount(this._differenceAmount);
/* 233 */     dao.setDifferenceMediaCount(this._differenceMediaCount);
/* 234 */     dao.setMediaCount(this._mediaCount);
/* 235 */     argDAO.suppressStateChanges(false);
/* 236 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 240 */     return loadDAO((IDataAccessObject)new TenderDenominationCountDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 244 */     TenderDenominationCountDAO dao = (TenderDenominationCountDAO)argDAO;
/* 245 */     this._businessDayDate = dao.getBusinessDayDate();
/* 246 */     this._denominationId = dao.getDenominationId();
/* 247 */     this._organizationId = dao.getOrganizationId();
/* 248 */     this._retailLocationId = dao.getRetailLocationId();
/* 249 */     this._tenderId = dao.getTenderId();
/* 250 */     this._tenderTypeCode = dao.getTenderTypeCode();
/* 251 */     this._transactionSequence = dao.getTransactionSequence();
/* 252 */     this._workstationId = dao.getWorkstationId();
/* 253 */     this._createDate = dao.getCreateDate();
/* 254 */     this._createUserId = dao.getCreateUserId();
/* 255 */     this._updateDate = dao.getUpdateDate();
/* 256 */     this._updateUserId = dao.getUpdateUserId();
/* 257 */     this._amount = dao.getAmount();
/* 258 */     this._differenceAmount = dao.getDifferenceAmount();
/* 259 */     this._differenceMediaCount = dao.getDifferenceMediaCount();
/* 260 */     this._mediaCount = dao.getMediaCount();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 264 */     TenderDenominationCountId id = (TenderDenominationCountId)argId;
/* 265 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDayDate().getTime()));
/* 266 */     argStatement.setString(2, id.getDenominationId());
/* 267 */     argStatement.setLong(3, id.getOrganizationId().longValue());
/* 268 */     argStatement.setLong(4, id.getRetailLocationId().longValue());
/* 269 */     argStatement.setString(5, id.getTenderId());
/* 270 */     argStatement.setString(6, id.getTenderTypeCode());
/* 271 */     argStatement.setLong(7, id.getTransactionSequence().longValue());
/* 272 */     argStatement.setLong(8, id.getWorkstationId().longValue());
/* 273 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 277 */     TenderDenominationCountId id = new TenderDenominationCountId();
/* 278 */     id.setBusinessDayDate(this._businessDayDate);
/* 279 */     id.setDenominationId(this._denominationId);
/* 280 */     id.setOrganizationId(this._organizationId);
/* 281 */     id.setRetailLocationId(this._retailLocationId);
/* 282 */     id.setTenderId(this._tenderId);
/* 283 */     id.setTenderTypeCode(this._tenderTypeCode);
/* 284 */     id.setTransactionSequence(this._transactionSequence);
/* 285 */     id.setWorkstationId(this._workstationId);
/* 286 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 294 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 298 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderDenominationCountDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */