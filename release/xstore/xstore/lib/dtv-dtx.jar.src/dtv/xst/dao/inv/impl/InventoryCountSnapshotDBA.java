/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.IHasIncrementalValues;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCountSnapshotId;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryCountSnapshotDBA
/*     */   implements IJDBCTableAdapter, IHasIncrementalValues
/*     */ {
/*     */   private static final long serialVersionUID = 1348133911L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private String _inventoryLocationId;
/*     */   private String _inventoryBucketId;
/*     */   private String _itemId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _snapshotDate;
/*     */   private BigDecimal _quantity;
/*     */   private BigDecimal _initQuantity;
/*     */   protected boolean _incrementalActive = true;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.inv_count_id, t.inv_location_id, t.inv_bucket_id, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.snapshot_date, t.quantity FROM inv_count_snapshot t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND inv_location_id = ?  AND inv_bucket_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public void setIncrementalActive(boolean argActive) {
/*  41 */     this._incrementalActive = argActive;
/*     */   }
/*     */   
/*     */   public boolean getIncrementalActive() {
/*  45 */     return this._incrementalActive;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelect() {
/*  51 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  55 */     return "SELECT t.organization_id, t.rtl_loc_id, t.inv_count_id, t.inv_location_id, t.inv_bucket_id, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.snapshot_date, t.quantity FROM inv_count_snapshot t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  61 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND inv_location_id = ?  AND inv_bucket_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   
/*  64 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_count_snapshot(organization_id, rtl_loc_id, inv_count_id, inv_location_id, inv_bucket_id, item_id, create_date, create_user_id, update_date, update_user_id, snapshot_date, quantity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  67 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  71 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._inventoryCountId, this._inventoryLocationId, this._inventoryBucketId, this._itemId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._snapshotDate, this._quantity } };
/*  72 */     return insertParameterObject;
/*     */   }
/*     */   
/*  75 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 12, 12, 91, 12, 91, 12, 91, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  78 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*     */   public String[] getUpdate() {
/*  82 */     if (this._incrementalActive) {
/*  83 */       return getIncrementalUpdate();
/*     */     }
/*     */     
/*  86 */     return getStandardUpdate();
/*     */   }
/*     */ 
/*     */   
/*  90 */   private static final String[] INCREMENTAL_UPDATE_OBJECT = new String[] { "UPDATE inv_count_snapshot SET update_date = ?, update_user_id = ?, snapshot_date = ?, quantity = COALESCE(quantity,0) + ?" };
/*     */   
/*     */   public String[] getIncrementalUpdate() {
/*  93 */     return INCREMENTAL_UPDATE_OBJECT;
/*     */   }
/*     */   
/*  96 */   private static final String[] STANDARD_UPDATE_OBJECT = new String[] { "UPDATE inv_count_snapshot SET update_date = ?, update_user_id = ?, snapshot_date = ?, quantity = ?" };
/*     */   
/*     */   public String[] getStandardUpdate() {
/*  99 */     return STANDARD_UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 103 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._snapshotDate, getQuantityDiff() } };
/* 104 */     return updateParameterObject;
/*     */   }
/*     */   
/* 107 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 109 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 112 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_count_snapshot" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND inv_location_id = ?  AND inv_bucket_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 115 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 121 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND inv_location_id = ?  AND inv_bucket_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 124 */     return new Object[] { this._organizationId, this._retailLocationId, this._inventoryCountId, this._inventoryLocationId, this._inventoryBucketId, this._itemId };
/*     */   }
/*     */   
/* 127 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 130 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */ 
/*     */   
/*     */   private BigDecimal getQuantityDiff() {
/*     */     BigDecimal val1, val2;
/* 136 */     if (this._quantity == null) {
/* 137 */       val1 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 140 */       val1 = this._quantity;
/*     */     } 
/*     */     
/* 143 */     if (this._initQuantity == null) {
/* 144 */       val2 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 147 */       val2 = this._initQuantity;
/*     */     } 
/*     */     
/* 150 */     BigDecimal res = val1.subtract(val2);
/*     */     
/* 152 */     if (res.scale() < 8) {
/* 153 */       res = res.setScale(8);
/*     */     }
/*     */     
/* 156 */     return res;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 160 */     return "inv_count_snapshot";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 164 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 168 */     return new InventoryCountSnapshotFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryCountSnapshotFiller
/*     */     implements IFiller {
/*     */     private InventoryCountSnapshotDBA _parent;
/*     */     
/*     */     public InventoryCountSnapshotFiller(InventoryCountSnapshotDBA argParent) {
/* 176 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 181 */       long primitiveResult = argResultSet.getLong(1);
/* 182 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 183 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 189 */       primitiveResult = argResultSet.getLong(2);
/* 190 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 191 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 195 */       this._parent._inventoryCountId = argResultSet.getString(3);
/* 196 */       this._parent._inventoryLocationId = argResultSet.getString(4);
/* 197 */       this._parent._inventoryBucketId = argResultSet.getString(5);
/* 198 */       this._parent._itemId = argResultSet.getString(6);
/*     */       
/* 200 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 201 */       if (t7 != null) {
/* 202 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 205 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 208 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 210 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 211 */       if (t9 != null) {
/* 212 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 215 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 218 */       this._parent._updateUserId = argResultSet.getString(10);
/*     */       
/* 220 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 221 */       if (t11 != null) {
/* 222 */         this._parent._snapshotDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 225 */         this._parent._snapshotDate = null;
/*     */       } 
/*     */       
/* 228 */       this._parent._quantity = argResultSet.getBigDecimal(12);
/* 229 */       this._parent._initQuantity = argResultSet.getBigDecimal(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 234 */     argDAO.suppressStateChanges(true);
/* 235 */     InventoryCountSnapshotDAO dao = (InventoryCountSnapshotDAO)argDAO;
/* 236 */     dao.setOrganizationId(this._organizationId);
/* 237 */     dao.setRetailLocationId(this._retailLocationId);
/* 238 */     dao.setInventoryCountId(this._inventoryCountId);
/* 239 */     dao.setInventoryLocationId(this._inventoryLocationId);
/* 240 */     dao.setInventoryBucketId(this._inventoryBucketId);
/* 241 */     dao.setItemId(this._itemId);
/* 242 */     dao.setCreateDate(this._createDate);
/* 243 */     dao.setCreateUserId(this._createUserId);
/* 244 */     dao.setUpdateDate(this._updateDate);
/* 245 */     dao.setUpdateUserId(this._updateUserId);
/* 246 */     dao.setSnapshotDate(this._snapshotDate);
/* 247 */     dao.setQuantity(this._quantity);
/* 248 */     dao.setInitQuantity(this._quantity);
/* 249 */     argDAO.suppressStateChanges(false);
/* 250 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 254 */     return loadDAO((IDataAccessObject)new InventoryCountSnapshotDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 258 */     InventoryCountSnapshotDAO dao = (InventoryCountSnapshotDAO)argDAO;
/* 259 */     this._organizationId = dao.getOrganizationId();
/* 260 */     this._retailLocationId = dao.getRetailLocationId();
/* 261 */     this._inventoryCountId = dao.getInventoryCountId();
/* 262 */     this._inventoryLocationId = dao.getInventoryLocationId();
/* 263 */     this._inventoryBucketId = dao.getInventoryBucketId();
/* 264 */     this._itemId = dao.getItemId();
/* 265 */     this._createDate = dao.getCreateDate();
/* 266 */     this._createUserId = dao.getCreateUserId();
/* 267 */     this._updateDate = dao.getUpdateDate();
/* 268 */     this._updateUserId = dao.getUpdateUserId();
/* 269 */     this._snapshotDate = dao.getSnapshotDate();
/* 270 */     this._quantity = dao.getQuantity();
/* 271 */     this._initQuantity = dao.getInitQuantity();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 275 */     InventoryCountSnapshotId id = (InventoryCountSnapshotId)argId;
/* 276 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 277 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 278 */     argStatement.setString(3, id.getInventoryCountId());
/* 279 */     argStatement.setString(4, id.getInventoryLocationId());
/* 280 */     argStatement.setString(5, id.getInventoryBucketId());
/* 281 */     argStatement.setString(6, id.getItemId());
/* 282 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 286 */     InventoryCountSnapshotId id = new InventoryCountSnapshotId();
/* 287 */     id.setOrganizationId(this._organizationId);
/* 288 */     id.setRetailLocationId(this._retailLocationId);
/* 289 */     id.setInventoryCountId(this._inventoryCountId);
/* 290 */     id.setInventoryLocationId(this._inventoryLocationId);
/* 291 */     id.setInventoryBucketId(this._inventoryBucketId);
/* 292 */     id.setItemId(this._itemId);
/* 293 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 301 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 305 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSnapshotDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */