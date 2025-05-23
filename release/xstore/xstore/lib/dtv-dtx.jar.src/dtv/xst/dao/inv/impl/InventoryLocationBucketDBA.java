/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryLocationBucketId;
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
/*     */ public class InventoryLocationBucketDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 415344219L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _locationId;
/*     */   private String _bucketId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _trackingMethod;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.location_id, t.bucket_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.tracking_method FROM inv_location_bucket t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND location_id = ?  AND bucket_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.organization_id, t.rtl_loc_id, t.location_id, t.bucket_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.tracking_method FROM inv_location_bucket t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  48 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND location_id = ?  AND bucket_id = ?  ";
/*     */   }
/*     */   
/*  51 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_location_bucket(organization_id, rtl_loc_id, location_id, bucket_id, create_date, create_user_id, update_date, update_user_id, tracking_method) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  54 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  58 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._locationId, this._bucketId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._trackingMethod } };
/*  59 */     return insertParameterObject;
/*     */   }
/*     */   
/*  62 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 91, 12, 91, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  65 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  68 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_location_bucket SET update_date = ?, update_user_id = ?, tracking_method = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  71 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  75 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._trackingMethod } };
/*  76 */     return updateParameterObject;
/*     */   }
/*     */   
/*  79 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  81 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_location_bucket" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND location_id = ?  AND bucket_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  87 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  93 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND location_id = ?  AND bucket_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  96 */     return new Object[] { this._organizationId, this._retailLocationId, this._locationId, this._bucketId };
/*     */   }
/*     */   
/*  99 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 102 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 105 */     return "inv_location_bucket";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 109 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 113 */     return new InventoryLocationBucketFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryLocationBucketFiller
/*     */     implements IFiller {
/*     */     private InventoryLocationBucketDBA _parent;
/*     */     
/*     */     public InventoryLocationBucketFiller(InventoryLocationBucketDBA argParent) {
/* 121 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 126 */       long primitiveResult = argResultSet.getLong(1);
/* 127 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 128 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       primitiveResult = argResultSet.getLong(2);
/* 135 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 136 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 140 */       this._parent._locationId = argResultSet.getString(3);
/* 141 */       this._parent._bucketId = argResultSet.getString(4);
/*     */       
/* 143 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 144 */       if (t5 != null) {
/* 145 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 148 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 151 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 153 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 154 */       if (t7 != null) {
/* 155 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 158 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 161 */       this._parent._updateUserId = argResultSet.getString(8);
/* 162 */       this._parent._trackingMethod = argResultSet.getString(9);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 167 */     argDAO.suppressStateChanges(true);
/* 168 */     InventoryLocationBucketDAO dao = (InventoryLocationBucketDAO)argDAO;
/* 169 */     dao.setOrganizationId(this._organizationId);
/* 170 */     dao.setRetailLocationId(this._retailLocationId);
/* 171 */     dao.setLocationId(this._locationId);
/* 172 */     dao.setBucketId(this._bucketId);
/* 173 */     dao.setCreateDate(this._createDate);
/* 174 */     dao.setCreateUserId(this._createUserId);
/* 175 */     dao.setUpdateDate(this._updateDate);
/* 176 */     dao.setUpdateUserId(this._updateUserId);
/* 177 */     dao.setTrackingMethod(this._trackingMethod);
/* 178 */     argDAO.suppressStateChanges(false);
/* 179 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 183 */     return loadDAO((IDataAccessObject)new InventoryLocationBucketDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 187 */     InventoryLocationBucketDAO dao = (InventoryLocationBucketDAO)argDAO;
/* 188 */     this._organizationId = dao.getOrganizationId();
/* 189 */     this._retailLocationId = dao.getRetailLocationId();
/* 190 */     this._locationId = dao.getLocationId();
/* 191 */     this._bucketId = dao.getBucketId();
/* 192 */     this._createDate = dao.getCreateDate();
/* 193 */     this._createUserId = dao.getCreateUserId();
/* 194 */     this._updateDate = dao.getUpdateDate();
/* 195 */     this._updateUserId = dao.getUpdateUserId();
/* 196 */     this._trackingMethod = dao.getTrackingMethod();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 200 */     InventoryLocationBucketId id = (InventoryLocationBucketId)argId;
/* 201 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 202 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 203 */     argStatement.setString(3, id.getLocationId());
/* 204 */     argStatement.setString(4, id.getBucketId());
/* 205 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 209 */     InventoryLocationBucketId id = new InventoryLocationBucketId();
/* 210 */     id.setOrganizationId(this._organizationId);
/* 211 */     id.setRetailLocationId(this._retailLocationId);
/* 212 */     id.setLocationId(this._locationId);
/* 213 */     id.setBucketId(this._bucketId);
/* 214 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 222 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 226 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryLocationBucketDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */