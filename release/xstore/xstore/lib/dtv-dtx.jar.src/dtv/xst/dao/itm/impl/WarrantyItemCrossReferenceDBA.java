/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.WarrantyItemCrossReferenceId;
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
/*     */ public class WarrantyItemCrossReferenceDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -332362982L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _warrantyItemId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _warrantyTypeCode;
/*     */   private Long _sortOrder;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.warranty_item_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.warranty_typcode, t.sort_order FROM itm_warranty_item_xref t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND warranty_item_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.item_id, t.warranty_item_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.warranty_typcode, t.sort_order FROM itm_warranty_item_xref t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND item_id = ?  AND warranty_item_id = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_warranty_item_xref(organization_id, item_id, warranty_item_id, org_code, org_value, create_date, create_user_id, update_date, update_user_id, warranty_typcode, sort_order) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, this._warrantyItemId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._warrantyTypeCode, this._sortOrder } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 12, 91, 12, 91, 12, 12, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_warranty_item_xref SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, warranty_typcode = ?, sort_order = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._warrantyTypeCode, this._sortOrder } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 12, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_warranty_item_xref" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND warranty_item_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND item_id = ?  AND warranty_item_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._itemId, this._warrantyItemId };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "itm_warranty_item_xref";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new WarrantyItemCrossReferenceFiller(this);
/*     */   }
/*     */   
/*     */   private static class WarrantyItemCrossReferenceFiller
/*     */     implements IFiller {
/*     */     private WarrantyItemCrossReferenceDBA _parent;
/*     */     
/*     */     public WarrantyItemCrossReferenceFiller(WarrantyItemCrossReferenceDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long primitiveResult = argResultSet.getLong(1);
/* 129 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 134 */       this._parent._itemId = argResultSet.getString(2);
/* 135 */       this._parent._warrantyItemId = argResultSet.getString(3);
/* 136 */       this._parent._orgCode = argResultSet.getString(4);
/* 137 */       this._parent._orgValue = argResultSet.getString(5);
/*     */       
/* 139 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 140 */       if (t6 != null) {
/* 141 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 147 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 149 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 150 */       if (t8 != null) {
/* 151 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._updateUserId = argResultSet.getString(9);
/* 158 */       this._parent._warrantyTypeCode = argResultSet.getString(10);
/*     */ 
/*     */       
/* 161 */       long l1 = argResultSet.getLong(11);
/* 162 */       if (l1 != 0L || argResultSet.getObject(11) != null) {
/* 163 */         this._parent._sortOrder = Long.valueOf(l1);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 171 */     argDAO.suppressStateChanges(true);
/* 172 */     WarrantyItemCrossReferenceDAO dao = (WarrantyItemCrossReferenceDAO)argDAO;
/* 173 */     dao.setOrganizationId(this._organizationId);
/* 174 */     dao.setItemId(this._itemId);
/* 175 */     dao.setWarrantyItemId(this._warrantyItemId);
/* 176 */     dao.setOrgCode(this._orgCode);
/* 177 */     dao.setOrgValue(this._orgValue);
/* 178 */     dao.setCreateDate(this._createDate);
/* 179 */     dao.setCreateUserId(this._createUserId);
/* 180 */     dao.setUpdateDate(this._updateDate);
/* 181 */     dao.setUpdateUserId(this._updateUserId);
/* 182 */     dao.setWarrantyTypeCode(this._warrantyTypeCode);
/* 183 */     dao.setSortOrder(this._sortOrder);
/* 184 */     argDAO.suppressStateChanges(false);
/* 185 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 189 */     return loadDAO((IDataAccessObject)new WarrantyItemCrossReferenceDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 193 */     WarrantyItemCrossReferenceDAO dao = (WarrantyItemCrossReferenceDAO)argDAO;
/* 194 */     this._organizationId = dao.getOrganizationId();
/* 195 */     this._itemId = dao.getItemId();
/* 196 */     this._warrantyItemId = dao.getWarrantyItemId();
/* 197 */     this._orgCode = dao.getOrgCode();
/* 198 */     this._orgValue = dao.getOrgValue();
/* 199 */     this._createDate = dao.getCreateDate();
/* 200 */     this._createUserId = dao.getCreateUserId();
/* 201 */     this._updateDate = dao.getUpdateDate();
/* 202 */     this._updateUserId = dao.getUpdateUserId();
/* 203 */     this._warrantyTypeCode = dao.getWarrantyTypeCode();
/* 204 */     this._sortOrder = dao.getSortOrder();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 208 */     WarrantyItemCrossReferenceId id = (WarrantyItemCrossReferenceId)argId;
/* 209 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 210 */     argStatement.setString(2, id.getItemId());
/* 211 */     argStatement.setString(3, id.getWarrantyItemId());
/* 212 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 216 */     WarrantyItemCrossReferenceId id = new WarrantyItemCrossReferenceId();
/* 217 */     id.setOrganizationId(this._organizationId);
/* 218 */     id.setItemId(this._itemId);
/* 219 */     id.setWarrantyItemId(this._warrantyItemId);
/* 220 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 228 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 232 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyItemCrossReferenceDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */