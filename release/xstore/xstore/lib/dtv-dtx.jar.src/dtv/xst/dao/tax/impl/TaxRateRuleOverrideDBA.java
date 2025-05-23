/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.tax.TaxRateRuleOverrideId;
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
/*     */ public class TaxRateRuleOverrideDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1162493549L;
/*     */   private Date _expirationDatetimestamp;
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
/*     */   private BigDecimal _percent;
/*     */   private BigDecimal _taxRateMaxTaxableAmount;
/*     */   private BigDecimal _taxRateMinTaxableAmount;
/*     */   private String _taxBracketId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.expr_datetime, t.organization_id, t.tax_group_id, t.tax_loc_id, t.tax_rate_rule_seq, t.tax_rule_seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.amt, t.breakpoint_typcode, t.daily_end_time, t.daily_start_time, t.effective_datetime, t.percentage, t.tax_rate_max_taxable_amt, t.tax_rate_min_taxable_amt, t.tax_bracket_id FROM tax_tax_rate_rule_override t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE expr_datetime = ?  AND organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rate_rule_seq = ?  AND tax_rule_seq_nbr = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  50 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  54 */     return "SELECT t.expr_datetime, t.organization_id, t.tax_group_id, t.tax_loc_id, t.tax_rate_rule_seq, t.tax_rule_seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.amt, t.breakpoint_typcode, t.daily_end_time, t.daily_start_time, t.effective_datetime, t.percentage, t.tax_rate_max_taxable_amt, t.tax_rate_min_taxable_amt, t.tax_bracket_id FROM tax_tax_rate_rule_override t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  60 */     return " WHERE expr_datetime = ?  AND organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rate_rule_seq = ?  AND tax_rule_seq_nbr = ?  ";
/*     */   }
/*     */   
/*  63 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tax_tax_rate_rule_override(expr_datetime, organization_id, tax_group_id, tax_loc_id, tax_rate_rule_seq, tax_rule_seq_nbr, create_date, create_user_id, update_date, update_user_id, org_code, org_value, amt, breakpoint_typcode, daily_end_time, daily_start_time, effective_datetime, percentage, tax_rate_max_taxable_amt, tax_rate_min_taxable_amt, tax_bracket_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  66 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  70 */     Object[][] insertParameterObject = { { this._expirationDatetimestamp, this._organizationId, this._taxGroupId, this._taxLocationId, this._taxRateRuleSequence, this._taxRuleSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._amount, this._breakPointTypeCode, this._dailyEndTimeDao, this._dailyStartTimeDao, this._effectiveDatetimestamp, this._percent, this._taxRateMaxTaxableAmount, this._taxRateMinTaxableAmount, this._taxBracketId } };
/*  71 */     return insertParameterObject;
/*     */   }
/*     */   
/*  74 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, 12, 12, 4, 4, 91, 12, 91, 12, 12, 12, 3, 12, 91, 91, 91, 3, 3, 3, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  77 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  80 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tax_tax_rate_rule_override SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, amt = ?, breakpoint_typcode = ?, daily_end_time = ?, daily_start_time = ?, effective_datetime = ?, percentage = ?, tax_rate_max_taxable_amt = ?, tax_rate_min_taxable_amt = ?, tax_bracket_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  83 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  87 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._amount, this._breakPointTypeCode, this._dailyEndTimeDao, this._dailyStartTimeDao, this._effectiveDatetimestamp, this._percent, this._taxRateMaxTaxableAmount, this._taxRateMinTaxableAmount, this._taxBracketId } };
/*  88 */     return updateParameterObject;
/*     */   }
/*     */   
/*  91 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 3, 12, 91, 91, 91, 3, 3, 3, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  93 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  96 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tax_tax_rate_rule_override" }; private static final String WHERE_OBJECT = " WHERE expr_datetime = ?  AND organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rate_rule_seq = ?  AND tax_rule_seq_nbr = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  99 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 105 */     return " WHERE expr_datetime = ?  AND organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rate_rule_seq = ?  AND tax_rule_seq_nbr = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 108 */     return new Object[] { this._expirationDatetimestamp, this._organizationId, this._taxGroupId, this._taxLocationId, this._taxRateRuleSequence, this._taxRuleSequence };
/*     */   }
/*     */   
/* 111 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, 12, 12, 4, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 114 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 117 */     return "tax_tax_rate_rule_override";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 121 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 125 */     return new TaxRateRuleOverrideFiller(this);
/*     */   }
/*     */   
/*     */   private static class TaxRateRuleOverrideFiller
/*     */     implements IFiller {
/*     */     private TaxRateRuleOverrideDBA _parent;
/*     */     
/*     */     public TaxRateRuleOverrideFiller(TaxRateRuleOverrideDBA argParent) {
/* 133 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 137 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 138 */       if (t1 != null) {
/* 139 */         this._parent._expirationDatetimestamp = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 142 */         this._parent._expirationDatetimestamp = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 147 */       long l = argResultSet.getLong(2);
/* 148 */       if (l != 0L || argResultSet.getObject(2) != null) {
/* 149 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 153 */       this._parent._taxGroupId = argResultSet.getString(3);
/* 154 */       this._parent._taxLocationId = argResultSet.getString(4);
/*     */ 
/*     */       
/* 157 */       int primitiveResult = argResultSet.getInt(5);
/* 158 */       if (primitiveResult != 0 || argResultSet.getObject(5) != null) {
/* 159 */         this._parent._taxRateRuleSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 165 */       primitiveResult = argResultSet.getInt(6);
/* 166 */       if (primitiveResult != 0 || argResultSet.getObject(6) != null) {
/* 167 */         this._parent._taxRuleSequence = Integer.valueOf(primitiveResult);
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
/* 191 */       this._parent._orgCode = argResultSet.getString(11);
/* 192 */       this._parent._orgValue = argResultSet.getString(12);
/* 193 */       this._parent._amount = argResultSet.getBigDecimal(13);
/* 194 */       this._parent._breakPointTypeCode = argResultSet.getString(14);
/*     */       
/* 196 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 197 */       if (t15 != null) {
/* 198 */         this._parent._dailyEndTimeDao = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 201 */         this._parent._dailyEndTimeDao = null;
/*     */       } 
/*     */ 
/*     */       
/* 205 */       Timestamp t16 = argResultSet.getTimestamp(16);
/* 206 */       if (t16 != null) {
/* 207 */         this._parent._dailyStartTimeDao = (Date)new DtvDate(t16.getTime());
/*     */       } else {
/*     */         
/* 210 */         this._parent._dailyStartTimeDao = null;
/*     */       } 
/*     */ 
/*     */       
/* 214 */       Timestamp t17 = argResultSet.getTimestamp(17);
/* 215 */       if (t17 != null) {
/* 216 */         this._parent._effectiveDatetimestamp = (Date)new DtvDate(t17.getTime());
/*     */       } else {
/*     */         
/* 219 */         this._parent._effectiveDatetimestamp = null;
/*     */       } 
/*     */       
/* 222 */       this._parent._percent = argResultSet.getBigDecimal(18);
/* 223 */       this._parent._taxRateMaxTaxableAmount = argResultSet.getBigDecimal(19);
/* 224 */       this._parent._taxRateMinTaxableAmount = argResultSet.getBigDecimal(20);
/* 225 */       this._parent._taxBracketId = argResultSet.getString(21);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 230 */     argDAO.suppressStateChanges(true);
/* 231 */     TaxRateRuleOverrideDAO dao = (TaxRateRuleOverrideDAO)argDAO;
/* 232 */     dao.setExpirationDatetimestamp(this._expirationDatetimestamp);
/* 233 */     dao.setOrganizationId(this._organizationId);
/* 234 */     dao.setTaxGroupId(this._taxGroupId);
/* 235 */     dao.setTaxLocationId(this._taxLocationId);
/* 236 */     dao.setTaxRateRuleSequence(this._taxRateRuleSequence);
/* 237 */     dao.setTaxRuleSequence(this._taxRuleSequence);
/* 238 */     dao.setCreateDate(this._createDate);
/* 239 */     dao.setCreateUserId(this._createUserId);
/* 240 */     dao.setUpdateDate(this._updateDate);
/* 241 */     dao.setUpdateUserId(this._updateUserId);
/* 242 */     dao.setOrgCode(this._orgCode);
/* 243 */     dao.setOrgValue(this._orgValue);
/* 244 */     dao.setAmount(this._amount);
/* 245 */     dao.setBreakPointTypeCode(this._breakPointTypeCode);
/* 246 */     dao.setDailyEndTimeDao(this._dailyEndTimeDao);
/* 247 */     dao.setDailyStartTimeDao(this._dailyStartTimeDao);
/* 248 */     dao.setEffectiveDatetimestamp(this._effectiveDatetimestamp);
/* 249 */     dao.setPercent(this._percent);
/* 250 */     dao.setTaxRateMaxTaxableAmount(this._taxRateMaxTaxableAmount);
/* 251 */     dao.setTaxRateMinTaxableAmount(this._taxRateMinTaxableAmount);
/* 252 */     dao.setTaxBracketId(this._taxBracketId);
/* 253 */     argDAO.suppressStateChanges(false);
/* 254 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 258 */     return loadDAO((IDataAccessObject)new TaxRateRuleOverrideDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 262 */     TaxRateRuleOverrideDAO dao = (TaxRateRuleOverrideDAO)argDAO;
/* 263 */     this._expirationDatetimestamp = dao.getExpirationDatetimestamp();
/* 264 */     this._organizationId = dao.getOrganizationId();
/* 265 */     this._taxGroupId = dao.getTaxGroupId();
/* 266 */     this._taxLocationId = dao.getTaxLocationId();
/* 267 */     this._taxRateRuleSequence = dao.getTaxRateRuleSequence();
/* 268 */     this._taxRuleSequence = dao.getTaxRuleSequence();
/* 269 */     this._createDate = dao.getCreateDate();
/* 270 */     this._createUserId = dao.getCreateUserId();
/* 271 */     this._updateDate = dao.getUpdateDate();
/* 272 */     this._updateUserId = dao.getUpdateUserId();
/* 273 */     this._orgCode = dao.getOrgCode();
/* 274 */     this._orgValue = dao.getOrgValue();
/* 275 */     this._amount = dao.getAmount();
/* 276 */     this._breakPointTypeCode = dao.getBreakPointTypeCode();
/* 277 */     this._dailyEndTimeDao = dao.getDailyEndTimeDao();
/* 278 */     this._dailyStartTimeDao = dao.getDailyStartTimeDao();
/* 279 */     this._effectiveDatetimestamp = dao.getEffectiveDatetimestamp();
/* 280 */     this._percent = dao.getPercent();
/* 281 */     this._taxRateMaxTaxableAmount = dao.getTaxRateMaxTaxableAmount();
/* 282 */     this._taxRateMinTaxableAmount = dao.getTaxRateMinTaxableAmount();
/* 283 */     this._taxBracketId = dao.getTaxBracketId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 287 */     TaxRateRuleOverrideId id = (TaxRateRuleOverrideId)argId;
/* 288 */     argStatement.setTimestamp(1, new Timestamp(id.getExpirationDatetimestamp().getTime()));
/* 289 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 290 */     argStatement.setString(3, id.getTaxGroupId());
/* 291 */     argStatement.setString(4, id.getTaxLocationId());
/* 292 */     argStatement.setInt(5, id.getTaxRateRuleSequence().intValue());
/* 293 */     argStatement.setInt(6, id.getTaxRuleSequence().intValue());
/* 294 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 298 */     TaxRateRuleOverrideId id = new TaxRateRuleOverrideId();
/* 299 */     id.setExpirationDatetimestamp(this._expirationDatetimestamp);
/* 300 */     id.setOrganizationId(this._organizationId);
/* 301 */     id.setTaxGroupId(this._taxGroupId);
/* 302 */     id.setTaxLocationId(this._taxLocationId);
/* 303 */     id.setTaxRateRuleSequence(this._taxRateRuleSequence);
/* 304 */     id.setTaxRuleSequence(this._taxRuleSequence);
/* 305 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 313 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 317 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxRateRuleOverrideDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */