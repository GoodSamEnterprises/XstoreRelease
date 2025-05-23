/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCountId;
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
/*     */ public class InventoryCountDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1061122765L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _description;
/*     */   private String _typeCode;
/*     */   private Date _beginDate;
/*     */   private Date _endDate;
/*     */   private String _countStatus;
/*     */   private Boolean _storeCreated;
/*     */   private Boolean _void;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.inv_count_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description, t.inv_count_typcode, t.begin_date, t.end_date, t.count_status, t.store_created_flag, t.void_flag FROM inv_count t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.rtl_loc_id, t.inv_count_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.description, t.inv_count_typcode, t.begin_date, t.end_date, t.count_status, t.store_created_flag, t.void_flag FROM inv_count t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_count(organization_id, rtl_loc_id, inv_count_id, create_date, create_user_id, update_date, update_user_id, description, inv_count_typcode, begin_date, end_date, count_status, store_created_flag, void_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._inventoryCountId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._description, this._typeCode, this._beginDate, this._endDate, this._countStatus, this._storeCreated, this._void } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 91, 12, 91, 12, 12, 12, 91, 91, 12, -7, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_count SET update_date = ?, update_user_id = ?, description = ?, inv_count_typcode = ?, begin_date = ?, end_date = ?, count_status = ?, store_created_flag = ?, void_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._description, this._typeCode, this._beginDate, this._endDate, this._countStatus, this._storeCreated, this._void } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 91, 91, 12, -7, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_count" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._retailLocationId, this._inventoryCountId };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "inv_count";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new InventoryCountFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryCountFiller
/*     */     implements IFiller {
/*     */     private InventoryCountDBA _parent;
/*     */     
/*     */     public InventoryCountFiller(InventoryCountDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long primitiveResult = argResultSet.getLong(1);
/* 132 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       primitiveResult = argResultSet.getLong(2);
/* 140 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 141 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 145 */       this._parent._inventoryCountId = argResultSet.getString(3);
/*     */       
/* 147 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 148 */       if (t4 != null) {
/* 149 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 155 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 157 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 158 */       if (t6 != null) {
/* 159 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 162 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 165 */       this._parent._updateUserId = argResultSet.getString(7);
/* 166 */       this._parent._description = argResultSet.getString(8);
/* 167 */       this._parent._typeCode = argResultSet.getString(9);
/*     */       
/* 169 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 170 */       if (t10 != null) {
/* 171 */         this._parent._beginDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 174 */         this._parent._beginDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 178 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 179 */       if (t11 != null) {
/* 180 */         this._parent._endDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 183 */         this._parent._endDate = null;
/*     */       } 
/*     */       
/* 186 */       this._parent._countStatus = argResultSet.getString(12);
/* 187 */       this._parent._storeCreated = Boolean.valueOf(argResultSet.getBoolean(13));
/* 188 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(14));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 193 */     argDAO.suppressStateChanges(true);
/* 194 */     InventoryCountDAO dao = (InventoryCountDAO)argDAO;
/* 195 */     dao.setOrganizationId(this._organizationId);
/* 196 */     dao.setRetailLocationId(this._retailLocationId);
/* 197 */     dao.setInventoryCountId(this._inventoryCountId);
/* 198 */     dao.setCreateDate(this._createDate);
/* 199 */     dao.setCreateUserId(this._createUserId);
/* 200 */     dao.setUpdateDate(this._updateDate);
/* 201 */     dao.setUpdateUserId(this._updateUserId);
/* 202 */     dao.setDescription(this._description);
/* 203 */     dao.setTypeCode(this._typeCode);
/* 204 */     dao.setBeginDate(this._beginDate);
/* 205 */     dao.setEndDate(this._endDate);
/* 206 */     dao.setCountStatus(this._countStatus);
/* 207 */     dao.setStoreCreated(this._storeCreated);
/* 208 */     dao.setVoid(this._void);
/* 209 */     argDAO.suppressStateChanges(false);
/* 210 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 214 */     return loadDAO((IDataAccessObject)new InventoryCountDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 218 */     InventoryCountDAO dao = (InventoryCountDAO)argDAO;
/* 219 */     this._organizationId = dao.getOrganizationId();
/* 220 */     this._retailLocationId = dao.getRetailLocationId();
/* 221 */     this._inventoryCountId = dao.getInventoryCountId();
/* 222 */     this._createDate = dao.getCreateDate();
/* 223 */     this._createUserId = dao.getCreateUserId();
/* 224 */     this._updateDate = dao.getUpdateDate();
/* 225 */     this._updateUserId = dao.getUpdateUserId();
/* 226 */     this._description = dao.getDescription();
/* 227 */     this._typeCode = dao.getTypeCode();
/* 228 */     this._beginDate = dao.getBeginDate();
/* 229 */     this._endDate = dao.getEndDate();
/* 230 */     this._countStatus = dao.getCountStatus();
/* 231 */     this._storeCreated = (dao.getStoreCreated() != null) ? dao.getStoreCreated() : Boolean.valueOf(false);
/* 232 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 236 */     InventoryCountId id = (InventoryCountId)argId;
/* 237 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 238 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 239 */     argStatement.setString(3, id.getInventoryCountId());
/* 240 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 244 */     InventoryCountId id = new InventoryCountId();
/* 245 */     id.setOrganizationId(this._organizationId);
/* 246 */     id.setRetailLocationId(this._retailLocationId);
/* 247 */     id.setInventoryCountId(this._inventoryCountId);
/* 248 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 256 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 260 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */