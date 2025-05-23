/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCountSheetLineItemId;
/*     */ import java.math.BigDecimal;
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
/*     */ public class InventoryCountSheetLineItemDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1408801485L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private Integer _countSheetNumber;
/*     */   private Integer _lineItemNumber;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _inventoryBucketId;
/*     */   private Integer _countCycle;
/*     */   private Integer _pageNumber;
/*     */   private String _itemId;
/*     */   private String _alternateId;
/*     */   private String _description;
/*     */   private BigDecimal _quantity;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.inv_count_id, t.count_sheet_nbr, t.lineitm_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.inv_bucket_id, t.count_cycle, t.page_nbr, t.item_id, t.alternate_id, t.description, t.quantity FROM inv_count_sheet_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND count_sheet_nbr = ?  AND lineitm_nbr = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.organization_id, t.rtl_loc_id, t.inv_count_id, t.count_sheet_nbr, t.lineitm_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.inv_bucket_id, t.count_cycle, t.page_nbr, t.item_id, t.alternate_id, t.description, t.quantity FROM inv_count_sheet_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND count_sheet_nbr = ?  AND lineitm_nbr = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_count_sheet_lineitm(organization_id, rtl_loc_id, inv_count_id, count_sheet_nbr, lineitm_nbr, create_date, create_user_id, update_date, update_user_id, inv_bucket_id, count_cycle, page_nbr, item_id, alternate_id, description, quantity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._inventoryCountId, this._countSheetNumber, this._lineItemNumber, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._inventoryBucketId, this._countCycle, this._pageNumber, this._itemId, this._alternateId, this._description, this._quantity } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 4, 4, 91, 12, 91, 12, 12, 4, 4, 12, 12, 12, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_count_sheet_lineitm SET update_date = ?, update_user_id = ?, inv_bucket_id = ?, count_cycle = ?, page_nbr = ?, item_id = ?, alternate_id = ?, description = ?, quantity = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._inventoryBucketId, this._countCycle, this._pageNumber, this._itemId, this._alternateId, this._description, this._quantity } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 4, 4, 12, 12, 12, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_count_sheet_lineitm" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND count_sheet_nbr = ?  AND lineitm_nbr = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND count_sheet_nbr = ?  AND lineitm_nbr = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._organizationId, this._retailLocationId, this._inventoryCountId, this._countSheetNumber, this._lineItemNumber };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 4, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "inv_count_sheet_lineitm";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new InventoryCountSheetLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryCountSheetLineItemFiller
/*     */     implements IFiller {
/*     */     private InventoryCountSheetLineItemDBA _parent;
/*     */     
/*     */     public InventoryCountSheetLineItemFiller(InventoryCountSheetLineItemDBA argParent) {
/* 128 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 133 */       long l = argResultSet.getLong(1);
/* 134 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 135 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 141 */       l = argResultSet.getLong(2);
/* 142 */       if (l != 0L || argResultSet.getObject(2) != null) {
/* 143 */         this._parent._retailLocationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 147 */       this._parent._inventoryCountId = argResultSet.getString(3);
/*     */ 
/*     */       
/* 150 */       int primitiveResult = argResultSet.getInt(4);
/* 151 */       if (primitiveResult != 0 || argResultSet.getObject(4) != null) {
/* 152 */         this._parent._countSheetNumber = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 158 */       primitiveResult = argResultSet.getInt(5);
/* 159 */       if (primitiveResult != 0 || argResultSet.getObject(5) != null) {
/* 160 */         this._parent._lineItemNumber = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 165 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 166 */       if (t6 != null) {
/* 167 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 170 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 173 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 175 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 176 */       if (t8 != null) {
/* 177 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 180 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 183 */       this._parent._updateUserId = argResultSet.getString(9);
/* 184 */       this._parent._inventoryBucketId = argResultSet.getString(10);
/*     */ 
/*     */       
/* 187 */       int i = argResultSet.getInt(11);
/* 188 */       if (i != 0 || argResultSet.getObject(11) != null) {
/* 189 */         this._parent._countCycle = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 195 */       i = argResultSet.getInt(12);
/* 196 */       if (i != 0 || argResultSet.getObject(12) != null) {
/* 197 */         this._parent._pageNumber = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 201 */       this._parent._itemId = argResultSet.getString(13);
/* 202 */       this._parent._alternateId = argResultSet.getString(14);
/* 203 */       this._parent._description = argResultSet.getString(15);
/* 204 */       this._parent._quantity = argResultSet.getBigDecimal(16);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 209 */     argDAO.suppressStateChanges(true);
/* 210 */     InventoryCountSheetLineItemDAO dao = (InventoryCountSheetLineItemDAO)argDAO;
/* 211 */     dao.setOrganizationId(this._organizationId);
/* 212 */     dao.setRetailLocationId(this._retailLocationId);
/* 213 */     dao.setInventoryCountId(this._inventoryCountId);
/* 214 */     dao.setCountSheetNumber(this._countSheetNumber);
/* 215 */     dao.setLineItemNumber(this._lineItemNumber);
/* 216 */     dao.setCreateDate(this._createDate);
/* 217 */     dao.setCreateUserId(this._createUserId);
/* 218 */     dao.setUpdateDate(this._updateDate);
/* 219 */     dao.setUpdateUserId(this._updateUserId);
/* 220 */     dao.setInventoryBucketId(this._inventoryBucketId);
/* 221 */     dao.setCountCycle(this._countCycle);
/* 222 */     dao.setPageNumber(this._pageNumber);
/* 223 */     dao.setItemId(this._itemId);
/* 224 */     dao.setAlternateId(this._alternateId);
/* 225 */     dao.setDescription(this._description);
/* 226 */     dao.setQuantity(this._quantity);
/* 227 */     argDAO.suppressStateChanges(false);
/* 228 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 232 */     return loadDAO((IDataAccessObject)new InventoryCountSheetLineItemDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 236 */     InventoryCountSheetLineItemDAO dao = (InventoryCountSheetLineItemDAO)argDAO;
/* 237 */     this._organizationId = dao.getOrganizationId();
/* 238 */     this._retailLocationId = dao.getRetailLocationId();
/* 239 */     this._inventoryCountId = dao.getInventoryCountId();
/* 240 */     this._countSheetNumber = dao.getCountSheetNumber();
/* 241 */     this._lineItemNumber = dao.getLineItemNumber();
/* 242 */     this._createDate = dao.getCreateDate();
/* 243 */     this._createUserId = dao.getCreateUserId();
/* 244 */     this._updateDate = dao.getUpdateDate();
/* 245 */     this._updateUserId = dao.getUpdateUserId();
/* 246 */     this._inventoryBucketId = dao.getInventoryBucketId();
/* 247 */     this._countCycle = dao.getCountCycle();
/* 248 */     this._pageNumber = dao.getPageNumber();
/* 249 */     this._itemId = dao.getItemId();
/* 250 */     this._alternateId = dao.getAlternateId();
/* 251 */     this._description = dao.getDescription();
/* 252 */     this._quantity = dao.getQuantity();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 256 */     InventoryCountSheetLineItemId id = (InventoryCountSheetLineItemId)argId;
/* 257 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 258 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 259 */     argStatement.setString(3, id.getInventoryCountId());
/* 260 */     argStatement.setInt(4, id.getCountSheetNumber().intValue());
/* 261 */     argStatement.setInt(5, id.getLineItemNumber().intValue());
/* 262 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 266 */     InventoryCountSheetLineItemId id = new InventoryCountSheetLineItemId();
/* 267 */     id.setOrganizationId(this._organizationId);
/* 268 */     id.setRetailLocationId(this._retailLocationId);
/* 269 */     id.setInventoryCountId(this._inventoryCountId);
/* 270 */     id.setCountSheetNumber(this._countSheetNumber);
/* 271 */     id.setLineItemNumber(this._lineItemNumber);
/* 272 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 280 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 284 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSheetLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */