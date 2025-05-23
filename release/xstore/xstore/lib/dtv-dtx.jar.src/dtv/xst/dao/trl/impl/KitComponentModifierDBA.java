/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.KitComponentModifierId;
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
/*     */ public class KitComponentModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -995503394L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private String _componentItemId;
/*     */   private Long _sequenceNumber;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _componentItemDesc;
/*     */   private String _kitItemId;
/*     */   private Integer _displayOrder;
/*     */   private Integer _quantity;
/*     */   private String _serialNumber;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.component_item_id, t.seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.component_item_desc, t.kit_item_id, t.display_order, t.quantity, t.serial_nbr FROM trl_kit_component_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND component_item_id = ?  AND seq_nbr = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.component_item_id, t.seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.component_item_desc, t.kit_item_id, t.display_order, t.quantity, t.serial_nbr FROM trl_kit_component_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND component_item_id = ?  AND seq_nbr = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_kit_component_mod(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, component_item_id, seq_nbr, create_date, create_user_id, update_date, update_user_id, component_item_desc, kit_item_id, display_order, quantity, serial_nbr) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._componentItemId, this._sequenceNumber, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._componentItemDesc, this._kitItemId, this._displayOrder, this._quantity, this._serialNumber } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 12, -5, 91, 12, 91, 12, 12, 12, 4, 4, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_kit_component_mod SET update_date = ?, update_user_id = ?, component_item_desc = ?, kit_item_id = ?, display_order = ?, quantity = ?, serial_nbr = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._componentItemDesc, this._kitItemId, this._displayOrder, this._quantity, this._serialNumber } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 4, 4, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_kit_component_mod" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND component_item_id = ?  AND seq_nbr = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND component_item_id = ?  AND seq_nbr = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._componentItemId, this._sequenceNumber };
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "trl_kit_component_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new KitComponentModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class KitComponentModifierFiller
/*     */     implements IFiller {
/*     */     private KitComponentModifierDBA _parent;
/*     */     
/*     */     public KitComponentModifierFiller(KitComponentModifierDBA argParent) {
/* 129 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 134 */       long primitiveResult = argResultSet.getLong(1);
/* 135 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 136 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       primitiveResult = argResultSet.getLong(2);
/* 143 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 144 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 149 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 150 */       if (t3 != null) {
/* 151 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 159 */       long l2 = argResultSet.getLong(4);
/* 160 */       if (l2 != 0L || argResultSet.getObject(4) != null) {
/* 161 */         this._parent._workstationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 167 */       l2 = argResultSet.getLong(5);
/* 168 */       if (l2 != 0L || argResultSet.getObject(5) != null) {
/* 169 */         this._parent._transactionSequence = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 175 */       int i = argResultSet.getInt(6);
/* 176 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 177 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 181 */       this._parent._componentItemId = argResultSet.getString(7);
/*     */ 
/*     */       
/* 184 */       long l1 = argResultSet.getLong(8);
/* 185 */       if (l1 != 0L || argResultSet.getObject(8) != null) {
/* 186 */         this._parent._sequenceNumber = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 191 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 192 */       if (t9 != null) {
/* 193 */         this._parent._createDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 196 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 199 */       this._parent._createUserId = argResultSet.getString(10);
/*     */       
/* 201 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 202 */       if (t11 != null) {
/* 203 */         this._parent._updateDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 206 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 209 */       this._parent._updateUserId = argResultSet.getString(12);
/* 210 */       this._parent._componentItemDesc = argResultSet.getString(13);
/* 211 */       this._parent._kitItemId = argResultSet.getString(14);
/*     */ 
/*     */       
/* 214 */       int j = argResultSet.getInt(15);
/* 215 */       if (j != 0 || argResultSet.getObject(15) != null) {
/* 216 */         this._parent._displayOrder = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 222 */       j = argResultSet.getInt(16);
/* 223 */       if (j != 0 || argResultSet.getObject(16) != null) {
/* 224 */         this._parent._quantity = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */       
/* 228 */       this._parent._serialNumber = argResultSet.getString(17);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 233 */     argDAO.suppressStateChanges(true);
/* 234 */     KitComponentModifierDAO dao = (KitComponentModifierDAO)argDAO;
/* 235 */     dao.setOrganizationId(this._organizationId);
/* 236 */     dao.setRetailLocationId(this._retailLocationId);
/* 237 */     dao.setBusinessDate(this._businessDate);
/* 238 */     dao.setWorkstationId(this._workstationId);
/* 239 */     dao.setTransactionSequence(this._transactionSequence);
/* 240 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 241 */     dao.setComponentItemId(this._componentItemId);
/* 242 */     dao.setSequenceNumber(this._sequenceNumber);
/* 243 */     dao.setCreateDate(this._createDate);
/* 244 */     dao.setCreateUserId(this._createUserId);
/* 245 */     dao.setUpdateDate(this._updateDate);
/* 246 */     dao.setUpdateUserId(this._updateUserId);
/* 247 */     dao.setComponentItemDesc(this._componentItemDesc);
/* 248 */     dao.setKitItemId(this._kitItemId);
/* 249 */     dao.setDisplayOrder(this._displayOrder);
/* 250 */     dao.setQuantity(this._quantity);
/* 251 */     dao.setSerialNumber(this._serialNumber);
/* 252 */     argDAO.suppressStateChanges(false);
/* 253 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 257 */     return loadDAO((IDataAccessObject)new KitComponentModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 261 */     KitComponentModifierDAO dao = (KitComponentModifierDAO)argDAO;
/* 262 */     this._organizationId = dao.getOrganizationId();
/* 263 */     this._retailLocationId = dao.getRetailLocationId();
/* 264 */     this._businessDate = dao.getBusinessDate();
/* 265 */     this._workstationId = dao.getWorkstationId();
/* 266 */     this._transactionSequence = dao.getTransactionSequence();
/* 267 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 268 */     this._componentItemId = dao.getComponentItemId();
/* 269 */     this._sequenceNumber = dao.getSequenceNumber();
/* 270 */     this._createDate = dao.getCreateDate();
/* 271 */     this._createUserId = dao.getCreateUserId();
/* 272 */     this._updateDate = dao.getUpdateDate();
/* 273 */     this._updateUserId = dao.getUpdateUserId();
/* 274 */     this._componentItemDesc = dao.getComponentItemDesc();
/* 275 */     this._kitItemId = dao.getKitItemId();
/* 276 */     this._displayOrder = dao.getDisplayOrder();
/* 277 */     this._quantity = dao.getQuantity();
/* 278 */     this._serialNumber = dao.getSerialNumber();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 282 */     KitComponentModifierId id = (KitComponentModifierId)argId;
/* 283 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 284 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 285 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 286 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 287 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 288 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 289 */     argStatement.setString(7, id.getComponentItemId());
/* 290 */     argStatement.setLong(8, id.getSequenceNumber().longValue());
/* 291 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 295 */     KitComponentModifierId id = new KitComponentModifierId();
/* 296 */     id.setOrganizationId(this._organizationId);
/* 297 */     id.setRetailLocationId(this._retailLocationId);
/* 298 */     id.setBusinessDate(this._businessDate);
/* 299 */     id.setWorkstationId(this._workstationId);
/* 300 */     id.setTransactionSequence(this._transactionSequence);
/* 301 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 302 */     id.setComponentItemId(this._componentItemId);
/* 303 */     id.setSequenceNumber(this._sequenceNumber);
/* 304 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 312 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 316 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\KitComponentModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */