/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tax.TaxRateRuleOverridePropertyId;
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
/*     */ public class TaxRateRuleOverridePropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1185365880L;
/*     */   private Date _expirationDatetimestamp;
/*     */   private Long _organizationId;
/*     */   private String _taxGroupId;
/*     */   private String _taxLocationId;
/*     */   private Integer _taxRateRuleSequence;
/*     */   private Integer _taxRuleSequence;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.expr_datetime, t.organization_id, t.tax_group_id, t.tax_loc_id, t.tax_rate_rule_seq, t.tax_rule_seq_nbr, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tax_tax_rate_rule_override_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE expr_datetime = ?  AND organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rate_rule_seq = ?  AND tax_rule_seq_nbr = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.expr_datetime, t.organization_id, t.tax_group_id, t.tax_loc_id, t.tax_rate_rule_seq, t.tax_rule_seq_nbr, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM tax_tax_rate_rule_override_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE expr_datetime = ?  AND organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rate_rule_seq = ?  AND tax_rule_seq_nbr = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tax_tax_rate_rule_override_p(expr_datetime, organization_id, tax_group_id, tax_loc_id, tax_rate_rule_seq, tax_rule_seq_nbr, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._expirationDatetimestamp, this._organizationId, this._taxGroupId, this._taxLocationId, this._taxRateRuleSequence, this._taxRuleSequence, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, 12, 12, 4, 4, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tax_tax_rate_rule_override_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tax_tax_rate_rule_override_p" }; private static final String WHERE_OBJECT = " WHERE expr_datetime = ?  AND organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rate_rule_seq = ?  AND tax_rule_seq_nbr = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE expr_datetime = ?  AND organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rate_rule_seq = ?  AND tax_rule_seq_nbr = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._expirationDatetimestamp, this._organizationId, this._taxGroupId, this._taxLocationId, this._taxRateRuleSequence, this._taxRuleSequence, this._propertyCode };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, 12, 12, 4, 4, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "tax_tax_rate_rule_override_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new TaxRateRuleOverridePropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class TaxRateRuleOverridePropertyFiller
/*     */     implements IFiller {
/*     */     private TaxRateRuleOverridePropertyDBA _parent;
/*     */     
/*     */     public TaxRateRuleOverridePropertyFiller(TaxRateRuleOverridePropertyDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 132 */       if (t1 != null) {
/* 133 */         this._parent._expirationDatetimestamp = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 136 */         this._parent._expirationDatetimestamp = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 141 */       long l = argResultSet.getLong(2);
/* 142 */       if (l != 0L || argResultSet.getObject(2) != null) {
/* 143 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 147 */       this._parent._taxGroupId = argResultSet.getString(3);
/* 148 */       this._parent._taxLocationId = argResultSet.getString(4);
/*     */ 
/*     */       
/* 151 */       int primitiveResult = argResultSet.getInt(5);
/* 152 */       if (primitiveResult != 0 || argResultSet.getObject(5) != null) {
/* 153 */         this._parent._taxRateRuleSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 159 */       primitiveResult = argResultSet.getInt(6);
/* 160 */       if (primitiveResult != 0 || argResultSet.getObject(6) != null) {
/* 161 */         this._parent._taxRuleSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 165 */       this._parent._propertyCode = argResultSet.getString(7);
/* 166 */       this._parent._type = argResultSet.getString(8);
/* 167 */       this._parent._stringValue = argResultSet.getString(9);
/*     */       
/* 169 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 170 */       if (t10 != null) {
/* 171 */         this._parent._dateValue = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 174 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 177 */       this._parent._decimalValue = argResultSet.getBigDecimal(11);
/*     */       
/* 179 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 180 */       if (t12 != null) {
/* 181 */         this._parent._createDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 184 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 187 */       this._parent._createUserId = argResultSet.getString(13);
/*     */       
/* 189 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 190 */       if (t14 != null) {
/* 191 */         this._parent._updateDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 194 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 197 */       this._parent._updateUserId = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 202 */     argDAO.suppressStateChanges(true);
/* 203 */     TaxRateRuleOverridePropertyDAO dao = (TaxRateRuleOverridePropertyDAO)argDAO;
/* 204 */     dao.setExpirationDatetimestamp(this._expirationDatetimestamp);
/* 205 */     dao.setOrganizationId(this._organizationId);
/* 206 */     dao.setTaxGroupId(this._taxGroupId);
/* 207 */     dao.setTaxLocationId(this._taxLocationId);
/* 208 */     dao.setTaxRateRuleSequence(this._taxRateRuleSequence);
/* 209 */     dao.setTaxRuleSequence(this._taxRuleSequence);
/* 210 */     dao.setPropertyCode(this._propertyCode);
/* 211 */     dao.setType(this._type);
/* 212 */     dao.setStringValue(this._stringValue);
/* 213 */     dao.setDateValue(this._dateValue);
/* 214 */     dao.setDecimalValue(this._decimalValue);
/* 215 */     dao.setCreateDate(this._createDate);
/* 216 */     dao.setCreateUserId(this._createUserId);
/* 217 */     dao.setUpdateDate(this._updateDate);
/* 218 */     dao.setUpdateUserId(this._updateUserId);
/* 219 */     argDAO.suppressStateChanges(false);
/* 220 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 224 */     return loadDAO((IDataAccessObject)new TaxRateRuleOverridePropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 228 */     TaxRateRuleOverridePropertyDAO dao = (TaxRateRuleOverridePropertyDAO)argDAO;
/* 229 */     this._expirationDatetimestamp = dao.getExpirationDatetimestamp();
/* 230 */     this._organizationId = dao.getOrganizationId();
/* 231 */     this._taxGroupId = dao.getTaxGroupId();
/* 232 */     this._taxLocationId = dao.getTaxLocationId();
/* 233 */     this._taxRateRuleSequence = dao.getTaxRateRuleSequence();
/* 234 */     this._taxRuleSequence = dao.getTaxRuleSequence();
/* 235 */     this._propertyCode = dao.getPropertyCode();
/* 236 */     this._type = dao.getType();
/* 237 */     this._stringValue = dao.getStringValue();
/* 238 */     this._dateValue = dao.getDateValue();
/* 239 */     this._decimalValue = dao.getDecimalValue();
/* 240 */     this._createDate = dao.getCreateDate();
/* 241 */     this._createUserId = dao.getCreateUserId();
/* 242 */     this._updateDate = dao.getUpdateDate();
/* 243 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 247 */     TaxRateRuleOverridePropertyId id = (TaxRateRuleOverridePropertyId)argId;
/* 248 */     argStatement.setTimestamp(1, new Timestamp(id.getExpirationDatetimestamp().getTime()));
/* 249 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 250 */     argStatement.setString(3, id.getTaxGroupId());
/* 251 */     argStatement.setString(4, id.getTaxLocationId());
/* 252 */     argStatement.setInt(5, id.getTaxRateRuleSequence().intValue());
/* 253 */     argStatement.setInt(6, id.getTaxRuleSequence().intValue());
/* 254 */     argStatement.setString(7, id.getPropertyCode());
/* 255 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 259 */     TaxRateRuleOverridePropertyId id = new TaxRateRuleOverridePropertyId();
/* 260 */     id.setExpirationDatetimestamp(this._expirationDatetimestamp);
/* 261 */     id.setOrganizationId(this._organizationId);
/* 262 */     id.setTaxGroupId(this._taxGroupId);
/* 263 */     id.setTaxLocationId(this._taxLocationId);
/* 264 */     id.setTaxRateRuleSequence(this._taxRateRuleSequence);
/* 265 */     id.setTaxRuleSequence(this._taxRuleSequence);
/* 266 */     id.setPropertyCode(this._propertyCode);
/* 267 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 275 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 279 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxRateRuleOverridePropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */