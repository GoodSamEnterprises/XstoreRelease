/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.com.TransactionPropertyPromptId;
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
/*     */ public class TransactionPropertyPromptDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1510887927L;
/*     */   private Long _organizationId;
/*     */   private String _promptPropertyCode;
/*     */   private Date _effectiveDate;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _expirationDate;
/*     */   private String _promptMethodCode;
/*     */   private String _codeCategory;
/*     */   private String _promptTitleKey;
/*     */   private String _promptMessageKey;
/*     */   private Boolean _required;
/*     */   private Integer _sortOrder;
/*     */   private String _promptEditPattern;
/*     */   private String _validationRuleKey;
/*     */   private String _promptKey;
/*     */   private String _chainKey;
/*     */   private String _transactionState;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.trans_prompt_property_code, t.effective_date, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.expiration_date, t.prompt_mthd_code, t.code_category, t.prompt_title_key, t.prompt_msg_key, t.required_flag, t.sort_order, t.prompt_edit_pattern, t.validation_rule_key, t.prompt_key, t.chain_key, t.transaction_state FROM com_trans_prompt_properties t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND trans_prompt_property_code = ?  AND effective_date = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  50 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  54 */     return "SELECT t.organization_id, t.trans_prompt_property_code, t.effective_date, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.expiration_date, t.prompt_mthd_code, t.code_category, t.prompt_title_key, t.prompt_msg_key, t.required_flag, t.sort_order, t.prompt_edit_pattern, t.validation_rule_key, t.prompt_key, t.chain_key, t.transaction_state FROM com_trans_prompt_properties t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  60 */     return " WHERE organization_id = ?  AND trans_prompt_property_code = ?  AND effective_date = ?  ";
/*     */   }
/*     */   
/*  63 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_trans_prompt_properties(organization_id, trans_prompt_property_code, effective_date, create_date, create_user_id, update_date, update_user_id, org_code, org_value, expiration_date, prompt_mthd_code, code_category, prompt_title_key, prompt_msg_key, required_flag, sort_order, prompt_edit_pattern, validation_rule_key, prompt_key, chain_key, transaction_state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  66 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  70 */     Object[][] insertParameterObject = { { this._organizationId, this._promptPropertyCode, this._effectiveDate, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._expirationDate, this._promptMethodCode, this._codeCategory, this._promptTitleKey, this._promptMessageKey, this._required, this._sortOrder, this._promptEditPattern, this._validationRuleKey, this._promptKey, this._chainKey, this._transactionState } };
/*  71 */     return insertParameterObject;
/*     */   }
/*     */   
/*  74 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 91, 12, 91, 12, 12, 12, 91, 12, 12, 12, 12, -7, 4, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  77 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  80 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_trans_prompt_properties SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, expiration_date = ?, prompt_mthd_code = ?, code_category = ?, prompt_title_key = ?, prompt_msg_key = ?, required_flag = ?, sort_order = ?, prompt_edit_pattern = ?, validation_rule_key = ?, prompt_key = ?, chain_key = ?, transaction_state = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  83 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  87 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._expirationDate, this._promptMethodCode, this._codeCategory, this._promptTitleKey, this._promptMessageKey, this._required, this._sortOrder, this._promptEditPattern, this._validationRuleKey, this._promptKey, this._chainKey, this._transactionState } };
/*  88 */     return updateParameterObject;
/*     */   }
/*     */   
/*  91 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 91, 12, 12, 12, 12, -7, 4, 12, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  93 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  96 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_trans_prompt_properties" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND trans_prompt_property_code = ?  AND effective_date = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  99 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 105 */     return " WHERE organization_id = ?  AND trans_prompt_property_code = ?  AND effective_date = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 108 */     return new Object[] { this._organizationId, this._promptPropertyCode, this._effectiveDate };
/*     */   }
/*     */   
/* 111 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 91 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 114 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 117 */     return "com_trans_prompt_properties";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 121 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 125 */     return new TransactionPropertyPromptFiller(this);
/*     */   }
/*     */   
/*     */   private static class TransactionPropertyPromptFiller
/*     */     implements IFiller {
/*     */     private TransactionPropertyPromptDBA _parent;
/*     */     
/*     */     public TransactionPropertyPromptFiller(TransactionPropertyPromptDBA argParent) {
/* 133 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 138 */       long primitiveResult = argResultSet.getLong(1);
/* 139 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 140 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 144 */       this._parent._promptPropertyCode = argResultSet.getString(2);
/*     */       
/* 146 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 147 */       if (t3 != null) {
/* 148 */         this._parent._effectiveDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 155 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 156 */       if (t4 != null) {
/* 157 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 165 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 166 */       if (t6 != null) {
/* 167 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._updateUserId = argResultSet.getString(7);
/* 174 */       this._parent._orgCode = argResultSet.getString(8);
/* 175 */       this._parent._orgValue = argResultSet.getString(9);
/*     */       
/* 177 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 178 */       if (t10 != null) {
/* 179 */         this._parent._expirationDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 182 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 185 */       this._parent._promptMethodCode = argResultSet.getString(11);
/* 186 */       this._parent._codeCategory = argResultSet.getString(12);
/* 187 */       this._parent._promptTitleKey = argResultSet.getString(13);
/* 188 */       this._parent._promptMessageKey = argResultSet.getString(14);
/* 189 */       this._parent._required = Boolean.valueOf(argResultSet.getBoolean(15));
/*     */ 
/*     */       
/* 192 */       int i = argResultSet.getInt(16);
/* 193 */       if (i != 0 || argResultSet.getObject(16) != null) {
/* 194 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 198 */       this._parent._promptEditPattern = argResultSet.getString(17);
/* 199 */       this._parent._validationRuleKey = argResultSet.getString(18);
/* 200 */       this._parent._promptKey = argResultSet.getString(19);
/* 201 */       this._parent._chainKey = argResultSet.getString(20);
/* 202 */       this._parent._transactionState = argResultSet.getString(21);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 207 */     argDAO.suppressStateChanges(true);
/* 208 */     TransactionPropertyPromptDAO dao = (TransactionPropertyPromptDAO)argDAO;
/* 209 */     dao.setOrganizationId(this._organizationId);
/* 210 */     dao.setPromptPropertyCode(this._promptPropertyCode);
/* 211 */     dao.setEffectiveDate(this._effectiveDate);
/* 212 */     dao.setCreateDate(this._createDate);
/* 213 */     dao.setCreateUserId(this._createUserId);
/* 214 */     dao.setUpdateDate(this._updateDate);
/* 215 */     dao.setUpdateUserId(this._updateUserId);
/* 216 */     dao.setOrgCode(this._orgCode);
/* 217 */     dao.setOrgValue(this._orgValue);
/* 218 */     dao.setExpirationDate(this._expirationDate);
/* 219 */     dao.setPromptMethodCode(this._promptMethodCode);
/* 220 */     dao.setCodeCategory(this._codeCategory);
/* 221 */     dao.setPromptTitleKey(this._promptTitleKey);
/* 222 */     dao.setPromptMessageKey(this._promptMessageKey);
/* 223 */     dao.setRequired(this._required);
/* 224 */     dao.setSortOrder(this._sortOrder);
/* 225 */     dao.setPromptEditPattern(this._promptEditPattern);
/* 226 */     dao.setValidationRuleKey(this._validationRuleKey);
/* 227 */     dao.setPromptKey(this._promptKey);
/* 228 */     dao.setChainKey(this._chainKey);
/* 229 */     dao.setTransactionState(this._transactionState);
/* 230 */     argDAO.suppressStateChanges(false);
/* 231 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 235 */     return loadDAO((IDataAccessObject)new TransactionPropertyPromptDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 239 */     TransactionPropertyPromptDAO dao = (TransactionPropertyPromptDAO)argDAO;
/* 240 */     this._organizationId = dao.getOrganizationId();
/* 241 */     this._promptPropertyCode = dao.getPromptPropertyCode();
/* 242 */     this._effectiveDate = dao.getEffectiveDate();
/* 243 */     this._createDate = dao.getCreateDate();
/* 244 */     this._createUserId = dao.getCreateUserId();
/* 245 */     this._updateDate = dao.getUpdateDate();
/* 246 */     this._updateUserId = dao.getUpdateUserId();
/* 247 */     this._orgCode = dao.getOrgCode();
/* 248 */     this._orgValue = dao.getOrgValue();
/* 249 */     this._expirationDate = dao.getExpirationDate();
/* 250 */     this._promptMethodCode = dao.getPromptMethodCode();
/* 251 */     this._codeCategory = dao.getCodeCategory();
/* 252 */     this._promptTitleKey = dao.getPromptTitleKey();
/* 253 */     this._promptMessageKey = dao.getPromptMessageKey();
/* 254 */     this._required = (dao.getRequired() != null) ? dao.getRequired() : Boolean.valueOf(false);
/* 255 */     this._sortOrder = dao.getSortOrder();
/* 256 */     this._promptEditPattern = dao.getPromptEditPattern();
/* 257 */     this._validationRuleKey = dao.getValidationRuleKey();
/* 258 */     this._promptKey = dao.getPromptKey();
/* 259 */     this._chainKey = dao.getChainKey();
/* 260 */     this._transactionState = dao.getTransactionState();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 264 */     TransactionPropertyPromptId id = (TransactionPropertyPromptId)argId;
/* 265 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 266 */     argStatement.setString(2, id.getPromptPropertyCode());
/* 267 */     argStatement.setTimestamp(3, new Timestamp(id.getEffectiveDate().getTime()));
/* 268 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 272 */     TransactionPropertyPromptId id = new TransactionPropertyPromptId();
/* 273 */     id.setOrganizationId(this._organizationId);
/* 274 */     id.setPromptPropertyCode(this._promptPropertyCode);
/* 275 */     id.setEffectiveDate(this._effectiveDate);
/* 276 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 284 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 288 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\TransactionPropertyPromptDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */