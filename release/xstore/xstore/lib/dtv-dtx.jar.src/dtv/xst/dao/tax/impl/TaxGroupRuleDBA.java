/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.tax.TaxGroupRuleId;
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
/*     */ public class TaxGroupRuleDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1838428464L;
/*     */   private Long _organizationId;
/*     */   private String _taxGroupId;
/*     */   private String _taxLocationId;
/*     */   private Integer _taxRuleSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Boolean _compound;
/*     */   private Integer _compoundSequence;
/*     */   private String _description;
/*     */   private String _name;
/*     */   private String _taxTypeCode;
/*     */   private Boolean _taxedAtTransLevel;
/*     */   private String _taxAuthorityId;
/*     */   private String _externalSystem;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.tax_group_id, t.tax_loc_id, t.tax_rule_seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.compound_flag, t.compound_seq_nbr, t.description, t.name, t.tax_typcode, t.taxed_at_trans_level_flag, t.tax_authority_id, t.external_system FROM tax_tax_group_rule t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rule_seq_nbr = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  47 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  51 */     return "SELECT t.organization_id, t.tax_group_id, t.tax_loc_id, t.tax_rule_seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.compound_flag, t.compound_seq_nbr, t.description, t.name, t.tax_typcode, t.taxed_at_trans_level_flag, t.tax_authority_id, t.external_system FROM tax_tax_group_rule t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  57 */     return " WHERE organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rule_seq_nbr = ?  ";
/*     */   }
/*     */   
/*  60 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tax_tax_group_rule(organization_id, tax_group_id, tax_loc_id, tax_rule_seq_nbr, create_date, create_user_id, update_date, update_user_id, org_code, org_value, compound_flag, compound_seq_nbr, description, name, tax_typcode, taxed_at_trans_level_flag, tax_authority_id, external_system) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  63 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  67 */     Object[][] insertParameterObject = { { this._organizationId, this._taxGroupId, this._taxLocationId, this._taxRuleSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._compound, this._compoundSequence, this._description, this._name, this._taxTypeCode, this._taxedAtTransLevel, this._taxAuthorityId, this._externalSystem } };
/*  68 */     return insertParameterObject;
/*     */   }
/*     */   
/*  71 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 4, 91, 12, 91, 12, 12, 12, -7, 4, 12, 12, 12, -7, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  74 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  77 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tax_tax_group_rule SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, compound_flag = ?, compound_seq_nbr = ?, description = ?, name = ?, tax_typcode = ?, taxed_at_trans_level_flag = ?, tax_authority_id = ?, external_system = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  80 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  84 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._compound, this._compoundSequence, this._description, this._name, this._taxTypeCode, this._taxedAtTransLevel, this._taxAuthorityId, this._externalSystem } };
/*  85 */     return updateParameterObject;
/*     */   }
/*     */   
/*  88 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, -7, 4, 12, 12, 12, -7, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  90 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  93 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tax_tax_group_rule" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rule_seq_nbr = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  96 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 102 */     return " WHERE organization_id = ?  AND tax_group_id = ?  AND tax_loc_id = ?  AND tax_rule_seq_nbr = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 105 */     return new Object[] { this._organizationId, this._taxGroupId, this._taxLocationId, this._taxRuleSequence };
/*     */   }
/*     */   
/* 108 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 111 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 114 */     return "tax_tax_group_rule";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 118 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 122 */     return new TaxGroupRuleFiller(this);
/*     */   }
/*     */   
/*     */   private static class TaxGroupRuleFiller
/*     */     implements IFiller {
/*     */     private TaxGroupRuleDBA _parent;
/*     */     
/*     */     public TaxGroupRuleFiller(TaxGroupRuleDBA argParent) {
/* 130 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 135 */       long l = argResultSet.getLong(1);
/* 136 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 137 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 141 */       this._parent._taxGroupId = argResultSet.getString(2);
/* 142 */       this._parent._taxLocationId = argResultSet.getString(3);
/*     */ 
/*     */       
/* 145 */       int primitiveResult = argResultSet.getInt(4);
/* 146 */       if (primitiveResult != 0 || argResultSet.getObject(4) != null) {
/* 147 */         this._parent._taxRuleSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 152 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 153 */       if (t5 != null) {
/* 154 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 162 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 163 */       if (t7 != null) {
/* 164 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 167 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 170 */       this._parent._updateUserId = argResultSet.getString(8);
/* 171 */       this._parent._orgCode = argResultSet.getString(9);
/* 172 */       this._parent._orgValue = argResultSet.getString(10);
/* 173 */       this._parent._compound = Boolean.valueOf(argResultSet.getBoolean(11));
/*     */ 
/*     */       
/* 176 */       int i = argResultSet.getInt(12);
/* 177 */       if (i != 0 || argResultSet.getObject(12) != null) {
/* 178 */         this._parent._compoundSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 182 */       this._parent._description = argResultSet.getString(13);
/* 183 */       this._parent._name = argResultSet.getString(14);
/* 184 */       this._parent._taxTypeCode = argResultSet.getString(15);
/* 185 */       this._parent._taxedAtTransLevel = Boolean.valueOf(argResultSet.getBoolean(16));
/* 186 */       this._parent._taxAuthorityId = argResultSet.getString(17);
/* 187 */       this._parent._externalSystem = argResultSet.getString(18);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 192 */     argDAO.suppressStateChanges(true);
/* 193 */     TaxGroupRuleDAO dao = (TaxGroupRuleDAO)argDAO;
/* 194 */     dao.setOrganizationId(this._organizationId);
/* 195 */     dao.setTaxGroupId(this._taxGroupId);
/* 196 */     dao.setTaxLocationId(this._taxLocationId);
/* 197 */     dao.setTaxRuleSequence(this._taxRuleSequence);
/* 198 */     dao.setCreateDate(this._createDate);
/* 199 */     dao.setCreateUserId(this._createUserId);
/* 200 */     dao.setUpdateDate(this._updateDate);
/* 201 */     dao.setUpdateUserId(this._updateUserId);
/* 202 */     dao.setOrgCode(this._orgCode);
/* 203 */     dao.setOrgValue(this._orgValue);
/* 204 */     dao.setCompound(this._compound);
/* 205 */     dao.setCompoundSequence(this._compoundSequence);
/* 206 */     dao.setDescription(this._description);
/* 207 */     dao.setName(this._name);
/* 208 */     dao.setTaxTypeCode(this._taxTypeCode);
/* 209 */     dao.setTaxedAtTransLevel(this._taxedAtTransLevel);
/* 210 */     dao.setTaxAuthorityId(this._taxAuthorityId);
/* 211 */     dao.setExternalSystem(this._externalSystem);
/* 212 */     argDAO.suppressStateChanges(false);
/* 213 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 217 */     return loadDAO((IDataAccessObject)new TaxGroupRuleDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 221 */     TaxGroupRuleDAO dao = (TaxGroupRuleDAO)argDAO;
/* 222 */     this._organizationId = dao.getOrganizationId();
/* 223 */     this._taxGroupId = dao.getTaxGroupId();
/* 224 */     this._taxLocationId = dao.getTaxLocationId();
/* 225 */     this._taxRuleSequence = dao.getTaxRuleSequence();
/* 226 */     this._createDate = dao.getCreateDate();
/* 227 */     this._createUserId = dao.getCreateUserId();
/* 228 */     this._updateDate = dao.getUpdateDate();
/* 229 */     this._updateUserId = dao.getUpdateUserId();
/* 230 */     this._orgCode = dao.getOrgCode();
/* 231 */     this._orgValue = dao.getOrgValue();
/* 232 */     this._compound = (dao.getCompound() != null) ? dao.getCompound() : Boolean.valueOf(false);
/* 233 */     this._compoundSequence = dao.getCompoundSequence();
/* 234 */     this._description = dao.getDescription();
/* 235 */     this._name = dao.getName();
/* 236 */     this._taxTypeCode = dao.getTaxTypeCode();
/* 237 */     this._taxedAtTransLevel = (dao.getTaxedAtTransLevel() != null) ? dao.getTaxedAtTransLevel() : Boolean.valueOf(false);
/* 238 */     this._taxAuthorityId = dao.getTaxAuthorityId();
/* 239 */     this._externalSystem = dao.getExternalSystem();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 243 */     TaxGroupRuleId id = (TaxGroupRuleId)argId;
/* 244 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 245 */     argStatement.setString(2, id.getTaxGroupId());
/* 246 */     argStatement.setString(3, id.getTaxLocationId());
/* 247 */     argStatement.setInt(4, id.getTaxRuleSequence().intValue());
/* 248 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 252 */     TaxGroupRuleId id = new TaxGroupRuleId();
/* 253 */     id.setOrganizationId(this._organizationId);
/* 254 */     id.setTaxGroupId(this._taxGroupId);
/* 255 */     id.setTaxLocationId(this._taxLocationId);
/* 256 */     id.setTaxRuleSequence(this._taxRuleSequence);
/* 257 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 265 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 269 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxGroupRuleDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */