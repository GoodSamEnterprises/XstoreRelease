/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.QuickItemId;
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
/*     */ public class QuickItemDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -990546304L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _parentId;
/*     */   private String _description;
/*     */   private String _imageUrl;
/*     */   private Integer _sortOrder;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.parent_id, t.description, t.image_url, t.sort_order FROM itm_quick_items t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.parent_id, t.description, t.image_url, t.sort_order FROM itm_quick_items t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_quick_items(organization_id, item_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, parent_id, description, image_url, sort_order) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._parentId, this._description, this._imageUrl, this._sortOrder } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 12, 12, 12, 12, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_quick_items SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, parent_id = ?, description = ?, image_url = ?, sort_order = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._parentId, this._description, this._imageUrl, this._sortOrder } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_quick_items" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._itemId };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "itm_quick_items";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new QuickItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class QuickItemFiller
/*     */     implements IFiller {
/*     */     private QuickItemDBA _parent;
/*     */     
/*     */     public QuickItemFiller(QuickItemDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long primitiveResult = argResultSet.getLong(1);
/* 130 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 135 */       this._parent._itemId = argResultSet.getString(2);
/*     */       
/* 137 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 138 */       if (t3 != null) {
/* 139 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 142 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 145 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 147 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 148 */       if (t5 != null) {
/* 149 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 155 */       this._parent._updateUserId = argResultSet.getString(6);
/* 156 */       this._parent._orgCode = argResultSet.getString(7);
/* 157 */       this._parent._orgValue = argResultSet.getString(8);
/* 158 */       this._parent._parentId = argResultSet.getString(9);
/* 159 */       this._parent._description = argResultSet.getString(10);
/* 160 */       this._parent._imageUrl = argResultSet.getString(11);
/*     */ 
/*     */       
/* 163 */       int i = argResultSet.getInt(12);
/* 164 */       if (i != 0 || argResultSet.getObject(12) != null) {
/* 165 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 173 */     argDAO.suppressStateChanges(true);
/* 174 */     QuickItemDAO dao = (QuickItemDAO)argDAO;
/* 175 */     dao.setOrganizationId(this._organizationId);
/* 176 */     dao.setItemId(this._itemId);
/* 177 */     dao.setCreateDate(this._createDate);
/* 178 */     dao.setCreateUserId(this._createUserId);
/* 179 */     dao.setUpdateDate(this._updateDate);
/* 180 */     dao.setUpdateUserId(this._updateUserId);
/* 181 */     dao.setOrgCode(this._orgCode);
/* 182 */     dao.setOrgValue(this._orgValue);
/* 183 */     dao.setParentId(this._parentId);
/* 184 */     dao.setDescription(this._description);
/* 185 */     dao.setImageUrl(this._imageUrl);
/* 186 */     dao.setSortOrder(this._sortOrder);
/* 187 */     argDAO.suppressStateChanges(false);
/* 188 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 192 */     return loadDAO((IDataAccessObject)new QuickItemDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 196 */     QuickItemDAO dao = (QuickItemDAO)argDAO;
/* 197 */     this._organizationId = dao.getOrganizationId();
/* 198 */     this._itemId = dao.getItemId();
/* 199 */     this._createDate = dao.getCreateDate();
/* 200 */     this._createUserId = dao.getCreateUserId();
/* 201 */     this._updateDate = dao.getUpdateDate();
/* 202 */     this._updateUserId = dao.getUpdateUserId();
/* 203 */     this._orgCode = dao.getOrgCode();
/* 204 */     this._orgValue = dao.getOrgValue();
/* 205 */     this._parentId = dao.getParentId();
/* 206 */     this._description = dao.getDescription();
/* 207 */     this._imageUrl = dao.getImageUrl();
/* 208 */     this._sortOrder = dao.getSortOrder();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 212 */     QuickItemId id = (QuickItemId)argId;
/* 213 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 214 */     argStatement.setString(2, id.getItemId());
/* 215 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 219 */     QuickItemId id = new QuickItemId();
/* 220 */     id.setOrganizationId(this._organizationId);
/* 221 */     id.setItemId(this._itemId);
/* 222 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 230 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 234 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\QuickItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */