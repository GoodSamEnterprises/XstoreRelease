/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.ItemImageId;
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
/*     */ public class ItemImageDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -157724184L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _featureId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _imageUrl;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.feature_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.image_url, t.org_code, t.org_value FROM itm_item_images t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND feature_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.item_id, t.feature_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.image_url, t.org_code, t.org_value FROM itm_item_images t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND item_id = ?  AND feature_id = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_images(organization_id, item_id, feature_id, create_date, create_user_id, update_date, update_user_id, image_url, org_code, org_value) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, this._featureId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._imageUrl, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }) } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_images SET update_date = ?, update_user_id = ?, image_url = ?, org_code = ?, org_value = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._imageUrl, this._orgCode, this._orgValue } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_images" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND feature_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND item_id = ?  AND feature_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._itemId, this._featureId };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "itm_item_images";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new ItemImageFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemImageFiller
/*     */     implements IFiller {
/*     */     private ItemImageDBA _parent;
/*     */     
/*     */     public ItemImageFiller(ItemImageDBA argParent) {
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
/* 133 */       this._parent._itemId = argResultSet.getString(2);
/* 134 */       this._parent._featureId = argResultSet.getString(3);
/*     */       
/* 136 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 137 */       if (t4 != null) {
/* 138 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 141 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 144 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 146 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 147 */       if (t6 != null) {
/* 148 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._updateUserId = argResultSet.getString(7);
/* 155 */       this._parent._imageUrl = argResultSet.getString(8);
/* 156 */       this._parent._orgCode = argResultSet.getString(9);
/* 157 */       this._parent._orgValue = argResultSet.getString(10);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 162 */     argDAO.suppressStateChanges(true);
/* 163 */     ItemImageDAO dao = (ItemImageDAO)argDAO;
/* 164 */     dao.setOrganizationId(this._organizationId);
/* 165 */     dao.setItemId(this._itemId);
/* 166 */     dao.setFeatureId(this._featureId);
/* 167 */     dao.setCreateDate(this._createDate);
/* 168 */     dao.setCreateUserId(this._createUserId);
/* 169 */     dao.setUpdateDate(this._updateDate);
/* 170 */     dao.setUpdateUserId(this._updateUserId);
/* 171 */     dao.setImageUrl(this._imageUrl);
/* 172 */     dao.setOrgCode(this._orgCode);
/* 173 */     dao.setOrgValue(this._orgValue);
/* 174 */     argDAO.suppressStateChanges(false);
/* 175 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 179 */     return loadDAO((IDataAccessObject)new ItemImageDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 183 */     ItemImageDAO dao = (ItemImageDAO)argDAO;
/* 184 */     this._organizationId = dao.getOrganizationId();
/* 185 */     this._itemId = dao.getItemId();
/* 186 */     this._featureId = dao.getFeatureId();
/* 187 */     this._createDate = dao.getCreateDate();
/* 188 */     this._createUserId = dao.getCreateUserId();
/* 189 */     this._updateDate = dao.getUpdateDate();
/* 190 */     this._updateUserId = dao.getUpdateUserId();
/* 191 */     this._imageUrl = dao.getImageUrl();
/* 192 */     this._orgCode = dao.getOrgCode();
/* 193 */     this._orgValue = dao.getOrgValue();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 197 */     ItemImageId id = (ItemImageId)argId;
/* 198 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 199 */     argStatement.setString(2, id.getItemId());
/* 200 */     argStatement.setString(3, id.getFeatureId());
/* 201 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 205 */     ItemImageId id = new ItemImageId();
/* 206 */     id.setOrganizationId(this._organizationId);
/* 207 */     id.setItemId(this._itemId);
/* 208 */     id.setFeatureId(this._featureId);
/* 209 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 217 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 221 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemImageDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */