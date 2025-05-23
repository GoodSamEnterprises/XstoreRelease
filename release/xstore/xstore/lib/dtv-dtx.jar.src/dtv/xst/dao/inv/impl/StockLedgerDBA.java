/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.IHasIncrementalValues;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.StockLedgerId;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StockLedgerDBA
/*     */   implements IJDBCTableAdapter, IHasIncrementalValues
/*     */ {
/*     */   private static final long serialVersionUID = 282529791L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _bucketId;
/*     */   private String _invLocationId;
/*     */   private String _itemId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _unitcount;
/*     */   private BigDecimal _initUnitcount;
/*     */   private BigDecimal _inventoryValue;
/*     */   protected boolean _incrementalActive = true;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.bucket_id, t.inv_location_id, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.unitcount, t.inventory_value FROM inv_stock_ledger_acct t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND bucket_id = ?  AND inv_location_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public void setIncrementalActive(boolean argActive) {
/*  40 */     this._incrementalActive = argActive;
/*     */   }
/*     */   
/*     */   public boolean getIncrementalActive() {
/*  44 */     return this._incrementalActive;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelect() {
/*  50 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  54 */     return "SELECT t.organization_id, t.rtl_loc_id, t.bucket_id, t.inv_location_id, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.unitcount, t.inventory_value FROM inv_stock_ledger_acct t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  60 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND bucket_id = ?  AND inv_location_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   
/*  63 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_stock_ledger_acct(organization_id, rtl_loc_id, bucket_id, inv_location_id, item_id, create_date, create_user_id, update_date, update_user_id, unitcount, inventory_value) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  66 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  70 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._bucketId, this._invLocationId, this._itemId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._unitcount, this._inventoryValue } };
/*  71 */     return insertParameterObject;
/*     */   }
/*     */   
/*  74 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 12, 12, 91, 12, 91, 12, 3, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  77 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*     */   public String[] getUpdate() {
/*  81 */     if (this._incrementalActive) {
/*  82 */       return getIncrementalUpdate();
/*     */     }
/*     */     
/*  85 */     return getStandardUpdate();
/*     */   }
/*     */ 
/*     */   
/*  89 */   private static final String[] INCREMENTAL_UPDATE_OBJECT = new String[] { "UPDATE inv_stock_ledger_acct SET update_date = ?, update_user_id = ?, unitcount = COALESCE(unitcount,0) + ?, inventory_value = ?" };
/*     */   
/*     */   public String[] getIncrementalUpdate() {
/*  92 */     return INCREMENTAL_UPDATE_OBJECT;
/*     */   }
/*     */   
/*  95 */   private static final String[] STANDARD_UPDATE_OBJECT = new String[] { "UPDATE inv_stock_ledger_acct SET update_date = ?, update_user_id = ?, unitcount = ?, inventory_value = ?" };
/*     */   
/*     */   public String[] getStandardUpdate() {
/*  98 */     return STANDARD_UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/* 102 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, getUnitcountDiff(), this._inventoryValue } };
/* 103 */     return updateParameterObject;
/*     */   }
/*     */   
/* 106 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/* 108 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/* 111 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_stock_ledger_acct" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND bucket_id = ?  AND inv_location_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 114 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 120 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND bucket_id = ?  AND inv_location_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 123 */     return new Object[] { this._organizationId, this._retailLocationId, this._bucketId, this._invLocationId, this._itemId };
/*     */   }
/*     */   
/* 126 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 129 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */ 
/*     */   
/*     */   private BigDecimal getUnitcountDiff() {
/*     */     BigDecimal val1, val2;
/* 135 */     if (this._unitcount == null) {
/* 136 */       val1 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 139 */       val1 = this._unitcount;
/*     */     } 
/*     */     
/* 142 */     if (this._initUnitcount == null) {
/* 143 */       val2 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 146 */       val2 = this._initUnitcount;
/*     */     } 
/*     */     
/* 149 */     BigDecimal res = val1.subtract(val2);
/*     */     
/* 151 */     if (res.scale() < 8) {
/* 152 */       res = res.setScale(8);
/*     */     }
/*     */     
/* 155 */     return res;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 159 */     return "inv_stock_ledger_acct";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 163 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 167 */     return new StockLedgerFiller(this);
/*     */   }
/*     */   
/*     */   private static class StockLedgerFiller
/*     */     implements IFiller {
/*     */     private StockLedgerDBA _parent;
/*     */     
/*     */     public StockLedgerFiller(StockLedgerDBA argParent) {
/* 175 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 180 */       long primitiveResult = argResultSet.getLong(1);
/* 181 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 182 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 188 */       primitiveResult = argResultSet.getLong(2);
/* 189 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 190 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 194 */       this._parent._bucketId = argResultSet.getString(3);
/* 195 */       this._parent._invLocationId = argResultSet.getString(4);
/* 196 */       this._parent._itemId = argResultSet.getString(5);
/*     */       
/* 198 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 199 */       if (t6 != null) {
/* 200 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 203 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 206 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 208 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 209 */       if (t8 != null) {
/* 210 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 213 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 216 */       this._parent._updateUserId = argResultSet.getString(9);
/* 217 */       this._parent._unitcount = argResultSet.getBigDecimal(10);
/* 218 */       this._parent._initUnitcount = argResultSet.getBigDecimal(10);
/* 219 */       this._parent._inventoryValue = argResultSet.getBigDecimal(11);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 224 */     argDAO.suppressStateChanges(true);
/* 225 */     StockLedgerDAO dao = (StockLedgerDAO)argDAO;
/* 226 */     dao.setOrganizationId(this._organizationId);
/* 227 */     dao.setRetailLocationId(this._retailLocationId);
/* 228 */     dao.setBucketId(this._bucketId);
/* 229 */     dao.setInvLocationId(this._invLocationId);
/* 230 */     dao.setItemId(this._itemId);
/* 231 */     dao.setCreateDate(this._createDate);
/* 232 */     dao.setCreateUserId(this._createUserId);
/* 233 */     dao.setUpdateDate(this._updateDate);
/* 234 */     dao.setUpdateUserId(this._updateUserId);
/* 235 */     dao.setUnitcount(this._unitcount);
/* 236 */     dao.setInitUnitcount(this._unitcount);
/* 237 */     dao.setInventoryValue(this._inventoryValue);
/* 238 */     argDAO.suppressStateChanges(false);
/* 239 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 243 */     return loadDAO((IDataAccessObject)new StockLedgerDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 247 */     StockLedgerDAO dao = (StockLedgerDAO)argDAO;
/* 248 */     this._organizationId = dao.getOrganizationId();
/* 249 */     this._retailLocationId = dao.getRetailLocationId();
/* 250 */     this._bucketId = dao.getBucketId();
/* 251 */     this._invLocationId = dao.getInvLocationId();
/* 252 */     this._itemId = dao.getItemId();
/* 253 */     this._createDate = dao.getCreateDate();
/* 254 */     this._createUserId = dao.getCreateUserId();
/* 255 */     this._updateDate = dao.getUpdateDate();
/* 256 */     this._updateUserId = dao.getUpdateUserId();
/* 257 */     this._unitcount = dao.getUnitcount();
/* 258 */     this._initUnitcount = dao.getInitUnitcount();
/* 259 */     this._inventoryValue = dao.getInventoryValue();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 263 */     StockLedgerId id = (StockLedgerId)argId;
/* 264 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 265 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 266 */     argStatement.setString(3, id.getBucketId());
/* 267 */     argStatement.setString(4, id.getInvLocationId());
/* 268 */     argStatement.setString(5, id.getItemId());
/* 269 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 273 */     StockLedgerId id = new StockLedgerId();
/* 274 */     id.setOrganizationId(this._organizationId);
/* 275 */     id.setRetailLocationId(this._retailLocationId);
/* 276 */     id.setBucketId(this._bucketId);
/* 277 */     id.setInvLocationId(this._invLocationId);
/* 278 */     id.setItemId(this._itemId);
/* 279 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 287 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 291 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\StockLedgerDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */