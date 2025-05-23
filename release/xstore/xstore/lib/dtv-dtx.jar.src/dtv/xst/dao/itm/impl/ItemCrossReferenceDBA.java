/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.ItemCrossReferenceId;
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
/*     */ public class ItemCrossReferenceDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1694348542L;
/*     */   private String _manufacturerUpc;
/*     */   private Long _organizationId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _manufacturer;
/*     */   private String _itemId;
/*     */   private Boolean _primaryFlag;
/*     */   private static final String SELECT_OBJECT = "SELECT t.manufacturer_upc, t.organization_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.manufacturer, t.item_id, t.primary_flag FROM itm_item_cross_reference t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE manufacturer_upc = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.manufacturer_upc, t.organization_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.manufacturer, t.item_id, t.primary_flag FROM itm_item_cross_reference t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE manufacturer_upc = ?  AND organization_id = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_cross_reference(manufacturer_upc, organization_id, org_code, org_value, create_date, create_user_id, update_date, update_user_id, manufacturer, item_id, primary_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._manufacturerUpc, this._organizationId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._manufacturer, this._itemId, this._primaryFlag } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 12, 91, 12, 91, 12, 12, 12, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_cross_reference SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, manufacturer = ?, item_id = ?, primary_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._manufacturer, this._itemId, this._primaryFlag } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 12, 12, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_cross_reference" }; private static final String WHERE_OBJECT = " WHERE manufacturer_upc = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE manufacturer_upc = ?  AND organization_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._manufacturerUpc, this._organizationId };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "itm_item_cross_reference";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new ItemCrossReferenceFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemCrossReferenceFiller
/*     */     implements IFiller {
/*     */     private ItemCrossReferenceDBA _parent;
/*     */     
/*     */     public ItemCrossReferenceFiller(ItemCrossReferenceDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 126 */       this._parent._manufacturerUpc = argResultSet.getString(1);
/*     */ 
/*     */       
/* 129 */       long primitiveResult = argResultSet.getLong(2);
/* 130 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 135 */       this._parent._orgCode = argResultSet.getString(3);
/* 136 */       this._parent._orgValue = argResultSet.getString(4);
/*     */       
/* 138 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 139 */       if (t5 != null) {
/* 140 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 143 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 146 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 148 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 149 */       if (t7 != null) {
/* 150 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 153 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 156 */       this._parent._updateUserId = argResultSet.getString(8);
/* 157 */       this._parent._manufacturer = argResultSet.getString(9);
/* 158 */       this._parent._itemId = argResultSet.getString(10);
/* 159 */       this._parent._primaryFlag = Boolean.valueOf(argResultSet.getBoolean(11));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 164 */     argDAO.suppressStateChanges(true);
/* 165 */     ItemCrossReferenceDAO dao = (ItemCrossReferenceDAO)argDAO;
/* 166 */     dao.setManufacturerUpc(this._manufacturerUpc);
/* 167 */     dao.setOrganizationId(this._organizationId);
/* 168 */     dao.setOrgCode(this._orgCode);
/* 169 */     dao.setOrgValue(this._orgValue);
/* 170 */     dao.setCreateDate(this._createDate);
/* 171 */     dao.setCreateUserId(this._createUserId);
/* 172 */     dao.setUpdateDate(this._updateDate);
/* 173 */     dao.setUpdateUserId(this._updateUserId);
/* 174 */     dao.setManufacturer(this._manufacturer);
/* 175 */     dao.setItemId(this._itemId);
/* 176 */     dao.setPrimaryFlag(this._primaryFlag);
/* 177 */     argDAO.suppressStateChanges(false);
/* 178 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 182 */     return loadDAO((IDataAccessObject)new ItemCrossReferenceDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 186 */     ItemCrossReferenceDAO dao = (ItemCrossReferenceDAO)argDAO;
/* 187 */     this._manufacturerUpc = dao.getManufacturerUpc();
/* 188 */     this._organizationId = dao.getOrganizationId();
/* 189 */     this._orgCode = dao.getOrgCode();
/* 190 */     this._orgValue = dao.getOrgValue();
/* 191 */     this._createDate = dao.getCreateDate();
/* 192 */     this._createUserId = dao.getCreateUserId();
/* 193 */     this._updateDate = dao.getUpdateDate();
/* 194 */     this._updateUserId = dao.getUpdateUserId();
/* 195 */     this._manufacturer = dao.getManufacturer();
/* 196 */     this._itemId = dao.getItemId();
/* 197 */     this._primaryFlag = (dao.getPrimaryFlag() != null) ? dao.getPrimaryFlag() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 201 */     ItemCrossReferenceId id = (ItemCrossReferenceId)argId;
/* 202 */     argStatement.setString(1, id.getManufacturerUpc());
/* 203 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 204 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 208 */     ItemCrossReferenceId id = new ItemCrossReferenceId();
/* 209 */     id.setManufacturerUpc(this._manufacturerUpc);
/* 210 */     id.setOrganizationId(this._organizationId);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemCrossReferenceDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */