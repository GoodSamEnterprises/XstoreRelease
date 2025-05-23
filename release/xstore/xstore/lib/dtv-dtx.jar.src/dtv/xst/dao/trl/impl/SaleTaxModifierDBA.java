/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.SaleTaxModifierId;
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
/*     */ public class SaleTaxModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 698796219L;
/*     */   private Date _businessDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Integer _saleTaxModifierSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _taxAmount;
/*     */   private BigDecimal _taxPercentage;
/*     */   private BigDecimal _rawTaxAmount;
/*     */   private BigDecimal _rawTaxPercentage;
/*     */   private BigDecimal _exemptTaxAmount;
/*     */   private BigDecimal _taxExemptAmount;
/*     */   private String _taxExemptionId;
/*     */   private BigDecimal _taxOverrideAmount;
/*     */   private Boolean _taxOverride;
/*     */   private BigDecimal _taxOverridePercentage;
/*     */   private String _taxOverrideReasonCode;
/*     */   private String _taxOverrideComment;
/*     */   private BigDecimal _taxableAmount;
/*     */   private Boolean _void;
/*     */   private String _taxGroupId;
/*     */   private String _taxLocationId;
/*     */   private Integer _taxRuleSequence;
/*     */   private String _authorityId;
/*     */   private String _authorityName;
/*     */   private String _authorityTypeCode;
/*     */   private String _taxOverrideBracket;
/*     */   private BigDecimal _origTaxableAmount;
/*     */   private String _origTaxGroupId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.sale_tax_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.tax_amt, t.tax_percentage, t.raw_tax_amount, t.raw_tax_percentage, t.exempt_tax_amount, t.tax_exempt_amt, t.tax_exemption_id, t.tax_override_amt, t.tax_override_flag, t.tax_override_percentage, t.tax_override_reascode, t.tax_override_comment, t.taxable_amt, t.void_flag, t.tax_group_id, t.tax_loc_id, t.tax_rule_seq_nbr, t.authority_id, t.authority_name, t.authority_type_code, t.tax_override_bracket_id, t.orig_taxable_amount, t.orig_tax_group_id FROM trl_sale_tax_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND sale_tax_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  63 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  67 */     return "SELECT t.business_date, t.organization_id, t.rtl_loc_id, t.rtrans_lineitm_seq, t.sale_tax_lineitm_seq, t.trans_seq, t.wkstn_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.tax_amt, t.tax_percentage, t.raw_tax_amount, t.raw_tax_percentage, t.exempt_tax_amount, t.tax_exempt_amt, t.tax_exemption_id, t.tax_override_amt, t.tax_override_flag, t.tax_override_percentage, t.tax_override_reascode, t.tax_override_comment, t.taxable_amt, t.void_flag, t.tax_group_id, t.tax_loc_id, t.tax_rule_seq_nbr, t.authority_id, t.authority_name, t.authority_type_code, t.tax_override_bracket_id, t.orig_taxable_amount, t.orig_tax_group_id FROM trl_sale_tax_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  73 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND sale_tax_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   
/*  76 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_sale_tax_lineitm(business_date, organization_id, rtl_loc_id, rtrans_lineitm_seq, sale_tax_lineitm_seq, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, tax_amt, tax_percentage, raw_tax_amount, raw_tax_percentage, exempt_tax_amount, tax_exempt_amt, tax_exemption_id, tax_override_amt, tax_override_flag, tax_override_percentage, tax_override_reascode, tax_override_comment, taxable_amt, void_flag, tax_group_id, tax_loc_id, tax_rule_seq_nbr, authority_id, authority_name, authority_type_code, tax_override_bracket_id, orig_taxable_amount, orig_tax_group_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  79 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  83 */     Object[][] insertParameterObject = { { this._businessDate, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._saleTaxModifierSequence, this._transactionSequence, this._workstationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._taxAmount, this._taxPercentage, this._rawTaxAmount, this._rawTaxPercentage, this._exemptTaxAmount, this._taxExemptAmount, this._taxExemptionId, this._taxOverrideAmount, this._taxOverride, this._taxOverridePercentage, this._taxOverrideReasonCode, this._taxOverrideComment, this._taxableAmount, this._void, this._taxGroupId, this._taxLocationId, this._taxRuleSequence, this._authorityId, this._authorityName, this._authorityTypeCode, this._taxOverrideBracket, this._origTaxableAmount, this._origTaxGroupId } };
/*  84 */     return insertParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, -5, -5, 4, 4, -5, -5, 91, 12, 91, 12, 3, 3, 3, 3, 3, 3, 12, 3, -7, 3, 12, 12, 3, -7, 12, 12, 4, 12, 12, 12, 12, 3, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  90 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  93 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_sale_tax_lineitm SET update_date = ?, update_user_id = ?, tax_amt = ?, tax_percentage = ?, raw_tax_amount = ?, raw_tax_percentage = ?, exempt_tax_amount = ?, tax_exempt_amt = ?, tax_exemption_id = ?, tax_override_amt = ?, tax_override_flag = ?, tax_override_percentage = ?, tax_override_reascode = ?, tax_override_comment = ?, taxable_amt = ?, void_flag = ?, tax_group_id = ?, tax_loc_id = ?, tax_rule_seq_nbr = ?, authority_id = ?, authority_name = ?, authority_type_code = ?, tax_override_bracket_id = ?, orig_taxable_amount = ?, orig_tax_group_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  96 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 100 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._taxAmount, this._taxPercentage, this._rawTaxAmount, this._rawTaxPercentage, this._exemptTaxAmount, this._taxExemptAmount, this._taxExemptionId, this._taxOverrideAmount, this._taxOverride, this._taxOverridePercentage, this._taxOverrideReasonCode, this._taxOverrideComment, this._taxableAmount, this._void, this._taxGroupId, this._taxLocationId, this._taxRuleSequence, this._authorityId, this._authorityName, this._authorityTypeCode, this._taxOverrideBracket, this._origTaxableAmount, this._origTaxGroupId } };
/* 101 */     return updateParameterObject;
/*     */   }
/*     */   
/* 104 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 3, 3, 3, 3, 3, 12, 3, -7, 3, 12, 12, 3, -7, 12, 12, 4, 12, 12, 12, 12, 3, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 106 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 109 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_sale_tax_lineitm" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND sale_tax_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 112 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 118 */     return " WHERE business_date = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND rtrans_lineitm_seq = ?  AND sale_tax_lineitm_seq = ?  AND trans_seq = ?  AND wkstn_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 121 */     return new Object[] { this._businessDate, this._organizationId, this._retailLocationId, this._retailTransactionLineItemSequence, this._saleTaxModifierSequence, this._transactionSequence, this._workstationId };
/*     */   }
/*     */   
/* 124 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, -5, -5, 4, 4, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 127 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 130 */     return "trl_sale_tax_lineitm";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 134 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 138 */     return new SaleTaxModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class SaleTaxModifierFiller
/*     */     implements IFiller {
/*     */     private SaleTaxModifierDBA _parent;
/*     */     
/*     */     public SaleTaxModifierFiller(SaleTaxModifierDBA argParent) {
/* 146 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 150 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 151 */       if (t1 != null) {
/* 152 */         this._parent._businessDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 155 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 160 */       long l1 = argResultSet.getLong(2);
/* 161 */       if (l1 != 0L || argResultSet.getObject(2) != null) {
/* 162 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 168 */       l1 = argResultSet.getLong(3);
/* 169 */       if (l1 != 0L || argResultSet.getObject(3) != null) {
/* 170 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 176 */       int i = argResultSet.getInt(4);
/* 177 */       if (i != 0 || argResultSet.getObject(4) != null) {
/* 178 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 184 */       i = argResultSet.getInt(5);
/* 185 */       if (i != 0 || argResultSet.getObject(5) != null) {
/* 186 */         this._parent._saleTaxModifierSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 192 */       long primitiveResult = argResultSet.getLong(6);
/* 193 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 194 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 200 */       primitiveResult = argResultSet.getLong(7);
/* 201 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 202 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 207 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 208 */       if (t8 != null) {
/* 209 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 212 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 215 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 217 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 218 */       if (t10 != null) {
/* 219 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 222 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 225 */       this._parent._updateUserId = argResultSet.getString(11);
/* 226 */       this._parent._taxAmount = argResultSet.getBigDecimal(12);
/* 227 */       this._parent._taxPercentage = argResultSet.getBigDecimal(13);
/* 228 */       this._parent._rawTaxAmount = argResultSet.getBigDecimal(14);
/* 229 */       this._parent._rawTaxPercentage = argResultSet.getBigDecimal(15);
/* 230 */       this._parent._exemptTaxAmount = argResultSet.getBigDecimal(16);
/* 231 */       this._parent._taxExemptAmount = argResultSet.getBigDecimal(17);
/* 232 */       this._parent._taxExemptionId = argResultSet.getString(18);
/* 233 */       this._parent._taxOverrideAmount = argResultSet.getBigDecimal(19);
/* 234 */       this._parent._taxOverride = Boolean.valueOf(argResultSet.getBoolean(20));
/* 235 */       this._parent._taxOverridePercentage = argResultSet.getBigDecimal(21);
/* 236 */       this._parent._taxOverrideReasonCode = argResultSet.getString(22);
/* 237 */       this._parent._taxOverrideComment = argResultSet.getString(23);
/* 238 */       this._parent._taxableAmount = argResultSet.getBigDecimal(24);
/* 239 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(25));
/* 240 */       this._parent._taxGroupId = argResultSet.getString(26);
/* 241 */       this._parent._taxLocationId = argResultSet.getString(27);
/*     */ 
/*     */       
/* 244 */       int j = argResultSet.getInt(28);
/* 245 */       if (j != 0 || argResultSet.getObject(28) != null) {
/* 246 */         this._parent._taxRuleSequence = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */       
/* 250 */       this._parent._authorityId = argResultSet.getString(29);
/* 251 */       this._parent._authorityName = argResultSet.getString(30);
/* 252 */       this._parent._authorityTypeCode = argResultSet.getString(31);
/* 253 */       this._parent._taxOverrideBracket = argResultSet.getString(32);
/* 254 */       this._parent._origTaxableAmount = argResultSet.getBigDecimal(33);
/* 255 */       this._parent._origTaxGroupId = argResultSet.getString(34);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 260 */     argDAO.suppressStateChanges(true);
/* 261 */     SaleTaxModifierDAO dao = (SaleTaxModifierDAO)argDAO;
/* 262 */     dao.setBusinessDate(this._businessDate);
/* 263 */     dao.setOrganizationId(this._organizationId);
/* 264 */     dao.setRetailLocationId(this._retailLocationId);
/* 265 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 266 */     dao.setSaleTaxModifierSequence(this._saleTaxModifierSequence);
/* 267 */     dao.setTransactionSequence(this._transactionSequence);
/* 268 */     dao.setWorkstationId(this._workstationId);
/* 269 */     dao.setCreateDate(this._createDate);
/* 270 */     dao.setCreateUserId(this._createUserId);
/* 271 */     dao.setUpdateDate(this._updateDate);
/* 272 */     dao.setUpdateUserId(this._updateUserId);
/* 273 */     dao.setTaxAmount(this._taxAmount);
/* 274 */     dao.setTaxPercentage(this._taxPercentage);
/* 275 */     dao.setRawTaxAmount(this._rawTaxAmount);
/* 276 */     dao.setRawTaxPercentage(this._rawTaxPercentage);
/* 277 */     dao.setExemptTaxAmount(this._exemptTaxAmount);
/* 278 */     dao.setTaxExemptAmount(this._taxExemptAmount);
/* 279 */     dao.setTaxExemptionId(this._taxExemptionId);
/* 280 */     dao.setTaxOverrideAmount(this._taxOverrideAmount);
/* 281 */     dao.setTaxOverride(this._taxOverride);
/* 282 */     dao.setTaxOverridePercentage(this._taxOverridePercentage);
/* 283 */     dao.setTaxOverrideReasonCode(this._taxOverrideReasonCode);
/* 284 */     dao.setTaxOverrideComment(this._taxOverrideComment);
/* 285 */     dao.setTaxableAmount(this._taxableAmount);
/* 286 */     dao.setVoid(this._void);
/* 287 */     dao.setTaxGroupId(this._taxGroupId);
/* 288 */     dao.setTaxLocationId(this._taxLocationId);
/* 289 */     dao.setTaxRuleSequence(this._taxRuleSequence);
/* 290 */     dao.setAuthorityId(this._authorityId);
/* 291 */     dao.setAuthorityName(this._authorityName);
/* 292 */     dao.setAuthorityTypeCode(this._authorityTypeCode);
/* 293 */     dao.setTaxOverrideBracket(this._taxOverrideBracket);
/* 294 */     dao.setOrigTaxableAmount(this._origTaxableAmount);
/* 295 */     dao.setOrigTaxGroupId(this._origTaxGroupId);
/* 296 */     argDAO.suppressStateChanges(false);
/* 297 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 301 */     return loadDAO((IDataAccessObject)new SaleTaxModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 305 */     SaleTaxModifierDAO dao = (SaleTaxModifierDAO)argDAO;
/* 306 */     this._businessDate = dao.getBusinessDate();
/* 307 */     this._organizationId = dao.getOrganizationId();
/* 308 */     this._retailLocationId = dao.getRetailLocationId();
/* 309 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 310 */     this._saleTaxModifierSequence = dao.getSaleTaxModifierSequence();
/* 311 */     this._transactionSequence = dao.getTransactionSequence();
/* 312 */     this._workstationId = dao.getWorkstationId();
/* 313 */     this._createDate = dao.getCreateDate();
/* 314 */     this._createUserId = dao.getCreateUserId();
/* 315 */     this._updateDate = dao.getUpdateDate();
/* 316 */     this._updateUserId = dao.getUpdateUserId();
/* 317 */     this._taxAmount = dao.getTaxAmount();
/* 318 */     this._taxPercentage = dao.getTaxPercentage();
/* 319 */     this._rawTaxAmount = dao.getRawTaxAmount();
/* 320 */     this._rawTaxPercentage = dao.getRawTaxPercentage();
/* 321 */     this._exemptTaxAmount = dao.getExemptTaxAmount();
/* 322 */     this._taxExemptAmount = dao.getTaxExemptAmount();
/* 323 */     this._taxExemptionId = dao.getTaxExemptionId();
/* 324 */     this._taxOverrideAmount = dao.getTaxOverrideAmount();
/* 325 */     this._taxOverride = (dao.getTaxOverride() != null) ? dao.getTaxOverride() : Boolean.valueOf(false);
/* 326 */     this._taxOverridePercentage = dao.getTaxOverridePercentage();
/* 327 */     this._taxOverrideReasonCode = dao.getTaxOverrideReasonCode();
/* 328 */     this._taxOverrideComment = dao.getTaxOverrideComment();
/* 329 */     this._taxableAmount = dao.getTaxableAmount();
/* 330 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/* 331 */     this._taxGroupId = dao.getTaxGroupId();
/* 332 */     this._taxLocationId = dao.getTaxLocationId();
/* 333 */     this._taxRuleSequence = dao.getTaxRuleSequence();
/* 334 */     this._authorityId = dao.getAuthorityId();
/* 335 */     this._authorityName = dao.getAuthorityName();
/* 336 */     this._authorityTypeCode = dao.getAuthorityTypeCode();
/* 337 */     this._taxOverrideBracket = dao.getTaxOverrideBracket();
/* 338 */     this._origTaxableAmount = dao.getOrigTaxableAmount();
/* 339 */     this._origTaxGroupId = dao.getOrigTaxGroupId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 343 */     SaleTaxModifierId id = (SaleTaxModifierId)argId;
/* 344 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 345 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 346 */     argStatement.setLong(3, id.getRetailLocationId().longValue());
/* 347 */     argStatement.setInt(4, id.getRetailTransactionLineItemSequence().intValue());
/* 348 */     argStatement.setInt(5, id.getSaleTaxModifierSequence().intValue());
/* 349 */     argStatement.setLong(6, id.getTransactionSequence().longValue());
/* 350 */     argStatement.setLong(7, id.getWorkstationId().longValue());
/* 351 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 355 */     SaleTaxModifierId id = new SaleTaxModifierId();
/* 356 */     id.setBusinessDate(this._businessDate);
/* 357 */     id.setOrganizationId(this._organizationId);
/* 358 */     id.setRetailLocationId(this._retailLocationId);
/* 359 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 360 */     id.setSaleTaxModifierSequence(this._saleTaxModifierSequence);
/* 361 */     id.setTransactionSequence(this._transactionSequence);
/* 362 */     id.setWorkstationId(this._workstationId);
/* 363 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 371 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 375 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\SaleTaxModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */