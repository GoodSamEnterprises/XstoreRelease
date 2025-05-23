/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailInventoryLocationModifierId;
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
/*     */ public class RetailInventoryLocationModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1641555781L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private Date _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private Long _transactionLineItemSequence;
/*     */   private Long _modifierSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _serialNumber;
/*     */   private String _sourceLocationId;
/*     */   private String _sourceBucketId;
/*     */   private String _destinationLocationId;
/*     */   private String _destinationBucketId;
/*     */   private String _itemId;
/*     */   private BigDecimal _quantity;
/*     */   private String _actionCode;
/*     */   private Boolean _void;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.rtrans_lineitm_seq, t.mod_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.serial_nbr, t.source_location_id, t.source_bucket_id, t.dest_location_id, t.dest_bucket_id, t.item_id, t.quantity, t.action_code, t.void_flag FROM trl_inventory_loc_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND mod_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  49 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  53 */     return "SELECT t.organization_id, t.rtl_loc_id, t.wkstn_id, t.business_date, t.trans_seq, t.rtrans_lineitm_seq, t.mod_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.serial_nbr, t.source_location_id, t.source_bucket_id, t.dest_location_id, t.dest_bucket_id, t.item_id, t.quantity, t.action_code, t.void_flag FROM trl_inventory_loc_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  59 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND mod_seq = ?  ";
/*     */   }
/*     */   
/*  62 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_inventory_loc_mod(organization_id, rtl_loc_id, wkstn_id, business_date, trans_seq, rtrans_lineitm_seq, mod_seq, create_date, create_user_id, update_date, update_user_id, serial_nbr, source_location_id, source_bucket_id, dest_location_id, dest_bucket_id, item_id, quantity, action_code, void_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  65 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  69 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._transactionLineItemSequence, this._modifierSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._serialNumber, this._sourceLocationId, this._sourceBucketId, this._destinationLocationId, this._destinationBucketId, this._itemId, this._quantity, this._actionCode, this._void } };
/*  70 */     return insertParameterObject;
/*     */   }
/*     */   
/*  73 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, -5, 91, -5, -5, -5, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 3, 12, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  76 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  79 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_inventory_loc_mod SET update_date = ?, update_user_id = ?, serial_nbr = ?, source_location_id = ?, source_bucket_id = ?, dest_location_id = ?, dest_bucket_id = ?, item_id = ?, quantity = ?, action_code = ?, void_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  82 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  86 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._serialNumber, this._sourceLocationId, this._sourceBucketId, this._destinationLocationId, this._destinationBucketId, this._itemId, this._quantity, this._actionCode, this._void } };
/*  87 */     return updateParameterObject;
/*     */   }
/*     */   
/*  90 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 3, 12, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  92 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  95 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_inventory_loc_mod" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND mod_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  98 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 104 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND wkstn_id = ?  AND business_date = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND mod_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 107 */     return new Object[] { this._organizationId, this._retailLocationId, this._workstationId, this._businessDate, this._transactionSequence, this._transactionLineItemSequence, this._modifierSequence };
/*     */   }
/*     */   
/* 110 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, -5, 91, -5, -5, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 113 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 116 */     return "trl_inventory_loc_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 120 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 124 */     return new RetailInventoryLocationModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class RetailInventoryLocationModifierFiller
/*     */     implements IFiller {
/*     */     private RetailInventoryLocationModifierDBA _parent;
/*     */     
/*     */     public RetailInventoryLocationModifierFiller(RetailInventoryLocationModifierDBA argParent) {
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
/*     */       
/* 153 */       primitiveResult = argResultSet.getLong(3);
/* 154 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 155 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 160 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 161 */       if (t4 != null) {
/* 162 */         this._parent._businessDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 165 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 170 */       long l1 = argResultSet.getLong(5);
/* 171 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 172 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 178 */       l1 = argResultSet.getLong(6);
/* 179 */       if (l1 != 0L || argResultSet.getObject(6) != null) {
/* 180 */         this._parent._transactionLineItemSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 186 */       l1 = argResultSet.getLong(7);
/* 187 */       if (l1 != 0L || argResultSet.getObject(7) != null) {
/* 188 */         this._parent._modifierSequence = Long.valueOf(l1);
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
/* 213 */       this._parent._sourceLocationId = argResultSet.getString(13);
/* 214 */       this._parent._sourceBucketId = argResultSet.getString(14);
/* 215 */       this._parent._destinationLocationId = argResultSet.getString(15);
/* 216 */       this._parent._destinationBucketId = argResultSet.getString(16);
/* 217 */       this._parent._itemId = argResultSet.getString(17);
/* 218 */       this._parent._quantity = argResultSet.getBigDecimal(18);
/* 219 */       this._parent._actionCode = argResultSet.getString(19);
/* 220 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(20));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 225 */     argDAO.suppressStateChanges(true);
/* 226 */     RetailInventoryLocationModifierDAO dao = (RetailInventoryLocationModifierDAO)argDAO;
/* 227 */     dao.setOrganizationId(this._organizationId);
/* 228 */     dao.setRetailLocationId(this._retailLocationId);
/* 229 */     dao.setWorkstationId(this._workstationId);
/* 230 */     dao.setBusinessDate(this._businessDate);
/* 231 */     dao.setTransactionSequence(this._transactionSequence);
/* 232 */     dao.setTransactionLineItemSequence(this._transactionLineItemSequence);
/* 233 */     dao.setModifierSequence(this._modifierSequence);
/* 234 */     dao.setCreateDate(this._createDate);
/* 235 */     dao.setCreateUserId(this._createUserId);
/* 236 */     dao.setUpdateDate(this._updateDate);
/* 237 */     dao.setUpdateUserId(this._updateUserId);
/* 238 */     dao.setSerialNumber(this._serialNumber);
/* 239 */     dao.setSourceLocationId(this._sourceLocationId);
/* 240 */     dao.setSourceBucketId(this._sourceBucketId);
/* 241 */     dao.setDestinationLocationId(this._destinationLocationId);
/* 242 */     dao.setDestinationBucketId(this._destinationBucketId);
/* 243 */     dao.setItemId(this._itemId);
/* 244 */     dao.setQuantity(this._quantity);
/* 245 */     dao.setActionCode(this._actionCode);
/* 246 */     dao.setVoid(this._void);
/* 247 */     argDAO.suppressStateChanges(false);
/* 248 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 252 */     return loadDAO((IDataAccessObject)new RetailInventoryLocationModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 256 */     RetailInventoryLocationModifierDAO dao = (RetailInventoryLocationModifierDAO)argDAO;
/* 257 */     this._organizationId = dao.getOrganizationId();
/* 258 */     this._retailLocationId = dao.getRetailLocationId();
/* 259 */     this._workstationId = dao.getWorkstationId();
/* 260 */     this._businessDate = dao.getBusinessDate();
/* 261 */     this._transactionSequence = dao.getTransactionSequence();
/* 262 */     this._transactionLineItemSequence = dao.getTransactionLineItemSequence();
/* 263 */     this._modifierSequence = dao.getModifierSequence();
/* 264 */     this._createDate = dao.getCreateDate();
/* 265 */     this._createUserId = dao.getCreateUserId();
/* 266 */     this._updateDate = dao.getUpdateDate();
/* 267 */     this._updateUserId = dao.getUpdateUserId();
/* 268 */     this._serialNumber = dao.getSerialNumber();
/* 269 */     this._sourceLocationId = dao.getSourceLocationId();
/* 270 */     this._sourceBucketId = dao.getSourceBucketId();
/* 271 */     this._destinationLocationId = dao.getDestinationLocationId();
/* 272 */     this._destinationBucketId = dao.getDestinationBucketId();
/* 273 */     this._itemId = dao.getItemId();
/* 274 */     this._quantity = dao.getQuantity();
/* 275 */     this._actionCode = dao.getActionCode();
/* 276 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 280 */     RetailInventoryLocationModifierId id = (RetailInventoryLocationModifierId)argId;
/* 281 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 282 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 283 */     argStatement.setLong(3, id.getWorkstationId().longValue());
/* 284 */     argStatement.setTimestamp(4, new Timestamp(id.getBusinessDate().getTime()));
/* 285 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 286 */     argStatement.setLong(6, id.getTransactionLineItemSequence().longValue());
/* 287 */     argStatement.setLong(7, id.getModifierSequence().longValue());
/* 288 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 292 */     RetailInventoryLocationModifierId id = new RetailInventoryLocationModifierId();
/* 293 */     id.setOrganizationId(this._organizationId);
/* 294 */     id.setRetailLocationId(this._retailLocationId);
/* 295 */     id.setWorkstationId(this._workstationId);
/* 296 */     id.setBusinessDate(this._businessDate);
/* 297 */     id.setTransactionSequence(this._transactionSequence);
/* 298 */     id.setTransactionLineItemSequence(this._transactionLineItemSequence);
/* 299 */     id.setModifierSequence(this._modifierSequence);
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailInventoryLocationModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */