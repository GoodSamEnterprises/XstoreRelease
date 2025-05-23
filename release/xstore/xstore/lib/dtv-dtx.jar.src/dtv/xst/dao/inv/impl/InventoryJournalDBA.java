/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryJournalId;
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
/*     */ public class InventoryJournalDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 85946971L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private Long _transactionLineItemSequence;
/*     */   private Long _journalSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _inventoryItemId;
/*     */   private String _itemSerialNumber;
/*     */   private String _actionCode;
/*     */   private BigDecimal _quantity;
/*     */   private String _sourceLocationId;
/*     */   private String _sourceBucketId;
/*     */   private String _destinationLocationId;
/*     */   private String _destinationBucketId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.trans_lineitm_seq, t.journal_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.inventory_item_id, t.item_serial_nbr, t.action_code, t.quantity, t.source_location_id, t.source_bucket_id, t.dest_location_id, t.dest_bucket_id FROM inv_inventory_journal t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  AND journal_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  48 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  52 */     return "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.trans_lineitm_seq, t.journal_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.inventory_item_id, t.item_serial_nbr, t.action_code, t.quantity, t.source_location_id, t.source_bucket_id, t.dest_location_id, t.dest_bucket_id FROM inv_inventory_journal t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  58 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  AND journal_seq = ?  ";
/*     */   }
/*     */   
/*  61 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_inventory_journal(organization_id, rtl_loc_id, wkstn_id, business_date, trans_seq, trans_lineitm_seq, journal_seq, create_date, create_user_id, update_date, update_user_id, inventory_item_id, item_serial_nbr, action_code, quantity, source_location_id, source_bucket_id, dest_location_id, dest_bucket_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  64 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  68 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._transactionLineItemSequence, this._journalSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._inventoryItemId, this._itemSerialNumber, this._actionCode, this._quantity, this._sourceLocationId, this._sourceBucketId, this._destinationLocationId, this._destinationBucketId } };
/*  69 */     return insertParameterObject;
/*     */   }
/*     */   
/*  72 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, -5, -5, -5, 91, 12, 91, 12, 12, 12, 12, 3, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  75 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  78 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_inventory_journal SET update_date = ?, update_user_id = ?, inventory_item_id = ?, item_serial_nbr = ?, action_code = ?, quantity = ?, source_location_id = ?, source_bucket_id = ?, dest_location_id = ?, dest_bucket_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  81 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  85 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._inventoryItemId, this._itemSerialNumber, this._actionCode, this._quantity, this._sourceLocationId, this._sourceBucketId, this._destinationLocationId, this._destinationBucketId } };
/*  86 */     return updateParameterObject;
/*     */   }
/*     */   
/*  89 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 3, 12, 12, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  91 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  94 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_inventory_journal" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  AND journal_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  97 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 103 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  AND journal_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 106 */     return new Object[] { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._transactionLineItemSequence, this._journalSequence };
/*     */   }
/*     */   
/* 109 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 91, -5, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 112 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 115 */     return "inv_inventory_journal";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 119 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 123 */     return new InventoryJournalFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryJournalFiller
/*     */     implements IFiller {
/*     */     private InventoryJournalDBA _parent;
/*     */     
/*     */     public InventoryJournalFiller(InventoryJournalDBA argParent) {
/* 131 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 136 */       long primitiveResult = argResultSet.getLong(1);
/* 137 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 138 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 144 */       primitiveResult = argResultSet.getLong(2);
/* 145 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 146 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 152 */       primitiveResult = argResultSet.getLong(3);
/* 153 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 154 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 159 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 160 */       if (t4 != null) {
/* 161 */         this._parent._businessDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 169 */       long l1 = argResultSet.getLong(5);
/* 170 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 171 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 177 */       l1 = argResultSet.getLong(6);
/* 178 */       if (l1 != 0L || argResultSet.getObject(6) != null) {
/* 179 */         this._parent._transactionLineItemSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 185 */       l1 = argResultSet.getLong(7);
/* 186 */       if (l1 != 0L || argResultSet.getObject(7) != null) {
/* 187 */         this._parent._journalSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 192 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 193 */       if (t8 != null) {
/* 194 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 197 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 200 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 202 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 203 */       if (t10 != null) {
/* 204 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 207 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 210 */       this._parent._updateUserId = argResultSet.getString(11);
/* 211 */       this._parent._inventoryItemId = argResultSet.getString(12);
/* 212 */       this._parent._itemSerialNumber = argResultSet.getString(13);
/* 213 */       this._parent._actionCode = argResultSet.getString(14);
/* 214 */       this._parent._quantity = argResultSet.getBigDecimal(15);
/* 215 */       this._parent._sourceLocationId = argResultSet.getString(16);
/* 216 */       this._parent._sourceBucketId = argResultSet.getString(17);
/* 217 */       this._parent._destinationLocationId = argResultSet.getString(18);
/* 218 */       this._parent._destinationBucketId = argResultSet.getString(19);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 223 */     argDAO.suppressStateChanges(true);
/* 224 */     InventoryJournalDAO dao = (InventoryJournalDAO)argDAO;
/* 225 */     dao.setOrganizationId(this._organizationId);
/* 226 */     dao.setRetailLocationId(this._retailLocationId);
/* 227 */     dao.setWorkstationId(this._workstationId);
/* 228 */     dao.setBusinessDate(this._businessDate);
/* 229 */     dao.setTransactionSequence(this._transactionSequence);
/* 230 */     dao.setTransactionLineItemSequence(this._transactionLineItemSequence);
/* 231 */     dao.setJournalSequence(this._journalSequence);
/* 232 */     dao.setCreateDate(this._createDate);
/* 233 */     dao.setCreateUserId(this._createUserId);
/* 234 */     dao.setUpdateDate(this._updateDate);
/* 235 */     dao.setUpdateUserId(this._updateUserId);
/* 236 */     dao.setInventoryItemId(this._inventoryItemId);
/* 237 */     dao.setItemSerialNumber(this._itemSerialNumber);
/* 238 */     dao.setActionCode(this._actionCode);
/* 239 */     dao.setQuantity(this._quantity);
/* 240 */     dao.setSourceLocationId(this._sourceLocationId);
/* 241 */     dao.setSourceBucketId(this._sourceBucketId);
/* 242 */     dao.setDestinationLocationId(this._destinationLocationId);
/* 243 */     dao.setDestinationBucketId(this._destinationBucketId);
/* 244 */     argDAO.suppressStateChanges(false);
/* 245 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 249 */     return loadDAO((IDataAccessObject)new InventoryJournalDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 253 */     InventoryJournalDAO dao = (InventoryJournalDAO)argDAO;
/* 254 */     this._organizationId = dao.getOrganizationId();
/* 255 */     this._retailLocationId = dao.getRetailLocationId();
/* 256 */     this._workstationId = dao.getWorkstationId();
/* 257 */     this._businessDate = dao.getBusinessDate();
/* 258 */     this._transactionSequence = dao.getTransactionSequence();
/* 259 */     this._transactionLineItemSequence = dao.getTransactionLineItemSequence();
/* 260 */     this._journalSequence = dao.getJournalSequence();
/* 261 */     this._createDate = dao.getCreateDate();
/* 262 */     this._createUserId = dao.getCreateUserId();
/* 263 */     this._updateDate = dao.getUpdateDate();
/* 264 */     this._updateUserId = dao.getUpdateUserId();
/* 265 */     this._inventoryItemId = dao.getInventoryItemId();
/* 266 */     this._itemSerialNumber = dao.getItemSerialNumber();
/* 267 */     this._actionCode = dao.getActionCode();
/* 268 */     this._quantity = dao.getQuantity();
/* 269 */     this._sourceLocationId = dao.getSourceLocationId();
/* 270 */     this._sourceBucketId = dao.getSourceBucketId();
/* 271 */     this._destinationLocationId = dao.getDestinationLocationId();
/* 272 */     this._destinationBucketId = dao.getDestinationBucketId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 276 */     InventoryJournalId id = (InventoryJournalId)argId;
/* 277 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 278 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 279 */     argStatement.setLong(3, id.getWorkstationId().longValue());
/* 280 */     argStatement.setTimestamp(4, new Timestamp(id.getBusinessDate().getTime()));
/* 281 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 282 */     argStatement.setLong(6, id.getTransactionLineItemSequence().longValue());
/* 283 */     argStatement.setLong(7, id.getJournalSequence().longValue());
/* 284 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 288 */     InventoryJournalId id = new InventoryJournalId();
/* 289 */     id.setOrganizationId(this._organizationId);
/* 290 */     id.setRetailLocationId(this._retailLocationId);
/* 291 */     id.setWorkstationId(this._workstationId);
/* 292 */     id.setBusinessDate(this._businessDate);
/* 293 */     id.setTransactionSequence(this._transactionSequence);
/* 294 */     id.setTransactionLineItemSequence(this._transactionLineItemSequence);
/* 295 */     id.setJournalSequence(this._journalSequence);
/* 296 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 304 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 308 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryJournalDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */