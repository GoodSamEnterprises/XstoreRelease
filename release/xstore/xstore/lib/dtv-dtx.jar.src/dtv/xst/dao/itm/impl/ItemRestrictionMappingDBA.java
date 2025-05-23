/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.ItemRestrictionMappingId;
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
/*     */ public class ItemRestrictionMappingDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1762616309L;
/*     */   private Long _organizationId;
/*     */   private String _merchHierarchyLevel;
/*     */   private String _merchHierarchyId;
/*     */   private String _restrictionCategory;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.merch_hierarchy_level, t.merch_hierarchy_id, t.restriction_category, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_restrict_mapping t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND merch_hierarchy_level = ?  AND merch_hierarchy_id = ?  AND restriction_category = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.merch_hierarchy_level, t.merch_hierarchy_id, t.restriction_category, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_restrict_mapping t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND merch_hierarchy_level = ?  AND merch_hierarchy_id = ?  AND restriction_category = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_restrict_mapping(organization_id, merch_hierarchy_level, merch_hierarchy_id, restriction_category, org_code, org_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._merchHierarchyLevel, this._merchHierarchyId, this._restrictionCategory, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 12, 12, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_restrict_mapping SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_restrict_mapping" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND merch_hierarchy_level = ?  AND merch_hierarchy_id = ?  AND restriction_category = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND merch_hierarchy_level = ?  AND merch_hierarchy_id = ?  AND restriction_category = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._merchHierarchyLevel, this._merchHierarchyId, this._restrictionCategory };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "itm_item_restrict_mapping";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new ItemRestrictionMappingFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemRestrictionMappingFiller
/*     */     implements IFiller {
/*     */     private ItemRestrictionMappingDBA _parent;
/*     */     
/*     */     public ItemRestrictionMappingFiller(ItemRestrictionMappingDBA argParent) {
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
/* 133 */       this._parent._merchHierarchyLevel = argResultSet.getString(2);
/* 134 */       this._parent._merchHierarchyId = argResultSet.getString(3);
/* 135 */       this._parent._restrictionCategory = argResultSet.getString(4);
/* 136 */       this._parent._orgCode = argResultSet.getString(5);
/* 137 */       this._parent._orgValue = argResultSet.getString(6);
/*     */       
/* 139 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 140 */       if (t7 != null) {
/* 141 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 147 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 149 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 150 */       if (t9 != null) {
/* 151 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._updateUserId = argResultSet.getString(10);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 162 */     argDAO.suppressStateChanges(true);
/* 163 */     ItemRestrictionMappingDAO dao = (ItemRestrictionMappingDAO)argDAO;
/* 164 */     dao.setOrganizationId(this._organizationId);
/* 165 */     dao.setMerchHierarchyLevel(this._merchHierarchyLevel);
/* 166 */     dao.setMerchHierarchyId(this._merchHierarchyId);
/* 167 */     dao.setRestrictionCategory(this._restrictionCategory);
/* 168 */     dao.setOrgCode(this._orgCode);
/* 169 */     dao.setOrgValue(this._orgValue);
/* 170 */     dao.setCreateDate(this._createDate);
/* 171 */     dao.setCreateUserId(this._createUserId);
/* 172 */     dao.setUpdateDate(this._updateDate);
/* 173 */     dao.setUpdateUserId(this._updateUserId);
/* 174 */     argDAO.suppressStateChanges(false);
/* 175 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 179 */     return loadDAO((IDataAccessObject)new ItemRestrictionMappingDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 183 */     ItemRestrictionMappingDAO dao = (ItemRestrictionMappingDAO)argDAO;
/* 184 */     this._organizationId = dao.getOrganizationId();
/* 185 */     this._merchHierarchyLevel = dao.getMerchHierarchyLevel();
/* 186 */     this._merchHierarchyId = dao.getMerchHierarchyId();
/* 187 */     this._restrictionCategory = dao.getRestrictionCategory();
/* 188 */     this._orgCode = dao.getOrgCode();
/* 189 */     this._orgValue = dao.getOrgValue();
/* 190 */     this._createDate = dao.getCreateDate();
/* 191 */     this._createUserId = dao.getCreateUserId();
/* 192 */     this._updateDate = dao.getUpdateDate();
/* 193 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 197 */     ItemRestrictionMappingId id = (ItemRestrictionMappingId)argId;
/* 198 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 199 */     argStatement.setString(2, id.getMerchHierarchyLevel());
/* 200 */     argStatement.setString(3, id.getMerchHierarchyId());
/* 201 */     argStatement.setString(4, id.getRestrictionCategory());
/* 202 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 206 */     ItemRestrictionMappingId id = new ItemRestrictionMappingId();
/* 207 */     id.setOrganizationId(this._organizationId);
/* 208 */     id.setMerchHierarchyLevel(this._merchHierarchyLevel);
/* 209 */     id.setMerchHierarchyId(this._merchHierarchyId);
/* 210 */     id.setRestrictionCategory(this._restrictionCategory);
/* 211 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 219 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 223 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictionMappingDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */