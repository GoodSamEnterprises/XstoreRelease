/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.tax.TaxRateRuleId;
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
/*     */ public class TaxRateRuleDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 133683367L;
/*     */   private Long _organizationId;
/*     */   private String _taxGroupId;
/*     */   private String _taxLocationId;
/*     */   private Integer _taxRateRuleSequence;
/*     */   private Integer _taxRuleSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private BigDecimal _amount;
/*     */   private String _breakPointTypeCode;
/*     */   private Date _dailyEndTimeDao;
/*     */   private Date _dailyStartTimeDao;
/*     */   private Date _effectiveDatetimestamp;
/*     */   private Date _expirationDatetimestamp;
/*     */   private BigDecimal _percent;
/*     */   private BigDecimal _taxRateMaxTaxableAmount;
/*     */   private BigDecimal _taxRateMinTaxableAmount;
/*     */   private String _taxBracketId;
/*     */   private String _externalSystem;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.tax_group_id, t.tax_loc_id, t.tax_rate_rule_seq, t.tax_rule_seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.amt, t.breakpoint_typcode, t.daily_end_time, t.daily_start_time, t.effective_datetime, t.expr_datetime, t.percentage, t.tax_rate_max_taxable_amt, t.tax_rate_min_taxable_amt, t.tax_bracket_id, t.external_system FROM tax_tax_rate_rule t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rate_rule_seq = ?  AND tax_rule_seq_nbr = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  51 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  55 */     return "SELECT t.organization_id, t.tax_group_id, t.tax_loc_id, t.tax_rate_rule_seq, t.tax_rule_seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.amt, t.breakpoint_typcode, t.daily_end_time, t.daily_start_time, t.effective_datetime, t.expr_datetime, t.percentage, t.tax_rate_max_taxable_amt, t.tax_rate_min_taxable_amt, t.tax_bracket_id, t.external_system FROM tax_tax_rate_rule t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  61 */     return " WHERE organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rate_rule_seq = ?  AND tax_rule_seq_nbr = ?  ";
/*     */   }
/*     */   
/*  64 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tax_tax_rate_rule(organization_id, tax_group_id, tax_loc_id, tax_rate_rule_seq, tax_rule_seq_nbr, create_date, create_user_id, update_date, update_user_id, org_code, org_value, amt, breakpoint_typcode, daily_end_time, daily_start_time, effective_datetime, expr_datetime, percentage, tax_rate_max_taxable_amt, tax_rate_min_taxable_amt, tax_bracket_id, external_system) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  67 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  71 */     Object[][] insertParameterObject = { { this._organizationId, this._taxGroupId, this._taxLocationId, this._taxRateRuleSequence, this._taxRuleSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._amount, this._breakPointTypeCode, this._dailyEndTimeDao, this._dailyStartTimeDao, this._effectiveDatetimestamp, this._expirationDatetimestamp, this._percent, this._taxRateMaxTaxableAmount, this._taxRateMinTaxableAmount, this._taxBracketId, this._externalSystem } };
/*  72 */     return insertParameterObject;
/*     */   }
/*     */   
/*  75 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 4, 4, 91, 12, 91, 12, 12, 12, 3, 12, 91, 91, 91, 91, 3, 3, 3, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  78 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  81 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tax_tax_rate_rule SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, amt = ?, breakpoint_typcode = ?, daily_end_time = ?, daily_start_time = ?, effective_datetime = ?, expr_datetime = ?, percentage = ?, tax_rate_max_taxable_amt = ?, tax_rate_min_taxable_amt = ?, tax_bracket_id = ?, external_system = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  84 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  88 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._amount, this._breakPointTypeCode, this._dailyEndTimeDao, this._dailyStartTimeDao, this._effectiveDatetimestamp, this._expirationDatetimestamp, this._percent, this._taxRateMaxTaxableAmount, this._taxRateMinTaxableAmount, this._taxBracketId, this._externalSystem } };
/*  89 */     return updateParameterObject;
/*     */   }
/*     */   
/*  92 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 3, 12, 91, 91, 91, 91, 3, 3, 3, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  94 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  97 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tax_tax_rate_rule" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rate_rule_seq = ?  AND tax_rule_seq_nbr = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 100 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 106 */     return " WHERE organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rate_rule_seq = ?  AND tax_rule_seq_nbr = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 109 */     return new Object[] { this._organizationId, this._taxGroupId, this._taxLocationId, this._taxRateRuleSequence, this._taxRuleSequence };
/*     */   }
/*     */   
/* 112 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 4, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 115 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 118 */     return "tax_tax_rate_rule";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 122 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 126 */     return new TaxRateRuleFiller(this);
/*     */   }
/*     */   
/*     */   private static class TaxRateRuleFiller
/*     */     implements IFiller {
/*     */     private TaxRateRuleDBA _parent;
/*     */     
/*     */     public TaxRateRuleFiller(TaxRateRuleDBA argParent) {
/* 134 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 139 */       long l = argResultSet.getLong(1);
/* 140 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 141 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 145 */       this._parent._taxGroupId = argResultSet.getString(2);
/* 146 */       this._parent._taxLocationId = argResultSet.getString(3);
/*     */ 
/*     */       
/* 149 */       int primitiveResult = argResultSet.getInt(4);
/* 150 */       if (primitiveResult != 0 || argResultSet.getObject(4) != null) {
/* 151 */         this._parent._taxRateRuleSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 157 */       primitiveResult = argResultSet.getInt(5);
/* 158 */       if (primitiveResult != 0 || argResultSet.getObject(5) != null) {
/* 159 */         this._parent._taxRuleSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 164 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 165 */       if (t6 != null) {
/* 166 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 169 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 172 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 174 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 175 */       if (t8 != null) {
/* 176 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 179 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 182 */       this._parent._updateUserId = argResultSet.getString(9);
/* 183 */       this._parent._orgCode = argResultSet.getString(10);
/* 184 */       this._parent._orgValue = argResultSet.getString(11);
/* 185 */       this._parent._amount = argResultSet.getBigDecimal(12);
/* 186 */       this._parent._breakPointTypeCode = argResultSet.getString(13);
/*     */       
/* 188 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 189 */       if (t14 != null) {
/* 190 */         this._parent._dailyEndTimeDao = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 193 */         this._parent._dailyEndTimeDao = null;
/*     */       } 
/*     */ 
/*     */       
/* 197 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 198 */       if (t15 != null) {
/* 199 */         this._parent._dailyStartTimeDao = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._dailyStartTimeDao = null;
/*     */       } 
/*     */ 
/*     */       
/* 206 */       Timestamp t16 = argResultSet.getTimestamp(16);
/* 207 */       if (t16 != null) {
/* 208 */         this._parent._effectiveDatetimestamp = (Date)new DtvDate(t16.getTime());
/*     */       } else {
/*     */         
/* 211 */         this._parent._effectiveDatetimestamp = null;
/*     */       } 
/*     */ 
/*     */       
/* 215 */       Timestamp t17 = argResultSet.getTimestamp(17);
/* 216 */       if (t17 != null) {
/* 217 */         this._parent._expirationDatetimestamp = (Date)new DtvDate(t17.getTime());
/*     */       } else {
/*     */         
/* 220 */         this._parent._expirationDatetimestamp = null;
/*     */       } 
/*     */       
/* 223 */       this._parent._percent = argResultSet.getBigDecimal(18);
/* 224 */       this._parent._taxRateMaxTaxableAmount = argResultSet.getBigDecimal(19);
/* 225 */       this._parent._taxRateMinTaxableAmount = argResultSet.getBigDecimal(20);
/* 226 */       this._parent._taxBracketId = argResultSet.getString(21);
/* 227 */       this._parent._externalSystem = argResultSet.getString(22);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 232 */     argDAO.suppressStateChanges(true);
/* 233 */     TaxRateRuleDAO dao = (TaxRateRuleDAO)argDAO;
/* 234 */     dao.setOrganizationId(this._organizationId);
/* 235 */     dao.setTaxGroupId(this._taxGroupId);
/* 236 */     dao.setTaxLocationId(this._taxLocationId);
/* 237 */     dao.setTaxRateRuleSequence(this._taxRateRuleSequence);
/* 238 */     dao.setTaxRuleSequence(this._taxRuleSequence);
/* 239 */     dao.setCreateDate(this._createDate);
/* 240 */     dao.setCreateUserId(this._createUserId);
/* 241 */     dao.setUpdateDate(this._updateDate);
/* 242 */     dao.setUpdateUserId(this._updateUserId);
/* 243 */     dao.setOrgCode(this._orgCode);
/* 244 */     dao.setOrgValue(this._orgValue);
/* 245 */     dao.setAmount(this._amount);
/* 246 */     dao.setBreakPointTypeCode(this._breakPointTypeCode);
/* 247 */     dao.setDailyEndTimeDao(this._dailyEndTimeDao);
/* 248 */     dao.setDailyStartTimeDao(this._dailyStartTimeDao);
/* 249 */     dao.setEffectiveDatetimestamp(this._effectiveDatetimestamp);
/* 250 */     dao.setExpirationDatetimestamp(this._expirationDatetimestamp);
/* 251 */     dao.setPercent(this._percent);
/* 252 */     dao.setTaxRateMaxTaxableAmount(this._taxRateMaxTaxableAmount);
/* 253 */     dao.setTaxRateMinTaxableAmount(this._taxRateMinTaxableAmount);
/* 254 */     dao.setTaxBracketId(this._taxBracketId);
/* 255 */     dao.setExternalSystem(this._externalSystem);
/* 256 */     argDAO.suppressStateChanges(false);
/* 257 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 261 */     return loadDAO((IDataAccessObject)new TaxRateRuleDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 265 */     TaxRateRuleDAO dao = (TaxRateRuleDAO)argDAO;
/* 266 */     this._organizationId = dao.getOrganizationId();
/* 267 */     this._taxGroupId = dao.getTaxGroupId();
/* 268 */     this._taxLocationId = dao.getTaxLocationId();
/* 269 */     this._taxRateRuleSequence = dao.getTaxRateRuleSequence();
/* 270 */     this._taxRuleSequence = dao.getTaxRuleSequence();
/* 271 */     this._createDate = dao.getCreateDate();
/* 272 */     this._createUserId = dao.getCreateUserId();
/* 273 */     this._updateDate = dao.getUpdateDate();
/* 274 */     this._updateUserId = dao.getUpdateUserId();
/* 275 */     this._orgCode = dao.getOrgCode();
/* 276 */     this._orgValue = dao.getOrgValue();
/* 277 */     this._amount = dao.getAmount();
/* 278 */     this._breakPointTypeCode = dao.getBreakPointTypeCode();
/* 279 */     this._dailyEndTimeDao = dao.getDailyEndTimeDao();
/* 280 */     this._dailyStartTimeDao = dao.getDailyStartTimeDao();
/* 281 */     this._effectiveDatetimestamp = dao.getEffectiveDatetimestamp();
/* 282 */     this._expirationDatetimestamp = dao.getExpirationDatetimestamp();
/* 283 */     this._percent = dao.getPercent();
/* 284 */     this._taxRateMaxTaxableAmount = dao.getTaxRateMaxTaxableAmount();
/* 285 */     this._taxRateMinTaxableAmount = dao.getTaxRateMinTaxableAmount();
/* 286 */     this._taxBracketId = dao.getTaxBracketId();
/* 287 */     this._externalSystem = dao.getExternalSystem();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 291 */     TaxRateRuleId id = (TaxRateRuleId)argId;
/* 292 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 293 */     argStatement.setString(2, id.getTaxGroupId());
/* 294 */     argStatement.setString(3, id.getTaxLocationId());
/* 295 */     argStatement.setInt(4, id.getTaxRateRuleSequence().intValue());
/* 296 */     argStatement.setInt(5, id.getTaxRuleSequence().intValue());
/* 297 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 301 */     TaxRateRuleId id = new TaxRateRuleId();
/* 302 */     id.setOrganizationId(this._organizationId);
/* 303 */     id.setTaxGroupId(this._taxGroupId);
/* 304 */     id.setTaxLocationId(this._taxLocationId);
/* 305 */     id.setTaxRateRuleSequence(this._taxRateRuleSequence);
/* 306 */     id.setTaxRuleSequence(this._taxRuleSequence);
/* 307 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 315 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 319 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxRateRuleDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */