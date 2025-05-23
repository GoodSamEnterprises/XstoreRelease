/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.ItemLabelPropertiesId;
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
/*     */ public class ItemLabelPropertiesDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1062658964L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _stockLabel;
/*     */   private String _logoUrl;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.stock_label, t.logo_url FROM itm_item_label_properties t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.item_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.stock_label, t.logo_url FROM itm_item_label_properties t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_label_properties(organization_id, item_id, org_code, org_value, create_date, create_user_id, update_date, update_user_id, stock_label, logo_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._stockLabel, this._logoUrl } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 12, 91, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_label_properties SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, stock_label = ?, logo_url = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._stockLabel, this._logoUrl } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_label_properties" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._itemId };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "itm_item_label_properties";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new ItemLabelPropertiesFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemLabelPropertiesFiller
/*     */     implements IFiller {
/*     */     private ItemLabelPropertiesDBA _parent;
/*     */     
/*     */     public ItemLabelPropertiesFiller(ItemLabelPropertiesDBA argParent) {
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
/* 134 */       this._parent._orgCode = argResultSet.getString(3);
/* 135 */       this._parent._orgValue = argResultSet.getString(4);
/*     */       
/* 137 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 138 */       if (t5 != null) {
/* 139 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 142 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 145 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 147 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 148 */       if (t7 != null) {
/* 149 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 155 */       this._parent._updateUserId = argResultSet.getString(8);
/* 156 */       this._parent._stockLabel = argResultSet.getString(9);
/* 157 */       this._parent._logoUrl = argResultSet.getString(10);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 162 */     argDAO.suppressStateChanges(true);
/* 163 */     ItemLabelPropertiesDAO dao = (ItemLabelPropertiesDAO)argDAO;
/* 164 */     dao.setOrganizationId(this._organizationId);
/* 165 */     dao.setItemId(this._itemId);
/* 166 */     dao.setOrgCode(this._orgCode);
/* 167 */     dao.setOrgValue(this._orgValue);
/* 168 */     dao.setCreateDate(this._createDate);
/* 169 */     dao.setCreateUserId(this._createUserId);
/* 170 */     dao.setUpdateDate(this._updateDate);
/* 171 */     dao.setUpdateUserId(this._updateUserId);
/* 172 */     dao.setStockLabel(this._stockLabel);
/* 173 */     dao.setLogoUrl(this._logoUrl);
/* 174 */     argDAO.suppressStateChanges(false);
/* 175 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 179 */     return loadDAO((IDataAccessObject)new ItemLabelPropertiesDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 183 */     ItemLabelPropertiesDAO dao = (ItemLabelPropertiesDAO)argDAO;
/* 184 */     this._organizationId = dao.getOrganizationId();
/* 185 */     this._itemId = dao.getItemId();
/* 186 */     this._orgCode = dao.getOrgCode();
/* 187 */     this._orgValue = dao.getOrgValue();
/* 188 */     this._createDate = dao.getCreateDate();
/* 189 */     this._createUserId = dao.getCreateUserId();
/* 190 */     this._updateDate = dao.getUpdateDate();
/* 191 */     this._updateUserId = dao.getUpdateUserId();
/* 192 */     this._stockLabel = dao.getStockLabel();
/* 193 */     this._logoUrl = dao.getLogoUrl();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 197 */     ItemLabelPropertiesId id = (ItemLabelPropertiesId)argId;
/* 198 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 199 */     argStatement.setString(2, id.getItemId());
/* 200 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 204 */     ItemLabelPropertiesId id = new ItemLabelPropertiesId();
/* 205 */     id.setOrganizationId(this._organizationId);
/* 206 */     id.setItemId(this._itemId);
/* 207 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 215 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 219 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemLabelPropertiesDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */