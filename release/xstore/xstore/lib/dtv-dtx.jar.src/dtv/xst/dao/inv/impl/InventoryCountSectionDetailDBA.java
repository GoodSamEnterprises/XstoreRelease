/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCountSectionDetailId;
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
/*     */ public class InventoryCountSectionDetailDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1362489635L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryBucketId;
/*     */   private String _sectionId;
/*     */   private Integer _sectionDetailNumber;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _merchandiseHierarchyLevel;
/*     */   private String _merchandiseHierarchyId;
/*     */   private String _description;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.inv_bucket_id, t.section_id, t.section_detail_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.merch_hierarchy_level, t.merch_hierarchy_id, t.description FROM inv_count_section_detail t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_bucket_id = ?  AND section_id = ?  AND section_detail_nbr = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.rtl_loc_id, t.inv_bucket_id, t.section_id, t.section_detail_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.merch_hierarchy_level, t.merch_hierarchy_id, t.description FROM inv_count_section_detail t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_bucket_id = ?  AND section_id = ?  AND section_detail_nbr = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_count_section_detail(organization_id, rtl_loc_id, inv_bucket_id, section_id, section_detail_nbr, create_date, create_user_id, update_date, update_user_id, merch_hierarchy_level, merch_hierarchy_id, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._inventoryBucketId, this._sectionId, this._sectionDetailNumber, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._merchandiseHierarchyLevel, this._merchandiseHierarchyId, this._description } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 4, 91, 12, 91, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_count_section_detail SET update_date = ?, update_user_id = ?, merch_hierarchy_level = ?, merch_hierarchy_id = ?, description = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._merchandiseHierarchyLevel, this._merchandiseHierarchyId, this._description } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_count_section_detail" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_bucket_id = ?  AND section_id = ?  AND section_detail_nbr = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_bucket_id = ?  AND section_id = ?  AND section_detail_nbr = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._retailLocationId, this._inventoryBucketId, this._sectionId, this._sectionDetailNumber };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "inv_count_section_detail";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new InventoryCountSectionDetailFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryCountSectionDetailFiller
/*     */     implements IFiller {
/*     */     private InventoryCountSectionDetailDBA _parent;
/*     */     
/*     */     public InventoryCountSectionDetailFiller(InventoryCountSectionDetailDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long l = argResultSet.getLong(1);
/* 130 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 137 */       l = argResultSet.getLong(2);
/* 138 */       if (l != 0L || argResultSet.getObject(2) != null) {
/* 139 */         this._parent._retailLocationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 143 */       this._parent._inventoryBucketId = argResultSet.getString(3);
/* 144 */       this._parent._sectionId = argResultSet.getString(4);
/*     */ 
/*     */       
/* 147 */       int primitiveResult = argResultSet.getInt(5);
/* 148 */       if (primitiveResult != 0 || argResultSet.getObject(5) != null) {
/* 149 */         this._parent._sectionDetailNumber = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 154 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 155 */       if (t6 != null) {
/* 156 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 162 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 164 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 165 */       if (t8 != null) {
/* 166 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 169 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 172 */       this._parent._updateUserId = argResultSet.getString(9);
/* 173 */       this._parent._merchandiseHierarchyLevel = argResultSet.getString(10);
/* 174 */       this._parent._merchandiseHierarchyId = argResultSet.getString(11);
/* 175 */       this._parent._description = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 180 */     argDAO.suppressStateChanges(true);
/* 181 */     InventoryCountSectionDetailDAO dao = (InventoryCountSectionDetailDAO)argDAO;
/* 182 */     dao.setOrganizationId(this._organizationId);
/* 183 */     dao.setRetailLocationId(this._retailLocationId);
/* 184 */     dao.setInventoryBucketId(this._inventoryBucketId);
/* 185 */     dao.setSectionId(this._sectionId);
/* 186 */     dao.setSectionDetailNumber(this._sectionDetailNumber);
/* 187 */     dao.setCreateDate(this._createDate);
/* 188 */     dao.setCreateUserId(this._createUserId);
/* 189 */     dao.setUpdateDate(this._updateDate);
/* 190 */     dao.setUpdateUserId(this._updateUserId);
/* 191 */     dao.setMerchandiseHierarchyLevel(this._merchandiseHierarchyLevel);
/* 192 */     dao.setMerchandiseHierarchyId(this._merchandiseHierarchyId);
/* 193 */     dao.setDescription(this._description);
/* 194 */     argDAO.suppressStateChanges(false);
/* 195 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 199 */     return loadDAO((IDataAccessObject)new InventoryCountSectionDetailDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 203 */     InventoryCountSectionDetailDAO dao = (InventoryCountSectionDetailDAO)argDAO;
/* 204 */     this._organizationId = dao.getOrganizationId();
/* 205 */     this._retailLocationId = dao.getRetailLocationId();
/* 206 */     this._inventoryBucketId = dao.getInventoryBucketId();
/* 207 */     this._sectionId = dao.getSectionId();
/* 208 */     this._sectionDetailNumber = dao.getSectionDetailNumber();
/* 209 */     this._createDate = dao.getCreateDate();
/* 210 */     this._createUserId = dao.getCreateUserId();
/* 211 */     this._updateDate = dao.getUpdateDate();
/* 212 */     this._updateUserId = dao.getUpdateUserId();
/* 213 */     this._merchandiseHierarchyLevel = dao.getMerchandiseHierarchyLevel();
/* 214 */     this._merchandiseHierarchyId = dao.getMerchandiseHierarchyId();
/* 215 */     this._description = dao.getDescription();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 219 */     InventoryCountSectionDetailId id = (InventoryCountSectionDetailId)argId;
/* 220 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 221 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 222 */     argStatement.setString(3, id.getInventoryBucketId());
/* 223 */     argStatement.setString(4, id.getSectionId());
/* 224 */     argStatement.setInt(5, id.getSectionDetailNumber().intValue());
/* 225 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 229 */     InventoryCountSectionDetailId id = new InventoryCountSectionDetailId();
/* 230 */     id.setOrganizationId(this._organizationId);
/* 231 */     id.setRetailLocationId(this._retailLocationId);
/* 232 */     id.setInventoryBucketId(this._inventoryBucketId);
/* 233 */     id.setSectionId(this._sectionId);
/* 234 */     id.setSectionDetailNumber(this._sectionDetailNumber);
/* 235 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 243 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 247 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSectionDetailDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */