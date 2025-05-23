/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCountSectionId;
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
/*     */ 
/*     */ public class InventoryCountSectionDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 2004539954L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryBucketId;
/*     */   private String _sectionId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _sortOrder;
/*     */   private String _inventoryBucketName;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.inv_bucket_id, t.section_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.sort_order, t.inv_bucket_name FROM inv_count_section t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_bucket_id = ?  AND section_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.rtl_loc_id, t.inv_bucket_id, t.section_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.sort_order, t.inv_bucket_name FROM inv_count_section t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_bucket_id = ?  AND section_id = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_count_section(organization_id, rtl_loc_id, inv_bucket_id, section_id, create_date, create_user_id, update_date, update_user_id, sort_order, inv_bucket_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._inventoryBucketId, this._sectionId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._sortOrder, this._inventoryBucketName } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 91, 12, 91, 12, 4, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_count_section SET update_date = ?, update_user_id = ?, sort_order = ?, inv_bucket_name = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._sortOrder, this._inventoryBucketName } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 4, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_count_section" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_bucket_id = ?  AND section_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_bucket_id = ?  AND section_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._retailLocationId, this._inventoryBucketId, this._sectionId };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "inv_count_section";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new InventoryCountSectionFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryCountSectionFiller
/*     */     implements IFiller {
/*     */     private InventoryCountSectionDBA _parent;
/*     */     
/*     */     public InventoryCountSectionFiller(InventoryCountSectionDBA argParent) {
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
/*     */ 
/*     */       
/* 135 */       primitiveResult = argResultSet.getLong(2);
/* 136 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 137 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 141 */       this._parent._inventoryBucketId = argResultSet.getString(3);
/* 142 */       this._parent._sectionId = argResultSet.getString(4);
/*     */       
/* 144 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 145 */       if (t5 != null) {
/* 146 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 154 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 155 */       if (t7 != null) {
/* 156 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 162 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */ 
/*     */       
/* 165 */       int i = argResultSet.getInt(9);
/* 166 */       if (i != 0 || argResultSet.getObject(9) != null) {
/* 167 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 171 */       this._parent._inventoryBucketName = argResultSet.getString(10);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 176 */     argDAO.suppressStateChanges(true);
/* 177 */     InventoryCountSectionDAO dao = (InventoryCountSectionDAO)argDAO;
/* 178 */     dao.setOrganizationId(this._organizationId);
/* 179 */     dao.setRetailLocationId(this._retailLocationId);
/* 180 */     dao.setInventoryBucketId(this._inventoryBucketId);
/* 181 */     dao.setSectionId(this._sectionId);
/* 182 */     dao.setCreateDate(this._createDate);
/* 183 */     dao.setCreateUserId(this._createUserId);
/* 184 */     dao.setUpdateDate(this._updateDate);
/* 185 */     dao.setUpdateUserId(this._updateUserId);
/* 186 */     dao.setSortOrder(this._sortOrder);
/* 187 */     dao.setInventoryBucketName(this._inventoryBucketName);
/* 188 */     argDAO.suppressStateChanges(false);
/* 189 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 193 */     return loadDAO((IDataAccessObject)new InventoryCountSectionDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 197 */     InventoryCountSectionDAO dao = (InventoryCountSectionDAO)argDAO;
/* 198 */     this._organizationId = dao.getOrganizationId();
/* 199 */     this._retailLocationId = dao.getRetailLocationId();
/* 200 */     this._inventoryBucketId = dao.getInventoryBucketId();
/* 201 */     this._sectionId = dao.getSectionId();
/* 202 */     this._createDate = dao.getCreateDate();
/* 203 */     this._createUserId = dao.getCreateUserId();
/* 204 */     this._updateDate = dao.getUpdateDate();
/* 205 */     this._updateUserId = dao.getUpdateUserId();
/* 206 */     this._sortOrder = dao.getSortOrder();
/* 207 */     this._inventoryBucketName = dao.getInventoryBucketName();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 211 */     InventoryCountSectionId id = (InventoryCountSectionId)argId;
/* 212 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 213 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 214 */     argStatement.setString(3, id.getInventoryBucketId());
/* 215 */     argStatement.setString(4, id.getSectionId());
/* 216 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 220 */     InventoryCountSectionId id = new InventoryCountSectionId();
/* 221 */     id.setOrganizationId(this._organizationId);
/* 222 */     id.setRetailLocationId(this._retailLocationId);
/* 223 */     id.setInventoryBucketId(this._inventoryBucketId);
/* 224 */     id.setSectionId(this._sectionId);
/* 225 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 233 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 237 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSectionDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */