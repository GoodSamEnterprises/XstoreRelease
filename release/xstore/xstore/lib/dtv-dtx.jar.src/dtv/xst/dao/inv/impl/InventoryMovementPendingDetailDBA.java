/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryMovementPendingDetailId;
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
/*     */ public class InventoryMovementPendingDetailDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 827340925L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Long _lineItemSequence;
/*     */   private Long _pendingSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _serialNumber;
/*     */   private String _itemId;
/*     */   private BigDecimal _quantity;
/*     */   private String _sourceLocationId;
/*     */   private String _sourceBucketId;
/*     */   private String _destinationLocationId;
/*     */   private String _destinationBucketId;
/*     */   private String _actionCode;
/*     */   private Boolean _void;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.trans_lineitm_seq, t.pending_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.serial_nbr, t.item_id, t.quantity, t.source_location_id, t.source_bucket_id, t.dest_location_id, t.dest_bucket_id, t.action_code, t.void_flag FROM inv_movement_pending_detail t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  AND pending_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  49 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  53 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.trans_lineitm_seq, t.pending_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.serial_nbr, t.item_id, t.quantity, t.source_location_id, t.source_bucket_id, t.dest_location_id, t.dest_bucket_id, t.action_code, t.void_flag FROM inv_movement_pending_detail t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  59 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  AND pending_seq = ?  ";
/*     */   }
/*     */   
/*  62 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_movement_pending_detail(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, trans_lineitm_seq, pending_seq, create_date, create_user_id, update_date, update_user_id, serial_nbr, item_id, quantity, source_location_id, source_bucket_id, dest_location_id, dest_bucket_id, action_code, void_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  65 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  69 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._lineItemSequence, this._pendingSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._serialNumber, this._itemId, this._quantity, this._sourceLocationId, this._sourceBucketId, this._destinationLocationId, this._destinationBucketId, this._actionCode, this._void } };
/*  70 */     return insertParameterObject;
/*     */   }
/*     */   
/*  73 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, -5, -5, 91, 12, 91, 12, 12, 12, 3, 12, 12, 12, 12, 12, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  76 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  79 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_movement_pending_detail SET update_date = ?, update_user_id = ?, serial_nbr = ?, item_id = ?, quantity = ?, source_location_id = ?, source_bucket_id = ?, dest_location_id = ?, dest_bucket_id = ?, action_code = ?, void_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  82 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  86 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._serialNumber, this._itemId, this._quantity, this._sourceLocationId, this._sourceBucketId, this._destinationLocationId, this._destinationBucketId, this._actionCode, this._void } };
/*  87 */     return updateParameterObject;
/*     */   }
/*     */   
/*  90 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 3, 12, 12, 12, 12, 12, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  92 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  95 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_movement_pending_detail" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  AND pending_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  98 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 104 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  AND pending_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 107 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._lineItemSequence, this._pendingSequence };
/*     */   }
/*     */   
/* 110 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 113 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 116 */     return "inv_movement_pending_detail";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 120 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 124 */     return new InventoryMovementPendingDetailFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryMovementPendingDetailFiller
/*     */     implements IFiller {
/*     */     private InventoryMovementPendingDetailDBA _parent;
/*     */     
/*     */     public InventoryMovementPendingDetailFiller(InventoryMovementPendingDetailDBA argParent) {
/* 132 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 137 */       long primitiveResult = argResultSet.getLong(1);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 139 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 145 */       primitiveResult = argResultSet.getLong(2);
/* 146 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 147 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 152 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 153 */       if (t3 != null) {
/* 154 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 162 */       long l1 = argResultSet.getLong(4);
/* 163 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 164 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 170 */       l1 = argResultSet.getLong(5);
/* 171 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 172 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 178 */       l1 = argResultSet.getLong(6);
/* 179 */       if (l1 != 0L || argResultSet.getObject(6) != null) {
/* 180 */         this._parent._lineItemSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 186 */       l1 = argResultSet.getLong(7);
/* 187 */       if (l1 != 0L || argResultSet.getObject(7) != null) {
/* 188 */         this._parent._pendingSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 193 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 194 */       if (t8 != null) {
/* 195 */         this._parent._createDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 198 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 201 */       this._parent._createUserId = argResultSet.getString(9);
/*     */       
/* 203 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 204 */       if (t10 != null) {
/* 205 */         this._parent._updateDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 208 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 211 */       this._parent._updateUserId = argResultSet.getString(11);
/* 212 */       this._parent._serialNumber = argResultSet.getString(12);
/* 213 */       this._parent._itemId = argResultSet.getString(13);
/* 214 */       this._parent._quantity = argResultSet.getBigDecimal(14);
/* 215 */       this._parent._sourceLocationId = argResultSet.getString(15);
/* 216 */       this._parent._sourceBucketId = argResultSet.getString(16);
/* 217 */       this._parent._destinationLocationId = argResultSet.getString(17);
/* 218 */       this._parent._destinationBucketId = argResultSet.getString(18);
/* 219 */       this._parent._actionCode = argResultSet.getString(19);
/* 220 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(20));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 225 */     argDAO.suppressStateChanges(true);
/* 226 */     InventoryMovementPendingDetailDAO dao = (InventoryMovementPendingDetailDAO)argDAO;
/* 227 */     dao.setOrganizationId(this._organizationId);
/* 228 */     dao.setRetailLocationId(this._retailLocationId);
/* 229 */     dao.setBusinessDate(this._businessDate);
/* 230 */     dao.setWorkstationId(this._workstationId);
/* 231 */     dao.setTransactionSequence(this._transactionSequence);
/* 232 */     dao.setLineItemSequence(this._lineItemSequence);
/* 233 */     dao.setPendingSequence(this._pendingSequence);
/* 234 */     dao.setCreateDate(this._createDate);
/* 235 */     dao.setCreateUserId(this._createUserId);
/* 236 */     dao.setUpdateDate(this._updateDate);
/* 237 */     dao.setUpdateUserId(this._updateUserId);
/* 238 */     dao.setSerialNumber(this._serialNumber);
/* 239 */     dao.setItemId(this._itemId);
/* 240 */     dao.setQuantity(this._quantity);
/* 241 */     dao.setSourceLocationId(this._sourceLocationId);
/* 242 */     dao.setSourceBucketId(this._sourceBucketId);
/* 243 */     dao.setDestinationLocationId(this._destinationLocationId);
/* 244 */     dao.setDestinationBucketId(this._destinationBucketId);
/* 245 */     dao.setActionCode(this._actionCode);
/* 246 */     dao.setVoid(this._void);
/* 247 */     argDAO.suppressStateChanges(false);
/* 248 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 252 */     return loadDAO((IDataAccessObject)new InventoryMovementPendingDetailDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 256 */     InventoryMovementPendingDetailDAO dao = (InventoryMovementPendingDetailDAO)argDAO;
/* 257 */     this._organizationId = dao.getOrganizationId();
/* 258 */     this._retailLocationId = dao.getRetailLocationId();
/* 259 */     this._businessDate = dao.getBusinessDate();
/* 260 */     this._workstationId = dao.getWorkstationId();
/* 261 */     this._transactionSequence = dao.getTransactionSequence();
/* 262 */     this._lineItemSequence = dao.getLineItemSequence();
/* 263 */     this._pendingSequence = dao.getPendingSequence();
/* 264 */     this._createDate = dao.getCreateDate();
/* 265 */     this._createUserId = dao.getCreateUserId();
/* 266 */     this._updateDate = dao.getUpdateDate();
/* 267 */     this._updateUserId = dao.getUpdateUserId();
/* 268 */     this._serialNumber = dao.getSerialNumber();
/* 269 */     this._itemId = dao.getItemId();
/* 270 */     this._quantity = dao.getQuantity();
/* 271 */     this._sourceLocationId = dao.getSourceLocationId();
/* 272 */     this._sourceBucketId = dao.getSourceBucketId();
/* 273 */     this._destinationLocationId = dao.getDestinationLocationId();
/* 274 */     this._destinationBucketId = dao.getDestinationBucketId();
/* 275 */     this._actionCode = dao.getActionCode();
/* 276 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 280 */     InventoryMovementPendingDetailId id = (InventoryMovementPendingDetailId)argId;
/* 281 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 282 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 283 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 284 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 285 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 286 */     argStatement.setLong(6, id.getLineItemSequence().longValue());
/* 287 */     argStatement.setLong(7, id.getPendingSequence().longValue());
/* 288 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 292 */     InventoryMovementPendingDetailId id = new InventoryMovementPendingDetailId();
/* 293 */     id.setOrganizationId(this._organizationId);
/* 294 */     id.setRetailLocationId(this._retailLocationId);
/* 295 */     id.setBusinessDate(this._businessDate);
/* 296 */     id.setWorkstationId(this._workstationId);
/* 297 */     id.setTransactionSequence(this._transactionSequence);
/* 298 */     id.setLineItemSequence(this._lineItemSequence);
/* 299 */     id.setPendingSequence(this._pendingSequence);
/* 300 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 308 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 312 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryMovementPendingDetailDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */