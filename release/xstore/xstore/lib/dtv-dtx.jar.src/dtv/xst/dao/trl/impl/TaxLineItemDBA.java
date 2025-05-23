/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemId;
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
/*     */ public class TaxLineItemDBA
/*     */   extends RetailTransactionLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 899773906L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _taxAmount;
/*     */   private BigDecimal _taxPercentage;
/*     */   private BigDecimal _rawTaxAmount;
/*     */   private BigDecimal _rawTaxPercentage;
/*     */   private BigDecimal _taxOverrideAmount;
/*     */   private Boolean _taxOverride;
/*     */   private BigDecimal _taxOverridePercentage;
/*     */   private String _taxOverrideReasonCode;
/*     */   private BigDecimal _taxableAmount;
/*     */   private String _taxGroupId;
/*     */   private String _taxLocationId;
/*     */   private Integer _taxRuleSequence;
/*     */   private String _authorityId;
/*     */   private String _authorityName;
/*     */   private String _authorityTypeCode;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.tax_amt, t.tax_percentage, t.raw_tax_amount, t.raw_tax_percentage, t.tax_override_amt, t.tax_override_flag, t.tax_override_percentage, t.tax_override_reascode, t.taxable_amt, t.tax_group_id, t.tax_loc_id, t.tax_rule_seq_nbr, t.authority_id, t.authority_name, t.authority_type_code FROM trl_tax_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  55 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  59 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.tax_amt, t.tax_percentage, t.raw_tax_amount, t.raw_tax_percentage, t.tax_override_amt, t.tax_override_flag, t.tax_override_percentage, t.tax_override_reascode, t.taxable_amt, t.tax_group_id, t.tax_loc_id, t.tax_rule_seq_nbr, t.authority_id, t.authority_name, t.authority_type_code FROM trl_tax_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  66 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  69 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_tax_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, tax_amt, tax_percentage, raw_tax_amount, raw_tax_percentage, tax_override_amt, tax_override_flag, tax_override_percentage, tax_override_reascode, taxable_amt, tax_group_id, tax_loc_id, tax_rule_seq_nbr, authority_id, authority_name, authority_type_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  73 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  78 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._taxAmount, this._taxPercentage, this._rawTaxAmount, this._rawTaxPercentage, this._taxOverrideAmount, this._taxOverride, this._taxOverridePercentage, this._taxOverrideReasonCode, this._taxableAmount, this._taxGroupId, this._taxLocationId, this._taxRuleSequence, this._authorityId, this._authorityName, this._authorityTypeCode } };
/*  79 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  82 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 3, 3, 3, 3, 3, -7, 3, 12, 3, 12, 12, 4, 12, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  86 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  89 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_tax_lineitm SET update_date = ?, update_user_id = ?, tax_amt = ?, tax_percentage = ?, raw_tax_amount = ?, raw_tax_percentage = ?, tax_override_amt = ?, tax_override_flag = ?, tax_override_percentage = ?, tax_override_reascode = ?, taxable_amt = ?, tax_group_id = ?, tax_loc_id = ?, tax_rule_seq_nbr = ?, authority_id = ?, authority_name = ?, authority_type_code = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  93 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  98 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._taxAmount, this._taxPercentage, this._rawTaxAmount, this._rawTaxPercentage, this._taxOverrideAmount, this._taxOverride, this._taxOverridePercentage, this._taxOverrideReasonCode, this._taxableAmount, this._taxGroupId, this._taxLocationId, this._taxRuleSequence, this._authorityId, this._authorityName, this._authorityTypeCode } };
/*  99 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/* 102 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 3, 3, 3, 3, -7, 3, 12, 3, 12, 12, 4, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/* 105 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 108 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_tax_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 112 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 119 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 123 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 126 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 130 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 134 */     return "trl_tax_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 139 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 143 */     return new TaxLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class TaxLineItemFiller
/*     */     implements IFiller {
/*     */     private TaxLineItemDBA _parent;
/*     */     
/*     */     public TaxLineItemFiller(TaxLineItemDBA argParent) {
/* 151 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 156 */       long primitiveResult = argResultSet.getLong(1);
/* 157 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 158 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 164 */       primitiveResult = argResultSet.getLong(2);
/* 165 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 166 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 171 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 172 */       if (t3 != null) {
/* 173 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 176 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 181 */       long l1 = argResultSet.getLong(4);
/* 182 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 183 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 189 */       l1 = argResultSet.getLong(5);
/* 190 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 191 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 197 */       int i = argResultSet.getInt(6);
/* 198 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 199 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 204 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 205 */       if (t7 != null) {
/* 206 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 209 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 212 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 214 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 215 */       if (t9 != null) {
/* 216 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 219 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 222 */       this._parent._updateUserId = argResultSet.getString(10);
/* 223 */       this._parent._taxAmount = argResultSet.getBigDecimal(11);
/* 224 */       this._parent._taxPercentage = argResultSet.getBigDecimal(12);
/* 225 */       this._parent._rawTaxAmount = argResultSet.getBigDecimal(13);
/* 226 */       this._parent._rawTaxPercentage = argResultSet.getBigDecimal(14);
/* 227 */       this._parent._taxOverrideAmount = argResultSet.getBigDecimal(15);
/* 228 */       this._parent._taxOverride = Boolean.valueOf(argResultSet.getBoolean(16));
/* 229 */       this._parent._taxOverridePercentage = argResultSet.getBigDecimal(17);
/* 230 */       this._parent._taxOverrideReasonCode = argResultSet.getString(18);
/* 231 */       this._parent._taxableAmount = argResultSet.getBigDecimal(19);
/* 232 */       this._parent._taxGroupId = argResultSet.getString(20);
/* 233 */       this._parent._taxLocationId = argResultSet.getString(21);
/*     */ 
/*     */       
/* 236 */       int j = argResultSet.getInt(22);
/* 237 */       if (j != 0 || argResultSet.getObject(22) != null) {
/* 238 */         this._parent._taxRuleSequence = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */       
/* 242 */       this._parent._authorityId = argResultSet.getString(23);
/* 243 */       this._parent._authorityName = argResultSet.getString(24);
/* 244 */       this._parent._authorityTypeCode = argResultSet.getString(25);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 250 */     super.loadDAO(argDAO);
/* 251 */     argDAO.suppressStateChanges(true);
/* 252 */     TaxLineItemDAO dao = (TaxLineItemDAO)argDAO;
/* 253 */     dao.setOrganizationId(this._organizationId);
/* 254 */     dao.setRetailLocationId(this._retailLocationId);
/* 255 */     dao.setBusinessDate(this._businessDate);
/* 256 */     dao.setWorkstationId(this._workstationId);
/* 257 */     dao.setTransactionSequence(this._transactionSequence);
/* 258 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 259 */     dao.setCreateDate(this._createDate);
/* 260 */     dao.setCreateUserId(this._createUserId);
/* 261 */     dao.setUpdateDate(this._updateDate);
/* 262 */     dao.setUpdateUserId(this._updateUserId);
/* 263 */     dao.setTaxAmount(this._taxAmount);
/* 264 */     dao.setTaxPercentage(this._taxPercentage);
/* 265 */     dao.setRawTaxAmount(this._rawTaxAmount);
/* 266 */     dao.setRawTaxPercentage(this._rawTaxPercentage);
/* 267 */     dao.setTaxOverrideAmount(this._taxOverrideAmount);
/* 268 */     dao.setTaxOverride(this._taxOverride);
/* 269 */     dao.setTaxOverridePercentage(this._taxOverridePercentage);
/* 270 */     dao.setTaxOverrideReasonCode(this._taxOverrideReasonCode);
/* 271 */     dao.setTaxableAmount(this._taxableAmount);
/* 272 */     dao.setTaxGroupId(this._taxGroupId);
/* 273 */     dao.setTaxLocationId(this._taxLocationId);
/* 274 */     dao.setTaxRuleSequence(this._taxRuleSequence);
/* 275 */     dao.setAuthorityId(this._authorityId);
/* 276 */     dao.setAuthorityName(this._authorityName);
/* 277 */     dao.setAuthorityTypeCode(this._authorityTypeCode);
/* 278 */     argDAO.suppressStateChanges(false);
/* 279 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 284 */     return loadDAO((IDataAccessObject)new TaxLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 289 */     TaxLineItemDAO dao = (TaxLineItemDAO)argDAO;
/* 290 */     super.fill((IDataAccessObject)dao);
/* 291 */     this._organizationId = dao.getOrganizationId();
/* 292 */     this._retailLocationId = dao.getRetailLocationId();
/* 293 */     this._businessDate = dao.getBusinessDate();
/* 294 */     this._workstationId = dao.getWorkstationId();
/* 295 */     this._transactionSequence = dao.getTransactionSequence();
/* 296 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 297 */     this._createDate = dao.getCreateDate();
/* 298 */     this._createUserId = dao.getCreateUserId();
/* 299 */     this._updateDate = dao.getUpdateDate();
/* 300 */     this._updateUserId = dao.getUpdateUserId();
/* 301 */     this._taxAmount = dao.getTaxAmount();
/* 302 */     this._taxPercentage = dao.getTaxPercentage();
/* 303 */     this._rawTaxAmount = dao.getRawTaxAmount();
/* 304 */     this._rawTaxPercentage = dao.getRawTaxPercentage();
/* 305 */     this._taxOverrideAmount = dao.getTaxOverrideAmount();
/* 306 */     this._taxOverride = (dao.getTaxOverride() != null) ? dao.getTaxOverride() : Boolean.valueOf(false);
/* 307 */     this._taxOverridePercentage = dao.getTaxOverridePercentage();
/* 308 */     this._taxOverrideReasonCode = dao.getTaxOverrideReasonCode();
/* 309 */     this._taxableAmount = dao.getTaxableAmount();
/* 310 */     this._taxGroupId = dao.getTaxGroupId();
/* 311 */     this._taxLocationId = dao.getTaxLocationId();
/* 312 */     this._taxRuleSequence = dao.getTaxRuleSequence();
/* 313 */     this._authorityId = dao.getAuthorityId();
/* 314 */     this._authorityName = dao.getAuthorityName();
/* 315 */     this._authorityTypeCode = dao.getAuthorityTypeCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 320 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 321 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 322 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 323 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 324 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 325 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 326 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 327 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 331 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 335 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\TaxLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */