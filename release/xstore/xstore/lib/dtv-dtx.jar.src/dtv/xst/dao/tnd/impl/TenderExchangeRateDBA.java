/*     */ package dtv.xst.dao.tnd.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tnd.TenderExchangeRateId;
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
/*     */ public class TenderExchangeRateDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 186706615L;
/*     */   private Long _organizationId;
/*     */   private String _baseCurrency;
/*     */   private String _targetCurrency;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _exchangeRate;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.base_currency, t.target_currency, t.level_code, t.level_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.rate FROM tnd_exchange_rate t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND base_currency = ?  AND target_currency = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.base_currency, t.target_currency, t.level_code, t.level_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.rate FROM tnd_exchange_rate t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND base_currency = ?  AND target_currency = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tnd_exchange_rate(organization_id, base_currency, target_currency, level_code, level_value, create_date, create_user_id, update_date, update_user_id, rate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._baseCurrency, this._targetCurrency, this._levelCode, this._levelValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._exchangeRate } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 12, 91, 12, 91, 12, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tnd_exchange_rate SET update_date = ?, update_user_id = ?, rate = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._exchangeRate } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tnd_exchange_rate" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND base_currency = ?  AND target_currency = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND base_currency = ?  AND target_currency = ?  AND level_code = ?  AND level_value = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._baseCurrency, this._targetCurrency, this._levelCode, this._levelValue };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "tnd_exchange_rate";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new TenderExchangeRateFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderExchangeRateFiller
/*     */     implements IFiller {
/*     */     private TenderExchangeRateDBA _parent;
/*     */     
/*     */     public TenderExchangeRateFiller(TenderExchangeRateDBA argParent) {
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
/* 133 */       this._parent._baseCurrency = argResultSet.getString(2);
/* 134 */       this._parent._targetCurrency = argResultSet.getString(3);
/* 135 */       this._parent._levelCode = argResultSet.getString(4);
/* 136 */       this._parent._levelValue = argResultSet.getString(5);
/*     */       
/* 138 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 139 */       if (t6 != null) {
/* 140 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 143 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 146 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 148 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 149 */       if (t8 != null) {
/* 150 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 153 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 156 */       this._parent._updateUserId = argResultSet.getString(9);
/* 157 */       this._parent._exchangeRate = argResultSet.getBigDecimal(10);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 162 */     argDAO.suppressStateChanges(true);
/* 163 */     TenderExchangeRateDAO dao = (TenderExchangeRateDAO)argDAO;
/* 164 */     dao.setOrganizationId(this._organizationId);
/* 165 */     dao.setBaseCurrency(this._baseCurrency);
/* 166 */     dao.setTargetCurrency(this._targetCurrency);
/* 167 */     dao.setLevelCode(this._levelCode);
/* 168 */     dao.setLevelValue(this._levelValue);
/* 169 */     dao.setCreateDate(this._createDate);
/* 170 */     dao.setCreateUserId(this._createUserId);
/* 171 */     dao.setUpdateDate(this._updateDate);
/* 172 */     dao.setUpdateUserId(this._updateUserId);
/* 173 */     dao.setExchangeRate(this._exchangeRate);
/* 174 */     argDAO.suppressStateChanges(false);
/* 175 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 179 */     return loadDAO((IDataAccessObject)new TenderExchangeRateDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 183 */     TenderExchangeRateDAO dao = (TenderExchangeRateDAO)argDAO;
/* 184 */     this._organizationId = dao.getOrganizationId();
/* 185 */     this._baseCurrency = dao.getBaseCurrency();
/* 186 */     this._targetCurrency = dao.getTargetCurrency();
/* 187 */     this._levelCode = dao.getLevelCode();
/* 188 */     this._levelValue = dao.getLevelValue();
/* 189 */     this._createDate = dao.getCreateDate();
/* 190 */     this._createUserId = dao.getCreateUserId();
/* 191 */     this._updateDate = dao.getUpdateDate();
/* 192 */     this._updateUserId = dao.getUpdateUserId();
/* 193 */     this._exchangeRate = dao.getExchangeRate();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 197 */     TenderExchangeRateId id = (TenderExchangeRateId)argId;
/* 198 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 199 */     argStatement.setString(2, id.getBaseCurrency());
/* 200 */     argStatement.setString(3, id.getTargetCurrency());
/* 201 */     argStatement.setString(4, id.getLevelCode());
/* 202 */     argStatement.setString(5, id.getLevelValue());
/* 203 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 207 */     TenderExchangeRateId id = new TenderExchangeRateId();
/* 208 */     id.setOrganizationId(this._organizationId);
/* 209 */     id.setBaseCurrency(this._baseCurrency);
/* 210 */     id.setTargetCurrency(this._targetCurrency);
/* 211 */     id.setLevelCode(this._levelCode);
/* 212 */     id.setLevelValue(this._levelValue);
/* 213 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 221 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 225 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderExchangeRateDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */