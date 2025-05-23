/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCountBucketId;
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
/*     */ public class InventoryCountBucketDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 8376573L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private String _inventoryBucketId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _countCycle;
/*     */   private String _bucketStatus;
/*     */   private String _inventoryBucketName;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.inv_count_id, t.inv_bucket_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.count_cycle, t.bucket_status, t.inv_bucket_name FROM inv_count_bucket t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND inv_bucket_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.rtl_loc_id, t.inv_count_id, t.inv_bucket_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.count_cycle, t.bucket_status, t.inv_bucket_name FROM inv_count_bucket t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND inv_bucket_id = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_count_bucket(organization_id, rtl_loc_id, inv_count_id, inv_bucket_id, create_date, create_user_id, update_date, update_user_id, count_cycle, bucket_status, inv_bucket_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._inventoryCountId, this._inventoryBucketId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._countCycle, this._bucketStatus, this._inventoryBucketName } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 91, 12, 91, 12, 4, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_count_bucket SET update_date = ?, update_user_id = ?, count_cycle = ?, bucket_status = ?, inv_bucket_name = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._countCycle, this._bucketStatus, this._inventoryBucketName } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 4, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_count_bucket" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND inv_bucket_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND inv_bucket_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._retailLocationId, this._inventoryCountId, this._inventoryBucketId };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "inv_count_bucket";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new InventoryCountBucketFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryCountBucketFiller
/*     */     implements IFiller {
/*     */     private InventoryCountBucketDBA _parent;
/*     */     
/*     */     public InventoryCountBucketFiller(InventoryCountBucketDBA argParent) {
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
/*     */ 
/*     */       
/* 136 */       primitiveResult = argResultSet.getLong(2);
/* 137 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 138 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 142 */       this._parent._inventoryCountId = argResultSet.getString(3);
/* 143 */       this._parent._inventoryBucketId = argResultSet.getString(4);
/*     */       
/* 145 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 146 */       if (t5 != null) {
/* 147 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 155 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 156 */       if (t7 != null) {
/* 157 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */ 
/*     */       
/* 166 */       int i = argResultSet.getInt(9);
/* 167 */       if (i != 0 || argResultSet.getObject(9) != null) {
/* 168 */         this._parent._countCycle = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 172 */       this._parent._bucketStatus = argResultSet.getString(10);
/* 173 */       this._parent._inventoryBucketName = argResultSet.getString(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 178 */     argDAO.suppressStateChanges(true);
/* 179 */     InventoryCountBucketDAO dao = (InventoryCountBucketDAO)argDAO;
/* 180 */     dao.setOrganizationId(this._organizationId);
/* 181 */     dao.setRetailLocationId(this._retailLocationId);
/* 182 */     dao.setInventoryCountId(this._inventoryCountId);
/* 183 */     dao.setInventoryBucketId(this._inventoryBucketId);
/* 184 */     dao.setCreateDate(this._createDate);
/* 185 */     dao.setCreateUserId(this._createUserId);
/* 186 */     dao.setUpdateDate(this._updateDate);
/* 187 */     dao.setUpdateUserId(this._updateUserId);
/* 188 */     dao.setCountCycle(this._countCycle);
/* 189 */     dao.setBucketStatus(this._bucketStatus);
/* 190 */     dao.setInventoryBucketName(this._inventoryBucketName);
/* 191 */     argDAO.suppressStateChanges(false);
/* 192 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 196 */     return loadDAO((IDataAccessObject)new InventoryCountBucketDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 200 */     InventoryCountBucketDAO dao = (InventoryCountBucketDAO)argDAO;
/* 201 */     this._organizationId = dao.getOrganizationId();
/* 202 */     this._retailLocationId = dao.getRetailLocationId();
/* 203 */     this._inventoryCountId = dao.getInventoryCountId();
/* 204 */     this._inventoryBucketId = dao.getInventoryBucketId();
/* 205 */     this._createDate = dao.getCreateDate();
/* 206 */     this._createUserId = dao.getCreateUserId();
/* 207 */     this._updateDate = dao.getUpdateDate();
/* 208 */     this._updateUserId = dao.getUpdateUserId();
/* 209 */     this._countCycle = dao.getCountCycle();
/* 210 */     this._bucketStatus = dao.getBucketStatus();
/* 211 */     this._inventoryBucketName = dao.getInventoryBucketName();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 215 */     InventoryCountBucketId id = (InventoryCountBucketId)argId;
/* 216 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 217 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 218 */     argStatement.setString(3, id.getInventoryCountId());
/* 219 */     argStatement.setString(4, id.getInventoryBucketId());
/* 220 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 224 */     InventoryCountBucketId id = new InventoryCountBucketId();
/* 225 */     id.setOrganizationId(this._organizationId);
/* 226 */     id.setRetailLocationId(this._retailLocationId);
/* 227 */     id.setInventoryCountId(this._inventoryCountId);
/* 228 */     id.setInventoryBucketId(this._inventoryBucketId);
/* 229 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 237 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 241 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountBucketDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */