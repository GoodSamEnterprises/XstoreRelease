/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryBucketId;
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
/*     */ public class InventoryBucketDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1441305158L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _bucketId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _name;
/*     */   private String _functionCode;
/*     */   private String _adjustmentAction;
/*     */   private String _defaultLocationId;
/*     */   private Boolean _systemBucket;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.bucket_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.name, t.function_code, t.adjustment_action, t.default_location_id, t.system_bucket_flag FROM inv_bucket t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND bucket_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.rtl_loc_id, t.bucket_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.name, t.function_code, t.adjustment_action, t.default_location_id, t.system_bucket_flag FROM inv_bucket t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND bucket_id = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_bucket(organization_id, rtl_loc_id, bucket_id, create_date, create_user_id, update_date, update_user_id, name, function_code, adjustment_action, default_location_id, system_bucket_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._bucketId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._name, this._functionCode, this._adjustmentAction, this._defaultLocationId, this._systemBucket } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 91, 12, 91, 12, 12, 12, 12, 12, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_bucket SET update_date = ?, update_user_id = ?, name = ?, function_code = ?, adjustment_action = ?, default_location_id = ?, system_bucket_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._name, this._functionCode, this._adjustmentAction, this._defaultLocationId, this._systemBucket } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_bucket" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND bucket_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND bucket_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._retailLocationId, this._bucketId };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "inv_bucket";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new InventoryBucketFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryBucketFiller
/*     */     implements IFiller {
/*     */     private InventoryBucketDBA _parent;
/*     */     
/*     */     public InventoryBucketFiller(InventoryBucketDBA argParent) {
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
/*     */ 
/*     */       
/* 137 */       primitiveResult = argResultSet.getLong(2);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 139 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 143 */       this._parent._bucketId = argResultSet.getString(3);
/*     */       
/* 145 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 146 */       if (t4 != null) {
/* 147 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 150 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 153 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 155 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 156 */       if (t6 != null) {
/* 157 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 160 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 163 */       this._parent._updateUserId = argResultSet.getString(7);
/* 164 */       this._parent._name = argResultSet.getString(8);
/* 165 */       this._parent._functionCode = argResultSet.getString(9);
/* 166 */       this._parent._adjustmentAction = argResultSet.getString(10);
/* 167 */       this._parent._defaultLocationId = argResultSet.getString(11);
/* 168 */       this._parent._systemBucket = Boolean.valueOf(argResultSet.getBoolean(12));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 173 */     argDAO.suppressStateChanges(true);
/* 174 */     InventoryBucketDAO dao = (InventoryBucketDAO)argDAO;
/* 175 */     dao.setOrganizationId(this._organizationId);
/* 176 */     dao.setRetailLocationId(this._retailLocationId);
/* 177 */     dao.setBucketId(this._bucketId);
/* 178 */     dao.setCreateDate(this._createDate);
/* 179 */     dao.setCreateUserId(this._createUserId);
/* 180 */     dao.setUpdateDate(this._updateDate);
/* 181 */     dao.setUpdateUserId(this._updateUserId);
/* 182 */     dao.setName(this._name);
/* 183 */     dao.setFunctionCode(this._functionCode);
/* 184 */     dao.setAdjustmentAction(this._adjustmentAction);
/* 185 */     dao.setDefaultLocationId(this._defaultLocationId);
/* 186 */     dao.setSystemBucket(this._systemBucket);
/* 187 */     argDAO.suppressStateChanges(false);
/* 188 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 192 */     return loadDAO((IDataAccessObject)new InventoryBucketDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 196 */     InventoryBucketDAO dao = (InventoryBucketDAO)argDAO;
/* 197 */     this._organizationId = dao.getOrganizationId();
/* 198 */     this._retailLocationId = dao.getRetailLocationId();
/* 199 */     this._bucketId = dao.getBucketId();
/* 200 */     this._createDate = dao.getCreateDate();
/* 201 */     this._createUserId = dao.getCreateUserId();
/* 202 */     this._updateDate = dao.getUpdateDate();
/* 203 */     this._updateUserId = dao.getUpdateUserId();
/* 204 */     this._name = dao.getName();
/* 205 */     this._functionCode = dao.getFunctionCode();
/* 206 */     this._adjustmentAction = dao.getAdjustmentAction();
/* 207 */     this._defaultLocationId = dao.getDefaultLocationId();
/* 208 */     this._systemBucket = (dao.getSystemBucket() != null) ? dao.getSystemBucket() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 212 */     InventoryBucketId id = (InventoryBucketId)argId;
/* 213 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 214 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 215 */     argStatement.setString(3, id.getBucketId());
/* 216 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 220 */     InventoryBucketId id = new InventoryBucketId();
/* 221 */     id.setOrganizationId(this._organizationId);
/* 222 */     id.setRetailLocationId(this._retailLocationId);
/* 223 */     id.setBucketId(this._bucketId);
/* 224 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 232 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 236 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryBucketDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */