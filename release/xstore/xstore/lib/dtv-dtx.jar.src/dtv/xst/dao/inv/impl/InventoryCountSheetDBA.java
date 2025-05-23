/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCountSheetId;
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
/*     */ public class InventoryCountSheetDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1369888788L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private Integer _countSheetNumber;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _inventoryBucketId;
/*     */   private Integer _sectionNumber;
/*     */   private String _sectionId;
/*     */   private Integer _countCycle;
/*     */   private String _sheetStatus;
/*     */   private Boolean _checkedOut;
/*     */   private String _inventoryBucketName;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.inv_count_id, t.count_sheet_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.inv_bucket_id, t.section_nbr, t.section_id, t.count_cycle, t.sheet_status, t.checked_out_flag, t.inv_bucket_name FROM inv_count_sheet t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND count_sheet_nbr = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  44 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  48 */     return "SELECT t.organization_id, t.rtl_loc_id, t.inv_count_id, t.count_sheet_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.inv_bucket_id, t.section_nbr, t.section_id, t.count_cycle, t.sheet_status, t.checked_out_flag, t.inv_bucket_name FROM inv_count_sheet t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  54 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND count_sheet_nbr = ?  ";
/*     */   }
/*     */   
/*  57 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_count_sheet(organization_id, rtl_loc_id, inv_count_id, count_sheet_nbr, create_date, create_user_id, update_date, update_user_id, inv_bucket_id, section_nbr, section_id, count_cycle, sheet_status, checked_out_flag, inv_bucket_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  60 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  64 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._inventoryCountId, this._countSheetNumber, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._inventoryBucketId, this._sectionNumber, this._sectionId, this._countCycle, this._sheetStatus, this._checkedOut, this._inventoryBucketName } };
/*  65 */     return insertParameterObject;
/*     */   }
/*     */   
/*  68 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 4, 91, 12, 91, 12, 12, 4, 12, 4, 12, -7, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  71 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  74 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_count_sheet SET update_date = ?, update_user_id = ?, inv_bucket_id = ?, section_nbr = ?, section_id = ?, count_cycle = ?, sheet_status = ?, checked_out_flag = ?, inv_bucket_name = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._inventoryBucketId, this._sectionNumber, this._sectionId, this._countCycle, this._sheetStatus, this._checkedOut, this._inventoryBucketName } };
/*  82 */     return updateParameterObject;
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 4, 12, 4, 12, -7, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  87 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  90 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_count_sheet" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND count_sheet_nbr = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  93 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  99 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND count_sheet_nbr = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 102 */     return new Object[] { this._organizationId, this._retailLocationId, this._inventoryCountId, this._countSheetNumber };
/*     */   }
/*     */   
/* 105 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 108 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 111 */     return "inv_count_sheet";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 115 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 119 */     return new InventoryCountSheetFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryCountSheetFiller
/*     */     implements IFiller {
/*     */     private InventoryCountSheetDBA _parent;
/*     */     
/*     */     public InventoryCountSheetFiller(InventoryCountSheetDBA argParent) {
/* 127 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 132 */       long l = argResultSet.getLong(1);
/* 133 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 134 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 140 */       l = argResultSet.getLong(2);
/* 141 */       if (l != 0L || argResultSet.getObject(2) != null) {
/* 142 */         this._parent._retailLocationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 146 */       this._parent._inventoryCountId = argResultSet.getString(3);
/*     */ 
/*     */       
/* 149 */       int primitiveResult = argResultSet.getInt(4);
/* 150 */       if (primitiveResult != 0 || argResultSet.getObject(4) != null) {
/* 151 */         this._parent._countSheetNumber = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 156 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 157 */       if (t5 != null) {
/* 158 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 161 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 164 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 166 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 167 */       if (t7 != null) {
/* 168 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 171 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 174 */       this._parent._updateUserId = argResultSet.getString(8);
/* 175 */       this._parent._inventoryBucketId = argResultSet.getString(9);
/*     */ 
/*     */       
/* 178 */       int i = argResultSet.getInt(10);
/* 179 */       if (i != 0 || argResultSet.getObject(10) != null) {
/* 180 */         this._parent._sectionNumber = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 184 */       this._parent._sectionId = argResultSet.getString(11);
/*     */ 
/*     */       
/* 187 */       i = argResultSet.getInt(12);
/* 188 */       if (i != 0 || argResultSet.getObject(12) != null) {
/* 189 */         this._parent._countCycle = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 193 */       this._parent._sheetStatus = argResultSet.getString(13);
/* 194 */       this._parent._checkedOut = Boolean.valueOf(argResultSet.getBoolean(14));
/* 195 */       this._parent._inventoryBucketName = argResultSet.getString(15);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 200 */     argDAO.suppressStateChanges(true);
/* 201 */     InventoryCountSheetDAO dao = (InventoryCountSheetDAO)argDAO;
/* 202 */     dao.setOrganizationId(this._organizationId);
/* 203 */     dao.setRetailLocationId(this._retailLocationId);
/* 204 */     dao.setInventoryCountId(this._inventoryCountId);
/* 205 */     dao.setCountSheetNumber(this._countSheetNumber);
/* 206 */     dao.setCreateDate(this._createDate);
/* 207 */     dao.setCreateUserId(this._createUserId);
/* 208 */     dao.setUpdateDate(this._updateDate);
/* 209 */     dao.setUpdateUserId(this._updateUserId);
/* 210 */     dao.setInventoryBucketId(this._inventoryBucketId);
/* 211 */     dao.setSectionNumber(this._sectionNumber);
/* 212 */     dao.setSectionId(this._sectionId);
/* 213 */     dao.setCountCycle(this._countCycle);
/* 214 */     dao.setSheetStatus(this._sheetStatus);
/* 215 */     dao.setCheckedOut(this._checkedOut);
/* 216 */     dao.setInventoryBucketName(this._inventoryBucketName);
/* 217 */     argDAO.suppressStateChanges(false);
/* 218 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 222 */     return loadDAO((IDataAccessObject)new InventoryCountSheetDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 226 */     InventoryCountSheetDAO dao = (InventoryCountSheetDAO)argDAO;
/* 227 */     this._organizationId = dao.getOrganizationId();
/* 228 */     this._retailLocationId = dao.getRetailLocationId();
/* 229 */     this._inventoryCountId = dao.getInventoryCountId();
/* 230 */     this._countSheetNumber = dao.getCountSheetNumber();
/* 231 */     this._createDate = dao.getCreateDate();
/* 232 */     this._createUserId = dao.getCreateUserId();
/* 233 */     this._updateDate = dao.getUpdateDate();
/* 234 */     this._updateUserId = dao.getUpdateUserId();
/* 235 */     this._inventoryBucketId = dao.getInventoryBucketId();
/* 236 */     this._sectionNumber = dao.getSectionNumber();
/* 237 */     this._sectionId = dao.getSectionId();
/* 238 */     this._countCycle = dao.getCountCycle();
/* 239 */     this._sheetStatus = dao.getSheetStatus();
/* 240 */     this._checkedOut = (dao.getCheckedOut() != null) ? dao.getCheckedOut() : Boolean.valueOf(false);
/* 241 */     this._inventoryBucketName = dao.getInventoryBucketName();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 245 */     InventoryCountSheetId id = (InventoryCountSheetId)argId;
/* 246 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 247 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 248 */     argStatement.setString(3, id.getInventoryCountId());
/* 249 */     argStatement.setInt(4, id.getCountSheetNumber().intValue());
/* 250 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 254 */     InventoryCountSheetId id = new InventoryCountSheetId();
/* 255 */     id.setOrganizationId(this._organizationId);
/* 256 */     id.setRetailLocationId(this._retailLocationId);
/* 257 */     id.setInventoryCountId(this._inventoryCountId);
/* 258 */     id.setCountSheetNumber(this._countSheetNumber);
/* 259 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 267 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 271 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSheetDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */