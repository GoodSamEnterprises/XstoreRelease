/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderTypeCountId;
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
/*     */ public class TenderTypeCountDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 838474081L;
/*     */   private Date _businessDayDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
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
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.difference_amt, t.difference_media_count, t.media_count FROM tsn_tndr_typcode_count t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.tndr_typcode, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amt, t.difference_amt, t.difference_media_count, t.media_count FROM tsn_tndr_typcode_count t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_tndr_typcode_count(business_date, organization_id, rtl_loc_id, tndr_typcode, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, amt, difference_amt, difference_media_count, media_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._businessDayDate, this._organizationId, this._retailLocationId, this._tenderTypeCode, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._amount, this._differenceAmount, this._differenceMediaCount, this._mediaCount } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, -5, 12, -5, -5, 91, 12, 91, 12, 3, 3, 4, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_tndr_typcode_count SET update_date = ?, update_user_id = ?, amt = ?, difference_amt = ?, difference_media_count = ?, media_count = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._amount, this._differenceAmount, this._differenceMediaCount, this._mediaCount } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 3, 4, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_tndr_typcode_count" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND tndr_typcode = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._businessDayDate, this._organizationId, this._retailLocationId, this._tenderTypeCode, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, -5, 12, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "tsn_tndr_typcode_count";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new TenderTypeCountFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderTypeCountFiller
/*     */     implements IFiller {
/*     */     private TenderTypeCountDBA _parent;
/*     */     
/*     */     public TenderTypeCountFiller(TenderTypeCountDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 131 */       if (t1 != null) {
/* 132 */         this._parent._businessDayDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 135 */         this._parent._businessDayDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 140 */       long primitiveResult = argResultSet.getLong(2);
/* 141 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 142 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       primitiveResult = argResultSet.getLong(3);
/* 149 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 150 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 154 */       this._parent._tenderTypeCode = argResultSet.getString(4);
/*     */ 
/*     */       
/* 157 */       primitiveResult = argResultSet.getLong(5);
/* 158 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 159 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 165 */       primitiveResult = argResultSet.getLong(6);
/* 166 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 167 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 172 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 173 */       if (t7 != null) {
/* 174 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 177 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 180 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 182 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 183 */       if (t9 != null) {
/* 184 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 187 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 190 */       this._parent._updateUserId = argResultSet.getString(10);
/* 191 */       this._parent._amount = argResultSet.getBigDecimal(11);
/* 192 */       this._parent._differenceAmount = argResultSet.getBigDecimal(12);
/*     */ 
/*     */       
/* 195 */       int i = argResultSet.getInt(13);
/* 196 */       if (i != 0 || argResultSet.getObject(13) != null) {
/* 197 */         this._parent._differenceMediaCount = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 203 */       i = argResultSet.getInt(14);
/* 204 */       if (i != 0 || argResultSet.getObject(14) != null) {
/* 205 */         this._parent._mediaCount = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 213 */     argDAO.suppressStateChanges(true);
/* 214 */     TenderTypeCountDAO dao = (TenderTypeCountDAO)argDAO;
/* 215 */     dao.setBusinessDayDate(this._businessDayDate);
/* 216 */     dao.setOrganizationId(this._organizationId);
/* 217 */     dao.setRetailLocationId(this._retailLocationId);
/* 218 */     dao.setTenderTypeCode(this._tenderTypeCode);
/* 219 */     dao.setTransactionSequence(this._transactionSequence);
/* 220 */     dao.setWorkstationId(this._workstationId);
/* 221 */     dao.setCreateDate(this._createDate);
/* 222 */     dao.setCreateUserId(this._createUserId);
/* 223 */     dao.setUpdateDate(this._updateDate);
/* 224 */     dao.setUpdateUserId(this._updateUserId);
/* 225 */     dao.setAmount(this._amount);
/* 226 */     dao.setDifferenceAmount(this._differenceAmount);
/* 227 */     dao.setDifferenceMediaCount(this._differenceMediaCount);
/* 228 */     dao.setMediaCount(this._mediaCount);
/* 229 */     argDAO.suppressStateChanges(false);
/* 230 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 234 */     return loadDAO((IDataAccessObject)new TenderTypeCountDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 238 */     TenderTypeCountDAO dao = (TenderTypeCountDAO)argDAO;
/* 239 */     this._businessDayDate = dao.getBusinessDayDate();
/* 240 */     this._organizationId = dao.getOrganizationId();
/* 241 */     this._retailLocationId = dao.getRetailLocationId();
/* 242 */     this._tenderTypeCode = dao.getTenderTypeCode();
/* 243 */     this._transactionSequence = dao.getTransactionSequence();
/* 244 */     this._workstationId = dao.getWorkstationId();
/* 245 */     this._createDate = dao.getCreateDate();
/* 246 */     this._createUserId = dao.getCreateUserId();
/* 247 */     this._updateDate = dao.getUpdateDate();
/* 248 */     this._updateUserId = dao.getUpdateUserId();
/* 249 */     this._amount = dao.getAmount();
/* 250 */     this._differenceAmount = dao.getDifferenceAmount();
/* 251 */     this._differenceMediaCount = dao.getDifferenceMediaCount();
/* 252 */     this._mediaCount = dao.getMediaCount();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 256 */     TenderTypeCountId id = (TenderTypeCountId)argId;
/* 257 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDayDate().getTime()));
/* 258 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 259 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 260 */     argStatement.setString(4, id.getTenderTypeCode());
/* 261 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 262 */     argStatement.setLong(6, id.getWorkstationId().longValue());
/* 263 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 267 */     TenderTypeCountId id = new TenderTypeCountId();
/* 268 */     id.setBusinessDayDate(this._businessDayDate);
/* 269 */     id.setOrganizationId(this._organizationId);
/* 270 */     id.setRetailLocationId(this._retailLocationId);
/* 271 */     id.setTenderTypeCode(this._tenderTypeCode);
/* 272 */     id.setTransactionSequence(this._transactionSequence);
/* 273 */     id.setWorkstationId(this._workstationId);
/* 274 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 282 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 286 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderTypeCountDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */