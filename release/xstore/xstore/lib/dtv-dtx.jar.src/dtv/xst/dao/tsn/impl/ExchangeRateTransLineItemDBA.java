/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.ExchangeRateTransLineItemId;
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
/*     */ public class ExchangeRateTransLineItemDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -835436820L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _lineItemSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _baseCurrency;
/*     */   private String _targetCurrency;
/*     */   private BigDecimal _oldExchangeRate;
/*     */   private BigDecimal _newExchangeRate;
/*     */   private String _notes;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.line_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.base_currency, t.target_currency, t.old_rate, t.new_rate, t.notes FROM tsn_xrtrans_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND line_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.line_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.base_currency, t.target_currency, t.old_rate, t.new_rate, t.notes FROM tsn_xrtrans_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND line_seq = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_xrtrans_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, line_seq, create_date, create_user_id, update_date, update_user_id, base_currency, target_currency, old_rate, new_rate, notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._lineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._baseCurrency, this._targetCurrency, this._oldExchangeRate, this._newExchangeRate, this._notes } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 12, 3, 3, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_xrtrans_lineitm SET update_date = ?, update_user_id = ?, base_currency = ?, target_currency = ?, old_rate = ?, new_rate = ?, notes = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._baseCurrency, this._targetCurrency, this._oldExchangeRate, this._newExchangeRate, this._notes } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 3, 3, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_xrtrans_lineitm" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND line_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND line_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._lineItemSequence };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "tsn_xrtrans_lineitm";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new ExchangeRateTransLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class ExchangeRateTransLineItemFiller
/*     */     implements IFiller {
/*     */     private ExchangeRateTransLineItemDBA _parent;
/*     */     
/*     */     public ExchangeRateTransLineItemFiller(ExchangeRateTransLineItemDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 132 */       long primitiveResult = argResultSet.getLong(1);
/* 133 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 134 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 140 */       primitiveResult = argResultSet.getLong(2);
/* 141 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 142 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 147 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 148 */       if (t3 != null) {
/* 149 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 157 */       long l1 = argResultSet.getLong(4);
/* 158 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 159 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 165 */       l1 = argResultSet.getLong(5);
/* 166 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 167 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       int i = argResultSet.getInt(6);
/* 174 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 175 */         this._parent._lineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 180 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 181 */       if (t7 != null) {
/* 182 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 185 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 188 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 190 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 191 */       if (t9 != null) {
/* 192 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 195 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 198 */       this._parent._updateUserId = argResultSet.getString(10);
/* 199 */       this._parent._baseCurrency = argResultSet.getString(11);
/* 200 */       this._parent._targetCurrency = argResultSet.getString(12);
/* 201 */       this._parent._oldExchangeRate = argResultSet.getBigDecimal(13);
/* 202 */       this._parent._newExchangeRate = argResultSet.getBigDecimal(14);
/* 203 */       this._parent._notes = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 208 */     argDAO.suppressStateChanges(true);
/* 209 */     ExchangeRateTransLineItemDAO dao = (ExchangeRateTransLineItemDAO)argDAO;
/* 210 */     dao.setOrganizationId(this._organizationId);
/* 211 */     dao.setRetailLocationId(this._retailLocationId);
/* 212 */     dao.setBusinessDate(this._businessDate);
/* 213 */     dao.setWorkstationId(this._workstationId);
/* 214 */     dao.setTransactionSequence(this._transactionSequence);
/* 215 */     dao.setLineItemSequence(this._lineItemSequence);
/* 216 */     dao.setCreateDate(this._createDate);
/* 217 */     dao.setCreateUserId(this._createUserId);
/* 218 */     dao.setUpdateDate(this._updateDate);
/* 219 */     dao.setUpdateUserId(this._updateUserId);
/* 220 */     dao.setBaseCurrency(this._baseCurrency);
/* 221 */     dao.setTargetCurrency(this._targetCurrency);
/* 222 */     dao.setOldExchangeRate(this._oldExchangeRate);
/* 223 */     dao.setNewExchangeRate(this._newExchangeRate);
/* 224 */     dao.setNotes(this._notes);
/* 225 */     argDAO.suppressStateChanges(false);
/* 226 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 230 */     return loadDAO((IDataAccessObject)new ExchangeRateTransLineItemDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 234 */     ExchangeRateTransLineItemDAO dao = (ExchangeRateTransLineItemDAO)argDAO;
/* 235 */     this._organizationId = dao.getOrganizationId();
/* 236 */     this._retailLocationId = dao.getRetailLocationId();
/* 237 */     this._businessDate = dao.getBusinessDate();
/* 238 */     this._workstationId = dao.getWorkstationId();
/* 239 */     this._transactionSequence = dao.getTransactionSequence();
/* 240 */     this._lineItemSequence = dao.getLineItemSequence();
/* 241 */     this._createDate = dao.getCreateDate();
/* 242 */     this._createUserId = dao.getCreateUserId();
/* 243 */     this._updateDate = dao.getUpdateDate();
/* 244 */     this._updateUserId = dao.getUpdateUserId();
/* 245 */     this._baseCurrency = dao.getBaseCurrency();
/* 246 */     this._targetCurrency = dao.getTargetCurrency();
/* 247 */     this._oldExchangeRate = dao.getOldExchangeRate();
/* 248 */     this._newExchangeRate = dao.getNewExchangeRate();
/* 249 */     this._notes = dao.getNotes();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 253 */     ExchangeRateTransLineItemId id = (ExchangeRateTransLineItemId)argId;
/* 254 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 255 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 256 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 257 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 258 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 259 */     argStatement.setInt(6, id.getLineItemSequence().intValue());
/* 260 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 264 */     ExchangeRateTransLineItemId id = new ExchangeRateTransLineItemId();
/* 265 */     id.setOrganizationId(this._organizationId);
/* 266 */     id.setRetailLocationId(this._retailLocationId);
/* 267 */     id.setBusinessDate(this._businessDate);
/* 268 */     id.setWorkstationId(this._workstationId);
/* 269 */     id.setTransactionSequence(this._transactionSequence);
/* 270 */     id.setLineItemSequence(this._lineItemSequence);
/* 271 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 279 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 283 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\ExchangeRateTransLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */