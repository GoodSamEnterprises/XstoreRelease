/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.MovementPendingTransactionLineItemId;
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
/*     */ public class MovementPendingTransactionLineItemDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -186541251L;
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
/*     */   private Long _originalRetailLocationId;
/*     */   private Long _originalWorkstationId;
/*     */   private Date _originalBusinessDate;
/*     */   private Long _originalTransactionSequence;
/*     */   private Integer _originalLineItemSequence;
/*     */   private BigDecimal _quantityReconciled;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.trans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.original_rtl_loc_id, t.original_wkstn_id, t.original_business_date, t.original_trans_seq, t.original_trans_lineitm_seq, t.quantity_reconciled FROM inv_mptrans_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.trans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.original_rtl_loc_id, t.original_wkstn_id, t.original_business_date, t.original_trans_seq, t.original_trans_lineitm_seq, t.quantity_reconciled FROM inv_mptrans_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_mptrans_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, trans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, original_rtl_loc_id, original_wkstn_id, original_business_date, original_trans_seq, original_trans_lineitm_seq, quantity_reconciled) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._lineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._originalRetailLocationId, this._originalWorkstationId, this._originalBusinessDate, this._originalTransactionSequence, this._originalLineItemSequence, this._quantityReconciled } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, -5, -5, 91, -5, 4, 3 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_mptrans_lineitm SET update_date = ?, update_user_id = ?, original_rtl_loc_id = ?, original_wkstn_id = ?, original_business_date = ?, original_trans_seq = ?, original_trans_lineitm_seq = ?, quantity_reconciled = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._originalRetailLocationId, this._originalWorkstationId, this._originalBusinessDate, this._originalTransactionSequence, this._originalLineItemSequence, this._quantityReconciled } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -5, -5, 91, -5, 4, 3 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_mptrans_lineitm" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND trans_lineitm_seq = ?  ";
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
/* 112 */     return "inv_mptrans_lineitm";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new MovementPendingTransactionLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class MovementPendingTransactionLineItemFiller
/*     */     implements IFiller {
/*     */     private MovementPendingTransactionLineItemDBA _parent;
/*     */     
/*     */     public MovementPendingTransactionLineItemFiller(MovementPendingTransactionLineItemDBA argParent) {
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
/*     */ 
/*     */       
/* 202 */       long l2 = argResultSet.getLong(11);
/* 203 */       if (l2 != 0L || argResultSet.getObject(11) != null) {
/* 204 */         this._parent._originalRetailLocationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 210 */       l2 = argResultSet.getLong(12);
/* 211 */       if (l2 != 0L || argResultSet.getObject(12) != null) {
/* 212 */         this._parent._originalWorkstationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 217 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 218 */       if (t13 != null) {
/* 219 */         this._parent._originalBusinessDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 222 */         this._parent._originalBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 227 */       long l3 = argResultSet.getLong(14);
/* 228 */       if (l3 != 0L || argResultSet.getObject(14) != null) {
/* 229 */         this._parent._originalTransactionSequence = Long.valueOf(l3);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 235 */       int j = argResultSet.getInt(15);
/* 236 */       if (j != 0 || argResultSet.getObject(15) != null) {
/* 237 */         this._parent._originalLineItemSequence = Integer.valueOf(j);
/*     */       }
/*     */ 
/*     */       
/* 241 */       this._parent._quantityReconciled = argResultSet.getBigDecimal(16);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 246 */     argDAO.suppressStateChanges(true);
/* 247 */     MovementPendingTransactionLineItemDAO dao = (MovementPendingTransactionLineItemDAO)argDAO;
/* 248 */     dao.setOrganizationId(this._organizationId);
/* 249 */     dao.setRetailLocationId(this._retailLocationId);
/* 250 */     dao.setBusinessDate(this._businessDate);
/* 251 */     dao.setWorkstationId(this._workstationId);
/* 252 */     dao.setTransactionSequence(this._transactionSequence);
/* 253 */     dao.setLineItemSequence(this._lineItemSequence);
/* 254 */     dao.setCreateDate(this._createDate);
/* 255 */     dao.setCreateUserId(this._createUserId);
/* 256 */     dao.setUpdateDate(this._updateDate);
/* 257 */     dao.setUpdateUserId(this._updateUserId);
/* 258 */     dao.setOriginalRetailLocationId(this._originalRetailLocationId);
/* 259 */     dao.setOriginalWorkstationId(this._originalWorkstationId);
/* 260 */     dao.setOriginalBusinessDate(this._originalBusinessDate);
/* 261 */     dao.setOriginalTransactionSequence(this._originalTransactionSequence);
/* 262 */     dao.setOriginalLineItemSequence(this._originalLineItemSequence);
/* 263 */     dao.setQuantityReconciled(this._quantityReconciled);
/* 264 */     argDAO.suppressStateChanges(false);
/* 265 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 269 */     return loadDAO((IDataAccessObject)new MovementPendingTransactionLineItemDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 273 */     MovementPendingTransactionLineItemDAO dao = (MovementPendingTransactionLineItemDAO)argDAO;
/* 274 */     this._organizationId = dao.getOrganizationId();
/* 275 */     this._retailLocationId = dao.getRetailLocationId();
/* 276 */     this._businessDate = dao.getBusinessDate();
/* 277 */     this._workstationId = dao.getWorkstationId();
/* 278 */     this._transactionSequence = dao.getTransactionSequence();
/* 279 */     this._lineItemSequence = dao.getLineItemSequence();
/* 280 */     this._createDate = dao.getCreateDate();
/* 281 */     this._createUserId = dao.getCreateUserId();
/* 282 */     this._updateDate = dao.getUpdateDate();
/* 283 */     this._updateUserId = dao.getUpdateUserId();
/* 284 */     this._originalRetailLocationId = dao.getOriginalRetailLocationId();
/* 285 */     this._originalWorkstationId = dao.getOriginalWorkstationId();
/* 286 */     this._originalBusinessDate = dao.getOriginalBusinessDate();
/* 287 */     this._originalTransactionSequence = dao.getOriginalTransactionSequence();
/* 288 */     this._originalLineItemSequence = dao.getOriginalLineItemSequence();
/* 289 */     this._quantityReconciled = dao.getQuantityReconciled();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 293 */     MovementPendingTransactionLineItemId id = (MovementPendingTransactionLineItemId)argId;
/* 294 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 295 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 296 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 297 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 298 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 299 */     argStatement.setInt(6, id.getLineItemSequence().intValue());
/* 300 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 304 */     MovementPendingTransactionLineItemId id = new MovementPendingTransactionLineItemId();
/* 305 */     id.setOrganizationId(this._organizationId);
/* 306 */     id.setRetailLocationId(this._retailLocationId);
/* 307 */     id.setBusinessDate(this._businessDate);
/* 308 */     id.setWorkstationId(this._workstationId);
/* 309 */     id.setTransactionSequence(this._transactionSequence);
/* 310 */     id.setLineItemSequence(this._lineItemSequence);
/* 311 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 319 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 323 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\MovementPendingTransactionLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */