/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryMovementPendingId;
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
/*     */ public class InventoryMovementPendingDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -313774836L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _lineItemSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _itemId;
/*     */   private String _serialNumber;
/*     */   private String _actionCode;
/*     */   private BigDecimal _quantity;
/*     */   private Boolean _reconciled;
/*     */   private Boolean _void;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.trans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.item_id, t.serial_nbr, t.action_code, t.quantity, t.reconciled_flag, t.void_flag FROM inv_movement_pending t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.trans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.item_id, t.serial_nbr, t.action_code, t.quantity, t.reconciled_flag, t.void_flag FROM inv_movement_pending t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_movement_pending(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, trans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, item_id, serial_nbr, action_code, quantity, reconciled_flag, void_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._lineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._itemId, this._serialNumber, this._actionCode, this._quantity, this._reconciled, this._void } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 12, 12, 3, -7, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_movement_pending SET update_date = ?, update_user_id = ?, item_id = ?, serial_nbr = ?, action_code = ?, quantity = ?, reconciled_flag = ?, void_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._itemId, this._serialNumber, this._actionCode, this._quantity, this._reconciled, this._void } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 3, -7, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_movement_pending" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._lineItemSequence };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "inv_movement_pending";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new InventoryMovementPendingFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryMovementPendingFiller
/*     */     implements IFiller {
/*     */     private InventoryMovementPendingDBA _parent;
/*     */     
/*     */     public InventoryMovementPendingFiller(InventoryMovementPendingDBA argParent) {
/* 128 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 133 */       long primitiveResult = argResultSet.getLong(1);
/* 134 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 135 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 141 */       primitiveResult = argResultSet.getLong(2);
/* 142 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 143 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 148 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 149 */       if (t3 != null) {
/* 150 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 153 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 158 */       long l1 = argResultSet.getLong(4);
/* 159 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 160 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 166 */       l1 = argResultSet.getLong(5);
/* 167 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 168 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 174 */       int i = argResultSet.getInt(6);
/* 175 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 176 */         this._parent._lineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 181 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 182 */       if (t7 != null) {
/* 183 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 186 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 189 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 191 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 192 */       if (t9 != null) {
/* 193 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 196 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 199 */       this._parent._updateUserId = argResultSet.getString(10);
/* 200 */       this._parent._itemId = argResultSet.getString(11);
/* 201 */       this._parent._serialNumber = argResultSet.getString(12);
/* 202 */       this._parent._actionCode = argResultSet.getString(13);
/* 203 */       this._parent._quantity = argResultSet.getBigDecimal(14);
/* 204 */       this._parent._reconciled = Boolean.valueOf(argResultSet.getBoolean(15));
/* 205 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(16));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 210 */     argDAO.suppressStateChanges(true);
/* 211 */     InventoryMovementPendingDAO dao = (InventoryMovementPendingDAO)argDAO;
/* 212 */     dao.setOrganizationId(this._organizationId);
/* 213 */     dao.setRetailLocationId(this._retailLocationId);
/* 214 */     dao.setBusinessDate(this._businessDate);
/* 215 */     dao.setWorkstationId(this._workstationId);
/* 216 */     dao.setTransactionSequence(this._transactionSequence);
/* 217 */     dao.setLineItemSequence(this._lineItemSequence);
/* 218 */     dao.setCreateDate(this._createDate);
/* 219 */     dao.setCreateUserId(this._createUserId);
/* 220 */     dao.setUpdateDate(this._updateDate);
/* 221 */     dao.setUpdateUserId(this._updateUserId);
/* 222 */     dao.setItemId(this._itemId);
/* 223 */     dao.setSerialNumber(this._serialNumber);
/* 224 */     dao.setActionCode(this._actionCode);
/* 225 */     dao.setQuantity(this._quantity);
/* 226 */     dao.setReconciled(this._reconciled);
/* 227 */     dao.setVoid(this._void);
/* 228 */     argDAO.suppressStateChanges(false);
/* 229 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 233 */     return loadDAO((IDataAccessObject)new InventoryMovementPendingDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 237 */     InventoryMovementPendingDAO dao = (InventoryMovementPendingDAO)argDAO;
/* 238 */     this._organizationId = dao.getOrganizationId();
/* 239 */     this._retailLocationId = dao.getRetailLocationId();
/* 240 */     this._businessDate = dao.getBusinessDate();
/* 241 */     this._workstationId = dao.getWorkstationId();
/* 242 */     this._transactionSequence = dao.getTransactionSequence();
/* 243 */     this._lineItemSequence = dao.getLineItemSequence();
/* 244 */     this._createDate = dao.getCreateDate();
/* 245 */     this._createUserId = dao.getCreateUserId();
/* 246 */     this._updateDate = dao.getUpdateDate();
/* 247 */     this._updateUserId = dao.getUpdateUserId();
/* 248 */     this._itemId = dao.getItemId();
/* 249 */     this._serialNumber = dao.getSerialNumber();
/* 250 */     this._actionCode = dao.getActionCode();
/* 251 */     this._quantity = dao.getQuantity();
/* 252 */     this._reconciled = (dao.getReconciled() != null) ? dao.getReconciled() : Boolean.valueOf(false);
/* 253 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 257 */     InventoryMovementPendingId id = (InventoryMovementPendingId)argId;
/* 258 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 259 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 260 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 261 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 262 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 263 */     argStatement.setInt(6, id.getLineItemSequence().intValue());
/* 264 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 268 */     InventoryMovementPendingId id = new InventoryMovementPendingId();
/* 269 */     id.setOrganizationId(this._organizationId);
/* 270 */     id.setRetailLocationId(this._retailLocationId);
/* 271 */     id.setBusinessDate(this._businessDate);
/* 272 */     id.setWorkstationId(this._workstationId);
/* 273 */     id.setTransactionSequence(this._transactionSequence);
/* 274 */     id.setLineItemSequence(this._lineItemSequence);
/* 275 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 283 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 287 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryMovementPendingDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */