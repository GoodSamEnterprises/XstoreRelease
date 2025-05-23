/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.ItemPromptPropertyId;
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
/*     */ public class ItemPromptPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 979737964L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _promptPropertyCode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _promptMethodCode;
/*     */   private String _codeGroup;
/*     */   private String _promptTitleKey;
/*     */   private String _promptMessageKey;
/*     */   private Boolean _required;
/*     */   private Integer _sortOrder;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.itm_prompt_property_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.prompt_mthd_code, t.code_group, t.prompt_title_key, t.prompt_msg_key, t.required_flag, t.sort_order FROM itm_item_prompt_properties t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND itm_prompt_property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.item_id, t.itm_prompt_property_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.prompt_mthd_code, t.code_group, t.prompt_title_key, t.prompt_msg_key, t.required_flag, t.sort_order FROM itm_item_prompt_properties t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND item_id = ?  AND itm_prompt_property_code = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_prompt_properties(organization_id, item_id, itm_prompt_property_code, create_date, create_user_id, update_date, update_user_id, org_code, org_value, prompt_mthd_code, code_group, prompt_title_key, prompt_msg_key, required_flag, sort_order) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, this._promptPropertyCode, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._promptMethodCode, this._codeGroup, this._promptTitleKey, this._promptMessageKey, this._required, this._sortOrder } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, -7, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_prompt_properties SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, prompt_mthd_code = ?, code_group = ?, prompt_title_key = ?, prompt_msg_key = ?, required_flag = ?, sort_order = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._promptMethodCode, this._codeGroup, this._promptTitleKey, this._promptMessageKey, this._required, this._sortOrder } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, -7, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_prompt_properties" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND itm_prompt_property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND item_id = ?  AND itm_prompt_property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._itemId, this._promptPropertyCode };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "itm_item_prompt_properties";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new ItemPromptPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemPromptPropertyFiller
/*     */     implements IFiller {
/*     */     private ItemPromptPropertyDBA _parent;
/*     */     
/*     */     public ItemPromptPropertyFiller(ItemPromptPropertyDBA argParent) {
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
/* 138 */       this._parent._itemId = argResultSet.getString(2);
/* 139 */       this._parent._promptPropertyCode = argResultSet.getString(3);
/*     */       
/* 141 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 142 */       if (t4 != null) {
/* 143 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 146 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 149 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 151 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 152 */       if (t6 != null) {
/* 153 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._updateUserId = argResultSet.getString(7);
/* 160 */       this._parent._orgCode = argResultSet.getString(8);
/* 161 */       this._parent._orgValue = argResultSet.getString(9);
/* 162 */       this._parent._promptMethodCode = argResultSet.getString(10);
/* 163 */       this._parent._codeGroup = argResultSet.getString(11);
/* 164 */       this._parent._promptTitleKey = argResultSet.getString(12);
/* 165 */       this._parent._promptMessageKey = argResultSet.getString(13);
/* 166 */       this._parent._required = Boolean.valueOf(argResultSet.getBoolean(14));
/*     */ 
/*     */       
/* 169 */       int i = argResultSet.getInt(15);
/* 170 */       if (i != 0 || argResultSet.getObject(15) != null) {
/* 171 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 179 */     argDAO.suppressStateChanges(true);
/* 180 */     ItemPromptPropertyDAO dao = (ItemPromptPropertyDAO)argDAO;
/* 181 */     dao.setOrganizationId(this._organizationId);
/* 182 */     dao.setItemId(this._itemId);
/* 183 */     dao.setPromptPropertyCode(this._promptPropertyCode);
/* 184 */     dao.setCreateDate(this._createDate);
/* 185 */     dao.setCreateUserId(this._createUserId);
/* 186 */     dao.setUpdateDate(this._updateDate);
/* 187 */     dao.setUpdateUserId(this._updateUserId);
/* 188 */     dao.setOrgCode(this._orgCode);
/* 189 */     dao.setOrgValue(this._orgValue);
/* 190 */     dao.setPromptMethodCode(this._promptMethodCode);
/* 191 */     dao.setCodeGroup(this._codeGroup);
/* 192 */     dao.setPromptTitleKey(this._promptTitleKey);
/* 193 */     dao.setPromptMessageKey(this._promptMessageKey);
/* 194 */     dao.setRequired(this._required);
/* 195 */     dao.setSortOrder(this._sortOrder);
/* 196 */     argDAO.suppressStateChanges(false);
/* 197 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 201 */     return loadDAO((IDataAccessObject)new ItemPromptPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 205 */     ItemPromptPropertyDAO dao = (ItemPromptPropertyDAO)argDAO;
/* 206 */     this._organizationId = dao.getOrganizationId();
/* 207 */     this._itemId = dao.getItemId();
/* 208 */     this._promptPropertyCode = dao.getPromptPropertyCode();
/* 209 */     this._createDate = dao.getCreateDate();
/* 210 */     this._createUserId = dao.getCreateUserId();
/* 211 */     this._updateDate = dao.getUpdateDate();
/* 212 */     this._updateUserId = dao.getUpdateUserId();
/* 213 */     this._orgCode = dao.getOrgCode();
/* 214 */     this._orgValue = dao.getOrgValue();
/* 215 */     this._promptMethodCode = dao.getPromptMethodCode();
/* 216 */     this._codeGroup = dao.getCodeGroup();
/* 217 */     this._promptTitleKey = dao.getPromptTitleKey();
/* 218 */     this._promptMessageKey = dao.getPromptMessageKey();
/* 219 */     this._required = (dao.getRequired() != null) ? dao.getRequired() : Boolean.valueOf(false);
/* 220 */     this._sortOrder = dao.getSortOrder();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 224 */     ItemPromptPropertyId id = (ItemPromptPropertyId)argId;
/* 225 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 226 */     argStatement.setString(2, id.getItemId());
/* 227 */     argStatement.setString(3, id.getPromptPropertyCode());
/* 228 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 232 */     ItemPromptPropertyId id = new ItemPromptPropertyId();
/* 233 */     id.setOrganizationId(this._organizationId);
/* 234 */     id.setItemId(this._itemId);
/* 235 */     id.setPromptPropertyCode(this._promptPropertyCode);
/* 236 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 244 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 248 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemPromptPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */