/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderRepositoryFloatId;
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
/*     */ public class TenderRepositoryFloatDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 921069470L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _tenderRepositoryId;
/*     */   private String _currencyId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _defaultCashFloat;
/*     */   private BigDecimal _lastClosingCashAmt;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.tndr_repository_id, t.currency_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.default_cash_float, t.last_closing_amount FROM tsn_tndr_repository_float t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND tndr_repository_id = ?  AND currency_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.rtl_loc_id, t.tndr_repository_id, t.currency_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.default_cash_float, t.last_closing_amount FROM tsn_tndr_repository_float t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND tndr_repository_id = ?  AND currency_id = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tsn_tndr_repository_float(organization_id, rtl_loc_id, tndr_repository_id, currency_id, create_date, create_user_id, update_date, update_user_id, default_cash_float, last_closing_amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._tenderRepositoryId, this._currencyId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._defaultCashFloat, this._lastClosingCashAmt } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 91, 12, 91, 12, 3, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tsn_tndr_repository_float SET update_date = ?, update_user_id = ?, default_cash_float = ?, last_closing_amount = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._defaultCashFloat, this._lastClosingCashAmt } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tsn_tndr_repository_float" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND tndr_repository_id = ?  AND currency_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND tndr_repository_id = ?  AND currency_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._retailLocationId, this._tenderRepositoryId, this._currencyId };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "tsn_tndr_repository_float";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new TenderRepositoryFloatFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderRepositoryFloatFiller
/*     */     implements IFiller {
/*     */     private TenderRepositoryFloatDBA _parent;
/*     */     
/*     */     public TenderRepositoryFloatFiller(TenderRepositoryFloatDBA argParent) {
/* 122 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       long primitiveResult = argResultSet.getLong(1);
/* 128 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 135 */       primitiveResult = argResultSet.getLong(2);
/* 136 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 137 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 141 */       this._parent._tenderRepositoryId = argResultSet.getString(3);
/* 142 */       this._parent._currencyId = argResultSet.getString(4);
/*     */       
/* 144 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 145 */       if (t5 != null) {
/* 146 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 154 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 155 */       if (t7 != null) {
/* 156 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 162 */       this._parent._updateUserId = argResultSet.getString(8);
/* 163 */       this._parent._defaultCashFloat = argResultSet.getBigDecimal(9);
/* 164 */       this._parent._lastClosingCashAmt = argResultSet.getBigDecimal(10);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 169 */     argDAO.suppressStateChanges(true);
/* 170 */     TenderRepositoryFloatDAO dao = (TenderRepositoryFloatDAO)argDAO;
/* 171 */     dao.setOrganizationId(this._organizationId);
/* 172 */     dao.setRetailLocationId(this._retailLocationId);
/* 173 */     dao.setTenderRepositoryId(this._tenderRepositoryId);
/* 174 */     dao.setCurrencyId(this._currencyId);
/* 175 */     dao.setCreateDate(this._createDate);
/* 176 */     dao.setCreateUserId(this._createUserId);
/* 177 */     dao.setUpdateDate(this._updateDate);
/* 178 */     dao.setUpdateUserId(this._updateUserId);
/* 179 */     dao.setDefaultCashFloat(this._defaultCashFloat);
/* 180 */     dao.setLastClosingCashAmt(this._lastClosingCashAmt);
/* 181 */     argDAO.suppressStateChanges(false);
/* 182 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 186 */     return loadDAO((IDataAccessObject)new TenderRepositoryFloatDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 190 */     TenderRepositoryFloatDAO dao = (TenderRepositoryFloatDAO)argDAO;
/* 191 */     this._organizationId = dao.getOrganizationId();
/* 192 */     this._retailLocationId = dao.getRetailLocationId();
/* 193 */     this._tenderRepositoryId = dao.getTenderRepositoryId();
/* 194 */     this._currencyId = dao.getCurrencyId();
/* 195 */     this._createDate = dao.getCreateDate();
/* 196 */     this._createUserId = dao.getCreateUserId();
/* 197 */     this._updateDate = dao.getUpdateDate();
/* 198 */     this._updateUserId = dao.getUpdateUserId();
/* 199 */     this._defaultCashFloat = dao.getDefaultCashFloat();
/* 200 */     this._lastClosingCashAmt = dao.getLastClosingCashAmt();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 204 */     TenderRepositoryFloatId id = (TenderRepositoryFloatId)argId;
/* 205 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 206 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 207 */     argStatement.setString(3, id.getTenderRepositoryId());
/* 208 */     argStatement.setString(4, id.getCurrencyId());
/* 209 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 213 */     TenderRepositoryFloatId id = new TenderRepositoryFloatId();
/* 214 */     id.setOrganizationId(this._organizationId);
/* 215 */     id.setRetailLocationId(this._retailLocationId);
/* 216 */     id.setTenderRepositoryId(this._tenderRepositoryId);
/* 217 */     id.setCurrencyId(this._currencyId);
/* 218 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 226 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 230 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderRepositoryFloatDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */